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
package com.google.cloud.resourcemanager.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Manages Google Cloud Projects.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/resourcemanager/v3/projects.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProjectsGrpc {

  private ProjectsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.resourcemanager.v3.Projects";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetProjectRequest,
          com.google.cloud.resourcemanager.v3.Project>
      getGetProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProject",
      requestType = com.google.cloud.resourcemanager.v3.GetProjectRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.Project.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.GetProjectRequest,
          com.google.cloud.resourcemanager.v3.Project>
      getGetProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.GetProjectRequest,
            com.google.cloud.resourcemanager.v3.Project>
        getGetProjectMethod;
    if ((getGetProjectMethod = ProjectsGrpc.getGetProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getGetProjectMethod = ProjectsGrpc.getGetProjectMethod) == null) {
          ProjectsGrpc.getGetProjectMethod =
              getGetProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.GetProjectRequest,
                          com.google.cloud.resourcemanager.v3.Project>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.GetProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.Project.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("GetProject"))
                      .build();
        }
      }
    }
    return getGetProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListProjectsRequest,
          com.google.cloud.resourcemanager.v3.ListProjectsResponse>
      getListProjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProjects",
      requestType = com.google.cloud.resourcemanager.v3.ListProjectsRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.ListProjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.ListProjectsRequest,
          com.google.cloud.resourcemanager.v3.ListProjectsResponse>
      getListProjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.ListProjectsRequest,
            com.google.cloud.resourcemanager.v3.ListProjectsResponse>
        getListProjectsMethod;
    if ((getListProjectsMethod = ProjectsGrpc.getListProjectsMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getListProjectsMethod = ProjectsGrpc.getListProjectsMethod) == null) {
          ProjectsGrpc.getListProjectsMethod =
              getListProjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.ListProjectsRequest,
                          com.google.cloud.resourcemanager.v3.ListProjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListProjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.ListProjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("ListProjects"))
                      .build();
        }
      }
    }
    return getListProjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchProjectsRequest,
          com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
      getSearchProjectsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SearchProjects",
      requestType = com.google.cloud.resourcemanager.v3.SearchProjectsRequest.class,
      responseType = com.google.cloud.resourcemanager.v3.SearchProjectsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.SearchProjectsRequest,
          com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
      getSearchProjectsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.SearchProjectsRequest,
            com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
        getSearchProjectsMethod;
    if ((getSearchProjectsMethod = ProjectsGrpc.getSearchProjectsMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getSearchProjectsMethod = ProjectsGrpc.getSearchProjectsMethod) == null) {
          ProjectsGrpc.getSearchProjectsMethod =
              getSearchProjectsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.SearchProjectsRequest,
                          com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SearchProjects"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchProjectsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.SearchProjectsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("SearchProjects"))
                      .build();
        }
      }
    }
    return getSearchProjectsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateProjectRequest,
          com.google.longrunning.Operation>
      getCreateProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProject",
      requestType = com.google.cloud.resourcemanager.v3.CreateProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.CreateProjectRequest,
          com.google.longrunning.Operation>
      getCreateProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.CreateProjectRequest,
            com.google.longrunning.Operation>
        getCreateProjectMethod;
    if ((getCreateProjectMethod = ProjectsGrpc.getCreateProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getCreateProjectMethod = ProjectsGrpc.getCreateProjectMethod) == null) {
          ProjectsGrpc.getCreateProjectMethod =
              getCreateProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.CreateProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.CreateProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("CreateProject"))
                      .build();
        }
      }
    }
    return getCreateProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateProjectRequest,
          com.google.longrunning.Operation>
      getUpdateProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProject",
      requestType = com.google.cloud.resourcemanager.v3.UpdateProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UpdateProjectRequest,
          com.google.longrunning.Operation>
      getUpdateProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.UpdateProjectRequest,
            com.google.longrunning.Operation>
        getUpdateProjectMethod;
    if ((getUpdateProjectMethod = ProjectsGrpc.getUpdateProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getUpdateProjectMethod = ProjectsGrpc.getUpdateProjectMethod) == null) {
          ProjectsGrpc.getUpdateProjectMethod =
              getUpdateProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.UpdateProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.UpdateProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("UpdateProject"))
                      .build();
        }
      }
    }
    return getUpdateProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.MoveProjectRequest, com.google.longrunning.Operation>
      getMoveProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MoveProject",
      requestType = com.google.cloud.resourcemanager.v3.MoveProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.MoveProjectRequest, com.google.longrunning.Operation>
      getMoveProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.MoveProjectRequest,
            com.google.longrunning.Operation>
        getMoveProjectMethod;
    if ((getMoveProjectMethod = ProjectsGrpc.getMoveProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getMoveProjectMethod = ProjectsGrpc.getMoveProjectMethod) == null) {
          ProjectsGrpc.getMoveProjectMethod =
              getMoveProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.MoveProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MoveProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.MoveProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("MoveProject"))
                      .build();
        }
      }
    }
    return getMoveProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteProjectRequest,
          com.google.longrunning.Operation>
      getDeleteProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProject",
      requestType = com.google.cloud.resourcemanager.v3.DeleteProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.DeleteProjectRequest,
          com.google.longrunning.Operation>
      getDeleteProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.DeleteProjectRequest,
            com.google.longrunning.Operation>
        getDeleteProjectMethod;
    if ((getDeleteProjectMethod = ProjectsGrpc.getDeleteProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getDeleteProjectMethod = ProjectsGrpc.getDeleteProjectMethod) == null) {
          ProjectsGrpc.getDeleteProjectMethod =
              getDeleteProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.DeleteProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.DeleteProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("DeleteProject"))
                      .build();
        }
      }
    }
    return getDeleteProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UndeleteProjectRequest,
          com.google.longrunning.Operation>
      getUndeleteProjectMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteProject",
      requestType = com.google.cloud.resourcemanager.v3.UndeleteProjectRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.resourcemanager.v3.UndeleteProjectRequest,
          com.google.longrunning.Operation>
      getUndeleteProjectMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.resourcemanager.v3.UndeleteProjectRequest,
            com.google.longrunning.Operation>
        getUndeleteProjectMethod;
    if ((getUndeleteProjectMethod = ProjectsGrpc.getUndeleteProjectMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getUndeleteProjectMethod = ProjectsGrpc.getUndeleteProjectMethod) == null) {
          ProjectsGrpc.getUndeleteProjectMethod =
              getUndeleteProjectMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.resourcemanager.v3.UndeleteProjectRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteProject"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.resourcemanager.v3.UndeleteProjectRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("UndeleteProject"))
                      .build();
        }
      }
    }
    return getUndeleteProjectMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = ProjectsGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getGetIamPolicyMethod = ProjectsGrpc.getGetIamPolicyMethod) == null) {
          ProjectsGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = ProjectsGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getSetIamPolicyMethod = ProjectsGrpc.getSetIamPolicyMethod) == null) {
          ProjectsGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(new ProjectsMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = ProjectsGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ProjectsGrpc.class) {
        if ((getTestIamPermissionsMethod = ProjectsGrpc.getTestIamPermissionsMethod) == null) {
          ProjectsGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProjectsMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProjectsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectsStub>() {
          @java.lang.Override
          public ProjectsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectsStub(channel, callOptions);
          }
        };
    return ProjectsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProjectsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectsBlockingStub>() {
          @java.lang.Override
          public ProjectsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectsBlockingStub(channel, callOptions);
          }
        };
    return ProjectsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProjectsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProjectsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProjectsFutureStub>() {
          @java.lang.Override
          public ProjectsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProjectsFutureStub(channel, callOptions);
          }
        };
    return ProjectsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Manages Google Cloud Projects.
   * </pre>
   */
  public abstract static class ProjectsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Retrieves the project identified by the specified `name` (for example,
     * `projects/415104041262`).
     * The caller must have `resourcemanager.projects.get` permission
     * for this project.
     * </pre>
     */
    public void getProject(
        com.google.cloud.resourcemanager.v3.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Project> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists projects that are direct children of the specified folder or
     * organization resource. `list()` provides a strongly consistent view of the
     * projects underneath the specified parent resource. `list()` returns
     * projects sorted based upon the (ascending) lexical ordering of their
     * `display_name`. The caller must have `resourcemanager.projects.list`
     * permission on the identified parent.
     * </pre>
     */
    public void listProjects(
        com.google.cloud.resourcemanager.v3.ListProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListProjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search for projects that the caller has both `resourcemanager.projects.get`
     * permission on, and also satisfy the specified query.
     * This method returns projects in an unspecified order.
     * This method is eventually consistent with project mutations; this means
     * that a newly created project may not appear in the results or recent
     * updates to an existing project may not be reflected in the results. To
     * retrieve the latest state of a project, use the
     * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
     * </pre>
     */
    public void searchProjects(
        com.google.cloud.resourcemanager.v3.SearchProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSearchProjectsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request that a new project be created. The result is an `Operation` which
     * can be used to track the creation process. This process usually takes a few
     * seconds, but can sometimes take much longer. The tracking `Operation` is
     * automatically deleted after a few hours, so there is no need to call
     * `DeleteOperation`.
     * </pre>
     */
    public void createProject(
        com.google.cloud.resourcemanager.v3.CreateProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the `display_name` and labels of the project identified by the
     * specified `name` (for example, `projects/415104041262`). Deleting all
     * labels requires an update mask for labels field.
     * The caller must have `resourcemanager.projects.update` permission for this
     * project.
     * </pre>
     */
    public void updateProject(
        com.google.cloud.resourcemanager.v3.UpdateProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Move a project to another place in your resource hierarchy, under a new
     * resource parent.
     * Returns an operation which can be used to track the process of the project
     * move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved project.
     * The caller must have `resourcemanager.projects.update` permission on the
     * project and have `resourcemanager.projects.move` permission on the
     * project's current and proposed new parent.
     * </pre>
     */
    public void moveProject(
        com.google.cloud.resourcemanager.v3.MoveProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMoveProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the project identified by the specified
     * `name` (for example, `projects/415104041262`) for deletion.
     * This method will only affect the project if it has a lifecycle state of
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
     * This method changes the Project's lifecycle state from
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE]
     * to [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED].
     * The deletion starts at an unspecified time,
     * at which point the Project is no longer accessible.
     * Until the deletion completes, you can check the lifecycle state
     * checked by retrieving the project with [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * and the project remains visible to [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects].
     * However, you cannot update the project.
     * After the deletion completes, the project is not retrievable by
     * the  [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
     * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects]
     * methods.
     * This method behaves idempotently, such that deleting a `DELETE_REQUESTED`
     * project will not cause an error, but also won't do anything.
     * The caller must have `resourcemanager.projects.delete` permissions for this
     * project.
     * </pre>
     */
    public void deleteProject(
        com.google.cloud.resourcemanager.v3.DeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the project identified by the specified
     * `name` (for example, `projects/415104041262`).
     * You can only use this method for a project that has a lifecycle state of
     * [DELETE_REQUESTED]
     * [Projects.State.DELETE_REQUESTED].
     * After deletion starts, the project cannot be restored.
     * The caller must have `resourcemanager.projects.undelete` permission for
     * this project.
     * </pre>
     */
    public void undeleteProject(
        com.google.cloud.resourcemanager.v3.UndeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeleteProjectMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the IAM access control policy for the specified project.
     * Permission is denied if the policy or the resource do not exist.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for the specified project.
     * CAUTION: This method will replace the existing policy, and cannot be used
     * to append additional IAM settings.
     * Note: Removing service accounts from policies or changing their roles can
     * render services completely inoperable. It is important to understand how
     * the service account is being used before removing or updating its roles.
     * The following constraints apply when using `setIamPolicy()`:
     * + Project does not support `allUsers` and `allAuthenticatedUsers` as
     * `members` in a `Binding` of a `Policy`.
     * + The owner role can be granted to a `user`, `serviceAccount`, or a group
     * that is part of an organization. For example,
     * group&#64;myownpersonaldomain.com could be added as an owner to a project in
     * the myownpersonaldomain.com organization, but not the examplepetstore.com
     * organization.
     * + Service accounts can be made owners of a project directly
     * without any restrictions. However, to be added as an owner, a user must be
     * invited using the Cloud Platform console and must accept the invitation.
     * + A user cannot be granted the owner role using `setIamPolicy()`. The user
     * must be granted the owner role using the Cloud Platform Console and must
     * explicitly accept the invitation.
     * + Invitations to grant the owner role cannot be sent using
     * `setIamPolicy()`;
     * they must be sent only using the Cloud Platform Console.
     * + Membership changes that leave the project without any owners that have
     * accepted the Terms of Service (ToS) will be rejected.
     * + If the project is not part of an organization, there must be at least
     * one owner who has accepted the Terms of Service (ToS) agreement in the
     * policy. Calling `setIamPolicy()` to remove the last ToS-accepted owner
     * from the policy will fail. This restriction also applies to legacy
     * projects that no longer have owners who have accepted the ToS. Edits to
     * IAM policies will be rejected until the lack of a ToS-accepting owner is
     * rectified.
     * + Calling this method requires enabling the App Engine Admin API.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified project.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.GetProjectRequest,
                      com.google.cloud.resourcemanager.v3.Project>(this, METHODID_GET_PROJECT)))
          .addMethod(
              getListProjectsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.ListProjectsRequest,
                      com.google.cloud.resourcemanager.v3.ListProjectsResponse>(
                      this, METHODID_LIST_PROJECTS)))
          .addMethod(
              getSearchProjectsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.SearchProjectsRequest,
                      com.google.cloud.resourcemanager.v3.SearchProjectsResponse>(
                      this, METHODID_SEARCH_PROJECTS)))
          .addMethod(
              getCreateProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.CreateProjectRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_PROJECT)))
          .addMethod(
              getUpdateProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.UpdateProjectRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_PROJECT)))
          .addMethod(
              getMoveProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.MoveProjectRequest,
                      com.google.longrunning.Operation>(this, METHODID_MOVE_PROJECT)))
          .addMethod(
              getDeleteProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.DeleteProjectRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_PROJECT)))
          .addMethod(
              getUndeleteProjectMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.resourcemanager.v3.UndeleteProjectRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDELETE_PROJECT)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Google Cloud Projects.
   * </pre>
   */
  public static final class ProjectsStub extends io.grpc.stub.AbstractAsyncStub<ProjectsStub> {
    private ProjectsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the project identified by the specified `name` (for example,
     * `projects/415104041262`).
     * The caller must have `resourcemanager.projects.get` permission
     * for this project.
     * </pre>
     */
    public void getProject(
        com.google.cloud.resourcemanager.v3.GetProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Project> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists projects that are direct children of the specified folder or
     * organization resource. `list()` provides a strongly consistent view of the
     * projects underneath the specified parent resource. `list()` returns
     * projects sorted based upon the (ascending) lexical ordering of their
     * `display_name`. The caller must have `resourcemanager.projects.list`
     * permission on the identified parent.
     * </pre>
     */
    public void listProjects(
        com.google.cloud.resourcemanager.v3.ListProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.ListProjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Search for projects that the caller has both `resourcemanager.projects.get`
     * permission on, and also satisfy the specified query.
     * This method returns projects in an unspecified order.
     * This method is eventually consistent with project mutations; this means
     * that a newly created project may not appear in the results or recent
     * updates to an existing project may not be reflected in the results. To
     * retrieve the latest state of a project, use the
     * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
     * </pre>
     */
    public void searchProjects(
        com.google.cloud.resourcemanager.v3.SearchProjectsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSearchProjectsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Request that a new project be created. The result is an `Operation` which
     * can be used to track the creation process. This process usually takes a few
     * seconds, but can sometimes take much longer. The tracking `Operation` is
     * automatically deleted after a few hours, so there is no need to call
     * `DeleteOperation`.
     * </pre>
     */
    public void createProject(
        com.google.cloud.resourcemanager.v3.CreateProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the `display_name` and labels of the project identified by the
     * specified `name` (for example, `projects/415104041262`). Deleting all
     * labels requires an update mask for labels field.
     * The caller must have `resourcemanager.projects.update` permission for this
     * project.
     * </pre>
     */
    public void updateProject(
        com.google.cloud.resourcemanager.v3.UpdateProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Move a project to another place in your resource hierarchy, under a new
     * resource parent.
     * Returns an operation which can be used to track the process of the project
     * move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved project.
     * The caller must have `resourcemanager.projects.update` permission on the
     * project and have `resourcemanager.projects.move` permission on the
     * project's current and proposed new parent.
     * </pre>
     */
    public void moveProject(
        com.google.cloud.resourcemanager.v3.MoveProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMoveProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks the project identified by the specified
     * `name` (for example, `projects/415104041262`) for deletion.
     * This method will only affect the project if it has a lifecycle state of
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
     * This method changes the Project's lifecycle state from
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE]
     * to [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED].
     * The deletion starts at an unspecified time,
     * at which point the Project is no longer accessible.
     * Until the deletion completes, you can check the lifecycle state
     * checked by retrieving the project with [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * and the project remains visible to [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects].
     * However, you cannot update the project.
     * After the deletion completes, the project is not retrievable by
     * the  [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
     * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects]
     * methods.
     * This method behaves idempotently, such that deleting a `DELETE_REQUESTED`
     * project will not cause an error, but also won't do anything.
     * The caller must have `resourcemanager.projects.delete` permissions for this
     * project.
     * </pre>
     */
    public void deleteProject(
        com.google.cloud.resourcemanager.v3.DeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restores the project identified by the specified
     * `name` (for example, `projects/415104041262`).
     * You can only use this method for a project that has a lifecycle state of
     * [DELETE_REQUESTED]
     * [Projects.State.DELETE_REQUESTED].
     * After deletion starts, the project cannot be restored.
     * The caller must have `resourcemanager.projects.undelete` permission for
     * this project.
     * </pre>
     */
    public void undeleteProject(
        com.google.cloud.resourcemanager.v3.UndeleteProjectRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteProjectMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the IAM access control policy for the specified project.
     * Permission is denied if the policy or the resource do not exist.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for the specified project.
     * CAUTION: This method will replace the existing policy, and cannot be used
     * to append additional IAM settings.
     * Note: Removing service accounts from policies or changing their roles can
     * render services completely inoperable. It is important to understand how
     * the service account is being used before removing or updating its roles.
     * The following constraints apply when using `setIamPolicy()`:
     * + Project does not support `allUsers` and `allAuthenticatedUsers` as
     * `members` in a `Binding` of a `Policy`.
     * + The owner role can be granted to a `user`, `serviceAccount`, or a group
     * that is part of an organization. For example,
     * group&#64;myownpersonaldomain.com could be added as an owner to a project in
     * the myownpersonaldomain.com organization, but not the examplepetstore.com
     * organization.
     * + Service accounts can be made owners of a project directly
     * without any restrictions. However, to be added as an owner, a user must be
     * invited using the Cloud Platform console and must accept the invitation.
     * + A user cannot be granted the owner role using `setIamPolicy()`. The user
     * must be granted the owner role using the Cloud Platform Console and must
     * explicitly accept the invitation.
     * + Invitations to grant the owner role cannot be sent using
     * `setIamPolicy()`;
     * they must be sent only using the Cloud Platform Console.
     * + Membership changes that leave the project without any owners that have
     * accepted the Terms of Service (ToS) will be rejected.
     * + If the project is not part of an organization, there must be at least
     * one owner who has accepted the Terms of Service (ToS) agreement in the
     * policy. Calling `setIamPolicy()` to remove the last ToS-accepted owner
     * from the policy will fail. This restriction also applies to legacy
     * projects that no longer have owners who have accepted the ToS. Edits to
     * IAM policies will be rejected until the lack of a ToS-accepting owner is
     * rectified.
     * + Calling this method requires enabling the App Engine Admin API.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified project.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Google Cloud Projects.
   * </pre>
   */
  public static final class ProjectsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProjectsBlockingStub> {
    private ProjectsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the project identified by the specified `name` (for example,
     * `projects/415104041262`).
     * The caller must have `resourcemanager.projects.get` permission
     * for this project.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.Project getProject(
        com.google.cloud.resourcemanager.v3.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists projects that are direct children of the specified folder or
     * organization resource. `list()` provides a strongly consistent view of the
     * projects underneath the specified parent resource. `list()` returns
     * projects sorted based upon the (ascending) lexical ordering of their
     * `display_name`. The caller must have `resourcemanager.projects.list`
     * permission on the identified parent.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.ListProjectsResponse listProjects(
        com.google.cloud.resourcemanager.v3.ListProjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Search for projects that the caller has both `resourcemanager.projects.get`
     * permission on, and also satisfy the specified query.
     * This method returns projects in an unspecified order.
     * This method is eventually consistent with project mutations; this means
     * that a newly created project may not appear in the results or recent
     * updates to an existing project may not be reflected in the results. To
     * retrieve the latest state of a project, use the
     * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
     * </pre>
     */
    public com.google.cloud.resourcemanager.v3.SearchProjectsResponse searchProjects(
        com.google.cloud.resourcemanager.v3.SearchProjectsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSearchProjectsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Request that a new project be created. The result is an `Operation` which
     * can be used to track the creation process. This process usually takes a few
     * seconds, but can sometimes take much longer. The tracking `Operation` is
     * automatically deleted after a few hours, so there is no need to call
     * `DeleteOperation`.
     * </pre>
     */
    public com.google.longrunning.Operation createProject(
        com.google.cloud.resourcemanager.v3.CreateProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the `display_name` and labels of the project identified by the
     * specified `name` (for example, `projects/415104041262`). Deleting all
     * labels requires an update mask for labels field.
     * The caller must have `resourcemanager.projects.update` permission for this
     * project.
     * </pre>
     */
    public com.google.longrunning.Operation updateProject(
        com.google.cloud.resourcemanager.v3.UpdateProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Move a project to another place in your resource hierarchy, under a new
     * resource parent.
     * Returns an operation which can be used to track the process of the project
     * move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved project.
     * The caller must have `resourcemanager.projects.update` permission on the
     * project and have `resourcemanager.projects.move` permission on the
     * project's current and proposed new parent.
     * </pre>
     */
    public com.google.longrunning.Operation moveProject(
        com.google.cloud.resourcemanager.v3.MoveProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMoveProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the project identified by the specified
     * `name` (for example, `projects/415104041262`) for deletion.
     * This method will only affect the project if it has a lifecycle state of
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
     * This method changes the Project's lifecycle state from
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE]
     * to [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED].
     * The deletion starts at an unspecified time,
     * at which point the Project is no longer accessible.
     * Until the deletion completes, you can check the lifecycle state
     * checked by retrieving the project with [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * and the project remains visible to [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects].
     * However, you cannot update the project.
     * After the deletion completes, the project is not retrievable by
     * the  [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
     * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects]
     * methods.
     * This method behaves idempotently, such that deleting a `DELETE_REQUESTED`
     * project will not cause an error, but also won't do anything.
     * The caller must have `resourcemanager.projects.delete` permissions for this
     * project.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProject(
        com.google.cloud.resourcemanager.v3.DeleteProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the project identified by the specified
     * `name` (for example, `projects/415104041262`).
     * You can only use this method for a project that has a lifecycle state of
     * [DELETE_REQUESTED]
     * [Projects.State.DELETE_REQUESTED].
     * After deletion starts, the project cannot be restored.
     * The caller must have `resourcemanager.projects.undelete` permission for
     * this project.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteProject(
        com.google.cloud.resourcemanager.v3.UndeleteProjectRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteProjectMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the IAM access control policy for the specified project.
     * Permission is denied if the policy or the resource do not exist.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for the specified project.
     * CAUTION: This method will replace the existing policy, and cannot be used
     * to append additional IAM settings.
     * Note: Removing service accounts from policies or changing their roles can
     * render services completely inoperable. It is important to understand how
     * the service account is being used before removing or updating its roles.
     * The following constraints apply when using `setIamPolicy()`:
     * + Project does not support `allUsers` and `allAuthenticatedUsers` as
     * `members` in a `Binding` of a `Policy`.
     * + The owner role can be granted to a `user`, `serviceAccount`, or a group
     * that is part of an organization. For example,
     * group&#64;myownpersonaldomain.com could be added as an owner to a project in
     * the myownpersonaldomain.com organization, but not the examplepetstore.com
     * organization.
     * + Service accounts can be made owners of a project directly
     * without any restrictions. However, to be added as an owner, a user must be
     * invited using the Cloud Platform console and must accept the invitation.
     * + A user cannot be granted the owner role using `setIamPolicy()`. The user
     * must be granted the owner role using the Cloud Platform Console and must
     * explicitly accept the invitation.
     * + Invitations to grant the owner role cannot be sent using
     * `setIamPolicy()`;
     * they must be sent only using the Cloud Platform Console.
     * + Membership changes that leave the project without any owners that have
     * accepted the Terms of Service (ToS) will be rejected.
     * + If the project is not part of an organization, there must be at least
     * one owner who has accepted the Terms of Service (ToS) agreement in the
     * policy. Calling `setIamPolicy()` to remove the last ToS-accepted owner
     * from the policy will fail. This restriction also applies to legacy
     * projects that no longer have owners who have accepted the ToS. Edits to
     * IAM policies will be rejected until the lack of a ToS-accepting owner is
     * rectified.
     * + Calling this method requires enabling the App Engine Admin API.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified project.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Manages Google Cloud Projects.
   * </pre>
   */
  public static final class ProjectsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProjectsFutureStub> {
    private ProjectsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProjectsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProjectsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the project identified by the specified `name` (for example,
     * `projects/415104041262`).
     * The caller must have `resourcemanager.projects.get` permission
     * for this project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.Project>
        getProject(com.google.cloud.resourcemanager.v3.GetProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists projects that are direct children of the specified folder or
     * organization resource. `list()` provides a strongly consistent view of the
     * projects underneath the specified parent resource. `list()` returns
     * projects sorted based upon the (ascending) lexical ordering of their
     * `display_name`. The caller must have `resourcemanager.projects.list`
     * permission on the identified parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.ListProjectsResponse>
        listProjects(com.google.cloud.resourcemanager.v3.ListProjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Search for projects that the caller has both `resourcemanager.projects.get`
     * permission on, and also satisfy the specified query.
     * This method returns projects in an unspecified order.
     * This method is eventually consistent with project mutations; this means
     * that a newly created project may not appear in the results or recent
     * updates to an existing project may not be reflected in the results. To
     * retrieve the latest state of a project, use the
     * [GetProject][google.cloud.resourcemanager.v3.Projects.GetProject] method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.resourcemanager.v3.SearchProjectsResponse>
        searchProjects(com.google.cloud.resourcemanager.v3.SearchProjectsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSearchProjectsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Request that a new project be created. The result is an `Operation` which
     * can be used to track the creation process. This process usually takes a few
     * seconds, but can sometimes take much longer. The tracking `Operation` is
     * automatically deleted after a few hours, so there is no need to call
     * `DeleteOperation`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createProject(com.google.cloud.resourcemanager.v3.CreateProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the `display_name` and labels of the project identified by the
     * specified `name` (for example, `projects/415104041262`). Deleting all
     * labels requires an update mask for labels field.
     * The caller must have `resourcemanager.projects.update` permission for this
     * project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateProject(com.google.cloud.resourcemanager.v3.UpdateProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Move a project to another place in your resource hierarchy, under a new
     * resource parent.
     * Returns an operation which can be used to track the process of the project
     * move workflow.
     * Upon success, the `Operation.response` field will be populated with the
     * moved project.
     * The caller must have `resourcemanager.projects.update` permission on the
     * project and have `resourcemanager.projects.move` permission on the
     * project's current and proposed new parent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        moveProject(com.google.cloud.resourcemanager.v3.MoveProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMoveProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks the project identified by the specified
     * `name` (for example, `projects/415104041262`) for deletion.
     * This method will only affect the project if it has a lifecycle state of
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE].
     * This method changes the Project's lifecycle state from
     * [ACTIVE][google.cloud.resourcemanager.v3.Project.State.ACTIVE]
     * to [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Project.State.DELETE_REQUESTED].
     * The deletion starts at an unspecified time,
     * at which point the Project is no longer accessible.
     * Until the deletion completes, you can check the lifecycle state
     * checked by retrieving the project with [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * and the project remains visible to [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects].
     * However, you cannot update the project.
     * After the deletion completes, the project is not retrievable by
     * the  [GetProject]
     * [google.cloud.resourcemanager.v3.Projects.GetProject],
     * [ListProjects]
     * [google.cloud.resourcemanager.v3.Projects.ListProjects], and
     * [SearchProjects][google.cloud.resourcemanager.v3.Projects.SearchProjects]
     * methods.
     * This method behaves idempotently, such that deleting a `DELETE_REQUESTED`
     * project will not cause an error, but also won't do anything.
     * The caller must have `resourcemanager.projects.delete` permissions for this
     * project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProject(com.google.cloud.resourcemanager.v3.DeleteProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restores the project identified by the specified
     * `name` (for example, `projects/415104041262`).
     * You can only use this method for a project that has a lifecycle state of
     * [DELETE_REQUESTED]
     * [Projects.State.DELETE_REQUESTED].
     * After deletion starts, the project cannot be restored.
     * The caller must have `resourcemanager.projects.undelete` permission for
     * this project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeleteProject(com.google.cloud.resourcemanager.v3.UndeleteProjectRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteProjectMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the IAM access control policy for the specified project.
     * Permission is denied if the policy or the resource do not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM access control policy for the specified project.
     * CAUTION: This method will replace the existing policy, and cannot be used
     * to append additional IAM settings.
     * Note: Removing service accounts from policies or changing their roles can
     * render services completely inoperable. It is important to understand how
     * the service account is being used before removing or updating its roles.
     * The following constraints apply when using `setIamPolicy()`:
     * + Project does not support `allUsers` and `allAuthenticatedUsers` as
     * `members` in a `Binding` of a `Policy`.
     * + The owner role can be granted to a `user`, `serviceAccount`, or a group
     * that is part of an organization. For example,
     * group&#64;myownpersonaldomain.com could be added as an owner to a project in
     * the myownpersonaldomain.com organization, but not the examplepetstore.com
     * organization.
     * + Service accounts can be made owners of a project directly
     * without any restrictions. However, to be added as an owner, a user must be
     * invited using the Cloud Platform console and must accept the invitation.
     * + A user cannot be granted the owner role using `setIamPolicy()`. The user
     * must be granted the owner role using the Cloud Platform Console and must
     * explicitly accept the invitation.
     * + Invitations to grant the owner role cannot be sent using
     * `setIamPolicy()`;
     * they must be sent only using the Cloud Platform Console.
     * + Membership changes that leave the project without any owners that have
     * accepted the Terms of Service (ToS) will be rejected.
     * + If the project is not part of an organization, there must be at least
     * one owner who has accepted the Terms of Service (ToS) agreement in the
     * policy. Calling `setIamPolicy()` to remove the last ToS-accepted owner
     * from the policy will fail. This restriction also applies to legacy
     * projects that no longer have owners who have accepted the ToS. Edits to
     * IAM policies will be rejected until the lack of a ToS-accepting owner is
     * rectified.
     * + Calling this method requires enabling the App Engine Admin API.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns permissions that a caller has on the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROJECT = 0;
  private static final int METHODID_LIST_PROJECTS = 1;
  private static final int METHODID_SEARCH_PROJECTS = 2;
  private static final int METHODID_CREATE_PROJECT = 3;
  private static final int METHODID_UPDATE_PROJECT = 4;
  private static final int METHODID_MOVE_PROJECT = 5;
  private static final int METHODID_DELETE_PROJECT = 6;
  private static final int METHODID_UNDELETE_PROJECT = 7;
  private static final int METHODID_GET_IAM_POLICY = 8;
  private static final int METHODID_SET_IAM_POLICY = 9;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 10;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProjectsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProjectsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROJECT:
          serviceImpl.getProject(
              (com.google.cloud.resourcemanager.v3.GetProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.resourcemanager.v3.Project>)
                  responseObserver);
          break;
        case METHODID_LIST_PROJECTS:
          serviceImpl.listProjects(
              (com.google.cloud.resourcemanager.v3.ListProjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.ListProjectsResponse>)
                  responseObserver);
          break;
        case METHODID_SEARCH_PROJECTS:
          serviceImpl.searchProjects(
              (com.google.cloud.resourcemanager.v3.SearchProjectsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.resourcemanager.v3.SearchProjectsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PROJECT:
          serviceImpl.createProject(
              (com.google.cloud.resourcemanager.v3.CreateProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PROJECT:
          serviceImpl.updateProject(
              (com.google.cloud.resourcemanager.v3.UpdateProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MOVE_PROJECT:
          serviceImpl.moveProject(
              (com.google.cloud.resourcemanager.v3.MoveProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PROJECT:
          serviceImpl.deleteProject(
              (com.google.cloud.resourcemanager.v3.DeleteProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_PROJECT:
          serviceImpl.undeleteProject(
              (com.google.cloud.resourcemanager.v3.UndeleteProjectRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
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

  private abstract static class ProjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProjectsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.resourcemanager.v3.ProjectsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Projects");
    }
  }

  private static final class ProjectsFileDescriptorSupplier extends ProjectsBaseDescriptorSupplier {
    ProjectsFileDescriptorSupplier() {}
  }

  private static final class ProjectsMethodDescriptorSupplier extends ProjectsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProjectsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProjectsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProjectsFileDescriptorSupplier())
                      .addMethod(getGetProjectMethod())
                      .addMethod(getListProjectsMethod())
                      .addMethod(getSearchProjectsMethod())
                      .addMethod(getCreateProjectMethod())
                      .addMethod(getUpdateProjectMethod())
                      .addMethod(getMoveProjectMethod())
                      .addMethod(getDeleteProjectMethod())
                      .addMethod(getUndeleteProjectMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
