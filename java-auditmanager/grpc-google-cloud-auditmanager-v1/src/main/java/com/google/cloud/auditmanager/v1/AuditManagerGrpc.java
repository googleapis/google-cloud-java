/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.auditmanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AuditManagerGrpc {

  private AuditManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.auditmanager.v1.AuditManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.EnrollResourceRequest,
          com.google.cloud.auditmanager.v1.Enrollment>
      getEnrollResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnrollResource",
      requestType = com.google.cloud.auditmanager.v1.EnrollResourceRequest.class,
      responseType = com.google.cloud.auditmanager.v1.Enrollment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.EnrollResourceRequest,
          com.google.cloud.auditmanager.v1.Enrollment>
      getEnrollResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.EnrollResourceRequest,
            com.google.cloud.auditmanager.v1.Enrollment>
        getEnrollResourceMethod;
    if ((getEnrollResourceMethod = AuditManagerGrpc.getEnrollResourceMethod) == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getEnrollResourceMethod = AuditManagerGrpc.getEnrollResourceMethod) == null) {
          AuditManagerGrpc.getEnrollResourceMethod =
              getEnrollResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.EnrollResourceRequest,
                          com.google.cloud.auditmanager.v1.Enrollment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnrollResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.EnrollResourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.Enrollment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("EnrollResource"))
                      .build();
        }
      }
    }
    return getEnrollResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest,
          com.google.cloud.auditmanager.v1.AuditScopeReport>
      getGenerateAuditScopeReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAuditScopeReport",
      requestType = com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest.class,
      responseType = com.google.cloud.auditmanager.v1.AuditScopeReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest,
          com.google.cloud.auditmanager.v1.AuditScopeReport>
      getGenerateAuditScopeReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest,
            com.google.cloud.auditmanager.v1.AuditScopeReport>
        getGenerateAuditScopeReportMethod;
    if ((getGenerateAuditScopeReportMethod = AuditManagerGrpc.getGenerateAuditScopeReportMethod)
        == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getGenerateAuditScopeReportMethod = AuditManagerGrpc.getGenerateAuditScopeReportMethod)
            == null) {
          AuditManagerGrpc.getGenerateAuditScopeReportMethod =
              getGenerateAuditScopeReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest,
                          com.google.cloud.auditmanager.v1.AuditScopeReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAuditScopeReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.AuditScopeReport
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("GenerateAuditScopeReport"))
                      .build();
        }
      }
    }
    return getGenerateAuditScopeReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GenerateAuditReportRequest,
          com.google.longrunning.Operation>
      getGenerateAuditReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAuditReport",
      requestType = com.google.cloud.auditmanager.v1.GenerateAuditReportRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GenerateAuditReportRequest,
          com.google.longrunning.Operation>
      getGenerateAuditReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.GenerateAuditReportRequest,
            com.google.longrunning.Operation>
        getGenerateAuditReportMethod;
    if ((getGenerateAuditReportMethod = AuditManagerGrpc.getGenerateAuditReportMethod) == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getGenerateAuditReportMethod = AuditManagerGrpc.getGenerateAuditReportMethod)
            == null) {
          AuditManagerGrpc.getGenerateAuditReportMethod =
              getGenerateAuditReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.GenerateAuditReportRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAuditReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.GenerateAuditReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("GenerateAuditReport"))
                      .build();
        }
      }
    }
    return getGenerateAuditReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListAuditReportsRequest,
          com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
      getListAuditReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAuditReports",
      requestType = com.google.cloud.auditmanager.v1.ListAuditReportsRequest.class,
      responseType = com.google.cloud.auditmanager.v1.ListAuditReportsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListAuditReportsRequest,
          com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
      getListAuditReportsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.ListAuditReportsRequest,
            com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
        getListAuditReportsMethod;
    if ((getListAuditReportsMethod = AuditManagerGrpc.getListAuditReportsMethod) == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getListAuditReportsMethod = AuditManagerGrpc.getListAuditReportsMethod) == null) {
          AuditManagerGrpc.getListAuditReportsMethod =
              getListAuditReportsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.ListAuditReportsRequest,
                          com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAuditReports"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ListAuditReportsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ListAuditReportsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("ListAuditReports"))
                      .build();
        }
      }
    }
    return getListAuditReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GetAuditReportRequest,
          com.google.cloud.auditmanager.v1.AuditReport>
      getGetAuditReportMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAuditReport",
      requestType = com.google.cloud.auditmanager.v1.GetAuditReportRequest.class,
      responseType = com.google.cloud.auditmanager.v1.AuditReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GetAuditReportRequest,
          com.google.cloud.auditmanager.v1.AuditReport>
      getGetAuditReportMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.GetAuditReportRequest,
            com.google.cloud.auditmanager.v1.AuditReport>
        getGetAuditReportMethod;
    if ((getGetAuditReportMethod = AuditManagerGrpc.getGetAuditReportMethod) == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getGetAuditReportMethod = AuditManagerGrpc.getGetAuditReportMethod) == null) {
          AuditManagerGrpc.getGetAuditReportMethod =
              getGetAuditReportMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.GetAuditReportRequest,
                          com.google.cloud.auditmanager.v1.AuditReport>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAuditReport"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.GetAuditReportRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.AuditReport.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("GetAuditReport"))
                      .build();
        }
      }
    }
    return getGetAuditReportMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest,
          com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
      getGetResourceEnrollmentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResourceEnrollmentStatus",
      requestType = com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest.class,
      responseType = com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest,
          com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
      getGetResourceEnrollmentStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest,
            com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
        getGetResourceEnrollmentStatusMethod;
    if ((getGetResourceEnrollmentStatusMethod =
            AuditManagerGrpc.getGetResourceEnrollmentStatusMethod)
        == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getGetResourceEnrollmentStatusMethod =
                AuditManagerGrpc.getGetResourceEnrollmentStatusMethod)
            == null) {
          AuditManagerGrpc.getGetResourceEnrollmentStatusMethod =
              getGetResourceEnrollmentStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest,
                          com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetResourceEnrollmentStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier("GetResourceEnrollmentStatus"))
                      .build();
        }
      }
    }
    return getGetResourceEnrollmentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest,
          com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
      getListResourceEnrollmentStatusesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceEnrollmentStatuses",
      requestType = com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest.class,
      responseType = com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest,
          com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
      getListResourceEnrollmentStatusesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest,
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
        getListResourceEnrollmentStatusesMethod;
    if ((getListResourceEnrollmentStatusesMethod =
            AuditManagerGrpc.getListResourceEnrollmentStatusesMethod)
        == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getListResourceEnrollmentStatusesMethod =
                AuditManagerGrpc.getListResourceEnrollmentStatusesMethod)
            == null) {
          AuditManagerGrpc.getListResourceEnrollmentStatusesMethod =
              getListResourceEnrollmentStatusesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest,
                          com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceEnrollmentStatuses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1
                                  .ListResourceEnrollmentStatusesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AuditManagerMethodDescriptorSupplier(
                              "ListResourceEnrollmentStatuses"))
                      .build();
        }
      }
    }
    return getListResourceEnrollmentStatusesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListControlsRequest,
          com.google.cloud.auditmanager.v1.ListControlsResponse>
      getListControlsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListControls",
      requestType = com.google.cloud.auditmanager.v1.ListControlsRequest.class,
      responseType = com.google.cloud.auditmanager.v1.ListControlsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.auditmanager.v1.ListControlsRequest,
          com.google.cloud.auditmanager.v1.ListControlsResponse>
      getListControlsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.auditmanager.v1.ListControlsRequest,
            com.google.cloud.auditmanager.v1.ListControlsResponse>
        getListControlsMethod;
    if ((getListControlsMethod = AuditManagerGrpc.getListControlsMethod) == null) {
      synchronized (AuditManagerGrpc.class) {
        if ((getListControlsMethod = AuditManagerGrpc.getListControlsMethod) == null) {
          AuditManagerGrpc.getListControlsMethod =
              getListControlsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.auditmanager.v1.ListControlsRequest,
                          com.google.cloud.auditmanager.v1.ListControlsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListControls"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ListControlsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.auditmanager.v1.ListControlsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AuditManagerMethodDescriptorSupplier("ListControls"))
                      .build();
        }
      }
    }
    return getListControlsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AuditManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditManagerStub>() {
          @java.lang.Override
          public AuditManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditManagerStub(channel, callOptions);
          }
        };
    return AuditManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static AuditManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditManagerBlockingV2Stub>() {
          @java.lang.Override
          public AuditManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return AuditManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AuditManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditManagerBlockingStub>() {
          @java.lang.Override
          public AuditManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditManagerBlockingStub(channel, callOptions);
          }
        };
    return AuditManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AuditManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AuditManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AuditManagerFutureStub>() {
          @java.lang.Override
          public AuditManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AuditManagerFutureStub(channel, callOptions);
          }
        };
    return AuditManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Enrolls the customer resource(folder/project/organization) to the audit
     * manager service by creating the audit managers Service Agent in customers
     * workload and granting required permissions to the Service Agent. Please
     * note that if enrollment request is made on the already enrolled workload
     * then enrollment is executed overriding the existing set of destinations.
     * </pre>
     */
    default void enrollResource(
        com.google.cloud.auditmanager.v1.EnrollResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.Enrollment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnrollResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a demo report highlighting different responsibilities
     * (Google/Customer/ shared) required to be fulfilled for the customer's
     * workload to be compliant with the given standard.
     * </pre>
     */
    default void generateAuditScopeReport(
        com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditScopeReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAuditScopeReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register the Audit Report generation requests and returns the OperationId
     * using which the customer can track the report generation progress.
     * </pre>
     */
    default void generateAuditReport(
        com.google.cloud.auditmanager.v1.GenerateAuditReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAuditReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists audit reports in the selected parent scope
     * </pre>
     */
    default void listAuditReports(
        com.google.cloud.auditmanager.v1.ListAuditReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAuditReportsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the overall audit report
     * </pre>
     */
    default void getAuditReport(
        com.google.cloud.auditmanager.v1.GetAuditReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditReport>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAuditReportMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a resource along with its enrollment status.
     * </pre>
     */
    default void getResourceEnrollmentStatus(
        com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetResourceEnrollmentStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all resources under the parent along with their enrollment.
     * </pre>
     */
    default void listResourceEnrollmentStatuses(
        com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceEnrollmentStatusesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets controls needed to be implemented to be compliant to a standard.
     * </pre>
     */
    default void listControls(
        com.google.cloud.auditmanager.v1.ListControlsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ListControlsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListControlsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AuditManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class AuditManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AuditManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AuditManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditManagerStub
      extends io.grpc.stub.AbstractAsyncStub<AuditManagerStub> {
    private AuditManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Enrolls the customer resource(folder/project/organization) to the audit
     * manager service by creating the audit managers Service Agent in customers
     * workload and granting required permissions to the Service Agent. Please
     * note that if enrollment request is made on the already enrolled workload
     * then enrollment is executed overriding the existing set of destinations.
     * </pre>
     */
    public void enrollResource(
        com.google.cloud.auditmanager.v1.EnrollResourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.Enrollment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnrollResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates a demo report highlighting different responsibilities
     * (Google/Customer/ shared) required to be fulfilled for the customer's
     * workload to be compliant with the given standard.
     * </pre>
     */
    public void generateAuditScopeReport(
        com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditScopeReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAuditScopeReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Register the Audit Report generation requests and returns the OperationId
     * using which the customer can track the report generation progress.
     * </pre>
     */
    public void generateAuditReport(
        com.google.cloud.auditmanager.v1.GenerateAuditReportRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAuditReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists audit reports in the selected parent scope
     * </pre>
     */
    public void listAuditReports(
        com.google.cloud.auditmanager.v1.ListAuditReportsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAuditReportsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the overall audit report
     * </pre>
     */
    public void getAuditReport(
        com.google.cloud.auditmanager.v1.GetAuditReportRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditReport>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAuditReportMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a resource along with its enrollment status.
     * </pre>
     */
    public void getResourceEnrollmentStatus(
        com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceEnrollmentStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches all resources under the parent along with their enrollment.
     * </pre>
     */
    public void listResourceEnrollmentStatuses(
        com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceEnrollmentStatusesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets controls needed to be implemented to be compliant to a standard.
     * </pre>
     */
    public void listControls(
        com.google.cloud.auditmanager.v1.ListControlsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ListControlsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListControlsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AuditManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AuditManagerBlockingV2Stub> {
    private AuditManagerBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Enrolls the customer resource(folder/project/organization) to the audit
     * manager service by creating the audit managers Service Agent in customers
     * workload and granting required permissions to the Service Agent. Please
     * note that if enrollment request is made on the already enrolled workload
     * then enrollment is executed overriding the existing set of destinations.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.Enrollment enrollResource(
        com.google.cloud.auditmanager.v1.EnrollResourceRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEnrollResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a demo report highlighting different responsibilities
     * (Google/Customer/ shared) required to be fulfilled for the customer's
     * workload to be compliant with the given standard.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.AuditScopeReport generateAuditScopeReport(
        com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateAuditScopeReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register the Audit Report generation requests and returns the OperationId
     * using which the customer can track the report generation progress.
     * </pre>
     */
    public com.google.longrunning.Operation generateAuditReport(
        com.google.cloud.auditmanager.v1.GenerateAuditReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGenerateAuditReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists audit reports in the selected parent scope
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListAuditReportsResponse listAuditReports(
        com.google.cloud.auditmanager.v1.ListAuditReportsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAuditReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the overall audit report
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.AuditReport getAuditReport(
        com.google.cloud.auditmanager.v1.GetAuditReportRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetAuditReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a resource along with its enrollment status.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus getResourceEnrollmentStatus(
        com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetResourceEnrollmentStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all resources under the parent along with their enrollment.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse
        listResourceEnrollmentStatuses(
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListResourceEnrollmentStatusesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets controls needed to be implemented to be compliant to a standard.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListControlsResponse listControls(
        com.google.cloud.auditmanager.v1.ListControlsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListControlsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AuditManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AuditManagerBlockingStub> {
    private AuditManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Enrolls the customer resource(folder/project/organization) to the audit
     * manager service by creating the audit managers Service Agent in customers
     * workload and granting required permissions to the Service Agent. Please
     * note that if enrollment request is made on the already enrolled workload
     * then enrollment is executed overriding the existing set of destinations.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.Enrollment enrollResource(
        com.google.cloud.auditmanager.v1.EnrollResourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnrollResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a demo report highlighting different responsibilities
     * (Google/Customer/ shared) required to be fulfilled for the customer's
     * workload to be compliant with the given standard.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.AuditScopeReport generateAuditScopeReport(
        com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAuditScopeReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Register the Audit Report generation requests and returns the OperationId
     * using which the customer can track the report generation progress.
     * </pre>
     */
    public com.google.longrunning.Operation generateAuditReport(
        com.google.cloud.auditmanager.v1.GenerateAuditReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAuditReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists audit reports in the selected parent scope
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListAuditReportsResponse listAuditReports(
        com.google.cloud.auditmanager.v1.ListAuditReportsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAuditReportsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the overall audit report
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.AuditReport getAuditReport(
        com.google.cloud.auditmanager.v1.GetAuditReportRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAuditReportMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a resource along with its enrollment status.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus getResourceEnrollmentStatus(
        com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceEnrollmentStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all resources under the parent along with their enrollment.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse
        listResourceEnrollmentStatuses(
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceEnrollmentStatusesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets controls needed to be implemented to be compliant to a standard.
     * </pre>
     */
    public com.google.cloud.auditmanager.v1.ListControlsResponse listControls(
        com.google.cloud.auditmanager.v1.ListControlsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListControlsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AuditManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class AuditManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<AuditManagerFutureStub> {
    private AuditManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AuditManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AuditManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Enrolls the customer resource(folder/project/organization) to the audit
     * manager service by creating the audit managers Service Agent in customers
     * workload and granting required permissions to the Service Agent. Please
     * note that if enrollment request is made on the already enrolled workload
     * then enrollment is executed overriding the existing set of destinations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.Enrollment>
        enrollResource(com.google.cloud.auditmanager.v1.EnrollResourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnrollResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates a demo report highlighting different responsibilities
     * (Google/Customer/ shared) required to be fulfilled for the customer's
     * workload to be compliant with the given standard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.AuditScopeReport>
        generateAuditScopeReport(
            com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAuditScopeReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Register the Audit Report generation requests and returns the OperationId
     * using which the customer can track the report generation progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        generateAuditReport(com.google.cloud.auditmanager.v1.GenerateAuditReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAuditReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists audit reports in the selected parent scope
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.ListAuditReportsResponse>
        listAuditReports(com.google.cloud.auditmanager.v1.ListAuditReportsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAuditReportsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the overall audit report
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.AuditReport>
        getAuditReport(com.google.cloud.auditmanager.v1.GetAuditReportRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAuditReportMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a resource along with its enrollment status.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>
        getResourceEnrollmentStatus(
            com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceEnrollmentStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches all resources under the parent along with their enrollment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>
        listResourceEnrollmentStatuses(
            com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceEnrollmentStatusesMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets controls needed to be implemented to be compliant to a standard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.auditmanager.v1.ListControlsResponse>
        listControls(com.google.cloud.auditmanager.v1.ListControlsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListControlsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ENROLL_RESOURCE = 0;
  private static final int METHODID_GENERATE_AUDIT_SCOPE_REPORT = 1;
  private static final int METHODID_GENERATE_AUDIT_REPORT = 2;
  private static final int METHODID_LIST_AUDIT_REPORTS = 3;
  private static final int METHODID_GET_AUDIT_REPORT = 4;
  private static final int METHODID_GET_RESOURCE_ENROLLMENT_STATUS = 5;
  private static final int METHODID_LIST_RESOURCE_ENROLLMENT_STATUSES = 6;
  private static final int METHODID_LIST_CONTROLS = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_ENROLL_RESOURCE:
          serviceImpl.enrollResource(
              (com.google.cloud.auditmanager.v1.EnrollResourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.Enrollment>)
                  responseObserver);
          break;
        case METHODID_GENERATE_AUDIT_SCOPE_REPORT:
          serviceImpl.generateAuditScopeReport(
              (com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditScopeReport>)
                  responseObserver);
          break;
        case METHODID_GENERATE_AUDIT_REPORT:
          serviceImpl.generateAuditReport(
              (com.google.cloud.auditmanager.v1.GenerateAuditReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_AUDIT_REPORTS:
          serviceImpl.listAuditReports(
              (com.google.cloud.auditmanager.v1.ListAuditReportsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.auditmanager.v1.ListAuditReportsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_AUDIT_REPORT:
          serviceImpl.getAuditReport(
              (com.google.cloud.auditmanager.v1.GetAuditReportRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.AuditReport>)
                  responseObserver);
          break;
        case METHODID_GET_RESOURCE_ENROLLMENT_STATUS:
          serviceImpl.getResourceEnrollmentStatus(
              (com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>)
                  responseObserver);
          break;
        case METHODID_LIST_RESOURCE_ENROLLMENT_STATUSES:
          serviceImpl.listResourceEnrollmentStatuses(
              (com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_CONTROLS:
          serviceImpl.listControls(
              (com.google.cloud.auditmanager.v1.ListControlsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.auditmanager.v1.ListControlsResponse>)
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getEnrollResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.EnrollResourceRequest,
                    com.google.cloud.auditmanager.v1.Enrollment>(
                    service, METHODID_ENROLL_RESOURCE)))
        .addMethod(
            getGenerateAuditScopeReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.GenerateAuditScopeReportRequest,
                    com.google.cloud.auditmanager.v1.AuditScopeReport>(
                    service, METHODID_GENERATE_AUDIT_SCOPE_REPORT)))
        .addMethod(
            getGenerateAuditReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.GenerateAuditReportRequest,
                    com.google.longrunning.Operation>(service, METHODID_GENERATE_AUDIT_REPORT)))
        .addMethod(
            getListAuditReportsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.ListAuditReportsRequest,
                    com.google.cloud.auditmanager.v1.ListAuditReportsResponse>(
                    service, METHODID_LIST_AUDIT_REPORTS)))
        .addMethod(
            getGetAuditReportMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.GetAuditReportRequest,
                    com.google.cloud.auditmanager.v1.AuditReport>(
                    service, METHODID_GET_AUDIT_REPORT)))
        .addMethod(
            getGetResourceEnrollmentStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.GetResourceEnrollmentStatusRequest,
                    com.google.cloud.auditmanager.v1.ResourceEnrollmentStatus>(
                    service, METHODID_GET_RESOURCE_ENROLLMENT_STATUS)))
        .addMethod(
            getListResourceEnrollmentStatusesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesRequest,
                    com.google.cloud.auditmanager.v1.ListResourceEnrollmentStatusesResponse>(
                    service, METHODID_LIST_RESOURCE_ENROLLMENT_STATUSES)))
        .addMethod(
            getListControlsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.auditmanager.v1.ListControlsRequest,
                    com.google.cloud.auditmanager.v1.ListControlsResponse>(
                    service, METHODID_LIST_CONTROLS)))
        .build();
  }

  private abstract static class AuditManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AuditManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.auditmanager.v1.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AuditManager");
    }
  }

  private static final class AuditManagerFileDescriptorSupplier
      extends AuditManagerBaseDescriptorSupplier {
    AuditManagerFileDescriptorSupplier() {}
  }

  private static final class AuditManagerMethodDescriptorSupplier
      extends AuditManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AuditManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AuditManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AuditManagerFileDescriptorSupplier())
                      .addMethod(getEnrollResourceMethod())
                      .addMethod(getGenerateAuditScopeReportMethod())
                      .addMethod(getGenerateAuditReportMethod())
                      .addMethod(getListAuditReportsMethod())
                      .addMethod(getGetAuditReportMethod())
                      .addMethod(getGetResourceEnrollmentStatusMethod())
                      .addMethod(getListResourceEnrollmentStatusesMethod())
                      .addMethod(getListControlsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
