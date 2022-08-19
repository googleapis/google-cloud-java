package com.google.cloud.apigateway.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The API Gateway Service is the interface for managing API Gateways.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apigateway/v1/apigateway_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ApiGatewayServiceGrpc {

  private ApiGatewayServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.apigateway.v1.ApiGatewayService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListGatewaysRequest,
      com.google.cloud.apigateway.v1.ListGatewaysResponse> getListGatewaysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGateways",
      requestType = com.google.cloud.apigateway.v1.ListGatewaysRequest.class,
      responseType = com.google.cloud.apigateway.v1.ListGatewaysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListGatewaysRequest,
      com.google.cloud.apigateway.v1.ListGatewaysResponse> getListGatewaysMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListGatewaysRequest, com.google.cloud.apigateway.v1.ListGatewaysResponse> getListGatewaysMethod;
    if ((getListGatewaysMethod = ApiGatewayServiceGrpc.getListGatewaysMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getListGatewaysMethod = ApiGatewayServiceGrpc.getListGatewaysMethod) == null) {
          ApiGatewayServiceGrpc.getListGatewaysMethod = getListGatewaysMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.ListGatewaysRequest, com.google.cloud.apigateway.v1.ListGatewaysResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGateways"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListGatewaysRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListGatewaysResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("ListGateways"))
              .build();
        }
      }
    }
    return getListGatewaysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetGatewayRequest,
      com.google.cloud.apigateway.v1.Gateway> getGetGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGateway",
      requestType = com.google.cloud.apigateway.v1.GetGatewayRequest.class,
      responseType = com.google.cloud.apigateway.v1.Gateway.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetGatewayRequest,
      com.google.cloud.apigateway.v1.Gateway> getGetGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetGatewayRequest, com.google.cloud.apigateway.v1.Gateway> getGetGatewayMethod;
    if ((getGetGatewayMethod = ApiGatewayServiceGrpc.getGetGatewayMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getGetGatewayMethod = ApiGatewayServiceGrpc.getGetGatewayMethod) == null) {
          ApiGatewayServiceGrpc.getGetGatewayMethod = getGetGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.GetGatewayRequest, com.google.cloud.apigateway.v1.Gateway>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.GetGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.Gateway.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("GetGateway"))
              .build();
        }
      }
    }
    return getGetGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateGatewayRequest,
      com.google.longrunning.Operation> getCreateGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGateway",
      requestType = com.google.cloud.apigateway.v1.CreateGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateGatewayRequest,
      com.google.longrunning.Operation> getCreateGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateGatewayRequest, com.google.longrunning.Operation> getCreateGatewayMethod;
    if ((getCreateGatewayMethod = ApiGatewayServiceGrpc.getCreateGatewayMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getCreateGatewayMethod = ApiGatewayServiceGrpc.getCreateGatewayMethod) == null) {
          ApiGatewayServiceGrpc.getCreateGatewayMethod = getCreateGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.CreateGatewayRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.CreateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("CreateGateway"))
              .build();
        }
      }
    }
    return getCreateGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateGatewayRequest,
      com.google.longrunning.Operation> getUpdateGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGateway",
      requestType = com.google.cloud.apigateway.v1.UpdateGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateGatewayRequest,
      com.google.longrunning.Operation> getUpdateGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateGatewayRequest, com.google.longrunning.Operation> getUpdateGatewayMethod;
    if ((getUpdateGatewayMethod = ApiGatewayServiceGrpc.getUpdateGatewayMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getUpdateGatewayMethod = ApiGatewayServiceGrpc.getUpdateGatewayMethod) == null) {
          ApiGatewayServiceGrpc.getUpdateGatewayMethod = getUpdateGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.UpdateGatewayRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.UpdateGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("UpdateGateway"))
              .build();
        }
      }
    }
    return getUpdateGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteGatewayRequest,
      com.google.longrunning.Operation> getDeleteGatewayMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGateway",
      requestType = com.google.cloud.apigateway.v1.DeleteGatewayRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteGatewayRequest,
      com.google.longrunning.Operation> getDeleteGatewayMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteGatewayRequest, com.google.longrunning.Operation> getDeleteGatewayMethod;
    if ((getDeleteGatewayMethod = ApiGatewayServiceGrpc.getDeleteGatewayMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getDeleteGatewayMethod = ApiGatewayServiceGrpc.getDeleteGatewayMethod) == null) {
          ApiGatewayServiceGrpc.getDeleteGatewayMethod = getDeleteGatewayMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.DeleteGatewayRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGateway"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.DeleteGatewayRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("DeleteGateway"))
              .build();
        }
      }
    }
    return getDeleteGatewayMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApisRequest,
      com.google.cloud.apigateway.v1.ListApisResponse> getListApisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApis",
      requestType = com.google.cloud.apigateway.v1.ListApisRequest.class,
      responseType = com.google.cloud.apigateway.v1.ListApisResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApisRequest,
      com.google.cloud.apigateway.v1.ListApisResponse> getListApisMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApisRequest, com.google.cloud.apigateway.v1.ListApisResponse> getListApisMethod;
    if ((getListApisMethod = ApiGatewayServiceGrpc.getListApisMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getListApisMethod = ApiGatewayServiceGrpc.getListApisMethod) == null) {
          ApiGatewayServiceGrpc.getListApisMethod = getListApisMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.ListApisRequest, com.google.cloud.apigateway.v1.ListApisResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApis"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListApisRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListApisResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("ListApis"))
              .build();
        }
      }
    }
    return getListApisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiRequest,
      com.google.cloud.apigateway.v1.Api> getGetApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApi",
      requestType = com.google.cloud.apigateway.v1.GetApiRequest.class,
      responseType = com.google.cloud.apigateway.v1.Api.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiRequest,
      com.google.cloud.apigateway.v1.Api> getGetApiMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiRequest, com.google.cloud.apigateway.v1.Api> getGetApiMethod;
    if ((getGetApiMethod = ApiGatewayServiceGrpc.getGetApiMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getGetApiMethod = ApiGatewayServiceGrpc.getGetApiMethod) == null) {
          ApiGatewayServiceGrpc.getGetApiMethod = getGetApiMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.GetApiRequest, com.google.cloud.apigateway.v1.Api>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.GetApiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.Api.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("GetApi"))
              .build();
        }
      }
    }
    return getGetApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiRequest,
      com.google.longrunning.Operation> getCreateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApi",
      requestType = com.google.cloud.apigateway.v1.CreateApiRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiRequest,
      com.google.longrunning.Operation> getCreateApiMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiRequest, com.google.longrunning.Operation> getCreateApiMethod;
    if ((getCreateApiMethod = ApiGatewayServiceGrpc.getCreateApiMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getCreateApiMethod = ApiGatewayServiceGrpc.getCreateApiMethod) == null) {
          ApiGatewayServiceGrpc.getCreateApiMethod = getCreateApiMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.CreateApiRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.CreateApiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("CreateApi"))
              .build();
        }
      }
    }
    return getCreateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiRequest,
      com.google.longrunning.Operation> getUpdateApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApi",
      requestType = com.google.cloud.apigateway.v1.UpdateApiRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiRequest,
      com.google.longrunning.Operation> getUpdateApiMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiRequest, com.google.longrunning.Operation> getUpdateApiMethod;
    if ((getUpdateApiMethod = ApiGatewayServiceGrpc.getUpdateApiMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getUpdateApiMethod = ApiGatewayServiceGrpc.getUpdateApiMethod) == null) {
          ApiGatewayServiceGrpc.getUpdateApiMethod = getUpdateApiMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.UpdateApiRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.UpdateApiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("UpdateApi"))
              .build();
        }
      }
    }
    return getUpdateApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiRequest,
      com.google.longrunning.Operation> getDeleteApiMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApi",
      requestType = com.google.cloud.apigateway.v1.DeleteApiRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiRequest,
      com.google.longrunning.Operation> getDeleteApiMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiRequest, com.google.longrunning.Operation> getDeleteApiMethod;
    if ((getDeleteApiMethod = ApiGatewayServiceGrpc.getDeleteApiMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getDeleteApiMethod = ApiGatewayServiceGrpc.getDeleteApiMethod) == null) {
          ApiGatewayServiceGrpc.getDeleteApiMethod = getDeleteApiMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.DeleteApiRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApi"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.DeleteApiRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("DeleteApi"))
              .build();
        }
      }
    }
    return getDeleteApiMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApiConfigsRequest,
      com.google.cloud.apigateway.v1.ListApiConfigsResponse> getListApiConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApiConfigs",
      requestType = com.google.cloud.apigateway.v1.ListApiConfigsRequest.class,
      responseType = com.google.cloud.apigateway.v1.ListApiConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApiConfigsRequest,
      com.google.cloud.apigateway.v1.ListApiConfigsResponse> getListApiConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.ListApiConfigsRequest, com.google.cloud.apigateway.v1.ListApiConfigsResponse> getListApiConfigsMethod;
    if ((getListApiConfigsMethod = ApiGatewayServiceGrpc.getListApiConfigsMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getListApiConfigsMethod = ApiGatewayServiceGrpc.getListApiConfigsMethod) == null) {
          ApiGatewayServiceGrpc.getListApiConfigsMethod = getListApiConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.ListApiConfigsRequest, com.google.cloud.apigateway.v1.ListApiConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApiConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListApiConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ListApiConfigsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("ListApiConfigs"))
              .build();
        }
      }
    }
    return getListApiConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiConfigRequest,
      com.google.cloud.apigateway.v1.ApiConfig> getGetApiConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApiConfig",
      requestType = com.google.cloud.apigateway.v1.GetApiConfigRequest.class,
      responseType = com.google.cloud.apigateway.v1.ApiConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiConfigRequest,
      com.google.cloud.apigateway.v1.ApiConfig> getGetApiConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.GetApiConfigRequest, com.google.cloud.apigateway.v1.ApiConfig> getGetApiConfigMethod;
    if ((getGetApiConfigMethod = ApiGatewayServiceGrpc.getGetApiConfigMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getGetApiConfigMethod = ApiGatewayServiceGrpc.getGetApiConfigMethod) == null) {
          ApiGatewayServiceGrpc.getGetApiConfigMethod = getGetApiConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.GetApiConfigRequest, com.google.cloud.apigateway.v1.ApiConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApiConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.GetApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.ApiConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("GetApiConfig"))
              .build();
        }
      }
    }
    return getGetApiConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiConfigRequest,
      com.google.longrunning.Operation> getCreateApiConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApiConfig",
      requestType = com.google.cloud.apigateway.v1.CreateApiConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiConfigRequest,
      com.google.longrunning.Operation> getCreateApiConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.CreateApiConfigRequest, com.google.longrunning.Operation> getCreateApiConfigMethod;
    if ((getCreateApiConfigMethod = ApiGatewayServiceGrpc.getCreateApiConfigMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getCreateApiConfigMethod = ApiGatewayServiceGrpc.getCreateApiConfigMethod) == null) {
          ApiGatewayServiceGrpc.getCreateApiConfigMethod = getCreateApiConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.CreateApiConfigRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApiConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.CreateApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("CreateApiConfig"))
              .build();
        }
      }
    }
    return getCreateApiConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiConfigRequest,
      com.google.longrunning.Operation> getUpdateApiConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApiConfig",
      requestType = com.google.cloud.apigateway.v1.UpdateApiConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiConfigRequest,
      com.google.longrunning.Operation> getUpdateApiConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.UpdateApiConfigRequest, com.google.longrunning.Operation> getUpdateApiConfigMethod;
    if ((getUpdateApiConfigMethod = ApiGatewayServiceGrpc.getUpdateApiConfigMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getUpdateApiConfigMethod = ApiGatewayServiceGrpc.getUpdateApiConfigMethod) == null) {
          ApiGatewayServiceGrpc.getUpdateApiConfigMethod = getUpdateApiConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.UpdateApiConfigRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApiConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.UpdateApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("UpdateApiConfig"))
              .build();
        }
      }
    }
    return getUpdateApiConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiConfigRequest,
      com.google.longrunning.Operation> getDeleteApiConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApiConfig",
      requestType = com.google.cloud.apigateway.v1.DeleteApiConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiConfigRequest,
      com.google.longrunning.Operation> getDeleteApiConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apigateway.v1.DeleteApiConfigRequest, com.google.longrunning.Operation> getDeleteApiConfigMethod;
    if ((getDeleteApiConfigMethod = ApiGatewayServiceGrpc.getDeleteApiConfigMethod) == null) {
      synchronized (ApiGatewayServiceGrpc.class) {
        if ((getDeleteApiConfigMethod = ApiGatewayServiceGrpc.getDeleteApiConfigMethod) == null) {
          ApiGatewayServiceGrpc.getDeleteApiConfigMethod = getDeleteApiConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apigateway.v1.DeleteApiConfigRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApiConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apigateway.v1.DeleteApiConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ApiGatewayServiceMethodDescriptorSupplier("DeleteApiConfig"))
              .build();
        }
      }
    }
    return getDeleteApiConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ApiGatewayServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceStub>() {
        @java.lang.Override
        public ApiGatewayServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiGatewayServiceStub(channel, callOptions);
        }
      };
    return ApiGatewayServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ApiGatewayServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceBlockingStub>() {
        @java.lang.Override
        public ApiGatewayServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiGatewayServiceBlockingStub(channel, callOptions);
        }
      };
    return ApiGatewayServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ApiGatewayServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ApiGatewayServiceFutureStub>() {
        @java.lang.Override
        public ApiGatewayServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ApiGatewayServiceFutureStub(channel, callOptions);
        }
      };
    return ApiGatewayServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The API Gateway Service is the interface for managing API Gateways.
   * </pre>
   */
  public static abstract class ApiGatewayServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public void listGateways(com.google.cloud.apigateway.v1.ListGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListGatewaysResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGatewaysMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public void getGateway(com.google.cloud.apigateway.v1.GetGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Gateway> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public void createGateway(com.google.cloud.apigateway.v1.CreateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public void updateGateway(com.google.cloud.apigateway.v1.UpdateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public void deleteGateway(com.google.cloud.apigateway.v1.DeleteGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteGatewayMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Apis in a given project and location.
     * </pre>
     */
    public void listApis(com.google.cloud.apigateway.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApisResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApisMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Api.
     * </pre>
     */
    public void getApi(com.google.cloud.apigateway.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Api> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new Api in a given project and location.
     * </pre>
     */
    public void createApi(com.google.cloud.apigateway.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApiMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Api.
     * </pre>
     */
    public void updateApi(com.google.cloud.apigateway.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApiMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Api.
     * </pre>
     */
    public void deleteApi(com.google.cloud.apigateway.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteApiMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists ApiConfigs in a given project and location.
     * </pre>
     */
    public void listApiConfigs(com.google.cloud.apigateway.v1.ListApiConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApiConfigsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApiConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ApiConfig.
     * </pre>
     */
    public void getApiConfig(com.google.cloud.apigateway.v1.GetApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ApiConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApiConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new ApiConfig in a given project and location.
     * </pre>
     */
    public void createApiConfig(com.google.cloud.apigateway.v1.CreateApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApiConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ApiConfig.
     * </pre>
     */
    public void updateApiConfig(com.google.cloud.apigateway.v1.UpdateApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApiConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ApiConfig.
     * </pre>
     */
    public void deleteApiConfig(com.google.cloud.apigateway.v1.DeleteApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteApiConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListGatewaysMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.ListGatewaysRequest,
                com.google.cloud.apigateway.v1.ListGatewaysResponse>(
                  this, METHODID_LIST_GATEWAYS)))
          .addMethod(
            getGetGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.GetGatewayRequest,
                com.google.cloud.apigateway.v1.Gateway>(
                  this, METHODID_GET_GATEWAY)))
          .addMethod(
            getCreateGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.CreateGatewayRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_GATEWAY)))
          .addMethod(
            getUpdateGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.UpdateGatewayRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_GATEWAY)))
          .addMethod(
            getDeleteGatewayMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.DeleteGatewayRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_GATEWAY)))
          .addMethod(
            getListApisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.ListApisRequest,
                com.google.cloud.apigateway.v1.ListApisResponse>(
                  this, METHODID_LIST_APIS)))
          .addMethod(
            getGetApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.GetApiRequest,
                com.google.cloud.apigateway.v1.Api>(
                  this, METHODID_GET_API)))
          .addMethod(
            getCreateApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.CreateApiRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_API)))
          .addMethod(
            getUpdateApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.UpdateApiRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_API)))
          .addMethod(
            getDeleteApiMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.DeleteApiRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_API)))
          .addMethod(
            getListApiConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.ListApiConfigsRequest,
                com.google.cloud.apigateway.v1.ListApiConfigsResponse>(
                  this, METHODID_LIST_API_CONFIGS)))
          .addMethod(
            getGetApiConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.GetApiConfigRequest,
                com.google.cloud.apigateway.v1.ApiConfig>(
                  this, METHODID_GET_API_CONFIG)))
          .addMethod(
            getCreateApiConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.CreateApiConfigRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_API_CONFIG)))
          .addMethod(
            getUpdateApiConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.UpdateApiConfigRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_API_CONFIG)))
          .addMethod(
            getDeleteApiConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.apigateway.v1.DeleteApiConfigRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_API_CONFIG)))
          .build();
    }
  }

  /**
   * <pre>
   * The API Gateway Service is the interface for managing API Gateways.
   * </pre>
   */
  public static final class ApiGatewayServiceStub extends io.grpc.stub.AbstractAsyncStub<ApiGatewayServiceStub> {
    private ApiGatewayServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiGatewayServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiGatewayServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public void listGateways(com.google.cloud.apigateway.v1.ListGatewaysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListGatewaysResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGatewaysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public void getGateway(com.google.cloud.apigateway.v1.GetGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Gateway> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public void createGateway(com.google.cloud.apigateway.v1.CreateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public void updateGateway(com.google.cloud.apigateway.v1.UpdateGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public void deleteGateway(com.google.cloud.apigateway.v1.DeleteGatewayRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGatewayMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Apis in a given project and location.
     * </pre>
     */
    public void listApis(com.google.cloud.apigateway.v1.ListApisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApisResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single Api.
     * </pre>
     */
    public void getApi(com.google.cloud.apigateway.v1.GetApiRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Api> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new Api in a given project and location.
     * </pre>
     */
    public void createApi(com.google.cloud.apigateway.v1.CreateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single Api.
     * </pre>
     */
    public void updateApi(com.google.cloud.apigateway.v1.UpdateApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single Api.
     * </pre>
     */
    public void deleteApi(com.google.cloud.apigateway.v1.DeleteApiRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists ApiConfigs in a given project and location.
     * </pre>
     */
    public void listApiConfigs(com.google.cloud.apigateway.v1.ListApiConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApiConfigsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApiConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets details of a single ApiConfig.
     * </pre>
     */
    public void getApiConfig(com.google.cloud.apigateway.v1.GetApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ApiConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApiConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new ApiConfig in a given project and location.
     * </pre>
     */
    public void createApiConfig(com.google.cloud.apigateway.v1.CreateApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApiConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the parameters of a single ApiConfig.
     * </pre>
     */
    public void updateApiConfig(com.google.cloud.apigateway.v1.UpdateApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApiConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a single ApiConfig.
     * </pre>
     */
    public void deleteApiConfig(com.google.cloud.apigateway.v1.DeleteApiConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApiConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The API Gateway Service is the interface for managing API Gateways.
   * </pre>
   */
  public static final class ApiGatewayServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ApiGatewayServiceBlockingStub> {
    private ApiGatewayServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiGatewayServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiGatewayServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.ListGatewaysResponse listGateways(com.google.cloud.apigateway.v1.ListGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGatewaysMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.Gateway getGateway(com.google.cloud.apigateway.v1.GetGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGateway(com.google.cloud.apigateway.v1.CreateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public com.google.longrunning.Operation updateGateway(com.google.cloud.apigateway.v1.UpdateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGateway(com.google.cloud.apigateway.v1.DeleteGatewayRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGatewayMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Apis in a given project and location.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.ListApisResponse listApis(com.google.cloud.apigateway.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApisMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single Api.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.Api getApi(com.google.cloud.apigateway.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new Api in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApi(com.google.cloud.apigateway.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Api.
     * </pre>
     */
    public com.google.longrunning.Operation updateApi(com.google.cloud.apigateway.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single Api.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApi(com.google.cloud.apigateway.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists ApiConfigs in a given project and location.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.ListApiConfigsResponse listApiConfigs(com.google.cloud.apigateway.v1.ListApiConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApiConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets details of a single ApiConfig.
     * </pre>
     */
    public com.google.cloud.apigateway.v1.ApiConfig getApiConfig(com.google.cloud.apigateway.v1.GetApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApiConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new ApiConfig in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApiConfig(com.google.cloud.apigateway.v1.CreateApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApiConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ApiConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateApiConfig(com.google.cloud.apigateway.v1.UpdateApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApiConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a single ApiConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApiConfig(com.google.cloud.apigateway.v1.DeleteApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApiConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The API Gateway Service is the interface for managing API Gateways.
   * </pre>
   */
  public static final class ApiGatewayServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ApiGatewayServiceFutureStub> {
    private ApiGatewayServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ApiGatewayServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ApiGatewayServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists Gateways in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.ListGatewaysResponse> listGateways(
        com.google.cloud.apigateway.v1.ListGatewaysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGatewaysMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.Gateway> getGateway(
        com.google.cloud.apigateway.v1.GetGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Gateway in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createGateway(
        com.google.cloud.apigateway.v1.CreateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateGateway(
        com.google.cloud.apigateway.v1.UpdateGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Gateway.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteGateway(
        com.google.cloud.apigateway.v1.DeleteGatewayRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGatewayMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Apis in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.ListApisResponse> listApis(
        com.google.cloud.apigateway.v1.ListApisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApisMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single Api.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.Api> getApi(
        com.google.cloud.apigateway.v1.GetApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new Api in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createApi(
        com.google.cloud.apigateway.v1.CreateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single Api.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateApi(
        com.google.cloud.apigateway.v1.UpdateApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single Api.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteApi(
        com.google.cloud.apigateway.v1.DeleteApiRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists ApiConfigs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.ListApiConfigsResponse> listApiConfigs(
        com.google.cloud.apigateway.v1.ListApiConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApiConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets details of a single ApiConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apigateway.v1.ApiConfig> getApiConfig(
        com.google.cloud.apigateway.v1.GetApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApiConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new ApiConfig in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createApiConfig(
        com.google.cloud.apigateway.v1.CreateApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApiConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the parameters of a single ApiConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateApiConfig(
        com.google.cloud.apigateway.v1.UpdateApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApiConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a single ApiConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteApiConfig(
        com.google.cloud.apigateway.v1.DeleteApiConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApiConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GATEWAYS = 0;
  private static final int METHODID_GET_GATEWAY = 1;
  private static final int METHODID_CREATE_GATEWAY = 2;
  private static final int METHODID_UPDATE_GATEWAY = 3;
  private static final int METHODID_DELETE_GATEWAY = 4;
  private static final int METHODID_LIST_APIS = 5;
  private static final int METHODID_GET_API = 6;
  private static final int METHODID_CREATE_API = 7;
  private static final int METHODID_UPDATE_API = 8;
  private static final int METHODID_DELETE_API = 9;
  private static final int METHODID_LIST_API_CONFIGS = 10;
  private static final int METHODID_GET_API_CONFIG = 11;
  private static final int METHODID_CREATE_API_CONFIG = 12;
  private static final int METHODID_UPDATE_API_CONFIG = 13;
  private static final int METHODID_DELETE_API_CONFIG = 14;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ApiGatewayServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ApiGatewayServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GATEWAYS:
          serviceImpl.listGateways((com.google.cloud.apigateway.v1.ListGatewaysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListGatewaysResponse>) responseObserver);
          break;
        case METHODID_GET_GATEWAY:
          serviceImpl.getGateway((com.google.cloud.apigateway.v1.GetGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Gateway>) responseObserver);
          break;
        case METHODID_CREATE_GATEWAY:
          serviceImpl.createGateway((com.google.cloud.apigateway.v1.CreateGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GATEWAY:
          serviceImpl.updateGateway((com.google.cloud.apigateway.v1.UpdateGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GATEWAY:
          serviceImpl.deleteGateway((com.google.cloud.apigateway.v1.DeleteGatewayRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_APIS:
          serviceImpl.listApis((com.google.cloud.apigateway.v1.ListApisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApisResponse>) responseObserver);
          break;
        case METHODID_GET_API:
          serviceImpl.getApi((com.google.cloud.apigateway.v1.GetApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.Api>) responseObserver);
          break;
        case METHODID_CREATE_API:
          serviceImpl.createApi((com.google.cloud.apigateway.v1.CreateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_API:
          serviceImpl.updateApi((com.google.cloud.apigateway.v1.UpdateApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_API:
          serviceImpl.deleteApi((com.google.cloud.apigateway.v1.DeleteApiRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_API_CONFIGS:
          serviceImpl.listApiConfigs((com.google.cloud.apigateway.v1.ListApiConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ListApiConfigsResponse>) responseObserver);
          break;
        case METHODID_GET_API_CONFIG:
          serviceImpl.getApiConfig((com.google.cloud.apigateway.v1.GetApiConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apigateway.v1.ApiConfig>) responseObserver);
          break;
        case METHODID_CREATE_API_CONFIG:
          serviceImpl.createApiConfig((com.google.cloud.apigateway.v1.CreateApiConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_API_CONFIG:
          serviceImpl.updateApiConfig((com.google.cloud.apigateway.v1.UpdateApiConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_API_CONFIG:
          serviceImpl.deleteApiConfig((com.google.cloud.apigateway.v1.DeleteApiConfigRequest) request,
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

  private static abstract class ApiGatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ApiGatewayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apigateway.v1.ApigatewayService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ApiGatewayService");
    }
  }

  private static final class ApiGatewayServiceFileDescriptorSupplier
      extends ApiGatewayServiceBaseDescriptorSupplier {
    ApiGatewayServiceFileDescriptorSupplier() {}
  }

  private static final class ApiGatewayServiceMethodDescriptorSupplier
      extends ApiGatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ApiGatewayServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ApiGatewayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ApiGatewayServiceFileDescriptorSupplier())
              .addMethod(getListGatewaysMethod())
              .addMethod(getGetGatewayMethod())
              .addMethod(getCreateGatewayMethod())
              .addMethod(getUpdateGatewayMethod())
              .addMethod(getDeleteGatewayMethod())
              .addMethod(getListApisMethod())
              .addMethod(getGetApiMethod())
              .addMethod(getCreateApiMethod())
              .addMethod(getUpdateApiMethod())
              .addMethod(getDeleteApiMethod())
              .addMethod(getListApiConfigsMethod())
              .addMethod(getGetApiConfigMethod())
              .addMethod(getCreateApiConfigMethod())
              .addMethod(getUpdateApiConfigMethod())
              .addMethod(getDeleteApiConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
