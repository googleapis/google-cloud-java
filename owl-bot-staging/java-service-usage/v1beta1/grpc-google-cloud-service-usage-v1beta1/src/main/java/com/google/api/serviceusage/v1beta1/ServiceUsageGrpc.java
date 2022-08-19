package com.google.api.serviceusage.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/serviceusage/v1beta1/serviceusage.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceUsageGrpc {

  private ServiceUsageGrpc() {}

  public static final String SERVICE_NAME = "google.api.serviceusage.v1beta1.ServiceUsage";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.EnableServiceRequest,
      com.google.longrunning.Operation> getEnableServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableService",
      requestType = com.google.api.serviceusage.v1beta1.EnableServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.EnableServiceRequest,
      com.google.longrunning.Operation> getEnableServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.EnableServiceRequest, com.google.longrunning.Operation> getEnableServiceMethod;
    if ((getEnableServiceMethod = ServiceUsageGrpc.getEnableServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getEnableServiceMethod = ServiceUsageGrpc.getEnableServiceMethod) == null) {
          ServiceUsageGrpc.getEnableServiceMethod = getEnableServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.EnableServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.EnableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("EnableService"))
              .build();
        }
      }
    }
    return getEnableServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DisableServiceRequest,
      com.google.longrunning.Operation> getDisableServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableService",
      requestType = com.google.api.serviceusage.v1beta1.DisableServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DisableServiceRequest,
      com.google.longrunning.Operation> getDisableServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DisableServiceRequest, com.google.longrunning.Operation> getDisableServiceMethod;
    if ((getDisableServiceMethod = ServiceUsageGrpc.getDisableServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getDisableServiceMethod = ServiceUsageGrpc.getDisableServiceMethod) == null) {
          ServiceUsageGrpc.getDisableServiceMethod = getDisableServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.DisableServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.DisableServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("DisableService"))
              .build();
        }
      }
    }
    return getDisableServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetServiceRequest,
      com.google.api.serviceusage.v1beta1.Service> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.api.serviceusage.v1beta1.GetServiceRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetServiceRequest,
      com.google.api.serviceusage.v1beta1.Service> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetServiceRequest, com.google.api.serviceusage.v1beta1.Service> getGetServiceMethod;
    if ((getGetServiceMethod = ServiceUsageGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getGetServiceMethod = ServiceUsageGrpc.getGetServiceMethod) == null) {
          ServiceUsageGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.GetServiceRequest, com.google.api.serviceusage.v1beta1.Service>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.Service.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("GetService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListServicesRequest,
      com.google.api.serviceusage.v1beta1.ListServicesResponse> getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.api.serviceusage.v1beta1.ListServicesRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListServicesRequest,
      com.google.api.serviceusage.v1beta1.ListServicesResponse> getListServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListServicesRequest, com.google.api.serviceusage.v1beta1.ListServicesResponse> getListServicesMethod;
    if ((getListServicesMethod = ServiceUsageGrpc.getListServicesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getListServicesMethod = ServiceUsageGrpc.getListServicesMethod) == null) {
          ServiceUsageGrpc.getListServicesMethod = getListServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ListServicesRequest, com.google.api.serviceusage.v1beta1.ListServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ListServices"))
              .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest,
      com.google.longrunning.Operation> getBatchEnableServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchEnableServices",
      requestType = com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest,
      com.google.longrunning.Operation> getBatchEnableServicesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest, com.google.longrunning.Operation> getBatchEnableServicesMethod;
    if ((getBatchEnableServicesMethod = ServiceUsageGrpc.getBatchEnableServicesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getBatchEnableServicesMethod = ServiceUsageGrpc.getBatchEnableServicesMethod) == null) {
          ServiceUsageGrpc.getBatchEnableServicesMethod = getBatchEnableServicesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchEnableServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("BatchEnableServices"))
              .build();
        }
      }
    }
    return getBatchEnableServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest,
      com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> getListConsumerQuotaMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConsumerQuotaMetrics",
      requestType = com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest,
      com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> getListConsumerQuotaMetricsMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest, com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> getListConsumerQuotaMetricsMethod;
    if ((getListConsumerQuotaMetricsMethod = ServiceUsageGrpc.getListConsumerQuotaMetricsMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getListConsumerQuotaMetricsMethod = ServiceUsageGrpc.getListConsumerQuotaMetricsMethod) == null) {
          ServiceUsageGrpc.getListConsumerQuotaMetricsMethod = getListConsumerQuotaMetricsMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest, com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConsumerQuotaMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ListConsumerQuotaMetrics"))
              .build();
        }
      }
    }
    return getListConsumerQuotaMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest,
      com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> getGetConsumerQuotaMetricMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConsumerQuotaMetric",
      requestType = com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest,
      com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> getGetConsumerQuotaMetricMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest, com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> getGetConsumerQuotaMetricMethod;
    if ((getGetConsumerQuotaMetricMethod = ServiceUsageGrpc.getGetConsumerQuotaMetricMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getGetConsumerQuotaMetricMethod = ServiceUsageGrpc.getGetConsumerQuotaMetricMethod) == null) {
          ServiceUsageGrpc.getGetConsumerQuotaMetricMethod = getGetConsumerQuotaMetricMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest, com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConsumerQuotaMetric"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("GetConsumerQuotaMetric"))
              .build();
        }
      }
    }
    return getGetConsumerQuotaMetricMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest,
      com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> getGetConsumerQuotaLimitMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConsumerQuotaLimit",
      requestType = com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest,
      com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> getGetConsumerQuotaLimitMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest, com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> getGetConsumerQuotaLimitMethod;
    if ((getGetConsumerQuotaLimitMethod = ServiceUsageGrpc.getGetConsumerQuotaLimitMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getGetConsumerQuotaLimitMethod = ServiceUsageGrpc.getGetConsumerQuotaLimitMethod) == null) {
          ServiceUsageGrpc.getGetConsumerQuotaLimitMethod = getGetConsumerQuotaLimitMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest, com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConsumerQuotaLimit"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("GetConsumerQuotaLimit"))
              .build();
        }
      }
    }
    return getGetConsumerQuotaLimitMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest,
      com.google.longrunning.Operation> getCreateAdminOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAdminOverride",
      requestType = com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest,
      com.google.longrunning.Operation> getCreateAdminOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest, com.google.longrunning.Operation> getCreateAdminOverrideMethod;
    if ((getCreateAdminOverrideMethod = ServiceUsageGrpc.getCreateAdminOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getCreateAdminOverrideMethod = ServiceUsageGrpc.getCreateAdminOverrideMethod) == null) {
          ServiceUsageGrpc.getCreateAdminOverrideMethod = getCreateAdminOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAdminOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("CreateAdminOverride"))
              .build();
        }
      }
    }
    return getCreateAdminOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest,
      com.google.longrunning.Operation> getUpdateAdminOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAdminOverride",
      requestType = com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest,
      com.google.longrunning.Operation> getUpdateAdminOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest, com.google.longrunning.Operation> getUpdateAdminOverrideMethod;
    if ((getUpdateAdminOverrideMethod = ServiceUsageGrpc.getUpdateAdminOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getUpdateAdminOverrideMethod = ServiceUsageGrpc.getUpdateAdminOverrideMethod) == null) {
          ServiceUsageGrpc.getUpdateAdminOverrideMethod = getUpdateAdminOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAdminOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("UpdateAdminOverride"))
              .build();
        }
      }
    }
    return getUpdateAdminOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest,
      com.google.longrunning.Operation> getDeleteAdminOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAdminOverride",
      requestType = com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest,
      com.google.longrunning.Operation> getDeleteAdminOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest, com.google.longrunning.Operation> getDeleteAdminOverrideMethod;
    if ((getDeleteAdminOverrideMethod = ServiceUsageGrpc.getDeleteAdminOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getDeleteAdminOverrideMethod = ServiceUsageGrpc.getDeleteAdminOverrideMethod) == null) {
          ServiceUsageGrpc.getDeleteAdminOverrideMethod = getDeleteAdminOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAdminOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("DeleteAdminOverride"))
              .build();
        }
      }
    }
    return getDeleteAdminOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest,
      com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> getListAdminOverridesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAdminOverrides",
      requestType = com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest,
      com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> getListAdminOverridesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest, com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> getListAdminOverridesMethod;
    if ((getListAdminOverridesMethod = ServiceUsageGrpc.getListAdminOverridesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getListAdminOverridesMethod = ServiceUsageGrpc.getListAdminOverridesMethod) == null) {
          ServiceUsageGrpc.getListAdminOverridesMethod = getListAdminOverridesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest, com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAdminOverrides"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ListAdminOverrides"))
              .build();
        }
      }
    }
    return getListAdminOverridesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest,
      com.google.longrunning.Operation> getImportAdminOverridesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAdminOverrides",
      requestType = com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest,
      com.google.longrunning.Operation> getImportAdminOverridesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest, com.google.longrunning.Operation> getImportAdminOverridesMethod;
    if ((getImportAdminOverridesMethod = ServiceUsageGrpc.getImportAdminOverridesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getImportAdminOverridesMethod = ServiceUsageGrpc.getImportAdminOverridesMethod) == null) {
          ServiceUsageGrpc.getImportAdminOverridesMethod = getImportAdminOverridesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportAdminOverrides"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ImportAdminOverrides"))
              .build();
        }
      }
    }
    return getImportAdminOverridesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest,
      com.google.longrunning.Operation> getCreateConsumerOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConsumerOverride",
      requestType = com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest,
      com.google.longrunning.Operation> getCreateConsumerOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest, com.google.longrunning.Operation> getCreateConsumerOverrideMethod;
    if ((getCreateConsumerOverrideMethod = ServiceUsageGrpc.getCreateConsumerOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getCreateConsumerOverrideMethod = ServiceUsageGrpc.getCreateConsumerOverrideMethod) == null) {
          ServiceUsageGrpc.getCreateConsumerOverrideMethod = getCreateConsumerOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConsumerOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("CreateConsumerOverride"))
              .build();
        }
      }
    }
    return getCreateConsumerOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest,
      com.google.longrunning.Operation> getUpdateConsumerOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConsumerOverride",
      requestType = com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest,
      com.google.longrunning.Operation> getUpdateConsumerOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest, com.google.longrunning.Operation> getUpdateConsumerOverrideMethod;
    if ((getUpdateConsumerOverrideMethod = ServiceUsageGrpc.getUpdateConsumerOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getUpdateConsumerOverrideMethod = ServiceUsageGrpc.getUpdateConsumerOverrideMethod) == null) {
          ServiceUsageGrpc.getUpdateConsumerOverrideMethod = getUpdateConsumerOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConsumerOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("UpdateConsumerOverride"))
              .build();
        }
      }
    }
    return getUpdateConsumerOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest,
      com.google.longrunning.Operation> getDeleteConsumerOverrideMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConsumerOverride",
      requestType = com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest,
      com.google.longrunning.Operation> getDeleteConsumerOverrideMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest, com.google.longrunning.Operation> getDeleteConsumerOverrideMethod;
    if ((getDeleteConsumerOverrideMethod = ServiceUsageGrpc.getDeleteConsumerOverrideMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getDeleteConsumerOverrideMethod = ServiceUsageGrpc.getDeleteConsumerOverrideMethod) == null) {
          ServiceUsageGrpc.getDeleteConsumerOverrideMethod = getDeleteConsumerOverrideMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConsumerOverride"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("DeleteConsumerOverride"))
              .build();
        }
      }
    }
    return getDeleteConsumerOverrideMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest,
      com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> getListConsumerOverridesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConsumerOverrides",
      requestType = com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest.class,
      responseType = com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest,
      com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> getListConsumerOverridesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest, com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> getListConsumerOverridesMethod;
    if ((getListConsumerOverridesMethod = ServiceUsageGrpc.getListConsumerOverridesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getListConsumerOverridesMethod = ServiceUsageGrpc.getListConsumerOverridesMethod) == null) {
          ServiceUsageGrpc.getListConsumerOverridesMethod = getListConsumerOverridesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest, com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConsumerOverrides"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ListConsumerOverrides"))
              .build();
        }
      }
    }
    return getListConsumerOverridesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest,
      com.google.longrunning.Operation> getImportConsumerOverridesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportConsumerOverrides",
      requestType = com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest,
      com.google.longrunning.Operation> getImportConsumerOverridesMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest, com.google.longrunning.Operation> getImportConsumerOverridesMethod;
    if ((getImportConsumerOverridesMethod = ServiceUsageGrpc.getImportConsumerOverridesMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getImportConsumerOverridesMethod = ServiceUsageGrpc.getImportConsumerOverridesMethod) == null) {
          ServiceUsageGrpc.getImportConsumerOverridesMethod = getImportConsumerOverridesMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportConsumerOverrides"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("ImportConsumerOverrides"))
              .build();
        }
      }
    }
    return getImportConsumerOverridesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest,
      com.google.longrunning.Operation> getGenerateServiceIdentityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateServiceIdentity",
      requestType = com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest,
      com.google.longrunning.Operation> getGenerateServiceIdentityMethod() {
    io.grpc.MethodDescriptor<com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest, com.google.longrunning.Operation> getGenerateServiceIdentityMethod;
    if ((getGenerateServiceIdentityMethod = ServiceUsageGrpc.getGenerateServiceIdentityMethod) == null) {
      synchronized (ServiceUsageGrpc.class) {
        if ((getGenerateServiceIdentityMethod = ServiceUsageGrpc.getGenerateServiceIdentityMethod) == null) {
          ServiceUsageGrpc.getGenerateServiceIdentityMethod = getGenerateServiceIdentityMethod =
              io.grpc.MethodDescriptor.<com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GenerateServiceIdentity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceUsageMethodDescriptorSupplier("GenerateServiceIdentity"))
              .build();
        }
      }
    }
    return getGenerateServiceIdentityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceUsageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageStub>() {
        @java.lang.Override
        public ServiceUsageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageStub(channel, callOptions);
        }
      };
    return ServiceUsageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceUsageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageBlockingStub>() {
        @java.lang.Override
        public ServiceUsageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageBlockingStub(channel, callOptions);
        }
      };
    return ServiceUsageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceUsageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceUsageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceUsageFutureStub>() {
        @java.lang.Override
        public ServiceUsageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceUsageFutureStub(channel, callOptions);
        }
      };
    return ServiceUsageFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static abstract class ServiceUsageImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Enables a service so that it can be used with a project.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void enableService(com.google.api.serviceusage.v1beta1.EnableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEnableServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Disables a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void disableService(com.google.api.serviceusage.v1beta1.DisableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDisableServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    @java.lang.Deprecated
    public void getService(com.google.api.serviceusage.v1beta1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * </pre>
     */
    @java.lang.Deprecated
    public void listServices(com.google.api.serviceusage.v1beta1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Enables multiple services on a project. The operation is atomic: if
     * enabling any service fails, then the entire batch fails, and no state
     * changes occur.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void batchEnableServices(com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBatchEnableServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of all quota information visible to the service
     * consumer, organized by service metric. Each metric includes information
     * about all of its defined limits. Each limit includes the limit
     * configuration (quota unit, preciseness, default value), the current
     * effective limit value, and all of the overrides applied to the limit.
     * </pre>
     */
    public void listConsumerQuotaMetrics(com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConsumerQuotaMetricsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota metric
     * </pre>
     */
    public void getConsumerQuotaMetric(com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConsumerQuotaMetricMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota limit.
     * </pre>
     */
    public void getConsumerQuotaLimit(com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetConsumerQuotaLimitMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an admin override.
     * An admin override is applied by an administrator of a parent folder or
     * parent organization of the consumer receiving the override. An admin
     * override is intended to limit the amount of quota the consumer can use out
     * of the total quota pool allocated to all children of the folder or
     * organization.
     * </pre>
     */
    public void createAdminOverride(com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAdminOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an admin override.
     * </pre>
     */
    public void updateAdminOverride(com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAdminOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an admin override.
     * </pre>
     */
    public void deleteAdminOverride(com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAdminOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all admin overrides on this limit.
     * </pre>
     */
    public void listAdminOverrides(com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAdminOverridesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates or updates multiple admin overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public void importAdminOverrides(com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportAdminOverridesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a consumer override.
     * A consumer override is applied to the consumer on its own authority to
     * limit its own quota usage. Consumer overrides cannot be used to grant more
     * quota than would be allowed by admin overrides, producer overrides, or the
     * default limit of the service.
     * </pre>
     */
    public void createConsumerOverride(com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateConsumerOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a consumer override.
     * </pre>
     */
    public void updateConsumerOverride(com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateConsumerOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a consumer override.
     * </pre>
     */
    public void deleteConsumerOverride(com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteConsumerOverrideMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all consumer overrides on this limit.
     * </pre>
     */
    public void listConsumerOverrides(com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListConsumerOverridesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates or updates multiple consumer overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public void importConsumerOverrides(com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportConsumerOverridesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Generates service identity for service.
     * </pre>
     */
    public void generateServiceIdentity(com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGenerateServiceIdentityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getEnableServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.EnableServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_ENABLE_SERVICE)))
          .addMethod(
            getDisableServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.DisableServiceRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DISABLE_SERVICE)))
          .addMethod(
            getGetServiceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.GetServiceRequest,
                com.google.api.serviceusage.v1beta1.Service>(
                  this, METHODID_GET_SERVICE)))
          .addMethod(
            getListServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ListServicesRequest,
                com.google.api.serviceusage.v1beta1.ListServicesResponse>(
                  this, METHODID_LIST_SERVICES)))
          .addMethod(
            getBatchEnableServicesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_BATCH_ENABLE_SERVICES)))
          .addMethod(
            getListConsumerQuotaMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest,
                com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse>(
                  this, METHODID_LIST_CONSUMER_QUOTA_METRICS)))
          .addMethod(
            getGetConsumerQuotaMetricMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest,
                com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric>(
                  this, METHODID_GET_CONSUMER_QUOTA_METRIC)))
          .addMethod(
            getGetConsumerQuotaLimitMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest,
                com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit>(
                  this, METHODID_GET_CONSUMER_QUOTA_LIMIT)))
          .addMethod(
            getCreateAdminOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_ADMIN_OVERRIDE)))
          .addMethod(
            getUpdateAdminOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_ADMIN_OVERRIDE)))
          .addMethod(
            getDeleteAdminOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_ADMIN_OVERRIDE)))
          .addMethod(
            getListAdminOverridesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest,
                com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse>(
                  this, METHODID_LIST_ADMIN_OVERRIDES)))
          .addMethod(
            getImportAdminOverridesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_IMPORT_ADMIN_OVERRIDES)))
          .addMethod(
            getCreateConsumerOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_CREATE_CONSUMER_OVERRIDE)))
          .addMethod(
            getUpdateConsumerOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_UPDATE_CONSUMER_OVERRIDE)))
          .addMethod(
            getDeleteConsumerOverrideMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_CONSUMER_OVERRIDE)))
          .addMethod(
            getListConsumerOverridesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest,
                com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse>(
                  this, METHODID_LIST_CONSUMER_OVERRIDES)))
          .addMethod(
            getImportConsumerOverridesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_IMPORT_CONSUMER_OVERRIDES)))
          .addMethod(
            getGenerateServiceIdentityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_GENERATE_SERVICE_IDENTITY)))
          .build();
    }
  }

  /**
   * <pre>
   * [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageStub extends io.grpc.stub.AbstractAsyncStub<ServiceUsageStub> {
    private ServiceUsageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enables a service so that it can be used with a project.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void enableService(com.google.api.serviceusage.v1beta1.EnableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Disables a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void disableService(com.google.api.serviceusage.v1beta1.DisableServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    @java.lang.Deprecated
    public void getService(com.google.api.serviceusage.v1beta1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * </pre>
     */
    @java.lang.Deprecated
    public void listServices(com.google.api.serviceusage.v1beta1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Enables multiple services on a project. The operation is atomic: if
     * enabling any service fails, then the entire batch fails, and no state
     * changes occur.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public void batchEnableServices(com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchEnableServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of all quota information visible to the service
     * consumer, organized by service metric. Each metric includes information
     * about all of its defined limits. Each limit includes the limit
     * configuration (quota unit, preciseness, default value), the current
     * effective limit value, and all of the overrides applied to the limit.
     * </pre>
     */
    public void listConsumerQuotaMetrics(com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConsumerQuotaMetricsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota metric
     * </pre>
     */
    public void getConsumerQuotaMetric(com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConsumerQuotaMetricMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota limit.
     * </pre>
     */
    public void getConsumerQuotaLimit(com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConsumerQuotaLimitMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an admin override.
     * An admin override is applied by an administrator of a parent folder or
     * parent organization of the consumer receiving the override. An admin
     * override is intended to limit the amount of quota the consumer can use out
     * of the total quota pool allocated to all children of the folder or
     * organization.
     * </pre>
     */
    public void createAdminOverride(com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAdminOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an admin override.
     * </pre>
     */
    public void updateAdminOverride(com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAdminOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an admin override.
     * </pre>
     */
    public void deleteAdminOverride(com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAdminOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all admin overrides on this limit.
     * </pre>
     */
    public void listAdminOverrides(com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAdminOverridesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates or updates multiple admin overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public void importAdminOverrides(com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAdminOverridesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a consumer override.
     * A consumer override is applied to the consumer on its own authority to
     * limit its own quota usage. Consumer overrides cannot be used to grant more
     * quota than would be allowed by admin overrides, producer overrides, or the
     * default limit of the service.
     * </pre>
     */
    public void createConsumerOverride(com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConsumerOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a consumer override.
     * </pre>
     */
    public void updateConsumerOverride(com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConsumerOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a consumer override.
     * </pre>
     */
    public void deleteConsumerOverride(com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConsumerOverrideMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all consumer overrides on this limit.
     * </pre>
     */
    public void listConsumerOverrides(com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConsumerOverridesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates or updates multiple consumer overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public void importConsumerOverrides(com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportConsumerOverridesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Generates service identity for service.
     * </pre>
     */
    public void generateServiceIdentity(com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateServiceIdentityMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceUsageBlockingStub> {
    private ServiceUsageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enables a service so that it can be used with a project.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation enableService(com.google.api.serviceusage.v1beta1.EnableServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Disables a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation disableService(com.google.api.serviceusage.v1beta1.DisableServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.api.serviceusage.v1beta1.Service getService(com.google.api.serviceusage.v1beta1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.api.serviceusage.v1beta1.ListServicesResponse listServices(com.google.api.serviceusage.v1beta1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Enables multiple services on a project. The operation is atomic: if
     * enabling any service fails, then the entire batch fails, and no state
     * changes occur.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.longrunning.Operation batchEnableServices(com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchEnableServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a summary of all quota information visible to the service
     * consumer, organized by service metric. Each metric includes information
     * about all of its defined limits. Each limit includes the limit
     * configuration (quota unit, preciseness, default value), the current
     * effective limit value, and all of the overrides applied to the limit.
     * </pre>
     */
    public com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse listConsumerQuotaMetrics(com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConsumerQuotaMetricsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota metric
     * </pre>
     */
    public com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric getConsumerQuotaMetric(com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConsumerQuotaMetricMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota limit.
     * </pre>
     */
    public com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit getConsumerQuotaLimit(com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConsumerQuotaLimitMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an admin override.
     * An admin override is applied by an administrator of a parent folder or
     * parent organization of the consumer receiving the override. An admin
     * override is intended to limit the amount of quota the consumer can use out
     * of the total quota pool allocated to all children of the folder or
     * organization.
     * </pre>
     */
    public com.google.longrunning.Operation createAdminOverride(com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAdminOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an admin override.
     * </pre>
     */
    public com.google.longrunning.Operation updateAdminOverride(com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAdminOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an admin override.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAdminOverride(com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAdminOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all admin overrides on this limit.
     * </pre>
     */
    public com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse listAdminOverrides(com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAdminOverridesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates or updates multiple admin overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public com.google.longrunning.Operation importAdminOverrides(com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAdminOverridesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a consumer override.
     * A consumer override is applied to the consumer on its own authority to
     * limit its own quota usage. Consumer overrides cannot be used to grant more
     * quota than would be allowed by admin overrides, producer overrides, or the
     * default limit of the service.
     * </pre>
     */
    public com.google.longrunning.Operation createConsumerOverride(com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConsumerOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a consumer override.
     * </pre>
     */
    public com.google.longrunning.Operation updateConsumerOverride(com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConsumerOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a consumer override.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConsumerOverride(com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConsumerOverrideMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all consumer overrides on this limit.
     * </pre>
     */
    public com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse listConsumerOverrides(com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConsumerOverridesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates or updates multiple consumer overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public com.google.longrunning.Operation importConsumerOverrides(com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportConsumerOverridesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Generates service identity for service.
     * </pre>
     */
    public com.google.longrunning.Operation generateServiceIdentity(com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateServiceIdentityMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * [Service Usage API](https://cloud.google.com/service-usage/docs/overview)
   * </pre>
   */
  public static final class ServiceUsageFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceUsageFutureStub> {
    private ServiceUsageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceUsageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceUsageFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Enables a service so that it can be used with a project.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> enableService(
        com.google.api.serviceusage.v1beta1.EnableServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Disables a service so that it can no longer be used with a project.
     * This prevents unintended usage that may cause unexpected billing
     * charges or security leaks.
     * It is not valid to call the disable method on a service that is not
     * currently enabled. Callers will receive a `FAILED_PRECONDITION` status if
     * the target service is not currently enabled.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> disableService(
        com.google.api.serviceusage.v1beta1.DisableServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the service configuration and enabled state for a given service.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.Service> getService(
        com.google.api.serviceusage.v1beta1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all services available to the specified project, and the current
     * state of those services with respect to the project. The list includes
     * all public services, all services for which the calling user has the
     * `servicemanagement.services.bind` permission, and all services that have
     * already been enabled on the project. The list can be filtered to
     * only include services in a specific state, for example to only include
     * services enabled on the project.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ListServicesResponse> listServices(
        com.google.api.serviceusage.v1beta1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Enables multiple services on a project. The operation is atomic: if
     * enabling any service fails, then the entire batch fails, and no state
     * changes occur.
     * Operation response type: `google.protobuf.Empty`
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> batchEnableServices(
        com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchEnableServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a summary of all quota information visible to the service
     * consumer, organized by service metric. Each metric includes information
     * about all of its defined limits. Each limit includes the limit
     * configuration (quota unit, preciseness, default value), the current
     * effective limit value, and all of the overrides applied to the limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse> listConsumerQuotaMetrics(
        com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConsumerQuotaMetricsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota metric
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric> getConsumerQuotaMetric(
        com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConsumerQuotaMetricMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a summary of quota information for a specific quota limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit> getConsumerQuotaLimit(
        com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConsumerQuotaLimitMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an admin override.
     * An admin override is applied by an administrator of a parent folder or
     * parent organization of the consumer receiving the override. An admin
     * override is intended to limit the amount of quota the consumer can use out
     * of the total quota pool allocated to all children of the folder or
     * organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createAdminOverride(
        com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAdminOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an admin override.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateAdminOverride(
        com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAdminOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an admin override.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteAdminOverride(
        com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAdminOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all admin overrides on this limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse> listAdminOverrides(
        com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAdminOverridesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates or updates multiple admin overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> importAdminOverrides(
        com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAdminOverridesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a consumer override.
     * A consumer override is applied to the consumer on its own authority to
     * limit its own quota usage. Consumer overrides cannot be used to grant more
     * quota than would be allowed by admin overrides, producer overrides, or the
     * default limit of the service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createConsumerOverride(
        com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConsumerOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a consumer override.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateConsumerOverride(
        com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConsumerOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a consumer override.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteConsumerOverride(
        com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConsumerOverrideMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all consumer overrides on this limit.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse> listConsumerOverrides(
        com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConsumerOverridesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates or updates multiple consumer overrides atomically, all on the
     * same consumer, but on many different metrics or limits.
     * The name field in the quota override message should not be set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> importConsumerOverrides(
        com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportConsumerOverridesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Generates service identity for service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> generateServiceIdentity(
        com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateServiceIdentityMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENABLE_SERVICE = 0;
  private static final int METHODID_DISABLE_SERVICE = 1;
  private static final int METHODID_GET_SERVICE = 2;
  private static final int METHODID_LIST_SERVICES = 3;
  private static final int METHODID_BATCH_ENABLE_SERVICES = 4;
  private static final int METHODID_LIST_CONSUMER_QUOTA_METRICS = 5;
  private static final int METHODID_GET_CONSUMER_QUOTA_METRIC = 6;
  private static final int METHODID_GET_CONSUMER_QUOTA_LIMIT = 7;
  private static final int METHODID_CREATE_ADMIN_OVERRIDE = 8;
  private static final int METHODID_UPDATE_ADMIN_OVERRIDE = 9;
  private static final int METHODID_DELETE_ADMIN_OVERRIDE = 10;
  private static final int METHODID_LIST_ADMIN_OVERRIDES = 11;
  private static final int METHODID_IMPORT_ADMIN_OVERRIDES = 12;
  private static final int METHODID_CREATE_CONSUMER_OVERRIDE = 13;
  private static final int METHODID_UPDATE_CONSUMER_OVERRIDE = 14;
  private static final int METHODID_DELETE_CONSUMER_OVERRIDE = 15;
  private static final int METHODID_LIST_CONSUMER_OVERRIDES = 16;
  private static final int METHODID_IMPORT_CONSUMER_OVERRIDES = 17;
  private static final int METHODID_GENERATE_SERVICE_IDENTITY = 18;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceUsageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceUsageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ENABLE_SERVICE:
          serviceImpl.enableService((com.google.api.serviceusage.v1beta1.EnableServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_SERVICE:
          serviceImpl.disableService((com.google.api.serviceusage.v1beta1.DisableServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.google.api.serviceusage.v1beta1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.Service>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices((com.google.api.serviceusage.v1beta1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListServicesResponse>) responseObserver);
          break;
        case METHODID_BATCH_ENABLE_SERVICES:
          serviceImpl.batchEnableServices((com.google.api.serviceusage.v1beta1.BatchEnableServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CONSUMER_QUOTA_METRICS:
          serviceImpl.listConsumerQuotaMetrics((com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerQuotaMetricsResponse>) responseObserver);
          break;
        case METHODID_GET_CONSUMER_QUOTA_METRIC:
          serviceImpl.getConsumerQuotaMetric((com.google.api.serviceusage.v1beta1.GetConsumerQuotaMetricRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaMetric>) responseObserver);
          break;
        case METHODID_GET_CONSUMER_QUOTA_LIMIT:
          serviceImpl.getConsumerQuotaLimit((com.google.api.serviceusage.v1beta1.GetConsumerQuotaLimitRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ConsumerQuotaLimit>) responseObserver);
          break;
        case METHODID_CREATE_ADMIN_OVERRIDE:
          serviceImpl.createAdminOverride((com.google.api.serviceusage.v1beta1.CreateAdminOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ADMIN_OVERRIDE:
          serviceImpl.updateAdminOverride((com.google.api.serviceusage.v1beta1.UpdateAdminOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ADMIN_OVERRIDE:
          serviceImpl.deleteAdminOverride((com.google.api.serviceusage.v1beta1.DeleteAdminOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ADMIN_OVERRIDES:
          serviceImpl.listAdminOverrides((com.google.api.serviceusage.v1beta1.ListAdminOverridesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListAdminOverridesResponse>) responseObserver);
          break;
        case METHODID_IMPORT_ADMIN_OVERRIDES:
          serviceImpl.importAdminOverrides((com.google.api.serviceusage.v1beta1.ImportAdminOverridesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_CONSUMER_OVERRIDE:
          serviceImpl.createConsumerOverride((com.google.api.serviceusage.v1beta1.CreateConsumerOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONSUMER_OVERRIDE:
          serviceImpl.updateConsumerOverride((com.google.api.serviceusage.v1beta1.UpdateConsumerOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONSUMER_OVERRIDE:
          serviceImpl.deleteConsumerOverride((com.google.api.serviceusage.v1beta1.DeleteConsumerOverrideRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CONSUMER_OVERRIDES:
          serviceImpl.listConsumerOverrides((com.google.api.serviceusage.v1beta1.ListConsumerOverridesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.serviceusage.v1beta1.ListConsumerOverridesResponse>) responseObserver);
          break;
        case METHODID_IMPORT_CONSUMER_OVERRIDES:
          serviceImpl.importConsumerOverrides((com.google.api.serviceusage.v1beta1.ImportConsumerOverridesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_SERVICE_IDENTITY:
          serviceImpl.generateServiceIdentity((com.google.api.serviceusage.v1beta1.GenerateServiceIdentityRequest) request,
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

  private static abstract class ServiceUsageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceUsageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.serviceusage.v1beta1.ServiceUsageProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceUsage");
    }
  }

  private static final class ServiceUsageFileDescriptorSupplier
      extends ServiceUsageBaseDescriptorSupplier {
    ServiceUsageFileDescriptorSupplier() {}
  }

  private static final class ServiceUsageMethodDescriptorSupplier
      extends ServiceUsageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceUsageMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceUsageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceUsageFileDescriptorSupplier())
              .addMethod(getEnableServiceMethod())
              .addMethod(getDisableServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getListServicesMethod())
              .addMethod(getBatchEnableServicesMethod())
              .addMethod(getListConsumerQuotaMetricsMethod())
              .addMethod(getGetConsumerQuotaMetricMethod())
              .addMethod(getGetConsumerQuotaLimitMethod())
              .addMethod(getCreateAdminOverrideMethod())
              .addMethod(getUpdateAdminOverrideMethod())
              .addMethod(getDeleteAdminOverrideMethod())
              .addMethod(getListAdminOverridesMethod())
              .addMethod(getImportAdminOverridesMethod())
              .addMethod(getCreateConsumerOverrideMethod())
              .addMethod(getUpdateConsumerOverrideMethod())
              .addMethod(getDeleteConsumerOverrideMethod())
              .addMethod(getListConsumerOverridesMethod())
              .addMethod(getImportConsumerOverridesMethod())
              .addMethod(getGenerateServiceIdentityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
