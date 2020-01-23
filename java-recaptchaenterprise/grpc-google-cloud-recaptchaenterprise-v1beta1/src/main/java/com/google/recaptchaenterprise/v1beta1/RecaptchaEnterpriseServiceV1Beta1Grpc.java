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
package com.google.recaptchaenterprise.v1beta1;

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
    value = "by gRPC proto compiler (version 1.10.0)",
    comments = "Source: google/cloud/recaptchaenterprise/v1beta1/recaptchaenterprise.proto")
public final class RecaptchaEnterpriseServiceV1Beta1Grpc {

  private RecaptchaEnterpriseServiceV1Beta1Grpc() {}

  public static final String SERVICE_NAME =
      "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateAssessmentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      METHOD_CREATE_ASSESSMENT = getCreateAssessmentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethod() {
    return getCreateAssessmentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.Assessment>
      getCreateAssessmentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
            com.google.recaptchaenterprise.v1beta1.Assessment>
        getCreateAssessmentMethod;
    if ((getCreateAssessmentMethod =
            RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getCreateAssessmentMethod =
                RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateAssessmentMethod =
              getCreateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
                          com.google.recaptchaenterprise.v1beta1.Assessment>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "CreateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.Assessment
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "CreateAssessment"))
                      .build();
        }
      }
    }
    return getCreateAssessmentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getAnnotateAssessmentMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      METHOD_ANNOTATE_ASSESSMENT = getAnnotateAssessmentMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethod() {
    return getAnnotateAssessmentMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
      getAnnotateAssessmentMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
        getAnnotateAssessmentMethod;
    if ((getAnnotateAssessmentMethod =
            RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod)
        == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getAnnotateAssessmentMethod =
                RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getAnnotateAssessmentMethod =
              getAnnotateAssessmentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
                          com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "AnnotateAssessment"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "AnnotateAssessment"))
                      .build();
        }
      }
    }
    return getAnnotateAssessmentMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCreateKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      METHOD_CREATE_KEY = getCreateKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getCreateKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getCreateKeyMethod() {
    return getCreateKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getCreateKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
            com.google.recaptchaenterprise.v1beta1.Key>
        getCreateKeyMethod;
    if ((getCreateKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getCreateKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateKeyMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getCreateKeyMethod =
              getCreateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
                          com.google.recaptchaenterprise.v1beta1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "CreateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.CreateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "CreateKey"))
                      .build();
        }
      }
    }
    return getCreateKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getListKeysMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
          com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
      METHOD_LIST_KEYS = getListKeysMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
          com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
      getListKeysMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
          com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
      getListKeysMethod() {
    return getListKeysMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
          com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
      getListKeysMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
            com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
        getListKeysMethod;
    if ((getListKeysMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getListKeysMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getListKeysMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getListKeysMethod) == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getListKeysMethod =
              getListKeysMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
                          com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "ListKeys"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.ListKeysRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.ListKeysResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier("ListKeys"))
                      .build();
        }
      }
    }
    return getListKeysMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getGetKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      METHOD_GET_KEY = getGetKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getGetKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getGetKeyMethod() {
    return getGetKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getGetKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
            com.google.recaptchaenterprise.v1beta1.Key>
        getGetKeyMethod;
    if ((getGetKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getGetKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getGetKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getGetKeyMethod) == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getGetKeyMethod =
              getGetKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
                          com.google.recaptchaenterprise.v1beta1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "GetKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.GetKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier("GetKey"))
                      .build();
        }
      }
    }
    return getGetKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getUpdateKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      METHOD_UPDATE_KEY = getUpdateKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getUpdateKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getUpdateKeyMethod() {
    return getUpdateKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
          com.google.recaptchaenterprise.v1beta1.Key>
      getUpdateKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
            com.google.recaptchaenterprise.v1beta1.Key>
        getUpdateKeyMethod;
    if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getUpdateKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getUpdateKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getUpdateKeyMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getUpdateKeyMethod =
              getUpdateKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
                          com.google.recaptchaenterprise.v1beta1.Key>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "UpdateKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.Key.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "UpdateKey"))
                      .build();
        }
      }
    }
    return getUpdateKeyMethod;
  }

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getDeleteKeyMethod()} instead.
  public static final io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest, com.google.protobuf.Empty>
      METHOD_DELETE_KEY = getDeleteKeyMethodHelper();

  private static volatile io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethod() {
    return getDeleteKeyMethodHelper();
  }

  private static io.grpc.MethodDescriptor<
          com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest, com.google.protobuf.Empty>
      getDeleteKeyMethodHelper() {
    io.grpc.MethodDescriptor<
            com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest, com.google.protobuf.Empty>
        getDeleteKeyMethod;
    if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getDeleteKeyMethod) == null) {
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        if ((getDeleteKeyMethod = RecaptchaEnterpriseServiceV1Beta1Grpc.getDeleteKeyMethod)
            == null) {
          RecaptchaEnterpriseServiceV1Beta1Grpc.getDeleteKeyMethod =
              getDeleteKeyMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              "google.cloud.recaptchaenterprise.v1beta1.RecaptchaEnterpriseServiceV1Beta1",
                              "DeleteKey"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(
                              "DeleteKey"))
                      .build();
        }
      }
    }
    return getDeleteKeyMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static RecaptchaEnterpriseServiceV1Beta1Stub newStub(io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1Stub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static RecaptchaEnterpriseServiceV1Beta1BlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1BlockingStub(channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static RecaptchaEnterpriseServiceV1Beta1FutureStub newFutureStub(io.grpc.Channel channel) {
    return new RecaptchaEnterpriseServiceV1Beta1FutureStub(channel);
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public abstract static class RecaptchaEnterpriseServiceV1Beta1ImplBase
      implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>
            responseObserver) {
      asyncUnimplementedUnaryCall(getCreateAssessmentMethodHelper(), responseObserver);
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
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getAnnotateAssessmentMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public void createKey(
        com.google.recaptchaenterprise.v1beta1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public void listKeys(
        com.google.recaptchaenterprise.v1beta1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
            responseObserver) {
      asyncUnimplementedUnaryCall(getListKeysMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public void getKey(
        com.google.recaptchaenterprise.v1beta1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getGetKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public void updateKey(
        com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateKeyMethodHelper(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public void deleteKey(
        com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteKeyMethodHelper(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateAssessmentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest,
                      com.google.recaptchaenterprise.v1beta1.Assessment>(
                      this, METHODID_CREATE_ASSESSMENT)))
          .addMethod(
              getAnnotateAssessmentMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest,
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>(
                      this, METHODID_ANNOTATE_ASSESSMENT)))
          .addMethod(
              getCreateKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.CreateKeyRequest,
                      com.google.recaptchaenterprise.v1beta1.Key>(this, METHODID_CREATE_KEY)))
          .addMethod(
              getListKeysMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.ListKeysRequest,
                      com.google.recaptchaenterprise.v1beta1.ListKeysResponse>(
                      this, METHODID_LIST_KEYS)))
          .addMethod(
              getGetKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.GetKeyRequest,
                      com.google.recaptchaenterprise.v1beta1.Key>(this, METHODID_GET_KEY)))
          .addMethod(
              getUpdateKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest,
                      com.google.recaptchaenterprise.v1beta1.Key>(this, METHODID_UPDATE_KEY)))
          .addMethod(
              getDeleteKeyMethodHelper(),
              asyncUnaryCall(
                  new MethodHandlers<
                      com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest,
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
  public static final class RecaptchaEnterpriseServiceV1Beta1Stub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1Stub> {
    private RecaptchaEnterpriseServiceV1Beta1Stub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public void createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateAssessmentMethodHelper(), getCallOptions()),
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
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request,
        io.grpc.stub.StreamObserver<
                com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethodHelper(), getCallOptions()),
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
        com.google.recaptchaenterprise.v1beta1.CreateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public void listKeys(
        com.google.recaptchaenterprise.v1beta1.ListKeysRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
            responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getListKeysMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public void getKey(
        com.google.recaptchaenterprise.v1beta1.GetKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public void updateKey(
        com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public void deleteKey(
        com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteKeyMethodHelper(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceV1Beta1BlockingStub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1BlockingStub> {
    private RecaptchaEnterpriseServiceV1Beta1BlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1BlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1BlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1BlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.Assessment createAssessment(
        com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateAssessmentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Annotates a previously created Assessment to provide additional information
     * on whether the event turned out to be authentic or fradulent.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse annotateAssessment(
        com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request) {
      return blockingUnaryCall(
          getChannel(), getAnnotateAssessmentMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.Key createKey(
        com.google.recaptchaenterprise.v1beta1.CreateKeyRequest request) {
      return blockingUnaryCall(getChannel(), getCreateKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.ListKeysResponse listKeys(
        com.google.recaptchaenterprise.v1beta1.ListKeysRequest request) {
      return blockingUnaryCall(getChannel(), getListKeysMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.Key getKey(
        com.google.recaptchaenterprise.v1beta1.GetKeyRequest request) {
      return blockingUnaryCall(getChannel(), getGetKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.recaptchaenterprise.v1beta1.Key updateKey(
        com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest request) {
      return blockingUnaryCall(getChannel(), getUpdateKeyMethodHelper(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.protobuf.Empty deleteKey(
        com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest request) {
      return blockingUnaryCall(getChannel(), getDeleteKeyMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service to determine the likelihood an event is legitimate.
   * </pre>
   */
  public static final class RecaptchaEnterpriseServiceV1Beta1FutureStub
      extends io.grpc.stub.AbstractStub<RecaptchaEnterpriseServiceV1Beta1FutureStub> {
    private RecaptchaEnterpriseServiceV1Beta1FutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private RecaptchaEnterpriseServiceV1Beta1FutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected RecaptchaEnterpriseServiceV1Beta1FutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new RecaptchaEnterpriseServiceV1Beta1FutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates an Assessment of the likelihood an event is legitimate.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.Assessment>
        createAssessment(com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateAssessmentMethodHelper(), getCallOptions()), request);
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
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>
        annotateAssessment(
            com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAnnotateAssessmentMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new reCAPTCHA Enterprise key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.Key>
        createKey(com.google.recaptchaenterprise.v1beta1.CreateKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all keys that belong to a project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.ListKeysResponse>
        listKeys(com.google.recaptchaenterprise.v1beta1.ListKeysRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getListKeysMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.Key>
        getKey(com.google.recaptchaenterprise.v1beta1.GetKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.recaptchaenterprise.v1beta1.Key>
        updateKey(com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateKeyMethodHelper(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes the specified key.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteKey(
        com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteKeyMethodHelper(), getCallOptions()), request);
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
    private final RecaptchaEnterpriseServiceV1Beta1ImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(RecaptchaEnterpriseServiceV1Beta1ImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ASSESSMENT:
          serviceImpl.createAssessment(
              (com.google.recaptchaenterprise.v1beta1.CreateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Assessment>)
                  responseObserver);
          break;
        case METHODID_ANNOTATE_ASSESSMENT:
          serviceImpl.annotateAssessment(
              (com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.recaptchaenterprise.v1beta1.AnnotateAssessmentResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_KEY:
          serviceImpl.createKey(
              (com.google.recaptchaenterprise.v1beta1.CreateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key>)
                  responseObserver);
          break;
        case METHODID_LIST_KEYS:
          serviceImpl.listKeys(
              (com.google.recaptchaenterprise.v1beta1.ListKeysRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.ListKeysResponse>)
                  responseObserver);
          break;
        case METHODID_GET_KEY:
          serviceImpl.getKey(
              (com.google.recaptchaenterprise.v1beta1.GetKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key>)
                  responseObserver);
          break;
        case METHODID_UPDATE_KEY:
          serviceImpl.updateKey(
              (com.google.recaptchaenterprise.v1beta1.UpdateKeyRequest) request,
              (io.grpc.stub.StreamObserver<com.google.recaptchaenterprise.v1beta1.Key>)
                  responseObserver);
          break;
        case METHODID_DELETE_KEY:
          serviceImpl.deleteKey(
              (com.google.recaptchaenterprise.v1beta1.DeleteKeyRequest) request,
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

  private abstract static class RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.recaptchaenterprise.v1beta1.RecaptchaEnterpriseProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("RecaptchaEnterpriseServiceV1Beta1");
    }
  }

  private static final class RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier
      extends RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier {
    RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier() {}
  }

  private static final class RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier
      extends RecaptchaEnterpriseServiceV1Beta1BaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    RecaptchaEnterpriseServiceV1Beta1MethodDescriptorSupplier(String methodName) {
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
      synchronized (RecaptchaEnterpriseServiceV1Beta1Grpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new RecaptchaEnterpriseServiceV1Beta1FileDescriptorSupplier())
                      .addMethod(getCreateAssessmentMethodHelper())
                      .addMethod(getAnnotateAssessmentMethodHelper())
                      .addMethod(getCreateKeyMethodHelper())
                      .addMethod(getListKeysMethodHelper())
                      .addMethod(getGetKeyMethodHelper())
                      .addMethod(getUpdateKeyMethodHelper())
                      .addMethod(getDeleteKeyMethodHelper())
                      .build();
        }
      }
    }
    return result;
  }
}
