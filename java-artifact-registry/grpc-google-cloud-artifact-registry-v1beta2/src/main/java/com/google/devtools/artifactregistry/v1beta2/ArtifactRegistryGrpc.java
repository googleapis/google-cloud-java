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
package com.google.devtools.artifactregistry.v1beta2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The Artifact Registry API service.
 * Artifact Registry is an artifact management system for storing artifacts
 * from different package management systems.
 * The resources managed by this API are:
 * * Repositories, which group packages and their data.
 * * Packages, which group versions and their tags.
 * * Versions, which are specific forms of a package.
 * * Tags, which represent alternative names for versions.
 * * Files, which contain content and are optionally associated with a Package
 *   or Version.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/devtools/artifactregistry/v1beta2/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ArtifactRegistryGrpc {

  private ArtifactRegistryGrpc() {}

  public static final String SERVICE_NAME =
      "google.devtools.artifactregistry.v1beta2.ArtifactRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest,
          com.google.longrunning.Operation>
      getImportAptArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAptArtifacts",
      requestType = com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest,
          com.google.longrunning.Operation>
      getImportAptArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest,
            com.google.longrunning.Operation>
        getImportAptArtifactsMethod;
    if ((getImportAptArtifactsMethod = ArtifactRegistryGrpc.getImportAptArtifactsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getImportAptArtifactsMethod = ArtifactRegistryGrpc.getImportAptArtifactsMethod)
            == null) {
          ArtifactRegistryGrpc.getImportAptArtifactsMethod =
              getImportAptArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportAptArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ImportAptArtifacts"))
                      .build();
        }
      }
    }
    return getImportAptArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest,
          com.google.longrunning.Operation>
      getImportYumArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportYumArtifacts",
      requestType = com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest,
          com.google.longrunning.Operation>
      getImportYumArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest,
            com.google.longrunning.Operation>
        getImportYumArtifactsMethod;
    if ((getImportYumArtifactsMethod = ArtifactRegistryGrpc.getImportYumArtifactsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getImportYumArtifactsMethod = ArtifactRegistryGrpc.getImportYumArtifactsMethod)
            == null) {
          ArtifactRegistryGrpc.getImportYumArtifactsMethod =
              getImportYumArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportYumArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ImportYumArtifacts"))
                      .build();
        }
      }
    }
    return getImportYumArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
      getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
      getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest,
            com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
        getListRepositoriesMethod;
    if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
          ArtifactRegistryGrpc.getListRepositoriesMethod =
              getListRepositoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest,
                          com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListRepositories"))
                      .build();
        }
      }
    }
    return getListRepositoriesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1beta2.Repository>
      getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1beta2.Repository>
      getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest,
            com.google.devtools.artifactregistry.v1beta2.Repository>
        getGetRepositoryMethod;
    if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getGetRepositoryMethod =
              getGetRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest,
                          com.google.devtools.artifactregistry.v1beta2.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Repository
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetRepository"))
                      .build();
        }
      }
    }
    return getGetRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRepository",
      requestType = com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest,
            com.google.longrunning.Operation>
        getCreateRepositoryMethod;
    if ((getCreateRepositoryMethod = ArtifactRegistryGrpc.getCreateRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getCreateRepositoryMethod = ArtifactRegistryGrpc.getCreateRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getCreateRepositoryMethod =
              getCreateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("CreateRepository"))
                      .build();
        }
      }
    }
    return getCreateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest,
          com.google.devtools.artifactregistry.v1beta2.Repository>
      getUpdateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRepository",
      requestType = com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest,
          com.google.devtools.artifactregistry.v1beta2.Repository>
      getUpdateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest,
            com.google.devtools.artifactregistry.v1beta2.Repository>
        getUpdateRepositoryMethod;
    if ((getUpdateRepositoryMethod = ArtifactRegistryGrpc.getUpdateRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateRepositoryMethod = ArtifactRegistryGrpc.getUpdateRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getUpdateRepositoryMethod =
              getUpdateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest,
                          com.google.devtools.artifactregistry.v1beta2.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Repository
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateRepository"))
                      .build();
        }
      }
    }
    return getUpdateRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRepository",
      requestType = com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest,
            com.google.longrunning.Operation>
        getDeleteRepositoryMethod;
    if ((getDeleteRepositoryMethod = ArtifactRegistryGrpc.getDeleteRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteRepositoryMethod = ArtifactRegistryGrpc.getDeleteRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getDeleteRepositoryMethod =
              getDeleteRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("DeleteRepository"))
                      .build();
        }
      }
    }
    return getDeleteRepositoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
      getListPackagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPackages",
      requestType = com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
      getListPackagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest,
            com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
        getListPackagesMethod;
    if ((getListPackagesMethod = ArtifactRegistryGrpc.getListPackagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListPackagesMethod = ArtifactRegistryGrpc.getListPackagesMethod) == null) {
          ArtifactRegistryGrpc.getListPackagesMethod =
              getListPackagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest,
                          com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPackages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListPackages"))
                      .build();
        }
      }
    }
    return getListPackagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetPackageRequest,
          com.google.devtools.artifactregistry.v1beta2.Package>
      getGetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPackage",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetPackageRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Package.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetPackageRequest,
          com.google.devtools.artifactregistry.v1beta2.Package>
      getGetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetPackageRequest,
            com.google.devtools.artifactregistry.v1beta2.Package>
        getGetPackageMethod;
    if ((getGetPackageMethod = ArtifactRegistryGrpc.getGetPackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetPackageMethod = ArtifactRegistryGrpc.getGetPackageMethod) == null) {
          ArtifactRegistryGrpc.getGetPackageMethod =
              getGetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetPackageRequest,
                          com.google.devtools.artifactregistry.v1beta2.Package>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Package
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetPackage"))
                      .build();
        }
      }
    }
    return getGetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest,
          com.google.longrunning.Operation>
      getDeletePackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePackage",
      requestType = com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest,
          com.google.longrunning.Operation>
      getDeletePackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest,
            com.google.longrunning.Operation>
        getDeletePackageMethod;
    if ((getDeletePackageMethod = ArtifactRegistryGrpc.getDeletePackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeletePackageMethod = ArtifactRegistryGrpc.getDeletePackageMethod) == null) {
          ArtifactRegistryGrpc.getDeletePackageMethod =
              getDeletePackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("DeletePackage"))
                      .build();
        }
      }
    }
    return getDeletePackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest,
          com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
      getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest,
          com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
      getListVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest,
            com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
        getListVersionsMethod;
    if ((getListVersionsMethod = ArtifactRegistryGrpc.getListVersionsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListVersionsMethod = ArtifactRegistryGrpc.getListVersionsMethod) == null) {
          ArtifactRegistryGrpc.getListVersionsMethod =
              getListVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest,
                          com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListVersions"))
                      .build();
        }
      }
    }
    return getListVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetVersionRequest,
          com.google.devtools.artifactregistry.v1beta2.Version>
      getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetVersionRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetVersionRequest,
          com.google.devtools.artifactregistry.v1beta2.Version>
      getGetVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetVersionRequest,
            com.google.devtools.artifactregistry.v1beta2.Version>
        getGetVersionMethod;
    if ((getGetVersionMethod = ArtifactRegistryGrpc.getGetVersionMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetVersionMethod = ArtifactRegistryGrpc.getGetVersionMethod) == null) {
          ArtifactRegistryGrpc.getGetVersionMethod =
              getGetVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetVersionRequest,
                          com.google.devtools.artifactregistry.v1beta2.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Version
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetVersion"))
                      .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest,
          com.google.longrunning.Operation>
      getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest,
          com.google.longrunning.Operation>
      getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest,
            com.google.longrunning.Operation>
        getDeleteVersionMethod;
    if ((getDeleteVersionMethod = ArtifactRegistryGrpc.getDeleteVersionMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteVersionMethod = ArtifactRegistryGrpc.getDeleteVersionMethod) == null) {
          ArtifactRegistryGrpc.getDeleteVersionMethod =
              getDeleteVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("DeleteVersion"))
                      .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListFilesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
      getListFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFiles",
      requestType = com.google.devtools.artifactregistry.v1beta2.ListFilesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ListFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListFilesRequest,
          com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
      getListFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ListFilesRequest,
            com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
        getListFilesMethod;
    if ((getListFilesMethod = ArtifactRegistryGrpc.getListFilesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListFilesMethod = ArtifactRegistryGrpc.getListFilesMethod) == null) {
          ArtifactRegistryGrpc.getListFilesMethod =
              getListFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ListFilesRequest,
                          com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListFilesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListFiles"))
                      .build();
        }
      }
    }
    return getListFilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetFileRequest,
          com.google.devtools.artifactregistry.v1beta2.File>
      getGetFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFile",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetFileRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetFileRequest,
          com.google.devtools.artifactregistry.v1beta2.File>
      getGetFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetFileRequest,
            com.google.devtools.artifactregistry.v1beta2.File>
        getGetFileMethod;
    if ((getGetFileMethod = ArtifactRegistryGrpc.getGetFileMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetFileMethod = ArtifactRegistryGrpc.getGetFileMethod) == null) {
          ArtifactRegistryGrpc.getGetFileMethod =
              getGetFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetFileRequest,
                          com.google.devtools.artifactregistry.v1beta2.File>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.File
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("GetFile"))
                      .build();
        }
      }
    }
    return getGetFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListTagsRequest,
          com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
      getListTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTags",
      requestType = com.google.devtools.artifactregistry.v1beta2.ListTagsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ListTagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.ListTagsRequest,
          com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
      getListTagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.ListTagsRequest,
            com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
        getListTagsMethod;
    if ((getListTagsMethod = ArtifactRegistryGrpc.getListTagsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListTagsMethod = ArtifactRegistryGrpc.getListTagsMethod) == null) {
          ArtifactRegistryGrpc.getListTagsMethod =
              getListTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.ListTagsRequest,
                          com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListTagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ListTagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("ListTags"))
                      .build();
        }
      }
    }
    return getListTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getGetTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTag",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getGetTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetTagRequest,
            com.google.devtools.artifactregistry.v1beta2.Tag>
        getGetTagMethod;
    if ((getGetTagMethod = ArtifactRegistryGrpc.getGetTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetTagMethod = ArtifactRegistryGrpc.getGetTagMethod) == null) {
          ArtifactRegistryGrpc.getGetTagMethod =
              getGetTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetTagRequest,
                          com.google.devtools.artifactregistry.v1beta2.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Tag
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("GetTag"))
                      .build();
        }
      }
    }
    return getGetTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.CreateTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getCreateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTag",
      requestType = com.google.devtools.artifactregistry.v1beta2.CreateTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.CreateTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getCreateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.CreateTagRequest,
            com.google.devtools.artifactregistry.v1beta2.Tag>
        getCreateTagMethod;
    if ((getCreateTagMethod = ArtifactRegistryGrpc.getCreateTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getCreateTagMethod = ArtifactRegistryGrpc.getCreateTagMethod) == null) {
          ArtifactRegistryGrpc.getCreateTagMethod =
              getCreateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.CreateTagRequest,
                          com.google.devtools.artifactregistry.v1beta2.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.CreateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Tag
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("CreateTag"))
                      .build();
        }
      }
    }
    return getCreateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getUpdateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTag",
      requestType = com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest,
          com.google.devtools.artifactregistry.v1beta2.Tag>
      getUpdateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest,
            com.google.devtools.artifactregistry.v1beta2.Tag>
        getUpdateTagMethod;
    if ((getUpdateTagMethod = ArtifactRegistryGrpc.getUpdateTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateTagMethod = ArtifactRegistryGrpc.getUpdateTagMethod) == null) {
          ArtifactRegistryGrpc.getUpdateTagMethod =
              getUpdateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest,
                          com.google.devtools.artifactregistry.v1beta2.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.Tag
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateTag"))
                      .build();
        }
      }
    }
    return getUpdateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTag",
      requestType = com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest,
            com.google.protobuf.Empty>
        getDeleteTagMethod;
    if ((getDeleteTagMethod = ArtifactRegistryGrpc.getDeleteTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteTagMethod = ArtifactRegistryGrpc.getDeleteTagMethod) == null) {
          ArtifactRegistryGrpc.getDeleteTagMethod =
              getDeleteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("DeleteTag"))
                      .build();
        }
      }
    }
    return getDeleteTagMethod;
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
    if ((getSetIamPolicyMethod = ArtifactRegistryGrpc.getSetIamPolicyMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getSetIamPolicyMethod = ArtifactRegistryGrpc.getSetIamPolicyMethod) == null) {
          ArtifactRegistryGrpc.getSetIamPolicyMethod =
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
                          new ArtifactRegistryMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
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
    if ((getGetIamPolicyMethod = ArtifactRegistryGrpc.getGetIamPolicyMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetIamPolicyMethod = ArtifactRegistryGrpc.getGetIamPolicyMethod) == null) {
          ArtifactRegistryGrpc.getGetIamPolicyMethod =
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
                          new ArtifactRegistryMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
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
    if ((getTestIamPermissionsMethod = ArtifactRegistryGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getTestIamPermissionsMethod = ArtifactRegistryGrpc.getTestIamPermissionsMethod)
            == null) {
          ArtifactRegistryGrpc.getTestIamPermissionsMethod =
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
                          new ArtifactRegistryMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
      getGetProjectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectSettings",
      requestType = com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ProjectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
      getGetProjectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest,
            com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
        getGetProjectSettingsMethod;
    if ((getGetProjectSettingsMethod = ArtifactRegistryGrpc.getGetProjectSettingsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetProjectSettingsMethod = ArtifactRegistryGrpc.getGetProjectSettingsMethod)
            == null) {
          ArtifactRegistryGrpc.getGetProjectSettingsMethod =
              getGetProjectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest,
                          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProjectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ProjectSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetProjectSettings"))
                      .build();
        }
      }
    }
    return getGetProjectSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
      getUpdateProjectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProjectSettings",
      requestType = com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1beta2.ProjectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
      getUpdateProjectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest,
            com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
        getUpdateProjectSettingsMethod;
    if ((getUpdateProjectSettingsMethod = ArtifactRegistryGrpc.getUpdateProjectSettingsMethod)
        == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateProjectSettingsMethod = ArtifactRegistryGrpc.getUpdateProjectSettingsMethod)
            == null) {
          ArtifactRegistryGrpc.getUpdateProjectSettingsMethod =
              getUpdateProjectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest,
                          com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateProjectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2
                                  .UpdateProjectSettingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1beta2.ProjectSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateProjectSettings"))
                      .build();
        }
      }
    }
    return getUpdateProjectSettingsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ArtifactRegistryStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryStub>() {
          @java.lang.Override
          public ArtifactRegistryStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryStub(channel, callOptions);
          }
        };
    return ArtifactRegistryStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArtifactRegistryBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryBlockingStub>() {
          @java.lang.Override
          public ArtifactRegistryBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryBlockingStub(channel, callOptions);
          }
        };
    return ArtifactRegistryBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ArtifactRegistryFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ArtifactRegistryFutureStub>() {
          @java.lang.Override
          public ArtifactRegistryFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ArtifactRegistryFutureStub(channel, callOptions);
          }
        };
    return ArtifactRegistryFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public abstract static class ArtifactRegistryImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Imports Apt artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public void importAptArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportAptArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports Yum (RPM) artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public void importYumArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportYumArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public void listRepositories(
        com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRepositoriesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public void getRepository(
        com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a repository. The returned Operation will finish once the
     * repository has been created. Its response will be the created Repository.
     * </pre>
     */
    public void createRepository(
        com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a repository.
     * </pre>
     */
    public void updateRepository(
        com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a repository and all of its contents. The returned Operation will
     * finish once the repository has been deleted. It will not have any Operation
     * metadata and will return a google.protobuf.Empty response.
     * </pre>
     */
    public void deleteRepository(
        com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteRepositoryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists packages.
     * </pre>
     */
    public void listPackages(
        com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPackagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a package.
     * </pre>
     */
    public void getPackage(
        com.google.devtools.artifactregistry.v1beta2.GetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Package>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a package and all of its versions and tags. The returned operation
     * will complete once the package has been deleted.
     * </pre>
     */
    public void deletePackage(
        com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions.
     * </pre>
     */
    public void listVersions(
        com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a version
     * </pre>
     */
    public void getVersion(
        com.google.devtools.artifactregistry.v1beta2.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Version>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a version and all of its content. The returned operation will
     * complete once the version has been deleted.
     * </pre>
     */
    public void deleteVersion(
        com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public void listFiles(
        com.google.devtools.artifactregistry.v1beta2.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListFilesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a file.
     * </pre>
     */
    public void getFile(
        com.google.devtools.artifactregistry.v1beta2.GetFileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.File>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFileMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tags.
     * </pre>
     */
    public void listTags(
        com.google.devtools.artifactregistry.v1beta2.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTagsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag.
     * </pre>
     */
    public void getTag(
        com.google.devtools.artifactregistry.v1beta2.GetTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag.
     * </pre>
     */
    public void createTag(
        com.google.devtools.artifactregistry.v1beta2.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag.
     * </pre>
     */
    public void updateTag(
        com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAM policy for a given resource.
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
     * Gets the IAM policy for a given resource.
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
     * Tests if the caller has a list of permissions on a resource.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTestIamPermissionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the Settings for the Project.
     * </pre>
     */
    public void getProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProjectSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings for the Project.
     * </pre>
     */
    public void updateProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProjectSettingsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getImportAptArtifactsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_APT_ARTIFACTS)))
          .addMethod(
              getImportYumArtifactsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_YUM_ARTIFACTS)))
          .addMethod(
              getListRepositoriesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest,
                      com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>(
                      this, METHODID_LIST_REPOSITORIES)))
          .addMethod(
              getGetRepositoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest,
                      com.google.devtools.artifactregistry.v1beta2.Repository>(
                      this, METHODID_GET_REPOSITORY)))
          .addMethod(
              getCreateRepositoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_REPOSITORY)))
          .addMethod(
              getUpdateRepositoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest,
                      com.google.devtools.artifactregistry.v1beta2.Repository>(
                      this, METHODID_UPDATE_REPOSITORY)))
          .addMethod(
              getDeleteRepositoryMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_REPOSITORY)))
          .addMethod(
              getListPackagesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest,
                      com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>(
                      this, METHODID_LIST_PACKAGES)))
          .addMethod(
              getGetPackageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetPackageRequest,
                      com.google.devtools.artifactregistry.v1beta2.Package>(
                      this, METHODID_GET_PACKAGE)))
          .addMethod(
              getDeletePackageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_PACKAGE)))
          .addMethod(
              getListVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest,
                      com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>(
                      this, METHODID_LIST_VERSIONS)))
          .addMethod(
              getGetVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetVersionRequest,
                      com.google.devtools.artifactregistry.v1beta2.Version>(
                      this, METHODID_GET_VERSION)))
          .addMethod(
              getDeleteVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_VERSION)))
          .addMethod(
              getListFilesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ListFilesRequest,
                      com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>(
                      this, METHODID_LIST_FILES)))
          .addMethod(
              getGetFileMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetFileRequest,
                      com.google.devtools.artifactregistry.v1beta2.File>(this, METHODID_GET_FILE)))
          .addMethod(
              getListTagsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.ListTagsRequest,
                      com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>(
                      this, METHODID_LIST_TAGS)))
          .addMethod(
              getGetTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetTagRequest,
                      com.google.devtools.artifactregistry.v1beta2.Tag>(this, METHODID_GET_TAG)))
          .addMethod(
              getCreateTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.CreateTagRequest,
                      com.google.devtools.artifactregistry.v1beta2.Tag>(this, METHODID_CREATE_TAG)))
          .addMethod(
              getUpdateTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest,
                      com.google.devtools.artifactregistry.v1beta2.Tag>(this, METHODID_UPDATE_TAG)))
          .addMethod(
              getDeleteTagMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAG)))
          .addMethod(
              getSetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getGetIamPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.TestIamPermissionsRequest,
                      com.google.iam.v1.TestIamPermissionsResponse>(
                      this, METHODID_TEST_IAM_PERMISSIONS)))
          .addMethod(
              getGetProjectSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest,
                      com.google.devtools.artifactregistry.v1beta2.ProjectSettings>(
                      this, METHODID_GET_PROJECT_SETTINGS)))
          .addMethod(
              getUpdateProjectSettingsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest,
                      com.google.devtools.artifactregistry.v1beta2.ProjectSettings>(
                      this, METHODID_UPDATE_PROJECT_SETTINGS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryStub
      extends io.grpc.stub.AbstractAsyncStub<ArtifactRegistryStub> {
    private ArtifactRegistryStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports Apt artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public void importAptArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAptArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports Yum (RPM) artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public void importYumArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportYumArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public void listRepositories(
        com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public void getRepository(
        com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a repository. The returned Operation will finish once the
     * repository has been created. Its response will be the created Repository.
     * </pre>
     */
    public void createRepository(
        com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a repository.
     * </pre>
     */
    public void updateRepository(
        com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a repository and all of its contents. The returned Operation will
     * finish once the repository has been deleted. It will not have any Operation
     * metadata and will return a google.protobuf.Empty response.
     * </pre>
     */
    public void deleteRepository(
        com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists packages.
     * </pre>
     */
    public void listPackages(
        com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPackagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a package.
     * </pre>
     */
    public void getPackage(
        com.google.devtools.artifactregistry.v1beta2.GetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Package>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPackageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a package and all of its versions and tags. The returned operation
     * will complete once the package has been deleted.
     * </pre>
     */
    public void deletePackage(
        com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists versions.
     * </pre>
     */
    public void listVersions(
        com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a version
     * </pre>
     */
    public void getVersion(
        com.google.devtools.artifactregistry.v1beta2.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Version>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a version and all of its content. The returned operation will
     * complete once the version has been deleted.
     * </pre>
     */
    public void deleteVersion(
        com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public void listFiles(
        com.google.devtools.artifactregistry.v1beta2.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a file.
     * </pre>
     */
    public void getFile(
        com.google.devtools.artifactregistry.v1beta2.GetFileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.File>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists tags.
     * </pre>
     */
    public void listTags(
        com.google.devtools.artifactregistry.v1beta2.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTagsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag.
     * </pre>
     */
    public void getTag(
        com.google.devtools.artifactregistry.v1beta2.GetTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag.
     * </pre>
     */
    public void createTag(
        com.google.devtools.artifactregistry.v1beta2.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag.
     * </pre>
     */
    public void updateTag(
        com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public void deleteTag(
        com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAM policy for a given resource.
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
     * Gets the IAM policy for a given resource.
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
     * Tests if the caller has a list of permissions on a resource.
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

    /**
     *
     *
     * <pre>
     * Retrieves the Settings for the Project.
     * </pre>
     */
    public void getProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProjectSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings for the Project.
     * </pre>
     */
    public void updateProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProjectSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ArtifactRegistryBlockingStub> {
    private ArtifactRegistryBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports Apt artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public com.google.longrunning.Operation importAptArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAptArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports Yum (RPM) artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public com.google.longrunning.Operation importYumArtifacts(
        com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportYumArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse listRepositories(
        com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRepositoriesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Repository getRepository(
        com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a repository. The returned Operation will finish once the
     * repository has been created. Its response will be the created Repository.
     * </pre>
     */
    public com.google.longrunning.Operation createRepository(
        com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a repository.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Repository updateRepository(
        com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a repository and all of its contents. The returned Operation will
     * finish once the repository has been deleted. It will not have any Operation
     * metadata and will return a google.protobuf.Empty response.
     * </pre>
     */
    public com.google.longrunning.Operation deleteRepository(
        com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteRepositoryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists packages.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse listPackages(
        com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPackagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a package.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Package getPackage(
        com.google.devtools.artifactregistry.v1beta2.GetPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a package and all of its versions and tags. The returned operation
     * will complete once the package has been deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deletePackage(
        com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse listVersions(
        com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a version
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Version getVersion(
        com.google.devtools.artifactregistry.v1beta2.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a version and all of its content. The returned operation will
     * complete once the version has been deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteVersion(
        com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ListFilesResponse listFiles(
        com.google.devtools.artifactregistry.v1beta2.ListFilesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFilesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a file.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.File getFile(
        com.google.devtools.artifactregistry.v1beta2.GetFileRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFileMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tags.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ListTagsResponse listTags(
        com.google.devtools.artifactregistry.v1beta2.ListTagsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTagsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Tag getTag(
        com.google.devtools.artifactregistry.v1beta2.GetTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Tag createTag(
        com.google.devtools.artifactregistry.v1beta2.CreateTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.Tag updateTag(
        com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTag(
        com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTagMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAM policy for a given resource.
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
     * Gets the IAM policy for a given resource.
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
     * Tests if the caller has a list of permissions on a resource.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the Settings for the Project.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ProjectSettings getProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProjectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings for the Project.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1beta2.ProjectSettings updateProjectSettings(
        com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProjectSettingsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The Artifact Registry API service.
   * Artifact Registry is an artifact management system for storing artifacts
   * from different package management systems.
   * The resources managed by this API are:
   * * Repositories, which group packages and their data.
   * * Packages, which group versions and their tags.
   * * Versions, which are specific forms of a package.
   * * Tags, which represent alternative names for versions.
   * * Files, which contain content and are optionally associated with a Package
   *   or Version.
   * </pre>
   */
  public static final class ArtifactRegistryFutureStub
      extends io.grpc.stub.AbstractFutureStub<ArtifactRegistryFutureStub> {
    private ArtifactRegistryFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArtifactRegistryFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArtifactRegistryFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Imports Apt artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importAptArtifacts(
            com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAptArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports Yum (RPM) artifacts. The returned Operation will complete once the
     * resources are imported. Package, Version, and File resources are created
     * based on the imported artifacts. Imported artifacts that conflict with
     * existing resources are ignored.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importYumArtifacts(
            com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportYumArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists repositories.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>
        listRepositories(
            com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRepositoriesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Repository>
        getRepository(com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a repository. The returned Operation will finish once the
     * repository has been created. Its response will be the created Repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createRepository(
            com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a repository.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Repository>
        updateRepository(
            com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a repository and all of its contents. The returned Operation will
     * finish once the repository has been deleted. It will not have any Operation
     * metadata and will return a google.protobuf.Empty response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteRepository(
            com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteRepositoryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists packages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>
        listPackages(com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPackagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a package.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Package>
        getPackage(com.google.devtools.artifactregistry.v1beta2.GetPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a package and all of its versions and tags. The returned operation
     * will complete once the package has been deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deletePackage(com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists versions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>
        listVersions(com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a version
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Version>
        getVersion(com.google.devtools.artifactregistry.v1beta2.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a version and all of its content. The returned operation will
     * complete once the version has been deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteVersion(com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>
        listFiles(com.google.devtools.artifactregistry.v1beta2.ListFilesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFilesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a file.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.File>
        getFile(com.google.devtools.artifactregistry.v1beta2.GetFileRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFileMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists tags.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>
        listTags(com.google.devtools.artifactregistry.v1beta2.ListTagsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTagsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Tag>
        getTag(com.google.devtools.artifactregistry.v1beta2.GetTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Tag>
        createTag(com.google.devtools.artifactregistry.v1beta2.CreateTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.Tag>
        updateTag(com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteTag(
        com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTagMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the IAM policy for a given resource.
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
     * Gets the IAM policy for a given resource.
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
     * Tests if the caller has a list of permissions on a resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the Settings for the Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
        getProjectSettings(
            com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProjectSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the Settings for the Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1beta2.ProjectSettings>
        updateProjectSettings(
            com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProjectSettingsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_IMPORT_APT_ARTIFACTS = 0;
  private static final int METHODID_IMPORT_YUM_ARTIFACTS = 1;
  private static final int METHODID_LIST_REPOSITORIES = 2;
  private static final int METHODID_GET_REPOSITORY = 3;
  private static final int METHODID_CREATE_REPOSITORY = 4;
  private static final int METHODID_UPDATE_REPOSITORY = 5;
  private static final int METHODID_DELETE_REPOSITORY = 6;
  private static final int METHODID_LIST_PACKAGES = 7;
  private static final int METHODID_GET_PACKAGE = 8;
  private static final int METHODID_DELETE_PACKAGE = 9;
  private static final int METHODID_LIST_VERSIONS = 10;
  private static final int METHODID_GET_VERSION = 11;
  private static final int METHODID_DELETE_VERSION = 12;
  private static final int METHODID_LIST_FILES = 13;
  private static final int METHODID_GET_FILE = 14;
  private static final int METHODID_LIST_TAGS = 15;
  private static final int METHODID_GET_TAG = 16;
  private static final int METHODID_CREATE_TAG = 17;
  private static final int METHODID_UPDATE_TAG = 18;
  private static final int METHODID_DELETE_TAG = 19;
  private static final int METHODID_SET_IAM_POLICY = 20;
  private static final int METHODID_GET_IAM_POLICY = 21;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 22;
  private static final int METHODID_GET_PROJECT_SETTINGS = 23;
  private static final int METHODID_UPDATE_PROJECT_SETTINGS = 24;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArtifactRegistryImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArtifactRegistryImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_IMPORT_APT_ARTIFACTS:
          serviceImpl.importAptArtifacts(
              (com.google.devtools.artifactregistry.v1beta2.ImportAptArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_YUM_ARTIFACTS:
          serviceImpl.importYumArtifacts(
              (com.google.devtools.artifactregistry.v1beta2.ImportYumArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories(
              (com.google.devtools.artifactregistry.v1beta2.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ListRepositoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository(
              (com.google.devtools.artifactregistry.v1beta2.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPOSITORY:
          serviceImpl.createRepository(
              (com.google.devtools.artifactregistry.v1beta2.CreateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REPOSITORY:
          serviceImpl.updateRepository(
              (com.google.devtools.artifactregistry.v1beta2.UpdateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Repository>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPOSITORY:
          serviceImpl.deleteRepository(
              (com.google.devtools.artifactregistry.v1beta2.DeleteRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PACKAGES:
          serviceImpl.listPackages(
              (com.google.devtools.artifactregistry.v1beta2.ListPackagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ListPackagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PACKAGE:
          serviceImpl.getPackage(
              (com.google.devtools.artifactregistry.v1beta2.GetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Package>)
                  responseObserver);
          break;
        case METHODID_DELETE_PACKAGE:
          serviceImpl.deletePackage(
              (com.google.devtools.artifactregistry.v1beta2.DeletePackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions(
              (com.google.devtools.artifactregistry.v1beta2.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ListVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion(
              (com.google.devtools.artifactregistry.v1beta2.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Version>)
                  responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion(
              (com.google.devtools.artifactregistry.v1beta2.DeleteVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FILES:
          serviceImpl.listFiles(
              (com.google.devtools.artifactregistry.v1beta2.ListFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ListFilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FILE:
          serviceImpl.getFile(
              (com.google.devtools.artifactregistry.v1beta2.GetFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.File>)
                  responseObserver);
          break;
        case METHODID_LIST_TAGS:
          serviceImpl.listTags(
              (com.google.devtools.artifactregistry.v1beta2.ListTagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ListTagsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TAG:
          serviceImpl.getTag(
              (com.google.devtools.artifactregistry.v1beta2.GetTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>)
                  responseObserver);
          break;
        case METHODID_CREATE_TAG:
          serviceImpl.createTag(
              (com.google.devtools.artifactregistry.v1beta2.CreateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG:
          serviceImpl.updateTag(
              (com.google.devtools.artifactregistry.v1beta2.UpdateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1beta2.Tag>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG:
          serviceImpl.deleteTag(
              (com.google.devtools.artifactregistry.v1beta2.DeleteTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_SET_IAM_POLICY:
          serviceImpl.setIamPolicy(
              (com.google.iam.v1.SetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_GET_IAM_POLICY:
          serviceImpl.getIamPolicy(
              (com.google.iam.v1.GetIamPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.Policy>) responseObserver);
          break;
        case METHODID_TEST_IAM_PERMISSIONS:
          serviceImpl.testIamPermissions(
              (com.google.iam.v1.TestIamPermissionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROJECT_SETTINGS:
          serviceImpl.getProjectSettings(
              (com.google.devtools.artifactregistry.v1beta2.GetProjectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ProjectSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROJECT_SETTINGS:
          serviceImpl.updateProjectSettings(
              (com.google.devtools.artifactregistry.v1beta2.UpdateProjectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1beta2.ProjectSettings>)
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

  private abstract static class ArtifactRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArtifactRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.artifactregistry.v1beta2.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArtifactRegistry");
    }
  }

  private static final class ArtifactRegistryFileDescriptorSupplier
      extends ArtifactRegistryBaseDescriptorSupplier {
    ArtifactRegistryFileDescriptorSupplier() {}
  }

  private static final class ArtifactRegistryMethodDescriptorSupplier
      extends ArtifactRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArtifactRegistryMethodDescriptorSupplier(String methodName) {
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
      synchronized (ArtifactRegistryGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ArtifactRegistryFileDescriptorSupplier())
                      .addMethod(getImportAptArtifactsMethod())
                      .addMethod(getImportYumArtifactsMethod())
                      .addMethod(getListRepositoriesMethod())
                      .addMethod(getGetRepositoryMethod())
                      .addMethod(getCreateRepositoryMethod())
                      .addMethod(getUpdateRepositoryMethod())
                      .addMethod(getDeleteRepositoryMethod())
                      .addMethod(getListPackagesMethod())
                      .addMethod(getGetPackageMethod())
                      .addMethod(getDeletePackageMethod())
                      .addMethod(getListVersionsMethod())
                      .addMethod(getGetVersionMethod())
                      .addMethod(getDeleteVersionMethod())
                      .addMethod(getListFilesMethod())
                      .addMethod(getGetFileMethod())
                      .addMethod(getListTagsMethod())
                      .addMethod(getGetTagMethod())
                      .addMethod(getCreateTagMethod())
                      .addMethod(getUpdateTagMethod())
                      .addMethod(getDeleteTagMethod())
                      .addMethod(getSetIamPolicyMethod())
                      .addMethod(getGetIamPolicyMethod())
                      .addMethod(getTestIamPermissionsMethod())
                      .addMethod(getGetProjectSettingsMethod())
                      .addMethod(getUpdateProjectSettingsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
