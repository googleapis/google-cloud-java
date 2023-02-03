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
package com.google.cloud.bigquery.datapolicies.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Data Policy Service provides APIs for managing the label-policy bindings.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/bigquery/datapolicies/v1beta1/datapolicy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataPolicyServiceGrpc {

  private DataPolicyServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.bigquery.datapolicies.v1beta1.DataPolicyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getCreateDataPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataPolicy",
      requestType = com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest.class,
      responseType = com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getCreateDataPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest,
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        getCreateDataPolicyMethod;
    if ((getCreateDataPolicyMethod = DataPolicyServiceGrpc.getCreateDataPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getCreateDataPolicyMethod = DataPolicyServiceGrpc.getCreateDataPolicyMethod) == null) {
          DataPolicyServiceGrpc.getCreateDataPolicyMethod =
              getCreateDataPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest,
                          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPolicyServiceMethodDescriptorSupplier("CreateDataPolicy"))
                      .build();
        }
      }
    }
    return getCreateDataPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getUpdateDataPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataPolicy",
      requestType = com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest.class,
      responseType = com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getUpdateDataPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest,
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        getUpdateDataPolicyMethod;
    if ((getUpdateDataPolicyMethod = DataPolicyServiceGrpc.getUpdateDataPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getUpdateDataPolicyMethod = DataPolicyServiceGrpc.getUpdateDataPolicyMethod) == null) {
          DataPolicyServiceGrpc.getUpdateDataPolicyMethod =
              getUpdateDataPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest,
                          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPolicyServiceMethodDescriptorSupplier("UpdateDataPolicy"))
                      .build();
        }
      }
    }
    return getUpdateDataPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest,
          com.google.protobuf.Empty>
      getDeleteDataPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataPolicy",
      requestType = com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest,
          com.google.protobuf.Empty>
      getDeleteDataPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest,
            com.google.protobuf.Empty>
        getDeleteDataPolicyMethod;
    if ((getDeleteDataPolicyMethod = DataPolicyServiceGrpc.getDeleteDataPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getDeleteDataPolicyMethod = DataPolicyServiceGrpc.getDeleteDataPolicyMethod) == null) {
          DataPolicyServiceGrpc.getDeleteDataPolicyMethod =
              getDeleteDataPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPolicyServiceMethodDescriptorSupplier("DeleteDataPolicy"))
                      .build();
        }
      }
    }
    return getDeleteDataPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getGetDataPolicyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataPolicy",
      requestType = com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest.class,
      responseType = com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
      getGetDataPolicyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest,
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        getGetDataPolicyMethod;
    if ((getGetDataPolicyMethod = DataPolicyServiceGrpc.getGetDataPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getGetDataPolicyMethod = DataPolicyServiceGrpc.getGetDataPolicyMethod) == null) {
          DataPolicyServiceGrpc.getGetDataPolicyMethod =
              getGetDataPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest,
                          com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPolicyServiceMethodDescriptorSupplier("GetDataPolicy"))
                      .build();
        }
      }
    }
    return getGetDataPolicyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
      getListDataPoliciesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataPolicies",
      requestType = com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest.class,
      responseType = com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest,
          com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
      getListDataPoliciesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest,
            com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
        getListDataPoliciesMethod;
    if ((getListDataPoliciesMethod = DataPolicyServiceGrpc.getListDataPoliciesMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getListDataPoliciesMethod = DataPolicyServiceGrpc.getListDataPoliciesMethod) == null) {
          DataPolicyServiceGrpc.getListDataPoliciesMethod =
              getListDataPoliciesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest,
                          com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataPolicies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.bigquery.datapolicies.v1beta1
                                  .ListDataPoliciesResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataPolicyServiceMethodDescriptorSupplier("ListDataPolicies"))
                      .build();
        }
      }
    }
    return getListDataPoliciesMethod;
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
    if ((getGetIamPolicyMethod = DataPolicyServiceGrpc.getGetIamPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getGetIamPolicyMethod = DataPolicyServiceGrpc.getGetIamPolicyMethod) == null) {
          DataPolicyServiceGrpc.getGetIamPolicyMethod =
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
                          new DataPolicyServiceMethodDescriptorSupplier("GetIamPolicy"))
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
    if ((getSetIamPolicyMethod = DataPolicyServiceGrpc.getSetIamPolicyMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getSetIamPolicyMethod = DataPolicyServiceGrpc.getSetIamPolicyMethod) == null) {
          DataPolicyServiceGrpc.getSetIamPolicyMethod =
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
                          new DataPolicyServiceMethodDescriptorSupplier("SetIamPolicy"))
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
    if ((getTestIamPermissionsMethod = DataPolicyServiceGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (DataPolicyServiceGrpc.class) {
        if ((getTestIamPermissionsMethod = DataPolicyServiceGrpc.getTestIamPermissionsMethod)
            == null) {
          DataPolicyServiceGrpc.getTestIamPermissionsMethod =
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
                          new DataPolicyServiceMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataPolicyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceStub>() {
          @java.lang.Override
          public DataPolicyServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPolicyServiceStub(channel, callOptions);
          }
        };
    return DataPolicyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataPolicyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceBlockingStub>() {
          @java.lang.Override
          public DataPolicyServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPolicyServiceBlockingStub(channel, callOptions);
          }
        };
    return DataPolicyServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataPolicyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataPolicyServiceFutureStub>() {
          @java.lang.Override
          public DataPolicyServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataPolicyServiceFutureStub(channel, callOptions);
          }
        };
    return DataPolicyServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Data Policy Service provides APIs for managing the label-policy bindings.
   * </pre>
   */
  public abstract static class DataPolicyServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new data policy under a project with the given `dataPolicyId`
     * (used as the display name), policy tag, and data policy type.
     * </pre>
     */
    public void createDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for an existing data policy. The target data policy
     * can be specified by the resource name.
     * </pre>
     */
    public void updateDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the data policy specified by its resource name.
     * </pre>
     */
    public void deleteDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the data policy specified by its resource name.
     * </pre>
     */
    public void getDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataPolicyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all of the data policies in the specified parent project.
     * </pre>
     */
    public void listDataPolicies(
        com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataPoliciesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for the specified data policy.
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
     * Sets the IAM policy for the specified data policy.
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
     * Returns the caller's permission on the specified data policy resource.
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
              getCreateDataPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest,
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>(
                      this, METHODID_CREATE_DATA_POLICY)))
          .addMethod(
              getUpdateDataPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest,
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>(
                      this, METHODID_UPDATE_DATA_POLICY)))
          .addMethod(
              getDeleteDataPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_DATA_POLICY)))
          .addMethod(
              getGetDataPolicyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest,
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>(
                      this, METHODID_GET_DATA_POLICY)))
          .addMethod(
              getListDataPoliciesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest,
                      com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>(
                      this, METHODID_LIST_DATA_POLICIES)))
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
   * Data Policy Service provides APIs for managing the label-policy bindings.
   * </pre>
   */
  public static final class DataPolicyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataPolicyServiceStub> {
    private DataPolicyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPolicyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPolicyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data policy under a project with the given `dataPolicyId`
     * (used as the display name), policy tag, and data policy type.
     * </pre>
     */
    public void createDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for an existing data policy. The target data policy
     * can be specified by the resource name.
     * </pre>
     */
    public void updateDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the data policy specified by its resource name.
     * </pre>
     */
    public void deleteDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the data policy specified by its resource name.
     * </pre>
     */
    public void getDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataPolicyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all of the data policies in the specified parent project.
     * </pre>
     */
    public void listDataPolicies(
        com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataPoliciesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for the specified data policy.
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
     * Sets the IAM policy for the specified data policy.
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
     * Returns the caller's permission on the specified data policy resource.
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
   * Data Policy Service provides APIs for managing the label-policy bindings.
   * </pre>
   */
  public static final class DataPolicyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataPolicyServiceBlockingStub> {
    private DataPolicyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPolicyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPolicyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data policy under a project with the given `dataPolicyId`
     * (used as the display name), policy tag, and data policy type.
     * </pre>
     */
    public com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy createDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for an existing data policy. The target data policy
     * can be specified by the resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy updateDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the data policy specified by its resource name.
     * </pre>
     */
    public com.google.protobuf.Empty deleteDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the data policy specified by its resource name.
     * </pre>
     */
    public com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy getDataPolicy(
        com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataPolicyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all of the data policies in the specified parent project.
     * </pre>
     */
    public com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse listDataPolicies(
        com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataPoliciesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for the specified data policy.
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
     * Sets the IAM policy for the specified data policy.
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
     * Returns the caller's permission on the specified data policy resource.
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
   * Data Policy Service provides APIs for managing the label-policy bindings.
   * </pre>
   */
  public static final class DataPolicyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataPolicyServiceFutureStub> {
    private DataPolicyServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataPolicyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataPolicyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new data policy under a project with the given `dataPolicyId`
     * (used as the display name), policy tag, and data policy type.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        createDataPolicy(
            com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the metadata for an existing data policy. The target data policy
     * can be specified by the resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        updateDataPolicy(
            com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the data policy specified by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteDataPolicy(
            com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the data policy specified by its resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>
        getDataPolicy(com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataPolicyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all of the data policies in the specified parent project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>
        listDataPolicies(
            com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataPoliciesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for the specified data policy.
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
     * Sets the IAM policy for the specified data policy.
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
     * Returns the caller's permission on the specified data policy resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_POLICY = 0;
  private static final int METHODID_UPDATE_DATA_POLICY = 1;
  private static final int METHODID_DELETE_DATA_POLICY = 2;
  private static final int METHODID_GET_DATA_POLICY = 3;
  private static final int METHODID_LIST_DATA_POLICIES = 4;
  private static final int METHODID_GET_IAM_POLICY = 5;
  private static final int METHODID_SET_IAM_POLICY = 6;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 7;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataPolicyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataPolicyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_DATA_POLICY:
          serviceImpl.createDataPolicy(
              (com.google.cloud.bigquery.datapolicies.v1beta1.CreateDataPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>)
                  responseObserver);
          break;
        case METHODID_UPDATE_DATA_POLICY:
          serviceImpl.updateDataPolicy(
              (com.google.cloud.bigquery.datapolicies.v1beta1.UpdateDataPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>)
                  responseObserver);
          break;
        case METHODID_DELETE_DATA_POLICY:
          serviceImpl.deleteDataPolicy(
              (com.google.cloud.bigquery.datapolicies.v1beta1.DeleteDataPolicyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_DATA_POLICY:
          serviceImpl.getDataPolicy(
              (com.google.cloud.bigquery.datapolicies.v1beta1.GetDataPolicyRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicy>)
                  responseObserver);
          break;
        case METHODID_LIST_DATA_POLICIES:
          serviceImpl.listDataPolicies(
              (com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.bigquery.datapolicies.v1beta1.ListDataPoliciesResponse>)
                  responseObserver);
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

  private abstract static class DataPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataPolicyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.bigquery.datapolicies.v1beta1.DataPolicyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataPolicyService");
    }
  }

  private static final class DataPolicyServiceFileDescriptorSupplier
      extends DataPolicyServiceBaseDescriptorSupplier {
    DataPolicyServiceFileDescriptorSupplier() {}
  }

  private static final class DataPolicyServiceMethodDescriptorSupplier
      extends DataPolicyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataPolicyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataPolicyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataPolicyServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataPolicyMethod())
                      .addMethod(getUpdateDataPolicyMethod())
                      .addMethod(getDeleteDataPolicyMethod())
                      .addMethod(getGetDataPolicyMethod())
                      .addMethod(getListDataPoliciesMethod())
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
