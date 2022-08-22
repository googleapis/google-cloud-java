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
package com.google.cloud.documentai.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service to call Cloud DocumentAI to process documents according to the
 * processor's definition. Processors are built using state-of-the-art Google
 * AI such as natural language, computer vision, and translation to extract
 * structured information from unstructured or semi-structured documents.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/documentai/v1/document_processor_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DocumentProcessorServiceGrpc {

  private DocumentProcessorServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.documentai.v1.DocumentProcessorService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ProcessRequest,
          com.google.cloud.documentai.v1.ProcessResponse>
      getProcessDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessDocument",
      requestType = com.google.cloud.documentai.v1.ProcessRequest.class,
      responseType = com.google.cloud.documentai.v1.ProcessResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ProcessRequest,
          com.google.cloud.documentai.v1.ProcessResponse>
      getProcessDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ProcessRequest,
            com.google.cloud.documentai.v1.ProcessResponse>
        getProcessDocumentMethod;
    if ((getProcessDocumentMethod = DocumentProcessorServiceGrpc.getProcessDocumentMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getProcessDocumentMethod = DocumentProcessorServiceGrpc.getProcessDocumentMethod)
            == null) {
          DocumentProcessorServiceGrpc.getProcessDocumentMethod =
              getProcessDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ProcessRequest,
                          com.google.cloud.documentai.v1.ProcessResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ProcessRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ProcessResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("ProcessDocument"))
                      .build();
        }
      }
    }
    return getProcessDocumentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
      getBatchProcessDocumentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchProcessDocuments",
      requestType = com.google.cloud.documentai.v1.BatchProcessRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
      getBatchProcessDocumentsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.BatchProcessRequest, com.google.longrunning.Operation>
        getBatchProcessDocumentsMethod;
    if ((getBatchProcessDocumentsMethod =
            DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getBatchProcessDocumentsMethod =
                DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod)
            == null) {
          DocumentProcessorServiceGrpc.getBatchProcessDocumentsMethod =
              getBatchProcessDocumentsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.BatchProcessRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchProcessDocuments"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.BatchProcessRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "BatchProcessDocuments"))
                      .build();
        }
      }
    }
    return getBatchProcessDocumentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.FetchProcessorTypesRequest,
          com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
      getFetchProcessorTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "FetchProcessorTypes",
      requestType = com.google.cloud.documentai.v1.FetchProcessorTypesRequest.class,
      responseType = com.google.cloud.documentai.v1.FetchProcessorTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.FetchProcessorTypesRequest,
          com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
      getFetchProcessorTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.FetchProcessorTypesRequest,
            com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
        getFetchProcessorTypesMethod;
    if ((getFetchProcessorTypesMethod = DocumentProcessorServiceGrpc.getFetchProcessorTypesMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getFetchProcessorTypesMethod =
                DocumentProcessorServiceGrpc.getFetchProcessorTypesMethod)
            == null) {
          DocumentProcessorServiceGrpc.getFetchProcessorTypesMethod =
              getFetchProcessorTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.FetchProcessorTypesRequest,
                          com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "FetchProcessorTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.FetchProcessorTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.FetchProcessorTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "FetchProcessorTypes"))
                      .build();
        }
      }
    }
    return getFetchProcessorTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorTypesRequest,
          com.google.cloud.documentai.v1.ListProcessorTypesResponse>
      getListProcessorTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcessorTypes",
      requestType = com.google.cloud.documentai.v1.ListProcessorTypesRequest.class,
      responseType = com.google.cloud.documentai.v1.ListProcessorTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorTypesRequest,
          com.google.cloud.documentai.v1.ListProcessorTypesResponse>
      getListProcessorTypesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ListProcessorTypesRequest,
            com.google.cloud.documentai.v1.ListProcessorTypesResponse>
        getListProcessorTypesMethod;
    if ((getListProcessorTypesMethod = DocumentProcessorServiceGrpc.getListProcessorTypesMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getListProcessorTypesMethod = DocumentProcessorServiceGrpc.getListProcessorTypesMethod)
            == null) {
          DocumentProcessorServiceGrpc.getListProcessorTypesMethod =
              getListProcessorTypesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ListProcessorTypesRequest,
                          com.google.cloud.documentai.v1.ListProcessorTypesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProcessorTypes"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorTypesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorTypesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "ListProcessorTypes"))
                      .build();
        }
      }
    }
    return getListProcessorTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorsRequest,
          com.google.cloud.documentai.v1.ListProcessorsResponse>
      getListProcessorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcessors",
      requestType = com.google.cloud.documentai.v1.ListProcessorsRequest.class,
      responseType = com.google.cloud.documentai.v1.ListProcessorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorsRequest,
          com.google.cloud.documentai.v1.ListProcessorsResponse>
      getListProcessorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ListProcessorsRequest,
            com.google.cloud.documentai.v1.ListProcessorsResponse>
        getListProcessorsMethod;
    if ((getListProcessorsMethod = DocumentProcessorServiceGrpc.getListProcessorsMethod) == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getListProcessorsMethod = DocumentProcessorServiceGrpc.getListProcessorsMethod)
            == null) {
          DocumentProcessorServiceGrpc.getListProcessorsMethod =
              getListProcessorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ListProcessorsRequest,
                          com.google.cloud.documentai.v1.ListProcessorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListProcessors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("ListProcessors"))
                      .build();
        }
      }
    }
    return getListProcessorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.GetProcessorRequest,
          com.google.cloud.documentai.v1.Processor>
      getGetProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProcessor",
      requestType = com.google.cloud.documentai.v1.GetProcessorRequest.class,
      responseType = com.google.cloud.documentai.v1.Processor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.GetProcessorRequest,
          com.google.cloud.documentai.v1.Processor>
      getGetProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.GetProcessorRequest,
            com.google.cloud.documentai.v1.Processor>
        getGetProcessorMethod;
    if ((getGetProcessorMethod = DocumentProcessorServiceGrpc.getGetProcessorMethod) == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getGetProcessorMethod = DocumentProcessorServiceGrpc.getGetProcessorMethod) == null) {
          DocumentProcessorServiceGrpc.getGetProcessorMethod =
              getGetProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.GetProcessorRequest,
                          com.google.cloud.documentai.v1.Processor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.GetProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.Processor.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("GetProcessor"))
                      .build();
        }
      }
    }
    return getGetProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.GetProcessorVersionRequest,
          com.google.cloud.documentai.v1.ProcessorVersion>
      getGetProcessorVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProcessorVersion",
      requestType = com.google.cloud.documentai.v1.GetProcessorVersionRequest.class,
      responseType = com.google.cloud.documentai.v1.ProcessorVersion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.GetProcessorVersionRequest,
          com.google.cloud.documentai.v1.ProcessorVersion>
      getGetProcessorVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.GetProcessorVersionRequest,
            com.google.cloud.documentai.v1.ProcessorVersion>
        getGetProcessorVersionMethod;
    if ((getGetProcessorVersionMethod = DocumentProcessorServiceGrpc.getGetProcessorVersionMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getGetProcessorVersionMethod =
                DocumentProcessorServiceGrpc.getGetProcessorVersionMethod)
            == null) {
          DocumentProcessorServiceGrpc.getGetProcessorVersionMethod =
              getGetProcessorVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.GetProcessorVersionRequest,
                          com.google.cloud.documentai.v1.ProcessorVersion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetProcessorVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.GetProcessorVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ProcessorVersion.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "GetProcessorVersion"))
                      .build();
        }
      }
    }
    return getGetProcessorVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorVersionsRequest,
          com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
      getListProcessorVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListProcessorVersions",
      requestType = com.google.cloud.documentai.v1.ListProcessorVersionsRequest.class,
      responseType = com.google.cloud.documentai.v1.ListProcessorVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ListProcessorVersionsRequest,
          com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
      getListProcessorVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ListProcessorVersionsRequest,
            com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
        getListProcessorVersionsMethod;
    if ((getListProcessorVersionsMethod =
            DocumentProcessorServiceGrpc.getListProcessorVersionsMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getListProcessorVersionsMethod =
                DocumentProcessorServiceGrpc.getListProcessorVersionsMethod)
            == null) {
          DocumentProcessorServiceGrpc.getListProcessorVersionsMethod =
              getListProcessorVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ListProcessorVersionsRequest,
                          com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListProcessorVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ListProcessorVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "ListProcessorVersions"))
                      .build();
        }
      }
    }
    return getListProcessorVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeleteProcessorVersionRequest,
          com.google.longrunning.Operation>
      getDeleteProcessorVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProcessorVersion",
      requestType = com.google.cloud.documentai.v1.DeleteProcessorVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeleteProcessorVersionRequest,
          com.google.longrunning.Operation>
      getDeleteProcessorVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.DeleteProcessorVersionRequest,
            com.google.longrunning.Operation>
        getDeleteProcessorVersionMethod;
    if ((getDeleteProcessorVersionMethod =
            DocumentProcessorServiceGrpc.getDeleteProcessorVersionMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getDeleteProcessorVersionMethod =
                DocumentProcessorServiceGrpc.getDeleteProcessorVersionMethod)
            == null) {
          DocumentProcessorServiceGrpc.getDeleteProcessorVersionMethod =
              getDeleteProcessorVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.DeleteProcessorVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteProcessorVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.DeleteProcessorVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "DeleteProcessorVersion"))
                      .build();
        }
      }
    }
    return getDeleteProcessorVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeployProcessorVersionRequest,
          com.google.longrunning.Operation>
      getDeployProcessorVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployProcessorVersion",
      requestType = com.google.cloud.documentai.v1.DeployProcessorVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeployProcessorVersionRequest,
          com.google.longrunning.Operation>
      getDeployProcessorVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.DeployProcessorVersionRequest,
            com.google.longrunning.Operation>
        getDeployProcessorVersionMethod;
    if ((getDeployProcessorVersionMethod =
            DocumentProcessorServiceGrpc.getDeployProcessorVersionMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getDeployProcessorVersionMethod =
                DocumentProcessorServiceGrpc.getDeployProcessorVersionMethod)
            == null) {
          DocumentProcessorServiceGrpc.getDeployProcessorVersionMethod =
              getDeployProcessorVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.DeployProcessorVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeployProcessorVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.DeployProcessorVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "DeployProcessorVersion"))
                      .build();
        }
      }
    }
    return getDeployProcessorVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.UndeployProcessorVersionRequest,
          com.google.longrunning.Operation>
      getUndeployProcessorVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployProcessorVersion",
      requestType = com.google.cloud.documentai.v1.UndeployProcessorVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.UndeployProcessorVersionRequest,
          com.google.longrunning.Operation>
      getUndeployProcessorVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.UndeployProcessorVersionRequest,
            com.google.longrunning.Operation>
        getUndeployProcessorVersionMethod;
    if ((getUndeployProcessorVersionMethod =
            DocumentProcessorServiceGrpc.getUndeployProcessorVersionMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getUndeployProcessorVersionMethod =
                DocumentProcessorServiceGrpc.getUndeployProcessorVersionMethod)
            == null) {
          DocumentProcessorServiceGrpc.getUndeployProcessorVersionMethod =
              getUndeployProcessorVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.UndeployProcessorVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeployProcessorVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.UndeployProcessorVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "UndeployProcessorVersion"))
                      .build();
        }
      }
    }
    return getUndeployProcessorVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.CreateProcessorRequest,
          com.google.cloud.documentai.v1.Processor>
      getCreateProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateProcessor",
      requestType = com.google.cloud.documentai.v1.CreateProcessorRequest.class,
      responseType = com.google.cloud.documentai.v1.Processor.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.CreateProcessorRequest,
          com.google.cloud.documentai.v1.Processor>
      getCreateProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.CreateProcessorRequest,
            com.google.cloud.documentai.v1.Processor>
        getCreateProcessorMethod;
    if ((getCreateProcessorMethod = DocumentProcessorServiceGrpc.getCreateProcessorMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getCreateProcessorMethod = DocumentProcessorServiceGrpc.getCreateProcessorMethod)
            == null) {
          DocumentProcessorServiceGrpc.getCreateProcessorMethod =
              getCreateProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.CreateProcessorRequest,
                          com.google.cloud.documentai.v1.Processor>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.CreateProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.Processor.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("CreateProcessor"))
                      .build();
        }
      }
    }
    return getCreateProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
      getDeleteProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteProcessor",
      requestType = com.google.cloud.documentai.v1.DeleteProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
      getDeleteProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.DeleteProcessorRequest, com.google.longrunning.Operation>
        getDeleteProcessorMethod;
    if ((getDeleteProcessorMethod = DocumentProcessorServiceGrpc.getDeleteProcessorMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getDeleteProcessorMethod = DocumentProcessorServiceGrpc.getDeleteProcessorMethod)
            == null) {
          DocumentProcessorServiceGrpc.getDeleteProcessorMethod =
              getDeleteProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.DeleteProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.DeleteProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("DeleteProcessor"))
                      .build();
        }
      }
    }
    return getDeleteProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.EnableProcessorRequest, com.google.longrunning.Operation>
      getEnableProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EnableProcessor",
      requestType = com.google.cloud.documentai.v1.EnableProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.EnableProcessorRequest, com.google.longrunning.Operation>
      getEnableProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.EnableProcessorRequest, com.google.longrunning.Operation>
        getEnableProcessorMethod;
    if ((getEnableProcessorMethod = DocumentProcessorServiceGrpc.getEnableProcessorMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getEnableProcessorMethod = DocumentProcessorServiceGrpc.getEnableProcessorMethod)
            == null) {
          DocumentProcessorServiceGrpc.getEnableProcessorMethod =
              getEnableProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.EnableProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EnableProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.EnableProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("EnableProcessor"))
                      .build();
        }
      }
    }
    return getEnableProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DisableProcessorRequest, com.google.longrunning.Operation>
      getDisableProcessorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DisableProcessor",
      requestType = com.google.cloud.documentai.v1.DisableProcessorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.DisableProcessorRequest, com.google.longrunning.Operation>
      getDisableProcessorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.DisableProcessorRequest,
            com.google.longrunning.Operation>
        getDisableProcessorMethod;
    if ((getDisableProcessorMethod = DocumentProcessorServiceGrpc.getDisableProcessorMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getDisableProcessorMethod = DocumentProcessorServiceGrpc.getDisableProcessorMethod)
            == null) {
          DocumentProcessorServiceGrpc.getDisableProcessorMethod =
              getDisableProcessorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.DisableProcessorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DisableProcessor"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.DisableProcessorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("DisableProcessor"))
                      .build();
        }
      }
    }
    return getDisableProcessorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest,
          com.google.longrunning.Operation>
      getSetDefaultProcessorVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SetDefaultProcessorVersion",
      requestType = com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest,
          com.google.longrunning.Operation>
      getSetDefaultProcessorVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest,
            com.google.longrunning.Operation>
        getSetDefaultProcessorVersionMethod;
    if ((getSetDefaultProcessorVersionMethod =
            DocumentProcessorServiceGrpc.getSetDefaultProcessorVersionMethod)
        == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getSetDefaultProcessorVersionMethod =
                DocumentProcessorServiceGrpc.getSetDefaultProcessorVersionMethod)
            == null) {
          DocumentProcessorServiceGrpc.getSetDefaultProcessorVersionMethod =
              getSetDefaultProcessorVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SetDefaultProcessorVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier(
                              "SetDefaultProcessorVersion"))
                      .build();
        }
      }
    }
    return getSetDefaultProcessorVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
      getReviewDocumentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReviewDocument",
      requestType = com.google.cloud.documentai.v1.ReviewDocumentRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
      getReviewDocumentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.documentai.v1.ReviewDocumentRequest, com.google.longrunning.Operation>
        getReviewDocumentMethod;
    if ((getReviewDocumentMethod = DocumentProcessorServiceGrpc.getReviewDocumentMethod) == null) {
      synchronized (DocumentProcessorServiceGrpc.class) {
        if ((getReviewDocumentMethod = DocumentProcessorServiceGrpc.getReviewDocumentMethod)
            == null) {
          DocumentProcessorServiceGrpc.getReviewDocumentMethod =
              getReviewDocumentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.documentai.v1.ReviewDocumentRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReviewDocument"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.documentai.v1.ReviewDocumentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DocumentProcessorServiceMethodDescriptorSupplier("ReviewDocument"))
                      .build();
        }
      }
    }
    return getReviewDocumentMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DocumentProcessorServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceStub>() {
          @java.lang.Override
          public DocumentProcessorServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DocumentProcessorServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceBlockingStub>() {
          @java.lang.Override
          public DocumentProcessorServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceBlockingStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DocumentProcessorServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DocumentProcessorServiceFutureStub>() {
          @java.lang.Override
          public DocumentProcessorServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DocumentProcessorServiceFutureStub(channel, callOptions);
          }
        };
    return DocumentProcessorServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public abstract static class DocumentProcessorServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getProcessDocumentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchProcessDocumentsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches processor types. Note that we do not use ListProcessorTypes here
     * because it is not paginated.
     * </pre>
     */
    public void fetchProcessorTypes(
        com.google.cloud.documentai.v1.FetchProcessorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getFetchProcessorTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processor types that exist.
     * </pre>
     */
    public void listProcessorTypes(
        com.google.cloud.documentai.v1.ListProcessorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorTypesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessorTypesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all processors which belong to this project.
     * </pre>
     */
    public void listProcessors(
        com.google.cloud.documentai.v1.ListProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor detail.
     * </pre>
     */
    public void getProcessor(
        com.google.cloud.documentai.v1.GetProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor version detail.
     * </pre>
     */
    public void getProcessorVersion(
        com.google.cloud.documentai.v1.GetProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessorVersion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetProcessorVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of a processor.
     * </pre>
     */
    public void listProcessorVersions(
        com.google.cloud.documentai.v1.ListProcessorVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListProcessorVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor version, all artifacts under the processor version
     * will be deleted.
     * </pre>
     */
    public void deleteProcessorVersion(
        com.google.cloud.documentai.v1.DeleteProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProcessorVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys the processor version.
     * </pre>
     */
    public void deployProcessorVersion(
        com.google.cloud.documentai.v1.DeployProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployProcessorVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys the processor version.
     * </pre>
     */
    public void undeployProcessorVersion(
        com.google.cloud.documentai.v1.UndeployProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployProcessorVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a processor from the type processor that the user chose.
     * The processor will be at "ENABLED" state by default after its creation.
     * </pre>
     */
    public void createProcessor(
        com.google.cloud.documentai.v1.CreateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor, unloads all deployed model artifacts if it was
     * enabled and then deletes all artifacts associated with this processor.
     * </pre>
     */
    public void deleteProcessor(
        com.google.cloud.documentai.v1.DeleteProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a processor
     * </pre>
     */
    public void enableProcessor(
        com.google.cloud.documentai.v1.EnableProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getEnableProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a processor
     * </pre>
     */
    public void disableProcessor(
        com.google.cloud.documentai.v1.DisableProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDisableProcessorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Set the default (active) version of a [Processor][google.cloud.documentai.v1.Processor] that will be used in
     * [ProcessDocument][google.cloud.documentai.v1.DocumentProcessorService.ProcessDocument] and
     * [BatchProcessDocuments][google.cloud.documentai.v1.DocumentProcessorService.BatchProcessDocuments].
     * </pre>
     */
    public void setDefaultProcessorVersion(
        com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSetDefaultProcessorVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public void reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getReviewDocumentMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getProcessDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ProcessRequest,
                      com.google.cloud.documentai.v1.ProcessResponse>(
                      this, METHODID_PROCESS_DOCUMENT)))
          .addMethod(
              getBatchProcessDocumentsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.BatchProcessRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_PROCESS_DOCUMENTS)))
          .addMethod(
              getFetchProcessorTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.FetchProcessorTypesRequest,
                      com.google.cloud.documentai.v1.FetchProcessorTypesResponse>(
                      this, METHODID_FETCH_PROCESSOR_TYPES)))
          .addMethod(
              getListProcessorTypesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ListProcessorTypesRequest,
                      com.google.cloud.documentai.v1.ListProcessorTypesResponse>(
                      this, METHODID_LIST_PROCESSOR_TYPES)))
          .addMethod(
              getListProcessorsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ListProcessorsRequest,
                      com.google.cloud.documentai.v1.ListProcessorsResponse>(
                      this, METHODID_LIST_PROCESSORS)))
          .addMethod(
              getGetProcessorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.GetProcessorRequest,
                      com.google.cloud.documentai.v1.Processor>(this, METHODID_GET_PROCESSOR)))
          .addMethod(
              getGetProcessorVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.GetProcessorVersionRequest,
                      com.google.cloud.documentai.v1.ProcessorVersion>(
                      this, METHODID_GET_PROCESSOR_VERSION)))
          .addMethod(
              getListProcessorVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ListProcessorVersionsRequest,
                      com.google.cloud.documentai.v1.ListProcessorVersionsResponse>(
                      this, METHODID_LIST_PROCESSOR_VERSIONS)))
          .addMethod(
              getDeleteProcessorVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.DeleteProcessorVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_PROCESSOR_VERSION)))
          .addMethod(
              getDeployProcessorVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.DeployProcessorVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_DEPLOY_PROCESSOR_VERSION)))
          .addMethod(
              getUndeployProcessorVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.UndeployProcessorVersionRequest,
                      com.google.longrunning.Operation>(this, METHODID_UNDEPLOY_PROCESSOR_VERSION)))
          .addMethod(
              getCreateProcessorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.CreateProcessorRequest,
                      com.google.cloud.documentai.v1.Processor>(this, METHODID_CREATE_PROCESSOR)))
          .addMethod(
              getDeleteProcessorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.DeleteProcessorRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_PROCESSOR)))
          .addMethod(
              getEnableProcessorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.EnableProcessorRequest,
                      com.google.longrunning.Operation>(this, METHODID_ENABLE_PROCESSOR)))
          .addMethod(
              getDisableProcessorMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.DisableProcessorRequest,
                      com.google.longrunning.Operation>(this, METHODID_DISABLE_PROCESSOR)))
          .addMethod(
              getSetDefaultProcessorVersionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_SET_DEFAULT_PROCESSOR_VERSION)))
          .addMethod(
              getReviewDocumentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.documentai.v1.ReviewDocumentRequest,
                      com.google.longrunning.Operation>(this, METHODID_REVIEW_DOCUMENT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceStub
      extends io.grpc.stub.AbstractAsyncStub<DocumentProcessorServiceStub> {
    private DocumentProcessorServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public void processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public void batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches processor types. Note that we do not use ListProcessorTypes here
     * because it is not paginated.
     * </pre>
     */
    public void fetchProcessorTypes(
        com.google.cloud.documentai.v1.FetchProcessorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getFetchProcessorTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the processor types that exist.
     * </pre>
     */
    public void listProcessorTypes(
        com.google.cloud.documentai.v1.ListProcessorTypesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorTypesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessorTypesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all processors which belong to this project.
     * </pre>
     */
    public void listProcessors(
        com.google.cloud.documentai.v1.ListProcessorsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor detail.
     * </pre>
     */
    public void getProcessor(
        com.google.cloud.documentai.v1.GetProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor version detail.
     * </pre>
     */
    public void getProcessorVersion(
        com.google.cloud.documentai.v1.GetProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessorVersion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProcessorVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of a processor.
     * </pre>
     */
    public void listProcessorVersions(
        com.google.cloud.documentai.v1.ListProcessorVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListProcessorVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor version, all artifacts under the processor version
     * will be deleted.
     * </pre>
     */
    public void deleteProcessorVersion(
        com.google.cloud.documentai.v1.DeleteProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProcessorVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys the processor version.
     * </pre>
     */
    public void deployProcessorVersion(
        com.google.cloud.documentai.v1.DeployProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployProcessorVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys the processor version.
     * </pre>
     */
    public void undeployProcessorVersion(
        com.google.cloud.documentai.v1.UndeployProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployProcessorVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a processor from the type processor that the user chose.
     * The processor will be at "ENABLED" state by default after its creation.
     * </pre>
     */
    public void createProcessor(
        com.google.cloud.documentai.v1.CreateProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor, unloads all deployed model artifacts if it was
     * enabled and then deletes all artifacts associated with this processor.
     * </pre>
     */
    public void deleteProcessor(
        com.google.cloud.documentai.v1.DeleteProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a processor
     * </pre>
     */
    public void enableProcessor(
        com.google.cloud.documentai.v1.EnableProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEnableProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a processor
     * </pre>
     */
    public void disableProcessor(
        com.google.cloud.documentai.v1.DisableProcessorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDisableProcessorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Set the default (active) version of a [Processor][google.cloud.documentai.v1.Processor] that will be used in
     * [ProcessDocument][google.cloud.documentai.v1.DocumentProcessorService.ProcessDocument] and
     * [BatchProcessDocuments][google.cloud.documentai.v1.DocumentProcessorService.BatchProcessDocuments].
     * </pre>
     */
    public void setDefaultProcessorVersion(
        com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSetDefaultProcessorVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public void reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReviewDocumentMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DocumentProcessorServiceBlockingStub> {
    private DocumentProcessorServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ProcessResponse processDocument(
        com.google.cloud.documentai.v1.ProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessDocumentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.longrunning.Operation batchProcessDocuments(
        com.google.cloud.documentai.v1.BatchProcessRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchProcessDocumentsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches processor types. Note that we do not use ListProcessorTypes here
     * because it is not paginated.
     * </pre>
     */
    public com.google.cloud.documentai.v1.FetchProcessorTypesResponse fetchProcessorTypes(
        com.google.cloud.documentai.v1.FetchProcessorTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getFetchProcessorTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processor types that exist.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ListProcessorTypesResponse listProcessorTypes(
        com.google.cloud.documentai.v1.ListProcessorTypesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessorTypesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all processors which belong to this project.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ListProcessorsResponse listProcessors(
        com.google.cloud.documentai.v1.ListProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor detail.
     * </pre>
     */
    public com.google.cloud.documentai.v1.Processor getProcessor(
        com.google.cloud.documentai.v1.GetProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor version detail.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ProcessorVersion getProcessorVersion(
        com.google.cloud.documentai.v1.GetProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProcessorVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of a processor.
     * </pre>
     */
    public com.google.cloud.documentai.v1.ListProcessorVersionsResponse listProcessorVersions(
        com.google.cloud.documentai.v1.ListProcessorVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListProcessorVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor version, all artifacts under the processor version
     * will be deleted.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProcessorVersion(
        com.google.cloud.documentai.v1.DeleteProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProcessorVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys the processor version.
     * </pre>
     */
    public com.google.longrunning.Operation deployProcessorVersion(
        com.google.cloud.documentai.v1.DeployProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployProcessorVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys the processor version.
     * </pre>
     */
    public com.google.longrunning.Operation undeployProcessorVersion(
        com.google.cloud.documentai.v1.UndeployProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployProcessorVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a processor from the type processor that the user chose.
     * The processor will be at "ENABLED" state by default after its creation.
     * </pre>
     */
    public com.google.cloud.documentai.v1.Processor createProcessor(
        com.google.cloud.documentai.v1.CreateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor, unloads all deployed model artifacts if it was
     * enabled and then deletes all artifacts associated with this processor.
     * </pre>
     */
    public com.google.longrunning.Operation deleteProcessor(
        com.google.cloud.documentai.v1.DeleteProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a processor
     * </pre>
     */
    public com.google.longrunning.Operation enableProcessor(
        com.google.cloud.documentai.v1.EnableProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEnableProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a processor
     * </pre>
     */
    public com.google.longrunning.Operation disableProcessor(
        com.google.cloud.documentai.v1.DisableProcessorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDisableProcessorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Set the default (active) version of a [Processor][google.cloud.documentai.v1.Processor] that will be used in
     * [ProcessDocument][google.cloud.documentai.v1.DocumentProcessorService.ProcessDocument] and
     * [BatchProcessDocuments][google.cloud.documentai.v1.DocumentProcessorService.BatchProcessDocuments].
     * </pre>
     */
    public com.google.longrunning.Operation setDefaultProcessorVersion(
        com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSetDefaultProcessorVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public com.google.longrunning.Operation reviewDocument(
        com.google.cloud.documentai.v1.ReviewDocumentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReviewDocumentMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to call Cloud DocumentAI to process documents according to the
   * processor's definition. Processors are built using state-of-the-art Google
   * AI such as natural language, computer vision, and translation to extract
   * structured information from unstructured or semi-structured documents.
   * </pre>
   */
  public static final class DocumentProcessorServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<DocumentProcessorServiceFutureStub> {
    private DocumentProcessorServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DocumentProcessorServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DocumentProcessorServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Processes a single document.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ProcessResponse>
        processDocument(com.google.cloud.documentai.v1.ProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessDocumentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * LRO endpoint to batch process many documents. The output is written
     * to Cloud Storage as JSON in the [Document] format.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchProcessDocuments(com.google.cloud.documentai.v1.BatchProcessRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchProcessDocumentsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches processor types. Note that we do not use ListProcessorTypes here
     * because it is not paginated.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.FetchProcessorTypesResponse>
        fetchProcessorTypes(com.google.cloud.documentai.v1.FetchProcessorTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getFetchProcessorTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the processor types that exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ListProcessorTypesResponse>
        listProcessorTypes(com.google.cloud.documentai.v1.ListProcessorTypesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessorTypesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all processors which belong to this project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ListProcessorsResponse>
        listProcessors(com.google.cloud.documentai.v1.ListProcessorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor detail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.Processor>
        getProcessor(com.google.cloud.documentai.v1.GetProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a processor version detail.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ProcessorVersion>
        getProcessorVersion(com.google.cloud.documentai.v1.GetProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProcessorVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all versions of a processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.ListProcessorVersionsResponse>
        listProcessorVersions(com.google.cloud.documentai.v1.ListProcessorVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListProcessorVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor version, all artifacts under the processor version
     * will be deleted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProcessorVersion(
            com.google.cloud.documentai.v1.DeleteProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProcessorVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys the processor version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployProcessorVersion(
            com.google.cloud.documentai.v1.DeployProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployProcessorVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys the processor version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployProcessorVersion(
            com.google.cloud.documentai.v1.UndeployProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployProcessorVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a processor from the type processor that the user chose.
     * The processor will be at "ENABLED" state by default after its creation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.documentai.v1.Processor>
        createProcessor(com.google.cloud.documentai.v1.CreateProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the processor, unloads all deployed model artifacts if it was
     * enabled and then deletes all artifacts associated with this processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteProcessor(com.google.cloud.documentai.v1.DeleteProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a processor
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        enableProcessor(com.google.cloud.documentai.v1.EnableProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEnableProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a processor
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        disableProcessor(com.google.cloud.documentai.v1.DisableProcessorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDisableProcessorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Set the default (active) version of a [Processor][google.cloud.documentai.v1.Processor] that will be used in
     * [ProcessDocument][google.cloud.documentai.v1.DocumentProcessorService.ProcessDocument] and
     * [BatchProcessDocuments][google.cloud.documentai.v1.DocumentProcessorService.BatchProcessDocuments].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        setDefaultProcessorVersion(
            com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSetDefaultProcessorVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Send a document for Human Review. The input document should be processed by
     * the specified processor.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        reviewDocument(com.google.cloud.documentai.v1.ReviewDocumentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReviewDocumentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_DOCUMENT = 0;
  private static final int METHODID_BATCH_PROCESS_DOCUMENTS = 1;
  private static final int METHODID_FETCH_PROCESSOR_TYPES = 2;
  private static final int METHODID_LIST_PROCESSOR_TYPES = 3;
  private static final int METHODID_LIST_PROCESSORS = 4;
  private static final int METHODID_GET_PROCESSOR = 5;
  private static final int METHODID_GET_PROCESSOR_VERSION = 6;
  private static final int METHODID_LIST_PROCESSOR_VERSIONS = 7;
  private static final int METHODID_DELETE_PROCESSOR_VERSION = 8;
  private static final int METHODID_DEPLOY_PROCESSOR_VERSION = 9;
  private static final int METHODID_UNDEPLOY_PROCESSOR_VERSION = 10;
  private static final int METHODID_CREATE_PROCESSOR = 11;
  private static final int METHODID_DELETE_PROCESSOR = 12;
  private static final int METHODID_ENABLE_PROCESSOR = 13;
  private static final int METHODID_DISABLE_PROCESSOR = 14;
  private static final int METHODID_SET_DEFAULT_PROCESSOR_VERSION = 15;
  private static final int METHODID_REVIEW_DOCUMENT = 16;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DocumentProcessorServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DocumentProcessorServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_DOCUMENT:
          serviceImpl.processDocument(
              (com.google.cloud.documentai.v1.ProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_PROCESS_DOCUMENTS:
          serviceImpl.batchProcessDocuments(
              (com.google.cloud.documentai.v1.BatchProcessRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_FETCH_PROCESSOR_TYPES:
          serviceImpl.fetchProcessorTypes(
              (com.google.cloud.documentai.v1.FetchProcessorTypesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.documentai.v1.FetchProcessorTypesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PROCESSOR_TYPES:
          serviceImpl.listProcessorTypes(
              (com.google.cloud.documentai.v1.ListProcessorTypesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.documentai.v1.ListProcessorTypesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_PROCESSORS:
          serviceImpl.listProcessors(
              (com.google.cloud.documentai.v1.ListProcessorsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ListProcessorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PROCESSOR:
          serviceImpl.getProcessor(
              (com.google.cloud.documentai.v1.GetProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor>)
                  responseObserver);
          break;
        case METHODID_GET_PROCESSOR_VERSION:
          serviceImpl.getProcessorVersion(
              (com.google.cloud.documentai.v1.GetProcessorVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.ProcessorVersion>)
                  responseObserver);
          break;
        case METHODID_LIST_PROCESSOR_VERSIONS:
          serviceImpl.listProcessorVersions(
              (com.google.cloud.documentai.v1.ListProcessorVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.documentai.v1.ListProcessorVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROCESSOR_VERSION:
          serviceImpl.deleteProcessorVersion(
              (com.google.cloud.documentai.v1.DeleteProcessorVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_PROCESSOR_VERSION:
          serviceImpl.deployProcessorVersion(
              (com.google.cloud.documentai.v1.DeployProcessorVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_PROCESSOR_VERSION:
          serviceImpl.undeployProcessorVersion(
              (com.google.cloud.documentai.v1.UndeployProcessorVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_PROCESSOR:
          serviceImpl.createProcessor(
              (com.google.cloud.documentai.v1.CreateProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.documentai.v1.Processor>)
                  responseObserver);
          break;
        case METHODID_DELETE_PROCESSOR:
          serviceImpl.deleteProcessor(
              (com.google.cloud.documentai.v1.DeleteProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_ENABLE_PROCESSOR:
          serviceImpl.enableProcessor(
              (com.google.cloud.documentai.v1.EnableProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DISABLE_PROCESSOR:
          serviceImpl.disableProcessor(
              (com.google.cloud.documentai.v1.DisableProcessorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_SET_DEFAULT_PROCESSOR_VERSION:
          serviceImpl.setDefaultProcessorVersion(
              (com.google.cloud.documentai.v1.SetDefaultProcessorVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REVIEW_DOCUMENT:
          serviceImpl.reviewDocument(
              (com.google.cloud.documentai.v1.ReviewDocumentRequest) request,
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

  private abstract static class DocumentProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DocumentProcessorServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.documentai.v1.DocumentAiProcessorService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DocumentProcessorService");
    }
  }

  private static final class DocumentProcessorServiceFileDescriptorSupplier
      extends DocumentProcessorServiceBaseDescriptorSupplier {
    DocumentProcessorServiceFileDescriptorSupplier() {}
  }

  private static final class DocumentProcessorServiceMethodDescriptorSupplier
      extends DocumentProcessorServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DocumentProcessorServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (DocumentProcessorServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DocumentProcessorServiceFileDescriptorSupplier())
                      .addMethod(getProcessDocumentMethod())
                      .addMethod(getBatchProcessDocumentsMethod())
                      .addMethod(getFetchProcessorTypesMethod())
                      .addMethod(getListProcessorTypesMethod())
                      .addMethod(getListProcessorsMethod())
                      .addMethod(getGetProcessorMethod())
                      .addMethod(getGetProcessorVersionMethod())
                      .addMethod(getListProcessorVersionsMethod())
                      .addMethod(getDeleteProcessorVersionMethod())
                      .addMethod(getDeployProcessorVersionMethod())
                      .addMethod(getUndeployProcessorVersionMethod())
                      .addMethod(getCreateProcessorMethod())
                      .addMethod(getDeleteProcessorMethod())
                      .addMethod(getEnableProcessorMethod())
                      .addMethod(getDisableProcessorMethod())
                      .addMethod(getSetDefaultProcessorVersionMethod())
                      .addMethod(getReviewDocumentMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
