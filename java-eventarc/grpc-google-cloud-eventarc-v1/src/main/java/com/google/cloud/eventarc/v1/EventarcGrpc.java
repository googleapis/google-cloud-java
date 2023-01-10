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

  public static final String SERVICE_NAME = "google.cloud.eventarc.v1.Eventarc";

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
  public abstract static class EventarcImplBase implements io.grpc.BindableService {

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
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTriggerMethod(), responseObserver);
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
    public void createTrigger(
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
    public void updateTrigger(
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
    public void deleteTrigger(
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
    public void getChannel(
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
    public void listChannels(
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
    public void createChannel(
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
    public void updateChannel(
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
    public void deleteChannel(
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
    public void getProvider(
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
    public void listProviders(
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
    public void getChannelConnection(
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
    public void listChannelConnections(
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
    public void createChannelConnection(
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
    public void deleteChannelConnection(
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
    public void getGoogleChannelConfig(
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
    public void updateGoogleChannelConfig(
        com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.eventarc.v1.GoogleChannelConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGoogleChannelConfigMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getGetTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetTriggerRequest,
                      com.google.cloud.eventarc.v1.Trigger>(this, METHODID_GET_TRIGGER)))
          .addMethod(
              getListTriggersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.ListTriggersRequest,
                      com.google.cloud.eventarc.v1.ListTriggersResponse>(
                      this, METHODID_LIST_TRIGGERS)))
          .addMethod(
              getCreateTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.CreateTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_TRIGGER)))
          .addMethod(
              getUpdateTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.UpdateTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_TRIGGER)))
          .addMethod(
              getDeleteTriggerMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.DeleteTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_TRIGGER)))
          .addMethod(
              getGetChannelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetChannelRequest,
                      com.google.cloud.eventarc.v1.Channel>(this, METHODID_GET_CHANNEL)))
          .addMethod(
              getListChannelsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.ListChannelsRequest,
                      com.google.cloud.eventarc.v1.ListChannelsResponse>(
                      this, METHODID_LIST_CHANNELS)))
          .addMethod(
              getCreateChannelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.CreateChannelRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CHANNEL)))
          .addMethod(
              getUpdateChannelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.UpdateChannelRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_CHANNEL)))
          .addMethod(
              getDeleteChannelMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.DeleteChannelRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CHANNEL)))
          .addMethod(
              getGetProviderMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetProviderRequest,
                      com.google.cloud.eventarc.v1.Provider>(this, METHODID_GET_PROVIDER)))
          .addMethod(
              getListProvidersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.ListProvidersRequest,
                      com.google.cloud.eventarc.v1.ListProvidersResponse>(
                      this, METHODID_LIST_PROVIDERS)))
          .addMethod(
              getGetChannelConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetChannelConnectionRequest,
                      com.google.cloud.eventarc.v1.ChannelConnection>(
                      this, METHODID_GET_CHANNEL_CONNECTION)))
          .addMethod(
              getListChannelConnectionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.ListChannelConnectionsRequest,
                      com.google.cloud.eventarc.v1.ListChannelConnectionsResponse>(
                      this, METHODID_LIST_CHANNEL_CONNECTIONS)))
          .addMethod(
              getCreateChannelConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.CreateChannelConnectionRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_CHANNEL_CONNECTION)))
          .addMethod(
              getDeleteChannelConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_CHANNEL_CONNECTION)))
          .addMethod(
              getGetGoogleChannelConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest,
                      com.google.cloud.eventarc.v1.GoogleChannelConfig>(
                      this, METHODID_GET_GOOGLE_CHANNEL_CONFIG)))
          .addMethod(
              getUpdateGoogleChannelConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest,
                      com.google.cloud.eventarc.v1.GoogleChannelConfig>(
                      this, METHODID_UPDATE_GOOGLE_CHANNEL_CONFIG)))
          .build();
    }
  }

  /**
   *
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
  }

  /**
   *
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
  }

  /**
   *
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

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EventarcImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EventarcImplBase serviceImpl, int methodId) {
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
    private final String methodName;

    EventarcMethodDescriptorSupplier(String methodName) {
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
                      .build();
        }
      }
    }
    return result;
  }
}
