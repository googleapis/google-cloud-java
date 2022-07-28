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
package com.google.cloud.dialogflow.v2beta1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing [Participants][google.cloud.dialogflow.v2beta1.Participant].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2beta1/participant.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ParticipantsGrpc {

  private ParticipantsGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.dialogflow.v2beta1.Participants";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getCreateParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateParticipant",
      requestType = com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Participant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getCreateParticipantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest,
            com.google.cloud.dialogflow.v2beta1.Participant>
        getCreateParticipantMethod;
    if ((getCreateParticipantMethod = ParticipantsGrpc.getCreateParticipantMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getCreateParticipantMethod = ParticipantsGrpc.getCreateParticipantMethod) == null) {
          ParticipantsGrpc.getCreateParticipantMethod =
              getCreateParticipantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest,
                          com.google.cloud.dialogflow.v2beta1.Participant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateParticipant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Participant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("CreateParticipant"))
                      .build();
        }
      }
    }
    return getCreateParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getGetParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParticipant",
      requestType = com.google.cloud.dialogflow.v2beta1.GetParticipantRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Participant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.GetParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getGetParticipantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.GetParticipantRequest,
            com.google.cloud.dialogflow.v2beta1.Participant>
        getGetParticipantMethod;
    if ((getGetParticipantMethod = ParticipantsGrpc.getGetParticipantMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getGetParticipantMethod = ParticipantsGrpc.getGetParticipantMethod) == null) {
          ParticipantsGrpc.getGetParticipantMethod =
              getGetParticipantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.GetParticipantRequest,
                          com.google.cloud.dialogflow.v2beta1.Participant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetParticipant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.GetParticipantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Participant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("GetParticipant"))
                      .build();
        }
      }
    }
    return getGetParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest,
          com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
      getListParticipantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParticipants",
      requestType = com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest,
          com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
      getListParticipantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest,
            com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
        getListParticipantsMethod;
    if ((getListParticipantsMethod = ParticipantsGrpc.getListParticipantsMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getListParticipantsMethod = ParticipantsGrpc.getListParticipantsMethod) == null) {
          ParticipantsGrpc.getListParticipantsMethod =
              getListParticipantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListParticipants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("ListParticipants"))
                      .build();
        }
      }
    }
    return getListParticipantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getUpdateParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateParticipant",
      requestType = com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.Participant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest,
          com.google.cloud.dialogflow.v2beta1.Participant>
      getUpdateParticipantMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest,
            com.google.cloud.dialogflow.v2beta1.Participant>
        getUpdateParticipantMethod;
    if ((getUpdateParticipantMethod = ParticipantsGrpc.getUpdateParticipantMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getUpdateParticipantMethod = ParticipantsGrpc.getUpdateParticipantMethod) == null) {
          ParticipantsGrpc.getUpdateParticipantMethod =
              getUpdateParticipantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest,
                          com.google.cloud.dialogflow.v2beta1.Participant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateParticipant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.Participant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("UpdateParticipant"))
                      .build();
        }
      }
    }
    return getUpdateParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest,
          com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
      getAnalyzeContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AnalyzeContent",
      requestType = com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest,
          com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
      getAnalyzeContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest,
            com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
        getAnalyzeContentMethod;
    if ((getAnalyzeContentMethod = ParticipantsGrpc.getAnalyzeContentMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getAnalyzeContentMethod = ParticipantsGrpc.getAnalyzeContentMethod) == null) {
          ParticipantsGrpc.getAnalyzeContentMethod =
              getAnalyzeContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest,
                          com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AnalyzeContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("AnalyzeContent"))
                      .build();
        }
      }
    }
    return getAnalyzeContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest,
          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
      getStreamingAnalyzeContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamingAnalyzeContent",
      requestType = com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest,
          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
      getStreamingAnalyzeContentMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest,
            com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
        getStreamingAnalyzeContentMethod;
    if ((getStreamingAnalyzeContentMethod = ParticipantsGrpc.getStreamingAnalyzeContentMethod)
        == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getStreamingAnalyzeContentMethod = ParticipantsGrpc.getStreamingAnalyzeContentMethod)
            == null) {
          ParticipantsGrpc.getStreamingAnalyzeContentMethod =
              getStreamingAnalyzeContentMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest,
                          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "StreamingAnalyzeContent"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("StreamingAnalyzeContent"))
                      .build();
        }
      }
    }
    return getStreamingAnalyzeContentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
      getSuggestArticlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestArticles",
      requestType = com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
      getSuggestArticlesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest,
            com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
        getSuggestArticlesMethod;
    if ((getSuggestArticlesMethod = ParticipantsGrpc.getSuggestArticlesMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getSuggestArticlesMethod = ParticipantsGrpc.getSuggestArticlesMethod) == null) {
          ParticipantsGrpc.getSuggestArticlesMethod =
              getSuggestArticlesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest,
                          com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuggestArticles"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("SuggestArticles"))
                      .build();
        }
      }
    }
    return getSuggestArticlesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
      getSuggestFaqAnswersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestFaqAnswers",
      requestType = com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
      getSuggestFaqAnswersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest,
            com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
        getSuggestFaqAnswersMethod;
    if ((getSuggestFaqAnswersMethod = ParticipantsGrpc.getSuggestFaqAnswersMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getSuggestFaqAnswersMethod = ParticipantsGrpc.getSuggestFaqAnswersMethod) == null) {
          ParticipantsGrpc.getSuggestFaqAnswersMethod =
              getSuggestFaqAnswersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest,
                          com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SuggestFaqAnswers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("SuggestFaqAnswers"))
                      .build();
        }
      }
    }
    return getSuggestFaqAnswersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
      getSuggestSmartRepliesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SuggestSmartReplies",
      requestType = com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest,
          com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
      getSuggestSmartRepliesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest,
            com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
        getSuggestSmartRepliesMethod;
    if ((getSuggestSmartRepliesMethod = ParticipantsGrpc.getSuggestSmartRepliesMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getSuggestSmartRepliesMethod = ParticipantsGrpc.getSuggestSmartRepliesMethod)
            == null) {
          ParticipantsGrpc.getSuggestSmartRepliesMethod =
              getSuggestSmartRepliesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest,
                          com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "SuggestSmartReplies"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("SuggestSmartReplies"))
                      .build();
        }
      }
    }
    return getSuggestSmartRepliesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest,
          com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
      getListSuggestionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSuggestions",
      requestType = com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest,
          com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
      getListSuggestionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest,
            com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
        getListSuggestionsMethod;
    if ((getListSuggestionsMethod = ParticipantsGrpc.getListSuggestionsMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getListSuggestionsMethod = ParticipantsGrpc.getListSuggestionsMethod) == null) {
          ParticipantsGrpc.getListSuggestionsMethod =
              getListSuggestionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest,
                          com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSuggestions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("ListSuggestions"))
                      .build();
        }
      }
    }
    return getListSuggestionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest,
          com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
      getCompileSuggestionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CompileSuggestion",
      requestType = com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest.class,
      responseType = com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest,
          com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
      getCompileSuggestionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest,
            com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
        getCompileSuggestionMethod;
    if ((getCompileSuggestionMethod = ParticipantsGrpc.getCompileSuggestionMethod) == null) {
      synchronized (ParticipantsGrpc.class) {
        if ((getCompileSuggestionMethod = ParticipantsGrpc.getCompileSuggestionMethod) == null) {
          ParticipantsGrpc.getCompileSuggestionMethod =
              getCompileSuggestionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest,
                          com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CompileSuggestion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ParticipantsMethodDescriptorSupplier("CompileSuggestion"))
                      .build();
        }
      }
    }
    return getCompileSuggestionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ParticipantsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParticipantsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParticipantsStub>() {
          @java.lang.Override
          public ParticipantsStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParticipantsStub(channel, callOptions);
          }
        };
    return ParticipantsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ParticipantsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParticipantsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParticipantsBlockingStub>() {
          @java.lang.Override
          public ParticipantsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParticipantsBlockingStub(channel, callOptions);
          }
        };
    return ParticipantsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ParticipantsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ParticipantsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ParticipantsFutureStub>() {
          @java.lang.Override
          public ParticipantsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ParticipantsFutureStub(channel, callOptions);
          }
        };
    return ParticipantsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Participants][google.cloud.dialogflow.v2beta1.Participant].
   * </pre>
   */
  public abstract static class ParticipantsImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a new participant in a conversation.
     * </pre>
     */
    public void createParticipant(
        com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateParticipantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a conversation participant.
     * </pre>
     */
    public void getParticipant(
        com.google.cloud.dialogflow.v2beta1.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParticipantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all participants in the specified conversation.
     * </pre>
     */
    public void listParticipants(
        com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParticipantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified participant.
     * </pre>
     */
    public void updateParticipant(
        com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateParticipantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (chat, for example), or audio (phone recording, for example)
     * message from a participant into the conversation.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public void analyzeContent(
        com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getAnalyzeContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (e.g., chat) or audio (e.g., phone recording) message from a
     * participant into the conversation.
     * Note: This method is only available through the gRPC API (not REST).
     * The top-level message sent to the client by the server is
     * `StreamingAnalyzeContentResponse`. Multiple response messages can be
     * returned in order. The first one or more messages contain the
     * `recognition_result` field. Each result represents a more complete
     * transcript of what the user said. The next message contains the
     * `reply_text` field, and potentially the `reply_audio` and/or the
     * `automated_agent_reply` fields.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest>
        streamingAnalyzeContent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
                responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(
          getStreamingAnalyzeContentMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested articles for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    public void suggestArticles(
        com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuggestArticlesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested faq answers for a participant based on specific historical
     * messages.
     * </pre>
     */
    public void suggestFaqAnswers(
        com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuggestFaqAnswersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets smart replies for a participant based on specific historical
     * messages.
     * </pre>
     */
    public void suggestSmartReplies(
        com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getSuggestSmartRepliesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use inline suggestion, event based suggestion or
     * Suggestion* API instead.
     * See [HumanAgentAssistantConfig.name][google.cloud.dialogflow.v2beta1.HumanAgentAssistantConfig.name] for more
     * details.
     * Removal Date: 2020-09-01.
     * Retrieves suggestions for live agents.
     * This method should be used by human agent client software to fetch auto
     * generated suggestions in real-time, while the conversation with an end user
     * is in progress. The functionality is implemented in terms of the
     * [list
     * pagination](https://cloud.google.com/apis/design/design_patterns#list_pagination)
     * design pattern. The client app should use the `next_page_token` field
     * to fetch the next batch of suggestions. `suggestions` are sorted by
     * `create_time` in descending order.
     * To fetch latest suggestion, just set `page_size` to 1.
     * To fetch new suggestions without duplication, send request with filter
     * `create_time_epoch_microseconds &gt; [first item's create_time of previous
     * request]` and empty page_token.
     * </pre>
     */
    @java.lang.Deprecated
    public void listSuggestions(
        com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListSuggestionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated. use [SuggestArticles][google.cloud.dialogflow.v2beta1.Participants.SuggestArticles] and [SuggestFaqAnswers][google.cloud.dialogflow.v2beta1.Participants.SuggestFaqAnswers] instead.
     * Gets suggestions for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    @java.lang.Deprecated
    public void compileSuggestion(
        com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCompileSuggestionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateParticipantMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest,
                      com.google.cloud.dialogflow.v2beta1.Participant>(
                      this, METHODID_CREATE_PARTICIPANT)))
          .addMethod(
              getGetParticipantMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.GetParticipantRequest,
                      com.google.cloud.dialogflow.v2beta1.Participant>(
                      this, METHODID_GET_PARTICIPANT)))
          .addMethod(
              getListParticipantsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>(
                      this, METHODID_LIST_PARTICIPANTS)))
          .addMethod(
              getUpdateParticipantMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest,
                      com.google.cloud.dialogflow.v2beta1.Participant>(
                      this, METHODID_UPDATE_PARTICIPANT)))
          .addMethod(
              getAnalyzeContentMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest,
                      com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>(
                      this, METHODID_ANALYZE_CONTENT)))
          .addMethod(
              getStreamingAnalyzeContentMethod(),
              io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest,
                      com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>(
                      this, METHODID_STREAMING_ANALYZE_CONTENT)))
          .addMethod(
              getSuggestArticlesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest,
                      com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>(
                      this, METHODID_SUGGEST_ARTICLES)))
          .addMethod(
              getSuggestFaqAnswersMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest,
                      com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>(
                      this, METHODID_SUGGEST_FAQ_ANSWERS)))
          .addMethod(
              getSuggestSmartRepliesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest,
                      com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>(
                      this, METHODID_SUGGEST_SMART_REPLIES)))
          .addMethod(
              getListSuggestionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest,
                      com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>(
                      this, METHODID_LIST_SUGGESTIONS)))
          .addMethod(
              getCompileSuggestionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest,
                      com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>(
                      this, METHODID_COMPILE_SUGGESTION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Participants][google.cloud.dialogflow.v2beta1.Participant].
   * </pre>
   */
  public static final class ParticipantsStub
      extends io.grpc.stub.AbstractAsyncStub<ParticipantsStub> {
    private ParticipantsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParticipantsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParticipantsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new participant in a conversation.
     * </pre>
     */
    public void createParticipant(
        com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateParticipantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a conversation participant.
     * </pre>
     */
    public void getParticipant(
        com.google.cloud.dialogflow.v2beta1.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all participants in the specified conversation.
     * </pre>
     */
    public void listParticipants(
        com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListParticipantsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified participant.
     * </pre>
     */
    public void updateParticipant(
        com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateParticipantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (chat, for example), or audio (phone recording, for example)
     * message from a participant into the conversation.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public void analyzeContent(
        com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAnalyzeContentMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (e.g., chat) or audio (e.g., phone recording) message from a
     * participant into the conversation.
     * Note: This method is only available through the gRPC API (not REST).
     * The top-level message sent to the client by the server is
     * `StreamingAnalyzeContentResponse`. Multiple response messages can be
     * returned in order. The first one or more messages contain the
     * `recognition_result` field. Each result represents a more complete
     * transcript of what the user said. The next message contains the
     * `reply_text` field, and potentially the `reply_audio` and/or the
     * `automated_agent_reply` fields.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public io.grpc.stub.StreamObserver<
            com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentRequest>
        streamingAnalyzeContent(
            io.grpc.stub.StreamObserver<
                    com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>
                responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getStreamingAnalyzeContentMethod(), getCallOptions()),
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested articles for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    public void suggestArticles(
        com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuggestArticlesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested faq answers for a participant based on specific historical
     * messages.
     * </pre>
     */
    public void suggestFaqAnswers(
        com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuggestFaqAnswersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets smart replies for a participant based on specific historical
     * messages.
     * </pre>
     */
    public void suggestSmartReplies(
        com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSuggestSmartRepliesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use inline suggestion, event based suggestion or
     * Suggestion* API instead.
     * See [HumanAgentAssistantConfig.name][google.cloud.dialogflow.v2beta1.HumanAgentAssistantConfig.name] for more
     * details.
     * Removal Date: 2020-09-01.
     * Retrieves suggestions for live agents.
     * This method should be used by human agent client software to fetch auto
     * generated suggestions in real-time, while the conversation with an end user
     * is in progress. The functionality is implemented in terms of the
     * [list
     * pagination](https://cloud.google.com/apis/design/design_patterns#list_pagination)
     * design pattern. The client app should use the `next_page_token` field
     * to fetch the next batch of suggestions. `suggestions` are sorted by
     * `create_time` in descending order.
     * To fetch latest suggestion, just set `page_size` to 1.
     * To fetch new suggestions without duplication, send request with filter
     * `create_time_epoch_microseconds &gt; [first item's create_time of previous
     * request]` and empty page_token.
     * </pre>
     */
    @java.lang.Deprecated
    public void listSuggestions(
        com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSuggestionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deprecated. use [SuggestArticles][google.cloud.dialogflow.v2beta1.Participants.SuggestArticles] and [SuggestFaqAnswers][google.cloud.dialogflow.v2beta1.Participants.SuggestFaqAnswers] instead.
     * Gets suggestions for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    @java.lang.Deprecated
    public void compileSuggestion(
        com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCompileSuggestionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Participants][google.cloud.dialogflow.v2beta1.Participant].
   * </pre>
   */
  public static final class ParticipantsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ParticipantsBlockingStub> {
    private ParticipantsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParticipantsBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParticipantsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new participant in a conversation.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Participant createParticipant(
        com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateParticipantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a conversation participant.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Participant getParticipant(
        com.google.cloud.dialogflow.v2beta1.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParticipantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all participants in the specified conversation.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse listParticipants(
        com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParticipantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified participant.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.Participant updateParticipant(
        com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateParticipantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (chat, for example), or audio (phone recording, for example)
     * message from a participant into the conversation.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse analyzeContent(
        com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAnalyzeContentMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested articles for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse suggestArticles(
        com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuggestArticlesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested faq answers for a participant based on specific historical
     * messages.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse suggestFaqAnswers(
        com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuggestFaqAnswersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets smart replies for a participant based on specific historical
     * messages.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse suggestSmartReplies(
        com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSuggestSmartRepliesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use inline suggestion, event based suggestion or
     * Suggestion* API instead.
     * See [HumanAgentAssistantConfig.name][google.cloud.dialogflow.v2beta1.HumanAgentAssistantConfig.name] for more
     * details.
     * Removal Date: 2020-09-01.
     * Retrieves suggestions for live agents.
     * This method should be used by human agent client software to fetch auto
     * generated suggestions in real-time, while the conversation with an end user
     * is in progress. The functionality is implemented in terms of the
     * [list
     * pagination](https://cloud.google.com/apis/design/design_patterns#list_pagination)
     * design pattern. The client app should use the `next_page_token` field
     * to fetch the next batch of suggestions. `suggestions` are sorted by
     * `create_time` in descending order.
     * To fetch latest suggestion, just set `page_size` to 1.
     * To fetch new suggestions without duplication, send request with filter
     * `create_time_epoch_microseconds &gt; [first item's create_time of previous
     * request]` and empty page_token.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse listSuggestions(
        com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSuggestionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated. use [SuggestArticles][google.cloud.dialogflow.v2beta1.Participants.SuggestArticles] and [SuggestFaqAnswers][google.cloud.dialogflow.v2beta1.Participants.SuggestFaqAnswers] instead.
     * Gets suggestions for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse compileSuggestion(
        com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCompileSuggestionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Participants][google.cloud.dialogflow.v2beta1.Participant].
   * </pre>
   */
  public static final class ParticipantsFutureStub
      extends io.grpc.stub.AbstractFutureStub<ParticipantsFutureStub> {
    private ParticipantsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ParticipantsFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ParticipantsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a new participant in a conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Participant>
        createParticipant(com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateParticipantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves a conversation participant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Participant>
        getParticipant(com.google.cloud.dialogflow.v2beta1.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all participants in the specified conversation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>
        listParticipants(com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParticipantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified participant.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.Participant>
        updateParticipant(com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateParticipantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Adds a text (chat, for example), or audio (phone recording, for example)
     * message from a participant into the conversation.
     * Note: Always use agent versions for production traffic
     * sent to virtual agents. See [Versions and
     * environments](https://cloud.google.com/dialogflow/es/docs/agents-versions).
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>
        analyzeContent(com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAnalyzeContentMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested articles for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>
        suggestArticles(com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuggestArticlesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets suggested faq answers for a participant based on specific historical
     * messages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>
        suggestFaqAnswers(com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuggestFaqAnswersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets smart replies for a participant based on specific historical
     * messages.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>
        suggestSmartReplies(
            com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSuggestSmartRepliesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated: Use inline suggestion, event based suggestion or
     * Suggestion* API instead.
     * See [HumanAgentAssistantConfig.name][google.cloud.dialogflow.v2beta1.HumanAgentAssistantConfig.name] for more
     * details.
     * Removal Date: 2020-09-01.
     * Retrieves suggestions for live agents.
     * This method should be used by human agent client software to fetch auto
     * generated suggestions in real-time, while the conversation with an end user
     * is in progress. The functionality is implemented in terms of the
     * [list
     * pagination](https://cloud.google.com/apis/design/design_patterns#list_pagination)
     * design pattern. The client app should use the `next_page_token` field
     * to fetch the next batch of suggestions. `suggestions` are sorted by
     * `create_time` in descending order.
     * To fetch latest suggestion, just set `page_size` to 1.
     * To fetch new suggestions without duplication, send request with filter
     * `create_time_epoch_microseconds &gt; [first item's create_time of previous
     * request]` and empty page_token.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>
        listSuggestions(com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSuggestionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deprecated. use [SuggestArticles][google.cloud.dialogflow.v2beta1.Participants.SuggestArticles] and [SuggestFaqAnswers][google.cloud.dialogflow.v2beta1.Participants.SuggestFaqAnswers] instead.
     * Gets suggestions for a participant based on specific historical
     * messages.
     * Note that [ListSuggestions][google.cloud.dialogflow.v2beta1.Participants.ListSuggestions] will only list the auto-generated
     * suggestions, while [CompileSuggestion][google.cloud.dialogflow.v2beta1.Participants.CompileSuggestion] will try to compile suggestion
     * based on the provided conversation context in the real time.
     * </pre>
     */
    @java.lang.Deprecated
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>
        compileSuggestion(com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCompileSuggestionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PARTICIPANT = 0;
  private static final int METHODID_GET_PARTICIPANT = 1;
  private static final int METHODID_LIST_PARTICIPANTS = 2;
  private static final int METHODID_UPDATE_PARTICIPANT = 3;
  private static final int METHODID_ANALYZE_CONTENT = 4;
  private static final int METHODID_SUGGEST_ARTICLES = 5;
  private static final int METHODID_SUGGEST_FAQ_ANSWERS = 6;
  private static final int METHODID_SUGGEST_SMART_REPLIES = 7;
  private static final int METHODID_LIST_SUGGESTIONS = 8;
  private static final int METHODID_COMPILE_SUGGESTION = 9;
  private static final int METHODID_STREAMING_ANALYZE_CONTENT = 10;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ParticipantsImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ParticipantsImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_PARTICIPANT:
          serviceImpl.createParticipant(
              (com.google.cloud.dialogflow.v2beta1.CreateParticipantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>)
                  responseObserver);
          break;
        case METHODID_GET_PARTICIPANT:
          serviceImpl.getParticipant(
              (com.google.cloud.dialogflow.v2beta1.GetParticipantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTICIPANTS:
          serviceImpl.listParticipants(
              (com.google.cloud.dialogflow.v2beta1.ListParticipantsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListParticipantsResponse>)
                  responseObserver);
          break;
        case METHODID_UPDATE_PARTICIPANT:
          serviceImpl.updateParticipant(
              (com.google.cloud.dialogflow.v2beta1.UpdateParticipantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2beta1.Participant>)
                  responseObserver);
          break;
        case METHODID_ANALYZE_CONTENT:
          serviceImpl.analyzeContent(
              (com.google.cloud.dialogflow.v2beta1.AnalyzeContentRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.AnalyzeContentResponse>)
                  responseObserver);
          break;
        case METHODID_SUGGEST_ARTICLES:
          serviceImpl.suggestArticles(
              (com.google.cloud.dialogflow.v2beta1.SuggestArticlesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.SuggestArticlesResponse>)
                  responseObserver);
          break;
        case METHODID_SUGGEST_FAQ_ANSWERS:
          serviceImpl.suggestFaqAnswers(
              (com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.SuggestFaqAnswersResponse>)
                  responseObserver);
          break;
        case METHODID_SUGGEST_SMART_REPLIES:
          serviceImpl.suggestSmartReplies(
              (com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.SuggestSmartRepliesResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_SUGGESTIONS:
          serviceImpl.listSuggestions(
              (com.google.cloud.dialogflow.v2beta1.ListSuggestionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.ListSuggestionsResponse>)
                  responseObserver);
          break;
        case METHODID_COMPILE_SUGGESTION:
          serviceImpl.compileSuggestion(
              (com.google.cloud.dialogflow.v2beta1.CompileSuggestionRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dialogflow.v2beta1.CompileSuggestionResponse>)
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
        case METHODID_STREAMING_ANALYZE_CONTENT:
          return (io.grpc.stub.StreamObserver<Req>)
              serviceImpl.streamingAnalyzeContent(
                  (io.grpc.stub.StreamObserver<
                          com.google.cloud.dialogflow.v2beta1.StreamingAnalyzeContentResponse>)
                      responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private abstract static class ParticipantsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ParticipantsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2beta1.ParticipantProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Participants");
    }
  }

  private static final class ParticipantsFileDescriptorSupplier
      extends ParticipantsBaseDescriptorSupplier {
    ParticipantsFileDescriptorSupplier() {}
  }

  private static final class ParticipantsMethodDescriptorSupplier
      extends ParticipantsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ParticipantsMethodDescriptorSupplier(String methodName) {
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
      synchronized (ParticipantsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ParticipantsFileDescriptorSupplier())
                      .addMethod(getCreateParticipantMethod())
                      .addMethod(getGetParticipantMethod())
                      .addMethod(getListParticipantsMethod())
                      .addMethod(getUpdateParticipantMethod())
                      .addMethod(getAnalyzeContentMethod())
                      .addMethod(getStreamingAnalyzeContentMethod())
                      .addMethod(getSuggestArticlesMethod())
                      .addMethod(getSuggestFaqAnswersMethod())
                      .addMethod(getSuggestSmartRepliesMethod())
                      .addMethod(getListSuggestionsMethod())
                      .addMethod(getCompileSuggestionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
