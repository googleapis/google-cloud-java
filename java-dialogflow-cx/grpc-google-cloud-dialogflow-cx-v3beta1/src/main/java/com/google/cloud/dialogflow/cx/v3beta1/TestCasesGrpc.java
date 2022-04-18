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
package com.google.cloud.dialogflow.cx.v3beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Test Cases][google.cloud.dialogflow.cx.v3beta1.TestCase] and
 * [Test Case Results][google.cloud.dialogflow.cx.v3beta1.TestCaseResult].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/cx/v3beta1/test_case.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TestCasesGrpc {

  private TestCasesGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.cx.v3beta1.TestCases";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
      getListTestCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTestCases",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
      getListTestCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
        getListTestCasesMethod;
    if ((getListTestCasesMethod = TestCasesGrpc.getListTestCasesMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getListTestCasesMethod = TestCasesGrpc.getListTestCasesMethod) == null) {
          TestCasesGrpc.getListTestCasesMethod =
              getListTestCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTestCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("ListTestCases"))
                      .build();
        }
      }
    }
    return getListTestCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest,
          com.google.protobuf.Empty>
      getBatchDeleteTestCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchDeleteTestCases",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest,
          com.google.protobuf.Empty>
      getBatchDeleteTestCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest,
            com.google.protobuf.Empty>
        getBatchDeleteTestCasesMethod;
    if ((getBatchDeleteTestCasesMethod = TestCasesGrpc.getBatchDeleteTestCasesMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getBatchDeleteTestCasesMethod = TestCasesGrpc.getBatchDeleteTestCasesMethod) == null) {
          TestCasesGrpc.getBatchDeleteTestCasesMethod =
              getBatchDeleteTestCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BatchDeleteTestCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TestCasesMethodDescriptorSupplier("BatchDeleteTestCases"))
                      .build();
        }
      }
    }
    return getBatchDeleteTestCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getGetTestCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTestCase",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.TestCase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getGetTestCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest,
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        getGetTestCaseMethod;
    if ((getGetTestCaseMethod = TestCasesGrpc.getGetTestCaseMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getGetTestCaseMethod = TestCasesGrpc.getGetTestCaseMethod) == null) {
          TestCasesGrpc.getGetTestCaseMethod =
              getGetTestCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTestCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.TestCase.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("GetTestCase"))
                      .build();
        }
      }
    }
    return getGetTestCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getCreateTestCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTestCase",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.TestCase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getCreateTestCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest,
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        getCreateTestCaseMethod;
    if ((getCreateTestCaseMethod = TestCasesGrpc.getCreateTestCaseMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getCreateTestCaseMethod = TestCasesGrpc.getCreateTestCaseMethod) == null) {
          TestCasesGrpc.getCreateTestCaseMethod =
              getCreateTestCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTestCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.TestCase.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("CreateTestCase"))
                      .build();
        }
      }
    }
    return getCreateTestCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getUpdateTestCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTestCase",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.TestCase.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
      getUpdateTestCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest,
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        getUpdateTestCaseMethod;
    if ((getUpdateTestCaseMethod = TestCasesGrpc.getUpdateTestCaseMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getUpdateTestCaseMethod = TestCasesGrpc.getUpdateTestCaseMethod) == null) {
          TestCasesGrpc.getUpdateTestCaseMethod =
              getUpdateTestCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.TestCase>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTestCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.TestCase.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("UpdateTestCase"))
                      .build();
        }
      }
    }
    return getUpdateTestCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest,
          com.google.longrunning.Operation>
      getRunTestCaseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RunTestCase",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest,
          com.google.longrunning.Operation>
      getRunTestCaseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest,
            com.google.longrunning.Operation>
        getRunTestCaseMethod;
    if ((getRunTestCaseMethod = TestCasesGrpc.getRunTestCaseMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getRunTestCaseMethod = TestCasesGrpc.getRunTestCaseMethod) == null) {
          TestCasesGrpc.getRunTestCaseMethod =
              getRunTestCaseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RunTestCase"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("RunTestCase"))
                      .build();
        }
      }
    }
    return getRunTestCaseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest,
          com.google.longrunning.Operation>
      getBatchRunTestCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BatchRunTestCases",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest,
          com.google.longrunning.Operation>
      getBatchRunTestCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest,
            com.google.longrunning.Operation>
        getBatchRunTestCasesMethod;
    if ((getBatchRunTestCasesMethod = TestCasesGrpc.getBatchRunTestCasesMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getBatchRunTestCasesMethod = TestCasesGrpc.getBatchRunTestCasesMethod) == null) {
          TestCasesGrpc.getBatchRunTestCasesMethod =
              getBatchRunTestCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BatchRunTestCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TestCasesMethodDescriptorSupplier("BatchRunTestCases"))
                      .build();
        }
      }
    }
    return getBatchRunTestCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest,
          com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
      getCalculateCoverageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateCoverage",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest,
          com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
      getCalculateCoverageMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest,
            com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
        getCalculateCoverageMethod;
    if ((getCalculateCoverageMethod = TestCasesGrpc.getCalculateCoverageMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getCalculateCoverageMethod = TestCasesGrpc.getCalculateCoverageMethod) == null) {
          TestCasesGrpc.getCalculateCoverageMethod =
              getCalculateCoverageMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CalculateCoverage"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TestCasesMethodDescriptorSupplier("CalculateCoverage"))
                      .build();
        }
      }
    }
    return getCalculateCoverageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest,
          com.google.longrunning.Operation>
      getImportTestCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportTestCases",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest,
          com.google.longrunning.Operation>
      getImportTestCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest,
            com.google.longrunning.Operation>
        getImportTestCasesMethod;
    if ((getImportTestCasesMethod = TestCasesGrpc.getImportTestCasesMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getImportTestCasesMethod = TestCasesGrpc.getImportTestCasesMethod) == null) {
          TestCasesGrpc.getImportTestCasesMethod =
              getImportTestCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportTestCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("ImportTestCases"))
                      .build();
        }
      }
    }
    return getImportTestCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest,
          com.google.longrunning.Operation>
      getExportTestCasesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportTestCases",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest,
          com.google.longrunning.Operation>
      getExportTestCasesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest,
            com.google.longrunning.Operation>
        getExportTestCasesMethod;
    if ((getExportTestCasesMethod = TestCasesGrpc.getExportTestCasesMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getExportTestCasesMethod = TestCasesGrpc.getExportTestCasesMethod) == null) {
          TestCasesGrpc.getExportTestCasesMethod =
              getExportTestCasesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportTestCases"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new TestCasesMethodDescriptorSupplier("ExportTestCases"))
                      .build();
        }
      }
    }
    return getExportTestCasesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
      getListTestCaseResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTestCaseResults",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest,
          com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
      getListTestCaseResultsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest,
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
        getListTestCaseResultsMethod;
    if ((getListTestCaseResultsMethod = TestCasesGrpc.getListTestCaseResultsMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getListTestCaseResultsMethod = TestCasesGrpc.getListTestCaseResultsMethod) == null) {
          TestCasesGrpc.getListTestCaseResultsMethod =
              getListTestCaseResultsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTestCaseResults"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TestCasesMethodDescriptorSupplier("ListTestCaseResults"))
                      .build();
        }
      }
    }
    return getListTestCaseResultsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
      getGetTestCaseResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTestCaseResult",
      requestType = com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest.class,
      responseType = com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest,
          com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
      getGetTestCaseResultMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest,
            com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
        getGetTestCaseResultMethod;
    if ((getGetTestCaseResultMethod = TestCasesGrpc.getGetTestCaseResultMethod) == null) {
      synchronized (TestCasesGrpc.class) {
        if ((getGetTestCaseResultMethod = TestCasesGrpc.getGetTestCaseResultMethod) == null) {
          TestCasesGrpc.getGetTestCaseResultMethod =
              getGetTestCaseResultMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest,
                          com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTestCaseResult"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new TestCasesMethodDescriptorSupplier("GetTestCaseResult"))
                      .build();
        }
      }
    }
    return getGetTestCaseResultMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static TestCasesStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestCasesStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestCasesStub>() {
          @java.lang.Override
          public TestCasesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestCasesStub(channel, callOptions);
          }
        };
    return TestCasesStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestCasesBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestCasesBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestCasesBlockingStub>() {
          @java.lang.Override
          public TestCasesBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestCasesBlockingStub(channel, callOptions);
          }
        };
    return TestCasesBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static TestCasesFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TestCasesFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<TestCasesFutureStub>() {
          @java.lang.Override
          public TestCasesFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new TestCasesFutureStub(channel, callOptions);
          }
        };
    return TestCasesFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Test Cases][google.cloud.dialogflow.cx.v3beta1.TestCase] and
   * [Test Case Results][google.cloud.dialogflow.cx.v3beta1.TestCaseResult].
   * </pre>
   */
  public abstract static class TestCasesImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Fetches a list of test cases for a given agent.
     * </pre>
     */
    public void listTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTestCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes test cases.
     * </pre>
     */
    public void batchDeleteTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchDeleteTestCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case.
     * </pre>
     */
    public void getTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTestCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a test case for the given agent.
     * </pre>
     */
    public void createTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTestCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified test case.
     * </pre>
     */
    public void updateTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTestCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a test case run.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata]
     * - `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse]
     * </pre>
     */
    public void runTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRunTestCaseMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a batch run of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata]
     * - `response`: [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse]
     * </pre>
     */
    public void batchRunTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBatchRunTestCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Calculates the test coverage for an agent.
     * </pre>
     */
    public void calculateCoverage(
        com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateCoverageMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the test cases from a Cloud Storage bucket or a local file. It
     * always creates new test cases and won't overwrite any existing ones. The
     * provided ID in the imported test case is neglected.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata]
     * - `response`: [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse]
     * </pre>
     */
    public void importTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportTestCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the test cases under the agent to a Cloud Storage bucket or a local
     * file. Filter can be applied to export a subset of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata]
     * - `response`: [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse]
     * </pre>
     */
    public void exportTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportTestCasesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of results for a given test case.
     * </pre>
     */
    public void listTestCaseResults(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTestCaseResultsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case result.
     * </pre>
     */
    public void getTestCaseResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTestCaseResultMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListTestCasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>(
                      this, METHODID_LIST_TEST_CASES)))
          .addMethod(
              getBatchDeleteTestCasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest,
                      com.google.protobuf.Empty>(this, METHODID_BATCH_DELETE_TEST_CASES)))
          .addMethod(
              getGetTestCaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.TestCase>(
                      this, METHODID_GET_TEST_CASE)))
          .addMethod(
              getCreateTestCaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.TestCase>(
                      this, METHODID_CREATE_TEST_CASE)))
          .addMethod(
              getUpdateTestCaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.TestCase>(
                      this, METHODID_UPDATE_TEST_CASE)))
          .addMethod(
              getRunTestCaseMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest,
                      com.google.longrunning.Operation>(this, METHODID_RUN_TEST_CASE)))
          .addMethod(
              getBatchRunTestCasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest,
                      com.google.longrunning.Operation>(this, METHODID_BATCH_RUN_TEST_CASES)))
          .addMethod(
              getCalculateCoverageMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>(
                      this, METHODID_CALCULATE_COVERAGE)))
          .addMethod(
              getImportTestCasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest,
                      com.google.longrunning.Operation>(this, METHODID_IMPORT_TEST_CASES)))
          .addMethod(
              getExportTestCasesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest,
                      com.google.longrunning.Operation>(this, METHODID_EXPORT_TEST_CASES)))
          .addMethod(
              getListTestCaseResultsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>(
                      this, METHODID_LIST_TEST_CASE_RESULTS)))
          .addMethod(
              getGetTestCaseResultMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest,
                      com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>(
                      this, METHODID_GET_TEST_CASE_RESULT)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Test Cases][google.cloud.dialogflow.cx.v3beta1.TestCase] and
   * [Test Case Results][google.cloud.dialogflow.cx.v3beta1.TestCaseResult].
   * </pre>
   */
  public static final class TestCasesStub extends io.grpc.stub.AbstractAsyncStub<TestCasesStub> {
    private TestCasesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestCasesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestCasesStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of test cases for a given agent.
     * </pre>
     */
    public void listTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTestCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes test cases.
     * </pre>
     */
    public void batchDeleteTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchDeleteTestCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case.
     * </pre>
     */
    public void getTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTestCaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a test case for the given agent.
     * </pre>
     */
    public void createTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTestCaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified test case.
     * </pre>
     */
    public void updateTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTestCaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a test case run.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata]
     * - `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse]
     * </pre>
     */
    public void runTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRunTestCaseMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a batch run of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata]
     * - `response`: [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse]
     * </pre>
     */
    public void batchRunTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBatchRunTestCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Calculates the test coverage for an agent.
     * </pre>
     */
    public void calculateCoverage(
        com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateCoverageMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports the test cases from a Cloud Storage bucket or a local file. It
     * always creates new test cases and won't overwrite any existing ones. The
     * provided ID in the imported test case is neglected.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata]
     * - `response`: [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse]
     * </pre>
     */
    public void importTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportTestCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports the test cases under the agent to a Cloud Storage bucket or a local
     * file. Filter can be applied to export a subset of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata]
     * - `response`: [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse]
     * </pre>
     */
    public void exportTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportTestCasesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of results for a given test case.
     * </pre>
     */
    public void listTestCaseResults(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTestCaseResultsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case result.
     * </pre>
     */
    public void getTestCaseResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTestCaseResultMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Test Cases][google.cloud.dialogflow.cx.v3beta1.TestCase] and
   * [Test Case Results][google.cloud.dialogflow.cx.v3beta1.TestCaseResult].
   * </pre>
   */
  public static final class TestCasesBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TestCasesBlockingStub> {
    private TestCasesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestCasesBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestCasesBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of test cases for a given agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse listTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTestCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes test cases.
     * </pre>
     */
    public com.google.protobuf.Empty batchDeleteTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchDeleteTestCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.TestCase getTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTestCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a test case for the given agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.TestCase createTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTestCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified test case.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.TestCase updateTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTestCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a test case run.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata]
     * - `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse]
     * </pre>
     */
    public com.google.longrunning.Operation runTestCase(
        com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRunTestCaseMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a batch run of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata]
     * - `response`: [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse]
     * </pre>
     */
    public com.google.longrunning.Operation batchRunTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBatchRunTestCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Calculates the test coverage for an agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse calculateCoverage(
        com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateCoverageMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the test cases from a Cloud Storage bucket or a local file. It
     * always creates new test cases and won't overwrite any existing ones. The
     * provided ID in the imported test case is neglected.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata]
     * - `response`: [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse]
     * </pre>
     */
    public com.google.longrunning.Operation importTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportTestCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the test cases under the agent to a Cloud Storage bucket or a local
     * file. Filter can be applied to export a subset of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata]
     * - `response`: [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse]
     * </pre>
     */
    public com.google.longrunning.Operation exportTestCases(
        com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportTestCasesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of results for a given test case.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse listTestCaseResults(
        com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTestCaseResultsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case result.
     * </pre>
     */
    public com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult getTestCaseResult(
        com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTestCaseResultMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Test Cases][google.cloud.dialogflow.cx.v3beta1.TestCase] and
   * [Test Case Results][google.cloud.dialogflow.cx.v3beta1.TestCaseResult].
   * </pre>
   */
  public static final class TestCasesFutureStub
      extends io.grpc.stub.AbstractFutureStub<TestCasesFutureStub> {
    private TestCasesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestCasesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TestCasesFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of test cases for a given agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>
        listTestCases(com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTestCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Batch deletes test cases.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        batchDeleteTestCases(
            com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchDeleteTestCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        getTestCase(com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTestCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a test case for the given agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        createTestCase(com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTestCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified test case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.TestCase>
        updateTestCase(com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTestCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a test case run.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [RunTestCaseMetadata][google.cloud.dialogflow.cx.v3beta1.RunTestCaseMetadata]
     * - `response`: [RunTestCaseResponse][google.cloud.dialogflow.cx.v3beta1.RunTestCaseResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        runTestCase(com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRunTestCaseMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Kicks off a batch run of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [BatchRunTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesMetadata]
     * - `response`: [BatchRunTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        batchRunTestCases(com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBatchRunTestCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Calculates the test coverage for an agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>
        calculateCoverage(com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateCoverageMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports the test cases from a Cloud Storage bucket or a local file. It
     * always creates new test cases and won't overwrite any existing ones. The
     * provided ID in the imported test case is neglected.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ImportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesMetadata]
     * - `response`: [ImportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ImportTestCasesResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importTestCases(com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportTestCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports the test cases under the agent to a Cloud Storage bucket or a local
     * file. Filter can be applied to export a subset of test cases.
     * This method is a [long-running
     * operation](https://cloud.google.com/dialogflow/cx/docs/how/long-running-operation).
     * The returned `Operation` type has the following method-specific fields:
     * - `metadata`: [ExportTestCasesMetadata][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesMetadata]
     * - `response`: [ExportTestCasesResponse][google.cloud.dialogflow.cx.v3beta1.ExportTestCasesResponse]
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportTestCases(com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportTestCasesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fetches a list of results for a given test case.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>
        listTestCaseResults(
            com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTestCaseResultsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a test case result.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>
        getTestCaseResult(com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTestCaseResultMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TEST_CASES = 0;
  private static final int METHODID_BATCH_DELETE_TEST_CASES = 1;
  private static final int METHODID_GET_TEST_CASE = 2;
  private static final int METHODID_CREATE_TEST_CASE = 3;
  private static final int METHODID_UPDATE_TEST_CASE = 4;
  private static final int METHODID_RUN_TEST_CASE = 5;
  private static final int METHODID_BATCH_RUN_TEST_CASES = 6;
  private static final int METHODID_CALCULATE_COVERAGE = 7;
  private static final int METHODID_IMPORT_TEST_CASES = 8;
  private static final int METHODID_EXPORT_TEST_CASES = 9;
  private static final int METHODID_LIST_TEST_CASE_RESULTS = 10;
  private static final int METHODID_GET_TEST_CASE_RESULT = 11;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestCasesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestCasesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_TEST_CASES:
          serviceImpl.listTestCases(
              (com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCasesResponse>)
                  responseObserver);
          break;
        case METHODID_BATCH_DELETE_TEST_CASES:
          serviceImpl.batchDeleteTestCases(
              (com.google.cloud.dialogflow.cx.v3beta1.BatchDeleteTestCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_TEST_CASE:
          serviceImpl.getTestCase(
              (com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>)
                  responseObserver);
          break;
        case METHODID_CREATE_TEST_CASE:
          serviceImpl.createTestCase(
              (com.google.cloud.dialogflow.cx.v3beta1.CreateTestCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TEST_CASE:
          serviceImpl.updateTestCase(
              (com.google.cloud.dialogflow.cx.v3beta1.UpdateTestCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCase>)
                  responseObserver);
          break;
        case METHODID_RUN_TEST_CASE:
          serviceImpl.runTestCase(
              (com.google.cloud.dialogflow.cx.v3beta1.RunTestCaseRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BATCH_RUN_TEST_CASES:
          serviceImpl.batchRunTestCases(
              (com.google.cloud.dialogflow.cx.v3beta1.BatchRunTestCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CALCULATE_COVERAGE:
          serviceImpl.calculateCoverage(
              (com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.CalculateCoverageResponse>)
                  responseObserver);
          break;
        case METHODID_IMPORT_TEST_CASES:
          serviceImpl.importTestCases(
              (com.google.cloud.dialogflow.cx.v3beta1.ImportTestCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_TEST_CASES:
          serviceImpl.exportTestCases(
              (com.google.cloud.dialogflow.cx.v3beta1.ExportTestCasesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_TEST_CASE_RESULTS:
          serviceImpl.listTestCaseResults(
              (com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.cx.v3beta1.ListTestCaseResultsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TEST_CASE_RESULT:
          serviceImpl.getTestCaseResult(
              (com.google.cloud.dialogflow.cx.v3beta1.GetTestCaseResultRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.cx.v3beta1.TestCaseResult>)
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

  private abstract static class TestCasesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestCasesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.cx.v3beta1.TestCaseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestCases");
    }
  }

  private static final class TestCasesFileDescriptorSupplier
      extends TestCasesBaseDescriptorSupplier {
    TestCasesFileDescriptorSupplier() {}
  }

  private static final class TestCasesMethodDescriptorSupplier
      extends TestCasesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestCasesMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestCasesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new TestCasesFileDescriptorSupplier())
                      .addMethod(getListTestCasesMethod())
                      .addMethod(getBatchDeleteTestCasesMethod())
                      .addMethod(getGetTestCaseMethod())
                      .addMethod(getCreateTestCaseMethod())
                      .addMethod(getUpdateTestCaseMethod())
                      .addMethod(getRunTestCaseMethod())
                      .addMethod(getBatchRunTestCasesMethod())
                      .addMethod(getCalculateCoverageMethod())
                      .addMethod(getImportTestCasesMethod())
                      .addMethod(getExportTestCasesMethod())
                      .addMethod(getListTestCaseResultsMethod())
                      .addMethod(getGetTestCaseResultMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
