package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The AlertPolicyService API is used to manage (list, create, delete,
 * edit) alert policies in Stackdriver Monitoring. An alerting policy is
 * a description of the conditions under which some aspect of your
 * system is considered to be "unhealthy" and the ways to notify
 * people or services about this state. In addition to using this API, alert
 * policies can also be managed through
 * [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/),
 * which can be reached by clicking the "Monitoring" tab in
 * [Cloud Console](https://console.cloud.google.com/).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/monitoring/v3/alert_service.proto")
public final class AlertPolicyServiceGrpc {

  private AlertPolicyServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.AlertPolicyService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListAlertPoliciesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.ListAlertPoliciesRequest,
      com.google.monitoring.v3.ListAlertPoliciesResponse> METHOD_LIST_ALERT_POLICIES = getListAlertPoliciesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.ListAlertPoliciesRequest,
      com.google.monitoring.v3.ListAlertPoliciesResponse> getListAlertPoliciesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListAlertPoliciesRequest,
      com.google.monitoring.v3.ListAlertPoliciesResponse> getListAlertPoliciesMethod() {
    return getListAlertPoliciesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListAlertPoliciesRequest,
      com.google.monitoring.v3.ListAlertPoliciesResponse> getListAlertPoliciesMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.ListAlertPoliciesRequest, com.google.monitoring.v3.ListAlertPoliciesResponse> getListAlertPoliciesMethod;
    if ((getListAlertPoliciesMethod = AlertPolicyServiceGrpc.getListAlertPoliciesMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getListAlertPoliciesMethod = AlertPolicyServiceGrpc.getListAlertPoliciesMethod) == null) {
          AlertPolicyServiceGrpc.getListAlertPoliciesMethod = getListAlertPoliciesMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.ListAlertPoliciesRequest, com.google.monitoring.v3.ListAlertPoliciesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.AlertPolicyService", "ListAlertPolicies"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListAlertPoliciesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListAlertPoliciesResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertPolicyServiceMethodDescriptorSupplier("ListAlertPolicies"))
                  .build();
          }
        }
     }
     return getListAlertPoliciesMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetAlertPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.GetAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> METHOD_GET_ALERT_POLICY = getGetAlertPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.GetAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getGetAlertPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getGetAlertPolicyMethod() {
    return getGetAlertPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getGetAlertPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.GetAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy> getGetAlertPolicyMethod;
    if ((getGetAlertPolicyMethod = AlertPolicyServiceGrpc.getGetAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getGetAlertPolicyMethod = AlertPolicyServiceGrpc.getGetAlertPolicyMethod) == null) {
          AlertPolicyServiceGrpc.getGetAlertPolicyMethod = getGetAlertPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.GetAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.AlertPolicyService", "GetAlertPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetAlertPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertPolicyServiceMethodDescriptorSupplier("GetAlertPolicy"))
                  .build();
          }
        }
     }
     return getGetAlertPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAlertPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> METHOD_CREATE_ALERT_POLICY = getCreateAlertPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getCreateAlertPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getCreateAlertPolicyMethod() {
    return getCreateAlertPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getCreateAlertPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy> getCreateAlertPolicyMethod;
    if ((getCreateAlertPolicyMethod = AlertPolicyServiceGrpc.getCreateAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getCreateAlertPolicyMethod = AlertPolicyServiceGrpc.getCreateAlertPolicyMethod) == null) {
          AlertPolicyServiceGrpc.getCreateAlertPolicyMethod = getCreateAlertPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.CreateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.AlertPolicyService", "CreateAlertPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.CreateAlertPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertPolicyServiceMethodDescriptorSupplier("CreateAlertPolicy"))
                  .build();
          }
        }
     }
     return getCreateAlertPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteAlertPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteAlertPolicyRequest,
      com.google.protobuf.Empty> METHOD_DELETE_ALERT_POLICY = getDeleteAlertPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteAlertPolicyRequest,
      com.google.protobuf.Empty> getDeleteAlertPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteAlertPolicyRequest,
      com.google.protobuf.Empty> getDeleteAlertPolicyMethod() {
    return getDeleteAlertPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteAlertPolicyRequest,
      com.google.protobuf.Empty> getDeleteAlertPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty> getDeleteAlertPolicyMethod;
    if ((getDeleteAlertPolicyMethod = AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getDeleteAlertPolicyMethod = AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod) == null) {
          AlertPolicyServiceGrpc.getDeleteAlertPolicyMethod = getDeleteAlertPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.DeleteAlertPolicyRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.AlertPolicyService", "DeleteAlertPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.DeleteAlertPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertPolicyServiceMethodDescriptorSupplier("DeleteAlertPolicy"))
                  .build();
          }
        }
     }
     return getDeleteAlertPolicyMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateAlertPolicyMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> METHOD_UPDATE_ALERT_POLICY = getUpdateAlertPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getUpdateAlertPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getUpdateAlertPolicyMethod() {
    return getUpdateAlertPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateAlertPolicyRequest,
      com.google.monitoring.v3.AlertPolicy> getUpdateAlertPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy> getUpdateAlertPolicyMethod;
    if ((getUpdateAlertPolicyMethod = AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod) == null) {
      synchronized (AlertPolicyServiceGrpc.class) {
        if ((getUpdateAlertPolicyMethod = AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod) == null) {
          AlertPolicyServiceGrpc.getUpdateAlertPolicyMethod = getUpdateAlertPolicyMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.UpdateAlertPolicyRequest, com.google.monitoring.v3.AlertPolicy>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.AlertPolicyService", "UpdateAlertPolicy"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UpdateAlertPolicyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.AlertPolicy.getDefaultInstance()))
                  .setSchemaDescriptor(new AlertPolicyServiceMethodDescriptorSupplier("UpdateAlertPolicy"))
                  .build();
          }
        }
     }
     return getUpdateAlertPolicyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AlertPolicyServiceStub newStub(io.grpc.Channel channel) {
    return new AlertPolicyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AlertPolicyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AlertPolicyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AlertPolicyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AlertPolicyServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Stackdriver Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud Console](https://console.cloud.google.com/).
   * </pre>
   */
  public static abstract class AlertPolicyServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the existing alerting policies for the project.
     * </pre>
     */
    public void listAlertPolicies(com.google.monitoring.v3.ListAlertPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListAlertPoliciesMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public void getAlertPolicy(com.google.monitoring.v3.GetAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAlertPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public void createAlertPolicy(com.google.monitoring.v3.CreateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAlertPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public void deleteAlertPolicy(com.google.monitoring.v3.DeleteAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteAlertPolicyMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public void updateAlertPolicy(com.google.monitoring.v3.UpdateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateAlertPolicyMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListAlertPoliciesMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.ListAlertPoliciesRequest,
                com.google.monitoring.v3.ListAlertPoliciesResponse>(
                  this, METHODID_LIST_ALERT_POLICIES)))
          .addMethod(
            getGetAlertPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.GetAlertPolicyRequest,
                com.google.monitoring.v3.AlertPolicy>(
                  this, METHODID_GET_ALERT_POLICY)))
          .addMethod(
            getCreateAlertPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.CreateAlertPolicyRequest,
                com.google.monitoring.v3.AlertPolicy>(
                  this, METHODID_CREATE_ALERT_POLICY)))
          .addMethod(
            getDeleteAlertPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.DeleteAlertPolicyRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_ALERT_POLICY)))
          .addMethod(
            getUpdateAlertPolicyMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.UpdateAlertPolicyRequest,
                com.google.monitoring.v3.AlertPolicy>(
                  this, METHODID_UPDATE_ALERT_POLICY)))
          .build();
    }
  }

  /**
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Stackdriver Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud Console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceStub extends io.grpc.stub.AbstractStub<AlertPolicyServiceStub> {
    private AlertPolicyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertPolicyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing alerting policies for the project.
     * </pre>
     */
    public void listAlertPolicies(com.google.monitoring.v3.ListAlertPoliciesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListAlertPoliciesMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public void getAlertPolicy(com.google.monitoring.v3.GetAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAlertPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public void createAlertPolicy(com.google.monitoring.v3.CreateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAlertPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public void deleteAlertPolicy(com.google.monitoring.v3.DeleteAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteAlertPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public void updateAlertPolicy(com.google.monitoring.v3.UpdateAlertPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateAlertPolicyMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Stackdriver Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud Console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceBlockingStub extends io.grpc.stub.AbstractStub<AlertPolicyServiceBlockingStub> {
    private AlertPolicyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertPolicyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing alerting policies for the project.
     * </pre>
     */
    public com.google.monitoring.v3.ListAlertPoliciesResponse listAlertPolicies(com.google.monitoring.v3.ListAlertPoliciesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListAlertPoliciesMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy getAlertPolicy(com.google.monitoring.v3.GetAlertPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetAlertPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy createAlertPolicy(com.google.monitoring.v3.CreateAlertPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAlertPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAlertPolicy(com.google.monitoring.v3.DeleteAlertPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteAlertPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public com.google.monitoring.v3.AlertPolicy updateAlertPolicy(com.google.monitoring.v3.UpdateAlertPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateAlertPolicyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The AlertPolicyService API is used to manage (list, create, delete,
   * edit) alert policies in Stackdriver Monitoring. An alerting policy is
   * a description of the conditions under which some aspect of your
   * system is considered to be "unhealthy" and the ways to notify
   * people or services about this state. In addition to using this API, alert
   * policies can also be managed through
   * [Stackdriver Monitoring](https://cloud.google.com/monitoring/docs/),
   * which can be reached by clicking the "Monitoring" tab in
   * [Cloud Console](https://console.cloud.google.com/).
   * </pre>
   */
  public static final class AlertPolicyServiceFutureStub extends io.grpc.stub.AbstractStub<AlertPolicyServiceFutureStub> {
    private AlertPolicyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AlertPolicyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AlertPolicyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AlertPolicyServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing alerting policies for the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.ListAlertPoliciesResponse> listAlertPolicies(
        com.google.monitoring.v3.ListAlertPoliciesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListAlertPoliciesMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy> getAlertPolicy(
        com.google.monitoring.v3.GetAlertPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAlertPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy> createAlertPolicy(
        com.google.monitoring.v3.CreateAlertPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAlertPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAlertPolicy(
        com.google.monitoring.v3.DeleteAlertPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteAlertPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an alerting policy. You can either replace the entire policy with
     * a new one or replace only certain fields in the current alerting policy by
     * specifying the fields to be updated via `updateMask`. Returns the
     * updated alerting policy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.AlertPolicy> updateAlertPolicy(
        com.google.monitoring.v3.UpdateAlertPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateAlertPolicyMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ALERT_POLICIES = 0;
  private static final int METHODID_GET_ALERT_POLICY = 1;
  private static final int METHODID_CREATE_ALERT_POLICY = 2;
  private static final int METHODID_DELETE_ALERT_POLICY = 3;
  private static final int METHODID_UPDATE_ALERT_POLICY = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
          serviceImpl.listAlertPolicies((com.google.monitoring.v3.ListAlertPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListAlertPoliciesResponse>) responseObserver);
          break;
        case METHODID_GET_ALERT_POLICY:
          serviceImpl.getAlertPolicy((com.google.monitoring.v3.GetAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy>) responseObserver);
          break;
        case METHODID_CREATE_ALERT_POLICY:
          serviceImpl.createAlertPolicy((com.google.monitoring.v3.CreateAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.AlertPolicy>) responseObserver);
          break;
        case METHODID_DELETE_ALERT_POLICY:
          serviceImpl.deleteAlertPolicy((com.google.monitoring.v3.DeleteAlertPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_ALERT_POLICY:
          serviceImpl.updateAlertPolicy((com.google.monitoring.v3.UpdateAlertPolicyRequest) request,
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

  private static abstract class AlertPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
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
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AlertPolicyServiceFileDescriptorSupplier())
              .addMethod(getListAlertPoliciesMethodHelper())
              .addMethod(getGetAlertPolicyMethodHelper())
              .addMethod(getCreateAlertPolicyMethodHelper())
              .addMethod(getDeleteAlertPolicyMethodHelper())
              .addMethod(getUpdateAlertPolicyMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
