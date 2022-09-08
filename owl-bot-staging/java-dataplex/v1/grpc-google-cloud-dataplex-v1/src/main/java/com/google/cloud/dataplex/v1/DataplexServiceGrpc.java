package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Dataplex service provides data lakes as a service. The primary resources
 * offered by this service are Lakes, Zones and Assets which collectively allow
 * a data administrator to organize, manage, secure and catalog data across
 * their organization located across cloud projects in a variety of storage
 * systems including Cloud Storage and BigQuery.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataplexServiceGrpc {

  private DataplexServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dataplex.v1.DataplexService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateLakeRequest,
      com.google.longrunning.Operation> getCreateLakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLake",
      requestType = com.google.cloud.dataplex.v1.CreateLakeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateLakeRequest,
      com.google.longrunning.Operation> getCreateLakeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateLakeRequest, com.google.longrunning.Operation> getCreateLakeMethod;
    if ((getCreateLakeMethod = DataplexServiceGrpc.getCreateLakeMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCreateLakeMethod = DataplexServiceGrpc.getCreateLakeMethod) == null) {
          DataplexServiceGrpc.getCreateLakeMethod = getCreateLakeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateLakeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateLakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CreateLake"))
              .build();
        }
      }
    }
    return getCreateLakeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateLakeRequest,
      com.google.longrunning.Operation> getUpdateLakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLake",
      requestType = com.google.cloud.dataplex.v1.UpdateLakeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateLakeRequest,
      com.google.longrunning.Operation> getUpdateLakeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateLakeRequest, com.google.longrunning.Operation> getUpdateLakeMethod;
    if ((getUpdateLakeMethod = DataplexServiceGrpc.getUpdateLakeMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getUpdateLakeMethod = DataplexServiceGrpc.getUpdateLakeMethod) == null) {
          DataplexServiceGrpc.getUpdateLakeMethod = getUpdateLakeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateLakeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateLake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateLakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("UpdateLake"))
              .build();
        }
      }
    }
    return getUpdateLakeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteLakeRequest,
      com.google.longrunning.Operation> getDeleteLakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteLake",
      requestType = com.google.cloud.dataplex.v1.DeleteLakeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteLakeRequest,
      com.google.longrunning.Operation> getDeleteLakeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteLakeRequest, com.google.longrunning.Operation> getDeleteLakeMethod;
    if ((getDeleteLakeMethod = DataplexServiceGrpc.getDeleteLakeMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getDeleteLakeMethod = DataplexServiceGrpc.getDeleteLakeMethod) == null) {
          DataplexServiceGrpc.getDeleteLakeMethod = getDeleteLakeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteLakeRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteLake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteLakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("DeleteLake"))
              .build();
        }
      }
    }
    return getDeleteLakeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakesRequest,
      com.google.cloud.dataplex.v1.ListLakesResponse> getListLakesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLakes",
      requestType = com.google.cloud.dataplex.v1.ListLakesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListLakesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakesRequest,
      com.google.cloud.dataplex.v1.ListLakesResponse> getListLakesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakesRequest, com.google.cloud.dataplex.v1.ListLakesResponse> getListLakesMethod;
    if ((getListLakesMethod = DataplexServiceGrpc.getListLakesMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListLakesMethod = DataplexServiceGrpc.getListLakesMethod) == null) {
          DataplexServiceGrpc.getListLakesMethod = getListLakesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListLakesRequest, com.google.cloud.dataplex.v1.ListLakesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLakes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListLakesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListLakesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListLakes"))
              .build();
        }
      }
    }
    return getListLakesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetLakeRequest,
      com.google.cloud.dataplex.v1.Lake> getGetLakeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLake",
      requestType = com.google.cloud.dataplex.v1.GetLakeRequest.class,
      responseType = com.google.cloud.dataplex.v1.Lake.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetLakeRequest,
      com.google.cloud.dataplex.v1.Lake> getGetLakeMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetLakeRequest, com.google.cloud.dataplex.v1.Lake> getGetLakeMethod;
    if ((getGetLakeMethod = DataplexServiceGrpc.getGetLakeMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetLakeMethod = DataplexServiceGrpc.getGetLakeMethod) == null) {
          DataplexServiceGrpc.getGetLakeMethod = getGetLakeMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetLakeRequest, com.google.cloud.dataplex.v1.Lake>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLake"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetLakeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Lake.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetLake"))
              .build();
        }
      }
    }
    return getGetLakeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakeActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListLakeActionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLakeActions",
      requestType = com.google.cloud.dataplex.v1.ListLakeActionsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListActionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakeActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListLakeActionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListLakeActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse> getListLakeActionsMethod;
    if ((getListLakeActionsMethod = DataplexServiceGrpc.getListLakeActionsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListLakeActionsMethod = DataplexServiceGrpc.getListLakeActionsMethod) == null) {
          DataplexServiceGrpc.getListLakeActionsMethod = getListLakeActionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListLakeActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListLakeActions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListLakeActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListActionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListLakeActions"))
              .build();
        }
      }
    }
    return getListLakeActionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateZoneRequest,
      com.google.longrunning.Operation> getCreateZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateZone",
      requestType = com.google.cloud.dataplex.v1.CreateZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateZoneRequest,
      com.google.longrunning.Operation> getCreateZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateZoneRequest, com.google.longrunning.Operation> getCreateZoneMethod;
    if ((getCreateZoneMethod = DataplexServiceGrpc.getCreateZoneMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCreateZoneMethod = DataplexServiceGrpc.getCreateZoneMethod) == null) {
          DataplexServiceGrpc.getCreateZoneMethod = getCreateZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateZoneRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CreateZone"))
              .build();
        }
      }
    }
    return getCreateZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateZoneRequest,
      com.google.longrunning.Operation> getUpdateZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateZone",
      requestType = com.google.cloud.dataplex.v1.UpdateZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateZoneRequest,
      com.google.longrunning.Operation> getUpdateZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateZoneRequest, com.google.longrunning.Operation> getUpdateZoneMethod;
    if ((getUpdateZoneMethod = DataplexServiceGrpc.getUpdateZoneMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getUpdateZoneMethod = DataplexServiceGrpc.getUpdateZoneMethod) == null) {
          DataplexServiceGrpc.getUpdateZoneMethod = getUpdateZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateZoneRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("UpdateZone"))
              .build();
        }
      }
    }
    return getUpdateZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteZoneRequest,
      com.google.longrunning.Operation> getDeleteZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteZone",
      requestType = com.google.cloud.dataplex.v1.DeleteZoneRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteZoneRequest,
      com.google.longrunning.Operation> getDeleteZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteZoneRequest, com.google.longrunning.Operation> getDeleteZoneMethod;
    if ((getDeleteZoneMethod = DataplexServiceGrpc.getDeleteZoneMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getDeleteZoneMethod = DataplexServiceGrpc.getDeleteZoneMethod) == null) {
          DataplexServiceGrpc.getDeleteZoneMethod = getDeleteZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteZoneRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("DeleteZone"))
              .build();
        }
      }
    }
    return getDeleteZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZonesRequest,
      com.google.cloud.dataplex.v1.ListZonesResponse> getListZonesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListZones",
      requestType = com.google.cloud.dataplex.v1.ListZonesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListZonesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZonesRequest,
      com.google.cloud.dataplex.v1.ListZonesResponse> getListZonesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZonesRequest, com.google.cloud.dataplex.v1.ListZonesResponse> getListZonesMethod;
    if ((getListZonesMethod = DataplexServiceGrpc.getListZonesMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListZonesMethod = DataplexServiceGrpc.getListZonesMethod) == null) {
          DataplexServiceGrpc.getListZonesMethod = getListZonesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListZonesRequest, com.google.cloud.dataplex.v1.ListZonesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListZones"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListZonesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListZonesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListZones"))
              .build();
        }
      }
    }
    return getListZonesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetZoneRequest,
      com.google.cloud.dataplex.v1.Zone> getGetZoneMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetZone",
      requestType = com.google.cloud.dataplex.v1.GetZoneRequest.class,
      responseType = com.google.cloud.dataplex.v1.Zone.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetZoneRequest,
      com.google.cloud.dataplex.v1.Zone> getGetZoneMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetZoneRequest, com.google.cloud.dataplex.v1.Zone> getGetZoneMethod;
    if ((getGetZoneMethod = DataplexServiceGrpc.getGetZoneMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetZoneMethod = DataplexServiceGrpc.getGetZoneMethod) == null) {
          DataplexServiceGrpc.getGetZoneMethod = getGetZoneMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetZoneRequest, com.google.cloud.dataplex.v1.Zone>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetZone"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetZoneRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Zone.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetZone"))
              .build();
        }
      }
    }
    return getGetZoneMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZoneActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListZoneActionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListZoneActions",
      requestType = com.google.cloud.dataplex.v1.ListZoneActionsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListActionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZoneActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListZoneActionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListZoneActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse> getListZoneActionsMethod;
    if ((getListZoneActionsMethod = DataplexServiceGrpc.getListZoneActionsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListZoneActionsMethod = DataplexServiceGrpc.getListZoneActionsMethod) == null) {
          DataplexServiceGrpc.getListZoneActionsMethod = getListZoneActionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListZoneActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListZoneActions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListZoneActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListActionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListZoneActions"))
              .build();
        }
      }
    }
    return getListZoneActionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAssetRequest,
      com.google.longrunning.Operation> getCreateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAsset",
      requestType = com.google.cloud.dataplex.v1.CreateAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAssetRequest,
      com.google.longrunning.Operation> getCreateAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateAssetRequest, com.google.longrunning.Operation> getCreateAssetMethod;
    if ((getCreateAssetMethod = DataplexServiceGrpc.getCreateAssetMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCreateAssetMethod = DataplexServiceGrpc.getCreateAssetMethod) == null) {
          DataplexServiceGrpc.getCreateAssetMethod = getCreateAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateAssetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CreateAsset"))
              .build();
        }
      }
    }
    return getCreateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAssetRequest,
      com.google.longrunning.Operation> getUpdateAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAsset",
      requestType = com.google.cloud.dataplex.v1.UpdateAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAssetRequest,
      com.google.longrunning.Operation> getUpdateAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateAssetRequest, com.google.longrunning.Operation> getUpdateAssetMethod;
    if ((getUpdateAssetMethod = DataplexServiceGrpc.getUpdateAssetMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getUpdateAssetMethod = DataplexServiceGrpc.getUpdateAssetMethod) == null) {
          DataplexServiceGrpc.getUpdateAssetMethod = getUpdateAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateAssetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("UpdateAsset"))
              .build();
        }
      }
    }
    return getUpdateAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAssetRequest,
      com.google.longrunning.Operation> getDeleteAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAsset",
      requestType = com.google.cloud.dataplex.v1.DeleteAssetRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAssetRequest,
      com.google.longrunning.Operation> getDeleteAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteAssetRequest, com.google.longrunning.Operation> getDeleteAssetMethod;
    if ((getDeleteAssetMethod = DataplexServiceGrpc.getDeleteAssetMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getDeleteAssetMethod = DataplexServiceGrpc.getDeleteAssetMethod) == null) {
          DataplexServiceGrpc.getDeleteAssetMethod = getDeleteAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteAssetRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("DeleteAsset"))
              .build();
        }
      }
    }
    return getDeleteAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetsRequest,
      com.google.cloud.dataplex.v1.ListAssetsResponse> getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.dataplex.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetsRequest,
      com.google.cloud.dataplex.v1.ListAssetsResponse> getListAssetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetsRequest, com.google.cloud.dataplex.v1.ListAssetsResponse> getListAssetsMethod;
    if ((getListAssetsMethod = DataplexServiceGrpc.getListAssetsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListAssetsMethod = DataplexServiceGrpc.getListAssetsMethod) == null) {
          DataplexServiceGrpc.getListAssetsMethod = getListAssetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListAssetsRequest, com.google.cloud.dataplex.v1.ListAssetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListAssetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListAssets"))
              .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAssetRequest,
      com.google.cloud.dataplex.v1.Asset> getGetAssetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAsset",
      requestType = com.google.cloud.dataplex.v1.GetAssetRequest.class,
      responseType = com.google.cloud.dataplex.v1.Asset.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAssetRequest,
      com.google.cloud.dataplex.v1.Asset> getGetAssetMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetAssetRequest, com.google.cloud.dataplex.v1.Asset> getGetAssetMethod;
    if ((getGetAssetMethod = DataplexServiceGrpc.getGetAssetMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetAssetMethod = DataplexServiceGrpc.getGetAssetMethod) == null) {
          DataplexServiceGrpc.getGetAssetMethod = getGetAssetMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetAssetRequest, com.google.cloud.dataplex.v1.Asset>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAsset"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetAssetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Asset.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetAsset"))
              .build();
        }
      }
    }
    return getGetAssetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListAssetActionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssetActions",
      requestType = com.google.cloud.dataplex.v1.ListAssetActionsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListActionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetActionsRequest,
      com.google.cloud.dataplex.v1.ListActionsResponse> getListAssetActionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListAssetActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse> getListAssetActionsMethod;
    if ((getListAssetActionsMethod = DataplexServiceGrpc.getListAssetActionsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListAssetActionsMethod = DataplexServiceGrpc.getListAssetActionsMethod) == null) {
          DataplexServiceGrpc.getListAssetActionsMethod = getListAssetActionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListAssetActionsRequest, com.google.cloud.dataplex.v1.ListActionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssetActions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListAssetActionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListActionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListAssetActions"))
              .build();
        }
      }
    }
    return getListAssetActionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateTaskRequest,
      com.google.longrunning.Operation> getCreateTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTask",
      requestType = com.google.cloud.dataplex.v1.CreateTaskRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateTaskRequest,
      com.google.longrunning.Operation> getCreateTaskMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateTaskRequest, com.google.longrunning.Operation> getCreateTaskMethod;
    if ((getCreateTaskMethod = DataplexServiceGrpc.getCreateTaskMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCreateTaskMethod = DataplexServiceGrpc.getCreateTaskMethod) == null) {
          DataplexServiceGrpc.getCreateTaskMethod = getCreateTaskMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateTaskRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CreateTask"))
              .build();
        }
      }
    }
    return getCreateTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateTaskRequest,
      com.google.longrunning.Operation> getUpdateTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTask",
      requestType = com.google.cloud.dataplex.v1.UpdateTaskRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateTaskRequest,
      com.google.longrunning.Operation> getUpdateTaskMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateTaskRequest, com.google.longrunning.Operation> getUpdateTaskMethod;
    if ((getUpdateTaskMethod = DataplexServiceGrpc.getUpdateTaskMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getUpdateTaskMethod = DataplexServiceGrpc.getUpdateTaskMethod) == null) {
          DataplexServiceGrpc.getUpdateTaskMethod = getUpdateTaskMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateTaskRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("UpdateTask"))
              .build();
        }
      }
    }
    return getUpdateTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteTaskRequest,
      com.google.longrunning.Operation> getDeleteTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTask",
      requestType = com.google.cloud.dataplex.v1.DeleteTaskRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteTaskRequest,
      com.google.longrunning.Operation> getDeleteTaskMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteTaskRequest, com.google.longrunning.Operation> getDeleteTaskMethod;
    if ((getDeleteTaskMethod = DataplexServiceGrpc.getDeleteTaskMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getDeleteTaskMethod = DataplexServiceGrpc.getDeleteTaskMethod) == null) {
          DataplexServiceGrpc.getDeleteTaskMethod = getDeleteTaskMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteTaskRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("DeleteTask"))
              .build();
        }
      }
    }
    return getDeleteTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListTasksRequest,
      com.google.cloud.dataplex.v1.ListTasksResponse> getListTasksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTasks",
      requestType = com.google.cloud.dataplex.v1.ListTasksRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListTasksResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListTasksRequest,
      com.google.cloud.dataplex.v1.ListTasksResponse> getListTasksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListTasksRequest, com.google.cloud.dataplex.v1.ListTasksResponse> getListTasksMethod;
    if ((getListTasksMethod = DataplexServiceGrpc.getListTasksMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListTasksMethod = DataplexServiceGrpc.getListTasksMethod) == null) {
          DataplexServiceGrpc.getListTasksMethod = getListTasksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListTasksRequest, com.google.cloud.dataplex.v1.ListTasksResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTasks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListTasksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListTasksResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListTasks"))
              .build();
        }
      }
    }
    return getListTasksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetTaskRequest,
      com.google.cloud.dataplex.v1.Task> getGetTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTask",
      requestType = com.google.cloud.dataplex.v1.GetTaskRequest.class,
      responseType = com.google.cloud.dataplex.v1.Task.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetTaskRequest,
      com.google.cloud.dataplex.v1.Task> getGetTaskMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetTaskRequest, com.google.cloud.dataplex.v1.Task> getGetTaskMethod;
    if ((getGetTaskMethod = DataplexServiceGrpc.getGetTaskMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetTaskMethod = DataplexServiceGrpc.getGetTaskMethod) == null) {
          DataplexServiceGrpc.getGetTaskMethod = getGetTaskMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetTaskRequest, com.google.cloud.dataplex.v1.Task>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetTaskRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Task.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetTask"))
              .build();
        }
      }
    }
    return getGetTaskMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListJobsRequest,
      com.google.cloud.dataplex.v1.ListJobsResponse> getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.dataplex.v1.ListJobsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListJobsRequest,
      com.google.cloud.dataplex.v1.ListJobsResponse> getListJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListJobsRequest, com.google.cloud.dataplex.v1.ListJobsResponse> getListJobsMethod;
    if ((getListJobsMethod = DataplexServiceGrpc.getListJobsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListJobsMethod = DataplexServiceGrpc.getListJobsMethod) == null) {
          DataplexServiceGrpc.getListJobsMethod = getListJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListJobsRequest, com.google.cloud.dataplex.v1.ListJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListJobs"))
              .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetJobRequest,
      com.google.cloud.dataplex.v1.Job> getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.dataplex.v1.GetJobRequest.class,
      responseType = com.google.cloud.dataplex.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetJobRequest,
      com.google.cloud.dataplex.v1.Job> getGetJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetJobRequest, com.google.cloud.dataplex.v1.Job> getGetJobMethod;
    if ((getGetJobMethod = DataplexServiceGrpc.getGetJobMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetJobMethod = DataplexServiceGrpc.getGetJobMethod) == null) {
          DataplexServiceGrpc.getGetJobMethod = getGetJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetJobRequest, com.google.cloud.dataplex.v1.Job>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Job.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetJob"))
              .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CancelJobRequest,
      com.google.protobuf.Empty> getCancelJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelJob",
      requestType = com.google.cloud.dataplex.v1.CancelJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CancelJobRequest,
      com.google.protobuf.Empty> getCancelJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CancelJobRequest, com.google.protobuf.Empty> getCancelJobMethod;
    if ((getCancelJobMethod = DataplexServiceGrpc.getCancelJobMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCancelJobMethod = DataplexServiceGrpc.getCancelJobMethod) == null) {
          DataplexServiceGrpc.getCancelJobMethod = getCancelJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CancelJobRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CancelJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CancelJob"))
              .build();
        }
      }
    }
    return getCancelJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnvironment",
      requestType = com.google.cloud.dataplex.v1.CreateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEnvironmentRequest,
      com.google.longrunning.Operation> getCreateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.CreateEnvironmentRequest, com.google.longrunning.Operation> getCreateEnvironmentMethod;
    if ((getCreateEnvironmentMethod = DataplexServiceGrpc.getCreateEnvironmentMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getCreateEnvironmentMethod = DataplexServiceGrpc.getCreateEnvironmentMethod) == null) {
          DataplexServiceGrpc.getCreateEnvironmentMethod = getCreateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.CreateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.CreateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("CreateEnvironment"))
              .build();
        }
      }
    }
    return getCreateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnvironment",
      requestType = com.google.cloud.dataplex.v1.UpdateEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEnvironmentRequest,
      com.google.longrunning.Operation> getUpdateEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.UpdateEnvironmentRequest, com.google.longrunning.Operation> getUpdateEnvironmentMethod;
    if ((getUpdateEnvironmentMethod = DataplexServiceGrpc.getUpdateEnvironmentMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getUpdateEnvironmentMethod = DataplexServiceGrpc.getUpdateEnvironmentMethod) == null) {
          DataplexServiceGrpc.getUpdateEnvironmentMethod = getUpdateEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.UpdateEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.UpdateEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("UpdateEnvironment"))
              .build();
        }
      }
    }
    return getUpdateEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEnvironmentRequest,
      com.google.longrunning.Operation> getDeleteEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnvironment",
      requestType = com.google.cloud.dataplex.v1.DeleteEnvironmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEnvironmentRequest,
      com.google.longrunning.Operation> getDeleteEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.DeleteEnvironmentRequest, com.google.longrunning.Operation> getDeleteEnvironmentMethod;
    if ((getDeleteEnvironmentMethod = DataplexServiceGrpc.getDeleteEnvironmentMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getDeleteEnvironmentMethod = DataplexServiceGrpc.getDeleteEnvironmentMethod) == null) {
          DataplexServiceGrpc.getDeleteEnvironmentMethod = getDeleteEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.DeleteEnvironmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.DeleteEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("DeleteEnvironment"))
              .build();
        }
      }
    }
    return getDeleteEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEnvironmentsRequest,
      com.google.cloud.dataplex.v1.ListEnvironmentsResponse> getListEnvironmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnvironments",
      requestType = com.google.cloud.dataplex.v1.ListEnvironmentsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEnvironmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEnvironmentsRequest,
      com.google.cloud.dataplex.v1.ListEnvironmentsResponse> getListEnvironmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListEnvironmentsRequest, com.google.cloud.dataplex.v1.ListEnvironmentsResponse> getListEnvironmentsMethod;
    if ((getListEnvironmentsMethod = DataplexServiceGrpc.getListEnvironmentsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListEnvironmentsMethod = DataplexServiceGrpc.getListEnvironmentsMethod) == null) {
          DataplexServiceGrpc.getListEnvironmentsMethod = getListEnvironmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListEnvironmentsRequest, com.google.cloud.dataplex.v1.ListEnvironmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnvironments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEnvironmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListEnvironmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListEnvironments"))
              .build();
        }
      }
    }
    return getListEnvironmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEnvironmentRequest,
      com.google.cloud.dataplex.v1.Environment> getGetEnvironmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnvironment",
      requestType = com.google.cloud.dataplex.v1.GetEnvironmentRequest.class,
      responseType = com.google.cloud.dataplex.v1.Environment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEnvironmentRequest,
      com.google.cloud.dataplex.v1.Environment> getGetEnvironmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.GetEnvironmentRequest, com.google.cloud.dataplex.v1.Environment> getGetEnvironmentMethod;
    if ((getGetEnvironmentMethod = DataplexServiceGrpc.getGetEnvironmentMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getGetEnvironmentMethod = DataplexServiceGrpc.getGetEnvironmentMethod) == null) {
          DataplexServiceGrpc.getGetEnvironmentMethod = getGetEnvironmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.GetEnvironmentRequest, com.google.cloud.dataplex.v1.Environment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnvironment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.GetEnvironmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.Environment.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("GetEnvironment"))
              .build();
        }
      }
    }
    return getGetEnvironmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListSessionsRequest,
      com.google.cloud.dataplex.v1.ListSessionsResponse> getListSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSessions",
      requestType = com.google.cloud.dataplex.v1.ListSessionsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListSessionsRequest,
      com.google.cloud.dataplex.v1.ListSessionsResponse> getListSessionsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.dataplex.v1.ListSessionsRequest, com.google.cloud.dataplex.v1.ListSessionsResponse> getListSessionsMethod;
    if ((getListSessionsMethod = DataplexServiceGrpc.getListSessionsMethod) == null) {
      synchronized (DataplexServiceGrpc.class) {
        if ((getListSessionsMethod = DataplexServiceGrpc.getListSessionsMethod) == null) {
          DataplexServiceGrpc.getListSessionsMethod = getListSessionsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.dataplex.v1.ListSessionsRequest, com.google.cloud.dataplex.v1.ListSessionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSessions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListSessionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.dataplex.v1.ListSessionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new DataplexServiceMethodDescriptorSupplier("ListSessions"))
              .build();
        }
      }
    }
    return getListSessionsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DataplexServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataplexServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataplexServiceStub>() {
        @java.lang.Override
        public DataplexServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataplexServiceStub(channel, callOptions);
        }
      };
    return DataplexServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataplexServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataplexServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataplexServiceBlockingStub>() {
        @java.lang.Override
        public DataplexServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataplexServiceBlockingStub(channel, callOptions);
        }
      };
    return DataplexServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static DataplexServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataplexServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<DataplexServiceFutureStub>() {
        @java.lang.Override
        public DataplexServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new DataplexServiceFutureStub(channel, callOptions);
        }
      };
    return DataplexServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Dataplex service provides data lakes as a service. The primary resources
   * offered by this service are Lakes, Zones and Assets which collectively allow
   * a data administrator to organize, manage, secure and catalog data across
   * their organization located across cloud projects in a variety of storage
   * systems including Cloud Storage and BigQuery.
   * </pre>
   */
  public static abstract class DataplexServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a lake resource.
     * </pre>
     */
    public void createLake(com.google.cloud.dataplex.v1.CreateLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateLakeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a lake resource.
     * </pre>
     */
    public void updateLake(com.google.cloud.dataplex.v1.UpdateLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateLakeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a lake resource. All zones within the lake must be deleted before
     * the lake can be deleted.
     * </pre>
     */
    public void deleteLake(com.google.cloud.dataplex.v1.DeleteLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteLakeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists lake resources in a project and location.
     * </pre>
     */
    public void listLakes(com.google.cloud.dataplex.v1.ListLakesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListLakesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLakesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a lake resource.
     * </pre>
     */
    public void getLake(com.google.cloud.dataplex.v1.GetLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Lake> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLakeMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in a lake.
     * </pre>
     */
    public void listLakeActions(com.google.cloud.dataplex.v1.ListLakeActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListLakeActionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a zone resource within a lake.
     * </pre>
     */
    public void createZone(com.google.cloud.dataplex.v1.CreateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a zone resource.
     * </pre>
     */
    public void updateZone(com.google.cloud.dataplex.v1.UpdateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a zone resource. All assets within a zone must be deleted before
     * the zone can be deleted.
     * </pre>
     */
    public void deleteZone(com.google.cloud.dataplex.v1.DeleteZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists zone resources in a lake.
     * </pre>
     */
    public void listZones(com.google.cloud.dataplex.v1.ListZonesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListZonesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListZonesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a zone resource.
     * </pre>
     */
    public void getZone(com.google.cloud.dataplex.v1.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Zone> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetZoneMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in a zone.
     * </pre>
     */
    public void listZoneActions(com.google.cloud.dataplex.v1.ListZoneActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListZoneActionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an asset resource.
     * </pre>
     */
    public void createAsset(com.google.cloud.dataplex.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an asset resource.
     * </pre>
     */
    public void updateAsset(com.google.cloud.dataplex.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an asset resource. The referenced storage resource is detached
     * (default) or deleted based on the associated Lifecycle policy.
     * </pre>
     */
    public void deleteAsset(com.google.cloud.dataplex.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists asset resources in a zone.
     * </pre>
     */
    public void listAssets(com.google.cloud.dataplex.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves an asset resource.
     * </pre>
     */
    public void getAsset(com.google.cloud.dataplex.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Asset> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAssetMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in an asset.
     * </pre>
     */
    public void listAssetActions(com.google.cloud.dataplex.v1.ListAssetActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetActionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a task resource within a lake.
     * </pre>
     */
    public void createTask(com.google.cloud.dataplex.v1.CreateTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update the task resource.
     * </pre>
     */
    public void updateTask(com.google.cloud.dataplex.v1.UpdateTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete the task resource.
     * </pre>
     */
    public void deleteTask(com.google.cloud.dataplex.v1.DeleteTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists tasks under the given lake.
     * </pre>
     */
    public void listTasks(com.google.cloud.dataplex.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListTasksResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTasksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get task resource.
     * </pre>
     */
    public void getTask(com.google.cloud.dataplex.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Task> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTaskMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Jobs under the given task.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataplex.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get job resource.
     * </pre>
     */
    public void getJob(com.google.cloud.dataplex.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancel jobs running for the task resource.
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataplex.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create an environment resource.
     * </pre>
     */
    public void createEnvironment(com.google.cloud.dataplex.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update the environment resource.
     * </pre>
     */
    public void updateEnvironment(com.google.cloud.dataplex.v1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete the environment resource. All the child resources must have been
     * deleted before environment deletion can be initiated.
     * </pre>
     */
    public void deleteEnvironment(com.google.cloud.dataplex.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists environments under the given lake.
     * </pre>
     */
    public void listEnvironments(com.google.cloud.dataplex.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEnvironmentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get environment resource.
     * </pre>
     */
    public void getEnvironment(com.google.cloud.dataplex.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Environment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEnvironmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists session resources in an environment.
     * </pre>
     */
    public void listSessions(com.google.cloud.dataplex.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListSessionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSessionsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateLakeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateLakeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_LAKE)))
          .addMethod(
            getUpdateLakeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateLakeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_LAKE)))
          .addMethod(
            getDeleteLakeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteLakeRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_LAKE)))
          .addMethod(
            getListLakesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListLakesRequest,
                com.google.cloud.dataplex.v1.ListLakesResponse>(
                  this, METHODID_LIST_LAKES)))
          .addMethod(
            getGetLakeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetLakeRequest,
                com.google.cloud.dataplex.v1.Lake>(
                  this, METHODID_GET_LAKE)))
          .addMethod(
            getListLakeActionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListLakeActionsRequest,
                com.google.cloud.dataplex.v1.ListActionsResponse>(
                  this, METHODID_LIST_LAKE_ACTIONS)))
          .addMethod(
            getCreateZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateZoneRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ZONE)))
          .addMethod(
            getUpdateZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateZoneRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ZONE)))
          .addMethod(
            getDeleteZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteZoneRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ZONE)))
          .addMethod(
            getListZonesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListZonesRequest,
                com.google.cloud.dataplex.v1.ListZonesResponse>(
                  this, METHODID_LIST_ZONES)))
          .addMethod(
            getGetZoneMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetZoneRequest,
                com.google.cloud.dataplex.v1.Zone>(
                  this, METHODID_GET_ZONE)))
          .addMethod(
            getListZoneActionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListZoneActionsRequest,
                com.google.cloud.dataplex.v1.ListActionsResponse>(
                  this, METHODID_LIST_ZONE_ACTIONS)))
          .addMethod(
            getCreateAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateAssetRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ASSET)))
          .addMethod(
            getUpdateAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateAssetRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ASSET)))
          .addMethod(
            getDeleteAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteAssetRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ASSET)))
          .addMethod(
            getListAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListAssetsRequest,
                com.google.cloud.dataplex.v1.ListAssetsResponse>(
                  this, METHODID_LIST_ASSETS)))
          .addMethod(
            getGetAssetMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetAssetRequest,
                com.google.cloud.dataplex.v1.Asset>(
                  this, METHODID_GET_ASSET)))
          .addMethod(
            getListAssetActionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListAssetActionsRequest,
                com.google.cloud.dataplex.v1.ListActionsResponse>(
                  this, METHODID_LIST_ASSET_ACTIONS)))
          .addMethod(
            getCreateTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateTaskRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_TASK)))
          .addMethod(
            getUpdateTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateTaskRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_TASK)))
          .addMethod(
            getDeleteTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteTaskRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TASK)))
          .addMethod(
            getListTasksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListTasksRequest,
                com.google.cloud.dataplex.v1.ListTasksResponse>(
                  this, METHODID_LIST_TASKS)))
          .addMethod(
            getGetTaskMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetTaskRequest,
                com.google.cloud.dataplex.v1.Task>(
                  this, METHODID_GET_TASK)))
          .addMethod(
            getListJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListJobsRequest,
                com.google.cloud.dataplex.v1.ListJobsResponse>(
                  this, METHODID_LIST_JOBS)))
          .addMethod(
            getGetJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetJobRequest,
                com.google.cloud.dataplex.v1.Job>(
                  this, METHODID_GET_JOB)))
          .addMethod(
            getCancelJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CancelJobRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CANCEL_JOB)))
          .addMethod(
            getCreateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.CreateEnvironmentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ENVIRONMENT)))
          .addMethod(
            getUpdateEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.UpdateEnvironmentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ENVIRONMENT)))
          .addMethod(
            getDeleteEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.DeleteEnvironmentRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ENVIRONMENT)))
          .addMethod(
            getListEnvironmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListEnvironmentsRequest,
                com.google.cloud.dataplex.v1.ListEnvironmentsResponse>(
                  this, METHODID_LIST_ENVIRONMENTS)))
          .addMethod(
            getGetEnvironmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.GetEnvironmentRequest,
                com.google.cloud.dataplex.v1.Environment>(
                  this, METHODID_GET_ENVIRONMENT)))
          .addMethod(
            getListSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.dataplex.v1.ListSessionsRequest,
                com.google.cloud.dataplex.v1.ListSessionsResponse>(
                  this, METHODID_LIST_SESSIONS)))
          .build();
    }
  }

  /**
   * <pre>
   * Dataplex service provides data lakes as a service. The primary resources
   * offered by this service are Lakes, Zones and Assets which collectively allow
   * a data administrator to organize, manage, secure and catalog data across
   * their organization located across cloud projects in a variety of storage
   * systems including Cloud Storage and BigQuery.
   * </pre>
   */
  public static final class DataplexServiceStub extends io.grpc.stub.AbstractAsyncStub<DataplexServiceStub> {
    private DataplexServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataplexServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataplexServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a lake resource.
     * </pre>
     */
    public void createLake(com.google.cloud.dataplex.v1.CreateLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLakeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a lake resource.
     * </pre>
     */
    public void updateLake(com.google.cloud.dataplex.v1.UpdateLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLakeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a lake resource. All zones within the lake must be deleted before
     * the lake can be deleted.
     * </pre>
     */
    public void deleteLake(com.google.cloud.dataplex.v1.DeleteLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteLakeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists lake resources in a project and location.
     * </pre>
     */
    public void listLakes(com.google.cloud.dataplex.v1.ListLakesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListLakesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLakesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a lake resource.
     * </pre>
     */
    public void getLake(com.google.cloud.dataplex.v1.GetLakeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Lake> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLakeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in a lake.
     * </pre>
     */
    public void listLakeActions(com.google.cloud.dataplex.v1.ListLakeActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLakeActionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a zone resource within a lake.
     * </pre>
     */
    public void createZone(com.google.cloud.dataplex.v1.CreateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a zone resource.
     * </pre>
     */
    public void updateZone(com.google.cloud.dataplex.v1.UpdateZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a zone resource. All assets within a zone must be deleted before
     * the zone can be deleted.
     * </pre>
     */
    public void deleteZone(com.google.cloud.dataplex.v1.DeleteZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists zone resources in a lake.
     * </pre>
     */
    public void listZones(com.google.cloud.dataplex.v1.ListZonesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListZonesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a zone resource.
     * </pre>
     */
    public void getZone(com.google.cloud.dataplex.v1.GetZoneRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Zone> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in a zone.
     * </pre>
     */
    public void listZoneActions(com.google.cloud.dataplex.v1.ListZoneActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListZoneActionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an asset resource.
     * </pre>
     */
    public void createAsset(com.google.cloud.dataplex.v1.CreateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an asset resource.
     * </pre>
     */
    public void updateAsset(com.google.cloud.dataplex.v1.UpdateAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an asset resource. The referenced storage resource is detached
     * (default) or deleted based on the associated Lifecycle policy.
     * </pre>
     */
    public void deleteAsset(com.google.cloud.dataplex.v1.DeleteAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists asset resources in a zone.
     * </pre>
     */
    public void listAssets(com.google.cloud.dataplex.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves an asset resource.
     * </pre>
     */
    public void getAsset(com.google.cloud.dataplex.v1.GetAssetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Asset> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists action resources in an asset.
     * </pre>
     */
    public void listAssetActions(com.google.cloud.dataplex.v1.ListAssetActionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetActionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a task resource within a lake.
     * </pre>
     */
    public void createTask(com.google.cloud.dataplex.v1.CreateTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update the task resource.
     * </pre>
     */
    public void updateTask(com.google.cloud.dataplex.v1.UpdateTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete the task resource.
     * </pre>
     */
    public void deleteTask(com.google.cloud.dataplex.v1.DeleteTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists tasks under the given lake.
     * </pre>
     */
    public void listTasks(com.google.cloud.dataplex.v1.ListTasksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListTasksResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get task resource.
     * </pre>
     */
    public void getTask(com.google.cloud.dataplex.v1.GetTaskRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Task> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Jobs under the given task.
     * </pre>
     */
    public void listJobs(com.google.cloud.dataplex.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get job resource.
     * </pre>
     */
    public void getJob(com.google.cloud.dataplex.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancel jobs running for the task resource.
     * </pre>
     */
    public void cancelJob(com.google.cloud.dataplex.v1.CancelJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create an environment resource.
     * </pre>
     */
    public void createEnvironment(com.google.cloud.dataplex.v1.CreateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update the environment resource.
     * </pre>
     */
    public void updateEnvironment(com.google.cloud.dataplex.v1.UpdateEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete the environment resource. All the child resources must have been
     * deleted before environment deletion can be initiated.
     * </pre>
     */
    public void deleteEnvironment(com.google.cloud.dataplex.v1.DeleteEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists environments under the given lake.
     * </pre>
     */
    public void listEnvironments(com.google.cloud.dataplex.v1.ListEnvironmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEnvironmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get environment resource.
     * </pre>
     */
    public void getEnvironment(com.google.cloud.dataplex.v1.GetEnvironmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Environment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists session resources in an environment.
     * </pre>
     */
    public void listSessions(com.google.cloud.dataplex.v1.ListSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListSessionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Dataplex service provides data lakes as a service. The primary resources
   * offered by this service are Lakes, Zones and Assets which collectively allow
   * a data administrator to organize, manage, secure and catalog data across
   * their organization located across cloud projects in a variety of storage
   * systems including Cloud Storage and BigQuery.
   * </pre>
   */
  public static final class DataplexServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<DataplexServiceBlockingStub> {
    private DataplexServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataplexServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataplexServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a lake resource.
     * </pre>
     */
    public com.google.longrunning.Operation createLake(com.google.cloud.dataplex.v1.CreateLakeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLakeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a lake resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateLake(com.google.cloud.dataplex.v1.UpdateLakeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLakeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a lake resource. All zones within the lake must be deleted before
     * the lake can be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteLake(com.google.cloud.dataplex.v1.DeleteLakeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteLakeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists lake resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListLakesResponse listLakes(com.google.cloud.dataplex.v1.ListLakesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLakesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a lake resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Lake getLake(com.google.cloud.dataplex.v1.GetLakeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLakeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists action resources in a lake.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListActionsResponse listLakeActions(com.google.cloud.dataplex.v1.ListLakeActionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLakeActionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a zone resource within a lake.
     * </pre>
     */
    public com.google.longrunning.Operation createZone(com.google.cloud.dataplex.v1.CreateZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a zone resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateZone(com.google.cloud.dataplex.v1.UpdateZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a zone resource. All assets within a zone must be deleted before
     * the zone can be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteZone(com.google.cloud.dataplex.v1.DeleteZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists zone resources in a lake.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListZonesResponse listZones(com.google.cloud.dataplex.v1.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListZonesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a zone resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Zone getZone(com.google.cloud.dataplex.v1.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetZoneMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists action resources in a zone.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListActionsResponse listZoneActions(com.google.cloud.dataplex.v1.ListZoneActionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListZoneActionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an asset resource.
     * </pre>
     */
    public com.google.longrunning.Operation createAsset(com.google.cloud.dataplex.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an asset resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateAsset(com.google.cloud.dataplex.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an asset resource. The referenced storage resource is detached
     * (default) or deleted based on the associated Lifecycle policy.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAsset(com.google.cloud.dataplex.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists asset resources in a zone.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListAssetsResponse listAssets(com.google.cloud.dataplex.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves an asset resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Asset getAsset(com.google.cloud.dataplex.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAssetMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists action resources in an asset.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListActionsResponse listAssetActions(com.google.cloud.dataplex.v1.ListAssetActionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetActionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a task resource within a lake.
     * </pre>
     */
    public com.google.longrunning.Operation createTask(com.google.cloud.dataplex.v1.CreateTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update the task resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateTask(com.google.cloud.dataplex.v1.UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete the task resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTask(com.google.cloud.dataplex.v1.DeleteTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists tasks under the given lake.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListTasksResponse listTasks(com.google.cloud.dataplex.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTasksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get task resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Task getTask(com.google.cloud.dataplex.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTaskMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Jobs under the given task.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListJobsResponse listJobs(com.google.cloud.dataplex.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get job resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Job getJob(com.google.cloud.dataplex.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel jobs running for the task resource.
     * </pre>
     */
    public com.google.protobuf.Empty cancelJob(com.google.cloud.dataplex.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create an environment resource.
     * </pre>
     */
    public com.google.longrunning.Operation createEnvironment(com.google.cloud.dataplex.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update the environment resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateEnvironment(com.google.cloud.dataplex.v1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete the environment resource. All the child resources must have been
     * deleted before environment deletion can be initiated.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEnvironment(com.google.cloud.dataplex.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists environments under the given lake.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEnvironmentsResponse listEnvironments(com.google.cloud.dataplex.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnvironmentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get environment resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.Environment getEnvironment(com.google.cloud.dataplex.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnvironmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists session resources in an environment.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListSessionsResponse listSessions(com.google.cloud.dataplex.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSessionsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Dataplex service provides data lakes as a service. The primary resources
   * offered by this service are Lakes, Zones and Assets which collectively allow
   * a data administrator to organize, manage, secure and catalog data across
   * their organization located across cloud projects in a variety of storage
   * systems including Cloud Storage and BigQuery.
   * </pre>
   */
  public static final class DataplexServiceFutureStub extends io.grpc.stub.AbstractFutureStub<DataplexServiceFutureStub> {
    private DataplexServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataplexServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataplexServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a lake resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createLake(
        com.google.cloud.dataplex.v1.CreateLakeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLakeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a lake resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateLake(
        com.google.cloud.dataplex.v1.UpdateLakeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLakeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a lake resource. All zones within the lake must be deleted before
     * the lake can be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteLake(
        com.google.cloud.dataplex.v1.DeleteLakeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteLakeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists lake resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListLakesResponse> listLakes(
        com.google.cloud.dataplex.v1.ListLakesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLakesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a lake resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Lake> getLake(
        com.google.cloud.dataplex.v1.GetLakeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLakeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists action resources in a lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListActionsResponse> listLakeActions(
        com.google.cloud.dataplex.v1.ListLakeActionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLakeActionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a zone resource within a lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createZone(
        com.google.cloud.dataplex.v1.CreateZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a zone resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateZone(
        com.google.cloud.dataplex.v1.UpdateZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a zone resource. All assets within a zone must be deleted before
     * the zone can be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteZone(
        com.google.cloud.dataplex.v1.DeleteZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists zone resources in a lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListZonesResponse> listZones(
        com.google.cloud.dataplex.v1.ListZonesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListZonesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a zone resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Zone> getZone(
        com.google.cloud.dataplex.v1.GetZoneRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetZoneMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists action resources in a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListActionsResponse> listZoneActions(
        com.google.cloud.dataplex.v1.ListZoneActionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListZoneActionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an asset resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAsset(
        com.google.cloud.dataplex.v1.CreateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an asset resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAsset(
        com.google.cloud.dataplex.v1.UpdateAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an asset resource. The referenced storage resource is detached
     * (default) or deleted based on the associated Lifecycle policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAsset(
        com.google.cloud.dataplex.v1.DeleteAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists asset resources in a zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListAssetsResponse> listAssets(
        com.google.cloud.dataplex.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves an asset resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Asset> getAsset(
        com.google.cloud.dataplex.v1.GetAssetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAssetMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists action resources in an asset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListActionsResponse> listAssetActions(
        com.google.cloud.dataplex.v1.ListAssetActionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetActionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a task resource within a lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createTask(
        com.google.cloud.dataplex.v1.CreateTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update the task resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateTask(
        com.google.cloud.dataplex.v1.UpdateTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete the task resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTask(
        com.google.cloud.dataplex.v1.DeleteTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists tasks under the given lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListTasksResponse> listTasks(
        com.google.cloud.dataplex.v1.ListTasksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTasksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get task resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Task> getTask(
        com.google.cloud.dataplex.v1.GetTaskRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTaskMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Jobs under the given task.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListJobsResponse> listJobs(
        com.google.cloud.dataplex.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get job resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Job> getJob(
        com.google.cloud.dataplex.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancel jobs running for the task resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancelJob(
        com.google.cloud.dataplex.v1.CancelJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create an environment resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createEnvironment(
        com.google.cloud.dataplex.v1.CreateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update the environment resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateEnvironment(
        com.google.cloud.dataplex.v1.UpdateEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete the environment resource. All the child resources must have been
     * deleted before environment deletion can be initiated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteEnvironment(
        com.google.cloud.dataplex.v1.DeleteEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists environments under the given lake.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListEnvironmentsResponse> listEnvironments(
        com.google.cloud.dataplex.v1.ListEnvironmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnvironmentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get environment resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.Environment> getEnvironment(
        com.google.cloud.dataplex.v1.GetEnvironmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnvironmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists session resources in an environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.dataplex.v1.ListSessionsResponse> listSessions(
        com.google.cloud.dataplex.v1.ListSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSessionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_LAKE = 0;
  private static final int METHODID_UPDATE_LAKE = 1;
  private static final int METHODID_DELETE_LAKE = 2;
  private static final int METHODID_LIST_LAKES = 3;
  private static final int METHODID_GET_LAKE = 4;
  private static final int METHODID_LIST_LAKE_ACTIONS = 5;
  private static final int METHODID_CREATE_ZONE = 6;
  private static final int METHODID_UPDATE_ZONE = 7;
  private static final int METHODID_DELETE_ZONE = 8;
  private static final int METHODID_LIST_ZONES = 9;
  private static final int METHODID_GET_ZONE = 10;
  private static final int METHODID_LIST_ZONE_ACTIONS = 11;
  private static final int METHODID_CREATE_ASSET = 12;
  private static final int METHODID_UPDATE_ASSET = 13;
  private static final int METHODID_DELETE_ASSET = 14;
  private static final int METHODID_LIST_ASSETS = 15;
  private static final int METHODID_GET_ASSET = 16;
  private static final int METHODID_LIST_ASSET_ACTIONS = 17;
  private static final int METHODID_CREATE_TASK = 18;
  private static final int METHODID_UPDATE_TASK = 19;
  private static final int METHODID_DELETE_TASK = 20;
  private static final int METHODID_LIST_TASKS = 21;
  private static final int METHODID_GET_TASK = 22;
  private static final int METHODID_LIST_JOBS = 23;
  private static final int METHODID_GET_JOB = 24;
  private static final int METHODID_CANCEL_JOB = 25;
  private static final int METHODID_CREATE_ENVIRONMENT = 26;
  private static final int METHODID_UPDATE_ENVIRONMENT = 27;
  private static final int METHODID_DELETE_ENVIRONMENT = 28;
  private static final int METHODID_LIST_ENVIRONMENTS = 29;
  private static final int METHODID_GET_ENVIRONMENT = 30;
  private static final int METHODID_LIST_SESSIONS = 31;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataplexServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataplexServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_LAKE:
          serviceImpl.createLake((com.google.cloud.dataplex.v1.CreateLakeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_LAKE:
          serviceImpl.updateLake((com.google.cloud.dataplex.v1.UpdateLakeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_LAKE:
          serviceImpl.deleteLake((com.google.cloud.dataplex.v1.DeleteLakeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_LAKES:
          serviceImpl.listLakes((com.google.cloud.dataplex.v1.ListLakesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListLakesResponse>) responseObserver);
          break;
        case METHODID_GET_LAKE:
          serviceImpl.getLake((com.google.cloud.dataplex.v1.GetLakeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Lake>) responseObserver);
          break;
        case METHODID_LIST_LAKE_ACTIONS:
          serviceImpl.listLakeActions((com.google.cloud.dataplex.v1.ListLakeActionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_ZONE:
          serviceImpl.createZone((com.google.cloud.dataplex.v1.CreateZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ZONE:
          serviceImpl.updateZone((com.google.cloud.dataplex.v1.UpdateZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ZONE:
          serviceImpl.deleteZone((com.google.cloud.dataplex.v1.DeleteZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ZONES:
          serviceImpl.listZones((com.google.cloud.dataplex.v1.ListZonesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListZonesResponse>) responseObserver);
          break;
        case METHODID_GET_ZONE:
          serviceImpl.getZone((com.google.cloud.dataplex.v1.GetZoneRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Zone>) responseObserver);
          break;
        case METHODID_LIST_ZONE_ACTIONS:
          serviceImpl.listZoneActions((com.google.cloud.dataplex.v1.ListZoneActionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_ASSET:
          serviceImpl.createAsset((com.google.cloud.dataplex.v1.CreateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ASSET:
          serviceImpl.updateAsset((com.google.cloud.dataplex.v1.UpdateAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ASSET:
          serviceImpl.deleteAsset((com.google.cloud.dataplex.v1.DeleteAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets((com.google.cloud.dataplex.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListAssetsResponse>) responseObserver);
          break;
        case METHODID_GET_ASSET:
          serviceImpl.getAsset((com.google.cloud.dataplex.v1.GetAssetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Asset>) responseObserver);
          break;
        case METHODID_LIST_ASSET_ACTIONS:
          serviceImpl.listAssetActions((com.google.cloud.dataplex.v1.ListAssetActionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListActionsResponse>) responseObserver);
          break;
        case METHODID_CREATE_TASK:
          serviceImpl.createTask((com.google.cloud.dataplex.v1.CreateTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TASK:
          serviceImpl.updateTask((com.google.cloud.dataplex.v1.UpdateTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TASK:
          serviceImpl.deleteTask((com.google.cloud.dataplex.v1.DeleteTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TASKS:
          serviceImpl.listTasks((com.google.cloud.dataplex.v1.ListTasksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListTasksResponse>) responseObserver);
          break;
        case METHODID_GET_TASK:
          serviceImpl.getTask((com.google.cloud.dataplex.v1.GetTaskRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Task>) responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs((com.google.cloud.dataplex.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListJobsResponse>) responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob((com.google.cloud.dataplex.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Job>) responseObserver);
          break;
        case METHODID_CANCEL_JOB:
          serviceImpl.cancelJob((com.google.cloud.dataplex.v1.CancelJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ENVIRONMENT:
          serviceImpl.createEnvironment((com.google.cloud.dataplex.v1.CreateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENVIRONMENT:
          serviceImpl.updateEnvironment((com.google.cloud.dataplex.v1.UpdateEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENVIRONMENT:
          serviceImpl.deleteEnvironment((com.google.cloud.dataplex.v1.DeleteEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENVIRONMENTS:
          serviceImpl.listEnvironments((com.google.cloud.dataplex.v1.ListEnvironmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEnvironmentsResponse>) responseObserver);
          break;
        case METHODID_GET_ENVIRONMENT:
          serviceImpl.getEnvironment((com.google.cloud.dataplex.v1.GetEnvironmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.Environment>) responseObserver);
          break;
        case METHODID_LIST_SESSIONS:
          serviceImpl.listSessions((com.google.cloud.dataplex.v1.ListSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListSessionsResponse>) responseObserver);
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

  private static abstract class DataplexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataplexServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataplexService");
    }
  }

  private static final class DataplexServiceFileDescriptorSupplier
      extends DataplexServiceBaseDescriptorSupplier {
    DataplexServiceFileDescriptorSupplier() {}
  }

  private static final class DataplexServiceMethodDescriptorSupplier
      extends DataplexServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataplexServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataplexServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DataplexServiceFileDescriptorSupplier())
              .addMethod(getCreateLakeMethod())
              .addMethod(getUpdateLakeMethod())
              .addMethod(getDeleteLakeMethod())
              .addMethod(getListLakesMethod())
              .addMethod(getGetLakeMethod())
              .addMethod(getListLakeActionsMethod())
              .addMethod(getCreateZoneMethod())
              .addMethod(getUpdateZoneMethod())
              .addMethod(getDeleteZoneMethod())
              .addMethod(getListZonesMethod())
              .addMethod(getGetZoneMethod())
              .addMethod(getListZoneActionsMethod())
              .addMethod(getCreateAssetMethod())
              .addMethod(getUpdateAssetMethod())
              .addMethod(getDeleteAssetMethod())
              .addMethod(getListAssetsMethod())
              .addMethod(getGetAssetMethod())
              .addMethod(getListAssetActionsMethod())
              .addMethod(getCreateTaskMethod())
              .addMethod(getUpdateTaskMethod())
              .addMethod(getDeleteTaskMethod())
              .addMethod(getListTasksMethod())
              .addMethod(getGetTaskMethod())
              .addMethod(getListJobsMethod())
              .addMethod(getGetJobMethod())
              .addMethod(getCancelJobMethod())
              .addMethod(getCreateEnvironmentMethod())
              .addMethod(getUpdateEnvironmentMethod())
              .addMethod(getDeleteEnvironmentMethod())
              .addMethod(getListEnvironmentsMethod())
              .addMethod(getGetEnvironmentMethod())
              .addMethod(getListSessionsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
