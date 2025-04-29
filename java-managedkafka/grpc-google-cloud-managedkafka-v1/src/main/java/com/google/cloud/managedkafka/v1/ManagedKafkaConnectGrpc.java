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
package com.google.cloud.managedkafka.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that a client application uses to manage Apache Kafka Connect
 * clusters and connectors.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/managedkafka/v1/managed_kafka_connect.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagedKafkaConnectGrpc {

  private ManagedKafkaConnectGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.managedkafka.v1.ManagedKafkaConnect";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConnectClustersRequest,
          com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
      getListConnectClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectClusters",
      requestType = com.google.cloud.managedkafka.v1.ListConnectClustersRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ListConnectClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConnectClustersRequest,
          com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
      getListConnectClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ListConnectClustersRequest,
            com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
        getListConnectClustersMethod;
    if ((getListConnectClustersMethod = ManagedKafkaConnectGrpc.getListConnectClustersMethod)
        == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getListConnectClustersMethod = ManagedKafkaConnectGrpc.getListConnectClustersMethod)
            == null) {
          ManagedKafkaConnectGrpc.getListConnectClustersMethod =
              getListConnectClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ListConnectClustersRequest,
                          com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConnectClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConnectClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConnectClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("ListConnectClusters"))
                      .build();
        }
      }
    }
    return getListConnectClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConnectClusterRequest,
          com.google.cloud.managedkafka.v1.ConnectCluster>
      getGetConnectClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnectCluster",
      requestType = com.google.cloud.managedkafka.v1.GetConnectClusterRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ConnectCluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConnectClusterRequest,
          com.google.cloud.managedkafka.v1.ConnectCluster>
      getGetConnectClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.GetConnectClusterRequest,
            com.google.cloud.managedkafka.v1.ConnectCluster>
        getGetConnectClusterMethod;
    if ((getGetConnectClusterMethod = ManagedKafkaConnectGrpc.getGetConnectClusterMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getGetConnectClusterMethod = ManagedKafkaConnectGrpc.getGetConnectClusterMethod)
            == null) {
          ManagedKafkaConnectGrpc.getGetConnectClusterMethod =
              getGetConnectClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.GetConnectClusterRequest,
                          com.google.cloud.managedkafka.v1.ConnectCluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnectCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.GetConnectClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ConnectCluster.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("GetConnectCluster"))
                      .build();
        }
      }
    }
    return getGetConnectClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateConnectClusterRequest,
          com.google.longrunning.Operation>
      getCreateConnectClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnectCluster",
      requestType = com.google.cloud.managedkafka.v1.CreateConnectClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateConnectClusterRequest,
          com.google.longrunning.Operation>
      getCreateConnectClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.CreateConnectClusterRequest,
            com.google.longrunning.Operation>
        getCreateConnectClusterMethod;
    if ((getCreateConnectClusterMethod = ManagedKafkaConnectGrpc.getCreateConnectClusterMethod)
        == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getCreateConnectClusterMethod = ManagedKafkaConnectGrpc.getCreateConnectClusterMethod)
            == null) {
          ManagedKafkaConnectGrpc.getCreateConnectClusterMethod =
              getCreateConnectClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.CreateConnectClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateConnectCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.CreateConnectClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("CreateConnectCluster"))
                      .build();
        }
      }
    }
    return getCreateConnectClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest,
          com.google.longrunning.Operation>
      getUpdateConnectClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnectCluster",
      requestType = com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest,
          com.google.longrunning.Operation>
      getUpdateConnectClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest,
            com.google.longrunning.Operation>
        getUpdateConnectClusterMethod;
    if ((getUpdateConnectClusterMethod = ManagedKafkaConnectGrpc.getUpdateConnectClusterMethod)
        == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getUpdateConnectClusterMethod = ManagedKafkaConnectGrpc.getUpdateConnectClusterMethod)
            == null) {
          ManagedKafkaConnectGrpc.getUpdateConnectClusterMethod =
              getUpdateConnectClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConnectCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("UpdateConnectCluster"))
                      .build();
        }
      }
    }
    return getUpdateConnectClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest,
          com.google.longrunning.Operation>
      getDeleteConnectClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnectCluster",
      requestType = com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest,
          com.google.longrunning.Operation>
      getDeleteConnectClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest,
            com.google.longrunning.Operation>
        getDeleteConnectClusterMethod;
    if ((getDeleteConnectClusterMethod = ManagedKafkaConnectGrpc.getDeleteConnectClusterMethod)
        == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getDeleteConnectClusterMethod = ManagedKafkaConnectGrpc.getDeleteConnectClusterMethod)
            == null) {
          ManagedKafkaConnectGrpc.getDeleteConnectClusterMethod =
              getDeleteConnectClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConnectCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("DeleteConnectCluster"))
                      .build();
        }
      }
    }
    return getDeleteConnectClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConnectorsRequest,
          com.google.cloud.managedkafka.v1.ListConnectorsResponse>
      getListConnectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConnectors",
      requestType = com.google.cloud.managedkafka.v1.ListConnectorsRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ListConnectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConnectorsRequest,
          com.google.cloud.managedkafka.v1.ListConnectorsResponse>
      getListConnectorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ListConnectorsRequest,
            com.google.cloud.managedkafka.v1.ListConnectorsResponse>
        getListConnectorsMethod;
    if ((getListConnectorsMethod = ManagedKafkaConnectGrpc.getListConnectorsMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getListConnectorsMethod = ManagedKafkaConnectGrpc.getListConnectorsMethod) == null) {
          ManagedKafkaConnectGrpc.getListConnectorsMethod =
              getListConnectorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ListConnectorsRequest,
                          com.google.cloud.managedkafka.v1.ListConnectorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConnectors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConnectorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConnectorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("ListConnectors"))
                      .build();
        }
      }
    }
    return getListConnectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getGetConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConnector",
      requestType = com.google.cloud.managedkafka.v1.GetConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Connector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getGetConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.GetConnectorRequest,
            com.google.cloud.managedkafka.v1.Connector>
        getGetConnectorMethod;
    if ((getGetConnectorMethod = ManagedKafkaConnectGrpc.getGetConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getGetConnectorMethod = ManagedKafkaConnectGrpc.getGetConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getGetConnectorMethod =
              getGetConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.GetConnectorRequest,
                          com.google.cloud.managedkafka.v1.Connector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.GetConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Connector.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("GetConnector"))
                      .build();
        }
      }
    }
    return getGetConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getCreateConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConnector",
      requestType = com.google.cloud.managedkafka.v1.CreateConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Connector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getCreateConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.CreateConnectorRequest,
            com.google.cloud.managedkafka.v1.Connector>
        getCreateConnectorMethod;
    if ((getCreateConnectorMethod = ManagedKafkaConnectGrpc.getCreateConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getCreateConnectorMethod = ManagedKafkaConnectGrpc.getCreateConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getCreateConnectorMethod =
              getCreateConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.CreateConnectorRequest,
                          com.google.cloud.managedkafka.v1.Connector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.CreateConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Connector.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("CreateConnector"))
                      .build();
        }
      }
    }
    return getCreateConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getUpdateConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConnector",
      requestType = com.google.cloud.managedkafka.v1.UpdateConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Connector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConnectorRequest,
          com.google.cloud.managedkafka.v1.Connector>
      getUpdateConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.UpdateConnectorRequest,
            com.google.cloud.managedkafka.v1.Connector>
        getUpdateConnectorMethod;
    if ((getUpdateConnectorMethod = ManagedKafkaConnectGrpc.getUpdateConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getUpdateConnectorMethod = ManagedKafkaConnectGrpc.getUpdateConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getUpdateConnectorMethod =
              getUpdateConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.UpdateConnectorRequest,
                          com.google.cloud.managedkafka.v1.Connector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.UpdateConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Connector.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("UpdateConnector"))
                      .build();
        }
      }
    }
    return getUpdateConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConnectorRequest, com.google.protobuf.Empty>
      getDeleteConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConnector",
      requestType = com.google.cloud.managedkafka.v1.DeleteConnectorRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConnectorRequest, com.google.protobuf.Empty>
      getDeleteConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.DeleteConnectorRequest, com.google.protobuf.Empty>
        getDeleteConnectorMethod;
    if ((getDeleteConnectorMethod = ManagedKafkaConnectGrpc.getDeleteConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getDeleteConnectorMethod = ManagedKafkaConnectGrpc.getDeleteConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getDeleteConnectorMethod =
              getDeleteConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.DeleteConnectorRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.DeleteConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("DeleteConnector"))
                      .build();
        }
      }
    }
    return getDeleteConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.PauseConnectorRequest,
          com.google.cloud.managedkafka.v1.PauseConnectorResponse>
      getPauseConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseConnector",
      requestType = com.google.cloud.managedkafka.v1.PauseConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.PauseConnectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.PauseConnectorRequest,
          com.google.cloud.managedkafka.v1.PauseConnectorResponse>
      getPauseConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.PauseConnectorRequest,
            com.google.cloud.managedkafka.v1.PauseConnectorResponse>
        getPauseConnectorMethod;
    if ((getPauseConnectorMethod = ManagedKafkaConnectGrpc.getPauseConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getPauseConnectorMethod = ManagedKafkaConnectGrpc.getPauseConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getPauseConnectorMethod =
              getPauseConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.PauseConnectorRequest,
                          com.google.cloud.managedkafka.v1.PauseConnectorResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.PauseConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.PauseConnectorResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("PauseConnector"))
                      .build();
        }
      }
    }
    return getPauseConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ResumeConnectorRequest,
          com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
      getResumeConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeConnector",
      requestType = com.google.cloud.managedkafka.v1.ResumeConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ResumeConnectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ResumeConnectorRequest,
          com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
      getResumeConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ResumeConnectorRequest,
            com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
        getResumeConnectorMethod;
    if ((getResumeConnectorMethod = ManagedKafkaConnectGrpc.getResumeConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getResumeConnectorMethod = ManagedKafkaConnectGrpc.getResumeConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getResumeConnectorMethod =
              getResumeConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ResumeConnectorRequest,
                          com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ResumeConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ResumeConnectorResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("ResumeConnector"))
                      .build();
        }
      }
    }
    return getResumeConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.RestartConnectorRequest,
          com.google.cloud.managedkafka.v1.RestartConnectorResponse>
      getRestartConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartConnector",
      requestType = com.google.cloud.managedkafka.v1.RestartConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.RestartConnectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.RestartConnectorRequest,
          com.google.cloud.managedkafka.v1.RestartConnectorResponse>
      getRestartConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.RestartConnectorRequest,
            com.google.cloud.managedkafka.v1.RestartConnectorResponse>
        getRestartConnectorMethod;
    if ((getRestartConnectorMethod = ManagedKafkaConnectGrpc.getRestartConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getRestartConnectorMethod = ManagedKafkaConnectGrpc.getRestartConnectorMethod)
            == null) {
          ManagedKafkaConnectGrpc.getRestartConnectorMethod =
              getRestartConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.RestartConnectorRequest,
                          com.google.cloud.managedkafka.v1.RestartConnectorResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.RestartConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.RestartConnectorResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("RestartConnector"))
                      .build();
        }
      }
    }
    return getRestartConnectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.StopConnectorRequest,
          com.google.cloud.managedkafka.v1.StopConnectorResponse>
      getStopConnectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopConnector",
      requestType = com.google.cloud.managedkafka.v1.StopConnectorRequest.class,
      responseType = com.google.cloud.managedkafka.v1.StopConnectorResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.StopConnectorRequest,
          com.google.cloud.managedkafka.v1.StopConnectorResponse>
      getStopConnectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.StopConnectorRequest,
            com.google.cloud.managedkafka.v1.StopConnectorResponse>
        getStopConnectorMethod;
    if ((getStopConnectorMethod = ManagedKafkaConnectGrpc.getStopConnectorMethod) == null) {
      synchronized (ManagedKafkaConnectGrpc.class) {
        if ((getStopConnectorMethod = ManagedKafkaConnectGrpc.getStopConnectorMethod) == null) {
          ManagedKafkaConnectGrpc.getStopConnectorMethod =
              getStopConnectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.StopConnectorRequest,
                          com.google.cloud.managedkafka.v1.StopConnectorResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopConnector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.StopConnectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.StopConnectorResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaConnectMethodDescriptorSupplier("StopConnector"))
                      .build();
        }
      }
    }
    return getStopConnectorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ManagedKafkaConnectStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectStub>() {
          @java.lang.Override
          public ManagedKafkaConnectStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaConnectStub(channel, callOptions);
          }
        };
    return ManagedKafkaConnectStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ManagedKafkaConnectBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectBlockingV2Stub>() {
          @java.lang.Override
          public ManagedKafkaConnectBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaConnectBlockingV2Stub(channel, callOptions);
          }
        };
    return ManagedKafkaConnectBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagedKafkaConnectBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectBlockingStub>() {
          @java.lang.Override
          public ManagedKafkaConnectBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaConnectBlockingStub(channel, callOptions);
          }
        };
    return ManagedKafkaConnectBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ManagedKafkaConnectFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaConnectFutureStub>() {
          @java.lang.Override
          public ManagedKafkaConnectFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaConnectFutureStub(channel, callOptions);
          }
        };
    return ManagedKafkaConnectFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the Kafka Connect clusters in a given project and location.
     * </pre>
     */
    default void listConnectClusters(
        com.google.cloud.managedkafka.v1.ListConnectClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single Kafka Connect cluster.
     * </pre>
     */
    default void getConnectCluster(
        com.google.cloud.managedkafka.v1.GetConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConnectCluster>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Kafka Connect cluster in a given project and location.
     * </pre>
     */
    default void createConnectCluster(
        com.google.cloud.managedkafka.v1.CreateConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single Kafka Connect cluster.
     * </pre>
     */
    default void updateConnectCluster(
        com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connect cluster.
     * </pre>
     */
    default void deleteConnectCluster(
        com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the connectors in a given Connect cluster.
     * </pre>
     */
    default void listConnectors(
        com.google.cloud.managedkafka.v1.ListConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConnectorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConnectorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single connector.
     * </pre>
     */
    default void getConnector(
        com.google.cloud.managedkafka.v1.GetConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connector in a given Connect cluster.
     * </pre>
     */
    default void createConnector(
        com.google.cloud.managedkafka.v1.CreateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a connector.
     * </pre>
     */
    default void updateConnector(
        com.google.cloud.managedkafka.v1.UpdateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connector.
     * </pre>
     */
    default void deleteConnector(
        com.google.cloud.managedkafka.v1.DeleteConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the connector and its tasks.
     * </pre>
     */
    default void pauseConnector(
        com.google.cloud.managedkafka.v1.PauseConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.PauseConnectorResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the connector and its tasks.
     * </pre>
     */
    default void resumeConnector(
        com.google.cloud.managedkafka.v1.ResumeConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts the connector.
     * </pre>
     */
    default void restartConnector(
        com.google.cloud.managedkafka.v1.RestartConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.RestartConnectorResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestartConnectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the connector.
     * </pre>
     */
    default void stopConnector(
        com.google.cloud.managedkafka.v1.StopConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.StopConnectorResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getStopConnectorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ManagedKafkaConnect.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public abstract static class ManagedKafkaConnectImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ManagedKafkaConnectGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ManagedKafkaConnect.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public static final class ManagedKafkaConnectStub
      extends io.grpc.stub.AbstractAsyncStub<ManagedKafkaConnectStub> {
    private ManagedKafkaConnectStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaConnectStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaConnectStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the Kafka Connect clusters in a given project and location.
     * </pre>
     */
    public void listConnectClusters(
        com.google.cloud.managedkafka.v1.ListConnectClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public void getConnectCluster(
        com.google.cloud.managedkafka.v1.GetConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConnectCluster>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Kafka Connect cluster in a given project and location.
     * </pre>
     */
    public void createConnectCluster(
        com.google.cloud.managedkafka.v1.CreateConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public void updateConnectCluster(
        com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connect cluster.
     * </pre>
     */
    public void deleteConnectCluster(
        com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the connectors in a given Connect cluster.
     * </pre>
     */
    public void listConnectors(
        com.google.cloud.managedkafka.v1.ListConnectorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConnectorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConnectorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single connector.
     * </pre>
     */
    public void getConnector(
        com.google.cloud.managedkafka.v1.GetConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connector in a given Connect cluster.
     * </pre>
     */
    public void createConnector(
        com.google.cloud.managedkafka.v1.CreateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a connector.
     * </pre>
     */
    public void updateConnector(
        com.google.cloud.managedkafka.v1.UpdateConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connector.
     * </pre>
     */
    public void deleteConnector(
        com.google.cloud.managedkafka.v1.DeleteConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the connector and its tasks.
     * </pre>
     */
    public void pauseConnector(
        com.google.cloud.managedkafka.v1.PauseConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.PauseConnectorResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the connector and its tasks.
     * </pre>
     */
    public void resumeConnector(
        com.google.cloud.managedkafka.v1.ResumeConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restarts the connector.
     * </pre>
     */
    public void restartConnector(
        com.google.cloud.managedkafka.v1.RestartConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.RestartConnectorResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops the connector.
     * </pre>
     */
    public void stopConnector(
        com.google.cloud.managedkafka.v1.StopConnectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.StopConnectorResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopConnectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ManagedKafkaConnect.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public static final class ManagedKafkaConnectBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ManagedKafkaConnectBlockingV2Stub> {
    private ManagedKafkaConnectBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaConnectBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaConnectBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the Kafka Connect clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListConnectClustersResponse listConnectClusters(
        com.google.cloud.managedkafka.v1.ListConnectClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ConnectCluster getConnectCluster(
        com.google.cloud.managedkafka.v1.GetConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Kafka Connect cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConnectCluster(
        com.google.cloud.managedkafka.v1.CreateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnectCluster(
        com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connect cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnectCluster(
        com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the connectors in a given Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListConnectorsResponse listConnectors(
        com.google.cloud.managedkafka.v1.ListConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector getConnector(
        com.google.cloud.managedkafka.v1.GetConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connector in a given Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector createConnector(
        com.google.cloud.managedkafka.v1.CreateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector updateConnector(
        com.google.cloud.managedkafka.v1.UpdateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connector.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnector(
        com.google.cloud.managedkafka.v1.DeleteConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the connector and its tasks.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.PauseConnectorResponse pauseConnector(
        com.google.cloud.managedkafka.v1.PauseConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the connector and its tasks.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ResumeConnectorResponse resumeConnector(
        com.google.cloud.managedkafka.v1.ResumeConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts the connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.RestartConnectorResponse restartConnector(
        com.google.cloud.managedkafka.v1.RestartConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.StopConnectorResponse stopConnector(
        com.google.cloud.managedkafka.v1.StopConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopConnectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ManagedKafkaConnect.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public static final class ManagedKafkaConnectBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ManagedKafkaConnectBlockingStub> {
    private ManagedKafkaConnectBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaConnectBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaConnectBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the Kafka Connect clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListConnectClustersResponse listConnectClusters(
        com.google.cloud.managedkafka.v1.ListConnectClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ConnectCluster getConnectCluster(
        com.google.cloud.managedkafka.v1.GetConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Kafka Connect cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createConnectCluster(
        com.google.cloud.managedkafka.v1.CreateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateConnectCluster(
        com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connect cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteConnectCluster(
        com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the connectors in a given Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListConnectorsResponse listConnectors(
        com.google.cloud.managedkafka.v1.ListConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConnectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector getConnector(
        com.google.cloud.managedkafka.v1.GetConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connector in a given Connect cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector createConnector(
        com.google.cloud.managedkafka.v1.CreateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Connector updateConnector(
        com.google.cloud.managedkafka.v1.UpdateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connector.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConnector(
        com.google.cloud.managedkafka.v1.DeleteConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the connector and its tasks.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.PauseConnectorResponse pauseConnector(
        com.google.cloud.managedkafka.v1.PauseConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the connector and its tasks.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ResumeConnectorResponse resumeConnector(
        com.google.cloud.managedkafka.v1.ResumeConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts the connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.RestartConnectorResponse restartConnector(
        com.google.cloud.managedkafka.v1.RestartConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartConnectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the connector.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.StopConnectorResponse stopConnector(
        com.google.cloud.managedkafka.v1.StopConnectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopConnectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ManagedKafkaConnect.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka Connect
   * clusters and connectors.
   * </pre>
   */
  public static final class ManagedKafkaConnectFutureStub
      extends io.grpc.stub.AbstractFutureStub<ManagedKafkaConnectFutureStub> {
    private ManagedKafkaConnectFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaConnectFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaConnectFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the Kafka Connect clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ListConnectClustersResponse>
        listConnectClusters(com.google.cloud.managedkafka.v1.ListConnectClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ConnectCluster>
        getConnectCluster(com.google.cloud.managedkafka.v1.GetConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Kafka Connect cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createConnectCluster(com.google.cloud.managedkafka.v1.CreateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single Kafka Connect cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateConnectCluster(com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Connect cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteConnectCluster(com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the connectors in a given Connect cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ListConnectorsResponse>
        listConnectors(com.google.cloud.managedkafka.v1.ListConnectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConnectorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Connector>
        getConnector(com.google.cloud.managedkafka.v1.GetConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new connector in a given Connect cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Connector>
        createConnector(com.google.cloud.managedkafka.v1.CreateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Connector>
        updateConnector(com.google.cloud.managedkafka.v1.UpdateConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConnector(com.google.cloud.managedkafka.v1.DeleteConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the connector and its tasks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.PauseConnectorResponse>
        pauseConnector(com.google.cloud.managedkafka.v1.PauseConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the connector and its tasks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ResumeConnectorResponse>
        resumeConnector(com.google.cloud.managedkafka.v1.ResumeConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restarts the connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.RestartConnectorResponse>
        restartConnector(com.google.cloud.managedkafka.v1.RestartConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartConnectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops the connector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.StopConnectorResponse>
        stopConnector(com.google.cloud.managedkafka.v1.StopConnectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopConnectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CONNECT_CLUSTERS = 0;
  private static final int METHODID_GET_CONNECT_CLUSTER = 1;
  private static final int METHODID_CREATE_CONNECT_CLUSTER = 2;
  private static final int METHODID_UPDATE_CONNECT_CLUSTER = 3;
  private static final int METHODID_DELETE_CONNECT_CLUSTER = 4;
  private static final int METHODID_LIST_CONNECTORS = 5;
  private static final int METHODID_GET_CONNECTOR = 6;
  private static final int METHODID_CREATE_CONNECTOR = 7;
  private static final int METHODID_UPDATE_CONNECTOR = 8;
  private static final int METHODID_DELETE_CONNECTOR = 9;
  private static final int METHODID_PAUSE_CONNECTOR = 10;
  private static final int METHODID_RESUME_CONNECTOR = 11;
  private static final int METHODID_RESTART_CONNECTOR = 12;
  private static final int METHODID_STOP_CONNECTOR = 13;

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
        case METHODID_LIST_CONNECT_CLUSTERS:
          serviceImpl.listConnectClusters(
              (com.google.cloud.managedkafka.v1.ListConnectClustersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.managedkafka.v1.ListConnectClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECT_CLUSTER:
          serviceImpl.getConnectCluster(
              (com.google.cloud.managedkafka.v1.GetConnectClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConnectCluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECT_CLUSTER:
          serviceImpl.createConnectCluster(
              (com.google.cloud.managedkafka.v1.CreateConnectClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONNECT_CLUSTER:
          serviceImpl.updateConnectCluster(
              (com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CONNECT_CLUSTER:
          serviceImpl.deleteConnectCluster(
              (com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_CONNECTORS:
          serviceImpl.listConnectors(
              (com.google.cloud.managedkafka.v1.ListConnectorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConnectorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONNECTOR:
          serviceImpl.getConnector(
              (com.google.cloud.managedkafka.v1.GetConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector>)
                  responseObserver);
          break;
        case METHODID_CREATE_CONNECTOR:
          serviceImpl.createConnector(
              (com.google.cloud.managedkafka.v1.CreateConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONNECTOR:
          serviceImpl.updateConnector(
              (com.google.cloud.managedkafka.v1.UpdateConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Connector>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONNECTOR:
          serviceImpl.deleteConnector(
              (com.google.cloud.managedkafka.v1.DeleteConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_PAUSE_CONNECTOR:
          serviceImpl.pauseConnector(
              (com.google.cloud.managedkafka.v1.PauseConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.PauseConnectorResponse>)
                  responseObserver);
          break;
        case METHODID_RESUME_CONNECTOR:
          serviceImpl.resumeConnector(
              (com.google.cloud.managedkafka.v1.ResumeConnectorRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.managedkafka.v1.ResumeConnectorResponse>)
                  responseObserver);
          break;
        case METHODID_RESTART_CONNECTOR:
          serviceImpl.restartConnector(
              (com.google.cloud.managedkafka.v1.RestartConnectorRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.managedkafka.v1.RestartConnectorResponse>)
                  responseObserver);
          break;
        case METHODID_STOP_CONNECTOR:
          serviceImpl.stopConnector(
              (com.google.cloud.managedkafka.v1.StopConnectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.StopConnectorResponse>)
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
            getListConnectClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ListConnectClustersRequest,
                    com.google.cloud.managedkafka.v1.ListConnectClustersResponse>(
                    service, METHODID_LIST_CONNECT_CLUSTERS)))
        .addMethod(
            getGetConnectClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.GetConnectClusterRequest,
                    com.google.cloud.managedkafka.v1.ConnectCluster>(
                    service, METHODID_GET_CONNECT_CLUSTER)))
        .addMethod(
            getCreateConnectClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.CreateConnectClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CONNECT_CLUSTER)))
        .addMethod(
            getUpdateConnectClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.UpdateConnectClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CONNECT_CLUSTER)))
        .addMethod(
            getDeleteConnectClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.DeleteConnectClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CONNECT_CLUSTER)))
        .addMethod(
            getListConnectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ListConnectorsRequest,
                    com.google.cloud.managedkafka.v1.ListConnectorsResponse>(
                    service, METHODID_LIST_CONNECTORS)))
        .addMethod(
            getGetConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.GetConnectorRequest,
                    com.google.cloud.managedkafka.v1.Connector>(service, METHODID_GET_CONNECTOR)))
        .addMethod(
            getCreateConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.CreateConnectorRequest,
                    com.google.cloud.managedkafka.v1.Connector>(
                    service, METHODID_CREATE_CONNECTOR)))
        .addMethod(
            getUpdateConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.UpdateConnectorRequest,
                    com.google.cloud.managedkafka.v1.Connector>(
                    service, METHODID_UPDATE_CONNECTOR)))
        .addMethod(
            getDeleteConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.DeleteConnectorRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONNECTOR)))
        .addMethod(
            getPauseConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.PauseConnectorRequest,
                    com.google.cloud.managedkafka.v1.PauseConnectorResponse>(
                    service, METHODID_PAUSE_CONNECTOR)))
        .addMethod(
            getResumeConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ResumeConnectorRequest,
                    com.google.cloud.managedkafka.v1.ResumeConnectorResponse>(
                    service, METHODID_RESUME_CONNECTOR)))
        .addMethod(
            getRestartConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.RestartConnectorRequest,
                    com.google.cloud.managedkafka.v1.RestartConnectorResponse>(
                    service, METHODID_RESTART_CONNECTOR)))
        .addMethod(
            getStopConnectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.StopConnectorRequest,
                    com.google.cloud.managedkafka.v1.StopConnectorResponse>(
                    service, METHODID_STOP_CONNECTOR)))
        .build();
  }

  private abstract static class ManagedKafkaConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagedKafkaConnectBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.managedkafka.v1.ManagedKafkaConnectProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagedKafkaConnect");
    }
  }

  private static final class ManagedKafkaConnectFileDescriptorSupplier
      extends ManagedKafkaConnectBaseDescriptorSupplier {
    ManagedKafkaConnectFileDescriptorSupplier() {}
  }

  private static final class ManagedKafkaConnectMethodDescriptorSupplier
      extends ManagedKafkaConnectBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ManagedKafkaConnectMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ManagedKafkaConnectGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ManagedKafkaConnectFileDescriptorSupplier())
                      .addMethod(getListConnectClustersMethod())
                      .addMethod(getGetConnectClusterMethod())
                      .addMethod(getCreateConnectClusterMethod())
                      .addMethod(getUpdateConnectClusterMethod())
                      .addMethod(getDeleteConnectClusterMethod())
                      .addMethod(getListConnectorsMethod())
                      .addMethod(getGetConnectorMethod())
                      .addMethod(getCreateConnectorMethod())
                      .addMethod(getUpdateConnectorMethod())
                      .addMethod(getDeleteConnectorMethod())
                      .addMethod(getPauseConnectorMethod())
                      .addMethod(getResumeConnectorMethod())
                      .addMethod(getRestartConnectorMethod())
                      .addMethod(getStopConnectorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
