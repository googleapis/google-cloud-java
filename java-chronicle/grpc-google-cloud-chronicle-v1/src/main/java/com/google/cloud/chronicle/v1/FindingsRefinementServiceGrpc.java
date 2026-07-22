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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * FindingsRefinementService provides an interface for filtering out
 * findings that are unlikely to be real threats to prevent them
 * from triggering alerts or notifications.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FindingsRefinementServiceGrpc {

  private FindingsRefinementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.FindingsRefinementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getGetFindingsRefinementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFindingsRefinement",
      requestType = com.google.cloud.chronicle.v1.GetFindingsRefinementRequest.class,
      responseType = com.google.cloud.chronicle.v1.FindingsRefinement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getGetFindingsRefinementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetFindingsRefinementRequest,
            com.google.cloud.chronicle.v1.FindingsRefinement>
        getGetFindingsRefinementMethod;
    if ((getGetFindingsRefinementMethod =
            FindingsRefinementServiceGrpc.getGetFindingsRefinementMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getGetFindingsRefinementMethod =
                FindingsRefinementServiceGrpc.getGetFindingsRefinementMethod)
            == null) {
          FindingsRefinementServiceGrpc.getGetFindingsRefinementMethod =
              getGetFindingsRefinementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetFindingsRefinementRequest,
                          com.google.cloud.chronicle.v1.FindingsRefinement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFindingsRefinement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetFindingsRefinementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FindingsRefinement
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "GetFindingsRefinement"))
                      .build();
        }
      }
    }
    return getGetFindingsRefinementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest,
          com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
      getListFindingsRefinementsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFindingsRefinements",
      requestType = com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest.class,
      responseType = com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest,
          com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
      getListFindingsRefinementsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest,
            com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
        getListFindingsRefinementsMethod;
    if ((getListFindingsRefinementsMethod =
            FindingsRefinementServiceGrpc.getListFindingsRefinementsMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getListFindingsRefinementsMethod =
                FindingsRefinementServiceGrpc.getListFindingsRefinementsMethod)
            == null) {
          FindingsRefinementServiceGrpc.getListFindingsRefinementsMethod =
              getListFindingsRefinementsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest,
                          com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListFindingsRefinements"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "ListFindingsRefinements"))
                      .build();
        }
      }
    }
    return getListFindingsRefinementsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getCreateFindingsRefinementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFindingsRefinement",
      requestType = com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest.class,
      responseType = com.google.cloud.chronicle.v1.FindingsRefinement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getCreateFindingsRefinementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest,
            com.google.cloud.chronicle.v1.FindingsRefinement>
        getCreateFindingsRefinementMethod;
    if ((getCreateFindingsRefinementMethod =
            FindingsRefinementServiceGrpc.getCreateFindingsRefinementMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getCreateFindingsRefinementMethod =
                FindingsRefinementServiceGrpc.getCreateFindingsRefinementMethod)
            == null) {
          FindingsRefinementServiceGrpc.getCreateFindingsRefinementMethod =
              getCreateFindingsRefinementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest,
                          com.google.cloud.chronicle.v1.FindingsRefinement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFindingsRefinement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FindingsRefinement
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "CreateFindingsRefinement"))
                      .build();
        }
      }
    }
    return getCreateFindingsRefinementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getUpdateFindingsRefinementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFindingsRefinement",
      requestType = com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest.class,
      responseType = com.google.cloud.chronicle.v1.FindingsRefinement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest,
          com.google.cloud.chronicle.v1.FindingsRefinement>
      getUpdateFindingsRefinementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest,
            com.google.cloud.chronicle.v1.FindingsRefinement>
        getUpdateFindingsRefinementMethod;
    if ((getUpdateFindingsRefinementMethod =
            FindingsRefinementServiceGrpc.getUpdateFindingsRefinementMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getUpdateFindingsRefinementMethod =
                FindingsRefinementServiceGrpc.getUpdateFindingsRefinementMethod)
            == null) {
          FindingsRefinementServiceGrpc.getUpdateFindingsRefinementMethod =
              getUpdateFindingsRefinementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest,
                          com.google.cloud.chronicle.v1.FindingsRefinement>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFindingsRefinement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FindingsRefinement
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "UpdateFindingsRefinement"))
                      .build();
        }
      }
    }
    return getUpdateFindingsRefinementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest,
          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
      getGetFindingsRefinementDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFindingsRefinementDeployment",
      requestType = com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest.class,
      responseType = com.google.cloud.chronicle.v1.FindingsRefinementDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest,
          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
      getGetFindingsRefinementDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest,
            com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
        getGetFindingsRefinementDeploymentMethod;
    if ((getGetFindingsRefinementDeploymentMethod =
            FindingsRefinementServiceGrpc.getGetFindingsRefinementDeploymentMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getGetFindingsRefinementDeploymentMethod =
                FindingsRefinementServiceGrpc.getGetFindingsRefinementDeploymentMethod)
            == null) {
          FindingsRefinementServiceGrpc.getGetFindingsRefinementDeploymentMethod =
              getGetFindingsRefinementDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest,
                          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFindingsRefinementDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FindingsRefinementDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "GetFindingsRefinementDeployment"))
                      .build();
        }
      }
    }
    return getGetFindingsRefinementDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest,
          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
      getUpdateFindingsRefinementDeploymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFindingsRefinementDeployment",
      requestType = com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest.class,
      responseType = com.google.cloud.chronicle.v1.FindingsRefinementDeployment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest,
          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
      getUpdateFindingsRefinementDeploymentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest,
            com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
        getUpdateFindingsRefinementDeploymentMethod;
    if ((getUpdateFindingsRefinementDeploymentMethod =
            FindingsRefinementServiceGrpc.getUpdateFindingsRefinementDeploymentMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getUpdateFindingsRefinementDeploymentMethod =
                FindingsRefinementServiceGrpc.getUpdateFindingsRefinementDeploymentMethod)
            == null) {
          FindingsRefinementServiceGrpc.getUpdateFindingsRefinementDeploymentMethod =
              getUpdateFindingsRefinementDeploymentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest,
                          com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "UpdateFindingsRefinementDeployment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .UpdateFindingsRefinementDeploymentRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FindingsRefinementDeployment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "UpdateFindingsRefinementDeployment"))
                      .build();
        }
      }
    }
    return getUpdateFindingsRefinementDeploymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest,
          com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
      getListAllFindingsRefinementDeploymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllFindingsRefinementDeployments",
      requestType = com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest.class,
      responseType =
          com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest,
          com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
      getListAllFindingsRefinementDeploymentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest,
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
        getListAllFindingsRefinementDeploymentsMethod;
    if ((getListAllFindingsRefinementDeploymentsMethod =
            FindingsRefinementServiceGrpc.getListAllFindingsRefinementDeploymentsMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getListAllFindingsRefinementDeploymentsMethod =
                FindingsRefinementServiceGrpc.getListAllFindingsRefinementDeploymentsMethod)
            == null) {
          FindingsRefinementServiceGrpc.getListAllFindingsRefinementDeploymentsMethod =
              getListAllFindingsRefinementDeploymentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest,
                          com.google.cloud.chronicle.v1
                              .ListAllFindingsRefinementDeploymentsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListAllFindingsRefinementDeployments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ListAllFindingsRefinementDeploymentsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ListAllFindingsRefinementDeploymentsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "ListAllFindingsRefinementDeployments"))
                      .build();
        }
      }
    }
    return getListAllFindingsRefinementDeploymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest,
          com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
      getComputeFindingsRefinementActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeFindingsRefinementActivity",
      requestType = com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest.class,
      responseType = com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest,
          com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
      getComputeFindingsRefinementActivityMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest,
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
        getComputeFindingsRefinementActivityMethod;
    if ((getComputeFindingsRefinementActivityMethod =
            FindingsRefinementServiceGrpc.getComputeFindingsRefinementActivityMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getComputeFindingsRefinementActivityMethod =
                FindingsRefinementServiceGrpc.getComputeFindingsRefinementActivityMethod)
            == null) {
          FindingsRefinementServiceGrpc.getComputeFindingsRefinementActivityMethod =
              getComputeFindingsRefinementActivityMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest,
                          com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ComputeFindingsRefinementActivity"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ComputeFindingsRefinementActivityResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "ComputeFindingsRefinementActivity"))
                      .build();
        }
      }
    }
    return getComputeFindingsRefinementActivityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest,
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
      getComputeAllFindingsRefinementActivitiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ComputeAllFindingsRefinementActivities",
      requestType =
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest.class,
      responseType =
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest,
          com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
      getComputeAllFindingsRefinementActivitiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest,
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
        getComputeAllFindingsRefinementActivitiesMethod;
    if ((getComputeAllFindingsRefinementActivitiesMethod =
            FindingsRefinementServiceGrpc.getComputeAllFindingsRefinementActivitiesMethod)
        == null) {
      synchronized (FindingsRefinementServiceGrpc.class) {
        if ((getComputeAllFindingsRefinementActivitiesMethod =
                FindingsRefinementServiceGrpc.getComputeAllFindingsRefinementActivitiesMethod)
            == null) {
          FindingsRefinementServiceGrpc.getComputeAllFindingsRefinementActivitiesMethod =
              getComputeAllFindingsRefinementActivitiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest,
                          com.google.cloud.chronicle.v1
                              .ComputeAllFindingsRefinementActivitiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ComputeAllFindingsRefinementActivities"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ComputeAllFindingsRefinementActivitiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ComputeAllFindingsRefinementActivitiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FindingsRefinementServiceMethodDescriptorSupplier(
                              "ComputeAllFindingsRefinementActivities"))
                      .build();
        }
      }
    }
    return getComputeAllFindingsRefinementActivitiesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FindingsRefinementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceStub>() {
          @java.lang.Override
          public FindingsRefinementServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FindingsRefinementServiceStub(channel, callOptions);
          }
        };
    return FindingsRefinementServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FindingsRefinementServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceBlockingV2Stub>() {
          @java.lang.Override
          public FindingsRefinementServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FindingsRefinementServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return FindingsRefinementServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FindingsRefinementServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceBlockingStub>() {
          @java.lang.Override
          public FindingsRefinementServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FindingsRefinementServiceBlockingStub(channel, callOptions);
          }
        };
    return FindingsRefinementServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FindingsRefinementServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FindingsRefinementServiceFutureStub>() {
          @java.lang.Override
          public FindingsRefinementServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FindingsRefinementServiceFutureStub(channel, callOptions);
          }
        };
    return FindingsRefinementServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a single findings refinement.
     * </pre>
     */
    default void getFindingsRefinement(
        com.google.cloud.chronicle.v1.GetFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFindingsRefinementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of findings refinements.
     * </pre>
     */
    default void listFindingsRefinements(
        com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFindingsRefinementsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new findings refinement.
     * </pre>
     */
    default void createFindingsRefinement(
        com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFindingsRefinementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement.
     * </pre>
     */
    default void updateFindingsRefinement(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFindingsRefinementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a findings refinement deployment.
     * </pre>
     */
    default void getFindingsRefinementDeployment(
        com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFindingsRefinementDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement deployment.
     * </pre>
     */
    default void updateFindingsRefinementDeployment(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFindingsRefinementDeploymentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all findings refinement deployments.
     * </pre>
     */
    default void listAllFindingsRefinementDeployments(
        com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAllFindingsRefinementDeploymentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for a specific findings refinement.
     * </pre>
     */
    default void computeFindingsRefinementActivity(
        com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeFindingsRefinementActivityMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for all findings refinements.
     * </pre>
     */
    default void computeAllFindingsRefinementActivities(
        com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getComputeAllFindingsRefinementActivitiesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FindingsRefinementService.
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public abstract static class FindingsRefinementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FindingsRefinementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FindingsRefinementService.
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public static final class FindingsRefinementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FindingsRefinementServiceStub> {
    private FindingsRefinementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindingsRefinementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindingsRefinementServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single findings refinement.
     * </pre>
     */
    public void getFindingsRefinement(
        com.google.cloud.chronicle.v1.GetFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFindingsRefinementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of findings refinements.
     * </pre>
     */
    public void listFindingsRefinements(
        com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFindingsRefinementsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new findings refinement.
     * </pre>
     */
    public void createFindingsRefinement(
        com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFindingsRefinementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement.
     * </pre>
     */
    public void updateFindingsRefinement(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFindingsRefinementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a findings refinement deployment.
     * </pre>
     */
    public void getFindingsRefinementDeployment(
        com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFindingsRefinementDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement deployment.
     * </pre>
     */
    public void updateFindingsRefinementDeployment(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFindingsRefinementDeploymentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all findings refinement deployments.
     * </pre>
     */
    public void listAllFindingsRefinementDeployments(
        com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllFindingsRefinementDeploymentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for a specific findings refinement.
     * </pre>
     */
    public void computeFindingsRefinementActivity(
        com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeFindingsRefinementActivityMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for all findings refinements.
     * </pre>
     */
    public void computeAllFindingsRefinementActivities(
        com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeAllFindingsRefinementActivitiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FindingsRefinementService.
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public static final class FindingsRefinementServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<FindingsRefinementServiceBlockingV2Stub> {
    private FindingsRefinementServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindingsRefinementServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindingsRefinementServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement getFindingsRefinement(
        com.google.cloud.chronicle.v1.GetFindingsRefinementRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of findings refinements.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse listFindingsRefinements(
        com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFindingsRefinementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement createFindingsRefinement(
        com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement updateFindingsRefinement(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a findings refinement deployment.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinementDeployment
        getFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFindingsRefinementDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement deployment.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinementDeployment
        updateFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateFindingsRefinementDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all findings refinement deployments.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse
        listAllFindingsRefinementDeployments(
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListAllFindingsRefinementDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for a specific findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse
        computeFindingsRefinementActivity(
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getComputeFindingsRefinementActivityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for all findings refinements.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse
        computeAllFindingsRefinementActivities(
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getComputeAllFindingsRefinementActivitiesMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * FindingsRefinementService.
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public static final class FindingsRefinementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FindingsRefinementServiceBlockingStub> {
    private FindingsRefinementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindingsRefinementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindingsRefinementServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement getFindingsRefinement(
        com.google.cloud.chronicle.v1.GetFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of findings refinements.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse listFindingsRefinements(
        com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFindingsRefinementsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement createFindingsRefinement(
        com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinement updateFindingsRefinement(
        com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFindingsRefinementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a findings refinement deployment.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinementDeployment
        getFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFindingsRefinementDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement deployment.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FindingsRefinementDeployment
        updateFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFindingsRefinementDeploymentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all findings refinement deployments.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse
        listAllFindingsRefinementDeployments(
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllFindingsRefinementDeploymentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for a specific findings refinement.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse
        computeFindingsRefinementActivity(
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeFindingsRefinementActivityMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for all findings refinements.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse
        computeAllFindingsRefinementActivities(
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getComputeAllFindingsRefinementActivitiesMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * FindingsRefinementService.
   *
   * <pre>
   * FindingsRefinementService provides an interface for filtering out
   * findings that are unlikely to be real threats to prevent them
   * from triggering alerts or notifications.
   * </pre>
   */
  public static final class FindingsRefinementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FindingsRefinementServiceFutureStub> {
    private FindingsRefinementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FindingsRefinementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FindingsRefinementServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a single findings refinement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FindingsRefinement>
        getFindingsRefinement(com.google.cloud.chronicle.v1.GetFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFindingsRefinementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists a collection of findings refinements.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>
        listFindingsRefinements(
            com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFindingsRefinementsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new findings refinement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FindingsRefinement>
        createFindingsRefinement(
            com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFindingsRefinementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FindingsRefinement>
        updateFindingsRefinement(
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFindingsRefinementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a findings refinement deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
        getFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFindingsRefinementDeploymentMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Updates a findings refinement deployment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FindingsRefinementDeployment>
        updateFindingsRefinementDeployment(
            com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFindingsRefinementDeploymentMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Lists all findings refinement deployments.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>
        listAllFindingsRefinementDeployments(
            com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllFindingsRefinementDeploymentsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for a specific findings refinement.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>
        computeFindingsRefinementActivity(
            com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeFindingsRefinementActivityMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Returns findings refinement activity for all findings refinements.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>
        computeAllFindingsRefinementActivities(
            com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeAllFindingsRefinementActivitiesMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_FINDINGS_REFINEMENT = 0;
  private static final int METHODID_LIST_FINDINGS_REFINEMENTS = 1;
  private static final int METHODID_CREATE_FINDINGS_REFINEMENT = 2;
  private static final int METHODID_UPDATE_FINDINGS_REFINEMENT = 3;
  private static final int METHODID_GET_FINDINGS_REFINEMENT_DEPLOYMENT = 4;
  private static final int METHODID_UPDATE_FINDINGS_REFINEMENT_DEPLOYMENT = 5;
  private static final int METHODID_LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS = 6;
  private static final int METHODID_COMPUTE_FINDINGS_REFINEMENT_ACTIVITY = 7;
  private static final int METHODID_COMPUTE_ALL_FINDINGS_REFINEMENT_ACTIVITIES = 8;

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
        case METHODID_GET_FINDINGS_REFINEMENT:
          serviceImpl.getFindingsRefinement(
              (com.google.cloud.chronicle.v1.GetFindingsRefinementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>)
                  responseObserver);
          break;
        case METHODID_LIST_FINDINGS_REFINEMENTS:
          serviceImpl.listFindingsRefinements(
              (com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FINDINGS_REFINEMENT:
          serviceImpl.createFindingsRefinement(
              (com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FINDINGS_REFINEMENT:
          serviceImpl.updateFindingsRefinement(
              (com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FindingsRefinement>)
                  responseObserver);
          break;
        case METHODID_GET_FINDINGS_REFINEMENT_DEPLOYMENT:
          serviceImpl.getFindingsRefinementDeployment(
              (com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.FindingsRefinementDeployment>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FINDINGS_REFINEMENT_DEPLOYMENT:
          serviceImpl.updateFindingsRefinementDeployment(
              (com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.FindingsRefinementDeployment>)
                  responseObserver);
          break;
        case METHODID_LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS:
          serviceImpl.listAllFindingsRefinementDeployments(
              (com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>)
                  responseObserver);
          break;
        case METHODID_COMPUTE_FINDINGS_REFINEMENT_ACTIVITY:
          serviceImpl.computeFindingsRefinementActivity(
              (com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>)
                  responseObserver);
          break;
        case METHODID_COMPUTE_ALL_FINDINGS_REFINEMENT_ACTIVITIES:
          serviceImpl.computeAllFindingsRefinementActivities(
              (com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>)
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
            getGetFindingsRefinementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetFindingsRefinementRequest,
                    com.google.cloud.chronicle.v1.FindingsRefinement>(
                    service, METHODID_GET_FINDINGS_REFINEMENT)))
        .addMethod(
            getListFindingsRefinementsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListFindingsRefinementsRequest,
                    com.google.cloud.chronicle.v1.ListFindingsRefinementsResponse>(
                    service, METHODID_LIST_FINDINGS_REFINEMENTS)))
        .addMethod(
            getCreateFindingsRefinementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.CreateFindingsRefinementRequest,
                    com.google.cloud.chronicle.v1.FindingsRefinement>(
                    service, METHODID_CREATE_FINDINGS_REFINEMENT)))
        .addMethod(
            getUpdateFindingsRefinementMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateFindingsRefinementRequest,
                    com.google.cloud.chronicle.v1.FindingsRefinement>(
                    service, METHODID_UPDATE_FINDINGS_REFINEMENT)))
        .addMethod(
            getGetFindingsRefinementDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetFindingsRefinementDeploymentRequest,
                    com.google.cloud.chronicle.v1.FindingsRefinementDeployment>(
                    service, METHODID_GET_FINDINGS_REFINEMENT_DEPLOYMENT)))
        .addMethod(
            getUpdateFindingsRefinementDeploymentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.UpdateFindingsRefinementDeploymentRequest,
                    com.google.cloud.chronicle.v1.FindingsRefinementDeployment>(
                    service, METHODID_UPDATE_FINDINGS_REFINEMENT_DEPLOYMENT)))
        .addMethod(
            getListAllFindingsRefinementDeploymentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsRequest,
                    com.google.cloud.chronicle.v1.ListAllFindingsRefinementDeploymentsResponse>(
                    service, METHODID_LIST_ALL_FINDINGS_REFINEMENT_DEPLOYMENTS)))
        .addMethod(
            getComputeFindingsRefinementActivityMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityRequest,
                    com.google.cloud.chronicle.v1.ComputeFindingsRefinementActivityResponse>(
                    service, METHODID_COMPUTE_FINDINGS_REFINEMENT_ACTIVITY)))
        .addMethod(
            getComputeAllFindingsRefinementActivitiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesRequest,
                    com.google.cloud.chronicle.v1.ComputeAllFindingsRefinementActivitiesResponse>(
                    service, METHODID_COMPUTE_ALL_FINDINGS_REFINEMENT_ACTIVITIES)))
        .build();
  }

  private abstract static class FindingsRefinementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FindingsRefinementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.FindingsRefinementProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FindingsRefinementService");
    }
  }

  private static final class FindingsRefinementServiceFileDescriptorSupplier
      extends FindingsRefinementServiceBaseDescriptorSupplier {
    FindingsRefinementServiceFileDescriptorSupplier() {}
  }

  private static final class FindingsRefinementServiceMethodDescriptorSupplier
      extends FindingsRefinementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FindingsRefinementServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FindingsRefinementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FindingsRefinementServiceFileDescriptorSupplier())
                      .addMethod(getGetFindingsRefinementMethod())
                      .addMethod(getListFindingsRefinementsMethod())
                      .addMethod(getCreateFindingsRefinementMethod())
                      .addMethod(getUpdateFindingsRefinementMethod())
                      .addMethod(getGetFindingsRefinementDeploymentMethod())
                      .addMethod(getUpdateFindingsRefinementDeploymentMethod())
                      .addMethod(getListAllFindingsRefinementDeploymentsMethod())
                      .addMethod(getComputeFindingsRefinementActivityMethod())
                      .addMethod(getComputeAllFindingsRefinementActivitiesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
