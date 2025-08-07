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
package com.google.shopping.merchant.issueresolution.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to provide an issue resolution content for account issues and product
 * issues.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/issueresolution/v1/issueresolution.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class IssueResolutionServiceGrpc {

  private IssueResolutionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.issueresolution.v1.IssueResolutionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest,
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
      getRenderAccountIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenderAccountIssues",
      requestType =
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest.class,
      responseType =
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest,
          com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
      getRenderAccountIssuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest,
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
        getRenderAccountIssuesMethod;
    if ((getRenderAccountIssuesMethod = IssueResolutionServiceGrpc.getRenderAccountIssuesMethod)
        == null) {
      synchronized (IssueResolutionServiceGrpc.class) {
        if ((getRenderAccountIssuesMethod = IssueResolutionServiceGrpc.getRenderAccountIssuesMethod)
            == null) {
          IssueResolutionServiceGrpc.getRenderAccountIssuesMethod =
              getRenderAccountIssuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest,
                          com.google.shopping.merchant.issueresolution.v1
                              .RenderAccountIssuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RenderAccountIssues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1
                                  .RenderAccountIssuesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1
                                  .RenderAccountIssuesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IssueResolutionServiceMethodDescriptorSupplier("RenderAccountIssues"))
                      .build();
        }
      }
    }
    return getRenderAccountIssuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest,
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
      getRenderProductIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RenderProductIssues",
      requestType =
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest.class,
      responseType =
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest,
          com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
      getRenderProductIssuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest,
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
        getRenderProductIssuesMethod;
    if ((getRenderProductIssuesMethod = IssueResolutionServiceGrpc.getRenderProductIssuesMethod)
        == null) {
      synchronized (IssueResolutionServiceGrpc.class) {
        if ((getRenderProductIssuesMethod = IssueResolutionServiceGrpc.getRenderProductIssuesMethod)
            == null) {
          IssueResolutionServiceGrpc.getRenderProductIssuesMethod =
              getRenderProductIssuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest,
                          com.google.shopping.merchant.issueresolution.v1
                              .RenderProductIssuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RenderProductIssues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1
                                  .RenderProductIssuesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1
                                  .RenderProductIssuesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IssueResolutionServiceMethodDescriptorSupplier("RenderProductIssues"))
                      .build();
        }
      }
    }
    return getRenderProductIssuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest,
          com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
      getTriggerActionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerAction",
      requestType = com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest.class,
      responseType = com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest,
          com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
      getTriggerActionMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest,
            com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
        getTriggerActionMethod;
    if ((getTriggerActionMethod = IssueResolutionServiceGrpc.getTriggerActionMethod) == null) {
      synchronized (IssueResolutionServiceGrpc.class) {
        if ((getTriggerActionMethod = IssueResolutionServiceGrpc.getTriggerActionMethod) == null) {
          IssueResolutionServiceGrpc.getTriggerActionMethod =
              getTriggerActionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest,
                          com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerAction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new IssueResolutionServiceMethodDescriptorSupplier("TriggerAction"))
                      .build();
        }
      }
    }
    return getTriggerActionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static IssueResolutionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceStub>() {
          @java.lang.Override
          public IssueResolutionServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IssueResolutionServiceStub(channel, callOptions);
          }
        };
    return IssueResolutionServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static IssueResolutionServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceBlockingV2Stub>() {
          @java.lang.Override
          public IssueResolutionServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IssueResolutionServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return IssueResolutionServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static IssueResolutionServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceBlockingStub>() {
          @java.lang.Override
          public IssueResolutionServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IssueResolutionServiceBlockingStub(channel, callOptions);
          }
        };
    return IssueResolutionServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static IssueResolutionServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<IssueResolutionServiceFutureStub>() {
          @java.lang.Override
          public IssueResolutionServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new IssueResolutionServiceFutureStub(channel, callOptions);
          }
        };
    return IssueResolutionServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Provide a list of business's account issues with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    default void renderAccountIssues(
        com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenderAccountIssuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of issues for business's product with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    default void renderProductIssues(
        com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRenderProductIssuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start an action. The action can be requested by a business in
     * third-party application. Before the business can request the action, the
     * third-party application needs to show them action specific content and
     * display a user input form.
     * The action can be successfully started only once all `required` inputs are
     * provided. If any `required` input is missing, or invalid value was
     * provided, the service will return 400 error. Validation errors will contain
     * [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all
     * problematic field together with translated, human readable error messages
     * that can be shown to the user.
     * </pre>
     */
    default void triggerAction(
        com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTriggerActionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service IssueResolutionService.
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public abstract static class IssueResolutionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return IssueResolutionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service IssueResolutionService.
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public static final class IssueResolutionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<IssueResolutionServiceStub> {
    private IssueResolutionServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IssueResolutionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IssueResolutionServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of business's account issues with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public void renderAccountIssues(
        com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenderAccountIssuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of issues for business's product with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public void renderProductIssues(
        com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRenderProductIssuesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Start an action. The action can be requested by a business in
     * third-party application. Before the business can request the action, the
     * third-party application needs to show them action specific content and
     * display a user input form.
     * The action can be successfully started only once all `required` inputs are
     * provided. If any `required` input is missing, or invalid value was
     * provided, the service will return 400 error. Validation errors will contain
     * [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all
     * problematic field together with translated, human readable error messages
     * that can be shown to the user.
     * </pre>
     */
    public void triggerAction(
        com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerActionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service IssueResolutionService.
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public static final class IssueResolutionServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<IssueResolutionServiceBlockingV2Stub> {
    private IssueResolutionServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IssueResolutionServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IssueResolutionServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of business's account issues with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse
        renderAccountIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderAccountIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of issues for business's product with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse
        renderProductIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderProductIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start an action. The action can be requested by a business in
     * third-party application. Before the business can request the action, the
     * third-party application needs to show them action specific content and
     * display a user input form.
     * The action can be successfully started only once all `required` inputs are
     * provided. If any `required` input is missing, or invalid value was
     * provided, the service will return 400 error. Validation errors will contain
     * [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all
     * problematic field together with translated, human readable error messages
     * that can be shown to the user.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse triggerAction(
        com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerActionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service IssueResolutionService.
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public static final class IssueResolutionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<IssueResolutionServiceBlockingStub> {
    private IssueResolutionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IssueResolutionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IssueResolutionServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of business's account issues with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse
        renderAccountIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderAccountIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of issues for business's product with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse
        renderProductIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRenderProductIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Start an action. The action can be requested by a business in
     * third-party application. Before the business can request the action, the
     * third-party application needs to show them action specific content and
     * display a user input form.
     * The action can be successfully started only once all `required` inputs are
     * provided. If any `required` input is missing, or invalid value was
     * provided, the service will return 400 error. Validation errors will contain
     * [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all
     * problematic field together with translated, human readable error messages
     * that can be shown to the user.
     * </pre>
     */
    public com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse triggerAction(
        com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerActionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * IssueResolutionService.
   *
   * <pre>
   * Service to provide an issue resolution content for account issues and product
   * issues.
   * </pre>
   */
  public static final class IssueResolutionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<IssueResolutionServiceFutureStub> {
    private IssueResolutionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected IssueResolutionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new IssueResolutionServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of business's account issues with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>
        renderAccountIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenderAccountIssuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Provide a list of issues for business's product with an issue resolution
     * content and available actions. This content and actions are meant to be
     * rendered and shown in third-party applications.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>
        renderProductIssues(
            com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRenderProductIssuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Start an action. The action can be requested by a business in
     * third-party application. Before the business can request the action, the
     * third-party application needs to show them action specific content and
     * display a user input form.
     * The action can be successfully started only once all `required` inputs are
     * provided. If any `required` input is missing, or invalid value was
     * provided, the service will return 400 error. Validation errors will contain
     * [Ids][google.shopping.merchant.issueresolution.v1.InputField.id] for all
     * problematic field together with translated, human readable error messages
     * that can be shown to the user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>
        triggerAction(
            com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerActionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RENDER_ACCOUNT_ISSUES = 0;
  private static final int METHODID_RENDER_PRODUCT_ISSUES = 1;
  private static final int METHODID_TRIGGER_ACTION = 2;

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
        case METHODID_RENDER_ACCOUNT_ISSUES:
          serviceImpl.renderAccountIssues(
              (com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>)
                  responseObserver);
          break;
        case METHODID_RENDER_PRODUCT_ISSUES:
          serviceImpl.renderProductIssues(
              (com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>)
                  responseObserver);
          break;
        case METHODID_TRIGGER_ACTION:
          serviceImpl.triggerAction(
              (com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>)
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
            getRenderAccountIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesRequest,
                    com.google.shopping.merchant.issueresolution.v1.RenderAccountIssuesResponse>(
                    service, METHODID_RENDER_ACCOUNT_ISSUES)))
        .addMethod(
            getRenderProductIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesRequest,
                    com.google.shopping.merchant.issueresolution.v1.RenderProductIssuesResponse>(
                    service, METHODID_RENDER_PRODUCT_ISSUES)))
        .addMethod(
            getTriggerActionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.issueresolution.v1.TriggerActionRequest,
                    com.google.shopping.merchant.issueresolution.v1.TriggerActionResponse>(
                    service, METHODID_TRIGGER_ACTION)))
        .build();
  }

  private abstract static class IssueResolutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    IssueResolutionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.issueresolution.v1.IssueResolutionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("IssueResolutionService");
    }
  }

  private static final class IssueResolutionServiceFileDescriptorSupplier
      extends IssueResolutionServiceBaseDescriptorSupplier {
    IssueResolutionServiceFileDescriptorSupplier() {}
  }

  private static final class IssueResolutionServiceMethodDescriptorSupplier
      extends IssueResolutionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    IssueResolutionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (IssueResolutionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new IssueResolutionServiceFileDescriptorSupplier())
                      .addMethod(getRenderAccountIssuesMethod())
                      .addMethod(getRenderProductIssuesMethod())
                      .addMethod(getTriggerActionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
