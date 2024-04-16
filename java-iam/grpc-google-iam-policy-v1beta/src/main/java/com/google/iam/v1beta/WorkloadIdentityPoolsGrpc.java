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
package com.google.iam.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Manages WorkloadIdentityPools.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/iam/v1beta/workload_identity_pool.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkloadIdentityPoolsGrpc {

  private WorkloadIdentityPoolsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.iam.v1beta.WorkloadIdentityPools";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest,
      com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> getListWorkloadIdentityPoolsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloadIdentityPools",
      requestType = com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest.class,
      responseType = com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest,
      com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> getListWorkloadIdentityPoolsMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest, com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> getListWorkloadIdentityPoolsMethod;
    if ((getListWorkloadIdentityPoolsMethod = WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolsMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getListWorkloadIdentityPoolsMethod = WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolsMethod) == null) {
          WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolsMethod = getListWorkloadIdentityPoolsMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest, com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloadIdentityPools"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("ListWorkloadIdentityPools"))
              .build();
        }
      }
    }
    return getListWorkloadIdentityPoolsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolRequest,
      com.google.iam.v1beta.WorkloadIdentityPool> getGetWorkloadIdentityPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkloadIdentityPool",
      requestType = com.google.iam.v1beta.GetWorkloadIdentityPoolRequest.class,
      responseType = com.google.iam.v1beta.WorkloadIdentityPool.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolRequest,
      com.google.iam.v1beta.WorkloadIdentityPool> getGetWorkloadIdentityPoolMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolRequest, com.google.iam.v1beta.WorkloadIdentityPool> getGetWorkloadIdentityPoolMethod;
    if ((getGetWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getGetWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolMethod) == null) {
          WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolMethod = getGetWorkloadIdentityPoolMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.GetWorkloadIdentityPoolRequest, com.google.iam.v1beta.WorkloadIdentityPool>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkloadIdentityPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.GetWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.WorkloadIdentityPool.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("GetWorkloadIdentityPool"))
              .build();
        }
      }
    }
    return getGetWorkloadIdentityPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getCreateWorkloadIdentityPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkloadIdentityPool",
      requestType = com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getCreateWorkloadIdentityPoolMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest, com.google.longrunning.Operation> getCreateWorkloadIdentityPoolMethod;
    if ((getCreateWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getCreateWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolMethod) == null) {
          WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolMethod = getCreateWorkloadIdentityPoolMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkloadIdentityPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("CreateWorkloadIdentityPool"))
              .build();
        }
      }
    }
    return getCreateWorkloadIdentityPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkloadIdentityPool",
      requestType = com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest, com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolMethod;
    if ((getUpdateWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getUpdateWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolMethod) == null) {
          WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolMethod = getUpdateWorkloadIdentityPoolMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkloadIdentityPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("UpdateWorkloadIdentityPool"))
              .build();
        }
      }
    }
    return getUpdateWorkloadIdentityPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkloadIdentityPool",
      requestType = com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest, com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolMethod;
    if ((getDeleteWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getDeleteWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolMethod) == null) {
          WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolMethod = getDeleteWorkloadIdentityPoolMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkloadIdentityPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("DeleteWorkloadIdentityPool"))
              .build();
        }
      }
    }
    return getDeleteWorkloadIdentityPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteWorkloadIdentityPool",
      requestType = com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest,
      com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest, com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolMethod;
    if ((getUndeleteWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getUndeleteWorkloadIdentityPoolMethod = WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolMethod) == null) {
          WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolMethod = getUndeleteWorkloadIdentityPoolMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteWorkloadIdentityPool"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("UndeleteWorkloadIdentityPool"))
              .build();
        }
      }
    }
    return getUndeleteWorkloadIdentityPoolMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest,
      com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> getListWorkloadIdentityPoolProvidersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListWorkloadIdentityPoolProviders",
      requestType = com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest.class,
      responseType = com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest,
      com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> getListWorkloadIdentityPoolProvidersMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest, com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> getListWorkloadIdentityPoolProvidersMethod;
    if ((getListWorkloadIdentityPoolProvidersMethod = WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolProvidersMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getListWorkloadIdentityPoolProvidersMethod = WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolProvidersMethod) == null) {
          WorkloadIdentityPoolsGrpc.getListWorkloadIdentityPoolProvidersMethod = getListWorkloadIdentityPoolProvidersMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest, com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListWorkloadIdentityPoolProviders"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("ListWorkloadIdentityPoolProviders"))
              .build();
        }
      }
    }
    return getListWorkloadIdentityPoolProvidersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest,
      com.google.iam.v1beta.WorkloadIdentityPoolProvider> getGetWorkloadIdentityPoolProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetWorkloadIdentityPoolProvider",
      requestType = com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest.class,
      responseType = com.google.iam.v1beta.WorkloadIdentityPoolProvider.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest,
      com.google.iam.v1beta.WorkloadIdentityPoolProvider> getGetWorkloadIdentityPoolProviderMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest, com.google.iam.v1beta.WorkloadIdentityPoolProvider> getGetWorkloadIdentityPoolProviderMethod;
    if ((getGetWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolProviderMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getGetWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolProviderMethod) == null) {
          WorkloadIdentityPoolsGrpc.getGetWorkloadIdentityPoolProviderMethod = getGetWorkloadIdentityPoolProviderMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest, com.google.iam.v1beta.WorkloadIdentityPoolProvider>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetWorkloadIdentityPoolProvider"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.WorkloadIdentityPoolProvider.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("GetWorkloadIdentityPoolProvider"))
              .build();
        }
      }
    }
    return getGetWorkloadIdentityPoolProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getCreateWorkloadIdentityPoolProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateWorkloadIdentityPoolProvider",
      requestType = com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getCreateWorkloadIdentityPoolProviderMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation> getCreateWorkloadIdentityPoolProviderMethod;
    if ((getCreateWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolProviderMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getCreateWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolProviderMethod) == null) {
          WorkloadIdentityPoolsGrpc.getCreateWorkloadIdentityPoolProviderMethod = getCreateWorkloadIdentityPoolProviderMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateWorkloadIdentityPoolProvider"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("CreateWorkloadIdentityPoolProvider"))
              .build();
        }
      }
    }
    return getCreateWorkloadIdentityPoolProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateWorkloadIdentityPoolProvider",
      requestType = com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolProviderMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation> getUpdateWorkloadIdentityPoolProviderMethod;
    if ((getUpdateWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolProviderMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getUpdateWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolProviderMethod) == null) {
          WorkloadIdentityPoolsGrpc.getUpdateWorkloadIdentityPoolProviderMethod = getUpdateWorkloadIdentityPoolProviderMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateWorkloadIdentityPoolProvider"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("UpdateWorkloadIdentityPoolProvider"))
              .build();
        }
      }
    }
    return getUpdateWorkloadIdentityPoolProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteWorkloadIdentityPoolProvider",
      requestType = com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolProviderMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation> getDeleteWorkloadIdentityPoolProviderMethod;
    if ((getDeleteWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolProviderMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getDeleteWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolProviderMethod) == null) {
          WorkloadIdentityPoolsGrpc.getDeleteWorkloadIdentityPoolProviderMethod = getDeleteWorkloadIdentityPoolProviderMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteWorkloadIdentityPoolProvider"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("DeleteWorkloadIdentityPoolProvider"))
              .build();
        }
      }
    }
    return getDeleteWorkloadIdentityPoolProviderMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolProviderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeleteWorkloadIdentityPoolProvider",
      requestType = com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest,
      com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolProviderMethod() {
    io.grpc.MethodDescriptor<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation> getUndeleteWorkloadIdentityPoolProviderMethod;
    if ((getUndeleteWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolProviderMethod) == null) {
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        if ((getUndeleteWorkloadIdentityPoolProviderMethod = WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolProviderMethod) == null) {
          WorkloadIdentityPoolsGrpc.getUndeleteWorkloadIdentityPoolProviderMethod = getUndeleteWorkloadIdentityPoolProviderMethod =
              io.grpc.MethodDescriptor.<com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest, com.google.longrunning.Operation>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeleteWorkloadIdentityPoolProvider"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.longrunning.Operation.getDefaultInstance()))
              .setSchemaDescriptor(new WorkloadIdentityPoolsMethodDescriptorSupplier("UndeleteWorkloadIdentityPoolProvider"))
              .build();
        }
      }
    }
    return getUndeleteWorkloadIdentityPoolProviderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkloadIdentityPoolsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsStub>() {
        @java.lang.Override
        public WorkloadIdentityPoolsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkloadIdentityPoolsStub(channel, callOptions);
        }
      };
    return WorkloadIdentityPoolsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkloadIdentityPoolsBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsBlockingStub>() {
        @java.lang.Override
        public WorkloadIdentityPoolsBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkloadIdentityPoolsBlockingStub(channel, callOptions);
        }
      };
    return WorkloadIdentityPoolsBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkloadIdentityPoolsFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkloadIdentityPoolsFutureStub>() {
        @java.lang.Override
        public WorkloadIdentityPoolsFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkloadIdentityPoolsFutureStub(channel, callOptions);
        }
      };
    return WorkloadIdentityPoolsFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Manages WorkloadIdentityPools.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
     * project. If `show_deleted` is set to `true`, then deleted pools are also
     * listed.
     * </pre>
     */
    default void listWorkloadIdentityPools(com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadIdentityPoolsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    default void getWorkloadIdentityPool(com.google.iam.v1beta.GetWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPool> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkloadIdentityPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted pool until 30 days after deletion.
     * </pre>
     */
    default void createWorkloadIdentityPool(com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkloadIdentityPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    default void updateWorkloadIdentityPool(com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWorkloadIdentityPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot use a deleted pool to exchange external
     * credentials for Google Cloud credentials. However, deletion does
     * not revoke credentials that have already been issued.
     * Credentials issued for a deleted pool do not grant access to resources.
     * If the pool is undeleted, and the credentials are not expired, they
     * grant access again.
     * You can undelete a pool for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted pools. However, you can view and list them.
     * </pre>
     */
    default void deleteWorkloadIdentityPool(com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWorkloadIdentityPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    default void undeleteWorkloadIdentityPool(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteWorkloadIdentityPoolMethod(), responseObserver);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * If `show_deleted` is set to `true`, then deleted providers are also listed.
     * </pre>
     */
    default void listWorkloadIdentityPoolProviders(com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListWorkloadIdentityPoolProvidersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
     * </pre>
     */
    default void getWorkloadIdentityPoolProvider(com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPoolProvider> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetWorkloadIdentityPoolProviderMethod(), responseObserver);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted provider until 30 days after
     * deletion.
     * </pre>
     */
    default void createWorkloadIdentityPoolProvider(com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateWorkloadIdentityPoolProviderMethod(), responseObserver);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * </pre>
     */
    default void updateWorkloadIdentityPoolProvider(com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateWorkloadIdentityPoolProviderMethod(), responseObserver);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * Deleting a provider does not revoke credentials that have already been
     * issued; they continue to grant access.
     * You can undelete a provider for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted providers. However, you can view and list them.
     * </pre>
     */
    default void deleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteWorkloadIdentityPoolProviderMethod(), responseObserver);
    }

    /**
     * <pre>
     * Undeletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    default void undeleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUndeleteWorkloadIdentityPoolProviderMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkloadIdentityPools.
   * <pre>
   * Manages WorkloadIdentityPools.
   * </pre>
   */
  public static abstract class WorkloadIdentityPoolsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WorkloadIdentityPoolsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkloadIdentityPools.
   * <pre>
   * Manages WorkloadIdentityPools.
   * </pre>
   */
  public static final class WorkloadIdentityPoolsStub
      extends io.grpc.stub.AbstractAsyncStub<WorkloadIdentityPoolsStub> {
    private WorkloadIdentityPoolsStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityPoolsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityPoolsStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
     * project. If `show_deleted` is set to `true`, then deleted pools are also
     * listed.
     * </pre>
     */
    public void listWorkloadIdentityPools(com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadIdentityPoolsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public void getWorkloadIdentityPool(com.google.iam.v1beta.GetWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPool> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadIdentityPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted pool until 30 days after deletion.
     * </pre>
     */
    public void createWorkloadIdentityPool(com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkloadIdentityPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public void updateWorkloadIdentityPool(com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkloadIdentityPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot use a deleted pool to exchange external
     * credentials for Google Cloud credentials. However, deletion does
     * not revoke credentials that have already been issued.
     * Credentials issued for a deleted pool do not grant access to resources.
     * If the pool is undeleted, and the credentials are not expired, they
     * grant access again.
     * You can undelete a pool for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted pools. However, you can view and list them.
     * </pre>
     */
    public void deleteWorkloadIdentityPool(com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkloadIdentityPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public void undeleteWorkloadIdentityPool(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteWorkloadIdentityPoolMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * If `show_deleted` is set to `true`, then deleted providers are also listed.
     * </pre>
     */
    public void listWorkloadIdentityPoolProviders(com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListWorkloadIdentityPoolProvidersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
     * </pre>
     */
    public void getWorkloadIdentityPoolProvider(com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPoolProvider> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetWorkloadIdentityPoolProviderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted provider until 30 days after
     * deletion.
     * </pre>
     */
    public void createWorkloadIdentityPoolProvider(com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateWorkloadIdentityPoolProviderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * </pre>
     */
    public void updateWorkloadIdentityPoolProvider(com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateWorkloadIdentityPoolProviderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * Deleting a provider does not revoke credentials that have already been
     * issued; they continue to grant access.
     * You can undelete a provider for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted providers. However, you can view and list them.
     * </pre>
     */
    public void deleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteWorkloadIdentityPoolProviderMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Undeletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public void undeleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeleteWorkloadIdentityPoolProviderMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkloadIdentityPools.
   * <pre>
   * Manages WorkloadIdentityPools.
   * </pre>
   */
  public static final class WorkloadIdentityPoolsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkloadIdentityPoolsBlockingStub> {
    private WorkloadIdentityPoolsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityPoolsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityPoolsBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
     * project. If `show_deleted` is set to `true`, then deleted pools are also
     * listed.
     * </pre>
     */
    public com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse listWorkloadIdentityPools(com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadIdentityPoolsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public com.google.iam.v1beta.WorkloadIdentityPool getWorkloadIdentityPool(com.google.iam.v1beta.GetWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadIdentityPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted pool until 30 days after deletion.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkloadIdentityPool(com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkloadIdentityPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkloadIdentityPool(com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkloadIdentityPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot use a deleted pool to exchange external
     * credentials for Google Cloud credentials. However, deletion does
     * not revoke credentials that have already been issued.
     * Credentials issued for a deleted pool do not grant access to resources.
     * If the pool is undeleted, and the credentials are not expired, they
     * grant access again.
     * You can undelete a pool for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted pools. However, you can view and list them.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkloadIdentityPool(com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkloadIdentityPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteWorkloadIdentityPool(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteWorkloadIdentityPoolMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * If `show_deleted` is set to `true`, then deleted providers are also listed.
     * </pre>
     */
    public com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse listWorkloadIdentityPoolProviders(com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListWorkloadIdentityPoolProvidersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
     * </pre>
     */
    public com.google.iam.v1beta.WorkloadIdentityPoolProvider getWorkloadIdentityPoolProvider(com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetWorkloadIdentityPoolProviderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted provider until 30 days after
     * deletion.
     * </pre>
     */
    public com.google.longrunning.Operation createWorkloadIdentityPoolProvider(com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateWorkloadIdentityPoolProviderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * </pre>
     */
    public com.google.longrunning.Operation updateWorkloadIdentityPoolProvider(com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateWorkloadIdentityPoolProviderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * Deleting a provider does not revoke credentials that have already been
     * issued; they continue to grant access.
     * You can undelete a provider for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted providers. However, you can view and list them.
     * </pre>
     */
    public com.google.longrunning.Operation deleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteWorkloadIdentityPoolProviderMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Undeletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public com.google.longrunning.Operation undeleteWorkloadIdentityPoolProvider(com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeleteWorkloadIdentityPoolProviderMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkloadIdentityPools.
   * <pre>
   * Manages WorkloadIdentityPools.
   * </pre>
   */
  public static final class WorkloadIdentityPoolsFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkloadIdentityPoolsFutureStub> {
    private WorkloadIdentityPoolsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkloadIdentityPoolsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkloadIdentityPoolsFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool]s in a
     * project. If `show_deleted` is set to `true`, then deleted pools are also
     * listed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse> listWorkloadIdentityPools(
        com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadIdentityPoolsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1beta.WorkloadIdentityPool> getWorkloadIdentityPool(
        com.google.iam.v1beta.GetWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadIdentityPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted pool until 30 days after deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createWorkloadIdentityPool(
        com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkloadIdentityPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateWorkloadIdentityPool(
        com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkloadIdentityPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot use a deleted pool to exchange external
     * credentials for Google Cloud credentials. However, deletion does
     * not revoke credentials that have already been issued.
     * Credentials issued for a deleted pool do not grant access to resources.
     * If the pool is undeleted, and the credentials are not expired, they
     * grant access again.
     * You can undelete a pool for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted pools. However, you can view and list them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteWorkloadIdentityPool(
        com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkloadIdentityPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Undeletes a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeleteWorkloadIdentityPool(
        com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteWorkloadIdentityPoolMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Lists all non-deleted
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider]s
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * If `show_deleted` is set to `true`, then deleted providers are also listed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse> listWorkloadIdentityPoolProviders(
        com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListWorkloadIdentityPoolProvidersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Gets an individual
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityPoolProvider].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1beta.WorkloadIdentityPoolProvider> getWorkloadIdentityPoolProvider(
        com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetWorkloadIdentityPoolProviderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Creates a new
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider]
     * in a [WorkloadIdentityPool][google.iam.v1beta.WorkloadIdentityPool].
     * You cannot reuse the name of a deleted provider until 30 days after
     * deletion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> createWorkloadIdentityPoolProvider(
        com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateWorkloadIdentityPoolProviderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Updates an existing
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> updateWorkloadIdentityPoolProvider(
        com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateWorkloadIdentityPoolProviderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Deletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider].
     * Deleting a provider does not revoke credentials that have already been
     * issued; they continue to grant access.
     * You can undelete a provider for 30 days. After 30 days, deletion is
     * permanent.
     * You cannot update deleted providers. However, you can view and list them.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> deleteWorkloadIdentityPoolProvider(
        com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteWorkloadIdentityPoolProviderMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Undeletes a
     * [WorkloadIdentityPoolProvider][google.iam.v1beta.WorkloadIdentityProvider],
     * as long as it was deleted fewer than 30 days ago.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation> undeleteWorkloadIdentityPoolProvider(
        com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeleteWorkloadIdentityPoolProviderMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_WORKLOAD_IDENTITY_POOLS = 0;
  private static final int METHODID_GET_WORKLOAD_IDENTITY_POOL = 1;
  private static final int METHODID_CREATE_WORKLOAD_IDENTITY_POOL = 2;
  private static final int METHODID_UPDATE_WORKLOAD_IDENTITY_POOL = 3;
  private static final int METHODID_DELETE_WORKLOAD_IDENTITY_POOL = 4;
  private static final int METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL = 5;
  private static final int METHODID_LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS = 6;
  private static final int METHODID_GET_WORKLOAD_IDENTITY_POOL_PROVIDER = 7;
  private static final int METHODID_CREATE_WORKLOAD_IDENTITY_POOL_PROVIDER = 8;
  private static final int METHODID_UPDATE_WORKLOAD_IDENTITY_POOL_PROVIDER = 9;
  private static final int METHODID_DELETE_WORKLOAD_IDENTITY_POOL_PROVIDER = 10;
  private static final int METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL_PROVIDER = 11;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
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
        case METHODID_LIST_WORKLOAD_IDENTITY_POOLS:
          serviceImpl.listWorkloadIdentityPools((com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse>) responseObserver);
          break;
        case METHODID_GET_WORKLOAD_IDENTITY_POOL:
          serviceImpl.getWorkloadIdentityPool((com.google.iam.v1beta.GetWorkloadIdentityPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPool>) responseObserver);
          break;
        case METHODID_CREATE_WORKLOAD_IDENTITY_POOL:
          serviceImpl.createWorkloadIdentityPool((com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKLOAD_IDENTITY_POOL:
          serviceImpl.updateWorkloadIdentityPool((com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKLOAD_IDENTITY_POOL:
          serviceImpl.deleteWorkloadIdentityPool((com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL:
          serviceImpl.undeleteWorkloadIdentityPool((com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS:
          serviceImpl.listWorkloadIdentityPoolProviders((com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse>) responseObserver);
          break;
        case METHODID_GET_WORKLOAD_IDENTITY_POOL_PROVIDER:
          serviceImpl.getWorkloadIdentityPoolProvider((com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.iam.v1beta.WorkloadIdentityPoolProvider>) responseObserver);
          break;
        case METHODID_CREATE_WORKLOAD_IDENTITY_POOL_PROVIDER:
          serviceImpl.createWorkloadIdentityPoolProvider((com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_WORKLOAD_IDENTITY_POOL_PROVIDER:
          serviceImpl.updateWorkloadIdentityPoolProvider((com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_WORKLOAD_IDENTITY_POOL_PROVIDER:
          serviceImpl.deleteWorkloadIdentityPoolProvider((com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL_PROVIDER:
          serviceImpl.undeleteWorkloadIdentityPoolProvider((com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest) request,
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
          getListWorkloadIdentityPoolsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.ListWorkloadIdentityPoolsRequest,
              com.google.iam.v1beta.ListWorkloadIdentityPoolsResponse>(
                service, METHODID_LIST_WORKLOAD_IDENTITY_POOLS)))
        .addMethod(
          getGetWorkloadIdentityPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.GetWorkloadIdentityPoolRequest,
              com.google.iam.v1beta.WorkloadIdentityPool>(
                service, METHODID_GET_WORKLOAD_IDENTITY_POOL)))
        .addMethod(
          getCreateWorkloadIdentityPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.CreateWorkloadIdentityPoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_WORKLOAD_IDENTITY_POOL)))
        .addMethod(
          getUpdateWorkloadIdentityPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.UpdateWorkloadIdentityPoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_WORKLOAD_IDENTITY_POOL)))
        .addMethod(
          getDeleteWorkloadIdentityPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.DeleteWorkloadIdentityPoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_WORKLOAD_IDENTITY_POOL)))
        .addMethod(
          getUndeleteWorkloadIdentityPoolMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.UndeleteWorkloadIdentityPoolRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL)))
        .addMethod(
          getListWorkloadIdentityPoolProvidersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersRequest,
              com.google.iam.v1beta.ListWorkloadIdentityPoolProvidersResponse>(
                service, METHODID_LIST_WORKLOAD_IDENTITY_POOL_PROVIDERS)))
        .addMethod(
          getGetWorkloadIdentityPoolProviderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.GetWorkloadIdentityPoolProviderRequest,
              com.google.iam.v1beta.WorkloadIdentityPoolProvider>(
                service, METHODID_GET_WORKLOAD_IDENTITY_POOL_PROVIDER)))
        .addMethod(
          getCreateWorkloadIdentityPoolProviderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.CreateWorkloadIdentityPoolProviderRequest,
              com.google.longrunning.Operation>(
                service, METHODID_CREATE_WORKLOAD_IDENTITY_POOL_PROVIDER)))
        .addMethod(
          getUpdateWorkloadIdentityPoolProviderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.UpdateWorkloadIdentityPoolProviderRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UPDATE_WORKLOAD_IDENTITY_POOL_PROVIDER)))
        .addMethod(
          getDeleteWorkloadIdentityPoolProviderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.DeleteWorkloadIdentityPoolProviderRequest,
              com.google.longrunning.Operation>(
                service, METHODID_DELETE_WORKLOAD_IDENTITY_POOL_PROVIDER)))
        .addMethod(
          getUndeleteWorkloadIdentityPoolProviderMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.iam.v1beta.UndeleteWorkloadIdentityPoolProviderRequest,
              com.google.longrunning.Operation>(
                service, METHODID_UNDELETE_WORKLOAD_IDENTITY_POOL_PROVIDER)))
        .build();
  }

  private static abstract class WorkloadIdentityPoolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkloadIdentityPoolsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.iam.v1beta.WorkloadIdentityPoolProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkloadIdentityPools");
    }
  }

  private static final class WorkloadIdentityPoolsFileDescriptorSupplier
      extends WorkloadIdentityPoolsBaseDescriptorSupplier {
    WorkloadIdentityPoolsFileDescriptorSupplier() {}
  }

  private static final class WorkloadIdentityPoolsMethodDescriptorSupplier
      extends WorkloadIdentityPoolsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkloadIdentityPoolsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WorkloadIdentityPoolsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkloadIdentityPoolsFileDescriptorSupplier())
              .addMethod(getListWorkloadIdentityPoolsMethod())
              .addMethod(getGetWorkloadIdentityPoolMethod())
              .addMethod(getCreateWorkloadIdentityPoolMethod())
              .addMethod(getUpdateWorkloadIdentityPoolMethod())
              .addMethod(getDeleteWorkloadIdentityPoolMethod())
              .addMethod(getUndeleteWorkloadIdentityPoolMethod())
              .addMethod(getListWorkloadIdentityPoolProvidersMethod())
              .addMethod(getGetWorkloadIdentityPoolProviderMethod())
              .addMethod(getCreateWorkloadIdentityPoolProviderMethod())
              .addMethod(getUpdateWorkloadIdentityPoolProviderMethod())
              .addMethod(getDeleteWorkloadIdentityPoolProviderMethod())
              .addMethod(getUndeleteWorkloadIdentityPoolProviderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
