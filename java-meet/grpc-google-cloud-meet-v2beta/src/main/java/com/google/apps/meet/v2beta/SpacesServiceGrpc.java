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
package com.google.apps.meet.v2beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * REST API for services dealing with spaces.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/apps/meet/v2beta/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SpacesServiceGrpc {

  private SpacesServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.apps.meet.v2beta.SpacesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.CreateSpaceRequest, com.google.apps.meet.v2beta.Space>
      getCreateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpace",
      requestType = com.google.apps.meet.v2beta.CreateSpaceRequest.class,
      responseType = com.google.apps.meet.v2beta.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.CreateSpaceRequest, com.google.apps.meet.v2beta.Space>
      getCreateSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.CreateSpaceRequest, com.google.apps.meet.v2beta.Space>
        getCreateSpaceMethod;
    if ((getCreateSpaceMethod = SpacesServiceGrpc.getCreateSpaceMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getCreateSpaceMethod = SpacesServiceGrpc.getCreateSpaceMethod) == null) {
          SpacesServiceGrpc.getCreateSpaceMethod =
              getCreateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.CreateSpaceRequest,
                          com.google.apps.meet.v2beta.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.CreateSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new SpacesServiceMethodDescriptorSupplier("CreateSpace"))
                      .build();
        }
      }
    }
    return getCreateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetSpaceRequest, com.google.apps.meet.v2beta.Space>
      getGetSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpace",
      requestType = com.google.apps.meet.v2beta.GetSpaceRequest.class,
      responseType = com.google.apps.meet.v2beta.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetSpaceRequest, com.google.apps.meet.v2beta.Space>
      getGetSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetSpaceRequest, com.google.apps.meet.v2beta.Space>
        getGetSpaceMethod;
    if ((getGetSpaceMethod = SpacesServiceGrpc.getGetSpaceMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getGetSpaceMethod = SpacesServiceGrpc.getGetSpaceMethod) == null) {
          SpacesServiceGrpc.getGetSpaceMethod =
              getGetSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetSpaceRequest,
                          com.google.apps.meet.v2beta.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new SpacesServiceMethodDescriptorSupplier("GetSpace"))
                      .build();
        }
      }
    }
    return getGetSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.UpdateSpaceRequest, com.google.apps.meet.v2beta.Space>
      getUpdateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpace",
      requestType = com.google.apps.meet.v2beta.UpdateSpaceRequest.class,
      responseType = com.google.apps.meet.v2beta.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.UpdateSpaceRequest, com.google.apps.meet.v2beta.Space>
      getUpdateSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.UpdateSpaceRequest, com.google.apps.meet.v2beta.Space>
        getUpdateSpaceMethod;
    if ((getUpdateSpaceMethod = SpacesServiceGrpc.getUpdateSpaceMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getUpdateSpaceMethod = SpacesServiceGrpc.getUpdateSpaceMethod) == null) {
          SpacesServiceGrpc.getUpdateSpaceMethod =
              getUpdateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.UpdateSpaceRequest,
                          com.google.apps.meet.v2beta.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.UpdateSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new SpacesServiceMethodDescriptorSupplier("UpdateSpace"))
                      .build();
        }
      }
    }
    return getUpdateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ConnectActiveConferenceRequest,
          com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
      getConnectActiveConferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConnectActiveConference",
      requestType = com.google.apps.meet.v2beta.ConnectActiveConferenceRequest.class,
      responseType = com.google.apps.meet.v2beta.ConnectActiveConferenceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ConnectActiveConferenceRequest,
          com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
      getConnectActiveConferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ConnectActiveConferenceRequest,
            com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
        getConnectActiveConferenceMethod;
    if ((getConnectActiveConferenceMethod = SpacesServiceGrpc.getConnectActiveConferenceMethod)
        == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getConnectActiveConferenceMethod = SpacesServiceGrpc.getConnectActiveConferenceMethod)
            == null) {
          SpacesServiceGrpc.getConnectActiveConferenceMethod =
              getConnectActiveConferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.ConnectActiveConferenceRequest,
                          com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ConnectActiveConference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ConnectActiveConferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ConnectActiveConferenceResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpacesServiceMethodDescriptorSupplier("ConnectActiveConference"))
                      .build();
        }
      }
    }
    return getConnectActiveConferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.EndActiveConferenceRequest, com.google.protobuf.Empty>
      getEndActiveConferenceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EndActiveConference",
      requestType = com.google.apps.meet.v2beta.EndActiveConferenceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.EndActiveConferenceRequest, com.google.protobuf.Empty>
      getEndActiveConferenceMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.EndActiveConferenceRequest, com.google.protobuf.Empty>
        getEndActiveConferenceMethod;
    if ((getEndActiveConferenceMethod = SpacesServiceGrpc.getEndActiveConferenceMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getEndActiveConferenceMethod = SpacesServiceGrpc.getEndActiveConferenceMethod)
            == null) {
          SpacesServiceGrpc.getEndActiveConferenceMethod =
              getEndActiveConferenceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.EndActiveConferenceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "EndActiveConference"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.EndActiveConferenceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpacesServiceMethodDescriptorSupplier("EndActiveConference"))
                      .build();
        }
      }
    }
    return getEndActiveConferenceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.CreateMemberRequest, com.google.apps.meet.v2beta.Member>
      getCreateMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMember",
      requestType = com.google.apps.meet.v2beta.CreateMemberRequest.class,
      responseType = com.google.apps.meet.v2beta.Member.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.CreateMemberRequest, com.google.apps.meet.v2beta.Member>
      getCreateMemberMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.CreateMemberRequest, com.google.apps.meet.v2beta.Member>
        getCreateMemberMethod;
    if ((getCreateMemberMethod = SpacesServiceGrpc.getCreateMemberMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getCreateMemberMethod = SpacesServiceGrpc.getCreateMemberMethod) == null) {
          SpacesServiceGrpc.getCreateMemberMethod =
              getCreateMemberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.CreateMemberRequest,
                          com.google.apps.meet.v2beta.Member>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMember"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.CreateMemberRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Member.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpacesServiceMethodDescriptorSupplier("CreateMember"))
                      .build();
        }
      }
    }
    return getCreateMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetMemberRequest, com.google.apps.meet.v2beta.Member>
      getGetMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMember",
      requestType = com.google.apps.meet.v2beta.GetMemberRequest.class,
      responseType = com.google.apps.meet.v2beta.Member.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.GetMemberRequest, com.google.apps.meet.v2beta.Member>
      getGetMemberMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.GetMemberRequest, com.google.apps.meet.v2beta.Member>
        getGetMemberMethod;
    if ((getGetMemberMethod = SpacesServiceGrpc.getGetMemberMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getGetMemberMethod = SpacesServiceGrpc.getGetMemberMethod) == null) {
          SpacesServiceGrpc.getGetMemberMethod =
              getGetMemberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.GetMemberRequest,
                          com.google.apps.meet.v2beta.Member>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMember"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.GetMemberRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.Member.getDefaultInstance()))
                      .setSchemaDescriptor(new SpacesServiceMethodDescriptorSupplier("GetMember"))
                      .build();
        }
      }
    }
    return getGetMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListMembersRequest,
          com.google.apps.meet.v2beta.ListMembersResponse>
      getListMembersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMembers",
      requestType = com.google.apps.meet.v2beta.ListMembersRequest.class,
      responseType = com.google.apps.meet.v2beta.ListMembersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.ListMembersRequest,
          com.google.apps.meet.v2beta.ListMembersResponse>
      getListMembersMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.ListMembersRequest,
            com.google.apps.meet.v2beta.ListMembersResponse>
        getListMembersMethod;
    if ((getListMembersMethod = SpacesServiceGrpc.getListMembersMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getListMembersMethod = SpacesServiceGrpc.getListMembersMethod) == null) {
          SpacesServiceGrpc.getListMembersMethod =
              getListMembersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.ListMembersRequest,
                          com.google.apps.meet.v2beta.ListMembersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMembers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListMembersRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.ListMembersResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new SpacesServiceMethodDescriptorSupplier("ListMembers"))
                      .build();
        }
      }
    }
    return getListMembersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.DeleteMemberRequest, com.google.protobuf.Empty>
      getDeleteMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMember",
      requestType = com.google.apps.meet.v2beta.DeleteMemberRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2beta.DeleteMemberRequest, com.google.protobuf.Empty>
      getDeleteMemberMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2beta.DeleteMemberRequest, com.google.protobuf.Empty>
        getDeleteMemberMethod;
    if ((getDeleteMemberMethod = SpacesServiceGrpc.getDeleteMemberMethod) == null) {
      synchronized (SpacesServiceGrpc.class) {
        if ((getDeleteMemberMethod = SpacesServiceGrpc.getDeleteMemberMethod) == null) {
          SpacesServiceGrpc.getDeleteMemberMethod =
              getDeleteMemberMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2beta.DeleteMemberRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMember"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2beta.DeleteMemberRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new SpacesServiceMethodDescriptorSupplier("DeleteMember"))
                      .build();
        }
      }
    }
    return getDeleteMemberMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static SpacesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpacesServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpacesServiceStub>() {
          @java.lang.Override
          public SpacesServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpacesServiceStub(channel, callOptions);
          }
        };
    return SpacesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpacesServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpacesServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpacesServiceBlockingStub>() {
          @java.lang.Override
          public SpacesServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpacesServiceBlockingStub(channel, callOptions);
          }
        };
    return SpacesServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static SpacesServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SpacesServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<SpacesServiceFutureStub>() {
          @java.lang.Override
          public SpacesServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new SpacesServiceFutureStub(channel, callOptions);
          }
        };
    return SpacesServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * REST API for services dealing with spaces.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    default void createSpace(
        com.google.apps.meet.v2beta.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a meeting space.
     * For an example, see [Get a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
     * </pre>
     */
    default void getSpace(
        com.google.apps.meet.v2beta.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates details about a meeting space.
     * For an example, see [Update a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
     * </pre>
     */
    default void updateSpace(
        com.google.apps.meet.v2beta.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Broker a WebRTC connection to the active conference of a space.
     * On success, clients must use the resulting SDP (Session Description
     * Protocol) answer to establish a WebRTC connection. Once connected,
     * additional functionality is available across WebRTC data channels.
     * See [Meet Media API
     * overview](https://developers.google.com/meet/media-api/guides/overview) for
     * more details about this connection.
     * </pre>
     */
    default void connectActiveConference(
        com.google.apps.meet.v2beta.ConnectActiveConferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getConnectActiveConferenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends an active conference (if there's one).
     * For an example, see [End active
     * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
     * </pre>
     */
    default void endActiveConference(
        com.google.apps.meet.v2beta.EndActiveConferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEndActiveConferenceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Create a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    default void createMember(
        com.google.apps.meet.v2beta.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMemberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Get a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    default void getMember(
        com.google.apps.meet.v2beta.GetMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMemberMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * List members.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    default void listMembers(
        com.google.apps.meet.v2beta.ListMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListMembersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMembersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Delete the member who was previously assigned roles in the space.
     * </pre>
     */
    default void deleteMember(
        com.google.apps.meet.v2beta.DeleteMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMemberMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SpacesService.
   *
   * <pre>
   * REST API for services dealing with spaces.
   * </pre>
   */
  public abstract static class SpacesServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return SpacesServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SpacesService.
   *
   * <pre>
   * REST API for services dealing with spaces.
   * </pre>
   */
  public static final class SpacesServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SpacesServiceStub> {
    private SpacesServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpacesServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpacesServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public void createSpace(
        com.google.apps.meet.v2beta.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a meeting space.
     * For an example, see [Get a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
     * </pre>
     */
    public void getSpace(
        com.google.apps.meet.v2beta.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates details about a meeting space.
     * For an example, see [Update a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
     * </pre>
     */
    public void updateSpace(
        com.google.apps.meet.v2beta.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Broker a WebRTC connection to the active conference of a space.
     * On success, clients must use the resulting SDP (Session Description
     * Protocol) answer to establish a WebRTC connection. Once connected,
     * additional functionality is available across WebRTC data channels.
     * See [Meet Media API
     * overview](https://developers.google.com/meet/media-api/guides/overview) for
     * more details about this connection.
     * </pre>
     */
    public void connectActiveConference(
        com.google.apps.meet.v2beta.ConnectActiveConferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConnectActiveConferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Ends an active conference (if there's one).
     * For an example, see [End active
     * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
     * </pre>
     */
    public void endActiveConference(
        com.google.apps.meet.v2beta.EndActiveConferenceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEndActiveConferenceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Create a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public void createMember(
        com.google.apps.meet.v2beta.CreateMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Get a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public void getMember(
        com.google.apps.meet.v2beta.GetMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * List members.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public void listMembers(
        com.google.apps.meet.v2beta.ListMembersRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListMembersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Delete the member who was previously assigned roles in the space.
     * </pre>
     */
    public void deleteMember(
        com.google.apps.meet.v2beta.DeleteMemberRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SpacesService.
   *
   * <pre>
   * REST API for services dealing with spaces.
   * </pre>
   */
  public static final class SpacesServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SpacesServiceBlockingStub> {
    private SpacesServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpacesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpacesServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public com.google.apps.meet.v2beta.Space createSpace(
        com.google.apps.meet.v2beta.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a meeting space.
     * For an example, see [Get a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
     * </pre>
     */
    public com.google.apps.meet.v2beta.Space getSpace(
        com.google.apps.meet.v2beta.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates details about a meeting space.
     * For an example, see [Update a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
     * </pre>
     */
    public com.google.apps.meet.v2beta.Space updateSpace(
        com.google.apps.meet.v2beta.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Broker a WebRTC connection to the active conference of a space.
     * On success, clients must use the resulting SDP (Session Description
     * Protocol) answer to establish a WebRTC connection. Once connected,
     * additional functionality is available across WebRTC data channels.
     * See [Meet Media API
     * overview](https://developers.google.com/meet/media-api/guides/overview) for
     * more details about this connection.
     * </pre>
     */
    public com.google.apps.meet.v2beta.ConnectActiveConferenceResponse connectActiveConference(
        com.google.apps.meet.v2beta.ConnectActiveConferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConnectActiveConferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Ends an active conference (if there's one).
     * For an example, see [End active
     * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
     * </pre>
     */
    public com.google.protobuf.Empty endActiveConference(
        com.google.apps.meet.v2beta.EndActiveConferenceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEndActiveConferenceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Create a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.apps.meet.v2beta.Member createMember(
        com.google.apps.meet.v2beta.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMemberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Get a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.apps.meet.v2beta.Member getMember(
        com.google.apps.meet.v2beta.GetMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMemberMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * List members.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.apps.meet.v2beta.ListMembersResponse listMembers(
        com.google.apps.meet.v2beta.ListMembersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Delete the member who was previously assigned roles in the space.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMember(
        com.google.apps.meet.v2beta.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SpacesService.
   *
   * <pre>
   * REST API for services dealing with spaces.
   * </pre>
   */
  public static final class SpacesServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SpacesServiceFutureStub> {
    private SpacesServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpacesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SpacesServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Space>
        createSpace(com.google.apps.meet.v2beta.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a meeting space.
     * For an example, see [Get a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#get-meeting-space).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Space>
        getSpace(com.google.apps.meet.v2beta.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates details about a meeting space.
     * For an example, see [Update a meeting
     * space](https://developers.google.com/meet/api/guides/meeting-spaces#update-meeting-space).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Space>
        updateSpace(com.google.apps.meet.v2beta.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Broker a WebRTC connection to the active conference of a space.
     * On success, clients must use the resulting SDP (Session Description
     * Protocol) answer to establish a WebRTC connection. Once connected,
     * additional functionality is available across WebRTC data channels.
     * See [Meet Media API
     * overview](https://developers.google.com/meet/media-api/guides/overview) for
     * more details about this connection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>
        connectActiveConference(
            com.google.apps.meet.v2beta.ConnectActiveConferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConnectActiveConferenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Ends an active conference (if there's one).
     * For an example, see [End active
     * conference](https://developers.google.com/meet/api/guides/meeting-spaces#end-active-conference).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        endActiveConference(com.google.apps.meet.v2beta.EndActiveConferenceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEndActiveConferenceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Create a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Member>
        createMember(com.google.apps.meet.v2beta.CreateMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMemberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Get a member.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted, this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2beta.Member>
        getMember(com.google.apps.meet.v2beta.GetMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMemberMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * List members.
     * This API supports the `fields` parameter in
     * [SystemParameterContext](https://cloud.google.com/apis/docs/system-parameters).
     * When the `fields` parameter is omitted this API response will default to
     * "name,email,role,user".
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2beta.ListMembersResponse>
        listMembers(com.google.apps.meet.v2beta.ListMembersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * [Developer Preview](https://developers.google.com/workspace/preview):
     * Delete the member who was previously assigned roles in the space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMember(com.google.apps.meet.v2beta.DeleteMemberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SPACE = 0;
  private static final int METHODID_GET_SPACE = 1;
  private static final int METHODID_UPDATE_SPACE = 2;
  private static final int METHODID_CONNECT_ACTIVE_CONFERENCE = 3;
  private static final int METHODID_END_ACTIVE_CONFERENCE = 4;
  private static final int METHODID_CREATE_MEMBER = 5;
  private static final int METHODID_GET_MEMBER = 6;
  private static final int METHODID_LIST_MEMBERS = 7;
  private static final int METHODID_DELETE_MEMBER = 8;

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
        case METHODID_CREATE_SPACE:
          serviceImpl.createSpace(
              (com.google.apps.meet.v2beta.CreateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space>) responseObserver);
          break;
        case METHODID_GET_SPACE:
          serviceImpl.getSpace(
              (com.google.apps.meet.v2beta.GetSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space>) responseObserver);
          break;
        case METHODID_UPDATE_SPACE:
          serviceImpl.updateSpace(
              (com.google.apps.meet.v2beta.UpdateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Space>) responseObserver);
          break;
        case METHODID_CONNECT_ACTIVE_CONFERENCE:
          serviceImpl.connectActiveConference(
              (com.google.apps.meet.v2beta.ConnectActiveConferenceRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>)
                  responseObserver);
          break;
        case METHODID_END_ACTIVE_CONFERENCE:
          serviceImpl.endActiveConference(
              (com.google.apps.meet.v2beta.EndActiveConferenceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_MEMBER:
          serviceImpl.createMember(
              (com.google.apps.meet.v2beta.CreateMemberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member>) responseObserver);
          break;
        case METHODID_GET_MEMBER:
          serviceImpl.getMember(
              (com.google.apps.meet.v2beta.GetMemberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.Member>) responseObserver);
          break;
        case METHODID_LIST_MEMBERS:
          serviceImpl.listMembers(
              (com.google.apps.meet.v2beta.ListMembersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2beta.ListMembersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_MEMBER:
          serviceImpl.deleteMember(
              (com.google.apps.meet.v2beta.DeleteMemberRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getCreateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.CreateSpaceRequest,
                    com.google.apps.meet.v2beta.Space>(service, METHODID_CREATE_SPACE)))
        .addMethod(
            getGetSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetSpaceRequest, com.google.apps.meet.v2beta.Space>(
                    service, METHODID_GET_SPACE)))
        .addMethod(
            getUpdateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.UpdateSpaceRequest,
                    com.google.apps.meet.v2beta.Space>(service, METHODID_UPDATE_SPACE)))
        .addMethod(
            getConnectActiveConferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ConnectActiveConferenceRequest,
                    com.google.apps.meet.v2beta.ConnectActiveConferenceResponse>(
                    service, METHODID_CONNECT_ACTIVE_CONFERENCE)))
        .addMethod(
            getEndActiveConferenceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.EndActiveConferenceRequest,
                    com.google.protobuf.Empty>(service, METHODID_END_ACTIVE_CONFERENCE)))
        .addMethod(
            getCreateMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.CreateMemberRequest,
                    com.google.apps.meet.v2beta.Member>(service, METHODID_CREATE_MEMBER)))
        .addMethod(
            getGetMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.GetMemberRequest,
                    com.google.apps.meet.v2beta.Member>(service, METHODID_GET_MEMBER)))
        .addMethod(
            getListMembersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.ListMembersRequest,
                    com.google.apps.meet.v2beta.ListMembersResponse>(
                    service, METHODID_LIST_MEMBERS)))
        .addMethod(
            getDeleteMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2beta.DeleteMemberRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_MEMBER)))
        .build();
  }

  private abstract static class SpacesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpacesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.apps.meet.v2beta.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpacesService");
    }
  }

  private static final class SpacesServiceFileDescriptorSupplier
      extends SpacesServiceBaseDescriptorSupplier {
    SpacesServiceFileDescriptorSupplier() {}
  }

  private static final class SpacesServiceMethodDescriptorSupplier
      extends SpacesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SpacesServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SpacesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new SpacesServiceFileDescriptorSupplier())
                      .addMethod(getCreateSpaceMethod())
                      .addMethod(getGetSpaceMethod())
                      .addMethod(getUpdateSpaceMethod())
                      .addMethod(getConnectActiveConferenceMethod())
                      .addMethod(getEndActiveConferenceMethod())
                      .addMethod(getCreateMemberMethod())
                      .addMethod(getGetMemberMethod())
                      .addMethod(getListMembersMethod())
                      .addMethod(getDeleteMemberMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
