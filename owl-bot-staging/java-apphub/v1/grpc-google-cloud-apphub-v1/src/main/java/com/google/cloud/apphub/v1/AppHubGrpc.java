package com.google.cloud.apphub.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The App Hub API allows you to manage App Hub resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/apphub/v1/apphub_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppHubGrpc {

  private AppHubGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.apphub.v1.AppHub";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> getLookupServiceProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupServiceProjectAttachment",
      requestType = com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest.class,
      responseType = com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> getLookupServiceProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> getLookupServiceProjectAttachmentMethod;
    if ((getLookupServiceProjectAttachmentMethod = AppHubGrpc.getLookupServiceProjectAttachmentMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getLookupServiceProjectAttachmentMethod = AppHubGrpc.getLookupServiceProjectAttachmentMethod) == null) {
          AppHubGrpc.getLookupServiceProjectAttachmentMethod = getLookupServiceProjectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupServiceProjectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("LookupServiceProjectAttachment"))
              .build();
        }
      }
    }
    return getLookupServiceProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest,
      com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> getListServiceProjectAttachmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceProjectAttachments",
      requestType = com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest.class,
      responseType = com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest,
      com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> getListServiceProjectAttachmentsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest, com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> getListServiceProjectAttachmentsMethod;
    if ((getListServiceProjectAttachmentsMethod = AppHubGrpc.getListServiceProjectAttachmentsMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListServiceProjectAttachmentsMethod = AppHubGrpc.getListServiceProjectAttachmentsMethod) == null) {
          AppHubGrpc.getListServiceProjectAttachmentsMethod = getListServiceProjectAttachmentsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest, com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServiceProjectAttachments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListServiceProjectAttachments"))
              .build();
        }
      }
    }
    return getListServiceProjectAttachmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest,
      com.google.longrunning.Operation> getCreateServiceProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceProjectAttachment",
      requestType = com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest,
      com.google.longrunning.Operation> getCreateServiceProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest, com.google.longrunning.Operation> getCreateServiceProjectAttachmentMethod;
    if ((getCreateServiceProjectAttachmentMethod = AppHubGrpc.getCreateServiceProjectAttachmentMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getCreateServiceProjectAttachmentMethod = AppHubGrpc.getCreateServiceProjectAttachmentMethod) == null) {
          AppHubGrpc.getCreateServiceProjectAttachmentMethod = getCreateServiceProjectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateServiceProjectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("CreateServiceProjectAttachment"))
              .build();
        }
      }
    }
    return getCreateServiceProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.ServiceProjectAttachment> getGetServiceProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceProjectAttachment",
      requestType = com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest.class,
      responseType = com.google.cloud.apphub.v1.ServiceProjectAttachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.ServiceProjectAttachment> getGetServiceProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.ServiceProjectAttachment> getGetServiceProjectAttachmentMethod;
    if ((getGetServiceProjectAttachmentMethod = AppHubGrpc.getGetServiceProjectAttachmentMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetServiceProjectAttachmentMethod = AppHubGrpc.getGetServiceProjectAttachmentMethod) == null) {
          AppHubGrpc.getGetServiceProjectAttachmentMethod = getGetServiceProjectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.ServiceProjectAttachment>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServiceProjectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ServiceProjectAttachment.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetServiceProjectAttachment"))
              .build();
        }
      }
    }
    return getGetServiceProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest,
      com.google.longrunning.Operation> getDeleteServiceProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceProjectAttachment",
      requestType = com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest,
      com.google.longrunning.Operation> getDeleteServiceProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest, com.google.longrunning.Operation> getDeleteServiceProjectAttachmentMethod;
    if ((getDeleteServiceProjectAttachmentMethod = AppHubGrpc.getDeleteServiceProjectAttachmentMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getDeleteServiceProjectAttachmentMethod = AppHubGrpc.getDeleteServiceProjectAttachmentMethod) == null) {
          AppHubGrpc.getDeleteServiceProjectAttachmentMethod = getDeleteServiceProjectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteServiceProjectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("DeleteServiceProjectAttachment"))
              .build();
        }
      }
    }
    return getDeleteServiceProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> getDetachServiceProjectAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DetachServiceProjectAttachment",
      requestType = com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest.class,
      responseType = com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest,
      com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> getDetachServiceProjectAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> getDetachServiceProjectAttachmentMethod;
    if ((getDetachServiceProjectAttachmentMethod = AppHubGrpc.getDetachServiceProjectAttachmentMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getDetachServiceProjectAttachmentMethod = AppHubGrpc.getDetachServiceProjectAttachmentMethod) == null) {
          AppHubGrpc.getDetachServiceProjectAttachmentMethod = getDetachServiceProjectAttachmentMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest, com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DetachServiceProjectAttachment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("DetachServiceProjectAttachment"))
              .build();
        }
      }
    }
    return getDetachServiceProjectAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredServicesRequest,
      com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> getListDiscoveredServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDiscoveredServices",
      requestType = com.google.cloud.apphub.v1.ListDiscoveredServicesRequest.class,
      responseType = com.google.cloud.apphub.v1.ListDiscoveredServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredServicesRequest,
      com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> getListDiscoveredServicesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredServicesRequest, com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> getListDiscoveredServicesMethod;
    if ((getListDiscoveredServicesMethod = AppHubGrpc.getListDiscoveredServicesMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListDiscoveredServicesMethod = AppHubGrpc.getListDiscoveredServicesMethod) == null) {
          AppHubGrpc.getListDiscoveredServicesMethod = getListDiscoveredServicesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListDiscoveredServicesRequest, com.google.cloud.apphub.v1.ListDiscoveredServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDiscoveredServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListDiscoveredServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListDiscoveredServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListDiscoveredServices"))
              .build();
        }
      }
    }
    return getListDiscoveredServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredServiceRequest,
      com.google.cloud.apphub.v1.DiscoveredService> getGetDiscoveredServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiscoveredService",
      requestType = com.google.cloud.apphub.v1.GetDiscoveredServiceRequest.class,
      responseType = com.google.cloud.apphub.v1.DiscoveredService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredServiceRequest,
      com.google.cloud.apphub.v1.DiscoveredService> getGetDiscoveredServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredServiceRequest, com.google.cloud.apphub.v1.DiscoveredService> getGetDiscoveredServiceMethod;
    if ((getGetDiscoveredServiceMethod = AppHubGrpc.getGetDiscoveredServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetDiscoveredServiceMethod = AppHubGrpc.getGetDiscoveredServiceMethod) == null) {
          AppHubGrpc.getGetDiscoveredServiceMethod = getGetDiscoveredServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetDiscoveredServiceRequest, com.google.cloud.apphub.v1.DiscoveredService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDiscoveredService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetDiscoveredServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DiscoveredService.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetDiscoveredService"))
              .build();
        }
      }
    }
    return getGetDiscoveredServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest,
      com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> getLookupDiscoveredServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupDiscoveredService",
      requestType = com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest.class,
      responseType = com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest,
      com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> getLookupDiscoveredServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest, com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> getLookupDiscoveredServiceMethod;
    if ((getLookupDiscoveredServiceMethod = AppHubGrpc.getLookupDiscoveredServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getLookupDiscoveredServiceMethod = AppHubGrpc.getLookupDiscoveredServiceMethod) == null) {
          AppHubGrpc.getLookupDiscoveredServiceMethod = getLookupDiscoveredServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest, com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupDiscoveredService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("LookupDiscoveredService"))
              .build();
        }
      }
    }
    return getLookupDiscoveredServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServicesRequest,
      com.google.cloud.apphub.v1.ListServicesResponse> getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.apphub.v1.ListServicesRequest.class,
      responseType = com.google.cloud.apphub.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServicesRequest,
      com.google.cloud.apphub.v1.ListServicesResponse> getListServicesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListServicesRequest, com.google.cloud.apphub.v1.ListServicesResponse> getListServicesMethod;
    if ((getListServicesMethod = AppHubGrpc.getListServicesMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListServicesMethod = AppHubGrpc.getListServicesMethod) == null) {
          AppHubGrpc.getListServicesMethod = getListServicesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListServicesRequest, com.google.cloud.apphub.v1.ListServicesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListServicesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListServicesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListServices"))
              .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceRequest,
      com.google.longrunning.Operation> getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.cloud.apphub.v1.CreateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceRequest,
      com.google.longrunning.Operation> getCreateServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateServiceRequest, com.google.longrunning.Operation> getCreateServiceMethod;
    if ((getCreateServiceMethod = AppHubGrpc.getCreateServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getCreateServiceMethod = AppHubGrpc.getCreateServiceMethod) == null) {
          AppHubGrpc.getCreateServiceMethod = getCreateServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.CreateServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.CreateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("CreateService"))
              .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceRequest,
      com.google.cloud.apphub.v1.Service> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.apphub.v1.GetServiceRequest.class,
      responseType = com.google.cloud.apphub.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceRequest,
      com.google.cloud.apphub.v1.Service> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetServiceRequest, com.google.cloud.apphub.v1.Service> getGetServiceMethod;
    if ((getGetServiceMethod = AppHubGrpc.getGetServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetServiceMethod = AppHubGrpc.getGetServiceMethod) == null) {
          AppHubGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetServiceRequest, com.google.cloud.apphub.v1.Service>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.Service.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateServiceRequest,
      com.google.longrunning.Operation> getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.cloud.apphub.v1.UpdateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateServiceRequest,
      com.google.longrunning.Operation> getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateServiceRequest, com.google.longrunning.Operation> getUpdateServiceMethod;
    if ((getUpdateServiceMethod = AppHubGrpc.getUpdateServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getUpdateServiceMethod = AppHubGrpc.getUpdateServiceMethod) == null) {
          AppHubGrpc.getUpdateServiceMethod = getUpdateServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.UpdateServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.UpdateServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("UpdateService"))
              .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceRequest,
      com.google.longrunning.Operation> getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.cloud.apphub.v1.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceRequest,
      com.google.longrunning.Operation> getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteServiceRequest, com.google.longrunning.Operation> getDeleteServiceMethod;
    if ((getDeleteServiceMethod = AppHubGrpc.getDeleteServiceMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getDeleteServiceMethod = AppHubGrpc.getDeleteServiceMethod) == null) {
          AppHubGrpc.getDeleteServiceMethod = getDeleteServiceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.DeleteServiceRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DeleteServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("DeleteService"))
              .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest,
      com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> getListDiscoveredWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDiscoveredWorkloads",
      requestType = com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest.class,
      responseType = com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest,
      com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> getListDiscoveredWorkloadsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest, com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> getListDiscoveredWorkloadsMethod;
    if ((getListDiscoveredWorkloadsMethod = AppHubGrpc.getListDiscoveredWorkloadsMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListDiscoveredWorkloadsMethod = AppHubGrpc.getListDiscoveredWorkloadsMethod) == null) {
          AppHubGrpc.getListDiscoveredWorkloadsMethod = getListDiscoveredWorkloadsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest, com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDiscoveredWorkloads"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListDiscoveredWorkloads"))
              .build();
        }
      }
    }
    return getListDiscoveredWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest,
      com.google.cloud.apphub.v1.DiscoveredWorkload> getGetDiscoveredWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDiscoveredWorkload",
      requestType = com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest.class,
      responseType = com.google.cloud.apphub.v1.DiscoveredWorkload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest,
      com.google.cloud.apphub.v1.DiscoveredWorkload> getGetDiscoveredWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest, com.google.cloud.apphub.v1.DiscoveredWorkload> getGetDiscoveredWorkloadMethod;
    if ((getGetDiscoveredWorkloadMethod = AppHubGrpc.getGetDiscoveredWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetDiscoveredWorkloadMethod = AppHubGrpc.getGetDiscoveredWorkloadMethod) == null) {
          AppHubGrpc.getGetDiscoveredWorkloadMethod = getGetDiscoveredWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest, com.google.cloud.apphub.v1.DiscoveredWorkload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDiscoveredWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DiscoveredWorkload.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetDiscoveredWorkload"))
              .build();
        }
      }
    }
    return getGetDiscoveredWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest,
      com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> getLookupDiscoveredWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupDiscoveredWorkload",
      requestType = com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest.class,
      responseType = com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest,
      com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> getLookupDiscoveredWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest, com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> getLookupDiscoveredWorkloadMethod;
    if ((getLookupDiscoveredWorkloadMethod = AppHubGrpc.getLookupDiscoveredWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getLookupDiscoveredWorkloadMethod = AppHubGrpc.getLookupDiscoveredWorkloadMethod) == null) {
          AppHubGrpc.getLookupDiscoveredWorkloadMethod = getLookupDiscoveredWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest, com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupDiscoveredWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("LookupDiscoveredWorkload"))
              .build();
        }
      }
    }
    return getLookupDiscoveredWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListWorkloadsRequest,
      com.google.cloud.apphub.v1.ListWorkloadsResponse> getListWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloads",
      requestType = com.google.cloud.apphub.v1.ListWorkloadsRequest.class,
      responseType = com.google.cloud.apphub.v1.ListWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListWorkloadsRequest,
      com.google.cloud.apphub.v1.ListWorkloadsResponse> getListWorkloadsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListWorkloadsRequest, com.google.cloud.apphub.v1.ListWorkloadsResponse> getListWorkloadsMethod;
    if ((getListWorkloadsMethod = AppHubGrpc.getListWorkloadsMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListWorkloadsMethod = AppHubGrpc.getListWorkloadsMethod) == null) {
          AppHubGrpc.getListWorkloadsMethod = getListWorkloadsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListWorkloadsRequest, com.google.cloud.apphub.v1.ListWorkloadsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloads"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListWorkloadsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListWorkloadsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListWorkloads"))
              .build();
        }
      }
    }
    return getListWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateWorkloadRequest,
      com.google.longrunning.Operation> getCreateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkload",
      requestType = com.google.cloud.apphub.v1.CreateWorkloadRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateWorkloadRequest,
      com.google.longrunning.Operation> getCreateWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateWorkloadRequest, com.google.longrunning.Operation> getCreateWorkloadMethod;
    if ((getCreateWorkloadMethod = AppHubGrpc.getCreateWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getCreateWorkloadMethod = AppHubGrpc.getCreateWorkloadMethod) == null) {
          AppHubGrpc.getCreateWorkloadMethod = getCreateWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.CreateWorkloadRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.CreateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("CreateWorkload"))
              .build();
        }
      }
    }
    return getCreateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetWorkloadRequest,
      com.google.cloud.apphub.v1.Workload> getGetWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkload",
      requestType = com.google.cloud.apphub.v1.GetWorkloadRequest.class,
      responseType = com.google.cloud.apphub.v1.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetWorkloadRequest,
      com.google.cloud.apphub.v1.Workload> getGetWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetWorkloadRequest, com.google.cloud.apphub.v1.Workload> getGetWorkloadMethod;
    if ((getGetWorkloadMethod = AppHubGrpc.getGetWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetWorkloadMethod = AppHubGrpc.getGetWorkloadMethod) == null) {
          AppHubGrpc.getGetWorkloadMethod = getGetWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetWorkloadRequest, com.google.cloud.apphub.v1.Workload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.Workload.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetWorkload"))
              .build();
        }
      }
    }
    return getGetWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateWorkloadRequest,
      com.google.longrunning.Operation> getUpdateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkload",
      requestType = com.google.cloud.apphub.v1.UpdateWorkloadRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateWorkloadRequest,
      com.google.longrunning.Operation> getUpdateWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateWorkloadRequest, com.google.longrunning.Operation> getUpdateWorkloadMethod;
    if ((getUpdateWorkloadMethod = AppHubGrpc.getUpdateWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getUpdateWorkloadMethod = AppHubGrpc.getUpdateWorkloadMethod) == null) {
          AppHubGrpc.getUpdateWorkloadMethod = getUpdateWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.UpdateWorkloadRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.UpdateWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("UpdateWorkload"))
              .build();
        }
      }
    }
    return getUpdateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteWorkloadRequest,
      com.google.longrunning.Operation> getDeleteWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkload",
      requestType = com.google.cloud.apphub.v1.DeleteWorkloadRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteWorkloadRequest,
      com.google.longrunning.Operation> getDeleteWorkloadMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteWorkloadRequest, com.google.longrunning.Operation> getDeleteWorkloadMethod;
    if ((getDeleteWorkloadMethod = AppHubGrpc.getDeleteWorkloadMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getDeleteWorkloadMethod = AppHubGrpc.getDeleteWorkloadMethod) == null) {
          AppHubGrpc.getDeleteWorkloadMethod = getDeleteWorkloadMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.DeleteWorkloadRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkload"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DeleteWorkloadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("DeleteWorkload"))
              .build();
        }
      }
    }
    return getDeleteWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListApplicationsRequest,
      com.google.cloud.apphub.v1.ListApplicationsResponse> getListApplicationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListApplications",
      requestType = com.google.cloud.apphub.v1.ListApplicationsRequest.class,
      responseType = com.google.cloud.apphub.v1.ListApplicationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListApplicationsRequest,
      com.google.cloud.apphub.v1.ListApplicationsResponse> getListApplicationsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.ListApplicationsRequest, com.google.cloud.apphub.v1.ListApplicationsResponse> getListApplicationsMethod;
    if ((getListApplicationsMethod = AppHubGrpc.getListApplicationsMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getListApplicationsMethod = AppHubGrpc.getListApplicationsMethod) == null) {
          AppHubGrpc.getListApplicationsMethod = getListApplicationsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.ListApplicationsRequest, com.google.cloud.apphub.v1.ListApplicationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListApplications"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListApplicationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.ListApplicationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("ListApplications"))
              .build();
        }
      }
    }
    return getListApplicationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateApplicationRequest,
      com.google.longrunning.Operation> getCreateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateApplication",
      requestType = com.google.cloud.apphub.v1.CreateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateApplicationRequest,
      com.google.longrunning.Operation> getCreateApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.CreateApplicationRequest, com.google.longrunning.Operation> getCreateApplicationMethod;
    if ((getCreateApplicationMethod = AppHubGrpc.getCreateApplicationMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getCreateApplicationMethod = AppHubGrpc.getCreateApplicationMethod) == null) {
          AppHubGrpc.getCreateApplicationMethod = getCreateApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.CreateApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.CreateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("CreateApplication"))
              .build();
        }
      }
    }
    return getCreateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetApplicationRequest,
      com.google.cloud.apphub.v1.Application> getGetApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetApplication",
      requestType = com.google.cloud.apphub.v1.GetApplicationRequest.class,
      responseType = com.google.cloud.apphub.v1.Application.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetApplicationRequest,
      com.google.cloud.apphub.v1.Application> getGetApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.GetApplicationRequest, com.google.cloud.apphub.v1.Application> getGetApplicationMethod;
    if ((getGetApplicationMethod = AppHubGrpc.getGetApplicationMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getGetApplicationMethod = AppHubGrpc.getGetApplicationMethod) == null) {
          AppHubGrpc.getGetApplicationMethod = getGetApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.GetApplicationRequest, com.google.cloud.apphub.v1.Application>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.GetApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.Application.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("GetApplication"))
              .build();
        }
      }
    }
    return getGetApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateApplicationRequest,
      com.google.longrunning.Operation> getUpdateApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateApplication",
      requestType = com.google.cloud.apphub.v1.UpdateApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateApplicationRequest,
      com.google.longrunning.Operation> getUpdateApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.UpdateApplicationRequest, com.google.longrunning.Operation> getUpdateApplicationMethod;
    if ((getUpdateApplicationMethod = AppHubGrpc.getUpdateApplicationMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getUpdateApplicationMethod = AppHubGrpc.getUpdateApplicationMethod) == null) {
          AppHubGrpc.getUpdateApplicationMethod = getUpdateApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.UpdateApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.UpdateApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("UpdateApplication"))
              .build();
        }
      }
    }
    return getUpdateApplicationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteApplicationRequest,
      com.google.longrunning.Operation> getDeleteApplicationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteApplication",
      requestType = com.google.cloud.apphub.v1.DeleteApplicationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteApplicationRequest,
      com.google.longrunning.Operation> getDeleteApplicationMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.apphub.v1.DeleteApplicationRequest, com.google.longrunning.Operation> getDeleteApplicationMethod;
    if ((getDeleteApplicationMethod = AppHubGrpc.getDeleteApplicationMethod) == null) {
      synchronized (AppHubGrpc.class) {
        if ((getDeleteApplicationMethod = AppHubGrpc.getDeleteApplicationMethod) == null) {
          AppHubGrpc.getDeleteApplicationMethod = getDeleteApplicationMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.apphub.v1.DeleteApplicationRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteApplication"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.apphub.v1.DeleteApplicationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new AppHubMethodDescriptorSupplier("DeleteApplication"))
              .build();
        }
      }
    }
    return getDeleteApplicationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppHubStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppHubStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppHubStub>() {
        @java.lang.Override
        public AppHubStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppHubStub(channel, callOptions);
        }
      };
    return AppHubStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppHubBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppHubBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppHubBlockingStub>() {
        @java.lang.Override
        public AppHubBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppHubBlockingStub(channel, callOptions);
        }
      };
    return AppHubBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppHubFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppHubFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppHubFutureStub>() {
        @java.lang.Override
        public AppHubFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppHubFutureStub(channel, callOptions);
        }
      };
    return AppHubFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The App Hub API allows you to manage App Hub resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists a service project attachment for a given service project. You can
     * call this API from any project to find if it is attached to a host project.
     * </pre>
     */
    default void lookupServiceProjectAttachment(com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupServiceProjectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists service projects attached to the host project.
     * </pre>
     */
    default void listServiceProjectAttachments(com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServiceProjectAttachmentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Attaches a service project to the host project.
     * </pre>
     */
    default void createServiceProjectAttachment(com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceProjectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a service project attachment.
     * </pre>
     */
    default void getServiceProjectAttachment(com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ServiceProjectAttachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceProjectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a service project attachment.
     * </pre>
     */
    default void deleteServiceProjectAttachment(com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServiceProjectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Detaches a service project from a host project.
     * You can call this API from any service project without needing access to
     * the host project that it is attached to.
     * </pre>
     */
    default void detachServiceProjectAttachment(com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDetachServiceProjectAttachmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Discovered Services that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    default void listDiscoveredServices(com.google.cloud.apphub.v1.ListDiscoveredServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDiscoveredServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Discovered Service in a host project and location.
     * </pre>
     */
    default void getDiscoveredService(com.google.cloud.apphub.v1.GetDiscoveredServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredService> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDiscoveredServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists a Discovered Service in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    default void lookupDiscoveredService(com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupDiscoveredServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Services in an Application.
     * </pre>
     */
    default void listServices(com.google.cloud.apphub.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListServicesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Service in an Application.
     * </pre>
     */
    default void createService(com.google.cloud.apphub.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Service in an Application.
     * </pre>
     */
    default void getService(com.google.cloud.apphub.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a Service in an Application.
     * </pre>
     */
    default void updateService(com.google.cloud.apphub.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Service from an Application.
     * </pre>
     */
    default void deleteService(com.google.cloud.apphub.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteServiceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Discovered Workloads that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    default void listDiscoveredWorkloads(com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListDiscoveredWorkloadsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Discovered Workload in a host project and location.
     * </pre>
     */
    default void getDiscoveredWorkload(com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredWorkload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetDiscoveredWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists a Discovered Workload in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    default void lookupDiscoveredWorkload(com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLookupDiscoveredWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Workloads in an Application.
     * </pre>
     */
    default void listWorkloads(com.google.cloud.apphub.v1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a Workload in an Application.
     * </pre>
     */
    default void createWorkload(com.google.cloud.apphub.v1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a Workload in an Application.
     * </pre>
     */
    default void getWorkload(com.google.cloud.apphub.v1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Workload> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a Workload in an Application.
     * </pre>
     */
    default void updateWorkload(com.google.cloud.apphub.v1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a Workload from an Application.
     * </pre>
     */
    default void deleteWorkload(com.google.cloud.apphub.v1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWorkloadMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists Applications in a host project and location.
     * </pre>
     */
    default void listApplications(com.google.cloud.apphub.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListApplicationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListApplicationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates an Application in a host project and location.
     * </pre>
     */
    default void createApplication(com.google.cloud.apphub.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an Application in a host project and location.
     * </pre>
     */
    default void getApplication(com.google.cloud.apphub.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Application> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an Application in a host project and location.
     * </pre>
     */
    default void updateApplication(com.google.cloud.apphub.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateApplicationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an Application in a host project and location.
     * </pre>
     */
    default void deleteApplication(com.google.cloud.apphub.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteApplicationMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AppHub.
   * <pre>
   * The App Hub API allows you to manage App Hub resources.
   * </pre>
   */
  public static abstract class AppHubImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AppHubGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AppHub.
   * <pre>
   * The App Hub API allows you to manage App Hub resources.
   * </pre>
   */
  public static final class AppHubStub
      extends io.grpc.stub.AbstractAsyncStub<AppHubStub> {
    private AppHubStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppHubStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppHubStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists a service project attachment for a given service project. You can
     * call this API from any project to find if it is attached to a host project.
     * </pre>
     */
    public void lookupServiceProjectAttachment(com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupServiceProjectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists service projects attached to the host project.
     * </pre>
     */
    public void listServiceProjectAttachments(com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceProjectAttachmentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Attaches a service project to the host project.
     * </pre>
     */
    public void createServiceProjectAttachment(com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceProjectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a service project attachment.
     * </pre>
     */
    public void getServiceProjectAttachment(com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ServiceProjectAttachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceProjectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a service project attachment.
     * </pre>
     */
    public void deleteServiceProjectAttachment(com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceProjectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Detaches a service project from a host project.
     * You can call this API from any service project without needing access to
     * the host project that it is attached to.
     * </pre>
     */
    public void detachServiceProjectAttachment(com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDetachServiceProjectAttachmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Discovered Services that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public void listDiscoveredServices(com.google.cloud.apphub.v1.ListDiscoveredServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDiscoveredServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Discovered Service in a host project and location.
     * </pre>
     */
    public void getDiscoveredService(com.google.cloud.apphub.v1.GetDiscoveredServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredService> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiscoveredServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists a Discovered Service in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public void lookupDiscoveredService(com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupDiscoveredServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Services in an Application.
     * </pre>
     */
    public void listServices(com.google.cloud.apphub.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServicesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Service in an Application.
     * </pre>
     */
    public void createService(com.google.cloud.apphub.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Service in an Application.
     * </pre>
     */
    public void getService(com.google.cloud.apphub.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a Service in an Application.
     * </pre>
     */
    public void updateService(com.google.cloud.apphub.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Service from an Application.
     * </pre>
     */
    public void deleteService(com.google.cloud.apphub.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Discovered Workloads that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public void listDiscoveredWorkloads(com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDiscoveredWorkloadsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Discovered Workload in a host project and location.
     * </pre>
     */
    public void getDiscoveredWorkload(com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredWorkload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDiscoveredWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists a Discovered Workload in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public void lookupDiscoveredWorkload(com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupDiscoveredWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Workloads in an Application.
     * </pre>
     */
    public void listWorkloads(com.google.cloud.apphub.v1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListWorkloadsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a Workload in an Application.
     * </pre>
     */
    public void createWorkload(com.google.cloud.apphub.v1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a Workload in an Application.
     * </pre>
     */
    public void getWorkload(com.google.cloud.apphub.v1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Workload> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a Workload in an Application.
     * </pre>
     */
    public void updateWorkload(com.google.cloud.apphub.v1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a Workload from an Application.
     * </pre>
     */
    public void deleteWorkload(com.google.cloud.apphub.v1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists Applications in a host project and location.
     * </pre>
     */
    public void listApplications(com.google.cloud.apphub.v1.ListApplicationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListApplicationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates an Application in a host project and location.
     * </pre>
     */
    public void createApplication(com.google.cloud.apphub.v1.CreateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an Application in a host project and location.
     * </pre>
     */
    public void getApplication(com.google.cloud.apphub.v1.GetApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Application> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an Application in a host project and location.
     * </pre>
     */
    public void updateApplication(com.google.cloud.apphub.v1.UpdateApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an Application in a host project and location.
     * </pre>
     */
    public void deleteApplication(com.google.cloud.apphub.v1.DeleteApplicationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AppHub.
   * <pre>
   * The App Hub API allows you to manage App Hub resources.
   * </pre>
   */
  public static final class AppHubBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AppHubBlockingStub> {
    private AppHubBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppHubBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppHubBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists a service project attachment for a given service project. You can
     * call this API from any project to find if it is attached to a host project.
     * </pre>
     */
    public com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse lookupServiceProjectAttachment(com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupServiceProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists service projects attached to the host project.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse listServiceProjectAttachments(com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceProjectAttachmentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Attaches a service project to the host project.
     * </pre>
     */
    public com.google.longrunning.Operation createServiceProjectAttachment(com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a service project attachment.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ServiceProjectAttachment getServiceProjectAttachment(com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a service project attachment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteServiceProjectAttachment(com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Detaches a service project from a host project.
     * You can call this API from any service project without needing access to
     * the host project that it is attached to.
     * </pre>
     */
    public com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse detachServiceProjectAttachment(com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDetachServiceProjectAttachmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Discovered Services that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListDiscoveredServicesResponse listDiscoveredServices(com.google.cloud.apphub.v1.ListDiscoveredServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiscoveredServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Discovered Service in a host project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.DiscoveredService getDiscoveredService(com.google.cloud.apphub.v1.GetDiscoveredServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiscoveredServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists a Discovered Service in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse lookupDiscoveredService(com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupDiscoveredServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Services in an Application.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListServicesResponse listServices(com.google.cloud.apphub.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Service in an Application.
     * </pre>
     */
    public com.google.longrunning.Operation createService(com.google.cloud.apphub.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Service in an Application.
     * </pre>
     */
    public com.google.cloud.apphub.v1.Service getService(com.google.cloud.apphub.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a Service in an Application.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(com.google.cloud.apphub.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Service from an Application.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(com.google.cloud.apphub.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Discovered Workloads that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse listDiscoveredWorkloads(com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDiscoveredWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Discovered Workload in a host project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.DiscoveredWorkload getDiscoveredWorkload(com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDiscoveredWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists a Discovered Workload in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse lookupDiscoveredWorkload(com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupDiscoveredWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Workloads in an Application.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListWorkloadsResponse listWorkloads(com.google.cloud.apphub.v1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a Workload in an Application.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkload(com.google.cloud.apphub.v1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a Workload in an Application.
     * </pre>
     */
    public com.google.cloud.apphub.v1.Workload getWorkload(com.google.cloud.apphub.v1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a Workload in an Application.
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkload(com.google.cloud.apphub.v1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a Workload from an Application.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkload(com.google.cloud.apphub.v1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkloadMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists Applications in a host project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.ListApplicationsResponse listApplications(com.google.cloud.apphub.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListApplicationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates an Application in a host project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createApplication(com.google.cloud.apphub.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an Application in a host project and location.
     * </pre>
     */
    public com.google.cloud.apphub.v1.Application getApplication(com.google.cloud.apphub.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an Application in a host project and location.
     * </pre>
     */
    public com.google.longrunning.Operation updateApplication(com.google.cloud.apphub.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateApplicationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an Application in a host project and location.
     * </pre>
     */
    public com.google.longrunning.Operation deleteApplication(com.google.cloud.apphub.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteApplicationMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AppHub.
   * <pre>
   * The App Hub API allows you to manage App Hub resources.
   * </pre>
   */
  public static final class AppHubFutureStub
      extends io.grpc.stub.AbstractFutureStub<AppHubFutureStub> {
    private AppHubFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppHubFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppHubFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists a service project attachment for a given service project. You can
     * call this API from any project to find if it is attached to a host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse> lookupServiceProjectAttachment(
        com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupServiceProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists service projects attached to the host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse> listServiceProjectAttachments(
        com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceProjectAttachmentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Attaches a service project to the host project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createServiceProjectAttachment(
        com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a service project attachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ServiceProjectAttachment> getServiceProjectAttachment(
        com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a service project attachment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteServiceProjectAttachment(
        com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Detaches a service project from a host project.
     * You can call this API from any service project without needing access to
     * the host project that it is attached to.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse> detachServiceProjectAttachment(
        com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDetachServiceProjectAttachmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Discovered Services that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListDiscoveredServicesResponse> listDiscoveredServices(
        com.google.cloud.apphub.v1.ListDiscoveredServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDiscoveredServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Discovered Service in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.DiscoveredService> getDiscoveredService(
        com.google.cloud.apphub.v1.GetDiscoveredServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiscoveredServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists a Discovered Service in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse> lookupDiscoveredService(
        com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupDiscoveredServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Services in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListServicesResponse> listServices(
        com.google.cloud.apphub.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Service in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createService(
        com.google.cloud.apphub.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Service in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.Service> getService(
        com.google.cloud.apphub.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a Service in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateService(
        com.google.cloud.apphub.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Service from an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteService(
        com.google.cloud.apphub.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Discovered Workloads that can be added to an Application in a host
     * project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse> listDiscoveredWorkloads(
        com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDiscoveredWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Discovered Workload in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.DiscoveredWorkload> getDiscoveredWorkload(
        com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDiscoveredWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists a Discovered Workload in a host project and location, with a
     * given resource URI.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse> lookupDiscoveredWorkload(
        com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupDiscoveredWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Workloads in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListWorkloadsResponse> listWorkloads(
        com.google.cloud.apphub.v1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a Workload in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createWorkload(
        com.google.cloud.apphub.v1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a Workload in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.Workload> getWorkload(
        com.google.cloud.apphub.v1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a Workload in an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateWorkload(
        com.google.cloud.apphub.v1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a Workload from an Application.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteWorkload(
        com.google.cloud.apphub.v1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists Applications in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.ListApplicationsResponse> listApplications(
        com.google.cloud.apphub.v1.ListApplicationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListApplicationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates an Application in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createApplication(
        com.google.cloud.apphub.v1.CreateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an Application in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.apphub.v1.Application> getApplication(
        com.google.cloud.apphub.v1.GetApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an Application in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateApplication(
        com.google.cloud.apphub.v1.UpdateApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateApplicationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an Application in a host project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteApplication(
        com.google.cloud.apphub.v1.DeleteApplicationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteApplicationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOOKUP_SERVICE_PROJECT_ATTACHMENT = 0;
  private static final int METHODID_LIST_SERVICE_PROJECT_ATTACHMENTS = 1;
  private static final int METHODID_CREATE_SERVICE_PROJECT_ATTACHMENT = 2;
  private static final int METHODID_GET_SERVICE_PROJECT_ATTACHMENT = 3;
  private static final int METHODID_DELETE_SERVICE_PROJECT_ATTACHMENT = 4;
  private static final int METHODID_DETACH_SERVICE_PROJECT_ATTACHMENT = 5;
  private static final int METHODID_LIST_DISCOVERED_SERVICES = 6;
  private static final int METHODID_GET_DISCOVERED_SERVICE = 7;
  private static final int METHODID_LOOKUP_DISCOVERED_SERVICE = 8;
  private static final int METHODID_LIST_SERVICES = 9;
  private static final int METHODID_CREATE_SERVICE = 10;
  private static final int METHODID_GET_SERVICE = 11;
  private static final int METHODID_UPDATE_SERVICE = 12;
  private static final int METHODID_DELETE_SERVICE = 13;
  private static final int METHODID_LIST_DISCOVERED_WORKLOADS = 14;
  private static final int METHODID_GET_DISCOVERED_WORKLOAD = 15;
  private static final int METHODID_LOOKUP_DISCOVERED_WORKLOAD = 16;
  private static final int METHODID_LIST_WORKLOADS = 17;
  private static final int METHODID_CREATE_WORKLOAD = 18;
  private static final int METHODID_GET_WORKLOAD = 19;
  private static final int METHODID_UPDATE_WORKLOAD = 20;
  private static final int METHODID_DELETE_WORKLOAD = 21;
  private static final int METHODID_LIST_APPLICATIONS = 22;
  private static final int METHODID_CREATE_APPLICATION = 23;
  private static final int METHODID_GET_APPLICATION = 24;
  private static final int METHODID_UPDATE_APPLICATION = 25;
  private static final int METHODID_DELETE_APPLICATION = 26;

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
        case METHODID_LOOKUP_SERVICE_PROJECT_ATTACHMENT:
          serviceImpl.lookupServiceProjectAttachment((com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse>) responseObserver);
          break;
        case METHODID_LIST_SERVICE_PROJECT_ATTACHMENTS:
          serviceImpl.listServiceProjectAttachments((com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_PROJECT_ATTACHMENT:
          serviceImpl.createServiceProjectAttachment((com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE_PROJECT_ATTACHMENT:
          serviceImpl.getServiceProjectAttachment((com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ServiceProjectAttachment>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE_PROJECT_ATTACHMENT:
          serviceImpl.deleteServiceProjectAttachment((com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DETACH_SERVICE_PROJECT_ATTACHMENT:
          serviceImpl.detachServiceProjectAttachment((com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse>) responseObserver);
          break;
        case METHODID_LIST_DISCOVERED_SERVICES:
          serviceImpl.listDiscoveredServices((com.google.cloud.apphub.v1.ListDiscoveredServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredServicesResponse>) responseObserver);
          break;
        case METHODID_GET_DISCOVERED_SERVICE:
          serviceImpl.getDiscoveredService((com.google.cloud.apphub.v1.GetDiscoveredServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredService>) responseObserver);
          break;
        case METHODID_LOOKUP_DISCOVERED_SERVICE:
          serviceImpl.lookupDiscoveredService((com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices((com.google.cloud.apphub.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListServicesResponse>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService((com.google.cloud.apphub.v1.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.google.cloud.apphub.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Service>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService((com.google.cloud.apphub.v1.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService((com.google.cloud.apphub.v1.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DISCOVERED_WORKLOADS:
          serviceImpl.listDiscoveredWorkloads((com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse>) responseObserver);
          break;
        case METHODID_GET_DISCOVERED_WORKLOAD:
          serviceImpl.getDiscoveredWorkload((com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.DiscoveredWorkload>) responseObserver);
          break;
        case METHODID_LOOKUP_DISCOVERED_WORKLOAD:
          serviceImpl.lookupDiscoveredWorkload((com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse>) responseObserver);
          break;
        case METHODID_LIST_WORKLOADS:
          serviceImpl.listWorkloads((com.google.cloud.apphub.v1.ListWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListWorkloadsResponse>) responseObserver);
          break;
        case METHODID_CREATE_WORKLOAD:
          serviceImpl.createWorkload((com.google.cloud.apphub.v1.CreateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_WORKLOAD:
          serviceImpl.getWorkload((com.google.cloud.apphub.v1.GetWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Workload>) responseObserver);
          break;
        case METHODID_UPDATE_WORKLOAD:
          serviceImpl.updateWorkload((com.google.cloud.apphub.v1.UpdateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKLOAD:
          serviceImpl.deleteWorkload((com.google.cloud.apphub.v1.DeleteWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_APPLICATIONS:
          serviceImpl.listApplications((com.google.cloud.apphub.v1.ListApplicationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.ListApplicationsResponse>) responseObserver);
          break;
        case METHODID_CREATE_APPLICATION:
          serviceImpl.createApplication((com.google.cloud.apphub.v1.CreateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_APPLICATION:
          serviceImpl.getApplication((com.google.cloud.apphub.v1.GetApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.apphub.v1.Application>) responseObserver);
          break;
        case METHODID_UPDATE_APPLICATION:
          serviceImpl.updateApplication((com.google.cloud.apphub.v1.UpdateApplicationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_APPLICATION:
          serviceImpl.deleteApplication((com.google.cloud.apphub.v1.DeleteApplicationRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getLookupServiceProjectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.LookupServiceProjectAttachmentRequest,
              com.google.cloud.apphub.v1.LookupServiceProjectAttachmentResponse>(
                service, METHODID_LOOKUP_SERVICE_PROJECT_ATTACHMENT)))
        .addMethod(
          getListServiceProjectAttachmentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListServiceProjectAttachmentsRequest,
              com.google.cloud.apphub.v1.ListServiceProjectAttachmentsResponse>(
                service, METHODID_LIST_SERVICE_PROJECT_ATTACHMENTS)))
        .addMethod(
          getCreateServiceProjectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.CreateServiceProjectAttachmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_SERVICE_PROJECT_ATTACHMENT)))
        .addMethod(
          getGetServiceProjectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetServiceProjectAttachmentRequest,
              com.google.cloud.apphub.v1.ServiceProjectAttachment>(
                service, METHODID_GET_SERVICE_PROJECT_ATTACHMENT)))
        .addMethod(
          getDeleteServiceProjectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.DeleteServiceProjectAttachmentRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_SERVICE_PROJECT_ATTACHMENT)))
        .addMethod(
          getDetachServiceProjectAttachmentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.DetachServiceProjectAttachmentRequest,
              com.google.cloud.apphub.v1.DetachServiceProjectAttachmentResponse>(
                service, METHODID_DETACH_SERVICE_PROJECT_ATTACHMENT)))
        .addMethod(
          getListDiscoveredServicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListDiscoveredServicesRequest,
              com.google.cloud.apphub.v1.ListDiscoveredServicesResponse>(
                service, METHODID_LIST_DISCOVERED_SERVICES)))
        .addMethod(
          getGetDiscoveredServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetDiscoveredServiceRequest,
              com.google.cloud.apphub.v1.DiscoveredService>(
                service, METHODID_GET_DISCOVERED_SERVICE)))
        .addMethod(
          getLookupDiscoveredServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.LookupDiscoveredServiceRequest,
              com.google.cloud.apphub.v1.LookupDiscoveredServiceResponse>(
                service, METHODID_LOOKUP_DISCOVERED_SERVICE)))
        .addMethod(
          getListServicesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListServicesRequest,
              com.google.cloud.apphub.v1.ListServicesResponse>(
                service, METHODID_LIST_SERVICES)))
        .addMethod(
          getCreateServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.CreateServiceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_SERVICE)))
        .addMethod(
          getGetServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetServiceRequest,
              com.google.cloud.apphub.v1.Service>(
                service, METHODID_GET_SERVICE)))
        .addMethod(
          getUpdateServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.UpdateServiceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_SERVICE)))
        .addMethod(
          getDeleteServiceMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.DeleteServiceRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_SERVICE)))
        .addMethod(
          getListDiscoveredWorkloadsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListDiscoveredWorkloadsRequest,
              com.google.cloud.apphub.v1.ListDiscoveredWorkloadsResponse>(
                service, METHODID_LIST_DISCOVERED_WORKLOADS)))
        .addMethod(
          getGetDiscoveredWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetDiscoveredWorkloadRequest,
              com.google.cloud.apphub.v1.DiscoveredWorkload>(
                service, METHODID_GET_DISCOVERED_WORKLOAD)))
        .addMethod(
          getLookupDiscoveredWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.LookupDiscoveredWorkloadRequest,
              com.google.cloud.apphub.v1.LookupDiscoveredWorkloadResponse>(
                service, METHODID_LOOKUP_DISCOVERED_WORKLOAD)))
        .addMethod(
          getListWorkloadsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListWorkloadsRequest,
              com.google.cloud.apphub.v1.ListWorkloadsResponse>(
                service, METHODID_LIST_WORKLOADS)))
        .addMethod(
          getCreateWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.CreateWorkloadRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_WORKLOAD)))
        .addMethod(
          getGetWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetWorkloadRequest,
              com.google.cloud.apphub.v1.Workload>(
                service, METHODID_GET_WORKLOAD)))
        .addMethod(
          getUpdateWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.UpdateWorkloadRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_WORKLOAD)))
        .addMethod(
          getDeleteWorkloadMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.DeleteWorkloadRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_WORKLOAD)))
        .addMethod(
          getListApplicationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.ListApplicationsRequest,
              com.google.cloud.apphub.v1.ListApplicationsResponse>(
                service, METHODID_LIST_APPLICATIONS)))
        .addMethod(
          getCreateApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.CreateApplicationRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_APPLICATION)))
        .addMethod(
          getGetApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.GetApplicationRequest,
              com.google.cloud.apphub.v1.Application>(
                service, METHODID_GET_APPLICATION)))
        .addMethod(
          getUpdateApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.UpdateApplicationRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_APPLICATION)))
        .addMethod(
          getDeleteApplicationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.cloud.apphub.v1.DeleteApplicationRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_APPLICATION)))
        .build();
  }

  private static abstract class AppHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppHubBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.apphub.v1.ApphubServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppHub");
    }
  }

  private static final class AppHubFileDescriptorSupplier
      extends AppHubBaseDescriptorSupplier {
    AppHubFileDescriptorSupplier() {}
  }

  private static final class AppHubMethodDescriptorSupplier
      extends AppHubBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AppHubMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AppHubGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AppHubFileDescriptorSupplier())
              .addMethod(getLookupServiceProjectAttachmentMethod())
              .addMethod(getListServiceProjectAttachmentsMethod())
              .addMethod(getCreateServiceProjectAttachmentMethod())
              .addMethod(getGetServiceProjectAttachmentMethod())
              .addMethod(getDeleteServiceProjectAttachmentMethod())
              .addMethod(getDetachServiceProjectAttachmentMethod())
              .addMethod(getListDiscoveredServicesMethod())
              .addMethod(getGetDiscoveredServiceMethod())
              .addMethod(getLookupDiscoveredServiceMethod())
              .addMethod(getListServicesMethod())
              .addMethod(getCreateServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getUpdateServiceMethod())
              .addMethod(getDeleteServiceMethod())
              .addMethod(getListDiscoveredWorkloadsMethod())
              .addMethod(getGetDiscoveredWorkloadMethod())
              .addMethod(getLookupDiscoveredWorkloadMethod())
              .addMethod(getListWorkloadsMethod())
              .addMethod(getCreateWorkloadMethod())
              .addMethod(getGetWorkloadMethod())
              .addMethod(getUpdateWorkloadMethod())
              .addMethod(getDeleteWorkloadMethod())
              .addMethod(getListApplicationsMethod())
              .addMethod(getCreateApplicationMethod())
              .addMethod(getGetApplicationMethod())
              .addMethod(getUpdateApplicationMethod())
              .addMethod(getDeleteApplicationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
