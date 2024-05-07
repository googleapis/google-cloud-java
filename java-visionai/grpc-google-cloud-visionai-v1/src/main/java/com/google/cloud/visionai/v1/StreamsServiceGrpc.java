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
package com.google.cloud.visionai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * Vision API and Vision AI API are two independent APIs developed by the same
 * team. Vision API is for people to annotate their image while Vision AI is an
 * e2e solution for customer to build their own computer vision application.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/visionai/v1/streams_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StreamsServiceGrpc {

  private StreamsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.visionai.v1.StreamsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListClustersRequest,
          com.google.cloud.visionai.v1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.visionai.v1.ListClustersRequest.class,
      responseType = com.google.cloud.visionai.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListClustersRequest,
          com.google.cloud.visionai.v1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListClustersRequest,
            com.google.cloud.visionai.v1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = StreamsServiceGrpc.getListClustersMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getListClustersMethod = StreamsServiceGrpc.getListClustersMethod) == null) {
          StreamsServiceGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListClustersRequest,
                          com.google.cloud.visionai.v1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetClusterRequest, com.google.cloud.visionai.v1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.visionai.v1.GetClusterRequest.class,
      responseType = com.google.cloud.visionai.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetClusterRequest, com.google.cloud.visionai.v1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetClusterRequest, com.google.cloud.visionai.v1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = StreamsServiceGrpc.getGetClusterMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGetClusterMethod = StreamsServiceGrpc.getGetClusterMethod) == null) {
          StreamsServiceGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetClusterRequest,
                          com.google.cloud.visionai.v1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetClusterRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.visionai.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = StreamsServiceGrpc.getCreateClusterMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getCreateClusterMethod = StreamsServiceGrpc.getCreateClusterMethod) == null) {
          StreamsServiceGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.visionai.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = StreamsServiceGrpc.getUpdateClusterMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getUpdateClusterMethod = StreamsServiceGrpc.getUpdateClusterMethod) == null) {
          StreamsServiceGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.visionai.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = StreamsServiceGrpc.getDeleteClusterMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getDeleteClusterMethod = StreamsServiceGrpc.getDeleteClusterMethod) == null) {
          StreamsServiceGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListStreamsRequest,
          com.google.cloud.visionai.v1.ListStreamsResponse>
      getListStreamsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStreams",
      requestType = com.google.cloud.visionai.v1.ListStreamsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListStreamsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListStreamsRequest,
          com.google.cloud.visionai.v1.ListStreamsResponse>
      getListStreamsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListStreamsRequest,
            com.google.cloud.visionai.v1.ListStreamsResponse>
        getListStreamsMethod;
    if ((getListStreamsMethod = StreamsServiceGrpc.getListStreamsMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getListStreamsMethod = StreamsServiceGrpc.getListStreamsMethod) == null) {
          StreamsServiceGrpc.getListStreamsMethod =
              getListStreamsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListStreamsRequest,
                          com.google.cloud.visionai.v1.ListStreamsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStreams"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListStreamsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListStreamsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("ListStreams"))
                      .build();
        }
      }
    }
    return getListStreamsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetStreamRequest, com.google.cloud.visionai.v1.Stream>
      getGetStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStream",
      requestType = com.google.cloud.visionai.v1.GetStreamRequest.class,
      responseType = com.google.cloud.visionai.v1.Stream.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetStreamRequest, com.google.cloud.visionai.v1.Stream>
      getGetStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetStreamRequest, com.google.cloud.visionai.v1.Stream>
        getGetStreamMethod;
    if ((getGetStreamMethod = StreamsServiceGrpc.getGetStreamMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGetStreamMethod = StreamsServiceGrpc.getGetStreamMethod) == null) {
          StreamsServiceGrpc.getGetStreamMethod =
              getGetStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetStreamRequest,
                          com.google.cloud.visionai.v1.Stream>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetStreamRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Stream.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("GetStream"))
                      .build();
        }
      }
    }
    return getGetStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateStreamRequest, com.google.longrunning.Operation>
      getCreateStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStream",
      requestType = com.google.cloud.visionai.v1.CreateStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateStreamRequest, com.google.longrunning.Operation>
      getCreateStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateStreamRequest, com.google.longrunning.Operation>
        getCreateStreamMethod;
    if ((getCreateStreamMethod = StreamsServiceGrpc.getCreateStreamMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getCreateStreamMethod = StreamsServiceGrpc.getCreateStreamMethod) == null) {
          StreamsServiceGrpc.getCreateStreamMethod =
              getCreateStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateStreamRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("CreateStream"))
                      .build();
        }
      }
    }
    return getCreateStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateStreamRequest, com.google.longrunning.Operation>
      getUpdateStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateStream",
      requestType = com.google.cloud.visionai.v1.UpdateStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateStreamRequest, com.google.longrunning.Operation>
      getUpdateStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateStreamRequest, com.google.longrunning.Operation>
        getUpdateStreamMethod;
    if ((getUpdateStreamMethod = StreamsServiceGrpc.getUpdateStreamMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getUpdateStreamMethod = StreamsServiceGrpc.getUpdateStreamMethod) == null) {
          StreamsServiceGrpc.getUpdateStreamMethod =
              getUpdateStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateStreamRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("UpdateStream"))
                      .build();
        }
      }
    }
    return getUpdateStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteStreamRequest, com.google.longrunning.Operation>
      getDeleteStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStream",
      requestType = com.google.cloud.visionai.v1.DeleteStreamRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteStreamRequest, com.google.longrunning.Operation>
      getDeleteStreamMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteStreamRequest, com.google.longrunning.Operation>
        getDeleteStreamMethod;
    if ((getDeleteStreamMethod = StreamsServiceGrpc.getDeleteStreamMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getDeleteStreamMethod = StreamsServiceGrpc.getDeleteStreamMethod) == null) {
          StreamsServiceGrpc.getDeleteStreamMethod =
              getDeleteStreamMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteStreamRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStream"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteStreamRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("DeleteStream"))
                      .build();
        }
      }
    }
    return getDeleteStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetStreamThumbnailRequest, com.google.longrunning.Operation>
      getGetStreamThumbnailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStreamThumbnail",
      requestType = com.google.cloud.visionai.v1.GetStreamThumbnailRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetStreamThumbnailRequest, com.google.longrunning.Operation>
      getGetStreamThumbnailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetStreamThumbnailRequest,
            com.google.longrunning.Operation>
        getGetStreamThumbnailMethod;
    if ((getGetStreamThumbnailMethod = StreamsServiceGrpc.getGetStreamThumbnailMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGetStreamThumbnailMethod = StreamsServiceGrpc.getGetStreamThumbnailMethod)
            == null) {
          StreamsServiceGrpc.getGetStreamThumbnailMethod =
              getGetStreamThumbnailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetStreamThumbnailRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStreamThumbnail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetStreamThumbnailRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("GetStreamThumbnail"))
                      .build();
        }
      }
    }
    return getGetStreamThumbnailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest,
          com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
      getGenerateStreamHlsTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateStreamHlsToken",
      requestType = com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest.class,
      responseType = com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest,
          com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
      getGenerateStreamHlsTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest,
            com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
        getGenerateStreamHlsTokenMethod;
    if ((getGenerateStreamHlsTokenMethod = StreamsServiceGrpc.getGenerateStreamHlsTokenMethod)
        == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGenerateStreamHlsTokenMethod = StreamsServiceGrpc.getGenerateStreamHlsTokenMethod)
            == null) {
          StreamsServiceGrpc.getGenerateStreamHlsTokenMethod =
              getGenerateStreamHlsTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest,
                          com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateStreamHlsToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("GenerateStreamHlsToken"))
                      .build();
        }
      }
    }
    return getGenerateStreamHlsTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListEventsRequest,
          com.google.cloud.visionai.v1.ListEventsResponse>
      getListEventsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEvents",
      requestType = com.google.cloud.visionai.v1.ListEventsRequest.class,
      responseType = com.google.cloud.visionai.v1.ListEventsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListEventsRequest,
          com.google.cloud.visionai.v1.ListEventsResponse>
      getListEventsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListEventsRequest,
            com.google.cloud.visionai.v1.ListEventsResponse>
        getListEventsMethod;
    if ((getListEventsMethod = StreamsServiceGrpc.getListEventsMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getListEventsMethod = StreamsServiceGrpc.getListEventsMethod) == null) {
          StreamsServiceGrpc.getListEventsMethod =
              getListEventsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListEventsRequest,
                          com.google.cloud.visionai.v1.ListEventsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEvents"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListEventsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListEventsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("ListEvents"))
                      .build();
        }
      }
    }
    return getListEventsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetEventRequest, com.google.cloud.visionai.v1.Event>
      getGetEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEvent",
      requestType = com.google.cloud.visionai.v1.GetEventRequest.class,
      responseType = com.google.cloud.visionai.v1.Event.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetEventRequest, com.google.cloud.visionai.v1.Event>
      getGetEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetEventRequest, com.google.cloud.visionai.v1.Event>
        getGetEventMethod;
    if ((getGetEventMethod = StreamsServiceGrpc.getGetEventMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGetEventMethod = StreamsServiceGrpc.getGetEventMethod) == null) {
          StreamsServiceGrpc.getGetEventMethod =
              getGetEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetEventRequest,
                          com.google.cloud.visionai.v1.Event>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Event.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("GetEvent"))
                      .build();
        }
      }
    }
    return getGetEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateEventRequest, com.google.longrunning.Operation>
      getCreateEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEvent",
      requestType = com.google.cloud.visionai.v1.CreateEventRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateEventRequest, com.google.longrunning.Operation>
      getCreateEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateEventRequest, com.google.longrunning.Operation>
        getCreateEventMethod;
    if ((getCreateEventMethod = StreamsServiceGrpc.getCreateEventMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getCreateEventMethod = StreamsServiceGrpc.getCreateEventMethod) == null) {
          StreamsServiceGrpc.getCreateEventMethod =
              getCreateEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateEventRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("CreateEvent"))
                      .build();
        }
      }
    }
    return getCreateEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateEventRequest, com.google.longrunning.Operation>
      getUpdateEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEvent",
      requestType = com.google.cloud.visionai.v1.UpdateEventRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateEventRequest, com.google.longrunning.Operation>
      getUpdateEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateEventRequest, com.google.longrunning.Operation>
        getUpdateEventMethod;
    if ((getUpdateEventMethod = StreamsServiceGrpc.getUpdateEventMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getUpdateEventMethod = StreamsServiceGrpc.getUpdateEventMethod) == null) {
          StreamsServiceGrpc.getUpdateEventMethod =
              getUpdateEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateEventRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("UpdateEvent"))
                      .build();
        }
      }
    }
    return getUpdateEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteEventRequest, com.google.longrunning.Operation>
      getDeleteEventMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEvent",
      requestType = com.google.cloud.visionai.v1.DeleteEventRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteEventRequest, com.google.longrunning.Operation>
      getDeleteEventMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteEventRequest, com.google.longrunning.Operation>
        getDeleteEventMethod;
    if ((getDeleteEventMethod = StreamsServiceGrpc.getDeleteEventMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getDeleteEventMethod = StreamsServiceGrpc.getDeleteEventMethod) == null) {
          StreamsServiceGrpc.getDeleteEventMethod =
              getDeleteEventMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteEventRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEvent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteEventRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("DeleteEvent"))
                      .build();
        }
      }
    }
    return getDeleteEventMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSeriesRequest,
          com.google.cloud.visionai.v1.ListSeriesResponse>
      getListSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSeries",
      requestType = com.google.cloud.visionai.v1.ListSeriesRequest.class,
      responseType = com.google.cloud.visionai.v1.ListSeriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.ListSeriesRequest,
          com.google.cloud.visionai.v1.ListSeriesResponse>
      getListSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.ListSeriesRequest,
            com.google.cloud.visionai.v1.ListSeriesResponse>
        getListSeriesMethod;
    if ((getListSeriesMethod = StreamsServiceGrpc.getListSeriesMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getListSeriesMethod = StreamsServiceGrpc.getListSeriesMethod) == null) {
          StreamsServiceGrpc.getListSeriesMethod =
              getListSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.ListSeriesRequest,
                          com.google.cloud.visionai.v1.ListSeriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSeriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.ListSeriesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("ListSeries"))
                      .build();
        }
      }
    }
    return getListSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSeriesRequest, com.google.cloud.visionai.v1.Series>
      getGetSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSeries",
      requestType = com.google.cloud.visionai.v1.GetSeriesRequest.class,
      responseType = com.google.cloud.visionai.v1.Series.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.GetSeriesRequest, com.google.cloud.visionai.v1.Series>
      getGetSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.GetSeriesRequest, com.google.cloud.visionai.v1.Series>
        getGetSeriesMethod;
    if ((getGetSeriesMethod = StreamsServiceGrpc.getGetSeriesMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getGetSeriesMethod = StreamsServiceGrpc.getGetSeriesMethod) == null) {
          StreamsServiceGrpc.getGetSeriesMethod =
              getGetSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.GetSeriesRequest,
                          com.google.cloud.visionai.v1.Series>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.GetSeriesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.Series.getDefaultInstance()))
                      .setSchemaDescriptor(new StreamsServiceMethodDescriptorSupplier("GetSeries"))
                      .build();
        }
      }
    }
    return getGetSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSeriesRequest, com.google.longrunning.Operation>
      getCreateSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSeries",
      requestType = com.google.cloud.visionai.v1.CreateSeriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.CreateSeriesRequest, com.google.longrunning.Operation>
      getCreateSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.CreateSeriesRequest, com.google.longrunning.Operation>
        getCreateSeriesMethod;
    if ((getCreateSeriesMethod = StreamsServiceGrpc.getCreateSeriesMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getCreateSeriesMethod = StreamsServiceGrpc.getCreateSeriesMethod) == null) {
          StreamsServiceGrpc.getCreateSeriesMethod =
              getCreateSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.CreateSeriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.CreateSeriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("CreateSeries"))
                      .build();
        }
      }
    }
    return getCreateSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSeriesRequest, com.google.longrunning.Operation>
      getUpdateSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSeries",
      requestType = com.google.cloud.visionai.v1.UpdateSeriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.UpdateSeriesRequest, com.google.longrunning.Operation>
      getUpdateSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.UpdateSeriesRequest, com.google.longrunning.Operation>
        getUpdateSeriesMethod;
    if ((getUpdateSeriesMethod = StreamsServiceGrpc.getUpdateSeriesMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getUpdateSeriesMethod = StreamsServiceGrpc.getUpdateSeriesMethod) == null) {
          StreamsServiceGrpc.getUpdateSeriesMethod =
              getUpdateSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.UpdateSeriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.UpdateSeriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("UpdateSeries"))
                      .build();
        }
      }
    }
    return getUpdateSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSeriesRequest, com.google.longrunning.Operation>
      getDeleteSeriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSeries",
      requestType = com.google.cloud.visionai.v1.DeleteSeriesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.DeleteSeriesRequest, com.google.longrunning.Operation>
      getDeleteSeriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.DeleteSeriesRequest, com.google.longrunning.Operation>
        getDeleteSeriesMethod;
    if ((getDeleteSeriesMethod = StreamsServiceGrpc.getDeleteSeriesMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getDeleteSeriesMethod = StreamsServiceGrpc.getDeleteSeriesMethod) == null) {
          StreamsServiceGrpc.getDeleteSeriesMethod =
              getDeleteSeriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.DeleteSeriesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSeries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.DeleteSeriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("DeleteSeries"))
                      .build();
        }
      }
    }
    return getDeleteSeriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.MaterializeChannelRequest, com.google.longrunning.Operation>
      getMaterializeChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "MaterializeChannel",
      requestType = com.google.cloud.visionai.v1.MaterializeChannelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.visionai.v1.MaterializeChannelRequest, com.google.longrunning.Operation>
      getMaterializeChannelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.visionai.v1.MaterializeChannelRequest,
            com.google.longrunning.Operation>
        getMaterializeChannelMethod;
    if ((getMaterializeChannelMethod = StreamsServiceGrpc.getMaterializeChannelMethod) == null) {
      synchronized (StreamsServiceGrpc.class) {
        if ((getMaterializeChannelMethod = StreamsServiceGrpc.getMaterializeChannelMethod)
            == null) {
          StreamsServiceGrpc.getMaterializeChannelMethod =
              getMaterializeChannelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.visionai.v1.MaterializeChannelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "MaterializeChannel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.visionai.v1.MaterializeChannelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new StreamsServiceMethodDescriptorSupplier("MaterializeChannel"))
                      .build();
        }
      }
    }
    return getMaterializeChannelMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static StreamsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamsServiceStub>() {
          @java.lang.Override
          public StreamsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamsServiceStub(channel, callOptions);
          }
        };
    return StreamsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamsServiceBlockingStub>() {
          @java.lang.Override
          public StreamsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamsServiceBlockingStub(channel, callOptions);
          }
        };
    return StreamsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static StreamsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StreamsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<StreamsServiceFutureStub>() {
          @java.lang.Override
          public StreamsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new StreamsServiceFutureStub(channel, callOptions);
          }
        };
    return StreamsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * Vision API and Vision AI API are two independent APIs developed by the same
   * team. Vision API is for people to annotate their image while Vision AI is an
   * e2e solution for customer to build their own computer vision application.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.visionai.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.visionai.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    default void createCluster(
        com.google.cloud.visionai.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.visionai.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.visionai.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Streams in a given project and location.
     * </pre>
     */
    default void listStreams(
        com.google.cloud.visionai.v1.ListStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListStreamsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStreamsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Stream.
     * </pre>
     */
    default void getStream(
        com.google.cloud.visionai.v1.GetStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Stream> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Stream in a given project and location.
     * </pre>
     */
    default void createStream(
        com.google.cloud.visionai.v1.CreateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Stream.
     * </pre>
     */
    default void updateStream(
        com.google.cloud.visionai.v1.UpdateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Stream.
     * </pre>
     */
    default void deleteStream(
        com.google.cloud.visionai.v1.DeleteStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteStreamMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the thumbnail (image snapshot) of a single Stream.
     * </pre>
     */
    default void getStreamThumbnail(
        com.google.cloud.visionai.v1.GetStreamThumbnailRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetStreamThumbnailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate the JWT auth token required to get the stream HLS contents.
     * </pre>
     */
    default void generateStreamHlsToken(
        com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateStreamHlsTokenMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Events in a given project and location.
     * </pre>
     */
    default void listEvents(
        com.google.cloud.visionai.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListEventsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Event.
     * </pre>
     */
    default void getEvent(
        com.google.cloud.visionai.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Event> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Event in a given project and location.
     * </pre>
     */
    default void createEvent(
        com.google.cloud.visionai.v1.CreateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    default void updateEvent(
        com.google.cloud.visionai.v1.UpdateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Event.
     * </pre>
     */
    default void deleteEvent(
        com.google.cloud.visionai.v1.DeleteEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEventMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Series in a given project and location.
     * </pre>
     */
    default void listSeries(
        com.google.cloud.visionai.v1.ListSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSeriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSeriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Series.
     * </pre>
     */
    default void getSeries(
        com.google.cloud.visionai.v1.GetSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Series> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSeriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Series in a given project and location.
     * </pre>
     */
    default void createSeries(
        com.google.cloud.visionai.v1.CreateSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSeriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    default void updateSeries(
        com.google.cloud.visionai.v1.UpdateSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSeriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Series.
     * </pre>
     */
    default void deleteSeries(
        com.google.cloud.visionai.v1.DeleteSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSeriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Materialize a channel.
     * </pre>
     */
    default void materializeChannel(
        com.google.cloud.visionai.v1.MaterializeChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getMaterializeChannelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service StreamsService.
   *
   * <pre>
   * Service describing handlers for resources.
   * Vision API and Vision AI API are two independent APIs developed by the same
   * team. Vision API is for people to annotate their image while Vision AI is an
   * e2e solution for customer to build their own computer vision application.
   * </pre>
   */
  public abstract static class StreamsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return StreamsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service StreamsService.
   *
   * <pre>
   * Service describing handlers for resources.
   * Vision API and Vision AI API are two independent APIs developed by the same
   * team. Vision API is for people to annotate their image while Vision AI is an
   * e2e solution for customer to build their own computer vision application.
   * </pre>
   */
  public static final class StreamsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<StreamsServiceStub> {
    private StreamsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamsServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.visionai.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.visionai.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public void createCluster(
        com.google.cloud.visionai.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.visionai.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.visionai.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Streams in a given project and location.
     * </pre>
     */
    public void listStreams(
        com.google.cloud.visionai.v1.ListStreamsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListStreamsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStreamsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Stream.
     * </pre>
     */
    public void getStream(
        com.google.cloud.visionai.v1.GetStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Stream> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Stream in a given project and location.
     * </pre>
     */
    public void createStream(
        com.google.cloud.visionai.v1.CreateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Stream.
     * </pre>
     */
    public void updateStream(
        com.google.cloud.visionai.v1.UpdateStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Stream.
     * </pre>
     */
    public void deleteStream(
        com.google.cloud.visionai.v1.DeleteStreamRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStreamMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the thumbnail (image snapshot) of a single Stream.
     * </pre>
     */
    public void getStreamThumbnail(
        com.google.cloud.visionai.v1.GetStreamThumbnailRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStreamThumbnailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generate the JWT auth token required to get the stream HLS contents.
     * </pre>
     */
    public void generateStreamHlsToken(
        com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateStreamHlsTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Events in a given project and location.
     * </pre>
     */
    public void listEvents(
        com.google.cloud.visionai.v1.ListEventsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListEventsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Event.
     * </pre>
     */
    public void getEvent(
        com.google.cloud.visionai.v1.GetEventRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Event> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Event in a given project and location.
     * </pre>
     */
    public void createEvent(
        com.google.cloud.visionai.v1.CreateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public void updateEvent(
        com.google.cloud.visionai.v1.UpdateEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Event.
     * </pre>
     */
    public void deleteEvent(
        com.google.cloud.visionai.v1.DeleteEventRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Series in a given project and location.
     * </pre>
     */
    public void listSeries(
        com.google.cloud.visionai.v1.ListSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSeriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Series.
     * </pre>
     */
    public void getSeries(
        com.google.cloud.visionai.v1.GetSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Series> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSeriesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Series in a given project and location.
     * </pre>
     */
    public void createSeries(
        com.google.cloud.visionai.v1.CreateSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSeriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public void updateSeries(
        com.google.cloud.visionai.v1.UpdateSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSeriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Series.
     * </pre>
     */
    public void deleteSeries(
        com.google.cloud.visionai.v1.DeleteSeriesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSeriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Materialize a channel.
     * </pre>
     */
    public void materializeChannel(
        com.google.cloud.visionai.v1.MaterializeChannelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getMaterializeChannelMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service StreamsService.
   *
   * <pre>
   * Service describing handlers for resources.
   * Vision API and Vision AI API are two independent APIs developed by the same
   * team. Vision API is for people to annotate their image while Vision AI is an
   * e2e solution for customer to build their own computer vision application.
   * </pre>
   */
  public static final class StreamsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<StreamsServiceBlockingStub> {
    private StreamsServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListClustersResponse listClusters(
        com.google.cloud.visionai.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Cluster getCluster(
        com.google.cloud.visionai.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.visionai.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.visionai.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.visionai.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Streams in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListStreamsResponse listStreams(
        com.google.cloud.visionai.v1.ListStreamsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStreamsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Stream.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Stream getStream(
        com.google.cloud.visionai.v1.GetStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Stream in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createStream(
        com.google.cloud.visionai.v1.CreateStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Stream.
     * </pre>
     */
    public com.google.longrunning.Operation updateStream(
        com.google.cloud.visionai.v1.UpdateStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Stream.
     * </pre>
     */
    public com.google.longrunning.Operation deleteStream(
        com.google.cloud.visionai.v1.DeleteStreamRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStreamMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the thumbnail (image snapshot) of a single Stream.
     * </pre>
     */
    public com.google.longrunning.Operation getStreamThumbnail(
        com.google.cloud.visionai.v1.GetStreamThumbnailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStreamThumbnailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generate the JWT auth token required to get the stream HLS contents.
     * </pre>
     */
    public com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse generateStreamHlsToken(
        com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateStreamHlsTokenMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Events in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListEventsResponse listEvents(
        com.google.cloud.visionai.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEventsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Event.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Event getEvent(
        com.google.cloud.visionai.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Event in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createEvent(
        com.google.cloud.visionai.v1.CreateEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public com.google.longrunning.Operation updateEvent(
        com.google.cloud.visionai.v1.UpdateEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Event.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEvent(
        com.google.cloud.visionai.v1.DeleteEventRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEventMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Series in a given project and location.
     * </pre>
     */
    public com.google.cloud.visionai.v1.ListSeriesResponse listSeries(
        com.google.cloud.visionai.v1.ListSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSeriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Series.
     * </pre>
     */
    public com.google.cloud.visionai.v1.Series getSeries(
        com.google.cloud.visionai.v1.GetSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSeriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Series in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createSeries(
        com.google.cloud.visionai.v1.CreateSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSeriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public com.google.longrunning.Operation updateSeries(
        com.google.cloud.visionai.v1.UpdateSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSeriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Series.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSeries(
        com.google.cloud.visionai.v1.DeleteSeriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSeriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Materialize a channel.
     * </pre>
     */
    public com.google.longrunning.Operation materializeChannel(
        com.google.cloud.visionai.v1.MaterializeChannelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getMaterializeChannelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service StreamsService.
   *
   * <pre>
   * Service describing handlers for resources.
   * Vision API and Vision AI API are two independent APIs developed by the same
   * team. Vision API is for people to annotate their image while Vision AI is an
   * e2e solution for customer to build their own computer vision application.
   * </pre>
   */
  public static final class StreamsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<StreamsServiceFutureStub> {
    private StreamsServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StreamsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListClustersResponse>
        listClusters(com.google.cloud.visionai.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Cluster>
        getCluster(com.google.cloud.visionai.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.visionai.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.visionai.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.visionai.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Streams in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListStreamsResponse>
        listStreams(com.google.cloud.visionai.v1.ListStreamsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStreamsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Stream>
        getStream(com.google.cloud.visionai.v1.GetStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Stream in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createStream(com.google.cloud.visionai.v1.CreateStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateStream(com.google.cloud.visionai.v1.UpdateStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteStream(com.google.cloud.visionai.v1.DeleteStreamRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStreamMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the thumbnail (image snapshot) of a single Stream.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        getStreamThumbnail(com.google.cloud.visionai.v1.GetStreamThumbnailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStreamThumbnailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generate the JWT auth token required to get the stream HLS contents.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>
        generateStreamHlsToken(com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateStreamHlsTokenMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Events in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListEventsResponse>
        listEvents(com.google.cloud.visionai.v1.ListEventsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEventsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Event>
        getEvent(com.google.cloud.visionai.v1.GetEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Event in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEvent(com.google.cloud.visionai.v1.CreateEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEvent(com.google.cloud.visionai.v1.UpdateEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEvent(com.google.cloud.visionai.v1.DeleteEventRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEventMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Series in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.visionai.v1.ListSeriesResponse>
        listSeries(com.google.cloud.visionai.v1.ListSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSeriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Series.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.visionai.v1.Series>
        getSeries(com.google.cloud.visionai.v1.GetSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSeriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Series in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createSeries(com.google.cloud.visionai.v1.CreateSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSeriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Event.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateSeries(com.google.cloud.visionai.v1.UpdateSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSeriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Series.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSeries(com.google.cloud.visionai.v1.DeleteSeriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSeriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Materialize a channel.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        materializeChannel(com.google.cloud.visionai.v1.MaterializeChannelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getMaterializeChannelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_DELETE_CLUSTER = 4;
  private static final int METHODID_LIST_STREAMS = 5;
  private static final int METHODID_GET_STREAM = 6;
  private static final int METHODID_CREATE_STREAM = 7;
  private static final int METHODID_UPDATE_STREAM = 8;
  private static final int METHODID_DELETE_STREAM = 9;
  private static final int METHODID_GET_STREAM_THUMBNAIL = 10;
  private static final int METHODID_GENERATE_STREAM_HLS_TOKEN = 11;
  private static final int METHODID_LIST_EVENTS = 12;
  private static final int METHODID_GET_EVENT = 13;
  private static final int METHODID_CREATE_EVENT = 14;
  private static final int METHODID_UPDATE_EVENT = 15;
  private static final int METHODID_DELETE_EVENT = 16;
  private static final int METHODID_LIST_SERIES = 17;
  private static final int METHODID_GET_SERIES = 18;
  private static final int METHODID_CREATE_SERIES = 19;
  private static final int METHODID_UPDATE_SERIES = 20;
  private static final int METHODID_DELETE_SERIES = 21;
  private static final int METHODID_MATERIALIZE_CHANNEL = 22;

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
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.visionai.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.visionai.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Cluster>) responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.visionai.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.visionai.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.visionai.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_STREAMS:
          serviceImpl.listStreams(
              (com.google.cloud.visionai.v1.ListStreamsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListStreamsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_STREAM:
          serviceImpl.getStream(
              (com.google.cloud.visionai.v1.GetStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Stream>) responseObserver);
          break;
        case METHODID_CREATE_STREAM:
          serviceImpl.createStream(
              (com.google.cloud.visionai.v1.CreateStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_STREAM:
          serviceImpl.updateStream(
              (com.google.cloud.visionai.v1.UpdateStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_STREAM:
          serviceImpl.deleteStream(
              (com.google.cloud.visionai.v1.DeleteStreamRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_STREAM_THUMBNAIL:
          serviceImpl.getStreamThumbnail(
              (com.google.cloud.visionai.v1.GetStreamThumbnailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GENERATE_STREAM_HLS_TOKEN:
          serviceImpl.generateStreamHlsToken(
              (com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_EVENTS:
          serviceImpl.listEvents(
              (com.google.cloud.visionai.v1.ListEventsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListEventsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EVENT:
          serviceImpl.getEvent(
              (com.google.cloud.visionai.v1.GetEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Event>) responseObserver);
          break;
        case METHODID_CREATE_EVENT:
          serviceImpl.createEvent(
              (com.google.cloud.visionai.v1.CreateEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_EVENT:
          serviceImpl.updateEvent(
              (com.google.cloud.visionai.v1.UpdateEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_EVENT:
          serviceImpl.deleteEvent(
              (com.google.cloud.visionai.v1.DeleteEventRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_SERIES:
          serviceImpl.listSeries(
              (com.google.cloud.visionai.v1.ListSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.ListSeriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERIES:
          serviceImpl.getSeries(
              (com.google.cloud.visionai.v1.GetSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.visionai.v1.Series>) responseObserver);
          break;
        case METHODID_CREATE_SERIES:
          serviceImpl.createSeries(
              (com.google.cloud.visionai.v1.CreateSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_SERIES:
          serviceImpl.updateSeries(
              (com.google.cloud.visionai.v1.UpdateSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_SERIES:
          serviceImpl.deleteSeries(
              (com.google.cloud.visionai.v1.DeleteSeriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_MATERIALIZE_CHANNEL:
          serviceImpl.materializeChannel(
              (com.google.cloud.visionai.v1.MaterializeChannelRequest) request,
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
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListClustersRequest,
                    com.google.cloud.visionai.v1.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetClusterRequest,
                    com.google.cloud.visionai.v1.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getListStreamsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListStreamsRequest,
                    com.google.cloud.visionai.v1.ListStreamsResponse>(
                    service, METHODID_LIST_STREAMS)))
        .addMethod(
            getGetStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetStreamRequest,
                    com.google.cloud.visionai.v1.Stream>(service, METHODID_GET_STREAM)))
        .addMethod(
            getCreateStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateStreamRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_STREAM)))
        .addMethod(
            getUpdateStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateStreamRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_STREAM)))
        .addMethod(
            getDeleteStreamMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteStreamRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_STREAM)))
        .addMethod(
            getGetStreamThumbnailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetStreamThumbnailRequest,
                    com.google.longrunning.Operation>(service, METHODID_GET_STREAM_THUMBNAIL)))
        .addMethod(
            getGenerateStreamHlsTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GenerateStreamHlsTokenRequest,
                    com.google.cloud.visionai.v1.GenerateStreamHlsTokenResponse>(
                    service, METHODID_GENERATE_STREAM_HLS_TOKEN)))
        .addMethod(
            getListEventsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListEventsRequest,
                    com.google.cloud.visionai.v1.ListEventsResponse>(
                    service, METHODID_LIST_EVENTS)))
        .addMethod(
            getGetEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetEventRequest,
                    com.google.cloud.visionai.v1.Event>(service, METHODID_GET_EVENT)))
        .addMethod(
            getCreateEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateEventRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_EVENT)))
        .addMethod(
            getUpdateEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateEventRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_EVENT)))
        .addMethod(
            getDeleteEventMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteEventRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_EVENT)))
        .addMethod(
            getListSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.ListSeriesRequest,
                    com.google.cloud.visionai.v1.ListSeriesResponse>(
                    service, METHODID_LIST_SERIES)))
        .addMethod(
            getGetSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.GetSeriesRequest,
                    com.google.cloud.visionai.v1.Series>(service, METHODID_GET_SERIES)))
        .addMethod(
            getCreateSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.CreateSeriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_SERIES)))
        .addMethod(
            getUpdateSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.UpdateSeriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_SERIES)))
        .addMethod(
            getDeleteSeriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.DeleteSeriesRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SERIES)))
        .addMethod(
            getMaterializeChannelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.visionai.v1.MaterializeChannelRequest,
                    com.google.longrunning.Operation>(service, METHODID_MATERIALIZE_CHANNEL)))
        .build();
  }

  private abstract static class StreamsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.visionai.v1.StreamsServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamsService");
    }
  }

  private static final class StreamsServiceFileDescriptorSupplier
      extends StreamsServiceBaseDescriptorSupplier {
    StreamsServiceFileDescriptorSupplier() {}
  }

  private static final class StreamsServiceMethodDescriptorSupplier
      extends StreamsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    StreamsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (StreamsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new StreamsServiceFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getListStreamsMethod())
                      .addMethod(getGetStreamMethod())
                      .addMethod(getCreateStreamMethod())
                      .addMethod(getUpdateStreamMethod())
                      .addMethod(getDeleteStreamMethod())
                      .addMethod(getGetStreamThumbnailMethod())
                      .addMethod(getGenerateStreamHlsTokenMethod())
                      .addMethod(getListEventsMethod())
                      .addMethod(getGetEventMethod())
                      .addMethod(getCreateEventMethod())
                      .addMethod(getUpdateEventMethod())
                      .addMethod(getDeleteEventMethod())
                      .addMethod(getListSeriesMethod())
                      .addMethod(getGetSeriesMethod())
                      .addMethod(getCreateSeriesMethod())
                      .addMethod(getUpdateSeriesMethod())
                      .addMethod(getDeleteSeriesMethod())
                      .addMethod(getMaterializeChannelMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
