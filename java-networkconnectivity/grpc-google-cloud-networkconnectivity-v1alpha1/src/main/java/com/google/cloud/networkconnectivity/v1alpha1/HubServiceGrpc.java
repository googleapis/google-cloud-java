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
package com.google.cloud.networkconnectivity.v1alpha1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Network Connectivity Center is a hub-and-spoke abstraction for
 * network connectivity management in Google Cloud. It reduces
 * operational complexity through a simple, centralized connectivity management
 * model.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/networkconnectivity/v1alpha1/hub.proto")
public final class HubServiceGrpc {

  private HubServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.networkconnectivity.v1alpha1.HubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest,
          com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
      getListHubsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHubs",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest,
          com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
      getListHubsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest,
            com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
        getListHubsMethod;
    if ((getListHubsMethod = HubServiceGrpc.getListHubsMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListHubsMethod = HubServiceGrpc.getListHubsMethod) == null) {
          HubServiceGrpc.getListHubsMethod =
              getListHubsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest,
                          com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHubs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListHubs"))
                      .build();
        }
      }
    }
    return getListHubsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest,
          com.google.cloud.networkconnectivity.v1alpha1.Hub>
      getGetHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHub",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1alpha1.Hub.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest,
          com.google.cloud.networkconnectivity.v1alpha1.Hub>
      getGetHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest,
            com.google.cloud.networkconnectivity.v1alpha1.Hub>
        getGetHubMethod;
    if ((getGetHubMethod = HubServiceGrpc.getGetHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetHubMethod = HubServiceGrpc.getGetHubMethod) == null) {
          HubServiceGrpc.getGetHubMethod =
              getGetHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest,
                          com.google.cloud.networkconnectivity.v1alpha1.Hub>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.Hub
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetHub"))
                      .build();
        }
      }
    }
    return getGetHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest,
          com.google.longrunning.Operation>
      getCreateHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHub",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest,
          com.google.longrunning.Operation>
      getCreateHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest,
            com.google.longrunning.Operation>
        getCreateHubMethod;
    if ((getCreateHubMethod = HubServiceGrpc.getCreateHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getCreateHubMethod = HubServiceGrpc.getCreateHubMethod) == null) {
          HubServiceGrpc.getCreateHubMethod =
              getCreateHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("CreateHub"))
                      .build();
        }
      }
    }
    return getCreateHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest,
          com.google.longrunning.Operation>
      getUpdateHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHub",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest,
          com.google.longrunning.Operation>
      getUpdateHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest,
            com.google.longrunning.Operation>
        getUpdateHubMethod;
    if ((getUpdateHubMethod = HubServiceGrpc.getUpdateHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateHubMethod = HubServiceGrpc.getUpdateHubMethod) == null) {
          HubServiceGrpc.getUpdateHubMethod =
              getUpdateHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("UpdateHub"))
                      .build();
        }
      }
    }
    return getUpdateHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest,
          com.google.longrunning.Operation>
      getDeleteHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHub",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest,
          com.google.longrunning.Operation>
      getDeleteHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest,
            com.google.longrunning.Operation>
        getDeleteHubMethod;
    if ((getDeleteHubMethod = HubServiceGrpc.getDeleteHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getDeleteHubMethod = HubServiceGrpc.getDeleteHubMethod) == null) {
          HubServiceGrpc.getDeleteHubMethod =
              getDeleteHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("DeleteHub"))
                      .build();
        }
      }
    }
    return getDeleteHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest,
          com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
      getListSpokesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpokes",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest,
          com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
      getListSpokesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest,
            com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
        getListSpokesMethod;
    if ((getListSpokesMethod = HubServiceGrpc.getListSpokesMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListSpokesMethod = HubServiceGrpc.getListSpokesMethod) == null) {
          HubServiceGrpc.getListSpokesMethod =
              getListSpokesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest,
                          com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpokes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListSpokes"))
                      .build();
        }
      }
    }
    return getListSpokesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest,
          com.google.cloud.networkconnectivity.v1alpha1.Spoke>
      getGetSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpoke",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1alpha1.Spoke.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest,
          com.google.cloud.networkconnectivity.v1alpha1.Spoke>
      getGetSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest,
            com.google.cloud.networkconnectivity.v1alpha1.Spoke>
        getGetSpokeMethod;
    if ((getGetSpokeMethod = HubServiceGrpc.getGetSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetSpokeMethod = HubServiceGrpc.getGetSpokeMethod) == null) {
          HubServiceGrpc.getGetSpokeMethod =
              getGetSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest,
                          com.google.cloud.networkconnectivity.v1alpha1.Spoke>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.Spoke
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetSpoke"))
                      .build();
        }
      }
    }
    return getGetSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest,
          com.google.longrunning.Operation>
      getCreateSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpoke",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest,
          com.google.longrunning.Operation>
      getCreateSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest,
            com.google.longrunning.Operation>
        getCreateSpokeMethod;
    if ((getCreateSpokeMethod = HubServiceGrpc.getCreateSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getCreateSpokeMethod = HubServiceGrpc.getCreateSpokeMethod) == null) {
          HubServiceGrpc.getCreateSpokeMethod =
              getCreateSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("CreateSpoke"))
                      .build();
        }
      }
    }
    return getCreateSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest,
          com.google.longrunning.Operation>
      getUpdateSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpoke",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest,
          com.google.longrunning.Operation>
      getUpdateSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest,
            com.google.longrunning.Operation>
        getUpdateSpokeMethod;
    if ((getUpdateSpokeMethod = HubServiceGrpc.getUpdateSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateSpokeMethod = HubServiceGrpc.getUpdateSpokeMethod) == null) {
          HubServiceGrpc.getUpdateSpokeMethod =
              getUpdateSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("UpdateSpoke"))
                      .build();
        }
      }
    }
    return getUpdateSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest,
          com.google.longrunning.Operation>
      getDeleteSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpoke",
      requestType = com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest,
          com.google.longrunning.Operation>
      getDeleteSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest,
            com.google.longrunning.Operation>
        getDeleteSpokeMethod;
    if ((getDeleteSpokeMethod = HubServiceGrpc.getDeleteSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getDeleteSpokeMethod = HubServiceGrpc.getDeleteSpokeMethod) == null) {
          HubServiceGrpc.getDeleteSpokeMethod =
              getDeleteSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("DeleteSpoke"))
                      .build();
        }
      }
    }
    return getDeleteSpokeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static HubServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HubServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HubServiceStub>() {
          @java.lang.Override
          public HubServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HubServiceStub(channel, callOptions);
          }
        };
    return HubServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HubServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HubServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HubServiceBlockingStub>() {
          @java.lang.Override
          public HubServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HubServiceBlockingStub(channel, callOptions);
          }
        };
    return HubServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static HubServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HubServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HubServiceFutureStub>() {
          @java.lang.Override
          public HubServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HubServiceFutureStub(channel, callOptions);
          }
        };
    return HubServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for
   * network connectivity management in Google Cloud. It reduces
   * operational complexity through a simple, centralized connectivity management
   * model.
   * </pre>
   */
  public abstract static class HubServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists Hubs in a given project and location.
     * </pre>
     */
    public void listHubs(
        com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListHubsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Hub.
     * </pre>
     */
    public void getHub(
        com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Hub>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Hub in a given project and location.
     * </pre>
     */
    public void createHub(
        com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Hub.
     * </pre>
     */
    public void updateHub(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Hub.
     * </pre>
     */
    public void deleteHub(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Spokes in a given project and location.
     * </pre>
     */
    public void listSpokes(
        com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListSpokesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Spoke.
     * </pre>
     */
    public void getSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Spoke>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Spoke in a given project and location.
     * </pre>
     */
    public void createSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Spoke.
     * </pre>
     */
    public void updateSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Spoke.
     * </pre>
     */
    public void deleteSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteSpokeMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListHubsMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest,
                      com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>(
                      this, METHODID_LIST_HUBS)))
          .addMethod(
              getGetHubMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest,
                      com.google.cloud.networkconnectivity.v1alpha1.Hub>(this, METHODID_GET_HUB)))
          .addMethod(
              getCreateHubMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_HUB)))
          .addMethod(
              getUpdateHubMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_HUB)))
          .addMethod(
              getDeleteHubMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_HUB)))
          .addMethod(
              getListSpokesMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest,
                      com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>(
                      this, METHODID_LIST_SPOKES)))
          .addMethod(
              getGetSpokeMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest,
                      com.google.cloud.networkconnectivity.v1alpha1.Spoke>(
                      this, METHODID_GET_SPOKE)))
          .addMethod(
              getCreateSpokeMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_SPOKE)))
          .addMethod(
              getUpdateSpokeMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_SPOKE)))
          .addMethod(
              getDeleteSpokeMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_SPOKE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for
   * network connectivity management in Google Cloud. It reduces
   * operational complexity through a simple, centralized connectivity management
   * model.
   * </pre>
   */
  public static final class HubServiceStub extends io.grpc.stub.AbstractAsyncStub<HubServiceStub> {
    private HubServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HubServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HubServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Hubs in a given project and location.
     * </pre>
     */
    public void listHubs(
        com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListHubsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Hub.
     * </pre>
     */
    public void getHub(
        com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Hub>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Hub in a given project and location.
     * </pre>
     */
    public void createHub(
        com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Hub.
     * </pre>
     */
    public void updateHub(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Hub.
     * </pre>
     */
    public void deleteHub(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Spokes in a given project and location.
     * </pre>
     */
    public void listSpokes(
        com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListSpokesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Spoke.
     * </pre>
     */
    public void getSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Spoke>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetSpokeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Spoke in a given project and location.
     * </pre>
     */
    public void createSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Spoke.
     * </pre>
     */
    public void updateSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Spoke.
     * </pre>
     */
    public void deleteSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for
   * network connectivity management in Google Cloud. It reduces
   * operational complexity through a simple, centralized connectivity management
   * model.
   * </pre>
   */
  public static final class HubServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HubServiceBlockingStub> {
    private HubServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HubServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HubServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Hubs in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse listHubs(
        com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest request) {
      return blockingUnaryCall(getChannel(), getListHubsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1alpha1.Hub getHub(
        com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest request) {
      return blockingUnaryCall(getChannel(), getGetHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Hub in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createHub(
        com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest request) {
      return blockingUnaryCall(getChannel(), getCreateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Hub.
     * </pre>
     */
    public com.google.longrunning.Operation updateHub(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Hub.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHub(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Spokes in a given project and location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse listSpokes(
        com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest request) {
      return blockingUnaryCall(getChannel(), getListSpokesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Spoke.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1alpha1.Spoke getSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest request) {
      return blockingUnaryCall(getChannel(), getGetSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Spoke in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest request) {
      return blockingUnaryCall(getChannel(), getCreateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Spoke.
     * </pre>
     */
    public com.google.longrunning.Operation updateSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Spoke.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSpoke(
        com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteSpokeMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for
   * network connectivity management in Google Cloud. It reduces
   * operational complexity through a simple, centralized connectivity management
   * model.
   * </pre>
   */
  public static final class HubServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<HubServiceFutureStub> {
    private HubServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HubServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HubServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Hubs in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>
        listHubs(com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest request) {
      return futureUnaryCall(getChannel().newCall(getListHubsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1alpha1.Hub>
        getHub(com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Hub in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHub(com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest request) {
      return futureUnaryCall(getChannel().newCall(getCreateHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHub(com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest request) {
      return futureUnaryCall(getChannel().newCall(getUpdateHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHub(com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest request) {
      return futureUnaryCall(getChannel().newCall(getDeleteHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Spokes in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>
        listSpokes(com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListSpokesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1alpha1.Spoke>
        getSpoke(com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Spoke in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSpoke(com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSpoke(com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSpoke(com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteSpokeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_HUBS = 0;
  private static final int METHODID_GET_HUB = 1;
  private static final int METHODID_CREATE_HUB = 2;
  private static final int METHODID_UPDATE_HUB = 3;
  private static final int METHODID_DELETE_HUB = 4;
  private static final int METHODID_LIST_SPOKES = 5;
  private static final int METHODID_GET_SPOKE = 6;
  private static final int METHODID_CREATE_SPOKE = 7;
  private static final int METHODID_UPDATE_SPOKE = 8;
  private static final int METHODID_DELETE_SPOKE = 9;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HubServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HubServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_HUBS:
          serviceImpl.listHubs(
              (com.google.cloud.networkconnectivity.v1alpha1.ListHubsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1alpha1.ListHubsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HUB:
          serviceImpl.getHub(
              (com.google.cloud.networkconnectivity.v1alpha1.GetHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Hub>)
                  responseObserver);
          break;
        case METHODID_CREATE_HUB:
          serviceImpl.createHub(
              (com.google.cloud.networkconnectivity.v1alpha1.CreateHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HUB:
          serviceImpl.updateHub(
              (com.google.cloud.networkconnectivity.v1alpha1.UpdateHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HUB:
          serviceImpl.deleteHub(
              (com.google.cloud.networkconnectivity.v1alpha1.DeleteHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SPOKES:
          serviceImpl.listSpokes(
              (com.google.cloud.networkconnectivity.v1alpha1.ListSpokesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1alpha1.ListSpokesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SPOKE:
          serviceImpl.getSpoke(
              (com.google.cloud.networkconnectivity.v1alpha1.GetSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1alpha1.Spoke>)
                  responseObserver);
          break;
        case METHODID_CREATE_SPOKE:
          serviceImpl.createSpoke(
              (com.google.cloud.networkconnectivity.v1alpha1.CreateSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SPOKE:
          serviceImpl.updateSpoke(
              (com.google.cloud.networkconnectivity.v1alpha1.UpdateSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SPOKE:
          serviceImpl.deleteSpoke(
              (com.google.cloud.networkconnectivity.v1alpha1.DeleteSpokeRequest) request,
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

  private abstract static class HubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1alpha1.HubProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HubService");
    }
  }

  private static final class HubServiceFileDescriptorSupplier
      extends HubServiceBaseDescriptorSupplier {
    HubServiceFileDescriptorSupplier() {}
  }

  private static final class HubServiceMethodDescriptorSupplier
      extends HubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HubServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HubServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new HubServiceFileDescriptorSupplier())
                      .addMethod(getListHubsMethod())
                      .addMethod(getGetHubMethod())
                      .addMethod(getCreateHubMethod())
                      .addMethod(getUpdateHubMethod())
                      .addMethod(getDeleteHubMethod())
                      .addMethod(getListSpokesMethod())
                      .addMethod(getGetSpokeMethod())
                      .addMethod(getCreateSpokeMethod())
                      .addMethod(getUpdateSpokeMethod())
                      .addMethod(getDeleteSpokeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
