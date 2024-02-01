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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * A service for creating and managing Vertex AI's Schedule resources to
 * periodically launch shceudled runs to make API calls.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/schedule_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ScheduleServiceGrpc {

  private ScheduleServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.aiplatform.v1.ScheduleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getCreateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateSchedule",
      requestType = com.google.cloud.aiplatform.v1.CreateScheduleRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Schedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getCreateScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateScheduleRequest,
            com.google.cloud.aiplatform.v1.Schedule>
        getCreateScheduleMethod;
    if ((getCreateScheduleMethod = ScheduleServiceGrpc.getCreateScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getCreateScheduleMethod = ScheduleServiceGrpc.getCreateScheduleMethod) == null) {
          ScheduleServiceGrpc.getCreateScheduleMethod =
              getCreateScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateScheduleRequest,
                          com.google.cloud.aiplatform.v1.Schedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Schedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("CreateSchedule"))
                      .build();
        }
      }
    }
    return getCreateScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
      getDeleteScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteSchedule",
      requestType = com.google.cloud.aiplatform.v1.DeleteScheduleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
      getDeleteScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteScheduleRequest, com.google.longrunning.Operation>
        getDeleteScheduleMethod;
    if ((getDeleteScheduleMethod = ScheduleServiceGrpc.getDeleteScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getDeleteScheduleMethod = ScheduleServiceGrpc.getDeleteScheduleMethod) == null) {
          ScheduleServiceGrpc.getDeleteScheduleMethod =
              getDeleteScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteScheduleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("DeleteSchedule"))
                      .build();
        }
      }
    }
    return getDeleteScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getGetScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSchedule",
      requestType = com.google.cloud.aiplatform.v1.GetScheduleRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Schedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getGetScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetScheduleRequest,
            com.google.cloud.aiplatform.v1.Schedule>
        getGetScheduleMethod;
    if ((getGetScheduleMethod = ScheduleServiceGrpc.getGetScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getGetScheduleMethod = ScheduleServiceGrpc.getGetScheduleMethod) == null) {
          ScheduleServiceGrpc.getGetScheduleMethod =
              getGetScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetScheduleRequest,
                          com.google.cloud.aiplatform.v1.Schedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Schedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("GetSchedule"))
                      .build();
        }
      }
    }
    return getGetScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListSchedulesRequest,
          com.google.cloud.aiplatform.v1.ListSchedulesResponse>
      getListSchedulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSchedules",
      requestType = com.google.cloud.aiplatform.v1.ListSchedulesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListSchedulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListSchedulesRequest,
          com.google.cloud.aiplatform.v1.ListSchedulesResponse>
      getListSchedulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListSchedulesRequest,
            com.google.cloud.aiplatform.v1.ListSchedulesResponse>
        getListSchedulesMethod;
    if ((getListSchedulesMethod = ScheduleServiceGrpc.getListSchedulesMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getListSchedulesMethod = ScheduleServiceGrpc.getListSchedulesMethod) == null) {
          ScheduleServiceGrpc.getListSchedulesMethod =
              getListSchedulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListSchedulesRequest,
                          com.google.cloud.aiplatform.v1.ListSchedulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSchedules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListSchedulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListSchedulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("ListSchedules"))
                      .build();
        }
      }
    }
    return getListSchedulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.PauseScheduleRequest, com.google.protobuf.Empty>
      getPauseScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseSchedule",
      requestType = com.google.cloud.aiplatform.v1.PauseScheduleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.PauseScheduleRequest, com.google.protobuf.Empty>
      getPauseScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.PauseScheduleRequest, com.google.protobuf.Empty>
        getPauseScheduleMethod;
    if ((getPauseScheduleMethod = ScheduleServiceGrpc.getPauseScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getPauseScheduleMethod = ScheduleServiceGrpc.getPauseScheduleMethod) == null) {
          ScheduleServiceGrpc.getPauseScheduleMethod =
              getPauseScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.PauseScheduleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.PauseScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("PauseSchedule"))
                      .build();
        }
      }
    }
    return getPauseScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ResumeScheduleRequest, com.google.protobuf.Empty>
      getResumeScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeSchedule",
      requestType = com.google.cloud.aiplatform.v1.ResumeScheduleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ResumeScheduleRequest, com.google.protobuf.Empty>
      getResumeScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ResumeScheduleRequest, com.google.protobuf.Empty>
        getResumeScheduleMethod;
    if ((getResumeScheduleMethod = ScheduleServiceGrpc.getResumeScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getResumeScheduleMethod = ScheduleServiceGrpc.getResumeScheduleMethod) == null) {
          ScheduleServiceGrpc.getResumeScheduleMethod =
              getResumeScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ResumeScheduleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ResumeScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("ResumeSchedule"))
                      .build();
        }
      }
    }
    return getResumeScheduleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getUpdateScheduleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSchedule",
      requestType = com.google.cloud.aiplatform.v1.UpdateScheduleRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Schedule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.UpdateScheduleRequest,
          com.google.cloud.aiplatform.v1.Schedule>
      getUpdateScheduleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.UpdateScheduleRequest,
            com.google.cloud.aiplatform.v1.Schedule>
        getUpdateScheduleMethod;
    if ((getUpdateScheduleMethod = ScheduleServiceGrpc.getUpdateScheduleMethod) == null) {
      synchronized (ScheduleServiceGrpc.class) {
        if ((getUpdateScheduleMethod = ScheduleServiceGrpc.getUpdateScheduleMethod) == null) {
          ScheduleServiceGrpc.getUpdateScheduleMethod =
              getUpdateScheduleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.UpdateScheduleRequest,
                          com.google.cloud.aiplatform.v1.Schedule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSchedule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.UpdateScheduleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Schedule.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ScheduleServiceMethodDescriptorSupplier("UpdateSchedule"))
                      .build();
        }
      }
    }
    return getUpdateScheduleMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ScheduleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceStub>() {
          @java.lang.Override
          public ScheduleServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScheduleServiceStub(channel, callOptions);
          }
        };
    return ScheduleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ScheduleServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceBlockingStub>() {
          @java.lang.Override
          public ScheduleServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScheduleServiceBlockingStub(channel, callOptions);
          }
        };
    return ScheduleServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ScheduleServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ScheduleServiceFutureStub>() {
          @java.lang.Override
          public ScheduleServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ScheduleServiceFutureStub(channel, callOptions);
          }
        };
    return ScheduleServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * A service for creating and managing Vertex AI's Schedule resources to
   * periodically launch shceudled runs to make API calls.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a Schedule.
     * </pre>
     */
    default void createSchedule(
        com.google.cloud.aiplatform.v1.CreateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Schedule.
     * </pre>
     */
    default void deleteSchedule(
        com.google.cloud.aiplatform.v1.DeleteScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Schedule.
     * </pre>
     */
    default void getSchedule(
        com.google.cloud.aiplatform.v1.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Schedules in a Location.
     * </pre>
     */
    default void listSchedules(
        com.google.cloud.aiplatform.v1.ListSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSchedulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a Schedule. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'PAUSED'. If
     * the schedule is paused, no new runs will be created. Already created runs
     * will NOT be paused or canceled.
     * </pre>
     */
    default void pauseSchedule(
        com.google.cloud.aiplatform.v1.PauseScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused Schedule to start scheduling new runs. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'ACTIVE'.
     * Only paused Schedule can be resumed.
     * When the Schedule is resumed, new runs will be scheduled starting from the
     * next execution time after the current time based on the time_specification
     * in the Schedule. If [Schedule.catchUp][] is set up true, all
     * missed runs will be scheduled for backfill first.
     * </pre>
     */
    default void resumeSchedule(
        com.google.cloud.aiplatform.v1.ResumeScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeScheduleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an active or paused Schedule.
     * When the Schedule is updated, new runs will be scheduled starting from the
     * updated next execution time after the update time based on the
     * time_specification in the updated Schedule. All unstarted runs before the
     * update time will be skipped while already created runs will NOT be paused
     * or canceled.
     * </pre>
     */
    default void updateSchedule(
        com.google.cloud.aiplatform.v1.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateScheduleMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ScheduleService.
   *
   * <pre>
   * A service for creating and managing Vertex AI's Schedule resources to
   * periodically launch shceudled runs to make API calls.
   * </pre>
   */
  public abstract static class ScheduleServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ScheduleServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ScheduleService.
   *
   * <pre>
   * A service for creating and managing Vertex AI's Schedule resources to
   * periodically launch shceudled runs to make API calls.
   * </pre>
   */
  public static final class ScheduleServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ScheduleServiceStub> {
    private ScheduleServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Schedule.
     * </pre>
     */
    public void createSchedule(
        com.google.cloud.aiplatform.v1.CreateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Schedule.
     * </pre>
     */
    public void deleteSchedule(
        com.google.cloud.aiplatform.v1.DeleteScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Schedule.
     * </pre>
     */
    public void getSchedule(
        com.google.cloud.aiplatform.v1.GetScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Schedules in a Location.
     * </pre>
     */
    public void listSchedules(
        com.google.cloud.aiplatform.v1.ListSchedulesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSchedulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSchedulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses a Schedule. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'PAUSED'. If
     * the schedule is paused, no new runs will be created. Already created runs
     * will NOT be paused or canceled.
     * </pre>
     */
    public void pauseSchedule(
        com.google.cloud.aiplatform.v1.PauseScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused Schedule to start scheduling new runs. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'ACTIVE'.
     * Only paused Schedule can be resumed.
     * When the Schedule is resumed, new runs will be scheduled starting from the
     * next execution time after the current time based on the time_specification
     * in the Schedule. If [Schedule.catchUp][] is set up true, all
     * missed runs will be scheduled for backfill first.
     * </pre>
     */
    public void resumeSchedule(
        com.google.cloud.aiplatform.v1.ResumeScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an active or paused Schedule.
     * When the Schedule is updated, new runs will be scheduled starting from the
     * updated next execution time after the update time based on the
     * time_specification in the updated Schedule. All unstarted runs before the
     * update time will be skipped while already created runs will NOT be paused
     * or canceled.
     * </pre>
     */
    public void updateSchedule(
        com.google.cloud.aiplatform.v1.UpdateScheduleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ScheduleService.
   *
   * <pre>
   * A service for creating and managing Vertex AI's Schedule resources to
   * periodically launch shceudled runs to make API calls.
   * </pre>
   */
  public static final class ScheduleServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ScheduleServiceBlockingStub> {
    private ScheduleServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Schedule.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Schedule createSchedule(
        com.google.cloud.aiplatform.v1.CreateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Schedule.
     * </pre>
     */
    public com.google.longrunning.Operation deleteSchedule(
        com.google.cloud.aiplatform.v1.DeleteScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Schedule.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Schedule getSchedule(
        com.google.cloud.aiplatform.v1.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Schedules in a Location.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListSchedulesResponse listSchedules(
        com.google.cloud.aiplatform.v1.ListSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSchedulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a Schedule. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'PAUSED'. If
     * the schedule is paused, no new runs will be created. Already created runs
     * will NOT be paused or canceled.
     * </pre>
     */
    public com.google.protobuf.Empty pauseSchedule(
        com.google.cloud.aiplatform.v1.PauseScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused Schedule to start scheduling new runs. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'ACTIVE'.
     * Only paused Schedule can be resumed.
     * When the Schedule is resumed, new runs will be scheduled starting from the
     * next execution time after the current time based on the time_specification
     * in the Schedule. If [Schedule.catchUp][] is set up true, all
     * missed runs will be scheduled for backfill first.
     * </pre>
     */
    public com.google.protobuf.Empty resumeSchedule(
        com.google.cloud.aiplatform.v1.ResumeScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeScheduleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an active or paused Schedule.
     * When the Schedule is updated, new runs will be scheduled starting from the
     * updated next execution time after the update time based on the
     * time_specification in the updated Schedule. All unstarted runs before the
     * update time will be skipped while already created runs will NOT be paused
     * or canceled.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Schedule updateSchedule(
        com.google.cloud.aiplatform.v1.UpdateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateScheduleMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ScheduleService.
   *
   * <pre>
   * A service for creating and managing Vertex AI's Schedule resources to
   * periodically launch shceudled runs to make API calls.
   * </pre>
   */
  public static final class ScheduleServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ScheduleServiceFutureStub> {
    private ScheduleServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ScheduleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ScheduleServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Schedule>
        createSchedule(com.google.cloud.aiplatform.v1.CreateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteSchedule(com.google.cloud.aiplatform.v1.DeleteScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Schedule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Schedule>
        getSchedule(com.google.cloud.aiplatform.v1.GetScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Schedules in a Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListSchedulesResponse>
        listSchedules(com.google.cloud.aiplatform.v1.ListSchedulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSchedulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses a Schedule. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'PAUSED'. If
     * the schedule is paused, no new runs will be created. Already created runs
     * will NOT be paused or canceled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        pauseSchedule(com.google.cloud.aiplatform.v1.PauseScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes a paused Schedule to start scheduling new runs. Will mark
     * [Schedule.state][google.cloud.aiplatform.v1.Schedule.state] to 'ACTIVE'.
     * Only paused Schedule can be resumed.
     * When the Schedule is resumed, new runs will be scheduled starting from the
     * next execution time after the current time based on the time_specification
     * in the Schedule. If [Schedule.catchUp][] is set up true, all
     * missed runs will be scheduled for backfill first.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        resumeSchedule(com.google.cloud.aiplatform.v1.ResumeScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeScheduleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an active or paused Schedule.
     * When the Schedule is updated, new runs will be scheduled starting from the
     * updated next execution time after the update time based on the
     * time_specification in the updated Schedule. All unstarted runs before the
     * update time will be skipped while already created runs will NOT be paused
     * or canceled.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.Schedule>
        updateSchedule(com.google.cloud.aiplatform.v1.UpdateScheduleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateScheduleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SCHEDULE = 0;
  private static final int METHODID_DELETE_SCHEDULE = 1;
  private static final int METHODID_GET_SCHEDULE = 2;
  private static final int METHODID_LIST_SCHEDULES = 3;
  private static final int METHODID_PAUSE_SCHEDULE = 4;
  private static final int METHODID_RESUME_SCHEDULE = 5;
  private static final int METHODID_UPDATE_SCHEDULE = 6;

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
        case METHODID_CREATE_SCHEDULE:
          serviceImpl.createSchedule(
              (com.google.cloud.aiplatform.v1.CreateScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule>)
                  responseObserver);
          break;
        case METHODID_DELETE_SCHEDULE:
          serviceImpl.deleteSchedule(
              (com.google.cloud.aiplatform.v1.DeleteScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_SCHEDULE:
          serviceImpl.getSchedule(
              (com.google.cloud.aiplatform.v1.GetScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule>)
                  responseObserver);
          break;
        case METHODID_LIST_SCHEDULES:
          serviceImpl.listSchedules(
              (com.google.cloud.aiplatform.v1.ListSchedulesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListSchedulesResponse>)
                  responseObserver);
          break;
        case METHODID_PAUSE_SCHEDULE:
          serviceImpl.pauseSchedule(
              (com.google.cloud.aiplatform.v1.PauseScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_RESUME_SCHEDULE:
          serviceImpl.resumeSchedule(
              (com.google.cloud.aiplatform.v1.ResumeScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SCHEDULE:
          serviceImpl.updateSchedule(
              (com.google.cloud.aiplatform.v1.UpdateScheduleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Schedule>)
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
            getCreateScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.CreateScheduleRequest,
                    com.google.cloud.aiplatform.v1.Schedule>(service, METHODID_CREATE_SCHEDULE)))
        .addMethod(
            getDeleteScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.DeleteScheduleRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_SCHEDULE)))
        .addMethod(
            getGetScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.GetScheduleRequest,
                    com.google.cloud.aiplatform.v1.Schedule>(service, METHODID_GET_SCHEDULE)))
        .addMethod(
            getListSchedulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ListSchedulesRequest,
                    com.google.cloud.aiplatform.v1.ListSchedulesResponse>(
                    service, METHODID_LIST_SCHEDULES)))
        .addMethod(
            getPauseScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.PauseScheduleRequest, com.google.protobuf.Empty>(
                    service, METHODID_PAUSE_SCHEDULE)))
        .addMethod(
            getResumeScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.ResumeScheduleRequest,
                    com.google.protobuf.Empty>(service, METHODID_RESUME_SCHEDULE)))
        .addMethod(
            getUpdateScheduleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.aiplatform.v1.UpdateScheduleRequest,
                    com.google.cloud.aiplatform.v1.Schedule>(service, METHODID_UPDATE_SCHEDULE)))
        .build();
  }

  private abstract static class ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ScheduleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.ScheduleServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ScheduleService");
    }
  }

  private static final class ScheduleServiceFileDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier {
    ScheduleServiceFileDescriptorSupplier() {}
  }

  private static final class ScheduleServiceMethodDescriptorSupplier
      extends ScheduleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ScheduleServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ScheduleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ScheduleServiceFileDescriptorSupplier())
                      .addMethod(getCreateScheduleMethod())
                      .addMethod(getDeleteScheduleMethod())
                      .addMethod(getGetScheduleMethod())
                      .addMethod(getListSchedulesMethod())
                      .addMethod(getPauseScheduleMethod())
                      .addMethod(getResumeScheduleMethod())
                      .addMethod(getUpdateScheduleMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
