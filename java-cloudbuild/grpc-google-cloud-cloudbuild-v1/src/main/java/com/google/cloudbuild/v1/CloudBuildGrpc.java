/*
 * Copyright 2019 Google LLC
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
package com.google.cloudbuild.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 *
 *
 * <pre>
 * Creates and manages builds on Google Cloud Platform.
 * The main concept used by this API is a `Build`, which describes the location
 * of the source to build, how to build the source, and where to store the
 * built artifacts, if any.
 * A user can list previously-requested builds or get builds by their ID to
 * determine the status of the build.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/devtools/cloudbuild/v1/cloudbuild.proto")
public final class CloudBuildGrpc {

  private CloudBuildGrpc() {}

  public static final String SERVICE_NAME = "google.devtools.cloudbuild.v1.CloudBuild";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateBuildMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>
      METHOD_CREATE_BUILD = getCreateBuildMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>
      getCreateBuildMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>
      getCreateBuildMethod() {
    return getCreateBuildMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>
      getCreateBuildMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.CreateBuildRequest, com.google.longrunning.Operation>
        getCreateBuildMethod;
    if ((getCreateBuildMethod = CloudBuildGrpc.getCreateBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateBuildMethod = CloudBuildGrpc.getCreateBuildMethod) == null) {
          CloudBuildGrpc.getCreateBuildMethod =
              getCreateBuildMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.CreateBuildRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "CreateBuild"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.CreateBuildRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CreateBuild"))
                      .build();
        }
      }
    }
    return getCreateBuildMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBuildMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
      METHOD_GET_BUILD = getGetBuildMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
      getGetBuildMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
      getGetBuildMethod() {
    return getGetBuildMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
      getGetBuildMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
        getGetBuildMethod;
    if ((getGetBuildMethod = CloudBuildGrpc.getGetBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetBuildMethod = CloudBuildGrpc.getGetBuildMethod) == null) {
          CloudBuildGrpc.getGetBuildMethod =
              getGetBuildMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "GetBuild"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.GetBuildRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.Build.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("GetBuild"))
                      .build();
        }
      }
    }
    return getGetBuildMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListBuildsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>
      METHOD_LIST_BUILDS = getListBuildsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>
      getListBuildsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>
      getListBuildsMethod() {
    return getListBuildsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>
      getListBuildsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.ListBuildsRequest, com.google.cloudbuild.v1.ListBuildsResponse>
        getListBuildsMethod;
    if ((getListBuildsMethod = CloudBuildGrpc.getListBuildsMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListBuildsMethod = CloudBuildGrpc.getListBuildsMethod) == null) {
          CloudBuildGrpc.getListBuildsMethod =
              getListBuildsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.ListBuildsRequest,
                          com.google.cloudbuild.v1.ListBuildsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "ListBuilds"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListBuildsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListBuildsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("ListBuilds"))
                      .build();
        }
      }
    }
    return getListBuildsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCancelBuildMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
      METHOD_CANCEL_BUILD = getCancelBuildMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
      getCancelBuildMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
      getCancelBuildMethod() {
    return getCancelBuildMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
      getCancelBuildMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
        getCancelBuildMethod;
    if ((getCancelBuildMethod = CloudBuildGrpc.getCancelBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCancelBuildMethod = CloudBuildGrpc.getCancelBuildMethod) == null) {
          CloudBuildGrpc.getCancelBuildMethod =
              getCancelBuildMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "CancelBuild"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.CancelBuildRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.Build.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("CancelBuild"))
                      .build();
        }
      }
    }
    return getCancelBuildMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRetryBuildMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>
      METHOD_RETRY_BUILD = getRetryBuildMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>
      getRetryBuildMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>
      getRetryBuildMethod() {
    return getRetryBuildMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>
      getRetryBuildMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>
        getRetryBuildMethod;
    if ((getRetryBuildMethod = CloudBuildGrpc.getRetryBuildMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getRetryBuildMethod = CloudBuildGrpc.getRetryBuildMethod) == null) {
          CloudBuildGrpc.getRetryBuildMethod =
              getRetryBuildMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.RetryBuildRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "RetryBuild"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.RetryBuildRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("RetryBuild"))
                      .build();
        }
      }
    }
    return getRetryBuildMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateBuildTriggerMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      METHOD_CREATE_BUILD_TRIGGER = getCreateBuildTriggerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getCreateBuildTriggerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getCreateBuildTriggerMethod() {
    return getCreateBuildTriggerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getCreateBuildTriggerMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.CreateBuildTriggerRequest,
            com.google.cloudbuild.v1.BuildTrigger>
        getCreateBuildTriggerMethod;
    if ((getCreateBuildTriggerMethod = CloudBuildGrpc.getCreateBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateBuildTriggerMethod = CloudBuildGrpc.getCreateBuildTriggerMethod) == null) {
          CloudBuildGrpc.getCreateBuildTriggerMethod =
              getCreateBuildTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.CreateBuildTriggerRequest,
                          com.google.cloudbuild.v1.BuildTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "CreateBuildTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.CreateBuildTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("CreateBuildTrigger"))
                      .build();
        }
      }
    }
    return getCreateBuildTriggerMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetBuildTriggerMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      METHOD_GET_BUILD_TRIGGER = getGetBuildTriggerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getGetBuildTriggerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getGetBuildTriggerMethod() {
    return getGetBuildTriggerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getGetBuildTriggerMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.GetBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
        getGetBuildTriggerMethod;
    if ((getGetBuildTriggerMethod = CloudBuildGrpc.getGetBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetBuildTriggerMethod = CloudBuildGrpc.getGetBuildTriggerMethod) == null) {
          CloudBuildGrpc.getGetBuildTriggerMethod =
              getGetBuildTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.GetBuildTriggerRequest,
                          com.google.cloudbuild.v1.BuildTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "GetBuildTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.GetBuildTriggerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("GetBuildTrigger"))
                      .build();
        }
      }
    }
    return getGetBuildTriggerMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListBuildTriggersMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildTriggersRequest,
          com.google.cloudbuild.v1.ListBuildTriggersResponse>
      METHOD_LIST_BUILD_TRIGGERS = getListBuildTriggersMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildTriggersRequest,
          com.google.cloudbuild.v1.ListBuildTriggersResponse>
      getListBuildTriggersMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildTriggersRequest,
          com.google.cloudbuild.v1.ListBuildTriggersResponse>
      getListBuildTriggersMethod() {
    return getListBuildTriggersMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListBuildTriggersRequest,
          com.google.cloudbuild.v1.ListBuildTriggersResponse>
      getListBuildTriggersMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.ListBuildTriggersRequest,
            com.google.cloudbuild.v1.ListBuildTriggersResponse>
        getListBuildTriggersMethod;
    if ((getListBuildTriggersMethod = CloudBuildGrpc.getListBuildTriggersMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListBuildTriggersMethod = CloudBuildGrpc.getListBuildTriggersMethod) == null) {
          CloudBuildGrpc.getListBuildTriggersMethod =
              getListBuildTriggersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.ListBuildTriggersRequest,
                          com.google.cloudbuild.v1.ListBuildTriggersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "ListBuildTriggers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListBuildTriggersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListBuildTriggersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("ListBuildTriggers"))
                      .build();
        }
      }
    }
    return getListBuildTriggersMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteBuildTriggerMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>
      METHOD_DELETE_BUILD_TRIGGER = getDeleteBuildTriggerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>
      getDeleteBuildTriggerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>
      getDeleteBuildTriggerMethod() {
    return getDeleteBuildTriggerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>
      getDeleteBuildTriggerMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.DeleteBuildTriggerRequest, com.google.protobuf.Empty>
        getDeleteBuildTriggerMethod;
    if ((getDeleteBuildTriggerMethod = CloudBuildGrpc.getDeleteBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getDeleteBuildTriggerMethod = CloudBuildGrpc.getDeleteBuildTriggerMethod) == null) {
          CloudBuildGrpc.getDeleteBuildTriggerMethod =
              getDeleteBuildTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.DeleteBuildTriggerRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "DeleteBuildTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.DeleteBuildTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("DeleteBuildTrigger"))
                      .build();
        }
      }
    }
    return getDeleteBuildTriggerMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateBuildTriggerMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      METHOD_UPDATE_BUILD_TRIGGER = getUpdateBuildTriggerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getUpdateBuildTriggerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getUpdateBuildTriggerMethod() {
    return getUpdateBuildTriggerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateBuildTriggerRequest, com.google.cloudbuild.v1.BuildTrigger>
      getUpdateBuildTriggerMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
            com.google.cloudbuild.v1.BuildTrigger>
        getUpdateBuildTriggerMethod;
    if ((getUpdateBuildTriggerMethod = CloudBuildGrpc.getUpdateBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getUpdateBuildTriggerMethod = CloudBuildGrpc.getUpdateBuildTriggerMethod) == null) {
          CloudBuildGrpc.getUpdateBuildTriggerMethod =
              getUpdateBuildTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
                          com.google.cloudbuild.v1.BuildTrigger>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "UpdateBuildTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.UpdateBuildTriggerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.BuildTrigger.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("UpdateBuildTrigger"))
                      .build();
        }
      }
    }
    return getUpdateBuildTriggerMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getRunBuildTriggerMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>
      METHOD_RUN_BUILD_TRIGGER = getRunBuildTriggerMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>
      getRunBuildTriggerMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>
      getRunBuildTriggerMethod() {
    return getRunBuildTriggerMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>
      getRunBuildTriggerMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.RunBuildTriggerRequest, com.google.longrunning.Operation>
        getRunBuildTriggerMethod;
    if ((getRunBuildTriggerMethod = CloudBuildGrpc.getRunBuildTriggerMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getRunBuildTriggerMethod = CloudBuildGrpc.getRunBuildTriggerMethod) == null) {
          CloudBuildGrpc.getRunBuildTriggerMethod =
              getRunBuildTriggerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.RunBuildTriggerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "RunBuildTrigger"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.RunBuildTriggerRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("RunBuildTrigger"))
                      .build();
        }
      }
    }
    return getRunBuildTriggerMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateWorkerPoolMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      METHOD_CREATE_WORKER_POOL = getCreateWorkerPoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getCreateWorkerPoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getCreateWorkerPoolMethod() {
    return getCreateWorkerPoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getCreateWorkerPoolMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.CreateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
        getCreateWorkerPoolMethod;
    if ((getCreateWorkerPoolMethod = CloudBuildGrpc.getCreateWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getCreateWorkerPoolMethod = CloudBuildGrpc.getCreateWorkerPoolMethod) == null) {
          CloudBuildGrpc.getCreateWorkerPoolMethod =
              getCreateWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.CreateWorkerPoolRequest,
                          com.google.cloudbuild.v1.WorkerPool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "CreateWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.CreateWorkerPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.WorkerPool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("CreateWorkerPool"))
                      .build();
        }
      }
    }
    return getCreateWorkerPoolMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetWorkerPoolMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      METHOD_GET_WORKER_POOL = getGetWorkerPoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getGetWorkerPoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getGetWorkerPoolMethod() {
    return getGetWorkerPoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getGetWorkerPoolMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.GetWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
        getGetWorkerPoolMethod;
    if ((getGetWorkerPoolMethod = CloudBuildGrpc.getGetWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getGetWorkerPoolMethod = CloudBuildGrpc.getGetWorkerPoolMethod) == null) {
          CloudBuildGrpc.getGetWorkerPoolMethod =
              getGetWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.GetWorkerPoolRequest,
                          com.google.cloudbuild.v1.WorkerPool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "GetWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.GetWorkerPoolRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.WorkerPool.getDefaultInstance()))
                      .setSchemaDescriptor(new CloudBuildMethodDescriptorSupplier("GetWorkerPool"))
                      .build();
        }
      }
    }
    return getGetWorkerPoolMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteWorkerPoolMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
      METHOD_DELETE_WORKER_POOL = getDeleteWorkerPoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
      getDeleteWorkerPoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
      getDeleteWorkerPoolMethod() {
    return getDeleteWorkerPoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
      getDeleteWorkerPoolMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
        getDeleteWorkerPoolMethod;
    if ((getDeleteWorkerPoolMethod = CloudBuildGrpc.getDeleteWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getDeleteWorkerPoolMethod = CloudBuildGrpc.getDeleteWorkerPoolMethod) == null) {
          CloudBuildGrpc.getDeleteWorkerPoolMethod =
              getDeleteWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "DeleteWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.DeleteWorkerPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("DeleteWorkerPool"))
                      .build();
        }
      }
    }
    return getDeleteWorkerPoolMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateWorkerPoolMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      METHOD_UPDATE_WORKER_POOL = getUpdateWorkerPoolMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getUpdateWorkerPoolMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getUpdateWorkerPoolMethod() {
    return getUpdateWorkerPoolMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
      getUpdateWorkerPoolMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.UpdateWorkerPoolRequest, com.google.cloudbuild.v1.WorkerPool>
        getUpdateWorkerPoolMethod;
    if ((getUpdateWorkerPoolMethod = CloudBuildGrpc.getUpdateWorkerPoolMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getUpdateWorkerPoolMethod = CloudBuildGrpc.getUpdateWorkerPoolMethod) == null) {
          CloudBuildGrpc.getUpdateWorkerPoolMethod =
              getUpdateWorkerPoolMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.UpdateWorkerPoolRequest,
                          com.google.cloudbuild.v1.WorkerPool>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "UpdateWorkerPool"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.UpdateWorkerPoolRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.WorkerPool.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("UpdateWorkerPool"))
                      .build();
        }
      }
    }
    return getUpdateWorkerPoolMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListWorkerPoolsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListWorkerPoolsRequest,
          com.google.cloudbuild.v1.ListWorkerPoolsResponse>
      METHOD_LIST_WORKER_POOLS = getListWorkerPoolsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListWorkerPoolsRequest,
          com.google.cloudbuild.v1.ListWorkerPoolsResponse>
      getListWorkerPoolsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListWorkerPoolsRequest,
          com.google.cloudbuild.v1.ListWorkerPoolsResponse>
      getListWorkerPoolsMethod() {
    return getListWorkerPoolsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloudbuild.v1.ListWorkerPoolsRequest,
          com.google.cloudbuild.v1.ListWorkerPoolsResponse>
      getListWorkerPoolsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloudbuild.v1.ListWorkerPoolsRequest,
            com.google.cloudbuild.v1.ListWorkerPoolsResponse>
        getListWorkerPoolsMethod;
    if ((getListWorkerPoolsMethod = CloudBuildGrpc.getListWorkerPoolsMethod) == null) {
      synchronized (CloudBuildGrpc.class) {
        if ((getListWorkerPoolsMethod = CloudBuildGrpc.getListWorkerPoolsMethod) == null) {
          CloudBuildGrpc.getListWorkerPoolsMethod =
              getListWorkerPoolsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloudbuild.v1.ListWorkerPoolsRequest,
                          com.google.cloudbuild.v1.ListWorkerPoolsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.devtools.cloudbuild.v1.CloudBuild", "ListWorkerPools"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListWorkerPoolsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloudbuild.v1.ListWorkerPoolsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CloudBuildMethodDescriptorSupplier("ListWorkerPools"))
                      .build();
        }
      }
    }
    return getListWorkerPoolsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CloudBuildStub newStub(io.grpc.Channel channel) {
    return new CloudBuildStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CloudBuildBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new CloudBuildBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CloudBuildFutureStub newFutureStub(io.grpc.Channel channel) {
    return new CloudBuildFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public abstract static class CloudBuildImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public void createBuild(
        com.google.cloudbuild.v1.CreateBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBuildMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public void getBuild(
        com.google.cloudbuild.v1.GetBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBuildMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public void listBuilds(
        com.google.cloudbuild.v1.ListBuildsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getListBuildsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public void cancelBuild(
        com.google.cloudbuild.v1.CancelBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      asyncUnimplementedUnaryCall(getCancelBuildMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public void retryBuild(
        com.google.cloudbuild.v1.RetryBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRetryBuildMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void createBuildTrigger(
        com.google.cloudbuild.v1.CreateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateBuildTriggerMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void getBuildTrigger(
        com.google.cloudbuild.v1.GetBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBuildTriggerMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public void listBuildTriggers(
        com.google.cloudbuild.v1.ListBuildTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListBuildTriggersMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void deleteBuildTrigger(
        com.google.cloudbuild.v1.DeleteBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteBuildTriggerMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void updateBuildTrigger(
        com.google.cloudbuild.v1.UpdateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateBuildTriggerMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public void runBuildTrigger(
        com.google.cloudbuild.v1.RunBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnimplementedUnaryCall(getRunBuildTriggerMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
     * This API is experimental.
     * </pre>
     */
    public void createWorkerPool(
        com.google.cloudbuild.v1.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateWorkerPoolMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public void getWorkerPool(
        com.google.cloudbuild.v1.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnimplementedUnaryCall(getGetWorkerPoolMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `WorkerPool` by its project ID and WorkerPool name.
     * This API is experimental.
     * </pre>
     */
    public void deleteWorkerPool(
        com.google.cloudbuild.v1.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteWorkerPoolMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public void updateWorkerPool(
        com.google.cloudbuild.v1.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateWorkerPoolMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List project's `WorkerPool`s.
     * This API is experimental.
     * </pre>
     */
    public void listWorkerPools(
        com.google.cloudbuild.v1.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListWorkerPoolsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateBuildMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.CreateBuildRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_BUILD)))
          .addMethod(
              getGetBuildMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.GetBuildRequest, com.google.cloudbuild.v1.Build>(
                      this, METHODID_GET_BUILD)))
          .addMethod(
              getListBuildsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.ListBuildsRequest,
                      com.google.cloudbuild.v1.ListBuildsResponse>(this, METHODID_LIST_BUILDS)))
          .addMethod(
              getCancelBuildMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.CancelBuildRequest, com.google.cloudbuild.v1.Build>(
                      this, METHODID_CANCEL_BUILD)))
          .addMethod(
              getRetryBuildMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.RetryBuildRequest, com.google.longrunning.Operation>(
                      this, METHODID_RETRY_BUILD)))
          .addMethod(
              getCreateBuildTriggerMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.CreateBuildTriggerRequest,
                      com.google.cloudbuild.v1.BuildTrigger>(this, METHODID_CREATE_BUILD_TRIGGER)))
          .addMethod(
              getGetBuildTriggerMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.GetBuildTriggerRequest,
                      com.google.cloudbuild.v1.BuildTrigger>(this, METHODID_GET_BUILD_TRIGGER)))
          .addMethod(
              getListBuildTriggersMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.ListBuildTriggersRequest,
                      com.google.cloudbuild.v1.ListBuildTriggersResponse>(
                      this, METHODID_LIST_BUILD_TRIGGERS)))
          .addMethod(
              getDeleteBuildTriggerMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.DeleteBuildTriggerRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_BUILD_TRIGGER)))
          .addMethod(
              getUpdateBuildTriggerMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.UpdateBuildTriggerRequest,
                      com.google.cloudbuild.v1.BuildTrigger>(this, METHODID_UPDATE_BUILD_TRIGGER)))
          .addMethod(
              getRunBuildTriggerMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.RunBuildTriggerRequest,
                      com.google.longrunning.Operation>(this, METHODID_RUN_BUILD_TRIGGER)))
          .addMethod(
              getCreateWorkerPoolMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.CreateWorkerPoolRequest,
                      com.google.cloudbuild.v1.WorkerPool>(this, METHODID_CREATE_WORKER_POOL)))
          .addMethod(
              getGetWorkerPoolMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.GetWorkerPoolRequest,
                      com.google.cloudbuild.v1.WorkerPool>(this, METHODID_GET_WORKER_POOL)))
          .addMethod(
              getDeleteWorkerPoolMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.DeleteWorkerPoolRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_WORKER_POOL)))
          .addMethod(
              getUpdateWorkerPoolMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.UpdateWorkerPoolRequest,
                      com.google.cloudbuild.v1.WorkerPool>(this, METHODID_UPDATE_WORKER_POOL)))
          .addMethod(
              getListWorkerPoolsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloudbuild.v1.ListWorkerPoolsRequest,
                      com.google.cloudbuild.v1.ListWorkerPoolsResponse>(
                      this, METHODID_LIST_WORKER_POOLS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildStub extends io.grpc.stub.AbstractStub<CloudBuildStub> {
    private CloudBuildStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudBuildStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public void createBuild(
        com.google.cloudbuild.v1.CreateBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBuildMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public void getBuild(
        com.google.cloudbuild.v1.GetBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBuildMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public void listBuilds(
        com.google.cloudbuild.v1.ListBuildsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListBuildsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public void cancelBuild(
        com.google.cloudbuild.v1.CancelBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCancelBuildMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public void retryBuild(
        com.google.cloudbuild.v1.RetryBuildRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRetryBuildMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void createBuildTrigger(
        com.google.cloudbuild.v1.CreateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateBuildTriggerMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public void getBuildTrigger(
        com.google.cloudbuild.v1.GetBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBuildTriggerMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public void listBuildTriggers(
        com.google.cloudbuild.v1.ListBuildTriggersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListBuildTriggersMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void deleteBuildTrigger(
        com.google.cloudbuild.v1.DeleteBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteBuildTriggerMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public void updateBuildTrigger(
        com.google.cloudbuild.v1.UpdateBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateBuildTriggerMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public void runBuildTrigger(
        com.google.cloudbuild.v1.RunBuildTriggerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRunBuildTriggerMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
     * This API is experimental.
     * </pre>
     */
    public void createWorkerPool(
        com.google.cloudbuild.v1.CreateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public void getWorkerPool(
        com.google.cloudbuild.v1.GetWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `WorkerPool` by its project ID and WorkerPool name.
     * This API is experimental.
     * </pre>
     */
    public void deleteWorkerPool(
        com.google.cloudbuild.v1.DeleteWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public void updateWorkerPool(
        com.google.cloudbuild.v1.UpdateWorkerPoolRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List project's `WorkerPool`s.
     * This API is experimental.
     * </pre>
     */
    public void listWorkerPools(
        com.google.cloudbuild.v1.ListWorkerPoolsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildBlockingStub
      extends io.grpc.stub.AbstractStub<CloudBuildBlockingStub> {
    private CloudBuildBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudBuildBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public com.google.longrunning.Operation createBuild(
        com.google.cloudbuild.v1.CreateBuildRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBuildMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public com.google.cloudbuild.v1.Build getBuild(
        com.google.cloudbuild.v1.GetBuildRequest request) {
      return blockingUnaryCall(getChannel(), getGetBuildMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListBuildsResponse listBuilds(
        com.google.cloudbuild.v1.ListBuildsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListBuildsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public com.google.cloudbuild.v1.Build cancelBuild(
        com.google.cloudbuild.v1.CancelBuildRequest request) {
      return blockingUnaryCall(
          getChannel(), getCancelBuildMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public com.google.longrunning.Operation retryBuild(
        com.google.cloudbuild.v1.RetryBuildRequest request) {
      return blockingUnaryCall(
          getChannel(), getRetryBuildMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger createBuildTrigger(
        com.google.cloudbuild.v1.CreateBuildTriggerRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateBuildTriggerMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger getBuildTrigger(
        com.google.cloudbuild.v1.GetBuildTriggerRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBuildTriggerMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListBuildTriggersResponse listBuildTriggers(
        com.google.cloudbuild.v1.ListBuildTriggersRequest request) {
      return blockingUnaryCall(
          getChannel(), getListBuildTriggersMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.protobuf.Empty deleteBuildTrigger(
        com.google.cloudbuild.v1.DeleteBuildTriggerRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteBuildTriggerMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.BuildTrigger updateBuildTrigger(
        com.google.cloudbuild.v1.UpdateBuildTriggerRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateBuildTriggerMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public com.google.longrunning.Operation runBuildTrigger(
        com.google.cloudbuild.v1.RunBuildTriggerRequest request) {
      return blockingUnaryCall(
          getChannel(), getRunBuildTriggerMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.WorkerPool createWorkerPool(
        com.google.cloudbuild.v1.CreateWorkerPoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateWorkerPoolMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.WorkerPool getWorkerPool(
        com.google.cloudbuild.v1.GetWorkerPoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetWorkerPoolMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `WorkerPool` by its project ID and WorkerPool name.
     * This API is experimental.
     * </pre>
     */
    public com.google.protobuf.Empty deleteWorkerPool(
        com.google.cloudbuild.v1.DeleteWorkerPoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteWorkerPoolMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.WorkerPool updateWorkerPool(
        com.google.cloudbuild.v1.UpdateWorkerPoolRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateWorkerPoolMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List project's `WorkerPool`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.cloudbuild.v1.ListWorkerPoolsResponse listWorkerPools(
        com.google.cloudbuild.v1.ListWorkerPoolsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListWorkerPoolsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Creates and manages builds on Google Cloud Platform.
   * The main concept used by this API is a `Build`, which describes the location
   * of the source to build, how to build the source, and where to store the
   * built artifacts, if any.
   * A user can list previously-requested builds or get builds by their ID to
   * determine the status of the build.
   * </pre>
   */
  public static final class CloudBuildFutureStub
      extends io.grpc.stub.AbstractStub<CloudBuildFutureStub> {
    private CloudBuildFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CloudBuildFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CloudBuildFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CloudBuildFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Starts a build with the specified configuration.
     * This method returns a long-running `Operation`, which includes the build
     * ID. Pass the build ID to `GetBuild` to determine the build status (such as
     * `SUCCESS` or `FAILURE`).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createBuild(com.google.cloudbuild.v1.CreateBuildRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBuildMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a previously requested build.
     * The `Build` that is returned includes its status (such as `SUCCESS`,
     * `FAILURE`, or `WORKING`), and timing information.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.Build>
        getBuild(com.google.cloudbuild.v1.GetBuildRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBuildMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists previously requested builds.
     * Previously requested builds may still be in-progress, or may have finished
     * successfully or unsuccessfully.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloudbuild.v1.ListBuildsResponse>
        listBuilds(com.google.cloudbuild.v1.ListBuildsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListBuildsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Cancels a build in progress.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.Build>
        cancelBuild(com.google.cloudbuild.v1.CancelBuildRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCancelBuildMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new build based on the specified build.
     * This method creates a new build using the original build request, which may
     * or may not result in an identical build.
     * For triggered builds:
     * * Triggered builds resolve to a precise revision; therefore a retry of a
     * triggered build will result in a build that uses the same revision.
     * For non-triggered builds that specify `RepoSource`:
     * * If the original build built from the tip of a branch, the retried build
     * will build from the tip of that branch, which may not be the same revision
     * as the original build.
     * * If the original build specified a commit sha or revision ID, the retried
     * build will use the identical source.
     * For builds that specify `StorageSource`:
     * * If the original build pulled source from Google Cloud Storage without
     * specifying the generation of the object, the new build will use the current
     * object, which may be different from the original build source.
     * * If the original build pulled source from Cloud Storage and specified the
     * generation of the object, the new build will attempt to use the same
     * object, which may or may not be available depending on the bucket's
     * lifecycle management settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        retryBuild(com.google.cloudbuild.v1.RetryBuildRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRetryBuildMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger>
        createBuildTrigger(com.google.cloudbuild.v1.CreateBuildTriggerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateBuildTriggerMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `BuildTrigger`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger>
        getBuildTrigger(com.google.cloudbuild.v1.GetBuildTriggerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBuildTriggerMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists existing `BuildTrigger`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloudbuild.v1.ListBuildTriggersResponse>
        listBuildTriggers(com.google.cloudbuild.v1.ListBuildTriggersRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListBuildTriggersMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteBuildTrigger(com.google.cloudbuild.v1.DeleteBuildTriggerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteBuildTriggerMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a `BuildTrigger` by its project ID and trigger ID.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.BuildTrigger>
        updateBuildTrigger(com.google.cloudbuild.v1.UpdateBuildTriggerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateBuildTriggerMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Runs a `BuildTrigger` at a particular source revision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runBuildTrigger(com.google.cloudbuild.v1.RunBuildTriggerRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRunBuildTriggerMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a `WorkerPool` to run the builds, and returns the new worker pool.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.WorkerPool>
        createWorkerPool(com.google.cloudbuild.v1.CreateWorkerPoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateWorkerPoolMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns information about a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.WorkerPool>
        getWorkerPool(com.google.cloudbuild.v1.GetWorkerPoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetWorkerPoolMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a `WorkerPool` by its project ID and WorkerPool name.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteWorkerPool(com.google.cloudbuild.v1.DeleteWorkerPoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteWorkerPoolMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a `WorkerPool`.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloudbuild.v1.WorkerPool>
        updateWorkerPool(com.google.cloudbuild.v1.UpdateWorkerPoolRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateWorkerPoolMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List project's `WorkerPool`s.
     * This API is experimental.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloudbuild.v1.ListWorkerPoolsResponse>
        listWorkerPools(com.google.cloudbuild.v1.ListWorkerPoolsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListWorkerPoolsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_BUILD = 0;
  private static final int METHODID_GET_BUILD = 1;
  private static final int METHODID_LIST_BUILDS = 2;
  private static final int METHODID_CANCEL_BUILD = 3;
  private static final int METHODID_RETRY_BUILD = 4;
  private static final int METHODID_CREATE_BUILD_TRIGGER = 5;
  private static final int METHODID_GET_BUILD_TRIGGER = 6;
  private static final int METHODID_LIST_BUILD_TRIGGERS = 7;
  private static final int METHODID_DELETE_BUILD_TRIGGER = 8;
  private static final int METHODID_UPDATE_BUILD_TRIGGER = 9;
  private static final int METHODID_RUN_BUILD_TRIGGER = 10;
  private static final int METHODID_CREATE_WORKER_POOL = 11;
  private static final int METHODID_GET_WORKER_POOL = 12;
  private static final int METHODID_DELETE_WORKER_POOL = 13;
  private static final int METHODID_UPDATE_WORKER_POOL = 14;
  private static final int METHODID_LIST_WORKER_POOLS = 15;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CloudBuildImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CloudBuildImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_BUILD:
          serviceImpl.createBuild(
              (com.google.cloudbuild.v1.CreateBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_BUILD:
          serviceImpl.getBuild(
              (com.google.cloudbuild.v1.GetBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build>) responseObserver);
          break;
        case METHODID_LIST_BUILDS:
          serviceImpl.listBuilds(
              (com.google.cloudbuild.v1.ListBuildsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildsResponse>)
                  responseObserver);
          break;
        case METHODID_CANCEL_BUILD:
          serviceImpl.cancelBuild(
              (com.google.cloudbuild.v1.CancelBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.Build>) responseObserver);
          break;
        case METHODID_RETRY_BUILD:
          serviceImpl.retryBuild(
              (com.google.cloudbuild.v1.RetryBuildRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_BUILD_TRIGGER:
          serviceImpl.createBuildTrigger(
              (com.google.cloudbuild.v1.CreateBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>)
                  responseObserver);
          break;
        case METHODID_GET_BUILD_TRIGGER:
          serviceImpl.getBuildTrigger(
              (com.google.cloudbuild.v1.GetBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>)
                  responseObserver);
          break;
        case METHODID_LIST_BUILD_TRIGGERS:
          serviceImpl.listBuildTriggers(
              (com.google.cloudbuild.v1.ListBuildTriggersRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListBuildTriggersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_BUILD_TRIGGER:
          serviceImpl.deleteBuildTrigger(
              (com.google.cloudbuild.v1.DeleteBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_BUILD_TRIGGER:
          serviceImpl.updateBuildTrigger(
              (com.google.cloudbuild.v1.UpdateBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.BuildTrigger>)
                  responseObserver);
          break;
        case METHODID_RUN_BUILD_TRIGGER:
          serviceImpl.runBuildTrigger(
              (com.google.cloudbuild.v1.RunBuildTriggerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_WORKER_POOL:
          serviceImpl.createWorkerPool(
              (com.google.cloudbuild.v1.CreateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool>) responseObserver);
          break;
        case METHODID_GET_WORKER_POOL:
          serviceImpl.getWorkerPool(
              (com.google.cloudbuild.v1.GetWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool>) responseObserver);
          break;
        case METHODID_DELETE_WORKER_POOL:
          serviceImpl.deleteWorkerPool(
              (com.google.cloudbuild.v1.DeleteWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_WORKER_POOL:
          serviceImpl.updateWorkerPool(
              (com.google.cloudbuild.v1.UpdateWorkerPoolRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.WorkerPool>) responseObserver);
          break;
        case METHODID_LIST_WORKER_POOLS:
          serviceImpl.listWorkerPools(
              (com.google.cloudbuild.v1.ListWorkerPoolsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloudbuild.v1.ListWorkerPoolsResponse>)
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

  private abstract static class CloudBuildBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CloudBuildBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloudbuild.v1.Cloudbuild.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CloudBuild");
    }
  }

  private static final class CloudBuildFileDescriptorSupplier
      extends CloudBuildBaseDescriptorSupplier {
    CloudBuildFileDescriptorSupplier() {}
  }

  private static final class CloudBuildMethodDescriptorSupplier
      extends CloudBuildBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CloudBuildMethodDescriptorSupplier(String methodName) {
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
      synchronized (CloudBuildGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CloudBuildFileDescriptorSupplier())
                      .addMethod(getCreateBuildMethodHelper())
                      .addMethod(getGetBuildMethodHelper())
                      .addMethod(getListBuildsMethodHelper())
                      .addMethod(getCancelBuildMethodHelper())
                      .addMethod(getRetryBuildMethodHelper())
                      .addMethod(getCreateBuildTriggerMethodHelper())
                      .addMethod(getGetBuildTriggerMethodHelper())
                      .addMethod(getListBuildTriggersMethodHelper())
                      .addMethod(getDeleteBuildTriggerMethodHelper())
                      .addMethod(getUpdateBuildTriggerMethodHelper())
                      .addMethod(getRunBuildTriggerMethodHelper())
                      .addMethod(getCreateWorkerPoolMethodHelper())
                      .addMethod(getGetWorkerPoolMethodHelper())
                      .addMethod(getDeleteWorkerPoolMethodHelper())
                      .addMethod(getUpdateWorkerPoolMethodHelper())
                      .addMethod(getListWorkerPoolsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
