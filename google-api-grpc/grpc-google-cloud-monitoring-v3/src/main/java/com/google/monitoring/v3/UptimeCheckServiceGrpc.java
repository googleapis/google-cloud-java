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
 * The UptimeCheckService API is used to manage (list, create, delete, edit)
 * uptime check configurations in the Stackdriver Monitoring product. An uptime
 * check is a piece of configuration that determines which resources and
 * services to monitor for availability. These configurations can also be
 * configured interactively by navigating to the [Cloud Console]
 * (http://console.cloud.google.com), selecting the appropriate project,
 * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
 * and then clicking on "Uptime".
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/monitoring/v3/uptime_service.proto")
public final class UptimeCheckServiceGrpc {

  private UptimeCheckServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.UptimeCheckService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListUptimeCheckConfigsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
      com.google.monitoring.v3.ListUptimeCheckConfigsResponse> METHOD_LIST_UPTIME_CHECK_CONFIGS = getListUptimeCheckConfigsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
      com.google.monitoring.v3.ListUptimeCheckConfigsResponse> getListUptimeCheckConfigsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
      com.google.monitoring.v3.ListUptimeCheckConfigsResponse> getListUptimeCheckConfigsMethod() {
    return getListUptimeCheckConfigsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
      com.google.monitoring.v3.ListUptimeCheckConfigsResponse> getListUptimeCheckConfigsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckConfigsRequest, com.google.monitoring.v3.ListUptimeCheckConfigsResponse> getListUptimeCheckConfigsMethod;
    if ((getListUptimeCheckConfigsMethod = UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getListUptimeCheckConfigsMethod = UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod) == null) {
          UptimeCheckServiceGrpc.getListUptimeCheckConfigsMethod = getListUptimeCheckConfigsMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.ListUptimeCheckConfigsRequest, com.google.monitoring.v3.ListUptimeCheckConfigsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "ListUptimeCheckConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListUptimeCheckConfigsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListUptimeCheckConfigsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("ListUptimeCheckConfigs"))
                  .build();
          }
        }
     }
     return getListUptimeCheckConfigsMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetUptimeCheckConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.GetUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> METHOD_GET_UPTIME_CHECK_CONFIG = getGetUptimeCheckConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.GetUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getGetUptimeCheckConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getGetUptimeCheckConfigMethod() {
    return getGetUptimeCheckConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.GetUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getGetUptimeCheckConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.GetUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig> getGetUptimeCheckConfigMethod;
    if ((getGetUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getGetUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod) == null) {
          UptimeCheckServiceGrpc.getGetUptimeCheckConfigMethod = getGetUptimeCheckConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.GetUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "GetUptimeCheckConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.GetUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("GetUptimeCheckConfig"))
                  .build();
          }
        }
     }
     return getGetUptimeCheckConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateUptimeCheckConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> METHOD_CREATE_UPTIME_CHECK_CONFIG = getCreateUptimeCheckConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getCreateUptimeCheckConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getCreateUptimeCheckConfigMethod() {
    return getCreateUptimeCheckConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getCreateUptimeCheckConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.CreateUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig> getCreateUptimeCheckConfigMethod;
    if ((getCreateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getCreateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod) == null) {
          UptimeCheckServiceGrpc.getCreateUptimeCheckConfigMethod = getCreateUptimeCheckConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.CreateUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "CreateUptimeCheckConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.CreateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("CreateUptimeCheckConfig"))
                  .build();
          }
        }
     }
     return getCreateUptimeCheckConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateUptimeCheckConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> METHOD_UPDATE_UPTIME_CHECK_CONFIG = getUpdateUptimeCheckConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getUpdateUptimeCheckConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getUpdateUptimeCheckConfigMethod() {
    return getUpdateUptimeCheckConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
      com.google.monitoring.v3.UptimeCheckConfig> getUpdateUptimeCheckConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig> getUpdateUptimeCheckConfigMethod;
    if ((getUpdateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getUpdateUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod) == null) {
          UptimeCheckServiceGrpc.getUpdateUptimeCheckConfigMethod = getUpdateUptimeCheckConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.UpdateUptimeCheckConfigRequest, com.google.monitoring.v3.UptimeCheckConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "UpdateUptimeCheckConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UpdateUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.UptimeCheckConfig.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("UpdateUptimeCheckConfig"))
                  .build();
          }
        }
     }
     return getUpdateUptimeCheckConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteUptimeCheckConfigMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
      com.google.protobuf.Empty> METHOD_DELETE_UPTIME_CHECK_CONFIG = getDeleteUptimeCheckConfigMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
      com.google.protobuf.Empty> getDeleteUptimeCheckConfigMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
      com.google.protobuf.Empty> getDeleteUptimeCheckConfigMethod() {
    return getDeleteUptimeCheckConfigMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
      com.google.protobuf.Empty> getDeleteUptimeCheckConfigMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest, com.google.protobuf.Empty> getDeleteUptimeCheckConfigMethod;
    if ((getDeleteUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getDeleteUptimeCheckConfigMethod = UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod) == null) {
          UptimeCheckServiceGrpc.getDeleteUptimeCheckConfigMethod = getDeleteUptimeCheckConfigMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.DeleteUptimeCheckConfigRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "DeleteUptimeCheckConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.DeleteUptimeCheckConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("DeleteUptimeCheckConfig"))
                  .build();
          }
        }
     }
     return getDeleteUptimeCheckConfigMethod;
  }
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListUptimeCheckIpsMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckIpsRequest,
      com.google.monitoring.v3.ListUptimeCheckIpsResponse> METHOD_LIST_UPTIME_CHECK_IPS = getListUptimeCheckIpsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckIpsRequest,
      com.google.monitoring.v3.ListUptimeCheckIpsResponse> getListUptimeCheckIpsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckIpsRequest,
      com.google.monitoring.v3.ListUptimeCheckIpsResponse> getListUptimeCheckIpsMethod() {
    return getListUptimeCheckIpsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckIpsRequest,
      com.google.monitoring.v3.ListUptimeCheckIpsResponse> getListUptimeCheckIpsMethodHelper() {
    io.grpc.MethodDescriptor<com.google.monitoring.v3.ListUptimeCheckIpsRequest, com.google.monitoring.v3.ListUptimeCheckIpsResponse> getListUptimeCheckIpsMethod;
    if ((getListUptimeCheckIpsMethod = UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod) == null) {
      synchronized (UptimeCheckServiceGrpc.class) {
        if ((getListUptimeCheckIpsMethod = UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod) == null) {
          UptimeCheckServiceGrpc.getListUptimeCheckIpsMethod = getListUptimeCheckIpsMethod = 
              io.grpc.MethodDescriptor.<com.google.monitoring.v3.ListUptimeCheckIpsRequest, com.google.monitoring.v3.ListUptimeCheckIpsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "google.monitoring.v3.UptimeCheckService", "ListUptimeCheckIps"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListUptimeCheckIpsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.monitoring.v3.ListUptimeCheckIpsResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new UptimeCheckServiceMethodDescriptorSupplier("ListUptimeCheckIps"))
                  .build();
          }
        }
     }
     return getListUptimeCheckIpsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UptimeCheckServiceStub newStub(io.grpc.Channel channel) {
    return new UptimeCheckServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UptimeCheckServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UptimeCheckServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UptimeCheckServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UptimeCheckServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * uptime check configurations in the Stackdriver Monitoring product. An uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static abstract class UptimeCheckServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Lists the existing valid uptime check configurations for the project,
     * leaving out any invalid configurations.
     * </pre>
     */
    public void listUptimeCheckConfigs(com.google.monitoring.v3.ListUptimeCheckConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListUptimeCheckConfigsMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Gets a single uptime check configuration.
     * </pre>
     */
    public void getUptimeCheckConfig(com.google.monitoring.v3.GetUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUptimeCheckConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new uptime check configuration.
     * </pre>
     */
    public void createUptimeCheckConfig(com.google.monitoring.v3.CreateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateUptimeCheckConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Updates an uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `"updateMask"`.
     * Returns the updated configuration.
     * </pre>
     */
    public void updateUptimeCheckConfig(com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateUptimeCheckConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Deletes an uptime check configuration. Note that this method will fail
     * if the uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public void deleteUptimeCheckConfig(com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUptimeCheckConfigMethodHelper(), responseObserver);
    }

    /**
     * <pre>
     * Returns the list of IPs that checkers run from
     * </pre>
     */
    public void listUptimeCheckIps(com.google.monitoring.v3.ListUptimeCheckIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListUptimeCheckIpsMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListUptimeCheckConfigsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.ListUptimeCheckConfigsRequest,
                com.google.monitoring.v3.ListUptimeCheckConfigsResponse>(
                  this, METHODID_LIST_UPTIME_CHECK_CONFIGS)))
          .addMethod(
            getGetUptimeCheckConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.GetUptimeCheckConfigRequest,
                com.google.monitoring.v3.UptimeCheckConfig>(
                  this, METHODID_GET_UPTIME_CHECK_CONFIG)))
          .addMethod(
            getCreateUptimeCheckConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.CreateUptimeCheckConfigRequest,
                com.google.monitoring.v3.UptimeCheckConfig>(
                  this, METHODID_CREATE_UPTIME_CHECK_CONFIG)))
          .addMethod(
            getUpdateUptimeCheckConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.UpdateUptimeCheckConfigRequest,
                com.google.monitoring.v3.UptimeCheckConfig>(
                  this, METHODID_UPDATE_UPTIME_CHECK_CONFIG)))
          .addMethod(
            getDeleteUptimeCheckConfigMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.DeleteUptimeCheckConfigRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_UPTIME_CHECK_CONFIG)))
          .addMethod(
            getListUptimeCheckIpsMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.monitoring.v3.ListUptimeCheckIpsRequest,
                com.google.monitoring.v3.ListUptimeCheckIpsResponse>(
                  this, METHODID_LIST_UPTIME_CHECK_IPS)))
          .build();
    }
  }

  /**
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * uptime check configurations in the Stackdriver Monitoring product. An uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceStub extends io.grpc.stub.AbstractStub<UptimeCheckServiceStub> {
    private UptimeCheckServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UptimeCheckServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing valid uptime check configurations for the project,
     * leaving out any invalid configurations.
     * </pre>
     */
    public void listUptimeCheckConfigs(com.google.monitoring.v3.ListUptimeCheckConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUptimeCheckConfigsMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a single uptime check configuration.
     * </pre>
     */
    public void getUptimeCheckConfig(com.google.monitoring.v3.GetUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUptimeCheckConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new uptime check configuration.
     * </pre>
     */
    public void createUptimeCheckConfig(com.google.monitoring.v3.CreateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateUptimeCheckConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `"updateMask"`.
     * Returns the updated configuration.
     * </pre>
     */
    public void updateUptimeCheckConfig(com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateUptimeCheckConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes an uptime check configuration. Note that this method will fail
     * if the uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public void deleteUptimeCheckConfig(com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteUptimeCheckConfigMethodHelper(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Returns the list of IPs that checkers run from
     * </pre>
     */
    public void listUptimeCheckIps(com.google.monitoring.v3.ListUptimeCheckIpsRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListUptimeCheckIpsMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * uptime check configurations in the Stackdriver Monitoring product. An uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceBlockingStub extends io.grpc.stub.AbstractStub<UptimeCheckServiceBlockingStub> {
    private UptimeCheckServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UptimeCheckServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing valid uptime check configurations for the project,
     * leaving out any invalid configurations.
     * </pre>
     */
    public com.google.monitoring.v3.ListUptimeCheckConfigsResponse listUptimeCheckConfigs(com.google.monitoring.v3.ListUptimeCheckConfigsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListUptimeCheckConfigsMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a single uptime check configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig getUptimeCheckConfig(com.google.monitoring.v3.GetUptimeCheckConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUptimeCheckConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new uptime check configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig createUptimeCheckConfig(com.google.monitoring.v3.CreateUptimeCheckConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateUptimeCheckConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `"updateMask"`.
     * Returns the updated configuration.
     * </pre>
     */
    public com.google.monitoring.v3.UptimeCheckConfig updateUptimeCheckConfig(com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateUptimeCheckConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes an uptime check configuration. Note that this method will fail
     * if the uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteUptimeCheckConfig(com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUptimeCheckConfigMethodHelper(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Returns the list of IPs that checkers run from
     * </pre>
     */
    public com.google.monitoring.v3.ListUptimeCheckIpsResponse listUptimeCheckIps(com.google.monitoring.v3.ListUptimeCheckIpsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListUptimeCheckIpsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The UptimeCheckService API is used to manage (list, create, delete, edit)
   * uptime check configurations in the Stackdriver Monitoring product. An uptime
   * check is a piece of configuration that determines which resources and
   * services to monitor for availability. These configurations can also be
   * configured interactively by navigating to the [Cloud Console]
   * (http://console.cloud.google.com), selecting the appropriate project,
   * clicking on "Monitoring" on the left-hand side to navigate to Stackdriver,
   * and then clicking on "Uptime".
   * </pre>
   */
  public static final class UptimeCheckServiceFutureStub extends io.grpc.stub.AbstractStub<UptimeCheckServiceFutureStub> {
    private UptimeCheckServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UptimeCheckServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UptimeCheckServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UptimeCheckServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists the existing valid uptime check configurations for the project,
     * leaving out any invalid configurations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.ListUptimeCheckConfigsResponse> listUptimeCheckConfigs(
        com.google.monitoring.v3.ListUptimeCheckConfigsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListUptimeCheckConfigsMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a single uptime check configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.UptimeCheckConfig> getUptimeCheckConfig(
        com.google.monitoring.v3.GetUptimeCheckConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUptimeCheckConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new uptime check configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.UptimeCheckConfig> createUptimeCheckConfig(
        com.google.monitoring.v3.CreateUptimeCheckConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateUptimeCheckConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an uptime check configuration. You can either replace the entire
     * configuration with a new one or replace only certain fields in the current
     * configuration by specifying the fields to be updated via `"updateMask"`.
     * Returns the updated configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.UptimeCheckConfig> updateUptimeCheckConfig(
        com.google.monitoring.v3.UpdateUptimeCheckConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateUptimeCheckConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes an uptime check configuration. Note that this method will fail
     * if the uptime check configuration is referenced by an alert policy or
     * other dependent configs that would be rendered invalid by the deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteUptimeCheckConfig(
        com.google.monitoring.v3.DeleteUptimeCheckConfigRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUptimeCheckConfigMethodHelper(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Returns the list of IPs that checkers run from
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.ListUptimeCheckIpsResponse> listUptimeCheckIps(
        com.google.monitoring.v3.ListUptimeCheckIpsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListUptimeCheckIpsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_UPTIME_CHECK_CONFIGS = 0;
  private static final int METHODID_GET_UPTIME_CHECK_CONFIG = 1;
  private static final int METHODID_CREATE_UPTIME_CHECK_CONFIG = 2;
  private static final int METHODID_UPDATE_UPTIME_CHECK_CONFIG = 3;
  private static final int METHODID_DELETE_UPTIME_CHECK_CONFIG = 4;
  private static final int METHODID_LIST_UPTIME_CHECK_IPS = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UptimeCheckServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UptimeCheckServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_UPTIME_CHECK_CONFIGS:
          serviceImpl.listUptimeCheckConfigs((com.google.monitoring.v3.ListUptimeCheckConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckConfigsResponse>) responseObserver);
          break;
        case METHODID_GET_UPTIME_CHECK_CONFIG:
          serviceImpl.getUptimeCheckConfig((com.google.monitoring.v3.GetUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>) responseObserver);
          break;
        case METHODID_CREATE_UPTIME_CHECK_CONFIG:
          serviceImpl.createUptimeCheckConfig((com.google.monitoring.v3.CreateUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>) responseObserver);
          break;
        case METHODID_UPDATE_UPTIME_CHECK_CONFIG:
          serviceImpl.updateUptimeCheckConfig((com.google.monitoring.v3.UpdateUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.UptimeCheckConfig>) responseObserver);
          break;
        case METHODID_DELETE_UPTIME_CHECK_CONFIG:
          serviceImpl.deleteUptimeCheckConfig((com.google.monitoring.v3.DeleteUptimeCheckConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_UPTIME_CHECK_IPS:
          serviceImpl.listUptimeCheckIps((com.google.monitoring.v3.ListUptimeCheckIpsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListUptimeCheckIpsResponse>) responseObserver);
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

  private static abstract class UptimeCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UptimeCheckServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.UptimeServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UptimeCheckService");
    }
  }

  private static final class UptimeCheckServiceFileDescriptorSupplier
      extends UptimeCheckServiceBaseDescriptorSupplier {
    UptimeCheckServiceFileDescriptorSupplier() {}
  }

  private static final class UptimeCheckServiceMethodDescriptorSupplier
      extends UptimeCheckServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UptimeCheckServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UptimeCheckServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UptimeCheckServiceFileDescriptorSupplier())
              .addMethod(getListUptimeCheckConfigsMethodHelper())
              .addMethod(getGetUptimeCheckConfigMethodHelper())
              .addMethod(getCreateUptimeCheckConfigMethodHelper())
              .addMethod(getUpdateUptimeCheckConfigMethodHelper())
              .addMethod(getDeleteUptimeCheckConfigMethodHelper())
              .addMethod(getListUptimeCheckIpsMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
