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
package com.google.apps.meet.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * REST API for services dealing with conference records.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/apps/meet/v2/service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConferenceRecordsServiceGrpc {

  private ConferenceRecordsServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.apps.meet.v2.ConferenceRecordsService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetConferenceRecordRequest,
          com.google.apps.meet.v2.ConferenceRecord>
      getGetConferenceRecordMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetConferenceRecord",
      requestType = com.google.apps.meet.v2.GetConferenceRecordRequest.class,
      responseType = com.google.apps.meet.v2.ConferenceRecord.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetConferenceRecordRequest,
          com.google.apps.meet.v2.ConferenceRecord>
      getGetConferenceRecordMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetConferenceRecordRequest,
            com.google.apps.meet.v2.ConferenceRecord>
        getGetConferenceRecordMethod;
    if ((getGetConferenceRecordMethod = ConferenceRecordsServiceGrpc.getGetConferenceRecordMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetConferenceRecordMethod =
                ConferenceRecordsServiceGrpc.getGetConferenceRecordMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetConferenceRecordMethod =
              getGetConferenceRecordMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetConferenceRecordRequest,
                          com.google.apps.meet.v2.ConferenceRecord>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetConferenceRecord"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetConferenceRecordRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ConferenceRecord.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "GetConferenceRecord"))
                      .build();
        }
      }
    }
    return getGetConferenceRecordMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListConferenceRecordsRequest,
          com.google.apps.meet.v2.ListConferenceRecordsResponse>
      getListConferenceRecordsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListConferenceRecords",
      requestType = com.google.apps.meet.v2.ListConferenceRecordsRequest.class,
      responseType = com.google.apps.meet.v2.ListConferenceRecordsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListConferenceRecordsRequest,
          com.google.apps.meet.v2.ListConferenceRecordsResponse>
      getListConferenceRecordsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListConferenceRecordsRequest,
            com.google.apps.meet.v2.ListConferenceRecordsResponse>
        getListConferenceRecordsMethod;
    if ((getListConferenceRecordsMethod =
            ConferenceRecordsServiceGrpc.getListConferenceRecordsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListConferenceRecordsMethod =
                ConferenceRecordsServiceGrpc.getListConferenceRecordsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListConferenceRecordsMethod =
              getListConferenceRecordsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListConferenceRecordsRequest,
                          com.google.apps.meet.v2.ListConferenceRecordsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListConferenceRecords"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListConferenceRecordsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListConferenceRecordsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "ListConferenceRecords"))
                      .build();
        }
      }
    }
    return getListConferenceRecordsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetParticipantRequest, com.google.apps.meet.v2.Participant>
      getGetParticipantMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParticipant",
      requestType = com.google.apps.meet.v2.GetParticipantRequest.class,
      responseType = com.google.apps.meet.v2.Participant.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetParticipantRequest, com.google.apps.meet.v2.Participant>
      getGetParticipantMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetParticipantRequest, com.google.apps.meet.v2.Participant>
        getGetParticipantMethod;
    if ((getGetParticipantMethod = ConferenceRecordsServiceGrpc.getGetParticipantMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetParticipantMethod = ConferenceRecordsServiceGrpc.getGetParticipantMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetParticipantMethod =
              getGetParticipantMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetParticipantRequest,
                          com.google.apps.meet.v2.Participant>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetParticipant"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetParticipantRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.Participant.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetParticipant"))
                      .build();
        }
      }
    }
    return getGetParticipantMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListParticipantsRequest,
          com.google.apps.meet.v2.ListParticipantsResponse>
      getListParticipantsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParticipants",
      requestType = com.google.apps.meet.v2.ListParticipantsRequest.class,
      responseType = com.google.apps.meet.v2.ListParticipantsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListParticipantsRequest,
          com.google.apps.meet.v2.ListParticipantsResponse>
      getListParticipantsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListParticipantsRequest,
            com.google.apps.meet.v2.ListParticipantsResponse>
        getListParticipantsMethod;
    if ((getListParticipantsMethod = ConferenceRecordsServiceGrpc.getListParticipantsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListParticipantsMethod = ConferenceRecordsServiceGrpc.getListParticipantsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListParticipantsMethod =
              getListParticipantsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListParticipantsRequest,
                          com.google.apps.meet.v2.ListParticipantsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListParticipants"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListParticipantsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListParticipantsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("ListParticipants"))
                      .build();
        }
      }
    }
    return getListParticipantsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetParticipantSessionRequest,
          com.google.apps.meet.v2.ParticipantSession>
      getGetParticipantSessionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetParticipantSession",
      requestType = com.google.apps.meet.v2.GetParticipantSessionRequest.class,
      responseType = com.google.apps.meet.v2.ParticipantSession.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetParticipantSessionRequest,
          com.google.apps.meet.v2.ParticipantSession>
      getGetParticipantSessionMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetParticipantSessionRequest,
            com.google.apps.meet.v2.ParticipantSession>
        getGetParticipantSessionMethod;
    if ((getGetParticipantSessionMethod =
            ConferenceRecordsServiceGrpc.getGetParticipantSessionMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetParticipantSessionMethod =
                ConferenceRecordsServiceGrpc.getGetParticipantSessionMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetParticipantSessionMethod =
              getGetParticipantSessionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetParticipantSessionRequest,
                          com.google.apps.meet.v2.ParticipantSession>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetParticipantSession"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetParticipantSessionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ParticipantSession.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "GetParticipantSession"))
                      .build();
        }
      }
    }
    return getGetParticipantSessionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListParticipantSessionsRequest,
          com.google.apps.meet.v2.ListParticipantSessionsResponse>
      getListParticipantSessionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListParticipantSessions",
      requestType = com.google.apps.meet.v2.ListParticipantSessionsRequest.class,
      responseType = com.google.apps.meet.v2.ListParticipantSessionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListParticipantSessionsRequest,
          com.google.apps.meet.v2.ListParticipantSessionsResponse>
      getListParticipantSessionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListParticipantSessionsRequest,
            com.google.apps.meet.v2.ListParticipantSessionsResponse>
        getListParticipantSessionsMethod;
    if ((getListParticipantSessionsMethod =
            ConferenceRecordsServiceGrpc.getListParticipantSessionsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListParticipantSessionsMethod =
                ConferenceRecordsServiceGrpc.getListParticipantSessionsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListParticipantSessionsMethod =
              getListParticipantSessionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListParticipantSessionsRequest,
                          com.google.apps.meet.v2.ListParticipantSessionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListParticipantSessions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListParticipantSessionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListParticipantSessionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "ListParticipantSessions"))
                      .build();
        }
      }
    }
    return getListParticipantSessionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetRecordingRequest, com.google.apps.meet.v2.Recording>
      getGetRecordingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRecording",
      requestType = com.google.apps.meet.v2.GetRecordingRequest.class,
      responseType = com.google.apps.meet.v2.Recording.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetRecordingRequest, com.google.apps.meet.v2.Recording>
      getGetRecordingMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetRecordingRequest, com.google.apps.meet.v2.Recording>
        getGetRecordingMethod;
    if ((getGetRecordingMethod = ConferenceRecordsServiceGrpc.getGetRecordingMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetRecordingMethod = ConferenceRecordsServiceGrpc.getGetRecordingMethod) == null) {
          ConferenceRecordsServiceGrpc.getGetRecordingMethod =
              getGetRecordingMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetRecordingRequest,
                          com.google.apps.meet.v2.Recording>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRecording"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetRecordingRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.Recording.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetRecording"))
                      .build();
        }
      }
    }
    return getGetRecordingMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListRecordingsRequest,
          com.google.apps.meet.v2.ListRecordingsResponse>
      getListRecordingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListRecordings",
      requestType = com.google.apps.meet.v2.ListRecordingsRequest.class,
      responseType = com.google.apps.meet.v2.ListRecordingsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListRecordingsRequest,
          com.google.apps.meet.v2.ListRecordingsResponse>
      getListRecordingsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListRecordingsRequest,
            com.google.apps.meet.v2.ListRecordingsResponse>
        getListRecordingsMethod;
    if ((getListRecordingsMethod = ConferenceRecordsServiceGrpc.getListRecordingsMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListRecordingsMethod = ConferenceRecordsServiceGrpc.getListRecordingsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListRecordingsMethod =
              getListRecordingsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListRecordingsRequest,
                          com.google.apps.meet.v2.ListRecordingsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListRecordings"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListRecordingsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListRecordingsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("ListRecordings"))
                      .build();
        }
      }
    }
    return getListRecordingsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetTranscriptRequest, com.google.apps.meet.v2.Transcript>
      getGetTranscriptMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTranscript",
      requestType = com.google.apps.meet.v2.GetTranscriptRequest.class,
      responseType = com.google.apps.meet.v2.Transcript.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetTranscriptRequest, com.google.apps.meet.v2.Transcript>
      getGetTranscriptMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetTranscriptRequest, com.google.apps.meet.v2.Transcript>
        getGetTranscriptMethod;
    if ((getGetTranscriptMethod = ConferenceRecordsServiceGrpc.getGetTranscriptMethod) == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetTranscriptMethod = ConferenceRecordsServiceGrpc.getGetTranscriptMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetTranscriptMethod =
              getGetTranscriptMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetTranscriptRequest,
                          com.google.apps.meet.v2.Transcript>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTranscript"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetTranscriptRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.Transcript.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("GetTranscript"))
                      .build();
        }
      }
    }
    return getGetTranscriptMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListTranscriptsRequest,
          com.google.apps.meet.v2.ListTranscriptsResponse>
      getListTranscriptsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTranscripts",
      requestType = com.google.apps.meet.v2.ListTranscriptsRequest.class,
      responseType = com.google.apps.meet.v2.ListTranscriptsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListTranscriptsRequest,
          com.google.apps.meet.v2.ListTranscriptsResponse>
      getListTranscriptsMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListTranscriptsRequest,
            com.google.apps.meet.v2.ListTranscriptsResponse>
        getListTranscriptsMethod;
    if ((getListTranscriptsMethod = ConferenceRecordsServiceGrpc.getListTranscriptsMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListTranscriptsMethod = ConferenceRecordsServiceGrpc.getListTranscriptsMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListTranscriptsMethod =
              getListTranscriptsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListTranscriptsRequest,
                          com.google.apps.meet.v2.ListTranscriptsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListTranscripts"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListTranscriptsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListTranscriptsResponse.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier("ListTranscripts"))
                      .build();
        }
      }
    }
    return getListTranscriptsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetTranscriptEntryRequest,
          com.google.apps.meet.v2.TranscriptEntry>
      getGetTranscriptEntryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTranscriptEntry",
      requestType = com.google.apps.meet.v2.GetTranscriptEntryRequest.class,
      responseType = com.google.apps.meet.v2.TranscriptEntry.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.GetTranscriptEntryRequest,
          com.google.apps.meet.v2.TranscriptEntry>
      getGetTranscriptEntryMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.GetTranscriptEntryRequest,
            com.google.apps.meet.v2.TranscriptEntry>
        getGetTranscriptEntryMethod;
    if ((getGetTranscriptEntryMethod = ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getGetTranscriptEntryMethod = ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getGetTranscriptEntryMethod =
              getGetTranscriptEntryMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.GetTranscriptEntryRequest,
                          com.google.apps.meet.v2.TranscriptEntry>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTranscriptEntry"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.GetTranscriptEntryRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.TranscriptEntry.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "GetTranscriptEntry"))
                      .build();
        }
      }
    }
    return getGetTranscriptEntryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListTranscriptEntriesRequest,
          com.google.apps.meet.v2.ListTranscriptEntriesResponse>
      getListTranscriptEntriesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListTranscriptEntries",
      requestType = com.google.apps.meet.v2.ListTranscriptEntriesRequest.class,
      responseType = com.google.apps.meet.v2.ListTranscriptEntriesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.apps.meet.v2.ListTranscriptEntriesRequest,
          com.google.apps.meet.v2.ListTranscriptEntriesResponse>
      getListTranscriptEntriesMethod() {
    io.grpc.MethodDescriptor<
            com.google.apps.meet.v2.ListTranscriptEntriesRequest,
            com.google.apps.meet.v2.ListTranscriptEntriesResponse>
        getListTranscriptEntriesMethod;
    if ((getListTranscriptEntriesMethod =
            ConferenceRecordsServiceGrpc.getListTranscriptEntriesMethod)
        == null) {
      synchronized (ConferenceRecordsServiceGrpc.class) {
        if ((getListTranscriptEntriesMethod =
                ConferenceRecordsServiceGrpc.getListTranscriptEntriesMethod)
            == null) {
          ConferenceRecordsServiceGrpc.getListTranscriptEntriesMethod =
              getListTranscriptEntriesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.apps.meet.v2.ListTranscriptEntriesRequest,
                          com.google.apps.meet.v2.ListTranscriptEntriesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListTranscriptEntries"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListTranscriptEntriesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.apps.meet.v2.ListTranscriptEntriesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ConferenceRecordsServiceMethodDescriptorSupplier(
                              "ListTranscriptEntries"))
                      .build();
        }
      }
    }
    return getListTranscriptEntriesMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ConferenceRecordsServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceStub>() {
          @java.lang.Override
          public ConferenceRecordsServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConferenceRecordsServiceStub(channel, callOptions);
          }
        };
    return ConferenceRecordsServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConferenceRecordsServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceBlockingStub>() {
          @java.lang.Override
          public ConferenceRecordsServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConferenceRecordsServiceBlockingStub(channel, callOptions);
          }
        };
    return ConferenceRecordsServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ConferenceRecordsServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ConferenceRecordsServiceFutureStub>() {
          @java.lang.Override
          public ConferenceRecordsServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ConferenceRecordsServiceFutureStub(channel, callOptions);
          }
        };
    return ConferenceRecordsServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * REST API for services dealing with conference records.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Gets a conference record by conference ID.
     * </pre>
     */
    default void getConferenceRecord(
        com.google.apps.meet.v2.GetConferenceRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ConferenceRecord> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetConferenceRecordMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the conference records. By default, ordered by start time and in
     * descending order.
     * </pre>
     */
    default void listConferenceRecords(
        com.google.apps.meet.v2.ListConferenceRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListConferenceRecordsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListConferenceRecordsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant by participant ID.
     * </pre>
     */
    default void getParticipant(
        com.google.apps.meet.v2.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Participant> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParticipantMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the participants in a conference record. By default, ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    default void listParticipants(
        com.google.apps.meet.v2.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParticipantsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant session by participant session ID.
     * </pre>
     */
    default void getParticipantSession(
        com.google.apps.meet.v2.GetParticipantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ParticipantSession> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetParticipantSessionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the participant sessions of a participant in a conference record. By
     * default, ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    default void listParticipantSessions(
        com.google.apps.meet.v2.ListParticipantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantSessionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListParticipantSessionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a recording by recording ID.
     * </pre>
     */
    default void getRecording(
        com.google.apps.meet.v2.GetRecordingRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Recording> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetRecordingMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the recording resources from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    default void listRecordings(
        com.google.apps.meet.v2.ListRecordingsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListRecordingsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListRecordingsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a transcript by transcript ID.
     * </pre>
     */
    default void getTranscript(
        com.google.apps.meet.v2.GetTranscriptRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Transcript> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTranscriptMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the set of transcripts from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    default void listTranscripts(
        com.google.apps.meet.v2.ListTranscriptsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTranscriptsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    default void getTranscriptEntry(
        com.google.apps.meet.v2.GetTranscriptEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.TranscriptEntry> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetTranscriptEntryMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    default void listTranscriptEntries(
        com.google.apps.meet.v2.ListTranscriptEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptEntriesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListTranscriptEntriesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConferenceRecordsService.
   *
   * <pre>
   * REST API for services dealing with conference records.
   * </pre>
   */
  public abstract static class ConferenceRecordsServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ConferenceRecordsServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConferenceRecordsService.
   *
   * <pre>
   * REST API for services dealing with conference records.
   * </pre>
   */
  public static final class ConferenceRecordsServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ConferenceRecordsServiceStub> {
    private ConferenceRecordsServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConferenceRecordsServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConferenceRecordsServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a conference record by conference ID.
     * </pre>
     */
    public void getConferenceRecord(
        com.google.apps.meet.v2.GetConferenceRecordRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ConferenceRecord> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetConferenceRecordMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the conference records. By default, ordered by start time and in
     * descending order.
     * </pre>
     */
    public void listConferenceRecords(
        com.google.apps.meet.v2.ListConferenceRecordsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListConferenceRecordsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListConferenceRecordsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant by participant ID.
     * </pre>
     */
    public void getParticipant(
        com.google.apps.meet.v2.GetParticipantRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Participant> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the participants in a conference record. By default, ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public void listParticipants(
        com.google.apps.meet.v2.ListParticipantsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantsResponse>
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
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public void getParticipantSession(
        com.google.apps.meet.v2.GetParticipantSessionRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ParticipantSession> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetParticipantSessionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the participant sessions of a participant in a conference record. By
     * default, ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public void listParticipantSessions(
        com.google.apps.meet.v2.ListParticipantSessionsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantSessionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListParticipantSessionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a recording by recording ID.
     * </pre>
     */
    public void getRecording(
        com.google.apps.meet.v2.GetRecordingRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Recording> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRecordingMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the recording resources from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public void listRecordings(
        com.google.apps.meet.v2.ListRecordingsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListRecordingsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListRecordingsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public void getTranscript(
        com.google.apps.meet.v2.GetTranscriptRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Transcript> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTranscriptMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the set of transcripts from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public void listTranscripts(
        com.google.apps.meet.v2.ListTranscriptsRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTranscriptsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public void getTranscriptEntry(
        com.google.apps.meet.v2.GetTranscriptEntryRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.TranscriptEntry> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTranscriptEntryMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public void listTranscriptEntries(
        com.google.apps.meet.v2.ListTranscriptEntriesRequest request,
        io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptEntriesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListTranscriptEntriesMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConferenceRecordsService.
   *
   * <pre>
   * REST API for services dealing with conference records.
   * </pre>
   */
  public static final class ConferenceRecordsServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConferenceRecordsServiceBlockingStub> {
    private ConferenceRecordsServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConferenceRecordsServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConferenceRecordsServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a conference record by conference ID.
     * </pre>
     */
    public com.google.apps.meet.v2.ConferenceRecord getConferenceRecord(
        com.google.apps.meet.v2.GetConferenceRecordRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetConferenceRecordMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the conference records. By default, ordered by start time and in
     * descending order.
     * </pre>
     */
    public com.google.apps.meet.v2.ListConferenceRecordsResponse listConferenceRecords(
        com.google.apps.meet.v2.ListConferenceRecordsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListConferenceRecordsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant by participant ID.
     * </pre>
     */
    public com.google.apps.meet.v2.Participant getParticipant(
        com.google.apps.meet.v2.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParticipantMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the participants in a conference record. By default, ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public com.google.apps.meet.v2.ListParticipantsResponse listParticipants(
        com.google.apps.meet.v2.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParticipantsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public com.google.apps.meet.v2.ParticipantSession getParticipantSession(
        com.google.apps.meet.v2.GetParticipantSessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetParticipantSessionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the participant sessions of a participant in a conference record. By
     * default, ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public com.google.apps.meet.v2.ListParticipantSessionsResponse listParticipantSessions(
        com.google.apps.meet.v2.ListParticipantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListParticipantSessionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a recording by recording ID.
     * </pre>
     */
    public com.google.apps.meet.v2.Recording getRecording(
        com.google.apps.meet.v2.GetRecordingRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRecordingMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the recording resources from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public com.google.apps.meet.v2.ListRecordingsResponse listRecordings(
        com.google.apps.meet.v2.ListRecordingsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListRecordingsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public com.google.apps.meet.v2.Transcript getTranscript(
        com.google.apps.meet.v2.GetTranscriptRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTranscriptMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the set of transcripts from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public com.google.apps.meet.v2.ListTranscriptsResponse listTranscripts(
        com.google.apps.meet.v2.ListTranscriptsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTranscriptsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.apps.meet.v2.TranscriptEntry getTranscriptEntry(
        com.google.apps.meet.v2.GetTranscriptEntryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTranscriptEntryMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.apps.meet.v2.ListTranscriptEntriesResponse listTranscriptEntries(
        com.google.apps.meet.v2.ListTranscriptEntriesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListTranscriptEntriesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * ConferenceRecordsService.
   *
   * <pre>
   * REST API for services dealing with conference records.
   * </pre>
   */
  public static final class ConferenceRecordsServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConferenceRecordsServiceFutureStub> {
    private ConferenceRecordsServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConferenceRecordsServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConferenceRecordsServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Gets a conference record by conference ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ConferenceRecord>
        getConferenceRecord(com.google.apps.meet.v2.GetConferenceRecordRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetConferenceRecordMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the conference records. By default, ordered by start time and in
     * descending order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListConferenceRecordsResponse>
        listConferenceRecords(com.google.apps.meet.v2.ListConferenceRecordsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListConferenceRecordsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant by participant ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2.Participant>
        getParticipant(com.google.apps.meet.v2.GetParticipantRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParticipantMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the participants in a conference record. By default, ordered by join
     * time and in descending order. This API supports `fields` as standard
     * parameters like every other API. However, when the `fields` request
     * parameter is omitted, this API defaults to `'participants/&#42;,
     * next_page_token'`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListParticipantsResponse>
        listParticipants(com.google.apps.meet.v2.ListParticipantsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParticipantsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a participant session by participant session ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ParticipantSession>
        getParticipantSession(com.google.apps.meet.v2.GetParticipantSessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetParticipantSessionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the participant sessions of a participant in a conference record. By
     * default, ordered by join time and in descending order. This API supports
     * `fields` as standard parameters like every other API. However, when the
     * `fields` request parameter is omitted this API defaults to
     * `'participantsessions/&#42;, next_page_token'`.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListParticipantSessionsResponse>
        listParticipantSessions(com.google.apps.meet.v2.ListParticipantSessionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListParticipantSessionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a recording by recording ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2.Recording>
        getRecording(com.google.apps.meet.v2.GetRecordingRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRecordingMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the recording resources from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListRecordingsResponse>
        listRecordings(com.google.apps.meet.v2.ListRecordingsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListRecordingsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a transcript by transcript ID.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.apps.meet.v2.Transcript>
        getTranscript(com.google.apps.meet.v2.GetTranscriptRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTranscriptMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the set of transcripts from the conference record. By default,
     * ordered by start time and in ascending order.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListTranscriptsResponse>
        listTranscripts(com.google.apps.meet.v2.ListTranscriptsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTranscriptsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a `TranscriptEntry` resource by entry ID.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.TranscriptEntry>
        getTranscriptEntry(com.google.apps.meet.v2.GetTranscriptEntryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTranscriptEntryMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists the structured transcript entries per transcript. By default, ordered
     * by start time and in ascending order.
     * Note: The transcript entries returned by the Google Meet API might not
     * match the transcription found in the Google Docs transcript file. This can
     * occur when the Google Docs transcript file is modified after generation.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.apps.meet.v2.ListTranscriptEntriesResponse>
        listTranscriptEntries(com.google.apps.meet.v2.ListTranscriptEntriesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListTranscriptEntriesMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CONFERENCE_RECORD = 0;
  private static final int METHODID_LIST_CONFERENCE_RECORDS = 1;
  private static final int METHODID_GET_PARTICIPANT = 2;
  private static final int METHODID_LIST_PARTICIPANTS = 3;
  private static final int METHODID_GET_PARTICIPANT_SESSION = 4;
  private static final int METHODID_LIST_PARTICIPANT_SESSIONS = 5;
  private static final int METHODID_GET_RECORDING = 6;
  private static final int METHODID_LIST_RECORDINGS = 7;
  private static final int METHODID_GET_TRANSCRIPT = 8;
  private static final int METHODID_LIST_TRANSCRIPTS = 9;
  private static final int METHODID_GET_TRANSCRIPT_ENTRY = 10;
  private static final int METHODID_LIST_TRANSCRIPT_ENTRIES = 11;

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
        case METHODID_GET_CONFERENCE_RECORD:
          serviceImpl.getConferenceRecord(
              (com.google.apps.meet.v2.GetConferenceRecordRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ConferenceRecord>)
                  responseObserver);
          break;
        case METHODID_LIST_CONFERENCE_RECORDS:
          serviceImpl.listConferenceRecords(
              (com.google.apps.meet.v2.ListConferenceRecordsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListConferenceRecordsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARTICIPANT:
          serviceImpl.getParticipant(
              (com.google.apps.meet.v2.GetParticipantRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Participant>) responseObserver);
          break;
        case METHODID_LIST_PARTICIPANTS:
          serviceImpl.listParticipants(
              (com.google.apps.meet.v2.ListParticipantsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_PARTICIPANT_SESSION:
          serviceImpl.getParticipantSession(
              (com.google.apps.meet.v2.GetParticipantSessionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ParticipantSession>)
                  responseObserver);
          break;
        case METHODID_LIST_PARTICIPANT_SESSIONS:
          serviceImpl.listParticipantSessions(
              (com.google.apps.meet.v2.ListParticipantSessionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListParticipantSessionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_RECORDING:
          serviceImpl.getRecording(
              (com.google.apps.meet.v2.GetRecordingRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Recording>) responseObserver);
          break;
        case METHODID_LIST_RECORDINGS:
          serviceImpl.listRecordings(
              (com.google.apps.meet.v2.ListRecordingsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListRecordingsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSCRIPT:
          serviceImpl.getTranscript(
              (com.google.apps.meet.v2.GetTranscriptRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.Transcript>) responseObserver);
          break;
        case METHODID_LIST_TRANSCRIPTS:
          serviceImpl.listTranscripts(
              (com.google.apps.meet.v2.ListTranscriptsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_TRANSCRIPT_ENTRY:
          serviceImpl.getTranscriptEntry(
              (com.google.apps.meet.v2.GetTranscriptEntryRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.TranscriptEntry>)
                  responseObserver);
          break;
        case METHODID_LIST_TRANSCRIPT_ENTRIES:
          serviceImpl.listTranscriptEntries(
              (com.google.apps.meet.v2.ListTranscriptEntriesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.apps.meet.v2.ListTranscriptEntriesResponse>)
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
            getGetConferenceRecordMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetConferenceRecordRequest,
                    com.google.apps.meet.v2.ConferenceRecord>(
                    service, METHODID_GET_CONFERENCE_RECORD)))
        .addMethod(
            getListConferenceRecordsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListConferenceRecordsRequest,
                    com.google.apps.meet.v2.ListConferenceRecordsResponse>(
                    service, METHODID_LIST_CONFERENCE_RECORDS)))
        .addMethod(
            getGetParticipantMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetParticipantRequest,
                    com.google.apps.meet.v2.Participant>(service, METHODID_GET_PARTICIPANT)))
        .addMethod(
            getListParticipantsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListParticipantsRequest,
                    com.google.apps.meet.v2.ListParticipantsResponse>(
                    service, METHODID_LIST_PARTICIPANTS)))
        .addMethod(
            getGetParticipantSessionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetParticipantSessionRequest,
                    com.google.apps.meet.v2.ParticipantSession>(
                    service, METHODID_GET_PARTICIPANT_SESSION)))
        .addMethod(
            getListParticipantSessionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListParticipantSessionsRequest,
                    com.google.apps.meet.v2.ListParticipantSessionsResponse>(
                    service, METHODID_LIST_PARTICIPANT_SESSIONS)))
        .addMethod(
            getGetRecordingMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetRecordingRequest, com.google.apps.meet.v2.Recording>(
                    service, METHODID_GET_RECORDING)))
        .addMethod(
            getListRecordingsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListRecordingsRequest,
                    com.google.apps.meet.v2.ListRecordingsResponse>(
                    service, METHODID_LIST_RECORDINGS)))
        .addMethod(
            getGetTranscriptMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetTranscriptRequest,
                    com.google.apps.meet.v2.Transcript>(service, METHODID_GET_TRANSCRIPT)))
        .addMethod(
            getListTranscriptsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListTranscriptsRequest,
                    com.google.apps.meet.v2.ListTranscriptsResponse>(
                    service, METHODID_LIST_TRANSCRIPTS)))
        .addMethod(
            getGetTranscriptEntryMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.GetTranscriptEntryRequest,
                    com.google.apps.meet.v2.TranscriptEntry>(
                    service, METHODID_GET_TRANSCRIPT_ENTRY)))
        .addMethod(
            getListTranscriptEntriesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.apps.meet.v2.ListTranscriptEntriesRequest,
                    com.google.apps.meet.v2.ListTranscriptEntriesResponse>(
                    service, METHODID_LIST_TRANSCRIPT_ENTRIES)))
        .build();
  }

  private abstract static class ConferenceRecordsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConferenceRecordsServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.apps.meet.v2.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConferenceRecordsService");
    }
  }

  private static final class ConferenceRecordsServiceFileDescriptorSupplier
      extends ConferenceRecordsServiceBaseDescriptorSupplier {
    ConferenceRecordsServiceFileDescriptorSupplier() {}
  }

  private static final class ConferenceRecordsServiceMethodDescriptorSupplier
      extends ConferenceRecordsServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ConferenceRecordsServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ConferenceRecordsServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ConferenceRecordsServiceFileDescriptorSupplier())
                      .addMethod(getGetConferenceRecordMethod())
                      .addMethod(getListConferenceRecordsMethod())
                      .addMethod(getGetParticipantMethod())
                      .addMethod(getListParticipantsMethod())
                      .addMethod(getGetParticipantSessionMethod())
                      .addMethod(getListParticipantSessionsMethod())
                      .addMethod(getGetRecordingMethod())
                      .addMethod(getListRecordingsMethod())
                      .addMethod(getGetTranscriptMethod())
                      .addMethod(getListTranscriptsMethod())
                      .addMethod(getGetTranscriptEntryMethod())
                      .addMethod(getListTranscriptEntriesMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
