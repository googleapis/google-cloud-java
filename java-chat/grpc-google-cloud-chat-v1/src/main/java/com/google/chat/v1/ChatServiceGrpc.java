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
package com.google.chat.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Enables developers to build Chat apps and
 * integrations on Google Chat Platform.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/chat/v1/chat_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ChatServiceGrpc {

  private ChatServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.chat.v1.ChatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateMessageRequest, com.google.chat.v1.Message>
      getCreateMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMessage",
      requestType = com.google.chat.v1.CreateMessageRequest.class,
      responseType = com.google.chat.v1.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateMessageRequest, com.google.chat.v1.Message>
      getCreateMessageMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.CreateMessageRequest, com.google.chat.v1.Message>
        getCreateMessageMethod;
    if ((getCreateMessageMethod = ChatServiceGrpc.getCreateMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCreateMessageMethod = ChatServiceGrpc.getCreateMessageMethod) == null) {
          ChatServiceGrpc.getCreateMessageMethod =
              getCreateMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.CreateMessageRequest, com.google.chat.v1.Message>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CreateMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Message.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("CreateMessage"))
                      .build();
        }
      }
    }
    return getCreateMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.ListMessagesRequest, com.google.chat.v1.ListMessagesResponse>
      getListMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessages",
      requestType = com.google.chat.v1.ListMessagesRequest.class,
      responseType = com.google.chat.v1.ListMessagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.ListMessagesRequest, com.google.chat.v1.ListMessagesResponse>
      getListMessagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.ListMessagesRequest, com.google.chat.v1.ListMessagesResponse>
        getListMessagesMethod;
    if ((getListMessagesMethod = ChatServiceGrpc.getListMessagesMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getListMessagesMethod = ChatServiceGrpc.getListMessagesMethod) == null) {
          ChatServiceGrpc.getListMessagesMethod =
              getListMessagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.ListMessagesRequest,
                          com.google.chat.v1.ListMessagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMessages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListMessagesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListMessagesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("ListMessages"))
                      .build();
        }
      }
    }
    return getListMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.ListMembershipsRequest, com.google.chat.v1.ListMembershipsResponse>
      getListMembershipsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMemberships",
      requestType = com.google.chat.v1.ListMembershipsRequest.class,
      responseType = com.google.chat.v1.ListMembershipsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.ListMembershipsRequest, com.google.chat.v1.ListMembershipsResponse>
      getListMembershipsMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.ListMembershipsRequest, com.google.chat.v1.ListMembershipsResponse>
        getListMembershipsMethod;
    if ((getListMembershipsMethod = ChatServiceGrpc.getListMembershipsMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getListMembershipsMethod = ChatServiceGrpc.getListMembershipsMethod) == null) {
          ChatServiceGrpc.getListMembershipsMethod =
              getListMembershipsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.ListMembershipsRequest,
                          com.google.chat.v1.ListMembershipsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMemberships"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListMembershipsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListMembershipsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("ListMemberships"))
                      .build();
        }
      }
    }
    return getListMembershipsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetMembershipRequest, com.google.chat.v1.Membership>
      getGetMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMembership",
      requestType = com.google.chat.v1.GetMembershipRequest.class,
      responseType = com.google.chat.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetMembershipRequest, com.google.chat.v1.Membership>
      getGetMembershipMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.GetMembershipRequest, com.google.chat.v1.Membership>
        getGetMembershipMethod;
    if ((getGetMembershipMethod = ChatServiceGrpc.getGetMembershipMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetMembershipMethod = ChatServiceGrpc.getGetMembershipMethod) == null) {
          ChatServiceGrpc.getGetMembershipMethod =
              getGetMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetMembershipRequest, com.google.chat.v1.Membership>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetMembershipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Membership.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("GetMembership"))
                      .build();
        }
      }
    }
    return getGetMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetMessageRequest, com.google.chat.v1.Message>
      getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessage",
      requestType = com.google.chat.v1.GetMessageRequest.class,
      responseType = com.google.chat.v1.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetMessageRequest, com.google.chat.v1.Message>
      getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.GetMessageRequest, com.google.chat.v1.Message>
        getGetMessageMethod;
    if ((getGetMessageMethod = ChatServiceGrpc.getGetMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetMessageMethod = ChatServiceGrpc.getGetMessageMethod) == null) {
          ChatServiceGrpc.getGetMessageMethod =
              getGetMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetMessageRequest, com.google.chat.v1.Message>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Message.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("GetMessage"))
                      .build();
        }
      }
    }
    return getGetMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateMessageRequest, com.google.chat.v1.Message>
      getUpdateMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMessage",
      requestType = com.google.chat.v1.UpdateMessageRequest.class,
      responseType = com.google.chat.v1.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateMessageRequest, com.google.chat.v1.Message>
      getUpdateMessageMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.UpdateMessageRequest, com.google.chat.v1.Message>
        getUpdateMessageMethod;
    if ((getUpdateMessageMethod = ChatServiceGrpc.getUpdateMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUpdateMessageMethod = ChatServiceGrpc.getUpdateMessageMethod) == null) {
          ChatServiceGrpc.getUpdateMessageMethod =
              getUpdateMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.UpdateMessageRequest, com.google.chat.v1.Message>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UpdateMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Message.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("UpdateMessage"))
                      .build();
        }
      }
    }
    return getUpdateMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteMessageRequest, com.google.protobuf.Empty>
      getDeleteMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMessage",
      requestType = com.google.chat.v1.DeleteMessageRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteMessageRequest, com.google.protobuf.Empty>
      getDeleteMessageMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.DeleteMessageRequest, com.google.protobuf.Empty>
        getDeleteMessageMethod;
    if ((getDeleteMessageMethod = ChatServiceGrpc.getDeleteMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDeleteMessageMethod = ChatServiceGrpc.getDeleteMessageMethod) == null) {
          ChatServiceGrpc.getDeleteMessageMethod =
              getDeleteMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.DeleteMessageRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.DeleteMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("DeleteMessage"))
                      .build();
        }
      }
    }
    return getDeleteMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetAttachmentRequest, com.google.chat.v1.Attachment>
      getGetAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttachment",
      requestType = com.google.chat.v1.GetAttachmentRequest.class,
      responseType = com.google.chat.v1.Attachment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetAttachmentRequest, com.google.chat.v1.Attachment>
      getGetAttachmentMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.GetAttachmentRequest, com.google.chat.v1.Attachment>
        getGetAttachmentMethod;
    if ((getGetAttachmentMethod = ChatServiceGrpc.getGetAttachmentMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetAttachmentMethod = ChatServiceGrpc.getGetAttachmentMethod) == null) {
          ChatServiceGrpc.getGetAttachmentMethod =
              getGetAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetAttachmentRequest, com.google.chat.v1.Attachment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetAttachmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Attachment.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("GetAttachment"))
                      .build();
        }
      }
    }
    return getGetAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.UploadAttachmentRequest, com.google.chat.v1.UploadAttachmentResponse>
      getUploadAttachmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadAttachment",
      requestType = com.google.chat.v1.UploadAttachmentRequest.class,
      responseType = com.google.chat.v1.UploadAttachmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.UploadAttachmentRequest, com.google.chat.v1.UploadAttachmentResponse>
      getUploadAttachmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.UploadAttachmentRequest, com.google.chat.v1.UploadAttachmentResponse>
        getUploadAttachmentMethod;
    if ((getUploadAttachmentMethod = ChatServiceGrpc.getUploadAttachmentMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUploadAttachmentMethod = ChatServiceGrpc.getUploadAttachmentMethod) == null) {
          ChatServiceGrpc.getUploadAttachmentMethod =
              getUploadAttachmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.UploadAttachmentRequest,
                          com.google.chat.v1.UploadAttachmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadAttachment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UploadAttachmentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UploadAttachmentResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("UploadAttachment"))
                      .build();
        }
      }
    }
    return getUploadAttachmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.ListSpacesRequest, com.google.chat.v1.ListSpacesResponse>
      getListSpacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpaces",
      requestType = com.google.chat.v1.ListSpacesRequest.class,
      responseType = com.google.chat.v1.ListSpacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.ListSpacesRequest, com.google.chat.v1.ListSpacesResponse>
      getListSpacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.ListSpacesRequest, com.google.chat.v1.ListSpacesResponse>
        getListSpacesMethod;
    if ((getListSpacesMethod = ChatServiceGrpc.getListSpacesMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getListSpacesMethod = ChatServiceGrpc.getListSpacesMethod) == null) {
          ChatServiceGrpc.getListSpacesMethod =
              getListSpacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.ListSpacesRequest, com.google.chat.v1.ListSpacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListSpacesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListSpacesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("ListSpaces"))
                      .build();
        }
      }
    }
    return getListSpacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetSpaceRequest, com.google.chat.v1.Space>
      getGetSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpace",
      requestType = com.google.chat.v1.GetSpaceRequest.class,
      responseType = com.google.chat.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetSpaceRequest, com.google.chat.v1.Space>
      getGetSpaceMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.GetSpaceRequest, com.google.chat.v1.Space>
        getGetSpaceMethod;
    if ((getGetSpaceMethod = ChatServiceGrpc.getGetSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetSpaceMethod = ChatServiceGrpc.getGetSpaceMethod) == null) {
          ChatServiceGrpc.getGetSpaceMethod =
              getGetSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetSpaceRequest, com.google.chat.v1.Space>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("GetSpace"))
                      .build();
        }
      }
    }
    return getGetSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateSpaceRequest, com.google.chat.v1.Space>
      getCreateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpace",
      requestType = com.google.chat.v1.CreateSpaceRequest.class,
      responseType = com.google.chat.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateSpaceRequest, com.google.chat.v1.Space>
      getCreateSpaceMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.CreateSpaceRequest, com.google.chat.v1.Space>
        getCreateSpaceMethod;
    if ((getCreateSpaceMethod = ChatServiceGrpc.getCreateSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCreateSpaceMethod = ChatServiceGrpc.getCreateSpaceMethod) == null) {
          ChatServiceGrpc.getCreateSpaceMethod =
              getCreateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.CreateSpaceRequest, com.google.chat.v1.Space>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CreateSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("CreateSpace"))
                      .build();
        }
      }
    }
    return getCreateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.SetUpSpaceRequest, com.google.chat.v1.Space>
      getSetUpSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetUpSpace",
      requestType = com.google.chat.v1.SetUpSpaceRequest.class,
      responseType = com.google.chat.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.SetUpSpaceRequest, com.google.chat.v1.Space>
      getSetUpSpaceMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.SetUpSpaceRequest, com.google.chat.v1.Space>
        getSetUpSpaceMethod;
    if ((getSetUpSpaceMethod = ChatServiceGrpc.getSetUpSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getSetUpSpaceMethod = ChatServiceGrpc.getSetUpSpaceMethod) == null) {
          ChatServiceGrpc.getSetUpSpaceMethod =
              getSetUpSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.SetUpSpaceRequest, com.google.chat.v1.Space>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetUpSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.SetUpSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("SetUpSpace"))
                      .build();
        }
      }
    }
    return getSetUpSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateSpaceRequest, com.google.chat.v1.Space>
      getUpdateSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpace",
      requestType = com.google.chat.v1.UpdateSpaceRequest.class,
      responseType = com.google.chat.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateSpaceRequest, com.google.chat.v1.Space>
      getUpdateSpaceMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.UpdateSpaceRequest, com.google.chat.v1.Space>
        getUpdateSpaceMethod;
    if ((getUpdateSpaceMethod = ChatServiceGrpc.getUpdateSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUpdateSpaceMethod = ChatServiceGrpc.getUpdateSpaceMethod) == null) {
          ChatServiceGrpc.getUpdateSpaceMethod =
              getUpdateSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.UpdateSpaceRequest, com.google.chat.v1.Space>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UpdateSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("UpdateSpace"))
                      .build();
        }
      }
    }
    return getUpdateSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
      getDeleteSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpace",
      requestType = com.google.chat.v1.DeleteSpaceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
      getDeleteSpaceMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
        getDeleteSpaceMethod;
    if ((getDeleteSpaceMethod = ChatServiceGrpc.getDeleteSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDeleteSpaceMethod = ChatServiceGrpc.getDeleteSpaceMethod) == null) {
          ChatServiceGrpc.getDeleteSpaceMethod =
              getDeleteSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.DeleteSpaceRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.DeleteSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("DeleteSpace"))
                      .build();
        }
      }
    }
    return getDeleteSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.CompleteImportSpaceRequest,
          com.google.chat.v1.CompleteImportSpaceResponse>
      getCompleteImportSpaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteImportSpace",
      requestType = com.google.chat.v1.CompleteImportSpaceRequest.class,
      responseType = com.google.chat.v1.CompleteImportSpaceResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.CompleteImportSpaceRequest,
          com.google.chat.v1.CompleteImportSpaceResponse>
      getCompleteImportSpaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.CompleteImportSpaceRequest,
            com.google.chat.v1.CompleteImportSpaceResponse>
        getCompleteImportSpaceMethod;
    if ((getCompleteImportSpaceMethod = ChatServiceGrpc.getCompleteImportSpaceMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCompleteImportSpaceMethod = ChatServiceGrpc.getCompleteImportSpaceMethod) == null) {
          ChatServiceGrpc.getCompleteImportSpaceMethod =
              getCompleteImportSpaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.CompleteImportSpaceRequest,
                          com.google.chat.v1.CompleteImportSpaceResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CompleteImportSpace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CompleteImportSpaceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CompleteImportSpaceResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("CompleteImportSpace"))
                      .build();
        }
      }
    }
    return getCompleteImportSpaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.FindDirectMessageRequest, com.google.chat.v1.Space>
      getFindDirectMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FindDirectMessage",
      requestType = com.google.chat.v1.FindDirectMessageRequest.class,
      responseType = com.google.chat.v1.Space.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.FindDirectMessageRequest, com.google.chat.v1.Space>
      getFindDirectMessageMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.FindDirectMessageRequest, com.google.chat.v1.Space>
        getFindDirectMessageMethod;
    if ((getFindDirectMessageMethod = ChatServiceGrpc.getFindDirectMessageMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getFindDirectMessageMethod = ChatServiceGrpc.getFindDirectMessageMethod) == null) {
          ChatServiceGrpc.getFindDirectMessageMethod =
              getFindDirectMessageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.FindDirectMessageRequest, com.google.chat.v1.Space>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "FindDirectMessage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.FindDirectMessageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Space.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("FindDirectMessage"))
                      .build();
        }
      }
    }
    return getFindDirectMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateMembershipRequest, com.google.chat.v1.Membership>
      getCreateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMembership",
      requestType = com.google.chat.v1.CreateMembershipRequest.class,
      responseType = com.google.chat.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateMembershipRequest, com.google.chat.v1.Membership>
      getCreateMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.CreateMembershipRequest, com.google.chat.v1.Membership>
        getCreateMembershipMethod;
    if ((getCreateMembershipMethod = ChatServiceGrpc.getCreateMembershipMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCreateMembershipMethod = ChatServiceGrpc.getCreateMembershipMethod) == null) {
          ChatServiceGrpc.getCreateMembershipMethod =
              getCreateMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.CreateMembershipRequest, com.google.chat.v1.Membership>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CreateMembershipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Membership.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("CreateMembership"))
                      .build();
        }
      }
    }
    return getCreateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateMembershipRequest, com.google.chat.v1.Membership>
      getUpdateMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMembership",
      requestType = com.google.chat.v1.UpdateMembershipRequest.class,
      responseType = com.google.chat.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateMembershipRequest, com.google.chat.v1.Membership>
      getUpdateMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.UpdateMembershipRequest, com.google.chat.v1.Membership>
        getUpdateMembershipMethod;
    if ((getUpdateMembershipMethod = ChatServiceGrpc.getUpdateMembershipMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUpdateMembershipMethod = ChatServiceGrpc.getUpdateMembershipMethod) == null) {
          ChatServiceGrpc.getUpdateMembershipMethod =
              getUpdateMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.UpdateMembershipRequest, com.google.chat.v1.Membership>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UpdateMembershipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Membership.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("UpdateMembership"))
                      .build();
        }
      }
    }
    return getUpdateMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteMembershipRequest, com.google.chat.v1.Membership>
      getDeleteMembershipMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMembership",
      requestType = com.google.chat.v1.DeleteMembershipRequest.class,
      responseType = com.google.chat.v1.Membership.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteMembershipRequest, com.google.chat.v1.Membership>
      getDeleteMembershipMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.DeleteMembershipRequest, com.google.chat.v1.Membership>
        getDeleteMembershipMethod;
    if ((getDeleteMembershipMethod = ChatServiceGrpc.getDeleteMembershipMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDeleteMembershipMethod = ChatServiceGrpc.getDeleteMembershipMethod) == null) {
          ChatServiceGrpc.getDeleteMembershipMethod =
              getDeleteMembershipMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.DeleteMembershipRequest, com.google.chat.v1.Membership>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMembership"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.DeleteMembershipRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Membership.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("DeleteMembership"))
                      .build();
        }
      }
    }
    return getDeleteMembershipMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateReactionRequest, com.google.chat.v1.Reaction>
      getCreateReactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReaction",
      requestType = com.google.chat.v1.CreateReactionRequest.class,
      responseType = com.google.chat.v1.Reaction.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.CreateReactionRequest, com.google.chat.v1.Reaction>
      getCreateReactionMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.CreateReactionRequest, com.google.chat.v1.Reaction>
        getCreateReactionMethod;
    if ((getCreateReactionMethod = ChatServiceGrpc.getCreateReactionMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getCreateReactionMethod = ChatServiceGrpc.getCreateReactionMethod) == null) {
          ChatServiceGrpc.getCreateReactionMethod =
              getCreateReactionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.CreateReactionRequest, com.google.chat.v1.Reaction>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReaction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.CreateReactionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.Reaction.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("CreateReaction"))
                      .build();
        }
      }
    }
    return getCreateReactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.ListReactionsRequest, com.google.chat.v1.ListReactionsResponse>
      getListReactionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReactions",
      requestType = com.google.chat.v1.ListReactionsRequest.class,
      responseType = com.google.chat.v1.ListReactionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.ListReactionsRequest, com.google.chat.v1.ListReactionsResponse>
      getListReactionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.ListReactionsRequest, com.google.chat.v1.ListReactionsResponse>
        getListReactionsMethod;
    if ((getListReactionsMethod = ChatServiceGrpc.getListReactionsMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getListReactionsMethod = ChatServiceGrpc.getListReactionsMethod) == null) {
          ChatServiceGrpc.getListReactionsMethod =
              getListReactionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.ListReactionsRequest,
                          com.google.chat.v1.ListReactionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReactions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListReactionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ListReactionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ChatServiceMethodDescriptorSupplier("ListReactions"))
                      .build();
        }
      }
    }
    return getListReactionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteReactionRequest, com.google.protobuf.Empty>
      getDeleteReactionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteReaction",
      requestType = com.google.chat.v1.DeleteReactionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.DeleteReactionRequest, com.google.protobuf.Empty>
      getDeleteReactionMethod() {
    io.grpc.MethodDescriptor<com.google.chat.v1.DeleteReactionRequest, com.google.protobuf.Empty>
        getDeleteReactionMethod;
    if ((getDeleteReactionMethod = ChatServiceGrpc.getDeleteReactionMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getDeleteReactionMethod = ChatServiceGrpc.getDeleteReactionMethod) == null) {
          ChatServiceGrpc.getDeleteReactionMethod =
              getDeleteReactionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.DeleteReactionRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteReaction"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.DeleteReactionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("DeleteReaction"))
                      .build();
        }
      }
    }
    return getDeleteReactionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
      getGetSpaceReadStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpaceReadState",
      requestType = com.google.chat.v1.GetSpaceReadStateRequest.class,
      responseType = com.google.chat.v1.SpaceReadState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
      getGetSpaceReadStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.GetSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
        getGetSpaceReadStateMethod;
    if ((getGetSpaceReadStateMethod = ChatServiceGrpc.getGetSpaceReadStateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetSpaceReadStateMethod = ChatServiceGrpc.getGetSpaceReadStateMethod) == null) {
          ChatServiceGrpc.getGetSpaceReadStateMethod =
              getGetSpaceReadStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetSpaceReadStateRequest,
                          com.google.chat.v1.SpaceReadState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpaceReadState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetSpaceReadStateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.SpaceReadState.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("GetSpaceReadState"))
                      .build();
        }
      }
    }
    return getGetSpaceReadStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
      getUpdateSpaceReadStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpaceReadState",
      requestType = com.google.chat.v1.UpdateSpaceReadStateRequest.class,
      responseType = com.google.chat.v1.SpaceReadState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.UpdateSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
      getUpdateSpaceReadStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.UpdateSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>
        getUpdateSpaceReadStateMethod;
    if ((getUpdateSpaceReadStateMethod = ChatServiceGrpc.getUpdateSpaceReadStateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getUpdateSpaceReadStateMethod = ChatServiceGrpc.getUpdateSpaceReadStateMethod)
            == null) {
          ChatServiceGrpc.getUpdateSpaceReadStateMethod =
              getUpdateSpaceReadStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.UpdateSpaceReadStateRequest,
                          com.google.chat.v1.SpaceReadState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateSpaceReadState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.UpdateSpaceReadStateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.SpaceReadState.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("UpdateSpaceReadState"))
                      .build();
        }
      }
    }
    return getUpdateSpaceReadStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.chat.v1.GetThreadReadStateRequest, com.google.chat.v1.ThreadReadState>
      getGetThreadReadStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetThreadReadState",
      requestType = com.google.chat.v1.GetThreadReadStateRequest.class,
      responseType = com.google.chat.v1.ThreadReadState.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.chat.v1.GetThreadReadStateRequest, com.google.chat.v1.ThreadReadState>
      getGetThreadReadStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.chat.v1.GetThreadReadStateRequest, com.google.chat.v1.ThreadReadState>
        getGetThreadReadStateMethod;
    if ((getGetThreadReadStateMethod = ChatServiceGrpc.getGetThreadReadStateMethod) == null) {
      synchronized (ChatServiceGrpc.class) {
        if ((getGetThreadReadStateMethod = ChatServiceGrpc.getGetThreadReadStateMethod) == null) {
          ChatServiceGrpc.getGetThreadReadStateMethod =
              getGetThreadReadStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.chat.v1.GetThreadReadStateRequest,
                          com.google.chat.v1.ThreadReadState>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetThreadReadState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.GetThreadReadStateRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.chat.v1.ThreadReadState.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ChatServiceMethodDescriptorSupplier("GetThreadReadState"))
                      .build();
        }
      }
    }
    return getGetThreadReadStateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ChatServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChatServiceStub>() {
          @java.lang.Override
          public ChatServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceStub(channel, callOptions);
          }
        };
    return ChatServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ChatServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChatServiceBlockingStub>() {
          @java.lang.Override
          public ChatServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceBlockingStub(channel, callOptions);
          }
        };
    return ChatServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ChatServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ChatServiceFutureStub>() {
          @java.lang.Override
          public ChatServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ChatServiceFutureStub(channel, callOptions);
          }
        };
    return ChatServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Enables developers to build Chat apps and
   * integrations on Google Chat Platform.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a message in a Google Chat space. For an example, see [Send a
     * message](https://developers.google.com/workspace/chat/create-messages).
     * Calling this method requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize)
     * and supports the following authentication types:
     * - For text messages, user authentication or app authentication are
     * supported.
     * - For card messages, only app authentication is supported. (Only Chat apps
     * can create card messages.)
     * </pre>
     */
    default void createMessage(
        com.google.chat.v1.CreateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists messages in a space that the caller is a member of, including
     * messages from blocked members and spaces. For an example, see
     * [List messages](/chat/api/guides/v1/messages/list).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void listMessages(
        com.google.chat.v1.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListMessagesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists memberships in a space. For an example, see [List users and Google
     * Chat apps in a
     * space](https://developers.google.com/workspace/chat/list-members). Listing
     * memberships with [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * lists memberships in spaces that the Chat app has
     * access to, but excludes Chat app memberships,
     * including its own. Listing memberships with
     * [User
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * lists memberships in spaces that the authenticated user has access to.
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void listMemberships(
        com.google.chat.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMembershipsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a membership. For an example, see
     * [Get details about a user's or Google Chat app's
     * membership](https://developers.google.com/workspace/chat/get-members).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void getMembership(
        com.google.chat.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a message.
     * For an example, see [Get details about a
     * message](https://developers.google.com/workspace/chat/get-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Note: Might return a message from a blocked member or space.
     * </pre>
     */
    default void getMessage(
        com.google.chat.v1.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a message. There's a difference between the `patch` and `update`
     * methods. The `patch`
     * method uses a `patch` request while the `update` method uses a `put`
     * request. We recommend using the `patch` method. For an example, see
     * [Update a
     * message](https://developers.google.com/workspace/chat/update-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only update messages
     * created by the calling Chat app.
     * </pre>
     */
    default void updateMessage(
        com.google.chat.v1.UpdateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a message.
     * For an example, see [Delete a
     * message](https://developers.google.com/workspace/chat/delete-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only delete messages
     * created by the calling Chat app.
     * </pre>
     */
    default void deleteMessage(
        com.google.chat.v1.DeleteMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata of a message attachment. The attachment data is fetched
     * using the [media
     * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download).
     * For an example, see
     * [Get metadata about a message
     * attachment](https://developers.google.com/workspace/chat/get-media-attachments).
     * Requires [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    default void getAttachment(
        com.google.chat.v1.GetAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Attachment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads an attachment. For an example, see
     * [Upload media as a file
     * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
     * Requires user
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * You can upload attachments up to 200 MB. Certain file types aren't
     * supported. For details, see [File types blocked by Google
     * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
     * </pre>
     */
    default void uploadAttachment(
        com.google.chat.v1.UploadAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.UploadAttachmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadAttachmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces the caller is a member of. Group chats and DMs aren't listed
     * until the first message is sent. For an example, see
     * [List
     * spaces](https://developers.google.com/workspace/chat/list-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Lists spaces visible to the caller or authenticated user. Group chats
     * and DMs aren't listed until the first message is sent.
     * </pre>
     */
    default void listSpaces(
        com.google.chat.v1.ListSpacesRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListSpacesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSpacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a space. For an example, see
     * [Get details about a
     * space](https://developers.google.com/workspace/chat/get-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void getSpace(
        com.google.chat.v1.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a named space. Spaces grouped by topics aren't supported. For an
     * example, see [Create a
     * space](https://developers.google.com/workspace/chat/create-spaces).
     *  If you receive the error message `ALREADY_EXISTS` when creating
     *  a space, try a different `displayName`. An existing space within
     *  the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void createSpace(
        com.google.chat.v1.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a space and adds specified users to it. The calling user is
     * automatically added to the space, and shouldn't be specified as a
     * membership in the request. For an example, see
     * [Set up a space with initial
     * members](https://developers.google.com/workspace/chat/set-up-spaces).
     * To specify the human members to add, add memberships with the appropriate
     * `member.name` in the `SetUpSpaceRequest`. To add a human user, use
     * `users/{user}`, where `{user}` can be the email address for the user. For
     * users in the same Workspace organization `{user}` can also be the `id` for
     * the person from the People API, or the `id` for the user in the Directory
     * API. For example, if the People API Person profile ID for
     * `user&#64;example.com` is `123456789`, you can add the user to the space by
     * setting the `membership.member.name` to `users/user&#64;example.com` or
     * `users/123456789`.
     * For a space or group chat, if the caller blocks or is blocked by some
     * members, then those members aren't added to the created space.
     * To create a direct message (DM) between the calling user and another human
     * user, specify exactly one membership to represent the human user. If
     * one user blocks the other, the request fails and the DM isn't created.
     * To create a DM between the calling user and the calling app, set
     * `Space.singleUserBotDm` to `true` and don't specify any memberships. You
     * can only use this method to set up a DM with the calling app. To add the
     * calling app as a member of a space or an existing DM between two human
     * users, see
     * [Invite or add a user or app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * If a DM already exists between two users, even when one user blocks the
     * other at the time a request is made, then the existing DM is returned.
     * Spaces with threaded replies aren't supported. If you receive the error
     * message `ALREADY_EXISTS` when setting up a space, try a different
     * `displayName`. An existing space within the Google Workspace organization
     * might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void setUpSpace(
        com.google.chat.v1.SetUpSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSetUpSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a space. For an example, see
     * [Update a
     * space](https://developers.google.com/workspace/chat/update-spaces).
     * If you're updating the `displayName` field and receive the error message
     * `ALREADY_EXISTS`, try a different display name.. An existing space within
     * the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void updateSpace(
        com.google.chat.v1.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a named space. Always performs a cascading delete, which means
     * that the space's child resources—like messages posted in the space and
     * memberships in the space—are also deleted. For an example, see
     * [Delete a
     * space](https://developers.google.com/workspace/chat/delete-spaces).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * from a user who has permission to delete the space.
     * </pre>
     */
    default void deleteSpace(
        com.google.chat.v1.DeleteSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes the
     * [import process](https://developers.google.com/workspace/chat/import-data)
     * for the specified space and makes it visible to users.
     * Requires app authentication and domain-wide delegation. For more
     * information, see [Authorize Google Chat apps to import
     * data](https://developers.google.com/workspace/chat/authorize-import).
     * </pre>
     */
    default void completeImportSpace(
        com.google.chat.v1.CompleteImportSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.CompleteImportSpaceResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteImportSpaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the existing direct message with the specified user. If no direct
     * message space is found, returns a `404 NOT_FOUND` error. For an example,
     * see
     * [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message).
     * With [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
     * returns the direct message space between the specified user and the
     * authenticated user.
     * With [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
     * returns the direct message space between the specified user and the calling
     * Chat app.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * or [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    default void findDirectMessage(
        com.google.chat.v1.FindDirectMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFindDirectMessageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a human membership or app membership for the calling app. Creating
     * memberships for other apps isn't supported. For an example, see
     * [Invite or add a user or a Google Chat app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * When creating a membership, if the specified member has their auto-accept
     * policy turned off, then they're invited, and must accept the space
     * invitation before joining. Otherwise, creating a membership adds the member
     * directly to the specified space. Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * To specify the member to add, set the `membership.member.name` in the
     * `CreateMembershipRequest`:
     * - To add the calling app to a space or a direct message between two human
     *   users, use `users/app`. Unable to add other
     *   apps to the space.
     * - To add a human user, use `users/{user}`, where `{user}` can be the email
     * address for the user. For users in the same Workspace organization `{user}`
     * can also be the `id` for the person from the People API, or the `id` for
     * the user in the Directory API. For example, if the People API Person
     * profile ID for `user&#64;example.com` is `123456789`, you can add the user to
     * the space by setting the `membership.member.name` to
     * `users/user&#64;example.com` or `users/123456789`.
     * </pre>
     */
    default void createMembership(
        com.google.chat.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a membership. Requires [user
     * authentication](https://developers.google.com/chat/api/guides/auth/users).
     * </pre>
     */
    default void updateMembership(
        com.google.chat.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a membership. For an example, see
     * [Remove a user or a Google Chat app from a
     * space](https://developers.google.com/workspace/chat/delete-members).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void deleteMembership(
        com.google.chat.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMembershipMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a reaction and adds it to a message. Only unicode emojis are
     * supported. For an example, see
     * [Add a reaction to a
     * message](https://developers.google.com/workspace/chat/create-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void createReaction(
        com.google.chat.v1.CreateReactionRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Reaction> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReactionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reactions to a message. For an example, see
     * [List reactions for a
     * message](https://developers.google.com/workspace/chat/list-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void listReactions(
        com.google.chat.v1.ListReactionsRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListReactionsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReactionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reaction to a message. Only unicode emojis are supported.
     * For an example, see
     * [Delete a
     * reaction](https://developers.google.com/workspace/chat/delete-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void deleteReaction(
        com.google.chat.v1.DeleteReactionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReactionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a space, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void getSpaceReadState(
        com.google.chat.v1.GetSpaceReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSpaceReadStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user's read state within a space, used to identify read and
     * unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void updateSpaceReadState(
        com.google.chat.v1.UpdateSpaceReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSpaceReadStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a thread, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    default void getThreadReadState(
        com.google.chat.v1.GetThreadReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ThreadReadState> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetThreadReadStateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ChatService.
   *
   * <pre>
   * Enables developers to build Chat apps and
   * integrations on Google Chat Platform.
   * </pre>
   */
  public abstract static class ChatServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ChatServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ChatService.
   *
   * <pre>
   * Enables developers to build Chat apps and
   * integrations on Google Chat Platform.
   * </pre>
   */
  public static final class ChatServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ChatServiceStub> {
    private ChatServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a message in a Google Chat space. For an example, see [Send a
     * message](https://developers.google.com/workspace/chat/create-messages).
     * Calling this method requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize)
     * and supports the following authentication types:
     * - For text messages, user authentication or app authentication are
     * supported.
     * - For card messages, only app authentication is supported. (Only Chat apps
     * can create card messages.)
     * </pre>
     */
    public void createMessage(
        com.google.chat.v1.CreateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists messages in a space that the caller is a member of, including
     * messages from blocked members and spaces. For an example, see
     * [List messages](/chat/api/guides/v1/messages/list).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void listMessages(
        com.google.chat.v1.ListMessagesRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListMessagesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists memberships in a space. For an example, see [List users and Google
     * Chat apps in a
     * space](https://developers.google.com/workspace/chat/list-members). Listing
     * memberships with [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * lists memberships in spaces that the Chat app has
     * access to, but excludes Chat app memberships,
     * including its own. Listing memberships with
     * [User
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * lists memberships in spaces that the authenticated user has access to.
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void listMemberships(
        com.google.chat.v1.ListMembershipsRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListMembershipsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a membership. For an example, see
     * [Get details about a user's or Google Chat app's
     * membership](https://developers.google.com/workspace/chat/get-members).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void getMembership(
        com.google.chat.v1.GetMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a message.
     * For an example, see [Get details about a
     * message](https://developers.google.com/workspace/chat/get-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Note: Might return a message from a blocked member or space.
     * </pre>
     */
    public void getMessage(
        com.google.chat.v1.GetMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a message. There's a difference between the `patch` and `update`
     * methods. The `patch`
     * method uses a `patch` request while the `update` method uses a `put`
     * request. We recommend using the `patch` method. For an example, see
     * [Update a
     * message](https://developers.google.com/workspace/chat/update-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only update messages
     * created by the calling Chat app.
     * </pre>
     */
    public void updateMessage(
        com.google.chat.v1.UpdateMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a message.
     * For an example, see [Delete a
     * message](https://developers.google.com/workspace/chat/delete-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only delete messages
     * created by the calling Chat app.
     * </pre>
     */
    public void deleteMessage(
        com.google.chat.v1.DeleteMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata of a message attachment. The attachment data is fetched
     * using the [media
     * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download).
     * For an example, see
     * [Get metadata about a message
     * attachment](https://developers.google.com/workspace/chat/get-media-attachments).
     * Requires [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public void getAttachment(
        com.google.chat.v1.GetAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Attachment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Uploads an attachment. For an example, see
     * [Upload media as a file
     * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
     * Requires user
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * You can upload attachments up to 200 MB. Certain file types aren't
     * supported. For details, see [File types blocked by Google
     * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
     * </pre>
     */
    public void uploadAttachment(
        com.google.chat.v1.UploadAttachmentRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.UploadAttachmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadAttachmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces the caller is a member of. Group chats and DMs aren't listed
     * until the first message is sent. For an example, see
     * [List
     * spaces](https://developers.google.com/workspace/chat/list-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Lists spaces visible to the caller or authenticated user. Group chats
     * and DMs aren't listed until the first message is sent.
     * </pre>
     */
    public void listSpaces(
        com.google.chat.v1.ListSpacesRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListSpacesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSpacesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a space. For an example, see
     * [Get details about a
     * space](https://developers.google.com/workspace/chat/get-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void getSpace(
        com.google.chat.v1.GetSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a named space. Spaces grouped by topics aren't supported. For an
     * example, see [Create a
     * space](https://developers.google.com/workspace/chat/create-spaces).
     *  If you receive the error message `ALREADY_EXISTS` when creating
     *  a space, try a different `displayName`. An existing space within
     *  the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void createSpace(
        com.google.chat.v1.CreateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a space and adds specified users to it. The calling user is
     * automatically added to the space, and shouldn't be specified as a
     * membership in the request. For an example, see
     * [Set up a space with initial
     * members](https://developers.google.com/workspace/chat/set-up-spaces).
     * To specify the human members to add, add memberships with the appropriate
     * `member.name` in the `SetUpSpaceRequest`. To add a human user, use
     * `users/{user}`, where `{user}` can be the email address for the user. For
     * users in the same Workspace organization `{user}` can also be the `id` for
     * the person from the People API, or the `id` for the user in the Directory
     * API. For example, if the People API Person profile ID for
     * `user&#64;example.com` is `123456789`, you can add the user to the space by
     * setting the `membership.member.name` to `users/user&#64;example.com` or
     * `users/123456789`.
     * For a space or group chat, if the caller blocks or is blocked by some
     * members, then those members aren't added to the created space.
     * To create a direct message (DM) between the calling user and another human
     * user, specify exactly one membership to represent the human user. If
     * one user blocks the other, the request fails and the DM isn't created.
     * To create a DM between the calling user and the calling app, set
     * `Space.singleUserBotDm` to `true` and don't specify any memberships. You
     * can only use this method to set up a DM with the calling app. To add the
     * calling app as a member of a space or an existing DM between two human
     * users, see
     * [Invite or add a user or app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * If a DM already exists between two users, even when one user blocks the
     * other at the time a request is made, then the existing DM is returned.
     * Spaces with threaded replies aren't supported. If you receive the error
     * message `ALREADY_EXISTS` when setting up a space, try a different
     * `displayName`. An existing space within the Google Workspace organization
     * might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void setUpSpace(
        com.google.chat.v1.SetUpSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetUpSpaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a space. For an example, see
     * [Update a
     * space](https://developers.google.com/workspace/chat/update-spaces).
     * If you're updating the `displayName` field and receive the error message
     * `ALREADY_EXISTS`, try a different display name.. An existing space within
     * the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void updateSpace(
        com.google.chat.v1.UpdateSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a named space. Always performs a cascading delete, which means
     * that the space's child resources—like messages posted in the space and
     * memberships in the space—are also deleted. For an example, see
     * [Delete a
     * space](https://developers.google.com/workspace/chat/delete-spaces).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * from a user who has permission to delete the space.
     * </pre>
     */
    public void deleteSpace(
        com.google.chat.v1.DeleteSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Completes the
     * [import process](https://developers.google.com/workspace/chat/import-data)
     * for the specified space and makes it visible to users.
     * Requires app authentication and domain-wide delegation. For more
     * information, see [Authorize Google Chat apps to import
     * data](https://developers.google.com/workspace/chat/authorize-import).
     * </pre>
     */
    public void completeImportSpace(
        com.google.chat.v1.CompleteImportSpaceRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.CompleteImportSpaceResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteImportSpaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the existing direct message with the specified user. If no direct
     * message space is found, returns a `404 NOT_FOUND` error. For an example,
     * see
     * [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message).
     * With [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
     * returns the direct message space between the specified user and the
     * authenticated user.
     * With [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
     * returns the direct message space between the specified user and the calling
     * Chat app.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * or [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public void findDirectMessage(
        com.google.chat.v1.FindDirectMessageRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Space> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFindDirectMessageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a human membership or app membership for the calling app. Creating
     * memberships for other apps isn't supported. For an example, see
     * [Invite or add a user or a Google Chat app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * When creating a membership, if the specified member has their auto-accept
     * policy turned off, then they're invited, and must accept the space
     * invitation before joining. Otherwise, creating a membership adds the member
     * directly to the specified space. Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * To specify the member to add, set the `membership.member.name` in the
     * `CreateMembershipRequest`:
     * - To add the calling app to a space or a direct message between two human
     *   users, use `users/app`. Unable to add other
     *   apps to the space.
     * - To add a human user, use `users/{user}`, where `{user}` can be the email
     * address for the user. For users in the same Workspace organization `{user}`
     * can also be the `id` for the person from the People API, or the `id` for
     * the user in the Directory API. For example, if the People API Person
     * profile ID for `user&#64;example.com` is `123456789`, you can add the user to
     * the space by setting the `membership.member.name` to
     * `users/user&#64;example.com` or `users/123456789`.
     * </pre>
     */
    public void createMembership(
        com.google.chat.v1.CreateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a membership. Requires [user
     * authentication](https://developers.google.com/chat/api/guides/auth/users).
     * </pre>
     */
    public void updateMembership(
        com.google.chat.v1.UpdateMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a membership. For an example, see
     * [Remove a user or a Google Chat app from a
     * space](https://developers.google.com/workspace/chat/delete-members).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void deleteMembership(
        com.google.chat.v1.DeleteMembershipRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Membership> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a reaction and adds it to a message. Only unicode emojis are
     * supported. For an example, see
     * [Add a reaction to a
     * message](https://developers.google.com/workspace/chat/create-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void createReaction(
        com.google.chat.v1.CreateReactionRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.Reaction> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReactionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists reactions to a message. For an example, see
     * [List reactions for a
     * message](https://developers.google.com/workspace/chat/list-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void listReactions(
        com.google.chat.v1.ListReactionsRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ListReactionsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReactionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reaction to a message. Only unicode emojis are supported.
     * For an example, see
     * [Delete a
     * reaction](https://developers.google.com/workspace/chat/delete-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void deleteReaction(
        com.google.chat.v1.DeleteReactionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReactionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a space, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void getSpaceReadState(
        com.google.chat.v1.GetSpaceReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpaceReadStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a user's read state within a space, used to identify read and
     * unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void updateSpaceReadState(
        com.google.chat.v1.UpdateSpaceReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpaceReadStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a thread, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public void getThreadReadState(
        com.google.chat.v1.GetThreadReadStateRequest request,
        io.grpc.stub.StreamObserver<com.google.chat.v1.ThreadReadState> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetThreadReadStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ChatService.
   *
   * <pre>
   * Enables developers to build Chat apps and
   * integrations on Google Chat Platform.
   * </pre>
   */
  public static final class ChatServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ChatServiceBlockingStub> {
    private ChatServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a message in a Google Chat space. For an example, see [Send a
     * message](https://developers.google.com/workspace/chat/create-messages).
     * Calling this method requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize)
     * and supports the following authentication types:
     * - For text messages, user authentication or app authentication are
     * supported.
     * - For card messages, only app authentication is supported. (Only Chat apps
     * can create card messages.)
     * </pre>
     */
    public com.google.chat.v1.Message createMessage(
        com.google.chat.v1.CreateMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists messages in a space that the caller is a member of, including
     * messages from blocked members and spaces. For an example, see
     * [List messages](/chat/api/guides/v1/messages/list).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.ListMessagesResponse listMessages(
        com.google.chat.v1.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists memberships in a space. For an example, see [List users and Google
     * Chat apps in a
     * space](https://developers.google.com/workspace/chat/list-members). Listing
     * memberships with [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * lists memberships in spaces that the Chat app has
     * access to, but excludes Chat app memberships,
     * including its own. Listing memberships with
     * [User
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * lists memberships in spaces that the authenticated user has access to.
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.ListMembershipsResponse listMemberships(
        com.google.chat.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMembershipsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a membership. For an example, see
     * [Get details about a user's or Google Chat app's
     * membership](https://developers.google.com/workspace/chat/get-members).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Membership getMembership(
        com.google.chat.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a message.
     * For an example, see [Get details about a
     * message](https://developers.google.com/workspace/chat/get-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Note: Might return a message from a blocked member or space.
     * </pre>
     */
    public com.google.chat.v1.Message getMessage(com.google.chat.v1.GetMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a message. There's a difference between the `patch` and `update`
     * methods. The `patch`
     * method uses a `patch` request while the `update` method uses a `put`
     * request. We recommend using the `patch` method. For an example, see
     * [Update a
     * message](https://developers.google.com/workspace/chat/update-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only update messages
     * created by the calling Chat app.
     * </pre>
     */
    public com.google.chat.v1.Message updateMessage(
        com.google.chat.v1.UpdateMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a message.
     * For an example, see [Delete a
     * message](https://developers.google.com/workspace/chat/delete-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only delete messages
     * created by the calling Chat app.
     * </pre>
     */
    public com.google.protobuf.Empty deleteMessage(
        com.google.chat.v1.DeleteMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata of a message attachment. The attachment data is fetched
     * using the [media
     * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download).
     * For an example, see
     * [Get metadata about a message
     * attachment](https://developers.google.com/workspace/chat/get-media-attachments).
     * Requires [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public com.google.chat.v1.Attachment getAttachment(
        com.google.chat.v1.GetAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads an attachment. For an example, see
     * [Upload media as a file
     * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
     * Requires user
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * You can upload attachments up to 200 MB. Certain file types aren't
     * supported. For details, see [File types blocked by Google
     * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
     * </pre>
     */
    public com.google.chat.v1.UploadAttachmentResponse uploadAttachment(
        com.google.chat.v1.UploadAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadAttachmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces the caller is a member of. Group chats and DMs aren't listed
     * until the first message is sent. For an example, see
     * [List
     * spaces](https://developers.google.com/workspace/chat/list-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Lists spaces visible to the caller or authenticated user. Group chats
     * and DMs aren't listed until the first message is sent.
     * </pre>
     */
    public com.google.chat.v1.ListSpacesResponse listSpaces(
        com.google.chat.v1.ListSpacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSpacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a space. For an example, see
     * [Get details about a
     * space](https://developers.google.com/workspace/chat/get-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Space getSpace(com.google.chat.v1.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a named space. Spaces grouped by topics aren't supported. For an
     * example, see [Create a
     * space](https://developers.google.com/workspace/chat/create-spaces).
     *  If you receive the error message `ALREADY_EXISTS` when creating
     *  a space, try a different `displayName`. An existing space within
     *  the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Space createSpace(com.google.chat.v1.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a space and adds specified users to it. The calling user is
     * automatically added to the space, and shouldn't be specified as a
     * membership in the request. For an example, see
     * [Set up a space with initial
     * members](https://developers.google.com/workspace/chat/set-up-spaces).
     * To specify the human members to add, add memberships with the appropriate
     * `member.name` in the `SetUpSpaceRequest`. To add a human user, use
     * `users/{user}`, where `{user}` can be the email address for the user. For
     * users in the same Workspace organization `{user}` can also be the `id` for
     * the person from the People API, or the `id` for the user in the Directory
     * API. For example, if the People API Person profile ID for
     * `user&#64;example.com` is `123456789`, you can add the user to the space by
     * setting the `membership.member.name` to `users/user&#64;example.com` or
     * `users/123456789`.
     * For a space or group chat, if the caller blocks or is blocked by some
     * members, then those members aren't added to the created space.
     * To create a direct message (DM) between the calling user and another human
     * user, specify exactly one membership to represent the human user. If
     * one user blocks the other, the request fails and the DM isn't created.
     * To create a DM between the calling user and the calling app, set
     * `Space.singleUserBotDm` to `true` and don't specify any memberships. You
     * can only use this method to set up a DM with the calling app. To add the
     * calling app as a member of a space or an existing DM between two human
     * users, see
     * [Invite or add a user or app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * If a DM already exists between two users, even when one user blocks the
     * other at the time a request is made, then the existing DM is returned.
     * Spaces with threaded replies aren't supported. If you receive the error
     * message `ALREADY_EXISTS` when setting up a space, try a different
     * `displayName`. An existing space within the Google Workspace organization
     * might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Space setUpSpace(com.google.chat.v1.SetUpSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetUpSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a space. For an example, see
     * [Update a
     * space](https://developers.google.com/workspace/chat/update-spaces).
     * If you're updating the `displayName` field and receive the error message
     * `ALREADY_EXISTS`, try a different display name.. An existing space within
     * the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Space updateSpace(com.google.chat.v1.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a named space. Always performs a cascading delete, which means
     * that the space's child resources—like messages posted in the space and
     * memberships in the space—are also deleted. For an example, see
     * [Delete a
     * space](https://developers.google.com/workspace/chat/delete-spaces).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * from a user who has permission to delete the space.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSpace(com.google.chat.v1.DeleteSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Completes the
     * [import process](https://developers.google.com/workspace/chat/import-data)
     * for the specified space and makes it visible to users.
     * Requires app authentication and domain-wide delegation. For more
     * information, see [Authorize Google Chat apps to import
     * data](https://developers.google.com/workspace/chat/authorize-import).
     * </pre>
     */
    public com.google.chat.v1.CompleteImportSpaceResponse completeImportSpace(
        com.google.chat.v1.CompleteImportSpaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteImportSpaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the existing direct message with the specified user. If no direct
     * message space is found, returns a `404 NOT_FOUND` error. For an example,
     * see
     * [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message).
     * With [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
     * returns the direct message space between the specified user and the
     * authenticated user.
     * With [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
     * returns the direct message space between the specified user and the calling
     * Chat app.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * or [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public com.google.chat.v1.Space findDirectMessage(
        com.google.chat.v1.FindDirectMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFindDirectMessageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a human membership or app membership for the calling app. Creating
     * memberships for other apps isn't supported. For an example, see
     * [Invite or add a user or a Google Chat app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * When creating a membership, if the specified member has their auto-accept
     * policy turned off, then they're invited, and must accept the space
     * invitation before joining. Otherwise, creating a membership adds the member
     * directly to the specified space. Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * To specify the member to add, set the `membership.member.name` in the
     * `CreateMembershipRequest`:
     * - To add the calling app to a space or a direct message between two human
     *   users, use `users/app`. Unable to add other
     *   apps to the space.
     * - To add a human user, use `users/{user}`, where `{user}` can be the email
     * address for the user. For users in the same Workspace organization `{user}`
     * can also be the `id` for the person from the People API, or the `id` for
     * the user in the Directory API. For example, if the People API Person
     * profile ID for `user&#64;example.com` is `123456789`, you can add the user to
     * the space by setting the `membership.member.name` to
     * `users/user&#64;example.com` or `users/123456789`.
     * </pre>
     */
    public com.google.chat.v1.Membership createMembership(
        com.google.chat.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a membership. Requires [user
     * authentication](https://developers.google.com/chat/api/guides/auth/users).
     * </pre>
     */
    public com.google.chat.v1.Membership updateMembership(
        com.google.chat.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a membership. For an example, see
     * [Remove a user or a Google Chat app from a
     * space](https://developers.google.com/workspace/chat/delete-members).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Membership deleteMembership(
        com.google.chat.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMembershipMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a reaction and adds it to a message. Only unicode emojis are
     * supported. For an example, see
     * [Add a reaction to a
     * message](https://developers.google.com/workspace/chat/create-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.Reaction createReaction(
        com.google.chat.v1.CreateReactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reactions to a message. For an example, see
     * [List reactions for a
     * message](https://developers.google.com/workspace/chat/list-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.ListReactionsResponse listReactions(
        com.google.chat.v1.ListReactionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReactionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reaction to a message. Only unicode emojis are supported.
     * For an example, see
     * [Delete a
     * reaction](https://developers.google.com/workspace/chat/delete-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.protobuf.Empty deleteReaction(
        com.google.chat.v1.DeleteReactionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReactionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a space, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.SpaceReadState getSpaceReadState(
        com.google.chat.v1.GetSpaceReadStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpaceReadStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user's read state within a space, used to identify read and
     * unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.SpaceReadState updateSpaceReadState(
        com.google.chat.v1.UpdateSpaceReadStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpaceReadStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a thread, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.chat.v1.ThreadReadState getThreadReadState(
        com.google.chat.v1.GetThreadReadStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetThreadReadStateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ChatService.
   *
   * <pre>
   * Enables developers to build Chat apps and
   * integrations on Google Chat Platform.
   * </pre>
   */
  public static final class ChatServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ChatServiceFutureStub> {
    private ChatServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ChatServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ChatServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a message in a Google Chat space. For an example, see [Send a
     * message](https://developers.google.com/workspace/chat/create-messages).
     * Calling this method requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize)
     * and supports the following authentication types:
     * - For text messages, user authentication or app authentication are
     * supported.
     * - For card messages, only app authentication is supported. (Only Chat apps
     * can create card messages.)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Message>
        createMessage(com.google.chat.v1.CreateMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists messages in a space that the caller is a member of, including
     * messages from blocked members and spaces. For an example, see
     * [List messages](/chat/api/guides/v1/messages/list).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.chat.v1.ListMessagesResponse>
        listMessages(com.google.chat.v1.ListMessagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists memberships in a space. For an example, see [List users and Google
     * Chat apps in a
     * space](https://developers.google.com/workspace/chat/list-members). Listing
     * memberships with [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * lists memberships in spaces that the Chat app has
     * access to, but excludes Chat app memberships,
     * including its own. Listing memberships with
     * [User
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * lists memberships in spaces that the authenticated user has access to.
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.chat.v1.ListMembershipsResponse>
        listMemberships(com.google.chat.v1.ListMembershipsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMembershipsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a membership. For an example, see
     * [Get details about a user's or Google Chat app's
     * membership](https://developers.google.com/workspace/chat/get-members).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Membership>
        getMembership(com.google.chat.v1.GetMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a message.
     * For an example, see [Get details about a
     * message](https://developers.google.com/workspace/chat/get-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Note: Might return a message from a blocked member or space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Message>
        getMessage(com.google.chat.v1.GetMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a message. There's a difference between the `patch` and `update`
     * methods. The `patch`
     * method uses a `patch` request while the `update` method uses a `put`
     * request. We recommend using the `patch` method. For an example, see
     * [Update a
     * message](https://developers.google.com/workspace/chat/update-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only update messages
     * created by the calling Chat app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Message>
        updateMessage(com.google.chat.v1.UpdateMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a message.
     * For an example, see [Delete a
     * message](https://developers.google.com/workspace/chat/delete-messages).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * When using app authentication, requests can only delete messages
     * created by the calling Chat app.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteMessage(com.google.chat.v1.DeleteMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the metadata of a message attachment. The attachment data is fetched
     * using the [media
     * API](https://developers.google.com/workspace/chat/api/reference/rest/v1/media/download).
     * For an example, see
     * [Get metadata about a message
     * attachment](https://developers.google.com/workspace/chat/get-media-attachments).
     * Requires [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Attachment>
        getAttachment(com.google.chat.v1.GetAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttachmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Uploads an attachment. For an example, see
     * [Upload media as a file
     * attachment](https://developers.google.com/workspace/chat/upload-media-attachments).
     * Requires user
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * You can upload attachments up to 200 MB. Certain file types aren't
     * supported. For details, see [File types blocked by Google
     * Chat](https://support.google.com/chat/answer/7651457?&amp;co=GENIE.Platform%3DDesktop#File%20types%20blocked%20in%20Google%20Chat).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.chat.v1.UploadAttachmentResponse>
        uploadAttachment(com.google.chat.v1.UploadAttachmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadAttachmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists spaces the caller is a member of. Group chats and DMs aren't listed
     * until the first message is sent. For an example, see
     * [List
     * spaces](https://developers.google.com/workspace/chat/list-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * Lists spaces visible to the caller or authenticated user. Group chats
     * and DMs aren't listed until the first message is sent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.ListSpacesResponse>
        listSpaces(com.google.chat.v1.ListSpacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSpacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a space. For an example, see
     * [Get details about a
     * space](https://developers.google.com/workspace/chat/get-spaces).
     * Requires
     * [authentication](https://developers.google.com/workspace/chat/authenticate-authorize).
     * Supports
     * [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app)
     * and [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Space> getSpace(
        com.google.chat.v1.GetSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a named space. Spaces grouped by topics aren't supported. For an
     * example, see [Create a
     * space](https://developers.google.com/workspace/chat/create-spaces).
     *  If you receive the error message `ALREADY_EXISTS` when creating
     *  a space, try a different `displayName`. An existing space within
     *  the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Space> createSpace(
        com.google.chat.v1.CreateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a space and adds specified users to it. The calling user is
     * automatically added to the space, and shouldn't be specified as a
     * membership in the request. For an example, see
     * [Set up a space with initial
     * members](https://developers.google.com/workspace/chat/set-up-spaces).
     * To specify the human members to add, add memberships with the appropriate
     * `member.name` in the `SetUpSpaceRequest`. To add a human user, use
     * `users/{user}`, where `{user}` can be the email address for the user. For
     * users in the same Workspace organization `{user}` can also be the `id` for
     * the person from the People API, or the `id` for the user in the Directory
     * API. For example, if the People API Person profile ID for
     * `user&#64;example.com` is `123456789`, you can add the user to the space by
     * setting the `membership.member.name` to `users/user&#64;example.com` or
     * `users/123456789`.
     * For a space or group chat, if the caller blocks or is blocked by some
     * members, then those members aren't added to the created space.
     * To create a direct message (DM) between the calling user and another human
     * user, specify exactly one membership to represent the human user. If
     * one user blocks the other, the request fails and the DM isn't created.
     * To create a DM between the calling user and the calling app, set
     * `Space.singleUserBotDm` to `true` and don't specify any memberships. You
     * can only use this method to set up a DM with the calling app. To add the
     * calling app as a member of a space or an existing DM between two human
     * users, see
     * [Invite or add a user or app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * If a DM already exists between two users, even when one user blocks the
     * other at the time a request is made, then the existing DM is returned.
     * Spaces with threaded replies aren't supported. If you receive the error
     * message `ALREADY_EXISTS` when setting up a space, try a different
     * `displayName`. An existing space within the Google Workspace organization
     * might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Space> setUpSpace(
        com.google.chat.v1.SetUpSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetUpSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a space. For an example, see
     * [Update a
     * space](https://developers.google.com/workspace/chat/update-spaces).
     * If you're updating the `displayName` field and receive the error message
     * `ALREADY_EXISTS`, try a different display name.. An existing space within
     * the Google Workspace organization might already use this display name.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Space> updateSpace(
        com.google.chat.v1.UpdateSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a named space. Always performs a cascading delete, which means
     * that the space's child resources—like messages posted in the space and
     * memberships in the space—are also deleted. For an example, see
     * [Delete a
     * space](https://developers.google.com/workspace/chat/delete-spaces).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * from a user who has permission to delete the space.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSpace(com.google.chat.v1.DeleteSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Completes the
     * [import process](https://developers.google.com/workspace/chat/import-data)
     * for the specified space and makes it visible to users.
     * Requires app authentication and domain-wide delegation. For more
     * information, see [Authorize Google Chat apps to import
     * data](https://developers.google.com/workspace/chat/authorize-import).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.chat.v1.CompleteImportSpaceResponse>
        completeImportSpace(com.google.chat.v1.CompleteImportSpaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteImportSpaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the existing direct message with the specified user. If no direct
     * message space is found, returns a `404 NOT_FOUND` error. For an example,
     * see
     * [Find a direct message](/chat/api/guides/v1/spaces/find-direct-message).
     * With [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user),
     * returns the direct message space between the specified user and the
     * authenticated user.
     * With [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app),
     * returns the direct message space between the specified user and the calling
     * Chat app.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user)
     * or [app
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-app).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Space>
        findDirectMessage(com.google.chat.v1.FindDirectMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFindDirectMessageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a human membership or app membership for the calling app. Creating
     * memberships for other apps isn't supported. For an example, see
     * [Invite or add a user or a Google Chat app to a
     * space](https://developers.google.com/workspace/chat/create-members).
     * When creating a membership, if the specified member has their auto-accept
     * policy turned off, then they're invited, and must accept the space
     * invitation before joining. Otherwise, creating a membership adds the member
     * directly to the specified space. Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * To specify the member to add, set the `membership.member.name` in the
     * `CreateMembershipRequest`:
     * - To add the calling app to a space or a direct message between two human
     *   users, use `users/app`. Unable to add other
     *   apps to the space.
     * - To add a human user, use `users/{user}`, where `{user}` can be the email
     * address for the user. For users in the same Workspace organization `{user}`
     * can also be the `id` for the person from the People API, or the `id` for
     * the user in the Directory API. For example, if the People API Person
     * profile ID for `user&#64;example.com` is `123456789`, you can add the user to
     * the space by setting the `membership.member.name` to
     * `users/user&#64;example.com` or `users/123456789`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Membership>
        createMembership(com.google.chat.v1.CreateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a membership. Requires [user
     * authentication](https://developers.google.com/chat/api/guides/auth/users).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Membership>
        updateMembership(com.google.chat.v1.UpdateMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a membership. For an example, see
     * [Remove a user or a Google Chat app from a
     * space](https://developers.google.com/workspace/chat/delete-members).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Membership>
        deleteMembership(com.google.chat.v1.DeleteMembershipRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMembershipMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a reaction and adds it to a message. Only unicode emojis are
     * supported. For an example, see
     * [Add a reaction to a
     * message](https://developers.google.com/workspace/chat/create-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.Reaction>
        createReaction(com.google.chat.v1.CreateReactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReactionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists reactions to a message. For an example, see
     * [List reactions for a
     * message](https://developers.google.com/workspace/chat/list-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.chat.v1.ListReactionsResponse>
        listReactions(com.google.chat.v1.ListReactionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReactionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a reaction to a message. Only unicode emojis are supported.
     * For an example, see
     * [Delete a
     * reaction](https://developers.google.com/workspace/chat/delete-reactions).
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteReaction(com.google.chat.v1.DeleteReactionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReactionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a space, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.SpaceReadState>
        getSpaceReadState(com.google.chat.v1.GetSpaceReadStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpaceReadStateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a user's read state within a space, used to identify read and
     * unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.SpaceReadState>
        updateSpaceReadState(com.google.chat.v1.UpdateSpaceReadStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpaceReadStateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns details about a user's read state within a thread, used to identify
     * read and unread messages.
     * Requires [user
     * authentication](https://developers.google.com/workspace/chat/authenticate-authorize-chat-user).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.chat.v1.ThreadReadState>
        getThreadReadState(com.google.chat.v1.GetThreadReadStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetThreadReadStateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_MESSAGE = 0;
  private static final int METHODID_LIST_MESSAGES = 1;
  private static final int METHODID_LIST_MEMBERSHIPS = 2;
  private static final int METHODID_GET_MEMBERSHIP = 3;
  private static final int METHODID_GET_MESSAGE = 4;
  private static final int METHODID_UPDATE_MESSAGE = 5;
  private static final int METHODID_DELETE_MESSAGE = 6;
  private static final int METHODID_GET_ATTACHMENT = 7;
  private static final int METHODID_UPLOAD_ATTACHMENT = 8;
  private static final int METHODID_LIST_SPACES = 9;
  private static final int METHODID_GET_SPACE = 10;
  private static final int METHODID_CREATE_SPACE = 11;
  private static final int METHODID_SET_UP_SPACE = 12;
  private static final int METHODID_UPDATE_SPACE = 13;
  private static final int METHODID_DELETE_SPACE = 14;
  private static final int METHODID_COMPLETE_IMPORT_SPACE = 15;
  private static final int METHODID_FIND_DIRECT_MESSAGE = 16;
  private static final int METHODID_CREATE_MEMBERSHIP = 17;
  private static final int METHODID_UPDATE_MEMBERSHIP = 18;
  private static final int METHODID_DELETE_MEMBERSHIP = 19;
  private static final int METHODID_CREATE_REACTION = 20;
  private static final int METHODID_LIST_REACTIONS = 21;
  private static final int METHODID_DELETE_REACTION = 22;
  private static final int METHODID_GET_SPACE_READ_STATE = 23;
  private static final int METHODID_UPDATE_SPACE_READ_STATE = 24;
  private static final int METHODID_GET_THREAD_READ_STATE = 25;

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
        case METHODID_CREATE_MESSAGE:
          serviceImpl.createMessage(
              (com.google.chat.v1.CreateMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Message>) responseObserver);
          break;
        case METHODID_LIST_MESSAGES:
          serviceImpl.listMessages(
              (com.google.chat.v1.ListMessagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.ListMessagesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MEMBERSHIPS:
          serviceImpl.listMemberships(
              (com.google.chat.v1.ListMembershipsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.ListMembershipsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MEMBERSHIP:
          serviceImpl.getMembership(
              (com.google.chat.v1.GetMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Membership>) responseObserver);
          break;
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage(
              (com.google.chat.v1.GetMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Message>) responseObserver);
          break;
        case METHODID_UPDATE_MESSAGE:
          serviceImpl.updateMessage(
              (com.google.chat.v1.UpdateMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Message>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGE:
          serviceImpl.deleteMessage(
              (com.google.chat.v1.DeleteMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ATTACHMENT:
          serviceImpl.getAttachment(
              (com.google.chat.v1.GetAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Attachment>) responseObserver);
          break;
        case METHODID_UPLOAD_ATTACHMENT:
          serviceImpl.uploadAttachment(
              (com.google.chat.v1.UploadAttachmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.UploadAttachmentResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SPACES:
          serviceImpl.listSpaces(
              (com.google.chat.v1.ListSpacesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.ListSpacesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SPACE:
          serviceImpl.getSpace(
              (com.google.chat.v1.GetSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Space>) responseObserver);
          break;
        case METHODID_CREATE_SPACE:
          serviceImpl.createSpace(
              (com.google.chat.v1.CreateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Space>) responseObserver);
          break;
        case METHODID_SET_UP_SPACE:
          serviceImpl.setUpSpace(
              (com.google.chat.v1.SetUpSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Space>) responseObserver);
          break;
        case METHODID_UPDATE_SPACE:
          serviceImpl.updateSpace(
              (com.google.chat.v1.UpdateSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Space>) responseObserver);
          break;
        case METHODID_DELETE_SPACE:
          serviceImpl.deleteSpace(
              (com.google.chat.v1.DeleteSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_COMPLETE_IMPORT_SPACE:
          serviceImpl.completeImportSpace(
              (com.google.chat.v1.CompleteImportSpaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.CompleteImportSpaceResponse>)
                  responseObserver);
          break;
        case METHODID_FIND_DIRECT_MESSAGE:
          serviceImpl.findDirectMessage(
              (com.google.chat.v1.FindDirectMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Space>) responseObserver);
          break;
        case METHODID_CREATE_MEMBERSHIP:
          serviceImpl.createMembership(
              (com.google.chat.v1.CreateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Membership>) responseObserver);
          break;
        case METHODID_UPDATE_MEMBERSHIP:
          serviceImpl.updateMembership(
              (com.google.chat.v1.UpdateMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Membership>) responseObserver);
          break;
        case METHODID_DELETE_MEMBERSHIP:
          serviceImpl.deleteMembership(
              (com.google.chat.v1.DeleteMembershipRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Membership>) responseObserver);
          break;
        case METHODID_CREATE_REACTION:
          serviceImpl.createReaction(
              (com.google.chat.v1.CreateReactionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.Reaction>) responseObserver);
          break;
        case METHODID_LIST_REACTIONS:
          serviceImpl.listReactions(
              (com.google.chat.v1.ListReactionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.ListReactionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_REACTION:
          serviceImpl.deleteReaction(
              (com.google.chat.v1.DeleteReactionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_SPACE_READ_STATE:
          serviceImpl.getSpaceReadState(
              (com.google.chat.v1.GetSpaceReadStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState>) responseObserver);
          break;
        case METHODID_UPDATE_SPACE_READ_STATE:
          serviceImpl.updateSpaceReadState(
              (com.google.chat.v1.UpdateSpaceReadStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.SpaceReadState>) responseObserver);
          break;
        case METHODID_GET_THREAD_READ_STATE:
          serviceImpl.getThreadReadState(
              (com.google.chat.v1.GetThreadReadStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.chat.v1.ThreadReadState>) responseObserver);
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
            getCreateMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.CreateMessageRequest, com.google.chat.v1.Message>(
                    service, METHODID_CREATE_MESSAGE)))
        .addMethod(
            getListMessagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.ListMessagesRequest,
                    com.google.chat.v1.ListMessagesResponse>(service, METHODID_LIST_MESSAGES)))
        .addMethod(
            getListMembershipsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.ListMembershipsRequest,
                    com.google.chat.v1.ListMembershipsResponse>(
                    service, METHODID_LIST_MEMBERSHIPS)))
        .addMethod(
            getGetMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.GetMembershipRequest, com.google.chat.v1.Membership>(
                    service, METHODID_GET_MEMBERSHIP)))
        .addMethod(
            getGetMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.GetMessageRequest, com.google.chat.v1.Message>(
                    service, METHODID_GET_MESSAGE)))
        .addMethod(
            getUpdateMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.UpdateMessageRequest, com.google.chat.v1.Message>(
                    service, METHODID_UPDATE_MESSAGE)))
        .addMethod(
            getDeleteMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.DeleteMessageRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_MESSAGE)))
        .addMethod(
            getGetAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.GetAttachmentRequest, com.google.chat.v1.Attachment>(
                    service, METHODID_GET_ATTACHMENT)))
        .addMethod(
            getUploadAttachmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.UploadAttachmentRequest,
                    com.google.chat.v1.UploadAttachmentResponse>(
                    service, METHODID_UPLOAD_ATTACHMENT)))
        .addMethod(
            getListSpacesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.ListSpacesRequest, com.google.chat.v1.ListSpacesResponse>(
                    service, METHODID_LIST_SPACES)))
        .addMethod(
            getGetSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.chat.v1.GetSpaceRequest, com.google.chat.v1.Space>(
                    service, METHODID_GET_SPACE)))
        .addMethod(
            getCreateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.chat.v1.CreateSpaceRequest, com.google.chat.v1.Space>(
                    service, METHODID_CREATE_SPACE)))
        .addMethod(
            getSetUpSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.chat.v1.SetUpSpaceRequest, com.google.chat.v1.Space>(
                    service, METHODID_SET_UP_SPACE)))
        .addMethod(
            getUpdateSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.chat.v1.UpdateSpaceRequest, com.google.chat.v1.Space>(
                    service, METHODID_UPDATE_SPACE)))
        .addMethod(
            getDeleteSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.DeleteSpaceRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_SPACE)))
        .addMethod(
            getCompleteImportSpaceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.CompleteImportSpaceRequest,
                    com.google.chat.v1.CompleteImportSpaceResponse>(
                    service, METHODID_COMPLETE_IMPORT_SPACE)))
        .addMethod(
            getFindDirectMessageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.FindDirectMessageRequest, com.google.chat.v1.Space>(
                    service, METHODID_FIND_DIRECT_MESSAGE)))
        .addMethod(
            getCreateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.CreateMembershipRequest, com.google.chat.v1.Membership>(
                    service, METHODID_CREATE_MEMBERSHIP)))
        .addMethod(
            getUpdateMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.UpdateMembershipRequest, com.google.chat.v1.Membership>(
                    service, METHODID_UPDATE_MEMBERSHIP)))
        .addMethod(
            getDeleteMembershipMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.DeleteMembershipRequest, com.google.chat.v1.Membership>(
                    service, METHODID_DELETE_MEMBERSHIP)))
        .addMethod(
            getCreateReactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.CreateReactionRequest, com.google.chat.v1.Reaction>(
                    service, METHODID_CREATE_REACTION)))
        .addMethod(
            getListReactionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.ListReactionsRequest,
                    com.google.chat.v1.ListReactionsResponse>(service, METHODID_LIST_REACTIONS)))
        .addMethod(
            getDeleteReactionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.DeleteReactionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_REACTION)))
        .addMethod(
            getGetSpaceReadStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.GetSpaceReadStateRequest, com.google.chat.v1.SpaceReadState>(
                    service, METHODID_GET_SPACE_READ_STATE)))
        .addMethod(
            getUpdateSpaceReadStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.UpdateSpaceReadStateRequest,
                    com.google.chat.v1.SpaceReadState>(service, METHODID_UPDATE_SPACE_READ_STATE)))
        .addMethod(
            getGetThreadReadStateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.chat.v1.GetThreadReadStateRequest,
                    com.google.chat.v1.ThreadReadState>(service, METHODID_GET_THREAD_READ_STATE)))
        .build();
  }

  private abstract static class ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ChatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.chat.v1.ChatServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ChatService");
    }
  }

  private static final class ChatServiceFileDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier {
    ChatServiceFileDescriptorSupplier() {}
  }

  private static final class ChatServiceMethodDescriptorSupplier
      extends ChatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ChatServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ChatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ChatServiceFileDescriptorSupplier())
                      .addMethod(getCreateMessageMethod())
                      .addMethod(getListMessagesMethod())
                      .addMethod(getListMembershipsMethod())
                      .addMethod(getGetMembershipMethod())
                      .addMethod(getGetMessageMethod())
                      .addMethod(getUpdateMessageMethod())
                      .addMethod(getDeleteMessageMethod())
                      .addMethod(getGetAttachmentMethod())
                      .addMethod(getUploadAttachmentMethod())
                      .addMethod(getListSpacesMethod())
                      .addMethod(getGetSpaceMethod())
                      .addMethod(getCreateSpaceMethod())
                      .addMethod(getSetUpSpaceMethod())
                      .addMethod(getUpdateSpaceMethod())
                      .addMethod(getDeleteSpaceMethod())
                      .addMethod(getCompleteImportSpaceMethod())
                      .addMethod(getFindDirectMessageMethod())
                      .addMethod(getCreateMembershipMethod())
                      .addMethod(getUpdateMembershipMethod())
                      .addMethod(getDeleteMembershipMethod())
                      .addMethod(getCreateReactionMethod())
                      .addMethod(getListReactionsMethod())
                      .addMethod(getDeleteReactionMethod())
                      .addMethod(getGetSpaceReadStateMethod())
                      .addMethod(getUpdateSpaceReadStateMethod())
                      .addMethod(getGetThreadReadStateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
