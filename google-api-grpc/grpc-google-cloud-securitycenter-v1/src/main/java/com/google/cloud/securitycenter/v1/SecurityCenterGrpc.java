package com.google.cloud.securitycenter.v1;

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
 * V1 APIs for Security Center service.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/securitycenter/v1/securitycenter_service.proto")
public final class SecurityCenterGrpc {

  private SecurityCenterGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.securitycenter.v1.SecurityCenter";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateSourceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      METHOD_CREATE_SOURCE = getCreateSourceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getCreateSourceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getCreateSourceMethod() {
    return getCreateSourceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getCreateSourceMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.CreateSourceRequest,
            com.google.cloud.securitycenter.v1.Source>
        getCreateSourceMethod;
    if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateSourceMethod = SecurityCenterGrpc.getCreateSourceMethod) == null) {
          SecurityCenterGrpc.getCreateSourceMethod =
              getCreateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.CreateSourceRequest,
                          com.google.cloud.securitycenter.v1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "CreateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.CreateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateSource"))
                      .build();
        }
      }
    }
    return getCreateSourceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateFindingMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      METHOD_CREATE_FINDING = getCreateFindingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getCreateFindingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getCreateFindingMethod() {
    return getCreateFindingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.CreateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getCreateFindingMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.CreateFindingRequest,
            com.google.cloud.securitycenter.v1.Finding>
        getCreateFindingMethod;
    if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getCreateFindingMethod = SecurityCenterGrpc.getCreateFindingMethod) == null) {
          SecurityCenterGrpc.getCreateFindingMethod =
              getCreateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.CreateFindingRequest,
                          com.google.cloud.securitycenter.v1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "CreateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.CreateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("CreateFinding"))
                      .build();
        }
      }
    }
    return getCreateFindingMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetIamPolicyMethod = SecurityCenterGrpc.getGetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetOrganizationSettingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      METHOD_GET_ORGANIZATION_SETTINGS = getGetOrganizationSettingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getGetOrganizationSettingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getGetOrganizationSettingsMethod() {
    return getGetOrganizationSettingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getGetOrganizationSettingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
            com.google.cloud.securitycenter.v1.OrganizationSettings>
        getGetOrganizationSettingsMethod;
    if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetOrganizationSettingsMethod = SecurityCenterGrpc.getGetOrganizationSettingsMethod)
            == null) {
          SecurityCenterGrpc.getGetOrganizationSettingsMethod =
              getGetOrganizationSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
                          com.google.cloud.securitycenter.v1.OrganizationSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter",
                              "GetOrganizationSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.OrganizationSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GetOrganizationSettings"))
                      .build();
        }
      }
    }
    return getGetOrganizationSettingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetSourceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      METHOD_GET_SOURCE = getGetSourceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getGetSourceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getGetSourceMethod() {
    return getGetSourceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GetSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getGetSourceMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.GetSourceRequest,
            com.google.cloud.securitycenter.v1.Source>
        getGetSourceMethod;
    if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGetSourceMethod = SecurityCenterGrpc.getGetSourceMethod) == null) {
          SecurityCenterGrpc.getGetSourceMethod =
              getGetSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.GetSourceRequest,
                          com.google.cloud.securitycenter.v1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "GetSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GetSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("GetSource"))
                      .build();
        }
      }
    }
    return getGetSourceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGroupAssetsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1.GroupAssetsResponse>
      METHOD_GROUP_ASSETS = getGroupAssetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1.GroupAssetsResponse>
      getGroupAssetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1.GroupAssetsResponse>
      getGroupAssetsMethod() {
    return getGroupAssetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupAssetsRequest,
          com.google.cloud.securitycenter.v1.GroupAssetsResponse>
      getGroupAssetsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.GroupAssetsRequest,
            com.google.cloud.securitycenter.v1.GroupAssetsResponse>
        getGroupAssetsMethod;
    if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupAssetsMethod = SecurityCenterGrpc.getGroupAssetsMethod) == null) {
          SecurityCenterGrpc.getGroupAssetsMethod =
              getGroupAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.GroupAssetsRequest,
                          com.google.cloud.securitycenter.v1.GroupAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "GroupAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GroupAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GroupAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GroupAssets"))
                      .build();
        }
      }
    }
    return getGroupAssetsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGroupFindingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1.GroupFindingsResponse>
      METHOD_GROUP_FINDINGS = getGroupFindingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1.GroupFindingsResponse>
      getGroupFindingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1.GroupFindingsResponse>
      getGroupFindingsMethod() {
    return getGroupFindingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.GroupFindingsRequest,
          com.google.cloud.securitycenter.v1.GroupFindingsResponse>
      getGroupFindingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.GroupFindingsRequest,
            com.google.cloud.securitycenter.v1.GroupFindingsResponse>
        getGroupFindingsMethod;
    if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getGroupFindingsMethod = SecurityCenterGrpc.getGroupFindingsMethod) == null) {
          SecurityCenterGrpc.getGroupFindingsMethod =
              getGroupFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.GroupFindingsRequest,
                          com.google.cloud.securitycenter.v1.GroupFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "GroupFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GroupFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.GroupFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("GroupFindings"))
                      .build();
        }
      }
    }
    return getGroupFindingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAssetsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1.ListAssetsResponse>
      METHOD_LIST_ASSETS = getListAssetsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1.ListAssetsResponse>
      getListAssetsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1.ListAssetsResponse>
      getListAssetsMethod() {
    return getListAssetsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListAssetsRequest,
          com.google.cloud.securitycenter.v1.ListAssetsResponse>
      getListAssetsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.ListAssetsRequest,
            com.google.cloud.securitycenter.v1.ListAssetsResponse>
        getListAssetsMethod;
    if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListAssetsMethod = SecurityCenterGrpc.getListAssetsMethod) == null) {
          SecurityCenterGrpc.getListAssetsMethod =
              getListAssetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.ListAssetsRequest,
                          com.google.cloud.securitycenter.v1.ListAssetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "ListAssets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListAssetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListAssetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new SecurityCenterMethodDescriptorSupplier("ListAssets"))
                      .build();
        }
      }
    }
    return getListAssetsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListFindingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1.ListFindingsResponse>
      METHOD_LIST_FINDINGS = getListFindingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1.ListFindingsResponse>
      getListFindingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1.ListFindingsResponse>
      getListFindingsMethod() {
    return getListFindingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListFindingsRequest,
          com.google.cloud.securitycenter.v1.ListFindingsResponse>
      getListFindingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.ListFindingsRequest,
            com.google.cloud.securitycenter.v1.ListFindingsResponse>
        getListFindingsMethod;
    if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListFindingsMethod = SecurityCenterGrpc.getListFindingsMethod) == null) {
          SecurityCenterGrpc.getListFindingsMethod =
              getListFindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.ListFindingsRequest,
                          com.google.cloud.securitycenter.v1.ListFindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "ListFindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListFindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListFindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListFindings"))
                      .build();
        }
      }
    }
    return getListFindingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListSourcesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1.ListSourcesResponse>
      METHOD_LIST_SOURCES = getListSourcesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1.ListSourcesResponse>
      getListSourcesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1.ListSourcesResponse>
      getListSourcesMethod() {
    return getListSourcesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.ListSourcesRequest,
          com.google.cloud.securitycenter.v1.ListSourcesResponse>
      getListSourcesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.ListSourcesRequest,
            com.google.cloud.securitycenter.v1.ListSourcesResponse>
        getListSourcesMethod;
    if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getListSourcesMethod = SecurityCenterGrpc.getListSourcesMethod) == null) {
          SecurityCenterGrpc.getListSourcesMethod =
              getListSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.ListSourcesRequest,
                          com.google.cloud.securitycenter.v1.ListSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "ListSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.ListSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("ListSources"))
                      .build();
        }
      }
    }
    return getListSourcesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunAssetDiscoveryMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      METHOD_RUN_ASSET_DISCOVERY = getRunAssetDiscoveryMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      getRunAssetDiscoveryMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      getRunAssetDiscoveryMethod() {
    return getRunAssetDiscoveryMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
          com.google.longrunning.Operation>
      getRunAssetDiscoveryMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
            com.google.longrunning.Operation>
        getRunAssetDiscoveryMethod;
    if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getRunAssetDiscoveryMethod = SecurityCenterGrpc.getRunAssetDiscoveryMethod) == null) {
          SecurityCenterGrpc.getRunAssetDiscoveryMethod =
              getRunAssetDiscoveryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "RunAssetDiscovery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("RunAssetDiscovery"))
                      .build();
        }
      }
    }
    return getRunAssetDiscoveryMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetFindingStateMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1.Finding>
      METHOD_SET_FINDING_STATE = getSetFindingStateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getSetFindingStateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getSetFindingStateMethod() {
    return getSetFindingStateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.SetFindingStateRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getSetFindingStateMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.SetFindingStateRequest,
            com.google.cloud.securitycenter.v1.Finding>
        getSetFindingStateMethod;
    if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetFindingStateMethod = SecurityCenterGrpc.getSetFindingStateMethod) == null) {
          SecurityCenterGrpc.getSetFindingStateMethod =
              getSetFindingStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.SetFindingStateRequest,
                          com.google.cloud.securitycenter.v1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "SetFindingState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.SetFindingStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("SetFindingState"))
                      .build();
        }
      }
    }
    return getSetFindingStateMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getSetIamPolicyMethod = SecurityCenterGrpc.getSetIamPolicyMethod) == null) {
          SecurityCenterGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getTestIamPermissionsMethod = SecurityCenterGrpc.getTestIamPermissionsMethod)
            == null) {
          SecurityCenterGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter",
                              "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateFindingMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      METHOD_UPDATE_FINDING = getUpdateFindingMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getUpdateFindingMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getUpdateFindingMethod() {
    return getUpdateFindingMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateFindingRequest,
          com.google.cloud.securitycenter.v1.Finding>
      getUpdateFindingMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.UpdateFindingRequest,
            com.google.cloud.securitycenter.v1.Finding>
        getUpdateFindingMethod;
    if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateFindingMethod = SecurityCenterGrpc.getUpdateFindingMethod) == null) {
          SecurityCenterGrpc.getUpdateFindingMethod =
              getUpdateFindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.UpdateFindingRequest,
                          com.google.cloud.securitycenter.v1.Finding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "UpdateFinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.UpdateFindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Finding.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateFinding"))
                      .build();
        }
      }
    }
    return getUpdateFindingMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateOrganizationSettingsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      METHOD_UPDATE_ORGANIZATION_SETTINGS = getUpdateOrganizationSettingsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getUpdateOrganizationSettingsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getUpdateOrganizationSettingsMethod() {
    return getUpdateOrganizationSettingsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
          com.google.cloud.securitycenter.v1.OrganizationSettings>
      getUpdateOrganizationSettingsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
            com.google.cloud.securitycenter.v1.OrganizationSettings>
        getUpdateOrganizationSettingsMethod;
    if ((getUpdateOrganizationSettingsMethod =
            SecurityCenterGrpc.getUpdateOrganizationSettingsMethod)
        == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateOrganizationSettingsMethod =
                SecurityCenterGrpc.getUpdateOrganizationSettingsMethod)
            == null) {
          SecurityCenterGrpc.getUpdateOrganizationSettingsMethod =
              getUpdateOrganizationSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
                          com.google.cloud.securitycenter.v1.OrganizationSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter",
                              "UpdateOrganizationSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.OrganizationSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateOrganizationSettings"))
                      .build();
        }
      }
    }
    return getUpdateOrganizationSettingsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSourceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      METHOD_UPDATE_SOURCE = getUpdateSourceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getUpdateSourceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getUpdateSourceMethod() {
    return getUpdateSourceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSourceRequest,
          com.google.cloud.securitycenter.v1.Source>
      getUpdateSourceMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.UpdateSourceRequest,
            com.google.cloud.securitycenter.v1.Source>
        getUpdateSourceMethod;
    if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSourceMethod = SecurityCenterGrpc.getUpdateSourceMethod) == null) {
          SecurityCenterGrpc.getUpdateSourceMethod =
              getUpdateSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.UpdateSourceRequest,
                          com.google.cloud.securitycenter.v1.Source>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter", "UpdateSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.UpdateSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.Source.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSource"))
                      .build();
        }
      }
    }
    return getUpdateSourceMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateSecurityMarksMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1.SecurityMarks>
      METHOD_UPDATE_SECURITY_MARKS = getUpdateSecurityMarksMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1.SecurityMarks>
      getUpdateSecurityMarksMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1.SecurityMarks>
      getUpdateSecurityMarksMethod() {
    return getUpdateSecurityMarksMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
          com.google.cloud.securitycenter.v1.SecurityMarks>
      getUpdateSecurityMarksMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
            com.google.cloud.securitycenter.v1.SecurityMarks>
        getUpdateSecurityMarksMethod;
    if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod) == null) {
      synchronized (SecurityCenterGrpc.class) {
        if ((getUpdateSecurityMarksMethod = SecurityCenterGrpc.getUpdateSecurityMarksMethod)
            == null) {
          SecurityCenterGrpc.getUpdateSecurityMarksMethod =
              getUpdateSecurityMarksMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
                          com.google.cloud.securitycenter.v1.SecurityMarks>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.securitycenter.v1.SecurityCenter",
                              "UpdateSecurityMarks"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.securitycenter.v1.SecurityMarks
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SecurityCenterMethodDescriptorSupplier("UpdateSecurityMarks"))
                      .build();
        }
      }
    }
    return getUpdateSecurityMarksMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SecurityCenterStub newStub(io.grpc.Channel channel) {
    return new SecurityCenterStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SecurityCenterBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new SecurityCenterBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SecurityCenterFutureStub newFutureStub(io.grpc.Channel channel) {
    return new SecurityCenterFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public abstract static class SecurityCenterImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(
        com.google.cloud.securitycenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSourceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public void createFinding(
        com.google.cloud.securitycenter.v1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateFindingMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(
        com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetOrganizationSettingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.securitycenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnimplementedUnaryCall(getGetSourceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(
        com.google.cloud.securitycenter.v1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGroupAssetsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public void groupFindings(
        com.google.cloud.securitycenter.v1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupFindingsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGroupFindingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.securitycenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListAssetsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public void listFindings(
        com.google.cloud.securitycenter.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListFindingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(
        com.google.cloud.securitycenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListSourcesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(
        com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRunAssetDiscoveryMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(
        com.google.cloud.securitycenter.v1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnimplementedUnaryCall(getSetFindingStateMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(
        com.google.cloud.securitycenter.v1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateFindingMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(
        com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateOrganizationSettingsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.securitycenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSourceMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(
        com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSecurityMarksMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateSourceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.CreateSourceRequest,
                      com.google.cloud.securitycenter.v1.Source>(this, METHODID_CREATE_SOURCE)))
          .addMethod(
              getCreateFindingMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.CreateFindingRequest,
                      com.google.cloud.securitycenter.v1.Finding>(this, METHODID_CREATE_FINDING)))
          .addMethod(
              getGetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getGetOrganizationSettingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest,
                      com.google.cloud.securitycenter.v1.OrganizationSettings>(
                      this, METHODID_GET_ORGANIZATION_SETTINGS)))
          .addMethod(
              getGetSourceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.GetSourceRequest,
                      com.google.cloud.securitycenter.v1.Source>(this, METHODID_GET_SOURCE)))
          .addMethod(
              getGroupAssetsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.GroupAssetsRequest,
                      com.google.cloud.securitycenter.v1.GroupAssetsResponse>(
                      this, METHODID_GROUP_ASSETS)))
          .addMethod(
              getGroupFindingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.GroupFindingsRequest,
                      com.google.cloud.securitycenter.v1.GroupFindingsResponse>(
                      this, METHODID_GROUP_FINDINGS)))
          .addMethod(
              getListAssetsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.ListAssetsRequest,
                      com.google.cloud.securitycenter.v1.ListAssetsResponse>(
                      this, METHODID_LIST_ASSETS)))
          .addMethod(
              getListFindingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.ListFindingsRequest,
                      com.google.cloud.securitycenter.v1.ListFindingsResponse>(
                      this, METHODID_LIST_FINDINGS)))
          .addMethod(
              getListSourcesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.ListSourcesRequest,
                      com.google.cloud.securitycenter.v1.ListSourcesResponse>(
                      this, METHODID_LIST_SOURCES)))
          .addMethod(
              getRunAssetDiscoveryMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest,
                      com.google.longrunning.Operation>(this, METHODID_RUN_ASSET_DISCOVERY)))
          .addMethod(
              getSetFindingStateMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.SetFindingStateRequest,
                      com.google.cloud.securitycenter.v1.Finding>(
                      this, METHODID_SET_FINDING_STATE)))
          .addMethod(
              getSetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getUpdateFindingMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.UpdateFindingRequest,
                      com.google.cloud.securitycenter.v1.Finding>(this, METHODID_UPDATE_FINDING)))
          .addMethod(
              getUpdateOrganizationSettingsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest,
                      com.google.cloud.securitycenter.v1.OrganizationSettings>(
                      this, METHODID_UPDATE_ORGANIZATION_SETTINGS)))
          .addMethod(
              getUpdateSourceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.UpdateSourceRequest,
                      com.google.cloud.securitycenter.v1.Source>(this, METHODID_UPDATE_SOURCE)))
          .addMethod(
              getUpdateSecurityMarksMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest,
                      com.google.cloud.securitycenter.v1.SecurityMarks>(
                      this, METHODID_UPDATE_SECURITY_MARKS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterStub
      extends io.grpc.stub.AbstractStub<SecurityCenterStub> {
    private SecurityCenterStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityCenterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public void createSource(
        com.google.cloud.securitycenter.v1.CreateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSourceMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public void createFinding(
        com.google.cloud.securitycenter.v1.CreateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateFindingMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public void getOrganizationSettings(
        com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public void getSource(
        com.google.cloud.securitycenter.v1.GetSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSourceMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public void groupAssets(
        com.google.cloud.securitycenter.v1.GroupAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGroupAssetsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public void groupFindings(
        com.google.cloud.securitycenter.v1.GroupFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupFindingsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGroupFindingsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public void listAssets(
        com.google.cloud.securitycenter.v1.ListAssetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAssetsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public void listFindings(
        com.google.cloud.securitycenter.v1.ListFindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListFindingsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public void listSources(
        com.google.cloud.securitycenter.v1.ListSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSourcesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public void runAssetDiscovery(
        com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public void setFindingState(
        com.google.cloud.securitycenter.v1.SetFindingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetFindingStateMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public void updateFinding(
        com.google.cloud.securitycenter.v1.UpdateFindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateFindingMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public void updateOrganizationSettings(
        com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public void updateSource(
        com.google.cloud.securitycenter.v1.UpdateSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSourceMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public void updateSecurityMarks(
        com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterBlockingStub
      extends io.grpc.stub.AbstractStub<SecurityCenterBlockingStub> {
    private SecurityCenterBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityCenterBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source createSource(
        com.google.cloud.securitycenter.v1.CreateSourceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateSourceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding createFinding(
        com.google.cloud.securitycenter.v1.CreateFindingRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateFindingMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.OrganizationSettings getOrganizationSettings(
        com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetOrganizationSettingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source getSource(
        com.google.cloud.securitycenter.v1.GetSourceRequest request) {
      return blockingUnaryCall(getChannel(), getGetSourceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.GroupAssetsResponse groupAssets(
        com.google.cloud.securitycenter.v1.GroupAssetsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGroupAssetsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.GroupFindingsResponse groupFindings(
        com.google.cloud.securitycenter.v1.GroupFindingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getGroupFindingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListAssetsResponse listAssets(
        com.google.cloud.securitycenter.v1.ListAssetsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAssetsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListFindingsResponse listFindings(
        com.google.cloud.securitycenter.v1.ListFindingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListFindingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.ListSourcesResponse listSources(
        com.google.cloud.securitycenter.v1.ListSourcesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListSourcesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.longrunning.Operation runAssetDiscovery(
        com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request) {
      return blockingUnaryCall(
          getChannel(), getRunAssetDiscoveryMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding setFindingState(
        com.google.cloud.securitycenter.v1.SetFindingStateRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetFindingStateMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Finding updateFinding(
        com.google.cloud.securitycenter.v1.UpdateFindingRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateFindingMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.OrganizationSettings updateOrganizationSettings(
        com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateOrganizationSettingsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.Source updateSource(
        com.google.cloud.securitycenter.v1.UpdateSourceRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSourceMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.cloud.securitycenter.v1.SecurityMarks updateSecurityMarks(
        com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateSecurityMarksMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * V1 APIs for Security Center service.
   * </pre>
   */
  public static final class SecurityCenterFutureStub
      extends io.grpc.stub.AbstractStub<SecurityCenterFutureStub> {
    private SecurityCenterFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SecurityCenterFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SecurityCenterFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SecurityCenterFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Source>
        createSource(com.google.cloud.securitycenter.v1.CreateSourceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSourceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a finding. The corresponding source must exist for finding creation
     * to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Finding>
        createFinding(com.google.cloud.securitycenter.v1.CreateFindingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateFindingMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the settings for an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.OrganizationSettings>
        getOrganizationSettings(
            com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetOrganizationSettingsMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Source>
        getSource(com.google.cloud.securitycenter.v1.GetSourceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetSourceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization's assets and  groups them by their specified
     * properties.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.GroupAssetsResponse>
        groupAssets(com.google.cloud.securitycenter.v1.GroupAssetsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGroupAssetsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Filters an organization or source's findings and  groups them by their
     * specified properties.
     * To group across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.GroupFindingsResponse>
        groupFindings(com.google.cloud.securitycenter.v1.GroupFindingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGroupFindingsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization's assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.ListAssetsResponse>
        listAssets(com.google.cloud.securitycenter.v1.ListAssetsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAssetsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists an organization or source's findings.
     * To list across all sources provide a `-` as the source id.
     * Example: /v1/organizations/123/sources/-/findings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.ListFindingsResponse>
        listFindings(com.google.cloud.securitycenter.v1.ListFindingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListFindingsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all sources belonging to an organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.ListSourcesResponse>
        listSources(com.google.cloud.securitycenter.v1.ListSourcesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSourcesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs asset discovery. The discovery is tracked with a long-running
     * operation.
     * This API can only be called with limited frequency for an organization. If
     * it is called too frequently the caller will receive a TOO_MANY_REQUESTS
     * error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runAssetDiscovery(com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunAssetDiscoveryMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the state of a finding.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Finding>
        setFindingState(com.google.cloud.securitycenter.v1.SetFindingStateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetFindingStateMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the access control policy on the specified Source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates or updates a finding. The corresponding source must exist for a
     * finding creation to succeed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Finding>
        updateFinding(com.google.cloud.securitycenter.v1.UpdateFindingRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateFindingMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an organization's settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.OrganizationSettings>
        updateOrganizationSettings(
            com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateOrganizationSettingsMethodHelper(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a source.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.Source>
        updateSource(com.google.cloud.securitycenter.v1.UpdateSourceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSourceMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates security marks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.securitycenter.v1.SecurityMarks>
        updateSecurityMarks(com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSecurityMarksMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SOURCE = 0;
  private static final int METHODID_CREATE_FINDING = 1;
  private static final int METHODID_GET_IAM_POLICY = 2;
  private static final int METHODID_GET_ORGANIZATION_SETTINGS = 3;
  private static final int METHODID_GET_SOURCE = 4;
  private static final int METHODID_GROUP_ASSETS = 5;
  private static final int METHODID_GROUP_FINDINGS = 6;
  private static final int METHODID_LIST_ASSETS = 7;
  private static final int METHODID_LIST_FINDINGS = 8;
  private static final int METHODID_LIST_SOURCES = 9;
  private static final int METHODID_RUN_ASSET_DISCOVERY = 10;
  private static final int METHODID_SET_FINDING_STATE = 11;
  private static final int METHODID_SET_IAM_POLICY = 12;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 13;
  private static final int METHODID_UPDATE_FINDING = 14;
  private static final int METHODID_UPDATE_ORGANIZATION_SETTINGS = 15;
  private static final int METHODID_UPDATE_SOURCE = 16;
  private static final int METHODID_UPDATE_SECURITY_MARKS = 17;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_CREATE_SOURCE:
          serviceImpl.createSource(
              (com.google.cloud.securitycenter.v1.CreateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>)
                  responseObserver);
          break;
        case METHODID_CREATE_FINDING:
          serviceImpl.createFinding(
              (com.google.cloud.securitycenter.v1.CreateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>)
                  responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_ORGANIZATION_SETTINGS:
          serviceImpl.getOrganizationSettings(
              (com.google.cloud.securitycenter.v1.GetOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>)
                  responseObserver);
          break;
        case METHODID_GET_SOURCE:
          serviceImpl.getSource(
              (com.google.cloud.securitycenter.v1.GetSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>)
                  responseObserver);
          break;
        case METHODID_GROUP_ASSETS:
          serviceImpl.groupAssets(
              (com.google.cloud.securitycenter.v1.GroupAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.GroupAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_GROUP_FINDINGS:
          serviceImpl.groupFindings(
              (com.google.cloud.securitycenter.v1.GroupFindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.securitycenter.v1.GroupFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ASSETS:
          serviceImpl.listAssets(
              (com.google.cloud.securitycenter.v1.ListAssetsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListAssetsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS:
          serviceImpl.listFindings(
              (com.google.cloud.securitycenter.v1.ListFindingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListFindingsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SOURCES:
          serviceImpl.listSources(
              (com.google.cloud.securitycenter.v1.ListSourcesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.ListSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_RUN_ASSET_DISCOVERY:
          serviceImpl.runAssetDiscovery(
              (com.google.cloud.securitycenter.v1.RunAssetDiscoveryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_FINDING_STATE:
          serviceImpl.setFindingState(
              (com.google.cloud.securitycenter.v1.SetFindingStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>)
                  responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FINDING:
          serviceImpl.updateFinding(
              (com.google.cloud.securitycenter.v1.UpdateFindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Finding>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ORGANIZATION_SETTINGS:
          serviceImpl.updateOrganizationSettings(
              (com.google.cloud.securitycenter.v1.UpdateOrganizationSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.OrganizationSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SOURCE:
          serviceImpl.updateSource(
              (com.google.cloud.securitycenter.v1.UpdateSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.Source>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SECURITY_MARKS:
          serviceImpl.updateSecurityMarks(
              (com.google.cloud.securitycenter.v1.UpdateSecurityMarksRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.securitycenter.v1.SecurityMarks>)
                  responseObserver);
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

  private abstract static class SecurityCenterBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SecurityCenterFileDescriptorSupplier())
                      .addMethod(getCreateSourceMethodHelper())
                      .addMethod(getCreateFindingMethodHelper())
                      .addMethod(getGetIamPolicyMethodHelper())
                      .addMethod(getGetOrganizationSettingsMethodHelper())
                      .addMethod(getGetSourceMethodHelper())
                      .addMethod(getGroupAssetsMethodHelper())
                      .addMethod(getGroupFindingsMethodHelper())
                      .addMethod(getListAssetsMethodHelper())
                      .addMethod(getListFindingsMethodHelper())
                      .addMethod(getListSourcesMethodHelper())
                      .addMethod(getRunAssetDiscoveryMethodHelper())
                      .addMethod(getSetFindingStateMethodHelper())
                      .addMethod(getSetIamPolicyMethodHelper())
                      .addMethod(getTestIamPermissionsMethodHelper())
                      .addMethod(getUpdateFindingMethodHelper())
                      .addMethod(getUpdateOrganizationSettingsMethodHelper())
                      .addMethod(getUpdateSourceMethodHelper())
                      .addMethod(getUpdateSecurityMarksMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
