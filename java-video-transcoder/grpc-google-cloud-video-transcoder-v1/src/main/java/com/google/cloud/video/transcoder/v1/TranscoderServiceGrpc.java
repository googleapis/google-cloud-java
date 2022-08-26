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
package com.google.cloud.video.transcoder.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Using the Transcoder API, you can queue asynchronous jobs for transcoding
 * media into various output formats. Output formats may include different
 * streaming standards such as HTTP Live Streaming (HLS) and Dynamic Adaptive
 * Streaming over HTTP (DASH). You can also customize jobs using advanced
 * features such as Digital Rights Management (DRM), audio equalization, content
 * concatenation, and digital ad-stitch ready content generation.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/video/transcoder/v1/services.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TranscoderServiceGrpc {

  private TranscoderServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.video.transcoder.v1.TranscoderService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.CreateJobRequest,
          com.google.cloud.video.transcoder.v1.Job>
      getCreateJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJob",
      requestType = com.google.cloud.video.transcoder.v1.CreateJobRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.CreateJobRequest,
          com.google.cloud.video.transcoder.v1.Job>
      getCreateJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.CreateJobRequest,
            com.google.cloud.video.transcoder.v1.Job>
        getCreateJobMethod;
    if ((getCreateJobMethod = TranscoderServiceGrpc.getCreateJobMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getCreateJobMethod = TranscoderServiceGrpc.getCreateJobMethod) == null) {
          TranscoderServiceGrpc.getCreateJobMethod =
              getCreateJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.CreateJobRequest,
                          com.google.cloud.video.transcoder.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.CreateJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("CreateJob"))
                      .build();
        }
      }
    }
    return getCreateJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.ListJobsRequest,
          com.google.cloud.video.transcoder.v1.ListJobsResponse>
      getListJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobs",
      requestType = com.google.cloud.video.transcoder.v1.ListJobsRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.ListJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.ListJobsRequest,
          com.google.cloud.video.transcoder.v1.ListJobsResponse>
      getListJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.ListJobsRequest,
            com.google.cloud.video.transcoder.v1.ListJobsResponse>
        getListJobsMethod;
    if ((getListJobsMethod = TranscoderServiceGrpc.getListJobsMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getListJobsMethod = TranscoderServiceGrpc.getListJobsMethod) == null) {
          TranscoderServiceGrpc.getListJobsMethod =
              getListJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.ListJobsRequest,
                          com.google.cloud.video.transcoder.v1.ListJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.ListJobsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.ListJobsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("ListJobs"))
                      .build();
        }
      }
    }
    return getListJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.GetJobRequest,
          com.google.cloud.video.transcoder.v1.Job>
      getGetJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJob",
      requestType = com.google.cloud.video.transcoder.v1.GetJobRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.Job.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.GetJobRequest,
          com.google.cloud.video.transcoder.v1.Job>
      getGetJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.GetJobRequest,
            com.google.cloud.video.transcoder.v1.Job>
        getGetJobMethod;
    if ((getGetJobMethod = TranscoderServiceGrpc.getGetJobMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getGetJobMethod = TranscoderServiceGrpc.getGetJobMethod) == null) {
          TranscoderServiceGrpc.getGetJobMethod =
              getGetJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.GetJobRequest,
                          com.google.cloud.video.transcoder.v1.Job>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.GetJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.Job.getDefaultInstance()))
                      .setSchemaDescriptor(new TranscoderServiceMethodDescriptorSupplier("GetJob"))
                      .build();
        }
      }
    }
    return getGetJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJob",
      requestType = com.google.cloud.video.transcoder.v1.DeleteJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.DeleteJobRequest, com.google.protobuf.Empty>
      getDeleteJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.DeleteJobRequest, com.google.protobuf.Empty>
        getDeleteJobMethod;
    if ((getDeleteJobMethod = TranscoderServiceGrpc.getDeleteJobMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getDeleteJobMethod = TranscoderServiceGrpc.getDeleteJobMethod) == null) {
          TranscoderServiceGrpc.getDeleteJobMethod =
              getDeleteJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.DeleteJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.DeleteJobRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("DeleteJob"))
                      .build();
        }
      }
    }
    return getDeleteJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest,
          com.google.cloud.video.transcoder.v1.JobTemplate>
      getCreateJobTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateJobTemplate",
      requestType = com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.JobTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest,
          com.google.cloud.video.transcoder.v1.JobTemplate>
      getCreateJobTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest,
            com.google.cloud.video.transcoder.v1.JobTemplate>
        getCreateJobTemplateMethod;
    if ((getCreateJobTemplateMethod = TranscoderServiceGrpc.getCreateJobTemplateMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getCreateJobTemplateMethod = TranscoderServiceGrpc.getCreateJobTemplateMethod)
            == null) {
          TranscoderServiceGrpc.getCreateJobTemplateMethod =
              getCreateJobTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest,
                          com.google.cloud.video.transcoder.v1.JobTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateJobTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.JobTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("CreateJobTemplate"))
                      .build();
        }
      }
    }
    return getCreateJobTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest,
          com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
      getListJobTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListJobTemplates",
      requestType = com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest,
          com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
      getListJobTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest,
            com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
        getListJobTemplatesMethod;
    if ((getListJobTemplatesMethod = TranscoderServiceGrpc.getListJobTemplatesMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getListJobTemplatesMethod = TranscoderServiceGrpc.getListJobTemplatesMethod) == null) {
          TranscoderServiceGrpc.getListJobTemplatesMethod =
              getListJobTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest,
                          com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListJobTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("ListJobTemplates"))
                      .build();
        }
      }
    }
    return getListJobTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.GetJobTemplateRequest,
          com.google.cloud.video.transcoder.v1.JobTemplate>
      getGetJobTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJobTemplate",
      requestType = com.google.cloud.video.transcoder.v1.GetJobTemplateRequest.class,
      responseType = com.google.cloud.video.transcoder.v1.JobTemplate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.GetJobTemplateRequest,
          com.google.cloud.video.transcoder.v1.JobTemplate>
      getGetJobTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.GetJobTemplateRequest,
            com.google.cloud.video.transcoder.v1.JobTemplate>
        getGetJobTemplateMethod;
    if ((getGetJobTemplateMethod = TranscoderServiceGrpc.getGetJobTemplateMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getGetJobTemplateMethod = TranscoderServiceGrpc.getGetJobTemplateMethod) == null) {
          TranscoderServiceGrpc.getGetJobTemplateMethod =
              getGetJobTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.GetJobTemplateRequest,
                          com.google.cloud.video.transcoder.v1.JobTemplate>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJobTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.GetJobTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.JobTemplate
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("GetJobTemplate"))
                      .build();
        }
      }
    }
    return getGetJobTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest, com.google.protobuf.Empty>
      getDeleteJobTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteJobTemplate",
      requestType = com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest, com.google.protobuf.Empty>
      getDeleteJobTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest,
            com.google.protobuf.Empty>
        getDeleteJobTemplateMethod;
    if ((getDeleteJobTemplateMethod = TranscoderServiceGrpc.getDeleteJobTemplateMethod) == null) {
      synchronized (TranscoderServiceGrpc.class) {
        if ((getDeleteJobTemplateMethod = TranscoderServiceGrpc.getDeleteJobTemplateMethod)
            == null) {
          TranscoderServiceGrpc.getDeleteJobTemplateMethod =
              getDeleteJobTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteJobTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TranscoderServiceMethodDescriptorSupplier("DeleteJobTemplate"))
                      .build();
        }
      }
    }
    return getDeleteJobTemplateMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TranscoderServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceStub>() {
          @java.lang.Override
          public TranscoderServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranscoderServiceStub(channel, callOptions);
          }
        };
    return TranscoderServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TranscoderServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceBlockingStub>() {
          @java.lang.Override
          public TranscoderServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranscoderServiceBlockingStub(channel, callOptions);
          }
        };
    return TranscoderServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TranscoderServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TranscoderServiceFutureStub>() {
          @java.lang.Override
          public TranscoderServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TranscoderServiceFutureStub(channel, callOptions);
          }
        };
    return TranscoderServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Using the Transcoder API, you can queue asynchronous jobs for transcoding
   * media into various output formats. Output formats may include different
   * streaming standards such as HTTP Live Streaming (HLS) and Dynamic Adaptive
   * Streaming over HTTP (DASH). You can also customize jobs using advanced
   * features such as Digital Rights Management (DRM), audio equalization, content
   * concatenation, and digital ad-stitch ready content generation.
   * </pre>
   */
  public abstract static class TranscoderServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a job in the specified region.
     * </pre>
     */
    public void createJob(
        com.google.cloud.video.transcoder.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs in the specified region.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.video.transcoder.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the job data.
     * </pre>
     */
    public void getJob(
        com.google.cloud.video.transcoder.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.video.transcoder.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job template in the specified region.
     * </pre>
     */
    public void createJobTemplate(
        com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateJobTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists job templates in the specified region.
     * </pre>
     */
    public void listJobTemplates(
        com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListJobTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the job template data.
     * </pre>
     */
    public void getJobTemplate(
        com.google.cloud.video.transcoder.v1.GetJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetJobTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job template.
     * </pre>
     */
    public void deleteJobTemplate(
        com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteJobTemplateMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.CreateJobRequest,
                      com.google.cloud.video.transcoder.v1.Job>(this, METHODID_CREATE_JOB)))
          .addMethod(
              getListJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.ListJobsRequest,
                      com.google.cloud.video.transcoder.v1.ListJobsResponse>(
                      this, METHODID_LIST_JOBS)))
          .addMethod(
              getGetJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.GetJobRequest,
                      com.google.cloud.video.transcoder.v1.Job>(this, METHODID_GET_JOB)))
          .addMethod(
              getDeleteJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.DeleteJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_JOB)))
          .addMethod(
              getCreateJobTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest,
                      com.google.cloud.video.transcoder.v1.JobTemplate>(
                      this, METHODID_CREATE_JOB_TEMPLATE)))
          .addMethod(
              getListJobTemplatesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest,
                      com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>(
                      this, METHODID_LIST_JOB_TEMPLATES)))
          .addMethod(
              getGetJobTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.GetJobTemplateRequest,
                      com.google.cloud.video.transcoder.v1.JobTemplate>(
                      this, METHODID_GET_JOB_TEMPLATE)))
          .addMethod(
              getDeleteJobTemplateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_JOB_TEMPLATE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Using the Transcoder API, you can queue asynchronous jobs for transcoding
   * media into various output formats. Output formats may include different
   * streaming standards such as HTTP Live Streaming (HLS) and Dynamic Adaptive
   * Streaming over HTTP (DASH). You can also customize jobs using advanced
   * features such as Digital Rights Management (DRM), audio equalization, content
   * concatenation, and digital ad-stitch ready content generation.
   * </pre>
   */
  public static final class TranscoderServiceStub
      extends io.grpc.stub.AbstractAsyncStub<TranscoderServiceStub> {
    private TranscoderServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranscoderServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranscoderServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a job in the specified region.
     * </pre>
     */
    public void createJob(
        com.google.cloud.video.transcoder.v1.CreateJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs in the specified region.
     * </pre>
     */
    public void listJobs(
        com.google.cloud.video.transcoder.v1.ListJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.ListJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the job data.
     * </pre>
     */
    public void getJob(
        com.google.cloud.video.transcoder.v1.GetJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public void deleteJob(
        com.google.cloud.video.transcoder.v1.DeleteJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a job template in the specified region.
     * </pre>
     */
    public void createJobTemplate(
        com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateJobTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists job templates in the specified region.
     * </pre>
     */
    public void listJobTemplates(
        com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListJobTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the job template data.
     * </pre>
     */
    public void getJobTemplate(
        com.google.cloud.video.transcoder.v1.GetJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job template.
     * </pre>
     */
    public void deleteJobTemplate(
        com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteJobTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Using the Transcoder API, you can queue asynchronous jobs for transcoding
   * media into various output formats. Output formats may include different
   * streaming standards such as HTTP Live Streaming (HLS) and Dynamic Adaptive
   * Streaming over HTTP (DASH). You can also customize jobs using advanced
   * features such as Digital Rights Management (DRM), audio equalization, content
   * concatenation, and digital ad-stitch ready content generation.
   * </pre>
   */
  public static final class TranscoderServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TranscoderServiceBlockingStub> {
    private TranscoderServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranscoderServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranscoderServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a job in the specified region.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.Job createJob(
        com.google.cloud.video.transcoder.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs in the specified region.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.ListJobsResponse listJobs(
        com.google.cloud.video.transcoder.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the job data.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.Job getJob(
        com.google.cloud.video.transcoder.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJob(
        com.google.cloud.video.transcoder.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job template in the specified region.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.JobTemplate createJobTemplate(
        com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateJobTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists job templates in the specified region.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse listJobTemplates(
        com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListJobTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the job template data.
     * </pre>
     */
    public com.google.cloud.video.transcoder.v1.JobTemplate getJobTemplate(
        com.google.cloud.video.transcoder.v1.GetJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteJobTemplate(
        com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteJobTemplateMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Using the Transcoder API, you can queue asynchronous jobs for transcoding
   * media into various output formats. Output formats may include different
   * streaming standards such as HTTP Live Streaming (HLS) and Dynamic Adaptive
   * Streaming over HTTP (DASH). You can also customize jobs using advanced
   * features such as Digital Rights Management (DRM), audio equalization, content
   * concatenation, and digital ad-stitch ready content generation.
   * </pre>
   */
  public static final class TranscoderServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<TranscoderServiceFutureStub> {
    private TranscoderServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TranscoderServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TranscoderServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a job in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.Job>
        createJob(com.google.cloud.video.transcoder.v1.CreateJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists jobs in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.ListJobsResponse>
        listJobs(com.google.cloud.video.transcoder.v1.ListJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the job data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.Job>
        getJob(com.google.cloud.video.transcoder.v1.GetJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteJob(
        com.google.cloud.video.transcoder.v1.DeleteJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a job template in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.JobTemplate>
        createJobTemplate(com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateJobTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists job templates in the specified region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>
        listJobTemplates(com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListJobTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the job template data.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.video.transcoder.v1.JobTemplate>
        getJobTemplate(com.google.cloud.video.transcoder.v1.GetJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a job template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteJobTemplate(com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteJobTemplateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_JOB = 0;
  private static final int METHODID_LIST_JOBS = 1;
  private static final int METHODID_GET_JOB = 2;
  private static final int METHODID_DELETE_JOB = 3;
  private static final int METHODID_CREATE_JOB_TEMPLATE = 4;
  private static final int METHODID_LIST_JOB_TEMPLATES = 5;
  private static final int METHODID_GET_JOB_TEMPLATE = 6;
  private static final int METHODID_DELETE_JOB_TEMPLATE = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TranscoderServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TranscoderServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_JOB:
          serviceImpl.createJob(
              (com.google.cloud.video.transcoder.v1.CreateJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job>)
                  responseObserver);
          break;
        case METHODID_LIST_JOBS:
          serviceImpl.listJobs(
              (com.google.cloud.video.transcoder.v1.ListJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.ListJobsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB:
          serviceImpl.getJob(
              (com.google.cloud.video.transcoder.v1.GetJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.Job>)
                  responseObserver);
          break;
        case METHODID_DELETE_JOB:
          serviceImpl.deleteJob(
              (com.google.cloud.video.transcoder.v1.DeleteJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_JOB_TEMPLATE:
          serviceImpl.createJobTemplate(
              (com.google.cloud.video.transcoder.v1.CreateJobTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>)
                  responseObserver);
          break;
        case METHODID_LIST_JOB_TEMPLATES:
          serviceImpl.listJobTemplates(
              (com.google.cloud.video.transcoder.v1.ListJobTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.video.transcoder.v1.ListJobTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_JOB_TEMPLATE:
          serviceImpl.getJobTemplate(
              (com.google.cloud.video.transcoder.v1.GetJobTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.video.transcoder.v1.JobTemplate>)
                  responseObserver);
          break;
        case METHODID_DELETE_JOB_TEMPLATE:
          serviceImpl.deleteJobTemplate(
              (com.google.cloud.video.transcoder.v1.DeleteJobTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class TranscoderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TranscoderServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.video.transcoder.v1.ServicesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TranscoderService");
    }
  }

  private static final class TranscoderServiceFileDescriptorSupplier
      extends TranscoderServiceBaseDescriptorSupplier {
    TranscoderServiceFileDescriptorSupplier() {}
  }

  private static final class TranscoderServiceMethodDescriptorSupplier
      extends TranscoderServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TranscoderServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TranscoderServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TranscoderServiceFileDescriptorSupplier())
                      .addMethod(getCreateJobMethod())
                      .addMethod(getListJobsMethod())
                      .addMethod(getGetJobMethod())
                      .addMethod(getDeleteJobMethod())
                      .addMethod(getCreateJobTemplateMethod())
                      .addMethod(getListJobTemplatesMethod())
                      .addMethod(getGetJobTemplateMethod())
                      .addMethod(getDeleteJobTemplateMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
