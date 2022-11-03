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
package com.google.cloud.contentwarehouse.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to manage customer specific RuleSets.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contentwarehouse/v1/ruleset_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RuleSetServiceGrpc {

  private RuleSetServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.contentwarehouse.v1.RuleSetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getCreateRuleSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRuleSet",
      requestType = com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.RuleSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getCreateRuleSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest,
            com.google.cloud.contentwarehouse.v1.RuleSet>
        getCreateRuleSetMethod;
    if ((getCreateRuleSetMethod = RuleSetServiceGrpc.getCreateRuleSetMethod) == null) {
      synchronized (RuleSetServiceGrpc.class) {
        if ((getCreateRuleSetMethod = RuleSetServiceGrpc.getCreateRuleSetMethod) == null) {
          RuleSetServiceGrpc.getCreateRuleSetMethod =
              getCreateRuleSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest,
                          com.google.cloud.contentwarehouse.v1.RuleSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRuleSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.RuleSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleSetServiceMethodDescriptorSupplier("CreateRuleSet"))
                      .build();
        }
      }
    }
    return getCreateRuleSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.GetRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getGetRuleSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRuleSet",
      requestType = com.google.cloud.contentwarehouse.v1.GetRuleSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.RuleSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.GetRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getGetRuleSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.GetRuleSetRequest,
            com.google.cloud.contentwarehouse.v1.RuleSet>
        getGetRuleSetMethod;
    if ((getGetRuleSetMethod = RuleSetServiceGrpc.getGetRuleSetMethod) == null) {
      synchronized (RuleSetServiceGrpc.class) {
        if ((getGetRuleSetMethod = RuleSetServiceGrpc.getGetRuleSetMethod) == null) {
          RuleSetServiceGrpc.getGetRuleSetMethod =
              getGetRuleSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.GetRuleSetRequest,
                          com.google.cloud.contentwarehouse.v1.RuleSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRuleSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.GetRuleSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.RuleSet.getDefaultInstance()))
                      .setSchemaDescriptor(new RuleSetServiceMethodDescriptorSupplier("GetRuleSet"))
                      .build();
        }
      }
    }
    return getGetRuleSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getUpdateRuleSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRuleSet",
      requestType = com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.RuleSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest,
          com.google.cloud.contentwarehouse.v1.RuleSet>
      getUpdateRuleSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest,
            com.google.cloud.contentwarehouse.v1.RuleSet>
        getUpdateRuleSetMethod;
    if ((getUpdateRuleSetMethod = RuleSetServiceGrpc.getUpdateRuleSetMethod) == null) {
      synchronized (RuleSetServiceGrpc.class) {
        if ((getUpdateRuleSetMethod = RuleSetServiceGrpc.getUpdateRuleSetMethod) == null) {
          RuleSetServiceGrpc.getUpdateRuleSetMethod =
              getUpdateRuleSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest,
                          com.google.cloud.contentwarehouse.v1.RuleSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRuleSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.RuleSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleSetServiceMethodDescriptorSupplier("UpdateRuleSet"))
                      .build();
        }
      }
    }
    return getUpdateRuleSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest, com.google.protobuf.Empty>
      getDeleteRuleSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRuleSet",
      requestType = com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest, com.google.protobuf.Empty>
      getDeleteRuleSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest, com.google.protobuf.Empty>
        getDeleteRuleSetMethod;
    if ((getDeleteRuleSetMethod = RuleSetServiceGrpc.getDeleteRuleSetMethod) == null) {
      synchronized (RuleSetServiceGrpc.class) {
        if ((getDeleteRuleSetMethod = RuleSetServiceGrpc.getDeleteRuleSetMethod) == null) {
          RuleSetServiceGrpc.getDeleteRuleSetMethod =
              getDeleteRuleSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRuleSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleSetServiceMethodDescriptorSupplier("DeleteRuleSet"))
                      .build();
        }
      }
    }
    return getDeleteRuleSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest,
          com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
      getListRuleSetsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRuleSets",
      requestType = com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest.class,
      responseType = com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest,
          com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
      getListRuleSetsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest,
            com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
        getListRuleSetsMethod;
    if ((getListRuleSetsMethod = RuleSetServiceGrpc.getListRuleSetsMethod) == null) {
      synchronized (RuleSetServiceGrpc.class) {
        if ((getListRuleSetsMethod = RuleSetServiceGrpc.getListRuleSetsMethod) == null) {
          RuleSetServiceGrpc.getListRuleSetsMethod =
              getListRuleSetsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest,
                          com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRuleSets"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RuleSetServiceMethodDescriptorSupplier("ListRuleSets"))
                      .build();
        }
      }
    }
    return getListRuleSetsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RuleSetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceStub>() {
          @java.lang.Override
          public RuleSetServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleSetServiceStub(channel, callOptions);
          }
        };
    return RuleSetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RuleSetServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceBlockingStub>() {
          @java.lang.Override
          public RuleSetServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleSetServiceBlockingStub(channel, callOptions);
          }
        };
    return RuleSetServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RuleSetServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RuleSetServiceFutureStub>() {
          @java.lang.Override
          public RuleSetServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RuleSetServiceFutureStub(channel, callOptions);
          }
        };
    return RuleSetServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to manage customer specific RuleSets.
   * </pre>
   */
  public abstract static class RuleSetServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a ruleset.
     * </pre>
     */
    public void createRuleSet(
        com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRuleSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
     * </pre>
     */
    public void getRuleSet(
        com.google.cloud.contentwarehouse.v1.GetRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRuleSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public void updateRuleSet(
        com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRuleSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public void deleteRuleSet(
        com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRuleSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rulesets.
     * </pre>
     */
    public void listRuleSets(
        com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRuleSetsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateRuleSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest,
                      com.google.cloud.contentwarehouse.v1.RuleSet>(
                      this, METHODID_CREATE_RULE_SET)))
          .addMethod(
              getGetRuleSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.GetRuleSetRequest,
                      com.google.cloud.contentwarehouse.v1.RuleSet>(this, METHODID_GET_RULE_SET)))
          .addMethod(
              getUpdateRuleSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest,
                      com.google.cloud.contentwarehouse.v1.RuleSet>(
                      this, METHODID_UPDATE_RULE_SET)))
          .addMethod(
              getDeleteRuleSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_RULE_SET)))
          .addMethod(
              getListRuleSetsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest,
                      com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>(
                      this, METHODID_LIST_RULE_SETS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage customer specific RuleSets.
   * </pre>
   */
  public static final class RuleSetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RuleSetServiceStub> {
    private RuleSetServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleSetServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleSetServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ruleset.
     * </pre>
     */
    public void createRuleSet(
        com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRuleSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
     * </pre>
     */
    public void getRuleSet(
        com.google.cloud.contentwarehouse.v1.GetRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRuleSetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public void updateRuleSet(
        com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRuleSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public void deleteRuleSet(
        com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRuleSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists rulesets.
     * </pre>
     */
    public void listRuleSets(
        com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRuleSetsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage customer specific RuleSets.
   * </pre>
   */
  public static final class RuleSetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RuleSetServiceBlockingStub> {
    private RuleSetServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleSetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleSetServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ruleset.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.RuleSet createRuleSet(
        com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRuleSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.RuleSet getRuleSet(
        com.google.cloud.contentwarehouse.v1.GetRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRuleSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.RuleSet updateRuleSet(
        com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRuleSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteRuleSet(
        com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRuleSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rulesets.
     * </pre>
     */
    public com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse listRuleSets(
        com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRuleSetsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to manage customer specific RuleSets.
   * </pre>
   */
  public static final class RuleSetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RuleSetServiceFutureStub> {
    private RuleSetServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RuleSetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RuleSetServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ruleset.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.RuleSet>
        createRuleSet(com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRuleSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ruleset. Returns NOT_FOUND if the ruleset does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.RuleSet>
        getRuleSet(com.google.cloud.contentwarehouse.v1.GetRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRuleSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ruleset. Returns INVALID_ARGUMENT if the name of the ruleset
     * is non-empty and does not equal the existing name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.RuleSet>
        updateRuleSet(com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRuleSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ruleset. Returns NOT_FOUND if the document does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteRuleSet(com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRuleSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists rulesets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>
        listRuleSets(com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRuleSetsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RULE_SET = 0;
  private static final int METHODID_GET_RULE_SET = 1;
  private static final int METHODID_UPDATE_RULE_SET = 2;
  private static final int METHODID_DELETE_RULE_SET = 3;
  private static final int METHODID_LIST_RULE_SETS = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RuleSetServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RuleSetServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_RULE_SET:
          serviceImpl.createRuleSet(
              (com.google.cloud.contentwarehouse.v1.CreateRuleSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>)
                  responseObserver);
          break;
        case METHODID_GET_RULE_SET:
          serviceImpl.getRuleSet(
              (com.google.cloud.contentwarehouse.v1.GetRuleSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>)
                  responseObserver);
          break;
        case METHODID_UPDATE_RULE_SET:
          serviceImpl.updateRuleSet(
              (com.google.cloud.contentwarehouse.v1.UpdateRuleSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contentwarehouse.v1.RuleSet>)
                  responseObserver);
          break;
        case METHODID_DELETE_RULE_SET:
          serviceImpl.deleteRuleSet(
              (com.google.cloud.contentwarehouse.v1.DeleteRuleSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_RULE_SETS:
          serviceImpl.listRuleSets(
              (com.google.cloud.contentwarehouse.v1.ListRuleSetsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contentwarehouse.v1.ListRuleSetsResponse>)
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

  private abstract static class RuleSetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RuleSetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contentwarehouse.v1.RuleSetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RuleSetService");
    }
  }

  private static final class RuleSetServiceFileDescriptorSupplier
      extends RuleSetServiceBaseDescriptorSupplier {
    RuleSetServiceFileDescriptorSupplier() {}
  }

  private static final class RuleSetServiceMethodDescriptorSupplier
      extends RuleSetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RuleSetServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RuleSetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RuleSetServiceFileDescriptorSupplier())
                      .addMethod(getCreateRuleSetMethod())
                      .addMethod(getGetRuleSetMethod())
                      .addMethod(getUpdateRuleSetMethod())
                      .addMethod(getDeleteRuleSetMethod())
                      .addMethod(getListRuleSetsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
