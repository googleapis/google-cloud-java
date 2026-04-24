/*
 * Copyright 2026 Google LLC
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
package com.google.showcase.v1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
 * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
 * correctly.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ComplianceGrpc {

  private ComplianceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.showcase.v1beta1.Compliance";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataBody",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataBodyMethod;
    if ((getRepeatDataBodyMethod = ComplianceGrpc.getRepeatDataBodyMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataBodyMethod = ComplianceGrpc.getRepeatDataBodyMethod) == null) {
          ComplianceGrpc.getRepeatDataBodyMethod =
              getRepeatDataBodyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RepeatDataBody"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ComplianceMethodDescriptorSupplier("RepeatDataBody"))
                      .build();
        }
      }
    }
    return getRepeatDataBodyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyInfoMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataBodyInfo",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyInfoMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataBodyInfoMethod;
    if ((getRepeatDataBodyInfoMethod = ComplianceGrpc.getRepeatDataBodyInfoMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataBodyInfoMethod = ComplianceGrpc.getRepeatDataBodyInfoMethod) == null) {
          ComplianceGrpc.getRepeatDataBodyInfoMethod =
              getRepeatDataBodyInfoMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RepeatDataBodyInfo"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataBodyInfo"))
                      .build();
        }
      }
    }
    return getRepeatDataBodyInfoMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataQueryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataQuery",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataQueryMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataQueryMethod;
    if ((getRepeatDataQueryMethod = ComplianceGrpc.getRepeatDataQueryMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataQueryMethod = ComplianceGrpc.getRepeatDataQueryMethod) == null) {
          ComplianceGrpc.getRepeatDataQueryMethod =
              getRepeatDataQueryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RepeatDataQuery"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataQuery"))
                      .build();
        }
      }
    }
    return getRepeatDataQueryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataSimplePathMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataSimplePath",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataSimplePathMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataSimplePathMethod;
    if ((getRepeatDataSimplePathMethod = ComplianceGrpc.getRepeatDataSimplePathMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataSimplePathMethod = ComplianceGrpc.getRepeatDataSimplePathMethod)
            == null) {
          ComplianceGrpc.getRepeatDataSimplePathMethod =
              getRepeatDataSimplePathMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RepeatDataSimplePath"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataSimplePath"))
                      .build();
        }
      }
    }
    return getRepeatDataSimplePathMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataPathResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataPathResource",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataPathResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataPathResourceMethod;
    if ((getRepeatDataPathResourceMethod = ComplianceGrpc.getRepeatDataPathResourceMethod)
        == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataPathResourceMethod = ComplianceGrpc.getRepeatDataPathResourceMethod)
            == null) {
          ComplianceGrpc.getRepeatDataPathResourceMethod =
              getRepeatDataPathResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RepeatDataPathResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataPathResource"))
                      .build();
        }
      }
    }
    return getRepeatDataPathResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataPathTrailingResourceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataPathTrailingResource",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataPathTrailingResourceMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataPathTrailingResourceMethod;
    if ((getRepeatDataPathTrailingResourceMethod =
            ComplianceGrpc.getRepeatDataPathTrailingResourceMethod)
        == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataPathTrailingResourceMethod =
                ComplianceGrpc.getRepeatDataPathTrailingResourceMethod)
            == null) {
          ComplianceGrpc.getRepeatDataPathTrailingResourceMethod =
              getRepeatDataPathTrailingResourceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RepeatDataPathTrailingResource"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataPathTrailingResource"))
                      .build();
        }
      }
    }
    return getRepeatDataPathTrailingResourceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyPutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataBodyPut",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyPutMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataBodyPutMethod;
    if ((getRepeatDataBodyPutMethod = ComplianceGrpc.getRepeatDataBodyPutMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataBodyPutMethod = ComplianceGrpc.getRepeatDataBodyPutMethod) == null) {
          ComplianceGrpc.getRepeatDataBodyPutMethod =
              getRepeatDataBodyPutMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RepeatDataBodyPut"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataBodyPut"))
                      .build();
        }
      }
    }
    return getRepeatDataBodyPutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyPatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RepeatDataBodyPatch",
      requestType = com.google.showcase.v1beta1.RepeatRequest.class,
      responseType = com.google.showcase.v1beta1.RepeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
      getRepeatDataBodyPatchMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.RepeatRequest, com.google.showcase.v1beta1.RepeatResponse>
        getRepeatDataBodyPatchMethod;
    if ((getRepeatDataBodyPatchMethod = ComplianceGrpc.getRepeatDataBodyPatchMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getRepeatDataBodyPatchMethod = ComplianceGrpc.getRepeatDataBodyPatchMethod) == null) {
          ComplianceGrpc.getRepeatDataBodyPatchMethod =
              getRepeatDataBodyPatchMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.RepeatRequest,
                          com.google.showcase.v1beta1.RepeatResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "RepeatDataBodyPatch"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.RepeatResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ComplianceMethodDescriptorSupplier("RepeatDataBodyPatch"))
                      .build();
        }
      }
    }
    return getRepeatDataBodyPatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.EnumRequest, com.google.showcase.v1beta1.EnumResponse>
      getGetEnumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEnum",
      requestType = com.google.showcase.v1beta1.EnumRequest.class,
      responseType = com.google.showcase.v1beta1.EnumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.EnumRequest, com.google.showcase.v1beta1.EnumResponse>
      getGetEnumMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.EnumRequest, com.google.showcase.v1beta1.EnumResponse>
        getGetEnumMethod;
    if ((getGetEnumMethod = ComplianceGrpc.getGetEnumMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getGetEnumMethod = ComplianceGrpc.getGetEnumMethod) == null) {
          ComplianceGrpc.getGetEnumMethod =
              getGetEnumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.EnumRequest,
                          com.google.showcase.v1beta1.EnumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEnum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.EnumRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.EnumResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ComplianceMethodDescriptorSupplier("GetEnum"))
                      .build();
        }
      }
    }
    return getGetEnumMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.EnumResponse, com.google.showcase.v1beta1.EnumResponse>
      getVerifyEnumMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "VerifyEnum",
      requestType = com.google.showcase.v1beta1.EnumResponse.class,
      responseType = com.google.showcase.v1beta1.EnumResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.showcase.v1beta1.EnumResponse, com.google.showcase.v1beta1.EnumResponse>
      getVerifyEnumMethod() {
    io.grpc.MethodDescriptor<
            com.google.showcase.v1beta1.EnumResponse, com.google.showcase.v1beta1.EnumResponse>
        getVerifyEnumMethod;
    if ((getVerifyEnumMethod = ComplianceGrpc.getVerifyEnumMethod) == null) {
      synchronized (ComplianceGrpc.class) {
        if ((getVerifyEnumMethod = ComplianceGrpc.getVerifyEnumMethod) == null) {
          ComplianceGrpc.getVerifyEnumMethod =
              getVerifyEnumMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.showcase.v1beta1.EnumResponse,
                          com.google.showcase.v1beta1.EnumResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "VerifyEnum"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.EnumResponse.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.showcase.v1beta1.EnumResponse.getDefaultInstance()))
                      .setSchemaDescriptor(new ComplianceMethodDescriptorSupplier("VerifyEnum"))
                      .build();
        }
      }
    }
    return getVerifyEnumMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ComplianceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComplianceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ComplianceStub>() {
          @java.lang.Override
          public ComplianceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ComplianceStub(channel, callOptions);
          }
        };
    return ComplianceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ComplianceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComplianceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ComplianceBlockingV2Stub>() {
          @java.lang.Override
          public ComplianceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ComplianceBlockingV2Stub(channel, callOptions);
          }
        };
    return ComplianceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ComplianceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComplianceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ComplianceBlockingStub>() {
          @java.lang.Override
          public ComplianceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ComplianceBlockingStub(channel, callOptions);
          }
        };
    return ComplianceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ComplianceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ComplianceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ComplianceFutureStub>() {
          @java.lang.Override
          public ComplianceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ComplianceFutureStub(channel, callOptions);
          }
        };
    return ComplianceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the entire request object in the REST body.
     * </pre>
     */
    default void repeatDataBody(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataBodyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the a message-type field in the REST body. Per AIP-127, only
     * top-level, non-repeated fields can be sent this way.
     * </pre>
     */
    default void repeatDataBodyInfo(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataBodyInfoMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending all request fields as query parameters.
     * </pre>
     */
    default void repeatDataQuery(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataQueryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending some parameters as "simple" path variables (i.e., of the form
     * "/bar/{foo}" rather than "/{foo=bar/&#42;}"), and the rest as query parameters.
     * </pre>
     */
    default void repeatDataSimplePath(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataSimplePathMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a path resource.
     * </pre>
     */
    default void repeatDataPathResource(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataPathResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a trailing resource.
     * </pre>
     */
    default void repeatDataPathTrailingResource(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataPathTrailingResourceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PUT method.
     * </pre>
     */
    default void repeatDataBodyPut(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataBodyPutMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PATCH method.
     * </pre>
     */
    default void repeatDataBodyPatch(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRepeatDataBodyPatchMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method requests an enum value from the server. Depending on the contents of EnumRequest, the enum value returned will be a known enum declared in the
     * .proto file, or a made-up enum value the is unknown to the client. To verify that clients can round-trip unknown enum values they receive, use the
     * response from this RPC as the request to VerifyEnum()
     * The values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run (this is needed for
     * VerifyEnum() to work) but are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    default void getEnum(
        com.google.showcase.v1beta1.EnumRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEnumMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is used to verify that clients can round-trip enum values, which is particularly important for unknown enum values over REST. VerifyEnum()
     * verifies that its request, which is presumably the response that the client previously got to a GetEnum(), contains the correct data. If so, it responds
     * with the same EnumResponse; otherwise, the RPC errors.
     * This works because the values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run,
     * although they are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    default void verifyEnum(
        com.google.showcase.v1beta1.EnumResponse request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyEnumMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Compliance.
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public abstract static class ComplianceImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ComplianceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Compliance.
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public static final class ComplianceStub extends io.grpc.stub.AbstractAsyncStub<ComplianceStub> {
    private ComplianceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComplianceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComplianceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the entire request object in the REST body.
     * </pre>
     */
    public void repeatDataBody(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataBodyMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the a message-type field in the REST body. Per AIP-127, only
     * top-level, non-repeated fields can be sent this way.
     * </pre>
     */
    public void repeatDataBodyInfo(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataBodyInfoMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending all request fields as query parameters.
     * </pre>
     */
    public void repeatDataQuery(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataQueryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending some parameters as "simple" path variables (i.e., of the form
     * "/bar/{foo}" rather than "/{foo=bar/&#42;}"), and the rest as query parameters.
     * </pre>
     */
    public void repeatDataSimplePath(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataSimplePathMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a path resource.
     * </pre>
     */
    public void repeatDataPathResource(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataPathResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a trailing resource.
     * </pre>
     */
    public void repeatDataPathTrailingResource(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataPathTrailingResourceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PUT method.
     * </pre>
     */
    public void repeatDataBodyPut(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataBodyPutMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PATCH method.
     * </pre>
     */
    public void repeatDataBodyPatch(
        com.google.showcase.v1beta1.RepeatRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRepeatDataBodyPatchMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method requests an enum value from the server. Depending on the contents of EnumRequest, the enum value returned will be a known enum declared in the
     * .proto file, or a made-up enum value the is unknown to the client. To verify that clients can round-trip unknown enum values they receive, use the
     * response from this RPC as the request to VerifyEnum()
     * The values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run (this is needed for
     * VerifyEnum() to work) but are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public void getEnum(
        com.google.showcase.v1beta1.EnumRequest request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEnumMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * This method is used to verify that clients can round-trip enum values, which is particularly important for unknown enum values over REST. VerifyEnum()
     * verifies that its request, which is presumably the response that the client previously got to a GetEnum(), contains the correct data. If so, it responds
     * with the same EnumResponse; otherwise, the RPC errors.
     * This works because the values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run,
     * although they are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public void verifyEnum(
        com.google.showcase.v1beta1.EnumResponse request,
        io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyEnumMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Compliance.
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public static final class ComplianceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ComplianceBlockingV2Stub> {
    private ComplianceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComplianceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComplianceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the entire request object in the REST body.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBody(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataBodyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the a message-type field in the REST body. Per AIP-127, only
     * top-level, non-repeated fields can be sent this way.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyInfo(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataBodyInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending all request fields as query parameters.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataQuery(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending some parameters as "simple" path variables (i.e., of the form
     * "/bar/{foo}" rather than "/{foo=bar/&#42;}"), and the rest as query parameters.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataSimplePath(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataSimplePathMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a path resource.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataPathResource(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataPathResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a trailing resource.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataPathTrailingResource(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataPathTrailingResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PUT method.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyPut(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataBodyPutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PATCH method.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyPatch(
        com.google.showcase.v1beta1.RepeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRepeatDataBodyPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method requests an enum value from the server. Depending on the contents of EnumRequest, the enum value returned will be a known enum declared in the
     * .proto file, or a made-up enum value the is unknown to the client. To verify that clients can round-trip unknown enum values they receive, use the
     * response from this RPC as the request to VerifyEnum()
     * The values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run (this is needed for
     * VerifyEnum() to work) but are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.showcase.v1beta1.EnumResponse getEnum(
        com.google.showcase.v1beta1.EnumRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEnumMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method is used to verify that clients can round-trip enum values, which is particularly important for unknown enum values over REST. VerifyEnum()
     * verifies that its request, which is presumably the response that the client previously got to a GetEnum(), contains the correct data. If so, it responds
     * with the same EnumResponse; otherwise, the RPC errors.
     * This works because the values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run,
     * although they are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.showcase.v1beta1.EnumResponse verifyEnum(
        com.google.showcase.v1beta1.EnumResponse request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getVerifyEnumMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Compliance.
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public static final class ComplianceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ComplianceBlockingStub> {
    private ComplianceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComplianceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComplianceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the entire request object in the REST body.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBody(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataBodyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the a message-type field in the REST body. Per AIP-127, only
     * top-level, non-repeated fields can be sent this way.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyInfo(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataBodyInfoMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending all request fields as query parameters.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataQuery(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataQueryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending some parameters as "simple" path variables (i.e., of the form
     * "/bar/{foo}" rather than "/{foo=bar/&#42;}"), and the rest as query parameters.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataSimplePath(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataSimplePathMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a path resource.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataPathResource(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataPathResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a trailing resource.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataPathTrailingResource(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataPathTrailingResourceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PUT method.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyPut(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataBodyPutMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PATCH method.
     * </pre>
     */
    public com.google.showcase.v1beta1.RepeatResponse repeatDataBodyPatch(
        com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRepeatDataBodyPatchMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method requests an enum value from the server. Depending on the contents of EnumRequest, the enum value returned will be a known enum declared in the
     * .proto file, or a made-up enum value the is unknown to the client. To verify that clients can round-trip unknown enum values they receive, use the
     * response from this RPC as the request to VerifyEnum()
     * The values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run (this is needed for
     * VerifyEnum() to work) but are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.showcase.v1beta1.EnumResponse getEnum(
        com.google.showcase.v1beta1.EnumRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEnumMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * This method is used to verify that clients can round-trip enum values, which is particularly important for unknown enum values over REST. VerifyEnum()
     * verifies that its request, which is presumably the response that the client previously got to a GetEnum(), contains the correct data. If so, it responds
     * with the same EnumResponse; otherwise, the RPC errors.
     * This works because the values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run,
     * although they are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.showcase.v1beta1.EnumResponse verifyEnum(
        com.google.showcase.v1beta1.EnumResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyEnumMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Compliance.
   *
   * <pre>
   * This service is used to test that GAPICs implement various REST-related features correctly. This mostly means transcoding proto3 requests to REST format
   * correctly for various types of HTTP annotations, but it also includes verifying that unknown (numeric) enums received by clients can be round-tripped
   * correctly.
   * </pre>
   */
  public static final class ComplianceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ComplianceFutureStub> {
    private ComplianceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ComplianceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ComplianceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the entire request object in the REST body.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataBody(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataBodyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending the a message-type field in the REST body. Per AIP-127, only
     * top-level, non-repeated fields can be sent this way.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataBodyInfo(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataBodyInfoMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending all request fields as query parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataQuery(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataQueryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request. This method exercises
     * sending some parameters as "simple" path variables (i.e., of the form
     * "/bar/{foo}" rather than "/{foo=bar/&#42;}"), and the rest as query parameters.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataSimplePath(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataSimplePathMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a path resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataPathResource(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataPathResourceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Same as RepeatDataSimplePath, but with a trailing resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataPathTrailingResource(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataPathTrailingResourceMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PUT method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataBodyPut(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataBodyPutMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method echoes the ComplianceData request, using the HTTP PATCH method.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.RepeatResponse>
        repeatDataBodyPatch(com.google.showcase.v1beta1.RepeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRepeatDataBodyPatchMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method requests an enum value from the server. Depending on the contents of EnumRequest, the enum value returned will be a known enum declared in the
     * .proto file, or a made-up enum value the is unknown to the client. To verify that clients can round-trip unknown enum values they receive, use the
     * response from this RPC as the request to VerifyEnum()
     * The values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run (this is needed for
     * VerifyEnum() to work) but are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.EnumResponse>
        getEnum(com.google.showcase.v1beta1.EnumRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEnumMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * This method is used to verify that clients can round-trip enum values, which is particularly important for unknown enum values over REST. VerifyEnum()
     * verifies that its request, which is presumably the response that the client previously got to a GetEnum(), contains the correct data. If so, it responds
     * with the same EnumResponse; otherwise, the RPC errors.
     * This works because the values of enums sent by the server when a known or unknown value is requested will be the same within a single Showcase server run,
     * although they are not guaranteed to be the same across separate Showcase server runs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.showcase.v1beta1.EnumResponse>
        verifyEnum(com.google.showcase.v1beta1.EnumResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyEnumMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REPEAT_DATA_BODY = 0;
  private static final int METHODID_REPEAT_DATA_BODY_INFO = 1;
  private static final int METHODID_REPEAT_DATA_QUERY = 2;
  private static final int METHODID_REPEAT_DATA_SIMPLE_PATH = 3;
  private static final int METHODID_REPEAT_DATA_PATH_RESOURCE = 4;
  private static final int METHODID_REPEAT_DATA_PATH_TRAILING_RESOURCE = 5;
  private static final int METHODID_REPEAT_DATA_BODY_PUT = 6;
  private static final int METHODID_REPEAT_DATA_BODY_PATCH = 7;
  private static final int METHODID_GET_ENUM = 8;
  private static final int METHODID_VERIFY_ENUM = 9;

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
        case METHODID_REPEAT_DATA_BODY:
          serviceImpl.repeatDataBody(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_BODY_INFO:
          serviceImpl.repeatDataBodyInfo(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_QUERY:
          serviceImpl.repeatDataQuery(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_SIMPLE_PATH:
          serviceImpl.repeatDataSimplePath(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_PATH_RESOURCE:
          serviceImpl.repeatDataPathResource(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_PATH_TRAILING_RESOURCE:
          serviceImpl.repeatDataPathTrailingResource(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_BODY_PUT:
          serviceImpl.repeatDataBodyPut(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_REPEAT_DATA_BODY_PATCH:
          serviceImpl.repeatDataBodyPatch(
              (com.google.showcase.v1beta1.RepeatRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.RepeatResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENUM:
          serviceImpl.getEnum(
              (com.google.showcase.v1beta1.EnumRequest) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse>)
                  responseObserver);
          break;
        case METHODID_VERIFY_ENUM:
          serviceImpl.verifyEnum(
              (com.google.showcase.v1beta1.EnumResponse) request,
              (io.grpc.stub.StreamObserver<com.google.showcase.v1beta1.EnumResponse>)
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
            getRepeatDataBodyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_BODY)))
        .addMethod(
            getRepeatDataBodyInfoMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_BODY_INFO)))
        .addMethod(
            getRepeatDataQueryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_QUERY)))
        .addMethod(
            getRepeatDataSimplePathMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_SIMPLE_PATH)))
        .addMethod(
            getRepeatDataPathResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_PATH_RESOURCE)))
        .addMethod(
            getRepeatDataPathTrailingResourceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_PATH_TRAILING_RESOURCE)))
        .addMethod(
            getRepeatDataBodyPutMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_BODY_PUT)))
        .addMethod(
            getRepeatDataBodyPatchMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.RepeatRequest,
                    com.google.showcase.v1beta1.RepeatResponse>(
                    service, METHODID_REPEAT_DATA_BODY_PATCH)))
        .addMethod(
            getGetEnumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.EnumRequest,
                    com.google.showcase.v1beta1.EnumResponse>(service, METHODID_GET_ENUM)))
        .addMethod(
            getVerifyEnumMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.showcase.v1beta1.EnumResponse,
                    com.google.showcase.v1beta1.EnumResponse>(service, METHODID_VERIFY_ENUM)))
        .build();
  }

  private abstract static class ComplianceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ComplianceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.showcase.v1beta1.ComplianceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Compliance");
    }
  }

  private static final class ComplianceFileDescriptorSupplier
      extends ComplianceBaseDescriptorSupplier {
    ComplianceFileDescriptorSupplier() {}
  }

  private static final class ComplianceMethodDescriptorSupplier
      extends ComplianceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ComplianceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ComplianceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ComplianceFileDescriptorSupplier())
                      .addMethod(getRepeatDataBodyMethod())
                      .addMethod(getRepeatDataBodyInfoMethod())
                      .addMethod(getRepeatDataQueryMethod())
                      .addMethod(getRepeatDataSimplePathMethod())
                      .addMethod(getRepeatDataPathResourceMethod())
                      .addMethod(getRepeatDataPathTrailingResourceMethod())
                      .addMethod(getRepeatDataBodyPutMethod())
                      .addMethod(getRepeatDataBodyPatchMethod())
                      .addMethod(getGetEnumMethod())
                      .addMethod(getVerifyEnumMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
