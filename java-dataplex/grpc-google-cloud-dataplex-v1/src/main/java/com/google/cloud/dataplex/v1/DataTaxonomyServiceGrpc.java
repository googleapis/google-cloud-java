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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * DataTaxonomyService enables attribute-based governance. The resources
 * currently offered include DataTaxonomy and DataAttribute.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/data_taxonomy.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataTaxonomyServiceGrpc {

  private DataTaxonomyServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.dataplex.v1.DataTaxonomyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest, com.google.longrunning.Operation>
      getCreateDataTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataTaxonomy",
      requestType = com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest, com.google.longrunning.Operation>
      getCreateDataTaxonomyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest,
            com.google.longrunning.Operation>
        getCreateDataTaxonomyMethod;
    if ((getCreateDataTaxonomyMethod = DataTaxonomyServiceGrpc.getCreateDataTaxonomyMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getCreateDataTaxonomyMethod = DataTaxonomyServiceGrpc.getCreateDataTaxonomyMethod)
            == null) {
          DataTaxonomyServiceGrpc.getCreateDataTaxonomyMethod =
              getCreateDataTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateDataTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("CreateDataTaxonomy"))
                      .build();
        }
      }
    }
    return getCreateDataTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest, com.google.longrunning.Operation>
      getUpdateDataTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataTaxonomy",
      requestType = com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest, com.google.longrunning.Operation>
      getUpdateDataTaxonomyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest,
            com.google.longrunning.Operation>
        getUpdateDataTaxonomyMethod;
    if ((getUpdateDataTaxonomyMethod = DataTaxonomyServiceGrpc.getUpdateDataTaxonomyMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getUpdateDataTaxonomyMethod = DataTaxonomyServiceGrpc.getUpdateDataTaxonomyMethod)
            == null) {
          DataTaxonomyServiceGrpc.getUpdateDataTaxonomyMethod =
              getUpdateDataTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateDataTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("UpdateDataTaxonomy"))
                      .build();
        }
      }
    }
    return getUpdateDataTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest, com.google.longrunning.Operation>
      getDeleteDataTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataTaxonomy",
      requestType = com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest, com.google.longrunning.Operation>
      getDeleteDataTaxonomyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest,
            com.google.longrunning.Operation>
        getDeleteDataTaxonomyMethod;
    if ((getDeleteDataTaxonomyMethod = DataTaxonomyServiceGrpc.getDeleteDataTaxonomyMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getDeleteDataTaxonomyMethod = DataTaxonomyServiceGrpc.getDeleteDataTaxonomyMethod)
            == null) {
          DataTaxonomyServiceGrpc.getDeleteDataTaxonomyMethod =
              getDeleteDataTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteDataTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("DeleteDataTaxonomy"))
                      .build();
        }
      }
    }
    return getDeleteDataTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest,
          com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
      getListDataTaxonomiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataTaxonomies",
      requestType = com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest,
          com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
      getListDataTaxonomiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest,
            com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
        getListDataTaxonomiesMethod;
    if ((getListDataTaxonomiesMethod = DataTaxonomyServiceGrpc.getListDataTaxonomiesMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getListDataTaxonomiesMethod = DataTaxonomyServiceGrpc.getListDataTaxonomiesMethod)
            == null) {
          DataTaxonomyServiceGrpc.getListDataTaxonomiesMethod =
              getListDataTaxonomiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest,
                          com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataTaxonomies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("ListDataTaxonomies"))
                      .build();
        }
      }
    }
    return getListDataTaxonomiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataTaxonomyRequest,
          com.google.cloud.dataplex.v1.DataTaxonomy>
      getGetDataTaxonomyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataTaxonomy",
      requestType = com.google.cloud.dataplex.v1.GetDataTaxonomyRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataTaxonomy.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataTaxonomyRequest,
          com.google.cloud.dataplex.v1.DataTaxonomy>
      getGetDataTaxonomyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataTaxonomyRequest,
            com.google.cloud.dataplex.v1.DataTaxonomy>
        getGetDataTaxonomyMethod;
    if ((getGetDataTaxonomyMethod = DataTaxonomyServiceGrpc.getGetDataTaxonomyMethod) == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getGetDataTaxonomyMethod = DataTaxonomyServiceGrpc.getGetDataTaxonomyMethod) == null) {
          DataTaxonomyServiceGrpc.getGetDataTaxonomyMethod =
              getGetDataTaxonomyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataTaxonomyRequest,
                          com.google.cloud.dataplex.v1.DataTaxonomy>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataTaxonomy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataTaxonomyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataTaxonomy.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("GetDataTaxonomy"))
                      .build();
        }
      }
    }
    return getGetDataTaxonomyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getCreateDataAttributeBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAttributeBinding",
      requestType = com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getCreateDataAttributeBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest,
            com.google.longrunning.Operation>
        getCreateDataAttributeBindingMethod;
    if ((getCreateDataAttributeBindingMethod =
            DataTaxonomyServiceGrpc.getCreateDataAttributeBindingMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getCreateDataAttributeBindingMethod =
                DataTaxonomyServiceGrpc.getCreateDataAttributeBindingMethod)
            == null) {
          DataTaxonomyServiceGrpc.getCreateDataAttributeBindingMethod =
              getCreateDataAttributeBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDataAttributeBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier(
                              "CreateDataAttributeBinding"))
                      .build();
        }
      }
    }
    return getCreateDataAttributeBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getUpdateDataAttributeBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAttributeBinding",
      requestType = com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getUpdateDataAttributeBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest,
            com.google.longrunning.Operation>
        getUpdateDataAttributeBindingMethod;
    if ((getUpdateDataAttributeBindingMethod =
            DataTaxonomyServiceGrpc.getUpdateDataAttributeBindingMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getUpdateDataAttributeBindingMethod =
                DataTaxonomyServiceGrpc.getUpdateDataAttributeBindingMethod)
            == null) {
          DataTaxonomyServiceGrpc.getUpdateDataAttributeBindingMethod =
              getUpdateDataAttributeBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataAttributeBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier(
                              "UpdateDataAttributeBinding"))
                      .build();
        }
      }
    }
    return getUpdateDataAttributeBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getDeleteDataAttributeBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAttributeBinding",
      requestType = com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest,
          com.google.longrunning.Operation>
      getDeleteDataAttributeBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest,
            com.google.longrunning.Operation>
        getDeleteDataAttributeBindingMethod;
    if ((getDeleteDataAttributeBindingMethod =
            DataTaxonomyServiceGrpc.getDeleteDataAttributeBindingMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getDeleteDataAttributeBindingMethod =
                DataTaxonomyServiceGrpc.getDeleteDataAttributeBindingMethod)
            == null) {
          DataTaxonomyServiceGrpc.getDeleteDataAttributeBindingMethod =
              getDeleteDataAttributeBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDataAttributeBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier(
                              "DeleteDataAttributeBinding"))
                      .build();
        }
      }
    }
    return getDeleteDataAttributeBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest,
          com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
      getListDataAttributeBindingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAttributeBindings",
      requestType = com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest,
          com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
      getListDataAttributeBindingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest,
            com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
        getListDataAttributeBindingsMethod;
    if ((getListDataAttributeBindingsMethod =
            DataTaxonomyServiceGrpc.getListDataAttributeBindingsMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getListDataAttributeBindingsMethod =
                DataTaxonomyServiceGrpc.getListDataAttributeBindingsMethod)
            == null) {
          DataTaxonomyServiceGrpc.getListDataAttributeBindingsMethod =
              getListDataAttributeBindingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest,
                          com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListDataAttributeBindings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier(
                              "ListDataAttributeBindings"))
                      .build();
        }
      }
    }
    return getListDataAttributeBindingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest,
          com.google.cloud.dataplex.v1.DataAttributeBinding>
      getGetDataAttributeBindingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAttributeBinding",
      requestType = com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataAttributeBinding.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest,
          com.google.cloud.dataplex.v1.DataAttributeBinding>
      getGetDataAttributeBindingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest,
            com.google.cloud.dataplex.v1.DataAttributeBinding>
        getGetDataAttributeBindingMethod;
    if ((getGetDataAttributeBindingMethod =
            DataTaxonomyServiceGrpc.getGetDataAttributeBindingMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getGetDataAttributeBindingMethod =
                DataTaxonomyServiceGrpc.getGetDataAttributeBindingMethod)
            == null) {
          DataTaxonomyServiceGrpc.getGetDataAttributeBindingMethod =
              getGetDataAttributeBindingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest,
                          com.google.cloud.dataplex.v1.DataAttributeBinding>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetDataAttributeBinding"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataAttributeBinding
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier(
                              "GetDataAttributeBinding"))
                      .build();
        }
      }
    }
    return getGetDataAttributeBindingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAttributeRequest, com.google.longrunning.Operation>
      getCreateDataAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateDataAttribute",
      requestType = com.google.cloud.dataplex.v1.CreateDataAttributeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateDataAttributeRequest, com.google.longrunning.Operation>
      getCreateDataAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateDataAttributeRequest,
            com.google.longrunning.Operation>
        getCreateDataAttributeMethod;
    if ((getCreateDataAttributeMethod = DataTaxonomyServiceGrpc.getCreateDataAttributeMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getCreateDataAttributeMethod = DataTaxonomyServiceGrpc.getCreateDataAttributeMethod)
            == null) {
          DataTaxonomyServiceGrpc.getCreateDataAttributeMethod =
              getCreateDataAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateDataAttributeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateDataAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateDataAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("CreateDataAttribute"))
                      .build();
        }
      }
    }
    return getCreateDataAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAttributeRequest, com.google.longrunning.Operation>
      getUpdateDataAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateDataAttribute",
      requestType = com.google.cloud.dataplex.v1.UpdateDataAttributeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateDataAttributeRequest, com.google.longrunning.Operation>
      getUpdateDataAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateDataAttributeRequest,
            com.google.longrunning.Operation>
        getUpdateDataAttributeMethod;
    if ((getUpdateDataAttributeMethod = DataTaxonomyServiceGrpc.getUpdateDataAttributeMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getUpdateDataAttributeMethod = DataTaxonomyServiceGrpc.getUpdateDataAttributeMethod)
            == null) {
          DataTaxonomyServiceGrpc.getUpdateDataAttributeMethod =
              getUpdateDataAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateDataAttributeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateDataAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateDataAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("UpdateDataAttribute"))
                      .build();
        }
      }
    }
    return getUpdateDataAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAttributeRequest, com.google.longrunning.Operation>
      getDeleteDataAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteDataAttribute",
      requestType = com.google.cloud.dataplex.v1.DeleteDataAttributeRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteDataAttributeRequest, com.google.longrunning.Operation>
      getDeleteDataAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteDataAttributeRequest,
            com.google.longrunning.Operation>
        getDeleteDataAttributeMethod;
    if ((getDeleteDataAttributeMethod = DataTaxonomyServiceGrpc.getDeleteDataAttributeMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getDeleteDataAttributeMethod = DataTaxonomyServiceGrpc.getDeleteDataAttributeMethod)
            == null) {
          DataTaxonomyServiceGrpc.getDeleteDataAttributeMethod =
              getDeleteDataAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteDataAttributeRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteDataAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteDataAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("DeleteDataAttribute"))
                      .build();
        }
      }
    }
    return getDeleteDataAttributeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAttributesRequest,
          com.google.cloud.dataplex.v1.ListDataAttributesResponse>
      getListDataAttributesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListDataAttributes",
      requestType = com.google.cloud.dataplex.v1.ListDataAttributesRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListDataAttributesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListDataAttributesRequest,
          com.google.cloud.dataplex.v1.ListDataAttributesResponse>
      getListDataAttributesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListDataAttributesRequest,
            com.google.cloud.dataplex.v1.ListDataAttributesResponse>
        getListDataAttributesMethod;
    if ((getListDataAttributesMethod = DataTaxonomyServiceGrpc.getListDataAttributesMethod)
        == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getListDataAttributesMethod = DataTaxonomyServiceGrpc.getListDataAttributesMethod)
            == null) {
          DataTaxonomyServiceGrpc.getListDataAttributesMethod =
              getListDataAttributesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListDataAttributesRequest,
                          com.google.cloud.dataplex.v1.ListDataAttributesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListDataAttributes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAttributesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListDataAttributesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("ListDataAttributes"))
                      .build();
        }
      }
    }
    return getListDataAttributesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAttributeRequest,
          com.google.cloud.dataplex.v1.DataAttribute>
      getGetDataAttributeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetDataAttribute",
      requestType = com.google.cloud.dataplex.v1.GetDataAttributeRequest.class,
      responseType = com.google.cloud.dataplex.v1.DataAttribute.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetDataAttributeRequest,
          com.google.cloud.dataplex.v1.DataAttribute>
      getGetDataAttributeMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetDataAttributeRequest,
            com.google.cloud.dataplex.v1.DataAttribute>
        getGetDataAttributeMethod;
    if ((getGetDataAttributeMethod = DataTaxonomyServiceGrpc.getGetDataAttributeMethod) == null) {
      synchronized (DataTaxonomyServiceGrpc.class) {
        if ((getGetDataAttributeMethod = DataTaxonomyServiceGrpc.getGetDataAttributeMethod)
            == null) {
          DataTaxonomyServiceGrpc.getGetDataAttributeMethod =
              getGetDataAttributeMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetDataAttributeRequest,
                          com.google.cloud.dataplex.v1.DataAttribute>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetDataAttribute"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetDataAttributeRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DataAttribute.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataTaxonomyServiceMethodDescriptorSupplier("GetDataAttribute"))
                      .build();
        }
      }
    }
    return getGetDataAttributeMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataTaxonomyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceStub>() {
          @java.lang.Override
          public DataTaxonomyServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTaxonomyServiceStub(channel, callOptions);
          }
        };
    return DataTaxonomyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataTaxonomyServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceBlockingStub>() {
          @java.lang.Override
          public DataTaxonomyServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTaxonomyServiceBlockingStub(channel, callOptions);
          }
        };
    return DataTaxonomyServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataTaxonomyServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataTaxonomyServiceFutureStub>() {
          @java.lang.Override
          public DataTaxonomyServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataTaxonomyServiceFutureStub(channel, callOptions);
          }
        };
    return DataTaxonomyServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * DataTaxonomyService enables attribute-based governance. The resources
   * currently offered include DataTaxonomy and DataAttribute.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a DataTaxonomy resource.
     * </pre>
     */
    default void createDataTaxonomy(
        com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataTaxonomyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataTaxonomy resource.
     * </pre>
     */
    default void updateDataTaxonomy(
        com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataTaxonomyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy
     * must be deleted before the DataTaxonomy can be deleted.
     * </pre>
     */
    default void deleteDataTaxonomy(
        com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataTaxonomyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataTaxonomy resources in a project and location.
     * </pre>
     */
    default void listDataTaxonomies(
        com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataTaxonomiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataTaxonomy resource.
     * </pre>
     */
    default void getDataTaxonomy(
        com.google.cloud.dataplex.v1.GetDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataTaxonomy> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataTaxonomyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttributeBinding resource.
     * </pre>
     */
    default void createDataAttributeBinding(
        com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAttributeBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttributeBinding resource.
     * </pre>
     */
    default void updateDataAttributeBinding(
        com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAttributeBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataAttributeBinding resource. All attributes within the
     * DataAttributeBinding must be deleted before the DataAttributeBinding can be
     * deleted.
     * </pre>
     */
    default void deleteDataAttributeBinding(
        com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAttributeBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAttributeBinding resources in a project and location.
     * </pre>
     */
    default void listDataAttributeBindings(
        com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAttributeBindingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataAttributeBinding resource.
     * </pre>
     */
    default void getDataAttributeBinding(
        com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttributeBinding>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAttributeBindingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttribute resource.
     * </pre>
     */
    default void createDataAttribute(
        com.google.cloud.dataplex.v1.CreateDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateDataAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttribute resource.
     * </pre>
     */
    default void updateDataAttribute(
        com.google.cloud.dataplex.v1.UpdateDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateDataAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Data Attribute resource.
     * </pre>
     */
    default void deleteDataAttribute(
        com.google.cloud.dataplex.v1.DeleteDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteDataAttributeMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Attribute resources in a DataTaxonomy.
     * </pre>
     */
    default void listDataAttributes(
        com.google.cloud.dataplex.v1.ListDataAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAttributesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListDataAttributesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Data Attribute resource.
     * </pre>
     */
    default void getDataAttribute(
        com.google.cloud.dataplex.v1.GetDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttribute> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetDataAttributeMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service DataTaxonomyService.
   *
   * <pre>
   * DataTaxonomyService enables attribute-based governance. The resources
   * currently offered include DataTaxonomy and DataAttribute.
   * </pre>
   */
  public abstract static class DataTaxonomyServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return DataTaxonomyServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service DataTaxonomyService.
   *
   * <pre>
   * DataTaxonomyService enables attribute-based governance. The resources
   * currently offered include DataTaxonomy and DataAttribute.
   * </pre>
   */
  public static final class DataTaxonomyServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DataTaxonomyServiceStub> {
    private DataTaxonomyServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTaxonomyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTaxonomyServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a DataTaxonomy resource.
     * </pre>
     */
    public void createDataTaxonomy(
        com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataTaxonomyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataTaxonomy resource.
     * </pre>
     */
    public void updateDataTaxonomy(
        com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataTaxonomyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy
     * must be deleted before the DataTaxonomy can be deleted.
     * </pre>
     */
    public void deleteDataTaxonomy(
        com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataTaxonomyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataTaxonomy resources in a project and location.
     * </pre>
     */
    public void listDataTaxonomies(
        com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataTaxonomiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataTaxonomy resource.
     * </pre>
     */
    public void getDataTaxonomy(
        com.google.cloud.dataplex.v1.GetDataTaxonomyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataTaxonomy> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataTaxonomyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttributeBinding resource.
     * </pre>
     */
    public void createDataAttributeBinding(
        com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAttributeBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttributeBinding resource.
     * </pre>
     */
    public void updateDataAttributeBinding(
        com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAttributeBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataAttributeBinding resource. All attributes within the
     * DataAttributeBinding must be deleted before the DataAttributeBinding can be
     * deleted.
     * </pre>
     */
    public void deleteDataAttributeBinding(
        com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAttributeBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAttributeBinding resources in a project and location.
     * </pre>
     */
    public void listDataAttributeBindings(
        com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAttributeBindingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataAttributeBinding resource.
     * </pre>
     */
    public void getDataAttributeBinding(
        com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttributeBinding>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAttributeBindingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttribute resource.
     * </pre>
     */
    public void createDataAttribute(
        com.google.cloud.dataplex.v1.CreateDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateDataAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttribute resource.
     * </pre>
     */
    public void updateDataAttribute(
        com.google.cloud.dataplex.v1.UpdateDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateDataAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Data Attribute resource.
     * </pre>
     */
    public void deleteDataAttribute(
        com.google.cloud.dataplex.v1.DeleteDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteDataAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Attribute resources in a DataTaxonomy.
     * </pre>
     */
    public void listDataAttributes(
        com.google.cloud.dataplex.v1.ListDataAttributesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAttributesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListDataAttributesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Data Attribute resource.
     * </pre>
     */
    public void getDataAttribute(
        com.google.cloud.dataplex.v1.GetDataAttributeRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttribute> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetDataAttributeMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service DataTaxonomyService.
   *
   * <pre>
   * DataTaxonomyService enables attribute-based governance. The resources
   * currently offered include DataTaxonomy and DataAttribute.
   * </pre>
   */
  public static final class DataTaxonomyServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataTaxonomyServiceBlockingStub> {
    private DataTaxonomyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTaxonomyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTaxonomyServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a DataTaxonomy resource.
     * </pre>
     */
    public com.google.longrunning.Operation createDataTaxonomy(
        com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataTaxonomy resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataTaxonomy(
        com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy
     * must be deleted before the DataTaxonomy can be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataTaxonomy(
        com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataTaxonomy resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse listDataTaxonomies(
        com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataTaxonomiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataTaxonomy resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataTaxonomy getDataTaxonomy(
        com.google.cloud.dataplex.v1.GetDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataTaxonomyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAttributeBinding(
        com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAttributeBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAttributeBinding(
        com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAttributeBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataAttributeBinding resource. All attributes within the
     * DataAttributeBinding must be deleted before the DataAttributeBinding can be
     * deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAttributeBinding(
        com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAttributeBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAttributeBinding resources in a project and location.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse listDataAttributeBindings(
        com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAttributeBindingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataAttributeBinding getDataAttributeBinding(
        com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAttributeBindingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttribute resource.
     * </pre>
     */
    public com.google.longrunning.Operation createDataAttribute(
        com.google.cloud.dataplex.v1.CreateDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateDataAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttribute resource.
     * </pre>
     */
    public com.google.longrunning.Operation updateDataAttribute(
        com.google.cloud.dataplex.v1.UpdateDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateDataAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Data Attribute resource.
     * </pre>
     */
    public com.google.longrunning.Operation deleteDataAttribute(
        com.google.cloud.dataplex.v1.DeleteDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteDataAttributeMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Attribute resources in a DataTaxonomy.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListDataAttributesResponse listDataAttributes(
        com.google.cloud.dataplex.v1.ListDataAttributesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListDataAttributesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Data Attribute resource.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.DataAttribute getDataAttribute(
        com.google.cloud.dataplex.v1.GetDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetDataAttributeMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service DataTaxonomyService.
   *
   * <pre>
   * DataTaxonomyService enables attribute-based governance. The resources
   * currently offered include DataTaxonomy and DataAttribute.
   * </pre>
   */
  public static final class DataTaxonomyServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataTaxonomyServiceFutureStub> {
    private DataTaxonomyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataTaxonomyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataTaxonomyServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a DataTaxonomy resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataTaxonomy(com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataTaxonomy resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataTaxonomy(com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataTaxonomy resource. All attributes within the DataTaxonomy
     * must be deleted before the DataTaxonomy can be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataTaxonomy(com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataTaxonomy resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>
        listDataTaxonomies(com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataTaxonomiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataTaxonomy resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataTaxonomy>
        getDataTaxonomy(com.google.cloud.dataplex.v1.GetDataTaxonomyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataTaxonomyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataAttributeBinding(
            com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAttributeBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataAttributeBinding(
            com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAttributeBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a DataAttributeBinding resource. All attributes within the
     * DataAttributeBinding must be deleted before the DataAttributeBinding can be
     * deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataAttributeBinding(
            com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAttributeBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists DataAttributeBinding resources in a project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>
        listDataAttributeBindings(
            com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAttributeBindingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a DataAttributeBinding resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataAttributeBinding>
        getDataAttributeBinding(
            com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAttributeBindingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a DataAttribute resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createDataAttribute(com.google.cloud.dataplex.v1.CreateDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateDataAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a DataAttribute resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateDataAttribute(com.google.cloud.dataplex.v1.UpdateDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateDataAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Data Attribute resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteDataAttribute(com.google.cloud.dataplex.v1.DeleteDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteDataAttributeMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Attribute resources in a DataTaxonomy.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListDataAttributesResponse>
        listDataAttributes(com.google.cloud.dataplex.v1.ListDataAttributesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListDataAttributesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a Data Attribute resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.DataAttribute>
        getDataAttribute(com.google.cloud.dataplex.v1.GetDataAttributeRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetDataAttributeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_DATA_TAXONOMY = 0;
  private static final int METHODID_UPDATE_DATA_TAXONOMY = 1;
  private static final int METHODID_DELETE_DATA_TAXONOMY = 2;
  private static final int METHODID_LIST_DATA_TAXONOMIES = 3;
  private static final int METHODID_GET_DATA_TAXONOMY = 4;
  private static final int METHODID_CREATE_DATA_ATTRIBUTE_BINDING = 5;
  private static final int METHODID_UPDATE_DATA_ATTRIBUTE_BINDING = 6;
  private static final int METHODID_DELETE_DATA_ATTRIBUTE_BINDING = 7;
  private static final int METHODID_LIST_DATA_ATTRIBUTE_BINDINGS = 8;
  private static final int METHODID_GET_DATA_ATTRIBUTE_BINDING = 9;
  private static final int METHODID_CREATE_DATA_ATTRIBUTE = 10;
  private static final int METHODID_UPDATE_DATA_ATTRIBUTE = 11;
  private static final int METHODID_DELETE_DATA_ATTRIBUTE = 12;
  private static final int METHODID_LIST_DATA_ATTRIBUTES = 13;
  private static final int METHODID_GET_DATA_ATTRIBUTE = 14;

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
        case METHODID_CREATE_DATA_TAXONOMY:
          serviceImpl.createDataTaxonomy(
              (com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_TAXONOMY:
          serviceImpl.updateDataTaxonomy(
              (com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_TAXONOMY:
          serviceImpl.deleteDataTaxonomy(
              (com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_TAXONOMIES:
          serviceImpl.listDataTaxonomies(
              (com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_TAXONOMY:
          serviceImpl.getDataTaxonomy(
              (com.google.cloud.dataplex.v1.GetDataTaxonomyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataTaxonomy>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_ATTRIBUTE_BINDING:
          serviceImpl.createDataAttributeBinding(
              (com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_ATTRIBUTE_BINDING:
          serviceImpl.updateDataAttributeBinding(
              (com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_ATTRIBUTE_BINDING:
          serviceImpl.deleteDataAttributeBinding(
              (com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_ATTRIBUTE_BINDINGS:
          serviceImpl.listDataAttributeBindings(
              (com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_ATTRIBUTE_BINDING:
          serviceImpl.getDataAttributeBinding(
              (com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttributeBinding>)
                  responseObserver);
          break;
        case METHODID_CREATE_DATA_ATTRIBUTE:
          serviceImpl.createDataAttribute(
              (com.google.cloud.dataplex.v1.CreateDataAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_DATA_ATTRIBUTE:
          serviceImpl.updateDataAttribute(
              (com.google.cloud.dataplex.v1.UpdateDataAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_DATA_ATTRIBUTE:
          serviceImpl.deleteDataAttribute(
              (com.google.cloud.dataplex.v1.DeleteDataAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_DATA_ATTRIBUTES:
          serviceImpl.listDataAttributes(
              (com.google.cloud.dataplex.v1.ListDataAttributesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListDataAttributesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_DATA_ATTRIBUTE:
          serviceImpl.getDataAttribute(
              (com.google.cloud.dataplex.v1.GetDataAttributeRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.DataAttribute>)
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
            getCreateDataTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_TAXONOMY)))
        .addMethod(
            getUpdateDataTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_TAXONOMY)))
        .addMethod(
            getDeleteDataTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_TAXONOMY)))
        .addMethod(
            getListDataTaxonomiesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest,
                    com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse>(
                    service, METHODID_LIST_DATA_TAXONOMIES)))
        .addMethod(
            getGetDataTaxonomyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataTaxonomyRequest,
                    com.google.cloud.dataplex.v1.DataTaxonomy>(
                    service, METHODID_GET_DATA_TAXONOMY)))
        .addMethod(
            getCreateDataAttributeBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_CREATE_DATA_ATTRIBUTE_BINDING)))
        .addMethod(
            getUpdateDataAttributeBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_UPDATE_DATA_ATTRIBUTE_BINDING)))
        .addMethod(
            getDeleteDataAttributeBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_DELETE_DATA_ATTRIBUTE_BINDING)))
        .addMethod(
            getListDataAttributeBindingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest,
                    com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse>(
                    service, METHODID_LIST_DATA_ATTRIBUTE_BINDINGS)))
        .addMethod(
            getGetDataAttributeBindingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest,
                    com.google.cloud.dataplex.v1.DataAttributeBinding>(
                    service, METHODID_GET_DATA_ATTRIBUTE_BINDING)))
        .addMethod(
            getCreateDataAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateDataAttributeRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_DATA_ATTRIBUTE)))
        .addMethod(
            getUpdateDataAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateDataAttributeRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_DATA_ATTRIBUTE)))
        .addMethod(
            getDeleteDataAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteDataAttributeRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_DATA_ATTRIBUTE)))
        .addMethod(
            getListDataAttributesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListDataAttributesRequest,
                    com.google.cloud.dataplex.v1.ListDataAttributesResponse>(
                    service, METHODID_LIST_DATA_ATTRIBUTES)))
        .addMethod(
            getGetDataAttributeMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetDataAttributeRequest,
                    com.google.cloud.dataplex.v1.DataAttribute>(
                    service, METHODID_GET_DATA_ATTRIBUTE)))
        .build();
  }

  private abstract static class DataTaxonomyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataTaxonomyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.DataTaxonomyProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataTaxonomyService");
    }
  }

  private static final class DataTaxonomyServiceFileDescriptorSupplier
      extends DataTaxonomyServiceBaseDescriptorSupplier {
    DataTaxonomyServiceFileDescriptorSupplier() {}
  }

  private static final class DataTaxonomyServiceMethodDescriptorSupplier
      extends DataTaxonomyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    DataTaxonomyServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (DataTaxonomyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataTaxonomyServiceFileDescriptorSupplier())
                      .addMethod(getCreateDataTaxonomyMethod())
                      .addMethod(getUpdateDataTaxonomyMethod())
                      .addMethod(getDeleteDataTaxonomyMethod())
                      .addMethod(getListDataTaxonomiesMethod())
                      .addMethod(getGetDataTaxonomyMethod())
                      .addMethod(getCreateDataAttributeBindingMethod())
                      .addMethod(getUpdateDataAttributeBindingMethod())
                      .addMethod(getDeleteDataAttributeBindingMethod())
                      .addMethod(getListDataAttributeBindingsMethod())
                      .addMethod(getGetDataAttributeBindingMethod())
                      .addMethod(getCreateDataAttributeMethod())
                      .addMethod(getUpdateDataAttributeMethod())
                      .addMethod(getDeleteDataAttributeMethod())
                      .addMethod(getListDataAttributesMethod())
                      .addMethod(getGetDataAttributeMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
