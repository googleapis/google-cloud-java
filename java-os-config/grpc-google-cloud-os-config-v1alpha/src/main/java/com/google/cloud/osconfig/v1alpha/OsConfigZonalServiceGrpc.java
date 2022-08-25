/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.osconfig.v1alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Zonal OS Config API
 * The OS Config service is the server-side component that allows users to
 * manage package installations and patch jobs for Compute Engine VM instances.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/osconfig/v1alpha/osconfig_zonal_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OsConfigZonalServiceGrpc {

  private OsConfigZonalServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.osconfig.v1alpha.OsConfigZonalService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getCreateOSPolicyAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOSPolicyAssignment",
      requestType = com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getCreateOSPolicyAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest,
            com.google.longrunning.Operation>
        getCreateOSPolicyAssignmentMethod;
    if ((getCreateOSPolicyAssignmentMethod =
            OsConfigZonalServiceGrpc.getCreateOSPolicyAssignmentMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getCreateOSPolicyAssignmentMethod =
                OsConfigZonalServiceGrpc.getCreateOSPolicyAssignmentMethod)
            == null) {
          OsConfigZonalServiceGrpc.getCreateOSPolicyAssignmentMethod =
              getCreateOSPolicyAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOSPolicyAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "CreateOSPolicyAssignment"))
                      .build();
        }
      }
    }
    return getCreateOSPolicyAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getUpdateOSPolicyAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOSPolicyAssignment",
      requestType = com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getUpdateOSPolicyAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest,
            com.google.longrunning.Operation>
        getUpdateOSPolicyAssignmentMethod;
    if ((getUpdateOSPolicyAssignmentMethod =
            OsConfigZonalServiceGrpc.getUpdateOSPolicyAssignmentMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getUpdateOSPolicyAssignmentMethod =
                OsConfigZonalServiceGrpc.getUpdateOSPolicyAssignmentMethod)
            == null) {
          OsConfigZonalServiceGrpc.getUpdateOSPolicyAssignmentMethod =
              getUpdateOSPolicyAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateOSPolicyAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "UpdateOSPolicyAssignment"))
                      .build();
        }
      }
    }
    return getUpdateOSPolicyAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest,
          com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
      getGetOSPolicyAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOSPolicyAssignment",
      requestType = com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.OSPolicyAssignment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest,
          com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
      getGetOSPolicyAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest,
            com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
        getGetOSPolicyAssignmentMethod;
    if ((getGetOSPolicyAssignmentMethod = OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetOSPolicyAssignmentMethod =
                OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentMethod)
            == null) {
          OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentMethod =
              getGetOSPolicyAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest,
                          com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOSPolicyAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.OSPolicyAssignment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier("GetOSPolicyAssignment"))
                      .build();
        }
      }
    }
    return getGetOSPolicyAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
      getListOSPolicyAssignmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOSPolicyAssignments",
      requestType = com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
      getListOSPolicyAssignmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest,
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
        getListOSPolicyAssignmentsMethod;
    if ((getListOSPolicyAssignmentsMethod =
            OsConfigZonalServiceGrpc.getListOSPolicyAssignmentsMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListOSPolicyAssignmentsMethod =
                OsConfigZonalServiceGrpc.getListOSPolicyAssignmentsMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListOSPolicyAssignmentsMethod =
              getListOSPolicyAssignmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest,
                          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOSPolicyAssignments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListOSPolicyAssignments"))
                      .build();
        }
      }
    }
    return getListOSPolicyAssignmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
      getListOSPolicyAssignmentRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOSPolicyAssignmentRevisions",
      requestType = com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest.class,
      responseType =
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
      getListOSPolicyAssignmentRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest,
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
        getListOSPolicyAssignmentRevisionsMethod;
    if ((getListOSPolicyAssignmentRevisionsMethod =
            OsConfigZonalServiceGrpc.getListOSPolicyAssignmentRevisionsMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListOSPolicyAssignmentRevisionsMethod =
                OsConfigZonalServiceGrpc.getListOSPolicyAssignmentRevisionsMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListOSPolicyAssignmentRevisionsMethod =
              getListOSPolicyAssignmentRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest,
                          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOSPolicyAssignmentRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .ListOSPolicyAssignmentRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .ListOSPolicyAssignmentRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListOSPolicyAssignmentRevisions"))
                      .build();
        }
      }
    }
    return getListOSPolicyAssignmentRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getDeleteOSPolicyAssignmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteOSPolicyAssignment",
      requestType = com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest,
          com.google.longrunning.Operation>
      getDeleteOSPolicyAssignmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest,
            com.google.longrunning.Operation>
        getDeleteOSPolicyAssignmentMethod;
    if ((getDeleteOSPolicyAssignmentMethod =
            OsConfigZonalServiceGrpc.getDeleteOSPolicyAssignmentMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getDeleteOSPolicyAssignmentMethod =
                OsConfigZonalServiceGrpc.getDeleteOSPolicyAssignmentMethod)
            == null) {
          OsConfigZonalServiceGrpc.getDeleteOSPolicyAssignmentMethod =
              getDeleteOSPolicyAssignmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteOSPolicyAssignment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "DeleteOSPolicyAssignment"))
                      .build();
        }
      }
    }
    return getDeleteOSPolicyAssignmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest,
          com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
      getGetInstanceOSPoliciesComplianceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstanceOSPoliciesCompliance",
      requestType = com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest,
          com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
      getGetInstanceOSPoliciesComplianceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest,
            com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
        getGetInstanceOSPoliciesComplianceMethod;
    if ((getGetInstanceOSPoliciesComplianceMethod =
            OsConfigZonalServiceGrpc.getGetInstanceOSPoliciesComplianceMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetInstanceOSPoliciesComplianceMethod =
                OsConfigZonalServiceGrpc.getGetInstanceOSPoliciesComplianceMethod)
            == null) {
          OsConfigZonalServiceGrpc.getGetInstanceOSPoliciesComplianceMethod =
              getGetInstanceOSPoliciesComplianceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest,
                          com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetInstanceOSPoliciesCompliance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .GetInstanceOSPoliciesComplianceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "GetInstanceOSPoliciesCompliance"))
                      .build();
        }
      }
    }
    return getGetInstanceOSPoliciesComplianceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest,
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
      getListInstanceOSPoliciesCompliancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstanceOSPoliciesCompliances",
      requestType =
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest.class,
      responseType =
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest,
          com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
      getListInstanceOSPoliciesCompliancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest,
            com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
        getListInstanceOSPoliciesCompliancesMethod;
    if ((getListInstanceOSPoliciesCompliancesMethod =
            OsConfigZonalServiceGrpc.getListInstanceOSPoliciesCompliancesMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListInstanceOSPoliciesCompliancesMethod =
                OsConfigZonalServiceGrpc.getListInstanceOSPoliciesCompliancesMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListInstanceOSPoliciesCompliancesMethod =
              getListInstanceOSPoliciesCompliancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest,
                          com.google.cloud.osconfig.v1alpha
                              .ListInstanceOSPoliciesCompliancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListInstanceOSPoliciesCompliances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .ListInstanceOSPoliciesCompliancesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .ListInstanceOSPoliciesCompliancesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListInstanceOSPoliciesCompliances"))
                      .build();
        }
      }
    }
    return getListInstanceOSPoliciesCompliancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest,
          com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
      getGetOSPolicyAssignmentReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOSPolicyAssignmentReport",
      requestType = com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest,
          com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
      getGetOSPolicyAssignmentReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest,
            com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
        getGetOSPolicyAssignmentReportMethod;
    if ((getGetOSPolicyAssignmentReportMethod =
            OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentReportMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetOSPolicyAssignmentReportMethod =
                OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentReportMethod)
            == null) {
          OsConfigZonalServiceGrpc.getGetOSPolicyAssignmentReportMethod =
              getGetOSPolicyAssignmentReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest,
                          com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOSPolicyAssignmentReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "GetOSPolicyAssignmentReport"))
                      .build();
        }
      }
    }
    return getGetOSPolicyAssignmentReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
      getListOSPolicyAssignmentReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOSPolicyAssignmentReports",
      requestType = com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest,
          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
      getListOSPolicyAssignmentReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest,
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
        getListOSPolicyAssignmentReportsMethod;
    if ((getListOSPolicyAssignmentReportsMethod =
            OsConfigZonalServiceGrpc.getListOSPolicyAssignmentReportsMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListOSPolicyAssignmentReportsMethod =
                OsConfigZonalServiceGrpc.getListOSPolicyAssignmentReportsMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListOSPolicyAssignmentReportsMethod =
              getListOSPolicyAssignmentReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest,
                          com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOSPolicyAssignmentReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha
                                  .ListOSPolicyAssignmentReportsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListOSPolicyAssignmentReports"))
                      .build();
        }
      }
    }
    return getListOSPolicyAssignmentReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetInventoryRequest,
          com.google.cloud.osconfig.v1alpha.Inventory>
      getGetInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInventory",
      requestType = com.google.cloud.osconfig.v1alpha.GetInventoryRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.Inventory.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetInventoryRequest,
          com.google.cloud.osconfig.v1alpha.Inventory>
      getGetInventoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.GetInventoryRequest,
            com.google.cloud.osconfig.v1alpha.Inventory>
        getGetInventoryMethod;
    if ((getGetInventoryMethod = OsConfigZonalServiceGrpc.getGetInventoryMethod) == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetInventoryMethod = OsConfigZonalServiceGrpc.getGetInventoryMethod) == null) {
          OsConfigZonalServiceGrpc.getGetInventoryMethod =
              getGetInventoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.GetInventoryRequest,
                          com.google.cloud.osconfig.v1alpha.Inventory>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInventory"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.GetInventoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.Inventory.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier("GetInventory"))
                      .build();
        }
      }
    }
    return getGetInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListInventoriesRequest,
          com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
      getListInventoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInventories",
      requestType = com.google.cloud.osconfig.v1alpha.ListInventoriesRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.ListInventoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListInventoriesRequest,
          com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
      getListInventoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListInventoriesRequest,
            com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
        getListInventoriesMethod;
    if ((getListInventoriesMethod = OsConfigZonalServiceGrpc.getListInventoriesMethod) == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListInventoriesMethod = OsConfigZonalServiceGrpc.getListInventoriesMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListInventoriesMethod =
              getListInventoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListInventoriesRequest,
                          com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInventories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListInventoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListInventoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier("ListInventories"))
                      .build();
        }
      }
    }
    return getListInventoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest,
          com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
      getGetVulnerabilityReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVulnerabilityReport",
      requestType = com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.VulnerabilityReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest,
          com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
      getGetVulnerabilityReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest,
            com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
        getGetVulnerabilityReportMethod;
    if ((getGetVulnerabilityReportMethod = OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getGetVulnerabilityReportMethod =
                OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod)
            == null) {
          OsConfigZonalServiceGrpc.getGetVulnerabilityReportMethod =
              getGetVulnerabilityReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest,
                          com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetVulnerabilityReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.VulnerabilityReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "GetVulnerabilityReport"))
                      .build();
        }
      }
    }
    return getGetVulnerabilityReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest,
          com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
      getListVulnerabilityReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVulnerabilityReports",
      requestType = com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest.class,
      responseType = com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest,
          com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
      getListVulnerabilityReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest,
            com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
        getListVulnerabilityReportsMethod;
    if ((getListVulnerabilityReportsMethod =
            OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod)
        == null) {
      synchronized (OsConfigZonalServiceGrpc.class) {
        if ((getListVulnerabilityReportsMethod =
                OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod)
            == null) {
          OsConfigZonalServiceGrpc.getListVulnerabilityReportsMethod =
              getListVulnerabilityReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest,
                          com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVulnerabilityReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OsConfigZonalServiceMethodDescriptorSupplier(
                              "ListVulnerabilityReports"))
                      .build();
        }
      }
    }
    return getListVulnerabilityReportsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OsConfigZonalServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceStub>() {
          @java.lang.Override
          public OsConfigZonalServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OsConfigZonalServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceBlockingStub>() {
          @java.lang.Override
          public OsConfigZonalServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceBlockingStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OsConfigZonalServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OsConfigZonalServiceFutureStub>() {
          @java.lang.Override
          public OsConfigZonalServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OsConfigZonalServiceFutureStub(channel, callOptions);
          }
        };
    return OsConfigZonalServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public abstract static class OsConfigZonalServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create an OS policy assignment.
     * This method also creates the first revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void createOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOSPolicyAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an existing OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void updateOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateOSPolicyAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an existing OS policy assignment.
     * This method always returns the latest revision. In order to retrieve a
     * previous revision of the assignment, also provide the revision ID in the
     * `name` parameter.
     * </pre>
     */
    public void getOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOSPolicyAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignments under the parent resource.
     * For each OS policy assignment, the latest revision is returned.
     * </pre>
     */
    public void listOSPolicyAssignments(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOSPolicyAssignmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignment revisions for a given OS policy assignment.
     * </pre>
     */
    public void listOSPolicyAssignmentRevisions(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOSPolicyAssignmentRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * If the LRO completes and is not cancelled, all revisions associated with
     * the OS policy assignment are deleted.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void deleteOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteOSPolicyAssignmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get OS policies compliance data for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    @java.lang.Deprecated
    public void getInstanceOSPoliciesCompliance(
        com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceOSPoliciesComplianceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List OS policies compliance data for all Compute Engine VM instances in the
     * specified zone.
     * </pre>
     */
    @java.lang.Deprecated
    public void listInstanceOSPoliciesCompliances(
        com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstanceOSPoliciesCompliancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the OS policy asssignment report for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    public void getOSPolicyAssignmentReport(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOSPolicyAssignmentReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List OS policy asssignment reports for all Compute Engine VM instances in
     * the specified zone.
     * </pre>
     */
    public void listOSPolicyAssignmentReports(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOSPolicyAssignmentReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public void getInventory(
        com.google.cloud.osconfig.v1alpha.GetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.Inventory> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInventoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public void listInventories(
        com.google.cloud.osconfig.v1alpha.ListInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInventoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public void getVulnerabilityReport(
        com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVulnerabilityReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public void listVulnerabilityReports(
        com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVulnerabilityReportsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateOSPolicyAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_OSPOLICY_ASSIGNMENT)))
          .addMethod(
              getUpdateOSPolicyAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_OSPOLICY_ASSIGNMENT)))
          .addMethod(
              getGetOSPolicyAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest,
                      com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>(
                      this, METHODID_GET_OSPOLICY_ASSIGNMENT)))
          .addMethod(
              getListOSPolicyAssignmentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest,
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>(
                      this, METHODID_LIST_OSPOLICY_ASSIGNMENTS)))
          .addMethod(
              getListOSPolicyAssignmentRevisionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest,
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>(
                      this, METHODID_LIST_OSPOLICY_ASSIGNMENT_REVISIONS)))
          .addMethod(
              getDeleteOSPolicyAssignmentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_OSPOLICY_ASSIGNMENT)))
          .addMethod(
              getGetInstanceOSPoliciesComplianceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest,
                      com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>(
                      this, METHODID_GET_INSTANCE_OSPOLICIES_COMPLIANCE)))
          .addMethod(
              getListInstanceOSPoliciesCompliancesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest,
                      com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>(
                      this, METHODID_LIST_INSTANCE_OSPOLICIES_COMPLIANCES)))
          .addMethod(
              getGetOSPolicyAssignmentReportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest,
                      com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>(
                      this, METHODID_GET_OSPOLICY_ASSIGNMENT_REPORT)))
          .addMethod(
              getListOSPolicyAssignmentReportsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest,
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>(
                      this, METHODID_LIST_OSPOLICY_ASSIGNMENT_REPORTS)))
          .addMethod(
              getGetInventoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.GetInventoryRequest,
                      com.google.cloud.osconfig.v1alpha.Inventory>(this, METHODID_GET_INVENTORY)))
          .addMethod(
              getListInventoriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListInventoriesRequest,
                      com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>(
                      this, METHODID_LIST_INVENTORIES)))
          .addMethod(
              getGetVulnerabilityReportMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest,
                      com.google.cloud.osconfig.v1alpha.VulnerabilityReport>(
                      this, METHODID_GET_VULNERABILITY_REPORT)))
          .addMethod(
              getListVulnerabilityReportsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest,
                      com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>(
                      this, METHODID_LIST_VULNERABILITY_REPORTS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OsConfigZonalServiceStub> {
    private OsConfigZonalServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an OS policy assignment.
     * This method also creates the first revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void createOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOSPolicyAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an existing OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void updateOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOSPolicyAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an existing OS policy assignment.
     * This method always returns the latest revision. In order to retrieve a
     * previous revision of the assignment, also provide the revision ID in the
     * `name` parameter.
     * </pre>
     */
    public void getOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOSPolicyAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignments under the parent resource.
     * For each OS policy assignment, the latest revision is returned.
     * </pre>
     */
    public void listOSPolicyAssignments(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignment revisions for a given OS policy assignment.
     * </pre>
     */
    public void listOSPolicyAssignmentRevisions(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * If the LRO completes and is not cancelled, all revisions associated with
     * the OS policy assignment are deleted.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public void deleteOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteOSPolicyAssignmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get OS policies compliance data for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    @java.lang.Deprecated
    public void getInstanceOSPoliciesCompliance(
        com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceOSPoliciesComplianceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List OS policies compliance data for all Compute Engine VM instances in the
     * specified zone.
     * </pre>
     */
    @java.lang.Deprecated
    public void listInstanceOSPoliciesCompliances(
        com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstanceOSPoliciesCompliancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the OS policy asssignment report for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    public void getOSPolicyAssignmentReport(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOSPolicyAssignmentReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List OS policy asssignment reports for all Compute Engine VM instances in
     * the specified zone.
     * </pre>
     */
    public void listOSPolicyAssignmentReports(
        com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public void getInventory(
        com.google.cloud.osconfig.v1alpha.GetInventoryRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.Inventory> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInventoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public void listInventories(
        com.google.cloud.osconfig.v1alpha.ListInventoriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInventoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public void getVulnerabilityReport(
        com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVulnerabilityReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public void listVulnerabilityReports(
        com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVulnerabilityReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OsConfigZonalServiceBlockingStub> {
    private OsConfigZonalServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an OS policy assignment.
     * This method also creates the first revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.longrunning.Operation createOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOSPolicyAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an existing OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.longrunning.Operation updateOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOSPolicyAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an existing OS policy assignment.
     * This method always returns the latest revision. In order to retrieve a
     * previous revision of the assignment, also provide the revision ID in the
     * `name` parameter.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.OSPolicyAssignment getOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOSPolicyAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignments under the parent resource.
     * For each OS policy assignment, the latest revision is returned.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse
        listOSPolicyAssignments(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOSPolicyAssignmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignment revisions for a given OS policy assignment.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse
        listOSPolicyAssignmentRevisions(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOSPolicyAssignmentRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * If the LRO completes and is not cancelled, all revisions associated with
     * the OS policy assignment are deleted.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.longrunning.Operation deleteOSPolicyAssignment(
        com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteOSPolicyAssignmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get OS policies compliance data for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance
        getInstanceOSPoliciesCompliance(
            com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceOSPoliciesComplianceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List OS policies compliance data for all Compute Engine VM instances in the
     * specified zone.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse
        listInstanceOSPoliciesCompliances(
            com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstanceOSPoliciesCompliancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the OS policy asssignment report for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport getOSPolicyAssignmentReport(
        com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOSPolicyAssignmentReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List OS policy asssignment reports for all Compute Engine VM instances in
     * the specified zone.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse
        listOSPolicyAssignmentReports(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOSPolicyAssignmentReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.Inventory getInventory(
        com.google.cloud.osconfig.v1alpha.GetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInventoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.ListInventoriesResponse listInventories(
        com.google.cloud.osconfig.v1alpha.ListInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInventoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.VulnerabilityReport getVulnerabilityReport(
        com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVulnerabilityReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse
        listVulnerabilityReports(
            com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVulnerabilityReportsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Zonal OS Config API
   * The OS Config service is the server-side component that allows users to
   * manage package installations and patch jobs for Compute Engine VM instances.
   * </pre>
   */
  public static final class OsConfigZonalServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OsConfigZonalServiceFutureStub> {
    private OsConfigZonalServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OsConfigZonalServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OsConfigZonalServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an OS policy assignment.
     * This method also creates the first revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOSPolicyAssignment(
            com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOSPolicyAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an existing OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateOSPolicyAssignment(
            com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOSPolicyAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve an existing OS policy assignment.
     * This method always returns the latest revision. In order to retrieve a
     * previous revision of the assignment, also provide the revision ID in the
     * `name` parameter.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>
        getOSPolicyAssignment(
            com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOSPolicyAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignments under the parent resource.
     * For each OS policy assignment, the latest revision is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>
        listOSPolicyAssignments(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the OS policy assignment revisions for a given OS policy assignment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>
        listOSPolicyAssignmentRevisions(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentRevisionsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Delete the OS policy assignment.
     * This method creates a new revision of the OS policy assignment.
     * This method returns a long running operation (LRO) that contains the
     * rollout details. The rollout can be cancelled by cancelling the LRO.
     * If the LRO completes and is not cancelled, all revisions associated with
     * the OS policy assignment are deleted.
     * For more information, see [Method:
     * projects.locations.osPolicyAssignments.operations.cancel](https://cloud.google.com/compute/docs/osconfig/rest/v1alpha/projects.locations.osPolicyAssignments.operations/cancel).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteOSPolicyAssignment(
            com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteOSPolicyAssignmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get OS policies compliance data for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>
        getInstanceOSPoliciesCompliance(
            com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceOSPoliciesComplianceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * List OS policies compliance data for all Compute Engine VM instances in the
     * specified zone.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>
        listInstanceOSPoliciesCompliances(
            com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstanceOSPoliciesCompliancesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Get the OS policy asssignment report for the specified Compute Engine VM
     * instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>
        getOSPolicyAssignmentReport(
            com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOSPolicyAssignmentReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List OS policy asssignment reports for all Compute Engine VM instances in
     * the specified zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>
        listOSPolicyAssignmentReports(
            com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOSPolicyAssignmentReportsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Get inventory data for the specified VM instance. If the VM has no
     * associated inventory, the message `NOT_FOUND` is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.Inventory>
        getInventory(com.google.cloud.osconfig.v1alpha.GetInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInventoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List inventory data for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>
        listInventories(com.google.cloud.osconfig.v1alpha.ListInventoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInventoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the vulnerability report for the specified VM instance. Only VMs with
     * inventory data have vulnerability reports associated with them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.VulnerabilityReport>
        getVulnerabilityReport(
            com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVulnerabilityReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List vulnerability reports for all VM instances in the specified zone.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>
        listVulnerabilityReports(
            com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVulnerabilityReportsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_OSPOLICY_ASSIGNMENT = 0;
  private static final int METHODID_UPDATE_OSPOLICY_ASSIGNMENT = 1;
  private static final int METHODID_GET_OSPOLICY_ASSIGNMENT = 2;
  private static final int METHODID_LIST_OSPOLICY_ASSIGNMENTS = 3;
  private static final int METHODID_LIST_OSPOLICY_ASSIGNMENT_REVISIONS = 4;
  private static final int METHODID_DELETE_OSPOLICY_ASSIGNMENT = 5;
  private static final int METHODID_GET_INSTANCE_OSPOLICIES_COMPLIANCE = 6;
  private static final int METHODID_LIST_INSTANCE_OSPOLICIES_COMPLIANCES = 7;
  private static final int METHODID_GET_OSPOLICY_ASSIGNMENT_REPORT = 8;
  private static final int METHODID_LIST_OSPOLICY_ASSIGNMENT_REPORTS = 9;
  private static final int METHODID_GET_INVENTORY = 10;
  private static final int METHODID_LIST_INVENTORIES = 11;
  private static final int METHODID_GET_VULNERABILITY_REPORT = 12;
  private static final int METHODID_LIST_VULNERABILITY_REPORTS = 13;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OsConfigZonalServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OsConfigZonalServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_OSPOLICY_ASSIGNMENT:
          serviceImpl.createOSPolicyAssignment(
              (com.google.cloud.osconfig.v1alpha.CreateOSPolicyAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_OSPOLICY_ASSIGNMENT:
          serviceImpl.updateOSPolicyAssignment(
              (com.google.cloud.osconfig.v1alpha.UpdateOSPolicyAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_OSPOLICY_ASSIGNMENT:
          serviceImpl.getOSPolicyAssignment(
              (com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.OSPolicyAssignment>)
                  responseObserver);
          break;
        case METHODID_LIST_OSPOLICY_ASSIGNMENTS:
          serviceImpl.listOSPolicyAssignments(
              (com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_OSPOLICY_ASSIGNMENT_REVISIONS:
          serviceImpl.listOSPolicyAssignmentRevisions(
              (com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_OSPOLICY_ASSIGNMENT:
          serviceImpl.deleteOSPolicyAssignment(
              (com.google.cloud.osconfig.v1alpha.DeleteOSPolicyAssignmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_INSTANCE_OSPOLICIES_COMPLIANCE:
          serviceImpl.getInstanceOSPoliciesCompliance(
              (com.google.cloud.osconfig.v1alpha.GetInstanceOSPoliciesComplianceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.InstanceOSPoliciesCompliance>)
                  responseObserver);
          break;
        case METHODID_LIST_INSTANCE_OSPOLICIES_COMPLIANCES:
          serviceImpl.listInstanceOSPoliciesCompliances(
              (com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListInstanceOSPoliciesCompliancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_OSPOLICY_ASSIGNMENT_REPORT:
          serviceImpl.getOSPolicyAssignmentReport(
              (com.google.cloud.osconfig.v1alpha.GetOSPolicyAssignmentReportRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.OSPolicyAssignmentReport>)
                  responseObserver);
          break;
        case METHODID_LIST_OSPOLICY_ASSIGNMENT_REPORTS:
          serviceImpl.listOSPolicyAssignmentReports(
              (com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListOSPolicyAssignmentReportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INVENTORY:
          serviceImpl.getInventory(
              (com.google.cloud.osconfig.v1alpha.GetInventoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.Inventory>)
                  responseObserver);
          break;
        case METHODID_LIST_INVENTORIES:
          serviceImpl.listInventories(
              (com.google.cloud.osconfig.v1alpha.ListInventoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListInventoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VULNERABILITY_REPORT:
          serviceImpl.getVulnerabilityReport(
              (com.google.cloud.osconfig.v1alpha.GetVulnerabilityReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.osconfig.v1alpha.VulnerabilityReport>)
                  responseObserver);
          break;
        case METHODID_LIST_VULNERABILITY_REPORTS:
          serviceImpl.listVulnerabilityReports(
              (com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.osconfig.v1alpha.ListVulnerabilityReportsResponse>)
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

  private abstract static class OsConfigZonalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OsConfigZonalServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.osconfig.v1alpha.OsConfigZonalServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OsConfigZonalService");
    }
  }

  private static final class OsConfigZonalServiceFileDescriptorSupplier
      extends OsConfigZonalServiceBaseDescriptorSupplier {
    OsConfigZonalServiceFileDescriptorSupplier() {}
  }

  private static final class OsConfigZonalServiceMethodDescriptorSupplier
      extends OsConfigZonalServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OsConfigZonalServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OsConfigZonalServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new OsConfigZonalServiceFileDescriptorSupplier())
                      .addMethod(getCreateOSPolicyAssignmentMethod())
                      .addMethod(getUpdateOSPolicyAssignmentMethod())
                      .addMethod(getGetOSPolicyAssignmentMethod())
                      .addMethod(getListOSPolicyAssignmentsMethod())
                      .addMethod(getListOSPolicyAssignmentRevisionsMethod())
                      .addMethod(getDeleteOSPolicyAssignmentMethod())
                      .addMethod(getGetInstanceOSPoliciesComplianceMethod())
                      .addMethod(getListInstanceOSPoliciesCompliancesMethod())
                      .addMethod(getGetOSPolicyAssignmentReportMethod())
                      .addMethod(getListOSPolicyAssignmentReportsMethod())
                      .addMethod(getGetInventoryMethod())
                      .addMethod(getListInventoriesMethod())
                      .addMethod(getGetVulnerabilityReportMethod())
                      .addMethod(getListVulnerabilityReportsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
