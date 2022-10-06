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
package com.google.cloud.vision.v1p4beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service that performs Google Cloud Vision API detection tasks over client
 * images, such as face, landmark, logo, label, and text detection. The
 * ImageAnnotator service returns detected entities from the images.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/vision/v1p4beta1/image_annotator.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ImageAnnotatorGrpc {

  private ImageAnnotatorGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.vision.v1p4beta1.ImageAnnotator";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest,
          com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
      getBatchAnnotateImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchAnnotateImages",
      requestType = com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest.class,
      responseType = com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest,
          com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
      getBatchAnnotateImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest,
            com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
        getBatchAnnotateImagesMethod;
    if ((getBatchAnnotateImagesMethod = ImageAnnotatorGrpc.getBatchAnnotateImagesMethod) == null) {
      synchronized (ImageAnnotatorGrpc.class) {
        if ((getBatchAnnotateImagesMethod = ImageAnnotatorGrpc.getBatchAnnotateImagesMethod)
            == null) {
          ImageAnnotatorGrpc.getBatchAnnotateImagesMethod =
              getBatchAnnotateImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest,
                          com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchAnnotateImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageAnnotatorMethodDescriptorSupplier("BatchAnnotateImages"))
                      .build();
        }
      }
    }
    return getBatchAnnotateImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest,
          com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
      getBatchAnnotateFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchAnnotateFiles",
      requestType = com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest.class,
      responseType = com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest,
          com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
      getBatchAnnotateFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest,
            com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
        getBatchAnnotateFilesMethod;
    if ((getBatchAnnotateFilesMethod = ImageAnnotatorGrpc.getBatchAnnotateFilesMethod) == null) {
      synchronized (ImageAnnotatorGrpc.class) {
        if ((getBatchAnnotateFilesMethod = ImageAnnotatorGrpc.getBatchAnnotateFilesMethod)
            == null) {
          ImageAnnotatorGrpc.getBatchAnnotateFilesMethod =
              getBatchAnnotateFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest,
                          com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchAnnotateFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageAnnotatorMethodDescriptorSupplier("BatchAnnotateFiles"))
                      .build();
        }
      }
    }
    return getBatchAnnotateFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest,
          com.google.longrunning.Operation>
      getAsyncBatchAnnotateImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsyncBatchAnnotateImages",
      requestType = com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest,
          com.google.longrunning.Operation>
      getAsyncBatchAnnotateImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest,
            com.google.longrunning.Operation>
        getAsyncBatchAnnotateImagesMethod;
    if ((getAsyncBatchAnnotateImagesMethod = ImageAnnotatorGrpc.getAsyncBatchAnnotateImagesMethod)
        == null) {
      synchronized (ImageAnnotatorGrpc.class) {
        if ((getAsyncBatchAnnotateImagesMethod =
                ImageAnnotatorGrpc.getAsyncBatchAnnotateImagesMethod)
            == null) {
          ImageAnnotatorGrpc.getAsyncBatchAnnotateImagesMethod =
              getAsyncBatchAnnotateImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AsyncBatchAnnotateImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageAnnotatorMethodDescriptorSupplier("AsyncBatchAnnotateImages"))
                      .build();
        }
      }
    }
    return getAsyncBatchAnnotateImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest,
          com.google.longrunning.Operation>
      getAsyncBatchAnnotateFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AsyncBatchAnnotateFiles",
      requestType = com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest,
          com.google.longrunning.Operation>
      getAsyncBatchAnnotateFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest,
            com.google.longrunning.Operation>
        getAsyncBatchAnnotateFilesMethod;
    if ((getAsyncBatchAnnotateFilesMethod = ImageAnnotatorGrpc.getAsyncBatchAnnotateFilesMethod)
        == null) {
      synchronized (ImageAnnotatorGrpc.class) {
        if ((getAsyncBatchAnnotateFilesMethod = ImageAnnotatorGrpc.getAsyncBatchAnnotateFilesMethod)
            == null) {
          ImageAnnotatorGrpc.getAsyncBatchAnnotateFilesMethod =
              getAsyncBatchAnnotateFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AsyncBatchAnnotateFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ImageAnnotatorMethodDescriptorSupplier("AsyncBatchAnnotateFiles"))
                      .build();
        }
      }
    }
    return getAsyncBatchAnnotateFilesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ImageAnnotatorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorStub>() {
          @java.lang.Override
          public ImageAnnotatorStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageAnnotatorStub(channel, callOptions);
          }
        };
    return ImageAnnotatorStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ImageAnnotatorBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorBlockingStub>() {
          @java.lang.Override
          public ImageAnnotatorBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageAnnotatorBlockingStub(channel, callOptions);
          }
        };
    return ImageAnnotatorBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ImageAnnotatorFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ImageAnnotatorFutureStub>() {
          @java.lang.Override
          public ImageAnnotatorFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ImageAnnotatorFutureStub(channel, callOptions);
          }
        };
    return ImageAnnotatorFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that performs Google Cloud Vision API detection tasks over client
   * images, such as face, landmark, logo, label, and text detection. The
   * ImageAnnotator service returns detected entities from the images.
   * </pre>
   */
  public abstract static class ImageAnnotatorImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Run image detection and annotation for a batch of images.
     * </pre>
     */
    public void batchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchAnnotateImagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Service that performs image detection and annotation for a batch of files.
     * Now only "application/pdf", "image/tiff" and "image/gif" are supported.
     * This service will extract at most 5 (customers can specify which 5 in
     * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
     * file provided and perform detection and annotation for each image
     * extracted.
     * </pre>
     */
    public void batchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchAnnotateFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of images.
     * Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
     * This service will write image annotation outputs to json files in customer
     * GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
     * </pre>
     */
    public void asyncBatchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAsyncBatchAnnotateImagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of generic
     * files, such as PDF files, which may contain multiple pages and multiple
     * images per page. Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
     * </pre>
     */
    public void asyncBatchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAsyncBatchAnnotateFilesMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getBatchAnnotateImagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest,
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>(
                      this, METHODID_BATCH_ANNOTATE_IMAGES)))
          .addMethod(
              getBatchAnnotateFilesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest,
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>(
                      this, METHODID_BATCH_ANNOTATE_FILES)))
          .addMethod(
              getAsyncBatchAnnotateImagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_ASYNC_BATCH_ANNOTATE_IMAGES)))
          .addMethod(
              getAsyncBatchAnnotateFilesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest,
                      com.google.longrunning.Operation>(this, METHODID_ASYNC_BATCH_ANNOTATE_FILES)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service that performs Google Cloud Vision API detection tasks over client
   * images, such as face, landmark, logo, label, and text detection. The
   * ImageAnnotator service returns detected entities from the images.
   * </pre>
   */
  public static final class ImageAnnotatorStub
      extends io.grpc.stub.AbstractAsyncStub<ImageAnnotatorStub> {
    private ImageAnnotatorStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageAnnotatorStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageAnnotatorStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run image detection and annotation for a batch of images.
     * </pre>
     */
    public void batchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchAnnotateImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Service that performs image detection and annotation for a batch of files.
     * Now only "application/pdf", "image/tiff" and "image/gif" are supported.
     * This service will extract at most 5 (customers can specify which 5 in
     * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
     * file provided and perform detection and annotation for each image
     * extracted.
     * </pre>
     */
    public void batchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchAnnotateFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of images.
     * Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
     * This service will write image annotation outputs to json files in customer
     * GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
     * </pre>
     */
    public void asyncBatchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAsyncBatchAnnotateImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of generic
     * files, such as PDF files, which may contain multiple pages and multiple
     * images per page. Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
     * </pre>
     */
    public void asyncBatchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAsyncBatchAnnotateFilesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that performs Google Cloud Vision API detection tasks over client
   * images, such as face, landmark, logo, label, and text detection. The
   * ImageAnnotator service returns detected entities from the images.
   * </pre>
   */
  public static final class ImageAnnotatorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ImageAnnotatorBlockingStub> {
    private ImageAnnotatorBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageAnnotatorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageAnnotatorBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run image detection and annotation for a batch of images.
     * </pre>
     */
    public com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse batchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchAnnotateImagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Service that performs image detection and annotation for a batch of files.
     * Now only "application/pdf", "image/tiff" and "image/gif" are supported.
     * This service will extract at most 5 (customers can specify which 5 in
     * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
     * file provided and perform detection and annotation for each image
     * extracted.
     * </pre>
     */
    public com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse batchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchAnnotateFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of images.
     * Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
     * This service will write image annotation outputs to json files in customer
     * GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
     * </pre>
     */
    public com.google.longrunning.Operation asyncBatchAnnotateImages(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAsyncBatchAnnotateImagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of generic
     * files, such as PDF files, which may contain multiple pages and multiple
     * images per page. Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
     * </pre>
     */
    public com.google.longrunning.Operation asyncBatchAnnotateFiles(
        com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAsyncBatchAnnotateFilesMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that performs Google Cloud Vision API detection tasks over client
   * images, such as face, landmark, logo, label, and text detection. The
   * ImageAnnotator service returns detected entities from the images.
   * </pre>
   */
  public static final class ImageAnnotatorFutureStub
      extends io.grpc.stub.AbstractFutureStub<ImageAnnotatorFutureStub> {
    private ImageAnnotatorFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ImageAnnotatorFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ImageAnnotatorFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Run image detection and annotation for a batch of images.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>
        batchAnnotateImages(com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchAnnotateImagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Service that performs image detection and annotation for a batch of files.
     * Now only "application/pdf", "image/tiff" and "image/gif" are supported.
     * This service will extract at most 5 (customers can specify which 5 in
     * AnnotateFileRequest.pages) frames (gif) or pages (pdf or tiff) from each
     * file provided and perform detection and annotation for each image
     * extracted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>
        batchAnnotateFiles(com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchAnnotateFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of images.
     * Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateImagesResponse` (results).
     * This service will write image annotation outputs to json files in customer
     * GCS bucket, each json file containing BatchAnnotateImagesResponse proto.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        asyncBatchAnnotateImages(
            com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAsyncBatchAnnotateImagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Run asynchronous image detection and annotation for a list of generic
     * files, such as PDF files, which may contain multiple pages and multiple
     * images per page. Progress and results can be retrieved through the
     * `google.longrunning.Operations` interface.
     * `Operation.metadata` contains `OperationMetadata` (metadata).
     * `Operation.response` contains `AsyncBatchAnnotateFilesResponse` (results).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        asyncBatchAnnotateFiles(
            com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAsyncBatchAnnotateFilesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BATCH_ANNOTATE_IMAGES = 0;
  private static final int METHODID_BATCH_ANNOTATE_FILES = 1;
  private static final int METHODID_ASYNC_BATCH_ANNOTATE_IMAGES = 2;
  private static final int METHODID_ASYNC_BATCH_ANNOTATE_FILES = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ImageAnnotatorImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ImageAnnotatorImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BATCH_ANNOTATE_IMAGES:
          serviceImpl.batchAnnotateImages(
              (com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateImagesResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_ANNOTATE_FILES:
          serviceImpl.batchAnnotateFiles(
              (com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.vision.v1p4beta1.BatchAnnotateFilesResponse>)
                  responseObserver);
          break;
        case METHODID_ASYNC_BATCH_ANNOTATE_IMAGES:
          serviceImpl.asyncBatchAnnotateImages(
              (com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateImagesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ASYNC_BATCH_ANNOTATE_FILES:
          serviceImpl.asyncBatchAnnotateFiles(
              (com.google.cloud.vision.v1p4beta1.AsyncBatchAnnotateFilesRequest) request,
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

  private abstract static class ImageAnnotatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ImageAnnotatorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.vision.v1p4beta1.ImageAnnotatorProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ImageAnnotator");
    }
  }

  private static final class ImageAnnotatorFileDescriptorSupplier
      extends ImageAnnotatorBaseDescriptorSupplier {
    ImageAnnotatorFileDescriptorSupplier() {}
  }

  private static final class ImageAnnotatorMethodDescriptorSupplier
      extends ImageAnnotatorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ImageAnnotatorMethodDescriptorSupplier(String methodName) {
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
      synchronized (ImageAnnotatorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ImageAnnotatorFileDescriptorSupplier())
                      .addMethod(getBatchAnnotateImagesMethod())
                      .addMethod(getBatchAnnotateFilesMethod())
                      .addMethod(getAsyncBatchAnnotateImagesMethod())
                      .addMethod(getAsyncBatchAnnotateFilesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
