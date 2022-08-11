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
package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The AlertPolicyService API is used to manage (list, create, delete,
 * edit) alert policies in Cloud Monitoring. An alerting policy is
 * a description of the conditions under which some aspect of your
 * system is considered to be "unhealthy" and the ways to notify
 * people or services about this state. In addition to using this API, alert
 * policies can also be managed through
 * [Cloud Monitoring](https://cloud.google.com/monitoring/docs/),
 * which can be reached by clicking the "Monitoring" tab in
 * [Cloud console](https://console.cloud.google.com/).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/alert_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AlertPolicyServiceGrpc {

  private AlertPolicyServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.AlertPolicyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListAlertPoliciesRequest,
          com.google.monitoring.v3.ListAlertPoliciesResponse>
      getListAlertPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAlertPolicies",
      requestType = com.google.monitoring.v3.ListAlertPoliciesRequest.class,
      responseType = com.google.monitoring.v3.ListAlertPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListAlertPoliciesRequest,
          com.google.monitoring.v3.ListAlertPoliciesResponse>
      getListAlertPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListAlertPoliciesRequest,
            com.google.monitoring.v3.ListAlertPoliciesResponse>
        getListAlertPoliciesMethod;
    if ((getListAlertPoliciesMethod = AlertPolicyServiceGrpc.getListAlertPoliciesMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getListAlertPoliciesMethod = AlertPolicyServiceGrpc.getListAlertPoliciesMethod)
            == null) {
          AlertPolicyServiceGrpc.getListAlertPoliciesMethod =
              getListAlertPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListAlertPoliciesRequest,
                          com.google.monitoring.v3.ListAlertPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAlertPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListAlertPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListAlertPoliciesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlertPolicyServiceMethodDescriptorSupplier("ListAlertPolicies"))
                      .build();
        }
      }
    }
    return getListAlertPoliciesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getGetAlertPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAlertPolicy",
      requestType = com.google.monitoring.v3.GetAlertPolicyRequest.class,
      responseType = com.google.monitoring.v3.AlertPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getGetAlertPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.GetAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
        getGetAlertPolicyMethod;
    if ((getGetAlertPolicyMethod = AlertPolicyServiceGrpc.getGetAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getGetAlertPolicyMethod = AlertPolicyServiceGrpc.getGetAlertPolicyMethod) == null) {
          AlertPolicyServiceGrpc.getGetAlertPolicyMethod =
              getGetAlertPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.GetAlertPolicyRequest,
                          com.google.monitoring.v3.AlertPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAlertPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.GetAlertPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlertPolicyServiceMethodDescriptorSupplier("GetAlertPolicy"))
                      .build();
        }
      }
    }
    return getGetAlertPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getCreateAlertPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAlertPolicy",
      requestType = com.google.monitoring.v3.CreateAlertPolicyRequest.class,
      responseType = com.google.monitoring.v3.AlertPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getCreateAlertPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.CreateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
        getCreateAlertPolicyMethod;
    if ((getCreateAlertPolicyMethod = AlertPolicyServiceGrpc.getCreateAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getCreateAlertPolicyMethod = AlertPolicyServiceGrpc.getCreateAlertPolicyMethod)
            == null) {
          AlertPolicyServiceGrpc.getCreateAlertPolicyMethod =
              getCreateAlertPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.CreateAlertPolicyRequest,
                          com.google.monitoring.v3.AlertPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAlertPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.CreateAlertPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlertPolicyServiceMethodDescriptorSupplier("CreateAlertPolicy"))
                      .build();
        }
      }
    }
    return getCreateAlertPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty>
      getDeleteAlertPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAlertPolicy",
      requestType = com.google.monitoring.v3.DeleteAlertPolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty>
      getDeleteAlertPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty>
        getDeleteAlertPolicyMethod;
    if ((getDeleteAlertPolicyMethod = AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getDeleteAlertPolicyMethod = AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod)
            == null) {
          AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod =
              getDeleteAlertPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.DeleteAlertPolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAlertPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.DeleteAlertPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlertPolicyServiceMethodDescriptorSupplier("DeleteAlertPolicy"))
                      .build();
        }
      }
    }
    return getDeleteAlertPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getUpdateAlertPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAlertPolicy",
      requestType = com.google.monitoring.v3.UpdateAlertPolicyRequest.class,
      responseType = com.google.monitoring.v3.AlertPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
      getUpdateAlertPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.UpdateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>
        getUpdateAlertPolicyMethod;
    if ((getUpdateAlertPolicyMethod = AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getUpdateAlertPolicyMethod = AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod)
            == null) {
          AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod =
              getUpdateAlertPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.UpdateAlertPolicyRequest,
                          com.google.monitoring.v3.AlertPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAlertPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UpdateAlertPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AlertPolicyServiceMethodDescriptorSupplier("UpdateAlertPolicy"))
                      .build();
        }
      }
    }
    return getUpdateAlertPolicyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AlertPolicyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceStub>() {
          @java.lang.Override
          public AlertPolicyServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlertPolicyServiceStub(channel, callOptions);
          }
        };
    return AlertPolicyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertPolicyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceBlockingStub>() {
          @java.lang.Override
          public AlertPolicyServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlertPolicyServiceBlockingStub(channel, callOptions);
          }
        };
    return AlertPolicyServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AlertPolicyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AlertPolicyServiceFutureStub>() {
          @java.lang.Override
          public AlertPolicyServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AlertPolicyServiceFutureStub(channel, callOptions);
          }
        };
    return AlertPolicyServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Cloud Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Cloud Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud console](https://console.cloud.google.com/).
   * </pre>
   */
  public abstract static class AlertPolicyServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists the existing alerting policies for the workspace.
     * </pre>
     */
    public void listAlertPolicies(
        com.google.monitoring.v3.ListAlertPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAlertPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public void getAlertPolicy(
        com.google.monitoring.v3.GetAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAlertPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public void createAlertPolicy(
        com.google.monitoring.v3.CreateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAlertPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public void deleteAlertPolicy(
        com.google.monitoring.v3.DeleteAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAlertPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public void updateAlertPolicy(
        com.google.monitoring.v3.UpdateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAlertPolicyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAlertPoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListAlertPoliciesRequest,
                      com.google.monitoring.v3.ListAlertPoliciesResponse>(
                      this, METHODID_LIST_ALERT_POLICIES)))
          .addMethod(
              getGetAlertPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetAlertPolicyRequest,
                      com.google.monitoring.v3.AlertPolicy>(this, METHODID_GET_ALERT_POLICY)))
          .addMethod(
              getCreateAlertPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateAlertPolicyRequest,
                      com.google.monitoring.v3.AlertPolicy>(this, METHODID_CREATE_ALERT_POLICY)))
          .addMethod(
              getDeleteAlertPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_ALERT_POLICY)))
          .addMethod(
              getUpdateAlertPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateAlertPolicyRequest,
                      com.google.monitoring.v3.AlertPolicy>(this, METHODID_UPDATE_ALERT_POLICY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Cloud Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Cloud Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AlertPolicyServiceStub> {
    private AlertPolicyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing alerting policies for the workspace.
     * </pre>
     */
    public void listAlertPolicies(
        com.google.monitoring.v3.ListAlertPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAlertPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public void getAlertPolicy(
        com.google.monitoring.v3.GetAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAlertPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public void createAlertPolicy(
        com.google.monitoring.v3.CreateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAlertPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public void deleteAlertPolicy(
        com.google.monitoring.v3.DeleteAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAlertPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public void updateAlertPolicy(
        com.google.monitoring.v3.UpdateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAlertPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Cloud Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Cloud Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AlertPolicyServiceBlockingStub> {
    private AlertPolicyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing alerting policies for the workspace.
     * </pre>
     */
    public com.google.monitoring.v3.ListAlertPoliciesResponse listAlertPolicies(
        com.google.monitoring.v3.ListAlertPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAlertPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy getAlertPolicy(
        com.google.monitoring.v3.GetAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAlertPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy createAlertPolicy(
        com.google.monitoring.v3.CreateAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAlertPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAlertPolicy(
        com.google.monitoring.v3.DeleteAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAlertPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy updateAlertPolicy(
        com.google.monitoring.v3.UpdateAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAlertPolicyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Cloud Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Cloud Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AlertPolicyServiceFutureStub> {
    private AlertPolicyServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the existing alerting policies for the workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListAlertPoliciesResponse>
        listAlertPolicies(com.google.monitoring.v3.ListAlertPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAlertPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy>
        getAlertPolicy(com.google.monitoring.v3.GetAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAlertPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy>
        createAlertPolicy(com.google.monitoring.v3.CreateAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAlertPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAlertPolicy(com.google.monitoring.v3.DeleteAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAlertPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy>
        updateAlertPolicy(com.google.monitoring.v3.UpdateAlertPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAlertPolicyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALERT_POLICIES = 0;
  private static final int METHODID_GET_ALERT_POLICY = 1;
  private static final int METHODID_CREATE_ALERT_POLICY = 2;
  private static final int METHODID_DELETE_ALERT_POLICY = 3;
  private static final int METHODID_UPDATE_ALERT_POLICY = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AlertPolicyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AlertPolicyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_ALERT_POLICIES:
          serviceImpl.listAlertPolicies(
              (com.google.monitoring.v3.ListAlertPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ALERT_POLICY:
          serviceImpl.getAlertPolicy(
              (com.google.monitoring.v3.GetAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy>) responseObserver);
          break;
        case METHODID_CREATE_ALERT_POLICY:
          serviceImpl.createAlertPolicy(
              (com.google.monitoring.v3.CreateAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy>) responseObserver);
          break;
        case METHODID_DELETE_ALERT_POLICY:
          serviceImpl.deleteAlertPolicy(
              (com.google.monitoring.v3.DeleteAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ALERT_POLICY:
          serviceImpl.updateAlertPolicy(
              (com.google.monitoring.v3.UpdateAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy>) responseObserver);
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

  private abstract static class AlertPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AlertPolicyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.AlertServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AlertPolicyService");
    }
  }

  private static final class AlertPolicyServiceFileDescriptorSupplier
      extends AlertPolicyServiceBaseDescriptorSupplier {
    AlertPolicyServiceFileDescriptorSupplier() {}
  }

  private static final class AlertPolicyServiceMethodDescriptorSupplier
      extends AlertPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AlertPolicyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AlertPolicyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AlertPolicyServiceFileDescriptorSupplier())
                      .addMethod(getListAlertPoliciesMethod())
                      .addMethod(getGetAlertPolicyMethod())
                      .addMethod(getCreateAlertPolicyMethod())
                      .addMethod(getDeleteAlertPolicyMethod())
                      .addMethod(getUpdateAlertPolicyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
