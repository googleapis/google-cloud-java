package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * A service for creating and managing Vertex AI's pipelines. This includes both
 * `TrainingPipeline` resources (used for AutoML and custom training) and
 * `PipelineJob` resources (used for Vertex AI Pipelines).
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/pipeline_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PipelineServiceGrpc {

  private PipelineServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.PipelineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest,
      com.google.cloud.aiplatform.v1.TrainingPipeline> getCreateTrainingPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrainingPipeline",
      requestType = com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest.class,
      responseType = com.google.cloud.aiplatform.v1.TrainingPipeline.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest,
      com.google.cloud.aiplatform.v1.TrainingPipeline> getCreateTrainingPipelineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest, com.google.cloud.aiplatform.v1.TrainingPipeline> getCreateTrainingPipelineMethod;
    if ((getCreateTrainingPipelineMethod = PipelineServiceGrpc.getCreateTrainingPipelineMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getCreateTrainingPipelineMethod = PipelineServiceGrpc.getCreateTrainingPipelineMethod) == null) {
          PipelineServiceGrpc.getCreateTrainingPipelineMethod = getCreateTrainingPipelineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest, com.google.cloud.aiplatform.v1.TrainingPipeline>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrainingPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.TrainingPipeline.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("CreateTrainingPipeline"))
              .build();
        }
      }
    }
    return getCreateTrainingPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest,
      com.google.cloud.aiplatform.v1.TrainingPipeline> getGetTrainingPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrainingPipeline",
      requestType = com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest.class,
      responseType = com.google.cloud.aiplatform.v1.TrainingPipeline.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest,
      com.google.cloud.aiplatform.v1.TrainingPipeline> getGetTrainingPipelineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest, com.google.cloud.aiplatform.v1.TrainingPipeline> getGetTrainingPipelineMethod;
    if ((getGetTrainingPipelineMethod = PipelineServiceGrpc.getGetTrainingPipelineMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getGetTrainingPipelineMethod = PipelineServiceGrpc.getGetTrainingPipelineMethod) == null) {
          PipelineServiceGrpc.getGetTrainingPipelineMethod = getGetTrainingPipelineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest, com.google.cloud.aiplatform.v1.TrainingPipeline>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrainingPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.TrainingPipeline.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("GetTrainingPipeline"))
              .build();
        }
      }
    }
    return getGetTrainingPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest,
      com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> getListTrainingPipelinesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTrainingPipelines",
      requestType = com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest,
      com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> getListTrainingPipelinesMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest, com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> getListTrainingPipelinesMethod;
    if ((getListTrainingPipelinesMethod = PipelineServiceGrpc.getListTrainingPipelinesMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getListTrainingPipelinesMethod = PipelineServiceGrpc.getListTrainingPipelinesMethod) == null) {
          PipelineServiceGrpc.getListTrainingPipelinesMethod = getListTrainingPipelinesMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest, com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTrainingPipelines"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("ListTrainingPipelines"))
              .build();
        }
      }
    }
    return getListTrainingPipelinesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest,
      com.google.longrunning.Operation> getDeleteTrainingPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrainingPipeline",
      requestType = com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest,
      com.google.longrunning.Operation> getDeleteTrainingPipelineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest, com.google.longrunning.Operation> getDeleteTrainingPipelineMethod;
    if ((getDeleteTrainingPipelineMethod = PipelineServiceGrpc.getDeleteTrainingPipelineMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getDeleteTrainingPipelineMethod = PipelineServiceGrpc.getDeleteTrainingPipelineMethod) == null) {
          PipelineServiceGrpc.getDeleteTrainingPipelineMethod = getDeleteTrainingPipelineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrainingPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("DeleteTrainingPipeline"))
              .build();
        }
      }
    }
    return getDeleteTrainingPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest,
      com.google.protobuf.Empty> getCancelTrainingPipelineMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelTrainingPipeline",
      requestType = com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest,
      com.google.protobuf.Empty> getCancelTrainingPipelineMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest, com.google.protobuf.Empty> getCancelTrainingPipelineMethod;
    if ((getCancelTrainingPipelineMethod = PipelineServiceGrpc.getCancelTrainingPipelineMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getCancelTrainingPipelineMethod = PipelineServiceGrpc.getCancelTrainingPipelineMethod) == null) {
          PipelineServiceGrpc.getCancelTrainingPipelineMethod = getCancelTrainingPipelineMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelTrainingPipeline"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("CancelTrainingPipeline"))
              .build();
        }
      }
    }
    return getCancelTrainingPipelineMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreatePipelineJobRequest,
      com.google.cloud.aiplatform.v1.PipelineJob> getCreatePipelineJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePipelineJob",
      requestType = com.google.cloud.aiplatform.v1.CreatePipelineJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1.PipelineJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreatePipelineJobRequest,
      com.google.cloud.aiplatform.v1.PipelineJob> getCreatePipelineJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CreatePipelineJobRequest, com.google.cloud.aiplatform.v1.PipelineJob> getCreatePipelineJobMethod;
    if ((getCreatePipelineJobMethod = PipelineServiceGrpc.getCreatePipelineJobMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getCreatePipelineJobMethod = PipelineServiceGrpc.getCreatePipelineJobMethod) == null) {
          PipelineServiceGrpc.getCreatePipelineJobMethod = getCreatePipelineJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CreatePipelineJobRequest, com.google.cloud.aiplatform.v1.PipelineJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePipelineJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CreatePipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.PipelineJob.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("CreatePipelineJob"))
              .build();
        }
      }
    }
    return getCreatePipelineJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetPipelineJobRequest,
      com.google.cloud.aiplatform.v1.PipelineJob> getGetPipelineJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPipelineJob",
      requestType = com.google.cloud.aiplatform.v1.GetPipelineJobRequest.class,
      responseType = com.google.cloud.aiplatform.v1.PipelineJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetPipelineJobRequest,
      com.google.cloud.aiplatform.v1.PipelineJob> getGetPipelineJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.GetPipelineJobRequest, com.google.cloud.aiplatform.v1.PipelineJob> getGetPipelineJobMethod;
    if ((getGetPipelineJobMethod = PipelineServiceGrpc.getGetPipelineJobMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getGetPipelineJobMethod = PipelineServiceGrpc.getGetPipelineJobMethod) == null) {
          PipelineServiceGrpc.getGetPipelineJobMethod = getGetPipelineJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.GetPipelineJobRequest, com.google.cloud.aiplatform.v1.PipelineJob>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPipelineJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.GetPipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.PipelineJob.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("GetPipelineJob"))
              .build();
        }
      }
    }
    return getGetPipelineJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListPipelineJobsRequest,
      com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> getListPipelineJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPipelineJobs",
      requestType = com.google.cloud.aiplatform.v1.ListPipelineJobsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListPipelineJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListPipelineJobsRequest,
      com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> getListPipelineJobsMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.ListPipelineJobsRequest, com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> getListPipelineJobsMethod;
    if ((getListPipelineJobsMethod = PipelineServiceGrpc.getListPipelineJobsMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getListPipelineJobsMethod = PipelineServiceGrpc.getListPipelineJobsMethod) == null) {
          PipelineServiceGrpc.getListPipelineJobsMethod = getListPipelineJobsMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.ListPipelineJobsRequest, com.google.cloud.aiplatform.v1.ListPipelineJobsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPipelineJobs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListPipelineJobsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.ListPipelineJobsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("ListPipelineJobs"))
              .build();
        }
      }
    }
    return getListPipelineJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeletePipelineJobRequest,
      com.google.longrunning.Operation> getDeletePipelineJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePipelineJob",
      requestType = com.google.cloud.aiplatform.v1.DeletePipelineJobRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeletePipelineJobRequest,
      com.google.longrunning.Operation> getDeletePipelineJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.DeletePipelineJobRequest, com.google.longrunning.Operation> getDeletePipelineJobMethod;
    if ((getDeletePipelineJobMethod = PipelineServiceGrpc.getDeletePipelineJobMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getDeletePipelineJobMethod = PipelineServiceGrpc.getDeletePipelineJobMethod) == null) {
          PipelineServiceGrpc.getDeletePipelineJobMethod = getDeletePipelineJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.DeletePipelineJobRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePipelineJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.DeletePipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("DeletePipelineJob"))
              .build();
        }
      }
    }
    return getDeletePipelineJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelPipelineJobRequest,
      com.google.protobuf.Empty> getCancelPipelineJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelPipelineJob",
      requestType = com.google.cloud.aiplatform.v1.CancelPipelineJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelPipelineJobRequest,
      com.google.protobuf.Empty> getCancelPipelineJobMethod() {
    io.grpc.MethodDescriptor<com.google.cloud.aiplatform.v1.CancelPipelineJobRequest, com.google.protobuf.Empty> getCancelPipelineJobMethod;
    if ((getCancelPipelineJobMethod = PipelineServiceGrpc.getCancelPipelineJobMethod) == null) {
      synchronized (PipelineServiceGrpc.class) {
        if ((getCancelPipelineJobMethod = PipelineServiceGrpc.getCancelPipelineJobMethod) == null) {
          PipelineServiceGrpc.getCancelPipelineJobMethod = getCancelPipelineJobMethod =
              io.grpc.MethodDescriptor.<com.google.cloud.aiplatform.v1.CancelPipelineJobRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelPipelineJob"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.cloud.aiplatform.v1.CancelPipelineJobRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new PipelineServiceMethodDescriptorSupplier("CancelPipelineJob"))
              .build();
        }
      }
    }
    return getCancelPipelineJobMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PipelineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceStub>() {
        @java.lang.Override
        public PipelineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PipelineServiceStub(channel, callOptions);
        }
      };
    return PipelineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PipelineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceBlockingStub>() {
        @java.lang.Override
        public PipelineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PipelineServiceBlockingStub(channel, callOptions);
        }
      };
    return PipelineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PipelineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PipelineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PipelineServiceFutureStub>() {
        @java.lang.Override
        public PipelineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PipelineServiceFutureStub(channel, callOptions);
        }
      };
    return PipelineServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * A service for creating and managing Vertex AI's pipelines. This includes both
   * `TrainingPipeline` resources (used for AutoML and custom training) and
   * `PipelineJob` resources (used for Vertex AI Pipelines).
   * </pre>
   */
  public static abstract class PipelineServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Creates a TrainingPipeline. A created TrainingPipeline right away will be
     * attempted to be run.
     * </pre>
     */
    public void createTrainingPipeline(com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTrainingPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a TrainingPipeline.
     * </pre>
     */
    public void getTrainingPipeline(com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrainingPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists TrainingPipelines in a Location.
     * </pre>
     */
    public void listTrainingPipelines(com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTrainingPipelinesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a TrainingPipeline.
     * </pre>
     */
    public void deleteTrainingPipeline(com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTrainingPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancels a TrainingPipeline.
     * Starts asynchronous cancellation on the TrainingPipeline. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the TrainingPipeline is not deleted; instead it becomes a pipeline with
     * a
     * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public void cancelTrainingPipeline(com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelTrainingPipelineMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a PipelineJob. A PipelineJob will run immediately when created.
     * </pre>
     */
    public void createPipelineJob(com.google.cloud.aiplatform.v1.CreatePipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePipelineJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets a PipelineJob.
     * </pre>
     */
    public void getPipelineJob(com.google.cloud.aiplatform.v1.GetPipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPipelineJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists PipelineJobs in a Location.
     * </pre>
     */
    public void listPipelineJobs(com.google.cloud.aiplatform.v1.ListPipelineJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPipelineJobsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a PipelineJob.
     * </pre>
     */
    public void deletePipelineJob(com.google.cloud.aiplatform.v1.DeletePipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeletePipelineJobMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancels a PipelineJob.
     * Starts asynchronous cancellation on the PipelineJob. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1.PipelineService.GetPipelineJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the PipelineJob is not deleted; instead it becomes a pipeline with
     * a [PipelineJob.error][google.cloud.aiplatform.v1.PipelineJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [PipelineJob.state][google.cloud.aiplatform.v1.PipelineJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public void cancelPipelineJob(com.google.cloud.aiplatform.v1.CancelPipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelPipelineJobMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateTrainingPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest,
                com.google.cloud.aiplatform.v1.TrainingPipeline>(
                  this, METHODID_CREATE_TRAINING_PIPELINE)))
          .addMethod(
            getGetTrainingPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest,
                com.google.cloud.aiplatform.v1.TrainingPipeline>(
                  this, METHODID_GET_TRAINING_PIPELINE)))
          .addMethod(
            getListTrainingPipelinesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest,
                com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse>(
                  this, METHODID_LIST_TRAINING_PIPELINES)))
          .addMethod(
            getDeleteTrainingPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_TRAINING_PIPELINE)))
          .addMethod(
            getCancelTrainingPipelineMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CANCEL_TRAINING_PIPELINE)))
          .addMethod(
            getCreatePipelineJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.CreatePipelineJobRequest,
                com.google.cloud.aiplatform.v1.PipelineJob>(
                  this, METHODID_CREATE_PIPELINE_JOB)))
          .addMethod(
            getGetPipelineJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.GetPipelineJobRequest,
                com.google.cloud.aiplatform.v1.PipelineJob>(
                  this, METHODID_GET_PIPELINE_JOB)))
          .addMethod(
            getListPipelineJobsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.ListPipelineJobsRequest,
                com.google.cloud.aiplatform.v1.ListPipelineJobsResponse>(
                  this, METHODID_LIST_PIPELINE_JOBS)))
          .addMethod(
            getDeletePipelineJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.DeletePipelineJobRequest,
                com.google.longrunning.Operation>(
                  this, METHODID_DELETE_PIPELINE_JOB)))
          .addMethod(
            getCancelPipelineJobMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.google.cloud.aiplatform.v1.CancelPipelineJobRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CANCEL_PIPELINE_JOB)))
          .build();
    }
  }

  /**
   * <pre>
   * A service for creating and managing Vertex AI's pipelines. This includes both
   * `TrainingPipeline` resources (used for AutoML and custom training) and
   * `PipelineJob` resources (used for Vertex AI Pipelines).
   * </pre>
   */
  public static final class PipelineServiceStub extends io.grpc.stub.AbstractAsyncStub<PipelineServiceStub> {
    private PipelineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a TrainingPipeline. A created TrainingPipeline right away will be
     * attempted to be run.
     * </pre>
     */
    public void createTrainingPipeline(com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTrainingPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a TrainingPipeline.
     * </pre>
     */
    public void getTrainingPipeline(com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrainingPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists TrainingPipelines in a Location.
     * </pre>
     */
    public void listTrainingPipelines(com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTrainingPipelinesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a TrainingPipeline.
     * </pre>
     */
    public void deleteTrainingPipeline(com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTrainingPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancels a TrainingPipeline.
     * Starts asynchronous cancellation on the TrainingPipeline. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the TrainingPipeline is not deleted; instead it becomes a pipeline with
     * a
     * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public void cancelTrainingPipeline(com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelTrainingPipelineMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a PipelineJob. A PipelineJob will run immediately when created.
     * </pre>
     */
    public void createPipelineJob(com.google.cloud.aiplatform.v1.CreatePipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePipelineJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets a PipelineJob.
     * </pre>
     */
    public void getPipelineJob(com.google.cloud.aiplatform.v1.GetPipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPipelineJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists PipelineJobs in a Location.
     * </pre>
     */
    public void listPipelineJobs(com.google.cloud.aiplatform.v1.ListPipelineJobsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPipelineJobsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a PipelineJob.
     * </pre>
     */
    public void deletePipelineJob(com.google.cloud.aiplatform.v1.DeletePipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePipelineJobMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancels a PipelineJob.
     * Starts asynchronous cancellation on the PipelineJob. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1.PipelineService.GetPipelineJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the PipelineJob is not deleted; instead it becomes a pipeline with
     * a [PipelineJob.error][google.cloud.aiplatform.v1.PipelineJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [PipelineJob.state][google.cloud.aiplatform.v1.PipelineJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public void cancelPipelineJob(com.google.cloud.aiplatform.v1.CancelPipelineJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelPipelineJobMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * A service for creating and managing Vertex AI's pipelines. This includes both
   * `TrainingPipeline` resources (used for AutoML and custom training) and
   * `PipelineJob` resources (used for Vertex AI Pipelines).
   * </pre>
   */
  public static final class PipelineServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<PipelineServiceBlockingStub> {
    private PipelineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a TrainingPipeline. A created TrainingPipeline right away will be
     * attempted to be run.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.TrainingPipeline createTrainingPipeline(com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTrainingPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a TrainingPipeline.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.TrainingPipeline getTrainingPipeline(com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrainingPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists TrainingPipelines in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse listTrainingPipelines(com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTrainingPipelinesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a TrainingPipeline.
     * </pre>
     */
    public com.google.longrunning.Operation deleteTrainingPipeline(com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTrainingPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancels a TrainingPipeline.
     * Starts asynchronous cancellation on the TrainingPipeline. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the TrainingPipeline is not deleted; instead it becomes a pipeline with
     * a
     * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public com.google.protobuf.Empty cancelTrainingPipeline(com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelTrainingPipelineMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a PipelineJob. A PipelineJob will run immediately when created.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.PipelineJob createPipelineJob(com.google.cloud.aiplatform.v1.CreatePipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePipelineJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets a PipelineJob.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.PipelineJob getPipelineJob(com.google.cloud.aiplatform.v1.GetPipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPipelineJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists PipelineJobs in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListPipelineJobsResponse listPipelineJobs(com.google.cloud.aiplatform.v1.ListPipelineJobsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPipelineJobsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a PipelineJob.
     * </pre>
     */
    public com.google.longrunning.Operation deletePipelineJob(com.google.cloud.aiplatform.v1.DeletePipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePipelineJobMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancels a PipelineJob.
     * Starts asynchronous cancellation on the PipelineJob. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1.PipelineService.GetPipelineJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the PipelineJob is not deleted; instead it becomes a pipeline with
     * a [PipelineJob.error][google.cloud.aiplatform.v1.PipelineJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [PipelineJob.state][google.cloud.aiplatform.v1.PipelineJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public com.google.protobuf.Empty cancelPipelineJob(com.google.cloud.aiplatform.v1.CancelPipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelPipelineJobMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * A service for creating and managing Vertex AI's pipelines. This includes both
   * `TrainingPipeline` resources (used for AutoML and custom training) and
   * `PipelineJob` resources (used for Vertex AI Pipelines).
   * </pre>
   */
  public static final class PipelineServiceFutureStub extends io.grpc.stub.AbstractFutureStub<PipelineServiceFutureStub> {
    private PipelineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PipelineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PipelineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Creates a TrainingPipeline. A created TrainingPipeline right away will be
     * attempted to be run.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.TrainingPipeline> createTrainingPipeline(
        com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTrainingPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a TrainingPipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.TrainingPipeline> getTrainingPipeline(
        com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrainingPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists TrainingPipelines in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse> listTrainingPipelines(
        com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTrainingPipelinesMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a TrainingPipeline.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteTrainingPipeline(
        com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTrainingPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancels a TrainingPipeline.
     * Starts asynchronous cancellation on the TrainingPipeline. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetTrainingPipeline][google.cloud.aiplatform.v1.PipelineService.GetTrainingPipeline]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the TrainingPipeline is not deleted; instead it becomes a pipeline with
     * a
     * [TrainingPipeline.error][google.cloud.aiplatform.v1.TrainingPipeline.error]
     * value with a [google.rpc.Status.code][google.rpc.Status.code] of 1,
     * corresponding to `Code.CANCELLED`, and
     * [TrainingPipeline.state][google.cloud.aiplatform.v1.TrainingPipeline.state]
     * is set to `CANCELLED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancelTrainingPipeline(
        com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelTrainingPipelineMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a PipelineJob. A PipelineJob will run immediately when created.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.PipelineJob> createPipelineJob(
        com.google.cloud.aiplatform.v1.CreatePipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePipelineJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets a PipelineJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.PipelineJob> getPipelineJob(
        com.google.cloud.aiplatform.v1.GetPipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPipelineJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists PipelineJobs in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.ListPipelineJobsResponse> listPipelineJobs(
        com.google.cloud.aiplatform.v1.ListPipelineJobsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPipelineJobsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a PipelineJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deletePipelineJob(
        com.google.cloud.aiplatform.v1.DeletePipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePipelineJobMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancels a PipelineJob.
     * Starts asynchronous cancellation on the PipelineJob. The server
     * makes a best effort to cancel the pipeline, but success is not
     * guaranteed. Clients can use
     * [PipelineService.GetPipelineJob][google.cloud.aiplatform.v1.PipelineService.GetPipelineJob]
     * or other methods to check whether the cancellation succeeded or whether the
     * pipeline completed despite cancellation. On successful cancellation,
     * the PipelineJob is not deleted; instead it becomes a pipeline with
     * a [PipelineJob.error][google.cloud.aiplatform.v1.PipelineJob.error] value
     * with a [google.rpc.Status.code][google.rpc.Status.code] of 1, corresponding
     * to `Code.CANCELLED`, and
     * [PipelineJob.state][google.cloud.aiplatform.v1.PipelineJob.state] is set to
     * `CANCELLED`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> cancelPipelineJob(
        com.google.cloud.aiplatform.v1.CancelPipelineJobRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelPipelineJobMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TRAINING_PIPELINE = 0;
  private static final int METHODID_GET_TRAINING_PIPELINE = 1;
  private static final int METHODID_LIST_TRAINING_PIPELINES = 2;
  private static final int METHODID_DELETE_TRAINING_PIPELINE = 3;
  private static final int METHODID_CANCEL_TRAINING_PIPELINE = 4;
  private static final int METHODID_CREATE_PIPELINE_JOB = 5;
  private static final int METHODID_GET_PIPELINE_JOB = 6;
  private static final int METHODID_LIST_PIPELINE_JOBS = 7;
  private static final int METHODID_DELETE_PIPELINE_JOB = 8;
  private static final int METHODID_CANCEL_PIPELINE_JOB = 9;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PipelineServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PipelineServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TRAINING_PIPELINE:
          serviceImpl.createTrainingPipeline((com.google.cloud.aiplatform.v1.CreateTrainingPipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline>) responseObserver);
          break;
        case METHODID_GET_TRAINING_PIPELINE:
          serviceImpl.getTrainingPipeline((com.google.cloud.aiplatform.v1.GetTrainingPipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.TrainingPipeline>) responseObserver);
          break;
        case METHODID_LIST_TRAINING_PIPELINES:
          serviceImpl.listTrainingPipelines((com.google.cloud.aiplatform.v1.ListTrainingPipelinesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrainingPipelinesResponse>) responseObserver);
          break;
        case METHODID_DELETE_TRAINING_PIPELINE:
          serviceImpl.deleteTrainingPipeline((com.google.cloud.aiplatform.v1.DeleteTrainingPipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_TRAINING_PIPELINE:
          serviceImpl.cancelTrainingPipeline((com.google.cloud.aiplatform.v1.CancelTrainingPipelineRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_PIPELINE_JOB:
          serviceImpl.createPipelineJob((com.google.cloud.aiplatform.v1.CreatePipelineJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob>) responseObserver);
          break;
        case METHODID_GET_PIPELINE_JOB:
          serviceImpl.getPipelineJob((com.google.cloud.aiplatform.v1.GetPipelineJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.PipelineJob>) responseObserver);
          break;
        case METHODID_LIST_PIPELINE_JOBS:
          serviceImpl.listPipelineJobs((com.google.cloud.aiplatform.v1.ListPipelineJobsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListPipelineJobsResponse>) responseObserver);
          break;
        case METHODID_DELETE_PIPELINE_JOB:
          serviceImpl.deletePipelineJob((com.google.cloud.aiplatform.v1.DeletePipelineJobRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CANCEL_PIPELINE_JOB:
          serviceImpl.cancelPipelineJob((com.google.cloud.aiplatform.v1.CancelPipelineJobRequest) request,
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

  private static abstract class PipelineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PipelineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.PipelineServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PipelineService");
    }
  }

  private static final class PipelineServiceFileDescriptorSupplier
      extends PipelineServiceBaseDescriptorSupplier {
    PipelineServiceFileDescriptorSupplier() {}
  }

  private static final class PipelineServiceMethodDescriptorSupplier
      extends PipelineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PipelineServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PipelineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PipelineServiceFileDescriptorSupplier())
              .addMethod(getCreateTrainingPipelineMethod())
              .addMethod(getGetTrainingPipelineMethod())
              .addMethod(getListTrainingPipelinesMethod())
              .addMethod(getDeleteTrainingPipelineMethod())
              .addMethod(getCancelTrainingPipelineMethod())
              .addMethod(getCreatePipelineJobMethod())
              .addMethod(getGetPipelineJobMethod())
              .addMethod(getListPipelineJobsMethod())
              .addMethod(getDeletePipelineJobMethod())
              .addMethod(getCancelPipelineJobMethod())
              .build();
        }
      }
    }
    return result;
  }
}
