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
package com.google.devtools.artifactregistry.v1;

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
    comments = "Source: google/devtools/artifactregistry/v1/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ArtifactRegistryGrpc {

  private ArtifactRegistryGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.devtools.artifactregistry.v1.ArtifactRegistry";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
      getListDockerImagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDockerImages",
      requestType = com.google.devtools.artifactregistry.v1.ListDockerImagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListDockerImagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
      getListDockerImagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
            com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
        getListDockerImagesMethod;
    if ((getListDockerImagesMethod = ArtifactRegistryGrpc.getListDockerImagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListDockerImagesMethod = ArtifactRegistryGrpc.getListDockerImagesMethod) == null) {
          ArtifactRegistryGrpc.getListDockerImagesMethod =
              getListDockerImagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
                          com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDockerImages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListDockerImagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListDockerImagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListDockerImages"))
                      .build();
        }
      }
    }
    return getListDockerImagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetDockerImageRequest,
          com.google.devtools.artifactregistry.v1.DockerImage>
      getGetDockerImageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDockerImage",
      requestType = com.google.devtools.artifactregistry.v1.GetDockerImageRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.DockerImage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetDockerImageRequest,
          com.google.devtools.artifactregistry.v1.DockerImage>
      getGetDockerImageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetDockerImageRequest,
            com.google.devtools.artifactregistry.v1.DockerImage>
        getGetDockerImageMethod;
    if ((getGetDockerImageMethod = ArtifactRegistryGrpc.getGetDockerImageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetDockerImageMethod = ArtifactRegistryGrpc.getGetDockerImageMethod) == null) {
          ArtifactRegistryGrpc.getGetDockerImageMethod =
              getGetDockerImageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetDockerImageRequest,
                          com.google.devtools.artifactregistry.v1.DockerImage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDockerImage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetDockerImageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.DockerImage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetDockerImage"))
                      .build();
        }
      }
    }
    return getGetDockerImageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest,
          com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
      getListMavenArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListMavenArtifacts",
      requestType = com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest,
          com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
      getListMavenArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest,
            com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
        getListMavenArtifactsMethod;
    if ((getListMavenArtifactsMethod = ArtifactRegistryGrpc.getListMavenArtifactsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListMavenArtifactsMethod = ArtifactRegistryGrpc.getListMavenArtifactsMethod)
            == null) {
          ArtifactRegistryGrpc.getListMavenArtifactsMethod =
              getListMavenArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest,
                          com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListMavenArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListMavenArtifacts"))
                      .build();
        }
      }
    }
    return getListMavenArtifactsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest,
          com.google.devtools.artifactregistry.v1.MavenArtifact>
      getGetMavenArtifactMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMavenArtifact",
      requestType = com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.MavenArtifact.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest,
          com.google.devtools.artifactregistry.v1.MavenArtifact>
      getGetMavenArtifactMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest,
            com.google.devtools.artifactregistry.v1.MavenArtifact>
        getGetMavenArtifactMethod;
    if ((getGetMavenArtifactMethod = ArtifactRegistryGrpc.getGetMavenArtifactMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetMavenArtifactMethod = ArtifactRegistryGrpc.getGetMavenArtifactMethod) == null) {
          ArtifactRegistryGrpc.getGetMavenArtifactMethod =
              getGetMavenArtifactMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest,
                          com.google.devtools.artifactregistry.v1.MavenArtifact>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMavenArtifact"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.MavenArtifact
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetMavenArtifact"))
                      .build();
        }
      }
    }
    return getGetMavenArtifactMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
      getListNpmPackagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListNpmPackages",
      requestType = com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
      getListNpmPackagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest,
            com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
        getListNpmPackagesMethod;
    if ((getListNpmPackagesMethod = ArtifactRegistryGrpc.getListNpmPackagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListNpmPackagesMethod = ArtifactRegistryGrpc.getListNpmPackagesMethod) == null) {
          ArtifactRegistryGrpc.getListNpmPackagesMethod =
              getListNpmPackagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest,
                          com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListNpmPackages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListNpmPackages"))
                      .build();
        }
      }
    }
    return getListNpmPackagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetNpmPackageRequest,
          com.google.devtools.artifactregistry.v1.NpmPackage>
      getGetNpmPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetNpmPackage",
      requestType = com.google.devtools.artifactregistry.v1.GetNpmPackageRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.NpmPackage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetNpmPackageRequest,
          com.google.devtools.artifactregistry.v1.NpmPackage>
      getGetNpmPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetNpmPackageRequest,
            com.google.devtools.artifactregistry.v1.NpmPackage>
        getGetNpmPackageMethod;
    if ((getGetNpmPackageMethod = ArtifactRegistryGrpc.getGetNpmPackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetNpmPackageMethod = ArtifactRegistryGrpc.getGetNpmPackageMethod) == null) {
          ArtifactRegistryGrpc.getGetNpmPackageMethod =
              getGetNpmPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetNpmPackageRequest,
                          com.google.devtools.artifactregistry.v1.NpmPackage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetNpmPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetNpmPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.NpmPackage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetNpmPackage"))
                      .build();
        }
      }
    }
    return getGetNpmPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
      getListPythonPackagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPythonPackages",
      requestType = com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
      getListPythonPackagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest,
            com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
        getListPythonPackagesMethod;
    if ((getListPythonPackagesMethod = ArtifactRegistryGrpc.getListPythonPackagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListPythonPackagesMethod = ArtifactRegistryGrpc.getListPythonPackagesMethod)
            == null) {
          ArtifactRegistryGrpc.getListPythonPackagesMethod =
              getListPythonPackagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest,
                          com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPythonPackages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("ListPythonPackages"))
                      .build();
        }
      }
    }
    return getListPythonPackagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetPythonPackageRequest,
          com.google.devtools.artifactregistry.v1.PythonPackage>
      getGetPythonPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPythonPackage",
      requestType = com.google.devtools.artifactregistry.v1.GetPythonPackageRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.PythonPackage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetPythonPackageRequest,
          com.google.devtools.artifactregistry.v1.PythonPackage>
      getGetPythonPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetPythonPackageRequest,
            com.google.devtools.artifactregistry.v1.PythonPackage>
        getGetPythonPackageMethod;
    if ((getGetPythonPackageMethod = ArtifactRegistryGrpc.getGetPythonPackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetPythonPackageMethod = ArtifactRegistryGrpc.getGetPythonPackageMethod) == null) {
          ArtifactRegistryGrpc.getGetPythonPackageMethod =
              getGetPythonPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetPythonPackageRequest,
                          com.google.devtools.artifactregistry.v1.PythonPackage>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPythonPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetPythonPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.PythonPackage
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetPythonPackage"))
                      .build();
        }
      }
    }
    return getGetPythonPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest,
          com.google.longrunning.Operation>
      getImportAptArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAptArtifacts",
      requestType = com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest,
          com.google.longrunning.Operation>
      getImportAptArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest,
            com.google.longrunning.Operation>
        getImportAptArtifactsMethod;
    if ((getImportAptArtifactsMethod = ArtifactRegistryGrpc.getImportAptArtifactsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getImportAptArtifactsMethod = ArtifactRegistryGrpc.getImportAptArtifactsMethod)
            == null) {
          ArtifactRegistryGrpc.getImportAptArtifactsMethod =
              getImportAptArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportAptArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest
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
          com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest,
          com.google.longrunning.Operation>
      getImportYumArtifactsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportYumArtifacts",
      requestType = com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest,
          com.google.longrunning.Operation>
      getImportYumArtifactsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest,
            com.google.longrunning.Operation>
        getImportYumArtifactsMethod;
    if ((getImportYumArtifactsMethod = ArtifactRegistryGrpc.getImportYumArtifactsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getImportYumArtifactsMethod = ArtifactRegistryGrpc.getImportYumArtifactsMethod)
            == null) {
          ArtifactRegistryGrpc.getImportYumArtifactsMethod =
              getImportYumArtifactsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportYumArtifacts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest
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
          com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
      getListRepositoriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRepositories",
      requestType = com.google.devtools.artifactregistry.v1.ListRepositoriesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListRepositoriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
      getListRepositoriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
            com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
        getListRepositoriesMethod;
    if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListRepositoriesMethod = ArtifactRegistryGrpc.getListRepositoriesMethod) == null) {
          ArtifactRegistryGrpc.getListRepositoriesMethod =
              getListRepositoriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
                          com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRepositories"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListRepositoriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListRepositoriesResponse
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
          com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getGetRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRepository",
      requestType = com.google.devtools.artifactregistry.v1.GetRepositoryRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getGetRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
            com.google.devtools.artifactregistry.v1.Repository>
        getGetRepositoryMethod;
    if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetRepositoryMethod = ArtifactRegistryGrpc.getGetRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getGetRepositoryMethod =
              getGetRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
                          com.google.devtools.artifactregistry.v1.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Repository
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
          com.google.devtools.artifactregistry.v1.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateRepository",
      requestType = com.google.devtools.artifactregistry.v1.CreateRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.CreateRepositoryRequest,
          com.google.longrunning.Operation>
      getCreateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.CreateRepositoryRequest,
            com.google.longrunning.Operation>
        getCreateRepositoryMethod;
    if ((getCreateRepositoryMethod = ArtifactRegistryGrpc.getCreateRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getCreateRepositoryMethod = ArtifactRegistryGrpc.getCreateRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getCreateRepositoryMethod =
              getCreateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.CreateRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.CreateRepositoryRequest
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
          com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getUpdateRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateRepository",
      requestType = com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Repository.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest,
          com.google.devtools.artifactregistry.v1.Repository>
      getUpdateRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest,
            com.google.devtools.artifactregistry.v1.Repository>
        getUpdateRepositoryMethod;
    if ((getUpdateRepositoryMethod = ArtifactRegistryGrpc.getUpdateRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateRepositoryMethod = ArtifactRegistryGrpc.getUpdateRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getUpdateRepositoryMethod =
              getUpdateRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest,
                          com.google.devtools.artifactregistry.v1.Repository>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Repository
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
          com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteRepository",
      requestType = com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest,
          com.google.longrunning.Operation>
      getDeleteRepositoryMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest,
            com.google.longrunning.Operation>
        getDeleteRepositoryMethod;
    if ((getDeleteRepositoryMethod = ArtifactRegistryGrpc.getDeleteRepositoryMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteRepositoryMethod = ArtifactRegistryGrpc.getDeleteRepositoryMethod) == null) {
          ArtifactRegistryGrpc.getDeleteRepositoryMethod =
              getDeleteRepositoryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteRepository"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest
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
          com.google.devtools.artifactregistry.v1.ListPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListPackagesResponse>
      getListPackagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPackages",
      requestType = com.google.devtools.artifactregistry.v1.ListPackagesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListPackagesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListPackagesRequest,
          com.google.devtools.artifactregistry.v1.ListPackagesResponse>
      getListPackagesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListPackagesRequest,
            com.google.devtools.artifactregistry.v1.ListPackagesResponse>
        getListPackagesMethod;
    if ((getListPackagesMethod = ArtifactRegistryGrpc.getListPackagesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListPackagesMethod = ArtifactRegistryGrpc.getListPackagesMethod) == null) {
          ArtifactRegistryGrpc.getListPackagesMethod =
              getListPackagesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListPackagesRequest,
                          com.google.devtools.artifactregistry.v1.ListPackagesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPackages"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListPackagesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListPackagesResponse
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
          com.google.devtools.artifactregistry.v1.GetPackageRequest,
          com.google.devtools.artifactregistry.v1.Package>
      getGetPackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPackage",
      requestType = com.google.devtools.artifactregistry.v1.GetPackageRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Package.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetPackageRequest,
          com.google.devtools.artifactregistry.v1.Package>
      getGetPackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetPackageRequest,
            com.google.devtools.artifactregistry.v1.Package>
        getGetPackageMethod;
    if ((getGetPackageMethod = ArtifactRegistryGrpc.getGetPackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetPackageMethod = ArtifactRegistryGrpc.getGetPackageMethod) == null) {
          ArtifactRegistryGrpc.getGetPackageMethod =
              getGetPackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetPackageRequest,
                          com.google.devtools.artifactregistry.v1.Package>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetPackageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Package.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetPackage"))
                      .build();
        }
      }
    }
    return getGetPackageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeletePackageRequest,
          com.google.longrunning.Operation>
      getDeletePackageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePackage",
      requestType = com.google.devtools.artifactregistry.v1.DeletePackageRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeletePackageRequest,
          com.google.longrunning.Operation>
      getDeletePackageMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.DeletePackageRequest,
            com.google.longrunning.Operation>
        getDeletePackageMethod;
    if ((getDeletePackageMethod = ArtifactRegistryGrpc.getDeletePackageMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeletePackageMethod = ArtifactRegistryGrpc.getDeletePackageMethod) == null) {
          ArtifactRegistryGrpc.getDeletePackageMethod =
              getDeletePackageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.DeletePackageRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePackage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.DeletePackageRequest
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
          com.google.devtools.artifactregistry.v1.ListVersionsRequest,
          com.google.devtools.artifactregistry.v1.ListVersionsResponse>
      getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.devtools.artifactregistry.v1.ListVersionsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListVersionsRequest,
          com.google.devtools.artifactregistry.v1.ListVersionsResponse>
      getListVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListVersionsRequest,
            com.google.devtools.artifactregistry.v1.ListVersionsResponse>
        getListVersionsMethod;
    if ((getListVersionsMethod = ArtifactRegistryGrpc.getListVersionsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListVersionsMethod = ArtifactRegistryGrpc.getListVersionsMethod) == null) {
          ArtifactRegistryGrpc.getListVersionsMethod =
              getListVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListVersionsRequest,
                          com.google.devtools.artifactregistry.v1.ListVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListVersionsResponse
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
          com.google.devtools.artifactregistry.v1.GetVersionRequest,
          com.google.devtools.artifactregistry.v1.Version>
      getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.devtools.artifactregistry.v1.GetVersionRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetVersionRequest,
          com.google.devtools.artifactregistry.v1.Version>
      getGetVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetVersionRequest,
            com.google.devtools.artifactregistry.v1.Version>
        getGetVersionMethod;
    if ((getGetVersionMethod = ArtifactRegistryGrpc.getGetVersionMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetVersionMethod = ArtifactRegistryGrpc.getGetVersionMethod) == null) {
          ArtifactRegistryGrpc.getGetVersionMethod =
              getGetVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetVersionRequest,
                          com.google.devtools.artifactregistry.v1.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Version.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetVersion"))
                      .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeleteVersionRequest,
          com.google.longrunning.Operation>
      getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.devtools.artifactregistry.v1.DeleteVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeleteVersionRequest,
          com.google.longrunning.Operation>
      getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.DeleteVersionRequest,
            com.google.longrunning.Operation>
        getDeleteVersionMethod;
    if ((getDeleteVersionMethod = ArtifactRegistryGrpc.getDeleteVersionMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteVersionMethod = ArtifactRegistryGrpc.getDeleteVersionMethod) == null) {
          ArtifactRegistryGrpc.getDeleteVersionMethod =
              getDeleteVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.DeleteVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.DeleteVersionRequest
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
          com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteVersions",
      requestType = com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest,
          com.google.longrunning.Operation>
      getBatchDeleteVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest,
            com.google.longrunning.Operation>
        getBatchDeleteVersionsMethod;
    if ((getBatchDeleteVersionsMethod = ArtifactRegistryGrpc.getBatchDeleteVersionsMethod)
        == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getBatchDeleteVersionsMethod = ArtifactRegistryGrpc.getBatchDeleteVersionsMethod)
            == null) {
          ArtifactRegistryGrpc.getBatchDeleteVersionsMethod =
              getBatchDeleteVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("BatchDeleteVersions"))
                      .build();
        }
      }
    }
    return getBatchDeleteVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListFilesRequest,
          com.google.devtools.artifactregistry.v1.ListFilesResponse>
      getListFilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFiles",
      requestType = com.google.devtools.artifactregistry.v1.ListFilesRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListFilesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListFilesRequest,
          com.google.devtools.artifactregistry.v1.ListFilesResponse>
      getListFilesMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListFilesRequest,
            com.google.devtools.artifactregistry.v1.ListFilesResponse>
        getListFilesMethod;
    if ((getListFilesMethod = ArtifactRegistryGrpc.getListFilesMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListFilesMethod = ArtifactRegistryGrpc.getListFilesMethod) == null) {
          ArtifactRegistryGrpc.getListFilesMethod =
              getListFilesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListFilesRequest,
                          com.google.devtools.artifactregistry.v1.ListFilesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFiles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListFilesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListFilesResponse
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
          com.google.devtools.artifactregistry.v1.GetFileRequest,
          com.google.devtools.artifactregistry.v1.File>
      getGetFileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFile",
      requestType = com.google.devtools.artifactregistry.v1.GetFileRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.File.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetFileRequest,
          com.google.devtools.artifactregistry.v1.File>
      getGetFileMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetFileRequest,
            com.google.devtools.artifactregistry.v1.File>
        getGetFileMethod;
    if ((getGetFileMethod = ArtifactRegistryGrpc.getGetFileMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetFileMethod = ArtifactRegistryGrpc.getGetFileMethod) == null) {
          ArtifactRegistryGrpc.getGetFileMethod =
              getGetFileMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetFileRequest,
                          com.google.devtools.artifactregistry.v1.File>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFile"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetFileRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.File.getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("GetFile"))
                      .build();
        }
      }
    }
    return getGetFileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListTagsRequest,
          com.google.devtools.artifactregistry.v1.ListTagsResponse>
      getListTagsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTags",
      requestType = com.google.devtools.artifactregistry.v1.ListTagsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ListTagsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.ListTagsRequest,
          com.google.devtools.artifactregistry.v1.ListTagsResponse>
      getListTagsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.ListTagsRequest,
            com.google.devtools.artifactregistry.v1.ListTagsResponse>
        getListTagsMethod;
    if ((getListTagsMethod = ArtifactRegistryGrpc.getListTagsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getListTagsMethod = ArtifactRegistryGrpc.getListTagsMethod) == null) {
          ArtifactRegistryGrpc.getListTagsMethod =
              getListTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.ListTagsRequest,
                          com.google.devtools.artifactregistry.v1.ListTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListTagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ListTagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("ListTags"))
                      .build();
        }
      }
    }
    return getListTagsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getGetTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTag",
      requestType = com.google.devtools.artifactregistry.v1.GetTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getGetTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetTagRequest,
            com.google.devtools.artifactregistry.v1.Tag>
        getGetTagMethod;
    if ((getGetTagMethod = ArtifactRegistryGrpc.getGetTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetTagMethod = ArtifactRegistryGrpc.getGetTagMethod) == null) {
          ArtifactRegistryGrpc.getGetTagMethod =
              getGetTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetTagRequest,
                          com.google.devtools.artifactregistry.v1.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(new ArtifactRegistryMethodDescriptorSupplier("GetTag"))
                      .build();
        }
      }
    }
    return getGetTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.CreateTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getCreateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTag",
      requestType = com.google.devtools.artifactregistry.v1.CreateTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.CreateTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getCreateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.CreateTagRequest,
            com.google.devtools.artifactregistry.v1.Tag>
        getCreateTagMethod;
    if ((getCreateTagMethod = ArtifactRegistryGrpc.getCreateTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getCreateTagMethod = ArtifactRegistryGrpc.getCreateTagMethod) == null) {
          ArtifactRegistryGrpc.getCreateTagMethod =
              getCreateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.CreateTagRequest,
                          com.google.devtools.artifactregistry.v1.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.CreateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("CreateTag"))
                      .build();
        }
      }
    }
    return getCreateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getUpdateTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTag",
      requestType = com.google.devtools.artifactregistry.v1.UpdateTagRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.Tag.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateTagRequest,
          com.google.devtools.artifactregistry.v1.Tag>
      getUpdateTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.UpdateTagRequest,
            com.google.devtools.artifactregistry.v1.Tag>
        getUpdateTagMethod;
    if ((getUpdateTagMethod = ArtifactRegistryGrpc.getUpdateTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateTagMethod = ArtifactRegistryGrpc.getUpdateTagMethod) == null) {
          ArtifactRegistryGrpc.getUpdateTagMethod =
              getUpdateTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.UpdateTagRequest,
                          com.google.devtools.artifactregistry.v1.Tag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.UpdateTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.Tag.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateTag"))
                      .build();
        }
      }
    }
    return getUpdateTagMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTag",
      requestType = com.google.devtools.artifactregistry.v1.DeleteTagRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.DeleteTagRequest, com.google.protobuf.Empty>
      getDeleteTagMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.DeleteTagRequest, com.google.protobuf.Empty>
        getDeleteTagMethod;
    if ((getDeleteTagMethod = ArtifactRegistryGrpc.getDeleteTagMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getDeleteTagMethod = ArtifactRegistryGrpc.getDeleteTagMethod) == null) {
          ArtifactRegistryGrpc.getDeleteTagMethod =
              getDeleteTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.DeleteTagRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.DeleteTagRequest
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
          com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1.ProjectSettings>
      getGetProjectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProjectSettings",
      requestType = com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ProjectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1.ProjectSettings>
      getGetProjectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest,
            com.google.devtools.artifactregistry.v1.ProjectSettings>
        getGetProjectSettingsMethod;
    if ((getGetProjectSettingsMethod = ArtifactRegistryGrpc.getGetProjectSettingsMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetProjectSettingsMethod = ArtifactRegistryGrpc.getGetProjectSettingsMethod)
            == null) {
          ArtifactRegistryGrpc.getGetProjectSettingsMethod =
              getGetProjectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest,
                          com.google.devtools.artifactregistry.v1.ProjectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProjectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ProjectSettings
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
          com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1.ProjectSettings>
      getUpdateProjectSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateProjectSettings",
      requestType = com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.ProjectSettings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest,
          com.google.devtools.artifactregistry.v1.ProjectSettings>
      getUpdateProjectSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest,
            com.google.devtools.artifactregistry.v1.ProjectSettings>
        getUpdateProjectSettingsMethod;
    if ((getUpdateProjectSettingsMethod = ArtifactRegistryGrpc.getUpdateProjectSettingsMethod)
        == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateProjectSettingsMethod = ArtifactRegistryGrpc.getUpdateProjectSettingsMethod)
            == null) {
          ArtifactRegistryGrpc.getUpdateProjectSettingsMethod =
              getUpdateProjectSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest,
                          com.google.devtools.artifactregistry.v1.ProjectSettings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateProjectSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.ProjectSettings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateProjectSettings"))
                      .build();
        }
      }
    }
    return getUpdateProjectSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest,
          com.google.devtools.artifactregistry.v1.VPCSCConfig>
      getGetVPCSCConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVPCSCConfig",
      requestType = com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.VPCSCConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest,
          com.google.devtools.artifactregistry.v1.VPCSCConfig>
      getGetVPCSCConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest,
            com.google.devtools.artifactregistry.v1.VPCSCConfig>
        getGetVPCSCConfigMethod;
    if ((getGetVPCSCConfigMethod = ArtifactRegistryGrpc.getGetVPCSCConfigMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getGetVPCSCConfigMethod = ArtifactRegistryGrpc.getGetVPCSCConfigMethod) == null) {
          ArtifactRegistryGrpc.getGetVPCSCConfigMethod =
              getGetVPCSCConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest,
                          com.google.devtools.artifactregistry.v1.VPCSCConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVPCSCConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.VPCSCConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("GetVPCSCConfig"))
                      .build();
        }
      }
    }
    return getGetVPCSCConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest,
          com.google.devtools.artifactregistry.v1.VPCSCConfig>
      getUpdateVPCSCConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVPCSCConfig",
      requestType = com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest.class,
      responseType = com.google.devtools.artifactregistry.v1.VPCSCConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest,
          com.google.devtools.artifactregistry.v1.VPCSCConfig>
      getUpdateVPCSCConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest,
            com.google.devtools.artifactregistry.v1.VPCSCConfig>
        getUpdateVPCSCConfigMethod;
    if ((getUpdateVPCSCConfigMethod = ArtifactRegistryGrpc.getUpdateVPCSCConfigMethod) == null) {
      synchronized (ArtifactRegistryGrpc.class) {
        if ((getUpdateVPCSCConfigMethod = ArtifactRegistryGrpc.getUpdateVPCSCConfigMethod)
            == null) {
          ArtifactRegistryGrpc.getUpdateVPCSCConfigMethod =
              getUpdateVPCSCConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest,
                          com.google.devtools.artifactregistry.v1.VPCSCConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVPCSCConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.devtools.artifactregistry.v1.VPCSCConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ArtifactRegistryMethodDescriptorSupplier("UpdateVPCSCConfig"))
                      .build();
        }
      }
    }
    return getUpdateVPCSCConfigMethod;
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
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists docker images.
     * </pre>
     */
    default void listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDockerImagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a docker image.
     * </pre>
     */
    default void getDockerImage(
        com.google.devtools.artifactregistry.v1.GetDockerImageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.DockerImage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDockerImageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists maven artifacts.
     * </pre>
     */
    default void listMavenArtifacts(
        com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListMavenArtifactsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a maven artifact.
     * </pre>
     */
    default void getMavenArtifact(
        com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.MavenArtifact>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetMavenArtifactMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists npm packages.
     * </pre>
     */
    default void listNpmPackages(
        com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListNpmPackagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a npm package.
     * </pre>
     */
    default void getNpmPackage(
        com.google.devtools.artifactregistry.v1.GetNpmPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.NpmPackage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetNpmPackageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists python packages.
     * </pre>
     */
    default void listPythonPackages(
        com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPythonPackagesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a python package.
     * </pre>
     */
    default void getPythonPackage(
        com.google.devtools.artifactregistry.v1.GetPythonPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.PythonPackage>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPythonPackageMethod(), responseObserver);
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
    default void importAptArtifacts(
        com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest request,
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
    default void importYumArtifacts(
        com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest request,
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
    default void listRepositories(
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
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
    default void getRepository(
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
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
    default void createRepository(
        com.google.devtools.artifactregistry.v1.CreateRepositoryRequest request,
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
    default void updateRepository(
        com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
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
    default void deleteRepository(
        com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest request,
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
    default void listPackages(
        com.google.devtools.artifactregistry.v1.ListPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListPackagesResponse>
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
    default void getPackage(
        com.google.devtools.artifactregistry.v1.GetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Package>
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
    default void deletePackage(
        com.google.devtools.artifactregistry.v1.DeletePackageRequest request,
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
    default void listVersions(
        com.google.devtools.artifactregistry.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListVersionsResponse>
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
    default void getVersion(
        com.google.devtools.artifactregistry.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Version>
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
    default void deleteVersion(
        com.google.devtools.artifactregistry.v1.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple versions across a repository. The returned operation will
     * complete once the versions have been deleted.
     * </pre>
     */
    default void batchDeleteVersions(
        com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    default void listFiles(
        com.google.devtools.artifactregistry.v1.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListFilesResponse>
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
    default void getFile(
        com.google.devtools.artifactregistry.v1.GetFileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.File>
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
    default void listTags(
        com.google.devtools.artifactregistry.v1.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListTagsResponse>
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
    default void getTag(
        com.google.devtools.artifactregistry.v1.GetTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a tag.
     * </pre>
     */
    default void createTag(
        com.google.devtools.artifactregistry.v1.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a tag.
     * </pre>
     */
    default void updateTag(
        com.google.devtools.artifactregistry.v1.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateTagMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a tag.
     * </pre>
     */
    default void deleteTag(
        com.google.devtools.artifactregistry.v1.DeleteTagRequest request,
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
    default void setIamPolicy(
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
    default void getIamPolicy(
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
    default void testIamPermissions(
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
    default void getProjectSettings(
        com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>
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
    default void updateProjectSettings(
        com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateProjectSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the VPCSC Config for the Project.
     * </pre>
     */
    default void getVPCSCConfig(
        com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetVPCSCConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the VPCSC Config for the Project.
     * </pre>
     */
    default void updateVPCSCConfig(
        com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVPCSCConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ArtifactRegistry.
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
  public abstract static class ArtifactRegistryImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ArtifactRegistryGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ArtifactRegistry.
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
     * Lists docker images.
     * </pre>
     */
    public void listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDockerImagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a docker image.
     * </pre>
     */
    public void getDockerImage(
        com.google.devtools.artifactregistry.v1.GetDockerImageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.DockerImage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDockerImageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists maven artifacts.
     * </pre>
     */
    public void listMavenArtifacts(
        com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListMavenArtifactsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a maven artifact.
     * </pre>
     */
    public void getMavenArtifact(
        com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.MavenArtifact>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMavenArtifactMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists npm packages.
     * </pre>
     */
    public void listNpmPackages(
        com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListNpmPackagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a npm package.
     * </pre>
     */
    public void getNpmPackage(
        com.google.devtools.artifactregistry.v1.GetNpmPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.NpmPackage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetNpmPackageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists python packages.
     * </pre>
     */
    public void listPythonPackages(
        com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPythonPackagesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a python package.
     * </pre>
     */
    public void getPythonPackage(
        com.google.devtools.artifactregistry.v1.GetPythonPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.PythonPackage>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPythonPackageMethod(), getCallOptions()),
          request,
          responseObserver);
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
        com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest request,
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
        com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest request,
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
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
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
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
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
        com.google.devtools.artifactregistry.v1.CreateRepositoryRequest request,
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
        com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>
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
        com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest request,
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
        com.google.devtools.artifactregistry.v1.ListPackagesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListPackagesResponse>
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
        com.google.devtools.artifactregistry.v1.GetPackageRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Package>
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
        com.google.devtools.artifactregistry.v1.DeletePackageRequest request,
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
        com.google.devtools.artifactregistry.v1.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListVersionsResponse>
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
        com.google.devtools.artifactregistry.v1.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Version>
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
        com.google.devtools.artifactregistry.v1.DeleteVersionRequest request,
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
     * Deletes multiple versions across a repository. The returned operation will
     * complete once the versions have been deleted.
     * </pre>
     */
    public void batchDeleteVersions(
        com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteVersionsMethod(), getCallOptions()),
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
        com.google.devtools.artifactregistry.v1.ListFilesRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListFilesResponse>
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
        com.google.devtools.artifactregistry.v1.GetFileRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.File>
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
        com.google.devtools.artifactregistry.v1.ListTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ListTagsResponse>
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
        com.google.devtools.artifactregistry.v1.GetTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
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
        com.google.devtools.artifactregistry.v1.CreateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
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
        com.google.devtools.artifactregistry.v1.UpdateTagRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag> responseObserver) {
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
        com.google.devtools.artifactregistry.v1.DeleteTagRequest request,
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
        com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>
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
        com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateProjectSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the VPCSC Config for the Project.
     * </pre>
     */
    public void getVPCSCConfig(
        com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVPCSCConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the VPCSC Config for the Project.
     * </pre>
     */
    public void updateVPCSCConfig(
        com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVPCSCConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ArtifactRegistry.
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
     * Lists docker images.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListDockerImagesResponse listDockerImages(
        com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDockerImagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a docker image.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.DockerImage getDockerImage(
        com.google.devtools.artifactregistry.v1.GetDockerImageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDockerImageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists maven artifacts.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse listMavenArtifacts(
        com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListMavenArtifactsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a maven artifact.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.MavenArtifact getMavenArtifact(
        com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMavenArtifactMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists npm packages.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse listNpmPackages(
        com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListNpmPackagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a npm package.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.NpmPackage getNpmPackage(
        com.google.devtools.artifactregistry.v1.GetNpmPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetNpmPackageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists python packages.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse listPythonPackages(
        com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPythonPackagesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a python package.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.PythonPackage getPythonPackage(
        com.google.devtools.artifactregistry.v1.GetPythonPackageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPythonPackageMethod(), getCallOptions(), request);
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
        com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest request) {
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
        com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ListRepositoriesResponse listRepositories(
        com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Repository getRepository(
        com.google.devtools.artifactregistry.v1.GetRepositoryRequest request) {
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
        com.google.devtools.artifactregistry.v1.CreateRepositoryRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Repository updateRepository(
        com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest request) {
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
        com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ListPackagesResponse listPackages(
        com.google.devtools.artifactregistry.v1.ListPackagesRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Package getPackage(
        com.google.devtools.artifactregistry.v1.GetPackageRequest request) {
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
        com.google.devtools.artifactregistry.v1.DeletePackageRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ListVersionsResponse listVersions(
        com.google.devtools.artifactregistry.v1.ListVersionsRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Version getVersion(
        com.google.devtools.artifactregistry.v1.GetVersionRequest request) {
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
        com.google.devtools.artifactregistry.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple versions across a repository. The returned operation will
     * complete once the versions have been deleted.
     * </pre>
     */
    public com.google.longrunning.Operation batchDeleteVersions(
        com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.ListFilesResponse listFiles(
        com.google.devtools.artifactregistry.v1.ListFilesRequest request) {
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
    public com.google.devtools.artifactregistry.v1.File getFile(
        com.google.devtools.artifactregistry.v1.GetFileRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ListTagsResponse listTags(
        com.google.devtools.artifactregistry.v1.ListTagsRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Tag getTag(
        com.google.devtools.artifactregistry.v1.GetTagRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Tag createTag(
        com.google.devtools.artifactregistry.v1.CreateTagRequest request) {
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
    public com.google.devtools.artifactregistry.v1.Tag updateTag(
        com.google.devtools.artifactregistry.v1.UpdateTagRequest request) {
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
        com.google.devtools.artifactregistry.v1.DeleteTagRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ProjectSettings getProjectSettings(
        com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest request) {
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
    public com.google.devtools.artifactregistry.v1.ProjectSettings updateProjectSettings(
        com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateProjectSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the VPCSC Config for the Project.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.VPCSCConfig getVPCSCConfig(
        com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVPCSCConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the VPCSC Config for the Project.
     * </pre>
     */
    public com.google.devtools.artifactregistry.v1.VPCSCConfig updateVPCSCConfig(
        com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVPCSCConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ArtifactRegistry.
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
     * Lists docker images.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>
        listDockerImages(com.google.devtools.artifactregistry.v1.ListDockerImagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDockerImagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a docker image.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.DockerImage>
        getDockerImage(com.google.devtools.artifactregistry.v1.GetDockerImageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDockerImageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists maven artifacts.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>
        listMavenArtifacts(
            com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListMavenArtifactsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a maven artifact.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.MavenArtifact>
        getMavenArtifact(com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMavenArtifactMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists npm packages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>
        listNpmPackages(com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListNpmPackagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a npm package.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.NpmPackage>
        getNpmPackage(com.google.devtools.artifactregistry.v1.GetNpmPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetNpmPackageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists python packages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>
        listPythonPackages(
            com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPythonPackagesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a python package.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.PythonPackage>
        getPythonPackage(com.google.devtools.artifactregistry.v1.GetPythonPackageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPythonPackageMethod(), getCallOptions()), request);
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
            com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest request) {
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
            com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest request) {
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
            com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>
        listRepositories(com.google.devtools.artifactregistry.v1.ListRepositoriesRequest request) {
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
            com.google.devtools.artifactregistry.v1.Repository>
        getRepository(com.google.devtools.artifactregistry.v1.GetRepositoryRequest request) {
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
        createRepository(com.google.devtools.artifactregistry.v1.CreateRepositoryRequest request) {
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
            com.google.devtools.artifactregistry.v1.Repository>
        updateRepository(com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest request) {
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
        deleteRepository(com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest request) {
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
            com.google.devtools.artifactregistry.v1.ListPackagesResponse>
        listPackages(com.google.devtools.artifactregistry.v1.ListPackagesRequest request) {
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
            com.google.devtools.artifactregistry.v1.Package>
        getPackage(com.google.devtools.artifactregistry.v1.GetPackageRequest request) {
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
        deletePackage(com.google.devtools.artifactregistry.v1.DeletePackageRequest request) {
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
            com.google.devtools.artifactregistry.v1.ListVersionsResponse>
        listVersions(com.google.devtools.artifactregistry.v1.ListVersionsRequest request) {
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
            com.google.devtools.artifactregistry.v1.Version>
        getVersion(com.google.devtools.artifactregistry.v1.GetVersionRequest request) {
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
        deleteVersion(com.google.devtools.artifactregistry.v1.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple versions across a repository. The returned operation will
     * complete once the versions have been deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchDeleteVersions(
            com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists files.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.ListFilesResponse>
        listFiles(com.google.devtools.artifactregistry.v1.ListFilesRequest request) {
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
            com.google.devtools.artifactregistry.v1.File>
        getFile(com.google.devtools.artifactregistry.v1.GetFileRequest request) {
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
            com.google.devtools.artifactregistry.v1.ListTagsResponse>
        listTags(com.google.devtools.artifactregistry.v1.ListTagsRequest request) {
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
            com.google.devtools.artifactregistry.v1.Tag>
        getTag(com.google.devtools.artifactregistry.v1.GetTagRequest request) {
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
            com.google.devtools.artifactregistry.v1.Tag>
        createTag(com.google.devtools.artifactregistry.v1.CreateTagRequest request) {
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
            com.google.devtools.artifactregistry.v1.Tag>
        updateTag(com.google.devtools.artifactregistry.v1.UpdateTagRequest request) {
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
        com.google.devtools.artifactregistry.v1.DeleteTagRequest request) {
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
            com.google.devtools.artifactregistry.v1.ProjectSettings>
        getProjectSettings(
            com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest request) {
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
            com.google.devtools.artifactregistry.v1.ProjectSettings>
        updateProjectSettings(
            com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateProjectSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the VPCSC Config for the Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.VPCSCConfig>
        getVPCSCConfig(com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVPCSCConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the VPCSC Config for the Project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.devtools.artifactregistry.v1.VPCSCConfig>
        updateVPCSCConfig(
            com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVPCSCConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_DOCKER_IMAGES = 0;
  private static final int METHODID_GET_DOCKER_IMAGE = 1;
  private static final int METHODID_LIST_MAVEN_ARTIFACTS = 2;
  private static final int METHODID_GET_MAVEN_ARTIFACT = 3;
  private static final int METHODID_LIST_NPM_PACKAGES = 4;
  private static final int METHODID_GET_NPM_PACKAGE = 5;
  private static final int METHODID_LIST_PYTHON_PACKAGES = 6;
  private static final int METHODID_GET_PYTHON_PACKAGE = 7;
  private static final int METHODID_IMPORT_APT_ARTIFACTS = 8;
  private static final int METHODID_IMPORT_YUM_ARTIFACTS = 9;
  private static final int METHODID_LIST_REPOSITORIES = 10;
  private static final int METHODID_GET_REPOSITORY = 11;
  private static final int METHODID_CREATE_REPOSITORY = 12;
  private static final int METHODID_UPDATE_REPOSITORY = 13;
  private static final int METHODID_DELETE_REPOSITORY = 14;
  private static final int METHODID_LIST_PACKAGES = 15;
  private static final int METHODID_GET_PACKAGE = 16;
  private static final int METHODID_DELETE_PACKAGE = 17;
  private static final int METHODID_LIST_VERSIONS = 18;
  private static final int METHODID_GET_VERSION = 19;
  private static final int METHODID_DELETE_VERSION = 20;
  private static final int METHODID_BATCH_DELETE_VERSIONS = 21;
  private static final int METHODID_LIST_FILES = 22;
  private static final int METHODID_GET_FILE = 23;
  private static final int METHODID_LIST_TAGS = 24;
  private static final int METHODID_GET_TAG = 25;
  private static final int METHODID_CREATE_TAG = 26;
  private static final int METHODID_UPDATE_TAG = 27;
  private static final int METHODID_DELETE_TAG = 28;
  private static final int METHODID_SET_IAM_POLICY = 29;
  private static final int METHODID_GET_IAM_POLICY = 30;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 31;
  private static final int METHODID_GET_PROJECT_SETTINGS = 32;
  private static final int METHODID_UPDATE_PROJECT_SETTINGS = 33;
  private static final int METHODID_GET_VPCSCCONFIG = 34;
  private static final int METHODID_UPDATE_VPCSCCONFIG = 35;

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
        case METHODID_LIST_DOCKER_IMAGES:
          serviceImpl.listDockerImages(
              (com.google.devtools.artifactregistry.v1.ListDockerImagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DOCKER_IMAGE:
          serviceImpl.getDockerImage(
              (com.google.devtools.artifactregistry.v1.GetDockerImageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.DockerImage>)
                  responseObserver);
          break;
        case METHODID_LIST_MAVEN_ARTIFACTS:
          serviceImpl.listMavenArtifacts(
              (com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MAVEN_ARTIFACT:
          serviceImpl.getMavenArtifact(
              (com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.MavenArtifact>)
                  responseObserver);
          break;
        case METHODID_LIST_NPM_PACKAGES:
          serviceImpl.listNpmPackages(
              (com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_NPM_PACKAGE:
          serviceImpl.getNpmPackage(
              (com.google.devtools.artifactregistry.v1.GetNpmPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.NpmPackage>)
                  responseObserver);
          break;
        case METHODID_LIST_PYTHON_PACKAGES:
          serviceImpl.listPythonPackages(
              (com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PYTHON_PACKAGE:
          serviceImpl.getPythonPackage(
              (com.google.devtools.artifactregistry.v1.GetPythonPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.PythonPackage>)
                  responseObserver);
          break;
        case METHODID_IMPORT_APT_ARTIFACTS:
          serviceImpl.importAptArtifacts(
              (com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_YUM_ARTIFACTS:
          serviceImpl.importYumArtifacts(
              (com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_REPOSITORIES:
          serviceImpl.listRepositories(
              (com.google.devtools.artifactregistry.v1.ListRepositoriesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_REPOSITORY:
          serviceImpl.getRepository(
              (com.google.devtools.artifactregistry.v1.GetRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>)
                  responseObserver);
          break;
        case METHODID_CREATE_REPOSITORY:
          serviceImpl.createRepository(
              (com.google.devtools.artifactregistry.v1.CreateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_REPOSITORY:
          serviceImpl.updateRepository(
              (com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Repository>)
                  responseObserver);
          break;
        case METHODID_DELETE_REPOSITORY:
          serviceImpl.deleteRepository(
              (com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_PACKAGES:
          serviceImpl.listPackages(
              (com.google.devtools.artifactregistry.v1.ListPackagesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListPackagesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PACKAGE:
          serviceImpl.getPackage(
              (com.google.devtools.artifactregistry.v1.GetPackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Package>)
                  responseObserver);
          break;
        case METHODID_DELETE_PACKAGE:
          serviceImpl.deletePackage(
              (com.google.devtools.artifactregistry.v1.DeletePackageRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions(
              (com.google.devtools.artifactregistry.v1.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion(
              (com.google.devtools.artifactregistry.v1.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Version>)
                  responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion(
              (com.google.devtools.artifactregistry.v1.DeleteVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_DELETE_VERSIONS:
          serviceImpl.batchDeleteVersions(
              (com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_FILES:
          serviceImpl.listFiles(
              (com.google.devtools.artifactregistry.v1.ListFilesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListFilesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FILE:
          serviceImpl.getFile(
              (com.google.devtools.artifactregistry.v1.GetFileRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.File>)
                  responseObserver);
          break;
        case METHODID_LIST_TAGS:
          serviceImpl.listTags(
              (com.google.devtools.artifactregistry.v1.ListTagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.devtools.artifactregistry.v1.ListTagsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TAG:
          serviceImpl.getTag(
              (com.google.devtools.artifactregistry.v1.GetTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag>)
                  responseObserver);
          break;
        case METHODID_CREATE_TAG:
          serviceImpl.createTag(
              (com.google.devtools.artifactregistry.v1.CreateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TAG:
          serviceImpl.updateTag(
              (com.google.devtools.artifactregistry.v1.UpdateTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.Tag>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAG:
          serviceImpl.deleteTag(
              (com.google.devtools.artifactregistry.v1.DeleteTagRequest) request,
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
              (com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PROJECT_SETTINGS:
          serviceImpl.updateProjectSettings(
              (com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.ProjectSettings>)
                  responseObserver);
          break;
        case METHODID_GET_VPCSCCONFIG:
          serviceImpl.getVPCSCConfig(
              (com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VPCSCCONFIG:
          serviceImpl.updateVPCSCConfig(
              (com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.devtools.artifactregistry.v1.VPCSCConfig>)
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
            getListDockerImagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListDockerImagesRequest,
                    com.google.devtools.artifactregistry.v1.ListDockerImagesResponse>(
                    service, METHODID_LIST_DOCKER_IMAGES)))
        .addMethod(
            getGetDockerImageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetDockerImageRequest,
                    com.google.devtools.artifactregistry.v1.DockerImage>(
                    service, METHODID_GET_DOCKER_IMAGE)))
        .addMethod(
            getListMavenArtifactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListMavenArtifactsRequest,
                    com.google.devtools.artifactregistry.v1.ListMavenArtifactsResponse>(
                    service, METHODID_LIST_MAVEN_ARTIFACTS)))
        .addMethod(
            getGetMavenArtifactMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetMavenArtifactRequest,
                    com.google.devtools.artifactregistry.v1.MavenArtifact>(
                    service, METHODID_GET_MAVEN_ARTIFACT)))
        .addMethod(
            getListNpmPackagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListNpmPackagesRequest,
                    com.google.devtools.artifactregistry.v1.ListNpmPackagesResponse>(
                    service, METHODID_LIST_NPM_PACKAGES)))
        .addMethod(
            getGetNpmPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetNpmPackageRequest,
                    com.google.devtools.artifactregistry.v1.NpmPackage>(
                    service, METHODID_GET_NPM_PACKAGE)))
        .addMethod(
            getListPythonPackagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListPythonPackagesRequest,
                    com.google.devtools.artifactregistry.v1.ListPythonPackagesResponse>(
                    service, METHODID_LIST_PYTHON_PACKAGES)))
        .addMethod(
            getGetPythonPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetPythonPackageRequest,
                    com.google.devtools.artifactregistry.v1.PythonPackage>(
                    service, METHODID_GET_PYTHON_PACKAGE)))
        .addMethod(
            getImportAptArtifactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ImportAptArtifactsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_APT_ARTIFACTS)))
        .addMethod(
            getImportYumArtifactsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ImportYumArtifactsRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_YUM_ARTIFACTS)))
        .addMethod(
            getListRepositoriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListRepositoriesRequest,
                    com.google.devtools.artifactregistry.v1.ListRepositoriesResponse>(
                    service, METHODID_LIST_REPOSITORIES)))
        .addMethod(
            getGetRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetRepositoryRequest,
                    com.google.devtools.artifactregistry.v1.Repository>(
                    service, METHODID_GET_REPOSITORY)))
        .addMethod(
            getCreateRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.CreateRepositoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_REPOSITORY)))
        .addMethod(
            getUpdateRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.UpdateRepositoryRequest,
                    com.google.devtools.artifactregistry.v1.Repository>(
                    service, METHODID_UPDATE_REPOSITORY)))
        .addMethod(
            getDeleteRepositoryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.DeleteRepositoryRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_REPOSITORY)))
        .addMethod(
            getListPackagesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListPackagesRequest,
                    com.google.devtools.artifactregistry.v1.ListPackagesResponse>(
                    service, METHODID_LIST_PACKAGES)))
        .addMethod(
            getGetPackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetPackageRequest,
                    com.google.devtools.artifactregistry.v1.Package>(
                    service, METHODID_GET_PACKAGE)))
        .addMethod(
            getDeletePackageMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.DeletePackageRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_PACKAGE)))
        .addMethod(
            getListVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListVersionsRequest,
                    com.google.devtools.artifactregistry.v1.ListVersionsResponse>(
                    service, METHODID_LIST_VERSIONS)))
        .addMethod(
            getGetVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetVersionRequest,
                    com.google.devtools.artifactregistry.v1.Version>(
                    service, METHODID_GET_VERSION)))
        .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.DeleteVersionRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_VERSION)))
        .addMethod(
            getBatchDeleteVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.BatchDeleteVersionsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BATCH_DELETE_VERSIONS)))
        .addMethod(
            getListFilesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListFilesRequest,
                    com.google.devtools.artifactregistry.v1.ListFilesResponse>(
                    service, METHODID_LIST_FILES)))
        .addMethod(
            getGetFileMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetFileRequest,
                    com.google.devtools.artifactregistry.v1.File>(service, METHODID_GET_FILE)))
        .addMethod(
            getListTagsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.ListTagsRequest,
                    com.google.devtools.artifactregistry.v1.ListTagsResponse>(
                    service, METHODID_LIST_TAGS)))
        .addMethod(
            getGetTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetTagRequest,
                    com.google.devtools.artifactregistry.v1.Tag>(service, METHODID_GET_TAG)))
        .addMethod(
            getCreateTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.CreateTagRequest,
                    com.google.devtools.artifactregistry.v1.Tag>(service, METHODID_CREATE_TAG)))
        .addMethod(
            getUpdateTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.UpdateTagRequest,
                    com.google.devtools.artifactregistry.v1.Tag>(service, METHODID_UPDATE_TAG)))
        .addMethod(
            getDeleteTagMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.DeleteTagRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TAG)))
        .addMethod(
            getSetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_SET_IAM_POLICY)))
        .addMethod(
            getGetIamPolicyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                    service, METHODID_GET_IAM_POLICY)))
        .addMethod(
            getTestIamPermissionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.iam.v1.TestIamPermissionsRequest,
                    com.google.iam.v1.TestIamPermissionsResponse>(
                    service, METHODID_TEST_IAM_PERMISSIONS)))
        .addMethod(
            getGetProjectSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetProjectSettingsRequest,
                    com.google.devtools.artifactregistry.v1.ProjectSettings>(
                    service, METHODID_GET_PROJECT_SETTINGS)))
        .addMethod(
            getUpdateProjectSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.UpdateProjectSettingsRequest,
                    com.google.devtools.artifactregistry.v1.ProjectSettings>(
                    service, METHODID_UPDATE_PROJECT_SETTINGS)))
        .addMethod(
            getGetVPCSCConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.GetVPCSCConfigRequest,
                    com.google.devtools.artifactregistry.v1.VPCSCConfig>(
                    service, METHODID_GET_VPCSCCONFIG)))
        .addMethod(
            getUpdateVPCSCConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.devtools.artifactregistry.v1.UpdateVPCSCConfigRequest,
                    com.google.devtools.artifactregistry.v1.VPCSCConfig>(
                    service, METHODID_UPDATE_VPCSCCONFIG)))
        .build();
  }

  private abstract static class ArtifactRegistryBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArtifactRegistryBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.devtools.artifactregistry.v1.ServiceProto.getDescriptor();
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
    private final java.lang.String methodName;

    ArtifactRegistryMethodDescriptorSupplier(java.lang.String methodName) {
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
                      .addMethod(getListDockerImagesMethod())
                      .addMethod(getGetDockerImageMethod())
                      .addMethod(getListMavenArtifactsMethod())
                      .addMethod(getGetMavenArtifactMethod())
                      .addMethod(getListNpmPackagesMethod())
                      .addMethod(getGetNpmPackageMethod())
                      .addMethod(getListPythonPackagesMethod())
                      .addMethod(getGetPythonPackageMethod())
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
                      .addMethod(getBatchDeleteVersionsMethod())
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
                      .addMethod(getGetVPCSCConfigMethod())
                      .addMethod(getUpdateVPCSCConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
