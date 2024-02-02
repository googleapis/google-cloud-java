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
package com.google.cloud.rapidmigrationassessment.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/rapidmigrationassessment/v1/rapidmigrationassessment.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class RapidMigrationAssessmentGrpc {

  private RapidMigrationAssessmentGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessment";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest,
          com.google.longrunning.Operation>
      getCreateCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest,
          com.google.longrunning.Operation>
      getCreateCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest,
            com.google.longrunning.Operation>
        getCreateCollectorMethod;
    if ((getCreateCollectorMethod = RapidMigrationAssessmentGrpc.getCreateCollectorMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getCreateCollectorMethod = RapidMigrationAssessmentGrpc.getCreateCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getCreateCollectorMethod =
              getCreateCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("CreateCollector"))
                      .build();
        }
      }
    }
    return getCreateCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest,
          com.google.longrunning.Operation>
      getCreateAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnnotation",
      requestType = com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest,
          com.google.longrunning.Operation>
      getCreateAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest,
            com.google.longrunning.Operation>
        getCreateAnnotationMethod;
    if ((getCreateAnnotationMethod = RapidMigrationAssessmentGrpc.getCreateAnnotationMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getCreateAnnotationMethod = RapidMigrationAssessmentGrpc.getCreateAnnotationMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getCreateAnnotationMethod =
              getCreateAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("CreateAnnotation"))
                      .build();
        }
      }
    }
    return getCreateAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest,
          com.google.cloud.rapidmigrationassessment.v1.Annotation>
      getGetAnnotationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnnotation",
      requestType = com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest.class,
      responseType = com.google.cloud.rapidmigrationassessment.v1.Annotation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest,
          com.google.cloud.rapidmigrationassessment.v1.Annotation>
      getGetAnnotationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest,
            com.google.cloud.rapidmigrationassessment.v1.Annotation>
        getGetAnnotationMethod;
    if ((getGetAnnotationMethod = RapidMigrationAssessmentGrpc.getGetAnnotationMethod) == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getGetAnnotationMethod = RapidMigrationAssessmentGrpc.getGetAnnotationMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getGetAnnotationMethod =
              getGetAnnotationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest,
                          com.google.cloud.rapidmigrationassessment.v1.Annotation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnnotation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.Annotation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("GetAnnotation"))
                      .build();
        }
      }
    }
    return getGetAnnotationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest,
          com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
      getListCollectorsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCollectors",
      requestType = com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest.class,
      responseType = com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest,
          com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
      getListCollectorsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest,
            com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
        getListCollectorsMethod;
    if ((getListCollectorsMethod = RapidMigrationAssessmentGrpc.getListCollectorsMethod) == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getListCollectorsMethod = RapidMigrationAssessmentGrpc.getListCollectorsMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getListCollectorsMethod =
              getListCollectorsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest,
                          com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCollectors"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("ListCollectors"))
                      .build();
        }
      }
    }
    return getListCollectorsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest,
          com.google.cloud.rapidmigrationassessment.v1.Collector>
      getGetCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest.class,
      responseType = com.google.cloud.rapidmigrationassessment.v1.Collector.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest,
          com.google.cloud.rapidmigrationassessment.v1.Collector>
      getGetCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest,
            com.google.cloud.rapidmigrationassessment.v1.Collector>
        getGetCollectorMethod;
    if ((getGetCollectorMethod = RapidMigrationAssessmentGrpc.getGetCollectorMethod) == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getGetCollectorMethod = RapidMigrationAssessmentGrpc.getGetCollectorMethod) == null) {
          RapidMigrationAssessmentGrpc.getGetCollectorMethod =
              getGetCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest,
                          com.google.cloud.rapidmigrationassessment.v1.Collector>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.Collector
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("GetCollector"))
                      .build();
        }
      }
    }
    return getGetCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest,
          com.google.longrunning.Operation>
      getUpdateCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest,
          com.google.longrunning.Operation>
      getUpdateCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest,
            com.google.longrunning.Operation>
        getUpdateCollectorMethod;
    if ((getUpdateCollectorMethod = RapidMigrationAssessmentGrpc.getUpdateCollectorMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getUpdateCollectorMethod = RapidMigrationAssessmentGrpc.getUpdateCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getUpdateCollectorMethod =
              getUpdateCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("UpdateCollector"))
                      .build();
        }
      }
    }
    return getUpdateCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest,
          com.google.longrunning.Operation>
      getDeleteCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest,
          com.google.longrunning.Operation>
      getDeleteCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest,
            com.google.longrunning.Operation>
        getDeleteCollectorMethod;
    if ((getDeleteCollectorMethod = RapidMigrationAssessmentGrpc.getDeleteCollectorMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getDeleteCollectorMethod = RapidMigrationAssessmentGrpc.getDeleteCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getDeleteCollectorMethod =
              getDeleteCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("DeleteCollector"))
                      .build();
        }
      }
    }
    return getDeleteCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest,
          com.google.longrunning.Operation>
      getResumeCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ResumeCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest,
          com.google.longrunning.Operation>
      getResumeCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest,
            com.google.longrunning.Operation>
        getResumeCollectorMethod;
    if ((getResumeCollectorMethod = RapidMigrationAssessmentGrpc.getResumeCollectorMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getResumeCollectorMethod = RapidMigrationAssessmentGrpc.getResumeCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getResumeCollectorMethod =
              getResumeCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ResumeCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("ResumeCollector"))
                      .build();
        }
      }
    }
    return getResumeCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest,
          com.google.longrunning.Operation>
      getRegisterCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest,
          com.google.longrunning.Operation>
      getRegisterCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest,
            com.google.longrunning.Operation>
        getRegisterCollectorMethod;
    if ((getRegisterCollectorMethod = RapidMigrationAssessmentGrpc.getRegisterCollectorMethod)
        == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getRegisterCollectorMethod = RapidMigrationAssessmentGrpc.getRegisterCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getRegisterCollectorMethod =
              getRegisterCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("RegisterCollector"))
                      .build();
        }
      }
    }
    return getRegisterCollectorMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest,
          com.google.longrunning.Operation>
      getPauseCollectorMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PauseCollector",
      requestType = com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest,
          com.google.longrunning.Operation>
      getPauseCollectorMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest,
            com.google.longrunning.Operation>
        getPauseCollectorMethod;
    if ((getPauseCollectorMethod = RapidMigrationAssessmentGrpc.getPauseCollectorMethod) == null) {
      synchronized (RapidMigrationAssessmentGrpc.class) {
        if ((getPauseCollectorMethod = RapidMigrationAssessmentGrpc.getPauseCollectorMethod)
            == null) {
          RapidMigrationAssessmentGrpc.getPauseCollectorMethod =
              getPauseCollectorMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "PauseCollector"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RapidMigrationAssessmentMethodDescriptorSupplier("PauseCollector"))
                      .build();
        }
      }
    }
    return getPauseCollectorMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RapidMigrationAssessmentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentStub>() {
          @java.lang.Override
          public RapidMigrationAssessmentStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RapidMigrationAssessmentStub(channel, callOptions);
          }
        };
    return RapidMigrationAssessmentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RapidMigrationAssessmentBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentBlockingStub>() {
          @java.lang.Override
          public RapidMigrationAssessmentBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RapidMigrationAssessmentBlockingStub(channel, callOptions);
          }
        };
    return RapidMigrationAssessmentBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RapidMigrationAssessmentFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RapidMigrationAssessmentFutureStub>() {
          @java.lang.Override
          public RapidMigrationAssessmentFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RapidMigrationAssessmentFutureStub(channel, callOptions);
          }
        };
    return RapidMigrationAssessmentFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create a Collector to manage the on-prem appliance which collects
     * information about Customer assets.
     * </pre>
     */
    default void createCollector(
        com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Annotation
     * </pre>
     */
    default void createAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Annotation.
     * </pre>
     */
    default void getAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Annotation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnnotationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Collectors in a given project and location.
     * </pre>
     */
    default void listCollectors(
        com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCollectorsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collector.
     * </pre>
     */
    default void getCollector(
        com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Collector>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collector.
     * </pre>
     */
    default void updateCollector(
        com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collector - changes state of collector to "Deleting".
     * Background jobs does final deletion thorugh producer api.
     * </pre>
     */
    default void deleteCollector(
        com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the given collector.
     * </pre>
     */
    default void resumeCollector(
        com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getResumeCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Registers the given collector.
     * </pre>
     */
    default void registerCollector(
        com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRegisterCollectorMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the given collector.
     * </pre>
     */
    default void pauseCollector(
        com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getPauseCollectorMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service RapidMigrationAssessment.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public abstract static class RapidMigrationAssessmentImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return RapidMigrationAssessmentGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service RapidMigrationAssessment.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class RapidMigrationAssessmentStub
      extends io.grpc.stub.AbstractAsyncStub<RapidMigrationAssessmentStub> {
    private RapidMigrationAssessmentStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RapidMigrationAssessmentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RapidMigrationAssessmentStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Collector to manage the on-prem appliance which collects
     * information about Customer assets.
     * </pre>
     */
    public void createCollector(
        com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an Annotation
     * </pre>
     */
    public void createAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Annotation.
     * </pre>
     */
    public void getAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Annotation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnnotationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Collectors in a given project and location.
     * </pre>
     */
    public void listCollectors(
        com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCollectorsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collector.
     * </pre>
     */
    public void getCollector(
        com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Collector>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collector.
     * </pre>
     */
    public void updateCollector(
        com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collector - changes state of collector to "Deleting".
     * Background jobs does final deletion thorugh producer api.
     * </pre>
     */
    public void deleteCollector(
        com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Resumes the given collector.
     * </pre>
     */
    public void resumeCollector(
        com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getResumeCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Registers the given collector.
     * </pre>
     */
    public void registerCollector(
        com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Pauses the given collector.
     * </pre>
     */
    public void pauseCollector(
        com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getPauseCollectorMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service RapidMigrationAssessment.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class RapidMigrationAssessmentBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RapidMigrationAssessmentBlockingStub> {
    private RapidMigrationAssessmentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RapidMigrationAssessmentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RapidMigrationAssessmentBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Collector to manage the on-prem appliance which collects
     * information about Customer assets.
     * </pre>
     */
    public com.google.longrunning.Operation createCollector(
        com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Annotation
     * </pre>
     */
    public com.google.longrunning.Operation createAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Annotation.
     * </pre>
     */
    public com.google.cloud.rapidmigrationassessment.v1.Annotation getAnnotation(
        com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnnotationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Collectors in a given project and location.
     * </pre>
     */
    public com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse listCollectors(
        com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCollectorsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collector.
     * </pre>
     */
    public com.google.cloud.rapidmigrationassessment.v1.Collector getCollector(
        com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collector.
     * </pre>
     */
    public com.google.longrunning.Operation updateCollector(
        com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collector - changes state of collector to "Deleting".
     * Background jobs does final deletion thorugh producer api.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCollector(
        com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the given collector.
     * </pre>
     */
    public com.google.longrunning.Operation resumeCollector(
        com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getResumeCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Registers the given collector.
     * </pre>
     */
    public com.google.longrunning.Operation registerCollector(
        com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterCollectorMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the given collector.
     * </pre>
     */
    public com.google.longrunning.Operation pauseCollector(
        com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getPauseCollectorMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * RapidMigrationAssessment.
   *
   * <pre>
   * Service describing handlers for resources.
   * </pre>
   */
  public static final class RapidMigrationAssessmentFutureStub
      extends io.grpc.stub.AbstractFutureStub<RapidMigrationAssessmentFutureStub> {
    private RapidMigrationAssessmentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RapidMigrationAssessmentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RapidMigrationAssessmentFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a Collector to manage the on-prem appliance which collects
     * information about Customer assets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createCollector(
            com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an Annotation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAnnotation(
            com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Annotation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.rapidmigrationassessment.v1.Annotation>
        getAnnotation(com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnnotationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Collectors in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>
        listCollectors(com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCollectorsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Collector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.rapidmigrationassessment.v1.Collector>
        getCollector(com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Collector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCollector(
            com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Collector - changes state of collector to "Deleting".
     * Background jobs does final deletion thorugh producer api.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCollector(
            com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Resumes the given collector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        resumeCollector(
            com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getResumeCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Registers the given collector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        registerCollector(
            com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterCollectorMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Pauses the given collector.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        pauseCollector(com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getPauseCollectorMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_COLLECTOR = 0;
  private static final int METHODID_CREATE_ANNOTATION = 1;
  private static final int METHODID_GET_ANNOTATION = 2;
  private static final int METHODID_LIST_COLLECTORS = 3;
  private static final int METHODID_GET_COLLECTOR = 4;
  private static final int METHODID_UPDATE_COLLECTOR = 5;
  private static final int METHODID_DELETE_COLLECTOR = 6;
  private static final int METHODID_RESUME_COLLECTOR = 7;
  private static final int METHODID_REGISTER_COLLECTOR = 8;
  private static final int METHODID_PAUSE_COLLECTOR = 9;

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
        case METHODID_CREATE_COLLECTOR:
          serviceImpl.createCollector(
              (com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ANNOTATION:
          serviceImpl.createAnnotation(
              (com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ANNOTATION:
          serviceImpl.getAnnotation(
              (com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Annotation>)
                  responseObserver);
          break;
        case METHODID_LIST_COLLECTORS:
          serviceImpl.listCollectors(
              (com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_COLLECTOR:
          serviceImpl.getCollector(
              (com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.rapidmigrationassessment.v1.Collector>)
                  responseObserver);
          break;
        case METHODID_UPDATE_COLLECTOR:
          serviceImpl.updateCollector(
              (com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_COLLECTOR:
          serviceImpl.deleteCollector(
              (com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESUME_COLLECTOR:
          serviceImpl.resumeCollector(
              (com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_REGISTER_COLLECTOR:
          serviceImpl.registerCollector(
              (com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_PAUSE_COLLECTOR:
          serviceImpl.pauseCollector(
              (com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest) request,
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
            getCreateCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.CreateCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_COLLECTOR)))
        .addMethod(
            getCreateAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.CreateAnnotationRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ANNOTATION)))
        .addMethod(
            getGetAnnotationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.GetAnnotationRequest,
                    com.google.cloud.rapidmigrationassessment.v1.Annotation>(
                    service, METHODID_GET_ANNOTATION)))
        .addMethod(
            getListCollectorsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.ListCollectorsRequest,
                    com.google.cloud.rapidmigrationassessment.v1.ListCollectorsResponse>(
                    service, METHODID_LIST_COLLECTORS)))
        .addMethod(
            getGetCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.GetCollectorRequest,
                    com.google.cloud.rapidmigrationassessment.v1.Collector>(
                    service, METHODID_GET_COLLECTOR)))
        .addMethod(
            getUpdateCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.UpdateCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_COLLECTOR)))
        .addMethod(
            getDeleteCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.DeleteCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_COLLECTOR)))
        .addMethod(
            getResumeCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.ResumeCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_RESUME_COLLECTOR)))
        .addMethod(
            getRegisterCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.RegisterCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_REGISTER_COLLECTOR)))
        .addMethod(
            getPauseCollectorMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.rapidmigrationassessment.v1.PauseCollectorRequest,
                    com.google.longrunning.Operation>(service, METHODID_PAUSE_COLLECTOR)))
        .build();
  }

  private abstract static class RapidMigrationAssessmentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RapidMigrationAssessmentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.rapidmigrationassessment.v1.RapidMigrationAssessmentProto
          .getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RapidMigrationAssessment");
    }
  }

  private static final class RapidMigrationAssessmentFileDescriptorSupplier
      extends RapidMigrationAssessmentBaseDescriptorSupplier {
    RapidMigrationAssessmentFileDescriptorSupplier() {}
  }

  private static final class RapidMigrationAssessmentMethodDescriptorSupplier
      extends RapidMigrationAssessmentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    RapidMigrationAssessmentMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (RapidMigrationAssessmentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RapidMigrationAssessmentFileDescriptorSupplier())
                      .addMethod(getCreateCollectorMethod())
                      .addMethod(getCreateAnnotationMethod())
                      .addMethod(getGetAnnotationMethod())
                      .addMethod(getListCollectorsMethod())
                      .addMethod(getGetCollectorMethod())
                      .addMethod(getUpdateCollectorMethod())
                      .addMethod(getDeleteCollectorMethod())
                      .addMethod(getResumeCollectorMethod())
                      .addMethod(getRegisterCollectorMethod())
                      .addMethod(getPauseCollectorMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
