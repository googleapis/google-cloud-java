package com.google.cloud.securitycenter.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * V1 APIs for Security Center service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/securitycenter/v1/securitycenter_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SecurityCenterGrpc {

  private SecurityCenterGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.securitycenter.v1.SecurityCenter";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest,
      com.google.longrunning.Operation> getBulkMuteFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkMuteFindings",
      requestType = com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest,
      com.google.longrunning.Operation> getBulkMuteFindingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest, com.google.longrunning.Operation> getBulkMuteFindingsMethod;
    if ((getBulkMuteFindingsMethod = SecurityCenterGrpc.getBulkMuteFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getBulkMuteFindingsMethod = SecurityCenterGrpc.getBulkMuteFindingsMethod) == null) {
          SecurityCenterGrpc.getBulkMuteFindingsMethod = getBulkMuteFindingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BulkMuteFindings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("BulkMuteFindings"))
              .build();
        }
      }
    }
    return getBulkMuteFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getCreateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSource",
      requestType = com.google.cloud.securitycenter.v1.CreateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getCreateSourceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateSourceRequest, com.google.cloud.securitycenter.v1.Source> getCreateSourceMethod;
    if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
          SecurityCenterGrpc.getCreateSourceMethod = getCreateSourceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.CreateSourceRequest, com.google.cloud.securitycenter.v1.Source>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.CreateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("CreateSource"))
              .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateFindingRequest,
      com.google.cloud.securitycenter.v1.Finding> getCreateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFinding",
      requestType = com.google.cloud.securitycenter.v1.CreateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateFindingRequest,
      com.google.cloud.securitycenter.v1.Finding> getCreateFindingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateFindingRequest, com.google.cloud.securitycenter.v1.Finding> getCreateFindingMethod;
    if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
          SecurityCenterGrpc.getCreateFindingMethod = getCreateFindingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.CreateFindingRequest, com.google.cloud.securitycenter.v1.Finding>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.CreateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("CreateFinding"))
              .build();
        }
      }
    }
    return getCreateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getCreateMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMuteConfig",
      requestType = com.google.cloud.securitycenter.v1.CreateMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getCreateMuteConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig> getCreateMuteConfigMethod;
    if ((getCreateMuteConfigMethod = SecurityCenterGrpc.getCreateMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateMuteConfigMethod = SecurityCenterGrpc.getCreateMuteConfigMethod) == null) {
          SecurityCenterGrpc.getCreateMuteConfigMethod = getCreateMuteConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.CreateMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMuteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.CreateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.MuteConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("CreateMuteConfig"))
              .build();
        }
      }
    }
    return getCreateMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getCreateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getCreateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig> getCreateNotificationConfigMethod;
    if ((getCreateNotificationConfigMethod = SecurityCenterGrpc.getCreateNotificationConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateNotificationConfigMethod = SecurityCenterGrpc.getCreateNotificationConfigMethod) == null) {
          SecurityCenterGrpc.getCreateNotificationConfigMethod = getCreateNotificationConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.NotificationConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("CreateNotificationConfig"))
              .build();
        }
      }
    }
    return getCreateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest,
      com.google.protobuf.Empty> getDeleteMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMuteConfig",
      requestType = com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest,
      com.google.protobuf.Empty> getDeleteMuteConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest, com.google.protobuf.Empty> getDeleteMuteConfigMethod;
    if ((getDeleteMuteConfigMethod = SecurityCenterGrpc.getDeleteMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteMuteConfigMethod = SecurityCenterGrpc.getDeleteMuteConfigMethod) == null) {
          SecurityCenterGrpc.getDeleteMuteConfigMethod = getDeleteMuteConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMuteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("DeleteMuteConfig"))
              .build();
        }
      }
    }
    return getDeleteMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest,
      com.google.protobuf.Empty> getDeleteNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest,
      com.google.protobuf.Empty> getDeleteNotificationConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest, com.google.protobuf.Empty> getDeleteNotificationConfigMethod;
    if ((getDeleteNotificationConfigMethod = SecurityCenterGrpc.getDeleteNotificationConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteNotificationConfigMethod = SecurityCenterGrpc.getDeleteNotificationConfigMethod) == null) {
          SecurityCenterGrpc.getDeleteNotificationConfigMethod = getDeleteNotificationConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("DeleteNotificationConfig"))
              .build();
        }
      }
    }
    return getDeleteNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getGetBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBigQueryExport",
      requestType = com.google.cloud.securitycenter.v1.GetBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getGetBigQueryExportMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport> getGetBigQueryExportMethod;
    if ((getGetBigQueryExportMethod = SecurityCenterGrpc.getGetBigQueryExportMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetBigQueryExportMethod = SecurityCenterGrpc.getGetBigQueryExportMethod) == null) {
          SecurityCenterGrpc.getGetBigQueryExportMethod = getGetBigQueryExportMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GetBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBigQueryExport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GetBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.BigQueryExport.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetBigQueryExport"))
              .build();
        }
      }
    }
    return getGetBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest,
      com.google.iam.v1.Policy> getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy> getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getGetIamPolicyMethod = getGetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetIamPolicy"))
              .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getGetMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMuteConfig",
      requestType = com.google.cloud.securitycenter.v1.GetMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getGetMuteConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig> getGetMuteConfigMethod;
    if ((getGetMuteConfigMethod = SecurityCenterGrpc.getGetMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetMuteConfigMethod = SecurityCenterGrpc.getGetMuteConfigMethod) == null) {
          SecurityCenterGrpc.getGetMuteConfigMethod = getGetMuteConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GetMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMuteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GetMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.MuteConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetMuteConfig"))
              .build();
        }
      }
    }
    return getGetMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getGetNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1.GetNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getGetNotificationConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig> getGetNotificationConfigMethod;
    if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetNotificationConfigMethod = SecurityCenterGrpc.getGetNotificationConfigMethod) == null) {
          SecurityCenterGrpc.getGetNotificationConfigMethod = getGetNotificationConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GetNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GetNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.NotificationConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetNotificationConfig"))
              .build();
        }
      }
    }
    return getGetNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
      com.google.cloud.securitycenter.v1.OrganizationSettings> getGetOrganizationSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrganizationSettings",
      requestType = com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.OrganizationSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
      com.google.cloud.securitycenter.v1.OrganizationSettings> getGetOrganizationSettingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest, com.google.cloud.securitycenter.v1.OrganizationSettings> getGetOrganizationSettingsMethod;
    if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod) == null) {
          SecurityCenterGrpc.getGetOrganizationSettingsMethod = getGetOrganizationSettingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest, com.google.cloud.securitycenter.v1.OrganizationSettings>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOrganizationSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.OrganizationSettings.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetOrganizationSettings"))
              .build();
        }
      }
    }
    return getGetOrganizationSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getGetSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSource",
      requestType = com.google.cloud.securitycenter.v1.GetSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getGetSourceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GetSourceRequest, com.google.cloud.securitycenter.v1.Source> getGetSourceMethod;
    if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
          SecurityCenterGrpc.getGetSourceMethod = getGetSourceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GetSourceRequest, com.google.cloud.securitycenter.v1.Source>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GetSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetSource"))
              .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupAssetsRequest,
      com.google.cloud.securitycenter.v1.GroupAssetsResponse> getGroupAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupAssets",
      requestType = com.google.cloud.securitycenter.v1.GroupAssetsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.GroupAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupAssetsRequest,
      com.google.cloud.securitycenter.v1.GroupAssetsResponse> getGroupAssetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupAssetsRequest, com.google.cloud.securitycenter.v1.GroupAssetsResponse> getGroupAssetsMethod;
    if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
          SecurityCenterGrpc.getGroupAssetsMethod = getGroupAssetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GroupAssetsRequest, com.google.cloud.securitycenter.v1.GroupAssetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GroupAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GroupAssetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GroupAssets"))
              .build();
        }
      }
    }
    return getGroupAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupFindingsRequest,
      com.google.cloud.securitycenter.v1.GroupFindingsResponse> getGroupFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GroupFindings",
      requestType = com.google.cloud.securitycenter.v1.GroupFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.GroupFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupFindingsRequest,
      com.google.cloud.securitycenter.v1.GroupFindingsResponse> getGroupFindingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.GroupFindingsRequest, com.google.cloud.securitycenter.v1.GroupFindingsResponse> getGroupFindingsMethod;
    if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
          SecurityCenterGrpc.getGroupFindingsMethod = getGroupFindingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.GroupFindingsRequest, com.google.cloud.securitycenter.v1.GroupFindingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GroupFindings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GroupFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.GroupFindingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GroupFindings"))
              .build();
        }
      }
    }
    return getGroupFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListAssetsRequest,
      com.google.cloud.securitycenter.v1.ListAssetsResponse> getListAssetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAssets",
      requestType = com.google.cloud.securitycenter.v1.ListAssetsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListAssetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListAssetsRequest,
      com.google.cloud.securitycenter.v1.ListAssetsResponse> getListAssetsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListAssetsRequest, com.google.cloud.securitycenter.v1.ListAssetsResponse> getListAssetsMethod;
    if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
          SecurityCenterGrpc.getListAssetsMethod = getListAssetsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListAssetsRequest, com.google.cloud.securitycenter.v1.ListAssetsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAssets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListAssetsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListAssetsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListAssets"))
              .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListFindingsRequest,
      com.google.cloud.securitycenter.v1.ListFindingsResponse> getListFindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindings",
      requestType = com.google.cloud.securitycenter.v1.ListFindingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListFindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListFindingsRequest,
      com.google.cloud.securitycenter.v1.ListFindingsResponse> getListFindingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListFindingsRequest, com.google.cloud.securitycenter.v1.ListFindingsResponse> getListFindingsMethod;
    if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
          SecurityCenterGrpc.getListFindingsMethod = getListFindingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListFindingsRequest, com.google.cloud.securitycenter.v1.ListFindingsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFindings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListFindingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListFindingsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListFindings"))
              .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListMuteConfigsRequest,
      com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> getListMuteConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMuteConfigs",
      requestType = com.google.cloud.securitycenter.v1.ListMuteConfigsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListMuteConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListMuteConfigsRequest,
      com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> getListMuteConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListMuteConfigsRequest, com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> getListMuteConfigsMethod;
    if ((getListMuteConfigsMethod = SecurityCenterGrpc.getListMuteConfigsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListMuteConfigsMethod = SecurityCenterGrpc.getListMuteConfigsMethod) == null) {
          SecurityCenterGrpc.getListMuteConfigsMethod = getListMuteConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListMuteConfigsRequest, com.google.cloud.securitycenter.v1.ListMuteConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMuteConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListMuteConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListMuteConfigsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListMuteConfigs"))
              .build();
        }
      }
    }
    return getListMuteConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest,
      com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> getListNotificationConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNotificationConfigs",
      requestType = com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest,
      com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> getListNotificationConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest, com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> getListNotificationConfigsMethod;
    if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListNotificationConfigsMethod = SecurityCenterGrpc.getListNotificationConfigsMethod) == null) {
          SecurityCenterGrpc.getListNotificationConfigsMethod = getListNotificationConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest, com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNotificationConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListNotificationConfigs"))
              .build();
        }
      }
    }
    return getListNotificationConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListSourcesRequest,
      com.google.cloud.securitycenter.v1.ListSourcesResponse> getListSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSources",
      requestType = com.google.cloud.securitycenter.v1.ListSourcesRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListSourcesRequest,
      com.google.cloud.securitycenter.v1.ListSourcesResponse> getListSourcesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListSourcesRequest, com.google.cloud.securitycenter.v1.ListSourcesResponse> getListSourcesMethod;
    if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
          SecurityCenterGrpc.getListSourcesMethod = getListSourcesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListSourcesRequest, com.google.cloud.securitycenter.v1.ListSourcesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSources"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListSourcesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListSourcesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListSources"))
              .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
      com.google.longrunning.Operation> getRunAssetDiscoveryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunAssetDiscovery",
      requestType = com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
      com.google.longrunning.Operation> getRunAssetDiscoveryMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest, com.google.longrunning.Operation> getRunAssetDiscoveryMethod;
    if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
          SecurityCenterGrpc.getRunAssetDiscoveryMethod = getRunAssetDiscoveryMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunAssetDiscovery"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("RunAssetDiscovery"))
              .build();
        }
      }
    }
    return getRunAssetDiscoveryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetFindingStateRequest,
      com.google.cloud.securitycenter.v1.Finding> getSetFindingStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetFindingState",
      requestType = com.google.cloud.securitycenter.v1.SetFindingStateRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetFindingStateRequest,
      com.google.cloud.securitycenter.v1.Finding> getSetFindingStateMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetFindingStateRequest, com.google.cloud.securitycenter.v1.Finding> getSetFindingStateMethod;
    if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
          SecurityCenterGrpc.getSetFindingStateMethod = getSetFindingStateMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.SetFindingStateRequest, com.google.cloud.securitycenter.v1.Finding>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetFindingState"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.SetFindingStateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("SetFindingState"))
              .build();
        }
      }
    }
    return getSetFindingStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetMuteRequest,
      com.google.cloud.securitycenter.v1.Finding> getSetMuteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetMute",
      requestType = com.google.cloud.securitycenter.v1.SetMuteRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetMuteRequest,
      com.google.cloud.securitycenter.v1.Finding> getSetMuteMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.SetMuteRequest, com.google.cloud.securitycenter.v1.Finding> getSetMuteMethod;
    if ((getSetMuteMethod = SecurityCenterGrpc.getSetMuteMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetMuteMethod = SecurityCenterGrpc.getSetMuteMethod) == null) {
          SecurityCenterGrpc.getSetMuteMethod = getSetMuteMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.SetMuteRequest, com.google.cloud.securitycenter.v1.Finding>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetMute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.SetMuteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("SetMute"))
              .build();
        }
      }
    }
    return getSetMuteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest,
      com.google.iam.v1.Policy> getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy> getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getSetIamPolicyMethod = getSetIamPolicyMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.Policy.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("SetIamPolicy"))
              .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest,
      com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse> getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod) == null) {
          SecurityCenterGrpc.getTestIamPermissionsMethod = getTestIamPermissionsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("TestIamPermissions"))
              .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest,
      com.google.cloud.securitycenter.v1.ExternalSystem> getUpdateExternalSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateExternalSystem",
      requestType = com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ExternalSystem.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest,
      com.google.cloud.securitycenter.v1.ExternalSystem> getUpdateExternalSystemMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest, com.google.cloud.securitycenter.v1.ExternalSystem> getUpdateExternalSystemMethod;
    if ((getUpdateExternalSystemMethod = SecurityCenterGrpc.getUpdateExternalSystemMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateExternalSystemMethod = SecurityCenterGrpc.getUpdateExternalSystemMethod) == null) {
          SecurityCenterGrpc.getUpdateExternalSystemMethod = getUpdateExternalSystemMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest, com.google.cloud.securitycenter.v1.ExternalSystem>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateExternalSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ExternalSystem.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateExternalSystem"))
              .build();
        }
      }
    }
    return getUpdateExternalSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateFindingRequest,
      com.google.cloud.securitycenter.v1.Finding> getUpdateFindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFinding",
      requestType = com.google.cloud.securitycenter.v1.UpdateFindingRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Finding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateFindingRequest,
      com.google.cloud.securitycenter.v1.Finding> getUpdateFindingMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateFindingRequest, com.google.cloud.securitycenter.v1.Finding> getUpdateFindingMethod;
    if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
          SecurityCenterGrpc.getUpdateFindingMethod = getUpdateFindingMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateFindingRequest, com.google.cloud.securitycenter.v1.Finding>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFinding"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateFindingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateFinding"))
              .build();
        }
      }
    }
    return getUpdateFindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getUpdateMuteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMuteConfig",
      requestType = com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.MuteConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest,
      com.google.cloud.securitycenter.v1.MuteConfig> getUpdateMuteConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig> getUpdateMuteConfigMethod;
    if ((getUpdateMuteConfigMethod = SecurityCenterGrpc.getUpdateMuteConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateMuteConfigMethod = SecurityCenterGrpc.getUpdateMuteConfigMethod) == null) {
          SecurityCenterGrpc.getUpdateMuteConfigMethod = getUpdateMuteConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest, com.google.cloud.securitycenter.v1.MuteConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMuteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.MuteConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateMuteConfig"))
              .build();
        }
      }
    }
    return getUpdateMuteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getUpdateNotificationConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNotificationConfig",
      requestType = com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest.class,
      responseType = com.google.cloud.securitycenter.v1.NotificationConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest,
      com.google.cloud.securitycenter.v1.NotificationConfig> getUpdateNotificationConfigMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig> getUpdateNotificationConfigMethod;
    if ((getUpdateNotificationConfigMethod = SecurityCenterGrpc.getUpdateNotificationConfigMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateNotificationConfigMethod = SecurityCenterGrpc.getUpdateNotificationConfigMethod) == null) {
          SecurityCenterGrpc.getUpdateNotificationConfigMethod = getUpdateNotificationConfigMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest, com.google.cloud.securitycenter.v1.NotificationConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNotificationConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.NotificationConfig.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateNotificationConfig"))
              .build();
        }
      }
    }
    return getUpdateNotificationConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
      com.google.cloud.securitycenter.v1.OrganizationSettings> getUpdateOrganizationSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOrganizationSettings",
      requestType = com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.OrganizationSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
      com.google.cloud.securitycenter.v1.OrganizationSettings> getUpdateOrganizationSettingsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest, com.google.cloud.securitycenter.v1.OrganizationSettings> getUpdateOrganizationSettingsMethod;
    if ((getUpdateOrganizationSettingsMethod = SecurityCenterGrpc.getUpdateOrganizationSettingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateOrganizationSettingsMethod = SecurityCenterGrpc.getUpdateOrganizationSettingsMethod) == null) {
          SecurityCenterGrpc.getUpdateOrganizationSettingsMethod = getUpdateOrganizationSettingsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest, com.google.cloud.securitycenter.v1.OrganizationSettings>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOrganizationSettings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.OrganizationSettings.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateOrganizationSettings"))
              .build();
        }
      }
    }
    return getUpdateOrganizationSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getUpdateSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSource",
      requestType = com.google.cloud.securitycenter.v1.UpdateSourceRequest.class,
      responseType = com.google.cloud.securitycenter.v1.Source.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSourceRequest,
      com.google.cloud.securitycenter.v1.Source> getUpdateSourceMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSourceRequest, com.google.cloud.securitycenter.v1.Source> getUpdateSourceMethod;
    if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
          SecurityCenterGrpc.getUpdateSourceMethod = getUpdateSourceMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateSourceRequest, com.google.cloud.securitycenter.v1.Source>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSource"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateSourceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateSource"))
              .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
      com.google.cloud.securitycenter.v1.SecurityMarks> getUpdateSecurityMarksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSecurityMarks",
      requestType = com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest.class,
      responseType = com.google.cloud.securitycenter.v1.SecurityMarks.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
      com.google.cloud.securitycenter.v1.SecurityMarks> getUpdateSecurityMarksMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest, com.google.cloud.securitycenter.v1.SecurityMarks> getUpdateSecurityMarksMethod;
    if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod) == null) {
          SecurityCenterGrpc.getUpdateSecurityMarksMethod = getUpdateSecurityMarksMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest, com.google.cloud.securitycenter.v1.SecurityMarks>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSecurityMarks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.SecurityMarks.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateSecurityMarks"))
              .build();
        }
      }
    }
    return getUpdateSecurityMarksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getCreateBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateBigQueryExport",
      requestType = com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getCreateBigQueryExportMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport> getCreateBigQueryExportMethod;
    if ((getCreateBigQueryExportMethod = SecurityCenterGrpc.getCreateBigQueryExportMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateBigQueryExportMethod = SecurityCenterGrpc.getCreateBigQueryExportMethod) == null) {
          SecurityCenterGrpc.getCreateBigQueryExportMethod = getCreateBigQueryExportMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateBigQueryExport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.BigQueryExport.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("CreateBigQueryExport"))
              .build();
        }
      }
    }
    return getCreateBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest,
      com.google.protobuf.Empty> getDeleteBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteBigQueryExport",
      requestType = com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest,
      com.google.protobuf.Empty> getDeleteBigQueryExportMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest, com.google.protobuf.Empty> getDeleteBigQueryExportMethod;
    if ((getDeleteBigQueryExportMethod = SecurityCenterGrpc.getDeleteBigQueryExportMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getDeleteBigQueryExportMethod = SecurityCenterGrpc.getDeleteBigQueryExportMethod) == null) {
          SecurityCenterGrpc.getDeleteBigQueryExportMethod = getDeleteBigQueryExportMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteBigQueryExport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("DeleteBigQueryExport"))
              .build();
        }
      }
    }
    return getDeleteBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getUpdateBigQueryExportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateBigQueryExport",
      requestType = com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest.class,
      responseType = com.google.cloud.securitycenter.v1.BigQueryExport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest,
      com.google.cloud.securitycenter.v1.BigQueryExport> getUpdateBigQueryExportMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport> getUpdateBigQueryExportMethod;
    if ((getUpdateBigQueryExportMethod = SecurityCenterGrpc.getUpdateBigQueryExportMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateBigQueryExportMethod = SecurityCenterGrpc.getUpdateBigQueryExportMethod) == null) {
          SecurityCenterGrpc.getUpdateBigQueryExportMethod = getUpdateBigQueryExportMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest, com.google.cloud.securitycenter.v1.BigQueryExport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateBigQueryExport"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.BigQueryExport.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("UpdateBigQueryExport"))
              .build();
        }
      }
    }
    return getUpdateBigQueryExportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest,
      com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> getListBigQueryExportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListBigQueryExports",
      requestType = com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest.class,
      responseType = com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest,
      com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> getListBigQueryExportsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest, com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> getListBigQueryExportsMethod;
    if ((getListBigQueryExportsMethod = SecurityCenterGrpc.getListBigQueryExportsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListBigQueryExportsMethod = SecurityCenterGrpc.getListBigQueryExportsMethod) == null) {
          SecurityCenterGrpc.getListBigQueryExportsMethod = getListBigQueryExportsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest, com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListBigQueryExports"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListBigQueryExports"))
              .build();
        }
      }
    }
    return getListBigQueryExportsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SecurityCenterStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterStub>() {
        @java.lang.Override
        public SecurityCenterStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityCenterStub(channel, callOptions);
        }
      };
    return SecurityCenterStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterBlockingStub>() {
        @java.lang.Override
        public SecurityCenterBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityCenterBlockingStub(channel, callOptions);
        }
      };
    return SecurityCenterBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SecurityCenterFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SecurityCenterFutureStub>() {
        @java.lang.Override
        public SecurityCenterFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SecurityCenterFutureStub(channel, callOptions);
        }
      };
    return SecurityCenterFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static abstract class SecurityCenterImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. The
     * parent can be either an organization, folder or project. The findings
     * matched by the filter will be muted after the LRO is done.
     * </pre>
     */
    public void bulkMuteFindings(com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBulkMuteFindingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(com.google.cloud.securitycenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public void createFinding(com.google.cloud.securitycenter.v1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public void createMuteConfig(com.google.cloud.securitycenter.v1.CreateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMuteConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public void createNotificationConfig(com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing mute config.
     * </pre>
     */
    public void deleteMuteConfig(com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMuteConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public void deleteNotificationConfig(com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public void getBigQueryExport(com.google.cloud.securitycenter.v1.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBigQueryExportMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a mute config.
     * </pre>
     */
    public void getMuteConfig(com.google.cloud.securitycenter.v1.GetMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMuteConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public void getNotificationConfig(com.google.cloud.securitycenter.v1.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOrganizationSettingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(com.google.cloud.securitycenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(com.google.cloud.securitycenter.v1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupAssetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public void groupFindings(com.google.cloud.securitycenter.v1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupFindingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGroupFindingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(com.google.cloud.securitycenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListAssetsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public void listFindings(com.google.cloud.securitycenter.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFindingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists mute configs.
     * </pre>
     */
    public void listMuteConfigs(com.google.cloud.securitycenter.v1.ListMuteConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListMuteConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public void listNotificationConfigs(com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListNotificationConfigsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(com.google.cloud.securitycenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSourcesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRunAssetDiscoveryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(com.google.cloud.securitycenter.v1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetFindingStateMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates the mute state of a finding.
     * </pre>
     */
    public void setMute(com.google.cloud.securitycenter.v1.SetMuteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetMuteMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetIamPolicyMethod(), responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates external system. This is for a given finding.
     * </pre>
     */
    public void updateExternalSystem(com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ExternalSystem> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateExternalSystemMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(com.google.cloud.securitycenter.v1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateFindingMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a mute config.
     * </pre>
     */
    public void updateMuteConfig(com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateMuteConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public void updateNotificationConfig(com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateNotificationConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateOrganizationSettingsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(com.google.cloud.securitycenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSourceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateSecurityMarksMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public void createBigQueryExport(com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateBigQueryExportMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public void deleteBigQueryExport(com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteBigQueryExportMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public void updateBigQueryExport(com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateBigQueryExportMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public void listBigQueryExports(com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListBigQueryExportsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getBulkMuteFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_BULK_MUTE_FINDINGS)))
          .addMethod(
            getCreateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.CreateSourceRequest,
                com.google.cloud.securitycenter.v1.Source>(
                  this, METHODID_CREATE_SOURCE)))
          .addMethod(
            getCreateFindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.CreateFindingRequest,
                com.google.cloud.securitycenter.v1.Finding>(
                  this, METHODID_CREATE_FINDING)))
          .addMethod(
            getCreateMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.CreateMuteConfigRequest,
                com.google.cloud.securitycenter.v1.MuteConfig>(
                  this, METHODID_CREATE_MUTE_CONFIG)))
          .addMethod(
            getCreateNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest,
                com.google.cloud.securitycenter.v1.NotificationConfig>(
                  this, METHODID_CREATE_NOTIFICATION_CONFIG)))
          .addMethod(
            getDeleteMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_MUTE_CONFIG)))
          .addMethod(
            getDeleteNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_NOTIFICATION_CONFIG)))
          .addMethod(
            getGetBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GetBigQueryExportRequest,
                com.google.cloud.securitycenter.v1.BigQueryExport>(
                  this, METHODID_GET_BIG_QUERY_EXPORT)))
          .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.GetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_GET_IAM_POLICY)))
          .addMethod(
            getGetMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GetMuteConfigRequest,
                com.google.cloud.securitycenter.v1.MuteConfig>(
                  this, METHODID_GET_MUTE_CONFIG)))
          .addMethod(
            getGetNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GetNotificationConfigRequest,
                com.google.cloud.securitycenter.v1.NotificationConfig>(
                  this, METHODID_GET_NOTIFICATION_CONFIG)))
          .addMethod(
            getGetOrganizationSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
                com.google.cloud.securitycenter.v1.OrganizationSettings>(
                  this, METHODID_GET_ORGANIZATION_SETTINGS)))
          .addMethod(
            getGetSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GetSourceRequest,
                com.google.cloud.securitycenter.v1.Source>(
                  this, METHODID_GET_SOURCE)))
          .addMethod(
            getGroupAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GroupAssetsRequest,
                com.google.cloud.securitycenter.v1.GroupAssetsResponse>(
                  this, METHODID_GROUP_ASSETS)))
          .addMethod(
            getGroupFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.GroupFindingsRequest,
                com.google.cloud.securitycenter.v1.GroupFindingsResponse>(
                  this, METHODID_GROUP_FINDINGS)))
          .addMethod(
            getListAssetsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListAssetsRequest,
                com.google.cloud.securitycenter.v1.ListAssetsResponse>(
                  this, METHODID_LIST_ASSETS)))
          .addMethod(
            getListFindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListFindingsRequest,
                com.google.cloud.securitycenter.v1.ListFindingsResponse>(
                  this, METHODID_LIST_FINDINGS)))
          .addMethod(
            getListMuteConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListMuteConfigsRequest,
                com.google.cloud.securitycenter.v1.ListMuteConfigsResponse>(
                  this, METHODID_LIST_MUTE_CONFIGS)))
          .addMethod(
            getListNotificationConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest,
                com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse>(
                  this, METHODID_LIST_NOTIFICATION_CONFIGS)))
          .addMethod(
            getListSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListSourcesRequest,
                com.google.cloud.securitycenter.v1.ListSourcesResponse>(
                  this, METHODID_LIST_SOURCES)))
          .addMethod(
            getRunAssetDiscoveryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_RUN_ASSET_DISCOVERY)))
          .addMethod(
            getSetFindingStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.SetFindingStateRequest,
                com.google.cloud.securitycenter.v1.Finding>(
                  this, METHODID_SET_FINDING_STATE)))
          .addMethod(
            getSetMuteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.SetMuteRequest,
                com.google.cloud.securitycenter.v1.Finding>(
                  this, METHODID_SET_MUTE)))
          .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.SetIamPolicyRequest,
                com.google.iam.v1.Policy>(
                  this, METHODID_SET_IAM_POLICY)))
          .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.iam.v1.TestIamPermissionsRequest,
                com.google.iam.v1.TestIamPermissionsResponse>(
                  this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
            getUpdateExternalSystemMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest,
                com.google.cloud.securitycenter.v1.ExternalSystem>(
                  this, METHODID_UPDATE_EXTERNAL_SYSTEM)))
          .addMethod(
            getUpdateFindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateFindingRequest,
                com.google.cloud.securitycenter.v1.Finding>(
                  this, METHODID_UPDATE_FINDING)))
          .addMethod(
            getUpdateMuteConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest,
                com.google.cloud.securitycenter.v1.MuteConfig>(
                  this, METHODID_UPDATE_MUTE_CONFIG)))
          .addMethod(
            getUpdateNotificationConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest,
                com.google.cloud.securitycenter.v1.NotificationConfig>(
                  this, METHODID_UPDATE_NOTIFICATION_CONFIG)))
          .addMethod(
            getUpdateOrganizationSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
                com.google.cloud.securitycenter.v1.OrganizationSettings>(
                  this, METHODID_UPDATE_ORGANIZATION_SETTINGS)))
          .addMethod(
            getUpdateSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateSourceRequest,
                com.google.cloud.securitycenter.v1.Source>(
                  this, METHODID_UPDATE_SOURCE)))
          .addMethod(
            getUpdateSecurityMarksMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
                com.google.cloud.securitycenter.v1.SecurityMarks>(
                  this, METHODID_UPDATE_SECURITY_MARKS)))
          .addMethod(
            getCreateBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest,
                com.google.cloud.securitycenter.v1.BigQueryExport>(
                  this, METHODID_CREATE_BIG_QUERY_EXPORT)))
          .addMethod(
            getDeleteBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_BIG_QUERY_EXPORT)))
          .addMethod(
            getUpdateBigQueryExportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest,
                com.google.cloud.securitycenter.v1.BigQueryExport>(
                  this, METHODID_UPDATE_BIG_QUERY_EXPORT)))
          .addMethod(
            getListBigQueryExportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest,
                com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse>(
                  this, METHODID_LIST_BIG_QUERY_EXPORTS)))
          .build();
    }
  }

  /**
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterStub extends io.grpc.stub.AbstractAsyncStub<SecurityCenterStub> {
    private SecurityCenterStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. The
     * parent can be either an organization, folder or project. The findings
     * matched by the filter will be muted after the LRO is done.
     * </pre>
     */
    public void bulkMuteFindings(com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkMuteFindingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(com.google.cloud.securitycenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public void createFinding(com.google.cloud.securitycenter.v1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public void createMuteConfig(com.google.cloud.securitycenter.v1.CreateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMuteConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public void createNotificationConfig(com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing mute config.
     * </pre>
     */
    public void deleteMuteConfig(com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMuteConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public void deleteNotificationConfig(com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public void getBigQueryExport(com.google.cloud.securitycenter.v1.GetBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a mute config.
     * </pre>
     */
    public void getMuteConfig(com.google.cloud.securitycenter.v1.GetMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMuteConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public void getNotificationConfig(com.google.cloud.securitycenter.v1.GetNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(com.google.cloud.securitycenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(com.google.cloud.securitycenter.v1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public void groupFindings(com.google.cloud.securitycenter.v1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupFindingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(com.google.cloud.securitycenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public void listFindings(com.google.cloud.securitycenter.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists mute configs.
     * </pre>
     */
    public void listMuteConfigs(com.google.cloud.securitycenter.v1.ListMuteConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMuteConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public void listNotificationConfigs(com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(com.google.cloud.securitycenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(com.google.cloud.securitycenter.v1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates the mute state of a finding.
     * </pre>
     */
    public void setMute(com.google.cloud.securitycenter.v1.SetMuteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetMuteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates external system. This is for a given finding.
     * </pre>
     */
    public void updateExternalSystem(com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ExternalSystem> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateExternalSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(com.google.cloud.securitycenter.v1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a mute config.
     * </pre>
     */
    public void updateMuteConfig(com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMuteConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public void updateNotificationConfig(com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(com.google.cloud.securitycenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public void createBigQueryExport(com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateBigQueryExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public void deleteBigQueryExport(com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteBigQueryExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public void updateBigQueryExport(com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public void listBigQueryExports(com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListBigQueryExportsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterBlockingStub extends io.grpc.stub.AbstractBlockingStub<SecurityCenterBlockingStub> {
    private SecurityCenterBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. The
     * parent can be either an organization, folder or project. The findings
     * matched by the filter will be muted after the LRO is done.
     * </pre>
     */
    public com.google.longrunning.Operation bulkMuteFindings(com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkMuteFindingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source createSource(com.google.cloud.securitycenter.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding createFinding(com.google.cloud.securitycenter.v1.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.MuteConfig createMuteConfig(com.google.cloud.securitycenter.v1.CreateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.NotificationConfig createNotificationConfig(com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing mute config.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMuteConfig(com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNotificationConfig(com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.BigQueryExport getBigQueryExport(com.google.cloud.securitycenter.v1.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a mute config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.MuteConfig getMuteConfig(com.google.cloud.securitycenter.v1.GetMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.NotificationConfig getNotificationConfig(com.google.cloud.securitycenter.v1.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.OrganizationSettings getOrganizationSettings(com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrganizationSettingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source getSource(com.google.cloud.securitycenter.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.GroupAssetsResponse groupAssets(com.google.cloud.securitycenter.v1.GroupAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupAssetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.GroupFindingsResponse groupFindings(com.google.cloud.securitycenter.v1.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGroupFindingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListAssetsResponse listAssets(com.google.cloud.securitycenter.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAssetsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListFindingsResponse listFindings(com.google.cloud.securitycenter.v1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists mute configs.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListMuteConfigsResponse listMuteConfigs(com.google.cloud.securitycenter.v1.ListMuteConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMuteConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse listNotificationConfigs(com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNotificationConfigsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListSourcesResponse listSources(com.google.cloud.securitycenter.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSourcesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.longrunning.Operation runAssetDiscovery(com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunAssetDiscoveryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding setFindingState(com.google.cloud.securitycenter.v1.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetFindingStateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates the mute state of a finding.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding setMute(com.google.cloud.securitycenter.v1.SetMuteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetMuteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates external system. This is for a given finding.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ExternalSystem updateExternalSystem(com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateExternalSystemMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding updateFinding(com.google.cloud.securitycenter.v1.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFindingMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a mute config.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.MuteConfig updateMuteConfig(com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMuteConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.NotificationConfig updateNotificationConfig(com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNotificationConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.OrganizationSettings updateOrganizationSettings(com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOrganizationSettingsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source updateSource(com.google.cloud.securitycenter.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSourceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.SecurityMarks updateSecurityMarks(com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSecurityMarksMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.BigQueryExport createBigQueryExport(com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBigQueryExport(com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.BigQueryExport updateBigQueryExport(com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateBigQueryExportMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse listBigQueryExports(com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListBigQueryExportsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterFutureStub extends io.grpc.stub.AbstractFutureStub<SecurityCenterFutureStub> {
    private SecurityCenterFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Kicks off an LRO to bulk mute findings for a parent based on a filter. The
     * parent can be either an organization, folder or project. The findings
     * matched by the filter will be muted after the LRO is done.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> bulkMuteFindings(
        com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkMuteFindingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Source> createSource(
        com.google.cloud.securitycenter.v1.CreateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Finding> createFinding(
        com.google.cloud.securitycenter.v1.CreateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a mute config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.MuteConfig> createMuteConfig(
        com.google.cloud.securitycenter.v1.CreateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.NotificationConfig> createNotificationConfig(
        com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing mute config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteMuteConfig(
        com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteNotificationConfig(
        com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.BigQueryExport> getBigQueryExport(
        com.google.cloud.securitycenter.v1.GetBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a mute config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.MuteConfig> getMuteConfig(
        com.google.cloud.securitycenter.v1.GetMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a notification config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.NotificationConfig> getNotificationConfig(
        com.google.cloud.securitycenter.v1.GetNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.OrganizationSettings> getOrganizationSettings(
        com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Source> getSource(
        com.google.cloud.securitycenter.v1.GetSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.GroupAssetsResponse> groupAssets(
        com.google.cloud.securitycenter.v1.GroupAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupAssetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings,
     * /v1/folders/{folder_id}/sources/-/findings,
     * /v1/projects/{project_id}/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.GroupFindingsResponse> groupFindings(
        com.google.cloud.securitycenter.v1.GroupFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGroupFindingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListAssetsResponse> listAssets(
        com.google.cloud.securitycenter.v1.ListAssetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAssetsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/{organization_id}/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListFindingsResponse> listFindings(
        com.google.cloud.securitycenter.v1.ListFindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists mute configs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListMuteConfigsResponse> listMuteConfigs(
        com.google.cloud.securitycenter.v1.ListMuteConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMuteConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists notification configs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse> listNotificationConfigs(
        com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNotificationConfigsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListSourcesResponse> listSources(
        com.google.cloud.securitycenter.v1.ListSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSourcesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> runAssetDiscovery(
        com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Finding> setFindingState(
        com.google.cloud.securitycenter.v1.SetFindingStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetFindingStateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates the mute state of a finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Finding> setMute(
        com.google.cloud.securitycenter.v1.SetMuteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetMuteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy> setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.TestIamPermissionsResponse> testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates external system. This is for a given finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ExternalSystem> updateExternalSystem(
        com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateExternalSystemMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Finding> updateFinding(
        com.google.cloud.securitycenter.v1.UpdateFindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFindingMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a mute config.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.MuteConfig> updateMuteConfig(
        com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMuteConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a notification config. The following update
     * fields are allowed: description, pubsub_topic, streaming_config.filter
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.NotificationConfig> updateNotificationConfig(
        com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNotificationConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.OrganizationSettings> updateOrganizationSettings(
        com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.Source> updateSource(
        com.google.cloud.securitycenter.v1.UpdateSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.SecurityMarks> updateSecurityMarks(
        com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.BigQueryExport> createBigQueryExport(
        com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an existing BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteBigQueryExport(
        com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates a BigQuery export.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.BigQueryExport> updateBigQueryExport(
        com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateBigQueryExportMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists BigQuery exports. Note that when requesting BigQuery exports at a
     * given level all exports under that level are also returned e.g. if
     * requesting BigQuery exports under a folder, then all BigQuery exports
     * immediately under the folder plus the ones created under the projects
     * within the folder are returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse> listBigQueryExports(
        com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListBigQueryExportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BULK_MUTE_FINDINGS = 0;
  private static final int METHODID_CREATE_SOURCE = 1;
  private static final int METHODID_CREATE_FINDING = 2;
  private static final int METHODID_CREATE_MUTE_CONFIG = 3;
  private static final int METHODID_CREATE_NOTIFICATION_CONFIG = 4;
  private static final int METHODID_DELETE_MUTE_CONFIG = 5;
  private static final int METHODID_DELETE_NOTIFICATION_CONFIG = 6;
  private static final int METHODID_GET_BIG_QUERY_EXPORT = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_GET_MUTE_CONFIG = 9;
  private static final int METHODID_GET_NOTIFICATION_CONFIG = 10;
  private static final int METHODID_GET_ORGANIZATION_SETTINGS = 11;
  private static final int METHODID_GET_SOURCE = 12;
  private static final int METHODID_GROUP_ASSETS = 13;
  private static final int METHODID_GROUP_FINDINGS = 14;
  private static final int METHODID_LIST_ASSETS = 15;
  private static final int METHODID_LIST_FINDINGS = 16;
  private static final int METHODID_LIST_MUTE_CONFIGS = 17;
  private static final int METHODID_LIST_NOTIFICATION_CONFIGS = 18;
  private static final int METHODID_LIST_SOURCES = 19;
  private static final int METHODID_RUN_ASSET_DISCOVERY = 20;
  private static final int METHODID_SET_FINDING_STATE = 21;
  private static final int METHODID_SET_MUTE = 22;
  private static final int METHODID_SET_IAM_POLICY = 23;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 24;
  private static final int METHODID_UPDATE_EXTERNAL_SYSTEM = 25;
  private static final int METHODID_UPDATE_FINDING = 26;
  private static final int METHODID_UPDATE_MUTE_CONFIG = 27;
  private static final int METHODID_UPDATE_NOTIFICATION_CONFIG = 28;
  private static final int METHODID_UPDATE_ORGANIZATION_SETTINGS = 29;
  private static final int METHODID_UPDATE_SOURCE = 30;
  private static final int METHODID_UPDATE_SECURITY_MARKS = 31;
  private static final int METHODID_CREATE_BIG_QUERY_EXPORT = 32;
  private static final int METHODID_DELETE_BIG_QUERY_EXPORT = 33;
  private static final int METHODID_UPDATE_BIG_QUERY_EXPORT = 34;
  private static final int METHODID_LIST_BIG_QUERY_EXPORTS = 35;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SecurityCenterImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SecurityCenterImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BULK_MUTE_FINDINGS:
          serviceImpl.bulkMuteFindings((com.google.cloud.securitycenter.v1.BulkMuteFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource((com.google.cloud.securitycenter.v1.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>) responseObserver);
          break;
        case METHODID_CREATE_FINDING:
          serviceImpl.createFinding((com.google.cloud.securitycenter.v1.CreateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>) responseObserver);
          break;
        case METHODID_CREATE_MUTE_CONFIG:
          serviceImpl.createMuteConfig((com.google.cloud.securitycenter.v1.CreateMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig>) responseObserver);
          break;
        case METHODID_CREATE_NOTIFICATION_CONFIG:
          serviceImpl.createNotificationConfig((com.google.cloud.securitycenter.v1.CreateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig>) responseObserver);
          break;
        case METHODID_DELETE_MUTE_CONFIG:
          serviceImpl.deleteMuteConfig((com.google.cloud.securitycenter.v1.DeleteMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_NOTIFICATION_CONFIG:
          serviceImpl.deleteNotificationConfig((com.google.cloud.securitycenter.v1.DeleteNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_BIG_QUERY_EXPORT:
          serviceImpl.getBigQueryExport((com.google.cloud.securitycenter.v1.GetBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy((com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_MUTE_CONFIG:
          serviceImpl.getMuteConfig((com.google.cloud.securitycenter.v1.GetMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig>) responseObserver);
          break;
        case METHODID_GET_NOTIFICATION_CONFIG:
          serviceImpl.getNotificationConfig((com.google.cloud.securitycenter.v1.GetNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig>) responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_SETTINGS:
          serviceImpl.getOrganizationSettings((com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>) responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource((com.google.cloud.securitycenter.v1.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>) responseObserver);
          break;
        case METHODID_GROUP_ASSETS:
          serviceImpl.groupAssets((com.google.cloud.securitycenter.v1.GroupAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse>) responseObserver);
          break;
        case METHODID_GROUP_FINDINGS:
          serviceImpl.groupFindings((com.google.cloud.securitycenter.v1.GroupFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupFindingsResponse>) responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets((com.google.cloud.securitycenter.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse>) responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings((com.google.cloud.securitycenter.v1.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse>) responseObserver);
          break;
        case METHODID_LIST_MUTE_CONFIGS:
          serviceImpl.listMuteConfigs((com.google.cloud.securitycenter.v1.ListMuteConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListMuteConfigsResponse>) responseObserver);
          break;
        case METHODID_LIST_NOTIFICATION_CONFIGS:
          serviceImpl.listNotificationConfigs((com.google.cloud.securitycenter.v1.ListNotificationConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListNotificationConfigsResponse>) responseObserver);
          break;
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources((com.google.cloud.securitycenter.v1.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse>) responseObserver);
          break;
        case METHODID_RUN_ASSET_DISCOVERY:
          serviceImpl.runAssetDiscovery((com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_FINDING_STATE:
          serviceImpl.setFindingState((com.google.cloud.securitycenter.v1.SetFindingStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>) responseObserver);
          break;
        case METHODID_SET_MUTE:
          serviceImpl.setMute((com.google.cloud.securitycenter.v1.SetMuteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy((com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions((com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_EXTERNAL_SYSTEM:
          serviceImpl.updateExternalSystem((com.google.cloud.securitycenter.v1.UpdateExternalSystemRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ExternalSystem>) responseObserver);
          break;
        case METHODID_UPDATE_FINDING:
          serviceImpl.updateFinding((com.google.cloud.securitycenter.v1.UpdateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>) responseObserver);
          break;
        case METHODID_UPDATE_MUTE_CONFIG:
          serviceImpl.updateMuteConfig((com.google.cloud.securitycenter.v1.UpdateMuteConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.MuteConfig>) responseObserver);
          break;
        case METHODID_UPDATE_NOTIFICATION_CONFIG:
          serviceImpl.updateNotificationConfig((com.google.cloud.securitycenter.v1.UpdateNotificationConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.NotificationConfig>) responseObserver);
          break;
        case METHODID_UPDATE_ORGANIZATION_SETTINGS:
          serviceImpl.updateOrganizationSettings((com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>) responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource((com.google.cloud.securitycenter.v1.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>) responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_MARKS:
          serviceImpl.updateSecurityMarks((com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks>) responseObserver);
          break;
        case METHODID_CREATE_BIG_QUERY_EXPORT:
          serviceImpl.createBigQueryExport((com.google.cloud.securitycenter.v1.CreateBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport>) responseObserver);
          break;
        case METHODID_DELETE_BIG_QUERY_EXPORT:
          serviceImpl.deleteBigQueryExport((com.google.cloud.securitycenter.v1.DeleteBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_BIG_QUERY_EXPORT:
          serviceImpl.updateBigQueryExport((com.google.cloud.securitycenter.v1.UpdateBigQueryExportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.BigQueryExport>) responseObserver);
          break;
        case METHODID_LIST_BIG_QUERY_EXPORTS:
          serviceImpl.listBigQueryExports((com.google.cloud.securitycenter.v1.ListBigQueryExportsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListBigQueryExportsResponse>) responseObserver);
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

  private static abstract class SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SecurityCenterBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.securitycenter.v1.SecuritycenterService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SecurityCenter");
    }
  }

  private static final class SecurityCenterFileDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier {
    SecurityCenterFileDescriptorSupplier() {}
  }

  private static final class SecurityCenterMethodDescriptorSupplier
      extends SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SecurityCenterMethodDescriptorSupplier(String methodName) {
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
      synchronized (SecurityCenterGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SecurityCenterFileDescriptorSupplier())
              .addMethod(getBulkMuteFindingsMethod())
              .addMethod(getCreateSourceMethod())
              .addMethod(getCreateFindingMethod())
              .addMethod(getCreateMuteConfigMethod())
              .addMethod(getCreateNotificationConfigMethod())
              .addMethod(getDeleteMuteConfigMethod())
              .addMethod(getDeleteNotificationConfigMethod())
              .addMethod(getGetBigQueryExportMethod())
              .addMethod(getGetIamPolicyMethod())
              .addMethod(getGetMuteConfigMethod())
              .addMethod(getGetNotificationConfigMethod())
              .addMethod(getGetOrganizationSettingsMethod())
              .addMethod(getGetSourceMethod())
              .addMethod(getGroupAssetsMethod())
              .addMethod(getGroupFindingsMethod())
              .addMethod(getListAssetsMethod())
              .addMethod(getListFindingsMethod())
              .addMethod(getListMuteConfigsMethod())
              .addMethod(getListNotificationConfigsMethod())
              .addMethod(getListSourcesMethod())
              .addMethod(getRunAssetDiscoveryMethod())
              .addMethod(getSetFindingStateMethod())
              .addMethod(getSetMuteMethod())
              .addMethod(getSetIamPolicyMethod())
              .addMethod(getTestIamPermissionsMethod())
              .addMethod(getUpdateExternalSystemMethod())
              .addMethod(getUpdateFindingMethod())
              .addMethod(getUpdateMuteConfigMethod())
              .addMethod(getUpdateNotificationConfigMethod())
              .addMethod(getUpdateOrganizationSettingsMethod())
              .addMethod(getUpdateSourceMethod())
              .addMethod(getUpdateSecurityMarksMethod())
              .addMethod(getCreateBigQueryExportMethod())
              .addMethod(getDeleteBigQueryExportMethod())
              .addMethod(getUpdateBigQueryExportMethod())
              .addMethod(getListBigQueryExportsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
