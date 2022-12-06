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
package com.google.cloud.speech.v1p1beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service that implements Google Cloud Speech Adaptation API.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/speech/v1p1beta1/cloud_speech_adaptation.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AdaptationGrpc {

  private AdaptationGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.speech.v1p1beta1.Adaptation";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getCreatePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePhraseSet",
      requestType = com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.PhraseSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getCreatePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest,
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        getCreatePhraseSetMethod;
    if ((getCreatePhraseSetMethod = AdaptationGrpc.getCreatePhraseSetMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getCreatePhraseSetMethod = AdaptationGrpc.getCreatePhraseSetMethod) == null) {
          AdaptationGrpc.getCreatePhraseSetMethod =
              getCreatePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest,
                          com.google.cloud.speech.v1p1beta1.PhraseSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.PhraseSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("CreatePhraseSet"))
                      .build();
        }
      }
    }
    return getCreatePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getGetPhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhraseSet",
      requestType = com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.PhraseSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getGetPhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest,
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        getGetPhraseSetMethod;
    if ((getGetPhraseSetMethod = AdaptationGrpc.getGetPhraseSetMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getGetPhraseSetMethod = AdaptationGrpc.getGetPhraseSetMethod) == null) {
          AdaptationGrpc.getGetPhraseSetMethod =
              getGetPhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest,
                          com.google.cloud.speech.v1p1beta1.PhraseSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.PhraseSet.getDefaultInstance()))
                      .setSchemaDescriptor(new AdaptationMethodDescriptorSupplier("GetPhraseSet"))
                      .build();
        }
      }
    }
    return getGetPhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
      getListPhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPhraseSet",
      requestType = com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
      getListPhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest,
            com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
        getListPhraseSetMethod;
    if ((getListPhraseSetMethod = AdaptationGrpc.getListPhraseSetMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getListPhraseSetMethod = AdaptationGrpc.getListPhraseSetMethod) == null) {
          AdaptationGrpc.getListPhraseSetMethod =
              getListPhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest,
                          com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new AdaptationMethodDescriptorSupplier("ListPhraseSet"))
                      .build();
        }
      }
    }
    return getListPhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getUpdatePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhraseSet",
      requestType = com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.PhraseSet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest,
          com.google.cloud.speech.v1p1beta1.PhraseSet>
      getUpdatePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest,
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        getUpdatePhraseSetMethod;
    if ((getUpdatePhraseSetMethod = AdaptationGrpc.getUpdatePhraseSetMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getUpdatePhraseSetMethod = AdaptationGrpc.getUpdatePhraseSetMethod) == null) {
          AdaptationGrpc.getUpdatePhraseSetMethod =
              getUpdatePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest,
                          com.google.cloud.speech.v1p1beta1.PhraseSet>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.PhraseSet.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("UpdatePhraseSet"))
                      .build();
        }
      }
    }
    return getUpdatePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest, com.google.protobuf.Empty>
      getDeletePhraseSetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePhraseSet",
      requestType = com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest, com.google.protobuf.Empty>
      getDeletePhraseSetMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest, com.google.protobuf.Empty>
        getDeletePhraseSetMethod;
    if ((getDeletePhraseSetMethod = AdaptationGrpc.getDeletePhraseSetMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getDeletePhraseSetMethod = AdaptationGrpc.getDeletePhraseSetMethod) == null) {
          AdaptationGrpc.getDeletePhraseSetMethod =
              getDeletePhraseSetMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeletePhraseSet"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("DeletePhraseSet"))
                      .build();
        }
      }
    }
    return getDeletePhraseSetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getCreateCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateCustomClass",
      requestType = com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.CustomClass.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getCreateCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest,
            com.google.cloud.speech.v1p1beta1.CustomClass>
        getCreateCustomClassMethod;
    if ((getCreateCustomClassMethod = AdaptationGrpc.getCreateCustomClassMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getCreateCustomClassMethod = AdaptationGrpc.getCreateCustomClassMethod) == null) {
          AdaptationGrpc.getCreateCustomClassMethod =
              getCreateCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest,
                          com.google.cloud.speech.v1p1beta1.CustomClass>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.CustomClass.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("CreateCustomClass"))
                      .build();
        }
      }
    }
    return getCreateCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.GetCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getGetCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCustomClass",
      requestType = com.google.cloud.speech.v1p1beta1.GetCustomClassRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.CustomClass.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.GetCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getGetCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.GetCustomClassRequest,
            com.google.cloud.speech.v1p1beta1.CustomClass>
        getGetCustomClassMethod;
    if ((getGetCustomClassMethod = AdaptationGrpc.getGetCustomClassMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getGetCustomClassMethod = AdaptationGrpc.getGetCustomClassMethod) == null) {
          AdaptationGrpc.getGetCustomClassMethod =
              getGetCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.GetCustomClassRequest,
                          com.google.cloud.speech.v1p1beta1.CustomClass>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.GetCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.CustomClass.getDefaultInstance()))
                      .setSchemaDescriptor(new AdaptationMethodDescriptorSupplier("GetCustomClass"))
                      .build();
        }
      }
    }
    return getGetCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest,
          com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
      getListCustomClassesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCustomClasses",
      requestType = com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest,
          com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
      getListCustomClassesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest,
            com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
        getListCustomClassesMethod;
    if ((getListCustomClassesMethod = AdaptationGrpc.getListCustomClassesMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getListCustomClassesMethod = AdaptationGrpc.getListCustomClassesMethod) == null) {
          AdaptationGrpc.getListCustomClassesMethod =
              getListCustomClassesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest,
                          com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCustomClasses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("ListCustomClasses"))
                      .build();
        }
      }
    }
    return getListCustomClassesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getUpdateCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCustomClass",
      requestType = com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest.class,
      responseType = com.google.cloud.speech.v1p1beta1.CustomClass.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest,
          com.google.cloud.speech.v1p1beta1.CustomClass>
      getUpdateCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest,
            com.google.cloud.speech.v1p1beta1.CustomClass>
        getUpdateCustomClassMethod;
    if ((getUpdateCustomClassMethod = AdaptationGrpc.getUpdateCustomClassMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getUpdateCustomClassMethod = AdaptationGrpc.getUpdateCustomClassMethod) == null) {
          AdaptationGrpc.getUpdateCustomClassMethod =
              getUpdateCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest,
                          com.google.cloud.speech.v1p1beta1.CustomClass>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.CustomClass.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("UpdateCustomClass"))
                      .build();
        }
      }
    }
    return getUpdateCustomClassMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest, com.google.protobuf.Empty>
      getDeleteCustomClassMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCustomClass",
      requestType = com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest, com.google.protobuf.Empty>
      getDeleteCustomClassMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest, com.google.protobuf.Empty>
        getDeleteCustomClassMethod;
    if ((getDeleteCustomClassMethod = AdaptationGrpc.getDeleteCustomClassMethod) == null) {
      synchronized (AdaptationGrpc.class) {
        if ((getDeleteCustomClassMethod = AdaptationGrpc.getDeleteCustomClassMethod) == null) {
          AdaptationGrpc.getDeleteCustomClassMethod =
              getDeleteCustomClassMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCustomClass"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new AdaptationMethodDescriptorSupplier("DeleteCustomClass"))
                      .build();
        }
      }
    }
    return getDeleteCustomClassMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static AdaptationStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdaptationStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdaptationStub>() {
          @java.lang.Override
          public AdaptationStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdaptationStub(channel, callOptions);
          }
        };
    return AdaptationStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdaptationBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdaptationBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdaptationBlockingStub>() {
          @java.lang.Override
          public AdaptationBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdaptationBlockingStub(channel, callOptions);
          }
        };
    return AdaptationBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static AdaptationFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdaptationFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<AdaptationFutureStub>() {
          @java.lang.Override
          public AdaptationFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new AdaptationFutureStub(channel, callOptions);
          }
        };
    return AdaptationFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech Adaptation API.
   * </pre>
   */
  public abstract static class AdaptationImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Create a set of phrase hints. Each item in the set can be a single word or
     * a multi-word phrase. The items in the PhraseSet are favored by the
     * recognition model when you send a call that includes the PhraseSet.
     * </pre>
     */
    public void createPhraseSet(
        com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a phrase set.
     * </pre>
     */
    public void getPhraseSet(
        com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List phrase sets.
     * </pre>
     */
    public void listPhraseSet(
        com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a phrase set.
     * </pre>
     */
    public void updatePhraseSet(
        com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a phrase set.
     * </pre>
     */
    public void deletePhraseSet(
        com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePhraseSetMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a custom class.
     * </pre>
     */
    public void createCustomClass(
        com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a custom class.
     * </pre>
     */
    public void getCustomClass(
        com.google.cloud.speech.v1p1beta1.GetCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List custom classes.
     * </pre>
     */
    public void listCustomClasses(
        com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCustomClassesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a custom class.
     * </pre>
     */
    public void updateCustomClass(
        com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCustomClassMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a custom class.
     * </pre>
     */
    public void deleteCustomClass(
        com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCustomClassMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreatePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest,
                      com.google.cloud.speech.v1p1beta1.PhraseSet>(
                      this, METHODID_CREATE_PHRASE_SET)))
          .addMethod(
              getGetPhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest,
                      com.google.cloud.speech.v1p1beta1.PhraseSet>(this, METHODID_GET_PHRASE_SET)))
          .addMethod(
              getListPhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest,
                      com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>(
                      this, METHODID_LIST_PHRASE_SET)))
          .addMethod(
              getUpdatePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest,
                      com.google.cloud.speech.v1p1beta1.PhraseSet>(
                      this, METHODID_UPDATE_PHRASE_SET)))
          .addMethod(
              getDeletePhraseSetMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_PHRASE_SET)))
          .addMethod(
              getCreateCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest,
                      com.google.cloud.speech.v1p1beta1.CustomClass>(
                      this, METHODID_CREATE_CUSTOM_CLASS)))
          .addMethod(
              getGetCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.GetCustomClassRequest,
                      com.google.cloud.speech.v1p1beta1.CustomClass>(
                      this, METHODID_GET_CUSTOM_CLASS)))
          .addMethod(
              getListCustomClassesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest,
                      com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>(
                      this, METHODID_LIST_CUSTOM_CLASSES)))
          .addMethod(
              getUpdateCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest,
                      com.google.cloud.speech.v1p1beta1.CustomClass>(
                      this, METHODID_UPDATE_CUSTOM_CLASS)))
          .addMethod(
              getDeleteCustomClassMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_CUSTOM_CLASS)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech Adaptation API.
   * </pre>
   */
  public static final class AdaptationStub extends io.grpc.stub.AbstractAsyncStub<AdaptationStub> {
    private AdaptationStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdaptationStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdaptationStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a set of phrase hints. Each item in the set can be a single word or
     * a multi-word phrase. The items in the PhraseSet are favored by the
     * recognition model when you send a call that includes the PhraseSet.
     * </pre>
     */
    public void createPhraseSet(
        com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a phrase set.
     * </pre>
     */
    public void getPhraseSet(
        com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List phrase sets.
     * </pre>
     */
    public void listPhraseSet(
        com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a phrase set.
     * </pre>
     */
    public void updatePhraseSet(
        com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a phrase set.
     * </pre>
     */
    public void deletePhraseSet(
        com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePhraseSetMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a custom class.
     * </pre>
     */
    public void createCustomClass(
        com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a custom class.
     * </pre>
     */
    public void getCustomClass(
        com.google.cloud.speech.v1p1beta1.GetCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List custom classes.
     * </pre>
     */
    public void listCustomClasses(
        com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCustomClassesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update a custom class.
     * </pre>
     */
    public void updateCustomClass(
        com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete a custom class.
     * </pre>
     */
    public void deleteCustomClass(
        com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomClassMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech Adaptation API.
   * </pre>
   */
  public static final class AdaptationBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdaptationBlockingStub> {
    private AdaptationBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdaptationBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdaptationBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a set of phrase hints. Each item in the set can be a single word or
     * a multi-word phrase. The items in the PhraseSet are favored by the
     * recognition model when you send a call that includes the PhraseSet.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.PhraseSet createPhraseSet(
        com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a phrase set.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.PhraseSet getPhraseSet(
        com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List phrase sets.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse listPhraseSet(
        com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a phrase set.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.PhraseSet updatePhraseSet(
        com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a phrase set.
     * </pre>
     */
    public com.google.protobuf.Empty deletePhraseSet(
        com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhraseSetMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a custom class.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.CustomClass createCustomClass(
        com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a custom class.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.CustomClass getCustomClass(
        com.google.cloud.speech.v1p1beta1.GetCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List custom classes.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse listCustomClasses(
        com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCustomClassesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update a custom class.
     * </pre>
     */
    public com.google.cloud.speech.v1p1beta1.CustomClass updateCustomClass(
        com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCustomClassMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a custom class.
     * </pre>
     */
    public com.google.protobuf.Empty deleteCustomClass(
        com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomClassMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service that implements Google Cloud Speech Adaptation API.
   * </pre>
   */
  public static final class AdaptationFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdaptationFutureStub> {
    private AdaptationFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdaptationFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdaptationFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create a set of phrase hints. Each item in the set can be a single word or
     * a multi-word phrase. The items in the PhraseSet are favored by the
     * recognition model when you send a call that includes the PhraseSet.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        createPhraseSet(com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a phrase set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        getPhraseSet(com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List phrase sets.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>
        listPhraseSet(com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a phrase set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.PhraseSet>
        updatePhraseSet(com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a phrase set.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePhraseSet(com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePhraseSetMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a custom class.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.CustomClass>
        createCustomClass(com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a custom class.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.CustomClass>
        getCustomClass(com.google.cloud.speech.v1p1beta1.GetCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List custom classes.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>
        listCustomClasses(com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCustomClassesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update a custom class.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.speech.v1p1beta1.CustomClass>
        updateCustomClass(com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCustomClassMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete a custom class.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteCustomClass(com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomClassMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PHRASE_SET = 0;
  private static final int METHODID_GET_PHRASE_SET = 1;
  private static final int METHODID_LIST_PHRASE_SET = 2;
  private static final int METHODID_UPDATE_PHRASE_SET = 3;
  private static final int METHODID_DELETE_PHRASE_SET = 4;
  private static final int METHODID_CREATE_CUSTOM_CLASS = 5;
  private static final int METHODID_GET_CUSTOM_CLASS = 6;
  private static final int METHODID_LIST_CUSTOM_CLASSES = 7;
  private static final int METHODID_UPDATE_CUSTOM_CLASS = 8;
  private static final int METHODID_DELETE_CUSTOM_CLASS = 9;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AdaptationImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AdaptationImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PHRASE_SET:
          serviceImpl.createPhraseSet(
              (com.google.cloud.speech.v1p1beta1.CreatePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet>)
                  responseObserver);
          break;
        case METHODID_GET_PHRASE_SET:
          serviceImpl.getPhraseSet(
              (com.google.cloud.speech.v1p1beta1.GetPhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet>)
                  responseObserver);
          break;
        case METHODID_LIST_PHRASE_SET:
          serviceImpl.listPhraseSet(
              (com.google.cloud.speech.v1p1beta1.ListPhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.ListPhraseSetResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PHRASE_SET:
          serviceImpl.updatePhraseSet(
              (com.google.cloud.speech.v1p1beta1.UpdatePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.PhraseSet>)
                  responseObserver);
          break;
        case METHODID_DELETE_PHRASE_SET:
          serviceImpl.deletePhraseSet(
              (com.google.cloud.speech.v1p1beta1.DeletePhraseSetRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_CUSTOM_CLASS:
          serviceImpl.createCustomClass(
              (com.google.cloud.speech.v1p1beta1.CreateCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>)
                  responseObserver);
          break;
        case METHODID_GET_CUSTOM_CLASS:
          serviceImpl.getCustomClass(
              (com.google.cloud.speech.v1p1beta1.GetCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>)
                  responseObserver);
          break;
        case METHODID_LIST_CUSTOM_CLASSES:
          serviceImpl.listCustomClasses(
              (com.google.cloud.speech.v1p1beta1.ListCustomClassesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.speech.v1p1beta1.ListCustomClassesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_CUSTOM_CLASS:
          serviceImpl.updateCustomClass(
              (com.google.cloud.speech.v1p1beta1.UpdateCustomClassRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.speech.v1p1beta1.CustomClass>)
                  responseObserver);
          break;
        case METHODID_DELETE_CUSTOM_CLASS:
          serviceImpl.deleteCustomClass(
              (com.google.cloud.speech.v1p1beta1.DeleteCustomClassRequest) request,
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

  private abstract static class AdaptationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdaptationBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.speech.v1p1beta1.SpeechAdaptationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Adaptation");
    }
  }

  private static final class AdaptationFileDescriptorSupplier
      extends AdaptationBaseDescriptorSupplier {
    AdaptationFileDescriptorSupplier() {}
  }

  private static final class AdaptationMethodDescriptorSupplier
      extends AdaptationBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AdaptationMethodDescriptorSupplier(String methodName) {
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
      synchronized (AdaptationGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new AdaptationFileDescriptorSupplier())
                      .addMethod(getCreatePhraseSetMethod())
                      .addMethod(getGetPhraseSetMethod())
                      .addMethod(getListPhraseSetMethod())
                      .addMethod(getUpdatePhraseSetMethod())
                      .addMethod(getDeletePhraseSetMethod())
                      .addMethod(getCreateCustomClassMethod())
                      .addMethod(getGetCustomClassMethod())
                      .addMethod(getListCustomClassesMethod())
                      .addMethod(getUpdateCustomClassMethod())
                      .addMethod(getDeleteCustomClassMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
