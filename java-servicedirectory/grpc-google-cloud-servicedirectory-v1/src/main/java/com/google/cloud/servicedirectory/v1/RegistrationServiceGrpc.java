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
package com.google.cloud.servicedirectory.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service Directory API for registering services. It defines the following
 * resource model:
 * - The API has a collection of
 * [Namespace][google.cloud.servicedirectory.v1.Namespace]
 * resources, named `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;`.
 * - Each Namespace has a collection of
 * [Service][google.cloud.servicedirectory.v1.Service] resources, named
 * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;`.
 * - Each Service has a collection of
 * [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
 * resources, named
 * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;&#47;endpoints/&#42;`.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/servicedirectory/v1/registration_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RegistrationServiceGrpc {

  private RegistrationServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.servicedirectory.v1.RegistrationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getCreateNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateNamespace",
      requestType = com.google.cloud.servicedirectory.v1.CreateNamespaceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Namespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getCreateNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.CreateNamespaceRequest,
            com.google.cloud.servicedirectory.v1.Namespace>
        getCreateNamespaceMethod;
    if ((getCreateNamespaceMethod = RegistrationServiceGrpc.getCreateNamespaceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getCreateNamespaceMethod = RegistrationServiceGrpc.getCreateNamespaceMethod) == null) {
          RegistrationServiceGrpc.getCreateNamespaceMethod =
              getCreateNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.CreateNamespaceRequest,
                          com.google.cloud.servicedirectory.v1.Namespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.CreateNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Namespace.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("CreateNamespace"))
                      .build();
        }
      }
    }
    return getCreateNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListNamespacesRequest,
          com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
      getListNamespacesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNamespaces",
      requestType = com.google.cloud.servicedirectory.v1.ListNamespacesRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.ListNamespacesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListNamespacesRequest,
          com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
      getListNamespacesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.ListNamespacesRequest,
            com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
        getListNamespacesMethod;
    if ((getListNamespacesMethod = RegistrationServiceGrpc.getListNamespacesMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getListNamespacesMethod = RegistrationServiceGrpc.getListNamespacesMethod) == null) {
          RegistrationServiceGrpc.getListNamespacesMethod =
              getListNamespacesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.ListNamespacesRequest,
                          com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNamespaces"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListNamespacesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListNamespacesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("ListNamespaces"))
                      .build();
        }
      }
    }
    return getListNamespacesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getGetNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNamespace",
      requestType = com.google.cloud.servicedirectory.v1.GetNamespaceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Namespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getGetNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.GetNamespaceRequest,
            com.google.cloud.servicedirectory.v1.Namespace>
        getGetNamespaceMethod;
    if ((getGetNamespaceMethod = RegistrationServiceGrpc.getGetNamespaceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getGetNamespaceMethod = RegistrationServiceGrpc.getGetNamespaceMethod) == null) {
          RegistrationServiceGrpc.getGetNamespaceMethod =
              getGetNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.GetNamespaceRequest,
                          com.google.cloud.servicedirectory.v1.Namespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.GetNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Namespace.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("GetNamespace"))
                      .build();
        }
      }
    }
    return getGetNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getUpdateNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateNamespace",
      requestType = com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Namespace.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest,
          com.google.cloud.servicedirectory.v1.Namespace>
      getUpdateNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest,
            com.google.cloud.servicedirectory.v1.Namespace>
        getUpdateNamespaceMethod;
    if ((getUpdateNamespaceMethod = RegistrationServiceGrpc.getUpdateNamespaceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getUpdateNamespaceMethod = RegistrationServiceGrpc.getUpdateNamespaceMethod) == null) {
          RegistrationServiceGrpc.getUpdateNamespaceMethod =
              getUpdateNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest,
                          com.google.cloud.servicedirectory.v1.Namespace>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Namespace.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("UpdateNamespace"))
                      .build();
        }
      }
    }
    return getUpdateNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest, com.google.protobuf.Empty>
      getDeleteNamespaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteNamespace",
      requestType = com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest, com.google.protobuf.Empty>
      getDeleteNamespaceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest, com.google.protobuf.Empty>
        getDeleteNamespaceMethod;
    if ((getDeleteNamespaceMethod = RegistrationServiceGrpc.getDeleteNamespaceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getDeleteNamespaceMethod = RegistrationServiceGrpc.getDeleteNamespaceMethod) == null) {
          RegistrationServiceGrpc.getDeleteNamespaceMethod =
              getDeleteNamespaceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteNamespace"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("DeleteNamespace"))
                      .build();
        }
      }
    }
    return getDeleteNamespaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getCreateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateService",
      requestType = com.google.cloud.servicedirectory.v1.CreateServiceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getCreateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.CreateServiceRequest,
            com.google.cloud.servicedirectory.v1.Service>
        getCreateServiceMethod;
    if ((getCreateServiceMethod = RegistrationServiceGrpc.getCreateServiceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getCreateServiceMethod = RegistrationServiceGrpc.getCreateServiceMethod) == null) {
          RegistrationServiceGrpc.getCreateServiceMethod =
              getCreateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.CreateServiceRequest,
                          com.google.cloud.servicedirectory.v1.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.CreateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("CreateService"))
                      .build();
        }
      }
    }
    return getCreateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListServicesRequest,
          com.google.cloud.servicedirectory.v1.ListServicesResponse>
      getListServicesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServices",
      requestType = com.google.cloud.servicedirectory.v1.ListServicesRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.ListServicesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListServicesRequest,
          com.google.cloud.servicedirectory.v1.ListServicesResponse>
      getListServicesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.ListServicesRequest,
            com.google.cloud.servicedirectory.v1.ListServicesResponse>
        getListServicesMethod;
    if ((getListServicesMethod = RegistrationServiceGrpc.getListServicesMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getListServicesMethod = RegistrationServiceGrpc.getListServicesMethod) == null) {
          RegistrationServiceGrpc.getListServicesMethod =
              getListServicesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.ListServicesRequest,
                          com.google.cloud.servicedirectory.v1.ListServicesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServices"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListServicesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListServicesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("ListServices"))
                      .build();
        }
      }
    }
    return getListServicesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetService",
      requestType = com.google.cloud.servicedirectory.v1.GetServiceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getGetServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.GetServiceRequest,
            com.google.cloud.servicedirectory.v1.Service>
        getGetServiceMethod;
    if ((getGetServiceMethod = RegistrationServiceGrpc.getGetServiceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getGetServiceMethod = RegistrationServiceGrpc.getGetServiceMethod) == null) {
          RegistrationServiceGrpc.getGetServiceMethod =
              getGetServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.GetServiceRequest,
                          com.google.cloud.servicedirectory.v1.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.GetServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("GetService"))
                      .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateService",
      requestType = com.google.cloud.servicedirectory.v1.UpdateServiceRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Service.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateServiceRequest,
          com.google.cloud.servicedirectory.v1.Service>
      getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.UpdateServiceRequest,
            com.google.cloud.servicedirectory.v1.Service>
        getUpdateServiceMethod;
    if ((getUpdateServiceMethod = RegistrationServiceGrpc.getUpdateServiceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getUpdateServiceMethod = RegistrationServiceGrpc.getUpdateServiceMethod) == null) {
          RegistrationServiceGrpc.getUpdateServiceMethod =
              getUpdateServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.UpdateServiceRequest,
                          com.google.cloud.servicedirectory.v1.Service>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.UpdateServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Service.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("UpdateService"))
                      .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteService",
      requestType = com.google.cloud.servicedirectory.v1.DeleteServiceRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteServiceRequest, com.google.protobuf.Empty>
      getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.DeleteServiceRequest, com.google.protobuf.Empty>
        getDeleteServiceMethod;
    if ((getDeleteServiceMethod = RegistrationServiceGrpc.getDeleteServiceMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getDeleteServiceMethod = RegistrationServiceGrpc.getDeleteServiceMethod) == null) {
          RegistrationServiceGrpc.getDeleteServiceMethod =
              getDeleteServiceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.DeleteServiceRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteService"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.DeleteServiceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("DeleteService"))
                      .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getCreateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEndpoint",
      requestType = com.google.cloud.servicedirectory.v1.CreateEndpointRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.CreateEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getCreateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.CreateEndpointRequest,
            com.google.cloud.servicedirectory.v1.Endpoint>
        getCreateEndpointMethod;
    if ((getCreateEndpointMethod = RegistrationServiceGrpc.getCreateEndpointMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getCreateEndpointMethod = RegistrationServiceGrpc.getCreateEndpointMethod) == null) {
          RegistrationServiceGrpc.getCreateEndpointMethod =
              getCreateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.CreateEndpointRequest,
                          com.google.cloud.servicedirectory.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.CreateEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("CreateEndpoint"))
                      .build();
        }
      }
    }
    return getCreateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListEndpointsRequest,
          com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
      getListEndpointsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEndpoints",
      requestType = com.google.cloud.servicedirectory.v1.ListEndpointsRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.ListEndpointsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.ListEndpointsRequest,
          com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
      getListEndpointsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.ListEndpointsRequest,
            com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
        getListEndpointsMethod;
    if ((getListEndpointsMethod = RegistrationServiceGrpc.getListEndpointsMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getListEndpointsMethod = RegistrationServiceGrpc.getListEndpointsMethod) == null) {
          RegistrationServiceGrpc.getListEndpointsMethod =
              getListEndpointsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.ListEndpointsRequest,
                          com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEndpoints"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListEndpointsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.ListEndpointsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("ListEndpoints"))
                      .build();
        }
      }
    }
    return getListEndpointsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getGetEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEndpoint",
      requestType = com.google.cloud.servicedirectory.v1.GetEndpointRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.GetEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getGetEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.GetEndpointRequest,
            com.google.cloud.servicedirectory.v1.Endpoint>
        getGetEndpointMethod;
    if ((getGetEndpointMethod = RegistrationServiceGrpc.getGetEndpointMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getGetEndpointMethod = RegistrationServiceGrpc.getGetEndpointMethod) == null) {
          RegistrationServiceGrpc.getGetEndpointMethod =
              getGetEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.GetEndpointRequest,
                          com.google.cloud.servicedirectory.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.GetEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("GetEndpoint"))
                      .build();
        }
      }
    }
    return getGetEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getUpdateEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEndpoint",
      requestType = com.google.cloud.servicedirectory.v1.UpdateEndpointRequest.class,
      responseType = com.google.cloud.servicedirectory.v1.Endpoint.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.UpdateEndpointRequest,
          com.google.cloud.servicedirectory.v1.Endpoint>
      getUpdateEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.UpdateEndpointRequest,
            com.google.cloud.servicedirectory.v1.Endpoint>
        getUpdateEndpointMethod;
    if ((getUpdateEndpointMethod = RegistrationServiceGrpc.getUpdateEndpointMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getUpdateEndpointMethod = RegistrationServiceGrpc.getUpdateEndpointMethod) == null) {
          RegistrationServiceGrpc.getUpdateEndpointMethod =
              getUpdateEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.UpdateEndpointRequest,
                          com.google.cloud.servicedirectory.v1.Endpoint>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.UpdateEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.Endpoint.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("UpdateEndpoint"))
                      .build();
        }
      }
    }
    return getUpdateEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteEndpointRequest, com.google.protobuf.Empty>
      getDeleteEndpointMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEndpoint",
      requestType = com.google.cloud.servicedirectory.v1.DeleteEndpointRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.servicedirectory.v1.DeleteEndpointRequest, com.google.protobuf.Empty>
      getDeleteEndpointMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.servicedirectory.v1.DeleteEndpointRequest, com.google.protobuf.Empty>
        getDeleteEndpointMethod;
    if ((getDeleteEndpointMethod = RegistrationServiceGrpc.getDeleteEndpointMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getDeleteEndpointMethod = RegistrationServiceGrpc.getDeleteEndpointMethod) == null) {
          RegistrationServiceGrpc.getDeleteEndpointMethod =
              getDeleteEndpointMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.servicedirectory.v1.DeleteEndpointRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteEndpoint"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.servicedirectory.v1.DeleteEndpointRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("DeleteEndpoint"))
                      .build();
        }
      }
    }
    return getDeleteEndpointMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIamPolicy",
      requestType = com.google.iam.v1.GetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = RegistrationServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getGetIamPolicyMethod = RegistrationServiceGrpc.getGetIamPolicyMethod) == null) {
          RegistrationServiceGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetIamPolicy",
      requestType = com.google.iam.v1.SetIamPolicyRequest.class,
      responseType = com.google.iam.v1.Policy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = RegistrationServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getSetIamPolicyMethod = RegistrationServiceGrpc.getSetIamPolicyMethod) == null) {
          RegistrationServiceGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TestIamPermissions",
      requestType = com.google.iam.v1.TestIamPermissionsRequest.class,
      responseType = com.google.iam.v1.TestIamPermissionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = RegistrationServiceGrpc.getTestIamPermissionsMethod)
        == null) {
      synchronized (RegistrationServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = RegistrationServiceGrpc.getTestIamPermissionsMethod)
            == null) {
          RegistrationServiceGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RegistrationServiceMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RegistrationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceStub>() {
          @java.lang.Override
          public RegistrationServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistrationServiceStub(channel, callOptions);
          }
        };
    return RegistrationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RegistrationServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceBlockingStub>() {
          @java.lang.Override
          public RegistrationServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistrationServiceBlockingStub(channel, callOptions);
          }
        };
    return RegistrationServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RegistrationServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RegistrationServiceFutureStub>() {
          @java.lang.Override
          public RegistrationServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RegistrationServiceFutureStub(channel, callOptions);
          }
        };
    return RegistrationServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service Directory API for registering services. It defines the following
   * resource model:
   * - The API has a collection of
   * [Namespace][google.cloud.servicedirectory.v1.Namespace]
   * resources, named `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;`.
   * - Each Namespace has a collection of
   * [Service][google.cloud.servicedirectory.v1.Service] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;`.
   * - Each Service has a collection of
   * [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
   * resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;&#47;endpoints/&#42;`.
   * </pre>
   */
  public abstract static class RegistrationServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a namespace, and returns the new Namespace.
     * </pre>
     */
    public void createNamespace(
        com.google.cloud.servicedirectory.v1.CreateNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all namespaces.
     * </pre>
     */
    public void listNamespaces(
        com.google.cloud.servicedirectory.v1.ListNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNamespacesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a namespace.
     * </pre>
     */
    public void getNamespace(
        com.google.cloud.servicedirectory.v1.GetNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a namespace.
     * </pre>
     */
    public void updateNamespace(
        com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a namespace. This also deletes all services and endpoints in
     * the namespace.
     * </pre>
     */
    public void deleteNamespace(
        com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteNamespaceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a service, and returns the new Service.
     * </pre>
     */
    public void createService(
        com.google.cloud.servicedirectory.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all services belonging to a namespace.
     * </pre>
     */
    public void listServices(
        com.google.cloud.servicedirectory.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListServicesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServicesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a service.
     * </pre>
     */
    public void getService(
        com.google.cloud.servicedirectory.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.servicedirectory.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a service. This also deletes all endpoints associated with
     * the service.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.servicedirectory.v1.DeleteServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServiceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a endpoint, and returns the new Endpoint.
     * </pre>
     */
    public void createEndpoint(
        com.google.cloud.servicedirectory.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all endpoints.
     * </pre>
     */
    public void listEndpoints(
        com.google.cloud.servicedirectory.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEndpointsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a endpoint.
     * </pre>
     */
    public void getEndpoint(
        com.google.cloud.servicedirectory.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a endpoint.
     * </pre>
     */
    public void updateEndpoint(
        com.google.cloud.servicedirectory.v1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a endpoint.
     * </pre>
     */
    public void deleteEndpoint(
        com.google.cloud.servicedirectory.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEndpointMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetIamPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests IAM permissions for a resource (namespace or service only).
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateNamespaceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.CreateNamespaceRequest,
                      com.google.cloud.servicedirectory.v1.Namespace>(
                      this, METHODID_CREATE_NAMESPACE)))
          .addMethod(
              getListNamespacesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.ListNamespacesRequest,
                      com.google.cloud.servicedirectory.v1.ListNamespacesResponse>(
                      this, METHODID_LIST_NAMESPACES)))
          .addMethod(
              getGetNamespaceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.GetNamespaceRequest,
                      com.google.cloud.servicedirectory.v1.Namespace>(
                      this, METHODID_GET_NAMESPACE)))
          .addMethod(
              getUpdateNamespaceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest,
                      com.google.cloud.servicedirectory.v1.Namespace>(
                      this, METHODID_UPDATE_NAMESPACE)))
          .addMethod(
              getDeleteNamespaceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_NAMESPACE)))
          .addMethod(
              getCreateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.CreateServiceRequest,
                      com.google.cloud.servicedirectory.v1.Service>(this, METHODID_CREATE_SERVICE)))
          .addMethod(
              getListServicesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.ListServicesRequest,
                      com.google.cloud.servicedirectory.v1.ListServicesResponse>(
                      this, METHODID_LIST_SERVICES)))
          .addMethod(
              getGetServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.GetServiceRequest,
                      com.google.cloud.servicedirectory.v1.Service>(this, METHODID_GET_SERVICE)))
          .addMethod(
              getUpdateServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.UpdateServiceRequest,
                      com.google.cloud.servicedirectory.v1.Service>(this, METHODID_UPDATE_SERVICE)))
          .addMethod(
              getDeleteServiceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.DeleteServiceRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SERVICE)))
          .addMethod(
              getCreateEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.CreateEndpointRequest,
                      com.google.cloud.servicedirectory.v1.Endpoint>(
                      this, METHODID_CREATE_ENDPOINT)))
          .addMethod(
              getListEndpointsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.ListEndpointsRequest,
                      com.google.cloud.servicedirectory.v1.ListEndpointsResponse>(
                      this, METHODID_LIST_ENDPOINTS)))
          .addMethod(
              getGetEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.GetEndpointRequest,
                      com.google.cloud.servicedirectory.v1.Endpoint>(this, METHODID_GET_ENDPOINT)))
          .addMethod(
              getUpdateEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.UpdateEndpointRequest,
                      com.google.cloud.servicedirectory.v1.Endpoint>(
                      this, METHODID_UPDATE_ENDPOINT)))
          .addMethod(
              getDeleteEndpointMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.servicedirectory.v1.DeleteEndpointRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_ENDPOINT)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service Directory API for registering services. It defines the following
   * resource model:
   * - The API has a collection of
   * [Namespace][google.cloud.servicedirectory.v1.Namespace]
   * resources, named `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;`.
   * - Each Namespace has a collection of
   * [Service][google.cloud.servicedirectory.v1.Service] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;`.
   * - Each Service has a collection of
   * [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
   * resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;&#47;endpoints/&#42;`.
   * </pre>
   */
  public static final class RegistrationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RegistrationServiceStub> {
    private RegistrationServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace, and returns the new Namespace.
     * </pre>
     */
    public void createNamespace(
        com.google.cloud.servicedirectory.v1.CreateNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all namespaces.
     * </pre>
     */
    public void listNamespaces(
        com.google.cloud.servicedirectory.v1.ListNamespacesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNamespacesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a namespace.
     * </pre>
     */
    public void getNamespace(
        com.google.cloud.servicedirectory.v1.GetNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a namespace.
     * </pre>
     */
    public void updateNamespace(
        com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a namespace. This also deletes all services and endpoints in
     * the namespace.
     * </pre>
     */
    public void deleteNamespace(
        com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteNamespaceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a service, and returns the new Service.
     * </pre>
     */
    public void createService(
        com.google.cloud.servicedirectory.v1.CreateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all services belonging to a namespace.
     * </pre>
     */
    public void listServices(
        com.google.cloud.servicedirectory.v1.ListServicesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListServicesResponse>
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
     * Gets a service.
     * </pre>
     */
    public void getService(
        com.google.cloud.servicedirectory.v1.GetServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a service.
     * </pre>
     */
    public void updateService(
        com.google.cloud.servicedirectory.v1.UpdateServiceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a service. This also deletes all endpoints associated with
     * the service.
     * </pre>
     */
    public void deleteService(
        com.google.cloud.servicedirectory.v1.DeleteServiceRequest request,
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
     * Creates a endpoint, and returns the new Endpoint.
     * </pre>
     */
    public void createEndpoint(
        com.google.cloud.servicedirectory.v1.CreateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all endpoints.
     * </pre>
     */
    public void listEndpoints(
        com.google.cloud.servicedirectory.v1.ListEndpointsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a endpoint.
     * </pre>
     */
    public void getEndpoint(
        com.google.cloud.servicedirectory.v1.GetEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a endpoint.
     * </pre>
     */
    public void updateEndpoint(
        com.google.cloud.servicedirectory.v1.UpdateEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a endpoint.
     * </pre>
     */
    public void deleteEndpoint(
        com.google.cloud.servicedirectory.v1.DeleteEndpointRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Tests IAM permissions for a resource (namespace or service only).
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Directory API for registering services. It defines the following
   * resource model:
   * - The API has a collection of
   * [Namespace][google.cloud.servicedirectory.v1.Namespace]
   * resources, named `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;`.
   * - Each Namespace has a collection of
   * [Service][google.cloud.servicedirectory.v1.Service] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;`.
   * - Each Service has a collection of
   * [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
   * resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;&#47;endpoints/&#42;`.
   * </pre>
   */
  public static final class RegistrationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RegistrationServiceBlockingStub> {
    private RegistrationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace, and returns the new Namespace.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Namespace createNamespace(
        com.google.cloud.servicedirectory.v1.CreateNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all namespaces.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.ListNamespacesResponse listNamespaces(
        com.google.cloud.servicedirectory.v1.ListNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNamespacesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a namespace.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Namespace getNamespace(
        com.google.cloud.servicedirectory.v1.GetNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a namespace.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Namespace updateNamespace(
        com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a namespace. This also deletes all services and endpoints in
     * the namespace.
     * </pre>
     */
    public com.google.protobuf.Empty deleteNamespace(
        com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteNamespaceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a service, and returns the new Service.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Service createService(
        com.google.cloud.servicedirectory.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all services belonging to a namespace.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.ListServicesResponse listServices(
        com.google.cloud.servicedirectory.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServicesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a service.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Service getService(
        com.google.cloud.servicedirectory.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a service.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Service updateService(
        com.google.cloud.servicedirectory.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a service. This also deletes all endpoints associated with
     * the service.
     * </pre>
     */
    public com.google.protobuf.Empty deleteService(
        com.google.cloud.servicedirectory.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a endpoint, and returns the new Endpoint.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Endpoint createEndpoint(
        com.google.cloud.servicedirectory.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all endpoints.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.ListEndpointsResponse listEndpoints(
        com.google.cloud.servicedirectory.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEndpointsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a endpoint.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Endpoint getEndpoint(
        com.google.cloud.servicedirectory.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a endpoint.
     * </pre>
     */
    public com.google.cloud.servicedirectory.v1.Endpoint updateEndpoint(
        com.google.cloud.servicedirectory.v1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a endpoint.
     * </pre>
     */
    public com.google.protobuf.Empty deleteEndpoint(
        com.google.cloud.servicedirectory.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEndpointMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetIamPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Tests IAM permissions for a resource (namespace or service only).
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service Directory API for registering services. It defines the following
   * resource model:
   * - The API has a collection of
   * [Namespace][google.cloud.servicedirectory.v1.Namespace]
   * resources, named `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;`.
   * - Each Namespace has a collection of
   * [Service][google.cloud.servicedirectory.v1.Service] resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;`.
   * - Each Service has a collection of
   * [Endpoint][google.cloud.servicedirectory.v1.Endpoint]
   * resources, named
   * `projects/&#42;&#47;locations/&#42;&#47;namespaces/&#42;&#47;services/&#42;&#47;endpoints/&#42;`.
   * </pre>
   */
  public static final class RegistrationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RegistrationServiceFutureStub> {
    private RegistrationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RegistrationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RegistrationServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a namespace, and returns the new Namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Namespace>
        createNamespace(com.google.cloud.servicedirectory.v1.CreateNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all namespaces.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.ListNamespacesResponse>
        listNamespaces(com.google.cloud.servicedirectory.v1.ListNamespacesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNamespacesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Namespace>
        getNamespace(com.google.cloud.servicedirectory.v1.GetNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Namespace>
        updateNamespace(com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a namespace. This also deletes all services and endpoints in
     * the namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteNamespace(com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteNamespaceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a service, and returns the new Service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Service>
        createService(com.google.cloud.servicedirectory.v1.CreateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all services belonging to a namespace.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.ListServicesResponse>
        listServices(com.google.cloud.servicedirectory.v1.ListServicesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServicesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Service>
        getService(com.google.cloud.servicedirectory.v1.GetServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Service>
        updateService(com.google.cloud.servicedirectory.v1.UpdateServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a service. This also deletes all endpoints associated with
     * the service.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteService(com.google.cloud.servicedirectory.v1.DeleteServiceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a endpoint, and returns the new Endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Endpoint>
        createEndpoint(com.google.cloud.servicedirectory.v1.CreateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all endpoints.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.ListEndpointsResponse>
        listEndpoints(com.google.cloud.servicedirectory.v1.ListEndpointsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEndpointsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Endpoint>
        getEndpoint(com.google.cloud.servicedirectory.v1.GetEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.servicedirectory.v1.Endpoint>
        updateEndpoint(com.google.cloud.servicedirectory.v1.UpdateEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a endpoint.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteEndpoint(com.google.cloud.servicedirectory.v1.DeleteEndpointRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEndpointMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM Policy for a resource (namespace or service only).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Tests IAM permissions for a resource (namespace or service only).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_NAMESPACE = 0;
  private static final int METHODID_LIST_NAMESPACES = 1;
  private static final int METHODID_GET_NAMESPACE = 2;
  private static final int METHODID_UPDATE_NAMESPACE = 3;
  private static final int METHODID_DELETE_NAMESPACE = 4;
  private static final int METHODID_CREATE_SERVICE = 5;
  private static final int METHODID_LIST_SERVICES = 6;
  private static final int METHODID_GET_SERVICE = 7;
  private static final int METHODID_UPDATE_SERVICE = 8;
  private static final int METHODID_DELETE_SERVICE = 9;
  private static final int METHODID_CREATE_ENDPOINT = 10;
  private static final int METHODID_LIST_ENDPOINTS = 11;
  private static final int METHODID_GET_ENDPOINT = 12;
  private static final int METHODID_UPDATE_ENDPOINT = 13;
  private static final int METHODID_DELETE_ENDPOINT = 14;
  private static final int METHODID_GET_IAM_POLICY = 15;
  private static final int METHODID_SET_IAM_POLICY = 16;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 17;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RegistrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RegistrationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_NAMESPACE:
          serviceImpl.createNamespace(
              (com.google.cloud.servicedirectory.v1.CreateNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>)
                  responseObserver);
          break;
        case METHODID_LIST_NAMESPACES:
          serviceImpl.listNamespaces(
              (com.google.cloud.servicedirectory.v1.ListNamespacesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.servicedirectory.v1.ListNamespacesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NAMESPACE:
          serviceImpl.getNamespace(
              (com.google.cloud.servicedirectory.v1.GetNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>)
                  responseObserver);
          break;
        case METHODID_UPDATE_NAMESPACE:
          serviceImpl.updateNamespace(
              (com.google.cloud.servicedirectory.v1.UpdateNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Namespace>)
                  responseObserver);
          break;
        case METHODID_DELETE_NAMESPACE:
          serviceImpl.deleteNamespace(
              (com.google.cloud.servicedirectory.v1.DeleteNamespaceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_SERVICE:
          serviceImpl.createService(
              (com.google.cloud.servicedirectory.v1.CreateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVICES:
          serviceImpl.listServices(
              (com.google.cloud.servicedirectory.v1.ListServicesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.servicedirectory.v1.ListServicesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService(
              (com.google.cloud.servicedirectory.v1.GetServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService(
              (com.google.cloud.servicedirectory.v1.UpdateServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Service>)
                  responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService(
              (com.google.cloud.servicedirectory.v1.DeleteServiceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ENDPOINT:
          serviceImpl.createEndpoint(
              (com.google.cloud.servicedirectory.v1.CreateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_LIST_ENDPOINTS:
          serviceImpl.listEndpoints(
              (com.google.cloud.servicedirectory.v1.ListEndpointsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.servicedirectory.v1.ListEndpointsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENDPOINT:
          serviceImpl.getEndpoint(
              (com.google.cloud.servicedirectory.v1.GetEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ENDPOINT:
          serviceImpl.updateEndpoint(
              (com.google.cloud.servicedirectory.v1.UpdateEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.servicedirectory.v1.Endpoint>)
                  responseObserver);
          break;
        case METHODID_DELETE_ENDPOINT:
          serviceImpl.deleteEndpoint(
              (com.google.cloud.servicedirectory.v1.DeleteEndpointRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
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

  private abstract static class RegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RegistrationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.servicedirectory.v1.RegistrationServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RegistrationService");
    }
  }

  private static final class RegistrationServiceFileDescriptorSupplier
      extends RegistrationServiceBaseDescriptorSupplier {
    RegistrationServiceFileDescriptorSupplier() {}
  }

  private static final class RegistrationServiceMethodDescriptorSupplier
      extends RegistrationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RegistrationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RegistrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RegistrationServiceFileDescriptorSupplier())
                      .addMethod(getCreateNamespaceMethod())
                      .addMethod(getListNamespacesMethod())
                      .addMethod(getGetNamespaceMethod())
                      .addMethod(getUpdateNamespaceMethod())
                      .addMethod(getDeleteNamespaceMethod())
                      .addMethod(getCreateServiceMethod())
                      .addMethod(getListServicesMethod())
                      .addMethod(getGetServiceMethod())
                      .addMethod(getUpdateServiceMethod())
                      .addMethod(getDeleteServiceMethod())
                      .addMethod(getCreateEndpointMethod())
                      .addMethod(getListEndpointsMethod())
                      .addMethod(getGetEndpointMethod())
                      .addMethod(getUpdateEndpointMethod())
                      .addMethod(getDeleteEndpointMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
