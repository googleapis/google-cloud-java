package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The primary resources offered by this service are EntryGroups, EntryTypes,
 * AspectTypes, Entry and Aspect which collectively allow a data administrator
 * to organize, manage, secure and catalog data across their organization
 * located across cloud projects in a variety of storage systems including Cloud
 * Storage and BigQuery.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/catalog.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CatalogServiceGrpc {

  private CatalogServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataplex.v1.CatalogService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryTypeRequest,
      com.google.longrunning.Operation> getCreateEntryTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntryType",
      requestType = com.google.cloud.dataplex.v1.CreateEntryTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryTypeRequest,
      com.google.longrunning.Operation> getCreateEntryTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryTypeRequest, com.google.longrunning.Operation> getCreateEntryTypeMethod;
    if ((getCreateEntryTypeMethod = CatalogServiceGrpc.getCreateEntryTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateEntryTypeMethod = CatalogServiceGrpc.getCreateEntryTypeMethod) == null) {
          CatalogServiceGrpc.getCreateEntryTypeMethod = getCreateEntryTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateEntryTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntryType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateEntryType"))
              .build();
        }
      }
    }
    return getCreateEntryTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryTypeRequest,
      com.google.longrunning.Operation> getUpdateEntryTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntryType",
      requestType = com.google.cloud.dataplex.v1.UpdateEntryTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryTypeRequest,
      com.google.longrunning.Operation> getUpdateEntryTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryTypeRequest, com.google.longrunning.Operation> getUpdateEntryTypeMethod;
    if ((getUpdateEntryTypeMethod = CatalogServiceGrpc.getUpdateEntryTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateEntryTypeMethod = CatalogServiceGrpc.getUpdateEntryTypeMethod) == null) {
          CatalogServiceGrpc.getUpdateEntryTypeMethod = getUpdateEntryTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateEntryTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntryType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateEntryType"))
              .build();
        }
      }
    }
    return getUpdateEntryTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryTypeRequest,
      com.google.longrunning.Operation> getDeleteEntryTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntryType",
      requestType = com.google.cloud.dataplex.v1.DeleteEntryTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryTypeRequest,
      com.google.longrunning.Operation> getDeleteEntryTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryTypeRequest, com.google.longrunning.Operation> getDeleteEntryTypeMethod;
    if ((getDeleteEntryTypeMethod = CatalogServiceGrpc.getDeleteEntryTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getDeleteEntryTypeMethod = CatalogServiceGrpc.getDeleteEntryTypeMethod) == null) {
          CatalogServiceGrpc.getDeleteEntryTypeMethod = getDeleteEntryTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteEntryTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntryType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("DeleteEntryType"))
              .build();
        }
      }
    }
    return getDeleteEntryTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryTypesRequest,
      com.google.cloud.dataplex.v1.ListEntryTypesResponse> getListEntryTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntryTypes",
      requestType = com.google.cloud.dataplex.v1.ListEntryTypesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEntryTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryTypesRequest,
      com.google.cloud.dataplex.v1.ListEntryTypesResponse> getListEntryTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryTypesRequest, com.google.cloud.dataplex.v1.ListEntryTypesResponse> getListEntryTypesMethod;
    if ((getListEntryTypesMethod = CatalogServiceGrpc.getListEntryTypesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListEntryTypesMethod = CatalogServiceGrpc.getListEntryTypesMethod) == null) {
          CatalogServiceGrpc.getListEntryTypesMethod = getListEntryTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListEntryTypesRequest, com.google.cloud.dataplex.v1.ListEntryTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntryTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntryTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntryTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListEntryTypes"))
              .build();
        }
      }
    }
    return getListEntryTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryTypeRequest,
      com.google.cloud.dataplex.v1.EntryType> getGetEntryTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntryType",
      requestType = com.google.cloud.dataplex.v1.GetEntryTypeRequest.class,
      responseType = com.google.cloud.dataplex.v1.EntryType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryTypeRequest,
      com.google.cloud.dataplex.v1.EntryType> getGetEntryTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryTypeRequest, com.google.cloud.dataplex.v1.EntryType> getGetEntryTypeMethod;
    if ((getGetEntryTypeMethod = CatalogServiceGrpc.getGetEntryTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetEntryTypeMethod = CatalogServiceGrpc.getGetEntryTypeMethod) == null) {
          CatalogServiceGrpc.getGetEntryTypeMethod = getGetEntryTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetEntryTypeRequest, com.google.cloud.dataplex.v1.EntryType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntryType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetEntryTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.EntryType.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetEntryType"))
              .build();
        }
      }
    }
    return getGetEntryTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAspectTypeRequest,
      com.google.longrunning.Operation> getCreateAspectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAspectType",
      requestType = com.google.cloud.dataplex.v1.CreateAspectTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAspectTypeRequest,
      com.google.longrunning.Operation> getCreateAspectTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAspectTypeRequest, com.google.longrunning.Operation> getCreateAspectTypeMethod;
    if ((getCreateAspectTypeMethod = CatalogServiceGrpc.getCreateAspectTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateAspectTypeMethod = CatalogServiceGrpc.getCreateAspectTypeMethod) == null) {
          CatalogServiceGrpc.getCreateAspectTypeMethod = getCreateAspectTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateAspectTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAspectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateAspectType"))
              .build();
        }
      }
    }
    return getCreateAspectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAspectTypeRequest,
      com.google.longrunning.Operation> getUpdateAspectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAspectType",
      requestType = com.google.cloud.dataplex.v1.UpdateAspectTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAspectTypeRequest,
      com.google.longrunning.Operation> getUpdateAspectTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAspectTypeRequest, com.google.longrunning.Operation> getUpdateAspectTypeMethod;
    if ((getUpdateAspectTypeMethod = CatalogServiceGrpc.getUpdateAspectTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateAspectTypeMethod = CatalogServiceGrpc.getUpdateAspectTypeMethod) == null) {
          CatalogServiceGrpc.getUpdateAspectTypeMethod = getUpdateAspectTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateAspectTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAspectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateAspectType"))
              .build();
        }
      }
    }
    return getUpdateAspectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAspectTypeRequest,
      com.google.longrunning.Operation> getDeleteAspectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAspectType",
      requestType = com.google.cloud.dataplex.v1.DeleteAspectTypeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAspectTypeRequest,
      com.google.longrunning.Operation> getDeleteAspectTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAspectTypeRequest, com.google.longrunning.Operation> getDeleteAspectTypeMethod;
    if ((getDeleteAspectTypeMethod = CatalogServiceGrpc.getDeleteAspectTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getDeleteAspectTypeMethod = CatalogServiceGrpc.getDeleteAspectTypeMethod) == null) {
          CatalogServiceGrpc.getDeleteAspectTypeMethod = getDeleteAspectTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteAspectTypeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAspectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("DeleteAspectType"))
              .build();
        }
      }
    }
    return getDeleteAspectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAspectTypesRequest,
      com.google.cloud.dataplex.v1.ListAspectTypesResponse> getListAspectTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAspectTypes",
      requestType = com.google.cloud.dataplex.v1.ListAspectTypesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListAspectTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAspectTypesRequest,
      com.google.cloud.dataplex.v1.ListAspectTypesResponse> getListAspectTypesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAspectTypesRequest, com.google.cloud.dataplex.v1.ListAspectTypesResponse> getListAspectTypesMethod;
    if ((getListAspectTypesMethod = CatalogServiceGrpc.getListAspectTypesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListAspectTypesMethod = CatalogServiceGrpc.getListAspectTypesMethod) == null) {
          CatalogServiceGrpc.getListAspectTypesMethod = getListAspectTypesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListAspectTypesRequest, com.google.cloud.dataplex.v1.ListAspectTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAspectTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListAspectTypesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListAspectTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListAspectTypes"))
              .build();
        }
      }
    }
    return getListAspectTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAspectTypeRequest,
      com.google.cloud.dataplex.v1.AspectType> getGetAspectTypeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAspectType",
      requestType = com.google.cloud.dataplex.v1.GetAspectTypeRequest.class,
      responseType = com.google.cloud.dataplex.v1.AspectType.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAspectTypeRequest,
      com.google.cloud.dataplex.v1.AspectType> getGetAspectTypeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAspectTypeRequest, com.google.cloud.dataplex.v1.AspectType> getGetAspectTypeMethod;
    if ((getGetAspectTypeMethod = CatalogServiceGrpc.getGetAspectTypeMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetAspectTypeMethod = CatalogServiceGrpc.getGetAspectTypeMethod) == null) {
          CatalogServiceGrpc.getGetAspectTypeMethod = getGetAspectTypeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetAspectTypeRequest, com.google.cloud.dataplex.v1.AspectType>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAspectType"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetAspectTypeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.AspectType.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetAspectType"))
              .build();
        }
      }
    }
    return getGetAspectTypeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryGroupRequest,
      com.google.longrunning.Operation> getCreateEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntryGroup",
      requestType = com.google.cloud.dataplex.v1.CreateEntryGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryGroupRequest,
      com.google.longrunning.Operation> getCreateEntryGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryGroupRequest, com.google.longrunning.Operation> getCreateEntryGroupMethod;
    if ((getCreateEntryGroupMethod = CatalogServiceGrpc.getCreateEntryGroupMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateEntryGroupMethod = CatalogServiceGrpc.getCreateEntryGroupMethod) == null) {
          CatalogServiceGrpc.getCreateEntryGroupMethod = getCreateEntryGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateEntryGroupRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntryGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateEntryGroup"))
              .build();
        }
      }
    }
    return getCreateEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryGroupRequest,
      com.google.longrunning.Operation> getUpdateEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntryGroup",
      requestType = com.google.cloud.dataplex.v1.UpdateEntryGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryGroupRequest,
      com.google.longrunning.Operation> getUpdateEntryGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryGroupRequest, com.google.longrunning.Operation> getUpdateEntryGroupMethod;
    if ((getUpdateEntryGroupMethod = CatalogServiceGrpc.getUpdateEntryGroupMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateEntryGroupMethod = CatalogServiceGrpc.getUpdateEntryGroupMethod) == null) {
          CatalogServiceGrpc.getUpdateEntryGroupMethod = getUpdateEntryGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateEntryGroupRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntryGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateEntryGroup"))
              .build();
        }
      }
    }
    return getUpdateEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryGroupRequest,
      com.google.longrunning.Operation> getDeleteEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntryGroup",
      requestType = com.google.cloud.dataplex.v1.DeleteEntryGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryGroupRequest,
      com.google.longrunning.Operation> getDeleteEntryGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryGroupRequest, com.google.longrunning.Operation> getDeleteEntryGroupMethod;
    if ((getDeleteEntryGroupMethod = CatalogServiceGrpc.getDeleteEntryGroupMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getDeleteEntryGroupMethod = CatalogServiceGrpc.getDeleteEntryGroupMethod) == null) {
          CatalogServiceGrpc.getDeleteEntryGroupMethod = getDeleteEntryGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteEntryGroupRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntryGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("DeleteEntryGroup"))
              .build();
        }
      }
    }
    return getDeleteEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryGroupsRequest,
      com.google.cloud.dataplex.v1.ListEntryGroupsResponse> getListEntryGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntryGroups",
      requestType = com.google.cloud.dataplex.v1.ListEntryGroupsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEntryGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryGroupsRequest,
      com.google.cloud.dataplex.v1.ListEntryGroupsResponse> getListEntryGroupsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntryGroupsRequest, com.google.cloud.dataplex.v1.ListEntryGroupsResponse> getListEntryGroupsMethod;
    if ((getListEntryGroupsMethod = CatalogServiceGrpc.getListEntryGroupsMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListEntryGroupsMethod = CatalogServiceGrpc.getListEntryGroupsMethod) == null) {
          CatalogServiceGrpc.getListEntryGroupsMethod = getListEntryGroupsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListEntryGroupsRequest, com.google.cloud.dataplex.v1.ListEntryGroupsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntryGroups"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntryGroupsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntryGroupsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListEntryGroups"))
              .build();
        }
      }
    }
    return getListEntryGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryGroupRequest,
      com.google.cloud.dataplex.v1.EntryGroup> getGetEntryGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntryGroup",
      requestType = com.google.cloud.dataplex.v1.GetEntryGroupRequest.class,
      responseType = com.google.cloud.dataplex.v1.EntryGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryGroupRequest,
      com.google.cloud.dataplex.v1.EntryGroup> getGetEntryGroupMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryGroupRequest, com.google.cloud.dataplex.v1.EntryGroup> getGetEntryGroupMethod;
    if ((getGetEntryGroupMethod = CatalogServiceGrpc.getGetEntryGroupMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetEntryGroupMethod = CatalogServiceGrpc.getGetEntryGroupMethod) == null) {
          CatalogServiceGrpc.getGetEntryGroupMethod = getGetEntryGroupMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetEntryGroupRequest, com.google.cloud.dataplex.v1.EntryGroup>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntryGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetEntryGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.EntryGroup.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetEntryGroup"))
              .build();
        }
      }
    }
    return getGetEntryGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getCreateEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntry",
      requestType = com.google.cloud.dataplex.v1.CreateEntryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getCreateEntryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEntryRequest, com.google.cloud.dataplex.v1.Entry> getCreateEntryMethod;
    if ((getCreateEntryMethod = CatalogServiceGrpc.getCreateEntryMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getCreateEntryMethod = CatalogServiceGrpc.getCreateEntryMethod) == null) {
          CatalogServiceGrpc.getCreateEntryMethod = getCreateEntryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateEntryRequest, com.google.cloud.dataplex.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEntry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("CreateEntry"))
              .build();
        }
      }
    }
    return getCreateEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getUpdateEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEntry",
      requestType = com.google.cloud.dataplex.v1.UpdateEntryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getUpdateEntryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEntryRequest, com.google.cloud.dataplex.v1.Entry> getUpdateEntryMethod;
    if ((getUpdateEntryMethod = CatalogServiceGrpc.getUpdateEntryMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getUpdateEntryMethod = CatalogServiceGrpc.getUpdateEntryMethod) == null) {
          CatalogServiceGrpc.getUpdateEntryMethod = getUpdateEntryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateEntryRequest, com.google.cloud.dataplex.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEntry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("UpdateEntry"))
              .build();
        }
      }
    }
    return getUpdateEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getDeleteEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntry",
      requestType = com.google.cloud.dataplex.v1.DeleteEntryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getDeleteEntryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEntryRequest, com.google.cloud.dataplex.v1.Entry> getDeleteEntryMethod;
    if ((getDeleteEntryMethod = CatalogServiceGrpc.getDeleteEntryMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getDeleteEntryMethod = CatalogServiceGrpc.getDeleteEntryMethod) == null) {
          CatalogServiceGrpc.getDeleteEntryMethod = getDeleteEntryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteEntryRequest, com.google.cloud.dataplex.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEntry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("DeleteEntry"))
              .build();
        }
      }
    }
    return getDeleteEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntriesRequest,
      com.google.cloud.dataplex.v1.ListEntriesResponse> getListEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntries",
      requestType = com.google.cloud.dataplex.v1.ListEntriesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntriesRequest,
      com.google.cloud.dataplex.v1.ListEntriesResponse> getListEntriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEntriesRequest, com.google.cloud.dataplex.v1.ListEntriesResponse> getListEntriesMethod;
    if ((getListEntriesMethod = CatalogServiceGrpc.getListEntriesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getListEntriesMethod = CatalogServiceGrpc.getListEntriesMethod) == null) {
          CatalogServiceGrpc.getListEntriesMethod = getListEntriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListEntriesRequest, com.google.cloud.dataplex.v1.ListEntriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEntries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEntriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("ListEntries"))
              .build();
        }
      }
    }
    return getListEntriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getGetEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntry",
      requestType = com.google.cloud.dataplex.v1.GetEntryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getGetEntryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEntryRequest, com.google.cloud.dataplex.v1.Entry> getGetEntryMethod;
    if ((getGetEntryMethod = CatalogServiceGrpc.getGetEntryMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getGetEntryMethod = CatalogServiceGrpc.getGetEntryMethod) == null) {
          CatalogServiceGrpc.getGetEntryMethod = getGetEntryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetEntryRequest, com.google.cloud.dataplex.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEntry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("GetEntry"))
              .build();
        }
      }
    }
    return getGetEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.LookupEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getLookupEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupEntry",
      requestType = com.google.cloud.dataplex.v1.LookupEntryRequest.class,
      responseType = com.google.cloud.dataplex.v1.Entry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.LookupEntryRequest,
      com.google.cloud.dataplex.v1.Entry> getLookupEntryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.LookupEntryRequest, com.google.cloud.dataplex.v1.Entry> getLookupEntryMethod;
    if ((getLookupEntryMethod = CatalogServiceGrpc.getLookupEntryMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getLookupEntryMethod = CatalogServiceGrpc.getLookupEntryMethod) == null) {
          CatalogServiceGrpc.getLookupEntryMethod = getLookupEntryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.LookupEntryRequest, com.google.cloud.dataplex.v1.Entry>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupEntry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.LookupEntryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Entry.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("LookupEntry"))
              .build();
        }
      }
    }
    return getLookupEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.SearchEntriesRequest,
      com.google.cloud.dataplex.v1.SearchEntriesResponse> getSearchEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchEntries",
      requestType = com.google.cloud.dataplex.v1.SearchEntriesRequest.class,
      responseType = com.google.cloud.dataplex.v1.SearchEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.SearchEntriesRequest,
      com.google.cloud.dataplex.v1.SearchEntriesResponse> getSearchEntriesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.SearchEntriesRequest, com.google.cloud.dataplex.v1.SearchEntriesResponse> getSearchEntriesMethod;
    if ((getSearchEntriesMethod = CatalogServiceGrpc.getSearchEntriesMethod) == null) {
      synchronized (CatalogServiceGrpc.class) {
        if ((getSearchEntriesMethod = CatalogServiceGrpc.getSearchEntriesMethod) == null) {
          CatalogServiceGrpc.getSearchEntriesMethod = getSearchEntriesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.SearchEntriesRequest, com.google.cloud.dataplex.v1.SearchEntriesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchEntries"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.SearchEntriesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.SearchEntriesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CatalogServiceMethodDescriptorSupplier("SearchEntries"))
              .build();
        }
      }
    }
    return getSearchEntriesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CatalogServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceStub>() {
        @java.lang.Override
        public CatalogServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceStub(channel, callOptions);
        }
      };
    return CatalogServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CatalogServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceBlockingStub>() {
        @java.lang.Override
        public CatalogServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceBlockingStub(channel, callOptions);
        }
      };
    return CatalogServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CatalogServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CatalogServiceFutureStub>() {
        @java.lang.Override
        public CatalogServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CatalogServiceFutureStub(channel, callOptions);
        }
      };
    return CatalogServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The primary resources offered by this service are EntryGroups, EntryTypes,
   * AspectTypes, Entry and Aspect which collectively allow a data administrator
   * to organize, manage, secure and catalog data across their organization
   * located across cloud projects in a variety of storage systems including Cloud
   * Storage and BigQuery.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates an EntryType
     * </pre>
     */
    default void createEntryType(com.google.cloud.dataplex.v1.CreateEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEntryTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a EntryType resource.
     * </pre>
     */
    default void updateEntryType(com.google.cloud.dataplex.v1.UpdateEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEntryTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a EntryType resource.
     * </pre>
     */
    default void deleteEntryType(com.google.cloud.dataplex.v1.DeleteEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEntryTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists EntryType resources in a project and location.
     * </pre>
     */
    default void listEntryTypes(com.google.cloud.dataplex.v1.ListEntryTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEntryTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a EntryType resource.
     * </pre>
     */
    default void getEntryType(com.google.cloud.dataplex.v1.GetEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntryTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an AspectType
     * </pre>
     */
    default void createAspectType(com.google.cloud.dataplex.v1.CreateAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAspectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a AspectType resource.
     * </pre>
     */
    default void updateAspectType(com.google.cloud.dataplex.v1.UpdateAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAspectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a AspectType resource.
     * </pre>
     */
    default void deleteAspectType(com.google.cloud.dataplex.v1.DeleteAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAspectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists AspectType resources in a project and location.
     * </pre>
     */
    default void listAspectTypes(com.google.cloud.dataplex.v1.ListAspectTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAspectTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAspectTypesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a AspectType resource.
     * </pre>
     */
    default void getAspectType(com.google.cloud.dataplex.v1.GetAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.AspectType> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAspectTypeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an EntryGroup
     * </pre>
     */
    default void createEntryGroup(com.google.cloud.dataplex.v1.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEntryGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a EntryGroup resource.
     * </pre>
     */
    default void updateEntryGroup(com.google.cloud.dataplex.v1.UpdateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEntryGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a EntryGroup resource.
     * </pre>
     */
    default void deleteEntryGroup(com.google.cloud.dataplex.v1.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEntryGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists EntryGroup resources in a project and location.
     * </pre>
     */
    default void listEntryGroups(com.google.cloud.dataplex.v1.ListEntryGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryGroupsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEntryGroupsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a EntryGroup resource.
     * </pre>
     */
    default void getEntryGroup(com.google.cloud.dataplex.v1.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryGroup> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntryGroupMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an Entry.
     * </pre>
     */
    default void createEntry(com.google.cloud.dataplex.v1.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEntryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an Entry.
     * </pre>
     */
    default void updateEntry(com.google.cloud.dataplex.v1.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEntryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an Entry.
     * </pre>
     */
    default void deleteEntry(com.google.cloud.dataplex.v1.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEntryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists entries within an entry group.
     * </pre>
     */
    default void listEntries(com.google.cloud.dataplex.v1.ListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEntriesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single entry.
     * </pre>
     */
    default void getEntry(com.google.cloud.dataplex.v1.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEntryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Looks up a single entry.
     * </pre>
     */
    default void lookupEntry(com.google.cloud.dataplex.v1.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupEntryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Searches for entries matching given query and scope.
     * </pre>
     */
    default void searchEntries(com.google.cloud.dataplex.v1.SearchEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.SearchEntriesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchEntriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CatalogService.
   * <pre>
   * The primary resources offered by this service are EntryGroups, EntryTypes,
   * AspectTypes, Entry and Aspect which collectively allow a data administrator
   * to organize, manage, secure and catalog data across their organization
   * located across cloud projects in a variety of storage systems including Cloud
   * Storage and BigQuery.
   * </pre>
   */
  public static abstract class CatalogServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CatalogServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CatalogService.
   * <pre>
   * The primary resources offered by this service are EntryGroups, EntryTypes,
   * AspectTypes, Entry and Aspect which collectively allow a data administrator
   * to organize, manage, secure and catalog data across their organization
   * located across cloud projects in a variety of storage systems including Cloud
   * Storage and BigQuery.
   * </pre>
   */
  public static final class CatalogServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CatalogServiceStub> {
    private CatalogServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates an EntryType
     * </pre>
     */
    public void createEntryType(com.google.cloud.dataplex.v1.CreateEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntryTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a EntryType resource.
     * </pre>
     */
    public void updateEntryType(com.google.cloud.dataplex.v1.UpdateEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntryTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a EntryType resource.
     * </pre>
     */
    public void deleteEntryType(com.google.cloud.dataplex.v1.DeleteEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntryTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists EntryType resources in a project and location.
     * </pre>
     */
    public void listEntryTypes(com.google.cloud.dataplex.v1.ListEntryTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntryTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a EntryType resource.
     * </pre>
     */
    public void getEntryType(com.google.cloud.dataplex.v1.GetEntryTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntryTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an AspectType
     * </pre>
     */
    public void createAspectType(com.google.cloud.dataplex.v1.CreateAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAspectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a AspectType resource.
     * </pre>
     */
    public void updateAspectType(com.google.cloud.dataplex.v1.UpdateAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAspectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a AspectType resource.
     * </pre>
     */
    public void deleteAspectType(com.google.cloud.dataplex.v1.DeleteAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAspectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists AspectType resources in a project and location.
     * </pre>
     */
    public void listAspectTypes(com.google.cloud.dataplex.v1.ListAspectTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAspectTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAspectTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a AspectType resource.
     * </pre>
     */
    public void getAspectType(com.google.cloud.dataplex.v1.GetAspectTypeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.AspectType> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAspectTypeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an EntryGroup
     * </pre>
     */
    public void createEntryGroup(com.google.cloud.dataplex.v1.CreateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a EntryGroup resource.
     * </pre>
     */
    public void updateEntryGroup(com.google.cloud.dataplex.v1.UpdateEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntryGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a EntryGroup resource.
     * </pre>
     */
    public void deleteEntryGroup(com.google.cloud.dataplex.v1.DeleteEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists EntryGroup resources in a project and location.
     * </pre>
     */
    public void listEntryGroups(com.google.cloud.dataplex.v1.ListEntryGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryGroupsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntryGroupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a EntryGroup resource.
     * </pre>
     */
    public void getEntryGroup(com.google.cloud.dataplex.v1.GetEntryGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryGroup> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntryGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an Entry.
     * </pre>
     */
    public void createEntry(com.google.cloud.dataplex.v1.CreateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an Entry.
     * </pre>
     */
    public void updateEntry(com.google.cloud.dataplex.v1.UpdateEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an Entry.
     * </pre>
     */
    public void deleteEntry(com.google.cloud.dataplex.v1.DeleteEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists entries within an entry group.
     * </pre>
     */
    public void listEntries(com.google.cloud.dataplex.v1.ListEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single entry.
     * </pre>
     */
    public void getEntry(com.google.cloud.dataplex.v1.GetEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Looks up a single entry.
     * </pre>
     */
    public void lookupEntry(com.google.cloud.dataplex.v1.LookupEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupEntryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Searches for entries matching given query and scope.
     * </pre>
     */
    public void searchEntries(com.google.cloud.dataplex.v1.SearchEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.SearchEntriesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchEntriesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CatalogService.
   * <pre>
   * The primary resources offered by this service are EntryGroups, EntryTypes,
   * AspectTypes, Entry and Aspect which collectively allow a data administrator
   * to organize, manage, secure and catalog data across their organization
   * located across cloud projects in a variety of storage systems including Cloud
   * Storage and BigQuery.
   * </pre>
   */
  public static final class CatalogServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CatalogServiceBlockingStub> {
    private CatalogServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates an EntryType
     * </pre>
     */
    public com.google.longrunning.Operation createEntryType(com.google.cloud.dataplex.v1.CreateEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntryTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a EntryType resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateEntryType(com.google.cloud.dataplex.v1.UpdateEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntryTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a EntryType resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEntryType(com.google.cloud.dataplex.v1.DeleteEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntryTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists EntryType resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEntryTypesResponse listEntryTypes(com.google.cloud.dataplex.v1.ListEntryTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntryTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a EntryType resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.EntryType getEntryType(com.google.cloud.dataplex.v1.GetEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntryTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an AspectType
     * </pre>
     */
    public com.google.longrunning.Operation createAspectType(com.google.cloud.dataplex.v1.CreateAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAspectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a AspectType resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateAspectType(com.google.cloud.dataplex.v1.UpdateAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAspectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a AspectType resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAspectType(com.google.cloud.dataplex.v1.DeleteAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAspectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists AspectType resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListAspectTypesResponse listAspectTypes(com.google.cloud.dataplex.v1.ListAspectTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAspectTypesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a AspectType resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.AspectType getAspectType(com.google.cloud.dataplex.v1.GetAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAspectTypeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an EntryGroup
     * </pre>
     */
    public com.google.longrunning.Operation createEntryGroup(com.google.cloud.dataplex.v1.CreateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a EntryGroup resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateEntryGroup(com.google.cloud.dataplex.v1.UpdateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a EntryGroup resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEntryGroup(com.google.cloud.dataplex.v1.DeleteEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists EntryGroup resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEntryGroupsResponse listEntryGroups(com.google.cloud.dataplex.v1.ListEntryGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntryGroupsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a EntryGroup resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.EntryGroup getEntryGroup(com.google.cloud.dataplex.v1.GetEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntryGroupMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an Entry.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entry createEntry(com.google.cloud.dataplex.v1.CreateEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an Entry.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entry updateEntry(com.google.cloud.dataplex.v1.UpdateEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEntryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an Entry.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entry deleteEntry(com.google.cloud.dataplex.v1.DeleteEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists entries within an entry group.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEntriesResponse listEntries(com.google.cloud.dataplex.v1.ListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntriesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single entry.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entry getEntry(com.google.cloud.dataplex.v1.GetEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Looks up a single entry.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Entry lookupEntry(com.google.cloud.dataplex.v1.LookupEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupEntryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Searches for entries matching given query and scope.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.SearchEntriesResponse searchEntries(com.google.cloud.dataplex.v1.SearchEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchEntriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CatalogService.
   * <pre>
   * The primary resources offered by this service are EntryGroups, EntryTypes,
   * AspectTypes, Entry and Aspect which collectively allow a data administrator
   * to organize, manage, secure and catalog data across their organization
   * located across cloud projects in a variety of storage systems including Cloud
   * Storage and BigQuery.
   * </pre>
   */
  public static final class CatalogServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CatalogServiceFutureStub> {
    private CatalogServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CatalogServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CatalogServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates an EntryType
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEntryType(
        com.google.cloud.dataplex.v1.CreateEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntryTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a EntryType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateEntryType(
        com.google.cloud.dataplex.v1.UpdateEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntryTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a EntryType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteEntryType(
        com.google.cloud.dataplex.v1.DeleteEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntryTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists EntryType resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListEntryTypesResponse> listEntryTypes(
        com.google.cloud.dataplex.v1.ListEntryTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntryTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a EntryType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.EntryType> getEntryType(
        com.google.cloud.dataplex.v1.GetEntryTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntryTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an AspectType
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAspectType(
        com.google.cloud.dataplex.v1.CreateAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAspectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a AspectType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAspectType(
        com.google.cloud.dataplex.v1.UpdateAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAspectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a AspectType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAspectType(
        com.google.cloud.dataplex.v1.DeleteAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAspectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists AspectType resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListAspectTypesResponse> listAspectTypes(
        com.google.cloud.dataplex.v1.ListAspectTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAspectTypesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a AspectType resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.AspectType> getAspectType(
        com.google.cloud.dataplex.v1.GetAspectTypeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAspectTypeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an EntryGroup
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEntryGroup(
        com.google.cloud.dataplex.v1.CreateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a EntryGroup resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateEntryGroup(
        com.google.cloud.dataplex.v1.UpdateEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a EntryGroup resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteEntryGroup(
        com.google.cloud.dataplex.v1.DeleteEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists EntryGroup resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListEntryGroupsResponse> listEntryGroups(
        com.google.cloud.dataplex.v1.ListEntryGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntryGroupsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a EntryGroup resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.EntryGroup> getEntryGroup(
        com.google.cloud.dataplex.v1.GetEntryGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntryGroupMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an Entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entry> createEntry(
        com.google.cloud.dataplex.v1.CreateEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an Entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entry> updateEntry(
        com.google.cloud.dataplex.v1.UpdateEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEntryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an Entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entry> deleteEntry(
        com.google.cloud.dataplex.v1.DeleteEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists entries within an entry group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListEntriesResponse> listEntries(
        com.google.cloud.dataplex.v1.ListEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntriesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entry> getEntry(
        com.google.cloud.dataplex.v1.GetEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Looks up a single entry.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Entry> lookupEntry(
        com.google.cloud.dataplex.v1.LookupEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupEntryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Searches for entries matching given query and scope.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.SearchEntriesResponse> searchEntries(
        com.google.cloud.dataplex.v1.SearchEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchEntriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENTRY_TYPE = 0;
  private static final int METHODID_UPDATE_ENTRY_TYPE = 1;
  private static final int METHODID_DELETE_ENTRY_TYPE = 2;
  private static final int METHODID_LIST_ENTRY_TYPES = 3;
  private static final int METHODID_GET_ENTRY_TYPE = 4;
  private static final int METHODID_CREATE_ASPECT_TYPE = 5;
  private static final int METHODID_UPDATE_ASPECT_TYPE = 6;
  private static final int METHODID_DELETE_ASPECT_TYPE = 7;
  private static final int METHODID_LIST_ASPECT_TYPES = 8;
  private static final int METHODID_GET_ASPECT_TYPE = 9;
  private static final int METHODID_CREATE_ENTRY_GROUP = 10;
  private static final int METHODID_UPDATE_ENTRY_GROUP = 11;
  private static final int METHODID_DELETE_ENTRY_GROUP = 12;
  private static final int METHODID_LIST_ENTRY_GROUPS = 13;
  private static final int METHODID_GET_ENTRY_GROUP = 14;
  private static final int METHODID_CREATE_ENTRY = 15;
  private static final int METHODID_UPDATE_ENTRY = 16;
  private static final int METHODID_DELETE_ENTRY = 17;
  private static final int METHODID_LIST_ENTRIES = 18;
  private static final int METHODID_GET_ENTRY = 19;
  private static final int METHODID_LOOKUP_ENTRY = 20;
  private static final int METHODID_SEARCH_ENTRIES = 21;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_CREATE_ENTRY_TYPE:
          serviceImpl.createEntryType((com.google.cloud.dataplex.v1.CreateEntryTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENTRY_TYPE:
          serviceImpl.updateEntryType((com.google.cloud.dataplex.v1.UpdateEntryTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENTRY_TYPE:
          serviceImpl.deleteEntryType((com.google.cloud.dataplex.v1.DeleteEntryTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENTRY_TYPES:
          serviceImpl.listEntryTypes((com.google.cloud.dataplex.v1.ListEntryTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryTypesResponse>) responseObserver);
          break;
        case METHODID_GET_ENTRY_TYPE:
          serviceImpl.getEntryType((com.google.cloud.dataplex.v1.GetEntryTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryType>) responseObserver);
          break;
        case METHODID_CREATE_ASPECT_TYPE:
          serviceImpl.createAspectType((com.google.cloud.dataplex.v1.CreateAspectTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ASPECT_TYPE:
          serviceImpl.updateAspectType((com.google.cloud.dataplex.v1.UpdateAspectTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ASPECT_TYPE:
          serviceImpl.deleteAspectType((com.google.cloud.dataplex.v1.DeleteAspectTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ASPECT_TYPES:
          serviceImpl.listAspectTypes((com.google.cloud.dataplex.v1.ListAspectTypesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAspectTypesResponse>) responseObserver);
          break;
        case METHODID_GET_ASPECT_TYPE:
          serviceImpl.getAspectType((com.google.cloud.dataplex.v1.GetAspectTypeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.AspectType>) responseObserver);
          break;
        case METHODID_CREATE_ENTRY_GROUP:
          serviceImpl.createEntryGroup((com.google.cloud.dataplex.v1.CreateEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENTRY_GROUP:
          serviceImpl.updateEntryGroup((com.google.cloud.dataplex.v1.UpdateEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENTRY_GROUP:
          serviceImpl.deleteEntryGroup((com.google.cloud.dataplex.v1.DeleteEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENTRY_GROUPS:
          serviceImpl.listEntryGroups((com.google.cloud.dataplex.v1.ListEntryGroupsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntryGroupsResponse>) responseObserver);
          break;
        case METHODID_GET_ENTRY_GROUP:
          serviceImpl.getEntryGroup((com.google.cloud.dataplex.v1.GetEntryGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EntryGroup>) responseObserver);
          break;
        case METHODID_CREATE_ENTRY:
          serviceImpl.createEntry((com.google.cloud.dataplex.v1.CreateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry>) responseObserver);
          break;
        case METHODID_UPDATE_ENTRY:
          serviceImpl.updateEntry((com.google.cloud.dataplex.v1.UpdateEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry>) responseObserver);
          break;
        case METHODID_DELETE_ENTRY:
          serviceImpl.deleteEntry((com.google.cloud.dataplex.v1.DeleteEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry>) responseObserver);
          break;
        case METHODID_LIST_ENTRIES:
          serviceImpl.listEntries((com.google.cloud.dataplex.v1.ListEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEntriesResponse>) responseObserver);
          break;
        case METHODID_GET_ENTRY:
          serviceImpl.getEntry((com.google.cloud.dataplex.v1.GetEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry>) responseObserver);
          break;
        case METHODID_LOOKUP_ENTRY:
          serviceImpl.lookupEntry((com.google.cloud.dataplex.v1.LookupEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Entry>) responseObserver);
          break;
        case METHODID_SEARCH_ENTRIES:
          serviceImpl.searchEntries((com.google.cloud.dataplex.v1.SearchEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.SearchEntriesResponse>) responseObserver);
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
          getCreateEntryTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.CreateEntryTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ENTRY_TYPE)))
        .addMethod(
          getUpdateEntryTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.UpdateEntryTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_ENTRY_TYPE)))
        .addMethod(
          getDeleteEntryTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.DeleteEntryTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ENTRY_TYPE)))
        .addMethod(
          getListEntryTypesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.ListEntryTypesRequest,
              com.google.cloud.dataplex.v1.ListEntryTypesResponse>(
                service, METHODID_LIST_ENTRY_TYPES)))
        .addMethod(
          getGetEntryTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.GetEntryTypeRequest,
              com.google.cloud.dataplex.v1.EntryType>(
                service, METHODID_GET_ENTRY_TYPE)))
        .addMethod(
          getCreateAspectTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.CreateAspectTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ASPECT_TYPE)))
        .addMethod(
          getUpdateAspectTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.UpdateAspectTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_ASPECT_TYPE)))
        .addMethod(
          getDeleteAspectTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.DeleteAspectTypeRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ASPECT_TYPE)))
        .addMethod(
          getListAspectTypesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.ListAspectTypesRequest,
              com.google.cloud.dataplex.v1.ListAspectTypesResponse>(
                service, METHODID_LIST_ASPECT_TYPES)))
        .addMethod(
          getGetAspectTypeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.GetAspectTypeRequest,
              com.google.cloud.dataplex.v1.AspectType>(
                service, METHODID_GET_ASPECT_TYPE)))
        .addMethod(
          getCreateEntryGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.CreateEntryGroupRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_ENTRY_GROUP)))
        .addMethod(
          getUpdateEntryGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.UpdateEntryGroupRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_ENTRY_GROUP)))
        .addMethod(
          getDeleteEntryGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.DeleteEntryGroupRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_ENTRY_GROUP)))
        .addMethod(
          getListEntryGroupsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.ListEntryGroupsRequest,
              com.google.cloud.dataplex.v1.ListEntryGroupsResponse>(
                service, METHODID_LIST_ENTRY_GROUPS)))
        .addMethod(
          getGetEntryGroupMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.GetEntryGroupRequest,
              com.google.cloud.dataplex.v1.EntryGroup>(
                service, METHODID_GET_ENTRY_GROUP)))
        .addMethod(
          getCreateEntryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.CreateEntryRequest,
              com.google.cloud.dataplex.v1.Entry>(
                service, METHODID_CREATE_ENTRY)))
        .addMethod(
          getUpdateEntryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.UpdateEntryRequest,
              com.google.cloud.dataplex.v1.Entry>(
                service, METHODID_UPDATE_ENTRY)))
        .addMethod(
          getDeleteEntryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.DeleteEntryRequest,
              com.google.cloud.dataplex.v1.Entry>(
                service, METHODID_DELETE_ENTRY)))
        .addMethod(
          getListEntriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.ListEntriesRequest,
              com.google.cloud.dataplex.v1.ListEntriesResponse>(
                service, METHODID_LIST_ENTRIES)))
        .addMethod(
          getGetEntryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.GetEntryRequest,
              com.google.cloud.dataplex.v1.Entry>(
                service, METHODID_GET_ENTRY)))
        .addMethod(
          getLookupEntryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.LookupEntryRequest,
              com.google.cloud.dataplex.v1.Entry>(
                service, METHODID_LOOKUP_ENTRY)))
        .addMethod(
          getSearchEntriesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.dataplex.v1.SearchEntriesRequest,
              com.google.cloud.dataplex.v1.SearchEntriesResponse>(
                service, METHODID_SEARCH_ENTRIES)))
        .build();
  }

  private static abstract class CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CatalogServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.CatalogProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CatalogService");
    }
  }

  private static final class CatalogServiceFileDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier {
    CatalogServiceFileDescriptorSupplier() {}
  }

  private static final class CatalogServiceMethodDescriptorSupplier
      extends CatalogServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CatalogServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CatalogServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CatalogServiceFileDescriptorSupplier())
              .addMethod(getCreateEntryTypeMethod())
              .addMethod(getUpdateEntryTypeMethod())
              .addMethod(getDeleteEntryTypeMethod())
              .addMethod(getListEntryTypesMethod())
              .addMethod(getGetEntryTypeMethod())
              .addMethod(getCreateAspectTypeMethod())
              .addMethod(getUpdateAspectTypeMethod())
              .addMethod(getDeleteAspectTypeMethod())
              .addMethod(getListAspectTypesMethod())
              .addMethod(getGetAspectTypeMethod())
              .addMethod(getCreateEntryGroupMethod())
              .addMethod(getUpdateEntryGroupMethod())
              .addMethod(getDeleteEntryGroupMethod())
              .addMethod(getListEntryGroupsMethod())
              .addMethod(getGetEntryGroupMethod())
              .addMethod(getCreateEntryMethod())
              .addMethod(getUpdateEntryMethod())
              .addMethod(getDeleteEntryMethod())
              .addMethod(getListEntriesMethod())
              .addMethod(getGetEntryMethod())
              .addMethod(getLookupEntryMethod())
              .addMethod(getSearchEntriesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
