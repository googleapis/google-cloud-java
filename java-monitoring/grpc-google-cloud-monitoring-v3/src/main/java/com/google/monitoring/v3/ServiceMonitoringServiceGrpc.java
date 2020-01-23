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
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * The Stackdriver Monitoring Service-Oriented Monitoring API has endpoints for
 * managing and querying aspects of a workspace's services. These include the
 * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
 * of categorized Health Metrics.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/monitoring/v3/service_service.proto")
public final class ServiceMonitoringServiceGrpc {

  private ServiceMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "google.monitoring.v3.ServiceMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateServiceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      METHOD_CREATE_SERVICE = getCreateServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      getCreateServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      getCreateServiceMethod() {
    return getCreateServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceRequest, com.google.monitoring.v3.Service>
      getCreateServiceMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService", "CreateService"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetServiceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      METHOD_GET_SERVICE = getGetServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      getGetServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      getGetServiceMethod() {
    return getGetServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>
      getGetServiceMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService", "GetService"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListServicesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      METHOD_LIST_SERVICES = getListServicesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      getListServicesMethod() {
    return getListServicesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServicesRequest,
          com.google.monitoring.v3.ListServicesResponse>
      getListServicesMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService", "ListServices"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateServiceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      METHOD_UPDATE_SERVICE = getUpdateServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      getUpdateServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      getUpdateServiceMethod() {
    return getUpdateServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceRequest, com.google.monitoring.v3.Service>
      getUpdateServiceMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService", "UpdateService"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteServiceMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SERVICE = getDeleteServiceMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod() {
    return getDeleteServiceMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethodHelper() {
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
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService", "DeleteService"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateServiceLevelObjectiveMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      METHOD_CREATE_SERVICE_LEVEL_OBJECTIVE = getCreateServiceLevelObjectiveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getCreateServiceLevelObjectiveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getCreateServiceLevelObjectiveMethod() {
    return getCreateServiceLevelObjectiveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getCreateServiceLevelObjectiveMethodHelper() {
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
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService",
                              "CreateServiceLevelObjective"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetServiceLevelObjectiveMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      METHOD_GET_SERVICE_LEVEL_OBJECTIVE = getGetServiceLevelObjectiveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getGetServiceLevelObjectiveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getGetServiceLevelObjectiveMethod() {
    return getGetServiceLevelObjectiveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getGetServiceLevelObjectiveMethodHelper() {
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
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService",
                              "GetServiceLevelObjective"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListServiceLevelObjectivesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      METHOD_LIST_SERVICE_LEVEL_OBJECTIVES = getListServiceLevelObjectivesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      getListServiceLevelObjectivesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      getListServiceLevelObjectivesMethod() {
    return getListServiceLevelObjectivesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
          com.google.monitoring.v3.ListServiceLevelObjectivesResponse>
      getListServiceLevelObjectivesMethodHelper() {
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
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService",
                              "ListServiceLevelObjectives"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateServiceLevelObjectiveMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      METHOD_UPDATE_SERVICE_LEVEL_OBJECTIVE = getUpdateServiceLevelObjectiveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getUpdateServiceLevelObjectiveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getUpdateServiceLevelObjectiveMethod() {
    return getUpdateServiceLevelObjectiveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
          com.google.monitoring.v3.ServiceLevelObjective>
      getUpdateServiceLevelObjectiveMethodHelper() {
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
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService",
                              "UpdateServiceLevelObjective"))
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

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteServiceLevelObjectiveMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      METHOD_DELETE_SERVICE_LEVEL_OBJECTIVE = getDeleteServiceLevelObjectiveMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      getDeleteServiceLevelObjectiveMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      getDeleteServiceLevelObjectiveMethod() {
    return getDeleteServiceLevelObjectiveMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.monitoring.v3.DeleteServiceLevelObjectiveRequest, com.google.protobuf.Empty>
      getDeleteServiceLevelObjectiveMethodHelper() {
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
                          generateFullMethodName(
                              "google.monitoring.v3.ServiceMonitoringService",
                              "DeleteServiceLevelObjective"))
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
    return new ServiceMonitoringServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceMonitoringServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ServiceMonitoringServiceBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServiceMonitoringServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ServiceMonitoringServiceFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The Stackdriver Monitoring Service-Oriented Monitoring API has endpoints for
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
      asyncUnimplementedUnaryCall(getCreateServiceMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetServiceMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListServicesMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateServiceMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteServiceMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getCreateServiceLevelObjectiveMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getGetServiceLevelObjectiveMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getListServiceLevelObjectivesMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getUpdateServiceLevelObjectiveMethodHelper(), responseObserver);
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
      asyncUnimplementedUnaryCall(getDeleteServiceLevelObjectiveMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateServiceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateServiceRequest,
                      com.google.monitoring.v3.Service>(this, METHODID_CREATE_SERVICE)))
          .addMethod(
              getGetServiceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetServiceRequest, com.google.monitoring.v3.Service>(
                      this, METHODID_GET_SERVICE)))
          .addMethod(
              getListServicesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListServicesRequest,
                      com.google.monitoring.v3.ListServicesResponse>(this, METHODID_LIST_SERVICES)))
          .addMethod(
              getUpdateServiceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateServiceRequest,
                      com.google.monitoring.v3.Service>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.DeleteServiceRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_SERVICE)))
          .addMethod(
              getCreateServiceLevelObjectiveMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.CreateServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_CREATE_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getGetServiceLevelObjectiveMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.GetServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_GET_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getListServiceLevelObjectivesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.ListServiceLevelObjectivesRequest,
                      com.google.monitoring.v3.ListServiceLevelObjectivesResponse>(
                      this, METHODID_LIST_SERVICE_LEVEL_OBJECTIVES)))
          .addMethod(
              getUpdateServiceLevelObjectiveMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.monitoring.v3.UpdateServiceLevelObjectiveRequest,
                      com.google.monitoring.v3.ServiceLevelObjective>(
                      this, METHODID_UPDATE_SERVICE_LEVEL_OBJECTIVE)))
          .addMethod(
              getDeleteServiceLevelObjectiveMethodHelper(),
              asyncUnaryCall(
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
   * The Stackdriver Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceStub
      extends io.grpc.stub.AbstractStub<ServiceMonitoringServiceStub> {
    private ServiceMonitoringServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetServiceMethodHelper(), getCallOptions()),
          request,
          responseObserver);
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
      asyncUnaryCall(
          getChannel().newCall(getListServicesMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getCreateServiceLevelObjectiveMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getGetServiceLevelObjectiveMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getListServiceLevelObjectivesMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getUpdateServiceLevelObjectiveMethodHelper(), getCallOptions()),
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
      asyncUnaryCall(
          getChannel().newCall(getDeleteServiceLevelObjectiveMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Stackdriver Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceBlockingStub
      extends io.grpc.stub.AbstractStub<ServiceMonitoringServiceBlockingStub> {
    private ServiceMonitoringServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return blockingUnaryCall(
          getChannel(), getCreateServiceMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetServiceMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListServicesMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateServiceMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteServiceMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getCreateServiceLevelObjectiveMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getGetServiceLevelObjectiveMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getListServiceLevelObjectivesMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getUpdateServiceLevelObjectiveMethodHelper(), getCallOptions(), request);
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
      return blockingUnaryCall(
          getChannel(), getDeleteServiceLevelObjectiveMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Stackdriver Monitoring Service-Oriented Monitoring API has endpoints for
   * managing and querying aspects of a workspace's services. These include the
   * `Service`'s monitored resources, its Service-Level Objectives, and a taxonomy
   * of categorized Health Metrics.
   * </pre>
   */
  public static final class ServiceMonitoringServiceFutureStub
      extends io.grpc.stub.AbstractStub<ServiceMonitoringServiceFutureStub> {
    private ServiceMonitoringServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

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
      return futureUnaryCall(
          getChannel().newCall(getCreateServiceMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetServiceMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getListServicesMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethodHelper(), getCallOptions()), request);
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
      return futureUnaryCall(
          getChannel().newCall(getCreateServiceLevelObjectiveMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getGetServiceLevelObjectiveMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getListServiceLevelObjectivesMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getUpdateServiceLevelObjectiveMethodHelper(), getCallOptions()),
          request);
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
      return futureUnaryCall(
          getChannel().newCall(getDeleteServiceLevelObjectiveMethodHelper(), getCallOptions()),
          request);
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
                      .addMethod(getCreateServiceMethodHelper())
                      .addMethod(getGetServiceMethodHelper())
                      .addMethod(getListServicesMethodHelper())
                      .addMethod(getUpdateServiceMethodHelper())
                      .addMethod(getDeleteServiceMethodHelper())
                      .addMethod(getCreateServiceLevelObjectiveMethodHelper())
                      .addMethod(getGetServiceLevelObjectiveMethodHelper())
                      .addMethod(getListServiceLevelObjectivesMethodHelper())
                      .addMethod(getUpdateServiceLevelObjectiveMethodHelper())
                      .addMethod(getDeleteServiceLevelObjectiveMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
