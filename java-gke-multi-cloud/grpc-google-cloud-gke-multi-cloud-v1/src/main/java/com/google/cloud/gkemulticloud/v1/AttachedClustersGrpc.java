/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.gkemulticloud.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The AttachedClusters API provides a single centrally managed service
 * to register and manage Anthos attached clusters that run on customer's owned
 * infrastructure.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/gkemulticloud/v1/attached_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AttachedClustersGrpc {

  private AttachedClustersGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.gkemulticloud.v1.AttachedClusters";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest,
          com.google.longrunning.Operation>
      getCreateAttachedClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAttachedCluster",
      requestType = com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest,
          com.google.longrunning.Operation>
      getCreateAttachedClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest,
            com.google.longrunning.Operation>
        getCreateAttachedClusterMethod;
    if ((getCreateAttachedClusterMethod = AttachedClustersGrpc.getCreateAttachedClusterMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getCreateAttachedClusterMethod = AttachedClustersGrpc.getCreateAttachedClusterMethod)
            == null) {
          AttachedClustersGrpc.getCreateAttachedClusterMethod =
              getCreateAttachedClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateAttachedCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("CreateAttachedCluster"))
                      .build();
        }
      }
    }
    return getCreateAttachedClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest,
          com.google.longrunning.Operation>
      getUpdateAttachedClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAttachedCluster",
      requestType = com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest,
          com.google.longrunning.Operation>
      getUpdateAttachedClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest,
            com.google.longrunning.Operation>
        getUpdateAttachedClusterMethod;
    if ((getUpdateAttachedClusterMethod = AttachedClustersGrpc.getUpdateAttachedClusterMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getUpdateAttachedClusterMethod = AttachedClustersGrpc.getUpdateAttachedClusterMethod)
            == null) {
          AttachedClustersGrpc.getUpdateAttachedClusterMethod =
              getUpdateAttachedClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateAttachedCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("UpdateAttachedCluster"))
                      .build();
        }
      }
    }
    return getUpdateAttachedClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest,
          com.google.longrunning.Operation>
      getImportAttachedClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportAttachedCluster",
      requestType = com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest,
          com.google.longrunning.Operation>
      getImportAttachedClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest,
            com.google.longrunning.Operation>
        getImportAttachedClusterMethod;
    if ((getImportAttachedClusterMethod = AttachedClustersGrpc.getImportAttachedClusterMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getImportAttachedClusterMethod = AttachedClustersGrpc.getImportAttachedClusterMethod)
            == null) {
          AttachedClustersGrpc.getImportAttachedClusterMethod =
              getImportAttachedClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ImportAttachedCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("ImportAttachedCluster"))
                      .build();
        }
      }
    }
    return getImportAttachedClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest,
          com.google.cloud.gkemulticloud.v1.AttachedCluster>
      getGetAttachedClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttachedCluster",
      requestType = com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AttachedCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest,
          com.google.cloud.gkemulticloud.v1.AttachedCluster>
      getGetAttachedClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest,
            com.google.cloud.gkemulticloud.v1.AttachedCluster>
        getGetAttachedClusterMethod;
    if ((getGetAttachedClusterMethod = AttachedClustersGrpc.getGetAttachedClusterMethod) == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getGetAttachedClusterMethod = AttachedClustersGrpc.getGetAttachedClusterMethod)
            == null) {
          AttachedClustersGrpc.getGetAttachedClusterMethod =
              getGetAttachedClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest,
                          com.google.cloud.gkemulticloud.v1.AttachedCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAttachedCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AttachedCluster
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("GetAttachedCluster"))
                      .build();
        }
      }
    }
    return getGetAttachedClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest,
          com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
      getListAttachedClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAttachedClusters",
      requestType = com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest,
          com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
      getListAttachedClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest,
            com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
        getListAttachedClustersMethod;
    if ((getListAttachedClustersMethod = AttachedClustersGrpc.getListAttachedClustersMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getListAttachedClustersMethod = AttachedClustersGrpc.getListAttachedClustersMethod)
            == null) {
          AttachedClustersGrpc.getListAttachedClustersMethod =
              getListAttachedClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest,
                          com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAttachedClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("ListAttachedClusters"))
                      .build();
        }
      }
    }
    return getListAttachedClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest,
          com.google.longrunning.Operation>
      getDeleteAttachedClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAttachedCluster",
      requestType = com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest,
          com.google.longrunning.Operation>
      getDeleteAttachedClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest,
            com.google.longrunning.Operation>
        getDeleteAttachedClusterMethod;
    if ((getDeleteAttachedClusterMethod = AttachedClustersGrpc.getDeleteAttachedClusterMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getDeleteAttachedClusterMethod = AttachedClustersGrpc.getDeleteAttachedClusterMethod)
            == null) {
          AttachedClustersGrpc.getDeleteAttachedClusterMethod =
              getDeleteAttachedClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteAttachedCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("DeleteAttachedCluster"))
                      .build();
        }
      }
    }
    return getDeleteAttachedClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest,
          com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
      getGetAttachedServerConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAttachedServerConfig",
      requestType = com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest.class,
      responseType = com.google.cloud.gkemulticloud.v1.AttachedServerConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest,
          com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
      getGetAttachedServerConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest,
            com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
        getGetAttachedServerConfigMethod;
    if ((getGetAttachedServerConfigMethod = AttachedClustersGrpc.getGetAttachedServerConfigMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getGetAttachedServerConfigMethod =
                AttachedClustersGrpc.getGetAttachedServerConfigMethod)
            == null) {
          AttachedClustersGrpc.getGetAttachedServerConfigMethod =
              getGetAttachedServerConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest,
                          com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetAttachedServerConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1.AttachedServerConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier("GetAttachedServerConfig"))
                      .build();
        }
      }
    }
    return getGetAttachedServerConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
      getGenerateAttachedClusterInstallManifestMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAttachedClusterInstallManifest",
      requestType =
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest.class,
      responseType =
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
      getGenerateAttachedClusterInstallManifestMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest,
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
        getGenerateAttachedClusterInstallManifestMethod;
    if ((getGenerateAttachedClusterInstallManifestMethod =
            AttachedClustersGrpc.getGenerateAttachedClusterInstallManifestMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getGenerateAttachedClusterInstallManifestMethod =
                AttachedClustersGrpc.getGenerateAttachedClusterInstallManifestMethod)
            == null) {
          AttachedClustersGrpc.getGenerateAttachedClusterInstallManifestMethod =
              getGenerateAttachedClusterInstallManifestMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1
                              .GenerateAttachedClusterInstallManifestRequest,
                          com.google.cloud.gkemulticloud.v1
                              .GenerateAttachedClusterInstallManifestResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "GenerateAttachedClusterInstallManifest"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1
                                  .GenerateAttachedClusterInstallManifestRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1
                                  .GenerateAttachedClusterInstallManifestResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier(
                              "GenerateAttachedClusterInstallManifest"))
                      .build();
        }
      }
    }
    return getGenerateAttachedClusterInstallManifestMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
      getGenerateAttachedClusterAgentTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GenerateAttachedClusterAgentToken",
      requestType =
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest.class,
      responseType =
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest,
          com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
      getGenerateAttachedClusterAgentTokenMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest,
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
        getGenerateAttachedClusterAgentTokenMethod;
    if ((getGenerateAttachedClusterAgentTokenMethod =
            AttachedClustersGrpc.getGenerateAttachedClusterAgentTokenMethod)
        == null) {
      synchronized (AttachedClustersGrpc.class) {
        if ((getGenerateAttachedClusterAgentTokenMethod =
                AttachedClustersGrpc.getGenerateAttachedClusterAgentTokenMethod)
            == null) {
          AttachedClustersGrpc.getGenerateAttachedClusterAgentTokenMethod =
              getGenerateAttachedClusterAgentTokenMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest,
                          com.google.cloud.gkemulticloud.v1
                              .GenerateAttachedClusterAgentTokenResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GenerateAttachedClusterAgentToken"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1
                                  .GenerateAttachedClusterAgentTokenRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.gkemulticloud.v1
                                  .GenerateAttachedClusterAgentTokenResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AttachedClustersMethodDescriptorSupplier(
                              "GenerateAttachedClusterAgentToken"))
                      .build();
        }
      }
    }
    return getGenerateAttachedClusterAgentTokenMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AttachedClustersStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttachedClustersStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AttachedClustersStub>() {
          @java.lang.Override
          public AttachedClustersStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AttachedClustersStub(channel, callOptions);
          }
        };
    return AttachedClustersStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AttachedClustersBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttachedClustersBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AttachedClustersBlockingStub>() {
          @java.lang.Override
          public AttachedClustersBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AttachedClustersBlockingStub(channel, callOptions);
          }
        };
    return AttachedClustersBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AttachedClustersFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AttachedClustersFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AttachedClustersFutureStub>() {
          @java.lang.Override
          public AttachedClustersFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AttachedClustersFutureStub(channel, callOptions);
          }
        };
    return AttachedClustersFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The AttachedClusters API provides a single centrally managed service
   * to register and manage Anthos attached clusters that run on customer's owned
   * infrastructure.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void createAttachedCluster(
        com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAttachedClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
     * </pre>
     */
    default void updateAttachedCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAttachedClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * by importing an existing Fleet Membership resource.
     * Attached Clusters created before the introduction of the Anthos Multi-Cloud
     * API can be imported through this method.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void importAttachedCluster(
        com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportAttachedClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * </pre>
     */
    default void getAttachedCluster(
        com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttachedClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    default void listAttachedClusters(
        com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAttachedClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    default void deleteAttachedCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAttachedClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Kubernetes versions, on a given
     * Google Cloud location.
     * </pre>
     */
    default void getAttachedServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAttachedServerConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the install manifest to be installed on the target cluster.
     * </pre>
     */
    default void generateAttachedClusterInstallManifest(
        com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAttachedClusterInstallManifestMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    default void generateAttachedClusterAgentToken(
        com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGenerateAttachedClusterAgentTokenMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AttachedClusters.
   *
   * <pre>
   * The AttachedClusters API provides a single centrally managed service
   * to register and manage Anthos attached clusters that run on customer's owned
   * infrastructure.
   * </pre>
   */
  public abstract static class AttachedClustersImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return AttachedClustersGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AttachedClusters.
   *
   * <pre>
   * The AttachedClusters API provides a single centrally managed service
   * to register and manage Anthos attached clusters that run on customer's owned
   * infrastructure.
   * </pre>
   */
  public static final class AttachedClustersStub
      extends io.grpc.stub.AbstractAsyncStub<AttachedClustersStub> {
    private AttachedClustersStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttachedClustersStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttachedClustersStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void createAttachedCluster(
        com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAttachedClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
     * </pre>
     */
    public void updateAttachedCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAttachedClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * by importing an existing Fleet Membership resource.
     * Attached Clusters created before the introduction of the Anthos Multi-Cloud
     * API can be imported through this method.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void importAttachedCluster(
        com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportAttachedClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * </pre>
     */
    public void getAttachedCluster(
        com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttachedClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public void listAttachedClusters(
        com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAttachedClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public void deleteAttachedCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAttachedClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Kubernetes versions, on a given
     * Google Cloud location.
     * </pre>
     */
    public void getAttachedServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAttachedServerConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates the install manifest to be installed on the target cluster.
     * </pre>
     */
    public void generateAttachedClusterInstallManifest(
        com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAttachedClusterInstallManifestMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public void generateAttachedClusterAgentToken(
        com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGenerateAttachedClusterAgentTokenMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AttachedClusters.
   *
   * <pre>
   * The AttachedClusters API provides a single centrally managed service
   * to register and manage Anthos attached clusters that run on customer's owned
   * infrastructure.
   * </pre>
   */
  public static final class AttachedClustersBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AttachedClustersBlockingStub> {
    private AttachedClustersBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttachedClustersBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttachedClustersBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation createAttachedCluster(
        com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAttachedClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
     * </pre>
     */
    public com.google.longrunning.Operation updateAttachedCluster(
        com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAttachedClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * by importing an existing Fleet Membership resource.
     * Attached Clusters created before the introduction of the Anthos Multi-Cloud
     * API can be imported through this method.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation importAttachedCluster(
        com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportAttachedClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AttachedCluster getAttachedCluster(
        com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttachedClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse listAttachedClusters(
        com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAttachedClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.longrunning.Operation deleteAttachedCluster(
        com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAttachedClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Kubernetes versions, on a given
     * Google Cloud location.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.AttachedServerConfig getAttachedServerConfig(
        com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAttachedServerConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the install manifest to be installed on the target cluster.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse
        generateAttachedClusterInstallManifest(
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest
                request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getGenerateAttachedClusterInstallManifestMethod(),
          getCallOptions(),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse
        generateAttachedClusterAgentToken(
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGenerateAttachedClusterAgentTokenMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AttachedClusters.
   *
   * <pre>
   * The AttachedClusters API provides a single centrally managed service
   * to register and manage Anthos attached clusters that run on customer's owned
   * infrastructure.
   * </pre>
   */
  public static final class AttachedClustersFutureStub
      extends io.grpc.stub.AbstractFutureStub<AttachedClustersFutureStub> {
    private AttachedClustersFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AttachedClustersFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AttachedClustersFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * on a given Google Cloud Platform project and region.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAttachedCluster(
            com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAttachedClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateAttachedCluster(
            com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAttachedClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports creates a new
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource
     * by importing an existing Fleet Membership resource.
     * Attached Clusters created before the introduction of the Anthos Multi-Cloud
     * API can be imported through this method.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importAttachedCluster(
            com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportAttachedClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Describes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AttachedCluster>
        getAttachedCluster(com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttachedClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster]
     * resources on a given Google Cloud project and region.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>
        listAttachedClusters(
            com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAttachedClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a specific
     * [AttachedCluster][google.cloud.gkemulticloud.v1.AttachedCluster] resource.
     * If successful, the response contains a newly created
     * [Operation][google.longrunning.Operation] resource that can be
     * described to track the status of the operation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteAttachedCluster(
            com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAttachedClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information, such as supported Kubernetes versions, on a given
     * Google Cloud location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.AttachedServerConfig>
        getAttachedServerConfig(
            com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAttachedServerConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Generates the install manifest to be installed on the target cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestResponse>
        generateAttachedClusterInstallManifest(
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest
                request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAttachedClusterInstallManifestMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Generates an access token for a cluster agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>
        generateAttachedClusterAgentToken(
            com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGenerateAttachedClusterAgentTokenMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_CREATE_ATTACHED_CLUSTER = 0;
  private static final int METHODID_UPDATE_ATTACHED_CLUSTER = 1;
  private static final int METHODID_IMPORT_ATTACHED_CLUSTER = 2;
  private static final int METHODID_GET_ATTACHED_CLUSTER = 3;
  private static final int METHODID_LIST_ATTACHED_CLUSTERS = 4;
  private static final int METHODID_DELETE_ATTACHED_CLUSTER = 5;
  private static final int METHODID_GET_ATTACHED_SERVER_CONFIG = 6;
  private static final int METHODID_GENERATE_ATTACHED_CLUSTER_INSTALL_MANIFEST = 7;
  private static final int METHODID_GENERATE_ATTACHED_CLUSTER_AGENT_TOKEN = 8;

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
        case METHODID_CREATE_ATTACHED_CLUSTER:
          serviceImpl.createAttachedCluster(
              (com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ATTACHED_CLUSTER:
          serviceImpl.updateAttachedCluster(
              (com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_ATTACHED_CLUSTER:
          serviceImpl.importAttachedCluster(
              (com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ATTACHED_CLUSTER:
          serviceImpl.getAttachedCluster(
              (com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedCluster>)
                  responseObserver);
          break;
        case METHODID_LIST_ATTACHED_CLUSTERS:
          serviceImpl.listAttachedClusters(
              (com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ATTACHED_CLUSTER:
          serviceImpl.deleteAttachedCluster(
              (com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ATTACHED_SERVER_CONFIG:
          serviceImpl.getAttachedServerConfig(
              (com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.gkemulticloud.v1.AttachedServerConfig>)
                  responseObserver);
          break;
        case METHODID_GENERATE_ATTACHED_CLUSTER_INSTALL_MANIFEST:
          serviceImpl.generateAttachedClusterInstallManifest(
              (com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1
                          .GenerateAttachedClusterInstallManifestResponse>)
                  responseObserver);
          break;
        case METHODID_GENERATE_ATTACHED_CLUSTER_AGENT_TOKEN:
          serviceImpl.generateAttachedClusterAgentToken(
              (com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>)
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
            getCreateAttachedClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.CreateAttachedClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ATTACHED_CLUSTER)))
        .addMethod(
            getUpdateAttachedClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.UpdateAttachedClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ATTACHED_CLUSTER)))
        .addMethod(
            getImportAttachedClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.ImportAttachedClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_ATTACHED_CLUSTER)))
        .addMethod(
            getGetAttachedClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.GetAttachedClusterRequest,
                    com.google.cloud.gkemulticloud.v1.AttachedCluster>(
                    service, METHODID_GET_ATTACHED_CLUSTER)))
        .addMethod(
            getListAttachedClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.ListAttachedClustersRequest,
                    com.google.cloud.gkemulticloud.v1.ListAttachedClustersResponse>(
                    service, METHODID_LIST_ATTACHED_CLUSTERS)))
        .addMethod(
            getDeleteAttachedClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.DeleteAttachedClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ATTACHED_CLUSTER)))
        .addMethod(
            getGetAttachedServerConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.GetAttachedServerConfigRequest,
                    com.google.cloud.gkemulticloud.v1.AttachedServerConfig>(
                    service, METHODID_GET_ATTACHED_SERVER_CONFIG)))
        .addMethod(
            getGenerateAttachedClusterInstallManifestMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterInstallManifestRequest,
                    com.google.cloud.gkemulticloud.v1
                        .GenerateAttachedClusterInstallManifestResponse>(
                    service, METHODID_GENERATE_ATTACHED_CLUSTER_INSTALL_MANIFEST)))
        .addMethod(
            getGenerateAttachedClusterAgentTokenMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenRequest,
                    com.google.cloud.gkemulticloud.v1.GenerateAttachedClusterAgentTokenResponse>(
                    service, METHODID_GENERATE_ATTACHED_CLUSTER_AGENT_TOKEN)))
        .build();
  }

  private abstract static class AttachedClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AttachedClustersBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.gkemulticloud.v1.AttachedServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AttachedClusters");
    }
  }

  private static final class AttachedClustersFileDescriptorSupplier
      extends AttachedClustersBaseDescriptorSupplier {
    AttachedClustersFileDescriptorSupplier() {}
  }

  private static final class AttachedClustersMethodDescriptorSupplier
      extends AttachedClustersBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AttachedClustersMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AttachedClustersGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AttachedClustersFileDescriptorSupplier())
                      .addMethod(getCreateAttachedClusterMethod())
                      .addMethod(getUpdateAttachedClusterMethod())
                      .addMethod(getImportAttachedClusterMethod())
                      .addMethod(getGetAttachedClusterMethod())
                      .addMethod(getListAttachedClustersMethod())
                      .addMethod(getDeleteAttachedClusterMethod())
                      .addMethod(getGetAttachedServerConfigMethod())
                      .addMethod(getGenerateAttachedClusterInstallManifestMethod())
                      .addMethod(getGenerateAttachedClusterAgentTokenMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
