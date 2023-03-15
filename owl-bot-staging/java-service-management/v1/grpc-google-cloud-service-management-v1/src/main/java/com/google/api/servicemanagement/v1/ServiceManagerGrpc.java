package com.google.api.servicemanagement.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * [Google Service Management
 * API](https://cloud.google.com/service-infrastructure/docs/overview)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/servicemanagement/v1/servicemanager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceManagerGrpc {

  private ServiceManagerGrpc() {}

  public static final String SERVICE_NAME = "google.api.servicemanagement.v1.ServiceManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServicesRequest,
      com.google.api.servicemanagement.v1.ListServicesResponse> getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.api.servicemanagement.v1.ListServicesRequest.class,
      responseType = com.google.api.servicemanagement.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServicesRequest,
      com.google.api.servicemanagement.v1.ListServicesResponse> getListServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServicesRequest, com.google.api.servicemanagement.v1.ListServicesResponse> getListServicesMethod;
    if ((getListServicesMethod = ServiceManagerGrpc.getListServicesMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getListServicesMethod = ServiceManagerGrpc.getListServicesMethod) == null) {
          ServiceManagerGrpc.getListServicesMethod = getListServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.ListServicesRequest, com.google.api.servicemanagement.v1.ListServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("ListServices"))
              .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRequest,
      com.google.api.servicemanagement.v1.ManagedService> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.api.servicemanagement.v1.GetServiceRequest.class,
      responseType = com.google.api.servicemanagement.v1.ManagedService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRequest,
      com.google.api.servicemanagement.v1.ManagedService> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRequest, com.google.api.servicemanagement.v1.ManagedService> getGetServiceMethod;
    if ((getGetServiceMethod = ServiceManagerGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getGetServiceMethod = ServiceManagerGrpc.getGetServiceMethod) == null) {
          ServiceManagerGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.GetServiceRequest, com.google.api.servicemanagement.v1.ManagedService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ManagedService.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("GetService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRequest,
      com.google.longrunning.Operation> getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.api.servicemanagement.v1.CreateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRequest,
      com.google.longrunning.Operation> getCreateServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRequest, com.google.longrunning.Operation> getCreateServiceMethod;
    if ((getCreateServiceMethod = ServiceManagerGrpc.getCreateServiceMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getCreateServiceMethod = ServiceManagerGrpc.getCreateServiceMethod) == null) {
          ServiceManagerGrpc.getCreateServiceMethod = getCreateServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.CreateServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("CreateService"))
              .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.DeleteServiceRequest,
      com.google.longrunning.Operation> getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.api.servicemanagement.v1.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.DeleteServiceRequest,
      com.google.longrunning.Operation> getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.DeleteServiceRequest, com.google.longrunning.Operation> getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServiceManagerGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getDeleteServiceMethod = ServiceManagerGrpc.getDeleteServiceMethod) == null) {
          ServiceManagerGrpc.getDeleteServiceMethod = getDeleteServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.DeleteServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("DeleteService"))
              .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.UndeleteServiceRequest,
      com.google.longrunning.Operation> getUndeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteService",
      requestType = com.google.api.servicemanagement.v1.UndeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.UndeleteServiceRequest,
      com.google.longrunning.Operation> getUndeleteServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.UndeleteServiceRequest, com.google.longrunning.Operation> getUndeleteServiceMethod;
    if ((getUndeleteServiceMethod = ServiceManagerGrpc.getUndeleteServiceMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getUndeleteServiceMethod = ServiceManagerGrpc.getUndeleteServiceMethod) == null) {
          ServiceManagerGrpc.getUndeleteServiceMethod = getUndeleteServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.UndeleteServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.UndeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("UndeleteService"))
              .build();
        }
      }
    }
    return getUndeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceConfigsRequest,
      com.google.api.servicemanagement.v1.ListServiceConfigsResponse> getListServiceConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceConfigs",
      requestType = com.google.api.servicemanagement.v1.ListServiceConfigsRequest.class,
      responseType = com.google.api.servicemanagement.v1.ListServiceConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceConfigsRequest,
      com.google.api.servicemanagement.v1.ListServiceConfigsResponse> getListServiceConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceConfigsRequest, com.google.api.servicemanagement.v1.ListServiceConfigsResponse> getListServiceConfigsMethod;
    if ((getListServiceConfigsMethod = ServiceManagerGrpc.getListServiceConfigsMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getListServiceConfigsMethod = ServiceManagerGrpc.getListServiceConfigsMethod) == null) {
          ServiceManagerGrpc.getListServiceConfigsMethod = getListServiceConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.ListServiceConfigsRequest, com.google.api.servicemanagement.v1.ListServiceConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServiceConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServiceConfigsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("ListServiceConfigs"))
              .build();
        }
      }
    }
    return getListServiceConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceConfigRequest,
      com.google.api.Service> getGetServiceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceConfig",
      requestType = com.google.api.servicemanagement.v1.GetServiceConfigRequest.class,
      responseType = com.google.api.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceConfigRequest,
      com.google.api.Service> getGetServiceConfigMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceConfigRequest, com.google.api.Service> getGetServiceConfigMethod;
    if ((getGetServiceConfigMethod = ServiceManagerGrpc.getGetServiceConfigMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getGetServiceConfigMethod = ServiceManagerGrpc.getGetServiceConfigMethod) == null) {
          ServiceManagerGrpc.getGetServiceConfigMethod = getGetServiceConfigMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.GetServiceConfigRequest, com.google.api.Service>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.GetServiceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.Service.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("GetServiceConfig"))
              .build();
        }
      }
    }
    return getGetServiceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceConfigRequest,
      com.google.api.Service> getCreateServiceConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceConfig",
      requestType = com.google.api.servicemanagement.v1.CreateServiceConfigRequest.class,
      responseType = com.google.api.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceConfigRequest,
      com.google.api.Service> getCreateServiceConfigMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceConfigRequest, com.google.api.Service> getCreateServiceConfigMethod;
    if ((getCreateServiceConfigMethod = ServiceManagerGrpc.getCreateServiceConfigMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getCreateServiceConfigMethod = ServiceManagerGrpc.getCreateServiceConfigMethod) == null) {
          ServiceManagerGrpc.getCreateServiceConfigMethod = getCreateServiceConfigMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.CreateServiceConfigRequest, com.google.api.Service>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServiceConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.CreateServiceConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.Service.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("CreateServiceConfig"))
              .build();
        }
      }
    }
    return getCreateServiceConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.SubmitConfigSourceRequest,
      com.google.longrunning.Operation> getSubmitConfigSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SubmitConfigSource",
      requestType = com.google.api.servicemanagement.v1.SubmitConfigSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.SubmitConfigSourceRequest,
      com.google.longrunning.Operation> getSubmitConfigSourceMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.SubmitConfigSourceRequest, com.google.longrunning.Operation> getSubmitConfigSourceMethod;
    if ((getSubmitConfigSourceMethod = ServiceManagerGrpc.getSubmitConfigSourceMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getSubmitConfigSourceMethod = ServiceManagerGrpc.getSubmitConfigSourceMethod) == null) {
          ServiceManagerGrpc.getSubmitConfigSourceMethod = getSubmitConfigSourceMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.SubmitConfigSourceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SubmitConfigSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.SubmitConfigSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("SubmitConfigSource"))
              .build();
        }
      }
    }
    return getSubmitConfigSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceRolloutsRequest,
      com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> getListServiceRolloutsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceRollouts",
      requestType = com.google.api.servicemanagement.v1.ListServiceRolloutsRequest.class,
      responseType = com.google.api.servicemanagement.v1.ListServiceRolloutsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceRolloutsRequest,
      com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> getListServiceRolloutsMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.ListServiceRolloutsRequest, com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> getListServiceRolloutsMethod;
    if ((getListServiceRolloutsMethod = ServiceManagerGrpc.getListServiceRolloutsMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getListServiceRolloutsMethod = ServiceManagerGrpc.getListServiceRolloutsMethod) == null) {
          ServiceManagerGrpc.getListServiceRolloutsMethod = getListServiceRolloutsMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.ListServiceRolloutsRequest, com.google.api.servicemanagement.v1.ListServiceRolloutsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceRollouts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServiceRolloutsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.ListServiceRolloutsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("ListServiceRollouts"))
              .build();
        }
      }
    }
    return getListServiceRolloutsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRolloutRequest,
      com.google.api.servicemanagement.v1.Rollout> getGetServiceRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceRollout",
      requestType = com.google.api.servicemanagement.v1.GetServiceRolloutRequest.class,
      responseType = com.google.api.servicemanagement.v1.Rollout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRolloutRequest,
      com.google.api.servicemanagement.v1.Rollout> getGetServiceRolloutMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GetServiceRolloutRequest, com.google.api.servicemanagement.v1.Rollout> getGetServiceRolloutMethod;
    if ((getGetServiceRolloutMethod = ServiceManagerGrpc.getGetServiceRolloutMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getGetServiceRolloutMethod = ServiceManagerGrpc.getGetServiceRolloutMethod) == null) {
          ServiceManagerGrpc.getGetServiceRolloutMethod = getGetServiceRolloutMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.GetServiceRolloutRequest, com.google.api.servicemanagement.v1.Rollout>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceRollout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.GetServiceRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.Rollout.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("GetServiceRollout"))
              .build();
        }
      }
    }
    return getGetServiceRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRolloutRequest,
      com.google.longrunning.Operation> getCreateServiceRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceRollout",
      requestType = com.google.api.servicemanagement.v1.CreateServiceRolloutRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRolloutRequest,
      com.google.longrunning.Operation> getCreateServiceRolloutMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.CreateServiceRolloutRequest, com.google.longrunning.Operation> getCreateServiceRolloutMethod;
    if ((getCreateServiceRolloutMethod = ServiceManagerGrpc.getCreateServiceRolloutMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getCreateServiceRolloutMethod = ServiceManagerGrpc.getCreateServiceRolloutMethod) == null) {
          ServiceManagerGrpc.getCreateServiceRolloutMethod = getCreateServiceRolloutMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.CreateServiceRolloutRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServiceRollout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.CreateServiceRolloutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("CreateServiceRollout"))
              .build();
        }
      }
    }
    return getCreateServiceRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GenerateConfigReportRequest,
      com.google.api.servicemanagement.v1.GenerateConfigReportResponse> getGenerateConfigReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateConfigReport",
      requestType = com.google.api.servicemanagement.v1.GenerateConfigReportRequest.class,
      responseType = com.google.api.servicemanagement.v1.GenerateConfigReportResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GenerateConfigReportRequest,
      com.google.api.servicemanagement.v1.GenerateConfigReportResponse> getGenerateConfigReportMethod() {
    io.grpc.MethodDescriptor<com.google.api.servicemanagement.v1.GenerateConfigReportRequest, com.google.api.servicemanagement.v1.GenerateConfigReportResponse> getGenerateConfigReportMethod;
    if ((getGenerateConfigReportMethod = ServiceManagerGrpc.getGenerateConfigReportMethod) == null) {
      synchronized (ServiceManagerGrpc.class) {
        if ((getGenerateConfigReportMethod = ServiceManagerGrpc.getGenerateConfigReportMethod) == null) {
          ServiceManagerGrpc.getGenerateConfigReportMethod = getGenerateConfigReportMethod =
              io.grpc.MethodDescriptor.<com.google.api.servicemanagement.v1.GenerateConfigReportRequest, com.google.api.servicemanagement.v1.GenerateConfigReportResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateConfigReport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.GenerateConfigReportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.servicemanagement.v1.GenerateConfigReportResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceManagerMethodDescriptorSupplier("GenerateConfigReport"))
              .build();
        }
      }
    }
    return getGenerateConfigReportMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceManagerStub>() {
        @java.lang.Override
        public ServiceManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceManagerStub(channel, callOptions);
        }
      };
    return ServiceManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceManagerBlockingStub>() {
        @java.lang.Override
        public ServiceManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceManagerBlockingStub(channel, callOptions);
        }
      };
    return ServiceManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceManagerFutureStub>() {
        @java.lang.Override
        public ServiceManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceManagerFutureStub(channel, callOptions);
        }
      };
    return ServiceManagerFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * [Google Service Management
   * API](https://cloud.google.com/service-infrastructure/docs/overview)
   * </pre>
   */
  public static abstract class ServiceManagerImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists managed services.
     * Returns all public services. For authenticated users, also returns all
     * services the calling user has "servicemanagement.services.get" permission
     * for.
     * </pre>
     */
    public void listServices(com.google.api.servicemanagement.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a managed service. Authentication is required unless the service is
     * public.
     * </pre>
     */
    public void getService(com.google.api.servicemanagement.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ManagedService> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new managed service.
     * A managed service is immutable, and is subject to mandatory 30-day
     * data retention. You cannot move a service or recreate it within 30 days
     * after deletion.
     * One producer project can own no more than 500 services. For security and
     * reliability purposes, a production service should be hosted in a
     * dedicated producer project.
     * Operation&lt;response: ManagedService&gt;
     * </pre>
     */
    public void createService(com.google.api.servicemanagement.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a managed service. This method will change the service to the
     * `Soft-Delete` state for 30 days. Within this period, service producers may
     * call
     * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService]
     * to restore the service. After 30 days, the service will be permanently
     * deleted.
     * Operation&lt;response: google.protobuf.Empty&gt;
     * </pre>
     */
    public void deleteService(com.google.api.servicemanagement.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Revives a previously deleted managed service. The method restores the
     * service using the configuration at the time the service was deleted.
     * The target service must exist and must have been deleted within the
     * last 30 days.
     * Operation&lt;response: UndeleteServiceResponse&gt;
     * </pre>
     */
    public void undeleteService(com.google.api.servicemanagement.v1.UndeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the history of the service configuration for a managed service,
     * from the newest to the oldest.
     * </pre>
     */
    public void listServiceConfigs(com.google.api.servicemanagement.v1.ListServiceConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceConfigsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServiceConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a service configuration (version) for a managed service.
     * </pre>
     */
    public void getServiceConfig(com.google.api.servicemanagement.v1.GetServiceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.api.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service.
     * This method only stores the service configuration. To roll out the service
     * configuration to backend systems please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent service configurations and ones referenced by
     * existing rollouts are kept for each service. The rest will be deleted
     * eventually.
     * </pre>
     */
    public void createServiceConfig(com.google.api.servicemanagement.v1.CreateServiceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.api.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service based
     * on
     * user-supplied configuration source files (for example: OpenAPI
     * Specification). This method stores the source configurations as well as the
     * generated service configuration. To rollout the service configuration to
     * other services,
     * please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent configuration sources and ones referenced by
     * existing service configurtions are kept for each service. The rest will be
     * deleted eventually.
     * Operation&lt;response: SubmitConfigSourceResponse&gt;
     * </pre>
     */
    public void submitConfigSource(com.google.api.servicemanagement.v1.SubmitConfigSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubmitConfigSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists the history of the service configuration rollouts for a managed
     * service, from the newest to the oldest.
     * </pre>
     */
    public void listServiceRollouts(com.google.api.servicemanagement.v1.ListServiceRolloutsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServiceRolloutsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a service configuration
     * [rollout][google.api.servicemanagement.v1.Rollout].
     * </pre>
     */
    public void getServiceRollout(com.google.api.servicemanagement.v1.GetServiceRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.Rollout> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceRolloutMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration rollout. Based on rollout, the
     * Google Service Management will roll out the service configurations to
     * different backend services. For example, the logging configuration will be
     * pushed to Google Cloud Logging.
     * Please note that any previous pending and running Rollouts and associated
     * Operations will be automatically cancelled so that the latest Rollout will
     * not be blocked by previous Rollouts.
     * Only the 100 most recent (in any state) and the last 10 successful (if not
     * already part of the set of 100 most recent) rollouts are kept for each
     * service. The rest will be deleted eventually.
     * Operation&lt;response: Rollout&gt;
     * </pre>
     */
    public void createServiceRollout(com.google.api.servicemanagement.v1.CreateServiceRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceRolloutMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates and returns a report (errors, warnings and changes from
     * existing configurations) associated with
     * GenerateConfigReportRequest.new_value
     * If GenerateConfigReportRequest.old_value is specified,
     * GenerateConfigReportRequest will contain a single ChangeReport based on the
     * comparison between GenerateConfigReportRequest.new_value and
     * GenerateConfigReportRequest.old_value.
     * If GenerateConfigReportRequest.old_value is not specified, this method
     * will compare GenerateConfigReportRequest.new_value with the last pushed
     * service configuration.
     * </pre>
     */
    public void generateConfigReport(com.google.api.servicemanagement.v1.GenerateConfigReportRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.GenerateConfigReportResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateConfigReportMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.ListServicesRequest,
                com.google.api.servicemanagement.v1.ListServicesResponse>(
                  this, METHODID_LIST_SERVICES)))
          .addMethod(
            getGetServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.GetServiceRequest,
                com.google.api.servicemanagement.v1.ManagedService>(
                  this, METHODID_GET_SERVICE)))
          .addMethod(
            getCreateServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.CreateServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_SERVICE)))
          .addMethod(
            getDeleteServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.DeleteServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_SERVICE)))
          .addMethod(
            getUndeleteServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.UndeleteServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UNDELETE_SERVICE)))
          .addMethod(
            getListServiceConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.ListServiceConfigsRequest,
                com.google.api.servicemanagement.v1.ListServiceConfigsResponse>(
                  this, METHODID_LIST_SERVICE_CONFIGS)))
          .addMethod(
            getGetServiceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.GetServiceConfigRequest,
                com.google.api.Service>(
                  this, METHODID_GET_SERVICE_CONFIG)))
          .addMethod(
            getCreateServiceConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.CreateServiceConfigRequest,
                com.google.api.Service>(
                  this, METHODID_CREATE_SERVICE_CONFIG)))
          .addMethod(
            getSubmitConfigSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.SubmitConfigSourceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_SUBMIT_CONFIG_SOURCE)))
          .addMethod(
            getListServiceRolloutsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.ListServiceRolloutsRequest,
                com.google.api.servicemanagement.v1.ListServiceRolloutsResponse>(
                  this, METHODID_LIST_SERVICE_ROLLOUTS)))
          .addMethod(
            getGetServiceRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.GetServiceRolloutRequest,
                com.google.api.servicemanagement.v1.Rollout>(
                  this, METHODID_GET_SERVICE_ROLLOUT)))
          .addMethod(
            getCreateServiceRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.CreateServiceRolloutRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_SERVICE_ROLLOUT)))
          .addMethod(
            getGenerateConfigReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.servicemanagement.v1.GenerateConfigReportRequest,
                com.google.api.servicemanagement.v1.GenerateConfigReportResponse>(
                  this, METHODID_GENERATE_CONFIG_REPORT)))
          .build();
    }
  }

  /**
   * <pre>
   * [Google Service Management
   * API](https://cloud.google.com/service-infrastructure/docs/overview)
   * </pre>
   */
  public static final class ServiceManagerStub extends io.grpc.stub.AbstractAsyncStub<ServiceManagerStub> {
    private ServiceManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceManagerStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists managed services.
     * Returns all public services. For authenticated users, also returns all
     * services the calling user has "servicemanagement.services.get" permission
     * for.
     * </pre>
     */
    public void listServices(com.google.api.servicemanagement.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a managed service. Authentication is required unless the service is
     * public.
     * </pre>
     */
    public void getService(com.google.api.servicemanagement.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ManagedService> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new managed service.
     * A managed service is immutable, and is subject to mandatory 30-day
     * data retention. You cannot move a service or recreate it within 30 days
     * after deletion.
     * One producer project can own no more than 500 services. For security and
     * reliability purposes, a production service should be hosted in a
     * dedicated producer project.
     * Operation&lt;response: ManagedService&gt;
     * </pre>
     */
    public void createService(com.google.api.servicemanagement.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a managed service. This method will change the service to the
     * `Soft-Delete` state for 30 days. Within this period, service producers may
     * call
     * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService]
     * to restore the service. After 30 days, the service will be permanently
     * deleted.
     * Operation&lt;response: google.protobuf.Empty&gt;
     * </pre>
     */
    public void deleteService(com.google.api.servicemanagement.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Revives a previously deleted managed service. The method restores the
     * service using the configuration at the time the service was deleted.
     * The target service must exist and must have been deleted within the
     * last 30 days.
     * Operation&lt;response: UndeleteServiceResponse&gt;
     * </pre>
     */
    public void undeleteService(com.google.api.servicemanagement.v1.UndeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the history of the service configuration for a managed service,
     * from the newest to the oldest.
     * </pre>
     */
    public void listServiceConfigs(com.google.api.servicemanagement.v1.ListServiceConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceConfigsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a service configuration (version) for a managed service.
     * </pre>
     */
    public void getServiceConfig(com.google.api.servicemanagement.v1.GetServiceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.api.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service.
     * This method only stores the service configuration. To roll out the service
     * configuration to backend systems please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent service configurations and ones referenced by
     * existing rollouts are kept for each service. The rest will be deleted
     * eventually.
     * </pre>
     */
    public void createServiceConfig(com.google.api.servicemanagement.v1.CreateServiceConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.api.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service based
     * on
     * user-supplied configuration source files (for example: OpenAPI
     * Specification). This method stores the source configurations as well as the
     * generated service configuration. To rollout the service configuration to
     * other services,
     * please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent configuration sources and ones referenced by
     * existing service configurtions are kept for each service. The rest will be
     * deleted eventually.
     * Operation&lt;response: SubmitConfigSourceResponse&gt;
     * </pre>
     */
    public void submitConfigSource(com.google.api.servicemanagement.v1.SubmitConfigSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubmitConfigSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists the history of the service configuration rollouts for a managed
     * service, from the newest to the oldest.
     * </pre>
     */
    public void listServiceRollouts(com.google.api.servicemanagement.v1.ListServiceRolloutsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceRolloutsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a service configuration
     * [rollout][google.api.servicemanagement.v1.Rollout].
     * </pre>
     */
    public void getServiceRollout(com.google.api.servicemanagement.v1.GetServiceRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.Rollout> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceRolloutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new service configuration rollout. Based on rollout, the
     * Google Service Management will roll out the service configurations to
     * different backend services. For example, the logging configuration will be
     * pushed to Google Cloud Logging.
     * Please note that any previous pending and running Rollouts and associated
     * Operations will be automatically cancelled so that the latest Rollout will
     * not be blocked by previous Rollouts.
     * Only the 100 most recent (in any state) and the last 10 successful (if not
     * already part of the set of 100 most recent) rollouts are kept for each
     * service. The rest will be deleted eventually.
     * Operation&lt;response: Rollout&gt;
     * </pre>
     */
    public void createServiceRollout(com.google.api.servicemanagement.v1.CreateServiceRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceRolloutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates and returns a report (errors, warnings and changes from
     * existing configurations) associated with
     * GenerateConfigReportRequest.new_value
     * If GenerateConfigReportRequest.old_value is specified,
     * GenerateConfigReportRequest will contain a single ChangeReport based on the
     * comparison between GenerateConfigReportRequest.new_value and
     * GenerateConfigReportRequest.old_value.
     * If GenerateConfigReportRequest.old_value is not specified, this method
     * will compare GenerateConfigReportRequest.new_value with the last pushed
     * service configuration.
     * </pre>
     */
    public void generateConfigReport(com.google.api.servicemanagement.v1.GenerateConfigReportRequest request,
        io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.GenerateConfigReportResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateConfigReportMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * [Google Service Management
   * API](https://cloud.google.com/service-infrastructure/docs/overview)
   * </pre>
   */
  public static final class ServiceManagerBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceManagerBlockingStub> {
    private ServiceManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceManagerBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists managed services.
     * Returns all public services. For authenticated users, also returns all
     * services the calling user has "servicemanagement.services.get" permission
     * for.
     * </pre>
     */
    public com.google.api.servicemanagement.v1.ListServicesResponse listServices(com.google.api.servicemanagement.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a managed service. Authentication is required unless the service is
     * public.
     * </pre>
     */
    public com.google.api.servicemanagement.v1.ManagedService getService(com.google.api.servicemanagement.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new managed service.
     * A managed service is immutable, and is subject to mandatory 30-day
     * data retention. You cannot move a service or recreate it within 30 days
     * after deletion.
     * One producer project can own no more than 500 services. For security and
     * reliability purposes, a production service should be hosted in a
     * dedicated producer project.
     * Operation&lt;response: ManagedService&gt;
     * </pre>
     */
    public com.google.longrunning.Operation createService(com.google.api.servicemanagement.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a managed service. This method will change the service to the
     * `Soft-Delete` state for 30 days. Within this period, service producers may
     * call
     * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService]
     * to restore the service. After 30 days, the service will be permanently
     * deleted.
     * Operation&lt;response: google.protobuf.Empty&gt;
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(com.google.api.servicemanagement.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Revives a previously deleted managed service. The method restores the
     * service using the configuration at the time the service was deleted.
     * The target service must exist and must have been deleted within the
     * last 30 days.
     * Operation&lt;response: UndeleteServiceResponse&gt;
     * </pre>
     */
    public com.google.longrunning.Operation undeleteService(com.google.api.servicemanagement.v1.UndeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the history of the service configuration for a managed service,
     * from the newest to the oldest.
     * </pre>
     */
    public com.google.api.servicemanagement.v1.ListServiceConfigsResponse listServiceConfigs(com.google.api.servicemanagement.v1.ListServiceConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a service configuration (version) for a managed service.
     * </pre>
     */
    public com.google.api.Service getServiceConfig(com.google.api.servicemanagement.v1.GetServiceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service.
     * This method only stores the service configuration. To roll out the service
     * configuration to backend systems please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent service configurations and ones referenced by
     * existing rollouts are kept for each service. The rest will be deleted
     * eventually.
     * </pre>
     */
    public com.google.api.Service createServiceConfig(com.google.api.servicemanagement.v1.CreateServiceConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service based
     * on
     * user-supplied configuration source files (for example: OpenAPI
     * Specification). This method stores the source configurations as well as the
     * generated service configuration. To rollout the service configuration to
     * other services,
     * please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent configuration sources and ones referenced by
     * existing service configurtions are kept for each service. The rest will be
     * deleted eventually.
     * Operation&lt;response: SubmitConfigSourceResponse&gt;
     * </pre>
     */
    public com.google.longrunning.Operation submitConfigSource(com.google.api.servicemanagement.v1.SubmitConfigSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubmitConfigSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists the history of the service configuration rollouts for a managed
     * service, from the newest to the oldest.
     * </pre>
     */
    public com.google.api.servicemanagement.v1.ListServiceRolloutsResponse listServiceRollouts(com.google.api.servicemanagement.v1.ListServiceRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceRolloutsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a service configuration
     * [rollout][google.api.servicemanagement.v1.Rollout].
     * </pre>
     */
    public com.google.api.servicemanagement.v1.Rollout getServiceRollout(com.google.api.servicemanagement.v1.GetServiceRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceRolloutMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new service configuration rollout. Based on rollout, the
     * Google Service Management will roll out the service configurations to
     * different backend services. For example, the logging configuration will be
     * pushed to Google Cloud Logging.
     * Please note that any previous pending and running Rollouts and associated
     * Operations will be automatically cancelled so that the latest Rollout will
     * not be blocked by previous Rollouts.
     * Only the 100 most recent (in any state) and the last 10 successful (if not
     * already part of the set of 100 most recent) rollouts are kept for each
     * service. The rest will be deleted eventually.
     * Operation&lt;response: Rollout&gt;
     * </pre>
     */
    public com.google.longrunning.Operation createServiceRollout(com.google.api.servicemanagement.v1.CreateServiceRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceRolloutMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates and returns a report (errors, warnings and changes from
     * existing configurations) associated with
     * GenerateConfigReportRequest.new_value
     * If GenerateConfigReportRequest.old_value is specified,
     * GenerateConfigReportRequest will contain a single ChangeReport based on the
     * comparison between GenerateConfigReportRequest.new_value and
     * GenerateConfigReportRequest.old_value.
     * If GenerateConfigReportRequest.old_value is not specified, this method
     * will compare GenerateConfigReportRequest.new_value with the last pushed
     * service configuration.
     * </pre>
     */
    public com.google.api.servicemanagement.v1.GenerateConfigReportResponse generateConfigReport(com.google.api.servicemanagement.v1.GenerateConfigReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateConfigReportMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * [Google Service Management
   * API](https://cloud.google.com/service-infrastructure/docs/overview)
   * </pre>
   */
  public static final class ServiceManagerFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceManagerFutureStub> {
    private ServiceManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceManagerFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists managed services.
     * Returns all public services. For authenticated users, also returns all
     * services the calling user has "servicemanagement.services.get" permission
     * for.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.ListServicesResponse> listServices(
        com.google.api.servicemanagement.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a managed service. Authentication is required unless the service is
     * public.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.ManagedService> getService(
        com.google.api.servicemanagement.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new managed service.
     * A managed service is immutable, and is subject to mandatory 30-day
     * data retention. You cannot move a service or recreate it within 30 days
     * after deletion.
     * One producer project can own no more than 500 services. For security and
     * reliability purposes, a production service should be hosted in a
     * dedicated producer project.
     * Operation&lt;response: ManagedService&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createService(
        com.google.api.servicemanagement.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a managed service. This method will change the service to the
     * `Soft-Delete` state for 30 days. Within this period, service producers may
     * call
     * [UndeleteService][google.api.servicemanagement.v1.ServiceManager.UndeleteService]
     * to restore the service. After 30 days, the service will be permanently
     * deleted.
     * Operation&lt;response: google.protobuf.Empty&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteService(
        com.google.api.servicemanagement.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Revives a previously deleted managed service. The method restores the
     * service using the configuration at the time the service was deleted.
     * The target service must exist and must have been deleted within the
     * last 30 days.
     * Operation&lt;response: UndeleteServiceResponse&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeleteService(
        com.google.api.servicemanagement.v1.UndeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the history of the service configuration for a managed service,
     * from the newest to the oldest.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.ListServiceConfigsResponse> listServiceConfigs(
        com.google.api.servicemanagement.v1.ListServiceConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a service configuration (version) for a managed service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.Service> getServiceConfig(
        com.google.api.servicemanagement.v1.GetServiceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service.
     * This method only stores the service configuration. To roll out the service
     * configuration to backend systems please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent service configurations and ones referenced by
     * existing rollouts are kept for each service. The rest will be deleted
     * eventually.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.Service> createServiceConfig(
        com.google.api.servicemanagement.v1.CreateServiceConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new service configuration (version) for a managed service based
     * on
     * user-supplied configuration source files (for example: OpenAPI
     * Specification). This method stores the source configurations as well as the
     * generated service configuration. To rollout the service configuration to
     * other services,
     * please call
     * [CreateServiceRollout][google.api.servicemanagement.v1.ServiceManager.CreateServiceRollout].
     * Only the 100 most recent configuration sources and ones referenced by
     * existing service configurtions are kept for each service. The rest will be
     * deleted eventually.
     * Operation&lt;response: SubmitConfigSourceResponse&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> submitConfigSource(
        com.google.api.servicemanagement.v1.SubmitConfigSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubmitConfigSourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists the history of the service configuration rollouts for a managed
     * service, from the newest to the oldest.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.ListServiceRolloutsResponse> listServiceRollouts(
        com.google.api.servicemanagement.v1.ListServiceRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceRolloutsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a service configuration
     * [rollout][google.api.servicemanagement.v1.Rollout].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.Rollout> getServiceRollout(
        com.google.api.servicemanagement.v1.GetServiceRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceRolloutMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new service configuration rollout. Based on rollout, the
     * Google Service Management will roll out the service configurations to
     * different backend services. For example, the logging configuration will be
     * pushed to Google Cloud Logging.
     * Please note that any previous pending and running Rollouts and associated
     * Operations will be automatically cancelled so that the latest Rollout will
     * not be blocked by previous Rollouts.
     * Only the 100 most recent (in any state) and the last 10 successful (if not
     * already part of the set of 100 most recent) rollouts are kept for each
     * service. The rest will be deleted eventually.
     * Operation&lt;response: Rollout&gt;
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createServiceRollout(
        com.google.api.servicemanagement.v1.CreateServiceRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceRolloutMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates and returns a report (errors, warnings and changes from
     * existing configurations) associated with
     * GenerateConfigReportRequest.new_value
     * If GenerateConfigReportRequest.old_value is specified,
     * GenerateConfigReportRequest will contain a single ChangeReport based on the
     * comparison between GenerateConfigReportRequest.new_value and
     * GenerateConfigReportRequest.old_value.
     * If GenerateConfigReportRequest.old_value is not specified, this method
     * will compare GenerateConfigReportRequest.new_value with the last pushed
     * service configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.servicemanagement.v1.GenerateConfigReportResponse> generateConfigReport(
        com.google.api.servicemanagement.v1.GenerateConfigReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateConfigReportMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_SERVICES = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_CREATE_SERVICE = 2;
  private static final int METHODID_DELETE_SERVICE = 3;
  private static final int METHODID_UNDELETE_SERVICE = 4;
  private static final int METHODID_LIST_SERVICE_CONFIGS = 5;
  private static final int METHODID_GET_SERVICE_CONFIG = 6;
  private static final int METHODID_CREATE_SERVICE_CONFIG = 7;
  private static final int METHODID_SUBMIT_CONFIG_SOURCE = 8;
  private static final int METHODID_LIST_SERVICE_ROLLOUTS = 9;
  private static final int METHODID_GET_SERVICE_ROLLOUT = 10;
  private static final int METHODID_CREATE_SERVICE_ROLLOUT = 11;
  private static final int METHODID_GENERATE_CONFIG_REPORT = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices((com.google.api.servicemanagement.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServicesResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.google.api.servicemanagement.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ManagedService>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService((com.google.api.servicemanagement.v1.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService((com.google.api.servicemanagement.v1.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_SERVICE:
          serviceImpl.undeleteService((com.google.api.servicemanagement.v1.UndeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_CONFIGS:
          serviceImpl.listServiceConfigs((com.google.api.servicemanagement.v1.ListServiceConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceConfigsResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_CONFIG:
          serviceImpl.getServiceConfig((com.google.api.servicemanagement.v1.GetServiceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.Service>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_CONFIG:
          serviceImpl.createServiceConfig((com.google.api.servicemanagement.v1.CreateServiceConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.Service>) responseObserver);
          break;
        case METHODID_SUBMIT_CONFIG_SOURCE:
          serviceImpl.submitConfigSource((com.google.api.servicemanagement.v1.SubmitConfigSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_ROLLOUTS:
          serviceImpl.listServiceRollouts((com.google.api.servicemanagement.v1.ListServiceRolloutsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.ListServiceRolloutsResponse>) responseObserver);
          break;
        case METHODID_GET_SERVICE_ROLLOUT:
          serviceImpl.getServiceRollout((com.google.api.servicemanagement.v1.GetServiceRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.Rollout>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_ROLLOUT:
          serviceImpl.createServiceRollout((com.google.api.servicemanagement.v1.CreateServiceRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_CONFIG_REPORT:
          serviceImpl.generateConfigReport((com.google.api.servicemanagement.v1.GenerateConfigReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.servicemanagement.v1.GenerateConfigReportResponse>) responseObserver);
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

  private static abstract class ServiceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.servicemanagement.v1.ServiceManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceManager");
    }
  }

  private static final class ServiceManagerFileDescriptorSupplier
      extends ServiceManagerBaseDescriptorSupplier {
    ServiceManagerFileDescriptorSupplier() {}
  }

  private static final class ServiceManagerMethodDescriptorSupplier
      extends ServiceManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceManagerFileDescriptorSupplier())
              .addMethod(getListServicesMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getCreateServiceMethod())
              .addMethod(getDeleteServiceMethod())
              .addMethod(getUndeleteServiceMethod())
              .addMethod(getListServiceConfigsMethod())
              .addMethod(getGetServiceConfigMethod())
              .addMethod(getCreateServiceConfigMethod())
              .addMethod(getSubmitConfigSourceMethod())
              .addMethod(getListServiceRolloutsMethod())
              .addMethod(getGetServiceRolloutMethod())
              .addMethod(getCreateServiceRolloutMethod())
              .addMethod(getGenerateConfigReportMethod())
              .build();
        }
      }
    }
    return result;
  }
}
