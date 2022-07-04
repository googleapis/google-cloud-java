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
package com.google.monitoring.v3;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
 * managing and querying aspects of a workspace's services. These include the
 * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
 * of categorized Health Metrics.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/monitoring/v3/service_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServiceMonitoringServiceGrpc {

  private ServiceMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.ServiceMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.monitoring.v3.CreateServiceRequest.class,
      responseType = com.google.monitoring.v3.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      getCreateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
        getCreateServiceMethod;
    if ((getCreateServiceMethod = ServiceMonitoringServiceGrpc.getCreateServiceMethod) == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getCreateServiceMethod = ServiceMonitoringServiceGrpc.getCreateServiceMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getCreateServiceMethod =
              getCreateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.CreateServiceRequest,
                          com.google.monitoring.v3.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.CreateServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier("CreateService"))
                      .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.monitoring.v3.GetServiceRequest.class,
      responseType = com.google.monitoring.v3.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = ServiceMonitoringServiceGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getGetServiceMethod = ServiceMonitoringServiceGrpc.getGetServiceMethod) == null) {
          ServiceMonitoringServiceGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.GetServiceRequest,
                          com.google.monitoring.v3.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.GetServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.monitoring.v3.ListServicesRequest.class,
      responseType = com.google.monitoring.v3.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListServicesRequest,
            com.google.monitoring.v3.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = ServiceMonitoringServiceGrpc.getListServicesMethod) == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getListServicesMethod = ServiceMonitoringServiceGrpc.getListServicesMethod) == null) {
          ServiceMonitoringServiceGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListServicesRequest,
                          com.google.monitoring.v3.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListServicesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListServicesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.monitoring.v3.UpdateServiceRequest.class,
      responseType = com.google.monitoring.v3.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = ServiceMonitoringServiceGrpc.getUpdateServiceMethod) == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getUpdateServiceMethod = ServiceMonitoringServiceGrpc.getUpdateServiceMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.UpdateServiceRequest,
                          com.google.monitoring.v3.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UpdateServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.monitoring.v3.DeleteServiceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServiceMonitoringServiceGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getDeleteServiceMethod = ServiceMonitoringServiceGrpc.getDeleteServiceMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.DeleteServiceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getCreateServiceLevelObjectiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServiceLevelObjective",
      requestType = com.google.monitoring.v3.CreateServiceLevelObjectiveRequest.class,
      responseType = com.google.monitoring.v3.ServiceLevelObjective.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getCreateServiceLevelObjectiveMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
            com.google.monitoring.v3.ServiceLevelObjective>
        getCreateServiceLevelObjectiveMethod;
    if ((getCreateServiceLevelObjectiveMethod =
            ServiceMonitoringServiceGrpc.getCreateServiceLevelObjectiveMethod)
        == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getCreateServiceLevelObjectiveMethod =
                ServiceMonitoringServiceGrpc.getCreateServiceLevelObjectiveMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getCreateServiceLevelObjectiveMethod =
              getCreateServiceLevelObjectiveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
                          com.google.monitoring.v3.ServiceLevelObjective>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServiceLevelObjective"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.CreateServiceLevelObjectiveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ServiceLevelObjective.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier(
                              "CreateServiceLevelObjective"))
                      .build();
        }
      }
    }
    return getCreateServiceLevelObjectiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getGetServiceLevelObjectiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServiceLevelObjective",
      requestType = com.google.monitoring.v3.GetServiceLevelObjectiveRequest.class,
      responseType = com.google.monitoring.v3.ServiceLevelObjective.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getGetServiceLevelObjectiveMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
            com.google.monitoring.v3.ServiceLevelObjective>
        getGetServiceLevelObjectiveMethod;
    if ((getGetServiceLevelObjectiveMethod =
            ServiceMonitoringServiceGrpc.getGetServiceLevelObjectiveMethod)
        == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getGetServiceLevelObjectiveMethod =
                ServiceMonitoringServiceGrpc.getGetServiceLevelObjectiveMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getGetServiceLevelObjectiveMethod =
              getGetServiceLevelObjectiveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
                          com.google.monitoring.v3.ServiceLevelObjective>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetServiceLevelObjective"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.GetServiceLevelObjectiveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ServiceLevelObjective.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier(
                              "GetServiceLevelObjective"))
                      .build();
        }
      }
    }
    return getGetServiceLevelObjectiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      getListServiceLevelObjectivesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServiceLevelObjectives",
      requestType = com.google.monitoring.v3.ListServiceLevelObjectivesRequest.class,
      responseType = com.google.monitoring.v3.ListServiceLevelObjectivesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      getListServiceLevelObjectivesMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
            com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
        getListServiceLevelObjectivesMethod;
    if ((getListServiceLevelObjectivesMethod =
            ServiceMonitoringServiceGrpc.getListServiceLevelObjectivesMethod)
        == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getListServiceLevelObjectivesMethod =
                ServiceMonitoringServiceGrpc.getListServiceLevelObjectivesMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getListServiceLevelObjectivesMethod =
              getListServiceLevelObjectivesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
                          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListServiceLevelObjectives"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListServiceLevelObjectivesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ListServiceLevelObjectivesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier(
                              "ListServiceLevelObjectives"))
                      .build();
        }
      }
    }
    return getListServiceLevelObjectivesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getUpdateServiceLevelObjectiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServiceLevelObjective",
      requestType = com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest.class,
      responseType = com.google.monitoring.v3.ServiceLevelObjective.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getUpdateServiceLevelObjectiveMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
            com.google.monitoring.v3.ServiceLevelObjective>
        getUpdateServiceLevelObjectiveMethod;
    if ((getUpdateServiceLevelObjectiveMethod =
            ServiceMonitoringServiceGrpc.getUpdateServiceLevelObjectiveMethod)
        == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getUpdateServiceLevelObjectiveMethod =
                ServiceMonitoringServiceGrpc.getUpdateServiceLevelObjectiveMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getUpdateServiceLevelObjectiveMethod =
              getUpdateServiceLevelObjectiveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
                          com.google.monitoring.v3.ServiceLevelObjective>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServiceLevelObjective"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.ServiceLevelObjective.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier(
                              "UpdateServiceLevelObjective"))
                      .build();
        }
      }
    }
    return getUpdateServiceLevelObjectiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      getDeleteServiceLevelObjectiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServiceLevelObjective",
      requestType = com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      getDeleteServiceLevelObjectiveMethod() {
    io.grpc.MethodDescriptor<
            com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
        getDeleteServiceLevelObjectiveMethod;
    if ((getDeleteServiceLevelObjectiveMethod =
            ServiceMonitoringServiceGrpc.getDeleteServiceLevelObjectiveMethod)
        == null) {
      synchronized (ServiceMonitoringServiceGrpc.class) {
        if ((getDeleteServiceLevelObjectiveMethod =
                ServiceMonitoringServiceGrpc.getDeleteServiceLevelObjectiveMethod)
            == null) {
          ServiceMonitoringServiceGrpc.getDeleteServiceLevelObjectiveMethod =
              getDeleteServiceLevelObjectiveMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServiceLevelObjective"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServiceMonitoringServiceMethodDescriptorSupplier(
                              "DeleteServiceLevelObjective"))
                      .build();
        }
      }
    }
    return getDeleteServiceLevelObjectiveMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServiceMonitoringServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceStub>() {
          @java.lang.Override
          public ServiceMonitoringServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceMonitoringServiceStub(channel, callOptions);
          }
        };
    return ServiceMonitoringServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceMonitoringServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceBlockingStub>() {
          @java.lang.Override
          public ServiceMonitoringServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceMonitoringServiceBlockingStub(channel, callOptions);
          }
        };
    return ServiceMonitoringServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServiceMonitoringServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServiceMonitoringServiceFutureStub>() {
          @java.lang.Override
          public ServiceMonitoringServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServiceMonitoringServiceFutureStub(channel, callOptions);
          }
        };
    return ServiceMonitoringServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public abstract static class ServiceMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a `Service`.
     * </pre>
     */
    public void createService(
        com.google.monitoring.v3.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the named `Service`.
     * </pre>
     */
    public void getService(
        com.google.monitoring.v3.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List `Service`s for this workspace.
     * </pre>
     */
    public void listServices(
        com.google.monitoring.v3.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update this `Service`.
     * </pre>
     */
    public void updateService(
        com.google.monitoring.v3.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Soft delete this `Service`.
     * </pre>
     */
    public void deleteService(
        com.google.monitoring.v3.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a `ServiceLevelObjective` for the given `Service`.
     * </pre>
     */
    public void createServiceLevelObjective(
        com.google.monitoring.v3.CreateServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceLevelObjectiveMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a `ServiceLevelObjective` by name.
     * </pre>
     */
    public void getServiceLevelObjective(
        com.google.monitoring.v3.GetServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServiceLevelObjectiveMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the `ServiceLevelObjective`s for the given `Service`.
     * </pre>
     */
    public void listServiceLevelObjectives(
        com.google.monitoring.v3.ListServiceLevelObjectivesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServiceLevelObjectivesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the given `ServiceLevelObjective`.
     * </pre>
     */
    public void updateServiceLevelObjective(
        com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceLevelObjectiveMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the given `ServiceLevelObjective`.
     * </pre>
     */
    public void deleteServiceLevelObjective(
        com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceLevelObjectiveMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateServiceRequest,
                      com.google.monitoring.v3.Service>(this, METHODID_CREATE_SERVICE)))
          .addMethod(
              getGetServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>(
                      this, METHODID_GET_SERVICE)))
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListServicesRequest,
                      com.google.monitoring.v3.ListServicesResponse>(this, METHODID_LIST_SERVICES)))
          .addMethod(
              getUpdateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateServiceRequest,
                      com.google.monitoring.v3.Service>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SERVICE)))
          .addMethod(
              getCreateServiceLevelObjectiveMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_CREATE_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getGetServiceLevelObjectiveMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_GET_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getListServiceLevelObjectivesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
                      com.google.monitoring.v3.ListServiceLevelObjectivesResponse>(
                      this, METHODID_LIST_SERVICE_LEVEL_OBJECTIVES)))
          .addMethod(
              getUpdateServiceLevelObjectiveMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_UPDATE_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getDeleteServiceLevelObjectiveMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SERVICE_LEVEL_OBJECTIVE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ServiceMonitoringServiceStub> {
    private ServiceMonitoringServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMonitoringServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMonitoringServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a `Service`.
     * </pre>
     */
    public void createService(
        com.google.monitoring.v3.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get the named `Service`.
     * </pre>
     */
    public void getService(
        com.google.monitoring.v3.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List `Service`s for this workspace.
     * </pre>
     */
    public void listServices(
        com.google.monitoring.v3.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update this `Service`.
     * </pre>
     */
    public void updateService(
        com.google.monitoring.v3.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Soft delete this `Service`.
     * </pre>
     */
    public void deleteService(
        com.google.monitoring.v3.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a `ServiceLevelObjective` for the given `Service`.
     * </pre>
     */
    public void createServiceLevelObjective(
        com.google.monitoring.v3.CreateServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceLevelObjectiveMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a `ServiceLevelObjective` by name.
     * </pre>
     */
    public void getServiceLevelObjective(
        com.google.monitoring.v3.GetServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceLevelObjectiveMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List the `ServiceLevelObjective`s for the given `Service`.
     * </pre>
     */
    public void listServiceLevelObjectives(
        com.google.monitoring.v3.ListServiceLevelObjectivesRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServiceLevelObjectivesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update the given `ServiceLevelObjective`.
     * </pre>
     */
    public void updateServiceLevelObjective(
        com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceLevelObjectiveMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the given `ServiceLevelObjective`.
     * </pre>
     */
    public void deleteServiceLevelObjective(
        com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServiceLevelObjectiveMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServiceMonitoringServiceBlockingStub> {
    private ServiceMonitoringServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMonitoringServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMonitoringServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a `Service`.
     * </pre>
     */
    public com.google.monitoring.v3.Service createService(
        com.google.monitoring.v3.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get the named `Service`.
     * </pre>
     */
    public com.google.monitoring.v3.Service getService(
        com.google.monitoring.v3.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List `Service`s for this workspace.
     * </pre>
     */
    public com.google.monitoring.v3.ListServicesResponse listServices(
        com.google.monitoring.v3.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update this `Service`.
     * </pre>
     */
    public com.google.monitoring.v3.Service updateService(
        com.google.monitoring.v3.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Soft delete this `Service`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteService(
        com.google.monitoring.v3.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a `ServiceLevelObjective` for the given `Service`.
     * </pre>
     */
    public com.google.monitoring.v3.ServiceLevelObjective createServiceLevelObjective(
        com.google.monitoring.v3.CreateServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceLevelObjectiveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a `ServiceLevelObjective` by name.
     * </pre>
     */
    public com.google.monitoring.v3.ServiceLevelObjective getServiceLevelObjective(
        com.google.monitoring.v3.GetServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceLevelObjectiveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List the `ServiceLevelObjective`s for the given `Service`.
     * </pre>
     */
    public com.google.monitoring.v3.ListServiceLevelObjectivesResponse listServiceLevelObjectives(
        com.google.monitoring.v3.ListServiceLevelObjectivesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServiceLevelObjectivesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update the given `ServiceLevelObjective`.
     * </pre>
     */
    public com.google.monitoring.v3.ServiceLevelObjective updateServiceLevelObjective(
        com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceLevelObjectiveMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the given `ServiceLevelObjective`.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServiceLevelObjective(
        com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceLevelObjectiveMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Cloud Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServiceMonitoringServiceFutureStub> {
    private ServiceMonitoringServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceMonitoringServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceMonitoringServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Service>
        createService(com.google.monitoring.v3.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get the named `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Service>
        getService(com.google.monitoring.v3.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List `Service`s for this workspace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListServicesResponse>
        listServices(com.google.monitoring.v3.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update this `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.monitoring.v3.Service>
        updateService(com.google.monitoring.v3.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Soft delete this `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteService(com.google.monitoring.v3.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a `ServiceLevelObjective` for the given `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ServiceLevelObjective>
        createServiceLevelObjective(
            com.google.monitoring.v3.CreateServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceLevelObjectiveMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a `ServiceLevelObjective` by name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ServiceLevelObjective>
        getServiceLevelObjective(com.google.monitoring.v3.GetServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceLevelObjectiveMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List the `ServiceLevelObjective`s for the given `Service`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
        listServiceLevelObjectives(
            com.google.monitoring.v3.ListServiceLevelObjectivesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServiceLevelObjectivesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update the given `ServiceLevelObjective`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.monitoring.v3.ServiceLevelObjective>
        updateServiceLevelObjective(
            com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceLevelObjectiveMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the given `ServiceLevelObjective`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteServiceLevelObjective(
            com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceLevelObjectiveMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVICE = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_LIST_SERVICES = 2;
  private static final int METHODID_UPDATE_SERVICE = 3;
  private static final int METHODID_DELETE_SERVICE = 4;
  private static final int METHODID_CREATE_SERVICE_LEVEL_OBJECTIVE = 5;
  private static final int METHODID_GET_SERVICE_LEVEL_OBJECTIVE = 6;
  private static final int METHODID_LIST_SERVICE_LEVEL_OBJECTIVES = 7;
  private static final int METHODID_UPDATE_SERVICE_LEVEL_OBJECTIVE = 8;
  private static final int METHODID_DELETE_SERVICE_LEVEL_OBJECTIVE = 9;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService(
              (com.google.monitoring.v3.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.monitoring.v3.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service>) responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.monitoring.v3.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.monitoring.v3.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.Service>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.monitoring.v3.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE_LEVEL_OBJECTIVE:
          serviceImpl.createServiceLevelObjective(
              (com.google.monitoring.v3.CreateServiceLevelObjectiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE_LEVEL_OBJECTIVE:
          serviceImpl.getServiceLevelObjective(
              (com.google.monitoring.v3.GetServiceLevelObjectiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVICE_LEVEL_OBJECTIVES:
          serviceImpl.listServiceLevelObjectives(
              (com.google.monitoring.v3.ListServiceLevelObjectivesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.monitoring.v3.ListServiceLevelObjectivesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SERVICE_LEVEL_OBJECTIVE:
          serviceImpl.updateServiceLevelObjective(
              (com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest) request,
              (io.grpc.stub.StreamObserver<com.google.monitoring.v3.ServiceLevelObjective>)
                  responseObserver);
          break;
        case METHODID_DELETE_SERVICE_LEVEL_OBJECTIVE:
          serviceImpl.deleteServiceLevelObjective(
              (com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest) request,
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

  private abstract static class ServiceMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.monitoring.v3.ServiceMonitoringServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceMonitoringService");
    }
  }

  private static final class ServiceMonitoringServiceFileDescriptorSupplier
      extends ServiceMonitoringServiceBaseDescriptorSupplier {
    ServiceMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMonitoringServiceMethodDescriptorSupplier
      extends ServiceMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceMonitoringServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServiceMonitoringServiceFileDescriptorSupplier())
                      .addMethod(getCreateServiceMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getListServicesMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
                      .addMethod(getCreateServiceLevelObjectiveMethod())
                      .addMethod(getGetServiceLevelObjectiveMethod())
                      .addMethod(getListServiceLevelObjectivesMethod())
                      .addMethod(getUpdateServiceLevelObjectiveMethod())
                      .addMethod(getDeleteServiceLevelObjectiveMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
