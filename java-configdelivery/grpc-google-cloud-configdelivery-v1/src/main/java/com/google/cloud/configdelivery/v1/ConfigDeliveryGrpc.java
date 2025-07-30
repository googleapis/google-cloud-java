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
package com.google.cloud.configdelivery.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * ConfigDelivery service manages the deployment of kubernetes configuration to
 * a fleet of kubernetes clusters.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/configdelivery/v1/config_delivery.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConfigDeliveryGrpc {

  private ConfigDeliveryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.configdelivery.v1.ConfigDelivery";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListResourceBundlesRequest,
          com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
      getListResourceBundlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListResourceBundles",
      requestType = com.google.cloud.configdelivery.v1.ListResourceBundlesRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ListResourceBundlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListResourceBundlesRequest,
          com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
      getListResourceBundlesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ListResourceBundlesRequest,
            com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
        getListResourceBundlesMethod;
    if ((getListResourceBundlesMethod = ConfigDeliveryGrpc.getListResourceBundlesMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getListResourceBundlesMethod = ConfigDeliveryGrpc.getListResourceBundlesMethod)
            == null) {
          ConfigDeliveryGrpc.getListResourceBundlesMethod =
              getListResourceBundlesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ListResourceBundlesRequest,
                          com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListResourceBundles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListResourceBundlesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListResourceBundlesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ListResourceBundles"))
                      .build();
        }
      }
    }
    return getListResourceBundlesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetResourceBundleRequest,
          com.google.cloud.configdelivery.v1.ResourceBundle>
      getGetResourceBundleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetResourceBundle",
      requestType = com.google.cloud.configdelivery.v1.GetResourceBundleRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ResourceBundle.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetResourceBundleRequest,
          com.google.cloud.configdelivery.v1.ResourceBundle>
      getGetResourceBundleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.GetResourceBundleRequest,
            com.google.cloud.configdelivery.v1.ResourceBundle>
        getGetResourceBundleMethod;
    if ((getGetResourceBundleMethod = ConfigDeliveryGrpc.getGetResourceBundleMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getGetResourceBundleMethod = ConfigDeliveryGrpc.getGetResourceBundleMethod) == null) {
          ConfigDeliveryGrpc.getGetResourceBundleMethod =
              getGetResourceBundleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.GetResourceBundleRequest,
                          com.google.cloud.configdelivery.v1.ResourceBundle>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetResourceBundle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.GetResourceBundleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ResourceBundle
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("GetResourceBundle"))
                      .build();
        }
      }
    }
    return getGetResourceBundleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateResourceBundleRequest,
          com.google.longrunning.Operation>
      getCreateResourceBundleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateResourceBundle",
      requestType = com.google.cloud.configdelivery.v1.CreateResourceBundleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateResourceBundleRequest,
          com.google.longrunning.Operation>
      getCreateResourceBundleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.CreateResourceBundleRequest,
            com.google.longrunning.Operation>
        getCreateResourceBundleMethod;
    if ((getCreateResourceBundleMethod = ConfigDeliveryGrpc.getCreateResourceBundleMethod)
        == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getCreateResourceBundleMethod = ConfigDeliveryGrpc.getCreateResourceBundleMethod)
            == null) {
          ConfigDeliveryGrpc.getCreateResourceBundleMethod =
              getCreateResourceBundleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.CreateResourceBundleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateResourceBundle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.CreateResourceBundleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("CreateResourceBundle"))
                      .build();
        }
      }
    }
    return getCreateResourceBundleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest,
          com.google.longrunning.Operation>
      getUpdateResourceBundleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateResourceBundle",
      requestType = com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest,
          com.google.longrunning.Operation>
      getUpdateResourceBundleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest,
            com.google.longrunning.Operation>
        getUpdateResourceBundleMethod;
    if ((getUpdateResourceBundleMethod = ConfigDeliveryGrpc.getUpdateResourceBundleMethod)
        == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getUpdateResourceBundleMethod = ConfigDeliveryGrpc.getUpdateResourceBundleMethod)
            == null) {
          ConfigDeliveryGrpc.getUpdateResourceBundleMethod =
              getUpdateResourceBundleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateResourceBundle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("UpdateResourceBundle"))
                      .build();
        }
      }
    }
    return getUpdateResourceBundleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest,
          com.google.longrunning.Operation>
      getDeleteResourceBundleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteResourceBundle",
      requestType = com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest,
          com.google.longrunning.Operation>
      getDeleteResourceBundleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest,
            com.google.longrunning.Operation>
        getDeleteResourceBundleMethod;
    if ((getDeleteResourceBundleMethod = ConfigDeliveryGrpc.getDeleteResourceBundleMethod)
        == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getDeleteResourceBundleMethod = ConfigDeliveryGrpc.getDeleteResourceBundleMethod)
            == null) {
          ConfigDeliveryGrpc.getDeleteResourceBundleMethod =
              getDeleteResourceBundleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteResourceBundle"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("DeleteResourceBundle"))
                      .build();
        }
      }
    }
    return getDeleteResourceBundleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListFleetPackagesRequest,
          com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
      getListFleetPackagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFleetPackages",
      requestType = com.google.cloud.configdelivery.v1.ListFleetPackagesRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ListFleetPackagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListFleetPackagesRequest,
          com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
      getListFleetPackagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ListFleetPackagesRequest,
            com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
        getListFleetPackagesMethod;
    if ((getListFleetPackagesMethod = ConfigDeliveryGrpc.getListFleetPackagesMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getListFleetPackagesMethod = ConfigDeliveryGrpc.getListFleetPackagesMethod) == null) {
          ConfigDeliveryGrpc.getListFleetPackagesMethod =
              getListFleetPackagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ListFleetPackagesRequest,
                          com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFleetPackages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListFleetPackagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListFleetPackagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ListFleetPackages"))
                      .build();
        }
      }
    }
    return getListFleetPackagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetFleetPackageRequest,
          com.google.cloud.configdelivery.v1.FleetPackage>
      getGetFleetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFleetPackage",
      requestType = com.google.cloud.configdelivery.v1.GetFleetPackageRequest.class,
      responseType = com.google.cloud.configdelivery.v1.FleetPackage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetFleetPackageRequest,
          com.google.cloud.configdelivery.v1.FleetPackage>
      getGetFleetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.GetFleetPackageRequest,
            com.google.cloud.configdelivery.v1.FleetPackage>
        getGetFleetPackageMethod;
    if ((getGetFleetPackageMethod = ConfigDeliveryGrpc.getGetFleetPackageMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getGetFleetPackageMethod = ConfigDeliveryGrpc.getGetFleetPackageMethod) == null) {
          ConfigDeliveryGrpc.getGetFleetPackageMethod =
              getGetFleetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.GetFleetPackageRequest,
                          com.google.cloud.configdelivery.v1.FleetPackage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFleetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.GetFleetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.FleetPackage.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("GetFleetPackage"))
                      .build();
        }
      }
    }
    return getGetFleetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateFleetPackageRequest,
          com.google.longrunning.Operation>
      getCreateFleetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFleetPackage",
      requestType = com.google.cloud.configdelivery.v1.CreateFleetPackageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateFleetPackageRequest,
          com.google.longrunning.Operation>
      getCreateFleetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.CreateFleetPackageRequest,
            com.google.longrunning.Operation>
        getCreateFleetPackageMethod;
    if ((getCreateFleetPackageMethod = ConfigDeliveryGrpc.getCreateFleetPackageMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getCreateFleetPackageMethod = ConfigDeliveryGrpc.getCreateFleetPackageMethod)
            == null) {
          ConfigDeliveryGrpc.getCreateFleetPackageMethod =
              getCreateFleetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.CreateFleetPackageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateFleetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.CreateFleetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("CreateFleetPackage"))
                      .build();
        }
      }
    }
    return getCreateFleetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest,
          com.google.longrunning.Operation>
      getUpdateFleetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFleetPackage",
      requestType = com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest,
          com.google.longrunning.Operation>
      getUpdateFleetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest,
            com.google.longrunning.Operation>
        getUpdateFleetPackageMethod;
    if ((getUpdateFleetPackageMethod = ConfigDeliveryGrpc.getUpdateFleetPackageMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getUpdateFleetPackageMethod = ConfigDeliveryGrpc.getUpdateFleetPackageMethod)
            == null) {
          ConfigDeliveryGrpc.getUpdateFleetPackageMethod =
              getUpdateFleetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFleetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("UpdateFleetPackage"))
                      .build();
        }
      }
    }
    return getUpdateFleetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest,
          com.google.longrunning.Operation>
      getDeleteFleetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFleetPackage",
      requestType = com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest,
          com.google.longrunning.Operation>
      getDeleteFleetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest,
            com.google.longrunning.Operation>
        getDeleteFleetPackageMethod;
    if ((getDeleteFleetPackageMethod = ConfigDeliveryGrpc.getDeleteFleetPackageMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getDeleteFleetPackageMethod = ConfigDeliveryGrpc.getDeleteFleetPackageMethod)
            == null) {
          ConfigDeliveryGrpc.getDeleteFleetPackageMethod =
              getDeleteFleetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteFleetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("DeleteFleetPackage"))
                      .build();
        }
      }
    }
    return getDeleteFleetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListReleasesRequest,
          com.google.cloud.configdelivery.v1.ListReleasesResponse>
      getListReleasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReleases",
      requestType = com.google.cloud.configdelivery.v1.ListReleasesRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ListReleasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListReleasesRequest,
          com.google.cloud.configdelivery.v1.ListReleasesResponse>
      getListReleasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ListReleasesRequest,
            com.google.cloud.configdelivery.v1.ListReleasesResponse>
        getListReleasesMethod;
    if ((getListReleasesMethod = ConfigDeliveryGrpc.getListReleasesMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getListReleasesMethod = ConfigDeliveryGrpc.getListReleasesMethod) == null) {
          ConfigDeliveryGrpc.getListReleasesMethod =
              getListReleasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ListReleasesRequest,
                          com.google.cloud.configdelivery.v1.ListReleasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReleases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListReleasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListReleasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ListReleases"))
                      .build();
        }
      }
    }
    return getListReleasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetReleaseRequest,
          com.google.cloud.configdelivery.v1.Release>
      getGetReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRelease",
      requestType = com.google.cloud.configdelivery.v1.GetReleaseRequest.class,
      responseType = com.google.cloud.configdelivery.v1.Release.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetReleaseRequest,
          com.google.cloud.configdelivery.v1.Release>
      getGetReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.GetReleaseRequest,
            com.google.cloud.configdelivery.v1.Release>
        getGetReleaseMethod;
    if ((getGetReleaseMethod = ConfigDeliveryGrpc.getGetReleaseMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getGetReleaseMethod = ConfigDeliveryGrpc.getGetReleaseMethod) == null) {
          ConfigDeliveryGrpc.getGetReleaseMethod =
              getGetReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.GetReleaseRequest,
                          com.google.cloud.configdelivery.v1.Release>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.GetReleaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.Release.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigDeliveryMethodDescriptorSupplier("GetRelease"))
                      .build();
        }
      }
    }
    return getGetReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateReleaseRequest, com.google.longrunning.Operation>
      getCreateReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRelease",
      requestType = com.google.cloud.configdelivery.v1.CreateReleaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateReleaseRequest, com.google.longrunning.Operation>
      getCreateReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.CreateReleaseRequest,
            com.google.longrunning.Operation>
        getCreateReleaseMethod;
    if ((getCreateReleaseMethod = ConfigDeliveryGrpc.getCreateReleaseMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getCreateReleaseMethod = ConfigDeliveryGrpc.getCreateReleaseMethod) == null) {
          ConfigDeliveryGrpc.getCreateReleaseMethod =
              getCreateReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.CreateReleaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.CreateReleaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("CreateRelease"))
                      .build();
        }
      }
    }
    return getCreateReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateReleaseRequest, com.google.longrunning.Operation>
      getUpdateReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRelease",
      requestType = com.google.cloud.configdelivery.v1.UpdateReleaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateReleaseRequest, com.google.longrunning.Operation>
      getUpdateReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.UpdateReleaseRequest,
            com.google.longrunning.Operation>
        getUpdateReleaseMethod;
    if ((getUpdateReleaseMethod = ConfigDeliveryGrpc.getUpdateReleaseMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getUpdateReleaseMethod = ConfigDeliveryGrpc.getUpdateReleaseMethod) == null) {
          ConfigDeliveryGrpc.getUpdateReleaseMethod =
              getUpdateReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.UpdateReleaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.UpdateReleaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("UpdateRelease"))
                      .build();
        }
      }
    }
    return getUpdateReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteReleaseRequest, com.google.longrunning.Operation>
      getDeleteReleaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRelease",
      requestType = com.google.cloud.configdelivery.v1.DeleteReleaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteReleaseRequest, com.google.longrunning.Operation>
      getDeleteReleaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.DeleteReleaseRequest,
            com.google.longrunning.Operation>
        getDeleteReleaseMethod;
    if ((getDeleteReleaseMethod = ConfigDeliveryGrpc.getDeleteReleaseMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getDeleteReleaseMethod = ConfigDeliveryGrpc.getDeleteReleaseMethod) == null) {
          ConfigDeliveryGrpc.getDeleteReleaseMethod =
              getDeleteReleaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.DeleteReleaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRelease"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.DeleteReleaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("DeleteRelease"))
                      .build();
        }
      }
    }
    return getDeleteReleaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListVariantsRequest,
          com.google.cloud.configdelivery.v1.ListVariantsResponse>
      getListVariantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVariants",
      requestType = com.google.cloud.configdelivery.v1.ListVariantsRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ListVariantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListVariantsRequest,
          com.google.cloud.configdelivery.v1.ListVariantsResponse>
      getListVariantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ListVariantsRequest,
            com.google.cloud.configdelivery.v1.ListVariantsResponse>
        getListVariantsMethod;
    if ((getListVariantsMethod = ConfigDeliveryGrpc.getListVariantsMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getListVariantsMethod = ConfigDeliveryGrpc.getListVariantsMethod) == null) {
          ConfigDeliveryGrpc.getListVariantsMethod =
              getListVariantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ListVariantsRequest,
                          com.google.cloud.configdelivery.v1.ListVariantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVariants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListVariantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListVariantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ListVariants"))
                      .build();
        }
      }
    }
    return getListVariantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetVariantRequest,
          com.google.cloud.configdelivery.v1.Variant>
      getGetVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVariant",
      requestType = com.google.cloud.configdelivery.v1.GetVariantRequest.class,
      responseType = com.google.cloud.configdelivery.v1.Variant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetVariantRequest,
          com.google.cloud.configdelivery.v1.Variant>
      getGetVariantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.GetVariantRequest,
            com.google.cloud.configdelivery.v1.Variant>
        getGetVariantMethod;
    if ((getGetVariantMethod = ConfigDeliveryGrpc.getGetVariantMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getGetVariantMethod = ConfigDeliveryGrpc.getGetVariantMethod) == null) {
          ConfigDeliveryGrpc.getGetVariantMethod =
              getGetVariantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.GetVariantRequest,
                          com.google.cloud.configdelivery.v1.Variant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVariant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.GetVariantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.Variant.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigDeliveryMethodDescriptorSupplier("GetVariant"))
                      .build();
        }
      }
    }
    return getGetVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateVariantRequest, com.google.longrunning.Operation>
      getCreateVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVariant",
      requestType = com.google.cloud.configdelivery.v1.CreateVariantRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.CreateVariantRequest, com.google.longrunning.Operation>
      getCreateVariantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.CreateVariantRequest,
            com.google.longrunning.Operation>
        getCreateVariantMethod;
    if ((getCreateVariantMethod = ConfigDeliveryGrpc.getCreateVariantMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getCreateVariantMethod = ConfigDeliveryGrpc.getCreateVariantMethod) == null) {
          ConfigDeliveryGrpc.getCreateVariantMethod =
              getCreateVariantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.CreateVariantRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVariant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.CreateVariantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("CreateVariant"))
                      .build();
        }
      }
    }
    return getCreateVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateVariantRequest, com.google.longrunning.Operation>
      getUpdateVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVariant",
      requestType = com.google.cloud.configdelivery.v1.UpdateVariantRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.UpdateVariantRequest, com.google.longrunning.Operation>
      getUpdateVariantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.UpdateVariantRequest,
            com.google.longrunning.Operation>
        getUpdateVariantMethod;
    if ((getUpdateVariantMethod = ConfigDeliveryGrpc.getUpdateVariantMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getUpdateVariantMethod = ConfigDeliveryGrpc.getUpdateVariantMethod) == null) {
          ConfigDeliveryGrpc.getUpdateVariantMethod =
              getUpdateVariantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.UpdateVariantRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVariant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.UpdateVariantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("UpdateVariant"))
                      .build();
        }
      }
    }
    return getUpdateVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteVariantRequest, com.google.longrunning.Operation>
      getDeleteVariantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVariant",
      requestType = com.google.cloud.configdelivery.v1.DeleteVariantRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.DeleteVariantRequest, com.google.longrunning.Operation>
      getDeleteVariantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.DeleteVariantRequest,
            com.google.longrunning.Operation>
        getDeleteVariantMethod;
    if ((getDeleteVariantMethod = ConfigDeliveryGrpc.getDeleteVariantMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getDeleteVariantMethod = ConfigDeliveryGrpc.getDeleteVariantMethod) == null) {
          ConfigDeliveryGrpc.getDeleteVariantMethod =
              getDeleteVariantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.DeleteVariantRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVariant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.DeleteVariantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("DeleteVariant"))
                      .build();
        }
      }
    }
    return getDeleteVariantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListRolloutsRequest,
          com.google.cloud.configdelivery.v1.ListRolloutsResponse>
      getListRolloutsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRollouts",
      requestType = com.google.cloud.configdelivery.v1.ListRolloutsRequest.class,
      responseType = com.google.cloud.configdelivery.v1.ListRolloutsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ListRolloutsRequest,
          com.google.cloud.configdelivery.v1.ListRolloutsResponse>
      getListRolloutsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ListRolloutsRequest,
            com.google.cloud.configdelivery.v1.ListRolloutsResponse>
        getListRolloutsMethod;
    if ((getListRolloutsMethod = ConfigDeliveryGrpc.getListRolloutsMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getListRolloutsMethod = ConfigDeliveryGrpc.getListRolloutsMethod) == null) {
          ConfigDeliveryGrpc.getListRolloutsMethod =
              getListRolloutsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ListRolloutsRequest,
                          com.google.cloud.configdelivery.v1.ListRolloutsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRollouts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListRolloutsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ListRolloutsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ListRollouts"))
                      .build();
        }
      }
    }
    return getListRolloutsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetRolloutRequest,
          com.google.cloud.configdelivery.v1.Rollout>
      getGetRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRollout",
      requestType = com.google.cloud.configdelivery.v1.GetRolloutRequest.class,
      responseType = com.google.cloud.configdelivery.v1.Rollout.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.GetRolloutRequest,
          com.google.cloud.configdelivery.v1.Rollout>
      getGetRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.GetRolloutRequest,
            com.google.cloud.configdelivery.v1.Rollout>
        getGetRolloutMethod;
    if ((getGetRolloutMethod = ConfigDeliveryGrpc.getGetRolloutMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getGetRolloutMethod = ConfigDeliveryGrpc.getGetRolloutMethod) == null) {
          ConfigDeliveryGrpc.getGetRolloutMethod =
              getGetRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.GetRolloutRequest,
                          com.google.cloud.configdelivery.v1.Rollout>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.GetRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.Rollout.getDefaultInstance()))
                      .setSchemaDescriptor(new ConfigDeliveryMethodDescriptorSupplier("GetRollout"))
                      .build();
        }
      }
    }
    return getGetRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.SuspendRolloutRequest,
          com.google.longrunning.Operation>
      getSuspendRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuspendRollout",
      requestType = com.google.cloud.configdelivery.v1.SuspendRolloutRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.SuspendRolloutRequest,
          com.google.longrunning.Operation>
      getSuspendRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.SuspendRolloutRequest,
            com.google.longrunning.Operation>
        getSuspendRolloutMethod;
    if ((getSuspendRolloutMethod = ConfigDeliveryGrpc.getSuspendRolloutMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getSuspendRolloutMethod = ConfigDeliveryGrpc.getSuspendRolloutMethod) == null) {
          ConfigDeliveryGrpc.getSuspendRolloutMethod =
              getSuspendRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.SuspendRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuspendRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.SuspendRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("SuspendRollout"))
                      .build();
        }
      }
    }
    return getSuspendRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ResumeRolloutRequest, com.google.longrunning.Operation>
      getResumeRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeRollout",
      requestType = com.google.cloud.configdelivery.v1.ResumeRolloutRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.ResumeRolloutRequest, com.google.longrunning.Operation>
      getResumeRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.ResumeRolloutRequest,
            com.google.longrunning.Operation>
        getResumeRolloutMethod;
    if ((getResumeRolloutMethod = ConfigDeliveryGrpc.getResumeRolloutMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getResumeRolloutMethod = ConfigDeliveryGrpc.getResumeRolloutMethod) == null) {
          ConfigDeliveryGrpc.getResumeRolloutMethod =
              getResumeRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.ResumeRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.ResumeRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("ResumeRollout"))
                      .build();
        }
      }
    }
    return getResumeRolloutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.AbortRolloutRequest, com.google.longrunning.Operation>
      getAbortRolloutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AbortRollout",
      requestType = com.google.cloud.configdelivery.v1.AbortRolloutRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.configdelivery.v1.AbortRolloutRequest, com.google.longrunning.Operation>
      getAbortRolloutMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.configdelivery.v1.AbortRolloutRequest,
            com.google.longrunning.Operation>
        getAbortRolloutMethod;
    if ((getAbortRolloutMethod = ConfigDeliveryGrpc.getAbortRolloutMethod) == null) {
      synchronized (ConfigDeliveryGrpc.class) {
        if ((getAbortRolloutMethod = ConfigDeliveryGrpc.getAbortRolloutMethod) == null) {
          ConfigDeliveryGrpc.getAbortRolloutMethod =
              getAbortRolloutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.configdelivery.v1.AbortRolloutRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AbortRollout"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.configdelivery.v1.AbortRolloutRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConfigDeliveryMethodDescriptorSupplier("AbortRollout"))
                      .build();
        }
      }
    }
    return getAbortRolloutMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConfigDeliveryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryStub>() {
          @java.lang.Override
          public ConfigDeliveryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigDeliveryStub(channel, callOptions);
          }
        };
    return ConfigDeliveryStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ConfigDeliveryBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryBlockingV2Stub>() {
          @java.lang.Override
          public ConfigDeliveryBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigDeliveryBlockingV2Stub(channel, callOptions);
          }
        };
    return ConfigDeliveryBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigDeliveryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryBlockingStub>() {
          @java.lang.Override
          public ConfigDeliveryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigDeliveryBlockingStub(channel, callOptions);
          }
        };
    return ConfigDeliveryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConfigDeliveryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConfigDeliveryFutureStub>() {
          @java.lang.Override
          public ConfigDeliveryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConfigDeliveryFutureStub(channel, callOptions);
          }
        };
    return ConfigDeliveryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ResourceBundles in a given project and location.
     * </pre>
     */
    default void listResourceBundles(
        com.google.cloud.configdelivery.v1.ListResourceBundlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListResourceBundlesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ResourceBundle.
     * </pre>
     */
    default void getResourceBundle(
        com.google.cloud.configdelivery.v1.GetResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ResourceBundle>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetResourceBundleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ResourceBundle in a given project and location.
     * </pre>
     */
    default void createResourceBundle(
        com.google.cloud.configdelivery.v1.CreateResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateResourceBundleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ResourceBundle.
     * </pre>
     */
    default void updateResourceBundle(
        com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateResourceBundleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ResourceBundle.
     * </pre>
     */
    default void deleteResourceBundle(
        com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteResourceBundleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FleetPackages in a given project and location.
     * </pre>
     */
    default void listFleetPackages(
        com.google.cloud.configdelivery.v1.ListFleetPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFleetPackagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FleetPackage.
     * </pre>
     */
    default void getFleetPackage(
        com.google.cloud.configdelivery.v1.GetFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.FleetPackage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFleetPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FleetPackage in a given project and location.
     * </pre>
     */
    default void createFleetPackage(
        com.google.cloud.configdelivery.v1.CreateFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFleetPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FleetPackage.
     * </pre>
     */
    default void updateFleetPackage(
        com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFleetPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FleetPackage.
     * </pre>
     */
    default void deleteFleetPackage(
        com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFleetPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Releases in a given project and location.
     * </pre>
     */
    default void listReleases(
        com.google.cloud.configdelivery.v1.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListReleasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListReleasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Release.
     * </pre>
     */
    default void getRelease(
        com.google.cloud.configdelivery.v1.GetReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Release> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Release in a given project, location and resource bundle.
     * </pre>
     */
    default void createRelease(
        com.google.cloud.configdelivery.v1.CreateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Release.
     * </pre>
     */
    default void updateRelease(
        com.google.cloud.configdelivery.v1.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Release.
     * </pre>
     */
    default void deleteRelease(
        com.google.cloud.configdelivery.v1.DeleteReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteReleaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Variants in a given project and location.
     * </pre>
     */
    default void listVariants(
        com.google.cloud.configdelivery.v1.ListVariantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListVariantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVariantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Variant.
     * </pre>
     */
    default void getVariant(
        com.google.cloud.configdelivery.v1.GetVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Variant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVariantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Variant in a given project, location, resource bundle, and
     * release.
     * </pre>
     */
    default void createVariant(
        com.google.cloud.configdelivery.v1.CreateVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVariantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Variant.
     * </pre>
     */
    default void updateVariant(
        com.google.cloud.configdelivery.v1.UpdateVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVariantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Variant.
     * </pre>
     */
    default void deleteVariant(
        com.google.cloud.configdelivery.v1.DeleteVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVariantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Rollouts in a given project, location, and Fleet Package.
     * </pre>
     */
    default void listRollouts(
        com.google.cloud.configdelivery.v1.ListRolloutsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListRolloutsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRolloutsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Rollout.
     * </pre>
     */
    default void getRollout(
        com.google.cloud.configdelivery.v1.GetRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Rollout> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspend a Rollout.
     * </pre>
     */
    default void suspendRollout(
        com.google.cloud.configdelivery.v1.SuspendRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuspendRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a Rollout.
     * </pre>
     */
    default void resumeRollout(
        com.google.cloud.configdelivery.v1.ResumeRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeRolloutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Abort a Rollout.
     * </pre>
     */
    default void abortRollout(
        com.google.cloud.configdelivery.v1.AbortRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAbortRolloutMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConfigDelivery.
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public abstract static class ConfigDeliveryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConfigDeliveryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConfigDelivery.
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public static final class ConfigDeliveryStub
      extends io.grpc.stub.AbstractAsyncStub<ConfigDeliveryStub> {
    private ConfigDeliveryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigDeliveryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigDeliveryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBundles in a given project and location.
     * </pre>
     */
    public void listResourceBundles(
        com.google.cloud.configdelivery.v1.ListResourceBundlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListResourceBundlesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ResourceBundle.
     * </pre>
     */
    public void getResourceBundle(
        com.google.cloud.configdelivery.v1.GetResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ResourceBundle>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetResourceBundleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ResourceBundle in a given project and location.
     * </pre>
     */
    public void createResourceBundle(
        com.google.cloud.configdelivery.v1.CreateResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateResourceBundleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ResourceBundle.
     * </pre>
     */
    public void updateResourceBundle(
        com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateResourceBundleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ResourceBundle.
     * </pre>
     */
    public void deleteResourceBundle(
        com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteResourceBundleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists FleetPackages in a given project and location.
     * </pre>
     */
    public void listFleetPackages(
        com.google.cloud.configdelivery.v1.ListFleetPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFleetPackagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FleetPackage.
     * </pre>
     */
    public void getFleetPackage(
        com.google.cloud.configdelivery.v1.GetFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.FleetPackage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFleetPackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FleetPackage in a given project and location.
     * </pre>
     */
    public void createFleetPackage(
        com.google.cloud.configdelivery.v1.CreateFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFleetPackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FleetPackage.
     * </pre>
     */
    public void updateFleetPackage(
        com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFleetPackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FleetPackage.
     * </pre>
     */
    public void deleteFleetPackage(
        com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFleetPackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Releases in a given project and location.
     * </pre>
     */
    public void listReleases(
        com.google.cloud.configdelivery.v1.ListReleasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListReleasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReleasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Release.
     * </pre>
     */
    public void getRelease(
        com.google.cloud.configdelivery.v1.GetReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Release> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReleaseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Release in a given project, location and resource bundle.
     * </pre>
     */
    public void createRelease(
        com.google.cloud.configdelivery.v1.CreateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Release.
     * </pre>
     */
    public void updateRelease(
        com.google.cloud.configdelivery.v1.UpdateReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Release.
     * </pre>
     */
    public void deleteRelease(
        com.google.cloud.configdelivery.v1.DeleteReleaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteReleaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Variants in a given project and location.
     * </pre>
     */
    public void listVariants(
        com.google.cloud.configdelivery.v1.ListVariantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListVariantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVariantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Variant.
     * </pre>
     */
    public void getVariant(
        com.google.cloud.configdelivery.v1.GetVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Variant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVariantMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Variant in a given project, location, resource bundle, and
     * release.
     * </pre>
     */
    public void createVariant(
        com.google.cloud.configdelivery.v1.CreateVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVariantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Variant.
     * </pre>
     */
    public void updateVariant(
        com.google.cloud.configdelivery.v1.UpdateVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVariantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Variant.
     * </pre>
     */
    public void deleteVariant(
        com.google.cloud.configdelivery.v1.DeleteVariantRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVariantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Rollouts in a given project, location, and Fleet Package.
     * </pre>
     */
    public void listRollouts(
        com.google.cloud.configdelivery.v1.ListRolloutsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListRolloutsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRolloutsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Rollout.
     * </pre>
     */
    public void getRollout(
        com.google.cloud.configdelivery.v1.GetRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Rollout> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRolloutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Suspend a Rollout.
     * </pre>
     */
    public void suspendRollout(
        com.google.cloud.configdelivery.v1.SuspendRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuspendRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resume a Rollout.
     * </pre>
     */
    public void resumeRollout(
        com.google.cloud.configdelivery.v1.ResumeRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Abort a Rollout.
     * </pre>
     */
    public void abortRollout(
        com.google.cloud.configdelivery.v1.AbortRolloutRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAbortRolloutMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConfigDelivery.
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public static final class ConfigDeliveryBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ConfigDeliveryBlockingV2Stub> {
    private ConfigDeliveryBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigDeliveryBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigDeliveryBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBundles in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListResourceBundlesResponse listResourceBundles(
        com.google.cloud.configdelivery.v1.ListResourceBundlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceBundlesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ResourceBundle.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ResourceBundle getResourceBundle(
        com.google.cloud.configdelivery.v1.GetResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ResourceBundle in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createResourceBundle(
        com.google.cloud.configdelivery.v1.CreateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ResourceBundle.
     * </pre>
     */
    public com.google.longrunning.Operation updateResourceBundle(
        com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ResourceBundle.
     * </pre>
     */
    public com.google.longrunning.Operation deleteResourceBundle(
        com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FleetPackages in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListFleetPackagesResponse listFleetPackages(
        com.google.cloud.configdelivery.v1.ListFleetPackagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFleetPackagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FleetPackage.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.FleetPackage getFleetPackage(
        com.google.cloud.configdelivery.v1.GetFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FleetPackage in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFleetPackage(
        com.google.cloud.configdelivery.v1.CreateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FleetPackage.
     * </pre>
     */
    public com.google.longrunning.Operation updateFleetPackage(
        com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FleetPackage.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFleetPackage(
        com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Releases in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListReleasesResponse listReleases(
        com.google.cloud.configdelivery.v1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReleasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Release.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Release getRelease(
        com.google.cloud.configdelivery.v1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Release in a given project, location and resource bundle.
     * </pre>
     */
    public com.google.longrunning.Operation createRelease(
        com.google.cloud.configdelivery.v1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Release.
     * </pre>
     */
    public com.google.longrunning.Operation updateRelease(
        com.google.cloud.configdelivery.v1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Release.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRelease(
        com.google.cloud.configdelivery.v1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Variants in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListVariantsResponse listVariants(
        com.google.cloud.configdelivery.v1.ListVariantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVariantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Variant.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Variant getVariant(
        com.google.cloud.configdelivery.v1.GetVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Variant in a given project, location, resource bundle, and
     * release.
     * </pre>
     */
    public com.google.longrunning.Operation createVariant(
        com.google.cloud.configdelivery.v1.CreateVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Variant.
     * </pre>
     */
    public com.google.longrunning.Operation updateVariant(
        com.google.cloud.configdelivery.v1.UpdateVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Variant.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVariant(
        com.google.cloud.configdelivery.v1.DeleteVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rollouts in a given project, location, and Fleet Package.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListRolloutsResponse listRollouts(
        com.google.cloud.configdelivery.v1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Rollout.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Rollout getRollout(
        com.google.cloud.configdelivery.v1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Suspend a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation suspendRollout(
        com.google.cloud.configdelivery.v1.SuspendRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuspendRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation resumeRollout(
        com.google.cloud.configdelivery.v1.ResumeRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Abort a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation abortRollout(
        com.google.cloud.configdelivery.v1.AbortRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAbortRolloutMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ConfigDelivery.
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public static final class ConfigDeliveryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConfigDeliveryBlockingStub> {
    private ConfigDeliveryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigDeliveryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigDeliveryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBundles in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListResourceBundlesResponse listResourceBundles(
        com.google.cloud.configdelivery.v1.ListResourceBundlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListResourceBundlesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ResourceBundle.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ResourceBundle getResourceBundle(
        com.google.cloud.configdelivery.v1.GetResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ResourceBundle in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createResourceBundle(
        com.google.cloud.configdelivery.v1.CreateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ResourceBundle.
     * </pre>
     */
    public com.google.longrunning.Operation updateResourceBundle(
        com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ResourceBundle.
     * </pre>
     */
    public com.google.longrunning.Operation deleteResourceBundle(
        com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteResourceBundleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FleetPackages in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListFleetPackagesResponse listFleetPackages(
        com.google.cloud.configdelivery.v1.ListFleetPackagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFleetPackagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FleetPackage.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.FleetPackage getFleetPackage(
        com.google.cloud.configdelivery.v1.GetFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FleetPackage in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createFleetPackage(
        com.google.cloud.configdelivery.v1.CreateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FleetPackage.
     * </pre>
     */
    public com.google.longrunning.Operation updateFleetPackage(
        com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FleetPackage.
     * </pre>
     */
    public com.google.longrunning.Operation deleteFleetPackage(
        com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFleetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Releases in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListReleasesResponse listReleases(
        com.google.cloud.configdelivery.v1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReleasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Release.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Release getRelease(
        com.google.cloud.configdelivery.v1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Release in a given project, location and resource bundle.
     * </pre>
     */
    public com.google.longrunning.Operation createRelease(
        com.google.cloud.configdelivery.v1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Release.
     * </pre>
     */
    public com.google.longrunning.Operation updateRelease(
        com.google.cloud.configdelivery.v1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Release.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRelease(
        com.google.cloud.configdelivery.v1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteReleaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Variants in a given project and location.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListVariantsResponse listVariants(
        com.google.cloud.configdelivery.v1.ListVariantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVariantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Variant.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Variant getVariant(
        com.google.cloud.configdelivery.v1.GetVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Variant in a given project, location, resource bundle, and
     * release.
     * </pre>
     */
    public com.google.longrunning.Operation createVariant(
        com.google.cloud.configdelivery.v1.CreateVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Variant.
     * </pre>
     */
    public com.google.longrunning.Operation updateVariant(
        com.google.cloud.configdelivery.v1.UpdateVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Variant.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVariant(
        com.google.cloud.configdelivery.v1.DeleteVariantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVariantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rollouts in a given project, location, and Fleet Package.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.ListRolloutsResponse listRollouts(
        com.google.cloud.configdelivery.v1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRolloutsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Rollout.
     * </pre>
     */
    public com.google.cloud.configdelivery.v1.Rollout getRollout(
        com.google.cloud.configdelivery.v1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Suspend a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation suspendRollout(
        com.google.cloud.configdelivery.v1.SuspendRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuspendRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation resumeRollout(
        com.google.cloud.configdelivery.v1.ResumeRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeRolloutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Abort a Rollout.
     * </pre>
     */
    public com.google.longrunning.Operation abortRollout(
        com.google.cloud.configdelivery.v1.AbortRolloutRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAbortRolloutMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConfigDelivery.
   *
   * <pre>
   * ConfigDelivery service manages the deployment of kubernetes configuration to
   * a fleet of kubernetes clusters.
   * </pre>
   */
  public static final class ConfigDeliveryFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConfigDeliveryFutureStub> {
    private ConfigDeliveryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigDeliveryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConfigDeliveryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ResourceBundles in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>
        listResourceBundles(com.google.cloud.configdelivery.v1.ListResourceBundlesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListResourceBundlesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ResourceBundle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ResourceBundle>
        getResourceBundle(com.google.cloud.configdelivery.v1.GetResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetResourceBundleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ResourceBundle in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createResourceBundle(
            com.google.cloud.configdelivery.v1.CreateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateResourceBundleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single ResourceBundle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateResourceBundle(
            com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateResourceBundleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ResourceBundle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteResourceBundle(
            com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteResourceBundleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists FleetPackages in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>
        listFleetPackages(com.google.cloud.configdelivery.v1.ListFleetPackagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFleetPackagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single FleetPackage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.FleetPackage>
        getFleetPackage(com.google.cloud.configdelivery.v1.GetFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFleetPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new FleetPackage in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createFleetPackage(com.google.cloud.configdelivery.v1.CreateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFleetPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single FleetPackage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateFleetPackage(com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFleetPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single FleetPackage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteFleetPackage(com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFleetPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Releases in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ListReleasesResponse>
        listReleases(com.google.cloud.configdelivery.v1.ListReleasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReleasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.Release>
        getRelease(com.google.cloud.configdelivery.v1.GetReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Release in a given project, location and resource bundle.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRelease(com.google.cloud.configdelivery.v1.CreateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateRelease(com.google.cloud.configdelivery.v1.UpdateReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRelease(com.google.cloud.configdelivery.v1.DeleteReleaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteReleaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Variants in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ListVariantsResponse>
        listVariants(com.google.cloud.configdelivery.v1.ListVariantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVariantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Variant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.Variant>
        getVariant(com.google.cloud.configdelivery.v1.GetVariantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVariantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Variant in a given project, location, resource bundle, and
     * release.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createVariant(com.google.cloud.configdelivery.v1.CreateVariantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVariantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Variant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateVariant(com.google.cloud.configdelivery.v1.UpdateVariantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVariantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Variant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteVariant(com.google.cloud.configdelivery.v1.DeleteVariantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVariantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Rollouts in a given project, location, and Fleet Package.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.ListRolloutsResponse>
        listRollouts(com.google.cloud.configdelivery.v1.ListRolloutsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRolloutsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.configdelivery.v1.Rollout>
        getRollout(com.google.cloud.configdelivery.v1.GetRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Suspend a Rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        suspendRollout(com.google.cloud.configdelivery.v1.SuspendRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuspendRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resume a Rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resumeRollout(com.google.cloud.configdelivery.v1.ResumeRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeRolloutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Abort a Rollout.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        abortRollout(com.google.cloud.configdelivery.v1.AbortRolloutRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAbortRolloutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_RESOURCE_BUNDLES = 0;
  private static final int METHODID_GET_RESOURCE_BUNDLE = 1;
  private static final int METHODID_CREATE_RESOURCE_BUNDLE = 2;
  private static final int METHODID_UPDATE_RESOURCE_BUNDLE = 3;
  private static final int METHODID_DELETE_RESOURCE_BUNDLE = 4;
  private static final int METHODID_LIST_FLEET_PACKAGES = 5;
  private static final int METHODID_GET_FLEET_PACKAGE = 6;
  private static final int METHODID_CREATE_FLEET_PACKAGE = 7;
  private static final int METHODID_UPDATE_FLEET_PACKAGE = 8;
  private static final int METHODID_DELETE_FLEET_PACKAGE = 9;
  private static final int METHODID_LIST_RELEASES = 10;
  private static final int METHODID_GET_RELEASE = 11;
  private static final int METHODID_CREATE_RELEASE = 12;
  private static final int METHODID_UPDATE_RELEASE = 13;
  private static final int METHODID_DELETE_RELEASE = 14;
  private static final int METHODID_LIST_VARIANTS = 15;
  private static final int METHODID_GET_VARIANT = 16;
  private static final int METHODID_CREATE_VARIANT = 17;
  private static final int METHODID_UPDATE_VARIANT = 18;
  private static final int METHODID_DELETE_VARIANT = 19;
  private static final int METHODID_LIST_ROLLOUTS = 20;
  private static final int METHODID_GET_ROLLOUT = 21;
  private static final int METHODID_SUSPEND_ROLLOUT = 22;
  private static final int METHODID_RESUME_ROLLOUT = 23;
  private static final int METHODID_ABORT_ROLLOUT = 24;

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
        case METHODID_LIST_RESOURCE_BUNDLES:
          serviceImpl.listResourceBundles(
              (com.google.cloud.configdelivery.v1.ListResourceBundlesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RESOURCE_BUNDLE:
          serviceImpl.getResourceBundle(
              (com.google.cloud.configdelivery.v1.GetResourceBundleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ResourceBundle>)
                  responseObserver);
          break;
        case METHODID_CREATE_RESOURCE_BUNDLE:
          serviceImpl.createResourceBundle(
              (com.google.cloud.configdelivery.v1.CreateResourceBundleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RESOURCE_BUNDLE:
          serviceImpl.updateResourceBundle(
              (com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RESOURCE_BUNDLE:
          serviceImpl.deleteResourceBundle(
              (com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FLEET_PACKAGES:
          serviceImpl.listFleetPackages(
              (com.google.cloud.configdelivery.v1.ListFleetPackagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FLEET_PACKAGE:
          serviceImpl.getFleetPackage(
              (com.google.cloud.configdelivery.v1.GetFleetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.FleetPackage>)
                  responseObserver);
          break;
        case METHODID_CREATE_FLEET_PACKAGE:
          serviceImpl.createFleetPackage(
              (com.google.cloud.configdelivery.v1.CreateFleetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_FLEET_PACKAGE:
          serviceImpl.updateFleetPackage(
              (com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_FLEET_PACKAGE:
          serviceImpl.deleteFleetPackage(
              (com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_RELEASES:
          serviceImpl.listReleases(
              (com.google.cloud.configdelivery.v1.ListReleasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListReleasesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RELEASE:
          serviceImpl.getRelease(
              (com.google.cloud.configdelivery.v1.GetReleaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Release>)
                  responseObserver);
          break;
        case METHODID_CREATE_RELEASE:
          serviceImpl.createRelease(
              (com.google.cloud.configdelivery.v1.CreateReleaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_RELEASE:
          serviceImpl.updateRelease(
              (com.google.cloud.configdelivery.v1.UpdateReleaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_RELEASE:
          serviceImpl.deleteRelease(
              (com.google.cloud.configdelivery.v1.DeleteReleaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VARIANTS:
          serviceImpl.listVariants(
              (com.google.cloud.configdelivery.v1.ListVariantsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListVariantsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VARIANT:
          serviceImpl.getVariant(
              (com.google.cloud.configdelivery.v1.GetVariantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Variant>)
                  responseObserver);
          break;
        case METHODID_CREATE_VARIANT:
          serviceImpl.createVariant(
              (com.google.cloud.configdelivery.v1.CreateVariantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_VARIANT:
          serviceImpl.updateVariant(
              (com.google.cloud.configdelivery.v1.UpdateVariantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_VARIANT:
          serviceImpl.deleteVariant(
              (com.google.cloud.configdelivery.v1.DeleteVariantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ROLLOUTS:
          serviceImpl.listRollouts(
              (com.google.cloud.configdelivery.v1.ListRolloutsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.ListRolloutsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ROLLOUT:
          serviceImpl.getRollout(
              (com.google.cloud.configdelivery.v1.GetRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.configdelivery.v1.Rollout>)
                  responseObserver);
          break;
        case METHODID_SUSPEND_ROLLOUT:
          serviceImpl.suspendRollout(
              (com.google.cloud.configdelivery.v1.SuspendRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESUME_ROLLOUT:
          serviceImpl.resumeRollout(
              (com.google.cloud.configdelivery.v1.ResumeRolloutRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ABORT_ROLLOUT:
          serviceImpl.abortRollout(
              (com.google.cloud.configdelivery.v1.AbortRolloutRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListResourceBundlesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ListResourceBundlesRequest,
                    com.google.cloud.configdelivery.v1.ListResourceBundlesResponse>(
                    service, METHODID_LIST_RESOURCE_BUNDLES)))
        .addMethod(
            getGetResourceBundleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.GetResourceBundleRequest,
                    com.google.cloud.configdelivery.v1.ResourceBundle>(
                    service, METHODID_GET_RESOURCE_BUNDLE)))
        .addMethod(
            getCreateResourceBundleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.CreateResourceBundleRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_RESOURCE_BUNDLE)))
        .addMethod(
            getUpdateResourceBundleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.UpdateResourceBundleRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_RESOURCE_BUNDLE)))
        .addMethod(
            getDeleteResourceBundleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.DeleteResourceBundleRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RESOURCE_BUNDLE)))
        .addMethod(
            getListFleetPackagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ListFleetPackagesRequest,
                    com.google.cloud.configdelivery.v1.ListFleetPackagesResponse>(
                    service, METHODID_LIST_FLEET_PACKAGES)))
        .addMethod(
            getGetFleetPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.GetFleetPackageRequest,
                    com.google.cloud.configdelivery.v1.FleetPackage>(
                    service, METHODID_GET_FLEET_PACKAGE)))
        .addMethod(
            getCreateFleetPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.CreateFleetPackageRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_FLEET_PACKAGE)))
        .addMethod(
            getUpdateFleetPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.UpdateFleetPackageRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_FLEET_PACKAGE)))
        .addMethod(
            getDeleteFleetPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.DeleteFleetPackageRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_FLEET_PACKAGE)))
        .addMethod(
            getListReleasesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ListReleasesRequest,
                    com.google.cloud.configdelivery.v1.ListReleasesResponse>(
                    service, METHODID_LIST_RELEASES)))
        .addMethod(
            getGetReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.GetReleaseRequest,
                    com.google.cloud.configdelivery.v1.Release>(service, METHODID_GET_RELEASE)))
        .addMethod(
            getCreateReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.CreateReleaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_RELEASE)))
        .addMethod(
            getUpdateReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.UpdateReleaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_RELEASE)))
        .addMethod(
            getDeleteReleaseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.DeleteReleaseRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_RELEASE)))
        .addMethod(
            getListVariantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ListVariantsRequest,
                    com.google.cloud.configdelivery.v1.ListVariantsResponse>(
                    service, METHODID_LIST_VARIANTS)))
        .addMethod(
            getGetVariantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.GetVariantRequest,
                    com.google.cloud.configdelivery.v1.Variant>(service, METHODID_GET_VARIANT)))
        .addMethod(
            getCreateVariantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.CreateVariantRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_VARIANT)))
        .addMethod(
            getUpdateVariantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.UpdateVariantRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_VARIANT)))
        .addMethod(
            getDeleteVariantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.DeleteVariantRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_VARIANT)))
        .addMethod(
            getListRolloutsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ListRolloutsRequest,
                    com.google.cloud.configdelivery.v1.ListRolloutsResponse>(
                    service, METHODID_LIST_ROLLOUTS)))
        .addMethod(
            getGetRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.GetRolloutRequest,
                    com.google.cloud.configdelivery.v1.Rollout>(service, METHODID_GET_ROLLOUT)))
        .addMethod(
            getSuspendRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.SuspendRolloutRequest,
                    com.google.longrunning.Operation>(service, METHODID_SUSPEND_ROLLOUT)))
        .addMethod(
            getResumeRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.ResumeRolloutRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESUME_ROLLOUT)))
        .addMethod(
            getAbortRolloutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.configdelivery.v1.AbortRolloutRequest,
                    com.google.longrunning.Operation>(service, METHODID_ABORT_ROLLOUT)))
        .build();
  }

  private abstract static class ConfigDeliveryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigDeliveryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.configdelivery.v1.ConfigDeliveryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigDelivery");
    }
  }

  private static final class ConfigDeliveryFileDescriptorSupplier
      extends ConfigDeliveryBaseDescriptorSupplier {
    ConfigDeliveryFileDescriptorSupplier() {}
  }

  private static final class ConfigDeliveryMethodDescriptorSupplier
      extends ConfigDeliveryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConfigDeliveryMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConfigDeliveryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConfigDeliveryFileDescriptorSupplier())
                      .addMethod(getListResourceBundlesMethod())
                      .addMethod(getGetResourceBundleMethod())
                      .addMethod(getCreateResourceBundleMethod())
                      .addMethod(getUpdateResourceBundleMethod())
                      .addMethod(getDeleteResourceBundleMethod())
                      .addMethod(getListFleetPackagesMethod())
                      .addMethod(getGetFleetPackageMethod())
                      .addMethod(getCreateFleetPackageMethod())
                      .addMethod(getUpdateFleetPackageMethod())
                      .addMethod(getDeleteFleetPackageMethod())
                      .addMethod(getListReleasesMethod())
                      .addMethod(getGetReleaseMethod())
                      .addMethod(getCreateReleaseMethod())
                      .addMethod(getUpdateReleaseMethod())
                      .addMethod(getDeleteReleaseMethod())
                      .addMethod(getListVariantsMethod())
                      .addMethod(getGetVariantMethod())
                      .addMethod(getCreateVariantMethod())
                      .addMethod(getUpdateVariantMethod())
                      .addMethod(getDeleteVariantMethod())
                      .addMethod(getListRolloutsMethod())
                      .addMethod(getGetRolloutMethod())
                      .addMethod(getSuspendRolloutMethod())
                      .addMethod(getResumeRolloutMethod())
                      .addMethod(getAbortRolloutMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
