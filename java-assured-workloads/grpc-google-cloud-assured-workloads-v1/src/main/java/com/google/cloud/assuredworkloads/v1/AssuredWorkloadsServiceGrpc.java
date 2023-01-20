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
package com.google.cloud.assuredworkloads.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage AssuredWorkloads.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/assuredworkloads/v1/assuredworkloads.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AssuredWorkloadsServiceGrpc {

  private AssuredWorkloadsServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.assuredworkloads.v1.AssuredWorkloadsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest,
          com.google.longrunning.Operation>
      getCreateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkload",
      requestType = com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest,
          com.google.longrunning.Operation>
      getCreateWorkloadMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest,
            com.google.longrunning.Operation>
        getCreateWorkloadMethod;
    if ((getCreateWorkloadMethod = AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getCreateWorkloadMethod = AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getCreateWorkloadMethod =
              getCreateWorkloadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("CreateWorkload"))
                      .build();
        }
      }
    }
    return getCreateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest,
          com.google.cloud.assuredworkloads.v1.Workload>
      getUpdateWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkload",
      requestType = com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest,
          com.google.cloud.assuredworkloads.v1.Workload>
      getUpdateWorkloadMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest,
            com.google.cloud.assuredworkloads.v1.Workload>
        getUpdateWorkloadMethod;
    if ((getUpdateWorkloadMethod = AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getUpdateWorkloadMethod = AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getUpdateWorkloadMethod =
              getUpdateWorkloadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest,
                          com.google.cloud.assuredworkloads.v1.Workload>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.Workload.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("UpdateWorkload"))
                      .build();
        }
      }
    }
    return getUpdateWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest,
          com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
      getRestrictAllowedResourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestrictAllowedResources",
      requestType = com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest,
          com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
      getRestrictAllowedResourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest,
            com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
        getRestrictAllowedResourcesMethod;
    if ((getRestrictAllowedResourcesMethod =
            AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod)
        == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getRestrictAllowedResourcesMethod =
                AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getRestrictAllowedResourcesMethod =
              getRestrictAllowedResourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest,
                          com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RestrictAllowedResources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier(
                              "RestrictAllowedResources"))
                      .build();
        }
      }
    }
    return getRestrictAllowedResourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest, com.google.protobuf.Empty>
      getDeleteWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkload",
      requestType = com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest, com.google.protobuf.Empty>
      getDeleteWorkloadMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest, com.google.protobuf.Empty>
        getDeleteWorkloadMethod;
    if ((getDeleteWorkloadMethod = AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getDeleteWorkloadMethod = AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getDeleteWorkloadMethod =
              getDeleteWorkloadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("DeleteWorkload"))
                      .build();
        }
      }
    }
    return getDeleteWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.GetWorkloadRequest,
          com.google.cloud.assuredworkloads.v1.Workload>
      getGetWorkloadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkload",
      requestType = com.google.cloud.assuredworkloads.v1.GetWorkloadRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.Workload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.GetWorkloadRequest,
          com.google.cloud.assuredworkloads.v1.Workload>
      getGetWorkloadMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.GetWorkloadRequest,
            com.google.cloud.assuredworkloads.v1.Workload>
        getGetWorkloadMethod;
    if ((getGetWorkloadMethod = AssuredWorkloadsServiceGrpc.getGetWorkloadMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getGetWorkloadMethod = AssuredWorkloadsServiceGrpc.getGetWorkloadMethod) == null) {
          AssuredWorkloadsServiceGrpc.getGetWorkloadMethod =
              getGetWorkloadMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.GetWorkloadRequest,
                          com.google.cloud.assuredworkloads.v1.Workload>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkload"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.GetWorkloadRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.Workload.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("GetWorkload"))
                      .build();
        }
      }
    }
    return getGetWorkloadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest,
          com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
      getListWorkloadsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloads",
      requestType = com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest,
          com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
      getListWorkloadsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest,
            com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
        getListWorkloadsMethod;
    if ((getListWorkloadsMethod = AssuredWorkloadsServiceGrpc.getListWorkloadsMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getListWorkloadsMethod = AssuredWorkloadsServiceGrpc.getListWorkloadsMethod) == null) {
          AssuredWorkloadsServiceGrpc.getListWorkloadsMethod =
              getListWorkloadsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest,
                          com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloads"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("ListWorkloads"))
                      .build();
        }
      }
    }
    return getListWorkloadsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.ListViolationsRequest,
          com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
      getListViolationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListViolations",
      requestType = com.google.cloud.assuredworkloads.v1.ListViolationsRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.ListViolationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.ListViolationsRequest,
          com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
      getListViolationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.ListViolationsRequest,
            com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
        getListViolationsMethod;
    if ((getListViolationsMethod = AssuredWorkloadsServiceGrpc.getListViolationsMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getListViolationsMethod = AssuredWorkloadsServiceGrpc.getListViolationsMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getListViolationsMethod =
              getListViolationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.ListViolationsRequest,
                          com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListViolations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.ListViolationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.ListViolationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("ListViolations"))
                      .build();
        }
      }
    }
    return getListViolationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.GetViolationRequest,
          com.google.cloud.assuredworkloads.v1.Violation>
      getGetViolationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetViolation",
      requestType = com.google.cloud.assuredworkloads.v1.GetViolationRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.Violation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.GetViolationRequest,
          com.google.cloud.assuredworkloads.v1.Violation>
      getGetViolationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.GetViolationRequest,
            com.google.cloud.assuredworkloads.v1.Violation>
        getGetViolationMethod;
    if ((getGetViolationMethod = AssuredWorkloadsServiceGrpc.getGetViolationMethod) == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getGetViolationMethod = AssuredWorkloadsServiceGrpc.getGetViolationMethod) == null) {
          AssuredWorkloadsServiceGrpc.getGetViolationMethod =
              getGetViolationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.GetViolationRequest,
                          com.google.cloud.assuredworkloads.v1.Violation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetViolation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.GetViolationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.Violation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier("GetViolation"))
                      .build();
        }
      }
    }
    return getGetViolationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest,
          com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
      getAcknowledgeViolationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcknowledgeViolation",
      requestType = com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest.class,
      responseType = com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest,
          com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
      getAcknowledgeViolationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest,
            com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
        getAcknowledgeViolationMethod;
    if ((getAcknowledgeViolationMethod = AssuredWorkloadsServiceGrpc.getAcknowledgeViolationMethod)
        == null) {
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        if ((getAcknowledgeViolationMethod =
                AssuredWorkloadsServiceGrpc.getAcknowledgeViolationMethod)
            == null) {
          AssuredWorkloadsServiceGrpc.getAcknowledgeViolationMethod =
              getAcknowledgeViolationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest,
                          com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AcknowledgeViolation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AssuredWorkloadsServiceMethodDescriptorSupplier(
                              "AcknowledgeViolation"))
                      .build();
        }
      }
    }
    return getAcknowledgeViolationMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AssuredWorkloadsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceStub>() {
          @java.lang.Override
          public AssuredWorkloadsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssuredWorkloadsServiceStub(channel, callOptions);
          }
        };
    return AssuredWorkloadsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AssuredWorkloadsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceBlockingStub>() {
          @java.lang.Override
          public AssuredWorkloadsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssuredWorkloadsServiceBlockingStub(channel, callOptions);
          }
        };
    return AssuredWorkloadsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AssuredWorkloadsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AssuredWorkloadsServiceFutureStub>() {
          @java.lang.Override
          public AssuredWorkloadsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AssuredWorkloadsServiceFutureStub(channel, callOptions);
          }
        };
    return AssuredWorkloadsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public abstract static class AssuredWorkloadsServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public void createWorkload(
        com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateWorkloadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public void updateWorkload(
        com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateWorkloadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public void restrictAllowedResources(
        com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestrictAllowedResourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * </pre>
     */
    public void deleteWorkload(
        com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteWorkloadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public void getWorkload(
        com.google.cloud.assuredworkloads.v1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetWorkloadMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public void listWorkloads(
        com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListWorkloadsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Violations in the AssuredWorkload Environment.
     * Callers may also choose to read across multiple Workloads as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of workload-id in the parent.
     * Format `organizations/{org_id}/locations/{location}/workloads/-`
     * </pre>
     */
    public void listViolations(
        com.google.cloud.assuredworkloads.v1.ListViolationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListViolationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Assured Workload Violation based on ID.
     * </pre>
     */
    public void getViolation(
        com.google.cloud.assuredworkloads.v1.GetViolationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Violation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetViolationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges an existing violation. By acknowledging a violation, users
     * acknowledge the existence of a compliance violation in their workload and
     * decide to ignore it due to a valid business justification. Acknowledgement
     * is a permanent operation and it cannot be reverted.
     * </pre>
     */
    public void acknowledgeViolation(
        com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcknowledgeViolationMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateWorkloadMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_WORKLOAD)))
          .addMethod(
              getUpdateWorkloadMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest,
                      com.google.cloud.assuredworkloads.v1.Workload>(
                      this, METHODID_UPDATE_WORKLOAD)))
          .addMethod(
              getRestrictAllowedResourcesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest,
                      com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>(
                      this, METHODID_RESTRICT_ALLOWED_RESOURCES)))
          .addMethod(
              getDeleteWorkloadMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_WORKLOAD)))
          .addMethod(
              getGetWorkloadMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.GetWorkloadRequest,
                      com.google.cloud.assuredworkloads.v1.Workload>(this, METHODID_GET_WORKLOAD)))
          .addMethod(
              getListWorkloadsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest,
                      com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>(
                      this, METHODID_LIST_WORKLOADS)))
          .addMethod(
              getListViolationsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.ListViolationsRequest,
                      com.google.cloud.assuredworkloads.v1.ListViolationsResponse>(
                      this, METHODID_LIST_VIOLATIONS)))
          .addMethod(
              getGetViolationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.GetViolationRequest,
                      com.google.cloud.assuredworkloads.v1.Violation>(
                      this, METHODID_GET_VIOLATION)))
          .addMethod(
              getAcknowledgeViolationMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest,
                      com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>(
                      this, METHODID_ACKNOWLEDGE_VIOLATION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AssuredWorkloadsServiceStub> {
    private AssuredWorkloadsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public void createWorkload(
        com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public void updateWorkload(
        com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public void restrictAllowedResources(
        com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestrictAllowedResourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * </pre>
     */
    public void deleteWorkload(
        com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public void getWorkload(
        com.google.cloud.assuredworkloads.v1.GetWorkloadRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public void listWorkloads(
        com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Violations in the AssuredWorkload Environment.
     * Callers may also choose to read across multiple Workloads as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of workload-id in the parent.
     * Format `organizations/{org_id}/locations/{location}/workloads/-`
     * </pre>
     */
    public void listViolations(
        com.google.cloud.assuredworkloads.v1.ListViolationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListViolationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Assured Workload Violation based on ID.
     * </pre>
     */
    public void getViolation(
        com.google.cloud.assuredworkloads.v1.GetViolationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Violation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetViolationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges an existing violation. By acknowledging a violation, users
     * acknowledge the existence of a compliance violation in their workload and
     * decide to ignore it due to a valid business justification. Acknowledgement
     * is a permanent operation and it cannot be reverted.
     * </pre>
     */
    public void acknowledgeViolation(
        com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcknowledgeViolationMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AssuredWorkloadsServiceBlockingStub> {
    private AssuredWorkloadsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkload(
        com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.Workload updateWorkload(
        com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkloadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse
        restrictAllowedResources(
            com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestrictAllowedResourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWorkload(
        com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkloadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.Workload getWorkload(
        com.google.cloud.assuredworkloads.v1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse listWorkloads(
        com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Violations in the AssuredWorkload Environment.
     * Callers may also choose to read across multiple Workloads as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of workload-id in the parent.
     * Format `organizations/{org_id}/locations/{location}/workloads/-`
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.ListViolationsResponse listViolations(
        com.google.cloud.assuredworkloads.v1.ListViolationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViolationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Assured Workload Violation based on ID.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.Violation getViolation(
        com.google.cloud.assuredworkloads.v1.GetViolationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViolationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges an existing violation. By acknowledging a violation, users
     * acknowledge the existence of a compliance violation in their workload and
     * decide to ignore it due to a valid business justification. Acknowledgement
     * is a permanent operation and it cannot be reverted.
     * </pre>
     */
    public com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse acknowledgeViolation(
        com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcknowledgeViolationMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage AssuredWorkloads.
   * </pre>
   */
  public static final class AssuredWorkloadsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AssuredWorkloadsServiceFutureStub> {
    private AssuredWorkloadsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AssuredWorkloadsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AssuredWorkloadsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates Assured Workload.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createWorkload(com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing workload.
     * Currently allows updating of workload display_name and labels.
     * For force updates don't set etag field in the Workload.
     * Only one update operation per workload can be in progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.Workload>
        updateWorkload(com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkloadMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restrict the list of resources allowed in the Workload environment.
     * The current list of allowed products can be found at
     * https://cloud.google.com/assured-workloads/docs/supported-products
     * In addition to assuredworkloads.workload.update permission, the user should
     * also have orgpolicy.policy.set permission on the folder resource
     * to use this functionality.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>
        restrictAllowedResources(
            com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestrictAllowedResourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the workload. Make sure that workload's direct children are already
     * in a deleted state, otherwise the request will fail with a
     * FAILED_PRECONDITION error.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWorkload(com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkloadMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets Assured Workload associated with a CRM Node
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.Workload>
        getWorkload(com.google.cloud.assuredworkloads.v1.GetWorkloadRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Assured Workloads under a CRM Node.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>
        listWorkloads(com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Violations in the AssuredWorkload Environment.
     * Callers may also choose to read across multiple Workloads as per
     * [AIP-159](https://google.aip.dev/159) by using '-' (the hyphen or dash
     * character) as a wildcard character instead of workload-id in the parent.
     * Format `organizations/{org_id}/locations/{location}/workloads/-`
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.ListViolationsResponse>
        listViolations(com.google.cloud.assuredworkloads.v1.ListViolationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListViolationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves Assured Workload Violation based on ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.Violation>
        getViolation(com.google.cloud.assuredworkloads.v1.GetViolationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetViolationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Acknowledges an existing violation. By acknowledging a violation, users
     * acknowledge the existence of a compliance violation in their workload and
     * decide to ignore it due to a valid business justification. Acknowledgement
     * is a permanent operation and it cannot be reverted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>
        acknowledgeViolation(
            com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcknowledgeViolationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_WORKLOAD = 0;
  private static final int METHODID_UPDATE_WORKLOAD = 1;
  private static final int METHODID_RESTRICT_ALLOWED_RESOURCES = 2;
  private static final int METHODID_DELETE_WORKLOAD = 3;
  private static final int METHODID_GET_WORKLOAD = 4;
  private static final int METHODID_LIST_WORKLOADS = 5;
  private static final int METHODID_LIST_VIOLATIONS = 6;
  private static final int METHODID_GET_VIOLATION = 7;
  private static final int METHODID_ACKNOWLEDGE_VIOLATION = 8;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AssuredWorkloadsServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AssuredWorkloadsServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_WORKLOAD:
          serviceImpl.createWorkload(
              (com.google.cloud.assuredworkloads.v1.CreateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKLOAD:
          serviceImpl.updateWorkload(
              (com.google.cloud.assuredworkloads.v1.UpdateWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>)
                  responseObserver);
          break;
        case METHODID_RESTRICT_ALLOWED_RESOURCES:
          serviceImpl.restrictAllowedResources(
              (com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.assuredworkloads.v1.RestrictAllowedResourcesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_WORKLOAD:
          serviceImpl.deleteWorkload(
              (com.google.cloud.assuredworkloads.v1.DeleteWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_WORKLOAD:
          serviceImpl.getWorkload(
              (com.google.cloud.assuredworkloads.v1.GetWorkloadRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Workload>)
                  responseObserver);
          break;
        case METHODID_LIST_WORKLOADS:
          serviceImpl.listWorkloads(
              (com.google.cloud.assuredworkloads.v1.ListWorkloadsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.assuredworkloads.v1.ListWorkloadsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_VIOLATIONS:
          serviceImpl.listViolations(
              (com.google.cloud.assuredworkloads.v1.ListViolationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.assuredworkloads.v1.ListViolationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VIOLATION:
          serviceImpl.getViolation(
              (com.google.cloud.assuredworkloads.v1.GetViolationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.assuredworkloads.v1.Violation>)
                  responseObserver);
          break;
        case METHODID_ACKNOWLEDGE_VIOLATION:
          serviceImpl.acknowledgeViolation(
              (com.google.cloud.assuredworkloads.v1.AcknowledgeViolationRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.assuredworkloads.v1.AcknowledgeViolationResponse>)
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

  private abstract static class AssuredWorkloadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AssuredWorkloadsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.assuredworkloads.v1.AssuredworkloadsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AssuredWorkloadsService");
    }
  }

  private static final class AssuredWorkloadsServiceFileDescriptorSupplier
      extends AssuredWorkloadsServiceBaseDescriptorSupplier {
    AssuredWorkloadsServiceFileDescriptorSupplier() {}
  }

  private static final class AssuredWorkloadsServiceMethodDescriptorSupplier
      extends AssuredWorkloadsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AssuredWorkloadsServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AssuredWorkloadsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AssuredWorkloadsServiceFileDescriptorSupplier())
                      .addMethod(getCreateWorkloadMethod())
                      .addMethod(getUpdateWorkloadMethod())
                      .addMethod(getRestrictAllowedResourcesMethod())
                      .addMethod(getDeleteWorkloadMethod())
                      .addMethod(getGetWorkloadMethod())
                      .addMethod(getListWorkloadsMethod())
                      .addMethod(getListViolationsMethod())
                      .addMethod(getGetViolationMethod())
                      .addMethod(getAcknowledgeViolationMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
