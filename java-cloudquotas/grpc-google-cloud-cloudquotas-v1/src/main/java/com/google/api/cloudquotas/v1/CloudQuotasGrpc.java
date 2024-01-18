/*
 * Copyright 2023 Google LLC
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
package com.google.api.cloudquotas.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
 * service consumers list and manage their resource usage limits.
 * - List/Get the metadata and current status of the quotas for a service.
 * - Create/Update quota preferencess that declare the preferred quota values.
 * - Check the status of a quota preference request.
 * - List/Get pending and historical quota preference.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/api/cloudquotas/v1/cloudquotas.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CloudQuotasGrpc {

  private CloudQuotasGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.api.cloudquotas.v1.CloudQuotas";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.ListQuotaInfosRequest,
          com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
      getListQuotaInfosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQuotaInfos",
      requestType = com.google.api.cloudquotas.v1.ListQuotaInfosRequest.class,
      responseType = com.google.api.cloudquotas.v1.ListQuotaInfosResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.ListQuotaInfosRequest,
          com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
      getListQuotaInfosMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.ListQuotaInfosRequest,
            com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
        getListQuotaInfosMethod;
    if ((getListQuotaInfosMethod = CloudQuotasGrpc.getListQuotaInfosMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getListQuotaInfosMethod = CloudQuotasGrpc.getListQuotaInfosMethod) == null) {
          CloudQuotasGrpc.getListQuotaInfosMethod =
              getListQuotaInfosMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.ListQuotaInfosRequest,
                          com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListQuotaInfos"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.ListQuotaInfosRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.ListQuotaInfosResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudQuotasMethodDescriptorSupplier("ListQuotaInfos"))
                      .build();
        }
      }
    }
    return getListQuotaInfosMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.GetQuotaInfoRequest,
          com.google.api.cloudquotas.v1.QuotaInfo>
      getGetQuotaInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQuotaInfo",
      requestType = com.google.api.cloudquotas.v1.GetQuotaInfoRequest.class,
      responseType = com.google.api.cloudquotas.v1.QuotaInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.GetQuotaInfoRequest,
          com.google.api.cloudquotas.v1.QuotaInfo>
      getGetQuotaInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.GetQuotaInfoRequest,
            com.google.api.cloudquotas.v1.QuotaInfo>
        getGetQuotaInfoMethod;
    if ((getGetQuotaInfoMethod = CloudQuotasGrpc.getGetQuotaInfoMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getGetQuotaInfoMethod = CloudQuotasGrpc.getGetQuotaInfoMethod) == null) {
          CloudQuotasGrpc.getGetQuotaInfoMethod =
              getGetQuotaInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.GetQuotaInfoRequest,
                          com.google.api.cloudquotas.v1.QuotaInfo>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQuotaInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.GetQuotaInfoRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.QuotaInfo.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudQuotasMethodDescriptorSupplier("GetQuotaInfo"))
                      .build();
        }
      }
    }
    return getGetQuotaInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest,
          com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
      getListQuotaPreferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQuotaPreferences",
      requestType = com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest.class,
      responseType = com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest,
          com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
      getListQuotaPreferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest,
            com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
        getListQuotaPreferencesMethod;
    if ((getListQuotaPreferencesMethod = CloudQuotasGrpc.getListQuotaPreferencesMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getListQuotaPreferencesMethod = CloudQuotasGrpc.getListQuotaPreferencesMethod)
            == null) {
          CloudQuotasGrpc.getListQuotaPreferencesMethod =
              getListQuotaPreferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest,
                          com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListQuotaPreferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudQuotasMethodDescriptorSupplier("ListQuotaPreferences"))
                      .build();
        }
      }
    }
    return getListQuotaPreferencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getGetQuotaPreferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQuotaPreference",
      requestType = com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest.class,
      responseType = com.google.api.cloudquotas.v1.QuotaPreference.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getGetQuotaPreferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest,
            com.google.api.cloudquotas.v1.QuotaPreference>
        getGetQuotaPreferenceMethod;
    if ((getGetQuotaPreferenceMethod = CloudQuotasGrpc.getGetQuotaPreferenceMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getGetQuotaPreferenceMethod = CloudQuotasGrpc.getGetQuotaPreferenceMethod) == null) {
          CloudQuotasGrpc.getGetQuotaPreferenceMethod =
              getGetQuotaPreferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest,
                          com.google.api.cloudquotas.v1.QuotaPreference>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQuotaPreference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.QuotaPreference.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudQuotasMethodDescriptorSupplier("GetQuotaPreference"))
                      .build();
        }
      }
    }
    return getGetQuotaPreferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getCreateQuotaPreferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQuotaPreference",
      requestType = com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest.class,
      responseType = com.google.api.cloudquotas.v1.QuotaPreference.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getCreateQuotaPreferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest,
            com.google.api.cloudquotas.v1.QuotaPreference>
        getCreateQuotaPreferenceMethod;
    if ((getCreateQuotaPreferenceMethod = CloudQuotasGrpc.getCreateQuotaPreferenceMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getCreateQuotaPreferenceMethod = CloudQuotasGrpc.getCreateQuotaPreferenceMethod)
            == null) {
          CloudQuotasGrpc.getCreateQuotaPreferenceMethod =
              getCreateQuotaPreferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest,
                          com.google.api.cloudquotas.v1.QuotaPreference>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateQuotaPreference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.QuotaPreference.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudQuotasMethodDescriptorSupplier("CreateQuotaPreference"))
                      .build();
        }
      }
    }
    return getCreateQuotaPreferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getUpdateQuotaPreferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQuotaPreference",
      requestType = com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest.class,
      responseType = com.google.api.cloudquotas.v1.QuotaPreference.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest,
          com.google.api.cloudquotas.v1.QuotaPreference>
      getUpdateQuotaPreferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest,
            com.google.api.cloudquotas.v1.QuotaPreference>
        getUpdateQuotaPreferenceMethod;
    if ((getUpdateQuotaPreferenceMethod = CloudQuotasGrpc.getUpdateQuotaPreferenceMethod) == null) {
      synchronized (CloudQuotasGrpc.class) {
        if ((getUpdateQuotaPreferenceMethod = CloudQuotasGrpc.getUpdateQuotaPreferenceMethod)
            == null) {
          CloudQuotasGrpc.getUpdateQuotaPreferenceMethod =
              getUpdateQuotaPreferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest,
                          com.google.api.cloudquotas.v1.QuotaPreference>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateQuotaPreference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.api.cloudquotas.v1.QuotaPreference.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudQuotasMethodDescriptorSupplier("UpdateQuotaPreference"))
                      .build();
        }
      }
    }
    return getUpdateQuotaPreferenceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudQuotasStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudQuotasStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudQuotasStub>() {
          @java.lang.Override
          public CloudQuotasStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudQuotasStub(channel, callOptions);
          }
        };
    return CloudQuotasStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudQuotasBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudQuotasBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudQuotasBlockingStub>() {
          @java.lang.Override
          public CloudQuotasBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudQuotasBlockingStub(channel, callOptions);
          }
        };
    return CloudQuotasBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudQuotasFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CloudQuotasFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CloudQuotasFutureStub>() {
          @java.lang.Override
          public CloudQuotasFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CloudQuotasFutureStub(channel, callOptions);
          }
        };
    return CloudQuotasFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
   * service consumers list and manage their resource usage limits.
   * - List/Get the metadata and current status of the quotas for a service.
   * - Create/Update quota preferencess that declare the preferred quota values.
   * - Check the status of a quota preference request.
   * - List/Get pending and historical quota preference.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists QuotaInfos of all quotas for a given project, folder or organization.
     * </pre>
     */
    default void listQuotaInfos(
        com.google.api.cloudquotas.v1.ListQuotaInfosRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQuotaInfosMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the QuotaInfo of a quota for a project, folder or organization.
     * </pre>
     */
    default void getQuotaInfo(
        com.google.api.cloudquotas.v1.GetQuotaInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQuotaInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaPreferences in a given project, folder or organization.
     * </pre>
     */
    default void listQuotaPreferences(
        com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQuotaPreferencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single QuotaPreference.
     * </pre>
     */
    default void getQuotaPreference(
        com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQuotaPreferenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QuotaPreference that declares the desired value for a quota.
     * </pre>
     */
    default void createQuotaPreference(
        com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQuotaPreferenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single QuotaPreference. It can updates the
     * config in any states, not just the ones pending approval.
     * </pre>
     */
    default void updateQuotaPreference(
        com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateQuotaPreferenceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CloudQuotas.
   *
   * <pre>
   * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
   * service consumers list and manage their resource usage limits.
   * - List/Get the metadata and current status of the quotas for a service.
   * - Create/Update quota preferencess that declare the preferred quota values.
   * - Check the status of a quota preference request.
   * - List/Get pending and historical quota preference.
   * </pre>
   */
  public abstract static class CloudQuotasImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CloudQuotasGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CloudQuotas.
   *
   * <pre>
   * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
   * service consumers list and manage their resource usage limits.
   * - List/Get the metadata and current status of the quotas for a service.
   * - Create/Update quota preferencess that declare the preferred quota values.
   * - Check the status of a quota preference request.
   * - List/Get pending and historical quota preference.
   * </pre>
   */
  public static final class CloudQuotasStub
      extends io.grpc.stub.AbstractAsyncStub<CloudQuotasStub> {
    private CloudQuotasStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudQuotasStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudQuotasStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaInfos of all quotas for a given project, folder or organization.
     * </pre>
     */
    public void listQuotaInfos(
        com.google.api.cloudquotas.v1.ListQuotaInfosRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQuotaInfosMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the QuotaInfo of a quota for a project, folder or organization.
     * </pre>
     */
    public void getQuotaInfo(
        com.google.api.cloudquotas.v1.GetQuotaInfoRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQuotaInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaPreferences in a given project, folder or organization.
     * </pre>
     */
    public void listQuotaPreferences(
        com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQuotaPreferencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single QuotaPreference.
     * </pre>
     */
    public void getQuotaPreference(
        com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQuotaPreferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QuotaPreference that declares the desired value for a quota.
     * </pre>
     */
    public void createQuotaPreference(
        com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQuotaPreferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single QuotaPreference. It can updates the
     * config in any states, not just the ones pending approval.
     * </pre>
     */
    public void updateQuotaPreference(
        com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQuotaPreferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CloudQuotas.
   *
   * <pre>
   * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
   * service consumers list and manage their resource usage limits.
   * - List/Get the metadata and current status of the quotas for a service.
   * - Create/Update quota preferencess that declare the preferred quota values.
   * - Check the status of a quota preference request.
   * - List/Get pending and historical quota preference.
   * </pre>
   */
  public static final class CloudQuotasBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CloudQuotasBlockingStub> {
    private CloudQuotasBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudQuotasBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudQuotasBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaInfos of all quotas for a given project, folder or organization.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.ListQuotaInfosResponse listQuotaInfos(
        com.google.api.cloudquotas.v1.ListQuotaInfosRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQuotaInfosMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the QuotaInfo of a quota for a project, folder or organization.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.QuotaInfo getQuotaInfo(
        com.google.api.cloudquotas.v1.GetQuotaInfoRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQuotaInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaPreferences in a given project, folder or organization.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse listQuotaPreferences(
        com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQuotaPreferencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single QuotaPreference.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.QuotaPreference getQuotaPreference(
        com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQuotaPreferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QuotaPreference that declares the desired value for a quota.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.QuotaPreference createQuotaPreference(
        com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQuotaPreferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single QuotaPreference. It can updates the
     * config in any states, not just the ones pending approval.
     * </pre>
     */
    public com.google.api.cloudquotas.v1.QuotaPreference updateQuotaPreference(
        com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQuotaPreferenceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CloudQuotas.
   *
   * <pre>
   * The Cloud Quotas API is an infrastructure service for Google Cloud that lets
   * service consumers list and manage their resource usage limits.
   * - List/Get the metadata and current status of the quotas for a service.
   * - Create/Update quota preferencess that declare the preferred quota values.
   * - Check the status of a quota preference request.
   * - List/Get pending and historical quota preference.
   * </pre>
   */
  public static final class CloudQuotasFutureStub
      extends io.grpc.stub.AbstractFutureStub<CloudQuotasFutureStub> {
    private CloudQuotasFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudQuotasFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudQuotasFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaInfos of all quotas for a given project, folder or organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.ListQuotaInfosResponse>
        listQuotaInfos(com.google.api.cloudquotas.v1.ListQuotaInfosRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQuotaInfosMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieve the QuotaInfo of a quota for a project, folder or organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.QuotaInfo>
        getQuotaInfo(com.google.api.cloudquotas.v1.GetQuotaInfoRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQuotaInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QuotaPreferences in a given project, folder or organization.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>
        listQuotaPreferences(com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQuotaPreferencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single QuotaPreference.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.QuotaPreference>
        getQuotaPreference(com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQuotaPreferenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new QuotaPreference that declares the desired value for a quota.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.QuotaPreference>
        createQuotaPreference(com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQuotaPreferenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single QuotaPreference. It can updates the
     * config in any states, not just the ones pending approval.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.api.cloudquotas.v1.QuotaPreference>
        updateQuotaPreference(com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQuotaPreferenceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_QUOTA_INFOS = 0;
  private static final int METHODID_GET_QUOTA_INFO = 1;
  private static final int METHODID_LIST_QUOTA_PREFERENCES = 2;
  private static final int METHODID_GET_QUOTA_PREFERENCE = 3;
  private static final int METHODID_CREATE_QUOTA_PREFERENCE = 4;
  private static final int METHODID_UPDATE_QUOTA_PREFERENCE = 5;

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
        case METHODID_LIST_QUOTA_INFOS:
          serviceImpl.listQuotaInfos(
              (com.google.api.cloudquotas.v1.ListQuotaInfosRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.ListQuotaInfosResponse>)
                  responseObserver);
          break;
        case METHODID_GET_QUOTA_INFO:
          serviceImpl.getQuotaInfo(
              (com.google.api.cloudquotas.v1.GetQuotaInfoRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaInfo>)
                  responseObserver);
          break;
        case METHODID_LIST_QUOTA_PREFERENCES:
          serviceImpl.listQuotaPreferences(
              (com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_QUOTA_PREFERENCE:
          serviceImpl.getQuotaPreference(
              (com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>)
                  responseObserver);
          break;
        case METHODID_CREATE_QUOTA_PREFERENCE:
          serviceImpl.createQuotaPreference(
              (com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>)
                  responseObserver);
          break;
        case METHODID_UPDATE_QUOTA_PREFERENCE:
          serviceImpl.updateQuotaPreference(
              (com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.api.cloudquotas.v1.QuotaPreference>)
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
            getListQuotaInfosMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.ListQuotaInfosRequest,
                    com.google.api.cloudquotas.v1.ListQuotaInfosResponse>(
                    service, METHODID_LIST_QUOTA_INFOS)))
        .addMethod(
            getGetQuotaInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.GetQuotaInfoRequest,
                    com.google.api.cloudquotas.v1.QuotaInfo>(service, METHODID_GET_QUOTA_INFO)))
        .addMethod(
            getListQuotaPreferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.ListQuotaPreferencesRequest,
                    com.google.api.cloudquotas.v1.ListQuotaPreferencesResponse>(
                    service, METHODID_LIST_QUOTA_PREFERENCES)))
        .addMethod(
            getGetQuotaPreferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.GetQuotaPreferenceRequest,
                    com.google.api.cloudquotas.v1.QuotaPreference>(
                    service, METHODID_GET_QUOTA_PREFERENCE)))
        .addMethod(
            getCreateQuotaPreferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.CreateQuotaPreferenceRequest,
                    com.google.api.cloudquotas.v1.QuotaPreference>(
                    service, METHODID_CREATE_QUOTA_PREFERENCE)))
        .addMethod(
            getUpdateQuotaPreferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.api.cloudquotas.v1.UpdateQuotaPreferenceRequest,
                    com.google.api.cloudquotas.v1.QuotaPreference>(
                    service, METHODID_UPDATE_QUOTA_PREFERENCE)))
        .build();
  }

  private abstract static class CloudQuotasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudQuotasBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.api.cloudquotas.v1.CloudquotasProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudQuotas");
    }
  }

  private static final class CloudQuotasFileDescriptorSupplier
      extends CloudQuotasBaseDescriptorSupplier {
    CloudQuotasFileDescriptorSupplier() {}
  }

  private static final class CloudQuotasMethodDescriptorSupplier
      extends CloudQuotasBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CloudQuotasMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CloudQuotasGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudQuotasFileDescriptorSupplier())
                      .addMethod(getListQuotaInfosMethod())
                      .addMethod(getGetQuotaInfoMethod())
                      .addMethod(getListQuotaPreferencesMethod())
                      .addMethod(getGetQuotaPreferenceMethod())
                      .addMethod(getCreateQuotaPreferenceMethod())
                      .addMethod(getUpdateQuotaPreferenceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
