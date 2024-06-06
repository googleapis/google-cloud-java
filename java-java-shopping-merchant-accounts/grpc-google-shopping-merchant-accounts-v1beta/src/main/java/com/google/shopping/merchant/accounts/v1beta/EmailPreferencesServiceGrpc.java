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
package com.google.shopping.merchant.accounts.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to support the `EmailPreferences` API.
 * This service only permits retrieving and updating email preferences for the
 * authenticated user.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/emailpreferences.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EmailPreferencesServiceGrpc {

  private EmailPreferencesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.EmailPreferencesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest,
          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
      getGetEmailPreferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEmailPreferences",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.EmailPreferences.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest,
          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
      getGetEmailPreferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest,
            com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
        getGetEmailPreferencesMethod;
    if ((getGetEmailPreferencesMethod = EmailPreferencesServiceGrpc.getGetEmailPreferencesMethod)
        == null) {
      synchronized (EmailPreferencesServiceGrpc.class) {
        if ((getGetEmailPreferencesMethod =
                EmailPreferencesServiceGrpc.getGetEmailPreferencesMethod)
            == null) {
          EmailPreferencesServiceGrpc.getGetEmailPreferencesMethod =
              getGetEmailPreferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest,
                          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEmailPreferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .GetEmailPreferencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.EmailPreferences
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EmailPreferencesServiceMethodDescriptorSupplier(
                              "GetEmailPreferences"))
                      .build();
        }
      }
    }
    return getGetEmailPreferencesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest,
          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
      getUpdateEmailPreferencesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEmailPreferences",
      requestType =
          com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.EmailPreferences.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest,
          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
      getUpdateEmailPreferencesMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest,
            com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
        getUpdateEmailPreferencesMethod;
    if ((getUpdateEmailPreferencesMethod =
            EmailPreferencesServiceGrpc.getUpdateEmailPreferencesMethod)
        == null) {
      synchronized (EmailPreferencesServiceGrpc.class) {
        if ((getUpdateEmailPreferencesMethod =
                EmailPreferencesServiceGrpc.getUpdateEmailPreferencesMethod)
            == null) {
          EmailPreferencesServiceGrpc.getUpdateEmailPreferencesMethod =
              getUpdateEmailPreferencesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest,
                          com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEmailPreferences"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta
                                  .UpdateEmailPreferencesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.EmailPreferences
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EmailPreferencesServiceMethodDescriptorSupplier(
                              "UpdateEmailPreferences"))
                      .build();
        }
      }
    }
    return getUpdateEmailPreferencesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EmailPreferencesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceStub>() {
          @java.lang.Override
          public EmailPreferencesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EmailPreferencesServiceStub(channel, callOptions);
          }
        };
    return EmailPreferencesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EmailPreferencesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceBlockingStub>() {
          @java.lang.Override
          public EmailPreferencesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EmailPreferencesServiceBlockingStub(channel, callOptions);
          }
        };
    return EmailPreferencesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EmailPreferencesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EmailPreferencesServiceFutureStub>() {
          @java.lang.Override
          public EmailPreferencesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EmailPreferencesServiceFutureStub(channel, callOptions);
          }
        };
    return EmailPreferencesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to support the `EmailPreferences` API.
   * This service only permits retrieving and updating email preferences for the
   * authenticated user.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the email preferences for a Merchant Center account user.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to get preferences
     * for the authenticated user.
     * </pre>
     */
    default void getEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEmailPreferencesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the email preferences for a Merchant Center account user. MCA users
     * should specify the MCA account rather than a sub-account of the MCA.
     * Preferences which are not explicitly selected in the update mask will not
     * be updated.
     * It is invalid for updates to specify an UNCONFIRMED opt-in status value.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to update
     * preferences
     * for the authenticated user.
     * </pre>
     */
    default void updateEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEmailPreferencesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EmailPreferencesService.
   *
   * <pre>
   * Service to support the `EmailPreferences` API.
   * This service only permits retrieving and updating email preferences for the
   * authenticated user.
   * </pre>
   */
  public abstract static class EmailPreferencesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EmailPreferencesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EmailPreferencesService.
   *
   * <pre>
   * Service to support the `EmailPreferences` API.
   * This service only permits retrieving and updating email preferences for the
   * authenticated user.
   * </pre>
   */
  public static final class EmailPreferencesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EmailPreferencesServiceStub> {
    private EmailPreferencesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailPreferencesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailPreferencesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the email preferences for a Merchant Center account user.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to get preferences
     * for the authenticated user.
     * </pre>
     */
    public void getEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEmailPreferencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the email preferences for a Merchant Center account user. MCA users
     * should specify the MCA account rather than a sub-account of the MCA.
     * Preferences which are not explicitly selected in the update mask will not
     * be updated.
     * It is invalid for updates to specify an UNCONFIRMED opt-in status value.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to update
     * preferences
     * for the authenticated user.
     * </pre>
     */
    public void updateEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEmailPreferencesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EmailPreferencesService.
   *
   * <pre>
   * Service to support the `EmailPreferences` API.
   * This service only permits retrieving and updating email preferences for the
   * authenticated user.
   * </pre>
   */
  public static final class EmailPreferencesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EmailPreferencesServiceBlockingStub> {
    private EmailPreferencesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailPreferencesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailPreferencesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the email preferences for a Merchant Center account user.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to get preferences
     * for the authenticated user.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.EmailPreferences getEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEmailPreferencesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the email preferences for a Merchant Center account user. MCA users
     * should specify the MCA account rather than a sub-account of the MCA.
     * Preferences which are not explicitly selected in the update mask will not
     * be updated.
     * It is invalid for updates to specify an UNCONFIRMED opt-in status value.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to update
     * preferences
     * for the authenticated user.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.EmailPreferences updateEmailPreferences(
        com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEmailPreferencesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * EmailPreferencesService.
   *
   * <pre>
   * Service to support the `EmailPreferences` API.
   * This service only permits retrieving and updating email preferences for the
   * authenticated user.
   * </pre>
   */
  public static final class EmailPreferencesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EmailPreferencesServiceFutureStub> {
    private EmailPreferencesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EmailPreferencesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EmailPreferencesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the email preferences for a Merchant Center account user.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to get preferences
     * for the authenticated user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
        getEmailPreferences(
            com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEmailPreferencesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the email preferences for a Merchant Center account user. MCA users
     * should specify the MCA account rather than a sub-account of the MCA.
     * Preferences which are not explicitly selected in the update mask will not
     * be updated.
     * It is invalid for updates to specify an UNCONFIRMED opt-in status value.
     * Use the name=accounts/&#42;&#47;users/me/emailPreferences alias to update
     * preferences
     * for the authenticated user.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.EmailPreferences>
        updateEmailPreferences(
            com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEmailPreferencesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EMAIL_PREFERENCES = 0;
  private static final int METHODID_UPDATE_EMAIL_PREFERENCES = 1;

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
        case METHODID_GET_EMAIL_PREFERENCES:
          serviceImpl.getEmailPreferences(
              (com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.EmailPreferences>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EMAIL_PREFERENCES:
          serviceImpl.updateEmailPreferences(
              (com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.EmailPreferences>)
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
            getGetEmailPreferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetEmailPreferencesRequest,
                    com.google.shopping.merchant.accounts.v1beta.EmailPreferences>(
                    service, METHODID_GET_EMAIL_PREFERENCES)))
        .addMethod(
            getUpdateEmailPreferencesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.UpdateEmailPreferencesRequest,
                    com.google.shopping.merchant.accounts.v1beta.EmailPreferences>(
                    service, METHODID_UPDATE_EMAIL_PREFERENCES)))
        .build();
  }

  private abstract static class EmailPreferencesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EmailPreferencesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.EmailPreferencesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EmailPreferencesService");
    }
  }

  private static final class EmailPreferencesServiceFileDescriptorSupplier
      extends EmailPreferencesServiceBaseDescriptorSupplier {
    EmailPreferencesServiceFileDescriptorSupplier() {}
  }

  private static final class EmailPreferencesServiceMethodDescriptorSupplier
      extends EmailPreferencesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EmailPreferencesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EmailPreferencesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EmailPreferencesServiceFileDescriptorSupplier())
                      .addMethod(getGetEmailPreferencesMethod())
                      .addMethod(getUpdateEmailPreferencesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
