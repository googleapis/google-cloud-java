/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.retail.v2alpha;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for settings at Project level.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2alpha/project_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectServiceGrpc {

  private ProjectServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.retail.v2alpha.ProjectService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetProjectRequest,
          com.google.cloud.retail.v2alpha.Project>
      getGetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProject",
      requestType = com.google.cloud.retail.v2alpha.GetProjectRequest.class,
      responseType = com.google.cloud.retail.v2alpha.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetProjectRequest,
          com.google.cloud.retail.v2alpha.Project>
      getGetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.GetProjectRequest,
            com.google.cloud.retail.v2alpha.Project>
        getGetProjectMethod;
    if ((getGetProjectMethod = ProjectServiceGrpc.getGetProjectMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getGetProjectMethod = ProjectServiceGrpc.getGetProjectMethod) == null) {
          ProjectServiceGrpc.getGetProjectMethod =
              getGetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.GetProjectRequest,
                          com.google.cloud.retail.v2alpha.Project>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.Project.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectServiceMethodDescriptorSupplier("GetProject"))
                      .build();
        }
      }
    }
    return getGetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.AcceptTermsRequest,
          com.google.cloud.retail.v2alpha.Project>
      getAcceptTermsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptTerms",
      requestType = com.google.cloud.retail.v2alpha.AcceptTermsRequest.class,
      responseType = com.google.cloud.retail.v2alpha.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.AcceptTermsRequest,
          com.google.cloud.retail.v2alpha.Project>
      getAcceptTermsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.AcceptTermsRequest,
            com.google.cloud.retail.v2alpha.Project>
        getAcceptTermsMethod;
    if ((getAcceptTermsMethod = ProjectServiceGrpc.getAcceptTermsMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getAcceptTermsMethod = ProjectServiceGrpc.getAcceptTermsMethod) == null) {
          ProjectServiceGrpc.getAcceptTermsMethod =
              getAcceptTermsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.AcceptTermsRequest,
                          com.google.cloud.retail.v2alpha.Project>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptTerms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.AcceptTermsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.Project.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("AcceptTerms"))
                      .build();
        }
      }
    }
    return getAcceptTermsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.EnrollSolutionRequest, com.google.longrunning.Operation>
      getEnrollSolutionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnrollSolution",
      requestType = com.google.cloud.retail.v2alpha.EnrollSolutionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.EnrollSolutionRequest, com.google.longrunning.Operation>
      getEnrollSolutionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.EnrollSolutionRequest, com.google.longrunning.Operation>
        getEnrollSolutionMethod;
    if ((getEnrollSolutionMethod = ProjectServiceGrpc.getEnrollSolutionMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getEnrollSolutionMethod = ProjectServiceGrpc.getEnrollSolutionMethod) == null) {
          ProjectServiceGrpc.getEnrollSolutionMethod =
              getEnrollSolutionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.EnrollSolutionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnrollSolution"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.EnrollSolutionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("EnrollSolution"))
                      .build();
        }
      }
    }
    return getEnrollSolutionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest,
          com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
      getListEnrolledSolutionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnrolledSolutions",
      requestType = com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest.class,
      responseType = com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest,
          com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
      getListEnrolledSolutionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest,
            com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
        getListEnrolledSolutionsMethod;
    if ((getListEnrolledSolutionsMethod = ProjectServiceGrpc.getListEnrolledSolutionsMethod)
        == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getListEnrolledSolutionsMethod = ProjectServiceGrpc.getListEnrolledSolutionsMethod)
            == null) {
          ProjectServiceGrpc.getListEnrolledSolutionsMethod =
              getListEnrolledSolutionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest,
                          com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEnrolledSolutions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("ListEnrolledSolutions"))
                      .build();
        }
      }
    }
    return getListEnrolledSolutionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetLoggingConfigRequest,
          com.google.cloud.retail.v2alpha.LoggingConfig>
      getGetLoggingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLoggingConfig",
      requestType = com.google.cloud.retail.v2alpha.GetLoggingConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.LoggingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetLoggingConfigRequest,
          com.google.cloud.retail.v2alpha.LoggingConfig>
      getGetLoggingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.GetLoggingConfigRequest,
            com.google.cloud.retail.v2alpha.LoggingConfig>
        getGetLoggingConfigMethod;
    if ((getGetLoggingConfigMethod = ProjectServiceGrpc.getGetLoggingConfigMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getGetLoggingConfigMethod = ProjectServiceGrpc.getGetLoggingConfigMethod) == null) {
          ProjectServiceGrpc.getGetLoggingConfigMethod =
              getGetLoggingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.GetLoggingConfigRequest,
                          com.google.cloud.retail.v2alpha.LoggingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLoggingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GetLoggingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.LoggingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("GetLoggingConfig"))
                      .build();
        }
      }
    }
    return getGetLoggingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest,
          com.google.cloud.retail.v2alpha.LoggingConfig>
      getUpdateLoggingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateLoggingConfig",
      requestType = com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.LoggingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest,
          com.google.cloud.retail.v2alpha.LoggingConfig>
      getUpdateLoggingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest,
            com.google.cloud.retail.v2alpha.LoggingConfig>
        getUpdateLoggingConfigMethod;
    if ((getUpdateLoggingConfigMethod = ProjectServiceGrpc.getUpdateLoggingConfigMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getUpdateLoggingConfigMethod = ProjectServiceGrpc.getUpdateLoggingConfigMethod)
            == null) {
          ProjectServiceGrpc.getUpdateLoggingConfigMethod =
              getUpdateLoggingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest,
                          com.google.cloud.retail.v2alpha.LoggingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateLoggingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.LoggingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("UpdateLoggingConfig"))
                      .build();
        }
      }
    }
    return getUpdateLoggingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetAlertConfigRequest,
          com.google.cloud.retail.v2alpha.AlertConfig>
      getGetAlertConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAlertConfig",
      requestType = com.google.cloud.retail.v2alpha.GetAlertConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.AlertConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.GetAlertConfigRequest,
          com.google.cloud.retail.v2alpha.AlertConfig>
      getGetAlertConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.GetAlertConfigRequest,
            com.google.cloud.retail.v2alpha.AlertConfig>
        getGetAlertConfigMethod;
    if ((getGetAlertConfigMethod = ProjectServiceGrpc.getGetAlertConfigMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getGetAlertConfigMethod = ProjectServiceGrpc.getGetAlertConfigMethod) == null) {
          ProjectServiceGrpc.getGetAlertConfigMethod =
              getGetAlertConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.GetAlertConfigRequest,
                          com.google.cloud.retail.v2alpha.AlertConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAlertConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.GetAlertConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.AlertConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("GetAlertConfig"))
                      .build();
        }
      }
    }
    return getGetAlertConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest,
          com.google.cloud.retail.v2alpha.AlertConfig>
      getUpdateAlertConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAlertConfig",
      requestType = com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest.class,
      responseType = com.google.cloud.retail.v2alpha.AlertConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest,
          com.google.cloud.retail.v2alpha.AlertConfig>
      getUpdateAlertConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest,
            com.google.cloud.retail.v2alpha.AlertConfig>
        getUpdateAlertConfigMethod;
    if ((getUpdateAlertConfigMethod = ProjectServiceGrpc.getUpdateAlertConfigMethod) == null) {
      synchronized (ProjectServiceGrpc.class) {
        if ((getUpdateAlertConfigMethod = ProjectServiceGrpc.getUpdateAlertConfigMethod) == null) {
          ProjectServiceGrpc.getUpdateAlertConfigMethod =
              getUpdateAlertConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest,
                          com.google.cloud.retail.v2alpha.AlertConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAlertConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2alpha.AlertConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectServiceMethodDescriptorSupplier("UpdateAlertConfig"))
                      .build();
        }
      }
    }
    return getUpdateAlertConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProjectServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceStub>() {
          @java.lang.Override
          public ProjectServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceStub(channel, callOptions);
          }
        };
    return ProjectServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceBlockingStub>() {
          @java.lang.Override
          public ProjectServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceBlockingStub(channel, callOptions);
          }
        };
    return ProjectServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProjectServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectServiceFutureStub>() {
          @java.lang.Override
          public ProjectServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectServiceFutureStub(channel, callOptions);
          }
        };
    return ProjectServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for settings at Project level.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets the project.
     * Throws `NOT_FOUND` if the project wasn't initialized for the Retail API
     * service.
     * </pre>
     */
    default void getProject(
        com.google.cloud.retail.v2alpha.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts service terms for this project.
     * By making requests to this API, you agree to the terms of service linked
     * below.
     * https://cloud.google.com/retail/data-use-terms
     * </pre>
     */
    default void acceptTerms(
        com.google.cloud.retail.v2alpha.AcceptTermsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcceptTermsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * The method enrolls a solution of type [Retail
     * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH]
     * into a project.
     * The [Recommendations AI solution
     * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION]
     * is enrolled by default when your project enables Retail API, so you don't
     * need to call the enrollSolution method for recommendations.
     * </pre>
     */
    default void enrollSolution(
        com.google.cloud.retail.v2alpha.EnrollSolutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnrollSolutionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the retail API solutions the project has enrolled.
     * </pre>
     */
    default void listEnrolledSolutions(
        com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnrolledSolutionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the
     * requested project.
     * </pre>
     */
    default void getLoggingConfig(
        com.google.cloud.retail.v2alpha.GetLoggingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLoggingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of
     * the requested project.
     * </pre>
     */
    default void updateLoggingConfig(
        com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateLoggingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the
     * requested project.
     * </pre>
     */
    default void getAlertConfig(
        com.google.cloud.retail.v2alpha.GetAlertConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAlertConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the alert config of the requested project.
     * </pre>
     */
    default void updateAlertConfig(
        com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAlertConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProjectService.
   *
   * <pre>
   * Service for settings at Project level.
   * </pre>
   */
  public abstract static class ProjectServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProjectServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProjectService.
   *
   * <pre>
   * Service for settings at Project level.
   * </pre>
   */
  public static final class ProjectServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProjectServiceStub> {
    private ProjectServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the project.
     * Throws `NOT_FOUND` if the project wasn't initialized for the Retail API
     * service.
     * </pre>
     */
    public void getProject(
        com.google.cloud.retail.v2alpha.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts service terms for this project.
     * By making requests to this API, you agree to the terms of service linked
     * below.
     * https://cloud.google.com/retail/data-use-terms
     * </pre>
     */
    public void acceptTerms(
        com.google.cloud.retail.v2alpha.AcceptTermsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptTermsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * The method enrolls a solution of type [Retail
     * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH]
     * into a project.
     * The [Recommendations AI solution
     * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION]
     * is enrolled by default when your project enables Retail API, so you don't
     * need to call the enrollSolution method for recommendations.
     * </pre>
     */
    public void enrollSolution(
        com.google.cloud.retail.v2alpha.EnrollSolutionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnrollSolutionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the retail API solutions the project has enrolled.
     * </pre>
     */
    public void listEnrolledSolutions(
        com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnrolledSolutionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the
     * requested project.
     * </pre>
     */
    public void getLoggingConfig(
        com.google.cloud.retail.v2alpha.GetLoggingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLoggingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of
     * the requested project.
     * </pre>
     */
    public void updateLoggingConfig(
        com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateLoggingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the
     * requested project.
     * </pre>
     */
    public void getAlertConfig(
        com.google.cloud.retail.v2alpha.GetAlertConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAlertConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the alert config of the requested project.
     * </pre>
     */
    public void updateAlertConfig(
        com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAlertConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProjectService.
   *
   * <pre>
   * Service for settings at Project level.
   * </pre>
   */
  public static final class ProjectServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProjectServiceBlockingStub> {
    private ProjectServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the project.
     * Throws `NOT_FOUND` if the project wasn't initialized for the Retail API
     * service.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.Project getProject(
        com.google.cloud.retail.v2alpha.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts service terms for this project.
     * By making requests to this API, you agree to the terms of service linked
     * below.
     * https://cloud.google.com/retail/data-use-terms
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.Project acceptTerms(
        com.google.cloud.retail.v2alpha.AcceptTermsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptTermsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * The method enrolls a solution of type [Retail
     * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH]
     * into a project.
     * The [Recommendations AI solution
     * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION]
     * is enrolled by default when your project enables Retail API, so you don't
     * need to call the enrollSolution method for recommendations.
     * </pre>
     */
    public com.google.longrunning.Operation enrollSolution(
        com.google.cloud.retail.v2alpha.EnrollSolutionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnrollSolutionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the retail API solutions the project has enrolled.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse listEnrolledSolutions(
        com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnrolledSolutionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the
     * requested project.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.LoggingConfig getLoggingConfig(
        com.google.cloud.retail.v2alpha.GetLoggingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLoggingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of
     * the requested project.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.LoggingConfig updateLoggingConfig(
        com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateLoggingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the
     * requested project.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.AlertConfig getAlertConfig(
        com.google.cloud.retail.v2alpha.GetAlertConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAlertConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the alert config of the requested project.
     * </pre>
     */
    public com.google.cloud.retail.v2alpha.AlertConfig updateAlertConfig(
        com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAlertConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProjectService.
   *
   * <pre>
   * Service for settings at Project level.
   * </pre>
   */
  public static final class ProjectServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProjectServiceFutureStub> {
    private ProjectServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets the project.
     * Throws `NOT_FOUND` if the project wasn't initialized for the Retail API
     * service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.Project>
        getProject(com.google.cloud.retail.v2alpha.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts service terms for this project.
     * By making requests to this API, you agree to the terms of service linked
     * below.
     * https://cloud.google.com/retail/data-use-terms
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.Project>
        acceptTerms(com.google.cloud.retail.v2alpha.AcceptTermsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptTermsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * The method enrolls a solution of type [Retail
     * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH]
     * into a project.
     * The [Recommendations AI solution
     * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION]
     * is enrolled by default when your project enables Retail API, so you don't
     * need to call the enrollSolution method for recommendations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enrollSolution(com.google.cloud.retail.v2alpha.EnrollSolutionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnrollSolutionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the retail API solutions the project has enrolled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>
        listEnrolledSolutions(
            com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnrolledSolutionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the
     * requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.LoggingConfig>
        getLoggingConfig(com.google.cloud.retail.v2alpha.GetLoggingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLoggingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of
     * the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.LoggingConfig>
        updateLoggingConfig(com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateLoggingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the
     * requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.AlertConfig>
        getAlertConfig(com.google.cloud.retail.v2alpha.GetAlertConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAlertConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the alert config of the requested project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2alpha.AlertConfig>
        updateAlertConfig(com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAlertConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECT = 0;
  private static final int METHODID_ACCEPT_TERMS = 1;
  private static final int METHODID_ENROLL_SOLUTION = 2;
  private static final int METHODID_LIST_ENROLLED_SOLUTIONS = 3;
  private static final int METHODID_GET_LOGGING_CONFIG = 4;
  private static final int METHODID_UPDATE_LOGGING_CONFIG = 5;
  private static final int METHODID_GET_ALERT_CONFIG = 6;
  private static final int METHODID_UPDATE_ALERT_CONFIG = 7;

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
        case METHODID_GET_PROJECT:
          serviceImpl.getProject(
              (com.google.cloud.retail.v2alpha.GetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project>)
                  responseObserver);
          break;
        case METHODID_ACCEPT_TERMS:
          serviceImpl.acceptTerms(
              (com.google.cloud.retail.v2alpha.AcceptTermsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.Project>)
                  responseObserver);
          break;
        case METHODID_ENROLL_SOLUTION:
          serviceImpl.enrollSolution(
              (com.google.cloud.retail.v2alpha.EnrollSolutionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENROLLED_SOLUTIONS:
          serviceImpl.listEnrolledSolutions(
              (com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LOGGING_CONFIG:
          serviceImpl.getLoggingConfig(
              (com.google.cloud.retail.v2alpha.GetLoggingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_LOGGING_CONFIG:
          serviceImpl.updateLoggingConfig(
              (com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.LoggingConfig>)
                  responseObserver);
          break;
        case METHODID_GET_ALERT_CONFIG:
          serviceImpl.getAlertConfig(
              (com.google.cloud.retail.v2alpha.GetAlertConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ALERT_CONFIG:
          serviceImpl.updateAlertConfig(
              (com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2alpha.AlertConfig>)
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
            getGetProjectMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.GetProjectRequest,
                    com.google.cloud.retail.v2alpha.Project>(service, METHODID_GET_PROJECT)))
        .addMethod(
            getAcceptTermsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.AcceptTermsRequest,
                    com.google.cloud.retail.v2alpha.Project>(service, METHODID_ACCEPT_TERMS)))
        .addMethod(
            getEnrollSolutionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.EnrollSolutionRequest,
                    com.google.longrunning.Operation>(service, METHODID_ENROLL_SOLUTION)))
        .addMethod(
            getListEnrolledSolutionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.ListEnrolledSolutionsRequest,
                    com.google.cloud.retail.v2alpha.ListEnrolledSolutionsResponse>(
                    service, METHODID_LIST_ENROLLED_SOLUTIONS)))
        .addMethod(
            getGetLoggingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.GetLoggingConfigRequest,
                    com.google.cloud.retail.v2alpha.LoggingConfig>(
                    service, METHODID_GET_LOGGING_CONFIG)))
        .addMethod(
            getUpdateLoggingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.UpdateLoggingConfigRequest,
                    com.google.cloud.retail.v2alpha.LoggingConfig>(
                    service, METHODID_UPDATE_LOGGING_CONFIG)))
        .addMethod(
            getGetAlertConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.GetAlertConfigRequest,
                    com.google.cloud.retail.v2alpha.AlertConfig>(
                    service, METHODID_GET_ALERT_CONFIG)))
        .addMethod(
            getUpdateAlertConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.retail.v2alpha.UpdateAlertConfigRequest,
                    com.google.cloud.retail.v2alpha.AlertConfig>(
                    service, METHODID_UPDATE_ALERT_CONFIG)))
        .build();
  }

  private abstract static class ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2alpha.ProjectServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProjectService");
    }
  }

  private static final class ProjectServiceFileDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier {
    ProjectServiceFileDescriptorSupplier() {}
  }

  private static final class ProjectServiceMethodDescriptorSupplier
      extends ProjectServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProjectServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProjectServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProjectServiceFileDescriptorSupplier())
                      .addMethod(getGetProjectMethod())
                      .addMethod(getAcceptTermsMethod())
                      .addMethod(getEnrollSolutionMethod())
                      .addMethod(getListEnrolledSolutionsMethod())
                      .addMethod(getGetLoggingConfigMethod())
                      .addMethod(getUpdateLoggingConfigMethod())
                      .addMethod(getGetAlertConfigMethod())
                      .addMethod(getUpdateAlertConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
