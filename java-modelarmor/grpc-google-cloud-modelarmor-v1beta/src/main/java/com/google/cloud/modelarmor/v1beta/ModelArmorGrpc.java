/*
 * Copyright 2025 Google LLC
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
package com.google.cloud.modelarmor.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/modelarmor/v1beta/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ModelArmorGrpc {

  private ModelArmorGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.modelarmor.v1beta.ModelArmor";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.ListTemplatesRequest,
          com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
      getListTemplatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTemplates",
      requestType = com.google.cloud.modelarmor.v1beta.ListTemplatesRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.ListTemplatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.ListTemplatesRequest,
          com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
      getListTemplatesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.ListTemplatesRequest,
            com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
        getListTemplatesMethod;
    if ((getListTemplatesMethod = ModelArmorGrpc.getListTemplatesMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getListTemplatesMethod = ModelArmorGrpc.getListTemplatesMethod) == null) {
          ModelArmorGrpc.getListTemplatesMethod =
              getListTemplatesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.ListTemplatesRequest,
                          com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTemplates"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.ListTemplatesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.ListTemplatesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new ModelArmorMethodDescriptorSupplier("ListTemplates"))
                      .build();
        }
      }
    }
    return getListTemplatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.GetTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getGetTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTemplate",
      requestType = com.google.cloud.modelarmor.v1beta.GetTemplateRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.GetTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getGetTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.GetTemplateRequest,
            com.google.cloud.modelarmor.v1beta.Template>
        getGetTemplateMethod;
    if ((getGetTemplateMethod = ModelArmorGrpc.getGetTemplateMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getGetTemplateMethod = ModelArmorGrpc.getGetTemplateMethod) == null) {
          ModelArmorGrpc.getGetTemplateMethod =
              getGetTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.GetTemplateRequest,
                          com.google.cloud.modelarmor.v1beta.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.GetTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.Template.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelArmorMethodDescriptorSupplier("GetTemplate"))
                      .build();
        }
      }
    }
    return getGetTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.CreateTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getCreateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTemplate",
      requestType = com.google.cloud.modelarmor.v1beta.CreateTemplateRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.CreateTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getCreateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.CreateTemplateRequest,
            com.google.cloud.modelarmor.v1beta.Template>
        getCreateTemplateMethod;
    if ((getCreateTemplateMethod = ModelArmorGrpc.getCreateTemplateMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getCreateTemplateMethod = ModelArmorGrpc.getCreateTemplateMethod) == null) {
          ModelArmorGrpc.getCreateTemplateMethod =
              getCreateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.CreateTemplateRequest,
                          com.google.cloud.modelarmor.v1beta.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.CreateTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.Template.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelArmorMethodDescriptorSupplier("CreateTemplate"))
                      .build();
        }
      }
    }
    return getCreateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getUpdateTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateTemplate",
      requestType = com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.Template.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest,
          com.google.cloud.modelarmor.v1beta.Template>
      getUpdateTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest,
            com.google.cloud.modelarmor.v1beta.Template>
        getUpdateTemplateMethod;
    if ((getUpdateTemplateMethod = ModelArmorGrpc.getUpdateTemplateMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getUpdateTemplateMethod = ModelArmorGrpc.getUpdateTemplateMethod) == null) {
          ModelArmorGrpc.getUpdateTemplateMethod =
              getUpdateTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest,
                          com.google.cloud.modelarmor.v1beta.Template>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.Template.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelArmorMethodDescriptorSupplier("UpdateTemplate"))
                      .build();
        }
      }
    }
    return getUpdateTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest, com.google.protobuf.Empty>
      getDeleteTemplateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteTemplate",
      requestType = com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest, com.google.protobuf.Empty>
      getDeleteTemplateMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest, com.google.protobuf.Empty>
        getDeleteTemplateMethod;
    if ((getDeleteTemplateMethod = ModelArmorGrpc.getDeleteTemplateMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getDeleteTemplateMethod = ModelArmorGrpc.getDeleteTemplateMethod) == null) {
          ModelArmorGrpc.getDeleteTemplateMethod =
              getDeleteTemplateMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteTemplate"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new ModelArmorMethodDescriptorSupplier("DeleteTemplate"))
                      .build();
        }
      }
    }
    return getDeleteTemplateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest,
          com.google.cloud.modelarmor.v1beta.FloorSetting>
      getGetFloorSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFloorSetting",
      requestType = com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.FloorSetting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest,
          com.google.cloud.modelarmor.v1beta.FloorSetting>
      getGetFloorSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest,
            com.google.cloud.modelarmor.v1beta.FloorSetting>
        getGetFloorSettingMethod;
    if ((getGetFloorSettingMethod = ModelArmorGrpc.getGetFloorSettingMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getGetFloorSettingMethod = ModelArmorGrpc.getGetFloorSettingMethod) == null) {
          ModelArmorGrpc.getGetFloorSettingMethod =
              getGetFloorSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest,
                          com.google.cloud.modelarmor.v1beta.FloorSetting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFloorSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.FloorSetting.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelArmorMethodDescriptorSupplier("GetFloorSetting"))
                      .build();
        }
      }
    }
    return getGetFloorSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest,
          com.google.cloud.modelarmor.v1beta.FloorSetting>
      getUpdateFloorSettingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFloorSetting",
      requestType = com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.FloorSetting.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest,
          com.google.cloud.modelarmor.v1beta.FloorSetting>
      getUpdateFloorSettingMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest,
            com.google.cloud.modelarmor.v1beta.FloorSetting>
        getUpdateFloorSettingMethod;
    if ((getUpdateFloorSettingMethod = ModelArmorGrpc.getUpdateFloorSettingMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getUpdateFloorSettingMethod = ModelArmorGrpc.getUpdateFloorSettingMethod) == null) {
          ModelArmorGrpc.getUpdateFloorSettingMethod =
              getUpdateFloorSettingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest,
                          com.google.cloud.modelarmor.v1beta.FloorSetting>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateFloorSetting"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.FloorSetting.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelArmorMethodDescriptorSupplier("UpdateFloorSetting"))
                      .build();
        }
      }
    }
    return getUpdateFloorSettingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest,
          com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
      getSanitizeUserPromptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SanitizeUserPrompt",
      requestType = com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest,
          com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
      getSanitizeUserPromptMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest,
            com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
        getSanitizeUserPromptMethod;
    if ((getSanitizeUserPromptMethod = ModelArmorGrpc.getSanitizeUserPromptMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getSanitizeUserPromptMethod = ModelArmorGrpc.getSanitizeUserPromptMethod) == null) {
          ModelArmorGrpc.getSanitizeUserPromptMethod =
              getSanitizeUserPromptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest,
                          com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SanitizeUserPrompt"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelArmorMethodDescriptorSupplier("SanitizeUserPrompt"))
                      .build();
        }
      }
    }
    return getSanitizeUserPromptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest,
          com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
      getSanitizeModelResponseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SanitizeModelResponse",
      requestType = com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest.class,
      responseType = com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest,
          com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
      getSanitizeModelResponseMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest,
            com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
        getSanitizeModelResponseMethod;
    if ((getSanitizeModelResponseMethod = ModelArmorGrpc.getSanitizeModelResponseMethod) == null) {
      synchronized (ModelArmorGrpc.class) {
        if ((getSanitizeModelResponseMethod = ModelArmorGrpc.getSanitizeModelResponseMethod)
            == null) {
          ModelArmorGrpc.getSanitizeModelResponseMethod =
              getSanitizeModelResponseMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest,
                          com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SanitizeModelResponse"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ModelArmorMethodDescriptorSupplier("SanitizeModelResponse"))
                      .build();
        }
      }
    }
    return getSanitizeModelResponseMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ModelArmorStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelArmorStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelArmorStub>() {
          @java.lang.Override
          public ModelArmorStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelArmorStub(channel, callOptions);
          }
        };
    return ModelArmorStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ModelArmorBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelArmorBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelArmorBlockingV2Stub>() {
          @java.lang.Override
          public ModelArmorBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelArmorBlockingV2Stub(channel, callOptions);
          }
        };
    return ModelArmorBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ModelArmorBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelArmorBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelArmorBlockingStub>() {
          @java.lang.Override
          public ModelArmorBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelArmorBlockingStub(channel, callOptions);
          }
        };
    return ModelArmorBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ModelArmorFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ModelArmorFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ModelArmorFutureStub>() {
          @java.lang.Override
          public ModelArmorFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ModelArmorFutureStub(channel, callOptions);
          }
        };
    return ModelArmorFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    default void listTemplates(
        com.google.cloud.modelarmor.v1beta.ListTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTemplatesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    default void getTemplate(
        com.google.cloud.modelarmor.v1beta.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    default void createTemplate(
        com.google.cloud.modelarmor.v1beta.CreateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Template.
     * </pre>
     */
    default void updateTemplate(
        com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    default void deleteTemplate(
        com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteTemplateMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single floor setting of a project
     * </pre>
     */
    default void getFloorSetting(
        com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFloorSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single floor setting of a project
     * </pre>
     */
    default void updateFloorSetting(
        com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFloorSettingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes User Prompt.
     * </pre>
     */
    default void sanitizeUserPrompt(
        com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSanitizeUserPromptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes Model Response.
     * </pre>
     */
    default void sanitizeModelResponse(
        com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSanitizeModelResponseMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ModelArmor.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class ModelArmorImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ModelArmorGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ModelArmor.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ModelArmorStub extends io.grpc.stub.AbstractAsyncStub<ModelArmorStub> {
    private ModelArmorStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelArmorStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelArmorStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public void listTemplates(
        com.google.cloud.modelarmor.v1beta.ListTemplatesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTemplatesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public void getTemplate(
        com.google.cloud.modelarmor.v1beta.GetTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public void createTemplate(
        com.google.cloud.modelarmor.v1beta.CreateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Template.
     * </pre>
     */
    public void updateTemplate(
        com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public void deleteTemplate(
        com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteTemplateMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single floor setting of a project
     * </pre>
     */
    public void getFloorSetting(
        com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFloorSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single floor setting of a project
     * </pre>
     */
    public void updateFloorSetting(
        com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFloorSettingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes User Prompt.
     * </pre>
     */
    public void sanitizeUserPrompt(
        com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSanitizeUserPromptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes Model Response.
     * </pre>
     */
    public void sanitizeModelResponse(
        com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSanitizeModelResponseMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ModelArmor.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ModelArmorBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ModelArmorBlockingV2Stub> {
    private ModelArmorBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelArmorBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelArmorBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.ListTemplatesResponse listTemplates(
        com.google.cloud.modelarmor.v1beta.ListTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template getTemplate(
        com.google.cloud.modelarmor.v1beta.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template createTemplate(
        com.google.cloud.modelarmor.v1beta.CreateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Template.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template updateTemplate(
        com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplate(
        com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single floor setting of a project
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.FloorSetting getFloorSetting(
        com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFloorSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single floor setting of a project
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.FloorSetting updateFloorSetting(
        com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFloorSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes User Prompt.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse sanitizeUserPrompt(
        com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSanitizeUserPromptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes Model Response.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse sanitizeModelResponse(
        com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSanitizeModelResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ModelArmor.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ModelArmorBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ModelArmorBlockingStub> {
    private ModelArmorBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelArmorBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelArmorBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.ListTemplatesResponse listTemplates(
        com.google.cloud.modelarmor.v1beta.ListTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTemplatesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template getTemplate(
        com.google.cloud.modelarmor.v1beta.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template createTemplate(
        com.google.cloud.modelarmor.v1beta.CreateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Template.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.Template updateTemplate(
        com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.protobuf.Empty deleteTemplate(
        com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteTemplateMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single floor setting of a project
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.FloorSetting getFloorSetting(
        com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFloorSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single floor setting of a project
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.FloorSetting updateFloorSetting(
        com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFloorSettingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes User Prompt.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse sanitizeUserPrompt(
        com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSanitizeUserPromptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes Model Response.
     * </pre>
     */
    public com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse sanitizeModelResponse(
        com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSanitizeModelResponseMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ModelArmor.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class ModelArmorFutureStub
      extends io.grpc.stub.AbstractFutureStub<ModelArmorFutureStub> {
    private ModelArmorFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ModelArmorFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ModelArmorFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists Templates in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>
        listTemplates(com.google.cloud.modelarmor.v1beta.ListTemplatesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTemplatesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.Template>
        getTemplate(com.google.cloud.modelarmor.v1beta.GetTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Template in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.Template>
        createTemplate(com.google.cloud.modelarmor.v1beta.CreateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.Template>
        updateTemplate(com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Template.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteTemplate(com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteTemplateMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single floor setting of a project
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.FloorSetting>
        getFloorSetting(com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFloorSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single floor setting of a project
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.FloorSetting>
        updateFloorSetting(com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFloorSettingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes User Prompt.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>
        sanitizeUserPrompt(com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSanitizeUserPromptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Sanitizes Model Response.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>
        sanitizeModelResponse(
            com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSanitizeModelResponseMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_TEMPLATES = 0;
  private static final int METHODID_GET_TEMPLATE = 1;
  private static final int METHODID_CREATE_TEMPLATE = 2;
  private static final int METHODID_UPDATE_TEMPLATE = 3;
  private static final int METHODID_DELETE_TEMPLATE = 4;
  private static final int METHODID_GET_FLOOR_SETTING = 5;
  private static final int METHODID_UPDATE_FLOOR_SETTING = 6;
  private static final int METHODID_SANITIZE_USER_PROMPT = 7;
  private static final int METHODID_SANITIZE_MODEL_RESPONSE = 8;

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
        case METHODID_LIST_TEMPLATES:
          serviceImpl.listTemplates(
              (com.google.cloud.modelarmor.v1beta.ListTemplatesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TEMPLATE:
          serviceImpl.getTemplate(
              (com.google.cloud.modelarmor.v1beta.GetTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template>)
                  responseObserver);
          break;
        case METHODID_CREATE_TEMPLATE:
          serviceImpl.createTemplate(
              (com.google.cloud.modelarmor.v1beta.CreateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template>)
                  responseObserver);
          break;
        case METHODID_UPDATE_TEMPLATE:
          serviceImpl.updateTemplate(
              (com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.Template>)
                  responseObserver);
          break;
        case METHODID_DELETE_TEMPLATE:
          serviceImpl.deleteTemplate(
              (com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_FLOOR_SETTING:
          serviceImpl.getFloorSetting(
              (com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FLOOR_SETTING:
          serviceImpl.updateFloorSetting(
              (com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.modelarmor.v1beta.FloorSetting>)
                  responseObserver);
          break;
        case METHODID_SANITIZE_USER_PROMPT:
          serviceImpl.sanitizeUserPrompt(
              (com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>)
                  responseObserver);
          break;
        case METHODID_SANITIZE_MODEL_RESPONSE:
          serviceImpl.sanitizeModelResponse(
              (com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>)
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
            getListTemplatesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.ListTemplatesRequest,
                    com.google.cloud.modelarmor.v1beta.ListTemplatesResponse>(
                    service, METHODID_LIST_TEMPLATES)))
        .addMethod(
            getGetTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.GetTemplateRequest,
                    com.google.cloud.modelarmor.v1beta.Template>(service, METHODID_GET_TEMPLATE)))
        .addMethod(
            getCreateTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.CreateTemplateRequest,
                    com.google.cloud.modelarmor.v1beta.Template>(
                    service, METHODID_CREATE_TEMPLATE)))
        .addMethod(
            getUpdateTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.UpdateTemplateRequest,
                    com.google.cloud.modelarmor.v1beta.Template>(
                    service, METHODID_UPDATE_TEMPLATE)))
        .addMethod(
            getDeleteTemplateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.DeleteTemplateRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_TEMPLATE)))
        .addMethod(
            getGetFloorSettingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.GetFloorSettingRequest,
                    com.google.cloud.modelarmor.v1beta.FloorSetting>(
                    service, METHODID_GET_FLOOR_SETTING)))
        .addMethod(
            getUpdateFloorSettingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.UpdateFloorSettingRequest,
                    com.google.cloud.modelarmor.v1beta.FloorSetting>(
                    service, METHODID_UPDATE_FLOOR_SETTING)))
        .addMethod(
            getSanitizeUserPromptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.SanitizeUserPromptRequest,
                    com.google.cloud.modelarmor.v1beta.SanitizeUserPromptResponse>(
                    service, METHODID_SANITIZE_USER_PROMPT)))
        .addMethod(
            getSanitizeModelResponseMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.modelarmor.v1beta.SanitizeModelResponseRequest,
                    com.google.cloud.modelarmor.v1beta.SanitizeModelResponseResponse>(
                    service, METHODID_SANITIZE_MODEL_RESPONSE)))
        .build();
  }

  private abstract static class ModelArmorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ModelArmorBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.modelarmor.v1beta.V1mainProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ModelArmor");
    }
  }

  private static final class ModelArmorFileDescriptorSupplier
      extends ModelArmorBaseDescriptorSupplier {
    ModelArmorFileDescriptorSupplier() {}
  }

  private static final class ModelArmorMethodDescriptorSupplier
      extends ModelArmorBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ModelArmorMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ModelArmorGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ModelArmorFileDescriptorSupplier())
                      .addMethod(getListTemplatesMethod())
                      .addMethod(getGetTemplateMethod())
                      .addMethod(getCreateTemplateMethod())
                      .addMethod(getUpdateTemplateMethod())
                      .addMethod(getDeleteTemplateMethod())
                      .addMethod(getGetFloorSettingMethod())
                      .addMethod(getUpdateFloorSettingMethod())
                      .addMethod(getSanitizeUserPromptMethod())
                      .addMethod(getSanitizeModelResponseMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
