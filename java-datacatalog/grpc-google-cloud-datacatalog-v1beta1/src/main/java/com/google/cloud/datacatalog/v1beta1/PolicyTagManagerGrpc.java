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
package com.google.cloud.datacatalog.v1beta1;

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
 * The policy tag manager API service allows clients to manage their taxonomies
 * and policy tags.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/datacatalog/v1beta1/policytagmanager.proto")
public final class PolicyTagManagerGrpc {

  private PolicyTagManagerGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datacatalog.v1beta1.PolicyTagManager";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateTaxonomyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      METHOD_CREATE_TAXONOMY = getCreateTaxonomyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getCreateTaxonomyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getCreateTaxonomyMethod() {
    return getCreateTaxonomyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getCreateTaxonomyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        getCreateTaxonomyMethod;
    if ((getCreateTaxonomyMethod = PolicyTagManagerGrpc.getCreateTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getCreateTaxonomyMethod = PolicyTagManagerGrpc.getCreateTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getCreateTaxonomyMethod =
              getCreateTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
                          com.google.cloud.datacatalog.v1beta1.Taxonomy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "CreateTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Taxonomy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("CreateTaxonomy"))
                      .build();
        }
      }
    }
    return getCreateTaxonomyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteTaxonomyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest, com.google.protobuf.Empty>
      METHOD_DELETE_TAXONOMY = getDeleteTaxonomyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest, com.google.protobuf.Empty>
      getDeleteTaxonomyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest, com.google.protobuf.Empty>
      getDeleteTaxonomyMethod() {
    return getDeleteTaxonomyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest, com.google.protobuf.Empty>
      getDeleteTaxonomyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest, com.google.protobuf.Empty>
        getDeleteTaxonomyMethod;
    if ((getDeleteTaxonomyMethod = PolicyTagManagerGrpc.getDeleteTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getDeleteTaxonomyMethod = PolicyTagManagerGrpc.getDeleteTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getDeleteTaxonomyMethod =
              getDeleteTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "DeleteTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("DeleteTaxonomy"))
                      .build();
        }
      }
    }
    return getDeleteTaxonomyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateTaxonomyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      METHOD_UPDATE_TAXONOMY = getUpdateTaxonomyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getUpdateTaxonomyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getUpdateTaxonomyMethod() {
    return getUpdateTaxonomyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getUpdateTaxonomyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        getUpdateTaxonomyMethod;
    if ((getUpdateTaxonomyMethod = PolicyTagManagerGrpc.getUpdateTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getUpdateTaxonomyMethod = PolicyTagManagerGrpc.getUpdateTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getUpdateTaxonomyMethod =
              getUpdateTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
                          com.google.cloud.datacatalog.v1beta1.Taxonomy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "UpdateTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Taxonomy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("UpdateTaxonomy"))
                      .build();
        }
      }
    }
    return getUpdateTaxonomyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListTaxonomiesMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
      METHOD_LIST_TAXONOMIES = getListTaxonomiesMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
      getListTaxonomiesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
      getListTaxonomiesMethod() {
    return getListTaxonomiesMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
      getListTaxonomiesMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
            com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
        getListTaxonomiesMethod;
    if ((getListTaxonomiesMethod = PolicyTagManagerGrpc.getListTaxonomiesMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getListTaxonomiesMethod = PolicyTagManagerGrpc.getListTaxonomiesMethod) == null) {
          PolicyTagManagerGrpc.getListTaxonomiesMethod =
              getListTaxonomiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
                          com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "ListTaxonomies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("ListTaxonomies"))
                      .build();
        }
      }
    }
    return getListTaxonomiesMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetTaxonomyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      METHOD_GET_TAXONOMY = getGetTaxonomyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getGetTaxonomyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getGetTaxonomyMethod() {
    return getGetTaxonomyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
          com.google.cloud.datacatalog.v1beta1.Taxonomy>
      getGetTaxonomyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        getGetTaxonomyMethod;
    if ((getGetTaxonomyMethod = PolicyTagManagerGrpc.getGetTaxonomyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetTaxonomyMethod = PolicyTagManagerGrpc.getGetTaxonomyMethod) == null) {
          PolicyTagManagerGrpc.getGetTaxonomyMethod =
              getGetTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
                          com.google.cloud.datacatalog.v1beta1.Taxonomy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager", "GetTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.Taxonomy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("GetTaxonomy"))
                      .build();
        }
      }
    }
    return getGetTaxonomyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreatePolicyTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      METHOD_CREATE_POLICY_TAG = getCreatePolicyTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getCreatePolicyTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getCreatePolicyTagMethod() {
    return getCreatePolicyTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getCreatePolicyTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        getCreatePolicyTagMethod;
    if ((getCreatePolicyTagMethod = PolicyTagManagerGrpc.getCreatePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getCreatePolicyTagMethod = PolicyTagManagerGrpc.getCreatePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getCreatePolicyTagMethod =
              getCreatePolicyTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
                          com.google.cloud.datacatalog.v1beta1.PolicyTag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "CreatePolicyTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.PolicyTag.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("CreatePolicyTag"))
                      .build();
        }
      }
    }
    return getCreatePolicyTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeletePolicyTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest, com.google.protobuf.Empty>
      METHOD_DELETE_POLICY_TAG = getDeletePolicyTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest, com.google.protobuf.Empty>
      getDeletePolicyTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest, com.google.protobuf.Empty>
      getDeletePolicyTagMethod() {
    return getDeletePolicyTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest, com.google.protobuf.Empty>
      getDeletePolicyTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest, com.google.protobuf.Empty>
        getDeletePolicyTagMethod;
    if ((getDeletePolicyTagMethod = PolicyTagManagerGrpc.getDeletePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getDeletePolicyTagMethod = PolicyTagManagerGrpc.getDeletePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getDeletePolicyTagMethod =
              getDeletePolicyTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "DeletePolicyTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("DeletePolicyTag"))
                      .build();
        }
      }
    }
    return getDeletePolicyTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdatePolicyTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      METHOD_UPDATE_POLICY_TAG = getUpdatePolicyTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getUpdatePolicyTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getUpdatePolicyTagMethod() {
    return getUpdatePolicyTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getUpdatePolicyTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        getUpdatePolicyTagMethod;
    if ((getUpdatePolicyTagMethod = PolicyTagManagerGrpc.getUpdatePolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getUpdatePolicyTagMethod = PolicyTagManagerGrpc.getUpdatePolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getUpdatePolicyTagMethod =
              getUpdatePolicyTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
                          com.google.cloud.datacatalog.v1beta1.PolicyTag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "UpdatePolicyTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.PolicyTag.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("UpdatePolicyTag"))
                      .build();
        }
      }
    }
    return getUpdatePolicyTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListPolicyTagsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
      METHOD_LIST_POLICY_TAGS = getListPolicyTagsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
      getListPolicyTagsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
      getListPolicyTagsMethod() {
    return getListPolicyTagsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
      getListPolicyTagsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
            com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
        getListPolicyTagsMethod;
    if ((getListPolicyTagsMethod = PolicyTagManagerGrpc.getListPolicyTagsMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getListPolicyTagsMethod = PolicyTagManagerGrpc.getListPolicyTagsMethod) == null) {
          PolicyTagManagerGrpc.getListPolicyTagsMethod =
              getListPolicyTagsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
                          com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "ListPolicyTags"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("ListPolicyTags"))
                      .build();
        }
      }
    }
    return getListPolicyTagsMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetPolicyTagMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      METHOD_GET_POLICY_TAG = getGetPolicyTagMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getGetPolicyTagMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getGetPolicyTagMethod() {
    return getGetPolicyTagMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
          com.google.cloud.datacatalog.v1beta1.PolicyTag>
      getGetPolicyTagMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        getGetPolicyTagMethod;
    if ((getGetPolicyTagMethod = PolicyTagManagerGrpc.getGetPolicyTagMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetPolicyTagMethod = PolicyTagManagerGrpc.getGetPolicyTagMethod) == null) {
          PolicyTagManagerGrpc.getGetPolicyTagMethod =
              getGetPolicyTagMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
                          com.google.cloud.datacatalog.v1beta1.PolicyTag>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager", "GetPolicyTag"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datacatalog.v1beta1.PolicyTag.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("GetPolicyTag"))
                      .build();
        }
      }
    }
    return getGetPolicyTagMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_GET_IAM_POLICY = getGetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethod() {
    return getGetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
      getGetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>
        getGetIamPolicyMethod;
    if ((getGetIamPolicyMethod = PolicyTagManagerGrpc.getGetIamPolicyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getGetIamPolicyMethod = PolicyTagManagerGrpc.getGetIamPolicyMethod) == null) {
          PolicyTagManagerGrpc.getGetIamPolicyMethod =
              getGetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager", "GetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.GetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("GetIamPolicy"))
                      .build();
        }
      }
    }
    return getGetIamPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSetIamPolicyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      METHOD_SET_IAM_POLICY = getSetIamPolicyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethod() {
    return getSetIamPolicyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
      getSetIamPolicyMethodHelper() {
    io.grpc.MethodDescriptor<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>
        getSetIamPolicyMethod;
    if ((getSetIamPolicyMethod = PolicyTagManagerGrpc.getSetIamPolicyMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getSetIamPolicyMethod = PolicyTagManagerGrpc.getSetIamPolicyMethod) == null) {
          PolicyTagManagerGrpc.getSetIamPolicyMethod =
              getSetIamPolicyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager", "SetIamPolicy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.SetIamPolicyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.Policy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("SetIamPolicy"))
                      .build();
        }
      }
    }
    return getSetIamPolicyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getTestIamPermissionsMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      METHOD_TEST_IAM_PERMISSIONS = getTestIamPermissionsMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethod() {
    return getTestIamPermissionsMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.iam.v1.TestIamPermissionsRequest, com.google.iam.v1.TestIamPermissionsResponse>
      getTestIamPermissionsMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.iam.v1.TestIamPermissionsRequest,
            com.google.iam.v1.TestIamPermissionsResponse>
        getTestIamPermissionsMethod;
    if ((getTestIamPermissionsMethod = PolicyTagManagerGrpc.getTestIamPermissionsMethod) == null) {
      synchronized (PolicyTagManagerGrpc.class) {
        if ((getTestIamPermissionsMethod = PolicyTagManagerGrpc.getTestIamPermissionsMethod)
            == null) {
          PolicyTagManagerGrpc.getTestIamPermissionsMethod =
              getTestIamPermissionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.iam.v1.TestIamPermissionsRequest,
                          com.google.iam.v1.TestIamPermissionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.datacatalog.v1beta1.PolicyTagManager",
                              "TestIamPermissions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.iam.v1.TestIamPermissionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new PolicyTagManagerMethodDescriptorSupplier("TestIamPermissions"))
                      .build();
        }
      }
    }
    return getTestIamPermissionsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static PolicyTagManagerStub newStub(io.grpc.Channel channel) {
    return new PolicyTagManagerStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolicyTagManagerBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new PolicyTagManagerBlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static PolicyTagManagerFutureStub newFutureStub(io.grpc.Channel channel) {
    return new PolicyTagManagerFutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * The policy tag manager API service allows clients to manage their taxonomies
   * and policy tags.
   * </pre>
   */
  public abstract static class PolicyTagManagerImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a taxonomy in the specified project.
     * </pre>
     */
    public void createTaxonomy(
        com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateTaxonomyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a taxonomy. This operation will also delete all
     * policy tags in this taxonomy along with their associated policies.
     * </pre>
     */
    public void deleteTaxonomy(
        com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteTaxonomyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a taxonomy.
     * </pre>
     */
    public void updateTaxonomy(
        com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateTaxonomyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all taxonomies in a project in a particular location that the caller
     * has permission to view.
     * </pre>
     */
    public void listTaxonomies(
        com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListTaxonomiesMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public void getTaxonomy(
        com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetTaxonomyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy tag in the specified taxonomy.
     * </pre>
     */
    public void createPolicyTag(
        com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreatePolicyTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy tag. Also deletes all of its descendant policy tags.
     * </pre>
     */
    public void deletePolicyTag(
        com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeletePolicyTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy tag.
     * </pre>
     */
    public void updatePolicyTag(
        com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnimplementedUnaryCall(getUpdatePolicyTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public void listPolicyTags(
        com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListPolicyTagsMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public void getPolicyTag(
        com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnimplementedUnaryCall(getGetPolicyTagMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getGetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnimplementedUnaryCall(getSetIamPolicyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified taxonomy or
     * policy tag.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getTestIamPermissionsMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateTaxonomyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest,
                      com.google.cloud.datacatalog.v1beta1.Taxonomy>(
                      this, METHODID_CREATE_TAXONOMY)))
          .addMethod(
              getDeleteTaxonomyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_TAXONOMY)))
          .addMethod(
              getUpdateTaxonomyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest,
                      com.google.cloud.datacatalog.v1beta1.Taxonomy>(
                      this, METHODID_UPDATE_TAXONOMY)))
          .addMethod(
              getListTaxonomiesMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest,
                      com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>(
                      this, METHODID_LIST_TAXONOMIES)))
          .addMethod(
              getGetTaxonomyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest,
                      com.google.cloud.datacatalog.v1beta1.Taxonomy>(this, METHODID_GET_TAXONOMY)))
          .addMethod(
              getCreatePolicyTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest,
                      com.google.cloud.datacatalog.v1beta1.PolicyTag>(
                      this, METHODID_CREATE_POLICY_TAG)))
          .addMethod(
              getDeletePolicyTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_POLICY_TAG)))
          .addMethod(
              getUpdatePolicyTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest,
                      com.google.cloud.datacatalog.v1beta1.PolicyTag>(
                      this, METHODID_UPDATE_POLICY_TAG)))
          .addMethod(
              getListPolicyTagsMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest,
                      com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>(
                      this, METHODID_LIST_POLICY_TAGS)))
          .addMethod(
              getGetPolicyTagMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest,
                      com.google.cloud.datacatalog.v1beta1.PolicyTag>(
                      this, METHODID_GET_POLICY_TAG)))
          .addMethod(
              getGetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.GetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_GET_IAM_POLICY)))
          .addMethod(
              getSetIamPolicyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.iam.v1.SetIamPolicyRequest, com.google.iam.v1.Policy>(
                      this, METHODID_SET_IAM_POLICY)))
          .addMethod(
              getTestIamPermissionsMethodHelper(),
              asyncUnaryCall(
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
   * The policy tag manager API service allows clients to manage their taxonomies
   * and policy tags.
   * </pre>
   */
  public static final class PolicyTagManagerStub
      extends io.grpc.stub.AbstractStub<PolicyTagManagerStub> {
    private PolicyTagManagerStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PolicyTagManagerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a taxonomy in the specified project.
     * </pre>
     */
    public void createTaxonomy(
        com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateTaxonomyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a taxonomy. This operation will also delete all
     * policy tags in this taxonomy along with their associated policies.
     * </pre>
     */
    public void deleteTaxonomy(
        com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteTaxonomyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a taxonomy.
     * </pre>
     */
    public void updateTaxonomy(
        com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateTaxonomyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all taxonomies in a project in a particular location that the caller
     * has permission to view.
     * </pre>
     */
    public void listTaxonomies(
        com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListTaxonomiesMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public void getTaxonomy(
        com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetTaxonomyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy tag in the specified taxonomy.
     * </pre>
     */
    public void createPolicyTag(
        com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreatePolicyTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy tag. Also deletes all of its descendant policy tags.
     * </pre>
     */
    public void deletePolicyTag(
        com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeletePolicyTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy tag.
     * </pre>
     */
    public void updatePolicyTag(
        com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdatePolicyTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public void listPolicyTags(
        com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListPolicyTagsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public void getPolicyTag(
        com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPolicyTagMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public void getIamPolicy(
        com.google.iam.v1.GetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public void setIamPolicy(
        com.google.iam.v1.SetIamPolicyRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.Policy> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified taxonomy or
     * policy tag.
     * </pre>
     */
    public void testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request,
        io.grpc.stub.StreamObserver<com.google.iam.v1.TestIamPermissionsResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * The policy tag manager API service allows clients to manage their taxonomies
   * and policy tags.
   * </pre>
   */
  public static final class PolicyTagManagerBlockingStub
      extends io.grpc.stub.AbstractStub<PolicyTagManagerBlockingStub> {
    private PolicyTagManagerBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PolicyTagManagerBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a taxonomy in the specified project.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Taxonomy createTaxonomy(
        com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateTaxonomyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a taxonomy. This operation will also delete all
     * policy tags in this taxonomy along with their associated policies.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTaxonomy(
        com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteTaxonomyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Taxonomy updateTaxonomy(
        com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateTaxonomyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all taxonomies in a project in a particular location that the caller
     * has permission to view.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse listTaxonomies(
        com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest request) {
      return blockingUnaryCall(
          getChannel(), getListTaxonomiesMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.Taxonomy getTaxonomy(
        com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetTaxonomyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy tag in the specified taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.PolicyTag createPolicyTag(
        com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreatePolicyTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy tag. Also deletes all of its descendant policy tags.
     * </pre>
     */
    public com.google.protobuf.Empty deletePolicyTag(
        com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeletePolicyTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.PolicyTag updatePolicyTag(
        com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdatePolicyTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse listPolicyTags(
        com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest request) {
      return blockingUnaryCall(
          getChannel(), getListPolicyTagsMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public com.google.cloud.datacatalog.v1beta1.PolicyTag getPolicyTag(
        com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetPolicyTagMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public com.google.iam.v1.Policy getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public com.google.iam.v1.Policy setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetIamPolicyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified taxonomy or
     * policy tag.
     * </pre>
     */
    public com.google.iam.v1.TestIamPermissionsResponse testIamPermissions(
        com.google.iam.v1.TestIamPermissionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getTestIamPermissionsMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * The policy tag manager API service allows clients to manage their taxonomies
   * and policy tags.
   * </pre>
   */
  public static final class PolicyTagManagerFutureStub
      extends io.grpc.stub.AbstractStub<PolicyTagManagerFutureStub> {
    private PolicyTagManagerFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PolicyTagManagerFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolicyTagManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolicyTagManagerFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a taxonomy in the specified project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        createTaxonomy(com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateTaxonomyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a taxonomy. This operation will also delete all
     * policy tags in this taxonomy along with their associated policies.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTaxonomy(com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteTaxonomyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        updateTaxonomy(com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateTaxonomyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all taxonomies in a project in a particular location that the caller
     * has permission to view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>
        listTaxonomies(com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListTaxonomiesMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.Taxonomy>
        getTaxonomy(com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetTaxonomyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a policy tag in the specified taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        createPolicyTag(com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreatePolicyTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a policy tag. Also deletes all of its descendant policy tags.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePolicyTag(com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeletePolicyTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        updatePolicyTag(com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdatePolicyTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all policy tags in a taxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>
        listPolicyTags(com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListPolicyTagsMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datacatalog.v1beta1.PolicyTag>
        getPolicyTag(com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPolicyTagMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        getIamPolicy(com.google.iam.v1.GetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sets the IAM policy for a taxonomy or a policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.iam.v1.Policy>
        setIamPolicy(com.google.iam.v1.SetIamPolicyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetIamPolicyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the permissions that a caller has on the specified taxonomy or
     * policy tag.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.iam.v1.TestIamPermissionsResponse>
        testIamPermissions(com.google.iam.v1.TestIamPermissionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getTestIamPermissionsMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_TAXONOMY = 0;
  private static final int METHODID_DELETE_TAXONOMY = 1;
  private static final int METHODID_UPDATE_TAXONOMY = 2;
  private static final int METHODID_LIST_TAXONOMIES = 3;
  private static final int METHODID_GET_TAXONOMY = 4;
  private static final int METHODID_CREATE_POLICY_TAG = 5;
  private static final int METHODID_DELETE_POLICY_TAG = 6;
  private static final int METHODID_UPDATE_POLICY_TAG = 7;
  private static final int METHODID_LIST_POLICY_TAGS = 8;
  private static final int METHODID_GET_POLICY_TAG = 9;
  private static final int METHODID_GET_IAM_POLICY = 10;
  private static final int METHODID_SET_IAM_POLICY = 11;
  private static final int METHODID_TEST_IAM_PERMISSIONS = 12;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PolicyTagManagerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PolicyTagManagerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_TAXONOMY:
          serviceImpl.createTaxonomy(
              (com.google.cloud.datacatalog.v1beta1.CreateTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>)
                  responseObserver);
          break;
        case METHODID_DELETE_TAXONOMY:
          serviceImpl.deleteTaxonomy(
              (com.google.cloud.datacatalog.v1beta1.DeleteTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_TAXONOMY:
          serviceImpl.updateTaxonomy(
              (com.google.cloud.datacatalog.v1beta1.UpdateTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>)
                  responseObserver);
          break;
        case METHODID_LIST_TAXONOMIES:
          serviceImpl.listTaxonomies(
              (com.google.cloud.datacatalog.v1beta1.ListTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.v1beta1.ListTaxonomiesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TAXONOMY:
          serviceImpl.getTaxonomy(
              (com.google.cloud.datacatalog.v1beta1.GetTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.Taxonomy>)
                  responseObserver);
          break;
        case METHODID_CREATE_POLICY_TAG:
          serviceImpl.createPolicyTag(
              (com.google.cloud.datacatalog.v1beta1.CreatePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>)
                  responseObserver);
          break;
        case METHODID_DELETE_POLICY_TAG:
          serviceImpl.deletePolicyTag(
              (com.google.cloud.datacatalog.v1beta1.DeletePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_POLICY_TAG:
          serviceImpl.updatePolicyTag(
              (com.google.cloud.datacatalog.v1beta1.UpdatePolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>)
                  responseObserver);
          break;
        case METHODID_LIST_POLICY_TAGS:
          serviceImpl.listPolicyTags(
              (com.google.cloud.datacatalog.v1beta1.ListPolicyTagsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datacatalog.v1beta1.ListPolicyTagsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_POLICY_TAG:
          serviceImpl.getPolicyTag(
              (com.google.cloud.datacatalog.v1beta1.GetPolicyTagRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datacatalog.v1beta1.PolicyTag>)
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

  private abstract static class PolicyTagManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolicyTagManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datacatalog.v1beta1.PolicyTagManagerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PolicyTagManager");
    }
  }

  private static final class PolicyTagManagerFileDescriptorSupplier
      extends PolicyTagManagerBaseDescriptorSupplier {
    PolicyTagManagerFileDescriptorSupplier() {}
  }

  private static final class PolicyTagManagerMethodDescriptorSupplier
      extends PolicyTagManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PolicyTagManagerMethodDescriptorSupplier(String methodName) {
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
      synchronized (PolicyTagManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new PolicyTagManagerFileDescriptorSupplier())
                      .addMethod(getCreateTaxonomyMethodHelper())
                      .addMethod(getDeleteTaxonomyMethodHelper())
                      .addMethod(getUpdateTaxonomyMethodHelper())
                      .addMethod(getListTaxonomiesMethodHelper())
                      .addMethod(getGetTaxonomyMethodHelper())
                      .addMethod(getCreatePolicyTagMethodHelper())
                      .addMethod(getDeletePolicyTagMethodHelper())
                      .addMethod(getUpdatePolicyTagMethodHelper())
                      .addMethod(getListPolicyTagsMethodHelper())
                      .addMethod(getGetPolicyTagMethodHelper())
                      .addMethod(getGetIamPolicyMethodHelper())
                      .addMethod(getSetIamPolicyMethodHelper())
                      .addMethod(getTestIamPermissionsMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
