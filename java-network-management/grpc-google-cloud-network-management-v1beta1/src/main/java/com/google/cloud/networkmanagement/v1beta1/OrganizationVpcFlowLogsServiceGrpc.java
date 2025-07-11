/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.networkmanagement.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The VPC Flow Logs organization service in the Google Cloud Network Management
 * API provides organization level configurations that generate Flow Logs. The
 * service and the configuration resources created using this service are
 * global.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkmanagement/v1beta1/vpc_flow_logs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrganizationVpcFlowLogsServiceGrpc {

  private OrganizationVpcFlowLogsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest,
          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
      getListVpcFlowLogsConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVpcFlowLogsConfigs",
      requestType = com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest.class,
      responseType =
          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest,
          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
      getListVpcFlowLogsConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest,
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
        getListVpcFlowLogsConfigsMethod;
    if ((getListVpcFlowLogsConfigsMethod =
            OrganizationVpcFlowLogsServiceGrpc.getListVpcFlowLogsConfigsMethod)
        == null) {
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        if ((getListVpcFlowLogsConfigsMethod =
                OrganizationVpcFlowLogsServiceGrpc.getListVpcFlowLogsConfigsMethod)
            == null) {
          OrganizationVpcFlowLogsServiceGrpc.getListVpcFlowLogsConfigsMethod =
              getListVpcFlowLogsConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest,
                          com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVpcFlowLogsConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1
                                  .ListVpcFlowLogsConfigsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1
                                  .ListVpcFlowLogsConfigsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(
                              "ListVpcFlowLogsConfigs"))
                      .build();
        }
      }
    }
    return getListVpcFlowLogsConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest,
          com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
      getGetVpcFlowLogsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVpcFlowLogsConfig",
      requestType = com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest.class,
      responseType = com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest,
          com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
      getGetVpcFlowLogsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest,
            com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
        getGetVpcFlowLogsConfigMethod;
    if ((getGetVpcFlowLogsConfigMethod =
            OrganizationVpcFlowLogsServiceGrpc.getGetVpcFlowLogsConfigMethod)
        == null) {
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        if ((getGetVpcFlowLogsConfigMethod =
                OrganizationVpcFlowLogsServiceGrpc.getGetVpcFlowLogsConfigMethod)
            == null) {
          OrganizationVpcFlowLogsServiceGrpc.getGetVpcFlowLogsConfigMethod =
              getGetVpcFlowLogsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest,
                          com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetVpcFlowLogsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(
                              "GetVpcFlowLogsConfig"))
                      .build();
        }
      }
    }
    return getGetVpcFlowLogsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getCreateVpcFlowLogsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVpcFlowLogsConfig",
      requestType = com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getCreateVpcFlowLogsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest,
            com.google.longrunning.Operation>
        getCreateVpcFlowLogsConfigMethod;
    if ((getCreateVpcFlowLogsConfigMethod =
            OrganizationVpcFlowLogsServiceGrpc.getCreateVpcFlowLogsConfigMethod)
        == null) {
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        if ((getCreateVpcFlowLogsConfigMethod =
                OrganizationVpcFlowLogsServiceGrpc.getCreateVpcFlowLogsConfigMethod)
            == null) {
          OrganizationVpcFlowLogsServiceGrpc.getCreateVpcFlowLogsConfigMethod =
              getCreateVpcFlowLogsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateVpcFlowLogsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1
                                  .CreateVpcFlowLogsConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(
                              "CreateVpcFlowLogsConfig"))
                      .build();
        }
      }
    }
    return getCreateVpcFlowLogsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getUpdateVpcFlowLogsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVpcFlowLogsConfig",
      requestType = com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getUpdateVpcFlowLogsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest,
            com.google.longrunning.Operation>
        getUpdateVpcFlowLogsConfigMethod;
    if ((getUpdateVpcFlowLogsConfigMethod =
            OrganizationVpcFlowLogsServiceGrpc.getUpdateVpcFlowLogsConfigMethod)
        == null) {
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        if ((getUpdateVpcFlowLogsConfigMethod =
                OrganizationVpcFlowLogsServiceGrpc.getUpdateVpcFlowLogsConfigMethod)
            == null) {
          OrganizationVpcFlowLogsServiceGrpc.getUpdateVpcFlowLogsConfigMethod =
              getUpdateVpcFlowLogsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateVpcFlowLogsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1
                                  .UpdateVpcFlowLogsConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(
                              "UpdateVpcFlowLogsConfig"))
                      .build();
        }
      }
    }
    return getUpdateVpcFlowLogsConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getDeleteVpcFlowLogsConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVpcFlowLogsConfig",
      requestType = com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest,
          com.google.longrunning.Operation>
      getDeleteVpcFlowLogsConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest,
            com.google.longrunning.Operation>
        getDeleteVpcFlowLogsConfigMethod;
    if ((getDeleteVpcFlowLogsConfigMethod =
            OrganizationVpcFlowLogsServiceGrpc.getDeleteVpcFlowLogsConfigMethod)
        == null) {
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        if ((getDeleteVpcFlowLogsConfigMethod =
                OrganizationVpcFlowLogsServiceGrpc.getDeleteVpcFlowLogsConfigMethod)
            == null) {
          OrganizationVpcFlowLogsServiceGrpc.getDeleteVpcFlowLogsConfigMethod =
              getDeleteVpcFlowLogsConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteVpcFlowLogsConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkmanagement.v1beta1
                                  .DeleteVpcFlowLogsConfigRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(
                              "DeleteVpcFlowLogsConfig"))
                      .build();
        }
      }
    }
    return getDeleteVpcFlowLogsConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrganizationVpcFlowLogsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceStub>() {
          @java.lang.Override
          public OrganizationVpcFlowLogsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationVpcFlowLogsServiceStub(channel, callOptions);
          }
        };
    return OrganizationVpcFlowLogsServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OrganizationVpcFlowLogsServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceBlockingV2Stub>() {
          @java.lang.Override
          public OrganizationVpcFlowLogsServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationVpcFlowLogsServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OrganizationVpcFlowLogsServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrganizationVpcFlowLogsServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceBlockingStub>() {
          @java.lang.Override
          public OrganizationVpcFlowLogsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationVpcFlowLogsServiceBlockingStub(channel, callOptions);
          }
        };
    return OrganizationVpcFlowLogsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrganizationVpcFlowLogsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrganizationVpcFlowLogsServiceFutureStub>() {
          @java.lang.Override
          public OrganizationVpcFlowLogsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrganizationVpcFlowLogsServiceFutureStub(channel, callOptions);
          }
        };
    return OrganizationVpcFlowLogsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists all `VpcFlowLogsConfigs` in a given organization.
     * </pre>
     */
    default void listVpcFlowLogsConfigs(
        com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVpcFlowLogsConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    default void getVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVpcFlowLogsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Creating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - creating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    default void createVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVpcFlowLogsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Updating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - updating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    default void updateVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVpcFlowLogsConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    default void deleteVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVpcFlowLogsConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrganizationVpcFlowLogsService.
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public abstract static class OrganizationVpcFlowLogsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrganizationVpcFlowLogsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OrganizationVpcFlowLogsService.
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public static final class OrganizationVpcFlowLogsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrganizationVpcFlowLogsServiceStub> {
    private OrganizationVpcFlowLogsServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationVpcFlowLogsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationVpcFlowLogsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all `VpcFlowLogsConfigs` in a given organization.
     * </pre>
     */
    public void listVpcFlowLogsConfigs(
        com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVpcFlowLogsConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public void getVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVpcFlowLogsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Creating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - creating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public void createVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVpcFlowLogsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Updating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - updating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public void updateVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVpcFlowLogsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public void deleteVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVpcFlowLogsConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OrganizationVpcFlowLogsService.
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public static final class OrganizationVpcFlowLogsServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrganizationVpcFlowLogsServiceBlockingV2Stub> {
    private OrganizationVpcFlowLogsServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationVpcFlowLogsServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationVpcFlowLogsServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all `VpcFlowLogsConfigs` in a given organization.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse
        listVpcFlowLogsConfigs(
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVpcFlowLogsConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig getVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Creating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - creating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.longrunning.Operation createVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Updating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - updating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.longrunning.Operation updateVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * OrganizationVpcFlowLogsService.
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public static final class OrganizationVpcFlowLogsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrganizationVpcFlowLogsServiceBlockingStub> {
    private OrganizationVpcFlowLogsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationVpcFlowLogsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationVpcFlowLogsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all `VpcFlowLogsConfigs` in a given organization.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse
        listVpcFlowLogsConfigs(
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVpcFlowLogsConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig getVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Creating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - creating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.longrunning.Operation createVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Updating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - updating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.longrunning.Operation updateVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVpcFlowLogsConfig(
        com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVpcFlowLogsConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OrganizationVpcFlowLogsService.
   *
   * <pre>
   * The VPC Flow Logs organization service in the Google Cloud Network Management
   * API provides organization level configurations that generate Flow Logs. The
   * service and the configuration resources created using this service are
   * global.
   * </pre>
   */
  public static final class OrganizationVpcFlowLogsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrganizationVpcFlowLogsServiceFutureStub> {
    private OrganizationVpcFlowLogsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrganizationVpcFlowLogsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrganizationVpcFlowLogsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists all `VpcFlowLogsConfigs` in a given organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>
        listVpcFlowLogsConfigs(
            com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVpcFlowLogsConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the details of a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>
        getVpcFlowLogsConfig(
            com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVpcFlowLogsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Creating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - creating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createVpcFlowLogsConfig(
            com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVpcFlowLogsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an existing `VpcFlowLogsConfig`.
     * If a configuration with the exact same settings already exists (even if the
     * ID is different), the creation fails.
     * Notes:
     *   1. Updating a configuration with `state=DISABLED` will fail
     *   2. The following fields are not considered as settings for the purpose
     *   of the check mentioned above, therefore - updating another configuration
     *   with the same fields but different values for the following fields will
     *   fail as well:
     *       * name
     *       * create_time
     *       * update_time
     *       * labels
     *       * description
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateVpcFlowLogsConfig(
            com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVpcFlowLogsConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific `VpcFlowLogsConfig`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteVpcFlowLogsConfig(
            com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVpcFlowLogsConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VPC_FLOW_LOGS_CONFIGS = 0;
  private static final int METHODID_GET_VPC_FLOW_LOGS_CONFIG = 1;
  private static final int METHODID_CREATE_VPC_FLOW_LOGS_CONFIG = 2;
  private static final int METHODID_UPDATE_VPC_FLOW_LOGS_CONFIG = 3;
  private static final int METHODID_DELETE_VPC_FLOW_LOGS_CONFIG = 4;

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
        case METHODID_LIST_VPC_FLOW_LOGS_CONFIGS:
          serviceImpl.listVpcFlowLogsConfigs(
              (com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VPC_FLOW_LOGS_CONFIG:
          serviceImpl.getVpcFlowLogsConfig(
              (com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>)
                  responseObserver);
          break;
        case METHODID_CREATE_VPC_FLOW_LOGS_CONFIG:
          serviceImpl.createVpcFlowLogsConfig(
              (com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VPC_FLOW_LOGS_CONFIG:
          serviceImpl.updateVpcFlowLogsConfig(
              (com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VPC_FLOW_LOGS_CONFIG:
          serviceImpl.deleteVpcFlowLogsConfig(
              (com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest) request,
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
            getListVpcFlowLogsConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsRequest,
                    com.google.cloud.networkmanagement.v1beta1.ListVpcFlowLogsConfigsResponse>(
                    service, METHODID_LIST_VPC_FLOW_LOGS_CONFIGS)))
        .addMethod(
            getGetVpcFlowLogsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkmanagement.v1beta1.GetVpcFlowLogsConfigRequest,
                    com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsConfig>(
                    service, METHODID_GET_VPC_FLOW_LOGS_CONFIG)))
        .addMethod(
            getCreateVpcFlowLogsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkmanagement.v1beta1.CreateVpcFlowLogsConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_VPC_FLOW_LOGS_CONFIG)))
        .addMethod(
            getUpdateVpcFlowLogsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkmanagement.v1beta1.UpdateVpcFlowLogsConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_VPC_FLOW_LOGS_CONFIG)))
        .addMethod(
            getDeleteVpcFlowLogsConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkmanagement.v1beta1.DeleteVpcFlowLogsConfigRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_VPC_FLOW_LOGS_CONFIG)))
        .build();
  }

  private abstract static class OrganizationVpcFlowLogsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrganizationVpcFlowLogsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrganizationVpcFlowLogsService");
    }
  }

  private static final class OrganizationVpcFlowLogsServiceFileDescriptorSupplier
      extends OrganizationVpcFlowLogsServiceBaseDescriptorSupplier {
    OrganizationVpcFlowLogsServiceFileDescriptorSupplier() {}
  }

  private static final class OrganizationVpcFlowLogsServiceMethodDescriptorSupplier
      extends OrganizationVpcFlowLogsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrganizationVpcFlowLogsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrganizationVpcFlowLogsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new OrganizationVpcFlowLogsServiceFileDescriptorSupplier())
                      .addMethod(getListVpcFlowLogsConfigsMethod())
                      .addMethod(getGetVpcFlowLogsConfigMethod())
                      .addMethod(getCreateVpcFlowLogsConfigMethod())
                      .addMethod(getUpdateVpcFlowLogsConfigMethod())
                      .addMethod(getDeleteVpcFlowLogsConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
