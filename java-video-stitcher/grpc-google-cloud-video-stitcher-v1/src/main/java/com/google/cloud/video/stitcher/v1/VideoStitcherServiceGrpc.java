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
package com.google.cloud.video.stitcher.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Video-On-Demand content stitching API allows you to insert ads
 * into (VoD) video on demand files. You will be able to render custom
 * scrubber bars with highlighted ads, enforce ad policies, allow
 * seamless playback and tracking on native players and monetize
 * content with any standard VMAP compliant ad server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/video/stitcher/v1/video_stitcher_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VideoStitcherServiceGrpc {

  private VideoStitcherServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.video.stitcher.v1.VideoStitcherService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getCreateCdnKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCdnKey",
      requestType = com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.CdnKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getCreateCdnKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest,
            com.google.cloud.video.stitcher.v1.CdnKey>
        getCreateCdnKeyMethod;
    if ((getCreateCdnKeyMethod = VideoStitcherServiceGrpc.getCreateCdnKeyMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getCreateCdnKeyMethod = VideoStitcherServiceGrpc.getCreateCdnKeyMethod) == null) {
          VideoStitcherServiceGrpc.getCreateCdnKeyMethod =
              getCreateCdnKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest,
                          com.google.cloud.video.stitcher.v1.CdnKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCdnKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CdnKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("CreateCdnKey"))
                      .build();
        }
      }
    }
    return getCreateCdnKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListCdnKeysRequest,
          com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
      getListCdnKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCdnKeys",
      requestType = com.google.cloud.video.stitcher.v1.ListCdnKeysRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.ListCdnKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListCdnKeysRequest,
          com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
      getListCdnKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.ListCdnKeysRequest,
            com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
        getListCdnKeysMethod;
    if ((getListCdnKeysMethod = VideoStitcherServiceGrpc.getListCdnKeysMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getListCdnKeysMethod = VideoStitcherServiceGrpc.getListCdnKeysMethod) == null) {
          VideoStitcherServiceGrpc.getListCdnKeysMethod =
              getListCdnKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.ListCdnKeysRequest,
                          com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCdnKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListCdnKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListCdnKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("ListCdnKeys"))
                      .build();
        }
      }
    }
    return getListCdnKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getGetCdnKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCdnKey",
      requestType = com.google.cloud.video.stitcher.v1.GetCdnKeyRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.CdnKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getGetCdnKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetCdnKeyRequest,
            com.google.cloud.video.stitcher.v1.CdnKey>
        getGetCdnKeyMethod;
    if ((getGetCdnKeyMethod = VideoStitcherServiceGrpc.getGetCdnKeyMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetCdnKeyMethod = VideoStitcherServiceGrpc.getGetCdnKeyMethod) == null) {
          VideoStitcherServiceGrpc.getGetCdnKeyMethod =
              getGetCdnKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetCdnKeyRequest,
                          com.google.cloud.video.stitcher.v1.CdnKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCdnKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetCdnKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CdnKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetCdnKey"))
                      .build();
        }
      }
    }
    return getGetCdnKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest, com.google.protobuf.Empty>
      getDeleteCdnKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCdnKey",
      requestType = com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest, com.google.protobuf.Empty>
      getDeleteCdnKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest, com.google.protobuf.Empty>
        getDeleteCdnKeyMethod;
    if ((getDeleteCdnKeyMethod = VideoStitcherServiceGrpc.getDeleteCdnKeyMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getDeleteCdnKeyMethod = VideoStitcherServiceGrpc.getDeleteCdnKeyMethod) == null) {
          VideoStitcherServiceGrpc.getDeleteCdnKeyMethod =
              getDeleteCdnKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCdnKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("DeleteCdnKey"))
                      .build();
        }
      }
    }
    return getDeleteCdnKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getUpdateCdnKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCdnKey",
      requestType = com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.CdnKey.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest,
          com.google.cloud.video.stitcher.v1.CdnKey>
      getUpdateCdnKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest,
            com.google.cloud.video.stitcher.v1.CdnKey>
        getUpdateCdnKeyMethod;
    if ((getUpdateCdnKeyMethod = VideoStitcherServiceGrpc.getUpdateCdnKeyMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getUpdateCdnKeyMethod = VideoStitcherServiceGrpc.getUpdateCdnKeyMethod) == null) {
          VideoStitcherServiceGrpc.getUpdateCdnKeyMethod =
              getUpdateCdnKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest,
                          com.google.cloud.video.stitcher.v1.CdnKey>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCdnKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CdnKey.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("UpdateCdnKey"))
                      .build();
        }
      }
    }
    return getUpdateCdnKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateVodSessionRequest,
          com.google.cloud.video.stitcher.v1.VodSession>
      getCreateVodSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVodSession",
      requestType = com.google.cloud.video.stitcher.v1.CreateVodSessionRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.VodSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateVodSessionRequest,
          com.google.cloud.video.stitcher.v1.VodSession>
      getCreateVodSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.CreateVodSessionRequest,
            com.google.cloud.video.stitcher.v1.VodSession>
        getCreateVodSessionMethod;
    if ((getCreateVodSessionMethod = VideoStitcherServiceGrpc.getCreateVodSessionMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getCreateVodSessionMethod = VideoStitcherServiceGrpc.getCreateVodSessionMethod)
            == null) {
          VideoStitcherServiceGrpc.getCreateVodSessionMethod =
              getCreateVodSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.CreateVodSessionRequest,
                          com.google.cloud.video.stitcher.v1.VodSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVodSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CreateVodSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.VodSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("CreateVodSession"))
                      .build();
        }
      }
    }
    return getCreateVodSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodSessionRequest,
          com.google.cloud.video.stitcher.v1.VodSession>
      getGetVodSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVodSession",
      requestType = com.google.cloud.video.stitcher.v1.GetVodSessionRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.VodSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodSessionRequest,
          com.google.cloud.video.stitcher.v1.VodSession>
      getGetVodSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetVodSessionRequest,
            com.google.cloud.video.stitcher.v1.VodSession>
        getGetVodSessionMethod;
    if ((getGetVodSessionMethod = VideoStitcherServiceGrpc.getGetVodSessionMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetVodSessionMethod = VideoStitcherServiceGrpc.getGetVodSessionMethod) == null) {
          VideoStitcherServiceGrpc.getGetVodSessionMethod =
              getGetVodSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetVodSessionRequest,
                          com.google.cloud.video.stitcher.v1.VodSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVodSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetVodSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.VodSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetVodSession"))
                      .build();
        }
      }
    }
    return getGetVodSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
      getListVodStitchDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVodStitchDetails",
      requestType = com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
      getListVodStitchDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest,
            com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
        getListVodStitchDetailsMethod;
    if ((getListVodStitchDetailsMethod = VideoStitcherServiceGrpc.getListVodStitchDetailsMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getListVodStitchDetailsMethod = VideoStitcherServiceGrpc.getListVodStitchDetailsMethod)
            == null) {
          VideoStitcherServiceGrpc.getListVodStitchDetailsMethod =
              getListVodStitchDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest,
                          com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVodStitchDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("ListVodStitchDetails"))
                      .build();
        }
      }
    }
    return getListVodStitchDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest,
          com.google.cloud.video.stitcher.v1.VodStitchDetail>
      getGetVodStitchDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVodStitchDetail",
      requestType = com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.VodStitchDetail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest,
          com.google.cloud.video.stitcher.v1.VodStitchDetail>
      getGetVodStitchDetailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest,
            com.google.cloud.video.stitcher.v1.VodStitchDetail>
        getGetVodStitchDetailMethod;
    if ((getGetVodStitchDetailMethod = VideoStitcherServiceGrpc.getGetVodStitchDetailMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetVodStitchDetailMethod = VideoStitcherServiceGrpc.getGetVodStitchDetailMethod)
            == null) {
          VideoStitcherServiceGrpc.getGetVodStitchDetailMethod =
              getGetVodStitchDetailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest,
                          com.google.cloud.video.stitcher.v1.VodStitchDetail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVodStitchDetail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.VodStitchDetail
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetVodStitchDetail"))
                      .build();
        }
      }
    }
    return getGetVodStitchDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
      getListVodAdTagDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVodAdTagDetails",
      requestType = com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
      getListVodAdTagDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest,
            com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
        getListVodAdTagDetailsMethod;
    if ((getListVodAdTagDetailsMethod = VideoStitcherServiceGrpc.getListVodAdTagDetailsMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getListVodAdTagDetailsMethod = VideoStitcherServiceGrpc.getListVodAdTagDetailsMethod)
            == null) {
          VideoStitcherServiceGrpc.getListVodAdTagDetailsMethod =
              getListVodAdTagDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest,
                          com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListVodAdTagDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("ListVodAdTagDetails"))
                      .build();
        }
      }
    }
    return getListVodAdTagDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest,
          com.google.cloud.video.stitcher.v1.VodAdTagDetail>
      getGetVodAdTagDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVodAdTagDetail",
      requestType = com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.VodAdTagDetail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest,
          com.google.cloud.video.stitcher.v1.VodAdTagDetail>
      getGetVodAdTagDetailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest,
            com.google.cloud.video.stitcher.v1.VodAdTagDetail>
        getGetVodAdTagDetailMethod;
    if ((getGetVodAdTagDetailMethod = VideoStitcherServiceGrpc.getGetVodAdTagDetailMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetVodAdTagDetailMethod = VideoStitcherServiceGrpc.getGetVodAdTagDetailMethod)
            == null) {
          VideoStitcherServiceGrpc.getGetVodAdTagDetailMethod =
              getGetVodAdTagDetailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest,
                          com.google.cloud.video.stitcher.v1.VodAdTagDetail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVodAdTagDetail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.VodAdTagDetail
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetVodAdTagDetail"))
                      .build();
        }
      }
    }
    return getGetVodAdTagDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
      getListLiveAdTagDetailsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListLiveAdTagDetails",
      requestType = com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest,
          com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
      getListLiveAdTagDetailsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest,
            com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
        getListLiveAdTagDetailsMethod;
    if ((getListLiveAdTagDetailsMethod = VideoStitcherServiceGrpc.getListLiveAdTagDetailsMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getListLiveAdTagDetailsMethod = VideoStitcherServiceGrpc.getListLiveAdTagDetailsMethod)
            == null) {
          VideoStitcherServiceGrpc.getListLiveAdTagDetailsMethod =
              getListLiveAdTagDetailsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest,
                          com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListLiveAdTagDetails"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("ListLiveAdTagDetails"))
                      .build();
        }
      }
    }
    return getListLiveAdTagDetailsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest,
          com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
      getGetLiveAdTagDetailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLiveAdTagDetail",
      requestType = com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.LiveAdTagDetail.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest,
          com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
      getGetLiveAdTagDetailMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest,
            com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
        getGetLiveAdTagDetailMethod;
    if ((getGetLiveAdTagDetailMethod = VideoStitcherServiceGrpc.getGetLiveAdTagDetailMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetLiveAdTagDetailMethod = VideoStitcherServiceGrpc.getGetLiveAdTagDetailMethod)
            == null) {
          VideoStitcherServiceGrpc.getGetLiveAdTagDetailMethod =
              getGetLiveAdTagDetailMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest,
                          com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLiveAdTagDetail"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.LiveAdTagDetail
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetLiveAdTagDetail"))
                      .build();
        }
      }
    }
    return getGetLiveAdTagDetailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getCreateSlateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSlate",
      requestType = com.google.cloud.video.stitcher.v1.CreateSlateRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.Slate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getCreateSlateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.CreateSlateRequest,
            com.google.cloud.video.stitcher.v1.Slate>
        getCreateSlateMethod;
    if ((getCreateSlateMethod = VideoStitcherServiceGrpc.getCreateSlateMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getCreateSlateMethod = VideoStitcherServiceGrpc.getCreateSlateMethod) == null) {
          VideoStitcherServiceGrpc.getCreateSlateMethod =
              getCreateSlateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.CreateSlateRequest,
                          com.google.cloud.video.stitcher.v1.Slate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSlate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CreateSlateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.Slate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("CreateSlate"))
                      .build();
        }
      }
    }
    return getCreateSlateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListSlatesRequest,
          com.google.cloud.video.stitcher.v1.ListSlatesResponse>
      getListSlatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSlates",
      requestType = com.google.cloud.video.stitcher.v1.ListSlatesRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.ListSlatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.ListSlatesRequest,
          com.google.cloud.video.stitcher.v1.ListSlatesResponse>
      getListSlatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.ListSlatesRequest,
            com.google.cloud.video.stitcher.v1.ListSlatesResponse>
        getListSlatesMethod;
    if ((getListSlatesMethod = VideoStitcherServiceGrpc.getListSlatesMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getListSlatesMethod = VideoStitcherServiceGrpc.getListSlatesMethod) == null) {
          VideoStitcherServiceGrpc.getListSlatesMethod =
              getListSlatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.ListSlatesRequest,
                          com.google.cloud.video.stitcher.v1.ListSlatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSlates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListSlatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.ListSlatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("ListSlates"))
                      .build();
        }
      }
    }
    return getListSlatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getGetSlateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSlate",
      requestType = com.google.cloud.video.stitcher.v1.GetSlateRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.Slate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getGetSlateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetSlateRequest,
            com.google.cloud.video.stitcher.v1.Slate>
        getGetSlateMethod;
    if ((getGetSlateMethod = VideoStitcherServiceGrpc.getGetSlateMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetSlateMethod = VideoStitcherServiceGrpc.getGetSlateMethod) == null) {
          VideoStitcherServiceGrpc.getGetSlateMethod =
              getGetSlateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetSlateRequest,
                          com.google.cloud.video.stitcher.v1.Slate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSlate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetSlateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.Slate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetSlate"))
                      .build();
        }
      }
    }
    return getGetSlateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.UpdateSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getUpdateSlateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSlate",
      requestType = com.google.cloud.video.stitcher.v1.UpdateSlateRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.Slate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.UpdateSlateRequest,
          com.google.cloud.video.stitcher.v1.Slate>
      getUpdateSlateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.UpdateSlateRequest,
            com.google.cloud.video.stitcher.v1.Slate>
        getUpdateSlateMethod;
    if ((getUpdateSlateMethod = VideoStitcherServiceGrpc.getUpdateSlateMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getUpdateSlateMethod = VideoStitcherServiceGrpc.getUpdateSlateMethod) == null) {
          VideoStitcherServiceGrpc.getUpdateSlateMethod =
              getUpdateSlateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.UpdateSlateRequest,
                          com.google.cloud.video.stitcher.v1.Slate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSlate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.UpdateSlateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.Slate.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("UpdateSlate"))
                      .build();
        }
      }
    }
    return getUpdateSlateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.DeleteSlateRequest, com.google.protobuf.Empty>
      getDeleteSlateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSlate",
      requestType = com.google.cloud.video.stitcher.v1.DeleteSlateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.DeleteSlateRequest, com.google.protobuf.Empty>
      getDeleteSlateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.DeleteSlateRequest, com.google.protobuf.Empty>
        getDeleteSlateMethod;
    if ((getDeleteSlateMethod = VideoStitcherServiceGrpc.getDeleteSlateMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getDeleteSlateMethod = VideoStitcherServiceGrpc.getDeleteSlateMethod) == null) {
          VideoStitcherServiceGrpc.getDeleteSlateMethod =
              getDeleteSlateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.DeleteSlateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSlate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.DeleteSlateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("DeleteSlate"))
                      .build();
        }
      }
    }
    return getDeleteSlateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest,
          com.google.cloud.video.stitcher.v1.LiveSession>
      getCreateLiveSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateLiveSession",
      requestType = com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.LiveSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest,
          com.google.cloud.video.stitcher.v1.LiveSession>
      getCreateLiveSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest,
            com.google.cloud.video.stitcher.v1.LiveSession>
        getCreateLiveSessionMethod;
    if ((getCreateLiveSessionMethod = VideoStitcherServiceGrpc.getCreateLiveSessionMethod)
        == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getCreateLiveSessionMethod = VideoStitcherServiceGrpc.getCreateLiveSessionMethod)
            == null) {
          VideoStitcherServiceGrpc.getCreateLiveSessionMethod =
              getCreateLiveSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest,
                          com.google.cloud.video.stitcher.v1.LiveSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateLiveSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.LiveSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("CreateLiveSession"))
                      .build();
        }
      }
    }
    return getCreateLiveSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetLiveSessionRequest,
          com.google.cloud.video.stitcher.v1.LiveSession>
      getGetLiveSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLiveSession",
      requestType = com.google.cloud.video.stitcher.v1.GetLiveSessionRequest.class,
      responseType = com.google.cloud.video.stitcher.v1.LiveSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.stitcher.v1.GetLiveSessionRequest,
          com.google.cloud.video.stitcher.v1.LiveSession>
      getGetLiveSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.stitcher.v1.GetLiveSessionRequest,
            com.google.cloud.video.stitcher.v1.LiveSession>
        getGetLiveSessionMethod;
    if ((getGetLiveSessionMethod = VideoStitcherServiceGrpc.getGetLiveSessionMethod) == null) {
      synchronized (VideoStitcherServiceGrpc.class) {
        if ((getGetLiveSessionMethod = VideoStitcherServiceGrpc.getGetLiveSessionMethod) == null) {
          VideoStitcherServiceGrpc.getGetLiveSessionMethod =
              getGetLiveSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.stitcher.v1.GetLiveSessionRequest,
                          com.google.cloud.video.stitcher.v1.LiveSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLiveSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.GetLiveSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.stitcher.v1.LiveSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VideoStitcherServiceMethodDescriptorSupplier("GetLiveSession"))
                      .build();
        }
      }
    }
    return getGetLiveSessionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VideoStitcherServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceStub>() {
          @java.lang.Override
          public VideoStitcherServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VideoStitcherServiceStub(channel, callOptions);
          }
        };
    return VideoStitcherServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VideoStitcherServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceBlockingStub>() {
          @java.lang.Override
          public VideoStitcherServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VideoStitcherServiceBlockingStub(channel, callOptions);
          }
        };
    return VideoStitcherServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VideoStitcherServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VideoStitcherServiceFutureStub>() {
          @java.lang.Override
          public VideoStitcherServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VideoStitcherServiceFutureStub(channel, callOptions);
          }
        };
    return VideoStitcherServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Video-On-Demand content stitching API allows you to insert ads
   * into (VoD) video on demand files. You will be able to render custom
   * scrubber bars with highlighted ads, enforce ad policies, allow
   * seamless playback and tracking on native players and monetize
   * content with any standard VMAP compliant ad server.
   * </pre>
   */
  public abstract static class VideoStitcherServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new CDN key.
     * </pre>
     */
    public void createCdnKey(
        com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCdnKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all CDN keys in the specified project and location.
     * </pre>
     */
    public void listCdnKeys(
        com.google.cloud.video.stitcher.v1.ListCdnKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCdnKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified CDN key.
     * </pre>
     */
    public void getCdnKey(
        com.google.cloud.video.stitcher.v1.GetCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCdnKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified CDN key.
     * </pre>
     */
    public void deleteCdnKey(
        com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCdnKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified CDN key. Only update fields specified
     * in the call method body.
     * </pre>
     */
    public void updateCdnKey(
        com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCdnKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a client side playback VOD session and returns the full
     * tracking and playback metadata of the session.
     * </pre>
     */
    public void createVodSession(
        com.google.cloud.video.stitcher.v1.CreateVodSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVodSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the full tracking, playback metadata, and relevant ad-ops
     * logs for the specified VOD session.
     * </pre>
     */
    public void getVodSession(
        com.google.cloud.video.stitcher.v1.GetVodSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVodSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of detailed stitching information of the specified VOD
     * session.
     * </pre>
     */
    public void listVodStitchDetails(
        com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVodStitchDetailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified stitching information for the specified VOD session.
     * </pre>
     */
    public void getVodStitchDetail(
        com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodStitchDetail>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVodStitchDetailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified VOD session.
     * </pre>
     */
    public void listVodAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVodAdTagDetailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified VOD session.
     * </pre>
     */
    public void getVodAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodAdTagDetail>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVodAdTagDetailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified live session.
     * </pre>
     */
    public void listLiveAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListLiveAdTagDetailsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified live session.
     * </pre>
     */
    public void getLiveAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLiveAdTagDetailMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a slate.
     * </pre>
     */
    public void createSlate(
        com.google.cloud.video.stitcher.v1.CreateSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateSlateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all slates in the specified project and location.
     * </pre>
     */
    public void listSlates(
        com.google.cloud.video.stitcher.v1.ListSlatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListSlatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSlatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified slate.
     * </pre>
     */
    public void getSlate(
        com.google.cloud.video.stitcher.v1.GetSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSlateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified slate.
     * </pre>
     */
    public void updateSlate(
        com.google.cloud.video.stitcher.v1.UpdateSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSlateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified slate.
     * </pre>
     */
    public void deleteSlate(
        com.google.cloud.video.stitcher.v1.DeleteSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteSlateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new live session.
     * </pre>
     */
    public void createLiveSession(
        com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateLiveSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details for the specified live session.
     * </pre>
     */
    public void getLiveSession(
        com.google.cloud.video.stitcher.v1.GetLiveSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetLiveSessionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateCdnKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest,
                      com.google.cloud.video.stitcher.v1.CdnKey>(this, METHODID_CREATE_CDN_KEY)))
          .addMethod(
              getListCdnKeysMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.ListCdnKeysRequest,
                      com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>(
                      this, METHODID_LIST_CDN_KEYS)))
          .addMethod(
              getGetCdnKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetCdnKeyRequest,
                      com.google.cloud.video.stitcher.v1.CdnKey>(this, METHODID_GET_CDN_KEY)))
          .addMethod(
              getDeleteCdnKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CDN_KEY)))
          .addMethod(
              getUpdateCdnKeyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest,
                      com.google.cloud.video.stitcher.v1.CdnKey>(this, METHODID_UPDATE_CDN_KEY)))
          .addMethod(
              getCreateVodSessionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.CreateVodSessionRequest,
                      com.google.cloud.video.stitcher.v1.VodSession>(
                      this, METHODID_CREATE_VOD_SESSION)))
          .addMethod(
              getGetVodSessionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetVodSessionRequest,
                      com.google.cloud.video.stitcher.v1.VodSession>(
                      this, METHODID_GET_VOD_SESSION)))
          .addMethod(
              getListVodStitchDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest,
                      com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>(
                      this, METHODID_LIST_VOD_STITCH_DETAILS)))
          .addMethod(
              getGetVodStitchDetailMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest,
                      com.google.cloud.video.stitcher.v1.VodStitchDetail>(
                      this, METHODID_GET_VOD_STITCH_DETAIL)))
          .addMethod(
              getListVodAdTagDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest,
                      com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>(
                      this, METHODID_LIST_VOD_AD_TAG_DETAILS)))
          .addMethod(
              getGetVodAdTagDetailMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest,
                      com.google.cloud.video.stitcher.v1.VodAdTagDetail>(
                      this, METHODID_GET_VOD_AD_TAG_DETAIL)))
          .addMethod(
              getListLiveAdTagDetailsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest,
                      com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>(
                      this, METHODID_LIST_LIVE_AD_TAG_DETAILS)))
          .addMethod(
              getGetLiveAdTagDetailMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest,
                      com.google.cloud.video.stitcher.v1.LiveAdTagDetail>(
                      this, METHODID_GET_LIVE_AD_TAG_DETAIL)))
          .addMethod(
              getCreateSlateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.CreateSlateRequest,
                      com.google.cloud.video.stitcher.v1.Slate>(this, METHODID_CREATE_SLATE)))
          .addMethod(
              getListSlatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.ListSlatesRequest,
                      com.google.cloud.video.stitcher.v1.ListSlatesResponse>(
                      this, METHODID_LIST_SLATES)))
          .addMethod(
              getGetSlateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetSlateRequest,
                      com.google.cloud.video.stitcher.v1.Slate>(this, METHODID_GET_SLATE)))
          .addMethod(
              getUpdateSlateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.UpdateSlateRequest,
                      com.google.cloud.video.stitcher.v1.Slate>(this, METHODID_UPDATE_SLATE)))
          .addMethod(
              getDeleteSlateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.DeleteSlateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SLATE)))
          .addMethod(
              getCreateLiveSessionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest,
                      com.google.cloud.video.stitcher.v1.LiveSession>(
                      this, METHODID_CREATE_LIVE_SESSION)))
          .addMethod(
              getGetLiveSessionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.stitcher.v1.GetLiveSessionRequest,
                      com.google.cloud.video.stitcher.v1.LiveSession>(
                      this, METHODID_GET_LIVE_SESSION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Video-On-Demand content stitching API allows you to insert ads
   * into (VoD) video on demand files. You will be able to render custom
   * scrubber bars with highlighted ads, enforce ad policies, allow
   * seamless playback and tracking on native players and monetize
   * content with any standard VMAP compliant ad server.
   * </pre>
   */
  public static final class VideoStitcherServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VideoStitcherServiceStub> {
    private VideoStitcherServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoStitcherServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoStitcherServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CDN key.
     * </pre>
     */
    public void createCdnKey(
        com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCdnKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all CDN keys in the specified project and location.
     * </pre>
     */
    public void listCdnKeys(
        com.google.cloud.video.stitcher.v1.ListCdnKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCdnKeysMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified CDN key.
     * </pre>
     */
    public void getCdnKey(
        com.google.cloud.video.stitcher.v1.GetCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCdnKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified CDN key.
     * </pre>
     */
    public void deleteCdnKey(
        com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCdnKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified CDN key. Only update fields specified
     * in the call method body.
     * </pre>
     */
    public void updateCdnKey(
        com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCdnKeyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a client side playback VOD session and returns the full
     * tracking and playback metadata of the session.
     * </pre>
     */
    public void createVodSession(
        com.google.cloud.video.stitcher.v1.CreateVodSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVodSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the full tracking, playback metadata, and relevant ad-ops
     * logs for the specified VOD session.
     * </pre>
     */
    public void getVodSession(
        com.google.cloud.video.stitcher.v1.GetVodSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVodSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of detailed stitching information of the specified VOD
     * session.
     * </pre>
     */
    public void listVodStitchDetails(
        com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVodStitchDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified stitching information for the specified VOD session.
     * </pre>
     */
    public void getVodStitchDetail(
        com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodStitchDetail>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVodStitchDetailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified VOD session.
     * </pre>
     */
    public void listVodAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVodAdTagDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified VOD session.
     * </pre>
     */
    public void getVodAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodAdTagDetail>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVodAdTagDetailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified live session.
     * </pre>
     */
    public void listLiveAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListLiveAdTagDetailsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified live session.
     * </pre>
     */
    public void getLiveAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLiveAdTagDetailMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a slate.
     * </pre>
     */
    public void createSlate(
        com.google.cloud.video.stitcher.v1.CreateSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSlateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all slates in the specified project and location.
     * </pre>
     */
    public void listSlates(
        com.google.cloud.video.stitcher.v1.ListSlatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListSlatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSlatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified slate.
     * </pre>
     */
    public void getSlate(
        com.google.cloud.video.stitcher.v1.GetSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSlateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified slate.
     * </pre>
     */
    public void updateSlate(
        com.google.cloud.video.stitcher.v1.UpdateSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSlateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified slate.
     * </pre>
     */
    public void deleteSlate(
        com.google.cloud.video.stitcher.v1.DeleteSlateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSlateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new live session.
     * </pre>
     */
    public void createLiveSession(
        com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateLiveSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the details for the specified live session.
     * </pre>
     */
    public void getLiveSession(
        com.google.cloud.video.stitcher.v1.GetLiveSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLiveSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Video-On-Demand content stitching API allows you to insert ads
   * into (VoD) video on demand files. You will be able to render custom
   * scrubber bars with highlighted ads, enforce ad policies, allow
   * seamless playback and tracking on native players and monetize
   * content with any standard VMAP compliant ad server.
   * </pre>
   */
  public static final class VideoStitcherServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VideoStitcherServiceBlockingStub> {
    private VideoStitcherServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoStitcherServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoStitcherServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CDN key.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.CdnKey createCdnKey(
        com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCdnKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all CDN keys in the specified project and location.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.ListCdnKeysResponse listCdnKeys(
        com.google.cloud.video.stitcher.v1.ListCdnKeysRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCdnKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified CDN key.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.CdnKey getCdnKey(
        com.google.cloud.video.stitcher.v1.GetCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCdnKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified CDN key.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCdnKey(
        com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCdnKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified CDN key. Only update fields specified
     * in the call method body.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.CdnKey updateCdnKey(
        com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCdnKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a client side playback VOD session and returns the full
     * tracking and playback metadata of the session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.VodSession createVodSession(
        com.google.cloud.video.stitcher.v1.CreateVodSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVodSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the full tracking, playback metadata, and relevant ad-ops
     * logs for the specified VOD session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.VodSession getVodSession(
        com.google.cloud.video.stitcher.v1.GetVodSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVodSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of detailed stitching information of the specified VOD
     * session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse listVodStitchDetails(
        com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVodStitchDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified stitching information for the specified VOD session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.VodStitchDetail getVodStitchDetail(
        com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVodStitchDetailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified VOD session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse listVodAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVodAdTagDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified VOD session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.VodAdTagDetail getVodAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVodAdTagDetailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified live session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse listLiveAdTagDetails(
        com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListLiveAdTagDetailsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified live session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.LiveAdTagDetail getLiveAdTagDetail(
        com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLiveAdTagDetailMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a slate.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.Slate createSlate(
        com.google.cloud.video.stitcher.v1.CreateSlateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSlateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all slates in the specified project and location.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.ListSlatesResponse listSlates(
        com.google.cloud.video.stitcher.v1.ListSlatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSlatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified slate.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.Slate getSlate(
        com.google.cloud.video.stitcher.v1.GetSlateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSlateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified slate.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.Slate updateSlate(
        com.google.cloud.video.stitcher.v1.UpdateSlateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSlateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified slate.
     * </pre>
     */
    public com.google.protobuf.Empty deleteSlate(
        com.google.cloud.video.stitcher.v1.DeleteSlateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSlateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new live session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.LiveSession createLiveSession(
        com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateLiveSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details for the specified live session.
     * </pre>
     */
    public com.google.cloud.video.stitcher.v1.LiveSession getLiveSession(
        com.google.cloud.video.stitcher.v1.GetLiveSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLiveSessionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Video-On-Demand content stitching API allows you to insert ads
   * into (VoD) video on demand files. You will be able to render custom
   * scrubber bars with highlighted ads, enforce ad policies, allow
   * seamless playback and tracking on native players and monetize
   * content with any standard VMAP compliant ad server.
   * </pre>
   */
  public static final class VideoStitcherServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VideoStitcherServiceFutureStub> {
    private VideoStitcherServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VideoStitcherServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VideoStitcherServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new CDN key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.CdnKey>
        createCdnKey(com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCdnKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all CDN keys in the specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>
        listCdnKeys(com.google.cloud.video.stitcher.v1.ListCdnKeysRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCdnKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified CDN key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.CdnKey>
        getCdnKey(com.google.cloud.video.stitcher.v1.GetCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCdnKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified CDN key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCdnKey(com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCdnKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified CDN key. Only update fields specified
     * in the call method body.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.CdnKey>
        updateCdnKey(com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCdnKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a client side playback VOD session and returns the full
     * tracking and playback metadata of the session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.VodSession>
        createVodSession(com.google.cloud.video.stitcher.v1.CreateVodSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVodSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the full tracking, playback metadata, and relevant ad-ops
     * logs for the specified VOD session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.VodSession>
        getVodSession(com.google.cloud.video.stitcher.v1.GetVodSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVodSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns a list of detailed stitching information of the specified VOD
     * session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>
        listVodStitchDetails(
            com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVodStitchDetailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified stitching information for the specified VOD session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.VodStitchDetail>
        getVodStitchDetail(com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVodStitchDetailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified VOD session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>
        listVodAdTagDetails(com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVodAdTagDetailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified VOD session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.VodAdTagDetail>
        getVodAdTagDetail(com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVodAdTagDetailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Return the list of ad tag details for the specified live session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>
        listLiveAdTagDetails(
            com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListLiveAdTagDetailsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified ad tag detail for the specified live session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.LiveAdTagDetail>
        getLiveAdTagDetail(com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLiveAdTagDetailMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a slate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.Slate>
        createSlate(com.google.cloud.video.stitcher.v1.CreateSlateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSlateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all slates in the specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.ListSlatesResponse>
        listSlates(com.google.cloud.video.stitcher.v1.ListSlatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSlatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified slate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.Slate>
        getSlate(com.google.cloud.video.stitcher.v1.GetSlateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSlateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified slate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.Slate>
        updateSlate(com.google.cloud.video.stitcher.v1.UpdateSlateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSlateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified slate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteSlate(com.google.cloud.video.stitcher.v1.DeleteSlateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSlateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new live session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.LiveSession>
        createLiveSession(com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateLiveSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the details for the specified live session.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.stitcher.v1.LiveSession>
        getLiveSession(com.google.cloud.video.stitcher.v1.GetLiveSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLiveSessionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CDN_KEY = 0;
  private static final int METHODID_LIST_CDN_KEYS = 1;
  private static final int METHODID_GET_CDN_KEY = 2;
  private static final int METHODID_DELETE_CDN_KEY = 3;
  private static final int METHODID_UPDATE_CDN_KEY = 4;
  private static final int METHODID_CREATE_VOD_SESSION = 5;
  private static final int METHODID_GET_VOD_SESSION = 6;
  private static final int METHODID_LIST_VOD_STITCH_DETAILS = 7;
  private static final int METHODID_GET_VOD_STITCH_DETAIL = 8;
  private static final int METHODID_LIST_VOD_AD_TAG_DETAILS = 9;
  private static final int METHODID_GET_VOD_AD_TAG_DETAIL = 10;
  private static final int METHODID_LIST_LIVE_AD_TAG_DETAILS = 11;
  private static final int METHODID_GET_LIVE_AD_TAG_DETAIL = 12;
  private static final int METHODID_CREATE_SLATE = 13;
  private static final int METHODID_LIST_SLATES = 14;
  private static final int METHODID_GET_SLATE = 15;
  private static final int METHODID_UPDATE_SLATE = 16;
  private static final int METHODID_DELETE_SLATE = 17;
  private static final int METHODID_CREATE_LIVE_SESSION = 18;
  private static final int METHODID_GET_LIVE_SESSION = 19;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VideoStitcherServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VideoStitcherServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CDN_KEY:
          serviceImpl.createCdnKey(
              (com.google.cloud.video.stitcher.v1.CreateCdnKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey>)
                  responseObserver);
          break;
        case METHODID_LIST_CDN_KEYS:
          serviceImpl.listCdnKeys(
              (com.google.cloud.video.stitcher.v1.ListCdnKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListCdnKeysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CDN_KEY:
          serviceImpl.getCdnKey(
              (com.google.cloud.video.stitcher.v1.GetCdnKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey>)
                  responseObserver);
          break;
        case METHODID_DELETE_CDN_KEY:
          serviceImpl.deleteCdnKey(
              (com.google.cloud.video.stitcher.v1.DeleteCdnKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_CDN_KEY:
          serviceImpl.updateCdnKey(
              (com.google.cloud.video.stitcher.v1.UpdateCdnKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.CdnKey>)
                  responseObserver);
          break;
        case METHODID_CREATE_VOD_SESSION:
          serviceImpl.createVodSession(
              (com.google.cloud.video.stitcher.v1.CreateVodSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>)
                  responseObserver);
          break;
        case METHODID_GET_VOD_SESSION:
          serviceImpl.getVodSession(
              (com.google.cloud.video.stitcher.v1.GetVodSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodSession>)
                  responseObserver);
          break;
        case METHODID_LIST_VOD_STITCH_DETAILS:
          serviceImpl.listVodStitchDetails(
              (com.google.cloud.video.stitcher.v1.ListVodStitchDetailsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.video.stitcher.v1.ListVodStitchDetailsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOD_STITCH_DETAIL:
          serviceImpl.getVodStitchDetail(
              (com.google.cloud.video.stitcher.v1.GetVodStitchDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodStitchDetail>)
                  responseObserver);
          break;
        case METHODID_LIST_VOD_AD_TAG_DETAILS:
          serviceImpl.listVodAdTagDetails(
              (com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.video.stitcher.v1.ListVodAdTagDetailsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VOD_AD_TAG_DETAIL:
          serviceImpl.getVodAdTagDetail(
              (com.google.cloud.video.stitcher.v1.GetVodAdTagDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.VodAdTagDetail>)
                  responseObserver);
          break;
        case METHODID_LIST_LIVE_AD_TAG_DETAILS:
          serviceImpl.listLiveAdTagDetails(
              (com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.video.stitcher.v1.ListLiveAdTagDetailsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_LIVE_AD_TAG_DETAIL:
          serviceImpl.getLiveAdTagDetail(
              (com.google.cloud.video.stitcher.v1.GetLiveAdTagDetailRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveAdTagDetail>)
                  responseObserver);
          break;
        case METHODID_CREATE_SLATE:
          serviceImpl.createSlate(
              (com.google.cloud.video.stitcher.v1.CreateSlateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate>)
                  responseObserver);
          break;
        case METHODID_LIST_SLATES:
          serviceImpl.listSlates(
              (com.google.cloud.video.stitcher.v1.ListSlatesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.ListSlatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SLATE:
          serviceImpl.getSlate(
              (com.google.cloud.video.stitcher.v1.GetSlateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SLATE:
          serviceImpl.updateSlate(
              (com.google.cloud.video.stitcher.v1.UpdateSlateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.Slate>)
                  responseObserver);
          break;
        case METHODID_DELETE_SLATE:
          serviceImpl.deleteSlate(
              (com.google.cloud.video.stitcher.v1.DeleteSlateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_LIVE_SESSION:
          serviceImpl.createLiveSession(
              (com.google.cloud.video.stitcher.v1.CreateLiveSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>)
                  responseObserver);
          break;
        case METHODID_GET_LIVE_SESSION:
          serviceImpl.getLiveSession(
              (com.google.cloud.video.stitcher.v1.GetLiveSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.stitcher.v1.LiveSession>)
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

  private abstract static class VideoStitcherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VideoStitcherServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.video.stitcher.v1.VideoStitcherServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VideoStitcherService");
    }
  }

  private static final class VideoStitcherServiceFileDescriptorSupplier
      extends VideoStitcherServiceBaseDescriptorSupplier {
    VideoStitcherServiceFileDescriptorSupplier() {}
  }

  private static final class VideoStitcherServiceMethodDescriptorSupplier
      extends VideoStitcherServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VideoStitcherServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VideoStitcherServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VideoStitcherServiceFileDescriptorSupplier())
                      .addMethod(getCreateCdnKeyMethod())
                      .addMethod(getListCdnKeysMethod())
                      .addMethod(getGetCdnKeyMethod())
                      .addMethod(getDeleteCdnKeyMethod())
                      .addMethod(getUpdateCdnKeyMethod())
                      .addMethod(getCreateVodSessionMethod())
                      .addMethod(getGetVodSessionMethod())
                      .addMethod(getListVodStitchDetailsMethod())
                      .addMethod(getGetVodStitchDetailMethod())
                      .addMethod(getListVodAdTagDetailsMethod())
                      .addMethod(getGetVodAdTagDetailMethod())
                      .addMethod(getListLiveAdTagDetailsMethod())
                      .addMethod(getGetLiveAdTagDetailMethod())
                      .addMethod(getCreateSlateMethod())
                      .addMethod(getListSlatesMethod())
                      .addMethod(getGetSlateMethod())
                      .addMethod(getUpdateSlateMethod())
                      .addMethod(getDeleteSlateMethod())
                      .addMethod(getCreateLiveSessionMethod())
                      .addMethod(getGetLiveSessionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
