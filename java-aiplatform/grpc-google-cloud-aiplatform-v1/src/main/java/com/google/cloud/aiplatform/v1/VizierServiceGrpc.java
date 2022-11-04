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
package com.google.cloud.aiplatform.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Vertex AI Vizier API.
 * Vertex AI Vizier is a service to solve blackbox optimization problems,
 * such as tuning machine learning hyperparameters and searching over deep
 * learning architectures.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/aiplatform/v1/vizier_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VizierServiceGrpc {

  private VizierServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.aiplatform.v1.VizierService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getCreateStudyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateStudy",
      requestType = com.google.cloud.aiplatform.v1.CreateStudyRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Study.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getCreateStudyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateStudyRequest, com.google.cloud.aiplatform.v1.Study>
        getCreateStudyMethod;
    if ((getCreateStudyMethod = VizierServiceGrpc.getCreateStudyMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getCreateStudyMethod = VizierServiceGrpc.getCreateStudyMethod) == null) {
          VizierServiceGrpc.getCreateStudyMethod =
              getCreateStudyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateStudyRequest,
                          com.google.cloud.aiplatform.v1.Study>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateStudy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateStudyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Study.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("CreateStudy"))
                      .build();
        }
      }
    }
    return getCreateStudyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getGetStudyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudy",
      requestType = com.google.cloud.aiplatform.v1.GetStudyRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Study.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getGetStudyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetStudyRequest, com.google.cloud.aiplatform.v1.Study>
        getGetStudyMethod;
    if ((getGetStudyMethod = VizierServiceGrpc.getGetStudyMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getGetStudyMethod = VizierServiceGrpc.getGetStudyMethod) == null) {
          VizierServiceGrpc.getGetStudyMethod =
              getGetStudyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetStudyRequest,
                          com.google.cloud.aiplatform.v1.Study>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetStudyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Study.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("GetStudy"))
                      .build();
        }
      }
    }
    return getGetStudyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListStudiesRequest,
          com.google.cloud.aiplatform.v1.ListStudiesResponse>
      getListStudiesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListStudies",
      requestType = com.google.cloud.aiplatform.v1.ListStudiesRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListStudiesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListStudiesRequest,
          com.google.cloud.aiplatform.v1.ListStudiesResponse>
      getListStudiesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListStudiesRequest,
            com.google.cloud.aiplatform.v1.ListStudiesResponse>
        getListStudiesMethod;
    if ((getListStudiesMethod = VizierServiceGrpc.getListStudiesMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getListStudiesMethod = VizierServiceGrpc.getListStudiesMethod) == null) {
          VizierServiceGrpc.getListStudiesMethod =
              getListStudiesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListStudiesRequest,
                          com.google.cloud.aiplatform.v1.ListStudiesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListStudies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListStudiesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListStudiesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("ListStudies"))
                      .build();
        }
      }
    }
    return getListStudiesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteStudyRequest, com.google.protobuf.Empty>
      getDeleteStudyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteStudy",
      requestType = com.google.cloud.aiplatform.v1.DeleteStudyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteStudyRequest, com.google.protobuf.Empty>
      getDeleteStudyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteStudyRequest, com.google.protobuf.Empty>
        getDeleteStudyMethod;
    if ((getDeleteStudyMethod = VizierServiceGrpc.getDeleteStudyMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getDeleteStudyMethod = VizierServiceGrpc.getDeleteStudyMethod) == null) {
          VizierServiceGrpc.getDeleteStudyMethod =
              getDeleteStudyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteStudyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteStudy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteStudyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("DeleteStudy"))
                      .build();
        }
      }
    }
    return getDeleteStudyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.LookupStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getLookupStudyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LookupStudy",
      requestType = com.google.cloud.aiplatform.v1.LookupStudyRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Study.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.LookupStudyRequest, com.google.cloud.aiplatform.v1.Study>
      getLookupStudyMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.LookupStudyRequest, com.google.cloud.aiplatform.v1.Study>
        getLookupStudyMethod;
    if ((getLookupStudyMethod = VizierServiceGrpc.getLookupStudyMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getLookupStudyMethod = VizierServiceGrpc.getLookupStudyMethod) == null) {
          VizierServiceGrpc.getLookupStudyMethod =
              getLookupStudyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.LookupStudyRequest,
                          com.google.cloud.aiplatform.v1.Study>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LookupStudy"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.LookupStudyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Study.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("LookupStudy"))
                      .build();
        }
      }
    }
    return getLookupStudyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.SuggestTrialsRequest, com.google.longrunning.Operation>
      getSuggestTrialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestTrials",
      requestType = com.google.cloud.aiplatform.v1.SuggestTrialsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.SuggestTrialsRequest, com.google.longrunning.Operation>
      getSuggestTrialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.SuggestTrialsRequest, com.google.longrunning.Operation>
        getSuggestTrialsMethod;
    if ((getSuggestTrialsMethod = VizierServiceGrpc.getSuggestTrialsMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getSuggestTrialsMethod = VizierServiceGrpc.getSuggestTrialsMethod) == null) {
          VizierServiceGrpc.getSuggestTrialsMethod =
              getSuggestTrialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.SuggestTrialsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuggestTrials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.SuggestTrialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VizierServiceMethodDescriptorSupplier("SuggestTrials"))
                      .build();
        }
      }
    }
    return getSuggestTrialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getCreateTrialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTrial",
      requestType = com.google.cloud.aiplatform.v1.CreateTrialRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Trial.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CreateTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getCreateTrialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CreateTrialRequest, com.google.cloud.aiplatform.v1.Trial>
        getCreateTrialMethod;
    if ((getCreateTrialMethod = VizierServiceGrpc.getCreateTrialMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getCreateTrialMethod = VizierServiceGrpc.getCreateTrialMethod) == null) {
          VizierServiceGrpc.getCreateTrialMethod =
              getCreateTrialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CreateTrialRequest,
                          com.google.cloud.aiplatform.v1.Trial>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTrial"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CreateTrialRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Trial.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("CreateTrial"))
                      .build();
        }
      }
    }
    return getCreateTrialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getGetTrialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTrial",
      requestType = com.google.cloud.aiplatform.v1.GetTrialRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Trial.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.GetTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getGetTrialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.GetTrialRequest, com.google.cloud.aiplatform.v1.Trial>
        getGetTrialMethod;
    if ((getGetTrialMethod = VizierServiceGrpc.getGetTrialMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getGetTrialMethod = VizierServiceGrpc.getGetTrialMethod) == null) {
          VizierServiceGrpc.getGetTrialMethod =
              getGetTrialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.GetTrialRequest,
                          com.google.cloud.aiplatform.v1.Trial>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTrial"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.GetTrialRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Trial.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("GetTrial"))
                      .build();
        }
      }
    }
    return getGetTrialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListTrialsRequest,
          com.google.cloud.aiplatform.v1.ListTrialsResponse>
      getListTrialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTrials",
      requestType = com.google.cloud.aiplatform.v1.ListTrialsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListTrialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListTrialsRequest,
          com.google.cloud.aiplatform.v1.ListTrialsResponse>
      getListTrialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListTrialsRequest,
            com.google.cloud.aiplatform.v1.ListTrialsResponse>
        getListTrialsMethod;
    if ((getListTrialsMethod = VizierServiceGrpc.getListTrialsMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getListTrialsMethod = VizierServiceGrpc.getListTrialsMethod) == null) {
          VizierServiceGrpc.getListTrialsMethod =
              getListTrialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListTrialsRequest,
                          com.google.cloud.aiplatform.v1.ListTrialsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTrials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListTrialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListTrialsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("ListTrials"))
                      .build();
        }
      }
    }
    return getListTrialsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest,
          com.google.cloud.aiplatform.v1.Trial>
      getAddTrialMeasurementMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddTrialMeasurement",
      requestType = com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Trial.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest,
          com.google.cloud.aiplatform.v1.Trial>
      getAddTrialMeasurementMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest,
            com.google.cloud.aiplatform.v1.Trial>
        getAddTrialMeasurementMethod;
    if ((getAddTrialMeasurementMethod = VizierServiceGrpc.getAddTrialMeasurementMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getAddTrialMeasurementMethod = VizierServiceGrpc.getAddTrialMeasurementMethod)
            == null) {
          VizierServiceGrpc.getAddTrialMeasurementMethod =
              getAddTrialMeasurementMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest,
                          com.google.cloud.aiplatform.v1.Trial>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "AddTrialMeasurement"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Trial.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VizierServiceMethodDescriptorSupplier("AddTrialMeasurement"))
                      .build();
        }
      }
    }
    return getAddTrialMeasurementMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CompleteTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getCompleteTrialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompleteTrial",
      requestType = com.google.cloud.aiplatform.v1.CompleteTrialRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Trial.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CompleteTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getCompleteTrialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CompleteTrialRequest,
            com.google.cloud.aiplatform.v1.Trial>
        getCompleteTrialMethod;
    if ((getCompleteTrialMethod = VizierServiceGrpc.getCompleteTrialMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getCompleteTrialMethod = VizierServiceGrpc.getCompleteTrialMethod) == null) {
          VizierServiceGrpc.getCompleteTrialMethod =
              getCompleteTrialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CompleteTrialRequest,
                          com.google.cloud.aiplatform.v1.Trial>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompleteTrial"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CompleteTrialRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Trial.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VizierServiceMethodDescriptorSupplier("CompleteTrial"))
                      .build();
        }
      }
    }
    return getCompleteTrialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteTrialRequest, com.google.protobuf.Empty>
      getDeleteTrialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTrial",
      requestType = com.google.cloud.aiplatform.v1.DeleteTrialRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.DeleteTrialRequest, com.google.protobuf.Empty>
      getDeleteTrialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.DeleteTrialRequest, com.google.protobuf.Empty>
        getDeleteTrialMethod;
    if ((getDeleteTrialMethod = VizierServiceGrpc.getDeleteTrialMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getDeleteTrialMethod = VizierServiceGrpc.getDeleteTrialMethod) == null) {
          VizierServiceGrpc.getDeleteTrialMethod =
              getDeleteTrialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.DeleteTrialRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTrial"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.DeleteTrialRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("DeleteTrial"))
                      .build();
        }
      }
    }
    return getDeleteTrialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest,
          com.google.longrunning.Operation>
      getCheckTrialEarlyStoppingStateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckTrialEarlyStoppingState",
      requestType = com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest,
          com.google.longrunning.Operation>
      getCheckTrialEarlyStoppingStateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest,
            com.google.longrunning.Operation>
        getCheckTrialEarlyStoppingStateMethod;
    if ((getCheckTrialEarlyStoppingStateMethod =
            VizierServiceGrpc.getCheckTrialEarlyStoppingStateMethod)
        == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getCheckTrialEarlyStoppingStateMethod =
                VizierServiceGrpc.getCheckTrialEarlyStoppingStateMethod)
            == null) {
          VizierServiceGrpc.getCheckTrialEarlyStoppingStateMethod =
              getCheckTrialEarlyStoppingStateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CheckTrialEarlyStoppingState"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VizierServiceMethodDescriptorSupplier("CheckTrialEarlyStoppingState"))
                      .build();
        }
      }
    }
    return getCheckTrialEarlyStoppingStateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.StopTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getStopTrialMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StopTrial",
      requestType = com.google.cloud.aiplatform.v1.StopTrialRequest.class,
      responseType = com.google.cloud.aiplatform.v1.Trial.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.StopTrialRequest, com.google.cloud.aiplatform.v1.Trial>
      getStopTrialMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.StopTrialRequest, com.google.cloud.aiplatform.v1.Trial>
        getStopTrialMethod;
    if ((getStopTrialMethod = VizierServiceGrpc.getStopTrialMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getStopTrialMethod = VizierServiceGrpc.getStopTrialMethod) == null) {
          VizierServiceGrpc.getStopTrialMethod =
              getStopTrialMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.StopTrialRequest,
                          com.google.cloud.aiplatform.v1.Trial>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StopTrial"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.StopTrialRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.Trial.getDefaultInstance()))
                      .setSchemaDescriptor(new VizierServiceMethodDescriptorSupplier("StopTrial"))
                      .build();
        }
      }
    }
    return getStopTrialMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest,
          com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
      getListOptimalTrialsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOptimalTrials",
      requestType = com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest.class,
      responseType = com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest,
          com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
      getListOptimalTrialsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest,
            com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
        getListOptimalTrialsMethod;
    if ((getListOptimalTrialsMethod = VizierServiceGrpc.getListOptimalTrialsMethod) == null) {
      synchronized (VizierServiceGrpc.class) {
        if ((getListOptimalTrialsMethod = VizierServiceGrpc.getListOptimalTrialsMethod) == null) {
          VizierServiceGrpc.getListOptimalTrialsMethod =
              getListOptimalTrialsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest,
                          com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOptimalTrials"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new VizierServiceMethodDescriptorSupplier("ListOptimalTrials"))
                      .build();
        }
      }
    }
    return getListOptimalTrialsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VizierServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VizierServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VizierServiceStub>() {
          @java.lang.Override
          public VizierServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VizierServiceStub(channel, callOptions);
          }
        };
    return VizierServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VizierServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VizierServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VizierServiceBlockingStub>() {
          @java.lang.Override
          public VizierServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VizierServiceBlockingStub(channel, callOptions);
          }
        };
    return VizierServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VizierServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VizierServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VizierServiceFutureStub>() {
          @java.lang.Override
          public VizierServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VizierServiceFutureStub(channel, callOptions);
          }
        };
    return VizierServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Vertex AI Vizier API.
   * Vertex AI Vizier is a service to solve blackbox optimization problems,
   * such as tuning machine learning hyperparameters and searching over deep
   * learning architectures.
   * </pre>
   */
  public abstract static class VizierServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a Study. A resource name will be generated after creation of the
     * Study.
     * </pre>
     */
    public void createStudy(
        com.google.cloud.aiplatform.v1.CreateStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateStudyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Study by name.
     * </pre>
     */
    public void getStudy(
        com.google.cloud.aiplatform.v1.GetStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the studies in a region for an associated project.
     * </pre>
     */
    public void listStudies(
        com.google.cloud.aiplatform.v1.ListStudiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListStudiesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListStudiesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Study.
     * </pre>
     */
    public void deleteStudy(
        com.google.cloud.aiplatform.v1.DeleteStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteStudyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks a study up using the user-defined display_name field instead of the
     * fully qualified resource name.
     * </pre>
     */
    public void lookupStudy(
        com.google.cloud.aiplatform.v1.LookupStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getLookupStudyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more Trials to a Study, with parameter values
     * suggested by Vertex AI Vizier. Returns a long-running
     * operation associated with the generation of Trial suggestions.
     * When this long-running operation succeeds, it will contain
     * a [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
     * </pre>
     */
    public void suggestTrials(
        com.google.cloud.aiplatform.v1.SuggestTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuggestTrialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a user provided Trial to a Study.
     * </pre>
     */
    public void createTrial(
        com.google.cloud.aiplatform.v1.CreateTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTrialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Trial.
     * </pre>
     */
    public void getTrial(
        com.google.cloud.aiplatform.v1.GetTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTrialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Trials associated with a Study.
     * </pre>
     */
    public void listTrials(
        com.google.cloud.aiplatform.v1.ListTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrialsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListTrialsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a measurement of the objective metrics to a Trial. This measurement
     * is assumed to have been taken before the Trial is complete.
     * </pre>
     */
    public void addTrialMeasurement(
        com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAddTrialMeasurementMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a Trial as complete.
     * </pre>
     */
    public void completeTrial(
        com.google.cloud.aiplatform.v1.CompleteTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompleteTrialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Trial.
     * </pre>
     */
    public void deleteTrial(
        com.google.cloud.aiplatform.v1.DeleteTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTrialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks  whether a Trial should stop or not. Returns a
     * long-running operation. When the operation is successful,
     * it will contain a
     * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
     * </pre>
     */
    public void checkTrialEarlyStoppingState(
        com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCheckTrialEarlyStoppingStateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a Trial.
     * </pre>
     */
    public void stopTrial(
        com.google.cloud.aiplatform.v1.StopTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStopTrialMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the pareto-optimal Trials for multi-objective Study or the
     * optimal Trials for single-objective Study. The definition of
     * pareto-optimal can be checked in wiki page.
     * https://en.wikipedia.org/wiki/Pareto_efficiency
     * </pre>
     */
    public void listOptimalTrials(
        com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListOptimalTrialsMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateStudyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateStudyRequest,
                      com.google.cloud.aiplatform.v1.Study>(this, METHODID_CREATE_STUDY)))
          .addMethod(
              getGetStudyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetStudyRequest,
                      com.google.cloud.aiplatform.v1.Study>(this, METHODID_GET_STUDY)))
          .addMethod(
              getListStudiesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListStudiesRequest,
                      com.google.cloud.aiplatform.v1.ListStudiesResponse>(
                      this, METHODID_LIST_STUDIES)))
          .addMethod(
              getDeleteStudyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteStudyRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_STUDY)))
          .addMethod(
              getLookupStudyMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.LookupStudyRequest,
                      com.google.cloud.aiplatform.v1.Study>(this, METHODID_LOOKUP_STUDY)))
          .addMethod(
              getSuggestTrialsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.SuggestTrialsRequest,
                      com.google.longrunning.Operation>(this, METHODID_SUGGEST_TRIALS)))
          .addMethod(
              getCreateTrialMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CreateTrialRequest,
                      com.google.cloud.aiplatform.v1.Trial>(this, METHODID_CREATE_TRIAL)))
          .addMethod(
              getGetTrialMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.GetTrialRequest,
                      com.google.cloud.aiplatform.v1.Trial>(this, METHODID_GET_TRIAL)))
          .addMethod(
              getListTrialsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListTrialsRequest,
                      com.google.cloud.aiplatform.v1.ListTrialsResponse>(
                      this, METHODID_LIST_TRIALS)))
          .addMethod(
              getAddTrialMeasurementMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest,
                      com.google.cloud.aiplatform.v1.Trial>(this, METHODID_ADD_TRIAL_MEASUREMENT)))
          .addMethod(
              getCompleteTrialMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CompleteTrialRequest,
                      com.google.cloud.aiplatform.v1.Trial>(this, METHODID_COMPLETE_TRIAL)))
          .addMethod(
              getDeleteTrialMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.DeleteTrialRequest, com.google.protobuf.Empty>(
                      this, METHODID_DELETE_TRIAL)))
          .addMethod(
              getCheckTrialEarlyStoppingStateMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest,
                      com.google.longrunning.Operation>(
                      this, METHODID_CHECK_TRIAL_EARLY_STOPPING_STATE)))
          .addMethod(
              getStopTrialMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.StopTrialRequest,
                      com.google.cloud.aiplatform.v1.Trial>(this, METHODID_STOP_TRIAL)))
          .addMethod(
              getListOptimalTrialsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest,
                      com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>(
                      this, METHODID_LIST_OPTIMAL_TRIALS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Vertex AI Vizier API.
   * Vertex AI Vizier is a service to solve blackbox optimization problems,
   * such as tuning machine learning hyperparameters and searching over deep
   * learning architectures.
   * </pre>
   */
  public static final class VizierServiceStub
      extends io.grpc.stub.AbstractAsyncStub<VizierServiceStub> {
    private VizierServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VizierServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VizierServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Study. A resource name will be generated after creation of the
     * Study.
     * </pre>
     */
    public void createStudy(
        com.google.cloud.aiplatform.v1.CreateStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateStudyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Study by name.
     * </pre>
     */
    public void getStudy(
        com.google.cloud.aiplatform.v1.GetStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetStudyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the studies in a region for an associated project.
     * </pre>
     */
    public void listStudies(
        com.google.cloud.aiplatform.v1.ListStudiesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListStudiesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListStudiesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Study.
     * </pre>
     */
    public void deleteStudy(
        com.google.cloud.aiplatform.v1.DeleteStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteStudyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Looks a study up using the user-defined display_name field instead of the
     * fully qualified resource name.
     * </pre>
     */
    public void lookupStudy(
        com.google.cloud.aiplatform.v1.LookupStudyRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLookupStudyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more Trials to a Study, with parameter values
     * suggested by Vertex AI Vizier. Returns a long-running
     * operation associated with the generation of Trial suggestions.
     * When this long-running operation succeeds, it will contain
     * a [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
     * </pre>
     */
    public void suggestTrials(
        com.google.cloud.aiplatform.v1.SuggestTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuggestTrialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a user provided Trial to a Study.
     * </pre>
     */
    public void createTrial(
        com.google.cloud.aiplatform.v1.CreateTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTrialMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a Trial.
     * </pre>
     */
    public void getTrial(
        com.google.cloud.aiplatform.v1.GetTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTrialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the Trials associated with a Study.
     * </pre>
     */
    public void listTrials(
        com.google.cloud.aiplatform.v1.ListTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrialsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTrialsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a measurement of the objective metrics to a Trial. This measurement
     * is assumed to have been taken before the Trial is complete.
     * </pre>
     */
    public void addTrialMeasurement(
        com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddTrialMeasurementMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Marks a Trial as complete.
     * </pre>
     */
    public void completeTrial(
        com.google.cloud.aiplatform.v1.CompleteTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompleteTrialMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Trial.
     * </pre>
     */
    public void deleteTrial(
        com.google.cloud.aiplatform.v1.DeleteTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTrialMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Checks  whether a Trial should stop or not. Returns a
     * long-running operation. When the operation is successful,
     * it will contain a
     * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
     * </pre>
     */
    public void checkTrialEarlyStoppingState(
        com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckTrialEarlyStoppingStateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Stops a Trial.
     * </pre>
     */
    public void stopTrial(
        com.google.cloud.aiplatform.v1.StopTrialRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStopTrialMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the pareto-optimal Trials for multi-objective Study or the
     * optimal Trials for single-objective Study. The definition of
     * pareto-optimal can be checked in wiki page.
     * https://en.wikipedia.org/wiki/Pareto_efficiency
     * </pre>
     */
    public void listOptimalTrials(
        com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOptimalTrialsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Vertex AI Vizier API.
   * Vertex AI Vizier is a service to solve blackbox optimization problems,
   * such as tuning machine learning hyperparameters and searching over deep
   * learning architectures.
   * </pre>
   */
  public static final class VizierServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VizierServiceBlockingStub> {
    private VizierServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VizierServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VizierServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Study. A resource name will be generated after creation of the
     * Study.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Study createStudy(
        com.google.cloud.aiplatform.v1.CreateStudyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateStudyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Study by name.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Study getStudy(
        com.google.cloud.aiplatform.v1.GetStudyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetStudyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the studies in a region for an associated project.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListStudiesResponse listStudies(
        com.google.cloud.aiplatform.v1.ListStudiesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListStudiesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Study.
     * </pre>
     */
    public com.google.protobuf.Empty deleteStudy(
        com.google.cloud.aiplatform.v1.DeleteStudyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteStudyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Looks a study up using the user-defined display_name field instead of the
     * fully qualified resource name.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Study lookupStudy(
        com.google.cloud.aiplatform.v1.LookupStudyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLookupStudyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more Trials to a Study, with parameter values
     * suggested by Vertex AI Vizier. Returns a long-running
     * operation associated with the generation of Trial suggestions.
     * When this long-running operation succeeds, it will contain
     * a [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
     * </pre>
     */
    public com.google.longrunning.Operation suggestTrials(
        com.google.cloud.aiplatform.v1.SuggestTrialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuggestTrialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a user provided Trial to a Study.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Trial createTrial(
        com.google.cloud.aiplatform.v1.CreateTrialRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTrialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Trial.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Trial getTrial(
        com.google.cloud.aiplatform.v1.GetTrialRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTrialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Trials associated with a Study.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListTrialsResponse listTrials(
        com.google.cloud.aiplatform.v1.ListTrialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTrialsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a measurement of the objective metrics to a Trial. This measurement
     * is assumed to have been taken before the Trial is complete.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Trial addTrialMeasurement(
        com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddTrialMeasurementMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a Trial as complete.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Trial completeTrial(
        com.google.cloud.aiplatform.v1.CompleteTrialRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompleteTrialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Trial.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTrial(
        com.google.cloud.aiplatform.v1.DeleteTrialRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTrialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Checks  whether a Trial should stop or not. Returns a
     * long-running operation. When the operation is successful,
     * it will contain a
     * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
     * </pre>
     */
    public com.google.longrunning.Operation checkTrialEarlyStoppingState(
        com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckTrialEarlyStoppingStateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a Trial.
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.Trial stopTrial(
        com.google.cloud.aiplatform.v1.StopTrialRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStopTrialMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the pareto-optimal Trials for multi-objective Study or the
     * optimal Trials for single-objective Study. The definition of
     * pareto-optimal can be checked in wiki page.
     * https://en.wikipedia.org/wiki/Pareto_efficiency
     * </pre>
     */
    public com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse listOptimalTrials(
        com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOptimalTrialsMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Vertex AI Vizier API.
   * Vertex AI Vizier is a service to solve blackbox optimization problems,
   * such as tuning machine learning hyperparameters and searching over deep
   * learning architectures.
   * </pre>
   */
  public static final class VizierServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<VizierServiceFutureStub> {
    private VizierServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VizierServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VizierServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a Study. A resource name will be generated after creation of the
     * Study.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Study>
        createStudy(com.google.cloud.aiplatform.v1.CreateStudyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateStudyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Study by name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Study>
        getStudy(com.google.cloud.aiplatform.v1.GetStudyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetStudyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the studies in a region for an associated project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListStudiesResponse>
        listStudies(com.google.cloud.aiplatform.v1.ListStudiesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListStudiesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Study.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteStudy(com.google.cloud.aiplatform.v1.DeleteStudyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteStudyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Looks a study up using the user-defined display_name field instead of the
     * fully qualified resource name.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Study>
        lookupStudy(com.google.cloud.aiplatform.v1.LookupStudyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLookupStudyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds one or more Trials to a Study, with parameter values
     * suggested by Vertex AI Vizier. Returns a long-running
     * operation associated with the generation of Trial suggestions.
     * When this long-running operation succeeds, it will contain
     * a [SuggestTrialsResponse][google.cloud.ml.v1.SuggestTrialsResponse].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        suggestTrials(com.google.cloud.aiplatform.v1.SuggestTrialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuggestTrialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a user provided Trial to a Study.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Trial>
        createTrial(com.google.cloud.aiplatform.v1.CreateTrialRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTrialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a Trial.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Trial>
        getTrial(com.google.cloud.aiplatform.v1.GetTrialRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTrialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the Trials associated with a Study.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListTrialsResponse>
        listTrials(com.google.cloud.aiplatform.v1.ListTrialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTrialsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a measurement of the objective metrics to a Trial. This measurement
     * is assumed to have been taken before the Trial is complete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Trial>
        addTrialMeasurement(com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddTrialMeasurementMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Marks a Trial as complete.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Trial>
        completeTrial(com.google.cloud.aiplatform.v1.CompleteTrialRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompleteTrialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a Trial.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTrial(com.google.cloud.aiplatform.v1.DeleteTrialRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTrialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Checks  whether a Trial should stop or not. Returns a
     * long-running operation. When the operation is successful,
     * it will contain a
     * [CheckTrialEarlyStoppingStateResponse][google.cloud.ml.v1.CheckTrialEarlyStoppingStateResponse].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        checkTrialEarlyStoppingState(
            com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckTrialEarlyStoppingStateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Stops a Trial.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.aiplatform.v1.Trial>
        stopTrial(com.google.cloud.aiplatform.v1.StopTrialRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStopTrialMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the pareto-optimal Trials for multi-objective Study or the
     * optimal Trials for single-objective Study. The definition of
     * pareto-optimal can be checked in wiki page.
     * https://en.wikipedia.org/wiki/Pareto_efficiency
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>
        listOptimalTrials(com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOptimalTrialsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_STUDY = 0;
  private static final int METHODID_GET_STUDY = 1;
  private static final int METHODID_LIST_STUDIES = 2;
  private static final int METHODID_DELETE_STUDY = 3;
  private static final int METHODID_LOOKUP_STUDY = 4;
  private static final int METHODID_SUGGEST_TRIALS = 5;
  private static final int METHODID_CREATE_TRIAL = 6;
  private static final int METHODID_GET_TRIAL = 7;
  private static final int METHODID_LIST_TRIALS = 8;
  private static final int METHODID_ADD_TRIAL_MEASUREMENT = 9;
  private static final int METHODID_COMPLETE_TRIAL = 10;
  private static final int METHODID_DELETE_TRIAL = 11;
  private static final int METHODID_CHECK_TRIAL_EARLY_STOPPING_STATE = 12;
  private static final int METHODID_STOP_TRIAL = 13;
  private static final int METHODID_LIST_OPTIMAL_TRIALS = 14;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VizierServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VizierServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_STUDY:
          serviceImpl.createStudy(
              (com.google.cloud.aiplatform.v1.CreateStudyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study>) responseObserver);
          break;
        case METHODID_GET_STUDY:
          serviceImpl.getStudy(
              (com.google.cloud.aiplatform.v1.GetStudyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study>) responseObserver);
          break;
        case METHODID_LIST_STUDIES:
          serviceImpl.listStudies(
              (com.google.cloud.aiplatform.v1.ListStudiesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListStudiesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_STUDY:
          serviceImpl.deleteStudy(
              (com.google.cloud.aiplatform.v1.DeleteStudyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LOOKUP_STUDY:
          serviceImpl.lookupStudy(
              (com.google.cloud.aiplatform.v1.LookupStudyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Study>) responseObserver);
          break;
        case METHODID_SUGGEST_TRIALS:
          serviceImpl.suggestTrials(
              (com.google.cloud.aiplatform.v1.SuggestTrialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_TRIAL:
          serviceImpl.createTrial(
              (com.google.cloud.aiplatform.v1.CreateTrialRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial>) responseObserver);
          break;
        case METHODID_GET_TRIAL:
          serviceImpl.getTrial(
              (com.google.cloud.aiplatform.v1.GetTrialRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial>) responseObserver);
          break;
        case METHODID_LIST_TRIALS:
          serviceImpl.listTrials(
              (com.google.cloud.aiplatform.v1.ListTrialsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.ListTrialsResponse>)
                  responseObserver);
          break;
        case METHODID_ADD_TRIAL_MEASUREMENT:
          serviceImpl.addTrialMeasurement(
              (com.google.cloud.aiplatform.v1.AddTrialMeasurementRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial>) responseObserver);
          break;
        case METHODID_COMPLETE_TRIAL:
          serviceImpl.completeTrial(
              (com.google.cloud.aiplatform.v1.CompleteTrialRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial>) responseObserver);
          break;
        case METHODID_DELETE_TRIAL:
          serviceImpl.deleteTrial(
              (com.google.cloud.aiplatform.v1.DeleteTrialRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CHECK_TRIAL_EARLY_STOPPING_STATE:
          serviceImpl.checkTrialEarlyStoppingState(
              (com.google.cloud.aiplatform.v1.CheckTrialEarlyStoppingStateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_STOP_TRIAL:
          serviceImpl.stopTrial(
              (com.google.cloud.aiplatform.v1.StopTrialRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.aiplatform.v1.Trial>) responseObserver);
          break;
        case METHODID_LIST_OPTIMAL_TRIALS:
          serviceImpl.listOptimalTrials(
              (com.google.cloud.aiplatform.v1.ListOptimalTrialsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.aiplatform.v1.ListOptimalTrialsResponse>)
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

  private abstract static class VizierServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VizierServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.aiplatform.v1.VizierServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VizierService");
    }
  }

  private static final class VizierServiceFileDescriptorSupplier
      extends VizierServiceBaseDescriptorSupplier {
    VizierServiceFileDescriptorSupplier() {}
  }

  private static final class VizierServiceMethodDescriptorSupplier
      extends VizierServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VizierServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (VizierServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VizierServiceFileDescriptorSupplier())
                      .addMethod(getCreateStudyMethod())
                      .addMethod(getGetStudyMethod())
                      .addMethod(getListStudiesMethod())
                      .addMethod(getDeleteStudyMethod())
                      .addMethod(getLookupStudyMethod())
                      .addMethod(getSuggestTrialsMethod())
                      .addMethod(getCreateTrialMethod())
                      .addMethod(getGetTrialMethod())
                      .addMethod(getListTrialsMethod())
                      .addMethod(getAddTrialMeasurementMethod())
                      .addMethod(getCompleteTrialMethod())
                      .addMethod(getDeleteTrialMethod())
                      .addMethod(getCheckTrialEarlyStoppingStateMethod())
                      .addMethod(getStopTrialMethod())
                      .addMethod(getListOptimalTrialsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
