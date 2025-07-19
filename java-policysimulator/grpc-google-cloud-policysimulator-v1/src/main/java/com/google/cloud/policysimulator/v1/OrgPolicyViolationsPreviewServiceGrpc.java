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
package com.google.cloud.policysimulator.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Violations Preview API service for OrgPolicy.
 * An
 * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
 * is a preview of the violations that will exist as soon as a proposed
 * OrgPolicy change is submitted. To create an
 * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
 * the API user specifies the changes they wish to make and requests the
 * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
 * Simulator service then scans the API user's currently existing resources to
 * determine these resources violate the newly set OrgPolicy.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/policysimulator/v1/orgpolicy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OrgPolicyViolationsPreviewServiceGrpc {

  private OrgPolicyViolationsPreviewServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.policysimulator.v1.OrgPolicyViolationsPreviewService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest,
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
      getListOrgPolicyViolationsPreviewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrgPolicyViolationsPreviews",
      requestType =
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest.class,
      responseType =
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest,
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
      getListOrgPolicyViolationsPreviewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest,
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
        getListOrgPolicyViolationsPreviewsMethod;
    if ((getListOrgPolicyViolationsPreviewsMethod =
            OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsPreviewsMethod)
        == null) {
      synchronized (OrgPolicyViolationsPreviewServiceGrpc.class) {
        if ((getListOrgPolicyViolationsPreviewsMethod =
                OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsPreviewsMethod)
            == null) {
          OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsPreviewsMethod =
              getListOrgPolicyViolationsPreviewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest,
                          com.google.cloud.policysimulator.v1
                              .ListOrgPolicyViolationsPreviewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrgPolicyViolationsPreviews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1
                                  .ListOrgPolicyViolationsPreviewsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1
                                  .ListOrgPolicyViolationsPreviewsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier(
                              "ListOrgPolicyViolationsPreviews"))
                      .build();
        }
      }
    }
    return getListOrgPolicyViolationsPreviewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest,
          com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
      getGetOrgPolicyViolationsPreviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOrgPolicyViolationsPreview",
      requestType = com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest.class,
      responseType = com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest,
          com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
      getGetOrgPolicyViolationsPreviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest,
            com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
        getGetOrgPolicyViolationsPreviewMethod;
    if ((getGetOrgPolicyViolationsPreviewMethod =
            OrgPolicyViolationsPreviewServiceGrpc.getGetOrgPolicyViolationsPreviewMethod)
        == null) {
      synchronized (OrgPolicyViolationsPreviewServiceGrpc.class) {
        if ((getGetOrgPolicyViolationsPreviewMethod =
                OrgPolicyViolationsPreviewServiceGrpc.getGetOrgPolicyViolationsPreviewMethod)
            == null) {
          OrgPolicyViolationsPreviewServiceGrpc.getGetOrgPolicyViolationsPreviewMethod =
              getGetOrgPolicyViolationsPreviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest,
                          com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetOrgPolicyViolationsPreview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1
                                  .GetOrgPolicyViolationsPreviewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier(
                              "GetOrgPolicyViolationsPreview"))
                      .build();
        }
      }
    }
    return getGetOrgPolicyViolationsPreviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest,
          com.google.longrunning.Operation>
      getCreateOrgPolicyViolationsPreviewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOrgPolicyViolationsPreview",
      requestType =
          com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest,
          com.google.longrunning.Operation>
      getCreateOrgPolicyViolationsPreviewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest,
            com.google.longrunning.Operation>
        getCreateOrgPolicyViolationsPreviewMethod;
    if ((getCreateOrgPolicyViolationsPreviewMethod =
            OrgPolicyViolationsPreviewServiceGrpc.getCreateOrgPolicyViolationsPreviewMethod)
        == null) {
      synchronized (OrgPolicyViolationsPreviewServiceGrpc.class) {
        if ((getCreateOrgPolicyViolationsPreviewMethod =
                OrgPolicyViolationsPreviewServiceGrpc.getCreateOrgPolicyViolationsPreviewMethod)
            == null) {
          OrgPolicyViolationsPreviewServiceGrpc.getCreateOrgPolicyViolationsPreviewMethod =
              getCreateOrgPolicyViolationsPreviewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateOrgPolicyViolationsPreview"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1
                                  .CreateOrgPolicyViolationsPreviewRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier(
                              "CreateOrgPolicyViolationsPreview"))
                      .build();
        }
      }
    }
    return getCreateOrgPolicyViolationsPreviewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest,
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
      getListOrgPolicyViolationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOrgPolicyViolations",
      requestType = com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest.class,
      responseType = com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest,
          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
      getListOrgPolicyViolationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest,
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
        getListOrgPolicyViolationsMethod;
    if ((getListOrgPolicyViolationsMethod =
            OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsMethod)
        == null) {
      synchronized (OrgPolicyViolationsPreviewServiceGrpc.class) {
        if ((getListOrgPolicyViolationsMethod =
                OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsMethod)
            == null) {
          OrgPolicyViolationsPreviewServiceGrpc.getListOrgPolicyViolationsMethod =
              getListOrgPolicyViolationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest,
                          com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListOrgPolicyViolations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier(
                              "ListOrgPolicyViolations"))
                      .build();
        }
      }
    }
    return getListOrgPolicyViolationsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static OrgPolicyViolationsPreviewServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceStub>() {
          @java.lang.Override
          public OrgPolicyViolationsPreviewServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyViolationsPreviewServiceStub(channel, callOptions);
          }
        };
    return OrgPolicyViolationsPreviewServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static OrgPolicyViolationsPreviewServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<
            OrgPolicyViolationsPreviewServiceBlockingV2Stub>() {
          @java.lang.Override
          public OrgPolicyViolationsPreviewServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyViolationsPreviewServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return OrgPolicyViolationsPreviewServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrgPolicyViolationsPreviewServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceBlockingStub>() {
          @java.lang.Override
          public OrgPolicyViolationsPreviewServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyViolationsPreviewServiceBlockingStub(channel, callOptions);
          }
        };
    return OrgPolicyViolationsPreviewServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static OrgPolicyViolationsPreviewServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<OrgPolicyViolationsPreviewServiceFutureStub>() {
          @java.lang.Override
          public OrgPolicyViolationsPreviewServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new OrgPolicyViolationsPreviewServiceFutureStub(channel, callOptions);
          }
        };
    return OrgPolicyViolationsPreviewServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolationsPreviews lists each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * in an organization. Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    default void listOrgPolicyViolationsPreviews(
        com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrgPolicyViolationsPreviewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetOrgPolicyViolationsPreview gets the specified
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    default void getOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetOrgPolicyViolationsPreviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateOrgPolicyViolationsPreview creates an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * for the proposed changes in the provided
     * [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy
     * are specified by this `OrgPolicyOverlay`. The resources to scan are
     * inferred from these specified changes.
     * </pre>
     */
    default void createOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateOrgPolicyViolationsPreviewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present
     * in an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * </pre>
     */
    default void listOrgPolicyViolations(
        com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOrgPolicyViolationsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OrgPolicyViolationsPreviewService.
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public abstract static class OrgPolicyViolationsPreviewServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return OrgPolicyViolationsPreviewServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * OrgPolicyViolationsPreviewService.
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public static final class OrgPolicyViolationsPreviewServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OrgPolicyViolationsPreviewServiceStub> {
    private OrgPolicyViolationsPreviewServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyViolationsPreviewServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyViolationsPreviewServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolationsPreviews lists each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * in an organization. Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public void listOrgPolicyViolationsPreviews(
        com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrgPolicyViolationsPreviewsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * GetOrgPolicyViolationsPreview gets the specified
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public void getOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOrgPolicyViolationsPreviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * CreateOrgPolicyViolationsPreview creates an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * for the proposed changes in the provided
     * [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy
     * are specified by this `OrgPolicyOverlay`. The resources to scan are
     * inferred from these specified changes.
     * </pre>
     */
    public void createOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOrgPolicyViolationsPreviewMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present
     * in an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * </pre>
     */
    public void listOrgPolicyViolations(
        com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOrgPolicyViolationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * OrgPolicyViolationsPreviewService.
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public static final class OrgPolicyViolationsPreviewServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OrgPolicyViolationsPreviewServiceBlockingV2Stub> {
    private OrgPolicyViolationsPreviewServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyViolationsPreviewServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyViolationsPreviewServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolationsPreviews lists each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * in an organization. Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse
        listOrgPolicyViolationsPreviews(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgPolicyViolationsPreviewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetOrgPolicyViolationsPreview gets the specified
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview
        getOrgPolicyViolationsPreview(
            com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrgPolicyViolationsPreviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateOrgPolicyViolationsPreview creates an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * for the proposed changes in the provided
     * [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy
     * are specified by this `OrgPolicyOverlay`. The resources to scan are
     * inferred from these specified changes.
     * </pre>
     */
    public com.google.longrunning.Operation createOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrgPolicyViolationsPreviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present
     * in an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse
        listOrgPolicyViolations(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgPolicyViolationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * OrgPolicyViolationsPreviewService.
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public static final class OrgPolicyViolationsPreviewServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OrgPolicyViolationsPreviewServiceBlockingStub> {
    private OrgPolicyViolationsPreviewServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyViolationsPreviewServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyViolationsPreviewServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolationsPreviews lists each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * in an organization. Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse
        listOrgPolicyViolationsPreviews(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgPolicyViolationsPreviewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * GetOrgPolicyViolationsPreview gets the specified
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview
        getOrgPolicyViolationsPreview(
            com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOrgPolicyViolationsPreviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * CreateOrgPolicyViolationsPreview creates an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * for the proposed changes in the provided
     * [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy
     * are specified by this `OrgPolicyOverlay`. The resources to scan are
     * inferred from these specified changes.
     * </pre>
     */
    public com.google.longrunning.Operation createOrgPolicyViolationsPreview(
        com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOrgPolicyViolationsPreviewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present
     * in an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * </pre>
     */
    public com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse
        listOrgPolicyViolations(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOrgPolicyViolationsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * OrgPolicyViolationsPreviewService.
   *
   * <pre>
   * Violations Preview API service for OrgPolicy.
   * An
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
   * is a preview of the violations that will exist as soon as a proposed
   * OrgPolicy change is submitted. To create an
   * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview],
   * the API user specifies the changes they wish to make and requests the
   * generation of a preview via [GenerateViolationsPreview][]. the OrgPolicy
   * Simulator service then scans the API user's currently existing resources to
   * determine these resources violate the newly set OrgPolicy.
   * </pre>
   */
  public static final class OrgPolicyViolationsPreviewServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OrgPolicyViolationsPreviewServiceFutureStub> {
    private OrgPolicyViolationsPreviewServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrgPolicyViolationsPreviewServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OrgPolicyViolationsPreviewServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolationsPreviews lists each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * in an organization. Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>
        listOrgPolicyViolationsPreviews(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrgPolicyViolationsPreviewsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * GetOrgPolicyViolationsPreview gets the specified
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * Each
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * is available for at least 7 days.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>
        getOrgPolicyViolationsPreview(
            com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOrgPolicyViolationsPreviewMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * CreateOrgPolicyViolationsPreview creates an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview]
     * for the proposed changes in the provided
     * [OrgPolicyViolationsPreview.OrgPolicyOverlay][]. The changes to OrgPolicy
     * are specified by this `OrgPolicyOverlay`. The resources to scan are
     * inferred from these specified changes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createOrgPolicyViolationsPreview(
            com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOrgPolicyViolationsPreviewMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * ListOrgPolicyViolations lists the [OrgPolicyViolations][] that are present
     * in an
     * [OrgPolicyViolationsPreview][google.cloud.policysimulator.v1.OrgPolicyViolationsPreview].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>
        listOrgPolicyViolations(
            com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOrgPolicyViolationsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_ORG_POLICY_VIOLATIONS_PREVIEWS = 0;
  private static final int METHODID_GET_ORG_POLICY_VIOLATIONS_PREVIEW = 1;
  private static final int METHODID_CREATE_ORG_POLICY_VIOLATIONS_PREVIEW = 2;
  private static final int METHODID_LIST_ORG_POLICY_VIOLATIONS = 3;

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
        case METHODID_LIST_ORG_POLICY_VIOLATIONS_PREVIEWS:
          serviceImpl.listOrgPolicyViolationsPreviews(
              (com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ORG_POLICY_VIOLATIONS_PREVIEW:
          serviceImpl.getOrgPolicyViolationsPreview(
              (com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>)
                  responseObserver);
          break;
        case METHODID_CREATE_ORG_POLICY_VIOLATIONS_PREVIEW:
          serviceImpl.createOrgPolicyViolationsPreview(
              (com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ORG_POLICY_VIOLATIONS:
          serviceImpl.listOrgPolicyViolations(
              (com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>)
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
            getListOrgPolicyViolationsPreviewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsRequest,
                    com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsPreviewsResponse>(
                    service, METHODID_LIST_ORG_POLICY_VIOLATIONS_PREVIEWS)))
        .addMethod(
            getGetOrgPolicyViolationsPreviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.GetOrgPolicyViolationsPreviewRequest,
                    com.google.cloud.policysimulator.v1.OrgPolicyViolationsPreview>(
                    service, METHODID_GET_ORG_POLICY_VIOLATIONS_PREVIEW)))
        .addMethod(
            getCreateOrgPolicyViolationsPreviewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.CreateOrgPolicyViolationsPreviewRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_ORG_POLICY_VIOLATIONS_PREVIEW)))
        .addMethod(
            getListOrgPolicyViolationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsRequest,
                    com.google.cloud.policysimulator.v1.ListOrgPolicyViolationsResponse>(
                    service, METHODID_LIST_ORG_POLICY_VIOLATIONS)))
        .build();
  }

  private abstract static class OrgPolicyViolationsPreviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrgPolicyViolationsPreviewServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.policysimulator.v1.OrgpolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrgPolicyViolationsPreviewService");
    }
  }

  private static final class OrgPolicyViolationsPreviewServiceFileDescriptorSupplier
      extends OrgPolicyViolationsPreviewServiceBaseDescriptorSupplier {
    OrgPolicyViolationsPreviewServiceFileDescriptorSupplier() {}
  }

  private static final class OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier
      extends OrgPolicyViolationsPreviewServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OrgPolicyViolationsPreviewServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OrgPolicyViolationsPreviewServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new OrgPolicyViolationsPreviewServiceFileDescriptorSupplier())
                      .addMethod(getListOrgPolicyViolationsPreviewsMethod())
                      .addMethod(getGetOrgPolicyViolationsPreviewMethod())
                      .addMethod(getCreateOrgPolicyViolationsPreviewMethod())
                      .addMethod(getListOrgPolicyViolationsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
