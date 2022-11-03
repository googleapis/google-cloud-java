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
package com.google.cloud.enterpriseknowledgegraph.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * APIs for enterprise knowledge graph product.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/enterpriseknowledgegraph/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EnterpriseKnowledgeGraphServiceGrpc {

  private EnterpriseKnowledgeGraphServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.enterpriseknowledgegraph.v1.EnterpriseKnowledgeGraphService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
      getCreateEntityReconciliationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEntityReconciliationJob",
      requestType =
          com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest.class,
      responseType = com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
      getCreateEntityReconciliationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest,
            com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
        getCreateEntityReconciliationJobMethod;
    if ((getCreateEntityReconciliationJobMethod =
            EnterpriseKnowledgeGraphServiceGrpc.getCreateEntityReconciliationJobMethod)
        == null) {
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        if ((getCreateEntityReconciliationJobMethod =
                EnterpriseKnowledgeGraphServiceGrpc.getCreateEntityReconciliationJobMethod)
            == null) {
          EnterpriseKnowledgeGraphServiceGrpc.getCreateEntityReconciliationJobMethod =
              getCreateEntityReconciliationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.enterpriseknowledgegraph.v1
                              .CreateEntityReconciliationJobRequest,
                          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEntityReconciliationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .CreateEntityReconciliationJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(
                              "CreateEntityReconciliationJob"))
                      .build();
        }
      }
    }
    return getCreateEntityReconciliationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
      getGetEntityReconciliationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEntityReconciliationJob",
      requestType =
          com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest.class,
      responseType = com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
      getGetEntityReconciliationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest,
            com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
        getGetEntityReconciliationJobMethod;
    if ((getGetEntityReconciliationJobMethod =
            EnterpriseKnowledgeGraphServiceGrpc.getGetEntityReconciliationJobMethod)
        == null) {
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        if ((getGetEntityReconciliationJobMethod =
                EnterpriseKnowledgeGraphServiceGrpc.getGetEntityReconciliationJobMethod)
            == null) {
          EnterpriseKnowledgeGraphServiceGrpc.getGetEntityReconciliationJobMethod =
              getGetEntityReconciliationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.enterpriseknowledgegraph.v1
                              .GetEntityReconciliationJobRequest,
                          com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEntityReconciliationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .GetEntityReconciliationJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(
                              "GetEntityReconciliationJob"))
                      .build();
        }
      }
    }
    return getGetEntityReconciliationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
      getListEntityReconciliationJobsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEntityReconciliationJobs",
      requestType =
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest.class,
      responseType =
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest,
          com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
      getListEntityReconciliationJobsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest,
            com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
        getListEntityReconciliationJobsMethod;
    if ((getListEntityReconciliationJobsMethod =
            EnterpriseKnowledgeGraphServiceGrpc.getListEntityReconciliationJobsMethod)
        == null) {
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        if ((getListEntityReconciliationJobsMethod =
                EnterpriseKnowledgeGraphServiceGrpc.getListEntityReconciliationJobsMethod)
            == null) {
          EnterpriseKnowledgeGraphServiceGrpc.getListEntityReconciliationJobsMethod =
              getListEntityReconciliationJobsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.enterpriseknowledgegraph.v1
                              .ListEntityReconciliationJobsRequest,
                          com.google.cloud.enterpriseknowledgegraph.v1
                              .ListEntityReconciliationJobsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEntityReconciliationJobs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .ListEntityReconciliationJobsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .ListEntityReconciliationJobsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(
                              "ListEntityReconciliationJobs"))
                      .build();
        }
      }
    }
    return getListEntityReconciliationJobsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest,
          com.google.protobuf.Empty>
      getCancelEntityReconciliationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelEntityReconciliationJob",
      requestType =
          com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest,
          com.google.protobuf.Empty>
      getCancelEntityReconciliationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest,
            com.google.protobuf.Empty>
        getCancelEntityReconciliationJobMethod;
    if ((getCancelEntityReconciliationJobMethod =
            EnterpriseKnowledgeGraphServiceGrpc.getCancelEntityReconciliationJobMethod)
        == null) {
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        if ((getCancelEntityReconciliationJobMethod =
                EnterpriseKnowledgeGraphServiceGrpc.getCancelEntityReconciliationJobMethod)
            == null) {
          EnterpriseKnowledgeGraphServiceGrpc.getCancelEntityReconciliationJobMethod =
              getCancelEntityReconciliationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.enterpriseknowledgegraph.v1
                              .CancelEntityReconciliationJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CancelEntityReconciliationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .CancelEntityReconciliationJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(
                              "CancelEntityReconciliationJob"))
                      .build();
        }
      }
    }
    return getCancelEntityReconciliationJobMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest,
          com.google.protobuf.Empty>
      getDeleteEntityReconciliationJobMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEntityReconciliationJob",
      requestType =
          com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest,
          com.google.protobuf.Empty>
      getDeleteEntityReconciliationJobMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest,
            com.google.protobuf.Empty>
        getDeleteEntityReconciliationJobMethod;
    if ((getDeleteEntityReconciliationJobMethod =
            EnterpriseKnowledgeGraphServiceGrpc.getDeleteEntityReconciliationJobMethod)
        == null) {
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        if ((getDeleteEntityReconciliationJobMethod =
                EnterpriseKnowledgeGraphServiceGrpc.getDeleteEntityReconciliationJobMethod)
            == null) {
          EnterpriseKnowledgeGraphServiceGrpc.getDeleteEntityReconciliationJobMethod =
              getDeleteEntityReconciliationJobMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.enterpriseknowledgegraph.v1
                              .DeleteEntityReconciliationJobRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEntityReconciliationJob"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.enterpriseknowledgegraph.v1
                                  .DeleteEntityReconciliationJobRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(
                              "DeleteEntityReconciliationJob"))
                      .build();
        }
      }
    }
    return getDeleteEntityReconciliationJobMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EnterpriseKnowledgeGraphServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceStub>() {
          @java.lang.Override
          public EnterpriseKnowledgeGraphServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnterpriseKnowledgeGraphServiceStub(channel, callOptions);
          }
        };
    return EnterpriseKnowledgeGraphServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EnterpriseKnowledgeGraphServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceBlockingStub>() {
          @java.lang.Override
          public EnterpriseKnowledgeGraphServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnterpriseKnowledgeGraphServiceBlockingStub(channel, callOptions);
          }
        };
    return EnterpriseKnowledgeGraphServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EnterpriseKnowledgeGraphServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EnterpriseKnowledgeGraphServiceFutureStub>() {
          @java.lang.Override
          public EnterpriseKnowledgeGraphServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EnterpriseKnowledgeGraphServiceFutureStub(channel, callOptions);
          }
        };
    return EnterpriseKnowledgeGraphServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * APIs for enterprise knowledge graph product.
   * </pre>
   */
  public abstract static class EnterpriseKnowledgeGraphServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a EntityReconciliationJob. A EntityReconciliationJob once created
     * will right away be attempted to start.
     * </pre>
     */
    public void createEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEntityReconciliationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a EntityReconciliationJob.
     * </pre>
     */
    public void getEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEntityReconciliationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Entity Reconciliation Jobs.
     * </pre>
     */
    public void listEntityReconciliationJobs(
        com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEntityReconciliationJobsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a EntityReconciliationJob. Success of cancellation is not
     * guaranteed.
     * </pre>
     */
    public void cancelEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCancelEntityReconciliationJobMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a EntityReconciliationJob.
     * It only deletes the job when the job state is in FAILED, SUCCEEDED, and
     * CANCELLED.
     * </pre>
     */
    public void deleteEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEntityReconciliationJobMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateEntityReconciliationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .CreateEntityReconciliationJobRequest,
                      com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>(
                      this, METHODID_CREATE_ENTITY_RECONCILIATION_JOB)))
          .addMethod(
              getGetEntityReconciliationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .GetEntityReconciliationJobRequest,
                      com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>(
                      this, METHODID_GET_ENTITY_RECONCILIATION_JOB)))
          .addMethod(
              getListEntityReconciliationJobsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .ListEntityReconciliationJobsRequest,
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .ListEntityReconciliationJobsResponse>(
                      this, METHODID_LIST_ENTITY_RECONCILIATION_JOBS)))
          .addMethod(
              getCancelEntityReconciliationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .CancelEntityReconciliationJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_CANCEL_ENTITY_RECONCILIATION_JOB)))
          .addMethod(
              getDeleteEntityReconciliationJobMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .DeleteEntityReconciliationJobRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENTITY_RECONCILIATION_JOB)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * APIs for enterprise knowledge graph product.
   * </pre>
   */
  public static final class EnterpriseKnowledgeGraphServiceStub
      extends io.grpc.stub.AbstractAsyncStub<EnterpriseKnowledgeGraphServiceStub> {
    private EnterpriseKnowledgeGraphServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnterpriseKnowledgeGraphServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnterpriseKnowledgeGraphServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a EntityReconciliationJob. A EntityReconciliationJob once created
     * will right away be attempted to start.
     * </pre>
     */
    public void createEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEntityReconciliationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a EntityReconciliationJob.
     * </pre>
     */
    public void getEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEntityReconciliationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Entity Reconciliation Jobs.
     * </pre>
     */
    public void listEntityReconciliationJobs(
        com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEntityReconciliationJobsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a EntityReconciliationJob. Success of cancellation is not
     * guaranteed.
     * </pre>
     */
    public void cancelEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelEntityReconciliationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a EntityReconciliationJob.
     * It only deletes the job when the job state is in FAILED, SUCCEEDED, and
     * CANCELLED.
     * </pre>
     */
    public void deleteEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEntityReconciliationJobMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * APIs for enterprise knowledge graph product.
   * </pre>
   */
  public static final class EnterpriseKnowledgeGraphServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EnterpriseKnowledgeGraphServiceBlockingStub> {
    private EnterpriseKnowledgeGraphServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnterpriseKnowledgeGraphServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnterpriseKnowledgeGraphServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a EntityReconciliationJob. A EntityReconciliationJob once created
     * will right away be attempted to start.
     * </pre>
     */
    public com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob
        createEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEntityReconciliationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a EntityReconciliationJob.
     * </pre>
     */
    public com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob
        getEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEntityReconciliationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Entity Reconciliation Jobs.
     * </pre>
     */
    public com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse
        listEntityReconciliationJobs(
            com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEntityReconciliationJobsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a EntityReconciliationJob. Success of cancellation is not
     * guaranteed.
     * </pre>
     */
    public com.google.protobuf.Empty cancelEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelEntityReconciliationJobMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a EntityReconciliationJob.
     * It only deletes the job when the job state is in FAILED, SUCCEEDED, and
     * CANCELLED.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEntityReconciliationJob(
        com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEntityReconciliationJobMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * APIs for enterprise knowledge graph product.
   * </pre>
   */
  public static final class EnterpriseKnowledgeGraphServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EnterpriseKnowledgeGraphServiceFutureStub> {
    private EnterpriseKnowledgeGraphServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EnterpriseKnowledgeGraphServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EnterpriseKnowledgeGraphServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a EntityReconciliationJob. A EntityReconciliationJob once created
     * will right away be attempted to start.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
        createEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEntityReconciliationJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Gets a EntityReconciliationJob.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>
        getEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEntityReconciliationJobMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Entity Reconciliation Jobs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsResponse>
        listEntityReconciliationJobs(
            com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEntityReconciliationJobsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a EntityReconciliationJob. Success of cancellation is not
     * guaranteed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        cancelEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelEntityReconciliationJobMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a EntityReconciliationJob.
     * It only deletes the job when the job state is in FAILED, SUCCEEDED, and
     * CANCELLED.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEntityReconciliationJob(
            com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEntityReconciliationJobMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_ENTITY_RECONCILIATION_JOB = 0;
  private static final int METHODID_GET_ENTITY_RECONCILIATION_JOB = 1;
  private static final int METHODID_LIST_ENTITY_RECONCILIATION_JOBS = 2;
  private static final int METHODID_CANCEL_ENTITY_RECONCILIATION_JOB = 3;
  private static final int METHODID_DELETE_ENTITY_RECONCILIATION_JOB = 4;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EnterpriseKnowledgeGraphServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EnterpriseKnowledgeGraphServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ENTITY_RECONCILIATION_JOB:
          serviceImpl.createEntityReconciliationJob(
              (com.google.cloud.enterpriseknowledgegraph.v1.CreateEntityReconciliationJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>)
                  responseObserver);
          break;
        case METHODID_GET_ENTITY_RECONCILIATION_JOB:
          serviceImpl.getEntityReconciliationJob(
              (com.google.cloud.enterpriseknowledgegraph.v1.GetEntityReconciliationJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.enterpriseknowledgegraph.v1.EntityReconciliationJob>)
                  responseObserver);
          break;
        case METHODID_LIST_ENTITY_RECONCILIATION_JOBS:
          serviceImpl.listEntityReconciliationJobs(
              (com.google.cloud.enterpriseknowledgegraph.v1.ListEntityReconciliationJobsRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.enterpriseknowledgegraph.v1
                          .ListEntityReconciliationJobsResponse>)
                  responseObserver);
          break;
        case METHODID_CANCEL_ENTITY_RECONCILIATION_JOB:
          serviceImpl.cancelEntityReconciliationJob(
              (com.google.cloud.enterpriseknowledgegraph.v1.CancelEntityReconciliationJobRequest)
                  request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_ENTITY_RECONCILIATION_JOB:
          serviceImpl.deleteEntityReconciliationJob(
              (com.google.cloud.enterpriseknowledgegraph.v1.DeleteEntityReconciliationJobRequest)
                  request,
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

  private abstract static class EnterpriseKnowledgeGraphServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EnterpriseKnowledgeGraphServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.enterpriseknowledgegraph.v1.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EnterpriseKnowledgeGraphService");
    }
  }

  private static final class EnterpriseKnowledgeGraphServiceFileDescriptorSupplier
      extends EnterpriseKnowledgeGraphServiceBaseDescriptorSupplier {
    EnterpriseKnowledgeGraphServiceFileDescriptorSupplier() {}
  }

  private static final class EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier
      extends EnterpriseKnowledgeGraphServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EnterpriseKnowledgeGraphServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EnterpriseKnowledgeGraphServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new EnterpriseKnowledgeGraphServiceFileDescriptorSupplier())
                      .addMethod(getCreateEntityReconciliationJobMethod())
                      .addMethod(getGetEntityReconciliationJobMethod())
                      .addMethod(getListEntityReconciliationJobsMethod())
                      .addMethod(getCancelEntityReconciliationJobMethod())
                      .addMethod(getDeleteEntityReconciliationJobMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
