package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The service that handles CRUD and List for resources for
 * FeatureOnlineStore.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/feature_online_store_admin_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeatureOnlineStoreAdminServiceGrpc {

  private FeatureOnlineStoreAdminServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.FeatureOnlineStoreAdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getCreateFeatureOnlineStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeatureOnlineStore",
      requestType = com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getCreateFeatureOnlineStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest, com.google.longrunning.Operation> getCreateFeatureOnlineStoreMethod;
    if ((getCreateFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureOnlineStoreMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getCreateFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureOnlineStoreMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureOnlineStoreMethod = getCreateFeatureOnlineStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeatureOnlineStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("CreateFeatureOnlineStore"))
              .build();
        }
      }
    }
    return getCreateFeatureOnlineStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest,
      com.google.cloud.aiplatform.v1.FeatureOnlineStore> getGetFeatureOnlineStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeatureOnlineStore",
      requestType = com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest.class,
      responseType = com.google.cloud.aiplatform.v1.FeatureOnlineStore.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest,
      com.google.cloud.aiplatform.v1.FeatureOnlineStore> getGetFeatureOnlineStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest, com.google.cloud.aiplatform.v1.FeatureOnlineStore> getGetFeatureOnlineStoreMethod;
    if ((getGetFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureOnlineStoreMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getGetFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureOnlineStoreMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getGetFeatureOnlineStoreMethod = getGetFeatureOnlineStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest, com.google.cloud.aiplatform.v1.FeatureOnlineStore>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeatureOnlineStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.FeatureOnlineStore.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("GetFeatureOnlineStore"))
              .build();
        }
      }
    }
    return getGetFeatureOnlineStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest,
      com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> getListFeatureOnlineStoresMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatureOnlineStores",
      requestType = com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest,
      com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> getListFeatureOnlineStoresMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest, com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> getListFeatureOnlineStoresMethod;
    if ((getListFeatureOnlineStoresMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureOnlineStoresMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getListFeatureOnlineStoresMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureOnlineStoresMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getListFeatureOnlineStoresMethod = getListFeatureOnlineStoresMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest, com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatureOnlineStores"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("ListFeatureOnlineStores"))
              .build();
        }
      }
    }
    return getListFeatureOnlineStoresMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getUpdateFeatureOnlineStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeatureOnlineStore",
      requestType = com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getUpdateFeatureOnlineStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest, com.google.longrunning.Operation> getUpdateFeatureOnlineStoreMethod;
    if ((getUpdateFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureOnlineStoreMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getUpdateFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureOnlineStoreMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureOnlineStoreMethod = getUpdateFeatureOnlineStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeatureOnlineStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("UpdateFeatureOnlineStore"))
              .build();
        }
      }
    }
    return getUpdateFeatureOnlineStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getDeleteFeatureOnlineStoreMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeatureOnlineStore",
      requestType = com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest,
      com.google.longrunning.Operation> getDeleteFeatureOnlineStoreMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest, com.google.longrunning.Operation> getDeleteFeatureOnlineStoreMethod;
    if ((getDeleteFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureOnlineStoreMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getDeleteFeatureOnlineStoreMethod = FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureOnlineStoreMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureOnlineStoreMethod = getDeleteFeatureOnlineStoreMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeatureOnlineStore"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("DeleteFeatureOnlineStore"))
              .build();
        }
      }
    }
    return getDeleteFeatureOnlineStoreMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureViewRequest,
      com.google.longrunning.Operation> getCreateFeatureViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeatureView",
      requestType = com.google.cloud.aiplatform.v1.CreateFeatureViewRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureViewRequest,
      com.google.longrunning.Operation> getCreateFeatureViewMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateFeatureViewRequest, com.google.longrunning.Operation> getCreateFeatureViewMethod;
    if ((getCreateFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureViewMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getCreateFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureViewMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getCreateFeatureViewMethod = getCreateFeatureViewMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CreateFeatureViewRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeatureView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CreateFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("CreateFeatureView"))
              .build();
        }
      }
    }
    return getCreateFeatureViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewRequest,
      com.google.cloud.aiplatform.v1.FeatureView> getGetFeatureViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeatureView",
      requestType = com.google.cloud.aiplatform.v1.GetFeatureViewRequest.class,
      responseType = com.google.cloud.aiplatform.v1.FeatureView.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewRequest,
      com.google.cloud.aiplatform.v1.FeatureView> getGetFeatureViewMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewRequest, com.google.cloud.aiplatform.v1.FeatureView> getGetFeatureViewMethod;
    if ((getGetFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getGetFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewMethod = getGetFeatureViewMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetFeatureViewRequest, com.google.cloud.aiplatform.v1.FeatureView>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeatureView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.FeatureView.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("GetFeatureView"))
              .build();
        }
      }
    }
    return getGetFeatureViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewsRequest,
      com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> getListFeatureViewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatureViews",
      requestType = com.google.cloud.aiplatform.v1.ListFeatureViewsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListFeatureViewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewsRequest,
      com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> getListFeatureViewsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewsRequest, com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> getListFeatureViewsMethod;
    if ((getListFeatureViewsMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewsMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getListFeatureViewsMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewsMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewsMethod = getListFeatureViewsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListFeatureViewsRequest, com.google.cloud.aiplatform.v1.ListFeatureViewsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatureViews"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureViewsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureViewsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("ListFeatureViews"))
              .build();
        }
      }
    }
    return getListFeatureViewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest,
      com.google.longrunning.Operation> getUpdateFeatureViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeatureView",
      requestType = com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest,
      com.google.longrunning.Operation> getUpdateFeatureViewMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest, com.google.longrunning.Operation> getUpdateFeatureViewMethod;
    if ((getUpdateFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureViewMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getUpdateFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureViewMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getUpdateFeatureViewMethod = getUpdateFeatureViewMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeatureView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("UpdateFeatureView"))
              .build();
        }
      }
    }
    return getUpdateFeatureViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest,
      com.google.longrunning.Operation> getDeleteFeatureViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeatureView",
      requestType = com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest,
      com.google.longrunning.Operation> getDeleteFeatureViewMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest, com.google.longrunning.Operation> getDeleteFeatureViewMethod;
    if ((getDeleteFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureViewMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getDeleteFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureViewMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getDeleteFeatureViewMethod = getDeleteFeatureViewMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeatureView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("DeleteFeatureView"))
              .build();
        }
      }
    }
    return getDeleteFeatureViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SyncFeatureViewRequest,
      com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> getSyncFeatureViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SyncFeatureView",
      requestType = com.google.cloud.aiplatform.v1.SyncFeatureViewRequest.class,
      responseType = com.google.cloud.aiplatform.v1.SyncFeatureViewResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SyncFeatureViewRequest,
      com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> getSyncFeatureViewMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.SyncFeatureViewRequest, com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> getSyncFeatureViewMethod;
    if ((getSyncFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getSyncFeatureViewMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getSyncFeatureViewMethod = FeatureOnlineStoreAdminServiceGrpc.getSyncFeatureViewMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getSyncFeatureViewMethod = getSyncFeatureViewMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.SyncFeatureViewRequest, com.google.cloud.aiplatform.v1.SyncFeatureViewResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SyncFeatureView"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.SyncFeatureViewRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.SyncFeatureViewResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("SyncFeatureView"))
              .build();
        }
      }
    }
    return getSyncFeatureViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest,
      com.google.cloud.aiplatform.v1.FeatureViewSync> getGetFeatureViewSyncMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeatureViewSync",
      requestType = com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest.class,
      responseType = com.google.cloud.aiplatform.v1.FeatureViewSync.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest,
      com.google.cloud.aiplatform.v1.FeatureViewSync> getGetFeatureViewSyncMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest, com.google.cloud.aiplatform.v1.FeatureViewSync> getGetFeatureViewSyncMethod;
    if ((getGetFeatureViewSyncMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewSyncMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getGetFeatureViewSyncMethod = FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewSyncMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getGetFeatureViewSyncMethod = getGetFeatureViewSyncMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest, com.google.cloud.aiplatform.v1.FeatureViewSync>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeatureViewSync"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.FeatureViewSync.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("GetFeatureViewSync"))
              .build();
        }
      }
    }
    return getGetFeatureViewSyncMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest,
      com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> getListFeatureViewSyncsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatureViewSyncs",
      requestType = com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest,
      com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> getListFeatureViewSyncsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest, com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> getListFeatureViewSyncsMethod;
    if ((getListFeatureViewSyncsMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewSyncsMethod) == null) {
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        if ((getListFeatureViewSyncsMethod = FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewSyncsMethod) == null) {
          FeatureOnlineStoreAdminServiceGrpc.getListFeatureViewSyncsMethod = getListFeatureViewSyncsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest, com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatureViewSyncs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceMethodDescriptorSupplier("ListFeatureViewSyncs"))
              .build();
        }
      }
    }
    return getListFeatureViewSyncsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FeatureOnlineStoreAdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceStub>() {
        @java.lang.Override
        public FeatureOnlineStoreAdminServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureOnlineStoreAdminServiceStub(channel, callOptions);
        }
      };
    return FeatureOnlineStoreAdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeatureOnlineStoreAdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceBlockingStub>() {
        @java.lang.Override
        public FeatureOnlineStoreAdminServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureOnlineStoreAdminServiceBlockingStub(channel, callOptions);
        }
      };
    return FeatureOnlineStoreAdminServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FeatureOnlineStoreAdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FeatureOnlineStoreAdminServiceFutureStub>() {
        @java.lang.Override
        public FeatureOnlineStoreAdminServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FeatureOnlineStoreAdminServiceFutureStub(channel, callOptions);
        }
      };
    return FeatureOnlineStoreAdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureOnlineStore.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Creates a new FeatureOnlineStore in a given project and location.
     * </pre>
     */
    default void createFeatureOnlineStore(com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeatureOnlineStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureOnlineStore.
     * </pre>
     */
    default void getFeatureOnlineStore(com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureOnlineStore> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureOnlineStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureOnlineStores in a given project and location.
     * </pre>
     */
    default void listFeatureOnlineStores(com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeatureOnlineStoresMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureOnlineStore.
     * </pre>
     */
    default void updateFeatureOnlineStore(com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeatureOnlineStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not
     * contain any FeatureViews.
     * </pre>
     */
    default void deleteFeatureOnlineStore(com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeatureOnlineStoreMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new FeatureView in a given FeatureOnlineStore.
     * </pre>
     */
    default void createFeatureView(com.google.cloud.aiplatform.v1.CreateFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFeatureViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureView.
     * </pre>
     */
    default void getFeatureView(com.google.cloud.aiplatform.v1.GetFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureView> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureViews in a given FeatureOnlineStore.
     * </pre>
     */
    default void listFeatureViews(com.google.cloud.aiplatform.v1.ListFeatureViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeatureViewsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureView.
     * </pre>
     */
    default void updateFeatureView(com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFeatureViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single FeatureView.
     * </pre>
     */
    default void deleteFeatureView(com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFeatureViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Triggers on-demand sync for the FeatureView.
     * </pre>
     */
    default void syncFeatureView(com.google.cloud.aiplatform.v1.SyncFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSyncFeatureViewMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureViewSync.
     * </pre>
     */
    default void getFeatureViewSync(com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureViewSync> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureViewSyncMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureViewSyncs in a given FeatureView.
     * </pre>
     */
    default void listFeatureViewSyncs(com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFeatureViewSyncsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeatureOnlineStoreAdminService.
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureOnlineStore.
   * </pre>
   */
  public static abstract class FeatureOnlineStoreAdminServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FeatureOnlineStoreAdminServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeatureOnlineStoreAdminService.
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureOnlineStore.
   * </pre>
   */
  public static final class FeatureOnlineStoreAdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeatureOnlineStoreAdminServiceStub> {
    private FeatureOnlineStoreAdminServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreAdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreAdminServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new FeatureOnlineStore in a given project and location.
     * </pre>
     */
    public void createFeatureOnlineStore(com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureOnlineStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureOnlineStore.
     * </pre>
     */
    public void getFeatureOnlineStore(com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureOnlineStore> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureOnlineStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureOnlineStores in a given project and location.
     * </pre>
     */
    public void listFeatureOnlineStores(com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeatureOnlineStoresMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureOnlineStore.
     * </pre>
     */
    public void updateFeatureOnlineStore(com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureOnlineStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not
     * contain any FeatureViews.
     * </pre>
     */
    public void deleteFeatureOnlineStore(com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureOnlineStoreMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new FeatureView in a given FeatureOnlineStore.
     * </pre>
     */
    public void createFeatureView(com.google.cloud.aiplatform.v1.CreateFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureView.
     * </pre>
     */
    public void getFeatureView(com.google.cloud.aiplatform.v1.GetFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureView> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureViews in a given FeatureOnlineStore.
     * </pre>
     */
    public void listFeatureViews(com.google.cloud.aiplatform.v1.ListFeatureViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeatureViewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureView.
     * </pre>
     */
    public void updateFeatureView(com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single FeatureView.
     * </pre>
     */
    public void deleteFeatureView(com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Triggers on-demand sync for the FeatureView.
     * </pre>
     */
    public void syncFeatureView(com.google.cloud.aiplatform.v1.SyncFeatureViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSyncFeatureViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single FeatureViewSync.
     * </pre>
     */
    public void getFeatureViewSync(com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureViewSync> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureViewSyncMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists FeatureViewSyncs in a given FeatureView.
     * </pre>
     */
    public void listFeatureViewSyncs(com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeatureViewSyncsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeatureOnlineStoreAdminService.
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureOnlineStore.
   * </pre>
   */
  public static final class FeatureOnlineStoreAdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeatureOnlineStoreAdminServiceBlockingStub> {
    private FeatureOnlineStoreAdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreAdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreAdminServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new FeatureOnlineStore in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFeatureOnlineStore(com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureOnlineStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureOnlineStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.FeatureOnlineStore getFeatureOnlineStore(com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureOnlineStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists FeatureOnlineStores in a given project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse listFeatureOnlineStores(com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeatureOnlineStoresMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureOnlineStore.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeatureOnlineStore(com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureOnlineStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not
     * contain any FeatureViews.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeatureOnlineStore(com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureOnlineStoreMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new FeatureView in a given FeatureOnlineStore.
     * </pre>
     */
    public com.google.longrunning.Operation createFeatureView(com.google.cloud.aiplatform.v1.CreateFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureView.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.FeatureView getFeatureView(com.google.cloud.aiplatform.v1.GetFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists FeatureViews in a given FeatureOnlineStore.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListFeatureViewsResponse listFeatureViews(com.google.cloud.aiplatform.v1.ListFeatureViewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeatureViewsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureView.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeatureView(com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single FeatureView.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeatureView(com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Triggers on-demand sync for the FeatureView.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.SyncFeatureViewResponse syncFeatureView(com.google.cloud.aiplatform.v1.SyncFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSyncFeatureViewMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureViewSync.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.FeatureViewSync getFeatureViewSync(com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureViewSyncMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists FeatureViewSyncs in a given FeatureView.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse listFeatureViewSyncs(com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeatureViewSyncsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FeatureOnlineStoreAdminService.
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureOnlineStore.
   * </pre>
   */
  public static final class FeatureOnlineStoreAdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeatureOnlineStoreAdminServiceFutureStub> {
    private FeatureOnlineStoreAdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureOnlineStoreAdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureOnlineStoreAdminServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a new FeatureOnlineStore in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFeatureOnlineStore(
        com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureOnlineStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureOnlineStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.FeatureOnlineStore> getFeatureOnlineStore(
        com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureOnlineStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists FeatureOnlineStores in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse> listFeatureOnlineStores(
        com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeatureOnlineStoresMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureOnlineStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFeatureOnlineStore(
        com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureOnlineStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single FeatureOnlineStore. The FeatureOnlineStore must not
     * contain any FeatureViews.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFeatureOnlineStore(
        com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureOnlineStoreMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new FeatureView in a given FeatureOnlineStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createFeatureView(
        com.google.cloud.aiplatform.v1.CreateFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.FeatureView> getFeatureView(
        com.google.cloud.aiplatform.v1.GetFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists FeatureViews in a given FeatureOnlineStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListFeatureViewsResponse> listFeatureViews(
        com.google.cloud.aiplatform.v1.ListFeatureViewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeatureViewsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateFeatureView(
        com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteFeatureView(
        com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Triggers on-demand sync for the FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.SyncFeatureViewResponse> syncFeatureView(
        com.google.cloud.aiplatform.v1.SyncFeatureViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSyncFeatureViewMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single FeatureViewSync.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.FeatureViewSync> getFeatureViewSync(
        com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureViewSyncMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists FeatureViewSyncs in a given FeatureView.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse> listFeatureViewSyncs(
        com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeatureViewSyncsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FEATURE_ONLINE_STORE = 0;
  private static final int METHODID_GET_FEATURE_ONLINE_STORE = 1;
  private static final int METHODID_LIST_FEATURE_ONLINE_STORES = 2;
  private static final int METHODID_UPDATE_FEATURE_ONLINE_STORE = 3;
  private static final int METHODID_DELETE_FEATURE_ONLINE_STORE = 4;
  private static final int METHODID_CREATE_FEATURE_VIEW = 5;
  private static final int METHODID_GET_FEATURE_VIEW = 6;
  private static final int METHODID_LIST_FEATURE_VIEWS = 7;
  private static final int METHODID_UPDATE_FEATURE_VIEW = 8;
  private static final int METHODID_DELETE_FEATURE_VIEW = 9;
  private static final int METHODID_SYNC_FEATURE_VIEW = 10;
  private static final int METHODID_GET_FEATURE_VIEW_SYNC = 11;
  private static final int METHODID_LIST_FEATURE_VIEW_SYNCS = 12;

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
        case METHODID_CREATE_FEATURE_ONLINE_STORE:
          serviceImpl.createFeatureOnlineStore((com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURE_ONLINE_STORE:
          serviceImpl.getFeatureOnlineStore((com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureOnlineStore>) responseObserver);
          break;
        case METHODID_LIST_FEATURE_ONLINE_STORES:
          serviceImpl.listFeatureOnlineStores((com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FEATURE_ONLINE_STORE:
          serviceImpl.updateFeatureOnlineStore((com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE_ONLINE_STORE:
          serviceImpl.deleteFeatureOnlineStore((com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE_VIEW:
          serviceImpl.createFeatureView((com.google.cloud.aiplatform.v1.CreateFeatureViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURE_VIEW:
          serviceImpl.getFeatureView((com.google.cloud.aiplatform.v1.GetFeatureViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureView>) responseObserver);
          break;
        case METHODID_LIST_FEATURE_VIEWS:
          serviceImpl.listFeatureViews((com.google.cloud.aiplatform.v1.ListFeatureViewsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_FEATURE_VIEW:
          serviceImpl.updateFeatureView((com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE_VIEW:
          serviceImpl.deleteFeatureView((com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SYNC_FEATURE_VIEW:
          serviceImpl.syncFeatureView((com.google.cloud.aiplatform.v1.SyncFeatureViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.SyncFeatureViewResponse>) responseObserver);
          break;
        case METHODID_GET_FEATURE_VIEW_SYNC:
          serviceImpl.getFeatureViewSync((com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.FeatureViewSync>) responseObserver);
          break;
        case METHODID_LIST_FEATURE_VIEW_SYNCS:
          serviceImpl.listFeatureViewSyncs((com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse>) responseObserver);
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
          getCreateFeatureOnlineStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.CreateFeatureOnlineStoreRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_FEATURE_ONLINE_STORE)))
        .addMethod(
          getGetFeatureOnlineStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.GetFeatureOnlineStoreRequest,
              com.google.cloud.aiplatform.v1.FeatureOnlineStore>(
                service, METHODID_GET_FEATURE_ONLINE_STORE)))
        .addMethod(
          getListFeatureOnlineStoresMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresRequest,
              com.google.cloud.aiplatform.v1.ListFeatureOnlineStoresResponse>(
                service, METHODID_LIST_FEATURE_ONLINE_STORES)))
        .addMethod(
          getUpdateFeatureOnlineStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.UpdateFeatureOnlineStoreRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_FEATURE_ONLINE_STORE)))
        .addMethod(
          getDeleteFeatureOnlineStoreMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.DeleteFeatureOnlineStoreRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_FEATURE_ONLINE_STORE)))
        .addMethod(
          getCreateFeatureViewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.CreateFeatureViewRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_FEATURE_VIEW)))
        .addMethod(
          getGetFeatureViewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.GetFeatureViewRequest,
              com.google.cloud.aiplatform.v1.FeatureView>(
                service, METHODID_GET_FEATURE_VIEW)))
        .addMethod(
          getListFeatureViewsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.ListFeatureViewsRequest,
              com.google.cloud.aiplatform.v1.ListFeatureViewsResponse>(
                service, METHODID_LIST_FEATURE_VIEWS)))
        .addMethod(
          getUpdateFeatureViewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.UpdateFeatureViewRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_FEATURE_VIEW)))
        .addMethod(
          getDeleteFeatureViewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.DeleteFeatureViewRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_FEATURE_VIEW)))
        .addMethod(
          getSyncFeatureViewMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.SyncFeatureViewRequest,
              com.google.cloud.aiplatform.v1.SyncFeatureViewResponse>(
                service, METHODID_SYNC_FEATURE_VIEW)))
        .addMethod(
          getGetFeatureViewSyncMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.GetFeatureViewSyncRequest,
              com.google.cloud.aiplatform.v1.FeatureViewSync>(
                service, METHODID_GET_FEATURE_VIEW_SYNC)))
        .addMethod(
          getListFeatureViewSyncsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.aiplatform.v1.ListFeatureViewSyncsRequest,
              com.google.cloud.aiplatform.v1.ListFeatureViewSyncsResponse>(
                service, METHODID_LIST_FEATURE_VIEW_SYNCS)))
        .build();
  }

  private static abstract class FeatureOnlineStoreAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeatureOnlineStoreAdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.FeatureOnlineStoreAdminServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeatureOnlineStoreAdminService");
    }
  }

  private static final class FeatureOnlineStoreAdminServiceFileDescriptorSupplier
      extends FeatureOnlineStoreAdminServiceBaseDescriptorSupplier {
    FeatureOnlineStoreAdminServiceFileDescriptorSupplier() {}
  }

  private static final class FeatureOnlineStoreAdminServiceMethodDescriptorSupplier
      extends FeatureOnlineStoreAdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeatureOnlineStoreAdminServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeatureOnlineStoreAdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FeatureOnlineStoreAdminServiceFileDescriptorSupplier())
              .addMethod(getCreateFeatureOnlineStoreMethod())
              .addMethod(getGetFeatureOnlineStoreMethod())
              .addMethod(getListFeatureOnlineStoresMethod())
              .addMethod(getUpdateFeatureOnlineStoreMethod())
              .addMethod(getDeleteFeatureOnlineStoreMethod())
              .addMethod(getCreateFeatureViewMethod())
              .addMethod(getGetFeatureViewMethod())
              .addMethod(getListFeatureViewsMethod())
              .addMethod(getUpdateFeatureViewMethod())
              .addMethod(getDeleteFeatureViewMethod())
              .addMethod(getSyncFeatureViewMethod())
              .addMethod(getGetFeatureViewSyncMethod())
              .addMethod(getListFeatureViewSyncsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
