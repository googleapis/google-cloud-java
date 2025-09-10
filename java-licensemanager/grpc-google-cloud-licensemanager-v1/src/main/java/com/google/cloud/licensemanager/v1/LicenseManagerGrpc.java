/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.licensemanager.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/licensemanager/v1/licensemanager.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LicenseManagerGrpc {

  private LicenseManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.licensemanager.v1.LicenseManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListConfigurationsRequest,
          com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
      getListConfigurationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConfigurations",
      requestType = com.google.cloud.licensemanager.v1.ListConfigurationsRequest.class,
      responseType = com.google.cloud.licensemanager.v1.ListConfigurationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListConfigurationsRequest,
          com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
      getListConfigurationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.ListConfigurationsRequest,
            com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
        getListConfigurationsMethod;
    if ((getListConfigurationsMethod = LicenseManagerGrpc.getListConfigurationsMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getListConfigurationsMethod = LicenseManagerGrpc.getListConfigurationsMethod)
            == null) {
          LicenseManagerGrpc.getListConfigurationsMethod =
              getListConfigurationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.ListConfigurationsRequest,
                          com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConfigurations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListConfigurationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListConfigurationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("ListConfigurations"))
                      .build();
        }
      }
    }
    return getListConfigurationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetConfigurationRequest,
          com.google.cloud.licensemanager.v1.Configuration>
      getGetConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConfiguration",
      requestType = com.google.cloud.licensemanager.v1.GetConfigurationRequest.class,
      responseType = com.google.cloud.licensemanager.v1.Configuration.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetConfigurationRequest,
          com.google.cloud.licensemanager.v1.Configuration>
      getGetConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.GetConfigurationRequest,
            com.google.cloud.licensemanager.v1.Configuration>
        getGetConfigurationMethod;
    if ((getGetConfigurationMethod = LicenseManagerGrpc.getGetConfigurationMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getGetConfigurationMethod = LicenseManagerGrpc.getGetConfigurationMethod) == null) {
          LicenseManagerGrpc.getGetConfigurationMethod =
              getGetConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.GetConfigurationRequest,
                          com.google.cloud.licensemanager.v1.Configuration>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.GetConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.Configuration
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("GetConfiguration"))
                      .build();
        }
      }
    }
    return getGetConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.CreateConfigurationRequest,
          com.google.longrunning.Operation>
      getCreateConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConfiguration",
      requestType = com.google.cloud.licensemanager.v1.CreateConfigurationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.CreateConfigurationRequest,
          com.google.longrunning.Operation>
      getCreateConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.CreateConfigurationRequest,
            com.google.longrunning.Operation>
        getCreateConfigurationMethod;
    if ((getCreateConfigurationMethod = LicenseManagerGrpc.getCreateConfigurationMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getCreateConfigurationMethod = LicenseManagerGrpc.getCreateConfigurationMethod)
            == null) {
          LicenseManagerGrpc.getCreateConfigurationMethod =
              getCreateConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.CreateConfigurationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.CreateConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("CreateConfiguration"))
                      .build();
        }
      }
    }
    return getCreateConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.UpdateConfigurationRequest,
          com.google.longrunning.Operation>
      getUpdateConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConfiguration",
      requestType = com.google.cloud.licensemanager.v1.UpdateConfigurationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.UpdateConfigurationRequest,
          com.google.longrunning.Operation>
      getUpdateConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.UpdateConfigurationRequest,
            com.google.longrunning.Operation>
        getUpdateConfigurationMethod;
    if ((getUpdateConfigurationMethod = LicenseManagerGrpc.getUpdateConfigurationMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getUpdateConfigurationMethod = LicenseManagerGrpc.getUpdateConfigurationMethod)
            == null) {
          LicenseManagerGrpc.getUpdateConfigurationMethod =
              getUpdateConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.UpdateConfigurationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.UpdateConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("UpdateConfiguration"))
                      .build();
        }
      }
    }
    return getUpdateConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.DeleteConfigurationRequest,
          com.google.longrunning.Operation>
      getDeleteConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConfiguration",
      requestType = com.google.cloud.licensemanager.v1.DeleteConfigurationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.DeleteConfigurationRequest,
          com.google.longrunning.Operation>
      getDeleteConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.DeleteConfigurationRequest,
            com.google.longrunning.Operation>
        getDeleteConfigurationMethod;
    if ((getDeleteConfigurationMethod = LicenseManagerGrpc.getDeleteConfigurationMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getDeleteConfigurationMethod = LicenseManagerGrpc.getDeleteConfigurationMethod)
            == null) {
          LicenseManagerGrpc.getDeleteConfigurationMethod =
              getDeleteConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.DeleteConfigurationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.DeleteConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("DeleteConfiguration"))
                      .build();
        }
      }
    }
    return getDeleteConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListInstancesRequest,
          com.google.cloud.licensemanager.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.licensemanager.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.licensemanager.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListInstancesRequest,
          com.google.cloud.licensemanager.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.ListInstancesRequest,
            com.google.cloud.licensemanager.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = LicenseManagerGrpc.getListInstancesMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getListInstancesMethod = LicenseManagerGrpc.getListInstancesMethod) == null) {
          LicenseManagerGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.ListInstancesRequest,
                          com.google.cloud.licensemanager.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetInstanceRequest,
          com.google.cloud.licensemanager.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.licensemanager.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.licensemanager.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetInstanceRequest,
          com.google.cloud.licensemanager.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.GetInstanceRequest,
            com.google.cloud.licensemanager.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = LicenseManagerGrpc.getGetInstanceMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getGetInstanceMethod = LicenseManagerGrpc.getGetInstanceMethod) == null) {
          LicenseManagerGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.GetInstanceRequest,
                          com.google.cloud.licensemanager.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest,
          com.google.longrunning.Operation>
      getDeactivateConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeactivateConfiguration",
      requestType = com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest,
          com.google.longrunning.Operation>
      getDeactivateConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest,
            com.google.longrunning.Operation>
        getDeactivateConfigurationMethod;
    if ((getDeactivateConfigurationMethod = LicenseManagerGrpc.getDeactivateConfigurationMethod)
        == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getDeactivateConfigurationMethod = LicenseManagerGrpc.getDeactivateConfigurationMethod)
            == null) {
          LicenseManagerGrpc.getDeactivateConfigurationMethod =
              getDeactivateConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeactivateConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("DeactivateConfiguration"))
                      .build();
        }
      }
    }
    return getDeactivateConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest,
          com.google.longrunning.Operation>
      getReactivateConfigurationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReactivateConfiguration",
      requestType = com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest,
          com.google.longrunning.Operation>
      getReactivateConfigurationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest,
            com.google.longrunning.Operation>
        getReactivateConfigurationMethod;
    if ((getReactivateConfigurationMethod = LicenseManagerGrpc.getReactivateConfigurationMethod)
        == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getReactivateConfigurationMethod = LicenseManagerGrpc.getReactivateConfigurationMethod)
            == null) {
          LicenseManagerGrpc.getReactivateConfigurationMethod =
              getReactivateConfigurationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ReactivateConfiguration"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("ReactivateConfiguration"))
                      .build();
        }
      }
    }
    return getReactivateConfigurationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest,
          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
      getQueryConfigurationLicenseUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryConfigurationLicenseUsage",
      requestType = com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest.class,
      responseType =
          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest,
          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
      getQueryConfigurationLicenseUsageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest,
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
        getQueryConfigurationLicenseUsageMethod;
    if ((getQueryConfigurationLicenseUsageMethod =
            LicenseManagerGrpc.getQueryConfigurationLicenseUsageMethod)
        == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getQueryConfigurationLicenseUsageMethod =
                LicenseManagerGrpc.getQueryConfigurationLicenseUsageMethod)
            == null) {
          LicenseManagerGrpc.getQueryConfigurationLicenseUsageMethod =
              getQueryConfigurationLicenseUsageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest,
                          com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "QueryConfigurationLicenseUsage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1
                                  .QueryConfigurationLicenseUsageRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1
                                  .QueryConfigurationLicenseUsageResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier(
                              "QueryConfigurationLicenseUsage"))
                      .build();
        }
      }
    }
    return getQueryConfigurationLicenseUsageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.AggregateUsageRequest,
          com.google.cloud.licensemanager.v1.AggregateUsageResponse>
      getAggregateUsageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AggregateUsage",
      requestType = com.google.cloud.licensemanager.v1.AggregateUsageRequest.class,
      responseType = com.google.cloud.licensemanager.v1.AggregateUsageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.AggregateUsageRequest,
          com.google.cloud.licensemanager.v1.AggregateUsageResponse>
      getAggregateUsageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.AggregateUsageRequest,
            com.google.cloud.licensemanager.v1.AggregateUsageResponse>
        getAggregateUsageMethod;
    if ((getAggregateUsageMethod = LicenseManagerGrpc.getAggregateUsageMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getAggregateUsageMethod = LicenseManagerGrpc.getAggregateUsageMethod) == null) {
          LicenseManagerGrpc.getAggregateUsageMethod =
              getAggregateUsageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.AggregateUsageRequest,
                          com.google.cloud.licensemanager.v1.AggregateUsageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AggregateUsage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.AggregateUsageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.AggregateUsageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("AggregateUsage"))
                      .build();
        }
      }
    }
    return getAggregateUsageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListProductsRequest,
          com.google.cloud.licensemanager.v1.ListProductsResponse>
      getListProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProducts",
      requestType = com.google.cloud.licensemanager.v1.ListProductsRequest.class,
      responseType = com.google.cloud.licensemanager.v1.ListProductsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.ListProductsRequest,
          com.google.cloud.licensemanager.v1.ListProductsResponse>
      getListProductsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.ListProductsRequest,
            com.google.cloud.licensemanager.v1.ListProductsResponse>
        getListProductsMethod;
    if ((getListProductsMethod = LicenseManagerGrpc.getListProductsMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getListProductsMethod = LicenseManagerGrpc.getListProductsMethod) == null) {
          LicenseManagerGrpc.getListProductsMethod =
              getListProductsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.ListProductsRequest,
                          com.google.cloud.licensemanager.v1.ListProductsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProducts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListProductsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.ListProductsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new LicenseManagerMethodDescriptorSupplier("ListProducts"))
                      .build();
        }
      }
    }
    return getListProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetProductRequest,
          com.google.cloud.licensemanager.v1.Product>
      getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProduct",
      requestType = com.google.cloud.licensemanager.v1.GetProductRequest.class,
      responseType = com.google.cloud.licensemanager.v1.Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.licensemanager.v1.GetProductRequest,
          com.google.cloud.licensemanager.v1.Product>
      getGetProductMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.licensemanager.v1.GetProductRequest,
            com.google.cloud.licensemanager.v1.Product>
        getGetProductMethod;
    if ((getGetProductMethod = LicenseManagerGrpc.getGetProductMethod) == null) {
      synchronized (LicenseManagerGrpc.class) {
        if ((getGetProductMethod = LicenseManagerGrpc.getGetProductMethod) == null) {
          LicenseManagerGrpc.getGetProductMethod =
              getGetProductMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.licensemanager.v1.GetProductRequest,
                          com.google.cloud.licensemanager.v1.Product>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProduct"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.GetProductRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.licensemanager.v1.Product.getDefaultInstance()))
                      .setSchemaDescriptor(new LicenseManagerMethodDescriptorSupplier("GetProduct"))
                      .build();
        }
      }
    }
    return getGetProductMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LicenseManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagerStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagerStub>() {
          @java.lang.Override
          public LicenseManagerStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagerStub(channel, callOptions);
          }
        };
    return LicenseManagerStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static LicenseManagerBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagerBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagerBlockingV2Stub>() {
          @java.lang.Override
          public LicenseManagerBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagerBlockingV2Stub(channel, callOptions);
          }
        };
    return LicenseManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LicenseManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagerBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagerBlockingStub>() {
          @java.lang.Override
          public LicenseManagerBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagerBlockingStub(channel, callOptions);
          }
        };
    return LicenseManagerBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LicenseManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LicenseManagerFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LicenseManagerFutureStub>() {
          @java.lang.Override
          public LicenseManagerFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LicenseManagerFutureStub(channel, callOptions);
          }
        };
    return LicenseManagerFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Configurations in a given project and location.
     * </pre>
     */
    default void listConfigurations(
        com.google.cloud.licensemanager.v1.ListConfigurationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConfigurationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Configuration.
     * </pre>
     */
    default void getConfiguration(
        com.google.cloud.licensemanager.v1.GetConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Configuration>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Configuration in a given project and location.
     * </pre>
     */
    default void createConfiguration(
        com.google.cloud.licensemanager.v1.CreateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Configuration.
     * </pre>
     */
    default void updateConfiguration(
        com.google.cloud.licensemanager.v1.UpdateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Configuration.
     * </pre>
     */
    default void deleteConfiguration(
        com.google.cloud.licensemanager.v1.DeleteConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.licensemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.licensemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deactivates the given configuration.
     * </pre>
     */
    default void deactivateConfiguration(
        com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeactivateConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reactivates the given configuration.
     * </pre>
     */
    default void reactivateConfiguration(
        com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReactivateConfigurationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * License Usage information for a Configuration.
     * </pre>
     */
    default void queryConfigurationLicenseUsage(
        com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryConfigurationLicenseUsageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates Usage per Instance for a Configuration.
     * </pre>
     */
    default void aggregateUsage(
        com.google.cloud.licensemanager.v1.AggregateUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.AggregateUsageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAggregateUsageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Products in a given project and location.
     * </pre>
     */
    default void listProducts(
        com.google.cloud.licensemanager.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProductsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Product.
     * </pre>
     */
    default void getProduct(
        com.google.cloud.licensemanager.v1.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service LicenseManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class LicenseManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LicenseManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service LicenseManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LicenseManagerStub
      extends io.grpc.stub.AbstractAsyncStub<LicenseManagerStub> {
    private LicenseManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Configurations in a given project and location.
     * </pre>
     */
    public void listConfigurations(
        com.google.cloud.licensemanager.v1.ListConfigurationsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConfigurationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Configuration.
     * </pre>
     */
    public void getConfiguration(
        com.google.cloud.licensemanager.v1.GetConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Configuration>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Configuration in a given project and location.
     * </pre>
     */
    public void createConfiguration(
        com.google.cloud.licensemanager.v1.CreateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Configuration.
     * </pre>
     */
    public void updateConfiguration(
        com.google.cloud.licensemanager.v1.UpdateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Configuration.
     * </pre>
     */
    public void deleteConfiguration(
        com.google.cloud.licensemanager.v1.DeleteConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.licensemanager.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.licensemanager.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deactivates the given configuration.
     * </pre>
     */
    public void deactivateConfiguration(
        com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeactivateConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Reactivates the given configuration.
     * </pre>
     */
    public void reactivateConfiguration(
        com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReactivateConfigurationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * License Usage information for a Configuration.
     * </pre>
     */
    public void queryConfigurationLicenseUsage(
        com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryConfigurationLicenseUsageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Aggregates Usage per Instance for a Configuration.
     * </pre>
     */
    public void aggregateUsage(
        com.google.cloud.licensemanager.v1.AggregateUsageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.AggregateUsageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAggregateUsageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Products in a given project and location.
     * </pre>
     */
    public void listProducts(
        com.google.cloud.licensemanager.v1.ListProductsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListProductsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Product.
     * </pre>
     */
    public void getProduct(
        com.google.cloud.licensemanager.v1.GetProductRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service LicenseManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LicenseManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LicenseManagerBlockingV2Stub> {
    private LicenseManagerBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Configurations in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListConfigurationsResponse listConfigurations(
        com.google.cloud.licensemanager.v1.ListConfigurationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConfigurationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Configuration getConfiguration(
        com.google.cloud.licensemanager.v1.GetConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Configuration in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConfiguration(
        com.google.cloud.licensemanager.v1.CreateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Configuration.
     * </pre>
     */
    public com.google.longrunning.Operation updateConfiguration(
        com.google.cloud.licensemanager.v1.UpdateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConfiguration(
        com.google.cloud.licensemanager.v1.DeleteConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListInstancesResponse listInstances(
        com.google.cloud.licensemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Instance getInstance(
        com.google.cloud.licensemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deactivates the given configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deactivateConfiguration(
        com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeactivateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reactivates the given configuration.
     * </pre>
     */
    public com.google.longrunning.Operation reactivateConfiguration(
        com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReactivateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * License Usage information for a Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse
        queryConfigurationLicenseUsage(
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryConfigurationLicenseUsageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates Usage per Instance for a Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.AggregateUsageResponse aggregateUsage(
        com.google.cloud.licensemanager.v1.AggregateUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateUsageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Products in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListProductsResponse listProducts(
        com.google.cloud.licensemanager.v1.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Product.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Product getProduct(
        com.google.cloud.licensemanager.v1.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service LicenseManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LicenseManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LicenseManagerBlockingStub> {
    private LicenseManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Configurations in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListConfigurationsResponse listConfigurations(
        com.google.cloud.licensemanager.v1.ListConfigurationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConfigurationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Configuration getConfiguration(
        com.google.cloud.licensemanager.v1.GetConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Configuration in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConfiguration(
        com.google.cloud.licensemanager.v1.CreateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Configuration.
     * </pre>
     */
    public com.google.longrunning.Operation updateConfiguration(
        com.google.cloud.licensemanager.v1.UpdateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConfiguration(
        com.google.cloud.licensemanager.v1.DeleteConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListInstancesResponse listInstances(
        com.google.cloud.licensemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Instance getInstance(
        com.google.cloud.licensemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deactivates the given configuration.
     * </pre>
     */
    public com.google.longrunning.Operation deactivateConfiguration(
        com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeactivateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Reactivates the given configuration.
     * </pre>
     */
    public com.google.longrunning.Operation reactivateConfiguration(
        com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReactivateConfigurationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * License Usage information for a Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse
        queryConfigurationLicenseUsage(
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryConfigurationLicenseUsageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates Usage per Instance for a Configuration.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.AggregateUsageResponse aggregateUsage(
        com.google.cloud.licensemanager.v1.AggregateUsageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAggregateUsageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Products in a given project and location.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.ListProductsResponse listProducts(
        com.google.cloud.licensemanager.v1.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProductsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Product.
     * </pre>
     */
    public com.google.cloud.licensemanager.v1.Product getProduct(
        com.google.cloud.licensemanager.v1.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service LicenseManager.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LicenseManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<LicenseManagerFutureStub> {
    private LicenseManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LicenseManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LicenseManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Configurations in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.ListConfigurationsResponse>
        listConfigurations(com.google.cloud.licensemanager.v1.ListConfigurationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConfigurationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.Configuration>
        getConfiguration(com.google.cloud.licensemanager.v1.GetConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Configuration in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createConfiguration(com.google.cloud.licensemanager.v1.CreateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateConfiguration(com.google.cloud.licensemanager.v1.UpdateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteConfiguration(com.google.cloud.licensemanager.v1.DeleteConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.ListInstancesResponse>
        listInstances(com.google.cloud.licensemanager.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.Instance>
        getInstance(com.google.cloud.licensemanager.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deactivates the given configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deactivateConfiguration(
            com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeactivateConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Reactivates the given configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reactivateConfiguration(
            com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReactivateConfigurationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * License Usage information for a Configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>
        queryConfigurationLicenseUsage(
            com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryConfigurationLicenseUsageMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Aggregates Usage per Instance for a Configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.AggregateUsageResponse>
        aggregateUsage(com.google.cloud.licensemanager.v1.AggregateUsageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAggregateUsageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Products in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.ListProductsResponse>
        listProducts(com.google.cloud.licensemanager.v1.ListProductsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProductsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Product.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.licensemanager.v1.Product>
        getProduct(com.google.cloud.licensemanager.v1.GetProductRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONFIGURATIONS = 0;
  private static final int METHODID_GET_CONFIGURATION = 1;
  private static final int METHODID_CREATE_CONFIGURATION = 2;
  private static final int METHODID_UPDATE_CONFIGURATION = 3;
  private static final int METHODID_DELETE_CONFIGURATION = 4;
  private static final int METHODID_LIST_INSTANCES = 5;
  private static final int METHODID_GET_INSTANCE = 6;
  private static final int METHODID_DEACTIVATE_CONFIGURATION = 7;
  private static final int METHODID_REACTIVATE_CONFIGURATION = 8;
  private static final int METHODID_QUERY_CONFIGURATION_LICENSE_USAGE = 9;
  private static final int METHODID_AGGREGATE_USAGE = 10;
  private static final int METHODID_LIST_PRODUCTS = 11;
  private static final int METHODID_GET_PRODUCT = 12;

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
        case METHODID_LIST_CONFIGURATIONS:
          serviceImpl.listConfigurations(
              (com.google.cloud.licensemanager.v1.ListConfigurationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.licensemanager.v1.ListConfigurationsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONFIGURATION:
          serviceImpl.getConfiguration(
              (com.google.cloud.licensemanager.v1.GetConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Configuration>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONFIGURATION:
          serviceImpl.createConfiguration(
              (com.google.cloud.licensemanager.v1.CreateConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONFIGURATION:
          serviceImpl.updateConfiguration(
              (com.google.cloud.licensemanager.v1.UpdateConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONFIGURATION:
          serviceImpl.deleteConfiguration(
              (com.google.cloud.licensemanager.v1.DeleteConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.licensemanager.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.licensemanager.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.licensemanager.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_DEACTIVATE_CONFIGURATION:
          serviceImpl.deactivateConfiguration(
              (com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REACTIVATE_CONFIGURATION:
          serviceImpl.reactivateConfiguration(
              (com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_QUERY_CONFIGURATION_LICENSE_USAGE:
          serviceImpl.queryConfigurationLicenseUsage(
              (com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>)
                  responseObserver);
          break;
        case METHODID_AGGREGATE_USAGE:
          serviceImpl.aggregateUsage(
              (com.google.cloud.licensemanager.v1.AggregateUsageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.licensemanager.v1.AggregateUsageResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PRODUCTS:
          serviceImpl.listProducts(
              (com.google.cloud.licensemanager.v1.ListProductsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.ListProductsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct(
              (com.google.cloud.licensemanager.v1.GetProductRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.licensemanager.v1.Product>)
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
            getListConfigurationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.ListConfigurationsRequest,
                    com.google.cloud.licensemanager.v1.ListConfigurationsResponse>(
                    service, METHODID_LIST_CONFIGURATIONS)))
        .addMethod(
            getGetConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.GetConfigurationRequest,
                    com.google.cloud.licensemanager.v1.Configuration>(
                    service, METHODID_GET_CONFIGURATION)))
        .addMethod(
            getCreateConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.CreateConfigurationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CONFIGURATION)))
        .addMethod(
            getUpdateConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.UpdateConfigurationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CONFIGURATION)))
        .addMethod(
            getDeleteConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.DeleteConfigurationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CONFIGURATION)))
        .addMethod(
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.ListInstancesRequest,
                    com.google.cloud.licensemanager.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.GetInstanceRequest,
                    com.google.cloud.licensemanager.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getDeactivateConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.DeactivateConfigurationRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEACTIVATE_CONFIGURATION)))
        .addMethod(
            getReactivateConfigurationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.ReactivateConfigurationRequest,
                    com.google.longrunning.Operation>(service, METHODID_REACTIVATE_CONFIGURATION)))
        .addMethod(
            getQueryConfigurationLicenseUsageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageRequest,
                    com.google.cloud.licensemanager.v1.QueryConfigurationLicenseUsageResponse>(
                    service, METHODID_QUERY_CONFIGURATION_LICENSE_USAGE)))
        .addMethod(
            getAggregateUsageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.AggregateUsageRequest,
                    com.google.cloud.licensemanager.v1.AggregateUsageResponse>(
                    service, METHODID_AGGREGATE_USAGE)))
        .addMethod(
            getListProductsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.ListProductsRequest,
                    com.google.cloud.licensemanager.v1.ListProductsResponse>(
                    service, METHODID_LIST_PRODUCTS)))
        .addMethod(
            getGetProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.licensemanager.v1.GetProductRequest,
                    com.google.cloud.licensemanager.v1.Product>(service, METHODID_GET_PRODUCT)))
        .build();
  }

  private abstract static class LicenseManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LicenseManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.licensemanager.v1.LicenseManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LicenseManager");
    }
  }

  private static final class LicenseManagerFileDescriptorSupplier
      extends LicenseManagerBaseDescriptorSupplier {
    LicenseManagerFileDescriptorSupplier() {}
  }

  private static final class LicenseManagerMethodDescriptorSupplier
      extends LicenseManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LicenseManagerMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LicenseManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LicenseManagerFileDescriptorSupplier())
                      .addMethod(getListConfigurationsMethod())
                      .addMethod(getGetConfigurationMethod())
                      .addMethod(getCreateConfigurationMethod())
                      .addMethod(getUpdateConfigurationMethod())
                      .addMethod(getDeleteConfigurationMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getDeactivateConfigurationMethod())
                      .addMethod(getReactivateConfigurationMethod())
                      .addMethod(getQueryConfigurationLicenseUsageMethod())
                      .addMethod(getAggregateUsageMethod())
                      .addMethod(getListProductsMethod())
                      .addMethod(getGetProductMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
