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
package com.google.recaptchaenterprise.v1;

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
 * Service to determine the likelihood an event is legitimate.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/recaptchaenterprise/v1/recaptchaenterprise.proto")
public final class RecaptchaEnterpriseServiceGrpc {

  private RecaptchaEnterpriseServiceGrpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.recaptchaenterprise.v1.RecaptchaEnterpriseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1.Assessment>
      getCreateAssessmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAssessment",
      requestType = com.google.recaptchaenterprise.v1.CreateAssessmentRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Assessment.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1.Assessment>
      getCreateAssessmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
            com.google.recaptchaenterprise.v1.Assessment>
        getCreateAssessmentMethod;
    if ((getCreateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getCreateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getCreateAssessmentMethod =
              getCreateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
                          com.google.recaptchaenterprise.v1.Assessment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.CreateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Assessment.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "CreateAssessment"))
                      .build();
        }
      }
    }
    return getCreateAssessmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnnotateAssessment",
      requestType = com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest.class,
      responseType = com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
            com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
        getAnnotateAssessmentMethod;
    if ((getAnnotateAssessmentMethod = RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getAnnotateAssessmentMethod =
                RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceGrpc.getAnnotateAssessmentMethod =
              getAnnotateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
                          com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnnotateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier(
                              "AnnotateAssessment"))
                      .build();
        }
      }
    }
    return getAnnotateAssessmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getCreateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateKey",
      requestType = com.google.recaptchaenterprise.v1.CreateKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.CreateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getCreateKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.CreateKeyRequest,
            com.google.recaptchaenterprise.v1.Key>
        getCreateKeyMethod;
    if ((getCreateKeyMethod = RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getCreateKeyMethod = RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getCreateKeyMethod =
              getCreateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.CreateKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.CreateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("CreateKey"))
                      .build();
        }
      }
    }
    return getCreateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListKeysRequest,
          com.google.recaptchaenterprise.v1.ListKeysResponse>
      getListKeysMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListKeys",
      requestType = com.google.recaptchaenterprise.v1.ListKeysRequest.class,
      responseType = com.google.recaptchaenterprise.v1.ListKeysResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.ListKeysRequest,
          com.google.recaptchaenterprise.v1.ListKeysResponse>
      getListKeysMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.ListKeysRequest,
            com.google.recaptchaenterprise.v1.ListKeysResponse>
        getListKeysMethod;
    if ((getListKeysMethod = RecaptchaEnterpriseServiceGrpc.getListKeysMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getListKeysMethod = RecaptchaEnterpriseServiceGrpc.getListKeysMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getListKeysMethod =
              getListKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.ListKeysRequest,
                          com.google.recaptchaenterprise.v1.ListKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.ListKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("ListKeys"))
                      .build();
        }
      }
    }
    return getListKeysMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getGetKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetKey",
      requestType = com.google.recaptchaenterprise.v1.GetKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getGetKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.GetKeyRequest, com.google.recaptchaenterprise.v1.Key>
        getGetKeyMethod;
    if ((getGetKeyMethod = RecaptchaEnterpriseServiceGrpc.getGetKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getGetKeyMethod = RecaptchaEnterpriseServiceGrpc.getGetKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getGetKeyMethod =
              getGetKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.GetKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.GetKeyRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("GetKey"))
                      .build();
        }
      }
    }
    return getGetKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getUpdateKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateKey",
      requestType = com.google.recaptchaenterprise.v1.UpdateKeyRequest.class,
      responseType = com.google.recaptchaenterprise.v1.Key.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.UpdateKeyRequest, com.google.recaptchaenterprise.v1.Key>
      getUpdateKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.UpdateKeyRequest,
            com.google.recaptchaenterprise.v1.Key>
        getUpdateKeyMethod;
    if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getUpdateKeyMethod =
              getUpdateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.UpdateKeyRequest,
                          com.google.recaptchaenterprise.v1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.UpdateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("UpdateKey"))
                      .build();
        }
      }
    }
    return getUpdateKeyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteKey",
      requestType = com.google.recaptchaenterprise.v1.DeleteKeyRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1.DeleteKeyRequest, com.google.protobuf.Empty>
        getDeleteKeyMethod;
    if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod) == null) {
          RecaptchaEnterpriseServiceGrpc.getDeleteKeyMethod =
              getDeleteKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1.DeleteKeyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1.DeleteKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceMethodDescriptorSupplier("DeleteKey"))
                      .build();
        }
      }
    }
    return getDeleteKeyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RecaptchaEnterpriseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecaptchaEnterpriseServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceBlockingStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceBlockingStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecaptchaEnterpriseServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<RecaptchaEnterpriseServiceFutureStub>() {
          @java.lang.Override
          public RecaptchaEnterpriseServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new RecaptchaEnterpriseServiceFutureStub(channel, callOptions);
          }
        };
    return RecaptchaEnterpriseServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public abstract static class RecaptchaEnterpriseServiceImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAssessmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public void annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAnnotateAssessmentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public void createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public void listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListKeysMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public void getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getGetKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public void updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateKeyMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public void deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeyMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAssessmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.CreateAssessmentRequest,
                      com.google.recaptchaenterprise.v1.Assessment>(
                      this, METHODID_CREATE_ASSESSMENT)))
          .addMethod(
              getAnnotateAssessmentMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest,
                      com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>(
                      this, METHODID_ANNOTATE_ASSESSMENT)))
          .addMethod(
              getCreateKeyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.CreateKeyRequest,
                      com.google.recaptchaenterprise.v1.Key>(this, METHODID_CREATE_KEY)))
          .addMethod(
              getListKeysMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.ListKeysRequest,
                      com.google.recaptchaenterprise.v1.ListKeysResponse>(
                      this, METHODID_LIST_KEYS)))
          .addMethod(
              getGetKeyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.GetKeyRequest,
                      com.google.recaptchaenterprise.v1.Key>(this, METHODID_GET_KEY)))
          .addMethod(
              getUpdateKeyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.UpdateKeyRequest,
                      com.google.recaptchaenterprise.v1.Key>(this, METHODID_UPDATE_KEY)))
          .addMethod(
              getDeleteKeyMethod(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1.DeleteKeyRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_KEY)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceStub
      extends io.grpc.stub.AbstractAsyncStub<RecaptchaEnterpriseServiceStub> {
    private RecaptchaEnterpriseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAssessmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public void annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public void createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public void listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListKeysMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public void getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public void updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public void deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<RecaptchaEnterpriseServiceBlockingStub> {
    private RecaptchaEnterpriseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Assessment createAssessment(
        com.google.recaptchaenterprise.v1.CreateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAssessmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse annotateAssessment(
        com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnnotateAssessmentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key createKey(
        com.google.recaptchaenterprise.v1.CreateKeyRequest request) {
      return blockingUnaryCall(getChannel(), getCreateKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.ListKeysResponse listKeys(
        com.google.recaptchaenterprise.v1.ListKeysRequest request) {
      return blockingUnaryCall(getChannel(), getListKeysMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key getKey(
        com.google.recaptchaenterprise.v1.GetKeyRequest request) {
      return blockingUnaryCall(getChannel(), getGetKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1.Key updateKey(
        com.google.recaptchaenterprise.v1.UpdateKeyRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateKeyMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.protobuf.Empty deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteKeyMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<RecaptchaEnterpriseServiceFutureStub> {
    private RecaptchaEnterpriseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.Assessment>
        createAssessment(com.google.recaptchaenterprise.v1.CreateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAssessmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>
        annotateAssessment(com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        createKey(com.google.recaptchaenterprise.v1.CreateKeyRequest request) {
      return futureUnaryCall(getChannel().newCall(getCreateKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1.ListKeysResponse>
        listKeys(com.google.recaptchaenterprise.v1.ListKeysRequest request) {
      return futureUnaryCall(getChannel().newCall(getListKeysMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        getKey(com.google.recaptchaenterprise.v1.GetKeyRequest request) {
      return futureUnaryCall(getChannel().newCall(getGetKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.recaptchaenterprise.v1.Key>
        updateKey(com.google.recaptchaenterprise.v1.UpdateKeyRequest request) {
      return futureUnaryCall(getChannel().newCall(getUpdateKeyMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteKey(
        com.google.recaptchaenterprise.v1.DeleteKeyRequest request) {
      return futureUnaryCall(getChannel().newCall(getDeleteKeyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ASSESSMENT = 0;
  private static final int METHODID_ANNOTATE_ASSESSMENT = 1;
  private static final int METHODID_CREATE_KEY = 2;
  private static final int METHODID_LIST_KEYS = 3;
  private static final int METHODID_GET_KEY = 4;
  private static final int METHODID_UPDATE_KEY = 5;
  private static final int METHODID_DELETE_KEY = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final RecaptchaEnterpriseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecaptchaEnterpriseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ASSESSMENT:
          serviceImpl.createAssessment(
              (com.google.recaptchaenterprise.v1.CreateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Assessment>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_ASSESSMENT:
          serviceImpl.annotateAssessment(
              (com.google.recaptchaenterprise.v1.AnnotateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1.AnnotateAssessmentResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_KEY:
          serviceImpl.createKey(
              (com.google.recaptchaenterprise.v1.CreateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_LIST_KEYS:
          serviceImpl.listKeys(
              (com.google.recaptchaenterprise.v1.ListKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.ListKeysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_KEY:
          serviceImpl.getKey(
              (com.google.recaptchaenterprise.v1.GetKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_UPDATE_KEY:
          serviceImpl.updateKey(
              (com.google.recaptchaenterprise.v1.UpdateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1.Key>)
                  responseObserver);
          break;
        case METHODID_DELETE_KEY:
          serviceImpl.deleteKey(
              (com.google.recaptchaenterprise.v1.DeleteKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private abstract static class RecaptchaEnterpriseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecaptchaEnterpriseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.recaptchaenterprise.v1.RecaptchaEnterpriseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecaptchaEnterpriseService");
    }
  }

  private static final class RecaptchaEnterpriseServiceFileDescriptorSupplier
      extends RecaptchaEnterpriseServiceBaseDescriptorSupplier {
    RecaptchaEnterpriseServiceFileDescriptorSupplier() {}
  }

  private static final class RecaptchaEnterpriseServiceMethodDescriptorSupplier
      extends RecaptchaEnterpriseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecaptchaEnterpriseServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (RecaptchaEnterpriseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new RecaptchaEnterpriseServiceFileDescriptorSupplier())
                      .addMethod(getCreateAssessmentMethod())
                      .addMethod(getAnnotateAssessmentMethod())
                      .addMethod(getCreateKeyMethod())
                      .addMethod(getListKeysMethod())
                      .addMethod(getGetKeyMethod())
                      .addMethod(getUpdateKeyMethod())
                      .addMethod(getDeleteKeyMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
