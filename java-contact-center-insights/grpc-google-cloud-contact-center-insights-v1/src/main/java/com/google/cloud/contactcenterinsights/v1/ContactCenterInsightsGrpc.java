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
package com.google.cloud.contactcenterinsights.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * An API that lets users analyze and explore their business conversation data.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/contactcenterinsights/v1/contact_center_insights.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ContactCenterInsightsGrpc {

  private ContactCenterInsightsGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.contactcenterinsights.v1.ContactCenterInsights";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getCreateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateConversation",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateConversationRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getCreateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateConversationRequest,
            com.google.cloud.contactcenterinsights.v1.Conversation>
        getCreateConversationMethod;
    if ((getCreateConversationMethod = ContactCenterInsightsGrpc.getCreateConversationMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateConversationMethod = ContactCenterInsightsGrpc.getCreateConversationMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateConversationMethod =
              getCreateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateConversationRequest,
                          com.google.cloud.contactcenterinsights.v1.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateConversation"))
                      .build();
        }
      }
    }
    return getCreateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UploadConversationRequest,
          com.google.longrunning.Operation>
      getUploadConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UploadConversation",
      requestType = com.google.cloud.contactcenterinsights.v1.UploadConversationRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UploadConversationRequest,
          com.google.longrunning.Operation>
      getUploadConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UploadConversationRequest,
            com.google.longrunning.Operation>
        getUploadConversationMethod;
    if ((getUploadConversationMethod = ContactCenterInsightsGrpc.getUploadConversationMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUploadConversationMethod = ContactCenterInsightsGrpc.getUploadConversationMethod)
            == null) {
          ContactCenterInsightsGrpc.getUploadConversationMethod =
              getUploadConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UploadConversationRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UploadConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UploadConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UploadConversation"))
                      .build();
        }
      }
    }
    return getUploadConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getUpdateConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConversation",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getUpdateConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest,
            com.google.cloud.contactcenterinsights.v1.Conversation>
        getUpdateConversationMethod;
    if ((getUpdateConversationMethod = ContactCenterInsightsGrpc.getUpdateConversationMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateConversationMethod = ContactCenterInsightsGrpc.getUpdateConversationMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateConversationMethod =
              getUpdateConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest,
                          com.google.cloud.contactcenterinsights.v1.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateConversation"))
                      .build();
        }
      }
    }
    return getUpdateConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getGetConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConversation",
      requestType = com.google.cloud.contactcenterinsights.v1.GetConversationRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Conversation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetConversationRequest,
          com.google.cloud.contactcenterinsights.v1.Conversation>
      getGetConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetConversationRequest,
            com.google.cloud.contactcenterinsights.v1.Conversation>
        getGetConversationMethod;
    if ((getGetConversationMethod = ContactCenterInsightsGrpc.getGetConversationMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetConversationMethod = ContactCenterInsightsGrpc.getGetConversationMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetConversationMethod =
              getGetConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetConversationRequest,
                          com.google.cloud.contactcenterinsights.v1.Conversation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Conversation
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetConversation"))
                      .build();
        }
      }
    }
    return getGetConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListConversationsRequest,
          com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
      getListConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConversations",
      requestType = com.google.cloud.contactcenterinsights.v1.ListConversationsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListConversationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListConversationsRequest,
          com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
      getListConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListConversationsRequest,
            com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
        getListConversationsMethod;
    if ((getListConversationsMethod = ContactCenterInsightsGrpc.getListConversationsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListConversationsMethod = ContactCenterInsightsGrpc.getListConversationsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListConversationsMethod =
              getListConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListConversationsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListConversationsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListConversations"))
                      .build();
        }
      }
    }
    return getListConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteConversation",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest,
          com.google.protobuf.Empty>
      getDeleteConversationMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest,
            com.google.protobuf.Empty>
        getDeleteConversationMethod;
    if ((getDeleteConversationMethod = ContactCenterInsightsGrpc.getDeleteConversationMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteConversationMethod = ContactCenterInsightsGrpc.getDeleteConversationMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteConversationMethod =
              getDeleteConversationMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteConversation"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteConversation"))
                      .build();
        }
      }
    }
    return getDeleteConversationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest,
          com.google.longrunning.Operation>
      getCreateAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnalysis",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest,
          com.google.longrunning.Operation>
      getCreateAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest,
            com.google.longrunning.Operation>
        getCreateAnalysisMethod;
    if ((getCreateAnalysisMethod = ContactCenterInsightsGrpc.getCreateAnalysisMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateAnalysisMethod = ContactCenterInsightsGrpc.getCreateAnalysisMethod) == null) {
          ContactCenterInsightsGrpc.getCreateAnalysisMethod =
              getCreateAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateAnalysis"))
                      .build();
        }
      }
    }
    return getCreateAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest,
          com.google.cloud.contactcenterinsights.v1.Analysis>
      getGetAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalysis",
      requestType = com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Analysis.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest,
          com.google.cloud.contactcenterinsights.v1.Analysis>
      getGetAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest,
            com.google.cloud.contactcenterinsights.v1.Analysis>
        getGetAnalysisMethod;
    if ((getGetAnalysisMethod = ContactCenterInsightsGrpc.getGetAnalysisMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetAnalysisMethod = ContactCenterInsightsGrpc.getGetAnalysisMethod) == null) {
          ContactCenterInsightsGrpc.getGetAnalysisMethod =
              getGetAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest,
                          com.google.cloud.contactcenterinsights.v1.Analysis>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Analysis
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetAnalysis"))
                      .build();
        }
      }
    }
    return getGetAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest,
          com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
      getListAnalysesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalyses",
      requestType = com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest,
          com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
      getListAnalysesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest,
            com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
        getListAnalysesMethod;
    if ((getListAnalysesMethod = ContactCenterInsightsGrpc.getListAnalysesMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListAnalysesMethod = ContactCenterInsightsGrpc.getListAnalysesMethod) == null) {
          ContactCenterInsightsGrpc.getListAnalysesMethod =
              getListAnalysesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest,
                          com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnalyses"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListAnalyses"))
                      .build();
        }
      }
    }
    return getListAnalysesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest,
          com.google.protobuf.Empty>
      getDeleteAnalysisMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnalysis",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest,
          com.google.protobuf.Empty>
      getDeleteAnalysisMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest,
            com.google.protobuf.Empty>
        getDeleteAnalysisMethod;
    if ((getDeleteAnalysisMethod = ContactCenterInsightsGrpc.getDeleteAnalysisMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteAnalysisMethod = ContactCenterInsightsGrpc.getDeleteAnalysisMethod) == null) {
          ContactCenterInsightsGrpc.getDeleteAnalysisMethod =
              getDeleteAnalysisMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnalysis"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteAnalysis"))
                      .build();
        }
      }
    }
    return getDeleteAnalysisMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest,
          com.google.longrunning.Operation>
      getBulkAnalyzeConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkAnalyzeConversations",
      requestType = com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest,
          com.google.longrunning.Operation>
      getBulkAnalyzeConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest,
            com.google.longrunning.Operation>
        getBulkAnalyzeConversationsMethod;
    if ((getBulkAnalyzeConversationsMethod =
            ContactCenterInsightsGrpc.getBulkAnalyzeConversationsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getBulkAnalyzeConversationsMethod =
                ContactCenterInsightsGrpc.getBulkAnalyzeConversationsMethod)
            == null) {
          ContactCenterInsightsGrpc.getBulkAnalyzeConversationsMethod =
              getBulkAnalyzeConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkAnalyzeConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .BulkAnalyzeConversationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "BulkAnalyzeConversations"))
                      .build();
        }
      }
    }
    return getBulkAnalyzeConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest,
          com.google.longrunning.Operation>
      getBulkDeleteConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkDeleteConversations",
      requestType = com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest,
          com.google.longrunning.Operation>
      getBulkDeleteConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest,
            com.google.longrunning.Operation>
        getBulkDeleteConversationsMethod;
    if ((getBulkDeleteConversationsMethod =
            ContactCenterInsightsGrpc.getBulkDeleteConversationsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getBulkDeleteConversationsMethod =
                ContactCenterInsightsGrpc.getBulkDeleteConversationsMethod)
            == null) {
          ContactCenterInsightsGrpc.getBulkDeleteConversationsMethod =
              getBulkDeleteConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkDeleteConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .BulkDeleteConversationsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "BulkDeleteConversations"))
                      .build();
        }
      }
    }
    return getBulkDeleteConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest,
          com.google.longrunning.Operation>
      getIngestConversationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "IngestConversations",
      requestType = com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest,
          com.google.longrunning.Operation>
      getIngestConversationsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest,
            com.google.longrunning.Operation>
        getIngestConversationsMethod;
    if ((getIngestConversationsMethod = ContactCenterInsightsGrpc.getIngestConversationsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getIngestConversationsMethod = ContactCenterInsightsGrpc.getIngestConversationsMethod)
            == null) {
          ContactCenterInsightsGrpc.getIngestConversationsMethod =
              getIngestConversationsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "IngestConversations"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("IngestConversations"))
                      .build();
        }
      }
    }
    return getIngestConversationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest,
          com.google.longrunning.Operation>
      getExportInsightsDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportInsightsData",
      requestType = com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest,
          com.google.longrunning.Operation>
      getExportInsightsDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest,
            com.google.longrunning.Operation>
        getExportInsightsDataMethod;
    if ((getExportInsightsDataMethod = ContactCenterInsightsGrpc.getExportInsightsDataMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getExportInsightsDataMethod = ContactCenterInsightsGrpc.getExportInsightsDataMethod)
            == null) {
          ContactCenterInsightsGrpc.getExportInsightsDataMethod =
              getExportInsightsDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportInsightsData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ExportInsightsData"))
                      .build();
        }
      }
    }
    return getExportInsightsDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest,
          com.google.longrunning.Operation>
      getCreateIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest,
          com.google.longrunning.Operation>
      getCreateIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest,
            com.google.longrunning.Operation>
        getCreateIssueModelMethod;
    if ((getCreateIssueModelMethod = ContactCenterInsightsGrpc.getCreateIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateIssueModelMethod = ContactCenterInsightsGrpc.getCreateIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateIssueModelMethod =
              getCreateIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateIssueModel"))
                      .build();
        }
      }
    }
    return getCreateIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest,
          com.google.cloud.contactcenterinsights.v1.IssueModel>
      getUpdateIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.IssueModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest,
          com.google.cloud.contactcenterinsights.v1.IssueModel>
      getUpdateIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest,
            com.google.cloud.contactcenterinsights.v1.IssueModel>
        getUpdateIssueModelMethod;
    if ((getUpdateIssueModelMethod = ContactCenterInsightsGrpc.getUpdateIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateIssueModelMethod = ContactCenterInsightsGrpc.getUpdateIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateIssueModelMethod =
              getUpdateIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest,
                          com.google.cloud.contactcenterinsights.v1.IssueModel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.IssueModel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateIssueModel"))
                      .build();
        }
      }
    }
    return getUpdateIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest,
          com.google.cloud.contactcenterinsights.v1.IssueModel>
      getGetIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.IssueModel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest,
          com.google.cloud.contactcenterinsights.v1.IssueModel>
      getGetIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest,
            com.google.cloud.contactcenterinsights.v1.IssueModel>
        getGetIssueModelMethod;
    if ((getGetIssueModelMethod = ContactCenterInsightsGrpc.getGetIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetIssueModelMethod = ContactCenterInsightsGrpc.getGetIssueModelMethod) == null) {
          ContactCenterInsightsGrpc.getGetIssueModelMethod =
              getGetIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest,
                          com.google.cloud.contactcenterinsights.v1.IssueModel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.IssueModel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetIssueModel"))
                      .build();
        }
      }
    }
    return getGetIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
      getListIssueModelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIssueModels",
      requestType = com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
      getListIssueModelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest,
            com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
        getListIssueModelsMethod;
    if ((getListIssueModelsMethod = ContactCenterInsightsGrpc.getListIssueModelsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListIssueModelsMethod = ContactCenterInsightsGrpc.getListIssueModelsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListIssueModelsMethod =
              getListIssueModelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIssueModels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListIssueModels"))
                      .build();
        }
      }
    }
    return getListIssueModelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest,
          com.google.longrunning.Operation>
      getDeleteIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest,
          com.google.longrunning.Operation>
      getDeleteIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest,
            com.google.longrunning.Operation>
        getDeleteIssueModelMethod;
    if ((getDeleteIssueModelMethod = ContactCenterInsightsGrpc.getDeleteIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteIssueModelMethod = ContactCenterInsightsGrpc.getDeleteIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteIssueModelMethod =
              getDeleteIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteIssueModel"))
                      .build();
        }
      }
    }
    return getDeleteIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest,
          com.google.longrunning.Operation>
      getDeployIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest,
          com.google.longrunning.Operation>
      getDeployIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest,
            com.google.longrunning.Operation>
        getDeployIssueModelMethod;
    if ((getDeployIssueModelMethod = ContactCenterInsightsGrpc.getDeployIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeployIssueModelMethod = ContactCenterInsightsGrpc.getDeployIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeployIssueModelMethod =
              getDeployIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeployIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeployIssueModel"))
                      .build();
        }
      }
    }
    return getDeployIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest,
          com.google.longrunning.Operation>
      getUndeployIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest,
          com.google.longrunning.Operation>
      getUndeployIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest,
            com.google.longrunning.Operation>
        getUndeployIssueModelMethod;
    if ((getUndeployIssueModelMethod = ContactCenterInsightsGrpc.getUndeployIssueModelMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUndeployIssueModelMethod = ContactCenterInsightsGrpc.getUndeployIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getUndeployIssueModelMethod =
              getUndeployIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UndeployIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UndeployIssueModel"))
                      .build();
        }
      }
    }
    return getUndeployIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest,
          com.google.longrunning.Operation>
      getExportIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest,
          com.google.longrunning.Operation>
      getExportIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest,
            com.google.longrunning.Operation>
        getExportIssueModelMethod;
    if ((getExportIssueModelMethod = ContactCenterInsightsGrpc.getExportIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getExportIssueModelMethod = ContactCenterInsightsGrpc.getExportIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getExportIssueModelMethod =
              getExportIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ExportIssueModel"))
                      .build();
        }
      }
    }
    return getExportIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest,
          com.google.longrunning.Operation>
      getImportIssueModelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportIssueModel",
      requestType = com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest,
          com.google.longrunning.Operation>
      getImportIssueModelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest,
            com.google.longrunning.Operation>
        getImportIssueModelMethod;
    if ((getImportIssueModelMethod = ContactCenterInsightsGrpc.getImportIssueModelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getImportIssueModelMethod = ContactCenterInsightsGrpc.getImportIssueModelMethod)
            == null) {
          ContactCenterInsightsGrpc.getImportIssueModelMethod =
              getImportIssueModelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportIssueModel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ImportIssueModel"))
                      .build();
        }
      }
    }
    return getImportIssueModelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetIssueRequest,
          com.google.cloud.contactcenterinsights.v1.Issue>
      getGetIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetIssue",
      requestType = com.google.cloud.contactcenterinsights.v1.GetIssueRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Issue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetIssueRequest,
          com.google.cloud.contactcenterinsights.v1.Issue>
      getGetIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetIssueRequest,
            com.google.cloud.contactcenterinsights.v1.Issue>
        getGetIssueMethod;
    if ((getGetIssueMethod = ContactCenterInsightsGrpc.getGetIssueMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetIssueMethod = ContactCenterInsightsGrpc.getGetIssueMethod) == null) {
          ContactCenterInsightsGrpc.getGetIssueMethod =
              getGetIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetIssueRequest,
                          com.google.cloud.contactcenterinsights.v1.Issue>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Issue.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetIssue"))
                      .build();
        }
      }
    }
    return getGetIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListIssuesRequest,
          com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
      getListIssuesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListIssues",
      requestType = com.google.cloud.contactcenterinsights.v1.ListIssuesRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListIssuesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListIssuesRequest,
          com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
      getListIssuesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListIssuesRequest,
            com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
        getListIssuesMethod;
    if ((getListIssuesMethod = ContactCenterInsightsGrpc.getListIssuesMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListIssuesMethod = ContactCenterInsightsGrpc.getListIssuesMethod) == null) {
          ContactCenterInsightsGrpc.getListIssuesMethod =
              getListIssuesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListIssuesRequest,
                          com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListIssues"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListIssuesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListIssuesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListIssues"))
                      .build();
        }
      }
    }
    return getListIssuesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest,
          com.google.cloud.contactcenterinsights.v1.Issue>
      getUpdateIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateIssue",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Issue.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest,
          com.google.cloud.contactcenterinsights.v1.Issue>
      getUpdateIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest,
            com.google.cloud.contactcenterinsights.v1.Issue>
        getUpdateIssueMethod;
    if ((getUpdateIssueMethod = ContactCenterInsightsGrpc.getUpdateIssueMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateIssueMethod = ContactCenterInsightsGrpc.getUpdateIssueMethod) == null) {
          ContactCenterInsightsGrpc.getUpdateIssueMethod =
              getUpdateIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest,
                          com.google.cloud.contactcenterinsights.v1.Issue>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Issue.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateIssue"))
                      .build();
        }
      }
    }
    return getUpdateIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest, com.google.protobuf.Empty>
      getDeleteIssueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteIssue",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest, com.google.protobuf.Empty>
      getDeleteIssueMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest, com.google.protobuf.Empty>
        getDeleteIssueMethod;
    if ((getDeleteIssueMethod = ContactCenterInsightsGrpc.getDeleteIssueMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteIssueMethod = ContactCenterInsightsGrpc.getDeleteIssueMethod) == null) {
          ContactCenterInsightsGrpc.getDeleteIssueMethod =
              getDeleteIssueMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteIssue"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteIssue"))
                      .build();
        }
      }
    }
    return getDeleteIssueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest,
          com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
      getCalculateIssueModelStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateIssueModelStats",
      requestType = com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest.class,
      responseType =
          com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest,
          com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
      getCalculateIssueModelStatsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest,
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
        getCalculateIssueModelStatsMethod;
    if ((getCalculateIssueModelStatsMethod =
            ContactCenterInsightsGrpc.getCalculateIssueModelStatsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCalculateIssueModelStatsMethod =
                ContactCenterInsightsGrpc.getCalculateIssueModelStatsMethod)
            == null) {
          ContactCenterInsightsGrpc.getCalculateIssueModelStatsMethod =
              getCalculateIssueModelStatsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest,
                          com.google.cloud.contactcenterinsights.v1
                              .CalculateIssueModelStatsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CalculateIssueModelStats"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .CalculateIssueModelStatsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .CalculateIssueModelStatsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "CalculateIssueModelStats"))
                      .build();
        }
      }
    }
    return getCalculateIssueModelStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getCreatePhraseMatcherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePhraseMatcher",
      requestType = com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.PhraseMatcher.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getCreatePhraseMatcherMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest,
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        getCreatePhraseMatcherMethod;
    if ((getCreatePhraseMatcherMethod = ContactCenterInsightsGrpc.getCreatePhraseMatcherMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreatePhraseMatcherMethod = ContactCenterInsightsGrpc.getCreatePhraseMatcherMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreatePhraseMatcherMethod =
              getCreatePhraseMatcherMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest,
                          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreatePhraseMatcher"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.PhraseMatcher
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreatePhraseMatcher"))
                      .build();
        }
      }
    }
    return getCreatePhraseMatcherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getGetPhraseMatcherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPhraseMatcher",
      requestType = com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.PhraseMatcher.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getGetPhraseMatcherMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest,
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        getGetPhraseMatcherMethod;
    if ((getGetPhraseMatcherMethod = ContactCenterInsightsGrpc.getGetPhraseMatcherMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetPhraseMatcherMethod = ContactCenterInsightsGrpc.getGetPhraseMatcherMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetPhraseMatcherMethod =
              getGetPhraseMatcherMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest,
                          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPhraseMatcher"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.PhraseMatcher
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetPhraseMatcher"))
                      .build();
        }
      }
    }
    return getGetPhraseMatcherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest,
          com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
      getListPhraseMatchersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPhraseMatchers",
      requestType = com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest,
          com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
      getListPhraseMatchersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest,
            com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
        getListPhraseMatchersMethod;
    if ((getListPhraseMatchersMethod = ContactCenterInsightsGrpc.getListPhraseMatchersMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListPhraseMatchersMethod = ContactCenterInsightsGrpc.getListPhraseMatchersMethod)
            == null) {
          ContactCenterInsightsGrpc.getListPhraseMatchersMethod =
              getListPhraseMatchersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest,
                          com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPhraseMatchers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListPhraseMatchers"))
                      .build();
        }
      }
    }
    return getListPhraseMatchersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest,
          com.google.protobuf.Empty>
      getDeletePhraseMatcherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeletePhraseMatcher",
      requestType = com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest,
          com.google.protobuf.Empty>
      getDeletePhraseMatcherMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest,
            com.google.protobuf.Empty>
        getDeletePhraseMatcherMethod;
    if ((getDeletePhraseMatcherMethod = ContactCenterInsightsGrpc.getDeletePhraseMatcherMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeletePhraseMatcherMethod = ContactCenterInsightsGrpc.getDeletePhraseMatcherMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeletePhraseMatcherMethod =
              getDeletePhraseMatcherMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeletePhraseMatcher"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeletePhraseMatcher"))
                      .build();
        }
      }
    }
    return getDeletePhraseMatcherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getUpdatePhraseMatcherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePhraseMatcher",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.PhraseMatcher.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest,
          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
      getUpdatePhraseMatcherMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest,
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        getUpdatePhraseMatcherMethod;
    if ((getUpdatePhraseMatcherMethod = ContactCenterInsightsGrpc.getUpdatePhraseMatcherMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdatePhraseMatcherMethod = ContactCenterInsightsGrpc.getUpdatePhraseMatcherMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdatePhraseMatcherMethod =
              getUpdatePhraseMatcherMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest,
                          com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdatePhraseMatcher"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.PhraseMatcher
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdatePhraseMatcher"))
                      .build();
        }
      }
    }
    return getUpdatePhraseMatcherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest,
          com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
      getCalculateStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CalculateStats",
      requestType = com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest,
          com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
      getCalculateStatsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest,
            com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
        getCalculateStatsMethod;
    if ((getCalculateStatsMethod = ContactCenterInsightsGrpc.getCalculateStatsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCalculateStatsMethod = ContactCenterInsightsGrpc.getCalculateStatsMethod) == null) {
          ContactCenterInsightsGrpc.getCalculateStatsMethod =
              getCalculateStatsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest,
                          com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CalculateStats"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CalculateStats"))
                      .build();
        }
      }
    }
    return getCalculateStatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetSettingsRequest,
          com.google.cloud.contactcenterinsights.v1.Settings>
      getGetSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSettings",
      requestType = com.google.cloud.contactcenterinsights.v1.GetSettingsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetSettingsRequest,
          com.google.cloud.contactcenterinsights.v1.Settings>
      getGetSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetSettingsRequest,
            com.google.cloud.contactcenterinsights.v1.Settings>
        getGetSettingsMethod;
    if ((getGetSettingsMethod = ContactCenterInsightsGrpc.getGetSettingsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetSettingsMethod = ContactCenterInsightsGrpc.getGetSettingsMethod) == null) {
          ContactCenterInsightsGrpc.getGetSettingsMethod =
              getGetSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetSettingsRequest,
                          com.google.cloud.contactcenterinsights.v1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetSettings"))
                      .build();
        }
      }
    }
    return getGetSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest,
          com.google.cloud.contactcenterinsights.v1.Settings>
      getUpdateSettingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateSettings",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.Settings.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest,
          com.google.cloud.contactcenterinsights.v1.Settings>
      getUpdateSettingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest,
            com.google.cloud.contactcenterinsights.v1.Settings>
        getUpdateSettingsMethod;
    if ((getUpdateSettingsMethod = ContactCenterInsightsGrpc.getUpdateSettingsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateSettingsMethod = ContactCenterInsightsGrpc.getUpdateSettingsMethod) == null) {
          ContactCenterInsightsGrpc.getUpdateSettingsMethod =
              getUpdateSettingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest,
                          com.google.cloud.contactcenterinsights.v1.Settings>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateSettings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.Settings
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateSettings"))
                      .build();
        }
      }
    }
    return getUpdateSettingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getCreateAnalysisRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAnalysisRule",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.AnalysisRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getCreateAnalysisRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest,
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        getCreateAnalysisRuleMethod;
    if ((getCreateAnalysisRuleMethod = ContactCenterInsightsGrpc.getCreateAnalysisRuleMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateAnalysisRuleMethod = ContactCenterInsightsGrpc.getCreateAnalysisRuleMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateAnalysisRuleMethod =
              getCreateAnalysisRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest,
                          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAnalysisRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.AnalysisRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateAnalysisRule"))
                      .build();
        }
      }
    }
    return getCreateAnalysisRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getGetAnalysisRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAnalysisRule",
      requestType = com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.AnalysisRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getGetAnalysisRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest,
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        getGetAnalysisRuleMethod;
    if ((getGetAnalysisRuleMethod = ContactCenterInsightsGrpc.getGetAnalysisRuleMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetAnalysisRuleMethod = ContactCenterInsightsGrpc.getGetAnalysisRuleMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetAnalysisRuleMethod =
              getGetAnalysisRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest,
                          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAnalysisRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.AnalysisRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetAnalysisRule"))
                      .build();
        }
      }
    }
    return getGetAnalysisRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest,
          com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
      getListAnalysisRulesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAnalysisRules",
      requestType = com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest,
          com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
      getListAnalysisRulesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest,
            com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
        getListAnalysisRulesMethod;
    if ((getListAnalysisRulesMethod = ContactCenterInsightsGrpc.getListAnalysisRulesMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListAnalysisRulesMethod = ContactCenterInsightsGrpc.getListAnalysisRulesMethod)
            == null) {
          ContactCenterInsightsGrpc.getListAnalysisRulesMethod =
              getListAnalysisRulesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest,
                          com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListAnalysisRules"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListAnalysisRules"))
                      .build();
        }
      }
    }
    return getListAnalysisRulesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getUpdateAnalysisRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateAnalysisRule",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.AnalysisRule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest,
          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
      getUpdateAnalysisRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest,
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        getUpdateAnalysisRuleMethod;
    if ((getUpdateAnalysisRuleMethod = ContactCenterInsightsGrpc.getUpdateAnalysisRuleMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateAnalysisRuleMethod = ContactCenterInsightsGrpc.getUpdateAnalysisRuleMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateAnalysisRuleMethod =
              getUpdateAnalysisRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest,
                          com.google.cloud.contactcenterinsights.v1.AnalysisRule>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateAnalysisRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.AnalysisRule
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateAnalysisRule"))
                      .build();
        }
      }
    }
    return getUpdateAnalysisRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest,
          com.google.protobuf.Empty>
      getDeleteAnalysisRuleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteAnalysisRule",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest,
          com.google.protobuf.Empty>
      getDeleteAnalysisRuleMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest,
            com.google.protobuf.Empty>
        getDeleteAnalysisRuleMethod;
    if ((getDeleteAnalysisRuleMethod = ContactCenterInsightsGrpc.getDeleteAnalysisRuleMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteAnalysisRuleMethod = ContactCenterInsightsGrpc.getDeleteAnalysisRuleMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteAnalysisRuleMethod =
              getDeleteAnalysisRuleMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAnalysisRule"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteAnalysisRule"))
                      .build();
        }
      }
    }
    return getDeleteAnalysisRuleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest,
          com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
      getGetEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEncryptionSpec",
      requestType = com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.EncryptionSpec.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest,
          com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
      getGetEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest,
            com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
        getGetEncryptionSpecMethod;
    if ((getGetEncryptionSpecMethod = ContactCenterInsightsGrpc.getGetEncryptionSpecMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetEncryptionSpecMethod = ContactCenterInsightsGrpc.getGetEncryptionSpecMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetEncryptionSpecMethod =
              getGetEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest,
                          com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.EncryptionSpec
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetEncryptionSpec"))
                      .build();
        }
      }
    }
    return getGetEncryptionSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getInitializeEncryptionSpecMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InitializeEncryptionSpec",
      requestType = com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest,
          com.google.longrunning.Operation>
      getInitializeEncryptionSpecMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest,
            com.google.longrunning.Operation>
        getInitializeEncryptionSpecMethod;
    if ((getInitializeEncryptionSpecMethod =
            ContactCenterInsightsGrpc.getInitializeEncryptionSpecMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getInitializeEncryptionSpecMethod =
                ContactCenterInsightsGrpc.getInitializeEncryptionSpecMethod)
            == null) {
          ContactCenterInsightsGrpc.getInitializeEncryptionSpecMethod =
              getInitializeEncryptionSpecMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "InitializeEncryptionSpec"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .InitializeEncryptionSpecRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "InitializeEncryptionSpec"))
                      .build();
        }
      }
    }
    return getInitializeEncryptionSpecMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getCreateViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateView",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateViewRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.View.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getCreateViewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateViewRequest,
            com.google.cloud.contactcenterinsights.v1.View>
        getCreateViewMethod;
    if ((getCreateViewMethod = ContactCenterInsightsGrpc.getCreateViewMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateViewMethod = ContactCenterInsightsGrpc.getCreateViewMethod) == null) {
          ContactCenterInsightsGrpc.getCreateViewMethod =
              getCreateViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateViewRequest,
                          com.google.cloud.contactcenterinsights.v1.View>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateViewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.View.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateView"))
                      .build();
        }
      }
    }
    return getCreateViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getGetViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetView",
      requestType = com.google.cloud.contactcenterinsights.v1.GetViewRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.View.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getGetViewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetViewRequest,
            com.google.cloud.contactcenterinsights.v1.View>
        getGetViewMethod;
    if ((getGetViewMethod = ContactCenterInsightsGrpc.getGetViewMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetViewMethod = ContactCenterInsightsGrpc.getGetViewMethod) == null) {
          ContactCenterInsightsGrpc.getGetViewMethod =
              getGetViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetViewRequest,
                          com.google.cloud.contactcenterinsights.v1.View>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetViewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.View.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetView"))
                      .build();
        }
      }
    }
    return getGetViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListViewsRequest,
          com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
      getListViewsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListViews",
      requestType = com.google.cloud.contactcenterinsights.v1.ListViewsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListViewsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListViewsRequest,
          com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
      getListViewsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListViewsRequest,
            com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
        getListViewsMethod;
    if ((getListViewsMethod = ContactCenterInsightsGrpc.getListViewsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListViewsMethod = ContactCenterInsightsGrpc.getListViewsMethod) == null) {
          ContactCenterInsightsGrpc.getListViewsMethod =
              getListViewsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListViewsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListViews"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListViewsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListViewsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListViews"))
                      .build();
        }
      }
    }
    return getListViewsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getUpdateViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateView",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateViewRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.View.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateViewRequest,
          com.google.cloud.contactcenterinsights.v1.View>
      getUpdateViewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateViewRequest,
            com.google.cloud.contactcenterinsights.v1.View>
        getUpdateViewMethod;
    if ((getUpdateViewMethod = ContactCenterInsightsGrpc.getUpdateViewMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateViewMethod = ContactCenterInsightsGrpc.getUpdateViewMethod) == null) {
          ContactCenterInsightsGrpc.getUpdateViewMethod =
              getUpdateViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateViewRequest,
                          com.google.cloud.contactcenterinsights.v1.View>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateViewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.View.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateView"))
                      .build();
        }
      }
    }
    return getUpdateViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteViewRequest, com.google.protobuf.Empty>
      getDeleteViewMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteView",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteViewRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteViewRequest, com.google.protobuf.Empty>
      getDeleteViewMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteViewRequest, com.google.protobuf.Empty>
        getDeleteViewMethod;
    if ((getDeleteViewMethod = ContactCenterInsightsGrpc.getDeleteViewMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteViewMethod = ContactCenterInsightsGrpc.getDeleteViewMethod) == null) {
          ContactCenterInsightsGrpc.getDeleteViewMethod =
              getDeleteViewMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteViewRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteView"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteViewRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteView"))
                      .build();
        }
      }
    }
    return getDeleteViewMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest,
          com.google.longrunning.Operation>
      getQueryMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "QueryMetrics",
      requestType = com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest,
          com.google.longrunning.Operation>
      getQueryMetricsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest,
            com.google.longrunning.Operation>
        getQueryMetricsMethod;
    if ((getQueryMetricsMethod = ContactCenterInsightsGrpc.getQueryMetricsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getQueryMetricsMethod = ContactCenterInsightsGrpc.getQueryMetricsMethod) == null) {
          ContactCenterInsightsGrpc.getQueryMetricsMethod =
              getQueryMetricsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "QueryMetrics"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("QueryMetrics"))
                      .build();
        }
      }
    }
    return getQueryMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getCreateQaQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQaQuestion",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaQuestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getCreateQaQuestionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest,
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        getCreateQaQuestionMethod;
    if ((getCreateQaQuestionMethod = ContactCenterInsightsGrpc.getCreateQaQuestionMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateQaQuestionMethod = ContactCenterInsightsGrpc.getCreateQaQuestionMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateQaQuestionMethod =
              getCreateQaQuestionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaQuestion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateQaQuestion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaQuestion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateQaQuestion"))
                      .build();
        }
      }
    }
    return getCreateQaQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getGetQaQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQaQuestion",
      requestType = com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaQuestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getGetQaQuestionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest,
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        getGetQaQuestionMethod;
    if ((getGetQaQuestionMethod = ContactCenterInsightsGrpc.getGetQaQuestionMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetQaQuestionMethod = ContactCenterInsightsGrpc.getGetQaQuestionMethod) == null) {
          ContactCenterInsightsGrpc.getGetQaQuestionMethod =
              getGetQaQuestionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaQuestion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQaQuestion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaQuestion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetQaQuestion"))
                      .build();
        }
      }
    }
    return getGetQaQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getUpdateQaQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQaQuestion",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaQuestion.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest,
          com.google.cloud.contactcenterinsights.v1.QaQuestion>
      getUpdateQaQuestionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest,
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        getUpdateQaQuestionMethod;
    if ((getUpdateQaQuestionMethod = ContactCenterInsightsGrpc.getUpdateQaQuestionMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateQaQuestionMethod = ContactCenterInsightsGrpc.getUpdateQaQuestionMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateQaQuestionMethod =
              getUpdateQaQuestionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaQuestion>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateQaQuestion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaQuestion
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateQaQuestion"))
                      .build();
        }
      }
    }
    return getUpdateQaQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest,
          com.google.protobuf.Empty>
      getDeleteQaQuestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteQaQuestion",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest,
          com.google.protobuf.Empty>
      getDeleteQaQuestionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest,
            com.google.protobuf.Empty>
        getDeleteQaQuestionMethod;
    if ((getDeleteQaQuestionMethod = ContactCenterInsightsGrpc.getDeleteQaQuestionMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteQaQuestionMethod = ContactCenterInsightsGrpc.getDeleteQaQuestionMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteQaQuestionMethod =
              getDeleteQaQuestionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteQaQuestion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteQaQuestion"))
                      .build();
        }
      }
    }
    return getDeleteQaQuestionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
      getListQaQuestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQaQuestions",
      requestType = com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
      getListQaQuestionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest,
            com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
        getListQaQuestionsMethod;
    if ((getListQaQuestionsMethod = ContactCenterInsightsGrpc.getListQaQuestionsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListQaQuestionsMethod = ContactCenterInsightsGrpc.getListQaQuestionsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListQaQuestionsMethod =
              getListQaQuestionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListQaQuestions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListQaQuestions"))
                      .build();
        }
      }
    }
    return getListQaQuestionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getCreateQaScorecardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQaScorecard",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getCreateQaScorecardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        getCreateQaScorecardMethod;
    if ((getCreateQaScorecardMethod = ContactCenterInsightsGrpc.getCreateQaScorecardMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateQaScorecardMethod = ContactCenterInsightsGrpc.getCreateQaScorecardMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateQaScorecardMethod =
              getCreateQaScorecardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateQaScorecard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecard
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateQaScorecard"))
                      .build();
        }
      }
    }
    return getCreateQaScorecardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getGetQaScorecardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQaScorecard",
      requestType = com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getGetQaScorecardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        getGetQaScorecardMethod;
    if ((getGetQaScorecardMethod = ContactCenterInsightsGrpc.getGetQaScorecardMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetQaScorecardMethod = ContactCenterInsightsGrpc.getGetQaScorecardMethod) == null) {
          ContactCenterInsightsGrpc.getGetQaScorecardMethod =
              getGetQaScorecardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQaScorecard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecard
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetQaScorecard"))
                      .build();
        }
      }
    }
    return getGetQaScorecardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getUpdateQaScorecardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateQaScorecard",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecard>
      getUpdateQaScorecardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        getUpdateQaScorecardMethod;
    if ((getUpdateQaScorecardMethod = ContactCenterInsightsGrpc.getUpdateQaScorecardMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateQaScorecardMethod = ContactCenterInsightsGrpc.getUpdateQaScorecardMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateQaScorecardMethod =
              getUpdateQaScorecardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateQaScorecard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecard
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateQaScorecard"))
                      .build();
        }
      }
    }
    return getUpdateQaScorecardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest,
          com.google.protobuf.Empty>
      getDeleteQaScorecardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteQaScorecard",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest,
          com.google.protobuf.Empty>
      getDeleteQaScorecardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest,
            com.google.protobuf.Empty>
        getDeleteQaScorecardMethod;
    if ((getDeleteQaScorecardMethod = ContactCenterInsightsGrpc.getDeleteQaScorecardMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteQaScorecardMethod = ContactCenterInsightsGrpc.getDeleteQaScorecardMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteQaScorecardMethod =
              getDeleteQaScorecardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteQaScorecard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteQaScorecard"))
                      .build();
        }
      }
    }
    return getDeleteQaScorecardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
      getListQaScorecardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQaScorecards",
      requestType = com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
      getListQaScorecardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest,
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
        getListQaScorecardsMethod;
    if ((getListQaScorecardsMethod = ContactCenterInsightsGrpc.getListQaScorecardsMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListQaScorecardsMethod = ContactCenterInsightsGrpc.getListQaScorecardsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListQaScorecardsMethod =
              getListQaScorecardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListQaScorecards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListQaScorecards"))
                      .build();
        }
      }
    }
    return getListQaScorecardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getCreateQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateQaScorecardRevision",
      requestType =
          com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecardRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getCreateQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        getCreateQaScorecardRevisionMethod;
    if ((getCreateQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getCreateQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getCreateQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateQaScorecardRevisionMethod =
              getCreateQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .CreateQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "CreateQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getCreateQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getGetQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQaScorecardRevision",
      requestType = com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecardRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getGetQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        getGetQaScorecardRevisionMethod;
    if ((getGetQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getGetQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getGetQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetQaScorecardRevisionMethod =
              getGetQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .GetQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "GetQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getGetQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest,
          com.google.longrunning.Operation>
      getTuneQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TuneQaScorecardRevision",
      requestType = com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest,
          com.google.longrunning.Operation>
      getTuneQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest,
            com.google.longrunning.Operation>
        getTuneQaScorecardRevisionMethod;
    if ((getTuneQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getTuneQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getTuneQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getTuneQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getTuneQaScorecardRevisionMethod =
              getTuneQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "TuneQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .TuneQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "TuneQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getTuneQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getDeployQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeployQaScorecardRevision",
      requestType =
          com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecardRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getDeployQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        getDeployQaScorecardRevisionMethod;
    if ((getDeployQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getDeployQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeployQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getDeployQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeployQaScorecardRevisionMethod =
              getDeployQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeployQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .DeployQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "DeployQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getDeployQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getUndeployQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UndeployQaScorecardRevision",
      requestType =
          com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.QaScorecardRevision.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest,
          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
      getUndeployQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest,
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        getUndeployQaScorecardRevisionMethod;
    if ((getUndeployQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getUndeployQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUndeployQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getUndeployQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getUndeployQaScorecardRevisionMethod =
              getUndeployQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1
                              .UndeployQaScorecardRevisionRequest,
                          com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UndeployQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .UndeployQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "UndeployQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getUndeployQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest,
          com.google.protobuf.Empty>
      getDeleteQaScorecardRevisionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteQaScorecardRevision",
      requestType =
          com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest,
          com.google.protobuf.Empty>
      getDeleteQaScorecardRevisionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest,
            com.google.protobuf.Empty>
        getDeleteQaScorecardRevisionMethod;
    if ((getDeleteQaScorecardRevisionMethod =
            ContactCenterInsightsGrpc.getDeleteQaScorecardRevisionMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteQaScorecardRevisionMethod =
                ContactCenterInsightsGrpc.getDeleteQaScorecardRevisionMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteQaScorecardRevisionMethod =
              getDeleteQaScorecardRevisionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteQaScorecardRevision"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .DeleteQaScorecardRevisionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "DeleteQaScorecardRevision"))
                      .build();
        }
      }
    }
    return getDeleteQaScorecardRevisionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
      getListQaScorecardRevisionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListQaScorecardRevisions",
      requestType = com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest.class,
      responseType =
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest,
          com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
      getListQaScorecardRevisionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest,
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
        getListQaScorecardRevisionsMethod;
    if ((getListQaScorecardRevisionsMethod =
            ContactCenterInsightsGrpc.getListQaScorecardRevisionsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListQaScorecardRevisionsMethod =
                ContactCenterInsightsGrpc.getListQaScorecardRevisionsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListQaScorecardRevisionsMethod =
              getListQaScorecardRevisionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest,
                          com.google.cloud.contactcenterinsights.v1
                              .ListQaScorecardRevisionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListQaScorecardRevisions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .ListQaScorecardRevisionsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .ListQaScorecardRevisionsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "ListQaScorecardRevisions"))
                      .build();
        }
      }
    }
    return getListQaScorecardRevisionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getCreateFeedbackLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateFeedbackLabel",
      requestType = com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.FeedbackLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getCreateFeedbackLabelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest,
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        getCreateFeedbackLabelMethod;
    if ((getCreateFeedbackLabelMethod = ContactCenterInsightsGrpc.getCreateFeedbackLabelMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getCreateFeedbackLabelMethod = ContactCenterInsightsGrpc.getCreateFeedbackLabelMethod)
            == null) {
          ContactCenterInsightsGrpc.getCreateFeedbackLabelMethod =
              getCreateFeedbackLabelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest,
                          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateFeedbackLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.FeedbackLabel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("CreateFeedbackLabel"))
                      .build();
        }
      }
    }
    return getCreateFeedbackLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
      getListFeedbackLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeedbackLabels",
      requestType = com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
      getListFeedbackLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest,
            com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
        getListFeedbackLabelsMethod;
    if ((getListFeedbackLabelsMethod = ContactCenterInsightsGrpc.getListFeedbackLabelsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListFeedbackLabelsMethod = ContactCenterInsightsGrpc.getListFeedbackLabelsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListFeedbackLabelsMethod =
              getListFeedbackLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListFeedbackLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("ListFeedbackLabels"))
                      .build();
        }
      }
    }
    return getListFeedbackLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getGetFeedbackLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeedbackLabel",
      requestType = com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.FeedbackLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getGetFeedbackLabelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest,
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        getGetFeedbackLabelMethod;
    if ((getGetFeedbackLabelMethod = ContactCenterInsightsGrpc.getGetFeedbackLabelMethod) == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getGetFeedbackLabelMethod = ContactCenterInsightsGrpc.getGetFeedbackLabelMethod)
            == null) {
          ContactCenterInsightsGrpc.getGetFeedbackLabelMethod =
              getGetFeedbackLabelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest,
                          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetFeedbackLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.FeedbackLabel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("GetFeedbackLabel"))
                      .build();
        }
      }
    }
    return getGetFeedbackLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getUpdateFeedbackLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateFeedbackLabel",
      requestType = com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.FeedbackLabel.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest,
          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
      getUpdateFeedbackLabelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest,
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        getUpdateFeedbackLabelMethod;
    if ((getUpdateFeedbackLabelMethod = ContactCenterInsightsGrpc.getUpdateFeedbackLabelMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getUpdateFeedbackLabelMethod = ContactCenterInsightsGrpc.getUpdateFeedbackLabelMethod)
            == null) {
          ContactCenterInsightsGrpc.getUpdateFeedbackLabelMethod =
              getUpdateFeedbackLabelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest,
                          com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateFeedbackLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.FeedbackLabel
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("UpdateFeedbackLabel"))
                      .build();
        }
      }
    }
    return getUpdateFeedbackLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest,
          com.google.protobuf.Empty>
      getDeleteFeedbackLabelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteFeedbackLabel",
      requestType = com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest,
          com.google.protobuf.Empty>
      getDeleteFeedbackLabelMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest,
            com.google.protobuf.Empty>
        getDeleteFeedbackLabelMethod;
    if ((getDeleteFeedbackLabelMethod = ContactCenterInsightsGrpc.getDeleteFeedbackLabelMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getDeleteFeedbackLabelMethod = ContactCenterInsightsGrpc.getDeleteFeedbackLabelMethod)
            == null) {
          ContactCenterInsightsGrpc.getDeleteFeedbackLabelMethod =
              getDeleteFeedbackLabelMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteFeedbackLabel"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier("DeleteFeedbackLabel"))
                      .build();
        }
      }
    }
    return getDeleteFeedbackLabelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
      getListAllFeedbackLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAllFeedbackLabels",
      requestType = com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest.class,
      responseType = com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest,
          com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
      getListAllFeedbackLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest,
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
        getListAllFeedbackLabelsMethod;
    if ((getListAllFeedbackLabelsMethod = ContactCenterInsightsGrpc.getListAllFeedbackLabelsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getListAllFeedbackLabelsMethod =
                ContactCenterInsightsGrpc.getListAllFeedbackLabelsMethod)
            == null) {
          ContactCenterInsightsGrpc.getListAllFeedbackLabelsMethod =
              getListAllFeedbackLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest,
                          com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAllFeedbackLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .ListAllFeedbackLabelsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "ListAllFeedbackLabels"))
                      .build();
        }
      }
    }
    return getListAllFeedbackLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest,
          com.google.longrunning.Operation>
      getBulkUploadFeedbackLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkUploadFeedbackLabels",
      requestType = com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest,
          com.google.longrunning.Operation>
      getBulkUploadFeedbackLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest,
            com.google.longrunning.Operation>
        getBulkUploadFeedbackLabelsMethod;
    if ((getBulkUploadFeedbackLabelsMethod =
            ContactCenterInsightsGrpc.getBulkUploadFeedbackLabelsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getBulkUploadFeedbackLabelsMethod =
                ContactCenterInsightsGrpc.getBulkUploadFeedbackLabelsMethod)
            == null) {
          ContactCenterInsightsGrpc.getBulkUploadFeedbackLabelsMethod =
              getBulkUploadFeedbackLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkUploadFeedbackLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .BulkUploadFeedbackLabelsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "BulkUploadFeedbackLabels"))
                      .build();
        }
      }
    }
    return getBulkUploadFeedbackLabelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest,
          com.google.longrunning.Operation>
      getBulkDownloadFeedbackLabelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BulkDownloadFeedbackLabels",
      requestType =
          com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest,
          com.google.longrunning.Operation>
      getBulkDownloadFeedbackLabelsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest,
            com.google.longrunning.Operation>
        getBulkDownloadFeedbackLabelsMethod;
    if ((getBulkDownloadFeedbackLabelsMethod =
            ContactCenterInsightsGrpc.getBulkDownloadFeedbackLabelsMethod)
        == null) {
      synchronized (ContactCenterInsightsGrpc.class) {
        if ((getBulkDownloadFeedbackLabelsMethod =
                ContactCenterInsightsGrpc.getBulkDownloadFeedbackLabelsMethod)
            == null) {
          ContactCenterInsightsGrpc.getBulkDownloadFeedbackLabelsMethod =
              getBulkDownloadFeedbackLabelsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "BulkDownloadFeedbackLabels"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.contactcenterinsights.v1
                                  .BulkDownloadFeedbackLabelsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ContactCenterInsightsMethodDescriptorSupplier(
                              "BulkDownloadFeedbackLabels"))
                      .build();
        }
      }
    }
    return getBulkDownloadFeedbackLabelsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ContactCenterInsightsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsStub>() {
          @java.lang.Override
          public ContactCenterInsightsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContactCenterInsightsStub(channel, callOptions);
          }
        };
    return ContactCenterInsightsStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ContactCenterInsightsBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsBlockingV2Stub>() {
          @java.lang.Override
          public ContactCenterInsightsBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContactCenterInsightsBlockingV2Stub(channel, callOptions);
          }
        };
    return ContactCenterInsightsBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ContactCenterInsightsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsBlockingStub>() {
          @java.lang.Override
          public ContactCenterInsightsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContactCenterInsightsBlockingStub(channel, callOptions);
          }
        };
    return ContactCenterInsightsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ContactCenterInsightsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ContactCenterInsightsFutureStub>() {
          @java.lang.Override
          public ContactCenterInsightsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ContactCenterInsightsFutureStub(channel, callOptions);
          }
        };
    return ContactCenterInsightsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a conversation.
     * Note that this method does not support audio transcription or redaction.
     * Use `conversations.upload` instead.
     * </pre>
     */
    default void createConversation(
        com.google.cloud.contactcenterinsights.v1.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a long-running conversation upload operation. This method differs
     * from `CreateConversation` by allowing audio transcription and optional DLP
     * redaction.
     * </pre>
     */
    default void uploadConversation(
        com.google.cloud.contactcenterinsights.v1.UploadConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUploadConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a conversation.
     * </pre>
     */
    default void updateConversation(
        com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a conversation.
     * </pre>
     */
    default void getConversation(
        com.google.cloud.contactcenterinsights.v1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations.
     * </pre>
     */
    default void listConversations(
        com.google.cloud.contactcenterinsights.v1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversation.
     * </pre>
     */
    default void deleteConversation(
        com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteConversationMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an analysis. The long running operation is done when the analysis
     * has completed.
     * </pre>
     */
    default void createAnalysis(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an analysis.
     * </pre>
     */
    default void getAnalysis(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Analysis>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists analyses.
     * </pre>
     */
    default void listAnalyses(
        com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalysesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an analysis.
     * </pre>
     */
    default void deleteAnalysis(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnalysisMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes multiple conversations in a single request.
     * </pre>
     */
    default void bulkAnalyzeConversations(
        com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkAnalyzeConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple conversations in a single request.
     * </pre>
     */
    default void bulkDeleteConversations(
        com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkDeleteConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports conversations and processes them according to the user's
     * configuration.
     * </pre>
     */
    default void ingestConversations(
        com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getIngestConversationsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export insights data to a destination defined in the request body.
     * </pre>
     */
    default void exportInsightsData(
        com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportInsightsDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue model.
     * </pre>
     */
    default void createIssueModel(
        com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue model.
     * </pre>
     */
    default void updateIssueModel(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model.
     * </pre>
     */
    default void getIssueModel(
        com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issue models.
     * </pre>
     */
    default void listIssueModels(
        com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListIssueModelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue model.
     * </pre>
     */
    default void deleteIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an issue model. Returns an error if a model is already deployed.
     * An issue model can only be used in analysis after it has been deployed.
     * </pre>
     */
    default void deployIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an issue model.
     * An issue model can not be used in analysis after it has been undeployed.
     * </pre>
     */
    default void undeployIssueModel(
        com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports an issue model to the provided destination.
     * </pre>
     */
    default void exportIssueModel(
        com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getExportIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an issue model from a Cloud Storage bucket.
     * </pre>
     */
    default void importIssueModel(
        com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getImportIssueModelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    default void getIssue(
        com.google.cloud.contactcenterinsights.v1.GetIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issues.
     * </pre>
     */
    default void listIssues(
        com.google.cloud.contactcenterinsights.v1.ListIssuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListIssuesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue.
     * </pre>
     */
    default void updateIssue(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    default void deleteIssue(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteIssueMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model's statistics.
     * </pre>
     */
    default void calculateIssueModelStats(
        com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateIssueModelStatsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a phrase matcher.
     * </pre>
     */
    default void createPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreatePhraseMatcherMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a phrase matcher.
     * </pre>
     */
    default void getPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetPhraseMatcherMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists phrase matchers.
     * </pre>
     */
    default void listPhraseMatchers(
        com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListPhraseMatchersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a phrase matcher.
     * </pre>
     */
    default void deletePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeletePhraseMatcherMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a phrase matcher.
     * </pre>
     */
    default void updatePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdatePhraseMatcherMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets conversation statistics.
     * </pre>
     */
    default void calculateStats(
        com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCalculateStatsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets project-level settings.
     * </pre>
     */
    default void getSettings(
        com.google.cloud.contactcenterinsights.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates project-level settings.
     * </pre>
     */
    default void updateSettings(
        com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateSettingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a analysis rule.
     * </pre>
     */
    default void createAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateAnalysisRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a analysis rule.
     * </pre>
     */
    default void getAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetAnalysisRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists analysis rules.
     * </pre>
     */
    default void listAnalysisRules(
        com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAnalysisRulesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a analysis rule.
     * </pre>
     */
    default void updateAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateAnalysisRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a analysis rule.
     * </pre>
     */
    default void deleteAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteAnalysisRuleMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    default void getEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEncryptionSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification. An error will
     * result if the location has resources already created before the
     * initialization. After the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    default void initializeEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInitializeEncryptionSpecMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a view.
     * </pre>
     */
    default void createView(
        com.google.cloud.contactcenterinsights.v1.CreateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a view.
     * </pre>
     */
    default void getView(
        com.google.cloud.contactcenterinsights.v1.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists views.
     * </pre>
     */
    default void listViews(
        com.google.cloud.contactcenterinsights.v1.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListViewsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a view.
     * </pre>
     */
    default void updateView(
        com.google.cloud.contactcenterinsights.v1.UpdateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view.
     * </pre>
     */
    default void deleteView(
        com.google.cloud.contactcenterinsights.v1.DeleteViewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteViewMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query metrics.
     * </pre>
     */
    default void queryMetrics(
        com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getQueryMetricsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a QaQuestion.
     * </pre>
     */
    default void createQaQuestion(
        com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQaQuestionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaQuestion.
     * </pre>
     */
    default void getQaQuestion(
        com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQaQuestionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaQuestion.
     * </pre>
     */
    default void updateQaQuestion(
        com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateQaQuestionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaQuestion.
     * </pre>
     */
    default void deleteQaQuestion(
        com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteQaQuestionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QaQuestions.
     * </pre>
     */
    default void listQaQuestions(
        com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQaQuestionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a QaScorecard.
     * </pre>
     */
    default void createQaScorecard(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQaScorecardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecard.
     * </pre>
     */
    default void getQaScorecard(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQaScorecardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaScorecard.
     * </pre>
     */
    default void updateQaScorecard(
        com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateQaScorecardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecard.
     * </pre>
     */
    default void deleteQaScorecard(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteQaScorecardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QaScorecards.
     * </pre>
     */
    default void listQaScorecards(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQaScorecardsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a QaScorecardRevision.
     * </pre>
     */
    default void createQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecardRevision.
     * </pre>
     */
    default void getQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fine tune one or more QaModels.
     * </pre>
     */
    default void tuneQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getTuneQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploy a QaScorecardRevision.
     * </pre>
     */
    default void deployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeployQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploy a QaScorecardRevision.
     * </pre>
     */
    default void undeployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUndeployQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecardRevision.
     * </pre>
     */
    default void deleteQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteQaScorecardRevisionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions under the parent QaScorecard.
     * </pre>
     */
    default void listQaScorecardRevisions(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListQaScorecardRevisionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create feedback label.
     * </pre>
     */
    default void createFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateFeedbackLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List feedback labels.
     * </pre>
     */
    default void listFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeedbackLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get feedback label.
     * </pre>
     */
    default void getFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFeedbackLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update feedback label.
     * </pre>
     */
    default void updateFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateFeedbackLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete feedback label.
     * </pre>
     */
    default void deleteFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteFeedbackLabelMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all feedback labels by project number.
     * </pre>
     */
    default void listAllFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAllFeedbackLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload feedback labels in bulk.
     * </pre>
     */
    default void bulkUploadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkUploadFeedbackLabelsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Download feedback labels in bulk.
     * </pre>
     */
    default void bulkDownloadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getBulkDownloadFeedbackLabelsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ContactCenterInsights.
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public abstract static class ContactCenterInsightsImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ContactCenterInsightsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ContactCenterInsights.
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public static final class ContactCenterInsightsStub
      extends io.grpc.stub.AbstractAsyncStub<ContactCenterInsightsStub> {
    private ContactCenterInsightsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContactCenterInsightsStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContactCenterInsightsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversation.
     * Note that this method does not support audio transcription or redaction.
     * Use `conversations.upload` instead.
     * </pre>
     */
    public void createConversation(
        com.google.cloud.contactcenterinsights.v1.CreateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a long-running conversation upload operation. This method differs
     * from `CreateConversation` by allowing audio transcription and optional DLP
     * redaction.
     * </pre>
     */
    public void uploadConversation(
        com.google.cloud.contactcenterinsights.v1.UploadConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUploadConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a conversation.
     * </pre>
     */
    public void updateConversation(
        com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a conversation.
     * </pre>
     */
    public void getConversation(
        com.google.cloud.contactcenterinsights.v1.GetConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations.
     * </pre>
     */
    public void listConversations(
        com.google.cloud.contactcenterinsights.v1.ListConversationsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversation.
     * </pre>
     */
    public void deleteConversation(
        com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an analysis. The long running operation is done when the analysis
     * has completed.
     * </pre>
     */
    public void createAnalysis(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an analysis.
     * </pre>
     */
    public void getAnalysis(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Analysis>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists analyses.
     * </pre>
     */
    public void listAnalyses(
        com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalysesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an analysis.
     * </pre>
     */
    public void deleteAnalysis(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnalysisMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Analyzes multiple conversations in a single request.
     * </pre>
     */
    public void bulkAnalyzeConversations(
        com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkAnalyzeConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple conversations in a single request.
     * </pre>
     */
    public void bulkDeleteConversations(
        com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkDeleteConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports conversations and processes them according to the user's
     * configuration.
     * </pre>
     */
    public void ingestConversations(
        com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getIngestConversationsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Export insights data to a destination defined in the request body.
     * </pre>
     */
    public void exportInsightsData(
        com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportInsightsDataMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue model.
     * </pre>
     */
    public void createIssueModel(
        com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue model.
     * </pre>
     */
    public void updateIssueModel(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model.
     * </pre>
     */
    public void getIssueModel(
        com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issue models.
     * </pre>
     */
    public void listIssueModels(
        com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIssueModelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue model.
     * </pre>
     */
    public void deleteIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploys an issue model. Returns an error if a model is already deployed.
     * An issue model can only be used in analysis after it has been deployed.
     * </pre>
     */
    public void deployIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an issue model.
     * An issue model can not be used in analysis after it has been undeployed.
     * </pre>
     */
    public void undeployIssueModel(
        com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports an issue model to the provided destination.
     * </pre>
     */
    public void exportIssueModel(
        com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports an issue model from a Cloud Storage bucket.
     * </pre>
     */
    public void importIssueModel(
        com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportIssueModelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public void getIssue(
        com.google.cloud.contactcenterinsights.v1.GetIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetIssueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists issues.
     * </pre>
     */
    public void listIssues(
        com.google.cloud.contactcenterinsights.v1.ListIssuesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListIssuesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue.
     * </pre>
     */
    public void updateIssue(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateIssueMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public void deleteIssue(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteIssueMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model's statistics.
     * </pre>
     */
    public void calculateIssueModelStats(
        com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateIssueModelStatsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a phrase matcher.
     * </pre>
     */
    public void createPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePhraseMatcherMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a phrase matcher.
     * </pre>
     */
    public void getPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPhraseMatcherMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists phrase matchers.
     * </pre>
     */
    public void listPhraseMatchers(
        com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPhraseMatchersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a phrase matcher.
     * </pre>
     */
    public void deletePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeletePhraseMatcherMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a phrase matcher.
     * </pre>
     */
    public void updatePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePhraseMatcherMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets conversation statistics.
     * </pre>
     */
    public void calculateStats(
        com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCalculateStatsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets project-level settings.
     * </pre>
     */
    public void getSettings(
        com.google.cloud.contactcenterinsights.v1.GetSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates project-level settings.
     * </pre>
     */
    public void updateSettings(
        com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a analysis rule.
     * </pre>
     */
    public void createAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAnalysisRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get a analysis rule.
     * </pre>
     */
    public void getAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnalysisRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists analysis rules.
     * </pre>
     */
    public void listAnalysisRules(
        com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAnalysisRulesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a analysis rule.
     * </pre>
     */
    public void updateAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnalysisRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a analysis rule.
     * </pre>
     */
    public void deleteAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteAnalysisRuleMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public void getEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification. An error will
     * result if the location has resources already created before the
     * initialization. After the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public void initializeEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInitializeEncryptionSpecMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a view.
     * </pre>
     */
    public void createView(
        com.google.cloud.contactcenterinsights.v1.CreateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a view.
     * </pre>
     */
    public void getView(
        com.google.cloud.contactcenterinsights.v1.GetViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists views.
     * </pre>
     */
    public void listViews(
        com.google.cloud.contactcenterinsights.v1.ListViewsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a view.
     * </pre>
     */
    public void updateView(
        com.google.cloud.contactcenterinsights.v1.UpdateViewRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view.
     * </pre>
     */
    public void deleteView(
        com.google.cloud.contactcenterinsights.v1.DeleteViewRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteViewMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Query metrics.
     * </pre>
     */
    public void queryMetrics(
        com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getQueryMetricsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a QaQuestion.
     * </pre>
     */
    public void createQaQuestion(
        com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQaQuestionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaQuestion.
     * </pre>
     */
    public void getQaQuestion(
        com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQaQuestionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaQuestion.
     * </pre>
     */
    public void updateQaQuestion(
        com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQaQuestionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaQuestion.
     * </pre>
     */
    public void deleteQaQuestion(
        com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteQaQuestionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QaQuestions.
     * </pre>
     */
    public void listQaQuestions(
        com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQaQuestionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create a QaScorecard.
     * </pre>
     */
    public void createQaScorecard(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQaScorecardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecard.
     * </pre>
     */
    public void getQaScorecard(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQaScorecardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaScorecard.
     * </pre>
     */
    public void updateQaScorecard(
        com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateQaScorecardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecard.
     * </pre>
     */
    public void deleteQaScorecard(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteQaScorecardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists QaScorecards.
     * </pre>
     */
    public void listQaScorecards(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQaScorecardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a QaScorecardRevision.
     * </pre>
     */
    public void createQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecardRevision.
     * </pre>
     */
    public void getQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Fine tune one or more QaModels.
     * </pre>
     */
    public void tuneQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTuneQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deploy a QaScorecardRevision.
     * </pre>
     */
    public void deployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeployQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Undeploy a QaScorecardRevision.
     * </pre>
     */
    public void undeployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUndeployQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecardRevision.
     * </pre>
     */
    public void deleteQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteQaScorecardRevisionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions under the parent QaScorecard.
     * </pre>
     */
    public void listQaScorecardRevisions(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListQaScorecardRevisionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Create feedback label.
     * </pre>
     */
    public void createFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFeedbackLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List feedback labels.
     * </pre>
     */
    public void listFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeedbackLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get feedback label.
     * </pre>
     */
    public void getFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeedbackLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update feedback label.
     * </pre>
     */
    public void updateFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateFeedbackLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete feedback label.
     * </pre>
     */
    public void deleteFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFeedbackLabelMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all feedback labels by project number.
     * </pre>
     */
    public void listAllFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAllFeedbackLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Upload feedback labels in bulk.
     * </pre>
     */
    public void bulkUploadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkUploadFeedbackLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Download feedback labels in bulk.
     * </pre>
     */
    public void bulkDownloadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBulkDownloadFeedbackLabelsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ContactCenterInsights.
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public static final class ContactCenterInsightsBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ContactCenterInsightsBlockingV2Stub> {
    private ContactCenterInsightsBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContactCenterInsightsBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContactCenterInsightsBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversation.
     * Note that this method does not support audio transcription or redaction.
     * Use `conversations.upload` instead.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation createConversation(
        com.google.cloud.contactcenterinsights.v1.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a long-running conversation upload operation. This method differs
     * from `CreateConversation` by allowing audio transcription and optional DLP
     * redaction.
     * </pre>
     */
    public com.google.longrunning.Operation uploadConversation(
        com.google.cloud.contactcenterinsights.v1.UploadConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a conversation.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation updateConversation(
        com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a conversation.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation getConversation(
        com.google.cloud.contactcenterinsights.v1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListConversationsResponse listConversations(
        com.google.cloud.contactcenterinsights.v1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an analysis. The long running operation is done when the analysis
     * has completed.
     * </pre>
     */
    public com.google.longrunning.Operation createAnalysis(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an analysis.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Analysis getAnalysis(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analyses.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse listAnalyses(
        com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalysesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an analysis.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnalysis(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes multiple conversations in a single request.
     * </pre>
     */
    public com.google.longrunning.Operation bulkAnalyzeConversations(
        com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkAnalyzeConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple conversations in a single request.
     * </pre>
     */
    public com.google.longrunning.Operation bulkDeleteConversations(
        com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkDeleteConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports conversations and processes them according to the user's
     * configuration.
     * </pre>
     */
    public com.google.longrunning.Operation ingestConversations(
        com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export insights data to a destination defined in the request body.
     * </pre>
     */
    public com.google.longrunning.Operation exportInsightsData(
        com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportInsightsDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue model.
     * </pre>
     */
    public com.google.longrunning.Operation createIssueModel(
        com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue model.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.IssueModel updateIssueModel(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.IssueModel getIssueModel(
        com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issue models.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse listIssueModels(
        com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssueModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue model.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an issue model. Returns an error if a model is already deployed.
     * An issue model can only be used in analysis after it has been deployed.
     * </pre>
     */
    public com.google.longrunning.Operation deployIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an issue model.
     * An issue model can not be used in analysis after it has been undeployed.
     * </pre>
     */
    public com.google.longrunning.Operation undeployIssueModel(
        com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports an issue model to the provided destination.
     * </pre>
     */
    public com.google.longrunning.Operation exportIssueModel(
        com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an issue model from a Cloud Storage bucket.
     * </pre>
     */
    public com.google.longrunning.Operation importIssueModel(
        com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Issue getIssue(
        com.google.cloud.contactcenterinsights.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListIssuesResponse listIssues(
        com.google.cloud.contactcenterinsights.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Issue updateIssue(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIssue(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model's statistics.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse
        calculateIssueModelStats(
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateIssueModelStatsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher createPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher getPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists phrase matchers.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse listPhraseMatchers(
        com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhraseMatchersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a phrase matcher.
     * </pre>
     */
    public com.google.protobuf.Empty deletePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher updatePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets conversation statistics.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse calculateStats(
        com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateStatsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets project-level settings.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Settings getSettings(
        com.google.cloud.contactcenterinsights.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates project-level settings.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Settings updateSettings(
        com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule createAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule getAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analysis rules.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse listAnalysisRules(
        com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalysisRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule updateAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a analysis rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.EncryptionSpec getEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification. An error will
     * result if the location has resources already created before the
     * initialization. After the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public com.google.longrunning.Operation initializeEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View createView(
        com.google.cloud.contactcenterinsights.v1.CreateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View getView(
        com.google.cloud.contactcenterinsights.v1.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists views.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListViewsResponse listViews(
        com.google.cloud.contactcenterinsights.v1.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View updateView(
        com.google.cloud.contactcenterinsights.v1.UpdateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view.
     * </pre>
     */
    public com.google.protobuf.Empty deleteView(
        com.google.cloud.contactcenterinsights.v1.DeleteViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query metrics.
     * </pre>
     */
    public com.google.longrunning.Operation queryMetrics(
        com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion createQaQuestion(
        com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion getQaQuestion(
        com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion updateQaQuestion(
        com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaQuestion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaQuestion(
        com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaQuestions.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse listQaQuestions(
        com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaQuestionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard createQaScorecard(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard getQaScorecard(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard updateQaScorecard(
        com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecard.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaScorecard(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaScorecards.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse listQaScorecards(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaScorecardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision createQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision getQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fine tune one or more QaModels.
     * </pre>
     */
    public com.google.longrunning.Operation tuneQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTuneQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision deployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
        undeployQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecardRevision.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions under the parent QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse
        listQaScorecardRevisions(
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaScorecardRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel createFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List feedback labels.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse listFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel getFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel updateFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete feedback label.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all feedback labels by project number.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse
        listAllFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upload feedback labels in bulk.
     * </pre>
     */
    public com.google.longrunning.Operation bulkUploadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkUploadFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Download feedback labels in bulk.
     * </pre>
     */
    public com.google.longrunning.Operation bulkDownloadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkDownloadFeedbackLabelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ContactCenterInsights.
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public static final class ContactCenterInsightsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ContactCenterInsightsBlockingStub> {
    private ContactCenterInsightsBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContactCenterInsightsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContactCenterInsightsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversation.
     * Note that this method does not support audio transcription or redaction.
     * Use `conversations.upload` instead.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation createConversation(
        com.google.cloud.contactcenterinsights.v1.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a long-running conversation upload operation. This method differs
     * from `CreateConversation` by allowing audio transcription and optional DLP
     * redaction.
     * </pre>
     */
    public com.google.longrunning.Operation uploadConversation(
        com.google.cloud.contactcenterinsights.v1.UploadConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUploadConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a conversation.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation updateConversation(
        com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a conversation.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Conversation getConversation(
        com.google.cloud.contactcenterinsights.v1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListConversationsResponse listConversations(
        com.google.cloud.contactcenterinsights.v1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversation.
     * </pre>
     */
    public com.google.protobuf.Empty deleteConversation(
        com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteConversationMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an analysis. The long running operation is done when the analysis
     * has completed.
     * </pre>
     */
    public com.google.longrunning.Operation createAnalysis(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an analysis.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Analysis getAnalysis(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analyses.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse listAnalyses(
        com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalysesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an analysis.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnalysis(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalysisMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes multiple conversations in a single request.
     * </pre>
     */
    public com.google.longrunning.Operation bulkAnalyzeConversations(
        com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkAnalyzeConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple conversations in a single request.
     * </pre>
     */
    public com.google.longrunning.Operation bulkDeleteConversations(
        com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkDeleteConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports conversations and processes them according to the user's
     * configuration.
     * </pre>
     */
    public com.google.longrunning.Operation ingestConversations(
        com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getIngestConversationsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Export insights data to a destination defined in the request body.
     * </pre>
     */
    public com.google.longrunning.Operation exportInsightsData(
        com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportInsightsDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue model.
     * </pre>
     */
    public com.google.longrunning.Operation createIssueModel(
        com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue model.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.IssueModel updateIssueModel(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.IssueModel getIssueModel(
        com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issue models.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse listIssueModels(
        com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssueModelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue model.
     * </pre>
     */
    public com.google.longrunning.Operation deleteIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an issue model. Returns an error if a model is already deployed.
     * An issue model can only be used in analysis after it has been deployed.
     * </pre>
     */
    public com.google.longrunning.Operation deployIssueModel(
        com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an issue model.
     * An issue model can not be used in analysis after it has been undeployed.
     * </pre>
     */
    public com.google.longrunning.Operation undeployIssueModel(
        com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports an issue model to the provided destination.
     * </pre>
     */
    public com.google.longrunning.Operation exportIssueModel(
        com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an issue model from a Cloud Storage bucket.
     * </pre>
     */
    public com.google.longrunning.Operation importIssueModel(
        com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportIssueModelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Issue getIssue(
        com.google.cloud.contactcenterinsights.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListIssuesResponse listIssues(
        com.google.cloud.contactcenterinsights.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListIssuesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Issue updateIssue(
        com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.protobuf.Empty deleteIssue(
        com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteIssueMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model's statistics.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse
        calculateIssueModelStats(
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateIssueModelStatsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher createPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher getPhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists phrase matchers.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse listPhraseMatchers(
        com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPhraseMatchersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a phrase matcher.
     * </pre>
     */
    public com.google.protobuf.Empty deletePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeletePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a phrase matcher.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.PhraseMatcher updatePhraseMatcher(
        com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePhraseMatcherMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets conversation statistics.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse calculateStats(
        com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCalculateStatsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets project-level settings.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Settings getSettings(
        com.google.cloud.contactcenterinsights.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates project-level settings.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.Settings updateSettings(
        com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateSettingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule createAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule getAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analysis rules.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse listAnalysisRules(
        com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAnalysisRulesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a analysis rule.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.AnalysisRule updateAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a analysis rule.
     * </pre>
     */
    public com.google.protobuf.Empty deleteAnalysisRule(
        com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteAnalysisRuleMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.EncryptionSpec getEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification. An error will
     * result if the location has resources already created before the
     * initialization. After the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public com.google.longrunning.Operation initializeEncryptionSpec(
        com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getInitializeEncryptionSpecMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View createView(
        com.google.cloud.contactcenterinsights.v1.CreateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View getView(
        com.google.cloud.contactcenterinsights.v1.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists views.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListViewsResponse listViews(
        com.google.cloud.contactcenterinsights.v1.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListViewsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a view.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.View updateView(
        com.google.cloud.contactcenterinsights.v1.UpdateViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view.
     * </pre>
     */
    public com.google.protobuf.Empty deleteView(
        com.google.cloud.contactcenterinsights.v1.DeleteViewRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteViewMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Query metrics.
     * </pre>
     */
    public com.google.longrunning.Operation queryMetrics(
        com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getQueryMetricsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion createQaQuestion(
        com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion getQaQuestion(
        com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaQuestion.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaQuestion updateQaQuestion(
        com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaQuestion.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaQuestion(
        com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaQuestionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaQuestions.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse listQaQuestions(
        com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaQuestionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard createQaScorecard(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard getQaScorecard(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecard updateQaScorecard(
        com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecard.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaScorecard(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaScorecardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaScorecards.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse listQaScorecards(
        com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaScorecardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision createQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision getQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Fine tune one or more QaModels.
     * </pre>
     */
    public com.google.longrunning.Operation tuneQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTuneQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision deployQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeployQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.QaScorecardRevision
        undeployQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUndeployQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecardRevision.
     * </pre>
     */
    public com.google.protobuf.Empty deleteQaScorecardRevision(
        com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteQaScorecardRevisionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions under the parent QaScorecard.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse
        listQaScorecardRevisions(
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListQaScorecardRevisionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Create feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel createFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List feedback labels.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse listFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel getFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update feedback label.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.FeedbackLabel updateFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete feedback label.
     * </pre>
     */
    public com.google.protobuf.Empty deleteFeedbackLabel(
        com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFeedbackLabelMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all feedback labels by project number.
     * </pre>
     */
    public com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse
        listAllFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAllFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Upload feedback labels in bulk.
     * </pre>
     */
    public com.google.longrunning.Operation bulkUploadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkUploadFeedbackLabelsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Download feedback labels in bulk.
     * </pre>
     */
    public com.google.longrunning.Operation bulkDownloadFeedbackLabels(
        com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBulkDownloadFeedbackLabelsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ContactCenterInsights.
   *
   * <pre>
   * An API that lets users analyze and explore their business conversation data.
   * </pre>
   */
  public static final class ContactCenterInsightsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ContactCenterInsightsFutureStub> {
    private ContactCenterInsightsFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ContactCenterInsightsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ContactCenterInsightsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a conversation.
     * Note that this method does not support audio transcription or redaction.
     * Use `conversations.upload` instead.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Conversation>
        createConversation(
            com.google.cloud.contactcenterinsights.v1.CreateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a long-running conversation upload operation. This method differs
     * from `CreateConversation` by allowing audio transcription and optional DLP
     * redaction.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        uploadConversation(
            com.google.cloud.contactcenterinsights.v1.UploadConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUploadConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Conversation>
        updateConversation(
            com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Conversation>
        getConversation(com.google.cloud.contactcenterinsights.v1.GetConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists conversations.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>
        listConversations(
            com.google.cloud.contactcenterinsights.v1.ListConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteConversation(
            com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteConversationMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an analysis. The long running operation is done when the analysis
     * has completed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createAnalysis(com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an analysis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Analysis>
        getAnalysis(com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analyses.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>
        listAnalyses(com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalysesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an analysis.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnalysis(com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnalysisMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Analyzes multiple conversations in a single request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkAnalyzeConversations(
            com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkAnalyzeConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes multiple conversations in a single request.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkDeleteConversations(
            com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkDeleteConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports conversations and processes them according to the user's
     * configuration.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        ingestConversations(
            com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getIngestConversationsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Export insights data to a destination defined in the request body.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportInsightsData(
            com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportInsightsDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an issue model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createIssueModel(
            com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.IssueModel>
        updateIssueModel(
            com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.IssueModel>
        getIssueModel(com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issue models.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>
        listIssueModels(com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIssueModelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue model.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteIssueModel(
            com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploys an issue model. Returns an error if a model is already deployed.
     * An issue model can only be used in analysis after it has been deployed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deployIssueModel(
            com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploys an issue model.
     * An issue model can not be used in analysis after it has been undeployed.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        undeployIssueModel(
            com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports an issue model to the provided destination.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportIssueModel(
            com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports an issue model from a Cloud Storage bucket.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importIssueModel(
            com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportIssueModelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Issue>
        getIssue(com.google.cloud.contactcenterinsights.v1.GetIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists issues.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>
        listIssues(com.google.cloud.contactcenterinsights.v1.ListIssuesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListIssuesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Issue>
        updateIssue(com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes an issue.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteIssue(com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteIssueMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets an issue model's statistics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>
        calculateIssueModelStats(
            com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateIssueModelStatsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a phrase matcher.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        createPhraseMatcher(
            com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePhraseMatcherMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a phrase matcher.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        getPhraseMatcher(
            com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPhraseMatcherMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists phrase matchers.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>
        listPhraseMatchers(
            com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPhraseMatchersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a phrase matcher.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deletePhraseMatcher(
            com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeletePhraseMatcherMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a phrase matcher.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.PhraseMatcher>
        updatePhraseMatcher(
            com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePhraseMatcherMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets conversation statistics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>
        calculateStats(com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCalculateStatsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets project-level settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Settings>
        getSettings(com.google.cloud.contactcenterinsights.v1.GetSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates project-level settings.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.Settings>
        updateSettings(com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateSettingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a analysis rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        createAnalysisRule(
            com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAnalysisRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get a analysis rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        getAnalysisRule(com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnalysisRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists analysis rules.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>
        listAnalysisRules(
            com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAnalysisRulesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a analysis rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.AnalysisRule>
        updateAnalysisRule(
            com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnalysisRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a analysis rule.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteAnalysisRule(
            com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteAnalysisRuleMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets location-level encryption key specification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.EncryptionSpec>
        getEncryptionSpec(
            com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEncryptionSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Initializes a location-level encryption key specification. An error will
     * result if the location has resources already created before the
     * initialization. After the encryption specification is initialized at a
     * location, it is immutable and all newly created resources under the
     * location will be encrypted with the existing specification.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        initializeEncryptionSpec(
            com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInitializeEncryptionSpecMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.View>
        createView(com.google.cloud.contactcenterinsights.v1.CreateViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.View>
        getView(com.google.cloud.contactcenterinsights.v1.GetViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists views.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListViewsResponse>
        listViews(com.google.cloud.contactcenterinsights.v1.ListViewsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListViewsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.View>
        updateView(com.google.cloud.contactcenterinsights.v1.UpdateViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a view.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteView(
        com.google.cloud.contactcenterinsights.v1.DeleteViewRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteViewMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Query metrics.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        queryMetrics(com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getQueryMetricsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaQuestion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        createQaQuestion(
            com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQaQuestionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaQuestion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        getQaQuestion(com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQaQuestionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaQuestion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaQuestion>
        updateQaQuestion(
            com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQaQuestionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaQuestion.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteQaQuestion(
            com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteQaQuestionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaQuestions.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>
        listQaQuestions(com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQaQuestionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create a QaScorecard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        createQaScorecard(
            com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQaScorecardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        getQaScorecard(com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQaScorecardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a QaScorecard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecard>
        updateQaScorecard(
            com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateQaScorecardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteQaScorecard(
            com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteQaScorecardMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists QaScorecards.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>
        listQaScorecards(
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQaScorecardsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a QaScorecardRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        createQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a QaScorecardRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        getQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Fine tune one or more QaModels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        tuneQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTuneQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        deployQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeployQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Undeploy a QaScorecardRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>
        undeployQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUndeployQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a QaScorecardRevision.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteQaScorecardRevision(
            com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteQaScorecardRevisionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all revisions under the parent QaScorecard.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>
        listQaScorecardRevisions(
            com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListQaScorecardRevisionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Create feedback label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        createFeedbackLabel(
            com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFeedbackLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List feedback labels.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>
        listFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeedbackLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get feedback label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        getFeedbackLabel(
            com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeedbackLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update feedback label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.FeedbackLabel>
        updateFeedbackLabel(
            com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateFeedbackLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete feedback label.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteFeedbackLabel(
            com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFeedbackLabelMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List all feedback labels by project number.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>
        listAllFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAllFeedbackLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Upload feedback labels in bulk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkUploadFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkUploadFeedbackLabelsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Download feedback labels in bulk.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        bulkDownloadFeedbackLabels(
            com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBulkDownloadFeedbackLabelsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CONVERSATION = 0;
  private static final int METHODID_UPLOAD_CONVERSATION = 1;
  private static final int METHODID_UPDATE_CONVERSATION = 2;
  private static final int METHODID_GET_CONVERSATION = 3;
  private static final int METHODID_LIST_CONVERSATIONS = 4;
  private static final int METHODID_DELETE_CONVERSATION = 5;
  private static final int METHODID_CREATE_ANALYSIS = 6;
  private static final int METHODID_GET_ANALYSIS = 7;
  private static final int METHODID_LIST_ANALYSES = 8;
  private static final int METHODID_DELETE_ANALYSIS = 9;
  private static final int METHODID_BULK_ANALYZE_CONVERSATIONS = 10;
  private static final int METHODID_BULK_DELETE_CONVERSATIONS = 11;
  private static final int METHODID_INGEST_CONVERSATIONS = 12;
  private static final int METHODID_EXPORT_INSIGHTS_DATA = 13;
  private static final int METHODID_CREATE_ISSUE_MODEL = 14;
  private static final int METHODID_UPDATE_ISSUE_MODEL = 15;
  private static final int METHODID_GET_ISSUE_MODEL = 16;
  private static final int METHODID_LIST_ISSUE_MODELS = 17;
  private static final int METHODID_DELETE_ISSUE_MODEL = 18;
  private static final int METHODID_DEPLOY_ISSUE_MODEL = 19;
  private static final int METHODID_UNDEPLOY_ISSUE_MODEL = 20;
  private static final int METHODID_EXPORT_ISSUE_MODEL = 21;
  private static final int METHODID_IMPORT_ISSUE_MODEL = 22;
  private static final int METHODID_GET_ISSUE = 23;
  private static final int METHODID_LIST_ISSUES = 24;
  private static final int METHODID_UPDATE_ISSUE = 25;
  private static final int METHODID_DELETE_ISSUE = 26;
  private static final int METHODID_CALCULATE_ISSUE_MODEL_STATS = 27;
  private static final int METHODID_CREATE_PHRASE_MATCHER = 28;
  private static final int METHODID_GET_PHRASE_MATCHER = 29;
  private static final int METHODID_LIST_PHRASE_MATCHERS = 30;
  private static final int METHODID_DELETE_PHRASE_MATCHER = 31;
  private static final int METHODID_UPDATE_PHRASE_MATCHER = 32;
  private static final int METHODID_CALCULATE_STATS = 33;
  private static final int METHODID_GET_SETTINGS = 34;
  private static final int METHODID_UPDATE_SETTINGS = 35;
  private static final int METHODID_CREATE_ANALYSIS_RULE = 36;
  private static final int METHODID_GET_ANALYSIS_RULE = 37;
  private static final int METHODID_LIST_ANALYSIS_RULES = 38;
  private static final int METHODID_UPDATE_ANALYSIS_RULE = 39;
  private static final int METHODID_DELETE_ANALYSIS_RULE = 40;
  private static final int METHODID_GET_ENCRYPTION_SPEC = 41;
  private static final int METHODID_INITIALIZE_ENCRYPTION_SPEC = 42;
  private static final int METHODID_CREATE_VIEW = 43;
  private static final int METHODID_GET_VIEW = 44;
  private static final int METHODID_LIST_VIEWS = 45;
  private static final int METHODID_UPDATE_VIEW = 46;
  private static final int METHODID_DELETE_VIEW = 47;
  private static final int METHODID_QUERY_METRICS = 48;
  private static final int METHODID_CREATE_QA_QUESTION = 49;
  private static final int METHODID_GET_QA_QUESTION = 50;
  private static final int METHODID_UPDATE_QA_QUESTION = 51;
  private static final int METHODID_DELETE_QA_QUESTION = 52;
  private static final int METHODID_LIST_QA_QUESTIONS = 53;
  private static final int METHODID_CREATE_QA_SCORECARD = 54;
  private static final int METHODID_GET_QA_SCORECARD = 55;
  private static final int METHODID_UPDATE_QA_SCORECARD = 56;
  private static final int METHODID_DELETE_QA_SCORECARD = 57;
  private static final int METHODID_LIST_QA_SCORECARDS = 58;
  private static final int METHODID_CREATE_QA_SCORECARD_REVISION = 59;
  private static final int METHODID_GET_QA_SCORECARD_REVISION = 60;
  private static final int METHODID_TUNE_QA_SCORECARD_REVISION = 61;
  private static final int METHODID_DEPLOY_QA_SCORECARD_REVISION = 62;
  private static final int METHODID_UNDEPLOY_QA_SCORECARD_REVISION = 63;
  private static final int METHODID_DELETE_QA_SCORECARD_REVISION = 64;
  private static final int METHODID_LIST_QA_SCORECARD_REVISIONS = 65;
  private static final int METHODID_CREATE_FEEDBACK_LABEL = 66;
  private static final int METHODID_LIST_FEEDBACK_LABELS = 67;
  private static final int METHODID_GET_FEEDBACK_LABEL = 68;
  private static final int METHODID_UPDATE_FEEDBACK_LABEL = 69;
  private static final int METHODID_DELETE_FEEDBACK_LABEL = 70;
  private static final int METHODID_LIST_ALL_FEEDBACK_LABELS = 71;
  private static final int METHODID_BULK_UPLOAD_FEEDBACK_LABELS = 72;
  private static final int METHODID_BULK_DOWNLOAD_FEEDBACK_LABELS = 73;

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
        case METHODID_CREATE_CONVERSATION:
          serviceImpl.createConversation(
              (com.google.cloud.contactcenterinsights.v1.CreateConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>)
                  responseObserver);
          break;
        case METHODID_UPLOAD_CONVERSATION:
          serviceImpl.uploadConversation(
              (com.google.cloud.contactcenterinsights.v1.UploadConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_CONVERSATION:
          serviceImpl.updateConversation(
              (com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>)
                  responseObserver);
          break;
        case METHODID_GET_CONVERSATION:
          serviceImpl.getConversation(
              (com.google.cloud.contactcenterinsights.v1.GetConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Conversation>)
                  responseObserver);
          break;
        case METHODID_LIST_CONVERSATIONS:
          serviceImpl.listConversations(
              (com.google.cloud.contactcenterinsights.v1.ListConversationsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CONVERSATION:
          serviceImpl.deleteConversation(
              (com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CREATE_ANALYSIS:
          serviceImpl.createAnalysis(
              (com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ANALYSIS:
          serviceImpl.getAnalysis(
              (com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Analysis>)
                  responseObserver);
          break;
        case METHODID_LIST_ANALYSES:
          serviceImpl.listAnalyses(
              (com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANALYSIS:
          serviceImpl.deleteAnalysis(
              (com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_BULK_ANALYZE_CONVERSATIONS:
          serviceImpl.bulkAnalyzeConversations(
              (com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BULK_DELETE_CONVERSATIONS:
          serviceImpl.bulkDeleteConversations(
              (com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_INGEST_CONVERSATIONS:
          serviceImpl.ingestConversations(
              (com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_INSIGHTS_DATA:
          serviceImpl.exportInsightsData(
              (com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_ISSUE_MODEL:
          serviceImpl.createIssueModel(
              (com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ISSUE_MODEL:
          serviceImpl.updateIssueModel(
              (com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>)
                  responseObserver);
          break;
        case METHODID_GET_ISSUE_MODEL:
          serviceImpl.getIssueModel(
              (com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.IssueModel>)
                  responseObserver);
          break;
        case METHODID_LIST_ISSUE_MODELS:
          serviceImpl.listIssueModels(
              (com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_ISSUE_MODEL:
          serviceImpl.deleteIssueModel(
              (com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_ISSUE_MODEL:
          serviceImpl.deployIssueModel(
              (com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UNDEPLOY_ISSUE_MODEL:
          serviceImpl.undeployIssueModel(
              (com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_ISSUE_MODEL:
          serviceImpl.exportIssueModel(
              (com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_ISSUE_MODEL:
          serviceImpl.importIssueModel(
              (com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_ISSUE:
          serviceImpl.getIssue(
              (com.google.cloud.contactcenterinsights.v1.GetIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>)
                  responseObserver);
          break;
        case METHODID_LIST_ISSUES:
          serviceImpl.listIssues(
              (com.google.cloud.contactcenterinsights.v1.ListIssuesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ISSUE:
          serviceImpl.updateIssue(
              (com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Issue>)
                  responseObserver);
          break;
        case METHODID_DELETE_ISSUE:
          serviceImpl.deleteIssue(
              (com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_CALCULATE_ISSUE_MODEL_STATS:
          serviceImpl.calculateIssueModelStats(
              (com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_PHRASE_MATCHER:
          serviceImpl.createPhraseMatcher(
              (com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>)
                  responseObserver);
          break;
        case METHODID_GET_PHRASE_MATCHER:
          serviceImpl.getPhraseMatcher(
              (com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>)
                  responseObserver);
          break;
        case METHODID_LIST_PHRASE_MATCHERS:
          serviceImpl.listPhraseMatchers(
              (com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_PHRASE_MATCHER:
          serviceImpl.deletePhraseMatcher(
              (com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_PHRASE_MATCHER:
          serviceImpl.updatePhraseMatcher(
              (com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.PhraseMatcher>)
                  responseObserver);
          break;
        case METHODID_CALCULATE_STATS:
          serviceImpl.calculateStats(
              (com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_SETTINGS:
          serviceImpl.getSettings(
              (com.google.cloud.contactcenterinsights.v1.GetSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>)
                  responseObserver);
          break;
        case METHODID_UPDATE_SETTINGS:
          serviceImpl.updateSettings(
              (com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.Settings>)
                  responseObserver);
          break;
        case METHODID_CREATE_ANALYSIS_RULE:
          serviceImpl.createAnalysisRule(
              (com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>)
                  responseObserver);
          break;
        case METHODID_GET_ANALYSIS_RULE:
          serviceImpl.getAnalysisRule(
              (com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>)
                  responseObserver);
          break;
        case METHODID_LIST_ANALYSIS_RULES:
          serviceImpl.listAnalysisRules(
              (com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_ANALYSIS_RULE:
          serviceImpl.updateAnalysisRule(
              (com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.AnalysisRule>)
                  responseObserver);
          break;
        case METHODID_DELETE_ANALYSIS_RULE:
          serviceImpl.deleteAnalysisRule(
              (com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_GET_ENCRYPTION_SPEC:
          serviceImpl.getEncryptionSpec(
              (com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.EncryptionSpec>)
                  responseObserver);
          break;
        case METHODID_INITIALIZE_ENCRYPTION_SPEC:
          serviceImpl.initializeEncryptionSpec(
              (com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_VIEW:
          serviceImpl.createView(
              (com.google.cloud.contactcenterinsights.v1.CreateViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>)
                  responseObserver);
          break;
        case METHODID_GET_VIEW:
          serviceImpl.getView(
              (com.google.cloud.contactcenterinsights.v1.GetViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>)
                  responseObserver);
          break;
        case METHODID_LIST_VIEWS:
          serviceImpl.listViews(
              (com.google.cloud.contactcenterinsights.v1.ListViewsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListViewsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VIEW:
          serviceImpl.updateView(
              (com.google.cloud.contactcenterinsights.v1.UpdateViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.View>)
                  responseObserver);
          break;
        case METHODID_DELETE_VIEW:
          serviceImpl.deleteView(
              (com.google.cloud.contactcenterinsights.v1.DeleteViewRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_QUERY_METRICS:
          serviceImpl.queryMetrics(
              (com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_CREATE_QA_QUESTION:
          serviceImpl.createQaQuestion(
              (com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>)
                  responseObserver);
          break;
        case METHODID_GET_QA_QUESTION:
          serviceImpl.getQaQuestion(
              (com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>)
                  responseObserver);
          break;
        case METHODID_UPDATE_QA_QUESTION:
          serviceImpl.updateQaQuestion(
              (com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaQuestion>)
                  responseObserver);
          break;
        case METHODID_DELETE_QA_QUESTION:
          serviceImpl.deleteQaQuestion(
              (com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_QA_QUESTIONS:
          serviceImpl.listQaQuestions(
              (com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_QA_SCORECARD:
          serviceImpl.createQaScorecard(
              (com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>)
                  responseObserver);
          break;
        case METHODID_GET_QA_SCORECARD:
          serviceImpl.getQaScorecard(
              (com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>)
                  responseObserver);
          break;
        case METHODID_UPDATE_QA_SCORECARD:
          serviceImpl.updateQaScorecard(
              (com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.QaScorecard>)
                  responseObserver);
          break;
        case METHODID_DELETE_QA_SCORECARD:
          serviceImpl.deleteQaScorecard(
              (com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_QA_SCORECARDS:
          serviceImpl.listQaScorecards(
              (com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_QA_SCORECARD_REVISION:
          serviceImpl.createQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>)
                  responseObserver);
          break;
        case METHODID_GET_QA_SCORECARD_REVISION:
          serviceImpl.getQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>)
                  responseObserver);
          break;
        case METHODID_TUNE_QA_SCORECARD_REVISION:
          serviceImpl.tuneQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DEPLOY_QA_SCORECARD_REVISION:
          serviceImpl.deployQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>)
                  responseObserver);
          break;
        case METHODID_UNDEPLOY_QA_SCORECARD_REVISION:
          serviceImpl.undeployQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest)
                  request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>)
                  responseObserver);
          break;
        case METHODID_DELETE_QA_SCORECARD_REVISION:
          serviceImpl.deleteQaScorecardRevision(
              (com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_QA_SCORECARD_REVISIONS:
          serviceImpl.listQaScorecardRevisions(
              (com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>)
                  responseObserver);
          break;
        case METHODID_CREATE_FEEDBACK_LABEL:
          serviceImpl.createFeedbackLabel(
              (com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>)
                  responseObserver);
          break;
        case METHODID_LIST_FEEDBACK_LABELS:
          serviceImpl.listFeedbackLabels(
              (com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_FEEDBACK_LABEL:
          serviceImpl.getFeedbackLabel(
              (com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>)
                  responseObserver);
          break;
        case METHODID_UPDATE_FEEDBACK_LABEL:
          serviceImpl.updateFeedbackLabel(
              (com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.contactcenterinsights.v1.FeedbackLabel>)
                  responseObserver);
          break;
        case METHODID_DELETE_FEEDBACK_LABEL:
          serviceImpl.deleteFeedbackLabel(
              (com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_LIST_ALL_FEEDBACK_LABELS:
          serviceImpl.listAllFeedbackLabels(
              (com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>)
                  responseObserver);
          break;
        case METHODID_BULK_UPLOAD_FEEDBACK_LABELS:
          serviceImpl.bulkUploadFeedbackLabels(
              (com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_BULK_DOWNLOAD_FEEDBACK_LABELS:
          serviceImpl.bulkDownloadFeedbackLabels(
              (com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest) request,
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
            getCreateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateConversationRequest,
                    com.google.cloud.contactcenterinsights.v1.Conversation>(
                    service, METHODID_CREATE_CONVERSATION)))
        .addMethod(
            getUploadConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UploadConversationRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPLOAD_CONVERSATION)))
        .addMethod(
            getUpdateConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateConversationRequest,
                    com.google.cloud.contactcenterinsights.v1.Conversation>(
                    service, METHODID_UPDATE_CONVERSATION)))
        .addMethod(
            getGetConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetConversationRequest,
                    com.google.cloud.contactcenterinsights.v1.Conversation>(
                    service, METHODID_GET_CONVERSATION)))
        .addMethod(
            getListConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListConversationsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListConversationsResponse>(
                    service, METHODID_LIST_CONVERSATIONS)))
        .addMethod(
            getDeleteConversationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteConversationRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_CONVERSATION)))
        .addMethod(
            getCreateAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateAnalysisRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ANALYSIS)))
        .addMethod(
            getGetAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetAnalysisRequest,
                    com.google.cloud.contactcenterinsights.v1.Analysis>(
                    service, METHODID_GET_ANALYSIS)))
        .addMethod(
            getListAnalysesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListAnalysesRequest,
                    com.google.cloud.contactcenterinsights.v1.ListAnalysesResponse>(
                    service, METHODID_LIST_ANALYSES)))
        .addMethod(
            getDeleteAnalysisMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ANALYSIS)))
        .addMethod(
            getBulkAnalyzeConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.BulkAnalyzeConversationsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BULK_ANALYZE_CONVERSATIONS)))
        .addMethod(
            getBulkDeleteConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.BulkDeleteConversationsRequest,
                    com.google.longrunning.Operation>(service, METHODID_BULK_DELETE_CONVERSATIONS)))
        .addMethod(
            getIngestConversationsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.IngestConversationsRequest,
                    com.google.longrunning.Operation>(service, METHODID_INGEST_CONVERSATIONS)))
        .addMethod(
            getExportInsightsDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ExportInsightsDataRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_INSIGHTS_DATA)))
        .addMethod(
            getCreateIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ISSUE_MODEL)))
        .addMethod(
            getUpdateIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateIssueModelRequest,
                    com.google.cloud.contactcenterinsights.v1.IssueModel>(
                    service, METHODID_UPDATE_ISSUE_MODEL)))
        .addMethod(
            getGetIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetIssueModelRequest,
                    com.google.cloud.contactcenterinsights.v1.IssueModel>(
                    service, METHODID_GET_ISSUE_MODEL)))
        .addMethod(
            getListIssueModelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListIssueModelsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListIssueModelsResponse>(
                    service, METHODID_LIST_ISSUE_MODELS)))
        .addMethod(
            getDeleteIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ISSUE_MODEL)))
        .addMethod(
            getDeployIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeployIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_DEPLOY_ISSUE_MODEL)))
        .addMethod(
            getUndeployIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UndeployIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_UNDEPLOY_ISSUE_MODEL)))
        .addMethod(
            getExportIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ExportIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_EXPORT_ISSUE_MODEL)))
        .addMethod(
            getImportIssueModelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ImportIssueModelRequest,
                    com.google.longrunning.Operation>(service, METHODID_IMPORT_ISSUE_MODEL)))
        .addMethod(
            getGetIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetIssueRequest,
                    com.google.cloud.contactcenterinsights.v1.Issue>(service, METHODID_GET_ISSUE)))
        .addMethod(
            getListIssuesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListIssuesRequest,
                    com.google.cloud.contactcenterinsights.v1.ListIssuesResponse>(
                    service, METHODID_LIST_ISSUES)))
        .addMethod(
            getUpdateIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateIssueRequest,
                    com.google.cloud.contactcenterinsights.v1.Issue>(
                    service, METHODID_UPDATE_ISSUE)))
        .addMethod(
            getDeleteIssueMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteIssueRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ISSUE)))
        .addMethod(
            getCalculateIssueModelStatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsRequest,
                    com.google.cloud.contactcenterinsights.v1.CalculateIssueModelStatsResponse>(
                    service, METHODID_CALCULATE_ISSUE_MODEL_STATS)))
        .addMethod(
            getCreatePhraseMatcherMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreatePhraseMatcherRequest,
                    com.google.cloud.contactcenterinsights.v1.PhraseMatcher>(
                    service, METHODID_CREATE_PHRASE_MATCHER)))
        .addMethod(
            getGetPhraseMatcherMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetPhraseMatcherRequest,
                    com.google.cloud.contactcenterinsights.v1.PhraseMatcher>(
                    service, METHODID_GET_PHRASE_MATCHER)))
        .addMethod(
            getListPhraseMatchersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersRequest,
                    com.google.cloud.contactcenterinsights.v1.ListPhraseMatchersResponse>(
                    service, METHODID_LIST_PHRASE_MATCHERS)))
        .addMethod(
            getDeletePhraseMatcherMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeletePhraseMatcherRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_PHRASE_MATCHER)))
        .addMethod(
            getUpdatePhraseMatcherMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdatePhraseMatcherRequest,
                    com.google.cloud.contactcenterinsights.v1.PhraseMatcher>(
                    service, METHODID_UPDATE_PHRASE_MATCHER)))
        .addMethod(
            getCalculateStatsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CalculateStatsRequest,
                    com.google.cloud.contactcenterinsights.v1.CalculateStatsResponse>(
                    service, METHODID_CALCULATE_STATS)))
        .addMethod(
            getGetSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetSettingsRequest,
                    com.google.cloud.contactcenterinsights.v1.Settings>(
                    service, METHODID_GET_SETTINGS)))
        .addMethod(
            getUpdateSettingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateSettingsRequest,
                    com.google.cloud.contactcenterinsights.v1.Settings>(
                    service, METHODID_UPDATE_SETTINGS)))
        .addMethod(
            getCreateAnalysisRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateAnalysisRuleRequest,
                    com.google.cloud.contactcenterinsights.v1.AnalysisRule>(
                    service, METHODID_CREATE_ANALYSIS_RULE)))
        .addMethod(
            getGetAnalysisRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetAnalysisRuleRequest,
                    com.google.cloud.contactcenterinsights.v1.AnalysisRule>(
                    service, METHODID_GET_ANALYSIS_RULE)))
        .addMethod(
            getListAnalysisRulesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesRequest,
                    com.google.cloud.contactcenterinsights.v1.ListAnalysisRulesResponse>(
                    service, METHODID_LIST_ANALYSIS_RULES)))
        .addMethod(
            getUpdateAnalysisRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateAnalysisRuleRequest,
                    com.google.cloud.contactcenterinsights.v1.AnalysisRule>(
                    service, METHODID_UPDATE_ANALYSIS_RULE)))
        .addMethod(
            getDeleteAnalysisRuleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteAnalysisRuleRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_ANALYSIS_RULE)))
        .addMethod(
            getGetEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetEncryptionSpecRequest,
                    com.google.cloud.contactcenterinsights.v1.EncryptionSpec>(
                    service, METHODID_GET_ENCRYPTION_SPEC)))
        .addMethod(
            getInitializeEncryptionSpecMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.InitializeEncryptionSpecRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_INITIALIZE_ENCRYPTION_SPEC)))
        .addMethod(
            getCreateViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateViewRequest,
                    com.google.cloud.contactcenterinsights.v1.View>(service, METHODID_CREATE_VIEW)))
        .addMethod(
            getGetViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetViewRequest,
                    com.google.cloud.contactcenterinsights.v1.View>(service, METHODID_GET_VIEW)))
        .addMethod(
            getListViewsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListViewsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListViewsResponse>(
                    service, METHODID_LIST_VIEWS)))
        .addMethod(
            getUpdateViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateViewRequest,
                    com.google.cloud.contactcenterinsights.v1.View>(service, METHODID_UPDATE_VIEW)))
        .addMethod(
            getDeleteViewMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteViewRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_VIEW)))
        .addMethod(
            getQueryMetricsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.QueryMetricsRequest,
                    com.google.longrunning.Operation>(service, METHODID_QUERY_METRICS)))
        .addMethod(
            getCreateQaQuestionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateQaQuestionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaQuestion>(
                    service, METHODID_CREATE_QA_QUESTION)))
        .addMethod(
            getGetQaQuestionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetQaQuestionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaQuestion>(
                    service, METHODID_GET_QA_QUESTION)))
        .addMethod(
            getUpdateQaQuestionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateQaQuestionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaQuestion>(
                    service, METHODID_UPDATE_QA_QUESTION)))
        .addMethod(
            getDeleteQaQuestionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteQaQuestionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_QA_QUESTION)))
        .addMethod(
            getListQaQuestionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListQaQuestionsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListQaQuestionsResponse>(
                    service, METHODID_LIST_QA_QUESTIONS)))
        .addMethod(
            getCreateQaScorecardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecard>(
                    service, METHODID_CREATE_QA_SCORECARD)))
        .addMethod(
            getGetQaScorecardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetQaScorecardRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecard>(
                    service, METHODID_GET_QA_SCORECARD)))
        .addMethod(
            getUpdateQaScorecardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateQaScorecardRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecard>(
                    service, METHODID_UPDATE_QA_SCORECARD)))
        .addMethod(
            getDeleteQaScorecardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_QA_SCORECARD)))
        .addMethod(
            getListQaScorecardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListQaScorecardsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListQaScorecardsResponse>(
                    service, METHODID_LIST_QA_SCORECARDS)))
        .addMethod(
            getCreateQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateQaScorecardRevisionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>(
                    service, METHODID_CREATE_QA_SCORECARD_REVISION)))
        .addMethod(
            getGetQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetQaScorecardRevisionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>(
                    service, METHODID_GET_QA_SCORECARD_REVISION)))
        .addMethod(
            getTuneQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.TuneQaScorecardRevisionRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_TUNE_QA_SCORECARD_REVISION)))
        .addMethod(
            getDeployQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeployQaScorecardRevisionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>(
                    service, METHODID_DEPLOY_QA_SCORECARD_REVISION)))
        .addMethod(
            getUndeployQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UndeployQaScorecardRevisionRequest,
                    com.google.cloud.contactcenterinsights.v1.QaScorecardRevision>(
                    service, METHODID_UNDEPLOY_QA_SCORECARD_REVISION)))
        .addMethod(
            getDeleteQaScorecardRevisionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteQaScorecardRevisionRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_QA_SCORECARD_REVISION)))
        .addMethod(
            getListQaScorecardRevisionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListQaScorecardRevisionsResponse>(
                    service, METHODID_LIST_QA_SCORECARD_REVISIONS)))
        .addMethod(
            getCreateFeedbackLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.CreateFeedbackLabelRequest,
                    com.google.cloud.contactcenterinsights.v1.FeedbackLabel>(
                    service, METHODID_CREATE_FEEDBACK_LABEL)))
        .addMethod(
            getListFeedbackLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListFeedbackLabelsResponse>(
                    service, METHODID_LIST_FEEDBACK_LABELS)))
        .addMethod(
            getGetFeedbackLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.GetFeedbackLabelRequest,
                    com.google.cloud.contactcenterinsights.v1.FeedbackLabel>(
                    service, METHODID_GET_FEEDBACK_LABEL)))
        .addMethod(
            getUpdateFeedbackLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.UpdateFeedbackLabelRequest,
                    com.google.cloud.contactcenterinsights.v1.FeedbackLabel>(
                    service, METHODID_UPDATE_FEEDBACK_LABEL)))
        .addMethod(
            getDeleteFeedbackLabelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.DeleteFeedbackLabelRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_FEEDBACK_LABEL)))
        .addMethod(
            getListAllFeedbackLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsRequest,
                    com.google.cloud.contactcenterinsights.v1.ListAllFeedbackLabelsResponse>(
                    service, METHODID_LIST_ALL_FEEDBACK_LABELS)))
        .addMethod(
            getBulkUploadFeedbackLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.BulkUploadFeedbackLabelsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BULK_UPLOAD_FEEDBACK_LABELS)))
        .addMethod(
            getBulkDownloadFeedbackLabelsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.contactcenterinsights.v1.BulkDownloadFeedbackLabelsRequest,
                    com.google.longrunning.Operation>(
                    service, METHODID_BULK_DOWNLOAD_FEEDBACK_LABELS)))
        .build();
  }

  private abstract static class ContactCenterInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ContactCenterInsightsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ContactCenterInsights");
    }
  }

  private static final class ContactCenterInsightsFileDescriptorSupplier
      extends ContactCenterInsightsBaseDescriptorSupplier {
    ContactCenterInsightsFileDescriptorSupplier() {}
  }

  private static final class ContactCenterInsightsMethodDescriptorSupplier
      extends ContactCenterInsightsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ContactCenterInsightsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ContactCenterInsightsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ContactCenterInsightsFileDescriptorSupplier())
                      .addMethod(getCreateConversationMethod())
                      .addMethod(getUploadConversationMethod())
                      .addMethod(getUpdateConversationMethod())
                      .addMethod(getGetConversationMethod())
                      .addMethod(getListConversationsMethod())
                      .addMethod(getDeleteConversationMethod())
                      .addMethod(getCreateAnalysisMethod())
                      .addMethod(getGetAnalysisMethod())
                      .addMethod(getListAnalysesMethod())
                      .addMethod(getDeleteAnalysisMethod())
                      .addMethod(getBulkAnalyzeConversationsMethod())
                      .addMethod(getBulkDeleteConversationsMethod())
                      .addMethod(getIngestConversationsMethod())
                      .addMethod(getExportInsightsDataMethod())
                      .addMethod(getCreateIssueModelMethod())
                      .addMethod(getUpdateIssueModelMethod())
                      .addMethod(getGetIssueModelMethod())
                      .addMethod(getListIssueModelsMethod())
                      .addMethod(getDeleteIssueModelMethod())
                      .addMethod(getDeployIssueModelMethod())
                      .addMethod(getUndeployIssueModelMethod())
                      .addMethod(getExportIssueModelMethod())
                      .addMethod(getImportIssueModelMethod())
                      .addMethod(getGetIssueMethod())
                      .addMethod(getListIssuesMethod())
                      .addMethod(getUpdateIssueMethod())
                      .addMethod(getDeleteIssueMethod())
                      .addMethod(getCalculateIssueModelStatsMethod())
                      .addMethod(getCreatePhraseMatcherMethod())
                      .addMethod(getGetPhraseMatcherMethod())
                      .addMethod(getListPhraseMatchersMethod())
                      .addMethod(getDeletePhraseMatcherMethod())
                      .addMethod(getUpdatePhraseMatcherMethod())
                      .addMethod(getCalculateStatsMethod())
                      .addMethod(getGetSettingsMethod())
                      .addMethod(getUpdateSettingsMethod())
                      .addMethod(getCreateAnalysisRuleMethod())
                      .addMethod(getGetAnalysisRuleMethod())
                      .addMethod(getListAnalysisRulesMethod())
                      .addMethod(getUpdateAnalysisRuleMethod())
                      .addMethod(getDeleteAnalysisRuleMethod())
                      .addMethod(getGetEncryptionSpecMethod())
                      .addMethod(getInitializeEncryptionSpecMethod())
                      .addMethod(getCreateViewMethod())
                      .addMethod(getGetViewMethod())
                      .addMethod(getListViewsMethod())
                      .addMethod(getUpdateViewMethod())
                      .addMethod(getDeleteViewMethod())
                      .addMethod(getQueryMetricsMethod())
                      .addMethod(getCreateQaQuestionMethod())
                      .addMethod(getGetQaQuestionMethod())
                      .addMethod(getUpdateQaQuestionMethod())
                      .addMethod(getDeleteQaQuestionMethod())
                      .addMethod(getListQaQuestionsMethod())
                      .addMethod(getCreateQaScorecardMethod())
                      .addMethod(getGetQaScorecardMethod())
                      .addMethod(getUpdateQaScorecardMethod())
                      .addMethod(getDeleteQaScorecardMethod())
                      .addMethod(getListQaScorecardsMethod())
                      .addMethod(getCreateQaScorecardRevisionMethod())
                      .addMethod(getGetQaScorecardRevisionMethod())
                      .addMethod(getTuneQaScorecardRevisionMethod())
                      .addMethod(getDeployQaScorecardRevisionMethod())
                      .addMethod(getUndeployQaScorecardRevisionMethod())
                      .addMethod(getDeleteQaScorecardRevisionMethod())
                      .addMethod(getListQaScorecardRevisionsMethod())
                      .addMethod(getCreateFeedbackLabelMethod())
                      .addMethod(getListFeedbackLabelsMethod())
                      .addMethod(getGetFeedbackLabelMethod())
                      .addMethod(getUpdateFeedbackLabelMethod())
                      .addMethod(getDeleteFeedbackLabelMethod())
                      .addMethod(getListAllFeedbackLabelsMethod())
                      .addMethod(getBulkUploadFeedbackLabelsMethod())
                      .addMethod(getBulkDownloadFeedbackLabelsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
