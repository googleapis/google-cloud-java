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
package com.google.cloud.run.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Cloud Run Service Control Plane API
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/run/v2/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServicesGrpc {

  private ServicesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.run.v2.Services";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.cloud.run.v2.CreateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.CreateServiceRequest, com.google.longrunning.Operation>
      getCreateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.CreateServiceRequest, com.google.longrunning.Operation>
        getCreateServiceMethod;
    if ((getCreateServiceMethod = ServicesGrpc.getCreateServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getCreateServiceMethod = ServicesGrpc.getCreateServiceMethod) == null) {
          ServicesGrpc.getCreateServiceMethod =
              getCreateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.CreateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.CreateServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("CreateService"))
                      .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetServiceRequest, com.google.cloud.run.v2.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.run.v2.GetServiceRequest.class,
      responseType = com.google.cloud.run.v2.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.GetServiceRequest, com.google.cloud.run.v2.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.GetServiceRequest, com.google.cloud.run.v2.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = ServicesGrpc.getGetServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getGetServiceMethod = ServicesGrpc.getGetServiceMethod) == null) {
          ServicesGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.GetServiceRequest, com.google.cloud.run.v2.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.GetServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.Service.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListServicesRequest, com.google.cloud.run.v2.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.run.v2.ListServicesRequest.class,
      responseType = com.google.cloud.run.v2.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.ListServicesRequest, com.google.cloud.run.v2.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.ListServicesRequest,
            com.google.cloud.run.v2.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = ServicesGrpc.getListServicesMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getListServicesMethod = ServicesGrpc.getListServicesMethod) == null) {
          ServicesGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.ListServicesRequest,
                          com.google.cloud.run.v2.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListServicesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.ListServicesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.cloud.run.v2.UpdateServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.UpdateServiceRequest, com.google.longrunning.Operation>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.UpdateServiceRequest, com.google.longrunning.Operation>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = ServicesGrpc.getUpdateServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getUpdateServiceMethod = ServicesGrpc.getUpdateServiceMethod) == null) {
          ServicesGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.UpdateServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.UpdateServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.cloud.run.v2.DeleteServiceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.run.v2.DeleteServiceRequest, com.google.longrunning.Operation>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.run.v2.DeleteServiceRequest, com.google.longrunning.Operation>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServicesGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getDeleteServiceMethod = ServicesGrpc.getDeleteServiceMethod) == null) {
          ServicesGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.run.v2.DeleteServiceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.run.v2.DeleteServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
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
    if ((getGetIamPolicyMethod = ServicesGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getGetIamPolicyMethod = ServicesGrpc.getGetIamPolicyMethod) == null) {
          ServicesGrpc.getGetIamPolicyMethod =
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
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = ServicesGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getSetIamPolicyMethod = ServicesGrpc.getSetIamPolicyMethod) == null) {
          ServicesGrpc.getSetIamPolicyMethod =
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
                      .setSchemaDescriptor(new ServicesMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = ServicesGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ServicesGrpc.class) {
        if ((getTestIamPermissionsMethod = ServicesGrpc.getTestIamPermissionsMethod) == null) {
          ServicesGrpc.getTestIamPermissionsMethod =
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
                          new ServicesMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServicesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesStub>() {
          @java.lang.Override
          public ServicesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesStub(channel, callOptions);
          }
        };
    return ServicesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServicesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesBlockingStub>() {
          @java.lang.Override
          public ServicesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesBlockingStub(channel, callOptions);
          }
        };
    return ServicesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServicesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServicesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServicesFutureStub>() {
          @java.lang.Override
          public ServicesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServicesFutureStub(channel, callOptions);
          }
        };
    return ServicesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Cloud Run Service Control Plane API
   * </pre>
   */
  public abstract static class ServicesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public void createService(
        com.google.cloud.run.v2.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Service.
     * </pre>
     */
    public void getService(
        com.google.cloud.run.v2.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Services.
     * </pre>
     */
    public void listServices(
        com.google.cloud.run.v2.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.run.v2.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Service.
     * This will cause the Service to stop serving traffic and will delete all
     * revisions.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.run.v2.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given
     * Cloud Run Service. This result does not include any inherited policies.
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
     * Sets the IAM Access control policy for the specified Service. Overwrites
     * any existing policy.
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
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
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
              getCreateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.CreateServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_SERVICE)))
          .addMethod(
              getGetServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.GetServiceRequest, com.google.cloud.run.v2.Service>(
                      this, METHODID_GET_SERVICE)))
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.ListServicesRequest,
                      com.google.cloud.run.v2.ListServicesResponse>(this, METHODID_LIST_SERVICES)))
          .addMethod(
              getUpdateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.UpdateServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.run.v2.DeleteServiceRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_SERVICE)))
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
   * Cloud Run Service Control Plane API
   * </pre>
   */
  public static final class ServicesStub extends io.grpc.stub.AbstractAsyncStub<ServicesStub> {
    private ServicesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public void createService(
        com.google.cloud.run.v2.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Service.
     * </pre>
     */
    public void getService(
        com.google.cloud.run.v2.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Services.
     * </pre>
     */
    public void listServices(
        com.google.cloud.run.v2.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a Service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.run.v2.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Service.
     * This will cause the Service to stop serving traffic and will delete all
     * revisions.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.run.v2.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given
     * Cloud Run Service. This result does not include any inherited policies.
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
     * Sets the IAM Access control policy for the specified Service. Overwrites
     * any existing policy.
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
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
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
   * Cloud Run Service Control Plane API
   * </pre>
   */
  public static final class ServicesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServicesBlockingStub> {
    private ServicesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createService(
        com.google.cloud.run.v2.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Service.
     * </pre>
     */
    public com.google.cloud.run.v2.Service getService(
        com.google.cloud.run.v2.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Services.
     * </pre>
     */
    public com.google.cloud.run.v2.ListServicesResponse listServices(
        com.google.cloud.run.v2.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Service.
     * </pre>
     */
    public com.google.longrunning.Operation updateService(
        com.google.cloud.run.v2.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Service.
     * This will cause the Service to stop serving traffic and will delete all
     * revisions.
     * </pre>
     */
    public com.google.longrunning.Operation deleteService(
        com.google.cloud.run.v2.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given
     * Cloud Run Service. This result does not include any inherited policies.
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
     * Sets the IAM Access control policy for the specified Service. Overwrites
     * any existing policy.
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
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
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
   * Cloud Run Service Control Plane API
   * </pre>
   */
  public static final class ServicesFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServicesFutureStub> {
    private ServicesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServicesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServicesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Service in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createService(com.google.cloud.run.v2.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets information about a Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.run.v2.Service>
        getService(com.google.cloud.run.v2.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Services.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.run.v2.ListServicesResponse>
        listServices(com.google.cloud.run.v2.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateService(com.google.cloud.run.v2.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Service.
     * This will cause the Service to stop serving traffic and will delete all
     * revisions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteService(com.google.cloud.run.v2.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the IAM Access Control policy currently in effect for the given
     * Cloud Run Service. This result does not include any inherited policies.
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
     * Sets the IAM Access control policy for the specified Service. Overwrites
     * any existing policy.
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
     * Returns permissions that a caller has on the specified Project.
     * There are no permissions required for making this API call.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVICE = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_LIST_SERVICES = 2;
  private static final int METHODID_UPDATE_SERVICE = 3;
  private static final int METHODID_DELETE_SERVICE = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServicesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServicesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService(
              (com.google.cloud.run.v2.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.cloud.run.v2.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.Service>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.run.v2.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.run.v2.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.cloud.run.v2.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.cloud.run.v2.DeleteServiceRequest) request,
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

  private abstract static class ServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServicesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.run.v2.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Services");
    }
  }

  private static final class ServicesFileDescriptorSupplier extends ServicesBaseDescriptorSupplier {
    ServicesFileDescriptorSupplier() {}
  }

  private static final class ServicesMethodDescriptorSupplier extends ServicesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServicesMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServicesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServicesFileDescriptorSupplier())
                      .addMethod(getCreateServiceMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getListServicesMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
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
