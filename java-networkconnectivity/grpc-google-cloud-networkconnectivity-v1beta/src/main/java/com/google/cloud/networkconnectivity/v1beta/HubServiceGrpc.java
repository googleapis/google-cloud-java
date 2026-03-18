/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.networkconnectivity.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Network Connectivity Center is a hub-and-spoke abstraction for network
 * connectivity management in Google Cloud. It reduces operational complexity
 * through a simple, centralized connectivity management model.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class HubServiceGrpc {

  private HubServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.networkconnectivity.v1beta.HubService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListHubsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
      getListHubsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHubs",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListHubsRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListHubsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListHubsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
      getListHubsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListHubsRequest,
            com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
        getListHubsMethod;
    if ((getListHubsMethod = HubServiceGrpc.getListHubsMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListHubsMethod = HubServiceGrpc.getListHubsMethod) == null) {
          HubServiceGrpc.getListHubsMethod =
              getListHubsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListHubsRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHubs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListHubsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListHubsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListHubs"))
                      .build();
        }
      }
    }
    return getListHubsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetHubRequest,
          com.google.cloud.networkconnectivity.v1beta.Hub>
      getGetHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetHub",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetHubRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.Hub.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetHubRequest,
          com.google.cloud.networkconnectivity.v1beta.Hub>
      getGetHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetHubRequest,
            com.google.cloud.networkconnectivity.v1beta.Hub>
        getGetHubMethod;
    if ((getGetHubMethod = HubServiceGrpc.getGetHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetHubMethod = HubServiceGrpc.getGetHubMethod) == null) {
          HubServiceGrpc.getGetHubMethod =
              getGetHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetHubRequest,
                          com.google.cloud.networkconnectivity.v1beta.Hub>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetHubRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.Hub.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetHub"))
                      .build();
        }
      }
    }
    return getGetHubMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateHubRequest,
          com.google.longrunning.Operation>
      getCreateHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateHub",
      requestType = com.google.cloud.networkconnectivity.v1beta.CreateHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateHubRequest,
          com.google.longrunning.Operation>
      getCreateHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.CreateHubRequest,
            com.google.longrunning.Operation>
        getCreateHubMethod;
    if ((getCreateHubMethod = HubServiceGrpc.getCreateHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getCreateHubMethod = HubServiceGrpc.getCreateHubMethod) == null) {
          HubServiceGrpc.getCreateHubMethod =
              getCreateHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.CreateHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.CreateHubRequest
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
          com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest,
          com.google.longrunning.Operation>
      getUpdateHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateHub",
      requestType = com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest,
          com.google.longrunning.Operation>
      getUpdateHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest,
            com.google.longrunning.Operation>
        getUpdateHubMethod;
    if ((getUpdateHubMethod = HubServiceGrpc.getUpdateHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateHubMethod = HubServiceGrpc.getUpdateHubMethod) == null) {
          HubServiceGrpc.getUpdateHubMethod =
              getUpdateHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest
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
          com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest,
          com.google.longrunning.Operation>
      getDeleteHubMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteHub",
      requestType = com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest,
          com.google.longrunning.Operation>
      getDeleteHubMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest,
            com.google.longrunning.Operation>
        getDeleteHubMethod;
    if ((getDeleteHubMethod = HubServiceGrpc.getDeleteHubMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getDeleteHubMethod = HubServiceGrpc.getDeleteHubMethod) == null) {
          HubServiceGrpc.getDeleteHubMethod =
              getDeleteHubMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteHub"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest
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
          com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
      getListHubSpokesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListHubSpokes",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
      getListHubSpokesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
        getListHubSpokesMethod;
    if ((getListHubSpokesMethod = HubServiceGrpc.getListHubSpokesMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListHubSpokesMethod = HubServiceGrpc.getListHubSpokesMethod) == null) {
          HubServiceGrpc.getListHubSpokesMethod =
              getListHubSpokesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListHubSpokes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListHubSpokes"))
                      .build();
        }
      }
    }
    return getListHubSpokesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest,
          com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
      getQueryHubStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryHubStatus",
      requestType = com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest,
          com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
      getQueryHubStatusMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest,
            com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
        getQueryHubStatusMethod;
    if ((getQueryHubStatusMethod = HubServiceGrpc.getQueryHubStatusMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getQueryHubStatusMethod = HubServiceGrpc.getQueryHubStatusMethod) == null) {
          HubServiceGrpc.getQueryHubStatusMethod =
              getQueryHubStatusMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest,
                          com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryHubStatus"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("QueryHubStatus"))
                      .build();
        }
      }
    }
    return getQueryHubStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
      getListSpokesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSpokes",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
      getListSpokesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
        getListSpokesMethod;
    if ((getListSpokesMethod = HubServiceGrpc.getListSpokesMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListSpokesMethod = HubServiceGrpc.getListSpokesMethod) == null) {
          HubServiceGrpc.getListSpokesMethod =
              getListSpokesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSpokes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListSpokes"))
                      .build();
        }
      }
    }
    return getListSpokesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest,
          com.google.cloud.networkconnectivity.v1beta.Spoke>
      getGetSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.Spoke.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest,
          com.google.cloud.networkconnectivity.v1beta.Spoke>
      getGetSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest,
            com.google.cloud.networkconnectivity.v1beta.Spoke>
        getGetSpokeMethod;
    if ((getGetSpokeMethod = HubServiceGrpc.getGetSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetSpokeMethod = HubServiceGrpc.getGetSpokeMethod) == null) {
          HubServiceGrpc.getGetSpokeMethod =
              getGetSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest,
                          com.google.cloud.networkconnectivity.v1beta.Spoke>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.Spoke
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetSpoke"))
                      .build();
        }
      }
    }
    return getGetSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest,
          com.google.longrunning.Operation>
      getCreateSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest,
          com.google.longrunning.Operation>
      getCreateSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest,
            com.google.longrunning.Operation>
        getCreateSpokeMethod;
    if ((getCreateSpokeMethod = HubServiceGrpc.getCreateSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getCreateSpokeMethod = HubServiceGrpc.getCreateSpokeMethod) == null) {
          HubServiceGrpc.getCreateSpokeMethod =
              getCreateSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest
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
          com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest,
          com.google.longrunning.Operation>
      getUpdateSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest,
          com.google.longrunning.Operation>
      getUpdateSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest,
            com.google.longrunning.Operation>
        getUpdateSpokeMethod;
    if ((getUpdateSpokeMethod = HubServiceGrpc.getUpdateSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateSpokeMethod = HubServiceGrpc.getUpdateSpokeMethod) == null) {
          HubServiceGrpc.getUpdateSpokeMethod =
              getUpdateSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest
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
          com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest,
          com.google.longrunning.Operation>
      getRejectHubSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RejectHubSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest,
          com.google.longrunning.Operation>
      getRejectHubSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest,
            com.google.longrunning.Operation>
        getRejectHubSpokeMethod;
    if ((getRejectHubSpokeMethod = HubServiceGrpc.getRejectHubSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getRejectHubSpokeMethod = HubServiceGrpc.getRejectHubSpokeMethod) == null) {
          HubServiceGrpc.getRejectHubSpokeMethod =
              getRejectHubSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RejectHubSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("RejectHubSpoke"))
                      .build();
        }
      }
    }
    return getRejectHubSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest,
          com.google.longrunning.Operation>
      getAcceptHubSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptHubSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest,
          com.google.longrunning.Operation>
      getAcceptHubSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest,
            com.google.longrunning.Operation>
        getAcceptHubSpokeMethod;
    if ((getAcceptHubSpokeMethod = HubServiceGrpc.getAcceptHubSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getAcceptHubSpokeMethod = HubServiceGrpc.getAcceptHubSpokeMethod) == null) {
          HubServiceGrpc.getAcceptHubSpokeMethod =
              getAcceptHubSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptHubSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("AcceptHubSpoke"))
                      .build();
        }
      }
    }
    return getAcceptHubSpokeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest,
          com.google.longrunning.Operation>
      getAcceptSpokeUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AcceptSpokeUpdate",
      requestType = com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest,
          com.google.longrunning.Operation>
      getAcceptSpokeUpdateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest,
            com.google.longrunning.Operation>
        getAcceptSpokeUpdateMethod;
    if ((getAcceptSpokeUpdateMethod = HubServiceGrpc.getAcceptSpokeUpdateMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getAcceptSpokeUpdateMethod = HubServiceGrpc.getAcceptSpokeUpdateMethod) == null) {
          HubServiceGrpc.getAcceptSpokeUpdateMethod =
              getAcceptSpokeUpdateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AcceptSpokeUpdate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("AcceptSpokeUpdate"))
                      .build();
        }
      }
    }
    return getAcceptSpokeUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest,
          com.google.longrunning.Operation>
      getRejectSpokeUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RejectSpokeUpdate",
      requestType = com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest,
          com.google.longrunning.Operation>
      getRejectSpokeUpdateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest,
            com.google.longrunning.Operation>
        getRejectSpokeUpdateMethod;
    if ((getRejectSpokeUpdateMethod = HubServiceGrpc.getRejectSpokeUpdateMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getRejectSpokeUpdateMethod = HubServiceGrpc.getRejectSpokeUpdateMethod) == null) {
          HubServiceGrpc.getRejectSpokeUpdateMethod =
              getRejectSpokeUpdateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RejectSpokeUpdate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("RejectSpokeUpdate"))
                      .build();
        }
      }
    }
    return getRejectSpokeUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest,
          com.google.longrunning.Operation>
      getDeleteSpokeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSpoke",
      requestType = com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest,
          com.google.longrunning.Operation>
      getDeleteSpokeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest,
            com.google.longrunning.Operation>
        getDeleteSpokeMethod;
    if ((getDeleteSpokeMethod = HubServiceGrpc.getDeleteSpokeMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getDeleteSpokeMethod = HubServiceGrpc.getDeleteSpokeMethod) == null) {
          HubServiceGrpc.getDeleteSpokeMethod =
              getDeleteSpokeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSpoke"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest
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

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest,
          com.google.cloud.networkconnectivity.v1beta.RouteTable>
      getGetRouteTableMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRouteTable",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.RouteTable.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest,
          com.google.cloud.networkconnectivity.v1beta.RouteTable>
      getGetRouteTableMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest,
            com.google.cloud.networkconnectivity.v1beta.RouteTable>
        getGetRouteTableMethod;
    if ((getGetRouteTableMethod = HubServiceGrpc.getGetRouteTableMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetRouteTableMethod = HubServiceGrpc.getGetRouteTableMethod) == null) {
          HubServiceGrpc.getGetRouteTableMethod =
              getGetRouteTableMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest,
                          com.google.cloud.networkconnectivity.v1beta.RouteTable>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRouteTable"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.RouteTable
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetRouteTable"))
                      .build();
        }
      }
    }
    return getGetRouteTableMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRouteRequest,
          com.google.cloud.networkconnectivity.v1beta.Route>
      getGetRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRoute",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetRouteRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.Route.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetRouteRequest,
          com.google.cloud.networkconnectivity.v1beta.Route>
      getGetRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetRouteRequest,
            com.google.cloud.networkconnectivity.v1beta.Route>
        getGetRouteMethod;
    if ((getGetRouteMethod = HubServiceGrpc.getGetRouteMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetRouteMethod = HubServiceGrpc.getGetRouteMethod) == null) {
          HubServiceGrpc.getGetRouteMethod =
              getGetRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetRouteRequest,
                          com.google.cloud.networkconnectivity.v1beta.Route>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetRouteRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.Route
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetRoute"))
                      .build();
        }
      }
    }
    return getGetRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
      getListRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRoutes",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
      getListRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
        getListRoutesMethod;
    if ((getListRoutesMethod = HubServiceGrpc.getListRoutesMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListRoutesMethod = HubServiceGrpc.getListRoutesMethod) == null) {
          HubServiceGrpc.getListRoutesMethod =
              getListRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListRoutes"))
                      .build();
        }
      }
    }
    return getListRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
      getListRouteTablesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRouteTables",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
      getListRouteTablesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
        getListRouteTablesMethod;
    if ((getListRouteTablesMethod = HubServiceGrpc.getListRouteTablesMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListRouteTablesMethod = HubServiceGrpc.getListRouteTablesMethod) == null) {
          HubServiceGrpc.getListRouteTablesMethod =
              getListRouteTablesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRouteTables"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("ListRouteTables"))
                      .build();
        }
      }
    }
    return getListRouteTablesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetGroupRequest,
          com.google.cloud.networkconnectivity.v1beta.Group>
      getGetGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGroup",
      requestType = com.google.cloud.networkconnectivity.v1beta.GetGroupRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.Group.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetGroupRequest,
          com.google.cloud.networkconnectivity.v1beta.Group>
      getGetGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetGroupRequest,
            com.google.cloud.networkconnectivity.v1beta.Group>
        getGetGroupMethod;
    if ((getGetGroupMethod = HubServiceGrpc.getGetGroupMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetGroupMethod = HubServiceGrpc.getGetGroupMethod) == null) {
          HubServiceGrpc.getGetGroupMethod =
              getGetGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.GetGroupRequest,
                          com.google.cloud.networkconnectivity.v1beta.Group>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GetGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.Group
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("GetGroup"))
                      .build();
        }
      }
    }
    return getGetGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
      getListGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGroups",
      requestType = com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest,
          com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
      getListGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest,
            com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
        getListGroupsMethod;
    if ((getListGroupsMethod = HubServiceGrpc.getListGroupsMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListGroupsMethod = HubServiceGrpc.getListGroupsMethod) == null) {
          HubServiceGrpc.getListGroupsMethod =
              getListGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest,
                          com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("ListGroups"))
                      .build();
        }
      }
    }
    return getListGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest,
          com.google.longrunning.Operation>
      getUpdateGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGroup",
      requestType = com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest,
          com.google.longrunning.Operation>
      getUpdateGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest,
            com.google.longrunning.Operation>
        getUpdateGroupMethod;
    if ((getUpdateGroupMethod = HubServiceGrpc.getUpdateGroupMethod) == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateGroupMethod = HubServiceGrpc.getUpdateGroupMethod) == null) {
          HubServiceGrpc.getUpdateGroupMethod =
              getUpdateGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new HubServiceMethodDescriptorSupplier("UpdateGroup"))
                      .build();
        }
      }
    }
    return getUpdateGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getCreateGatewayAdvertisedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateGatewayAdvertisedRoute",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getCreateGatewayAdvertisedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest,
            com.google.longrunning.Operation>
        getCreateGatewayAdvertisedRouteMethod;
    if ((getCreateGatewayAdvertisedRouteMethod =
            HubServiceGrpc.getCreateGatewayAdvertisedRouteMethod)
        == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getCreateGatewayAdvertisedRouteMethod =
                HubServiceGrpc.getCreateGatewayAdvertisedRouteMethod)
            == null) {
          HubServiceGrpc.getCreateGatewayAdvertisedRouteMethod =
              getCreateGatewayAdvertisedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .CreateGatewayAdvertisedRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateGatewayAdvertisedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .CreateGatewayAdvertisedRouteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("CreateGatewayAdvertisedRoute"))
                      .build();
        }
      }
    }
    return getCreateGatewayAdvertisedRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest,
          com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
      getGetGatewayAdvertisedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetGatewayAdvertisedRoute",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest.class,
      responseType = com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest,
          com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
      getGetGatewayAdvertisedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest,
            com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
        getGetGatewayAdvertisedRouteMethod;
    if ((getGetGatewayAdvertisedRouteMethod = HubServiceGrpc.getGetGatewayAdvertisedRouteMethod)
        == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getGetGatewayAdvertisedRouteMethod = HubServiceGrpc.getGetGatewayAdvertisedRouteMethod)
            == null) {
          HubServiceGrpc.getGetGatewayAdvertisedRouteMethod =
              getGetGatewayAdvertisedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .GetGatewayAdvertisedRouteRequest,
                          com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetGatewayAdvertisedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .GetGatewayAdvertisedRouteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("GetGatewayAdvertisedRoute"))
                      .build();
        }
      }
    }
    return getGetGatewayAdvertisedRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
      getListGatewayAdvertisedRoutesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGatewayAdvertisedRoutes",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest.class,
      responseType =
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest,
          com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
      getListGatewayAdvertisedRoutesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest,
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
        getListGatewayAdvertisedRoutesMethod;
    if ((getListGatewayAdvertisedRoutesMethod = HubServiceGrpc.getListGatewayAdvertisedRoutesMethod)
        == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getListGatewayAdvertisedRoutesMethod =
                HubServiceGrpc.getListGatewayAdvertisedRoutesMethod)
            == null) {
          HubServiceGrpc.getListGatewayAdvertisedRoutesMethod =
              getListGatewayAdvertisedRoutesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .ListGatewayAdvertisedRoutesRequest,
                          com.google.cloud.networkconnectivity.v1beta
                              .ListGatewayAdvertisedRoutesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListGatewayAdvertisedRoutes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .ListGatewayAdvertisedRoutesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .ListGatewayAdvertisedRoutesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("ListGatewayAdvertisedRoutes"))
                      .build();
        }
      }
    }
    return getListGatewayAdvertisedRoutesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getUpdateGatewayAdvertisedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateGatewayAdvertisedRoute",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getUpdateGatewayAdvertisedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest,
            com.google.longrunning.Operation>
        getUpdateGatewayAdvertisedRouteMethod;
    if ((getUpdateGatewayAdvertisedRouteMethod =
            HubServiceGrpc.getUpdateGatewayAdvertisedRouteMethod)
        == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getUpdateGatewayAdvertisedRouteMethod =
                HubServiceGrpc.getUpdateGatewayAdvertisedRouteMethod)
            == null) {
          HubServiceGrpc.getUpdateGatewayAdvertisedRouteMethod =
              getUpdateGatewayAdvertisedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .UpdateGatewayAdvertisedRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateGatewayAdvertisedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .UpdateGatewayAdvertisedRouteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("UpdateGatewayAdvertisedRoute"))
                      .build();
        }
      }
    }
    return getUpdateGatewayAdvertisedRouteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getDeleteGatewayAdvertisedRouteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGatewayAdvertisedRoute",
      requestType =
          com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest,
          com.google.longrunning.Operation>
      getDeleteGatewayAdvertisedRouteMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest,
            com.google.longrunning.Operation>
        getDeleteGatewayAdvertisedRouteMethod;
    if ((getDeleteGatewayAdvertisedRouteMethod =
            HubServiceGrpc.getDeleteGatewayAdvertisedRouteMethod)
        == null) {
      synchronized (HubServiceGrpc.class) {
        if ((getDeleteGatewayAdvertisedRouteMethod =
                HubServiceGrpc.getDeleteGatewayAdvertisedRouteMethod)
            == null) {
          HubServiceGrpc.getDeleteGatewayAdvertisedRouteMethod =
              getDeleteGatewayAdvertisedRouteMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.networkconnectivity.v1beta
                              .DeleteGatewayAdvertisedRouteRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteGatewayAdvertisedRoute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.networkconnectivity.v1beta
                                  .DeleteGatewayAdvertisedRouteRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new HubServiceMethodDescriptorSupplier("DeleteGatewayAdvertisedRoute"))
                      .build();
        }
      }
    }
    return getDeleteGatewayAdvertisedRouteMethod;
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

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static HubServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HubServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<HubServiceBlockingV2Stub>() {
          @java.lang.Override
          public HubServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new HubServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return HubServiceBlockingV2Stub.newStub(factory, channel);
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
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center hubs associated with a given project.
     * </pre>
     */
    default void listHubs(
        com.google.cloud.networkconnectivity.v1beta.ListHubsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListHubsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center hub.
     * </pre>
     */
    default void getHub(
        com.google.cloud.networkconnectivity.v1beta.GetHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Hub>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Network Connectivity Center hub in the specified project.
     * </pre>
     */
    default void createHub(
        com.google.cloud.networkconnectivity.v1beta.CreateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the description and/or labels of a Network Connectivity Center
     * hub.
     * </pre>
     */
    default void updateHub(
        com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center hub.
     * </pre>
     */
    default void deleteHub(
        com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteHubMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes associated with a
     * specified hub and location. The list includes both spokes that are attached
     * to the hub and spokes that have been proposed but not yet accepted.
     * </pre>
     */
    default void listHubSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListHubSpokesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query the Private Service Connect propagation status of a Network
     * Connectivity Center hub.
     * </pre>
     */
    default void queryHubStatus(
        com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryHubStatusMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes in a specified project and
     * location.
     * </pre>
     */
    default void listSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSpokesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center spoke.
     * </pre>
     */
    default void getSpoke(
        com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Spoke>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Network Connectivity Center spoke.
     * </pre>
     */
    default void createSpoke(
        com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center spoke.
     * </pre>
     */
    default void updateSpoke(
        com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a Network Connectivity Center spoke from being attached to a hub.
     * If the spoke was previously in the `ACTIVE` state, it
     * transitions to the `INACTIVE` state and is no longer able to
     * connect to other spokes that are attached to the hub.
     * </pre>
     */
    default void rejectHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRejectHubSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to attach a Network Connectivity Center spoke
     * to a hub.
     * </pre>
     */
    default void acceptHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcceptHubSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    default void acceptSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAcceptSpokeUpdateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    default void rejectSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRejectSpokeUpdateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center spoke.
     * </pre>
     */
    default void deleteSpoke(
        com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSpokeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center route table.
     * </pre>
     */
    default void getRouteTable(
        com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.RouteTable>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRouteTableMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the specified route.
     * </pre>
     */
    default void getRoute(
        com.google.cloud.networkconnectivity.v1beta.GetRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Route>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists routes in a given route table.
     * </pre>
     */
    default void listRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists route tables in a given hub.
     * </pre>
     */
    default void listRouteTables(
        com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRouteTablesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center group.
     * </pre>
     */
    default void getGroup(
        com.google.cloud.networkconnectivity.v1beta.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Group>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists groups in a given hub.
     * </pre>
     */
    default void listGroups(
        com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center group.
     * </pre>
     */
    default void updateGroup(
        com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a GatewayAdvertisedRoute
     * </pre>
     */
    default void createGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateGatewayAdvertisedRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a GatewayAdvertisedRoute
     * </pre>
     */
    default void getGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetGatewayAdvertisedRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List GatewayAdvertisedRoutes
     * </pre>
     */
    default void listGatewayAdvertisedRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListGatewayAdvertisedRoutesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a GatewayAdvertisedRoute
     * </pre>
     */
    default void updateGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateGatewayAdvertisedRouteMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a GatewayAdvertisedRoute
     * </pre>
     */
    default void deleteGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteGatewayAdvertisedRouteMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service HubService.
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
   * </pre>
   */
  public abstract static class HubServiceImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return HubServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service HubService.
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
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
     * Lists the Network Connectivity Center hubs associated with a given project.
     * </pre>
     */
    public void listHubs(
        com.google.cloud.networkconnectivity.v1beta.ListHubsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHubsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center hub.
     * </pre>
     */
    public void getHub(
        com.google.cloud.networkconnectivity.v1beta.GetHubRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Hub>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Network Connectivity Center hub in the specified project.
     * </pre>
     */
    public void createHub(
        com.google.cloud.networkconnectivity.v1beta.CreateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the description and/or labels of a Network Connectivity Center
     * hub.
     * </pre>
     */
    public void updateHub(
        com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center hub.
     * </pre>
     */
    public void deleteHub(
        com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteHubMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes associated with a
     * specified hub and location. The list includes both spokes that are attached
     * to the hub and spokes that have been proposed but not yet accepted.
     * </pre>
     */
    public void listHubSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListHubSpokesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query the Private Service Connect propagation status of a Network
     * Connectivity Center hub.
     * </pre>
     */
    public void queryHubStatus(
        com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryHubStatusMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes in a specified project and
     * location.
     * </pre>
     */
    public void listSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSpokesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center spoke.
     * </pre>
     */
    public void getSpoke(
        com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Spoke>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSpokeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a Network Connectivity Center spoke.
     * </pre>
     */
    public void createSpoke(
        com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center spoke.
     * </pre>
     */
    public void updateSpoke(
        com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a Network Connectivity Center spoke from being attached to a hub.
     * If the spoke was previously in the `ACTIVE` state, it
     * transitions to the `INACTIVE` state and is no longer able to
     * connect to other spokes that are attached to the hub.
     * </pre>
     */
    public void rejectHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRejectHubSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to attach a Network Connectivity Center spoke
     * to a hub.
     * </pre>
     */
    public void acceptHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptHubSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public void acceptSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAcceptSpokeUpdateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Rejects a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public void rejectSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRejectSpokeUpdateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center spoke.
     * </pre>
     */
    public void deleteSpoke(
        com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSpokeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center route table.
     * </pre>
     */
    public void getRouteTable(
        com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.RouteTable>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRouteTableMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the specified route.
     * </pre>
     */
    public void getRoute(
        com.google.cloud.networkconnectivity.v1beta.GetRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Route>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRouteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists routes in a given route table.
     * </pre>
     */
    public void listRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRoutesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists route tables in a given hub.
     * </pre>
     */
    public void listRouteTables(
        com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRouteTablesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center group.
     * </pre>
     */
    public void getGroup(
        com.google.cloud.networkconnectivity.v1beta.GetGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Group>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists groups in a given hub.
     * </pre>
     */
    public void listGroups(
        com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center group.
     * </pre>
     */
    public void updateGroup(
        com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a GatewayAdvertisedRoute
     * </pre>
     */
    public void createGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateGatewayAdvertisedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a GatewayAdvertisedRoute
     * </pre>
     */
    public void getGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetGatewayAdvertisedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List GatewayAdvertisedRoutes
     * </pre>
     */
    public void listGatewayAdvertisedRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGatewayAdvertisedRoutesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a GatewayAdvertisedRoute
     * </pre>
     */
    public void updateGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateGatewayAdvertisedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a GatewayAdvertisedRoute
     * </pre>
     */
    public void deleteGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGatewayAdvertisedRouteMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service HubService.
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
   * </pre>
   */
  public static final class HubServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HubServiceBlockingV2Stub> {
    private HubServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HubServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HubServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center hubs associated with a given project.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListHubsResponse listHubs(
        com.google.cloud.networkconnectivity.v1beta.ListHubsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListHubsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Hub getHub(
        com.google.cloud.networkconnectivity.v1beta.GetHubRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Network Connectivity Center hub in the specified project.
     * </pre>
     */
    public com.google.longrunning.Operation createHub(
        com.google.cloud.networkconnectivity.v1beta.CreateHubRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the description and/or labels of a Network Connectivity Center
     * hub.
     * </pre>
     */
    public com.google.longrunning.Operation updateHub(
        com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHub(
        com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes associated with a
     * specified hub and location. The list includes both spokes that are attached
     * to the hub and spokes that have been proposed but not yet accepted.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse listHubSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListHubSpokesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query the Private Service Connect propagation status of a Network
     * Connectivity Center hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse queryHubStatus(
        com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getQueryHubStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes in a specified project and
     * location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse listSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListSpokesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Spoke getSpoke(
        com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation createSpoke(
        com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation updateSpoke(
        com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a Network Connectivity Center spoke from being attached to a hub.
     * If the spoke was previously in the `ACTIVE` state, it
     * transitions to the `INACTIVE` state and is no longer able to
     * connect to other spokes that are attached to the hub.
     * </pre>
     */
    public com.google.longrunning.Operation rejectHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRejectHubSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to attach a Network Connectivity Center spoke
     * to a hub.
     * </pre>
     */
    public com.google.longrunning.Operation acceptHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAcceptHubSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.longrunning.Operation acceptSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getAcceptSpokeUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.longrunning.Operation rejectSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRejectSpokeUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSpoke(
        com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center route table.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.RouteTable getRouteTable(
        com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRouteTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the specified route.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Route getRoute(
        com.google.cloud.networkconnectivity.v1beta.GetRouteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists routes in a given route table.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse listRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists route tables in a given hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse listRouteTables(
        com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListRouteTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center group.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Group getGroup(
        com.google.cloud.networkconnectivity.v1beta.GetGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists groups in a given hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse listGroups(
        com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center group.
     * </pre>
     */
    public com.google.longrunning.Operation updateGroup(
        com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation createGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute
        getGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List GatewayAdvertisedRoutes
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse
        listGatewayAdvertisedRoutes(
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListGatewayAdvertisedRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service HubService.
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
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
     * Lists the Network Connectivity Center hubs associated with a given project.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListHubsResponse listHubs(
        com.google.cloud.networkconnectivity.v1beta.ListHubsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHubsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Hub getHub(
        com.google.cloud.networkconnectivity.v1beta.GetHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Network Connectivity Center hub in the specified project.
     * </pre>
     */
    public com.google.longrunning.Operation createHub(
        com.google.cloud.networkconnectivity.v1beta.CreateHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the description and/or labels of a Network Connectivity Center
     * hub.
     * </pre>
     */
    public com.google.longrunning.Operation updateHub(
        com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.longrunning.Operation deleteHub(
        com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteHubMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes associated with a
     * specified hub and location. The list includes both spokes that are attached
     * to the hub and spokes that have been proposed but not yet accepted.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse listHubSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListHubSpokesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query the Private Service Connect propagation status of a Network
     * Connectivity Center hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse queryHubStatus(
        com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryHubStatusMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes in a specified project and
     * location.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse listSpokes(
        com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSpokesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Spoke getSpoke(
        com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation createSpoke(
        com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation updateSpoke(
        com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a Network Connectivity Center spoke from being attached to a hub.
     * If the spoke was previously in the `ACTIVE` state, it
     * transitions to the `INACTIVE` state and is no longer able to
     * connect to other spokes that are attached to the hub.
     * </pre>
     */
    public com.google.longrunning.Operation rejectHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRejectHubSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to attach a Network Connectivity Center spoke
     * to a hub.
     * </pre>
     */
    public com.google.longrunning.Operation acceptHubSpoke(
        com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptHubSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.longrunning.Operation acceptSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAcceptSpokeUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.longrunning.Operation rejectSpokeUpdate(
        com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRejectSpokeUpdateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSpoke(
        com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSpokeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center route table.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.RouteTable getRouteTable(
        com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRouteTableMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the specified route.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Route getRoute(
        com.google.cloud.networkconnectivity.v1beta.GetRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists routes in a given route table.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse listRoutes(
        com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists route tables in a given hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse listRouteTables(
        com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRouteTablesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center group.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.Group getGroup(
        com.google.cloud.networkconnectivity.v1beta.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists groups in a given hub.
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse listGroups(
        com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center group.
     * </pre>
     */
    public com.google.longrunning.Operation updateGroup(
        com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation createGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute
        getGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List GatewayAdvertisedRoutes
     * </pre>
     */
    public com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse
        listGatewayAdvertisedRoutes(
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGatewayAdvertisedRoutesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation updateGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.longrunning.Operation deleteGatewayAdvertisedRoute(
        com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGatewayAdvertisedRouteMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service HubService.
   *
   * <pre>
   * Network Connectivity Center is a hub-and-spoke abstraction for network
   * connectivity management in Google Cloud. It reduces operational complexity
   * through a simple, centralized connectivity management model.
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
     * Lists the Network Connectivity Center hubs associated with a given project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>
        listHubs(com.google.cloud.networkconnectivity.v1beta.ListHubsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHubsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.Hub>
        getHub(com.google.cloud.networkconnectivity.v1beta.GetHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Network Connectivity Center hub in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createHub(com.google.cloud.networkconnectivity.v1beta.CreateHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the description and/or labels of a Network Connectivity Center
     * hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateHub(com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteHub(com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteHubMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes associated with a
     * specified hub and location. The list includes both spokes that are attached
     * to the hub and spokes that have been proposed but not yet accepted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>
        listHubSpokes(com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListHubSpokesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Query the Private Service Connect propagation status of a Network
     * Connectivity Center hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>
        queryHubStatus(com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryHubStatusMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Network Connectivity Center spokes in a specified project and
     * location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>
        listSpokes(com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSpokesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.Spoke>
        getSpoke(com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSpoke(com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSpoke(com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a Network Connectivity Center spoke from being attached to a hub.
     * If the spoke was previously in the `ACTIVE` state, it
     * transitions to the `INACTIVE` state and is no longer able to
     * connect to other spokes that are attached to the hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rejectHubSpoke(com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRejectHubSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to attach a Network Connectivity Center spoke
     * to a hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        acceptHubSpoke(com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptHubSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Accepts a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        acceptSpokeUpdate(
            com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAcceptSpokeUpdateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Rejects a proposal to update a Network Connectivity Center spoke in a hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        rejectSpokeUpdate(
            com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRejectSpokeUpdateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Network Connectivity Center spoke.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSpoke(com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSpokeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center route table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.RouteTable>
        getRouteTable(com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRouteTableMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about the specified route.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.Route>
        getRoute(com.google.cloud.networkconnectivity.v1beta.GetRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists routes in a given route table.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>
        listRoutes(com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists route tables in a given hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>
        listRouteTables(
            com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRouteTablesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details about a Network Connectivity Center group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.Group>
        getGroup(com.google.cloud.networkconnectivity.v1beta.GetGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists groups in a given hub.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>
        listGroups(com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a Network Connectivity Center group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGroup(com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateGatewayAdvertisedRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>
        getGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetGatewayAdvertisedRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List GatewayAdvertisedRoutes
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesResponse>
        listGatewayAdvertisedRoutes(
            com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGatewayAdvertisedRoutesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateGatewayAdvertisedRouteMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a GatewayAdvertisedRoute
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteGatewayAdvertisedRoute(
            com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGatewayAdvertisedRouteMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_HUBS = 0;
  private static final int METHODID_GET_HUB = 1;
  private static final int METHODID_CREATE_HUB = 2;
  private static final int METHODID_UPDATE_HUB = 3;
  private static final int METHODID_DELETE_HUB = 4;
  private static final int METHODID_LIST_HUB_SPOKES = 5;
  private static final int METHODID_QUERY_HUB_STATUS = 6;
  private static final int METHODID_LIST_SPOKES = 7;
  private static final int METHODID_GET_SPOKE = 8;
  private static final int METHODID_CREATE_SPOKE = 9;
  private static final int METHODID_UPDATE_SPOKE = 10;
  private static final int METHODID_REJECT_HUB_SPOKE = 11;
  private static final int METHODID_ACCEPT_HUB_SPOKE = 12;
  private static final int METHODID_ACCEPT_SPOKE_UPDATE = 13;
  private static final int METHODID_REJECT_SPOKE_UPDATE = 14;
  private static final int METHODID_DELETE_SPOKE = 15;
  private static final int METHODID_GET_ROUTE_TABLE = 16;
  private static final int METHODID_GET_ROUTE = 17;
  private static final int METHODID_LIST_ROUTES = 18;
  private static final int METHODID_LIST_ROUTE_TABLES = 19;
  private static final int METHODID_GET_GROUP = 20;
  private static final int METHODID_LIST_GROUPS = 21;
  private static final int METHODID_UPDATE_GROUP = 22;
  private static final int METHODID_CREATE_GATEWAY_ADVERTISED_ROUTE = 23;
  private static final int METHODID_GET_GATEWAY_ADVERTISED_ROUTE = 24;
  private static final int METHODID_LIST_GATEWAY_ADVERTISED_ROUTES = 25;
  private static final int METHODID_UPDATE_GATEWAY_ADVERTISED_ROUTE = 26;
  private static final int METHODID_DELETE_GATEWAY_ADVERTISED_ROUTE = 27;

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
        case METHODID_LIST_HUBS:
          serviceImpl.listHubs(
              (com.google.cloud.networkconnectivity.v1beta.ListHubsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_HUB:
          serviceImpl.getHub(
              (com.google.cloud.networkconnectivity.v1beta.GetHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Hub>)
                  responseObserver);
          break;
        case METHODID_CREATE_HUB:
          serviceImpl.createHub(
              (com.google.cloud.networkconnectivity.v1beta.CreateHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_HUB:
          serviceImpl.updateHub(
              (com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_HUB:
          serviceImpl.deleteHub(
              (com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_HUB_SPOKES:
          serviceImpl.listHubSpokes(
              (com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>)
                  responseObserver);
          break;
        case METHODID_QUERY_HUB_STATUS:
          serviceImpl.queryHubStatus(
              (com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SPOKES:
          serviceImpl.listSpokes(
              (com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SPOKE:
          serviceImpl.getSpoke(
              (com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Spoke>)
                  responseObserver);
          break;
        case METHODID_CREATE_SPOKE:
          serviceImpl.createSpoke(
              (com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SPOKE:
          serviceImpl.updateSpoke(
              (com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REJECT_HUB_SPOKE:
          serviceImpl.rejectHubSpoke(
              (com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ACCEPT_HUB_SPOKE:
          serviceImpl.acceptHubSpoke(
              (com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ACCEPT_SPOKE_UPDATE:
          serviceImpl.acceptSpokeUpdate(
              (com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REJECT_SPOKE_UPDATE:
          serviceImpl.rejectSpokeUpdate(
              (com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SPOKE:
          serviceImpl.deleteSpoke(
              (com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ROUTE_TABLE:
          serviceImpl.getRouteTable(
              (com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.RouteTable>)
                  responseObserver);
          break;
        case METHODID_GET_ROUTE:
          serviceImpl.getRoute(
              (com.google.cloud.networkconnectivity.v1beta.GetRouteRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Route>)
                  responseObserver);
          break;
        case METHODID_LIST_ROUTES:
          serviceImpl.listRoutes(
              (com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_ROUTE_TABLES:
          serviceImpl.listRouteTables(
              (com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_GROUP:
          serviceImpl.getGroup(
              (com.google.cloud.networkconnectivity.v1beta.GetGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.networkconnectivity.v1beta.Group>)
                  responseObserver);
          break;
        case METHODID_LIST_GROUPS:
          serviceImpl.listGroups(
              (com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GROUP:
          serviceImpl.updateGroup(
              (com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_GATEWAY_ADVERTISED_ROUTE:
          serviceImpl.createGatewayAdvertisedRoute(
              (com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_GATEWAY_ADVERTISED_ROUTE:
          serviceImpl.getGatewayAdvertisedRoute(
              (com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>)
                  responseObserver);
          break;
        case METHODID_LIST_GATEWAY_ADVERTISED_ROUTES:
          serviceImpl.listGatewayAdvertisedRoutes(
              (com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.networkconnectivity.v1beta
                          .ListGatewayAdvertisedRoutesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_GATEWAY_ADVERTISED_ROUTE:
          serviceImpl.updateGatewayAdvertisedRoute(
              (com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_GATEWAY_ADVERTISED_ROUTE:
          serviceImpl.deleteGatewayAdvertisedRoute(
              (com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest)
                  request,
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
            getListHubsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListHubsRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListHubsResponse>(
                    service, METHODID_LIST_HUBS)))
        .addMethod(
            getGetHubMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetHubRequest,
                    com.google.cloud.networkconnectivity.v1beta.Hub>(service, METHODID_GET_HUB)))
        .addMethod(
            getCreateHubMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.CreateHubRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_HUB)))
        .addMethod(
            getUpdateHubMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.UpdateHubRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_HUB)))
        .addMethod(
            getDeleteHubMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.DeleteHubRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_HUB)))
        .addMethod(
            getListHubSpokesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListHubSpokesRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListHubSpokesResponse>(
                    service, METHODID_LIST_HUB_SPOKES)))
        .addMethod(
            getQueryHubStatusMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.QueryHubStatusRequest,
                    com.google.cloud.networkconnectivity.v1beta.QueryHubStatusResponse>(
                    service, METHODID_QUERY_HUB_STATUS)))
        .addMethod(
            getListSpokesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListSpokesRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListSpokesResponse>(
                    service, METHODID_LIST_SPOKES)))
        .addMethod(
            getGetSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetSpokeRequest,
                    com.google.cloud.networkconnectivity.v1beta.Spoke>(
                    service, METHODID_GET_SPOKE)))
        .addMethod(
            getCreateSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.CreateSpokeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SPOKE)))
        .addMethod(
            getUpdateSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.UpdateSpokeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SPOKE)))
        .addMethod(
            getRejectHubSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.RejectHubSpokeRequest,
                    com.google.longrunning.Operation>(service, METHODID_REJECT_HUB_SPOKE)))
        .addMethod(
            getAcceptHubSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.AcceptHubSpokeRequest,
                    com.google.longrunning.Operation>(service, METHODID_ACCEPT_HUB_SPOKE)))
        .addMethod(
            getAcceptSpokeUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.AcceptSpokeUpdateRequest,
                    com.google.longrunning.Operation>(service, METHODID_ACCEPT_SPOKE_UPDATE)))
        .addMethod(
            getRejectSpokeUpdateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.RejectSpokeUpdateRequest,
                    com.google.longrunning.Operation>(service, METHODID_REJECT_SPOKE_UPDATE)))
        .addMethod(
            getDeleteSpokeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.DeleteSpokeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SPOKE)))
        .addMethod(
            getGetRouteTableMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetRouteTableRequest,
                    com.google.cloud.networkconnectivity.v1beta.RouteTable>(
                    service, METHODID_GET_ROUTE_TABLE)))
        .addMethod(
            getGetRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetRouteRequest,
                    com.google.cloud.networkconnectivity.v1beta.Route>(
                    service, METHODID_GET_ROUTE)))
        .addMethod(
            getListRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListRoutesRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListRoutesResponse>(
                    service, METHODID_LIST_ROUTES)))
        .addMethod(
            getListRouteTablesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListRouteTablesRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListRouteTablesResponse>(
                    service, METHODID_LIST_ROUTE_TABLES)))
        .addMethod(
            getGetGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetGroupRequest,
                    com.google.cloud.networkconnectivity.v1beta.Group>(
                    service, METHODID_GET_GROUP)))
        .addMethod(
            getListGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListGroupsRequest,
                    com.google.cloud.networkconnectivity.v1beta.ListGroupsResponse>(
                    service, METHODID_LIST_GROUPS)))
        .addMethod(
            getUpdateGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.UpdateGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_GROUP)))
        .addMethod(
            getCreateGatewayAdvertisedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.CreateGatewayAdvertisedRouteRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_GATEWAY_ADVERTISED_ROUTE)))
        .addMethod(
            getGetGatewayAdvertisedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.GetGatewayAdvertisedRouteRequest,
                    com.google.cloud.networkconnectivity.v1beta.GatewayAdvertisedRoute>(
                    service, METHODID_GET_GATEWAY_ADVERTISED_ROUTE)))
        .addMethod(
            getListGatewayAdvertisedRoutesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.ListGatewayAdvertisedRoutesRequest,
                    com.google.cloud.networkconnectivity.v1beta
                        .ListGatewayAdvertisedRoutesResponse>(
                    service, METHODID_LIST_GATEWAY_ADVERTISED_ROUTES)))
        .addMethod(
            getUpdateGatewayAdvertisedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.UpdateGatewayAdvertisedRouteRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_GATEWAY_ADVERTISED_ROUTE)))
        .addMethod(
            getDeleteGatewayAdvertisedRouteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.networkconnectivity.v1beta.DeleteGatewayAdvertisedRouteRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_GATEWAY_ADVERTISED_ROUTE)))
        .build();
  }

  private abstract static class HubServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HubServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.networkconnectivity.v1beta.HubProto.getDescriptor();
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
    private final java.lang.String methodName;

    HubServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getListHubSpokesMethod())
                      .addMethod(getQueryHubStatusMethod())
                      .addMethod(getListSpokesMethod())
                      .addMethod(getGetSpokeMethod())
                      .addMethod(getCreateSpokeMethod())
                      .addMethod(getUpdateSpokeMethod())
                      .addMethod(getRejectHubSpokeMethod())
                      .addMethod(getAcceptHubSpokeMethod())
                      .addMethod(getAcceptSpokeUpdateMethod())
                      .addMethod(getRejectSpokeUpdateMethod())
                      .addMethod(getDeleteSpokeMethod())
                      .addMethod(getGetRouteTableMethod())
                      .addMethod(getGetRouteMethod())
                      .addMethod(getListRoutesMethod())
                      .addMethod(getListRouteTablesMethod())
                      .addMethod(getGetGroupMethod())
                      .addMethod(getListGroupsMethod())
                      .addMethod(getUpdateGroupMethod())
                      .addMethod(getCreateGatewayAdvertisedRouteMethod())
                      .addMethod(getGetGatewayAdvertisedRouteMethod())
                      .addMethod(getListGatewayAdvertisedRoutesMethod())
                      .addMethod(getUpdateGatewayAdvertisedRouteMethod())
                      .addMethod(getDeleteGatewayAdvertisedRouteMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
