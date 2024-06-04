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
package com.google.cloud.managedkafka.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The service that a client application uses to manage Apache Kafka clusters,
 * topics and consumer groups.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/managedkafka/v1/managed_kafka.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ManagedKafkaGrpc {

  private ManagedKafkaGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.managedkafka.v1.ManagedKafka";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListClustersRequest,
          com.google.cloud.managedkafka.v1.ListClustersResponse>
      getListClustersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListClusters",
      requestType = com.google.cloud.managedkafka.v1.ListClustersRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ListClustersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListClustersRequest,
          com.google.cloud.managedkafka.v1.ListClustersResponse>
      getListClustersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ListClustersRequest,
            com.google.cloud.managedkafka.v1.ListClustersResponse>
        getListClustersMethod;
    if ((getListClustersMethod = ManagedKafkaGrpc.getListClustersMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getListClustersMethod = ManagedKafkaGrpc.getListClustersMethod) == null) {
          ManagedKafkaGrpc.getListClustersMethod =
              getListClustersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ListClustersRequest,
                          com.google.cloud.managedkafka.v1.ListClustersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListClusters"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListClustersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListClustersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("ListClusters"))
                      .build();
        }
      }
    }
    return getListClustersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetClusterRequest,
          com.google.cloud.managedkafka.v1.Cluster>
      getGetClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCluster",
      requestType = com.google.cloud.managedkafka.v1.GetClusterRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Cluster.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetClusterRequest,
          com.google.cloud.managedkafka.v1.Cluster>
      getGetClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.GetClusterRequest,
            com.google.cloud.managedkafka.v1.Cluster>
        getGetClusterMethod;
    if ((getGetClusterMethod = ManagedKafkaGrpc.getGetClusterMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getGetClusterMethod = ManagedKafkaGrpc.getGetClusterMethod) == null) {
          ManagedKafkaGrpc.getGetClusterMethod =
              getGetClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.GetClusterRequest,
                          com.google.cloud.managedkafka.v1.Cluster>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.GetClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Cluster.getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("GetCluster"))
                      .build();
        }
      }
    }
    return getGetClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCluster",
      requestType = com.google.cloud.managedkafka.v1.CreateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateClusterRequest, com.google.longrunning.Operation>
      getCreateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.CreateClusterRequest, com.google.longrunning.Operation>
        getCreateClusterMethod;
    if ((getCreateClusterMethod = ManagedKafkaGrpc.getCreateClusterMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getCreateClusterMethod = ManagedKafkaGrpc.getCreateClusterMethod) == null) {
          ManagedKafkaGrpc.getCreateClusterMethod =
              getCreateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.CreateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.CreateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("CreateCluster"))
                      .build();
        }
      }
    }
    return getCreateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCluster",
      requestType = com.google.cloud.managedkafka.v1.UpdateClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateClusterRequest, com.google.longrunning.Operation>
      getUpdateClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.UpdateClusterRequest, com.google.longrunning.Operation>
        getUpdateClusterMethod;
    if ((getUpdateClusterMethod = ManagedKafkaGrpc.getUpdateClusterMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getUpdateClusterMethod = ManagedKafkaGrpc.getUpdateClusterMethod) == null) {
          ManagedKafkaGrpc.getUpdateClusterMethod =
              getUpdateClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.UpdateClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.UpdateClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("UpdateCluster"))
                      .build();
        }
      }
    }
    return getUpdateClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCluster",
      requestType = com.google.cloud.managedkafka.v1.DeleteClusterRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteClusterRequest, com.google.longrunning.Operation>
      getDeleteClusterMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.DeleteClusterRequest, com.google.longrunning.Operation>
        getDeleteClusterMethod;
    if ((getDeleteClusterMethod = ManagedKafkaGrpc.getDeleteClusterMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getDeleteClusterMethod = ManagedKafkaGrpc.getDeleteClusterMethod) == null) {
          ManagedKafkaGrpc.getDeleteClusterMethod =
              getDeleteClusterMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.DeleteClusterRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCluster"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.DeleteClusterRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("DeleteCluster"))
                      .build();
        }
      }
    }
    return getDeleteClusterMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListTopicsRequest,
          com.google.cloud.managedkafka.v1.ListTopicsResponse>
      getListTopicsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTopics",
      requestType = com.google.cloud.managedkafka.v1.ListTopicsRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ListTopicsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListTopicsRequest,
          com.google.cloud.managedkafka.v1.ListTopicsResponse>
      getListTopicsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ListTopicsRequest,
            com.google.cloud.managedkafka.v1.ListTopicsResponse>
        getListTopicsMethod;
    if ((getListTopicsMethod = ManagedKafkaGrpc.getListTopicsMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getListTopicsMethod = ManagedKafkaGrpc.getListTopicsMethod) == null) {
          ManagedKafkaGrpc.getListTopicsMethod =
              getListTopicsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ListTopicsRequest,
                          com.google.cloud.managedkafka.v1.ListTopicsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTopics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListTopicsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListTopicsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("ListTopics"))
                      .build();
        }
      }
    }
    return getListTopicsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetTopicRequest, com.google.cloud.managedkafka.v1.Topic>
      getGetTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTopic",
      requestType = com.google.cloud.managedkafka.v1.GetTopicRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetTopicRequest, com.google.cloud.managedkafka.v1.Topic>
      getGetTopicMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.GetTopicRequest,
            com.google.cloud.managedkafka.v1.Topic>
        getGetTopicMethod;
    if ((getGetTopicMethod = ManagedKafkaGrpc.getGetTopicMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getGetTopicMethod = ManagedKafkaGrpc.getGetTopicMethod) == null) {
          ManagedKafkaGrpc.getGetTopicMethod =
              getGetTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.GetTopicRequest,
                          com.google.cloud.managedkafka.v1.Topic>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.GetTopicRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("GetTopic"))
                      .build();
        }
      }
    }
    return getGetTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateTopicRequest,
          com.google.cloud.managedkafka.v1.Topic>
      getCreateTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTopic",
      requestType = com.google.cloud.managedkafka.v1.CreateTopicRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.CreateTopicRequest,
          com.google.cloud.managedkafka.v1.Topic>
      getCreateTopicMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.CreateTopicRequest,
            com.google.cloud.managedkafka.v1.Topic>
        getCreateTopicMethod;
    if ((getCreateTopicMethod = ManagedKafkaGrpc.getCreateTopicMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getCreateTopicMethod = ManagedKafkaGrpc.getCreateTopicMethod) == null) {
          ManagedKafkaGrpc.getCreateTopicMethod =
              getCreateTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.CreateTopicRequest,
                          com.google.cloud.managedkafka.v1.Topic>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.CreateTopicRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("CreateTopic"))
                      .build();
        }
      }
    }
    return getCreateTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateTopicRequest,
          com.google.cloud.managedkafka.v1.Topic>
      getUpdateTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTopic",
      requestType = com.google.cloud.managedkafka.v1.UpdateTopicRequest.class,
      responseType = com.google.cloud.managedkafka.v1.Topic.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateTopicRequest,
          com.google.cloud.managedkafka.v1.Topic>
      getUpdateTopicMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.UpdateTopicRequest,
            com.google.cloud.managedkafka.v1.Topic>
        getUpdateTopicMethod;
    if ((getUpdateTopicMethod = ManagedKafkaGrpc.getUpdateTopicMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getUpdateTopicMethod = ManagedKafkaGrpc.getUpdateTopicMethod) == null) {
          ManagedKafkaGrpc.getUpdateTopicMethod =
              getUpdateTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.UpdateTopicRequest,
                          com.google.cloud.managedkafka.v1.Topic>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.UpdateTopicRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.Topic.getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("UpdateTopic"))
                      .build();
        }
      }
    }
    return getUpdateTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteTopicRequest, com.google.protobuf.Empty>
      getDeleteTopicMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTopic",
      requestType = com.google.cloud.managedkafka.v1.DeleteTopicRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteTopicRequest, com.google.protobuf.Empty>
      getDeleteTopicMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.DeleteTopicRequest, com.google.protobuf.Empty>
        getDeleteTopicMethod;
    if ((getDeleteTopicMethod = ManagedKafkaGrpc.getDeleteTopicMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getDeleteTopicMethod = ManagedKafkaGrpc.getDeleteTopicMethod) == null) {
          ManagedKafkaGrpc.getDeleteTopicMethod =
              getDeleteTopicMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.DeleteTopicRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTopic"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.DeleteTopicRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ManagedKafkaMethodDescriptorSupplier("DeleteTopic"))
                      .build();
        }
      }
    }
    return getDeleteTopicMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest,
          com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
      getListConsumerGroupsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConsumerGroups",
      requestType = com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest,
          com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
      getListConsumerGroupsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest,
            com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
        getListConsumerGroupsMethod;
    if ((getListConsumerGroupsMethod = ManagedKafkaGrpc.getListConsumerGroupsMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getListConsumerGroupsMethod = ManagedKafkaGrpc.getListConsumerGroupsMethod) == null) {
          ManagedKafkaGrpc.getListConsumerGroupsMethod =
              getListConsumerGroupsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest,
                          com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConsumerGroups"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("ListConsumerGroups"))
                      .build();
        }
      }
    }
    return getListConsumerGroupsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConsumerGroupRequest,
          com.google.cloud.managedkafka.v1.ConsumerGroup>
      getGetConsumerGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConsumerGroup",
      requestType = com.google.cloud.managedkafka.v1.GetConsumerGroupRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ConsumerGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.GetConsumerGroupRequest,
          com.google.cloud.managedkafka.v1.ConsumerGroup>
      getGetConsumerGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.GetConsumerGroupRequest,
            com.google.cloud.managedkafka.v1.ConsumerGroup>
        getGetConsumerGroupMethod;
    if ((getGetConsumerGroupMethod = ManagedKafkaGrpc.getGetConsumerGroupMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getGetConsumerGroupMethod = ManagedKafkaGrpc.getGetConsumerGroupMethod) == null) {
          ManagedKafkaGrpc.getGetConsumerGroupMethod =
              getGetConsumerGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.GetConsumerGroupRequest,
                          com.google.cloud.managedkafka.v1.ConsumerGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConsumerGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.GetConsumerGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ConsumerGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("GetConsumerGroup"))
                      .build();
        }
      }
    }
    return getGetConsumerGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest,
          com.google.cloud.managedkafka.v1.ConsumerGroup>
      getUpdateConsumerGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConsumerGroup",
      requestType = com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest.class,
      responseType = com.google.cloud.managedkafka.v1.ConsumerGroup.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest,
          com.google.cloud.managedkafka.v1.ConsumerGroup>
      getUpdateConsumerGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest,
            com.google.cloud.managedkafka.v1.ConsumerGroup>
        getUpdateConsumerGroupMethod;
    if ((getUpdateConsumerGroupMethod = ManagedKafkaGrpc.getUpdateConsumerGroupMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getUpdateConsumerGroupMethod = ManagedKafkaGrpc.getUpdateConsumerGroupMethod)
            == null) {
          ManagedKafkaGrpc.getUpdateConsumerGroupMethod =
              getUpdateConsumerGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest,
                          com.google.cloud.managedkafka.v1.ConsumerGroup>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateConsumerGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.ConsumerGroup.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("UpdateConsumerGroup"))
                      .build();
        }
      }
    }
    return getUpdateConsumerGroupMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest, com.google.protobuf.Empty>
      getDeleteConsumerGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConsumerGroup",
      requestType = com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest, com.google.protobuf.Empty>
      getDeleteConsumerGroupMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest, com.google.protobuf.Empty>
        getDeleteConsumerGroupMethod;
    if ((getDeleteConsumerGroupMethod = ManagedKafkaGrpc.getDeleteConsumerGroupMethod) == null) {
      synchronized (ManagedKafkaGrpc.class) {
        if ((getDeleteConsumerGroupMethod = ManagedKafkaGrpc.getDeleteConsumerGroupMethod)
            == null) {
          ManagedKafkaGrpc.getDeleteConsumerGroupMethod =
              getDeleteConsumerGroupMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteConsumerGroup"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ManagedKafkaMethodDescriptorSupplier("DeleteConsumerGroup"))
                      .build();
        }
      }
    }
    return getDeleteConsumerGroupMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ManagedKafkaStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaStub>() {
          @java.lang.Override
          public ManagedKafkaStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaStub(channel, callOptions);
          }
        };
    return ManagedKafkaStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ManagedKafkaBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaBlockingStub>() {
          @java.lang.Override
          public ManagedKafkaBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaBlockingStub(channel, callOptions);
          }
        };
    return ManagedKafkaBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ManagedKafkaFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ManagedKafkaFutureStub>() {
          @java.lang.Override
          public ManagedKafkaFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ManagedKafkaFutureStub(channel, callOptions);
          }
        };
    return ManagedKafkaFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka clusters,
   * topics and consumer groups.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists the clusters in a given project and location.
     * </pre>
     */
    default void listClusters(
        com.google.cloud.managedkafka.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListClustersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single cluster.
     * </pre>
     */
    default void getCluster(
        com.google.cloud.managedkafka.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Cluster> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given project and location.
     * </pre>
     */
    default void createCluster(
        com.google.cloud.managedkafka.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single cluster.
     * </pre>
     */
    default void updateCluster(
        com.google.cloud.managedkafka.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single cluster.
     * </pre>
     */
    default void deleteCluster(
        com.google.cloud.managedkafka.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteClusterMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the topics in a given cluster.
     * </pre>
     */
    default void listTopics(
        com.google.cloud.managedkafka.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListTopicsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTopicsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single topic.
     * </pre>
     */
    default void getTopic(
        com.google.cloud.managedkafka.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new topic in a given project and location.
     * </pre>
     */
    default void createTopic(
        com.google.cloud.managedkafka.v1.CreateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single topic.
     * </pre>
     */
    default void updateTopic(
        com.google.cloud.managedkafka.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single topic.
     * </pre>
     */
    default void deleteTopic(
        com.google.cloud.managedkafka.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTopicMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the consumer groups in a given cluster.
     * </pre>
     */
    default void listConsumerGroups(
        com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConsumerGroupsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single consumer group.
     * </pre>
     */
    default void getConsumerGroup(
        com.google.cloud.managedkafka.v1.GetConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConsumerGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single consumer group.
     * </pre>
     */
    default void updateConsumerGroup(
        com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConsumerGroupMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single consumer group.
     * </pre>
     */
    default void deleteConsumerGroup(
        com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConsumerGroupMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ManagedKafka.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka clusters,
   * topics and consumer groups.
   * </pre>
   */
  public abstract static class ManagedKafkaImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ManagedKafkaGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ManagedKafka.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka clusters,
   * topics and consumer groups.
   * </pre>
   */
  public static final class ManagedKafkaStub
      extends io.grpc.stub.AbstractAsyncStub<ManagedKafkaStub> {
    private ManagedKafkaStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the clusters in a given project and location.
     * </pre>
     */
    public void listClusters(
        com.google.cloud.managedkafka.v1.ListClustersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListClustersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single cluster.
     * </pre>
     */
    public void getCluster(
        com.google.cloud.managedkafka.v1.GetClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Cluster> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given project and location.
     * </pre>
     */
    public void createCluster(
        com.google.cloud.managedkafka.v1.CreateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single cluster.
     * </pre>
     */
    public void updateCluster(
        com.google.cloud.managedkafka.v1.UpdateClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single cluster.
     * </pre>
     */
    public void deleteCluster(
        com.google.cloud.managedkafka.v1.DeleteClusterRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the topics in a given cluster.
     * </pre>
     */
    public void listTopics(
        com.google.cloud.managedkafka.v1.ListTopicsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListTopicsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single topic.
     * </pre>
     */
    public void getTopic(
        com.google.cloud.managedkafka.v1.GetTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new topic in a given project and location.
     * </pre>
     */
    public void createTopic(
        com.google.cloud.managedkafka.v1.CreateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single topic.
     * </pre>
     */
    public void updateTopic(
        com.google.cloud.managedkafka.v1.UpdateTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single topic.
     * </pre>
     */
    public void deleteTopic(
        com.google.cloud.managedkafka.v1.DeleteTopicRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTopicMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the consumer groups in a given cluster.
     * </pre>
     */
    public void listConsumerGroups(
        com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConsumerGroupsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single consumer group.
     * </pre>
     */
    public void getConsumerGroup(
        com.google.cloud.managedkafka.v1.GetConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConsumerGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single consumer group.
     * </pre>
     */
    public void updateConsumerGroup(
        com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConsumerGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single consumer group.
     * </pre>
     */
    public void deleteConsumerGroup(
        com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConsumerGroupMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ManagedKafka.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka clusters,
   * topics and consumer groups.
   * </pre>
   */
  public static final class ManagedKafkaBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ManagedKafkaBlockingStub> {
    private ManagedKafkaBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the clusters in a given project and location.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListClustersResponse listClusters(
        com.google.cloud.managedkafka.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListClustersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Cluster getCluster(
        com.google.cloud.managedkafka.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createCluster(
        com.google.cloud.managedkafka.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single cluster.
     * </pre>
     */
    public com.google.longrunning.Operation updateCluster(
        com.google.cloud.managedkafka.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single cluster.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCluster(
        com.google.cloud.managedkafka.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteClusterMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the topics in a given cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListTopicsResponse listTopics(
        com.google.cloud.managedkafka.v1.ListTopicsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTopicsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single topic.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Topic getTopic(
        com.google.cloud.managedkafka.v1.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new topic in a given project and location.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Topic createTopic(
        com.google.cloud.managedkafka.v1.CreateTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single topic.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.Topic updateTopic(
        com.google.cloud.managedkafka.v1.UpdateTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single topic.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTopic(
        com.google.cloud.managedkafka.v1.DeleteTopicRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTopicMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the consumer groups in a given cluster.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse listConsumerGroups(
        com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConsumerGroupsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single consumer group.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ConsumerGroup getConsumerGroup(
        com.google.cloud.managedkafka.v1.GetConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConsumerGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single consumer group.
     * </pre>
     */
    public com.google.cloud.managedkafka.v1.ConsumerGroup updateConsumerGroup(
        com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConsumerGroupMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single consumer group.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConsumerGroup(
        com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConsumerGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ManagedKafka.
   *
   * <pre>
   * The service that a client application uses to manage Apache Kafka clusters,
   * topics and consumer groups.
   * </pre>
   */
  public static final class ManagedKafkaFutureStub
      extends io.grpc.stub.AbstractFutureStub<ManagedKafkaFutureStub> {
    private ManagedKafkaFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ManagedKafkaFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ManagedKafkaFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists the clusters in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ListClustersResponse>
        listClusters(com.google.cloud.managedkafka.v1.ListClustersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListClustersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Cluster>
        getCluster(com.google.cloud.managedkafka.v1.GetClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new cluster in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCluster(com.google.cloud.managedkafka.v1.CreateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCluster(com.google.cloud.managedkafka.v1.UpdateClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCluster(com.google.cloud.managedkafka.v1.DeleteClusterRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteClusterMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the topics in a given cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ListTopicsResponse>
        listTopics(com.google.cloud.managedkafka.v1.ListTopicsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTopicsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Topic>
        getTopic(com.google.cloud.managedkafka.v1.GetTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new topic in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Topic>
        createTopic(com.google.cloud.managedkafka.v1.CreateTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.Topic>
        updateTopic(com.google.cloud.managedkafka.v1.UpdateTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single topic.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTopic(com.google.cloud.managedkafka.v1.DeleteTopicRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTopicMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the consumer groups in a given cluster.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>
        listConsumerGroups(com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConsumerGroupsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the properties of a single consumer group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ConsumerGroup>
        getConsumerGroup(com.google.cloud.managedkafka.v1.GetConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConsumerGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the properties of a single consumer group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.managedkafka.v1.ConsumerGroup>
        updateConsumerGroup(com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConsumerGroupMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single consumer group.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConsumerGroup(com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConsumerGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_CLUSTERS = 0;
  private static final int METHODID_GET_CLUSTER = 1;
  private static final int METHODID_CREATE_CLUSTER = 2;
  private static final int METHODID_UPDATE_CLUSTER = 3;
  private static final int METHODID_DELETE_CLUSTER = 4;
  private static final int METHODID_LIST_TOPICS = 5;
  private static final int METHODID_GET_TOPIC = 6;
  private static final int METHODID_CREATE_TOPIC = 7;
  private static final int METHODID_UPDATE_TOPIC = 8;
  private static final int METHODID_DELETE_TOPIC = 9;
  private static final int METHODID_LIST_CONSUMER_GROUPS = 10;
  private static final int METHODID_GET_CONSUMER_GROUP = 11;
  private static final int METHODID_UPDATE_CONSUMER_GROUP = 12;
  private static final int METHODID_DELETE_CONSUMER_GROUP = 13;

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
        case METHODID_LIST_CLUSTERS:
          serviceImpl.listClusters(
              (com.google.cloud.managedkafka.v1.ListClustersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListClustersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CLUSTER:
          serviceImpl.getCluster(
              (com.google.cloud.managedkafka.v1.GetClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Cluster>)
                  responseObserver);
          break;
        case METHODID_CREATE_CLUSTER:
          serviceImpl.createCluster(
              (com.google.cloud.managedkafka.v1.CreateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CLUSTER:
          serviceImpl.updateCluster(
              (com.google.cloud.managedkafka.v1.UpdateClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_CLUSTER:
          serviceImpl.deleteCluster(
              (com.google.cloud.managedkafka.v1.DeleteClusterRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TOPICS:
          serviceImpl.listTopics(
              (com.google.cloud.managedkafka.v1.ListTopicsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ListTopicsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TOPIC:
          serviceImpl.getTopic(
              (com.google.cloud.managedkafka.v1.GetTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic>)
                  responseObserver);
          break;
        case METHODID_CREATE_TOPIC:
          serviceImpl.createTopic(
              (com.google.cloud.managedkafka.v1.CreateTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TOPIC:
          serviceImpl.updateTopic(
              (com.google.cloud.managedkafka.v1.UpdateTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.Topic>)
                  responseObserver);
          break;
        case METHODID_DELETE_TOPIC:
          serviceImpl.deleteTopic(
              (com.google.cloud.managedkafka.v1.DeleteTopicRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_CONSUMER_GROUPS:
          serviceImpl.listConsumerGroups(
              (com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_CONSUMER_GROUP:
          serviceImpl.getConsumerGroup(
              (com.google.cloud.managedkafka.v1.GetConsumerGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CONSUMER_GROUP:
          serviceImpl.updateConsumerGroup(
              (com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.managedkafka.v1.ConsumerGroup>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONSUMER_GROUP:
          serviceImpl.deleteConsumerGroup(
              (com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest) request,
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
            getListClustersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ListClustersRequest,
                    com.google.cloud.managedkafka.v1.ListClustersResponse>(
                    service, METHODID_LIST_CLUSTERS)))
        .addMethod(
            getGetClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.GetClusterRequest,
                    com.google.cloud.managedkafka.v1.Cluster>(service, METHODID_GET_CLUSTER)))
        .addMethod(
            getCreateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.CreateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_CLUSTER)))
        .addMethod(
            getUpdateClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.UpdateClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CLUSTER)))
        .addMethod(
            getDeleteClusterMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.DeleteClusterRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CLUSTER)))
        .addMethod(
            getListTopicsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ListTopicsRequest,
                    com.google.cloud.managedkafka.v1.ListTopicsResponse>(
                    service, METHODID_LIST_TOPICS)))
        .addMethod(
            getGetTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.GetTopicRequest,
                    com.google.cloud.managedkafka.v1.Topic>(service, METHODID_GET_TOPIC)))
        .addMethod(
            getCreateTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.CreateTopicRequest,
                    com.google.cloud.managedkafka.v1.Topic>(service, METHODID_CREATE_TOPIC)))
        .addMethod(
            getUpdateTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.UpdateTopicRequest,
                    com.google.cloud.managedkafka.v1.Topic>(service, METHODID_UPDATE_TOPIC)))
        .addMethod(
            getDeleteTopicMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.DeleteTopicRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_TOPIC)))
        .addMethod(
            getListConsumerGroupsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.ListConsumerGroupsRequest,
                    com.google.cloud.managedkafka.v1.ListConsumerGroupsResponse>(
                    service, METHODID_LIST_CONSUMER_GROUPS)))
        .addMethod(
            getGetConsumerGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.GetConsumerGroupRequest,
                    com.google.cloud.managedkafka.v1.ConsumerGroup>(
                    service, METHODID_GET_CONSUMER_GROUP)))
        .addMethod(
            getUpdateConsumerGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.UpdateConsumerGroupRequest,
                    com.google.cloud.managedkafka.v1.ConsumerGroup>(
                    service, METHODID_UPDATE_CONSUMER_GROUP)))
        .addMethod(
            getDeleteConsumerGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.managedkafka.v1.DeleteConsumerGroupRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONSUMER_GROUP)))
        .build();
  }

  private abstract static class ManagedKafkaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ManagedKafkaBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.managedkafka.v1.ManagedKafkaProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ManagedKafka");
    }
  }

  private static final class ManagedKafkaFileDescriptorSupplier
      extends ManagedKafkaBaseDescriptorSupplier {
    ManagedKafkaFileDescriptorSupplier() {}
  }

  private static final class ManagedKafkaMethodDescriptorSupplier
      extends ManagedKafkaBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ManagedKafkaMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ManagedKafkaGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ManagedKafkaFileDescriptorSupplier())
                      .addMethod(getListClustersMethod())
                      .addMethod(getGetClusterMethod())
                      .addMethod(getCreateClusterMethod())
                      .addMethod(getUpdateClusterMethod())
                      .addMethod(getDeleteClusterMethod())
                      .addMethod(getListTopicsMethod())
                      .addMethod(getGetTopicMethod())
                      .addMethod(getCreateTopicMethod())
                      .addMethod(getUpdateTopicMethod())
                      .addMethod(getDeleteTopicMethod())
                      .addMethod(getListConsumerGroupsMethod())
                      .addMethod(getGetConsumerGroupMethod())
                      .addMethod(getUpdateConsumerGroupMethod())
                      .addMethod(getDeleteConsumerGroupMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
