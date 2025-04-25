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
package com.google.cloud.eventarc.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Eventarc allows users to subscribe to various events that are provided by
 * Google Cloud services and forward them to supported destinations.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/eventarc/v1/eventarc.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EventarcGrpc {

  private EventarcGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.eventarc.v1.Eventarc";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
      getGetTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrigger",
      requestType = com.google.cloud.eventarc.v1.GetTriggerRequest.class,
      responseType = com.google.cloud.eventarc.v1.Trigger.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
      getGetTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetTriggerRequest, com.google.cloud.eventarc.v1.Trigger>
        getGetTriggerMethod;
    if ((getGetTriggerMethod = EventarcGrpc.getGetTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetTriggerMethod = EventarcGrpc.getGetTriggerMethod) == null) {
          EventarcGrpc.getGetTriggerMethod =
              getGetTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetTriggerRequest,
                          com.google.cloud.eventarc.v1.Trigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetTriggerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Trigger.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetTrigger"))
                      .build();
        }
      }
    }
    return getGetTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListTriggersRequest,
          com.google.cloud.eventarc.v1.ListTriggersResponse>
      getListTriggersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTriggers",
      requestType = com.google.cloud.eventarc.v1.ListTriggersRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListTriggersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListTriggersRequest,
          com.google.cloud.eventarc.v1.ListTriggersResponse>
      getListTriggersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListTriggersRequest,
            com.google.cloud.eventarc.v1.ListTriggersResponse>
        getListTriggersMethod;
    if ((getListTriggersMethod = EventarcGrpc.getListTriggersMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListTriggersMethod = EventarcGrpc.getListTriggersMethod) == null) {
          EventarcGrpc.getListTriggersMethod =
              getListTriggersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListTriggersRequest,
                          com.google.cloud.eventarc.v1.ListTriggersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTriggers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListTriggersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListTriggersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListTriggers"))
                      .build();
        }
      }
    }
    return getListTriggersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
      getCreateTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrigger",
      requestType = com.google.cloud.eventarc.v1.CreateTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
      getCreateTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateTriggerRequest, com.google.longrunning.Operation>
        getCreateTriggerMethod;
    if ((getCreateTriggerMethod = EventarcGrpc.getCreateTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateTriggerMethod = EventarcGrpc.getCreateTriggerMethod) == null) {
          EventarcGrpc.getCreateTriggerMethod =
              getCreateTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreateTrigger"))
                      .build();
        }
      }
    }
    return getCreateTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
      getUpdateTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTrigger",
      requestType = com.google.cloud.eventarc.v1.UpdateTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
      getUpdateTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateTriggerRequest, com.google.longrunning.Operation>
        getUpdateTriggerMethod;
    if ((getUpdateTriggerMethod = EventarcGrpc.getUpdateTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateTriggerMethod = EventarcGrpc.getUpdateTriggerMethod) == null) {
          EventarcGrpc.getUpdateTriggerMethod =
              getUpdateTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdateTrigger"))
                      .build();
        }
      }
    }
    return getUpdateTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
      getDeleteTriggerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrigger",
      requestType = com.google.cloud.eventarc.v1.DeleteTriggerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
      getDeleteTriggerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteTriggerRequest, com.google.longrunning.Operation>
        getDeleteTriggerMethod;
    if ((getDeleteTriggerMethod = EventarcGrpc.getDeleteTriggerMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteTriggerMethod = EventarcGrpc.getDeleteTriggerMethod) == null) {
          EventarcGrpc.getDeleteTriggerMethod =
              getDeleteTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeleteTrigger"))
                      .build();
        }
      }
    }
    return getDeleteTriggerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetChannelRequest, com.google.cloud.eventarc.v1.Channel>
      getGetChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannel",
      requestType = com.google.cloud.eventarc.v1.GetChannelRequest.class,
      responseType = com.google.cloud.eventarc.v1.Channel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetChannelRequest, com.google.cloud.eventarc.v1.Channel>
      getGetChannelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetChannelRequest, com.google.cloud.eventarc.v1.Channel>
        getGetChannelMethod;
    if ((getGetChannelMethod = EventarcGrpc.getGetChannelMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetChannelMethod = EventarcGrpc.getGetChannelMethod) == null) {
          EventarcGrpc.getGetChannelMethod =
              getGetChannelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetChannelRequest,
                          com.google.cloud.eventarc.v1.Channel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetChannel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetChannelRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Channel.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetChannel"))
                      .build();
        }
      }
    }
    return getGetChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListChannelsRequest,
          com.google.cloud.eventarc.v1.ListChannelsResponse>
      getListChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannels",
      requestType = com.google.cloud.eventarc.v1.ListChannelsRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListChannelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListChannelsRequest,
          com.google.cloud.eventarc.v1.ListChannelsResponse>
      getListChannelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListChannelsRequest,
            com.google.cloud.eventarc.v1.ListChannelsResponse>
        getListChannelsMethod;
    if ((getListChannelsMethod = EventarcGrpc.getListChannelsMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListChannelsMethod = EventarcGrpc.getListChannelsMethod) == null) {
          EventarcGrpc.getListChannelsMethod =
              getListChannelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListChannelsRequest,
                          com.google.cloud.eventarc.v1.ListChannelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChannels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListChannelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListChannelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListChannels"))
                      .build();
        }
      }
    }
    return getListChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateChannelRequest, com.google.longrunning.Operation>
      getCreateChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChannel",
      requestType = com.google.cloud.eventarc.v1.CreateChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateChannelRequest, com.google.longrunning.Operation>
      getCreateChannelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateChannelRequest, com.google.longrunning.Operation>
        getCreateChannelMethod;
    if ((getCreateChannelMethod = EventarcGrpc.getCreateChannelMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateChannelMethod = EventarcGrpc.getCreateChannelMethod) == null) {
          EventarcGrpc.getCreateChannelMethod =
              getCreateChannelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateChannelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateChannel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateChannelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreateChannel"))
                      .build();
        }
      }
    }
    return getCreateChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateChannelRequest, com.google.longrunning.Operation>
      getUpdateChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateChannel",
      requestType = com.google.cloud.eventarc.v1.UpdateChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateChannelRequest, com.google.longrunning.Operation>
      getUpdateChannelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateChannelRequest, com.google.longrunning.Operation>
        getUpdateChannelMethod;
    if ((getUpdateChannelMethod = EventarcGrpc.getUpdateChannelMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateChannelMethod = EventarcGrpc.getUpdateChannelMethod) == null) {
          EventarcGrpc.getUpdateChannelMethod =
              getUpdateChannelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateChannelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateChannel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateChannelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdateChannel"))
                      .build();
        }
      }
    }
    return getUpdateChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteChannelRequest, com.google.longrunning.Operation>
      getDeleteChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChannel",
      requestType = com.google.cloud.eventarc.v1.DeleteChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteChannelRequest, com.google.longrunning.Operation>
      getDeleteChannelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteChannelRequest, com.google.longrunning.Operation>
        getDeleteChannelMethod;
    if ((getDeleteChannelMethod = EventarcGrpc.getDeleteChannelMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteChannelMethod = EventarcGrpc.getDeleteChannelMethod) == null) {
          EventarcGrpc.getDeleteChannelMethod =
              getDeleteChannelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteChannelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteChannel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteChannelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeleteChannel"))
                      .build();
        }
      }
    }
    return getDeleteChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetProviderRequest, com.google.cloud.eventarc.v1.Provider>
      getGetProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProvider",
      requestType = com.google.cloud.eventarc.v1.GetProviderRequest.class,
      responseType = com.google.cloud.eventarc.v1.Provider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetProviderRequest, com.google.cloud.eventarc.v1.Provider>
      getGetProviderMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetProviderRequest, com.google.cloud.eventarc.v1.Provider>
        getGetProviderMethod;
    if ((getGetProviderMethod = EventarcGrpc.getGetProviderMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetProviderMethod = EventarcGrpc.getGetProviderMethod) == null) {
          EventarcGrpc.getGetProviderMethod =
              getGetProviderMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetProviderRequest,
                          com.google.cloud.eventarc.v1.Provider>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProvider"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetProviderRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Provider.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetProvider"))
                      .build();
        }
      }
    }
    return getGetProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListProvidersRequest,
          com.google.cloud.eventarc.v1.ListProvidersResponse>
      getListProvidersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProviders",
      requestType = com.google.cloud.eventarc.v1.ListProvidersRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListProvidersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListProvidersRequest,
          com.google.cloud.eventarc.v1.ListProvidersResponse>
      getListProvidersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListProvidersRequest,
            com.google.cloud.eventarc.v1.ListProvidersResponse>
        getListProvidersMethod;
    if ((getListProvidersMethod = EventarcGrpc.getListProvidersMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListProvidersMethod = EventarcGrpc.getListProvidersMethod) == null) {
          EventarcGrpc.getListProvidersMethod =
              getListProvidersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListProvidersRequest,
                          com.google.cloud.eventarc.v1.ListProvidersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProviders"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListProvidersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListProvidersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListProviders"))
                      .build();
        }
      }
    }
    return getListProvidersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
          com.google.cloud.eventarc.v1.ChannelConnection>
      getGetChannelConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetChannelConnection",
      requestType = com.google.cloud.eventarc.v1.GetChannelConnectionRequest.class,
      responseType = com.google.cloud.eventarc.v1.ChannelConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
          com.google.cloud.eventarc.v1.ChannelConnection>
      getGetChannelConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
            com.google.cloud.eventarc.v1.ChannelConnection>
        getGetChannelConnectionMethod;
    if ((getGetChannelConnectionMethod = EventarcGrpc.getGetChannelConnectionMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetChannelConnectionMethod = EventarcGrpc.getGetChannelConnectionMethod) == null) {
          EventarcGrpc.getGetChannelConnectionMethod =
              getGetChannelConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
                          com.google.cloud.eventarc.v1.ChannelConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetChannelConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetChannelConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ChannelConnection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("GetChannelConnection"))
                      .build();
        }
      }
    }
    return getGetChannelConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
          com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
      getListChannelConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannelConnections",
      requestType = com.google.cloud.eventarc.v1.ListChannelConnectionsRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListChannelConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
          com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
      getListChannelConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
            com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
        getListChannelConnectionsMethod;
    if ((getListChannelConnectionsMethod = EventarcGrpc.getListChannelConnectionsMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListChannelConnectionsMethod = EventarcGrpc.getListChannelConnectionsMethod)
            == null) {
          EventarcGrpc.getListChannelConnectionsMethod =
              getListChannelConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
                          com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListChannelConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListChannelConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListChannelConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("ListChannelConnections"))
                      .build();
        }
      }
    }
    return getListChannelConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
          com.google.longrunning.Operation>
      getCreateChannelConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateChannelConnection",
      requestType = com.google.cloud.eventarc.v1.CreateChannelConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
          com.google.longrunning.Operation>
      getCreateChannelConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
            com.google.longrunning.Operation>
        getCreateChannelConnectionMethod;
    if ((getCreateChannelConnectionMethod = EventarcGrpc.getCreateChannelConnectionMethod)
        == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateChannelConnectionMethod = EventarcGrpc.getCreateChannelConnectionMethod)
            == null) {
          EventarcGrpc.getCreateChannelConnectionMethod =
              getCreateChannelConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateChannelConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateChannelConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("CreateChannelConnection"))
                      .build();
        }
      }
    }
    return getCreateChannelConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
          com.google.longrunning.Operation>
      getDeleteChannelConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChannelConnection",
      requestType = com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
          com.google.longrunning.Operation>
      getDeleteChannelConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
            com.google.longrunning.Operation>
        getDeleteChannelConnectionMethod;
    if ((getDeleteChannelConnectionMethod = EventarcGrpc.getDeleteChannelConnectionMethod)
        == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteChannelConnectionMethod = EventarcGrpc.getDeleteChannelConnectionMethod)
            == null) {
          EventarcGrpc.getDeleteChannelConnectionMethod =
              getDeleteChannelConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteChannelConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("DeleteChannelConnection"))
                      .build();
        }
      }
    }
    return getDeleteChannelConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
          com.google.cloud.eventarc.v1.GoogleChannelConfig>
      getGetGoogleChannelConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGoogleChannelConfig",
      requestType = com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest.class,
      responseType = com.google.cloud.eventarc.v1.GoogleChannelConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
          com.google.cloud.eventarc.v1.GoogleChannelConfig>
      getGetGoogleChannelConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
            com.google.cloud.eventarc.v1.GoogleChannelConfig>
        getGetGoogleChannelConfigMethod;
    if ((getGetGoogleChannelConfigMethod = EventarcGrpc.getGetGoogleChannelConfigMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetGoogleChannelConfigMethod = EventarcGrpc.getGetGoogleChannelConfigMethod)
            == null) {
          EventarcGrpc.getGetGoogleChannelConfigMethod =
              getGetGoogleChannelConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
                          com.google.cloud.eventarc.v1.GoogleChannelConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGoogleChannelConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GoogleChannelConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("GetGoogleChannelConfig"))
                      .build();
        }
      }
    }
    return getGetGoogleChannelConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
          com.google.cloud.eventarc.v1.GoogleChannelConfig>
      getUpdateGoogleChannelConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleChannelConfig",
      requestType = com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest.class,
      responseType = com.google.cloud.eventarc.v1.GoogleChannelConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
          com.google.cloud.eventarc.v1.GoogleChannelConfig>
      getUpdateGoogleChannelConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
            com.google.cloud.eventarc.v1.GoogleChannelConfig>
        getUpdateGoogleChannelConfigMethod;
    if ((getUpdateGoogleChannelConfigMethod = EventarcGrpc.getUpdateGoogleChannelConfigMethod)
        == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateGoogleChannelConfigMethod = EventarcGrpc.getUpdateGoogleChannelConfigMethod)
            == null) {
          EventarcGrpc.getUpdateGoogleChannelConfigMethod =
              getUpdateGoogleChannelConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
                          com.google.cloud.eventarc.v1.GoogleChannelConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleChannelConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GoogleChannelConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("UpdateGoogleChannelConfig"))
                      .build();
        }
      }
    }
    return getUpdateGoogleChannelConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetMessageBusRequest,
          com.google.cloud.eventarc.v1.MessageBus>
      getGetMessageBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMessageBus",
      requestType = com.google.cloud.eventarc.v1.GetMessageBusRequest.class,
      responseType = com.google.cloud.eventarc.v1.MessageBus.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetMessageBusRequest,
          com.google.cloud.eventarc.v1.MessageBus>
      getGetMessageBusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetMessageBusRequest,
            com.google.cloud.eventarc.v1.MessageBus>
        getGetMessageBusMethod;
    if ((getGetMessageBusMethod = EventarcGrpc.getGetMessageBusMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetMessageBusMethod = EventarcGrpc.getGetMessageBusMethod) == null) {
          EventarcGrpc.getGetMessageBusMethod =
              getGetMessageBusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetMessageBusRequest,
                          com.google.cloud.eventarc.v1.MessageBus>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMessageBus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetMessageBusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.MessageBus.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetMessageBus"))
                      .build();
        }
      }
    }
    return getGetMessageBusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListMessageBusesRequest,
          com.google.cloud.eventarc.v1.ListMessageBusesResponse>
      getListMessageBusesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessageBuses",
      requestType = com.google.cloud.eventarc.v1.ListMessageBusesRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListMessageBusesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListMessageBusesRequest,
          com.google.cloud.eventarc.v1.ListMessageBusesResponse>
      getListMessageBusesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListMessageBusesRequest,
            com.google.cloud.eventarc.v1.ListMessageBusesResponse>
        getListMessageBusesMethod;
    if ((getListMessageBusesMethod = EventarcGrpc.getListMessageBusesMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListMessageBusesMethod = EventarcGrpc.getListMessageBusesMethod) == null) {
          EventarcGrpc.getListMessageBusesMethod =
              getListMessageBusesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListMessageBusesRequest,
                          com.google.cloud.eventarc.v1.ListMessageBusesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMessageBuses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListMessageBusesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListMessageBusesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListMessageBuses"))
                      .build();
        }
      }
    }
    return getListMessageBusesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest,
          com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
      getListMessageBusEnrollmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMessageBusEnrollments",
      requestType = com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest,
          com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
      getListMessageBusEnrollmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest,
            com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
        getListMessageBusEnrollmentsMethod;
    if ((getListMessageBusEnrollmentsMethod = EventarcGrpc.getListMessageBusEnrollmentsMethod)
        == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListMessageBusEnrollmentsMethod = EventarcGrpc.getListMessageBusEnrollmentsMethod)
            == null) {
          EventarcGrpc.getListMessageBusEnrollmentsMethod =
              getListMessageBusEnrollmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest,
                          com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListMessageBusEnrollments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("ListMessageBusEnrollments"))
                      .build();
        }
      }
    }
    return getListMessageBusEnrollmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateMessageBusRequest, com.google.longrunning.Operation>
      getCreateMessageBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateMessageBus",
      requestType = com.google.cloud.eventarc.v1.CreateMessageBusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateMessageBusRequest, com.google.longrunning.Operation>
      getCreateMessageBusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateMessageBusRequest, com.google.longrunning.Operation>
        getCreateMessageBusMethod;
    if ((getCreateMessageBusMethod = EventarcGrpc.getCreateMessageBusMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateMessageBusMethod = EventarcGrpc.getCreateMessageBusMethod) == null) {
          EventarcGrpc.getCreateMessageBusMethod =
              getCreateMessageBusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateMessageBusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateMessageBus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateMessageBusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreateMessageBus"))
                      .build();
        }
      }
    }
    return getCreateMessageBusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateMessageBusRequest, com.google.longrunning.Operation>
      getUpdateMessageBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateMessageBus",
      requestType = com.google.cloud.eventarc.v1.UpdateMessageBusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateMessageBusRequest, com.google.longrunning.Operation>
      getUpdateMessageBusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateMessageBusRequest, com.google.longrunning.Operation>
        getUpdateMessageBusMethod;
    if ((getUpdateMessageBusMethod = EventarcGrpc.getUpdateMessageBusMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateMessageBusMethod = EventarcGrpc.getUpdateMessageBusMethod) == null) {
          EventarcGrpc.getUpdateMessageBusMethod =
              getUpdateMessageBusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateMessageBusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateMessageBus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateMessageBusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdateMessageBus"))
                      .build();
        }
      }
    }
    return getUpdateMessageBusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteMessageBusRequest, com.google.longrunning.Operation>
      getDeleteMessageBusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMessageBus",
      requestType = com.google.cloud.eventarc.v1.DeleteMessageBusRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteMessageBusRequest, com.google.longrunning.Operation>
      getDeleteMessageBusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteMessageBusRequest, com.google.longrunning.Operation>
        getDeleteMessageBusMethod;
    if ((getDeleteMessageBusMethod = EventarcGrpc.getDeleteMessageBusMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteMessageBusMethod = EventarcGrpc.getDeleteMessageBusMethod) == null) {
          EventarcGrpc.getDeleteMessageBusMethod =
              getDeleteMessageBusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteMessageBusRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMessageBus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteMessageBusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeleteMessageBus"))
                      .build();
        }
      }
    }
    return getDeleteMessageBusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetEnrollmentRequest,
          com.google.cloud.eventarc.v1.Enrollment>
      getGetEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnrollment",
      requestType = com.google.cloud.eventarc.v1.GetEnrollmentRequest.class,
      responseType = com.google.cloud.eventarc.v1.Enrollment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetEnrollmentRequest,
          com.google.cloud.eventarc.v1.Enrollment>
      getGetEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetEnrollmentRequest,
            com.google.cloud.eventarc.v1.Enrollment>
        getGetEnrollmentMethod;
    if ((getGetEnrollmentMethod = EventarcGrpc.getGetEnrollmentMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetEnrollmentMethod = EventarcGrpc.getGetEnrollmentMethod) == null) {
          EventarcGrpc.getGetEnrollmentMethod =
              getGetEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetEnrollmentRequest,
                          com.google.cloud.eventarc.v1.Enrollment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetEnrollmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Enrollment.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetEnrollment"))
                      .build();
        }
      }
    }
    return getGetEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListEnrollmentsRequest,
          com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
      getListEnrollmentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEnrollments",
      requestType = com.google.cloud.eventarc.v1.ListEnrollmentsRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListEnrollmentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListEnrollmentsRequest,
          com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
      getListEnrollmentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListEnrollmentsRequest,
            com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
        getListEnrollmentsMethod;
    if ((getListEnrollmentsMethod = EventarcGrpc.getListEnrollmentsMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListEnrollmentsMethod = EventarcGrpc.getListEnrollmentsMethod) == null) {
          EventarcGrpc.getListEnrollmentsMethod =
              getListEnrollmentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListEnrollmentsRequest,
                          com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEnrollments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListEnrollmentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListEnrollmentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListEnrollments"))
                      .build();
        }
      }
    }
    return getListEnrollmentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateEnrollmentRequest, com.google.longrunning.Operation>
      getCreateEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEnrollment",
      requestType = com.google.cloud.eventarc.v1.CreateEnrollmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateEnrollmentRequest, com.google.longrunning.Operation>
      getCreateEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateEnrollmentRequest, com.google.longrunning.Operation>
        getCreateEnrollmentMethod;
    if ((getCreateEnrollmentMethod = EventarcGrpc.getCreateEnrollmentMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateEnrollmentMethod = EventarcGrpc.getCreateEnrollmentMethod) == null) {
          EventarcGrpc.getCreateEnrollmentMethod =
              getCreateEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateEnrollmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateEnrollmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreateEnrollment"))
                      .build();
        }
      }
    }
    return getCreateEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateEnrollmentRequest, com.google.longrunning.Operation>
      getUpdateEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEnrollment",
      requestType = com.google.cloud.eventarc.v1.UpdateEnrollmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateEnrollmentRequest, com.google.longrunning.Operation>
      getUpdateEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateEnrollmentRequest, com.google.longrunning.Operation>
        getUpdateEnrollmentMethod;
    if ((getUpdateEnrollmentMethod = EventarcGrpc.getUpdateEnrollmentMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateEnrollmentMethod = EventarcGrpc.getUpdateEnrollmentMethod) == null) {
          EventarcGrpc.getUpdateEnrollmentMethod =
              getUpdateEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateEnrollmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateEnrollmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdateEnrollment"))
                      .build();
        }
      }
    }
    return getUpdateEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteEnrollmentRequest, com.google.longrunning.Operation>
      getDeleteEnrollmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEnrollment",
      requestType = com.google.cloud.eventarc.v1.DeleteEnrollmentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteEnrollmentRequest, com.google.longrunning.Operation>
      getDeleteEnrollmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteEnrollmentRequest, com.google.longrunning.Operation>
        getDeleteEnrollmentMethod;
    if ((getDeleteEnrollmentMethod = EventarcGrpc.getDeleteEnrollmentMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteEnrollmentMethod = EventarcGrpc.getDeleteEnrollmentMethod) == null) {
          EventarcGrpc.getDeleteEnrollmentMethod =
              getDeleteEnrollmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteEnrollmentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEnrollment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteEnrollmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeleteEnrollment"))
                      .build();
        }
      }
    }
    return getDeleteEnrollmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetPipelineRequest, com.google.cloud.eventarc.v1.Pipeline>
      getGetPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPipeline",
      requestType = com.google.cloud.eventarc.v1.GetPipelineRequest.class,
      responseType = com.google.cloud.eventarc.v1.Pipeline.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetPipelineRequest, com.google.cloud.eventarc.v1.Pipeline>
      getGetPipelineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetPipelineRequest, com.google.cloud.eventarc.v1.Pipeline>
        getGetPipelineMethod;
    if ((getGetPipelineMethod = EventarcGrpc.getGetPipelineMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetPipelineMethod = EventarcGrpc.getGetPipelineMethod) == null) {
          EventarcGrpc.getGetPipelineMethod =
              getGetPipelineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetPipelineRequest,
                          com.google.cloud.eventarc.v1.Pipeline>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPipeline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetPipelineRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.Pipeline.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("GetPipeline"))
                      .build();
        }
      }
    }
    return getGetPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListPipelinesRequest,
          com.google.cloud.eventarc.v1.ListPipelinesResponse>
      getListPipelinesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPipelines",
      requestType = com.google.cloud.eventarc.v1.ListPipelinesRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListPipelinesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListPipelinesRequest,
          com.google.cloud.eventarc.v1.ListPipelinesResponse>
      getListPipelinesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListPipelinesRequest,
            com.google.cloud.eventarc.v1.ListPipelinesResponse>
        getListPipelinesMethod;
    if ((getListPipelinesMethod = EventarcGrpc.getListPipelinesMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListPipelinesMethod = EventarcGrpc.getListPipelinesMethod) == null) {
          EventarcGrpc.getListPipelinesMethod =
              getListPipelinesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListPipelinesRequest,
                          com.google.cloud.eventarc.v1.ListPipelinesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPipelines"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListPipelinesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListPipelinesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("ListPipelines"))
                      .build();
        }
      }
    }
    return getListPipelinesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreatePipelineRequest, com.google.longrunning.Operation>
      getCreatePipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePipeline",
      requestType = com.google.cloud.eventarc.v1.CreatePipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreatePipelineRequest, com.google.longrunning.Operation>
      getCreatePipelineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreatePipelineRequest, com.google.longrunning.Operation>
        getCreatePipelineMethod;
    if ((getCreatePipelineMethod = EventarcGrpc.getCreatePipelineMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreatePipelineMethod = EventarcGrpc.getCreatePipelineMethod) == null) {
          EventarcGrpc.getCreatePipelineMethod =
              getCreatePipelineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreatePipelineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePipeline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreatePipelineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("CreatePipeline"))
                      .build();
        }
      }
    }
    return getCreatePipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdatePipelineRequest, com.google.longrunning.Operation>
      getUpdatePipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePipeline",
      requestType = com.google.cloud.eventarc.v1.UpdatePipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdatePipelineRequest, com.google.longrunning.Operation>
      getUpdatePipelineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdatePipelineRequest, com.google.longrunning.Operation>
        getUpdatePipelineMethod;
    if ((getUpdatePipelineMethod = EventarcGrpc.getUpdatePipelineMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdatePipelineMethod = EventarcGrpc.getUpdatePipelineMethod) == null) {
          EventarcGrpc.getUpdatePipelineMethod =
              getUpdatePipelineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdatePipelineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePipeline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdatePipelineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("UpdatePipeline"))
                      .build();
        }
      }
    }
    return getUpdatePipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeletePipelineRequest, com.google.longrunning.Operation>
      getDeletePipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePipeline",
      requestType = com.google.cloud.eventarc.v1.DeletePipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeletePipelineRequest, com.google.longrunning.Operation>
      getDeletePipelineMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeletePipelineRequest, com.google.longrunning.Operation>
        getDeletePipelineMethod;
    if ((getDeletePipelineMethod = EventarcGrpc.getDeletePipelineMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeletePipelineMethod = EventarcGrpc.getDeletePipelineMethod) == null) {
          EventarcGrpc.getDeletePipelineMethod =
              getDeletePipelineMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeletePipelineRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePipeline"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeletePipelineRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new EventarcMethodDescriptorSupplier("DeletePipeline"))
                      .build();
        }
      }
    }
    return getDeletePipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest,
          com.google.cloud.eventarc.v1.GoogleApiSource>
      getGetGoogleApiSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGoogleApiSource",
      requestType = com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest.class,
      responseType = com.google.cloud.eventarc.v1.GoogleApiSource.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest,
          com.google.cloud.eventarc.v1.GoogleApiSource>
      getGetGoogleApiSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest,
            com.google.cloud.eventarc.v1.GoogleApiSource>
        getGetGoogleApiSourceMethod;
    if ((getGetGoogleApiSourceMethod = EventarcGrpc.getGetGoogleApiSourceMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getGetGoogleApiSourceMethod = EventarcGrpc.getGetGoogleApiSourceMethod) == null) {
          EventarcGrpc.getGetGoogleApiSourceMethod =
              getGetGoogleApiSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest,
                          com.google.cloud.eventarc.v1.GoogleApiSource>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGoogleApiSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.GoogleApiSource.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("GetGoogleApiSource"))
                      .build();
        }
      }
    }
    return getGetGoogleApiSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest,
          com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
      getListGoogleApiSourcesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGoogleApiSources",
      requestType = com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest.class,
      responseType = com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest,
          com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
      getListGoogleApiSourcesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest,
            com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
        getListGoogleApiSourcesMethod;
    if ((getListGoogleApiSourcesMethod = EventarcGrpc.getListGoogleApiSourcesMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getListGoogleApiSourcesMethod = EventarcGrpc.getListGoogleApiSourcesMethod) == null) {
          EventarcGrpc.getListGoogleApiSourcesMethod =
              getListGoogleApiSourcesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest,
                          com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGoogleApiSources"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("ListGoogleApiSources"))
                      .build();
        }
      }
    }
    return getListGoogleApiSourcesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getCreateGoogleApiSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGoogleApiSource",
      requestType = com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getCreateGoogleApiSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest,
            com.google.longrunning.Operation>
        getCreateGoogleApiSourceMethod;
    if ((getCreateGoogleApiSourceMethod = EventarcGrpc.getCreateGoogleApiSourceMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getCreateGoogleApiSourceMethod = EventarcGrpc.getCreateGoogleApiSourceMethod)
            == null) {
          EventarcGrpc.getCreateGoogleApiSourceMethod =
              getCreateGoogleApiSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGoogleApiSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("CreateGoogleApiSource"))
                      .build();
        }
      }
    }
    return getCreateGoogleApiSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getUpdateGoogleApiSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGoogleApiSource",
      requestType = com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getUpdateGoogleApiSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest,
            com.google.longrunning.Operation>
        getUpdateGoogleApiSourceMethod;
    if ((getUpdateGoogleApiSourceMethod = EventarcGrpc.getUpdateGoogleApiSourceMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getUpdateGoogleApiSourceMethod = EventarcGrpc.getUpdateGoogleApiSourceMethod)
            == null) {
          EventarcGrpc.getUpdateGoogleApiSourceMethod =
              getUpdateGoogleApiSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGoogleApiSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("UpdateGoogleApiSource"))
                      .build();
        }
      }
    }
    return getUpdateGoogleApiSourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getDeleteGoogleApiSourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGoogleApiSource",
      requestType = com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest,
          com.google.longrunning.Operation>
      getDeleteGoogleApiSourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest,
            com.google.longrunning.Operation>
        getDeleteGoogleApiSourceMethod;
    if ((getDeleteGoogleApiSourceMethod = EventarcGrpc.getDeleteGoogleApiSourceMethod) == null) {
      synchronized (EventarcGrpc.class) {
        if ((getDeleteGoogleApiSourceMethod = EventarcGrpc.getDeleteGoogleApiSourceMethod)
            == null) {
          EventarcGrpc.getDeleteGoogleApiSourceMethod =
              getDeleteGoogleApiSourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGoogleApiSource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EventarcMethodDescriptorSupplier("DeleteGoogleApiSource"))
                      .build();
        }
      }
    }
    return getDeleteGoogleApiSourceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EventarcStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcStub>() {
          @java.lang.Override
          public EventarcStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcStub(channel, callOptions);
          }
        };
    return EventarcStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventarcBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcBlockingStub>() {
          @java.lang.Override
          public EventarcBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcBlockingStub(channel, callOptions);
          }
        };
    return EventarcBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EventarcFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventarcFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EventarcFutureStub>() {
          @java.lang.Override
          public EventarcFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EventarcFutureStub(channel, callOptions);
          }
        };
    return EventarcFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    default void getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    default void listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTriggersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    default void createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    default void updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    default void deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTriggerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Channel.
     * </pre>
     */
    default void getChannel(
        com.google.cloud.eventarc.v1.GetChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Channel> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetChannelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List channels.
     * </pre>
     */
    default void listChannels(
        com.google.cloud.eventarc.v1.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListChannelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChannelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new channel in a particular project and location.
     * </pre>
     */
    default void createChannel(
        com.google.cloud.eventarc.v1.CreateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateChannelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single channel.
     * </pre>
     */
    default void updateChannel(
        com.google.cloud.eventarc.v1.UpdateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateChannelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single channel.
     * </pre>
     */
    default void deleteChannel(
        com.google.cloud.eventarc.v1.DeleteChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteChannelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Provider.
     * </pre>
     */
    default void getProvider(
        com.google.cloud.eventarc.v1.GetProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Provider> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProviderMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List providers.
     * </pre>
     */
    default void listProviders(
        com.google.cloud.eventarc.v1.ListProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListProvidersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProvidersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single ChannelConnection.
     * </pre>
     */
    default void getChannelConnection(
        com.google.cloud.eventarc.v1.GetChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ChannelConnection>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetChannelConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List channel connections.
     * </pre>
     */
    default void listChannelConnections(
        com.google.cloud.eventarc.v1.ListChannelConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListChannelConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new ChannelConnection in a particular project and location.
     * </pre>
     */
    default void createChannelConnection(
        com.google.cloud.eventarc.v1.CreateChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateChannelConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single ChannelConnection.
     * </pre>
     */
    default void deleteChannelConnection(
        com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteChannelConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a GoogleChannelConfig
     * </pre>
     */
    default void getGoogleChannelConfig(
        com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGoogleChannelConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleChannelConfig
     * </pre>
     */
    default void updateGoogleChannelConfig(
        com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGoogleChannelConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single MessageBus.
     * </pre>
     */
    default void getMessageBus(
        com.google.cloud.eventarc.v1.GetMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.MessageBus> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMessageBusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List message buses.
     * </pre>
     */
    default void listMessageBuses(
        com.google.cloud.eventarc.v1.ListMessageBusesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListMessageBusesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessageBusesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List message bus enrollments.
     * </pre>
     */
    default void listMessageBusEnrollments(
        com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMessageBusEnrollmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new MessageBus in a particular project and location.
     * </pre>
     */
    default void createMessageBus(
        com.google.cloud.eventarc.v1.CreateMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateMessageBusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single message bus.
     * </pre>
     */
    default void updateMessageBus(
        com.google.cloud.eventarc.v1.UpdateMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateMessageBusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single message bus.
     * </pre>
     */
    default void deleteMessageBus(
        com.google.cloud.eventarc.v1.DeleteMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteMessageBusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Enrollment.
     * </pre>
     */
    default void getEnrollment(
        com.google.cloud.eventarc.v1.GetEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Enrollment> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEnrollmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Enrollments.
     * </pre>
     */
    default void listEnrollments(
        com.google.cloud.eventarc.v1.ListEnrollmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEnrollmentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new Enrollment in a particular project and location.
     * </pre>
     */
    default void createEnrollment(
        com.google.cloud.eventarc.v1.CreateEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEnrollmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single Enrollment.
     * </pre>
     */
    default void updateEnrollment(
        com.google.cloud.eventarc.v1.UpdateEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEnrollmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Enrollment.
     * </pre>
     */
    default void deleteEnrollment(
        com.google.cloud.eventarc.v1.DeleteEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEnrollmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Pipeline.
     * </pre>
     */
    default void getPipeline(
        com.google.cloud.eventarc.v1.GetPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Pipeline> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPipelineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List pipelines.
     * </pre>
     */
    default void listPipelines(
        com.google.cloud.eventarc.v1.ListPipelinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListPipelinesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPipelinesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new Pipeline in a particular project and location.
     * </pre>
     */
    default void createPipeline(
        com.google.cloud.eventarc.v1.CreatePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePipelineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single pipeline.
     * </pre>
     */
    default void updatePipeline(
        com.google.cloud.eventarc.v1.UpdatePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePipelineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single pipeline.
     * </pre>
     */
    default void deletePipeline(
        com.google.cloud.eventarc.v1.DeletePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePipelineMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single GoogleApiSource.
     * </pre>
     */
    default void getGoogleApiSource(
        com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleApiSource>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGoogleApiSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List GoogleApiSources.
     * </pre>
     */
    default void listGoogleApiSources(
        com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGoogleApiSourcesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new GoogleApiSource in a particular project and location.
     * </pre>
     */
    default void createGoogleApiSource(
        com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGoogleApiSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleApiSource.
     * </pre>
     */
    default void updateGoogleApiSource(
        com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGoogleApiSourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single GoogleApiSource.
     * </pre>
     */
    default void deleteGoogleApiSource(
        com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGoogleApiSourceMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Eventarc.
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public abstract static class EventarcImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return EventarcGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Eventarc.
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcStub extends io.grpc.stub.AbstractAsyncStub<EventarcStub> {
    private EventarcStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public void getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTriggerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public void listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTriggersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public void createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public void updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public void deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTriggerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Channel.
     * </pre>
     */
    public void getChannel(
        com.google.cloud.eventarc.v1.GetChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Channel> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List channels.
     * </pre>
     */
    public void listChannels(
        com.google.cloud.eventarc.v1.ListChannelsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListChannelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new channel in a particular project and location.
     * </pre>
     */
    public void createChannel(
        com.google.cloud.eventarc.v1.CreateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateChannelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single channel.
     * </pre>
     */
    public void updateChannel(
        com.google.cloud.eventarc.v1.UpdateChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateChannelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single channel.
     * </pre>
     */
    public void deleteChannel(
        com.google.cloud.eventarc.v1.DeleteChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Provider.
     * </pre>
     */
    public void getProvider(
        com.google.cloud.eventarc.v1.GetProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Provider> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProviderMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List providers.
     * </pre>
     */
    public void listProviders(
        com.google.cloud.eventarc.v1.ListProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListProvidersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProvidersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single ChannelConnection.
     * </pre>
     */
    public void getChannelConnection(
        com.google.cloud.eventarc.v1.GetChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ChannelConnection>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetChannelConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List channel connections.
     * </pre>
     */
    public void listChannelConnections(
        com.google.cloud.eventarc.v1.ListChannelConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChannelConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new ChannelConnection in a particular project and location.
     * </pre>
     */
    public void createChannelConnection(
        com.google.cloud.eventarc.v1.CreateChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateChannelConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single ChannelConnection.
     * </pre>
     */
    public void deleteChannelConnection(
        com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteChannelConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a GoogleChannelConfig
     * </pre>
     */
    public void getGoogleChannelConfig(
        com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGoogleChannelConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleChannelConfig
     * </pre>
     */
    public void updateGoogleChannelConfig(
        com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGoogleChannelConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single MessageBus.
     * </pre>
     */
    public void getMessageBus(
        com.google.cloud.eventarc.v1.GetMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.MessageBus> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMessageBusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List message buses.
     * </pre>
     */
    public void listMessageBuses(
        com.google.cloud.eventarc.v1.ListMessageBusesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListMessageBusesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessageBusesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List message bus enrollments.
     * </pre>
     */
    public void listMessageBusEnrollments(
        com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMessageBusEnrollmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new MessageBus in a particular project and location.
     * </pre>
     */
    public void createMessageBus(
        com.google.cloud.eventarc.v1.CreateMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMessageBusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single message bus.
     * </pre>
     */
    public void updateMessageBus(
        com.google.cloud.eventarc.v1.UpdateMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateMessageBusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single message bus.
     * </pre>
     */
    public void deleteMessageBus(
        com.google.cloud.eventarc.v1.DeleteMessageBusRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMessageBusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Enrollment.
     * </pre>
     */
    public void getEnrollment(
        com.google.cloud.eventarc.v1.GetEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Enrollment> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List Enrollments.
     * </pre>
     */
    public void listEnrollments(
        com.google.cloud.eventarc.v1.ListEnrollmentsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEnrollmentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new Enrollment in a particular project and location.
     * </pre>
     */
    public void createEnrollment(
        com.google.cloud.eventarc.v1.CreateEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single Enrollment.
     * </pre>
     */
    public void updateEnrollment(
        com.google.cloud.eventarc.v1.UpdateEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Enrollment.
     * </pre>
     */
    public void deleteEnrollment(
        com.google.cloud.eventarc.v1.DeleteEnrollmentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEnrollmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single Pipeline.
     * </pre>
     */
    public void getPipeline(
        com.google.cloud.eventarc.v1.GetPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Pipeline> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPipelineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List pipelines.
     * </pre>
     */
    public void listPipelines(
        com.google.cloud.eventarc.v1.ListPipelinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListPipelinesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPipelinesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new Pipeline in a particular project and location.
     * </pre>
     */
    public void createPipeline(
        com.google.cloud.eventarc.v1.CreatePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePipelineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single pipeline.
     * </pre>
     */
    public void updatePipeline(
        com.google.cloud.eventarc.v1.UpdatePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePipelineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single pipeline.
     * </pre>
     */
    public void deletePipeline(
        com.google.cloud.eventarc.v1.DeletePipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePipelineMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a single GoogleApiSource.
     * </pre>
     */
    public void getGoogleApiSource(
        com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleApiSource>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGoogleApiSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List GoogleApiSources.
     * </pre>
     */
    public void listGoogleApiSources(
        com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGoogleApiSourcesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a new GoogleApiSource in a particular project and location.
     * </pre>
     */
    public void createGoogleApiSource(
        com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGoogleApiSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleApiSource.
     * </pre>
     */
    public void updateGoogleApiSource(
        com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGoogleApiSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a single GoogleApiSource.
     * </pre>
     */
    public void deleteGoogleApiSource(
        com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGoogleApiSourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Eventarc.
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventarcBlockingStub> {
    private EventarcBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Trigger getTrigger(
        com.google.cloud.eventarc.v1.GetTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListTriggersResponse listTriggers(
        com.google.cloud.eventarc.v1.ListTriggersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTriggersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createTrigger(
        com.google.cloud.eventarc.v1.CreateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public com.google.longrunning.Operation updateTrigger(
        com.google.cloud.eventarc.v1.UpdateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTrigger(
        com.google.cloud.eventarc.v1.DeleteTriggerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTriggerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Channel.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Channel getChannel(
        com.google.cloud.eventarc.v1.GetChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChannelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List channels.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListChannelsResponse listChannels(
        com.google.cloud.eventarc.v1.ListChannelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChannelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new channel in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createChannel(
        com.google.cloud.eventarc.v1.CreateChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateChannelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single channel.
     * </pre>
     */
    public com.google.longrunning.Operation updateChannel(
        com.google.cloud.eventarc.v1.UpdateChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateChannelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single channel.
     * </pre>
     */
    public com.google.longrunning.Operation deleteChannel(
        com.google.cloud.eventarc.v1.DeleteChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteChannelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Provider.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Provider getProvider(
        com.google.cloud.eventarc.v1.GetProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProviderMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List providers.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListProvidersResponse listProviders(
        com.google.cloud.eventarc.v1.ListProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProvidersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single ChannelConnection.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ChannelConnection getChannelConnection(
        com.google.cloud.eventarc.v1.GetChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetChannelConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List channel connections.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListChannelConnectionsResponse listChannelConnections(
        com.google.cloud.eventarc.v1.ListChannelConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChannelConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new ChannelConnection in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createChannelConnection(
        com.google.cloud.eventarc.v1.CreateChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateChannelConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single ChannelConnection.
     * </pre>
     */
    public com.google.longrunning.Operation deleteChannelConnection(
        com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteChannelConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a GoogleChannelConfig
     * </pre>
     */
    public com.google.cloud.eventarc.v1.GoogleChannelConfig getGoogleChannelConfig(
        com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGoogleChannelConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleChannelConfig
     * </pre>
     */
    public com.google.cloud.eventarc.v1.GoogleChannelConfig updateGoogleChannelConfig(
        com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGoogleChannelConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single MessageBus.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.MessageBus getMessageBus(
        com.google.cloud.eventarc.v1.GetMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMessageBusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List message buses.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListMessageBusesResponse listMessageBuses(
        com.google.cloud.eventarc.v1.ListMessageBusesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessageBusesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List message bus enrollments.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse listMessageBusEnrollments(
        com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMessageBusEnrollmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new MessageBus in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createMessageBus(
        com.google.cloud.eventarc.v1.CreateMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMessageBusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single message bus.
     * </pre>
     */
    public com.google.longrunning.Operation updateMessageBus(
        com.google.cloud.eventarc.v1.UpdateMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateMessageBusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single message bus.
     * </pre>
     */
    public com.google.longrunning.Operation deleteMessageBus(
        com.google.cloud.eventarc.v1.DeleteMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMessageBusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Enrollment.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Enrollment getEnrollment(
        com.google.cloud.eventarc.v1.GetEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List Enrollments.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListEnrollmentsResponse listEnrollments(
        com.google.cloud.eventarc.v1.ListEnrollmentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEnrollmentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new Enrollment in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEnrollment(
        com.google.cloud.eventarc.v1.CreateEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single Enrollment.
     * </pre>
     */
    public com.google.longrunning.Operation updateEnrollment(
        com.google.cloud.eventarc.v1.UpdateEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Enrollment.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEnrollment(
        com.google.cloud.eventarc.v1.DeleteEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEnrollmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Pipeline.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.Pipeline getPipeline(
        com.google.cloud.eventarc.v1.GetPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPipelineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List pipelines.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListPipelinesResponse listPipelines(
        com.google.cloud.eventarc.v1.ListPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPipelinesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new Pipeline in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createPipeline(
        com.google.cloud.eventarc.v1.CreatePipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePipelineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single pipeline.
     * </pre>
     */
    public com.google.longrunning.Operation updatePipeline(
        com.google.cloud.eventarc.v1.UpdatePipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePipelineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single pipeline.
     * </pre>
     */
    public com.google.longrunning.Operation deletePipeline(
        com.google.cloud.eventarc.v1.DeletePipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePipelineMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single GoogleApiSource.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.GoogleApiSource getGoogleApiSource(
        com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGoogleApiSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List GoogleApiSources.
     * </pre>
     */
    public com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse listGoogleApiSources(
        com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGoogleApiSourcesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new GoogleApiSource in a particular project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createGoogleApiSource(
        com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGoogleApiSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleApiSource.
     * </pre>
     */
    public com.google.longrunning.Operation updateGoogleApiSource(
        com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGoogleApiSourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single GoogleApiSource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteGoogleApiSource(
        com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGoogleApiSourceMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Eventarc.
   *
   * <pre>
   * Eventarc allows users to subscribe to various events that are provided by
   * Google Cloud services and forward them to supported destinations.
   * </pre>
   */
  public static final class EventarcFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventarcFutureStub> {
    private EventarcFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventarcFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventarcFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.eventarc.v1.Trigger>
        getTrigger(com.google.cloud.eventarc.v1.GetTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List triggers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListTriggersResponse>
        listTriggers(com.google.cloud.eventarc.v1.ListTriggersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTriggersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new trigger in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createTrigger(com.google.cloud.eventarc.v1.CreateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateTrigger(com.google.cloud.eventarc.v1.UpdateTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single trigger.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteTrigger(com.google.cloud.eventarc.v1.DeleteTriggerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTriggerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.eventarc.v1.Channel>
        getChannel(com.google.cloud.eventarc.v1.GetChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChannelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List channels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListChannelsResponse>
        listChannels(com.google.cloud.eventarc.v1.ListChannelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new channel in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createChannel(com.google.cloud.eventarc.v1.CreateChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateChannelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateChannel(com.google.cloud.eventarc.v1.UpdateChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateChannelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteChannel(com.google.cloud.eventarc.v1.DeleteChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Provider.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.eventarc.v1.Provider>
        getProvider(com.google.cloud.eventarc.v1.GetProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProviderMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List providers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListProvidersResponse>
        listProviders(com.google.cloud.eventarc.v1.ListProvidersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProvidersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single ChannelConnection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ChannelConnection>
        getChannelConnection(com.google.cloud.eventarc.v1.GetChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetChannelConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List channel connections.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>
        listChannelConnections(com.google.cloud.eventarc.v1.ListChannelConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChannelConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new ChannelConnection in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createChannelConnection(
            com.google.cloud.eventarc.v1.CreateChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateChannelConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single ChannelConnection.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteChannelConnection(
            com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteChannelConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a GoogleChannelConfig
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.GoogleChannelConfig>
        getGoogleChannelConfig(com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGoogleChannelConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleChannelConfig
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.GoogleChannelConfig>
        updateGoogleChannelConfig(
            com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGoogleChannelConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single MessageBus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.MessageBus>
        getMessageBus(com.google.cloud.eventarc.v1.GetMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMessageBusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List message buses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListMessageBusesResponse>
        listMessageBuses(com.google.cloud.eventarc.v1.ListMessageBusesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessageBusesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List message bus enrollments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>
        listMessageBusEnrollments(
            com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMessageBusEnrollmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new MessageBus in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createMessageBus(com.google.cloud.eventarc.v1.CreateMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMessageBusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single message bus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateMessageBus(com.google.cloud.eventarc.v1.UpdateMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateMessageBusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single message bus.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteMessageBus(com.google.cloud.eventarc.v1.DeleteMessageBusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMessageBusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Enrollment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.Enrollment>
        getEnrollment(com.google.cloud.eventarc.v1.GetEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List Enrollments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListEnrollmentsResponse>
        listEnrollments(com.google.cloud.eventarc.v1.ListEnrollmentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEnrollmentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new Enrollment in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEnrollment(com.google.cloud.eventarc.v1.CreateEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single Enrollment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEnrollment(com.google.cloud.eventarc.v1.UpdateEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single Enrollment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEnrollment(com.google.cloud.eventarc.v1.DeleteEnrollmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEnrollmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single Pipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.eventarc.v1.Pipeline>
        getPipeline(com.google.cloud.eventarc.v1.GetPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPipelineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List pipelines.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListPipelinesResponse>
        listPipelines(com.google.cloud.eventarc.v1.ListPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPipelinesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new Pipeline in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createPipeline(com.google.cloud.eventarc.v1.CreatePipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePipelineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single pipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updatePipeline(com.google.cloud.eventarc.v1.UpdatePipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePipelineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single pipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePipeline(com.google.cloud.eventarc.v1.DeletePipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePipelineMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a single GoogleApiSource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.GoogleApiSource>
        getGoogleApiSource(com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGoogleApiSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List GoogleApiSources.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>
        listGoogleApiSources(com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGoogleApiSourcesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a new GoogleApiSource in a particular project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGoogleApiSource(com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGoogleApiSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a single GoogleApiSource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGoogleApiSource(com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGoogleApiSourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a single GoogleApiSource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGoogleApiSource(com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGoogleApiSourceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_TRIGGER = 0;
  private static final int METHODID_LIST_TRIGGERS = 1;
  private static final int METHODID_CREATE_TRIGGER = 2;
  private static final int METHODID_UPDATE_TRIGGER = 3;
  private static final int METHODID_DELETE_TRIGGER = 4;
  private static final int METHODID_GET_CHANNEL = 5;
  private static final int METHODID_LIST_CHANNELS = 6;
  private static final int METHODID_CREATE_CHANNEL = 7;
  private static final int METHODID_UPDATE_CHANNEL = 8;
  private static final int METHODID_DELETE_CHANNEL = 9;
  private static final int METHODID_GET_PROVIDER = 10;
  private static final int METHODID_LIST_PROVIDERS = 11;
  private static final int METHODID_GET_CHANNEL_CONNECTION = 12;
  private static final int METHODID_LIST_CHANNEL_CONNECTIONS = 13;
  private static final int METHODID_CREATE_CHANNEL_CONNECTION = 14;
  private static final int METHODID_DELETE_CHANNEL_CONNECTION = 15;
  private static final int METHODID_GET_GOOGLE_CHANNEL_CONFIG = 16;
  private static final int METHODID_UPDATE_GOOGLE_CHANNEL_CONFIG = 17;
  private static final int METHODID_GET_MESSAGE_BUS = 18;
  private static final int METHODID_LIST_MESSAGE_BUSES = 19;
  private static final int METHODID_LIST_MESSAGE_BUS_ENROLLMENTS = 20;
  private static final int METHODID_CREATE_MESSAGE_BUS = 21;
  private static final int METHODID_UPDATE_MESSAGE_BUS = 22;
  private static final int METHODID_DELETE_MESSAGE_BUS = 23;
  private static final int METHODID_GET_ENROLLMENT = 24;
  private static final int METHODID_LIST_ENROLLMENTS = 25;
  private static final int METHODID_CREATE_ENROLLMENT = 26;
  private static final int METHODID_UPDATE_ENROLLMENT = 27;
  private static final int METHODID_DELETE_ENROLLMENT = 28;
  private static final int METHODID_GET_PIPELINE = 29;
  private static final int METHODID_LIST_PIPELINES = 30;
  private static final int METHODID_CREATE_PIPELINE = 31;
  private static final int METHODID_UPDATE_PIPELINE = 32;
  private static final int METHODID_DELETE_PIPELINE = 33;
  private static final int METHODID_GET_GOOGLE_API_SOURCE = 34;
  private static final int METHODID_LIST_GOOGLE_API_SOURCES = 35;
  private static final int METHODID_CREATE_GOOGLE_API_SOURCE = 36;
  private static final int METHODID_UPDATE_GOOGLE_API_SOURCE = 37;
  private static final int METHODID_DELETE_GOOGLE_API_SOURCE = 38;

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
        case METHODID_GET_TRIGGER:
          serviceImpl.getTrigger(
              (com.google.cloud.eventarc.v1.GetTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Trigger>) responseObserver);
          break;
        case METHODID_LIST_TRIGGERS:
          serviceImpl.listTriggers(
              (com.google.cloud.eventarc.v1.ListTriggersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListTriggersResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_TRIGGER:
          serviceImpl.createTrigger(
              (com.google.cloud.eventarc.v1.CreateTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_TRIGGER:
          serviceImpl.updateTrigger(
              (com.google.cloud.eventarc.v1.UpdateTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_TRIGGER:
          serviceImpl.deleteTrigger(
              (com.google.cloud.eventarc.v1.DeleteTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CHANNEL:
          serviceImpl.getChannel(
              (com.google.cloud.eventarc.v1.GetChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Channel>) responseObserver);
          break;
        case METHODID_LIST_CHANNELS:
          serviceImpl.listChannels(
              (com.google.cloud.eventarc.v1.ListChannelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListChannelsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CHANNEL:
          serviceImpl.createChannel(
              (com.google.cloud.eventarc.v1.CreateChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CHANNEL:
          serviceImpl.updateChannel(
              (com.google.cloud.eventarc.v1.UpdateChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CHANNEL:
          serviceImpl.deleteChannel(
              (com.google.cloud.eventarc.v1.DeleteChannelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PROVIDER:
          serviceImpl.getProvider(
              (com.google.cloud.eventarc.v1.GetProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Provider>)
                  responseObserver);
          break;
        case METHODID_LIST_PROVIDERS:
          serviceImpl.listProviders(
              (com.google.cloud.eventarc.v1.ListProvidersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListProvidersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CHANNEL_CONNECTION:
          serviceImpl.getChannelConnection(
              (com.google.cloud.eventarc.v1.GetChannelConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ChannelConnection>)
                  responseObserver);
          break;
        case METHODID_LIST_CHANNEL_CONNECTIONS:
          serviceImpl.listChannelConnections(
              (com.google.cloud.eventarc.v1.ListChannelConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_CHANNEL_CONNECTION:
          serviceImpl.createChannelConnection(
              (com.google.cloud.eventarc.v1.CreateChannelConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CHANNEL_CONNECTION:
          serviceImpl.deleteChannelConnection(
              (com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GOOGLE_CHANNEL_CONFIG:
          serviceImpl.getGoogleChannelConfig(
              (com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_CHANNEL_CONFIG:
          serviceImpl.updateGoogleChannelConfig(
              (com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>)
                  responseObserver);
          break;
        case METHODID_GET_MESSAGE_BUS:
          serviceImpl.getMessageBus(
              (com.google.cloud.eventarc.v1.GetMessageBusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.MessageBus>)
                  responseObserver);
          break;
        case METHODID_LIST_MESSAGE_BUSES:
          serviceImpl.listMessageBuses(
              (com.google.cloud.eventarc.v1.ListMessageBusesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListMessageBusesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_MESSAGE_BUS_ENROLLMENTS:
          serviceImpl.listMessageBusEnrollments(
              (com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_MESSAGE_BUS:
          serviceImpl.createMessageBus(
              (com.google.cloud.eventarc.v1.CreateMessageBusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_MESSAGE_BUS:
          serviceImpl.updateMessageBus(
              (com.google.cloud.eventarc.v1.UpdateMessageBusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MESSAGE_BUS:
          serviceImpl.deleteMessageBus(
              (com.google.cloud.eventarc.v1.DeleteMessageBusRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ENROLLMENT:
          serviceImpl.getEnrollment(
              (com.google.cloud.eventarc.v1.GetEnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Enrollment>)
                  responseObserver);
          break;
        case METHODID_LIST_ENROLLMENTS:
          serviceImpl.listEnrollments(
              (com.google.cloud.eventarc.v1.ListEnrollmentsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListEnrollmentsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_ENROLLMENT:
          serviceImpl.createEnrollment(
              (com.google.cloud.eventarc.v1.CreateEnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENROLLMENT:
          serviceImpl.updateEnrollment(
              (com.google.cloud.eventarc.v1.UpdateEnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENROLLMENT:
          serviceImpl.deleteEnrollment(
              (com.google.cloud.eventarc.v1.DeleteEnrollmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_PIPELINE:
          serviceImpl.getPipeline(
              (com.google.cloud.eventarc.v1.GetPipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.Pipeline>)
                  responseObserver);
          break;
        case METHODID_LIST_PIPELINES:
          serviceImpl.listPipelines(
              (com.google.cloud.eventarc.v1.ListPipelinesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.ListPipelinesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PIPELINE:
          serviceImpl.createPipeline(
              (com.google.cloud.eventarc.v1.CreatePipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_PIPELINE:
          serviceImpl.updatePipeline(
              (com.google.cloud.eventarc.v1.UpdatePipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_PIPELINE:
          serviceImpl.deletePipeline(
              (com.google.cloud.eventarc.v1.DeletePipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GOOGLE_API_SOURCE:
          serviceImpl.getGoogleApiSource(
              (com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleApiSource>)
                  responseObserver);
          break;
        case METHODID_LIST_GOOGLE_API_SOURCES:
          serviceImpl.listGoogleApiSources(
              (com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_GOOGLE_API_SOURCE:
          serviceImpl.createGoogleApiSource(
              (com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_GOOGLE_API_SOURCE:
          serviceImpl.updateGoogleApiSource(
              (com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GOOGLE_API_SOURCE:
          serviceImpl.deleteGoogleApiSource(
              (com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
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
            getGetTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetTriggerRequest,
                    com.google.cloud.eventarc.v1.Trigger>(service, METHODID_GET_TRIGGER)))
        .addMethod(
            getListTriggersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListTriggersRequest,
                    com.google.cloud.eventarc.v1.ListTriggersResponse>(
                    service, METHODID_LIST_TRIGGERS)))
        .addMethod(
            getCreateTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateTriggerRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_TRIGGER)))
        .addMethod(
            getUpdateTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateTriggerRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_TRIGGER)))
        .addMethod(
            getDeleteTriggerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteTriggerRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_TRIGGER)))
        .addMethod(
            getGetChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetChannelRequest,
                    com.google.cloud.eventarc.v1.Channel>(service, METHODID_GET_CHANNEL)))
        .addMethod(
            getListChannelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListChannelsRequest,
                    com.google.cloud.eventarc.v1.ListChannelsResponse>(
                    service, METHODID_LIST_CHANNELS)))
        .addMethod(
            getCreateChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateChannelRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CHANNEL)))
        .addMethod(
            getUpdateChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateChannelRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CHANNEL)))
        .addMethod(
            getDeleteChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteChannelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CHANNEL)))
        .addMethod(
            getGetProviderMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetProviderRequest,
                    com.google.cloud.eventarc.v1.Provider>(service, METHODID_GET_PROVIDER)))
        .addMethod(
            getListProvidersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListProvidersRequest,
                    com.google.cloud.eventarc.v1.ListProvidersResponse>(
                    service, METHODID_LIST_PROVIDERS)))
        .addMethod(
            getGetChannelConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
                    com.google.cloud.eventarc.v1.ChannelConnection>(
                    service, METHODID_GET_CHANNEL_CONNECTION)))
        .addMethod(
            getListChannelConnectionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
                    com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>(
                    service, METHODID_LIST_CHANNEL_CONNECTIONS)))
        .addMethod(
            getCreateChannelConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CHANNEL_CONNECTION)))
        .addMethod(
            getDeleteChannelConnectionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CHANNEL_CONNECTION)))
        .addMethod(
            getGetGoogleChannelConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
                    com.google.cloud.eventarc.v1.GoogleChannelConfig>(
                    service, METHODID_GET_GOOGLE_CHANNEL_CONFIG)))
        .addMethod(
            getUpdateGoogleChannelConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
                    com.google.cloud.eventarc.v1.GoogleChannelConfig>(
                    service, METHODID_UPDATE_GOOGLE_CHANNEL_CONFIG)))
        .addMethod(
            getGetMessageBusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetMessageBusRequest,
                    com.google.cloud.eventarc.v1.MessageBus>(service, METHODID_GET_MESSAGE_BUS)))
        .addMethod(
            getListMessageBusesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListMessageBusesRequest,
                    com.google.cloud.eventarc.v1.ListMessageBusesResponse>(
                    service, METHODID_LIST_MESSAGE_BUSES)))
        .addMethod(
            getListMessageBusEnrollmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest,
                    com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse>(
                    service, METHODID_LIST_MESSAGE_BUS_ENROLLMENTS)))
        .addMethod(
            getCreateMessageBusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateMessageBusRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MESSAGE_BUS)))
        .addMethod(
            getUpdateMessageBusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateMessageBusRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_MESSAGE_BUS)))
        .addMethod(
            getDeleteMessageBusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteMessageBusRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MESSAGE_BUS)))
        .addMethod(
            getGetEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetEnrollmentRequest,
                    com.google.cloud.eventarc.v1.Enrollment>(service, METHODID_GET_ENROLLMENT)))
        .addMethod(
            getListEnrollmentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListEnrollmentsRequest,
                    com.google.cloud.eventarc.v1.ListEnrollmentsResponse>(
                    service, METHODID_LIST_ENROLLMENTS)))
        .addMethod(
            getCreateEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateEnrollmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENROLLMENT)))
        .addMethod(
            getUpdateEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateEnrollmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENROLLMENT)))
        .addMethod(
            getDeleteEnrollmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteEnrollmentRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENROLLMENT)))
        .addMethod(
            getGetPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetPipelineRequest,
                    com.google.cloud.eventarc.v1.Pipeline>(service, METHODID_GET_PIPELINE)))
        .addMethod(
            getListPipelinesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListPipelinesRequest,
                    com.google.cloud.eventarc.v1.ListPipelinesResponse>(
                    service, METHODID_LIST_PIPELINES)))
        .addMethod(
            getCreatePipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreatePipelineRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_PIPELINE)))
        .addMethod(
            getUpdatePipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdatePipelineRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_PIPELINE)))
        .addMethod(
            getDeletePipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeletePipelineRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PIPELINE)))
        .addMethod(
            getGetGoogleApiSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest,
                    com.google.cloud.eventarc.v1.GoogleApiSource>(
                    service, METHODID_GET_GOOGLE_API_SOURCE)))
        .addMethod(
            getListGoogleApiSourcesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest,
                    com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse>(
                    service, METHODID_LIST_GOOGLE_API_SOURCES)))
        .addMethod(
            getCreateGoogleApiSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_GOOGLE_API_SOURCE)))
        .addMethod(
            getUpdateGoogleApiSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GOOGLE_API_SOURCE)))
        .addMethod(
            getDeleteGoogleApiSourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_GOOGLE_API_SOURCE)))
        .build();
  }

  private abstract static class EventarcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventarcBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.eventarc.v1.EventarcProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Eventarc");
    }
  }

  private static final class EventarcFileDescriptorSupplier extends EventarcBaseDescriptorSupplier {
    EventarcFileDescriptorSupplier() {}
  }

  private static final class EventarcMethodDescriptorSupplier extends EventarcBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EventarcMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (EventarcGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EventarcFileDescriptorSupplier())
                      .addMethod(getGetTriggerMethod())
                      .addMethod(getListTriggersMethod())
                      .addMethod(getCreateTriggerMethod())
                      .addMethod(getUpdateTriggerMethod())
                      .addMethod(getDeleteTriggerMethod())
                      .addMethod(getGetChannelMethod())
                      .addMethod(getListChannelsMethod())
                      .addMethod(getCreateChannelMethod())
                      .addMethod(getUpdateChannelMethod())
                      .addMethod(getDeleteChannelMethod())
                      .addMethod(getGetProviderMethod())
                      .addMethod(getListProvidersMethod())
                      .addMethod(getGetChannelConnectionMethod())
                      .addMethod(getListChannelConnectionsMethod())
                      .addMethod(getCreateChannelConnectionMethod())
                      .addMethod(getDeleteChannelConnectionMethod())
                      .addMethod(getGetGoogleChannelConfigMethod())
                      .addMethod(getUpdateGoogleChannelConfigMethod())
                      .addMethod(getGetMessageBusMethod())
                      .addMethod(getListMessageBusesMethod())
                      .addMethod(getListMessageBusEnrollmentsMethod())
                      .addMethod(getCreateMessageBusMethod())
                      .addMethod(getUpdateMessageBusMethod())
                      .addMethod(getDeleteMessageBusMethod())
                      .addMethod(getGetEnrollmentMethod())
                      .addMethod(getListEnrollmentsMethod())
                      .addMethod(getCreateEnrollmentMethod())
                      .addMethod(getUpdateEnrollmentMethod())
                      .addMethod(getDeleteEnrollmentMethod())
                      .addMethod(getGetPipelineMethod())
                      .addMethod(getListPipelinesMethod())
                      .addMethod(getCreatePipelineMethod())
                      .addMethod(getUpdatePipelineMethod())
                      .addMethod(getDeletePipelineMethod())
                      .addMethod(getGetGoogleApiSourceMethod())
                      .addMethod(getListGoogleApiSourcesMethod())
                      .addMethod(getCreateGoogleApiSourceMethod())
                      .addMethod(getUpdateGoogleApiSourceMethod())
                      .addMethod(getDeleteGoogleApiSourceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
