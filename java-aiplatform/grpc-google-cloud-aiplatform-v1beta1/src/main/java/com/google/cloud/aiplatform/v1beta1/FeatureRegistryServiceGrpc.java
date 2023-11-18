/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.aiplatform.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that handles CRUD and List for resources for
 * FeatureRegistry.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1beta1/feature_registry_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FeatureRegistryServiceGrpc {

  private FeatureRegistryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.aiplatform.v1beta1.FeatureRegistryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest,
          com.google.longrunning.Operation>
      getCreateFeatureGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeatureGroup",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest,
          com.google.longrunning.Operation>
      getCreateFeatureGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest,
            com.google.longrunning.Operation>
        getCreateFeatureGroupMethod;
    if ((getCreateFeatureGroupMethod = FeatureRegistryServiceGrpc.getCreateFeatureGroupMethod)
        == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getCreateFeatureGroupMethod = FeatureRegistryServiceGrpc.getCreateFeatureGroupMethod)
            == null) {
          FeatureRegistryServiceGrpc.getCreateFeatureGroupMethod =
              getCreateFeatureGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeatureGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("CreateFeatureGroup"))
                      .build();
        }
      }
    }
    return getCreateFeatureGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest,
          com.google.cloud.aiplatform.v1beta1.FeatureGroup>
      getGetFeatureGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeatureGroup",
      requestType = com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.FeatureGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest,
          com.google.cloud.aiplatform.v1beta1.FeatureGroup>
      getGetFeatureGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest,
            com.google.cloud.aiplatform.v1beta1.FeatureGroup>
        getGetFeatureGroupMethod;
    if ((getGetFeatureGroupMethod = FeatureRegistryServiceGrpc.getGetFeatureGroupMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getGetFeatureGroupMethod = FeatureRegistryServiceGrpc.getGetFeatureGroupMethod)
            == null) {
          FeatureRegistryServiceGrpc.getGetFeatureGroupMethod =
              getGetFeatureGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest,
                          com.google.cloud.aiplatform.v1beta1.FeatureGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeatureGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.FeatureGroup
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("GetFeatureGroup"))
                      .build();
        }
      }
    }
    return getGetFeatureGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest,
          com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
      getListFeatureGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatureGroups",
      requestType = com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest,
          com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
      getListFeatureGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest,
            com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
        getListFeatureGroupsMethod;
    if ((getListFeatureGroupsMethod = FeatureRegistryServiceGrpc.getListFeatureGroupsMethod)
        == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getListFeatureGroupsMethod = FeatureRegistryServiceGrpc.getListFeatureGroupsMethod)
            == null) {
          FeatureRegistryServiceGrpc.getListFeatureGroupsMethod =
              getListFeatureGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest,
                          com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatureGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("ListFeatureGroups"))
                      .build();
        }
      }
    }
    return getListFeatureGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest,
          com.google.longrunning.Operation>
      getUpdateFeatureGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeatureGroup",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest,
          com.google.longrunning.Operation>
      getUpdateFeatureGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest,
            com.google.longrunning.Operation>
        getUpdateFeatureGroupMethod;
    if ((getUpdateFeatureGroupMethod = FeatureRegistryServiceGrpc.getUpdateFeatureGroupMethod)
        == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getUpdateFeatureGroupMethod = FeatureRegistryServiceGrpc.getUpdateFeatureGroupMethod)
            == null) {
          FeatureRegistryServiceGrpc.getUpdateFeatureGroupMethod =
              getUpdateFeatureGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeatureGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("UpdateFeatureGroup"))
                      .build();
        }
      }
    }
    return getUpdateFeatureGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest,
          com.google.longrunning.Operation>
      getDeleteFeatureGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeatureGroup",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest,
          com.google.longrunning.Operation>
      getDeleteFeatureGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest,
            com.google.longrunning.Operation>
        getDeleteFeatureGroupMethod;
    if ((getDeleteFeatureGroupMethod = FeatureRegistryServiceGrpc.getDeleteFeatureGroupMethod)
        == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getDeleteFeatureGroupMethod = FeatureRegistryServiceGrpc.getDeleteFeatureGroupMethod)
            == null) {
          FeatureRegistryServiceGrpc.getDeleteFeatureGroupMethod =
              getDeleteFeatureGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeatureGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("DeleteFeatureGroup"))
                      .build();
        }
      }
    }
    return getDeleteFeatureGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest,
          com.google.longrunning.Operation>
      getCreateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeature",
      requestType = com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest,
          com.google.longrunning.Operation>
      getCreateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest,
            com.google.longrunning.Operation>
        getCreateFeatureMethod;
    if ((getCreateFeatureMethod = FeatureRegistryServiceGrpc.getCreateFeatureMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getCreateFeatureMethod = FeatureRegistryServiceGrpc.getCreateFeatureMethod) == null) {
          FeatureRegistryServiceGrpc.getCreateFeatureMethod =
              getCreateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("CreateFeature"))
                      .build();
        }
      }
    }
    return getCreateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetFeatureRequest,
          com.google.cloud.aiplatform.v1beta1.Feature>
      getGetFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeature",
      requestType = com.google.cloud.aiplatform.v1beta1.GetFeatureRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.Feature.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.GetFeatureRequest,
          com.google.cloud.aiplatform.v1beta1.Feature>
      getGetFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.GetFeatureRequest,
            com.google.cloud.aiplatform.v1beta1.Feature>
        getGetFeatureMethod;
    if ((getGetFeatureMethod = FeatureRegistryServiceGrpc.getGetFeatureMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getGetFeatureMethod = FeatureRegistryServiceGrpc.getGetFeatureMethod) == null) {
          FeatureRegistryServiceGrpc.getGetFeatureMethod =
              getGetFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.GetFeatureRequest,
                          com.google.cloud.aiplatform.v1beta1.Feature>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.GetFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.Feature.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("GetFeature"))
                      .build();
        }
      }
    }
    return getGetFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest,
          com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
      getListFeaturesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeatures",
      requestType = com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest.class,
      responseType = com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest,
          com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
      getListFeaturesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest,
            com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
        getListFeaturesMethod;
    if ((getListFeaturesMethod = FeatureRegistryServiceGrpc.getListFeaturesMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getListFeaturesMethod = FeatureRegistryServiceGrpc.getListFeaturesMethod) == null) {
          FeatureRegistryServiceGrpc.getListFeaturesMethod =
              getListFeaturesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest,
                          com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeatures"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("ListFeatures"))
                      .build();
        }
      }
    }
    return getListFeaturesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest,
          com.google.longrunning.Operation>
      getUpdateFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeature",
      requestType = com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest,
          com.google.longrunning.Operation>
      getUpdateFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest,
            com.google.longrunning.Operation>
        getUpdateFeatureMethod;
    if ((getUpdateFeatureMethod = FeatureRegistryServiceGrpc.getUpdateFeatureMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getUpdateFeatureMethod = FeatureRegistryServiceGrpc.getUpdateFeatureMethod) == null) {
          FeatureRegistryServiceGrpc.getUpdateFeatureMethod =
              getUpdateFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("UpdateFeature"))
                      .build();
        }
      }
    }
    return getUpdateFeatureMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest,
          com.google.longrunning.Operation>
      getDeleteFeatureMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeature",
      requestType = com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest,
          com.google.longrunning.Operation>
      getDeleteFeatureMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest,
            com.google.longrunning.Operation>
        getDeleteFeatureMethod;
    if ((getDeleteFeatureMethod = FeatureRegistryServiceGrpc.getDeleteFeatureMethod) == null) {
      synchronized (FeatureRegistryServiceGrpc.class) {
        if ((getDeleteFeatureMethod = FeatureRegistryServiceGrpc.getDeleteFeatureMethod) == null) {
          FeatureRegistryServiceGrpc.getDeleteFeatureMethod =
              getDeleteFeatureMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFeature"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeatureRegistryServiceMethodDescriptorSupplier("DeleteFeature"))
                      .build();
        }
      }
    }
    return getDeleteFeatureMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeatureRegistryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceStub>() {
          @java.lang.Override
          public FeatureRegistryServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureRegistryServiceStub(channel, callOptions);
          }
        };
    return FeatureRegistryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeatureRegistryServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceBlockingStub>() {
          @java.lang.Override
          public FeatureRegistryServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureRegistryServiceBlockingStub(channel, callOptions);
          }
        };
    return FeatureRegistryServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeatureRegistryServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeatureRegistryServiceFutureStub>() {
          @java.lang.Override
          public FeatureRegistryServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeatureRegistryServiceFutureStub(channel, callOptions);
          }
        };
    return FeatureRegistryServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureRegistry.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new FeatureGroup in a given project and location.
     * </pre>
     */
    default void createFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeatureGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FeatureGroup.
     * </pre>
     */
    default void getFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FeatureGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFeatureGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FeatureGroups in a given project and location.
     * </pre>
     */
    default void listFeatureGroups(
        com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeatureGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FeatureGroup.
     * </pre>
     */
    default void updateFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeatureGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FeatureGroup.
     * </pre>
     */
    default void deleteFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeatureGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given FeatureGroup.
     * </pre>
     */
    default void createFeature(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    default void getFeature(
        com.google.cloud.aiplatform.v1beta1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Feature> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given FeatureGroup.
     * </pre>
     */
    default void listFeatures(
        com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeaturesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    default void updateFeature(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeatureMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    default void deleteFeature(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeatureMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeatureRegistryService.
   *
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureRegistry.
   * </pre>
   */
  public abstract static class FeatureRegistryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FeatureRegistryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FeatureRegistryService.
   *
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureRegistry.
   * </pre>
   */
  public static final class FeatureRegistryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeatureRegistryServiceStub> {
    private FeatureRegistryServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureRegistryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureRegistryServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FeatureGroup in a given project and location.
     * </pre>
     */
    public void createFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FeatureGroup.
     * </pre>
     */
    public void getFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FeatureGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FeatureGroups in a given project and location.
     * </pre>
     */
    public void listFeatureGroups(
        com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeatureGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FeatureGroup.
     * </pre>
     */
    public void updateFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FeatureGroup.
     * </pre>
     */
    public void deleteFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given FeatureGroup.
     * </pre>
     */
    public void createFeature(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public void getFeature(
        com.google.cloud.aiplatform.v1beta1.GetFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Feature> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given FeatureGroup.
     * </pre>
     */
    public void listFeatures(
        com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public void updateFeature(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public void deleteFeature(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FeatureRegistryService.
   *
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureRegistry.
   * </pre>
   */
  public static final class FeatureRegistryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeatureRegistryServiceBlockingStub> {
    private FeatureRegistryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureRegistryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureRegistryServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FeatureGroup in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FeatureGroup.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.FeatureGroup getFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FeatureGroups in a given project and location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse listFeatureGroups(
        com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeatureGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FeatureGroup.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FeatureGroup.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeatureGroup(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given FeatureGroup.
     * </pre>
     */
    public com.google.longrunning.Operation createFeature(
        com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.Feature getFeature(
        com.google.cloud.aiplatform.v1beta1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given FeatureGroup.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse listFeatures(
        com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public com.google.longrunning.Operation updateFeature(
        com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeatureMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFeature(
        com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeatureMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * FeatureRegistryService.
   *
   * <pre>
   * The service that handles CRUD and List for resources for
   * FeatureRegistry.
   * </pre>
   */
  public static final class FeatureRegistryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeatureRegistryServiceFutureStub> {
    private FeatureRegistryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeatureRegistryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeatureRegistryServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FeatureGroup in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFeatureGroup(com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FeatureGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.FeatureGroup>
        getFeatureGroup(com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FeatureGroups in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>
        listFeatureGroups(com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeatureGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FeatureGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFeatureGroup(com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FeatureGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFeatureGroup(com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Feature in a given FeatureGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFeature(com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.Feature>
        getFeature(com.google.cloud.aiplatform.v1beta1.GetFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Features in a given FeatureGroup.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>
        listFeatures(com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFeature(com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeatureMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Feature.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFeature(com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeatureMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FEATURE_GROUP = 0;
  private static final int METHODID_GET_FEATURE_GROUP = 1;
  private static final int METHODID_LIST_FEATURE_GROUPS = 2;
  private static final int METHODID_UPDATE_FEATURE_GROUP = 3;
  private static final int METHODID_DELETE_FEATURE_GROUP = 4;
  private static final int METHODID_CREATE_FEATURE = 5;
  private static final int METHODID_GET_FEATURE = 6;
  private static final int METHODID_LIST_FEATURES = 7;
  private static final int METHODID_UPDATE_FEATURE = 8;
  private static final int METHODID_DELETE_FEATURE = 9;

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
        case METHODID_CREATE_FEATURE_GROUP:
          serviceImpl.createFeatureGroup(
              (com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURE_GROUP:
          serviceImpl.getFeatureGroup(
              (com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.FeatureGroup>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURE_GROUPS:
          serviceImpl.listFeatureGroups(
              (com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEATURE_GROUP:
          serviceImpl.updateFeatureGroup(
              (com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE_GROUP:
          serviceImpl.deleteFeatureGroup(
              (com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_FEATURE:
          serviceImpl.createFeature(
              (com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_FEATURE:
          serviceImpl.getFeature(
              (com.google.cloud.aiplatform.v1beta1.GetFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1beta1.Feature>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURES:
          serviceImpl.listFeatures(
              (com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEATURE:
          serviceImpl.updateFeature(
              (com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FEATURE:
          serviceImpl.deleteFeature(
              (com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest) request,
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
            getCreateFeatureGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateFeatureGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FEATURE_GROUP)))
        .addMethod(
            getGetFeatureGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetFeatureGroupRequest,
                    com.google.cloud.aiplatform.v1beta1.FeatureGroup>(
                    service, METHODID_GET_FEATURE_GROUP)))
        .addMethod(
            getListFeatureGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsRequest,
                    com.google.cloud.aiplatform.v1beta1.ListFeatureGroupsResponse>(
                    service, METHODID_LIST_FEATURE_GROUPS)))
        .addMethod(
            getUpdateFeatureGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateFeatureGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FEATURE_GROUP)))
        .addMethod(
            getDeleteFeatureGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteFeatureGroupRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FEATURE_GROUP)))
        .addMethod(
            getCreateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FEATURE)))
        .addMethod(
            getGetFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.GetFeatureRequest,
                    com.google.cloud.aiplatform.v1beta1.Feature>(service, METHODID_GET_FEATURE)))
        .addMethod(
            getListFeaturesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest,
                    com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse>(
                    service, METHODID_LIST_FEATURES)))
        .addMethod(
            getUpdateFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FEATURE)))
        .addMethod(
            getDeleteFeatureMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FEATURE)))
        .build();
  }

  private abstract static class FeatureRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeatureRegistryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1beta1.FeatureRegistryServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeatureRegistryService");
    }
  }

  private static final class FeatureRegistryServiceFileDescriptorSupplier
      extends FeatureRegistryServiceBaseDescriptorSupplier {
    FeatureRegistryServiceFileDescriptorSupplier() {}
  }

  private static final class FeatureRegistryServiceMethodDescriptorSupplier
      extends FeatureRegistryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeatureRegistryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeatureRegistryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new FeatureRegistryServiceFileDescriptorSupplier())
                      .addMethod(getCreateFeatureGroupMethod())
                      .addMethod(getGetFeatureGroupMethod())
                      .addMethod(getListFeatureGroupsMethod())
                      .addMethod(getUpdateFeatureGroupMethod())
                      .addMethod(getDeleteFeatureGroupMethod())
                      .addMethod(getCreateFeatureMethod())
                      .addMethod(getGetFeatureMethod())
                      .addMethod(getListFeaturesMethod())
                      .addMethod(getUpdateFeatureMethod())
                      .addMethod(getDeleteFeatureMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
