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
 * Service for program management.
 * Programs provide a mechanism for adding functionality to merchant accounts. A
 * typical example of this is the [Free product
 * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
 * program, which enables products from a merchant's store to be shown across
 * Google for free.
 * This service exposes methods to retrieve a merchant's
 * participation in all available programs, in addition to methods for
 * explicitly enabling or disabling participation in each program.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/shopping/merchant/accounts/v1beta/programs.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProgramsServiceGrpc {

  private ProgramsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.shopping.merchant.accounts.v1beta.ProgramsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getGetProgramMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProgram",
      requestType = com.google.shopping.merchant.accounts.v1beta.GetProgramRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Program.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.GetProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getGetProgramMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.GetProgramRequest,
            com.google.shopping.merchant.accounts.v1beta.Program>
        getGetProgramMethod;
    if ((getGetProgramMethod = ProgramsServiceGrpc.getGetProgramMethod) == null) {
      synchronized (ProgramsServiceGrpc.class) {
        if ((getGetProgramMethod = ProgramsServiceGrpc.getGetProgramMethod) == null) {
          ProgramsServiceGrpc.getGetProgramMethod =
              getGetProgramMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.GetProgramRequest,
                          com.google.shopping.merchant.accounts.v1beta.Program>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProgram"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.GetProgramRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Program
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProgramsServiceMethodDescriptorSupplier("GetProgram"))
                      .build();
        }
      }
    }
    return getGetProgramMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
      getListProgramsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPrograms",
      requestType = com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest,
          com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
      getListProgramsMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest,
            com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
        getListProgramsMethod;
    if ((getListProgramsMethod = ProgramsServiceGrpc.getListProgramsMethod) == null) {
      synchronized (ProgramsServiceGrpc.class) {
        if ((getListProgramsMethod = ProgramsServiceGrpc.getListProgramsMethod) == null) {
          ProgramsServiceGrpc.getListProgramsMethod =
              getListProgramsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest,
                          com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPrograms"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProgramsServiceMethodDescriptorSupplier("ListPrograms"))
                      .build();
        }
      }
    }
    return getListProgramsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getEnableProgramMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableProgram",
      requestType = com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Program.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getEnableProgramMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest,
            com.google.shopping.merchant.accounts.v1beta.Program>
        getEnableProgramMethod;
    if ((getEnableProgramMethod = ProgramsServiceGrpc.getEnableProgramMethod) == null) {
      synchronized (ProgramsServiceGrpc.class) {
        if ((getEnableProgramMethod = ProgramsServiceGrpc.getEnableProgramMethod) == null) {
          ProgramsServiceGrpc.getEnableProgramMethod =
              getEnableProgramMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest,
                          com.google.shopping.merchant.accounts.v1beta.Program>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableProgram"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Program
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProgramsServiceMethodDescriptorSupplier("EnableProgram"))
                      .build();
        }
      }
    }
    return getEnableProgramMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getDisableProgramMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableProgram",
      requestType = com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest.class,
      responseType = com.google.shopping.merchant.accounts.v1beta.Program.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest,
          com.google.shopping.merchant.accounts.v1beta.Program>
      getDisableProgramMethod() {
    io.grpc.MethodDescriptor<
            com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest,
            com.google.shopping.merchant.accounts.v1beta.Program>
        getDisableProgramMethod;
    if ((getDisableProgramMethod = ProgramsServiceGrpc.getDisableProgramMethod) == null) {
      synchronized (ProgramsServiceGrpc.class) {
        if ((getDisableProgramMethod = ProgramsServiceGrpc.getDisableProgramMethod) == null) {
          ProgramsServiceGrpc.getDisableProgramMethod =
              getDisableProgramMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest,
                          com.google.shopping.merchant.accounts.v1beta.Program>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableProgram"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.shopping.merchant.accounts.v1beta.Program
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ProgramsServiceMethodDescriptorSupplier("DisableProgram"))
                      .build();
        }
      }
    }
    return getDisableProgramMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ProgramsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceStub>() {
          @java.lang.Override
          public ProgramsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProgramsServiceStub(channel, callOptions);
          }
        };
    return ProgramsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProgramsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceBlockingStub>() {
          @java.lang.Override
          public ProgramsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProgramsServiceBlockingStub(channel, callOptions);
          }
        };
    return ProgramsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ProgramsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ProgramsServiceFutureStub>() {
          @java.lang.Override
          public ProgramsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ProgramsServiceFutureStub(channel, callOptions);
          }
        };
    return ProgramsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for program management.
   * Programs provide a mechanism for adding functionality to merchant accounts. A
   * typical example of this is the [Free product
   * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
   * program, which enables products from a merchant's store to be shown across
   * Google for free.
   * This service exposes methods to retrieve a merchant's
   * participation in all available programs, in addition to methods for
   * explicitly enabling or disabling participation in each program.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Retrieves the specified program for the account.
     * </pre>
     */
    default void getProgram(
        com.google.shopping.merchant.accounts.v1beta.GetProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProgramMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all programs for the account.
     * </pre>
     */
    default void listPrograms(
        com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProgramsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    default void enableProgram(
        com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableProgramMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    default void disableProgram(
        com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableProgramMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ProgramsService.
   *
   * <pre>
   * Service for program management.
   * Programs provide a mechanism for adding functionality to merchant accounts. A
   * typical example of this is the [Free product
   * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
   * program, which enables products from a merchant's store to be shown across
   * Google for free.
   * This service exposes methods to retrieve a merchant's
   * participation in all available programs, in addition to methods for
   * explicitly enabling or disabling participation in each program.
   * </pre>
   */
  public abstract static class ProgramsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ProgramsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ProgramsService.
   *
   * <pre>
   * Service for program management.
   * Programs provide a mechanism for adding functionality to merchant accounts. A
   * typical example of this is the [Free product
   * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
   * program, which enables products from a merchant's store to be shown across
   * Google for free.
   * This service exposes methods to retrieve a merchant's
   * participation in all available programs, in addition to methods for
   * explicitly enabling or disabling participation in each program.
   * </pre>
   */
  public static final class ProgramsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ProgramsServiceStub> {
    private ProgramsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgramsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgramsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified program for the account.
     * </pre>
     */
    public void getProgram(
        com.google.shopping.merchant.accounts.v1beta.GetProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProgramMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all programs for the account.
     * </pre>
     */
    public void listPrograms(
        com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProgramsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public void enableProgram(
        com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableProgramMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public void disableProgram(
        com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest request,
        io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableProgramMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ProgramsService.
   *
   * <pre>
   * Service for program management.
   * Programs provide a mechanism for adding functionality to merchant accounts. A
   * typical example of this is the [Free product
   * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
   * program, which enables products from a merchant's store to be shown across
   * Google for free.
   * This service exposes methods to retrieve a merchant's
   * participation in all available programs, in addition to methods for
   * explicitly enabling or disabling participation in each program.
   * </pre>
   */
  public static final class ProgramsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ProgramsServiceBlockingStub> {
    private ProgramsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgramsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgramsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified program for the account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Program getProgram(
        com.google.shopping.merchant.accounts.v1beta.GetProgramRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProgramMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all programs for the account.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse listPrograms(
        com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProgramsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Program enableProgram(
        com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableProgramMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.shopping.merchant.accounts.v1beta.Program disableProgram(
        com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableProgramMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ProgramsService.
   *
   * <pre>
   * Service for program management.
   * Programs provide a mechanism for adding functionality to merchant accounts. A
   * typical example of this is the [Free product
   * listings](https://support.google.com/merchants/topic/9240261?ref_topic=7257954,7259405,&amp;sjid=796648681813264022-EU)
   * program, which enables products from a merchant's store to be shown across
   * Google for free.
   * This service exposes methods to retrieve a merchant's
   * participation in all available programs, in addition to methods for
   * explicitly enabling or disabling participation in each program.
   * </pre>
   */
  public static final class ProgramsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ProgramsServiceFutureStub> {
    private ProgramsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProgramsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProgramsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified program for the account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Program>
        getProgram(com.google.shopping.merchant.accounts.v1beta.GetProgramRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProgramMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves all programs for the account.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>
        listPrograms(com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProgramsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Program>
        enableProgram(com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableProgramMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disable participation in the specified program for the account. Executing
     * this method requires admin access.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.shopping.merchant.accounts.v1beta.Program>
        disableProgram(com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableProgramMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROGRAM = 0;
  private static final int METHODID_LIST_PROGRAMS = 1;
  private static final int METHODID_ENABLE_PROGRAM = 2;
  private static final int METHODID_DISABLE_PROGRAM = 3;

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
        case METHODID_GET_PROGRAM:
          serviceImpl.getProgram(
              (com.google.shopping.merchant.accounts.v1beta.GetProgramRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>)
                  responseObserver);
          break;
        case METHODID_LIST_PROGRAMS:
          serviceImpl.listPrograms(
              (com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>)
                  responseObserver);
          break;
        case METHODID_ENABLE_PROGRAM:
          serviceImpl.enableProgram(
              (com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>)
                  responseObserver);
          break;
        case METHODID_DISABLE_PROGRAM:
          serviceImpl.disableProgram(
              (com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest) request,
              (io.grpc.stub.StreamObserver<com.google.shopping.merchant.accounts.v1beta.Program>)
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
            getGetProgramMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.GetProgramRequest,
                    com.google.shopping.merchant.accounts.v1beta.Program>(
                    service, METHODID_GET_PROGRAM)))
        .addMethod(
            getListProgramsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.ListProgramsRequest,
                    com.google.shopping.merchant.accounts.v1beta.ListProgramsResponse>(
                    service, METHODID_LIST_PROGRAMS)))
        .addMethod(
            getEnableProgramMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.EnableProgramRequest,
                    com.google.shopping.merchant.accounts.v1beta.Program>(
                    service, METHODID_ENABLE_PROGRAM)))
        .addMethod(
            getDisableProgramMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.shopping.merchant.accounts.v1beta.DisableProgramRequest,
                    com.google.shopping.merchant.accounts.v1beta.Program>(
                    service, METHODID_DISABLE_PROGRAM)))
        .build();
  }

  private abstract static class ProgramsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProgramsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.shopping.merchant.accounts.v1beta.ProgramsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProgramsService");
    }
  }

  private static final class ProgramsServiceFileDescriptorSupplier
      extends ProgramsServiceBaseDescriptorSupplier {
    ProgramsServiceFileDescriptorSupplier() {}
  }

  private static final class ProgramsServiceMethodDescriptorSupplier
      extends ProgramsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ProgramsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ProgramsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ProgramsServiceFileDescriptorSupplier())
                      .addMethod(getGetProgramMethod())
                      .addMethod(getListProgramsMethod())
                      .addMethod(getEnableProgramMethod())
                      .addMethod(getDisableProgramMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
